import { CartItem } from "./CartItem.js";
import { CartList } from "./CartList.js";
import { Cart } from "./Cart.js";

export function ViewhandlerOverview(cl,cartOutput,priceOutput,HomescreenButtonId,nameOverview,select)
{
    this.cartList = cl;
    this.output = document.getElementById(cartOutput);
    this.price = document.getElementById(priceOutput);
    this.homescreen = document.getElementById(HomescreenButtonId);
    this.name = document.getElementById(nameOverview);
    this.select = document.getElementById(select);
}


ViewhandlerOverview.prototype.renderProducts = function(idx){
    
    this.output.innerHTML = "";

    let currentCart = this.cartList.getByIndex(idx);
    console.log(currentCart);

    if(currentCart.items.length == 0)
    {
        let h2 = document.createElement('h2');
        h2.innerHTML = "Your Selected Cart Is Empty";
        this.output.append(h2);
        this.name.innerHTML = "";

        this.price.innerHTML = "";

    }

    if(currentCart.items.length > 0)
    {
        this.name.innerHTML = "Cart Name: " + currentCart.name;
        
    }

    for(let i = 0; i < currentCart.items.length; i++)
    {
        let currentProduct = currentCart.getItem(i);
        let name = document.createElement('p');
        let picture = document.createElement('img');
        let div = document.createElement('div');

        name.innerHTML = currentProduct.amount+ "x  " + currentProduct.product.name;

        picture.src = currentProduct.product.picture.url + currentProduct.product.picture.fileName;
        picture.width = currentProduct.product.picture.width;
        picture.height = currentProduct.product.picture.height;

        let product = document.createElement('div');
        let idDIV = "Product" + i;
    
        product.id = idDIV;

        product.append(picture);

        div.append(name);
        div.append(product);
    
        this.output.append(div);
        
        this.price.innerHTML = "Total Price: " + Number(currentCart.calculateTotal()) + "$";
    }
}

ViewhandlerOverview.prototype.bind = function(){
    this.homescreen.innerHTML = "Homescreen";
    this.homescreen.onclick = () => toggleInvisible("Homescreen","Overview");

} 

function toggleInvisible(id1,id2){
    let element1 = document.getElementById(id1);
    let element2 = document.getElementById(id2);
    element1.classList.toggle("invisible");
    element2.classList.toggle("invisible");
}


  