<!DOCTYPE html>
<html lang="es">
<?php include $_SERVER['DOCUMENT_ROOT'] . '/TFG/WEB/config.php'; ?>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Cesta</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.11.5/css/jquery.dataTables.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="styles.css">
    <script src="funciones.js"></script>
    <style>
        .row {
            align-content: center;
            justify-content: center;
        }
    </style>
</head>
<header>
    <div>
        <h3 style="float: left;">
            TFG Miguel Angel Girona y David Pato
            <input type="select-one" autocomplete="off" tabindex="" id="ais-autocomplete-selectized" placeholder="Buscar..." style="width: 263.562px; opacity: 1; position: relative; left: 0px;" class="">
            <button type="button" class="active">🔎</button>
        </h3>
    </div>
</header>

<body>
    <div class="topnav">
        <a href="index.php">Inicio</a>
        <a class="active" href="productos.php">Productos</a>
        <a href="cesta.php">🛒</a>
        <a class="derecha" href="iniciarSesion.php">Iniciar Sesion</a>
    </div>
    <div class="wrapper">
        <div class="container-fluid">
            <div class="row">
                <div>
                    <div class="mt-3 mb-3 clearfix">
                        <h2 class="pull-left">Productos</h2><br><br>
                    </div>
                    <table id="tabla" class="table">
                        <thead>
                            <tr>
                                <th class='text-center'>Nombre</th>
                                <th class='text-center'>Descripcion</th>
                                <th class='text-center'>Precio</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <!-- <?php
                                    /*  $sql = "SELECT * FROM dbo.carritos WHERE con_eliminado=0 AND con_web=3 ORDER BY 1 DESC";
            $result = (odbc_exec($cnn, $sql));
            $row = odbc_fetch_array($result); 
            while ($rs_con = odbc_fetch_array($result)) {
                $arrayContactos[$rs_con['con_codigo']] = array(
                    'con_codigo' => !empty($rs_con['con_codigo']) ? $rs_con['con_codigo'] : 0,
                    'con_nombre' => !empty($rs_con['con_nombre']) ? $rs_con['con_nombre'] : '',
                    'con_telefono' => !empty($rs_con['con_telefono']) ? $rs_con['con_telefono'] : '',
                    'con_archivo' => !empty($rs_con['con_archivo']) ? $rs_con['con_archivo'] : '',
                    'con_mail' => !empty($rs_con['con_mail']) ? $rs_con['con_mail'] : '',
                    'con_ruta' => !empty($rs_con['con_ruta']) ? $rs_con['con_ruta'] : 0,
                    'con_comentarios' => !empty($rs_con['con_comentarios']) ? $rs_con['con_comentarios'] : '',
                    'con_provincia' => !empty($rs_con['con_provincia']) ? $rs_con['con_provincia'] : 1,
                );
            }
            foreach ($arrayContactos as $arrayContacto) {
                echo '<tr>';
                echo '<td>' . ($arrayContacto['con_codigo'])  . '</td>';
                echo '<td>' . ($arrayContacto['con_nombre']) . '</td>';
                echo '<td>' . ($arrayContacto['con_telefono']) . '</td>';
                echo '<td>' . ($arrayContacto['con_mail']) . '</td>';
                $sqlProvincia = "SELECT prov_nombre FROM dbo.provincia WHERE prov_codigo = " . $arrayContacto['con_provincia'];
                $resultProvincia = (odbc_exec($cnn, $sqlProvincia));
                $variableProvincia = odbc_result($resultProvincia, 1);
                echo '<td>' . $variableProvincia . '</td>';
                $numeroRuta = $arrayContacto['con_ruta']; //consigo numero de ruta
                $rutaArray = str_split($numeroRuta);
                echo '<td>';
                foreach ($rutaArray as $rutaIndividual) {
                    $sqlNombreRuta = "SELECT rut_nombre FROM dbo.rutas WHERE rut_codigo = " . $rutaIndividual; //consigo nombre de "123"
                    $resultRuta = (odbc_exec($cnn, $sqlNombreRuta));
                    $rutaFinal = odbc_result($resultRuta, 1);
                    echo $rutaFinal;
                    echo "<br/>";
                    echo "<br/>";
                }
                echo '</td>';
                echo '<td>' . ($arrayContacto['con_comentarios']) . '</td>';
                if ($arrayContacto['con_archivo'] == "") {
                    echo '<td></td>';
                } else {
                    echo '<td><img src="/mod_formulario3/carpeta_imagenes/' . ($arrayContacto['con_archivo']) . '" alt="" width="128" height="128" srcset=""></td>';
                }
                echo '</tr>';
            } */
                                    ?> -->
                            <tr>
                                <td>Producto 1</td>
                                <td>Este es el producto 1</td>
                                <td>10€</td>
                                <td></td>
                            </tr>
                            <tr>
                                <td>Producto 2</td>
                                <td>Este es el producto 2</td>
                                <td>7,50€</td>
                                <td></td>
                            </tr>
                            <tr>
                                <td>Producto 3</td>
                                <td>Este es el producto 3</td>
                                <td>2,50€</td>
                                <td></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
    </div>
</body>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>
<script>
    $(document).ready(function() {
        $('#tabla').DataTable({
            "scrollY": "autocomplete",
            "order": [
                [0, "asc"]
            ]
        });
    });
</script>

</html>