<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Resultado del IMC</title>
</head>
<body>

    <h1>Resultado del IMC</h1>

    <p>
        Peso:
        <strong>${resultadoImc.peso()}</strong> kg
    </p>

    <p>
        Altura:
        <strong>${resultadoImc.altura()}</strong> metros
    </p>

    <p>
        IMC numérico:
        <strong>${resultadoImc.imcNumerico()}</strong>
    </p>
    
    <img src="${resultadoImc.foto()}" alt="${resultadoImc.fotoDescripcion()}">

    <p>
        Clasificación:
        <strong>${resultadoImc.imcNominal()}</strong>
    </p>

    <a href="index.html">
        Realizar otro cálculo
    </a>

</body>
</html>