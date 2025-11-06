import { CartItem } from "./CartItem.js";
import { Product } from "./Product.js";
import { Cart } from "./Cart.js";
import { CartList } from "./CartList.js";


export function ViewhandlerProduct(cL,outputID,descriptionID,priceID,amountID,addID,homescreenID,editID)
{
    this.cartList = cL;
    this.output = document.getElementById(outputID);
    this.description = document.getElementById(descriptionID);
    this.price = document.getElementById(priceID);
    this.amount = document.getElementById(amountID);
    this.add = document.getElementById(addID);
    this.homescreenButton = document.getElementById(homescreenID);
    this.editButton = document.getElementById(editID);
}

ViewhandlerProduct.prototype.renderProduct = function(product,idxCart)
{
    this.output.innerHTML = "";
    this.amount.value = "";

    let currentCart = this.cartList.getByIndex(idxCart);
    

    let name = document.createElement('h2');
    name.innerHTML = product.getName();

    let picture = document.createElement('img');
    console.log("PORDUCT: ");
    console.log(product);
    picture.src = "" + product.picture.url + product.picture.fileName;
    console.log("PICUTRE SRC: ");
    console.log(picture.src);
    picture.width = product.picture.width;        
    picture.height = product.picture.height;
    picture.id = "ProductPicture";

    this.output.append(name);
    this.output.append(picture);

    this.description.innerHTML = "Description: " + product.getDescription();
    this.price.innerHTML = "Price: " + product.getPrice() + " $";

    this.add.onclick = this.addToCart.bind(this,product,currentCart);
}

ViewhandlerProduct.prototype.bind = function()
{
    this.homescreenButton.onclick = () => toggleInvisible("Product","Homescreen");
    this.editButton.onclick = () => toggleInvisible("Product","Cart");
}

ViewhandlerProduct.prototype.addToCart = function(product,currentCart){

    let amount = this.amount.value;
    if(amount < 1)
        amount = 1;

    let cartItem = new CartItem(product, amount);
    currentCart.addItem(cartItem); 

    if(currentCart.getLength() >= 1)
    {
        currentCart.checkForMatch();
    }

    alert("Item has been added to your cart!");
    console.log(currentCart);
    this.updateCartList(currentCart);
}

ViewhandlerProduct.prototype.updateCartList = function(cart){
    this.cartList.updateCart(() => console.log("UPDATET CARTLIST"),cart)
}

function toggleInvisible(id1,id2){
    let element1 = document.getElementById(id1);
    let element2 = document.getElementById(id2);
    element1.classList.toggle("invisible");
    element2.classList.toggle("invisible");
}

