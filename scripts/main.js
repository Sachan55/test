var myImage = document.querySelector('img');

myImage.onclick = function() {
    var mySrc = myImage.getAttribute('src');
    if(mySrc === 'images/firefox-icon.png') {
      myImage.setAttribute ('src','images/chrome.png');
    } else {
      myImage.setAttribute ('src','images/firefox-icon.png');
    }
}
var myButton = document.querySelector('button');
var myHeading = document.querySelector('h1');
function setUserName(){
         var myname = prompt('please enter your name : ');
         localStorage.setItem('name' , myname);
         myHeading.innerHTML = 'mozilla is cool, ' + myname;
}
if(!localStorage.getItem('name')){
	setUserName();
}
else{
	var storedName = localStorage.getItem('name');
	myHeading.innerHTML = 'Mozilla is cool, ' + storedName;
}
myButton.onclick = function(){
	setUserName();
}
