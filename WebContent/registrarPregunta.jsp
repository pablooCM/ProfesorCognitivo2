<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Registrar una Pregunta</title>

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
                <label for="curso">Tema:</label>
                <Select class="form-control" id="curso">
                    <option value=""></option>
                    <option value="ti505">SOLID</option>
                    <option value="ti506">Axiomas de diseño</option>
                </Select>
            </div>

            <div class="form-group">
                <label for="curso">Subtemas:</label>
                <Select class="form-control" id="curso">
                    <option value=""></option>
                    <option value="ti505">S</option>
                    <option value="ti506">O</option>
                    <option value="ti506">L</option>
                </Select>
            </div>

            <div class="form-group">
                <label for="curso">Tipo de pregunta:</label>
                <Select class="form-control" id="curso">
                    <option value=""></option>
                    <option value="ti505">Marque con x</option>
                    <option value="ti506">Complete</option>
                    <option value="ti506">Desarrollo</option>
                </Select>
            </div>

            <div class="form-group">
                <label for="pregunta">Pregunta:</label>
                <input class="form-control" type="text" name="pregunta" id="pregunta">
            </div>

            <div class="form-group">
                <label for="descripcion">Descripcion:</label>
                <small>si es marque con x, ingrese las opciones separadas por una coma ","</small>
                <textarea class="form-control" name="descripcion" id="descripcion" placeholer="opcion 1, opcion 2, opcion 3"></textarea>
            </div>

            <div class="form-group">
                <small>Si es marque con x, ingresa la opción correcta acá</small>
                <input class="form-control" type="text" name="correcta" id="correcta">
            </div>

            <div class="form-group">
                <label for="ayuda">Ayuda:</label>
                <textarea class="form-control" name="ayuda" id="ayuda"></textarea>
            </div>


            <button type="submit" class="btn btn-default">Registrar</button>
        </form>
    </div>

</body>
</html>
