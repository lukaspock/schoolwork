import { CategoryDAO } from "./CategoryDAO.js";

export function CategoryList(categoryDAO)
{
    this.ar = new Array();
    this.dao = categoryDAO;
}

CategoryList.prototype.getNoe = function(){return this.ar.length};

CategoryList.prototype.getByIndex = function(idx){ return this.ar[idx]};
CategoryList.prototype.getLength = function(){ return this.ar.length};

CategoryList.prototype.loadCategorys = function(callback){

    this.dao.loadCategorys((pl) => {
        this.ar = pl; 
        callback();
    } );
    
}

CategoryList.prototype.addCategory = function(callback, category) {
    //this.ar.push(category);
    this.dao.addCategory((response) => {
        console.log("Categgory successfully added:");
        this.ar.push(response);
        callback();
    }, category);
};

CategoryList.prototype.removeCategory = function(callback,id,i){
    
    this.ar.splice(i,1);
    this.dao.deleteCategory((response)=>console.log(response),id);
    callback();
};




