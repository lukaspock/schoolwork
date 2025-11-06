
import { I18N } from "./I18N.js";

function main(){
    let i18n = new I18N("de");
    let _ = (key, ...args) => i18n.translate(key, args);

    console.log(_('hello', 'Alice'));
    console.log(_('time') + new Date().toISOString());
    console.log(_('niceday'));

    i18n.setLanguage("en");
    console.log("----");

    console.log(_('hello', 'Alice'));
    console.log(_('time') + new Date().toISOString());
    console.log(_('niceday'));
}

main(); 


