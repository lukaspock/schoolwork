

import {CartItem} from './CartItem.js';

function Cart(id,name, items = new Array)
{
    this.id = id;
    this.name = name;
    this.items = items;
}

Cart.prototype.getItems = function(){return this.items;} 
Cart.prototype.getPrice = function(idx){return Number(this.items[idx].product.price)} 
Cart.prototype.getAmount = function(idx){return Number(this.items[idx].amount)}
Cart.prototype.getName = function(){return this.name;} 
Cart.prototype.getLength = function(){return this.items.length;} 
Cart.prototype.addItem = function(item){this.items.push(item);} 
Cart.prototype.getItem = function(idx){return this.items[idx];}
Cart.prototype.gegetDescriptiontId = function(idx){this.items.splice(idx,1)} 
Cart.prototype.removeItem = function(idx){this.items.splice(idx,1);} 



Cart.prototype.calculateTotal = function()
{
    let total = 0;
    
    for(let i=0; i < this.items.length; i++)
    {
        total += Number(this.items[i].product.price) * Number(this.items[i].amount);
    }
    

    return total;
} 

Cart.prototype.checkForMatch = function(){

    for(let i = 0; i < this.getLength(); i++)
    {
        for(let j = 1;  i + j < this.getLength(); j++)
        {
            if(this.items[i].product.id == this.items[i+j].product.id)
                {
                    let newAmount = Number(this.items[i].amount) + Number(this.items[i+j].amount);
                    this.items[i].amount = newAmount;
                    this.removeItem(i+j);
                }
        }
    }
}

export { Cart };