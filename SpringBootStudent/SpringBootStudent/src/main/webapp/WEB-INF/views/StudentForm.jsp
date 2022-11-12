<%@ page isELIgnored="false" language="java"
    contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
    href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script
    src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script
    src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
    src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>

<title>Plese Fill up the Following Form </title>
</head>
<body>
    <div class="container">

        <div class="bg-success text-white">
            <h1 style="text-align: center; color: black; padding-top: 40px;">STUDENT
                 MANAGMENT PROJECT</h1>
            <br> <br>
        </div>
    </div>
    <br>
    <div class=" container bg-secondary text-white"
        style="margin-left: 190px; margin-right: 190px;">
        <div class="container" style="padding-top: 40px; padding-bottom: 40px">
            <form action="save" method="post">
                <h1 class="bg-secondary text-white">Please Fill Up The
                    Following credentials</h1>
                <hr style="background-color: black;">
                <br>
                <div class="form-group">
                    <input type="hidden" class="form-control" id="id"
                        placeholder="Enter Id" name="id" value="${student.id}" required>
                    <div class="valid-feedback">Valid.</div>
                    <div class="invalid-feedback">Please fill out this field.</div>
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" id="name"
                        placeholder="Enter Name" name="name"
                        value="${student.name}" required>
                    <div class="valid-feedback">Valid.</div>
                    <div class="invalid-feedback">Please fill out this field.</div>
                </div>
               
                <div class="form-group">
                    <input type="text" class="form-control" id="Department"
                        placeholder="Enter Department" name="Department" value="${student.Department}"
                        required>
                    <div class="valid-feedback">Valid.</div>
                    <div class="invalid-feedback">Please fill out this field.</div>
                </div>
                  <div class="form-group">
                    <input type="text" class="form-control" id="Country"
                        placeholder="Enter Country" name="Country" value="${student.Country}"
                        required>
                    <div class="valid-feedback">Valid.</div>
                    <div class="invalid-feedback">Please fill out this field.</div>
                </div>
                <div class="form-group form-check">
                    <input class="form-check-input" type="checkbox" name="remember"
                        required> I am Not a Robot.
                    <div class="valid-feedback">Valid.</div>
                    <div class="invalid-feedback">Check this checkbox to
                        continue.</div>

                </div>
                <button type="submit" class="btn btn-primary">Save</button>
            </form>
        </div>
    </div>
    <br>
    <div style="text-align: center;">
        <a href="/List" class="btn btn-secondary" type="button">Back to
            List</a>
    </div>
    <script>
        // Disable form submissions if there are invalid fields
        (function() {
            'use strict';
            window.addEventListener('load',
                    function() {
                        // Get the forms we want to add validation styles to
                        var forms = document
                                .getElementsByClassName('needs-validation');
                        // Loop over them and prevent submission
                        var validation = Array.prototype.filter.call(forms,
                                function(form) {
                                    form.addEventListener('submit', function(
                                            event) {
                                        if (form.checkValidity() === false) {
                                            event.preventDefault();
                                            event.stopPropagation();
                                        }
                                        form.classList.add('was-validated');
                                    }, false);
                                });
                    }, false);
        })();
    </script>
</body>
</html>