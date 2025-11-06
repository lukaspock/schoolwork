

import {Product} from './Product.js';

export function CartItem(product,amount)
{
    this.product = product;
    this.amount = amount;
    
}

CartItem.prototype.getProduct = function(){return this.product;} 
CartItem.prototype.getAmount = function(){return this.amount;} 
CartItem.prototype.getName = function(){return this.product.getName();} 
CartItem.prototype.getPrice = function(){return Number(this.product.getPrice());} 
CartItem.prototype.getAmount = function(){return this.amount;} 
CartItem.prototype.setAmount = function(number){this.amount = number;} 
