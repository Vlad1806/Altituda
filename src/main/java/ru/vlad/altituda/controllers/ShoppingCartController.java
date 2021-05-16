package ru.vlad.altituda.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.*;

@Controller
@RequestMapping("/shoppingCart")
public class ShoppingCartController {

    ProductDAO productDAO = new ProductDAO();
    OrdersDAO ordersDAO = new OrdersDAO();
    private List<Item> cart = new ArrayList<>();
    double total = 0;
    @GetMapping()
    public String index(HttpSession session){

        session.setAttribute("shoppingCart", cart);
        session.setAttribute("total", total);
        return "cart/shoppingCart";
    }

    @RequestMapping(value="/order", method=RequestMethod.POST)
    public String ordering(@RequestParam("date")String date,HttpSession session) throws JsonProcessingException {

        if (session.getAttribute("shoppingCart")==null){
            session.setAttribute("shoppingCart", cart);
            return "redirect:/shoppingCart";
        }
        if (date == "") return "/error/DateOrderError";
        Instant date1 = stringToDate(date);
        if (date1.isBefore(Instant.now().plusSeconds(84400))){
            return "/error/DateOrderError";
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
            String description = product.getDescription();
            description = addChar(description,'{',0);
            description = addChar(description,'}',description.length());
            JsonObject convertedObject = new Gson().fromJson(description, JsonObject.class);
            product.setDescription(convertedObject.toString());
            System.out.println(product);
            productDAO.update(product.getId(),product);
        }
        cart = null;
        session.setAttribute("shoppingCart", cart);
        return "redirect:/shoppingCart";
    }

    private Instant stringToDate(String date){
        Instant instant = null;
        try {
            Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(date);
            instant = date1.toInstant();
            instant = instant.plusSeconds(50400);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return instant;
    }

    private String addChar(String str, char ch, int position) {
        StringBuilder sb = new StringBuilder(str);
        sb.insert(position, ch);
        return sb.toString();
    }

    @GetMapping("/{id}")
    public String order(@PathVariable ("id") int id, HttpSession session){
        total = 0;
        if (session.getAttribute("shoppingCart")==null){
            cart = new ArrayList<>();
            cart.add(new Item(this.productDAO.show(id),1,this.productDAO.getProduct(id)));
            cart.get(0).getProduct().setDescription(description(cart.get(0).getProduct().getDescription()));
            total += cart.get(0).getProduct().getPrice();
            session.setAttribute("shoppingCart", cart);
        } else {
            cart = (List<Item>) session.getAttribute("shoppingCart");
            int index = isExisting(id,session);
            if (index == -1) {
                cart.add(new Item(this.productDAO.show(id), 1,this.productDAO.getProduct(id)));
            }else {
                int quantity = cart.get(index).getQuantity() + 1 ;
                cart.get(index).setQuantity(quantity);
//                total += cart.get(index).getProduct().getPrice();
            }
            for (int i = 0; i < cart.size(); i++) {
                total += cart.get(i).quantity * cart.get(i).getProduct().getPrice();
            }
//            cart.get(cart.size()+1).getProduct().setDescription(description(cart.get(cart.size()+1).getProduct().getDescription()));
            cart.forEach(x-> x.getProduct().setDescription(description(x.getProduct().getDescription())));
            session.setAttribute("shoppingCart", cart);
            session.setAttribute("total", total);
        }
        return "redirect:/home#collection";
    }

    private String description(String description){
        description = description.replaceAll("\\{","")
                .replaceAll("\\}","")
                .replaceAll("\"","");
        return description;
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable ("id") int id, HttpSession session){
        cart = (List<Item>) session.getAttribute("shoppingCart");
        int index = isExisting(id,session);
        total -= cart.get(index).quantity * cart.get(index).getProduct().getPrice();
        cart.remove(index);
        session.setAttribute("shoppingCart", cart);
        session.setAttribute("total",total);
        return "redirect:/shoppingCart";
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
}
