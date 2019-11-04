<%-- 
    Document   : planAlimenticio
    Created on : May 15, 2019, 11:42:24 PM
    Author     : pepe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

<head>
  <meta charset="utf-8" />
  <link rel="apple-touch-icon" sizes="76x76" href="../../assets/img/apple-icon.png">
  <link rel="icon" type="image/png" href="../../assets/img/favicon.png">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
  <title>
    Propuesta de plan de Alimentación
  </title>
  <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no' name='viewport' />
  <!--     Fonts and icons     -->
  <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons" />
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
  <!-- CSS Files -->
  <link href="../../assets/css/material-dashboard.css?v=2.0.2" rel="stylesheet" />
  <!-- CSS Just for demo purpose, don't include it in your project -->
  <link href="../../assets/demo/demo.css" rel="stylesheet" />
</head>

<body class="">
  <div class="wrapper ">
    <div class="sidebar" data-color="rose" data-background-color="black">
      <!--
        Tip 1: You can change the color of the sidebar using: data-color="purple | azure | green | orange | danger"

        Tip 2: you can also add an image using data-image tag
    -->
      <div class="logo">
        <img class="simple-text logo-normal" id="logoDashM" src="../../assets/img/yumk-min.png" />
        <img class="simple-text logo-normal" id="logoDash" src="../../assets/img/yumk1.png" />
      </div>

      <div class="sidebar-wrapper">
        <div class="user">
          <div class="photo">
            <img src="../../assets/img/avatar.png" />
          </div>
          <div class="user-info">
            <a data-toggle="collapse" href="#collapseExample" class="username">
              <span>
                  <%
                        if (session.getAttribute("nameNutricionista") == null) {
                              response.sendRedirect("../login.html");
                        } else {
                            out.println(session.getAttribute("nameNutricionista"));
                        }
                  %>
                <b class="caret"></b>
              </span>
            </a>
            <div class="collapse" id="collapseExample">
              <ul class="nav">
                <li class="nav-item">
                  <a class="nav-link" href="#">
                    <i class="material-icons">edit</i>
                    <span class="sidebar-normal"> Editar Perfil </span>
                  </a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="#">
                    <i class="material-icons">exit_to_app</i>
                    <span class="sidebar-normal"> Cerrar Sesión </span>
                  </a>
                </li>
              </ul>
            </div>
          </div>
        </div>
        <ul class="nav">
          <li class="nav-item active">
            <a class="nav-link" href="BlankN.jsp">
              <i class="material-icons">home</i>
              <p> Inicio </p>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="registroPaciente.jsp">
              <i class="material-icons">face</i>
              <p> Registrar Paciente </p>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="listaPacientes.jsp">
              <i class="material-icons">favorite_border</i>
              <p> Lista de Pacientes </p>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="agregarAlimento.jsp">
              <i class="material-icons">restaurant</i>
              <p> Registrar Alimento </p>
            </a>
          </li>
        </ul>
      </div>
    </div>


    <div class="main-panel">


      <!-- Navbar -->
      <nav class="navbar navbar-expand-lg navbar-transparent navbar-absolute fixed-top " id="navigation-example">
        <div class="container-fluid">
          <div class="navbar-wrapper">
            <div class="navbar-minimize">
              <button id="minimizeSidebar" class="btn btn-just-icon btn-white btn-fab btn-round">
                <i class="material-icons text_align-center visible-on-sidebar-regular">more_vert</i>
                <i class="material-icons design_bullet-list-67 visible-on-sidebar-mini">view_list</i>
              </button>
            </div>
            <a class="navbar-brand" href="#pablo">Generación de Plan Alimenticio</a>
          </div>
          <button class="navbar-toggler" type="button" data-toggle="collapse" aria-controls="navigation-index" aria-expanded="false" aria-label="Toggle navigation" data-target="#navigation-example">
            <span class="sr-only">Toggle navigation</span>
            <span class="navbar-toggler-icon icon-bar"></span>
            <span class="navbar-toggler-icon icon-bar"></span>
            <span class="navbar-toggler-icon icon-bar"></span>
          </button>
          <div class="collapse navbar-collapse justify-content-end">
            <ul class="navbar-nav">
              <li class="nav-item dropdown">
                <a class="nav-link" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                  <i class="material-icons">person</i>
                  <p class="d-lg-none d-md-block">
                    Cuenta
                  </p>
                </a>
                <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownMenuLink">
                  <a class="dropdown-item" href="#"><i class="material-icons">edit</i>Editar Perfil</a>
                  <a class="dropdown-item" href="#"><i class="material-icons">exit_to_app</i>Cerrar Sesión</a>
                </div>
              </li>
            </ul>
          </div>
        </div>
      </nav>
      <!-- End Navbar -->

      <!-- CONTENEDOR -->
      <div class="content">
        <div class="container-fluid">
          <div class="row">
            <div class="col-md-12 ml-auto mr-auto">
              <div class="page-categories">
                <h3 class="title text-center">Plan Alimenticio<span id="test"></span></h3>
                <br />
                <ul class="nav nav-pills nav-pills-info nav-pills-icons justify-content-center">
                  <li class="nav-item">
                    <a class="nav-link active" data-toggle="tab" href="#link1">
                      <i class="material-icons">filter_1</i> Lunes
                    </a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" data-toggle="tab" href="#link2">
                      <i class="material-icons">filter_2</i> Martes
                    </a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" data-toggle="tab" href="#link3">
                      <i class="material-icons">filter_3</i> Miércoles
                    </a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" data-toggle="tab" href="#link4">
                      <i class="material-icons">filter_4</i> Jueves
                    </a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" data-toggle="tab" href="#link5">
                      <i class="material-icons">filter_5</i> Viernes
                    </a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" data-toggle="tab" href="#link6">
                      <i class="material-icons">filter_6</i> Sábado
                    </a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" data-toggle="tab" href="#link7">
                      <i class="material-icons">filter_7</i> Domingo
                    </a>
                  </li>
                </ul>



                <div class="row">
                <div class="col-md-8">
                <div class="tab-content tab-space tab-subcategories">
                  <div class="tab-pane active" id="link1">
                    <div class="card">
                      <div class="card-header card-header-primary card-header-icon">
                        <div class="card-icon">
                          <i class="material-icons">restaurant</i>
                        </div>
                        <h4 class="card-title">Plan Alimenticio Lunes</h4>
                      </div>
                      <div class="card-body">
                        <div class="row">
                          <div class="col-md-4">
                            <ul class="nav nav-pills nav-pills-rose flex-column" id="MondayTabTitles">
                            </ul>
                          </div>
                          <div class="col-md-6">
                            <div class="tab-content" id="MondayContent">
                            </div>
                          </div>
                          
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="tab-pane" id="link2">
                    <div class="card">
                      <div class="card-header card-header-primary card-header-icon">
                        <div class="card-icon">
                          <i class="material-icons">restaurant</i>
                        </div>
                        <h4 class="card-title">Plan Alimenticio Martes</h4>
                      </div>
                      <div class="card-body">
                        <div class="row">
                          <div class="col-md-4">
                            <ul class="nav nav-pills nav-pills-rose flex-column" id="TuesdayTabTitles">
                            </ul>
                          </div>
                          <div class="col-md-6">
                            <div class="tab-content" id="TuesdayContent">
                            </div>
                          </div>
                          
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="tab-pane" id="link3">
                    <div class="card">
                      <div class="card-header card-header-primary card-header-icon">
                        <div class="card-icon">
                          <i class="material-icons">restaurant</i>
                        </div>
                        <h4 class="card-title">Plan Alimenticio Miércoles</h4>
                      </div>
                      <div class="card-body">
                        <div class="row">
                          <div class="col-md-4">
                            <ul class="nav nav-pills nav-pills-rose flex-column"  id="WednesdayTabTitles">
                            </ul>
                          </div>
                          <div class="col-md-6">
                            <div class="tab-content" id="WednesdayContent">
                            </div>
                          </div>
                          
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="tab-pane" id="link4">
                    <div class="card">
                      <div class="card-header card-header-primary card-header-icon">
                        <div class="card-icon">
                          <i class="material-icons">restaurant</i>
                        </div>
                        <h4 class="card-title">Plan Alimenticio Jueves</h4>
                      </div>
                      <div class="card-body">
                        <div class="row">
                          <div class="col-md-4">
                            <ul class="nav nav-pills nav-pills-rose flex-column"  id="ThursdayTabTitles">
                            </ul>
                          </div>
                          <div class="col-md-6">
                            <div class="tab-content" id="ThursdayContent">
                            </div>
                          </div>
                          
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="tab-pane" id="link5">
                    <div class="card">
                      <div class="card-header card-header-primary card-header-icon">
                        <div class="card-icon">
                          <i class="material-icons">restaurant</i>
                        </div>
                        <h4 class="card-title">Plan Alimenticio Viernes</h4>
                      </div>
                      <div class="card-body">
                        <div class="row">
                          <div class="col-md-4">
                            <ul class="nav nav-pills nav-pills-rose flex-column"  id="FridayTabTitles">
                            </ul>
                          </div>
                          <div class="col-md-6">
                            <div class="tab-content" id="FridayContent">
                            </div>
                          </div>
                          
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="tab-pane" id="link6">
                    <div class="card">
                      <div class="card-header card-header-primary card-header-icon">
                        <div class="card-icon">
                          <i class="material-icons">restaurant</i>
                        </div>
                        <h4 class="card-title">Plan Alimenticio Sábado</h4>
                      </div>
                      <div class="card-body">
                        <div class="row">
                          <div class="col-md-4">
                            <ul class="nav nav-pills nav-pills-rose flex-column"  id="SaturdayTabTitles">
                            </ul>
                          </div>
                          <div class="col-md-6">
                            <div class="tab-content" id="SaturdayContent">
                            </div>
                          </div>
                          
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="tab-pane" id="link7">
                    <div class="card">
                      <div class="card-header card-header-primary card-header-icon">
                        <div class="card-icon">
                          <i class="material-icons">restaurant</i>
                        </div>
                        <h4 class="card-title">Plan Alimenticio Domingo</h4>
                      </div>
                      <div class="card-body">
                        <div class="row">
                          <div class="col-md-4">
                            <ul class="nav nav-pills nav-pills-rose flex-column"  id="SundayTabTitles">
                            </ul>
                          </div>
                          <div class="col-md-6">
                            <div class="tab-content" id="SundayContent">
                            </div>
                          </div>
                          
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
                </div>
                    <div class="col-md-4">
                        <div class="card">
                            <div class="card-header card-header-primary card-header-icon">
                                <div class="card-icon">
                          <i class="material-icons">playlist_add</i>
                        </div>
                                <h4 class="card-title">Agregar Alimentos</h4>
                            </div>
                            <div class="card-body">
                                  <div class="row">
                                    <div class="col-sm-12">
                                      <div class="input-group form-control-lg">
                                        <div class="input-group-prepend">
                                          <span class="input-group-text">
                                            <i class="material-icons">fastfood</i>
                                          </span>
                                        </div>
                                        <div class="form-group">
                                          <select class="selectpicker" data-style="select-with-transition" title="alimentos" id="alimentos">
                                          </select>
                                        </div>
                                      </div>
                                      <div class="input-group form-control-lg">
                                        <div class="input-group-prepend">
                                          <span class="input-group-text">
                                            <i class="material-icons">kitchen</i>
                                          </span>
                                        </div>
                                        <div class="form-group">
                                          <label for="exampleInput1" class="bmd-label-floating">Cantidad</label>
                                          <input type="text" class="form-control" id="cantidadA" name="v">
                                        </div>                                          
                                        <span class="btn btn-primary btn-fab btn-fab-mini btn-round" id="addA">
                                          <i class="material-icons">add</i>
                                        </span>
                                      </div>
                                    </div>
                                  </div>
                                 <div class="row">
                                    <div class="col-sm-12">
                                      <div class="progress-container progress-info">
                                        <span class="progress-badge">Proteína 8 de 10 gramos (80%)</span>
                                        <div class="progress">
                                            <div class="progress-bar progress-bar-rose" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: 80%;">
                                            </div>
                                        </div>
                                      </div>
                                    </div>
                                  </div>
                                  <div class="row">
                                    <div class="col-sm-12">
                                      <div class="progress-container progress-info">
                                        <span class="progress-badge">Carbohidratos 8 de 10 gramos (80%)</span>
                                        <div class="progress">
                                            <div class="progress-bar progress-bar-primary" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: 80%;">
                                            </div>
                                        </div>
                                      </div>
                                    </div>
                                  </div>
                                  <div class="row">
                                    <div class="col-sm-12">
                                      <div class="progress-container progress-info">
                                        <span class="progress-badge">Lípidos 8 de 10 gramos (80%)</span>
                                        <div class="progress">
                                            <div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: 80%;">
                                            </div>
                                        </div>
                                      </div>
                                    </div>
                                  </div>
                                  <div class="row">
                                    <div class="col-sm-12">
                                      <input type="submit" id="subB" class="btn btn-finish btn-fill btn-rose btn-wd" name="finish" value="Guardar">
                                      </div>
                                  </div>
                              </div>
                        </div>
                    </div>


                </div>
            </div>
          </div>
        </div>
      </div>
      <footer class="footer">
        <div class="container-fluid">
          YUMK 2019
        </div>
      </footer>
    </div>
  </div>

  <!-- CONFIGURACION GRAFICA -->
  <div class="fixed-plugin">
    <div class="dropdown show-dropdown">
      <a href="#" data-toggle="dropdown">
        <i class="fa fa-cog fa-2x"> </i>
      </a>
      <ul class="dropdown-menu">
        <li class="header-title"> Seleción de Barra Lateral</li>
        <li class="adjustments-line">
          <a href="javascript:void(0)" class="switch-trigger active-color">
            <div class="badge-colors ml-auto mr-auto">
              <span class="badge filter badge-purple" data-color="purple"></span>
              <span class="badge filter badge-azure" data-color="azure"></span>
              <span class="badge filter badge-rose active" data-color="rose"></span>
            </div>
            <div class="clearfix"></div>
          </a>
        </li>
        <li class="header-title">Fonodo de Barra Lateral</li>
        <li class="adjustments-line">
          <a href="javascript:void(0)" class="switch-trigger background-color">
            <div class="ml-auto mr-auto">
              <span class="badge filter badge-black active" data-background-color="black"></span>
              <span class="badge filter badge-white" data-background-color="white"></span>
            </div>
            <div class="clearfix"></div>
          </a>
        </li>
        <li class="adjustments-line">
          <a href="javascript:void(0)" class="switch-trigger">
            <p>Barra Lateral Mini</p>
              <div class="togglebutton switch-sidebar-mini">
                <label>
                  <input type="checkbox">
                  <span class="toggle"></span>
                </label>
              </div>
            <div class="clearfix"></div>
          </a>
        </li>
      </ul>
    </div>
  </div>
  <!--   Core JS Files   -->
  <script src="../../assets/js/core/jquery.min.js" type="text/javascript"></script>
  <script src="../../assets/js/core/popper.min.js" type="text/javascript"></script>
  <script src="../../assets/js/core/bootstrap-material-design.min.js" type="text/javascript"></script>
  <script src="../../assets/js/plugins/perfect-scrollbar.jquery.min.js"></script>
  <!-- Plugin for the momentJs  -->
  <script src="../../assets/js/plugins/moment.min.js"></script>
  <!--  Plugin for Sweet Alert -->
  <script src="../../assets/js/plugins/sweetalert2.js"></script>
  <!-- Forms Validations Plugin -->
  <script src="../../assets/js/plugins/jquery.validate.min.js"></script>
  <!--  Plugin for the Wizard, full documentation here: https://github.com/VinceG/twitter-bootstrap-wizard -->
  <script src="../../assets/js/plugins/jquery.bootstrap-wizard.js"></script>
  <!--	Plugin for Select, full documentation here: http://silviomoreto.github.io/bootstrap-select -->
  <script src="../../assets/js/plugins/bootstrap-selectpicker.js"></script>
  <!--  Plugin for the DateTimePicker, full documentation here: https://eonasdan.github.io/bootstrap-datetimepicker/ -->
  <script src="../../assets/js/plugins/bootstrap-datetimepicker.min.js"></script>
  <!--  DataTables.net Plugin, full documentation here: https://datatables.net/    -->
  <script src="../../assets/js/plugins/jquery.dataTables.min.js"></script>
  <!--	Plugin for Tags, full documentation here: https://github.com/bootstrap-tagsinput/bootstrap-tagsinputs  -->
  <script src="../../assets/js/plugins/bootstrap-tagsinput.js"></script>
  <!-- Plugin for Fileupload, full documentation here: http://www.jasny.net/bootstrap/javascript/#fileinput -->
  <script src="../../assets/js/plugins/jasny-bootstrap.min.js"></script>
  <!--  Full Calendar Plugin, full documentation here: https://github.com/fullcalendar/fullcalendar    -->
  <script src="../../assets/js/plugins/fullcalendar.min.js"></script>
  <!-- Vector Map plugin, full documentation here: http://jvectormap.com/documentation/ -->
  <script src="../../assets/js/plugins/jquery-jvectormap.js"></script>
  <!--  Plugin for the Sliders, full documentation here: http://refreshless.com/nouislider/ -->
  <script src="../../assets/js/plugins/nouislider.min.js"></script>
  <!-- Include a polyfill for ES6 Promises (optional) for IE11, UC Browser and Android browser support SweetAlert -->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/core-js/2.4.1/core.js"></script>
  <!-- Library for adding dinamically elements -->
  <script src="../../assets/js/plugins/arrive.min.js"></script>
  <!-- Chartist JS -->
  <script src="../../assets/js/plugins/chartist.min.js"></script>
  <!--  Notifications Plugin    -->
  <script src="../../assets/js/plugins/bootstrap-notify.js"></script>
  <!-- Control Center for Material Dashboard: parallax effects, scripts for the example pages etc -->
  <script src="../../assets/js/material-dashboard.js?v=2.0.2" type="text/javascript"></script>
  <!-- Material Dashboard DEMO methods, don't include it in your project! -->
  <script src="../../assets/demo/demo.js"></script>
  
<script>
    
        $.get("../../getProposePlan", function(responseJson) {    // Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response JSON...
            
            $.each(responseJson, function(index, item) { // Iterate over the JSON array.
                var numeroComidas = 0;
                $.each(item, function(index2, item2) { // Iterate over the JSON array.
                    numeroComidas = numeroComidas + 1;
                    if (numeroComidas === 1) {
                        var text2 = "<div class='tab-pane active' id='link";
                    } else {
                        var text2 = "<div class='tab-pane' id='link";
                    }
                    text2 = text2 + (index+1);
                    text2 = text2 + "-" + (index2+1) + "'>";
                    text2 = text2 + "<div class='input-group form-control-lg'><div class='input-group-prepend'><span class='input-group-text'><i class='material-icons'>alarm</i></span></div><div class='form-group'><label for='exampleInput1' class='bmd-label-floating'>Hora de Comida</label>";
                    text2 = text2 + "<input type='text' class='form-control timepicker' id='comida" + (index+1) +"-"+(index2+1)+"' value='10:05'/></div></div>";
                    text2 = text2 + "<input type='text' value='";
                   
                    text2 = text2 + "' class='form-control tagsinput' data-color='info' id='Alink";
                    text2 = text2 + (index+1) +"-"+(index2+1)+"' name='comida";
                    text2 = text2 + (index+1) +"-"+(index2+1)+"'></div>";
                              //Alink con el index y luego index2
                       
                        if (index === 0) {                                
                            $("#MondayContent").append(text2);
                        } else if (index === 1) {
                            $("#TuesdayContent").append(text2);
                        } else if (index === 2) {                                
                            $("#WednesdayContent").append(text2);
                        } else if (index === 3) {                                
                            $("#ThursdayContent").append(text2);
                        } else if (index === 4) {                                
                            $("#FridayContent").append(text2);
                        } else if (index === 5) {                                
                            $("#SaturdayContent").append(text2);
                        } else if (index === 6) {                                
                            $("#SundayContent").append(text2);
                        } 
                        $("#Alink"+(index+1) +"-"+(index2+1)).tagsinput("refresh");
                        //$("#Alink"+(index+1) +"-"+(index2+1)).addClass("info-badge");
                        
                         $.each(item2, function(index3, item3) { // Iterate over the JSON array.
                        //$('#link' + (item+1)).append();
                            //console.log(item3.nombre + "(" + index2 + ", " + index3 +  ")") ;
                            text2 = text2 + " , " + item3.nombre;
                            var qty = item3.quantity*item3.cantidad;
                            $("#Alink"+(index+1) +"-"+(index2+1)).tagsinput('add',qty + " " + item3.unidad + " " +  item3.nombre+"("+item3.idalimento+")");
                            
                            /*
                            $("#Alink"+(index+1) +"-"+(index2+1)).tagsinput({
                                itemValue: 'id',
                                  itemText: 'text'
                              });
                            $("#Alink"+(index+1) +"-"+(index2+1)).tagsinput('add',{id: item3.idalimento,text: item3.nombre});
                         */
                        });
                        
                });
                
                if (numeroComidas === 3) {
                    for (var i = 1; i <= numeroComidas; i++) {
                        if (i===1) {
                            var text = "<li class='nav-item'><a class='nav-link active' data-toggle='tab' href='#link"+(index+1)+"-"+ i+"'>";    
                        }else {
                            var text = "<li class='nav-item'><a class='nav-link' data-toggle='tab' href='#link"+(index+1)+"-"+ i+"'>";
                        }
                        if (i===1) {
                            text = text + "Desayuno</a></li>";
                        } else if (i===2) {
                            text = text + "Comida</a></li>";
                        }else if (i===3) {
                            text = text + "Cena</a></li>";
                        }
                        if (index === 0) {                                
                            $("#MondayTabTitles").append(text);
                        } else if (index === 1) {
                            $("#TuesdayTabTitles").append(text);
                        } else if (index === 2) {                                
                            $("#WednesdayTabTitles").append(text);
                        } else if (index === 3) {                                
                            $("#ThursdayTabTitles").append(text);
                        } else if (index === 4) {                                
                            $("#FridayTabTitles").append(text);
                        } else if (index === 5) {                                
                            $("#SaturdayTabTitles").append(text);
                        } else if (index === 6) {                                
                            $("#SundayTabTitles").append(text);
                        }
                    }
                    
                }
            });
            $('.tag').css('background','#00bcd4');
            
        });
              
  </script>  
  <script>
    var selection = "Alink1-1";
    //$('#test').text(selection);
    $(document).on('click', '.nav-link', function () {
      selection = $(this).attr('href').replace('#','A');
      if(selection.indexOf('-')<0){
        selection=selection+"-1";
      }
      //$('#test').text(selection);
      //$('#paciente').text(info[1]);
    });

    $(document).ready(function() {
      $('#logoDashM').hide();
      $().ready(function() {
        $sidebar = $('.sidebar');

        $sidebar_img_container = $sidebar.find('.sidebar-background');

        $full_page = $('.full-page');

        $sidebar_responsive = $('body > .navbar-collapse');

        window_width = $(window).width();

        fixed_plugin_open = $('.sidebar .sidebar-wrapper .nav li.active a p').html();

        if (window_width > 767 && fixed_plugin_open == 'Dashboard') {
          if ($('.fixed-plugin .dropdown').hasClass('show-dropdown')) {
            $('.fixed-plugin .dropdown').addClass('open');
          }

        }

        $('#addA').click( function(){          
          //var list = $('#Alink1-1').val();
          //$('#alimEv').val(list+','+algo);
          
          //$('#'+selection).tagsinput('add', {id:$('#alimentos').val(),text:$("#alimentos option:selected").text()});
        
        $('#'+selection).tagsinput('add', 
            (parseFloat($("#cantidadA").val())+ parseFloat($("#alimentos option:selected").getAttribute("data-qty")))+ " " +
            $("#alimentos option:selected").getAttribute("data-unidad") + " " +
            $("#alimentos option:selected").text()+"("+$('#alimentos').val()+")");
            $('.tag').css('background','#00bcd4');
          //$('#alimEv').val(list+','+$('#alimentos').val()); {"value":item3.idalimento,"text":item3.nombre}
        });

      
        $('.fixed-plugin a').click(function(event) {
          // Alex if we click on switch, stop propagation of the event, so the dropdown will not be hide, otherwise we set the  section active
          if ($(this).hasClass('switch-trigger')) {
            if (event.stopPropagation) {
              event.stopPropagation();
            } else if (window.event) {
              window.event.cancelBubble = true;
            }
          }
        });

        $('.fixed-plugin .active-color span').click(function() {
          $full_page_background = $('.full-page-background');

          $(this).siblings().removeClass('active');
          $(this).addClass('active');

          var new_color = $(this).data('color');

          if ($sidebar.length != 0) {
            $sidebar.attr('data-color', new_color);
          }

          if ($full_page.length != 0) {
            $full_page.attr('filter-color', new_color);
          }

          if ($sidebar_responsive.length != 0) {
            $sidebar_responsive.attr('data-color', new_color);
          }
        });

        $('.fixed-plugin .background-color .badge').click(function() {
          $(this).siblings().removeClass('active');
          $(this).addClass('active');

          var new_color = $(this).data('background-color');

          if ($sidebar.length != 0) {
            $sidebar.attr('data-background-color', new_color);
          }
        });

        
        $('.switch-sidebar-mini input').change(function() {
          $body = $('body');

          $input = $(this);

          if (md.misc.sidebar_mini_active == true) {
            $('body').removeClass('sidebar-mini');
            $('#logoDash').show('slow');
            $('#logoDashM').hide('slow');
            md.misc.sidebar_mini_active = false;

            $('.sidebar .sidebar-wrapper, .main-panel').perfectScrollbar();

          } else {

            $('.sidebar .sidebar-wrapper, .main-panel').perfectScrollbar('destroy');

            setTimeout(function() {
              $('body').addClass('sidebar-mini');
              $('#logoDash').hide('slow');
              $('#logoDashM').show('slow');
              md.misc.sidebar_mini_active = true;
            }, 300);
          }

          // we simulate the window Resize so the charts will get updated in realtime.
          var simulateWindowResize = setInterval(function() {
            window.dispatchEvent(new Event('resize'));
          }, 180);

          // we stop the simulation of Window Resize after the animations are completed
          setTimeout(function() {
            clearInterval(simulateWindowResize);
          }, 1000);

        });
      });
    });
  </script>
  <script>
    $(document).ready(function() {
      // initialise Datetimepicker and Sliders
      md.initFormExtendedDatetimepickers();
      if ($('.slider').length != 0) {
        md.initSliders();
      }
    });
  </script>
  <script>
        $.get("../../getAllFood", function(responseJson) {    // Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response JSON...
            $.each(responseJson, function(index, item) { // Iterate over the JSON array.
                ($("#alimentos")).append("<option data-unidad='" + item.unidad +"' data-qty='" + item.cantidad + "' value=" + item.idalimento +">" + item.nombre + "</option>");
            });
            $('#alimentos').selectpicker('refresh');
        });
      
  </script>
  <script>
    $("#subB").click(function(){
        var result = [];
        for (var i = 1; i <= 7; i++) {
            var x;
            
            if (i === 1) { 
                x = $("#MondayContent > div").length;
            } else if (i === 2) {
                x = $("#TuesdayContent > div").length;
            } else if (i === 3) {                                
                x = $("#WednesdayContent > div").length;
            } else if (i === 4) {
                x = $("#ThursdayContent > div").length;
            } else if (i === 5) {
                x = $("#FridayContent > div").length;
            } else if (i === 6) {                                
                x = $("#SaturdayContent > div").length;
            } else if (i === 7) {                                
                x = $("#SundayContent > div").length;
            }  
            var resultAux2 = [];
            for (var j = 1; j <= x; j++) {
                var aux = $("#link" + i + "-"+ j).find(".bootstrap-tagsinput").find(".tag");
                var resultAux = [];
                $.each(aux, function(index, item) {
                    var cadena = item.innerText+"*" + $("#comida" + i + "-" + j).val();
                    resultAux.push(cadena);
                });
                resultAux2.push(resultAux);
            }
            result.push(resultAux2);
        }
        var myJSON = JSON.stringify(result);
        window.location.replace("../../SaveMealPlan?infoPlan=" +myJSON);
    });
  </script>
  </body>
</html>