"use strict"

function UserList(ar)
{
    this.array = ar;

    this.add = function(user)
    {
        this.array.push(user);
    }

    this.get = function(idx)
    {
        return this.array[idx];
    }

    this.getNoe = function()
    {
        return this.array.length;
    }

    this.show = function(idx)
    {
        alert(this.array[idx].toString());
    }

    this.toStringUL = (idx) =>
    {
        return this.array[idx].toString();
    }

    this.gName = (idx) =>
    {
        return this.array[idx].getName();
    }
}
