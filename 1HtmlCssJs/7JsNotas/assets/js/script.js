var nh1 = prompt("Ingrese primera nota de HTML: ");
document.getElementById('hn1').innerHTML = nh1;

var nh2 = prompt('Ingrese segunda nota de HTML: ');
document.getElementById('hn2').innerHTML = nh2;

var nh3 = prompt('Ingrese tercera nota de HTML: ');
document.getElementById('hn3').innerHTML = nh3;

var ph = (parseFloat(nh1) + parseFloat(nh2) + parseFloat(nh3))/3;
document.getElementById('hp').innerHTML = ph;

var nc1 = prompt("Ingrese primera nota de CSS: ");
document.getElementById('cn1').innerHTML = nc1;

var nc2 = prompt('Ingrese segunda nota de CSS: ');
document.getElementById('cn2').innerHTML = nc2;

var nc3 = prompt('Ingrese tercera nota de CSS: ');
document.getElementById('cn3').innerHTML = nc3;

var pc = (parseFloat(nc1) + parseFloat(nc2) + parseFloat(nc3))/3;
document.getElementById('cp').innerHTML = ph;

var nj1 = prompt("Ingrese primera nota de JavaScript: ");
document.getElementById('jn1').innerHTML = nj1;

var nj2 = prompt('Ingrese segunda nota de JavaScript: ');
document.getElementById('jn2').innerHTML = nj2;

var nj3 = prompt('Ingrese tercera nota de JavaScript: ');
document.getElementById('jn3').innerHTML = nj3;

var pj = (parseFloat(nj1) + parseFloat(nj2) + parseFloat(nj3))/3;
document.getElementById('jp').innerHTML = pj;
