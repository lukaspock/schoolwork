"use strict"

function ViewHandler(uL, sE)
{
    this.userList = uL;
    this.select = document.getElementById(sE)

    this.updateView = function()
    {

        for(let i = 0; i < this.userList.getNoe(); i++)
        {
            let option = document.createElement('option');
            option.innerHTML = this.userList.gName(i);
            this.select.append(option);
        }
    }

    this.bindButton = function(bID)
    {
        let button = document.getElementById(bID);

        button.onclick = () => 
        {
            let index = this.select.selectedIndex;
            this.userList.show(index);
        }
    }
}

function init()
{
    let u1 = new User("Lukas", "lukas.pock@htlpinkafeld.at");
    let u2 = new User("Nik", "nik.unger@htlpinkafeld.at");
    let u3 = new User("Samuel", "samuel.koeppel@htlpinkafeld.at");
    let u4 = new User("Justin", "justin.tatzgern@htlpinkafeld.at");

    let ar = [u1,u2,u3,u4];

    let uL = new UserList(ar);

    let vH = new ViewHandler(uL, "userlist");

    vH.updateView();
    vH.bindButton("showbtn");
       
}

init();