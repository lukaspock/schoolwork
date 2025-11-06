"use strict"

function QuizDao()
{
    this.loadQuestions = (callback) => {
        // Local questions, no fetch, pure JavaScript
        let questions = [];

        let aL1 = ["Yes", "No"];
        questions.push(new Question(1, "School", "Is Posch the best teacher?", aL1, 0));

        let aL2 = ["1993", "1990", "1995", "1994"];
        questions.push(new Question(2, "Music", "When did Kurt Cobain die?", aL2, 3));

        let aL3 = ["30", "40", "50"];
        questions.push(new Question(3, "Sports", "How old is Lebron James?", aL3, 1));

        callback(questions);
    }
}
