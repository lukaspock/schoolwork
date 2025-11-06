
import { Category } from "./Category.js";
import { CategoryList } from "./CategoryList.js";


export function CategoryDAO(baseurl)
{
    this.baseurl = baseurl;
}

CategoryDAO.prototype.prepareRequest = function(method, path){

    let url = new URL(this.baseurl + path);
    let xhr = new XMLHttpRequest();
    xhr.open(method,url);

    return xhr;
}

CategoryDAO.prototype.loadCategorys = function(callback){

    let xhr = this.prepareRequest("GET","");
    xhr.responseType = "json";
    xhr.send();
    xhr.onload = function(){
        console.log(xhr.response);
        let categoryList = [];

        for (let c of xhr.response) {
            categoryList.push(new Category(c.name, c.id, c.description));
        }
        callback(categoryList);
    }

    xhr.onerror = function(){
        console.log("ERROR - load Categorys");
    }
}

CategoryDAO.prototype.addCategory = function(callback, category) {
    let xhr = this.prepareRequest("POST", "");
    xhr.responseType = "json";
    xhr.setRequestHeader("Content-Type", "application/json");

    xhr.send(JSON.stringify(category));

    xhr.onload = function() {
        let temp = xhr.response;
        callback(new Category(temp.name,temp.id,temp.description));
    };

    xhr.onerror = function() {
        console.log("ERROR - addCategory");
    };
};

CategoryDAO.prototype.deleteCategory = function(callback,id){
    let xhr = this.prepareRequest("DELETE", id);
    xhr.responseType = "json";
    xhr.setRequestHeader("Content-Type", "application/json");
    
    xhr.send();
    
    xhr.onload = function(){
        console.log("Category deletet");
        callback();
    }

    xhr.onerror = function(){
        console.log("ERROR - deleteCategory");
    }

}