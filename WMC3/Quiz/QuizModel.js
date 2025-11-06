"use strict"

function QuizModel()
{
    this.array = [];

    this.addQuestion = (question) => this.array.push(question);
    this.getQuestionAt = (idx) => this.array[idx];
    this.getNumberOfQuestions = () => this.array.length;
    this.getAnswerAt = (idx, answerNumber) => this.getQuestionAt(idx).getAnswerAt(answerNumber);
    this.getNumberOfAnswers = (idx) =>  this.getQuestionAt(idx).getNumberOfAnswers();

    this.isAnswerOk = (questionIndex, answerNumber) => 
    {
        if (answerNumber - 1 > this.getNumberOfAnswers(questionIndex) ||
            answerNumber - 1 < 0) {
            return false;
        } else {
            return this.getQuestionAt(questionIndex).getCorrectAnswerIndex() === answerNumber - 1;
        }
    }
}
