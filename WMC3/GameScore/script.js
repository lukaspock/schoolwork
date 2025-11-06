"use strict"

function Result(s){
    this.score = parseFloat(s);
}

function ResultList(){

    this.resultArray = new Array();

    this.addResult = function(result){
        this.resultArray.push(result);
    };

    this.getAverage = function(){

        let total = 0;
        for(let i = 0; i < this.resultArray.length; i++)
        {
            total += this.resultArray.score;
        }

        return total / this.resultArray.length;
    };

    this.getNoe = function(){
        return this.resultArray.length;
    };
}

function View(rL, pID, inputID){
    this.resultList = rL;
    this.dom = document;
    this.p = pID;
    this.input = inputID;

    this.render = function () {
        let output = this.dom.getElementById(this.p);
        output.innerHTML = ` ${this.resultList.getAverage().toFixed(2)} 
                            (${this.resultList.getNoe()} entries)`;
    };

    this.bind = (bID) => {
        let button = this.dom.getElementById(bID);
    
        button.onclick = () => {
            let input = this.dom.getElementById(this.input);
            let score = input.value;
            
            let r = new Result(score);
            this.resultList.addResult(r);
            this.render();
            input.value = "";
            
        };
    };
}

// Initialization
const resultList = new ResultList();
const view = new View(resultList, "output", "scoreInput");
view.bind("addButton");

