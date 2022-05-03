<!DOCTYPE html>
<html lang="es">
<?php include $_SERVER['DOCUMENT_ROOT'] . '/TFG/WEB/config.php'; ?>

<head>
    <title>Productos</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.11.5/css/jquery.dataTables.min.css">
    <link rel="stylesheet" href="styles.css">
    <script src="funciones.js"></script>
</head>

<body>
    <div class="topnav">
        <a href="index.php">Inicio</a>
        <a class="active" href="productos.php">Productos</a>
        <a href="cesta.php">🛒</a>
        <a class="iniciarSesion" href="iniciarSesion.php">Iniciar Sesion</a>
    </div>
    <h1>This is a Heading</h1>
    <p>This is a paragraph.</p>
</body>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>
<script>
    $(document).ready(function() {
        $('#tabla').DataTable({
            "scrollY": "400px",
            "order": [
                [0, "desc"]
            ]
        });
    });
</script>

</html>