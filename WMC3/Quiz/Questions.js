"use strict"

function Question(id, t, qT, aL, index) {
    this.id = id;
    this.topic = t;
    this.questionText = qT;
    this.answerList = aL;
    this.correctAnswerIndex = index;

    this.getAnswer = (answerNumber) => this.answerList[answerNumber];
    this.getALLength = () => this.answerList.length;
    this.getCorrect = () => this.correctAnswerIndex;
    this.getTopic = () => this.topic;
    this.getQuestionText = () => this.questionText;
    this.getAnswerList = () => this.answerList;
    this.getCorrectAnswerIndex = () => this.correctAnswerIndex;
    this.getNumberOfAnswers = () => this.answerList.length;
    this.getAnswerAt = (index) => this.answerList[index];
}
