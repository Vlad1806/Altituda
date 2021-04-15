let carts = document.querySelectorAll(".product__btn");
let products = [
  {
    name: "Grey Tshirt",
    tag: "greytshirt",
    price: 15,
    inCart: 0,
  },
  {
    name: "Grey Hoddie",
    tag: "greyhoddie",
    price: 20,
    inCart: 0,
  },
  {
    name: "Black Hoddie",
    tag: "blackhoddie",
    price: 25,
    inCart: 0,
  },
];
if (displayProductItems) {
  for (let i = 0; i < carts.length; i++) {
    carts[i].addEventListener("click", () => {
      cartNumbers();
    });
  }
}
// console.log(carts);

function onLoadCartNumbers() {
  let productNumbers = localStorage.getItem("cartNumbers");

  if (productNumbers) {
    document.querySelector(".icon__item span").textContent = productNumbers;
  }
}

function cartNumbers() {
  let productNumbers = localStorage.getItem("cartNumbers");

  productNumbers = parseInt(productNumbers);
  if (productNumbers) {
    localStorage.setItem("cartNumbers", productNumbers + 1);
    document.querySelector(".icon__item span").textContent = productNumbers + 1;
  } else {
    localStorage.setItem("cartNumbers", 1);
    document.querySelector(".icon__item span").textContent = 1;
  }
}
onLoadCartNumbers();
