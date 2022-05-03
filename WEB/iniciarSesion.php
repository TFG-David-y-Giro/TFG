<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>Iniciar sesion</title>
    <link rel="stylesheet" href="styles.css">
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

<body>
    <div class="topnav">
        <a href="index.php">Inicio</a>
        <a href="productos.php">Productos</a>
        <a href="cesta.php">🛒</a>
        <a class="iniciarSesion" href="iniciarSesion.php">Iniciar Sesion</a>
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