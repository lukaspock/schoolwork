

import { ViewHandlerHomescreen } from "./ViewhandlerHomescreen.js";
import { Cart } from "./Cart.js";
import { Category } from "./Category.js";
import { Picture } from "./Picture.js";
import { Product } from "./Product.js";
import { ViewhandlerProduct } from "./ViewhandlerProduct.js"
import {ViewhandlerCart} from "./ViewhandlerCart.js"
import { CartList } from "./CartList.js";
import { ViewhandlerOverview } from "./ViewhandlerOverview.js";
import { ProductList } from "./ProductList.js";
import { CategoryList } from "./CategoryList.js";

import { CartDAO } from "./CartDAO.js";
import { ProductsDAO } from "./ProductsDAO.js";
import { CategoryDAO } from "./CategoryDAO.js";
import { ViewHandlerADD } from "./ViewHandlerADD.js";

function start()
{   
    //DAOS
    let cartDAO = new CartDAO("http://localhost:3000/CartList/");
    let productsDAO = new ProductsDAO("http://localhost:3000/products/");
    let categoryDAO = new CategoryDAO("http://localhost:3000/categorys/")  

    // Empty CartList
    let cartList = new CartList(cartDAO);
    let productList = new ProductList(productsDAO);
    let categoryList = new CategoryList(categoryDAO);

    // Making The Viewhandlers
    let viewProduct = new ViewhandlerProduct(cartList,"outputProduct","description","price","amount","add", "HomescreenProduct","EditProduct");
    let viewOverview = new ViewhandlerOverview(cartList,"outputOverview","priceOverview","HomescreenOverview","nameOverview");
    
    let viewCart = new ViewhandlerCart(cartList, productList, categoryList, "Products", "outputCart", "TotalPrice", "cartName","HomescreenCart","add",viewProduct,viewOverview, "filterByName", "filterByCattegory");
    let viewAdd = new ViewHandlerADD(cartList,productList,categoryList,"nameP","priceP","categoryP","descriptionP","urlP","fileNameP","existingProductsOutput","existingCategorysOutput", "BackADD","createProduct","nameC","descriptionC","createCategory");
    let viewHomescreen = new ViewHandlerHomescreen(cartList,"name","create","outputCarts",viewCart,viewOverview, "AddProduct", viewAdd);
    

    viewAdd.bind();
    viewProduct.bind();
    viewOverview.bind();
    viewCart.bind();
    viewHomescreen.bind();

    viewHomescreen.init();
    viewCart.init();
    viewAdd.init();



    // Renders ONLY the available products for the Cart
        
}

start();
