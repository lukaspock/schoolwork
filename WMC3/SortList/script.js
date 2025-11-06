"use strict"

beginn();

function beginn()
{
    let byText = document.getElementById("text");
    let byValue = document.getElementById("value");

    byText.onclick = sortByText;
    byValue.onclick = sortByValue;

}

function sortByText()
{
    sortLiElements((a,b) => comparatorText(a,b));
}

function sortByValue()
{
    sortLiElements((a,b) => comparatorValue(a,b));
}

function sortLiElements(comparator)
{
    let list = document.querySelectorAll("li");
    let a = Array.from(list);
    let sortedArray = SortingFunc(a,comparator);

    let ulElement = document.querySelector("ul") || document.querySelector("ol");
    deleteLiElements(ulElement);
    addLiElements(ulElement, sortedArray);
}

function comparatorText(a,b)
{
    let t1 = a.textcontent.toLowerCase();
    let t2 = b.textcontent.toLowerCase();

    if(t1 > t2)
        {
            return 1;
        }
    
    if(t1 < t2)
        {
            return -1;
        }
    
    if(t1 = t2)
        {
            return 0;
        }
}

function comparatorValue(a,b)
{
    let v1 = a.value;
    let v2 = b.value;

    if(v1 > v2)
    {
        return 1;
    }

    if(v1 < v2)
    {
        return -1;
    }

    if(v1 = v2)
    {
        return 0;
    }
}


function SortingFunc(origArray, comparator)
{
    
    let sortedArray = origArray.slice();

    for (let i = 0; i < sortedArray.length - 1; i++) {
        for (let j = 0; j < sortedArray.length - i - 1; j++) {
            if (comparator(sortedArray[j], sortedArray[j + 1]) > 0) {
                [sortedArray[j], sortedArray[j + 1]] = [sortedArray[j + 1], sortedArray[j]];
            }
        }
    }

    return sortedArray;
}


function deleteLiElements(ulElement) {
    while (ulElement.firstChild) {
        ulElement.removeChild(ulElement.firstChild);
    }
}


function addLiElements(ulElement, liElementList) {
    liElementList.forEach(li => ulElement.appendChild(li));
}