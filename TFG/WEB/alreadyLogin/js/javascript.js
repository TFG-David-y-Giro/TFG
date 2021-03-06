//	Hacer tienda online de informatica usando: HTML, CSS, JS
//	En el codigo javascript hay que hacer la base de datos de los productos con un vector 
let respuesta = "";
let respuestaByWord = "";
const id = [];
const productos = [];
const precios = [];
const stock = [];
const url_itemByWord = "http://localhost:9090/item/?word=";
function getItems() {
    var xhttp;
    xhttp = new XMLHttpRequest();
    /* var filter_word = document.querySelector('#filter_word').value; */
    xhttp.onreadystatechange = function () {
        respuesta = JSON.parse(this.responseText);
        console.log(respuesta)
        for (let i = 0; i < respuesta.length; i++) {
            id.push(respuesta[i].id)
            productos.push(respuesta[i].name)
            precios.push(respuesta[i].price)
            stock.push(respuesta[i].quantity)
        }
        //Creo variable y asocio al html
        var PRINC = document.getElementsByName("PRINC");
        PRINC[0].innerHTML = ''
        //Bucle para crear divs en funcion de la cantidad que exista
        for (let i = 0; i < respuesta.length; i++) {
            PRINC[0].innerHTML += '<div id="div' + i + '" name="DIVS" class="productos"></div>';
            var DIVSS = document.getElementsByName("DIVS");
            DIVSS[i].innerHTML = '<a id="imgG' + i + '" ><img id="imgP' + 0 + i + '" class="imagen" src="' + imgPeque[i] + '"style="width:225px; height:230px;"></a><div class="etiquetas"><b><span id="pro' + i + '">' + productos[i] + '</span>: <span id="pre' + i + '">' + precios[i] + '€</span></b></div><div class="stock">Hay en stock <span id="uni' + i + '">' + stock[i] + '</span> unidades,<br/>¿Cuantas quiere?: <input class="uniBien" style="margin-bottom:40px"type="number" id="uniUser' + i + '" name="uniUser" value="0" size="4" /></div>';
        }
    }
    xhttp.open("GET", url_itemByWord/* +filter_word */, true);
    xhttp.send();
}

function getItemsByWord() {
    
    var xhttp;
    xhttp = new XMLHttpRequest();
    var filter_word = document.querySelector('#filter_word').value;
    xhttp.open("GET", url_itemByWord + filter_word, true);
    xhttp.send();
    xhttp.onreadystatechange = function () {
        if (xhttp.readyState == 4) {
            if (xhttp.status == 200) {
                respuestaByWord = JSON.parse(xhttp.responseText);
                /* for (let i = 0; i < respuestaByWord.length; i++) {
                    id.push(respuestaByWord[i].id)
                    productos.push(respuestaByWord[i].name)
                    precios.push(respuestaByWord[i].price)
                    stock.push(respuestaByWord[i].quantity)
                } */
                //Creo variable y asocio al html
                //document.getElementById("PRINC").style.display = "none";
                var SECUNDARY = document.getElementById("SECUNDARY");
                SECUNDARY.innerHTML = ''


                //Bucle para crear divs en funcion de la cantidad que exista
                for (let i = 0; i < respuestaByWord.length; i++) {
                    console.log(respuestaByWord)
                    SECUNDARY.innerHTML += '<div id="div' + i + '" name="DIVSS" class="productos">' + respuestaByWord[i].price + '</div>';

                    var DIVSS = document.getElementsByName("DIVSS");
                    DIVSS[i].innerHTML = '<a id="imgG' + i + '" ><img id="imgP' + 0 + i + '" class="imagen" src="'
                        + imgPeque[respuestaByWord[i].id-1] + '"style="width:225px; height:230px;"></a><div class="etiquetas"><b><span id="pro'
                        + i + '">' + respuestaByWord[i].name + '</span>: <span id="pre' + i + '">' + respuestaByWord[i].price
                        + '€</span></b></div><div class="stock">Hay en stock <span id="uni' + i + '">'
                        + respuestaByWord[i].quantity + '</span> unidades,<br/>¿Cuantas quiere?: <input class="uniBien" style="margin-bottom:40px"type="number" id="uniUser'
                        + i + '" name="uniUser" value="0" size="4" /></div>';

                }
                console.log(respuestaByWord);
                console.log(filter_word);
            }
        }
        document.getElementById("princ").style.display = "none";
    }

}

function descargaArchivo() {
    // Obtener la instancia del objeto XMLHttpRequest
    peticion_http = new XMLHttpRequest();
    // Preparar la funcion de respuesta
    peticion_http.onreadystatechange = muestraContenido;
    // Realizar peticion HTTP
    peticion_http.open('GET', 'enlaces.txt', true);
    peticion_http.send(null);
    function muestraContenido() {
        if (peticion_http.readyState == 4) {
            if (peticion_http.status == 200) {
                var arr = JSON.parse(peticion_http.responseText);
                var out = "";
                for (i = 0; i < arr.length; i++) {
                    out += '<a href="' + arr[i].url + '">' + arr[i].display + '</a><br>';
                }
                document.getElementById("id1").innerHTML = out;
            }
        }
    }
}

//BASE DE DATOS
//var productos = ["MSI i5 ", "Hummer i3", "RTX 3090", "RTX 3080"];

var imgGrandes = ["../../imagenes/msi-i5.jpeg", "../../imagenes/hummer-i3.jpeg", "../../imagenes/rtx3090.jpeg", "../../imagenes/rtx3080.jpeg", "../../imagenes/msi-i5.jpeg", "../../imagenes/hummer-i3.jpeg", "../../imagenes/rtx3090.jpeg", "../../imagenes/rtx3080.jpeg"];
var imgPeque = ["../../imagenes/msi-i5.jpeg", "../../imagenes/hummer-i3.jpeg", "../../imagenes/rtx3090.jpeg", "../../imagenes/rtx3080.jpeg", "../../imagenes/msi-i5.jpeg", "../../imagenes/hummer-i3.jpeg", "../../imagenes/rtx3090.jpeg", "../../imagenes/rtx3080.jpeg"];
//var precios = [499, 399, 2000, 1500];
// var stock = [1, 1, 1, 1];
var precioTransporte = [6, 12, 20, "gratis"];
var IVA = 0.21;
var uniUser;



//JAVASCRIPT A EJECUTARSE UNA VEZ CARGADA LA PAGINA:	
window.onload = function () {

    getItems();
    //Se cargan los productos dentro del HTML de forna dinamica haciendo uso de los datos de la base de datos, como si de un PHP se tratase:
    /* var DIVS = document.getElementsByName("DIVS");
    for (i in productos) {
        DIVS[i].innerHTML = '<a id="imgG' + i + '" href="' + imgGrandes[i] + '"><img id="imgP' + i + '" class="imagen" src="' + imgPeque[i] + '"></a><div class="etiquetas"><b><span id="pro' + i + '">' + productos[i] + '</span>: <span id="pre' + i + '">' + precios[i] + '€</span></b></div><div class="stock">Hay en stock <span id="uni' + i + '">' + stock[i] + '</span> unidades,<br/>¿Cuantas quiere?: <input class="uniBien" type="number" id="uniUser' + i + '" name="uniUser" value="0" size="4" /></div>';
    }
 */

    //Rellena el campo dia y año, de la fecha de nacimiento y tarjeta de credito:
    //Mas info en: http://www.tallerwebmaster.com/tutorial/mostrar-fecha-actual-con-javascrip/58/
    //Fecha de nacimiento
    var fecha = new Date();
    var anio = fecha.getFullYear();

    for (var i = 1; i <= 31; i++) {
        document.getElementById("fechaNacimientoDia").innerHTML = document.getElementById("fechaNacimientoDia").innerHTML + '<option value="' + i + '">' + i + '</option>';
    }

    for (var i = anio; i >= (anio - 110); i--) {
        document.getElementById("fechaNacimientoAnio").innerHTML = document.getElementById("fechaNacimientoAnio").innerHTML + '<option value="' + i + '">' + i + '</option>';
    }

    //Tarjeta de credito:
    for (var i = 1; i <= 12; i++) {
        document.getElementById("mesTarjeta").innerHTML = document.getElementById("mesTarjeta").innerHTML + '<option value="' + i + '">' + i + '</option>';
    }

    for (var i = anio; i <= (anio + 21); i++) {
        document.getElementById("anioTarjeta").innerHTML = document.getElementById("anioTarjeta").innerHTML + '<option value="' + i + '">' + i + '</option>';
    }



    //Botones que llevaran a cabo la ejecucion de determinadas secuencias de codigo JavaScript:
    document.getElementById("botonTotal").onclick = validaLasUnidades;
    //document.getElementById("botonDatos").onclick = pideDatos;
    document.getElementById("botonPago").onclick = validaDatosPersonales;
    document.getElementById("botonConfirmar").onclick = validaDatosPago;
    //document.getElementById("button_postItem").addEventListener("click", postItem);
    document.querySelector('#filter_word_button').addEventListener("click", getItemsByWord);
}




/*-------------------COMIENZAN LAS FUNCIONES-------------------*/


//FUNCION DE VALIDACION DE UNIDADES
function validaLasUnidades(elEvento) {

    var todoBien = true;
    uniUser = document.getElementsByName("uniUser");


    for (let i = 0; i < respuesta.length; i++) {

        if (uniUser[i].value == "" || uniUser[i].value > stock[i] || uniUser[i].value < 0) {

            todoBien = false;
            uniUser[i].className = "uniMal";

            //Modifica el css para quitar los formularios:
            document.getElementById("todo").className = "todoNo";
            document.getElementById("menu").className = "menuNo";
            document.getElementById("divZonaCompra").className = "divZonaCompraNo";
            document.getElementById("divTotal").className = "divsNo";
/**/			document.getElementById("divDatos").className = "divsNo";
/**/			document.getElementById("divPago").className = "divsNo";

            //Deshabilita el boton de datos personales:
            document.getElementById("botonDatos").disabled = true;
/**/			document.getElementById("botonDatos").disabled = true;
/**/			document.getElementById("botonDatos").disabled = true;

            //Con solo un error se para la validacion de unidades:
            return;
        }
        else {
            todoBien = true;
            uniUser[i].className = "uniBien";
        }
    }

    //Si no ha habido ni un solo error, se ejecuta la siguiente funcion que se encarga de cargar el carro de la compra:
    if (todoBien) {
        calculaElTotal();
    }
}




//FUNCION QUE MUSTRA EL CARRO DE LA COMPRA:
function calculaElTotal(elEvento) {


    //Añade el encabezado de la tabla
    document.getElementById("tablaTotal").innerHTML = '<tr><td class="pro"><b>Producto</b></td><td class="uni"><b>Unidades</b></td><td class="preUni"><b>Precio Unidad</b></td><td class="preTotal"><b>Precio Total</b></td></tr>';


    //Inicializacion de las variables para esta funcion:
    var carroTotal = 0;
    var numProductos = 0;


    //Muestra el carrito de la compra
    for (let i = 0; i < respuesta.length; i++) {

        var tablaTotal = document.getElementById("tablaTotal").innerHTML;
        var preTotal = 0;


        //Cuenta el numero de productos para saber cuanto costara el transporte
        if (uniUser[i].value != 0) {
            numProductos++;
        }


        if (uniUser[i].value != 0) {

            //Modifica el css para hacer hueco a los formularios
            document.getElementById("todo").className = "todoSi";
            document.getElementById("menu").className = "menuSi";
            document.getElementById("divZonaCompra").className = "divZonaCompraSi";
            document.getElementById("divTotal").className = "divsSi";
/**/			document.getElementById("divDatos").className = "divsNo";
/**/			document.getElementById("divPago").className = "divsNo";

            //Habilita el boton de datos personales
            document.getElementById("botonPago").disabled = false;
           /*  document.getElementById("botonDatos").disabled = false; */

            //Calcula el totalUnidades y rellena el carro de la compra
            preTotal = precios[i] * uniUser[i].value;
            carroTotal = carroTotal + preTotal;
            document.getElementById("tablaTotal").innerHTML = tablaTotal + '<tr class="proCarrito"><td>' + productos[i] + '</td><td>' + uniUser[i].value + '</td><td>' + precios[i] + '</td><td id="preTotal' + i + '" name="preTotal">' + preTotal + '</td></tr>';
        }
    }


    //Se calcula el transporte a pagar segun la cantidad de productos comprados:
    var precioTransporteAPagar;
    if (numProductos <= 2) {
        precioTransporteAPagar = precioTransporte[0];
    }
    else if (numProductos <= 3) {
        precioTransporteAPagar = precioTransporte[1];
    }
    else if (numProductos <= 4) {
        precioTransporteAPagar = precioTransporte[2];
    }
    else if (numProductos >= 5) {
        precioTransporteAPagar = precioTransporte[3];
    }

    //Se sacan las cuentas del transporte (si lo hubiese), del iva y el total:
    var totalTransporte = precioTransporteAPagar;
    if (totalTransporte == "gratis") {
        var totalIVA = (carroTotal * IVA);
        var totalAPagar = carroTotal + totalIVA;
    }
    else {
        var totalIVA = ((carroTotal + totalTransporte) * IVA);
        var totalAPagar = carroTotal + totalTransporte + totalIVA;
    }


    //Limitar a 2 los decimales a mostrar del IVA:
    totalIVA = totalIVA * 100;
    totalIVA = Math.floor(totalIVA);
    totalIVA = totalIVA / 100;
    //Limitar a 2 los decimales a mostrar del TOTAL A PAGAR:
    totalAPagar = totalAPagar * 100;
    totalAPagar = Math.floor(totalAPagar);
    totalAPagar = totalAPagar / 100;

    //Se añade a la tabla el TOTAL que suma el carrito:
    tablaTotal = document.getElementById("tablaTotal").innerHTML;
    document.getElementById("tablaTotal").innerHTML = tablaTotal + '<tr><td> </td> <td></td><td class="preUni"><b>Transporte: </b></td><td class="preTotal"><b>' + totalTransporte + '</b></td></tr>' + '<tr><td> </td> <td></td><td class="preUni"><b>IVA (' + (IVA * 100) + '%): </b></td><td class="preTotal"><b>' + totalIVA + '</b></td></tr>' + '<tr><td> </td> <td></td><td class="preUni"><b>Total: </b></td><td class="preTotal" id="totalAPagar"><b>' + totalAPagar + ' €</b></td></tr>';
}




//FUNCION DE PEDIR DATOS
function pideDatos(elEvento) {
    document.getElementById("divDatos").className = "divsSi";
/**/	document.getElementById("divTotal").className = "divsNo";
/**/	document.getElementById("divPago").className = "divsNo";
    document.getElementById("botonPago").disabled = false;
}




//FUNCION DE VALIDACION DE DATOS PERSONALES:
function validaDatosPersonales(elEvento) {

    var todoBien = true;


    //Nombre:
    var vNombre = document.getElementById("nombre").value;
    if (vNombre == null || vNombre.length == 0 || /^\s+$/.test(vNombre) || !isNaN(vNombre)) {
        todoBien = false;
        document.getElementById("nombre").className = "textMal";
    }
    else {
        document.getElementById("nombre").className = "textBien";
    }


    //DNI:	
    var vDNI = document.getElementById("dni").value;
    var letras = ['T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N',
        'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'];

    if (!(/^\d{8}[A-Z]$/.test(vDNI))) {
        todoBien = false;
        document.getElementById("dni").className = "textMal";
    }
    else {
        document.getElementById("dni").className = "textBien";
    }

    if (vDNI.charAt(8) != letras[(vDNI.substring(0, 8)) % 23]) {
        todoBien = false;
        document.getElementById("dni").className = "textMal";
    }
    else {
        document.getElementById("dni").className = "textBien";
    }


    //Fecha de nacimiento DIA:
    var vFechaNacimientoDia = document.getElementById("fechaNacimientoDia").selectedIndex;
    if (vFechaNacimientoDia == null || vFechaNacimientoDia == 0) {
        todoBien = false;
        document.getElementById("fechaNacimientoDia").className = "textMal";
    }
    else {
        document.getElementById("fechaNacimientoDia").className = "textBien";
    }
    //Fecha de nacimiento MES:
    var vFechaNacimientoMes = document.getElementById("fechaNacimientoMes").selectedIndex;
    if (vFechaNacimientoMes == null || vFechaNacimientoMes == 0) {
        todoBien = false;
        document.getElementById("fechaNacimientoMes").className = "textMal";
    }
    else {
        document.getElementById("fechaNacimientoMes").className = "textBien";
    }
    //Fecha de nacimiento AÑO:
    var vFechaNacimientoAnio = document.getElementById("fechaNacimientoAnio").selectedIndex;
    if (vFechaNacimientoAnio == null || vFechaNacimientoAnio == 0) {
        todoBien = false;
        document.getElementById("fechaNacimientoAnio").className = "textMal";
    }
    else {
        document.getElementById("fechaNacimientoAnio").className = "textBien";
    }


    //Telefono:
    var vMovil = document.getElementById("movil").value;
    if (!(/^\d{9}$/.test(vMovil))) {
        todoBien = false;
        document.getElementById("movil").className = "textMal";
    }
    else {
        document.getElementById("movil").className = "textBien";
    }


    //email:
    var vEmail1 = document.getElementById("email1").value;
    var vEmail2 = document.getElementById("email2").value;

    //email 1
    if (!(/^\w+([-.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/.test(vEmail1))) {
        todoBien = false;
        document.getElementById("email1").className = "textMal";
    }
    else {
        document.getElementById("email1").className = "textBien";
    }

    //email 2
    if (!(/^\w+([-.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/.test(vEmail2))) {
        todoBien = false;
        document.getElementById("email2").className = "textMal";
    }
    else {
        document.getElementById("email2").className = "textBien";
    }

    //Comparacion email 1 y 2
    if (vEmail1 != vEmail2) {
        todoBien = false;
        document.getElementById("email2").className = "textMal";
    }


    //Nombre Via:
    var vViaNombre = document.getElementById("viaNombre").value;
    if (vViaNombre == null || vViaNombre.length == 0 || /^\s+$/.test(vViaNombre) || !isNaN(vViaNombre)) {
        todoBien = false;
        document.getElementById("viaNombre").className = "textMal";
    }
    else {
        document.getElementById("viaNombre").className = "textBien";
    }


    //Via Numero:	
    var vViaNumero = document.getElementById("viaNumero").value;
    if (vViaNumero == "" || isNaN(vViaNumero)) {
        todoBien = false;
        document.getElementById("viaNumero").className = "textMal";
    }
    else {
        document.getElementById("viaNumero").className = "textBien";
    }


    //Localidad:
    var vLocalidad = document.getElementById("localidad").value;
    if (vLocalidad == null || vLocalidad.length == 0 || /^\s+$/.test(vLocalidad) || !isNaN(vLocalidad)) {
        todoBien = false;
        document.getElementById("localidad").className = "textMal";
    }
    else {
        document.getElementById("localidad").className = "textBien";
    }


    //Codigo Postal:	
    var vCodigoPostal = document.getElementById("codigoPostal").value;
    if (vCodigoPostal.length != 5 || vCodigoPostal == "" || isNaN(vCodigoPostal)) {
        todoBien = false;
        document.getElementById("codigoPostal").className = "textMal";
    }
    else {
        document.getElementById("codigoPostal").className = "textBien";
    }


    //Provincia:
    var vProvincia = document.getElementById("provincia").selectedIndex;
    if (vProvincia == null || vProvincia == 0) {
        todoBien = false;
        document.getElementById("provincia").className = "textMal";
    }
    else {
        document.getElementById("provincia").className = "textBien";
    }


    //Si no ha habido ni un solo error, se ejecuta la siguiente funcion que se encarga de mostrar el formulario de los datos personales:
    if (!todoBien) {
        pideDatosPago();
    }
    else {
        document.getElementById("botonConfirmar").disabled = true;
    }
}




//FUNCION DE VALIDAR DATOS y PEDIR DATOS PAGO
function pideDatosPago(elEvento) {
/**/	document.getElementById("divTotal").className = "divsNo";
/**/	document.getElementById("divDatos").className = "divsNo";
    document.getElementById("divPago").className = "divsSi";
    document.getElementById("botonConfirmar").disabled = false;
}




//FUNCION DE VALIDACION DE DATOS PAGO:
function validaDatosPago(elEvento) {

    var todoBien = true;

    //Titular de la cuenta:
    var vTitular = document.getElementById("titular").value;
    if (vTitular == null || vTitular.length == 0 || /^\s+$/.test(vTitular) || !isNaN(vTitular)) {
        todoBien = false;
        document.getElementById("titular").className = "textMal";
    }
    else {
        document.getElementById("titular").className = "textBien";
    }


    //Tipo de tarjeta:
    var vTarjetas = document.getElementsByName("tarjetas");
    var seleccionado = false;
    for (var i = 0; i < vTarjetas.length; i++) {
        if (vTarjetas[i].checked) {
            seleccionado = true;
            //break;
        }
    }
    if (!seleccionado) {
        todoBien = false;
        document.getElementById("alertTipoDeTarjeta").className = "alertTipoDeTarjeta";
    }
    else {
        document.getElementById("alertTipoDeTarjeta").className = "";
    }


    //Numero de tarjeta:	
    var vNumeroTarjeta = document.getElementById("numeroTarjeta").value;
    if (vNumeroTarjeta.length != 16 || vNumeroTarjeta == "" || isNaN(vNumeroTarjeta)) {
        todoBien = false;
        document.getElementById("numeroTarjeta").className = "textMal";
    }
    else {
        document.getElementById("numeroTarjeta").className = "textBien";
    }


    //CVC de la tarjeta:	
    var vCvcTarjeta = document.getElementById("cvcTarjeta").value;
    if (vCvcTarjeta.length != 3 || vCvcTarjeta == "" || isNaN(vCvcTarjeta)) {
        todoBien = false;
        document.getElementById("cvcTarjeta").className = "textMal";
    }
    else {
        document.getElementById("cvcTarjeta").className = "textBien";
    }


    //Fecha de tarjeta MES:
    var vMesTarjeta = document.getElementById("mesTarjeta").selectedIndex;
    if (vMesTarjeta == null || vMesTarjeta == 0) {
        todoBien = false;
        document.getElementById("mesTarjeta").className = "textMal";
    }
    else {
        document.getElementById("mesTarjeta").className = "textBien";
    }
    //Fecha de tarjeta AÑO:
    var vAnioTarjeta = document.getElementById("anioTarjeta").selectedIndex;
    if (vAnioTarjeta == null || vAnioTarjeta == 0) {
        todoBien = false;
        document.getElementById("anioTarjeta").className = "textMal";
    }
    else {
        document.getElementById("anioTarjeta").className = "textBien";
    }


    //Si no ha habido ni un solo error, se ejecuta la siguiente funcion que se encarga de enviar los datos:
    if (todoBien) {
        validaDatosPagoYEnviaCarro();
    }
}

/* function filterItems() {
    var xhttp;
    xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        var filter_word = document.querySelector('#filter_word').value;
        console.log(filter_word)
    }
    xhttp.open("GET", "http://localhost:9090/item/?word="+filter_word, true);
    xhttp.send();
} */
function filterByWord() {
    var filter_word = document.getElementById("filter_word").value;
    var button = document.getElementById("button_search");

    button.onclick()

}

//FUNCION DE VALIDAR DATOS PAGO y ENVIAR DATOS
function validaDatosPagoYEnviaCarro(elEvento) {
    alert("Gracias por su compra, en 24 horas recibira su pedido\nAhora sera redirigido a la pagina de inicio.");
    window.location.reload()
}