"use strict"

function start()
{
    let dao = new QuizDao();

    dao.loadQuestions((questionArray) => {
        let model = new QuizModel();

        for (let q of questionArray) {
            model.addQuestion(q);
        }
        let view = new QuizView(model, "topic", "question", "list", "input", "result");

        view.createSelectOptionList();

        view.render(0);
        view.bind();
    });
}

start();
