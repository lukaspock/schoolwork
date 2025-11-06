import { Cart } from "./Cart.js";
import { Product } from "./Product.js";



export function CartDAO(baseurl)
{
    this.baseurl = baseurl;
}

CartDAO.prototype.prepareRequest = function(method, path){

    let url = new URL(this.baseurl + path);
    let xhr = new XMLHttpRequest();
    xhr.open(method,url);

    return xhr;
}

CartDAO.prototype.loadCartList = function(callback){
    let xhr = this.prepareRequest("GET", "");
    xhr.responseType = "json";
    xhr.send();

    xhr.onload = function(){
        console.log(xhr.response);
        let cartList = [];

        for (let c of xhr.response) {
            cartList.push(new Cart(c.id, c.name, c.items));
        }

        console.log(cartList);
        callback(cartList);
    }

    xhr.onerror = function(){
        console.log("ERROR - loadCartList");
    }
}


CartDAO.prototype.addCart = function(callback, cart) {
    let xhr = this.prepareRequest("POST", "");
    xhr.responseType = "json";
    xhr.setRequestHeader("Content-Type", "application/json");

    xhr.send(JSON.stringify(cart));

    xhr.onload = function() {
        let temp = xhr.response;
        callback(new Cart(temp.id, temp.name, temp.items));
    };

    xhr.onerror = function() {
        console.log("ERROR - addCart");
    };
};


CartDAO.prototype.deleteCart = function(callback,id){
    let xhr = this.prepareRequest("DELETE", id);
    xhr.responseType = "json";
    xhr.setRequestHeader("Content-Type", "application/json");
    
    xhr.send();
    
    xhr.onload = function(){

        console.log("Cart deletete");
        callback();
    }

    xhr.onerror = function(){
        console.log("ERROR - deleteCart");
    }

}

CartDAO.prototype.updateCartList = function(callback, cart) {
    let xhr = this.prepareRequest("PUT", cart.id);
    xhr.responseType = "json";
    xhr.setRequestHeader("Content-Type", "application/json");

    xhr.send(JSON.stringify(cart));

    xhr.onload = function() {
        console.log("Cart Updatet");
        callback();
    };

    xhr.onerror = function() {
        console.log("ERROR - updateCartList");
    };
};