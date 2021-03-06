<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%--<!DOCTYPE HTML>--%>
<html lang="ru">

<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css2?family=Archivo:wght@400;700&display=swap" rel="stylesheet" />

    <link rel="shortcut icon" href="${pageContext.request.contextPath}./images/logo.svg" type="image/x-icon" />


    <!-- Carousel -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/Glide.js/3.4.1/css/glide.core.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/Glide.js/3.4.1/css/glide.theme.min.css">
    <link rel="stylesheet" href="https://unpkg.com/aos@next/dist/aos.css">

    <link rel="stylesheet" href="${pageContext.request.contextPath}./css/styles.css">
    <title>Альтитуда</title>
</head>

<body>
<%--<style><%@include file="WEB-INF/resources/css/styles.css"%></style>--%>


<!-- Glide Carousel Script -->
<script src="js/glide.min.js"></script>
<!-- Animate On Scroll -->
<script src="js/aos.js"></script>
<script src="js/products.js.js"></script>
<script src="js/index.js.js"></script>
<script src="js/slider.js"></script>
<script src="js/main.js.js"></script>

<!-- Custom JavaScript -->









<!-- Header -->
<header id="header" class="header">
    <div class="navigation">
        <div class="container">
            <nav class="nav">
                <div class="nav__hamburger">
                    <svg>
                        <use xlink:href="WEB-INF/resources/images/sprite.svg#icon-menu"></use>
                    </svg>
                </div>

                <div class="nav__logo">
<%--                    <img src="//WEB-INF//resources//images//logo.svg" alt="logo">--%>
    <img src="${pageContext.request.contextPath}./images/logo.svg">
                    <a href="/" class="scroll-link">
                        Альтитуда
                    </a>
                </div>

                <div class="nav__menu">
                    <div class="menu__top">
                        <span class="nav__category">Альтитуда</span>
                        <a href="#" class="close__toggle">
                            <svg>
                                <use xlink:href="./images/sprite.svg#icon-cross"></use>
                            </svg>
                        </a>
                    </div>
                    <ul class="nav__list">
                        <li class="nav__item">
                            <a href="#header" class="nav__link scroll-link">Главная</a>
                        </li>
                        <li class="nav__item">
                            <a href="#collection" class="nav__link scroll-link">Категории</a>
                        </li>
                        <li class="nav__item">
                            <a href="#testimonial" class="nav__link scroll-link">Отзывы</a>
                        </li>
                        <li class="nav__item">
                            <a href="./aboutUs.html"class="nav__link">О нас</a>
                        </li>
                    </ul>
                </div>

                <div class="nav__icons">
                    <a href="./login.html" class="icon__item">
                        <svg class="icon__user">
                            <use xlink:href="./images/sprite.svg#icon-user"></use>
                        </svg>
                    </a>

                    <!-- <a href="#" class="icon__item">
                      <svg class="icon__search">
                        <use xlink:href="./images/sprite.svg#icon-search"></use>
                      </svg>
                    </a> -->

                    <a href="./cart.html" class="icon__item" id="cart__icon">
                        <svg class="icon__cart">
                            <use xlink:href="./images/sprite.svg#icon-shopping-basket"></use>
                        </svg>
                        <span id="cart__total">0</span>
                    </a>
                </div>
            </nav>
        </div>
    </div>

    <!-- Hero -->
    <div class="hero">
        <div class="glide" id="glide_1">
            <div class="glide__track" data-glide-el="track">
                <ul class="glide__slides">
                    <li class="glide__slide">
                        <div class="hero__center">
                            <div class="hero__left">
                                <span>Новые товары</span>
                                <h1>Лучшие цены в Одессе!</h1>
                                <p>Качественные товары для вашего будущего дома</p>
                                <a href="#category"><button class="hero__btn">Перейти</button></a>
                            </div>
                            <div class="hero__right">
                                <div class="hero__img-container">
                                    <img class="banner_01" src="./images/materials-removebg.png" alt="banner2" />
                                </div>
                            </div>
                        </div>
                    </li>
                    <li class="glide__slide">
                        <div class="hero__center">
                            <div class="hero__left">
                                <span>Новые товары</span>
                                <h1>Лучшие цены в Одессе!</h1>
                                <p>Качественные товары для вашего будущего дома</p>
                                <a href="#category"><button class="hero__btn">Перейти</button></a>
                            </div>
                            <div class="hero__right">
                                <img class="banner_02" src="./images/stroitelnie_materiali-removebg.png" alt="banner2" />
                            </div>
                        </div>
                    </li>
                </ul>
            </div>
            <div class="glide__bullets" data-glide-el="controls[nav]">
                <button class="glide__bullet" data-glide-dir="=0"></button>
                <button class="glide__bullet" data-glide-dir="=1"></button>
            </div>

            <div class="glide__arrows" data-glide-el="controls">
                <button class="glide__arrow glide__arrow--left" data-glide-dir="<">
                    <svg>
                        <use xlink:href="./images/sprite.svg#icon-arrow-left2"></use>
                    </svg>
                </button>
                <button class="glide__arrow glide__arrow--right" data-glide-dir=">">
                    <svg>
                        <use xlink:href="./images/sprite.svg#icon-arrow-right2"></use>
                    </svg>
                </button>
            </div>
        </div>
    </div>
</header>
<!-- End Header -->

<!-- Main -->
<main id="main">
    <div class="container">
        <!-- Collection -->
        <section id="collection" class="section collection">
            <h1 class="collection__title">Категории</h1>
            <div class="collection__wrap">
                <div class="category__wrap">
                    <img src="images/derevo.webp" alt="">
                    <span>Дерево</span>
                </div>
                <div class="category__wrap">
                    <img src="images/metal2.webp" alt="">
                    <span>Металл</span>
                </div>
                <div class="category__wrap">
                    <img src="images/krovlya.webp" alt="">
                    <span>Кровля</span>
                </div>
            </div>

            <section class="category__section section" id="category">
                <div class="tab__list">
                    <div class="title__container tabs">
                        <div class="section__titles category__titles ">
                            <div class="section__title filter-btn active" data-id="All Products">
                                <span class="dot"></span>
                                <h1 class="primary__title">Все товары</h1>
                            </div>
                        </div>
                        <div class="section__titles">
                            <div class="section__title filter-btn" data-id="Уголок">
                                <span class="dot"></span>
                                <h1 class="primary__title">Уголок</h1>
                            </div>
                        </div>

                        <div class="section__titles">
                            <div class="section__title filter-btn" data-id="Профильная труба">
                                <span class="dot"></span>
                                <h1 class="primary__title">Профильная труба</h1>
                            </div>
                        </div>

                        <div class="section__titles">
                            <div class="section__title filter-btn" data-id="Арматура">
                                <span class="dot"></span>
                                <h1 class="primary__title">Арматура</h1>
                            </div>
                        </div>

                    </div>

                    <div class="category__container" data-aos="fade-up" data-aos-duration="1200">
                        <div class="category__center">
                            <div class="product category__products">
                                <div class="product__header">
                                    <img src=${product.image} alt="product">
                                </div>
                                <div class="product__footer">
                                    <h3>${product.title}</h3>
                                    <div class="product__price">
                                        <h4>$${product.price}</h4>
                                    </div>
                                    <button type="submit" class="product__btn" id='product__${id}'>Добавить</button>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>
            </section>

            <!-- Facility Section -->
            <section class="facility__section section" id="facility">
                <div class="container">
                    <div class="facility__contianer" data-aos="fade-up" data-aos-duration="1200">
                        <div class="facility__box">
                            <div class="facility-img__container">
                                <svg>
                                    <use xlink:href="./images/sprite.svg#icon-airplane"></use>
                                </svg>
                            </div>
                            <p>бессплатная доставка по городу</p>
                        </div>

                        <div class="facility__box">
                            <div class="facility-img__container">
                                <svg>
                                    <use xlink:href="./images/sprite.svg#icon-credit-card-alt"></use>
                                </svg>
                            </div>
                            <p>100% гарантия возврата денег</p>
                        </div>

                        <div class="facility__box">
                            <div class="facility-img__container">
                                <svg>
                                    <use xlink:href="./images/sprite.svg#icon-credit-card"></use>
                                </svg>
                            </div>
                            <p>множественные способы оплаты</p>
                        </div>

                        <div class="facility__box">
                            <div class="facility-img__container">
                                <svg>
                                    <use xlink:href="./images/sprite.svg#icon-headphones"></use>
                                </svg>
                            </div>
                            <p>24/7 онлайн поддержка</p>
                        </div>
                    </div>
                </div>
            </section>
    </div>

    <!-- Testimonial Section -->
    <section class="section testimonial" id="testimonial">
        <div class="testimonial__container">
            <div class="glide" id="glide_4">
                <div class="glide__track" data-glide-el="track">
                    <ul class="glide__slides">
                        <li class="glide__slide">
                            <div class="testimonial__box">
                                <div class="client__image">
                                    <img src="./images/profile1.jpg" alt="profile">
                                </div>
                                <p>Lorem, ipsum dolor sit amet consectetur adipisicing elit. Recusandae fuga hic nesciunt tempore
                                    quibusdam consequatur eligendi unde officia ex quae.ipsum dolor sit amet consectetur adipisicing
                                    elit. Recusandae fuga hic nesciunt tempore
                                    quibusdam consequatur eligendi unde officia ex quae.</p>
                                <div class="client__info">
                                    <h3>Джон Смит</h3>
                                </div>
                            </div>
                        </li>
                        <li class="glide__slide">
                            <div class="testimonial__box">
                                <div class="client__image">
                                    <img src="./images/profile2.jpg" alt="profile">
                                </div>
                                <p>Lorem, ipsum dolor sit amet consectetur adipisicing elit. Recusandae fuga hic nesciunt tempore
                                    quibusdam consequatur
                                    eligendi unde officia ex quae.ipsum dolor sit amet consectetur adipisicing elit. Recusandae fuga hic
                                    nesciunt tempore
                                    quibusdam consequatur eligendi unde officia ex quae.adipisicing elit. Recusandae fuga hic
                                    nesciunt tempore
                                    quibusdam consequatur eligendi unde officia ex quae.</p>
                                <div class="client__info">
                                    <h3>Марина Кравец</h3>
                                </div>
                            </div>
                        </li>
                        <li class="glide__slide">
                            <div class="testimonial__box">
                                <div class="client__image">
                                    <img src="./images/profile3.jpg" alt="profile">
                                </div>
                                <p>Lorem, ipsum dolor sit amet consectetur adipisicing elit. Recusandae fuga hic nesciunt tempore
                                    quibusdam consequatur
                                    eligendi unde officia ex quae.ipsum dolor sit amet consectetur adipisicing elit. Recusandae fuga hic
                                    nesciunt tempore
                                    quibusdam consequatur eligendi unde officia ex quae.adipisicing elit. Recusandae fuga hic
                                    nesciunt tempore
                                    quibusdam consequatur eligendi unde officia ex quae.</p>
                                <div class="client__info">
                                    <h3>Валерий Дятлов</h3>
                                </div>
                            </div>

                        </li>
                        <li class="glide__slide">
                            <div class="testimonial__box">
                                <div class="client__image">
                                    <img src="./images/profile4.jpg" alt="">
                                </div>
                                <p>Lorem, ipsum dolor sit amet consectetur adipisicing elit. Recusandae fuga hic nesciunt tempore
                                    quibusdam consequatur
                                    eligendi unde officia ex quae.adipisicing elit. Recusandae fuga hic
                                    nesciunt tempore
                                    quibusdam consequatur eligendi unde officia ex quae.
                                    hic
                                    nesciunt tempore
                                    quibusdam consequatur eligendi unde officia ex quae.</p>
                                <div class="client__info">
                                    <h3>Владимир Акимов</h3>
                                </div>
                            </div>
                        </li>
                    </ul>
                </div>

                <div class="glide__bullets" data-glide-el="controls[nav]">
                    <button class="glide__bullet" data-glide-dir="=0"></button>
                    <button class="glide__bullet" data-glide-dir="=1"></button>
                    <button class="glide__bullet" data-glide-dir="=2"></button>
                    <button class="glide__bullet" data-glide-dir="=3"></button>
                </div>
            </div>
        </div>
    </section>
</main>

<!-- End Main -->

<!-- Footer -->
<footer id="footer" class="section footer">
    <div class="container">
        <div class="footer__top">

            <div class="footer-top__box">
                <h3>КОНТАКТЫ</h3>
                <div>
            <span>
              <svg>
                <use xlink:href="./images/sprite.svg#icon-location"></use>
              </svg>
            </span>
                    Княжеская 42, Украина
                </div>
                <div>
            <span>
              <svg>
                <use xlink:href="./images/sprite.svg#icon-envelop"></use>
              </svg>
            </span>
                    <a href="mailto:company@gmail.com">company@gmail.com</a>
                </div>
                <div>
            <span>
              <svg>
                <use xlink:href="./images/sprite.svg#icon-phone"></use>
              </svg>
            </span>
                    <a href="tel:+4564564512">456-456-4512</a>
                </div>
                <div>
            <span>
              <svg>
                <use xlink:href="./images/sprite.svg#icon-paperplane"></use>
              </svg>
            </span>
                    Одесса, Украина
                </div>
            </div>

            <div class="footer-top__box">
                <h3>О НАС</h3>
                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Illo praesentium, numquam non
                    provident rem sed minus natus unde vel modi!
                    Lorem ipsum dolor sit amet consectetur adipisicing elit. Illo praesentium, numquam non
                    provident rem sed minus natus unde vel modi!</p>
            </div>
        </div>
    </div>
    <!-- <div class="footer__bottom">
      <div class="footer-bottom__box">

      </div>
      <div class="footer-bottom__box">

      </div>
    </div> -->
    </div>
</footer>
<!-- End Footer -->

<!-- PopUp -->
<div class="popup hide__popup">
    <div class="popup__content">
        <div class="popup__close">
            <svg>
                <use xlink:href="./images/sprite.svg#icon-cross"></use>
            </svg>
        </div>
        <div class="cart__table table-responsive">
            <table width="100%" class="table">
                <thead>
                <tr>
                    <th>Товар</th>
                    <th>Название</th>
                    <th>Цена</th>
                    <th>Количество</th>
                    <th>Всего</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td class="product__thumbnail">
                        <a href="#">
                            <img src="./images/Fanara-1.webp" alt="">
                        </a>
                    </td>
                    <td class="product__name">
                        <a href="#">Фанера</a>
                        <br><br>
                        <small>1525х1250х4мм</small>
                    </td>
                    <td class="product__price">
                        <div class="price">
                            <span class="new__price">$250.99</span>
                        </div>
                    </td>
                    <td class="product__quantity">
                        <div class="input-counter">
                            <div>
                            <span class="minus-btn">
                                <svg>
                                    <use xlink:href="./images/sprite.svg#icon-minus"></use>
                                </svg>
                            </span>
                                <input type="text" min="1" value="1" max="10" class="counter-btn">
                                <span class="plus-btn">
                                <svg>
                                    <use xlink:href="./images/sprite.svg#icon-plus"></use>
                                </svg>
                            </span>
                            </div>
                        </div>
                    </td>
                    <td class="product__subtotal">
                        <div class="price">
                            <span class="new__price">$250.99</span>
                        </div>
                        <a href="#" class="remove__cart-item">
                            <svg>
                                <use xlink:href="./images/sprite.svg#icon-trash"></use>
                            </svg>
                        </a>
                    </td>
                </tr>
                <tr>
                    <td class="product__thumbnail">
                        <a href="#">
                            <img src="./images/armatura.webp" alt="">
                        </a>
                    </td>
                    <td class="product__name">
                        <a href="#">Aрматура</a>
                        <br><br>
                        <small>8мм</small>
                    </td>
                    <td class="product__price">
                        <div class="price">
                            <span class="new__price">34 грн</span>
                        </div>
                    </td>
                    <td class="product__quantity">
                        <div class="input-counter">
                            <div>
                            <span class="minus-btn">
                                <svg>
                                    <use xlink:href="./images/sprite.svg#icon-minus"></use>
                                </svg>
                            </span>
                                <input type="text" min="1" value="1" max="10" class="counter-btn">
                                <span class="plus-btn">
                                <svg>
                                    <use xlink:href="./images/sprite.svg#icon-plus"></use>
                                </svg>
                            </span>
                            </div>
                        </div>
                    </td>
                    <td class="product__subtotal">
                        <div class="price">
                            <span class="new__price">34 грн</span>
                        </div>
                        <a href="#" class="remove__cart-item">
                            <svg>
                                <use xlink:href="./images/sprite.svg#icon-trash"></use>
                            </svg>
                        </a>
                    </td>
                </tr>
                <tr>
                    <td class="product__thumbnail">
                        <a href="#">
                            <img src="./images/armatura3.jpeg" alt="">
                        </a>
                    </td>
                    <td class="product__name">
                        <a href="#">Арматура</a>
                        <br><br>
                        <small>12мм</small>
                    </td>
                    <td class="product__price">
                        <div class="price">
                            <span class="new__price">47 грн</span>
                        </div>
                    </td>
                    <td class="product__quantity">
                        <div class="input-counter">
                            <div>
                            <span class="minus-btn">
                                <svg>
                                    <use xlink:href="./images/sprite.svg#icon-minus"></use>
                                </svg>
                            </span>
                                <input type="text" min="1" value="1" max="10" class="counter-btn">
                                <span class="plus-btn">
                                <svg>
                                    <use xlink:href="./images/sprite.svg#icon-plus"></use>
                                </svg>
                            </span>
                            </div>
                        </div>
                    </td>
                    <td class="product__subtotal">
                        <div class="price">
                            <span class="new__price">47 грн</span>
                        </div>
                        <a href="#" class="remove__cart-item">
                            <svg>
                                <use xlink:href="./images/sprite.svg#icon-trash"></use>
                            </svg>
                        </a>
                    </td>
                </tr>
                <tr>
                    <td class="product__thumbnail">
                        <a href="#">
                            <img src="./images/osb.webp" alt="">
                        </a>
                    </td>
                    <td class="product__name">
                        <a href="#">ОСБ</a>
                        <br><br>
                        <small>2500х1250х10мм</small>
                    </td>
                    <td class="product__price">
                        <div class="price">
                            <span class="new__price">345 грн</span>
                        </div>
                    </td>
                    <td class="product__quantity">
                        <div class="input-counter">
                            <div>
                            <span class="minus-btn">
                                <svg>
                                    <use xlink:href="./images/sprite.svg#icon-minus"></use>
                                </svg>
                            </span>
                                <input type="text" min="1" value="1" max="10" class="counter-btn">
                                <span class="plus-btn">
                                <svg>
                                    <use xlink:href="./images/sprite.svg#icon-plus"></use>
                                </svg>
                            </span>
                            </div>
                        </div>
                    </td>
                    <td class="product__subtotal">
                        <div class="price">
                            <span class="new__price">345 грн</span>
                        </div>
                        <button href="#" class="remove__cart-item">
                            <svg>
                                <use xlink:href="./images/sprite.svg#icon-trash"></use>
                            </svg>
                        </button>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>



<!-- Go To -->
<a href="#header" class="goto-top scroll-link">
    <svg>
        <use xlink:href="./images/sprite.svg#icon-arrow-up"></use>
    </svg>
</a>

</body>

</html>