import { CartItem } from './CartItem.js';
import { Cart } from './Cart.js';
import { Product } from './Product.js';

export function ViewhandlerCart(cl, pl, categoryList, productsOutput,cartItemsOutput,priceOutput,cartnameID,goBackBUtton,addButtonProduct, viewProduct, viewOverview, filterName, filterCategory)
{
    this.cartList = cl;
    this.productList = pl;
    this.categoryList = categoryList;
    this.products = document.getElementById(productsOutput);
    this.cartItems = document.getElementById(cartItemsOutput);
    this.priceOutput = document.getElementById(priceOutput);
    this.cartName = document.getElementById(cartnameID);
    this.goBackBUtton = document.getElementById(goBackBUtton);
    this.addButton = document.getElementById(addButtonProduct);
    this.filterName = document.getElementById(filterName);
    this.filterCategory = document.getElementById(filterCategory);

    this.viewOverview = viewOverview;
    this.viewProduct = viewProduct;

    this.currentIndex = null;
}

ViewhandlerCart.prototype.renderProducts = function(idx,cattegory = null){
    this.products.innerHTML = "";
    this.cartItems.innerHTML = "";

    this.currentIndex = idx;
    if(idx != -1)
    {
        let currentCart = this.cartList.ar[idx];
        console.log("CurrentCart: " + currentCart);


        this.filterCategory.innerHTML = " ";
        let filterDiv = document.createElement('div');
        
        for(let i = 0; i < this.categoryList.getLength(); i++)
        {
            let input = document.createElement('input');
            input.type = "radio"; 
            input.id = Number(this.categoryList.ar[i].id);
            input.value = this.categoryList.ar[i].name;
            input.name = "categoryFilter"; 

            if(input.id == cattegory){
                input.checked = "true";
            }

            // Toggle behavior on repeated click
            input.addEventListener('click', function () {
                if (input.dataset.wasChecked === "true") {
                    input.checked = false;
                    input.dataset.wasChecked = "false";
                } else {
                    input.dataset.wasChecked = "true";
                }
                // Reset other radios
                document.querySelectorAll('input[name="categoryFilter"]').forEach(r => {
                    if (r !== input) {
                        r.dataset.wasChecked = "false";
                    }
                });
            });

            input.onclick = () => {
                this.renderProducts(idx,input.id);
            }

            let label = document.createElement('label');
            label.for = this.categoryList.ar[i].name;
            label.innerHTML = this.categoryList.ar[i].name;

            filterDiv.append(input,label);
        }

        this.filterCategory.append(filterDiv);
    }

    for(let i = 0; i < this.productList.getLength(); i++)
        {
            let currentProduct = this.productList.getByIndex(i);
            
            if(cattegory == null || currentProduct.category == cattegory)
            {
                let name = document.createElement('p');
                let picture = document.createElement('img')
                let div = document.createElement('div');
                div.classList.add('center');            
                let buttons = document.createElement('div');
                buttons.classList.add('buttons');
                let buttonContainer = document.createElement('div');
                buttonContainer.classList.add('buttonContainer');

                name.innerHTML = currentProduct.getName() + "  "  + currentProduct.getPrice() + "$";

                picture.src = currentProduct.picture.url + currentProduct.picture.fileName;
                picture.width = currentProduct.picture.width;
                picture.height = currentProduct.picture.height;
                picture.addEventListener("click", () => {
                    this.viewProduct.renderProduct(currentProduct,idx);
                    this.renderProducts(idx);
                })
                picture.style = "cursor: pointer";

                picture.onclick = () => toggleInvisible("Cart","Product");

        
                let product = document.createElement('div');
                let idDIV = "Product" + i;
            
                product.id = idDIV;

                let idInput = "inputAmount" + i
                let input = document.createElement("input");
                input.type = "number";
                input.id = idInput;

                let addButton = document.createElement('button');
                addButton.innerHTML = "Add to cart";
                addButton.onclick = this.addToCart.bind(this,idx, i, idInput);

                buttons.append(input);
                buttons.append(addButton);

                buttonContainer.append(buttons);

                div.append(name);
                div.append(picture);
                div.append(buttonContainer);
                
                product.append(div);
                
                
                this.products.append(product);
                }
                
        }
    
    console.log(this.currentIndex);
    console.log(idx);
    console.log();

    if(this.currentIndex != null && this.currentIndex != -1)
    {
        console.log(this.currentIndex)
        
    this.cartName.innerHTML = "Cart Name: " + this.cartList.ar[this.currentIndex].getName(); 
        
    for(let i = 0; i < this.cartList.ar[this.currentIndex].getLength(); i++)
    {
        let currentProduct =  this.cartList.ar[this.currentIndex].getItem(i);
       
        let name = document.createElement('p');
        let picture = document.createElement('img');

        name.innerHTML = currentProduct.amount + "x  " + currentProduct.product.name;

        picture.src = "" + currentProduct.product.picture.url + currentProduct.product.picture.fileName;
        picture.width = currentProduct.product.picture.width;
        picture.height = currentProduct.product.picture.height;
        picture.onclick = this.removeFromCart.bind(this,idx, i);
        picture.style = "cursor: pointer";

        let product = document.createElement('div');
        let idDIV = "Product" + i;
    
        product.id = idDIV;

        product.append(name);
        product.append(picture);
        
        this.cartItems.append(product);
    }
}

    let overviewButton = document.createElement('button');
    overviewButton.innerHTML = "Continue";
    overviewButton.id = "continue";
    overviewButton.onclick = () => toggleInvisible("Cart","Overview");

    overviewButton.addEventListener("click", () => {
        this.viewOverview.renderProducts(idx);
    })

    this.cartItems.append(overviewButton);

    this.addButton.addEventListener("click", () => {
        this.renderProducts(idx);
    })
    
}
ViewhandlerCart.prototype.addToCart = function(idx,i, idInput){

    let currentCart = this.cartList.getByIndex(idx);
    
    console.log(currentCart);

    let amount = Number(document.getElementById(idInput).value);
    if(amount < 1)
        amount = 1;
    let cartItem = new CartItem(this.productList.getByIndex(i), amount);
    currentCart.addItem(cartItem); 

    if(currentCart.getLength() > 1)
    {
        currentCart.checkForMatch();
    }
    
    this.renderProducts(idx);
    this.calculate(idx);

    this.updateCartList(currentCart);
}

ViewhandlerCart.prototype.calculate = function(idx){
    let currentCart = this.cartList.getByIndex(idx);
    this.priceOutput.innerHTML = "Total Price: " + currentCart.calculateTotal() + "$";
} 

ViewhandlerCart.prototype.removeFromCart = function(idx,i){
    let currentCart = this.cartList.getByIndex(idx);
    currentCart.removeItem(i);
    this.calculate(idx);

    this.updateCartList(currentCart);
}

ViewhandlerCart.prototype.bind = function(){
    this.goBackBUtton.innerHTML = "Homescreen";
    this.goBackBUtton.onclick = () => toggleInvisible("Cart","Homescreen");
}

function toggleInvisible(id1,id2){
    let element1 = document.getElementById(id1);
    let element2 = document.getElementById(id2);
    element1.classList.toggle("invisible");
    element2.classList.toggle("invisible");
}

ViewhandlerCart.prototype.reloadProducts = function() {
    this.productList.loadProdcuts(() => {
      this.renderProducts(this.currentIndex);
    });
}

ViewhandlerCart.prototype.updateCartList = function(cart){
    this.cartList.updateCart(() => this.renderProducts(this.currentIndex),cart)
}

ViewhandlerCart.prototype.reloadCarts = function() {
    this.cartList.loadCarts(() => {
        this.renderProducts(this.currentIndex);
    });
}

ViewhandlerCart.prototype.reloadCategorys = function(){
    this.categoryList.loadCategorys(() => console.log("reloadCategorys - succesful"));
}

ViewhandlerCart.prototype.init = function(){
    this.reloadCarts();
    this.reloadCategorys();
    this.productList.loadProducts(() => this.renderProducts(-1))
}