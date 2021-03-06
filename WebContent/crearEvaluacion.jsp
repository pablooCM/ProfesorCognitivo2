<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Crear evaluación</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

    <link rel="stylesheet" href="main.css">
</head>
<body>

    <div id="asignar-profesor">
        <form>
            <div class="form-group">
                <label for="curso">Curso</label>
                <Select class="form-control" id="curso">
                    <option value=""></option>
                    <option value="ti505">Diseño de software</option>
                    <option value="ti506">Diseño de software 2</option>
                </Select>
            </div>

            <div class="form-group">
                <label for="nombre">Nombre de la evaluación:</label>
                <input type="text" class="form-control" id="nombre">
            </div>

            <div class="form-group">
                <label for="puntaje">Puntaje:</label>
                <input type="number" class="form-control" id="puntaje">
            </div>

            <div class="form-group">
                <label for="porcentaje">Porcentaje:</label>
                <input type="number" class="form-control" id="porcentaje">
            </div>

            <div class="form-group">
                <label for="tipo">Tipo de evaluación</label>
                <Select class="form-control" id="tipo">
                    <option value=""></option>
                    <option value="formativa">Formativa</option>
                    <option value="sumativa">Sumativa</option>
                </Select>
            </div>

            <div class="form-group">
                <label for="descripcion">Descripcion:</label>
                <textarea class="form-control" name="descripcion" id="descripcion"></textarea>
            </div>

            <div class="form-group">
                <label for="fecha">Descripcion:</label>
                <input type="datetime-local" class="form-control" name="fecha" id="fecha"></input>
            </div>

            <div class="form-group">
                <label for="tiempo">Tiempo para completar:</label>
                <input type="number" class="form-control" id="tiempo">
            </div>

            <div class="form-group">
                <label for="tipo">Seleccione las preguntas</label>
                <Select class="form-control" id="tipo">
                    <option value=""></option>
                    <option value="pregunta1">Pregunta1</option>
                    <option value="pregunta2">Pregunta2</option>
                </Select>
            </div>

            <div class="form-group">
                <label for="tipo">Orden de las preguntas</label>
                <Select class="form-control" id="tipo">
                    <option value=""></option>
                    <option value="aleatorio">Aleatorio</option>
                    <option value="ordenadas">Ordenadas</option>
                </Select>
            </div>

            <button type="submit" class="btn btn-default">Asignar</button>
        </form>
    </div>

</body>
</html>
