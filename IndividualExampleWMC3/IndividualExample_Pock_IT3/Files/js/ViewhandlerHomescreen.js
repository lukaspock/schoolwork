import { Cart } from './Cart.js';
import { CartList } from './CartList.js';

export function ViewHandlerHomescreen(cl,inputId,cButtonID,outputID, viewCart, viewOverview, addPID, viewAdd)
{
    this.cartList = cl;
    this.input = document.getElementById(inputId);
    this.cButton = document.getElementById(cButtonID);
    this.output = document.getElementById(outputID);
    this.addProductButton = document.getElementById(addPID);

    this.viewCart = viewCart;
    this.viewOverview = viewOverview;
    this.viewADD = viewAdd;
}

ViewHandlerHomescreen.prototype.renderHomescreen = function()
{

    this.output.innerHTML = "";
    this.input.value = "";

    for(let i = 0; i < this.cartList.getLength(); i++)
    {
        let currentCart = this.cartList.getByIndex(i);

        let div = document.createElement('div');
        
        let name = document.createElement('h2');
        let viewButton = document.createElement('button');
        let editButton = document.createElement('button');
        let deleteButton = document.createElement('button');

        name.innerHTML = currentCart.getName();

        deleteButton.innerHTML = "Delete";
        deleteButton.onclick = this.removeCart.bind(this,this.cartList.getByIndex(i).id);

        editButton.innerHTML = "Edit";
        editButton.id = "edit" + i;
        viewButton.innerHTML = "View";
        editButton.addEventListener("click", () => {
            this.viewCart.renderProducts(this.cartList.getByIndex(i).id - 1);
        })
        viewButton.addEventListener("click", () => {
            this.viewOverview.renderProducts(i);
        })
        
        editButton.onclick = () => {toggleInvisible("Homescreen", "Cart");}
        viewButton.onclick = () => toggleInvisible("Homescreen", "Overview");
        this.addProductButton.onclick = () => toggleInvisible("Homescreen", "ADD");

        div.append(name);
        div.append(editButton);
        div.append(deleteButton);
        div.append(viewButton);
    
        this.output.append(div);
        
        
    }

    
}

ViewHandlerHomescreen.prototype.reloadCarts = function() {
    this.cartList.loadCarts(() => {
      this.renderHomescreen();
    });
}

ViewHandlerHomescreen.prototype.addNewCart = function () {
    let name = this.input.value;

    if (name === "") return;

    let cart = new Cart(this.cartList.getLength() + 1, name);

    this.cartList.addCart(() => {
        this.renderHomescreen();
    }, cart);
}

ViewHandlerHomescreen.prototype.removeCart = function (idx)
{
    this.cartList.removeCart(() => {this.renderHomescreen();},idx);
}


ViewHandlerHomescreen.prototype.bind = function()
{
    this.cButton.onclick = this.addNewCart.bind(this);
    this.addProductButton.onclick = () => this.viewADD.render.bind();
}

function toggleInvisible(id1,id2){
    let element1 = document.getElementById(id1);
    let element2 = document.getElementById(id2);
    element1.classList.toggle("invisible");
    element2.classList.toggle("invisible");
}

ViewHandlerHomescreen.prototype.init = function() {
    this.reloadCarts();
}