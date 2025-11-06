

function EncryptViewHandler(service,input,output,button)
{
    this.service = service;
    this.input = document.getElementById(input);
    this.output = document.getElementById(output);
    this.button = document.getElementById(button);
}

EncryptViewHandler.prototype.bind = function()
{
    this.button.onclick = this.render.bind(this);
}

EncryptViewHandler.prototype.render = function()
{
    let text = this.input.value;
    let callback = () =>
}
