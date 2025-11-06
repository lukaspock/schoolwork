

function start(){
    
    let input = document.getElementById("input").value;
    let url = "https://faas-fra1-afec6ce7.doserverless.co/api/v1/web/fn-a2df8e50-3266-47e2-819b-8c46de65fb73/wmcdemos/encryptWord?word=" + input;


        let xhr = new XMLHttpRequest();
        xhr.open('Get', url);
        xhr.send();

        xhr.onload = () => {
            alert(`Got response: ${xhr.response}`);
            document.getElementById("disabled").value = `${xhr.response}`
        }
    }


let button = document.getElementById("encrypt");
button.onclick = () => {
        start();
}