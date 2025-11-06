const express = require('express');
const app = express();


app.get("/hello", (req, res) => {
    let name = req.query.name;

    res.end(`Hello ${name}!`);
});

app.listen(3000, () => console.log("Server is running..."));


app.get("/calculate", (req,res) => {

    let op1 = Number(req.query.op1);
    let op2 = Number(req.query.op2);
    let result = op1 + op2;

    res.end(op1 + " + " + op2 + " = " + result);
    
})

