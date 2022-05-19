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
        <a href="productos.php">Productos</a>
        <a class="active" href="cesta.php">🛒</a>
        <a class="derecha" href="iniciarSesion.php">Iniciar Sesion</a>
    </div>
    <div class="wrapper">
        <div class="container-fluid">
            <div class="row">
                <div>
                    <div class="mt-3 mb-3 clearfix">
                        <h2 class="pull-left">Cesta</h2><br><br>
                    </div>
                    <table id="tabla" class="table">
                        <thead>
                            <tr>
                                <th class='text-center'>Producto</th>
                                <th class='text-center'>Cantidad</th>
                                <th class='text-center'>Precio</th>
                                <th class='text-center'>Total</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>a</td>
                                <td>1</td>
                                <td>10€</td>
                                <td>10€</td>
                            </tr>
                            <tr>
                                <td>b</td>
                                <td>2</td>
                                <td>7,50€</td>
                                <td>15€</td>
                            </tr>
                            <tr>
                                <td>c</td>
                                <td>3</td>
                                <td>2,50€</td>
                                <td>7,50€</td>
                            </tr>
                            <tr>
                                <td>d</td>
                                <td>3</td>
                                <td>2,50€</td>
                                <td>7,50€</td>
                            </tr>
                            <tr>
                                <td>f</td>
                                <td>3</td>
                                <td>2,50€</td>
                                <td>7,50€</td>
                            </tr>
                            <tr>
                                <td>g</td>
                                <td>3</td>
                                <td>2,50€</td>
                                <td>7,50€</td>
                            </tr>
                            <tr>
                                <td>h</td>
                                <td>3</td>
                                <td>2,50€</td>
                                <td>7,50€</td>
                            </tr>
                            <tr>
                                <td>i</td>
                                <td>3</td>
                                <td>2,50€</td>
                                <td>7,50€</td>
                            </tr>
                            <tr>
                                <td>j</td>
                                <td>3</td>
                                <td>2,50€</td>
                                <td>7,50€</td>
                            </tr>
                            <tr>
                                <td>k</td>
                                <td>3</td>
                                <td>2,50€</td>
                                <td>7,50€</td>
                            </tr>
                            <tr>
                                <td>l</td>
                                <td>3</td>
                                <td>2,50€</td>
                                <td>7,50€</td>
                            </tr>
                            <tr>
                                <td>m</td>
                                <td>3</td>
                                <td>2,50€</td>
                                <td>7,50€</td>
                            </tr>
                        </tbody>
                        <tfoot>
                            <td>Total cesta</td>
                            <td></td>
                            <td></td>
                            <td>32,50€</td>
                        </tfoot>
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