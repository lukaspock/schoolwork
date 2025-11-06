

export function I18N(language){
    this.language = language;

    this.translations = new Array;

    this.translations['en'] = {
        'hello': "Hello $0, nice to see you!",
        'time': "The time is: ",
        'niceday': "Have a nice day!",
    }

    this.translations['de'] = {
        'hello': "Hallo $0, schön dich zu sehen!",
        'time': "Die Uhrzeit ist: ",
        'niceday': "Schönen Tag noch!",
    }

}

I18N.prototype.translate = function(key, args) {
    let temp = this.translations[this.language][key];

    for(let i = 0; i < args.length; i++)
    {
        temp = temp.replace("$"+ i, args[i]);
    }

    return temp;
}

I18N.prototype.setLanguage = function(lang){
    this.language = lang;
}

