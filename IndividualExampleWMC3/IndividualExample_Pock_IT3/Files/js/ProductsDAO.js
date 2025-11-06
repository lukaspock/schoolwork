import { Product } from "./Product.js";


export function ProductsDAO(baseurl)
{
    this.baseurl = baseurl;
}

ProductsDAO.prototype.prepareRequest = function(method, path){

    let url = new URL(this.baseurl + path);
    let xhr = new XMLHttpRequest();
    xhr.open(method,url);

    return xhr;
}

ProductsDAO.prototype.loadProducts = function(callback){

    let xhr = this.prepareRequest("GET","");
    xhr.responseType = "json";
    xhr.send();
    xhr.onload = function(){
        console.log(xhr.response);
        let productList = [];

        for (let p of xhr.response) {
            productList.push(new Product(p.id, p.name, p.price, p.sizes, p.category, p.description, p.picture));
        }
        callback(productList);
    }

    xhr.onerror = function(){
        console.log("ERROR - loadProducts");
    }
}


ProductsDAO.prototype.addProduct = function(callback, product) {
    let xhr = this.prepareRequest("POST", "");
    xhr.responseType = "json";
    xhr.setRequestHeader("Content-Type", "application/json");

    xhr.send(JSON.stringify(product));

    xhr.onload = function() {
        let p = xhr.response;
        callback(new Product(p.id, p.name, p.price, p.sizes, p.category, p.description, p.picture));
    };

    xhr.onerror = function() {
        console.log("ERROR - add Product");
    };
};

ProductsDAO.prototype.deleteProduct = function(callback,id){
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