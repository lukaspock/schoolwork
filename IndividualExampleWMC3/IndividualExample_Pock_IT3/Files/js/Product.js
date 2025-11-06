"use strict";

import { Picture } from './Picture.js';
import { Category } from './Category.js';

function Product(id, name, price, sizes, category, description, picture) {
    this.id = id;
    this.name = name;
    this.price = price;
    this.sizes = sizes;
    this.category = category;
    this.description = description;
    this.picture = picture;
}

Product.prototype.getId = function () { return this.id; };
Product.prototype.getName = function () { return this.name; };
Product.prototype.getPrice = function () { return Number(this.price); };
Product.prototype.getSizes = function () { return this.sizes; };
Product.prototype.getCategory = function () { return this.category; };
Product.prototype.getDescription = function () { return this.description; };
Product.prototype.getPicture = function () { return this.picture; };

export { Product };
