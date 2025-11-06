"use strict"

function User(n,e)
{
    this.name = n;
    this.email = e;

    this.toString = function()
    {
        return "Name: " + this.name + "\nE-Mail: " + this.email;
    };

    this.getName = () =>
    {
        return this.name;
    };

}
