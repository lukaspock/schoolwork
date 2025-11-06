"use strict"

function ObjectList(ar)
{
    this.array = ar,

    this.toString = function()
    {
        let str = "[";

        for(let i=0; i < this.array.length ; i++)
        {
            str += this.array[i];
            
            if(i + 1 < this.array.length)
            {
                str += ", "
            }
        }

        str += "]";

        return str;
    },

    this.add = function(item, index = -1)
    {
        if(index == -1)
        {
            this.array.push(item);
            return;
        }
        if(index < 0 || index > this.array.length-1)
        {
            alert("invalid index");
            return;
        }
        else
        {
            this.array.splice(index , 0 , item);
        }
    },

    this.deleteAtIndex = function(index)
    {
        if(index < 0 || index > this.array.length-1)
            {
                alert("invalid index");
                return;
            }
        else
            {
                this.array.splice(index , 1);
            }
    },

    this.reverse = function()
    {

        let temp = new Array();
        let len = this.array.length;

        for(let i = 0; i < len; i++)
        {
            temp[i] = this.array[len-i-1];
        }

        this.array = temp;

    }

    this.getAt = function(index)
    {
        return this.array[index];
    },

    this.contains = function(item)
    {
        for(let i = 0; i < this.array.length; i++)
        {
            if(this.array[i].toString() == item.toString())
            {
                return true;
            }
        }

        return false;
    },

    this.indexOf = function(item)
    {
        for(let i = 0; i < this.array.length; i++)
            {
                if(this.array[i].toString() == item.toString())
                {
                    return i;
                }
            }
    
            return -1;
    }

}