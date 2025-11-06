

export function ProductList(ProductDAO)
{
    this.ar = new Array();
    this.dao = ProductDAO;
}

ProductList.prototype.getNoe = function(){return this.ar.length};

ProductList.prototype.getByIndex = function(idx){ return this.ar[idx]};
ProductList.prototype.getLength = function(){ return this.ar.length};

ProductList.prototype.loadProducts = function(callback){

    this.dao.loadProducts((pl) => {
        this.ar = pl; 
        callback();
    } );
    
}

ProductList.prototype.addProduct = function(callback, product) {
    //this.ar.push(product);
    this.dao.addProduct((response) => {
        console.log("Cart successfully added:", response);
        this.ar.push(response);
        callback();
    }, product);
};


ProductList.prototype.removeProduct = function(callback,id,i){

    this.ar.splice(i,1);
    this.dao.deleteProduct((response)=>console.log(response),id);
    callback();
};

