<!DOCTYPE html>
<html lang="es">
<!-- <?php include $_SERVER['DOCUMENT_ROOT'] . '/WEB/config/config.php'; ?> -->

<head>
    <title>Cesta</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.11.5/css/jquery.dataTables.min.css">
    <link rel="stylesheet" href="styles.css">
</head>

<body>
    <div class="topnav">
        <a href="index.php">Inicio</a>
        <a href="productos.php">Productos</a>
        <a class="active" href="carrito.php">🛒</a>
        <a class="iniciarSesion" href="iniciarSesion.php">Iniciar Sesion</a>
    </div>
    <table id="tabla" class="table">
        <thead>
            <tr>
                <th class='text-center'>Producto</th>
                <th class='text-center'>Cantidad</th>
                <th class='text-center'>Precio</th>
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
                <td>a</td>
                <td>1</td>
                <td>10</td>
            </tr>
            <tr>
                <td>b</td>
                <td>2</td>
                <td>7,50</td>
            </tr>
            <tr>
                <td>c</td>
                <td>3</td>
                <td>2,50</td>
            </tr>
        </tbody>
        <tfoot>
            <td>Total</td>
            <td></td>
            <td>32,50€</td>
        </tfoot>
    </table>
</body>

</html>