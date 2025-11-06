

function EncryptService(dao)
{
    this.text = "";
    this.encryptedText = "";
    this.dao = dao;

}

EncryptService.prototype.setText = function(text,callback)
{
    this.text = text;
    this.dao.encrypt(this.text, (encryptedText) => {
        this.encryptedText = encryptedText;
        callback();
    });

}