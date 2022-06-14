function borrarDatosEspecificos(){
    
    var txtUsuario =  document.getElementById("txtUsuario");
    txtUsuario.value = "";
    
    document.getElementById("txtContrasena").value = "";
}


function resetearFormularioLogin(){
    document.getElementById("formularioLogin").reset();
}