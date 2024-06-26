<%@ page import="model.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
   
        <title>Alke Wallet</title>

        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css" rel="stylesheet" />
        <link href="css/styles.css" rel="stylesheet" />
        <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
    </head>

    <body class="sb-nav-fixed">
    <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
        <!-- Barra Navegador-->
        <a class="navbar-brand ps-3" href="index.jsp">ALkeWallet</a>
        <!-- Sidebar-->
        <button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0" id="sidebarToggle" href="#!"><i class="fas fa-bars"></i></button>

    </nav>
    <!-- Barra Lateral Navegador-->
    <div id="layoutSidenav">
        <div id="layoutSidenav_nav">
            <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                <div class="sb-sidenav-menu">
                    <div class="nav">
                        <div class="sb-sidenav-menu-heading">Mis operaciones</div>
                        <a class="nav-link" href="index.jsp">
                            <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                            Mi sesión
                        </a>
                        <ul class="sb-nav-link-icon">
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" id="navDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false"><i class="fas fa-user fa-fw"></i></a>
                                <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                                    <li><a class="dropdown-item" href="login.jsp">Cerrar sesión</a></li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
        </div>
            <!-- Contenido-->
            <div id="layoutSidenav_content">
               <main>
                    <!-- se le da la bienvenida al usuario por el nombre mediante user.getName-->
                        <!-- Detalle de saldo disponible y operaciones de deposito y retiro-->
                   <div class="container mt-3">
                       <% User user = (User) session.getAttribute("user");
                          String status = (String) session.getAttribute("status"); %>
                       <input type="hidden" id="status" value="<%= status %>">
                       <h2 class="text-center">Bienvenida  <%=user.getName() %> a tu AlkeWallet</h2>

                       <div class="d-flex justify-content-center mt-3">
                           <div class="card mb-3" style="max-width: 18rem;">
                               <div class="card-body">
                                   <form action="operation" method="post">
                                       <div class="form-group">
                                           <label for="amount">
                                               <h5>Ingrese cantidad:</h5>
                                           </label>
                                           <input type="number" id="amount" name="amount" class="form-control" />
                                           <% if(user != null) { %>
                                               <h5 class="mt-2">Saldo: $<%= user.getBalance() %> </h5>
                                           <% } %>
                                       </div>

                                       <!-- funciones depositar y retirar dinero-->
                                       <input type="hidden" name="operation" id="operation" />
                                       <div id="liveAlertPlaceholder">
                                           <ul class="list-group list-group-flush">
                                               <li class="list-group-item">
                                                   <button type="submit" id="Deposit"  class="btn btn-secondary w-100">
                                                       Depositar
                                                   </button>
                                               </li>
                                               <li class="list-group-item">
                                                   <button type="submit" id="Withdrawal"  class="btn btn-secondary w-100">
                                                       Retirar
                                                   </button>
                                               </li>
                                           </ul>
                                       </div>
                                   </form>
                                    <script>
                                       <!-- Setea el valor del input operation según el botón clickeado-->
                                         document.getElementById("Deposit").addEventListener("click", function() {
                                         document.getElementById("operation").value = "Depositar";
                                            });
                                         document.getElementById("Withdrawal").addEventListener("click", function() {
                                         document.getElementById("operation").value = "Retirar";
                                            });
                                        </script>
                               </div>
                           </div>
                       </div>
                   </div>
               </main>

                </main>

                <!-- Footer-->
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
