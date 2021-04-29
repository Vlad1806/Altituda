package ru.vlad.altituda.controllers;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.vlad.altituda.Model.Item;
import ru.vlad.altituda.Model.Orders;
import ru.vlad.altituda.Model.Product;
import ru.vlad.altituda.dao.OrdersDAO;
import ru.vlad.altituda.dao.ProductDAO;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/shoppingCart")
public class ShoppingCartController {

    ProductDAO productDAO = new ProductDAO();
    OrdersDAO ordersDAO = new OrdersDAO();
    private List<Item> cart = new ArrayList<>();

    @GetMapping()
    public String index(){
        return "cart/shoppingCart";
    }

    @RequestMapping(value="/order", method=RequestMethod.POST)
    public String ordering(@RequestParam("date")String date,HttpSession session){
        if (session.getAttribute("shoppingCart")==null){
            session.setAttribute("shoppingCart", cart);
            return "redirect:/shoppingCart";
        }
        for (int i = 0; i < cart.size(); i++) {
            Orders orders = new Orders();
            Product product;
            Item item;
            item = cart.get(i);
            product = item.getProduct();
            orders.setProduct(product.getId());
            orders.setQuantity(item.getQuantity());
            orders.setReceiving(date);
            orders.setTimeOrder(Timestamp.from(Instant.now()));
            ordersDAO.save(orders);
            int col = product.getQuantity() - item.getQuantity();
            if (col < 0){
                return "/error/QuantityError";
            }
            System.out.println(col);
            product.setQuantity(col);
            productDAO.update(product.getId(),product);
        }
        cart = null;
        session.setAttribute("shoppingCart", cart);
        return "redirect:/shoppingCart";
    }


    @GetMapping("/{id}")
    public String order(@PathVariable ("id") int id, HttpSession session){
        if (session.getAttribute("shoppingCart")==null){
            cart = new ArrayList<>();

            cart.add(new Item(this.productDAO.show(id),1));
            session.setAttribute("shoppingCart", cart);
        } else {
            cart = (List<Item>) session.getAttribute("shoppingCart");
            int index = isExisting(id,session);
            if (index == -1) {
                cart.add(new Item(this.productDAO.show(id), 1));
            }else {
                int quantity = cart.get(index).getQuantity() + 1 ;
                cart.get(index).setQuantity(quantity);
            }
            session.setAttribute("shoppingCart", cart);
        }
        return "redirect:/home";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable ("id") int id, HttpSession session){
        cart = (List<Item>) session.getAttribute("shoppingCart");
        int index = isExisting(id,session);
        cart.remove(index);
        session.setAttribute("shoppingCart", cart);
        return "cart/shoppingCart";
    }

    private int isExisting(int id, HttpSession session){
        cart = (List<Item>) session.getAttribute("shoppingCart");
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getProduct().getId() == id) {
                return i;
            }
        }
        return -1;
    }


    @GetMapping("/aboutUs")
    public String aboutUs(){
        return "/aboutUs";
    }

    @GetMapping("/home")
    public String home(){
        return "home/wood";
    }
    @GetMapping("/error/QuantityError")
        public String error(){
            return"/error/QuantityError";
        }
}
