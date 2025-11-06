

export function CartList(CartListDAO)
{
    this.ar = new Array();
    this.dao = CartListDAO;
}

CartList.prototype.getNoe = function(){return this.ar.length};

CartList.prototype.getByIndex = function(idx){ return this.ar[idx]};
CartList.prototype.getLength = function() {
    return this.ar.length;
};


CartList.prototype.loadCarts = function(callback){
    this.dao.loadCartList((cl) => {
        this.ar = cl; 
        callback();
    });
};


CartList.prototype.addCart = function(callback, cart) {
    //this.ar.push(cart);
    this.dao.addCart((response) => {
        console.log("Cart successfully added:", response);
        this.ar.push(response);
        callback();
    }, cart);
};

CartList.prototype.updateCart = function(callback, cart) {
    this.dao.updateCartList((response) => {
        console.log("Cart successfully added: ", response);
        callback();
    }, cart);
};

CartList.prototype.removeCart = function(callback,id){
    let i = this.findCartWithID(id)
    this.ar.splice(i,1);
    this.dao.deleteCart((response)=>console.log(response),id);
    callback();
};

CartList.prototype.findCartWithID = function(idx){
    for(let i = 0; i < 100; i++){
        if(this.ar[i].id == idx)
            return i;
    }
}

