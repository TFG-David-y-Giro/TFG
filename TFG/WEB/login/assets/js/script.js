//Ejecutando funciones
window.onload = function () {
    getUsers();
}
document.querySelector('#boton_login').addEventListener("click", validarCredenciales);
document.querySelector('#button_register').addEventListener("click", postUser);
document.getElementById("btn__iniciar-sesion").addEventListener("click", iniciarSesion);
document.getElementById("btn__registrarse").addEventListener("click", register);
window.addEventListener("resize", anchoPage);

//Declarando variables
var formulario_login = document.querySelector(".formulario__login");
var formulario_register = document.querySelector(".formulario__register");
var contenedor_login_register = document.querySelector(".contenedor__login-register");
var caja_trasera_login = document.querySelector(".caja__trasera-login");
var caja_trasera_register = document.querySelector(".caja__trasera-register");
let respuesta = "";
const id = [];
const nombre_usuario = [];
const nombre = [];
const apellido = [];
const mail = [];
const password = [];


//FUNCIONES
function getUsers() {
    var xhttp;
    xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {

        respuesta = JSON.parse(this.responseText);

        console.log(respuesta)
        for (let i = 0; i < respuesta.length; i++) {
            id.push(respuesta[i].id)
            nombre_usuario.push(respuesta[i].username)
            nombre.push(respuesta[i].name)
            apellido.push(respuesta[i].surname)
            mail.push(respuesta[i].mail)
            password.push(respuesta[i].password)
        }
        //Creo variable y asocio al html
        /* var PRINC = document.getElementsByName("PRINC");
        PRINC[0].innerHTML = ''
        //Bucle para crear divs en funcion de la cantidad que exista
        for (let i = 0; i < respuesta.length; i++) {
            PRINC[0].innerHTML += '<div id="div' + i + '" name="DIVS" class="productos"></div>';
            var DIVSS = document.getElementsByName("DIVS");
            DIVSS[i].innerHTML = '<a id="imgG' + i + '" ><img id="imgP' + 0 + i + '" class="imagen" src="' + imgPeque[i] + '"style="width:225px; height:230px;"></a><div class="etiquetas"><b><span id="pro' + i + '">' + productos[i] + '</span>: <span id="pre' + i + '">' + precios[i] + '€</span></b></div><div class="stock">Hay en stock <span id="uni' + i + '">' + stock[i] + '</span> unidades,<br/>¿Cuantas quiere?: <input class="uniBien" style="margin-bottom:40px"type="number" id="uniUser' + i + '" name="uniUser" value="0" size="4" /></div>';
        } */

    }
    xhttp.open("GET", "http://localhost:9090/user", true);
    xhttp.send();
}

function validarCredenciales() {
    var nombre_usuario_html = document.querySelector('#usuario_login').value;
    var contraseña_html = document.querySelector('#contraseña_login').value;
    var bAcceso = false;
    //console.log(respuesta);
    for (var i = 0; i < respuesta.length; i++) {
        if (nombre_usuario_html == nombre_usuario[i] && contraseña_html == password[i]) {
            bAcceso = true;
            alert("Bienvenido " + nombre_usuario_html);

            localStorage.setItem('usuario', nombre_usuario_html);
            window.location.href = "../alreadyLogin/index_copy.html";
            /* "http://localhost:9090/user/login?username="+nombre_usuario_html+"&password="+contraseña_html; */
        }
        console.log(respuesta[i][1]);
        console.log(respuesta[i][5])
    }
    console.log(respuesta)
    console.log(bAcceso);
    console.log(contraseña_html);
    console.log(nombre_usuario_html);

}

/* function logearse() {
    var nombre_usuario = document.querySelector('#usuario_login').value;
    var contraseña = document.querySelector('#contraseña_login').value; 
    var bAcceso = false;

    if (validarCredenciales(nombre_usuario, contraseña) != null) {
        bAcceso = true
    }

    if (bAcceso == true) {
        alert("Bienvenido " + nombre_usuario);
    }

} */
function postUser() {
    var xhttp;
    xhttp = new XMLHttpRequest();
    var username_post = document.querySelector('#post_username').value;
    var name_post = document.querySelector('#post_name').value;
    var surname_post = document.querySelector('#post_surname').value;
    var mail_post = document.querySelector('#post_mail').value;
    var password_post = document.querySelector('#post_password').value;
    const Url = 'http://localhost:9090/user';
    const user = {
        username: username_post,
        name: name_post,
        surname: surname_post,
        mail: mail_post,
        password: password_post
    }
    console.log(user);
    $.ajax({
        type : "POST",
        contentType : "application/json",
        dataType : 'json',
        url : Url,
        data : JSON.stringify(user),
        timeout : 100000,
        headers : {
          'Accept' : 'application/json',
          'Content-Type' : 'application/json'
        },
        success : function(data) {
          console.log("SUCCESS: ", data);
        },
        error : function(e) {
          console.log("ERROR: ", e);
        },
        done : function(e) {
        }
    });
}



function anchoPage() {
    if (window.innerWidth > 850) {
        caja_trasera_register.style.display = "block";
        caja_trasera_login.style.display = "block";
    } else {
        caja_trasera_register.style.display = "block";
        caja_trasera_register.style.opacity = "1";
        caja_trasera_login.style.display = "none";
        formulario_login.style.display = "block";
        contenedor_login_register.style.left = "0px";
        formulario_register.style.display = "none";
    }
}
anchoPage();

function iniciarSesion() {
    if (window.innerWidth > 850) {
        formulario_login.style.display = "block";
        contenedor_login_register.style.left = "10px";
        formulario_register.style.display = "none";
        caja_trasera_register.style.opacity = "1";
        caja_trasera_login.style.opacity = "0";
    } else {
        formulario_login.style.display = "block";
        contenedor_login_register.style.left = "0px";
        formulario_register.style.display = "none";
        caja_trasera_register.style.display = "block";
        caja_trasera_login.style.display = "none";
    }
}

function register() {
    if (window.innerWidth > 850) {
        formulario_register.style.display = "block";
        contenedor_login_register.style.left = "410px";
        formulario_login.style.display = "none";
        caja_trasera_register.style.opacity = "0";
        caja_trasera_login.style.opacity = "1";
    } else {
        formulario_register.style.display = "block";
        contenedor_login_register.style.left = "0px";
        formulario_login.style.display = "none";
        caja_trasera_register.style.display = "none";
        caja_trasera_login.style.display = "block";
        caja_trasera_login.style.opacity = "1";
    }
}