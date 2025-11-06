"use strict"

function QuizView(qModel, selectID, questionID, listID,inputID,resultID)
{
    this.qModel = qModel;
    this.select = document.getElementById(selectID);
    this.input = document.getElementById(inputID);
    this.question = document.getElementById(questionID);
    this.result = document.getElementById(resultID);
    this.list = document.getElementById(listID);

    this.bind = () => {
        this.select.onchange = () => {
            this.render(this.select.value);
        };    

        this.input.onchange = () => {
            if (this.qModel.isAnswerOk(this.select.value, this.input.value)) {
                this.result.innerHTML = "Your guess was <em>OK</em>";
            } else {
                this.result.innerHTML = "Your guess was <em>NOT OK</em>";
            }
        };
    }

    this.render = (questionIndex) => {

        this.question.innerHTML = "Question: " + this.qModel.getQuestionAt(questionIndex).getQuestionText();

        this.list.innerHTML = "";
        this.input.value = "";
        this.result.innerHTML = "";

        for (let i = 0; i < this.qModel.getNumberOfAnswers(questionIndex); i++) {
            let li = document.createElement("li");           
            li.innerHTML = this.qModel.getAnswerAt(questionIndex, i);
            this.list.append(li);
        }
    }

    this.createSelectOptionList = function()
    {
        this.select.innerHTML = "";

        for(let i = 0; i < this.qModel.getNumberOfQuestions() ; i++) {
            let op = document.createElement("option");
            op.innerHTML = this.qModel.getQuestionAt(i).getTopic();
            op.value = i;
            this.select.append(op);
        } 
    }
}
