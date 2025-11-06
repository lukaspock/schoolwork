import { ProductList } from "./ProductList.js";
import { CategoryList } from "./CategoryList.js";
import { Category } from "./Category.js";
import { Picture } from "./Picture.js";
import { Product } from "./Product.js";

export function ViewHandlerADD(cl,pl,categoryList,nameID,priceID,categoryID,descriptionID,urlID,fileNameID,existingPoutput,existingCoutput,backButton,createButton,nameID2,descriptionID2,createButton2)
{
    this.cartList = cl;
    this.productList = pl;
    this.categoryList = categoryList;
    this.name = document.getElementById(nameID);
    this.price = document.getElementById(priceID);
    this.category = document.getElementById(categoryID);
    this.description = document.getElementById(descriptionID);
    
    this.url = document.getElementById(urlID);
    this.fileName = document.getElementById(fileNameID);

    this.name2 = document.getElementById(nameID2);
    this.description2 = document.getElementById(descriptionID2);

    this.existingPoutput = document.getElementById(existingPoutput);
    this.existingCoutput = document.getElementById(existingCoutput);
    this.backButton = document.getElementById(backButton);
    this.createButton = document.getElementById(createButton);
    this.createButton2 = document.getElementById(createButton2);

}



ViewHandlerADD.prototype.render = function() {

    
    console.log(this);

    this.existingPoutput.innerHTML = "";
    this.existingCoutput.innerHTML = "";

    console.log("render ADD");

    console.log("this.productList.getLength()" + this.productList.ar.length);
    console.log(this.productList);

    for(let i = 0; i < this.productList.getLength(); i++)
        {
            let currentProduct = this.productList.getByIndex(i);
            
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

        
                let product = document.createElement('div');
                let idDIV = "Product" + i;
            
                product.id = idDIV;


                let deleteButton = document.createElement('button');
                deleteButton.innerHTML = "Delete";
                deleteButton.onclick = this.removeProduct.bind(this,currentProduct.id,i);

                buttons.append(deleteButton);

                buttonContainer.append(buttons);

                div.append(name);
                div.append(picture);
                div.append(buttonContainer);
                
                product.append(div);
                
                
                this.existingPoutput.append(product);
                
        }

        this.category.innerHTML = "";

        for(let i = 0; i < this.categoryList.getLength(); i++)
        {
            
            let currentCategory = this.categoryList.getByIndex(i);
            let category = document.createElement('div');

            let idname = document.createElement('p');
            idname.innerHTML = currentCategory.getName();

            let deleteButton = document.createElement('button');
            deleteButton.innerHTML = "Delete";
            deleteButton.onclick = this.removeCategory.bind(this,currentCategory.id,i);

            category.append(idname,deleteButton);

            this.existingCoutput.append(category);

            let option = document.createElement('option');
            option.value = currentCategory.id;
            option.innerHTML = currentCategory.name;

            this.category.append(option);

        }
    

}


ViewHandlerADD.prototype.bind = function(){
    this.backButton.onclick = () => toggleInvisible("ADD","Homescreen");
    this.createButton.onclick = () => this.addHelperProduct();
    this.createButton2.onclick = () => this.addHelperCategory();
}

function toggleInvisible(id1,id2){
    let element1 = document.getElementById(id1);
    let element2 = document.getElementById(id2);
    element1.classList.toggle("invisible");
    element2.classList.toggle("invisible");
}

// CATEGORYS //

ViewHandlerADD.prototype.addHelperCategory = function(){
    
    let id = this.categoryList.length + 1;

    console.log("Category List: ");
    console.log(this.categoryList);
    //console.log(this.categoryList.getByIndex(i).id);


    let name = this.name2.value;
    let description = this.description2.value;

    this.name2.value = "";
    this.description2.value = "";

    let tempCat = new Category(name,id,description);
    console.log(tempCat)

    this.addCategory(tempCat);

}

ViewHandlerADD.prototype.reloadCategorys = function(){
    this.categoryList.loadCategorys(() => console.log("reloadCategorys - succesful"));
}

ViewHandlerADD.prototype.addCategory = function(category){
    this.categoryList.addCategory(() => this.render(),category)
}

ViewHandlerADD.prototype.removeCategory = function(id,i){
    this.categoryList.removeCategory(() => this.render(),id,i)

    for(let i = 0; i < this.productList.getLength(); i++){
        if(this.productList.getByIndex(i).category = id);
            this.removeProduct.bind(this, this.productList.getByIndex(i).id,i);
    }
}

// PRODUCT //

ViewHandlerADD.prototype.addHelperProduct = function(){

    //if(this.name == "" || this.price == "" || this.category == "" || this.description = "")

    let id = this.categoryList.length + 1;

    let name = this.name.value;
    let price = Number(this.price.value);
    let category = Number(this.category.value);
    let description = this.description.value;
    

    let url = this.url.value;
    let fileName = this.fileName.value;

    let tempPic = new Picture(url,fileName,200,120);

    let tempProduct = new Product(id,name,price,null,category,description,tempPic);

    this.name.value = "";
    this.price.value = "";
    this.description.value = ""; 
    this.url.value = "";
    this.fileName.vlaue = "";

    this.addProduct(tempProduct);
}


ViewHandlerADD.prototype.reloadProducts = function() {
    this.productList.loadProducts(() => {
      this.render();
    });
}

ViewHandlerADD.prototype.addProduct = function(product){
    this.productList.addProduct(() => this.render(),product)
}

ViewHandlerADD.prototype.removeProduct = function(id,i){
    this.productList.removeProduct(() => this.render(),id,i);
}

ViewHandlerADD.prototype.init = function(){
    this.reloadProducts();
    this.reloadCategorys();
}