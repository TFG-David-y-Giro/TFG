<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>Iniciar sesion</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.11.5/css/jquery.dataTables.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="styles.css">
    <script src="funciones.js"></script>
    <script src='https://www.google.com/recaptcha/api.js?onload=myCallBack&render=explicit'></script>
    <script src='https://www.google.com/recaptcha/api.js?render=6Lf8KaYfAAAAAK0RaH6Ra_2QVDMnuijFiYZEEp_N'></script>
    <script src="https://www.google.com/recaptcha/api.js"></script>
    <script>
        grecaptcha.ready(function() {
            grecaptcha.execute('6Lf8KaYfAAAAAK0RaH6Ra_2QVDMnuijFiYZEEp_N', {
                    action: 'formulario'
                })
                .then(function(token) {
                    var recaptchaResponse = document.getElementById('recaptchaResponse');
                    recaptchaResponse.value = token;
                });
        });
    </script>
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
        <a href="cesta.php">🛒</a>
        <a class="derecha" href="iniciarSesion.php">Iniciar Sesion</a>
    </div>
    <?php if (!empty($message)) : ?> <p> <?= $message ?> </p>
    <?php endif; ?>
    <h1>Iniciar sesion</h1>

    <form action="iniciarSesion.php" method="POST">
        <?php $_SESSION['control'] = date('yGiz'); ?>
        <input name="usuario" type="text" placeholder="Introduce tu nombre de usuario">
        <input name="contraseña" type="password" autocomplete=”OFF” placeholder="Introduce tu contraseña">
        <input type="hidden" name="recaptcha_response" id="recaptchaResponse">
        <input type="hidden" name="control" id="control" value="<?php echo $_SESSION['control']; ?>" />
        <br />
        <input type="submit" value="Enviar">

        <br />
        <a href="index.php" type="button" class="btn btn-secondary">Volver a home</a>
        <br />
        <!-- <span><?php echo $login_err ?></span>
        <span><?php echo $captcha_err ?></span> -->
        <?php $control = isset($_POST['control']) ? intval($_POST['control']) : 0;
        if ($control !== intval($_SESSION['control']))
            exit(); ?>
    </form>
</body>

</html>