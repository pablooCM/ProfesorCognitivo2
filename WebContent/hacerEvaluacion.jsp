<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Registro de estudiantes</title>

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

    <link rel="stylesheet" href="main.css">
</head>
<body>

    <div id="registrar-estudiantes">


        <!-- acá hay que agregarle el action papu -->
        <form>

            <c:forEach var="pregunta" items="${DTO_Evaluacion.preguntas}">
                <!--
                     esta vara se fija si una pregunta es marque con x, si lo es, agrega n radiobuttons (según la cantidad de opciones que los mops pusieron cuando crearon la pregunta)
                -->
                <c:if test="${pregunta.tipo === 'marqueConX'}">
                    <h2>${pregunta.pregunta}</h2> <!-- pongo el titulo de la pregunta -->

                    <c:forEach var="opcion" items="${pregunta.opciones}">
                        <input type="radio" id="${opcion}" name="${opcion}" value="${opcion}" />
                    </c:forEach>
                </c:if>

                
                <c:if test="${pregunta.tipo === 'complete'}">
                    <h2>${pregunta.pregunta}</h2> <!-- pongo el titulo de la pregunta -->

                        <input type="text" id="${pregunta.respuesta}" name="${pregunta.respuesta}" value="${pregunta.respuesta}" /> <!-- no estoy seguro de esto maes -->
                </c:if>


            </c:forEach>

            <button type="submit" class="btn btn-default">Submit</button>
        </form>
    </div>

</body>
</html>
