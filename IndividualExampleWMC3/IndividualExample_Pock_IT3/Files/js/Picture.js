"use strict"


function Picture(URL,fileName,width,height)
{
    this.url = URL;
    this.fileName = fileName;
    this.width = width;
    this.height = height;

}

Picture.prototype.getURL = function(){return this.url;} 
Picture.prototype.getFileName = function(){return this.fileName;} 
Picture.prototype.getWidth = function(){return this.width;} 
Picture.prototype.getHeight = function(){return this.height;} 

export { Picture };

