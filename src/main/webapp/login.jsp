<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Inicio de sesión</title>
    <link href="css/styles.css" rel="stylesheet" />
    <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
</head>
<body class="bg-dark">
<div id="layoutAuthentication">
    <div id="layoutAuthentication_content">
        <main>
          <input type="hidden" id="status" value="<%= status %>">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-lg-5 ">
                        <div class="card shadow-lg border-0 rounded-lg mt-5">
                            <div class="card-header"><h3 class="text-center font-weight-light my-4">Inicio de sesión</h3></div>
                            <div class="card-body">
                               <form method="post" action="login">
                                   <div class="form-floating mb-3">
                                       <input class="form-control" name="email" id="inputEmail" type="email" placeholder="name@example.com" />
                                       <label for="inputEmail">Correo electrónico</label>
                                   </div>
                                   <div class="form-floating mb-3">
                                       <input class="form-control" name="password" id="inputPassword" type="password" placeholder="******" />
                                       <label for="inputPassword">Password</label>
                                   </div>
                                   <div class="d-flex align-items-center justify-content-between mt-4 mb-0">
                                       <button type="submit" class="btn btn-secondary">Login</button>
                                   </div>
                               </form>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </main>
    </div>
    <div id="layoutAuthentication_footer">
        <footer class="py-4 bg-light mt-auto">
            <div class="container-fluid px-4">
                <div class="d-flex align-items-center justify-content-between small">
                    <div class="text-muted">@vcra 2024</div>
                    <div class= "text-muted">Alkewallet, tu billetera digital</div>
                </div>
            </div>
        </footer>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
<script src="js/scripts.js"></script>
</body>
</html>
