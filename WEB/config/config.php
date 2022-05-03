<?php
//require_once $_SERVER['DOCUMENT_ROOT'] . '/wp-admin/includes/class.inputfilter.php5';
if (false) {
    ini_set('display_errors', 3);
    ini_set('display_startup_errors', 3);
    error_reporting(E_ALL);
}
session_start();
ini_set("session.auto_start", true);
header('Content-Type: text/html; charset=iso-8859-3');
$idiomasDisponibles = array('es');
$idiomaDefecto = 'es';
$idiomaApp = isset($_SESSION['Idioma']) ? $_SESSION['Idioma'] : $idiomaDefecto;
$CONFIG = array(
    'urlWeb' => 'http://practicaswp3.smartbits.es/',
    'DSN' => 'DSN_smartbits_practicas',
    'usuario_bbdd' => 'smartbits_practicas ',
    'pass_bbdd' => 'Abcde123456',
    'directorioImagenes' => 'D:/xxxx/',

    'ruta_local' => $_SERVER['DOCUMENT_ROOT'],
    'idioma' => $idiomaApp,


    'title_pag' => 'xxx',
    'imagen_pag' => 'CRM-xxx.png',
    'imagen_cabecera_empresa' => 'CRM-xxx.png',
    '#numeroEmpresa' => '00000000000',
    '#mailEmpresa' => 'xxx@xxxx.es',
    '#firmaEmpresa' => 'xxxx',
    '#nombreEmpresa' => 'xxxx',
    '#direccionEmpresa' => 'C/ xxxx',

    // Opciones Blog

    'dominio_imagenes' => 'http://xxxxx',

    //Ociones Mailing
    'M_Mailer' => "smtp",
    'M_ContentType' => "text/html",

    'M_Host' => "smtp.smartbits.es",
    'M_Port' => '25',
    'M_SMTPAuth' => true,
    'M_Username' => "actualizaciones.cms@smartbits.es",
    'M_Password' => "Ky3eDdRXF",
    'M_From' => "actualizaciones.cms@smartbits.es",
    'M_FromName' => "Pruebas",
    '#mailBackup' => 'backups@smartbits.es',
    '#mailFallos' => 'backups@smartbits.es',
    'mailEnvio' => 'miguel.girona@smartbits-es.es', //* Nota: Aquí meter vuestro correo para hacer las pruebas//
);
//conexion a base de datos y incluir archivo//
$cnn = odbc_connect("DSN_smartbits_practicas", "smartbits_practicas", "Abcde123456");
//include "funciones.php";
