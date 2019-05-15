<%-- 
    Document   : seguimientoPaciente
    Created on : May 12, 2019, 5:00:22 PM
    Author     : pepe
--%>

<%@page import="mx.ipn.www.finalproject.model.Alimento"%>
<%@page import="java.util.List"%>
<%@page import="mx.ipn.www.finalproject.model.Usuario"%>
<%@page import="mx.ipn.www.finalproject.model.Paciente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="es">

<head>
    <%Paciente paciente = (Paciente) session.getAttribute("pacienteGeneralInformation");%>
    <%Usuario usuario = (Usuario) session.getAttribute("pacienteGIUsuario");%>
    <%List<Alimento> alimentosEvitados = (List<Alimento>) session.getAttribute("pacienteGIAlimentosEvitados");%>
    
  <meta charset="utf-8" />
  <link rel="apple-touch-icon" sizes="76x76" href="../../assets/img/apple-icon.png">
  <link rel="icon" type="image/png" href="../../assets/img/favicon.png">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
  <title>
    Seguimiento del paciente
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
                Dr. Tania Andrew
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
          <li class="nav-item">
            <a class="nav-link" href="BlankN.html">
              <i class="material-icons">home</i>
              <p> Inicio </p>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="registroPaciente.html">
              <i class="material-icons">face</i>
              <p> Registrar Paciente </p>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="listaPacientes.html">
              <i class="material-icons">favorite_border</i>
              <p> Lista de Pacientes </p>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="agregarAlimento.html">
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
            <a class="navbar-brand" href="#pablo">Seguimiento de Paciente</a>
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
            <div class="col-md-12 col-12 mr-auto ml-auto">
              <div class="card">
                <div class="card-header card-header-info card-header-icon">
                  <div class="card-icon">
                    <i class="material-icons">face</i>
                  </div>
                  <h4 class="card-title">Información del Paciente</h4>
                </div>
                
                <div class="card-body">
                  <div class="row">
                    <div class="col-md-6">
                        <p><i class="material-icons">sentiment_satisfied_alt</i><%out.print(paciente.getNombre());%></p>
                      <p><i class="material-icons">call</i><%out.print(paciente.getTelefono());%></p>
                      <p><i class="material-icons">email</i><%out.print(usuario.getCorreo());%></p>
                      <p><i class="material-icons">room</i><%out.print(paciente.getDireccion());%></p>
                      <p><i class="material-icons">local_dining</i>Dificultades para Comer: <%if (paciente.getDificultadesaliment().equals("")|paciente.getDificultadesaliment()==null) {
                                out.print("ninguna");
                            } else {
                                out.print(paciente.getDificultadesaliment());
                            }
                          %></p>
                      <p><i class="material-icons">fastfood</i>Alimentos Evitados: <%
                                if (alimentosEvitados.size()>0) {
                                    Integer a = new Integer(1);
                                    for (Alimento alimentoEvitadoObject : alimentosEvitados) {
                                        if (a==1) {
                                            out.print(alimentoEvitadoObject.getNombre());
                                        } else {
                                            out.print(", "+alimentoEvitadoObject.getNombre());
                                        }
                                        a++;
                                    }
                                } else {
                                    out.print("ninguno");
                                }%></p>
                    </div>
                    <div class="col-md-6">
                      <p><i class="material-icons">accessibility</i><%out.print(paciente.getTelefono());%> cm</p>
                      <p><i class="material-icons">straighten</i>Cir. Braquial: <%out.print(paciente.getCirbraquial());%> cm</p>
                      <p><i class="material-icons">straighten</i>Cir. Pantorrilla: <%out.print(paciente.getCirpantorrilla());%> cm</p>
                      <p><i class="material-icons">fitness_center</i><%
                            switch(paciente.getActividadfisica()) {
                                case 0:
                                    out.print("Actividad fisica nula");
                                    break;
                                case 1:
                                    out.print("Actividad fisica ligera");
                                    break;
                                case 2:
                                    out.print("Actividad fisica normal");
                                    break;
                                case 3:
                                    out.print("Actividad fisica alta");
                                    break;                                
                            }
                      %></p>
                      <p><i class="material-icons">favorite_border</i>Enfermedades: <%

                            if (paciente.getEnfermedades() == null | paciente.getEnfermedades().equals("")) {
                                out.print("ninguna");
                            } else {
                                out.print(paciente.getEnfermedades());
                            }
                          %></p>
                      <p><i class="material-icons">favorite</i>Tratamiento: <%
                            if (paciente.getTratamiento() == null | paciente.getTratamiento().equals("")) {
                                out.print("ninguna");
                            } else {
                                out.print(paciente.getTratamiento());
                            }
                          %></p>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-md-8 col-12 mr-auto ml-auto">
              <div class="card">
                <div class="card-header card-header-rose card-header-icon">
                  <div class="card-icon">
                    <i class="material-icons">show_chart</i>
                  </div>
                  <h4 class="card-title">Avance</h4>
                </div>
                <div class="card-body">
                  <div class="row">
                    <div class="col-md-12">
                      <div id="colouredBarsChart" class="ct-chart"></div>
                    </div>
                  </div>
                </div>
                <div class="card-footer">
                  <div class="row">
                    <div class="col-md-12">
                      <i class="fa fa-circle text-info"></i> Peso
                      <i class="fa fa-circle text-warning"></i> Músculo
                      <i class="fa fa-circle text-danger"></i> Grasa
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <div class="col-md-4">
              <div class="row">
                <div class="card">
                  <div class="card-header card-header-primary card-header-icon">
                    <div class="card-icon">
                      <i class="material-icons">update</i>
                    </div>
                    <h4 class="card-title">Ajustar Plan Alimenticio</h4>
                  </div>
                  <div class="card-body">
                    <div class="row">
                      <div class="col-md-12">
                        <p>Fecha Establecida de Ajuste: 24/01/2019</p>
                        <center><input type="submit" class="btn btn-finish btn-fill btn-rose btn-wd" name="finish" value="Ajustar"></center>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <div class="row">
                <div class="card card-chart">
                  <div class="card-header card-header-info">
                    <div id="roundedLineChart" class="ct-chart"></div>
                  </div>
                  <div class="card-body">
                    <h4 class="card-title">Apego al Plan</h4>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-md-12 col-12 mr-auto ml-auto">
              <div class="card">
                <div class="card-header card-header-primary card-header-icon">
                  <div class="card-icon">
                    <i class="material-icons">calendar_today</i>
                  </div>
                  <h4 class="card-title">Búsqueda de Plan</h4>
                  <div class="input-group form-control-lg">
                    <div class="input-group-prepend">
                      <span class="input-group-text">
                        <i class="material-icons">list</i>
                      </span>
                    </div>
                    <div class="form-group">
                      <div class="form-group">
                        <select class="selectpicker" data-style="select-with-transition" title="Plan Alimenticio">
                          <option value="2">Plan 1 </option>
                          <option value="3">Plan 2</option>                                
                        </select>
                      </div>
                    </div>
                  </div>
                </div>
                <div class="card-body">
                  <div class="row">
                    <div class="col-md-12">
                      <p>Inicio del Plan: 24/12/2017</p>
                      <p>Duración: 8 semanas</p>
                      <p>Dieta de <b>1500 kcal</b>. <i class="fa fa-circle text-success"></i>Carbohidratos(50%) <i class="fa fa-circle text-primary"></i>Proteína(20%) <i class="fa fa-circle text-info"></i> Lípidos(30%)</p>
                      <div class="progress">
                        <div class="progress-bar progress-bar-success" role="progressbar" style="width: 50%" aria-valuenow="15" aria-valuemin="0" aria-valuemax="100"></div>
                        <div class="progress-bar progress-bar-primary" role="progressbar" style="width: 20%" aria-valuenow="30" aria-valuemin="0" aria-valuemax="100"></div>
                        <div class="progress-bar progress-bar-info" role="progressbar" style="width: 30%" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100"></div>
                      </div>
                    </div>
                  </div>
                  <div class="row">
                    <div class="col-md-7">
                      <div class="material-datatables">
                        <table id="datatables" class="table table-striped table-no-bordered table-hover" cellspacing="0" width="100%" style="width:100%">
                          <thead>
                            <tr>
                              <th>Fecha</th>
                              <th class="disabled-sorting">Comida</th>
                              <th class="disabled-sorting">Alimento</th>
                            </tr>
                          </thead>
                          <tbody>
                            <tr>
                              <td>4/12/2018</td>
                              <td>Desayuno</td>
                              <td>Barbacoa</td>
                            </tr>
                            <tr>
                              <td>4/12/2018</td>
                              <td>Comida</td>
                              <td>Tacos Suadero</td>
                            </tr>
                            <tr>
                              <td>16/12/2018</td>
                              <td>Cena</td>
                              <td>Pizza</td>
                            </tr>
                            <tr>
                              <td>5/12/2018</td>
                              <td>Desayuno</td>
                              <td>Birria</td>
                            </tr>
                            <tr>
                              <td>8/12/2018</td>
                              <td>Comida</td>
                              <td>Tacos Pastor</td>
                            </tr>
                            <tr>
                              <td>20/12/2018</td>
                              <td>Desayuno</td>
                              <td>Barbacoa</td>
                            </tr>
                            <tr>
                              <td>21/12/2018</td>
                              <td>Desayuno</td>
                              <td>Barbacoa</td>
                            </tr>
                            <tr>
                              <td>22/12/2018</td>
                              <td>Desayuno</td>
                              <td>Barbacoa</td>
                            </tr>
                            <tr>
                              <td>4/12/2018</td>
                              <td>Desayuno</td>
                              <td>Barbacoa</td>
                            </tr>
                            <tr>
                              <td>23/12/2018</td>
                              <td>Desayuno</td>
                              <td>Barbacoa</td>
                            </tr>
                          </tbody>
                        </table>
                      </div>
                    </div>
                    <div class="col-md-5">
                      <center>
                      <div class="row">
                        <div class="col-md-12">
                          <h6>Porcentaje de Apego</h6>
                          <i class="fa fa-circle text-info"></i> Cumplió
                          <i class="fa fa-circle text-danger"></i> No Cumplió
                        </div>
                      </div>
                      <div class="row">
                        <div class="col-md-12">
                          <div id="chartPreferences" class="ct-chart"></div>
                        </div>
                      </div>
                      </center>
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
          YUMK 2018
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
            <label class="ml-auto">
              <div class="togglebutton switch-sidebar-mini">
                <label>
                  <input type="checkbox">
                  <span class="toggle"></span>
                </label>
              </div>
            </label>
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
      dataColouredBarsChart = {
        labels: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto'],
        series: [
          [90, 88, 88, 87, 84, 85, 82, 81, 80],
          [67, 65, 65, 62, 61, 63, 60, 59, 56],
          [20, 21, 22, 22, 23, 20, 20, 21, 22]
        ]
      };

      optionsColouredBarsChart = {
        lineSmooth: Chartist.Interpolation.cardinal({
          tension: 10
        }),
        axisY: {
          showGrid: true,
          offset: 40
        },
        axisX: {
          showGrid: false,
        },
        low: 30,
        high: 150,
        showPoint: true,
        height: '300px'
      };


      var colouredBarsChart = new Chartist.Line('#colouredBarsChart', dataColouredBarsChart, optionsColouredBarsChart);

      md.startAnimationForLineChart(colouredBarsChart);


      dataRoundedLineChart = {
        labels: ['Plan 1', 'Plan 2', 'Plan 3', 'Plan 4', 'Plan 5'],
        series: [
          [98, 80, 90, 95, 78]
        ]
      };

      optionsRoundedLineChart = {
        lineSmooth: Chartist.Interpolation.cardinal({
          tension: 10
        }),
        axisX: {
          showGrid: false,
        },
        low: 60,
        high: 100, // creative tim: we recommend you to set the high sa the biggest value + something for a better look
        chartPadding: {
          top: 0,
          right: 0,
          bottom: 0,
          left: 0
        },
        showPoint: false
      }

      var RoundedLineChart = new Chartist.Line('#roundedLineChart', dataRoundedLineChart, optionsRoundedLineChart);

      md.startAnimationForLineChart(RoundedLineChart);

      var dataPreferences = {
        labels: ['68%', '32%'],
        series: [68, 32]
      };

      var optionsPreferences = {
        height: '230px'
      };

      Chartist.Pie('#chartPreferences', dataPreferences, optionsPreferences);

      $('#datatables').DataTable({
        "pagingType": "numbers",
        "pageLength": 5,
        responsive: true,
        language: {
          search: "_INPUT_",
          searchPlaceholder: "Búsqueda de Comidas",
        }
      });

      var table = $('#datatable').DataTable();
    });
  </script>
  <script type="text/javascript">
  </script>  
</body>

</html>
