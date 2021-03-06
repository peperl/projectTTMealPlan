<%-- 
    Document   : registroPaciente
    Created on : Apr 26, 2019, 1:34:47 AM
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
    Registro de Paciente
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
        <ul class="nav ">
          <li class="nav-item">
            <a class="nav-link" href="BlankN.jsp">
              <i class="material-icons">home</i>
              <p> Inicio </p>
            </a>
          </li>
          <li class="nav-item active">
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
                                    <a class="navbar-brand" href="#pablo">Lista de Pacientes</a>
                                </div>
                                <button class="navbar-toggler" type="button" data-toggle="collapse" aria-controls="navigation-index" aria-expanded="false" aria-label="Toggle navigation" data-target="#navigation-example">
                                  <span class="sr-only">Toggle navigation</span>
                                  <span class="navbar-toggler-icon icon-bar"></span>
                                  <span class="navbar-toggler-icon icon-bar"></span>
                                  <span class="navbar-toggler-icon icon-bar"></span>
                                </button>
			        <div class="collapse navbar-collapse justify-content-end">
			            <ul class="nav navbar-nav navbar-right">
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
          <div class="col-md-8 col-12 mr-auto ml-auto">

            <!--      Wizard container        -->
            <div class="wizard-container">
              <div class="card card-wizard" data-color="rose" id="wizardProfile">
                <form class="form" method = "GET" action = "../../RegistroPaciente">
                  <!--        You can switch " data-color="primary" "  with one of the next bright colors: "green", "orange", "red", "blue"       -->
                  <div class="card-header text-center">
                    <h3 class="card-title">
                      Formato de Registro de Paciente
                    </h3>
                    <h5 class="card-description">Llene los campos requeridos con la información que el paciente proporcione durante la entrevista.</h5>
                  </div>
                  <div class="wizard-navigation">
                    <ul class="nav nav-pills">
                      <li class="nav-item">
                        <a class="nav-link active" href="#personales" data-toggle="tab" role="tab">
                          Personales
                        </a>
                      </li>
                      <li class="nav-item">
                        <a class="nav-link" href="#medidas" data-toggle="tab" role="tab">
                          Antropométricos
                        </a>
                      </li>
                      <li class="nav-item">
                        <a class="nav-link" href="#antecedentes" data-toggle="tab" role="tab">
                          Antecedentes
                        </a>
                      </li>
                      <li class="nav-item">
                        <a class="nav-link" href="#dieteticos" data-toggle="tab" role="tab">
                          Dietéticos
                        </a>
                      </li>
                    </ul>
                  </div>
                  <div class="card-body">
                    <div class="tab-content">
                      <div class="tab-pane active" id="personales">
                        <h5 class="info-text"> Introduzca la información personal del paciente</h5>
                        <div class="row justify-content-center">
                            
                          <div class="col-sm-6">
                              <!--Nombre-->
                            <div class="input-group form-control-lg">
                              <div class="input-group-prepend">
                                <span class="input-group-text">
                                  <i class="material-icons">face</i>
                                </span>
                              </div>
                              <div class="form-group">
                                <label for="exampleInput1" class="bmd-label-floating">Nombre</label>
                                <input type="text" class="form-control" id="firstname" name="firstname" required>
                              </div>
                            </div>
                              <!--Fecha de nacimiento-->
                            <div class="input-group form-control-lg">
                              <div class="input-group-prepend">
                                <span class="input-group-text">
                                  <i class="material-icons">event</i>
                                </span>
                              </div>
                              <div class="form-group">
                                <label class="label-control">Fecha de Nacimiento</label>
                                <input type="text" class="form-control datepicker" id="dateBirth" name="dateBirth" value="10/06/2000" required>
                              </div>
                            </div>
                              <!--Telefono-->
                            <div class="input-group form-control-lg">
                              <div class="input-group-prepend">
                                <span class="input-group-text">
                                  <i class="material-icons">call</i>
                                </span>
                              </div>
                              <div class="form-group">
                                <label for="exampleInput1" class="bmd-label-floating">Teléfono</label>
                                <input type="tel" class="form-control" id="telephone" name="telephone" required>
                              </div>
                            </div>
                          </div>
                          <div class="col-sm-6">
                              <!--Apellidos-->
                            <div class="input-group form-control-lg">
                              <div class="input-group-prepend">
                                <span class="input-group-text">
                                  <i class="material-icons">face</i>
                                </span>
                              </div>
                              <div class="form-group">
                                <label for="exampleInput1" class="bmd-label-floating">Apellidos</label>
                                <input type="text" class="form-control" id="lastname" name="lastname" required>
                              </div>
                            </div>
                              <!--Sexo-->
                            <div class="input-group form-control-lg">
                              <div class="input-group-prepend">
                                <span class="input-group-text">
                                  <i class="material-icons">wc</i>
                                </span>
                              </div>
                              <div class="form-group">
                                  <select class="selectpicker" id="sexo" name="sexo" data-style="select-with-transition" title="Sexo" required>
                                    <option value="F">Femenino</option>
                                    <option value="M">Masculino</option>
                                  </select>
                                
                              </div>
                            </div>
                              <!--email-->
                            <div class="input-group form-control-lg">
                              <div class="input-group-prepend">
                                <span class="input-group-text">
                                  <i class="material-icons">email</i>
                                </span>
                              </div>
                              <div class="form-group">
                                <label for="exampleInput1" class="bmd-label-floating">Correo electrónico</label>
                                <input type="email" class="form-control" id="correo" name="correo" required>
                              </div>
                            </div>
                          </div>
                          <div class="col-lg-10 mt-3">
                            <div class="input-group form-control-lg">
                              <div class="input-group-prepend">
                                <span class="input-group-text">
                                  <i class="material-icons">place</i>
                                </span>
                              </div>
                              <div class="form-group">
                                <label for="exampleInput1" class="bmd-label-floating">Dirección</label>
                                <input type="text" class="form-control" id="address" name="address" required>
                              </div>
                            </div>
                          </div>
                            
                        </div>
                      </div>
                      <div class="tab-pane" id="medidas">
                        <h5 class="info-text"> Introduzca las medidas antropométricas del paciente</h5>
                        <div class="row justify-content-center">
                          <div class="col-sm-6">
                            <div class="input-group form-control-lg">
                              <div class="input-group-prepend">
                                <span class="input-group-text">
                                  <i class="material-icons">accessibility</i>
                                </span>
                              </div>
                              <div class="form-group">
                                <label for="exampleInput1" class="bmd-label-floating">Peso 3 meses antes (kg)</label>
                                <input type="number" class="form-control" id="weightBefore" name="weightBefore" required>
                              </div>
                            </div>
                            <div class="input-group form-control-lg">
                              <div class="input-group-prepend">
                                <span class="input-group-text">
                                  <i class="material-icons">transform</i>
                                </span>
                              </div>
                              <div class="form-group">
                                <label for="exampleInput1" class="bmd-label-floating">Circunferencia Braquial (cm)</label>
                                <input type="text" class="form-control" id="branquial" name="branquial" required>
                              </div>
                            </div>
                          </div>
                          <div class="col-sm-6">
                            <div class="input-group form-control-lg">
                              <div class="input-group-prepend">
                                <span class="input-group-text">
                                  <i class="material-icons">accessibility_new</i>
                                </span>
                              </div>
                              <div class="form-group">
                                <label for="exampleInput1" class="bmd-label-floating">Estatura (m)</label>
                                <input type="text" class="form-control" id="height" name="height" required>
                              </div>
                            </div>
                            <div class="input-group form-control-lg">
                              <div class="input-group-prepend">
                                <span class="input-group-text">
                                  <i class="material-icons">transform</i>
                                </span>
                              </div>
                              <div class="form-group">
                                <label for="exampleInput1" class="bmd-label-floating">Circunferencia Pantorrilla (cm)</label>
                                <input type="text" class="form-control" id="Pantorrilla" name="Pantorrilla" required>
                              </div>
                            </div>
                          </div>
                        </div>
                      </div>
                      <div class="tab-pane" id="antecedentes">
                        <h5>Introduzca los antecedentes del paciente</h5>
                        <div class="row justify-content-center">
                          <div class="col-sm-6">
                            <div class="input-group form-control-lg">
                              <div class="input-group-prepend">
                                <span class="input-group-text">
                                  <i class="material-icons">fitness_center</i>
                                </span>
                              </div>
                              <div class="form-group">
                                  <select class="selectpicker" id="phisicalActivity" name="phisicalActivity" data-style="select-with-transition" title="Actividad Física" required>
                                    <option value="0">Nula</option>
                                    <option value="1">Ligera</option>
                                    <option value="2">Moderada</option>
                                    <option value="3">Alta</option>
                                  </select>
                                <!--<label for="exampleInput1" class="bmd-label-floating">Actividad Física (%)</label>-->
                                <!--<input type="number" class="form-control" id="phisicalActivity" name="phisicalActivity" required>-->
                              </div>
                            </div>
                          </div>
                          <div class="col-sm-6">
                            <div class="input-group form-control-lg">
                              <div class="input-group-prepend">
                                <span class="input-group-text">
                                  <i class="material-icons">local_dining</i>
                                </span>
                              </div>
                              <div class="form-group">
                                <label for="exampleInput1" class="bmd-label-floating">No. Comidas Actuales</label>
                                <input type="text" class="form-control" id="actualMealsQty" name="actualMealsQty" required>
                              </div>
                            </div>
                          </div>
                        </div>
                        <br><h6><i class="material-icons">restaurant</i>Estimado de Consumo Diario Actual</h6>
                        <div class="row justify-content-center">
                          <div class="col-sm-4">
                            <div class="input-group form-control-lg">
                              <div class="form-group">
                                <label for="exampleInput1" class="bmd-label-floating">Proteínas</label>
                                <input type="text" class="form-control" id="actualProteins" name="actualProteins" required>
                              </div>
                            </div>
                          </div>
                          <div class="col-sm-4">
                            <div class="input-group form-control-lg">
                              <div class="form-group">
                                <label for="exampleInput1" class="bmd-label-floating">Carbohidratos</label>
                                <input type="text" class="form-control" id="actualCarbo" name="actualCarbo" required>
                              </div>
                            </div>
                          </div>
                          <div class="col-sm-4">
                            <div class="input-group form-control-lg">
                              <div class="form-group">
                                <label for="exampleInput1" class="bmd-label-floating">Lípidos</label>
                                <input type="text" class="form-control" id="actualLipid" name="actualLipid" required>
                              </div>
                            </div>
                          </div>
                        </div>
                        <div class="row justify-content-center">
                          <div class="col-lg-10">
                            <div class="row">
                              <div class="col-sm-6">
                                <div class="choice" data-toggle="wizard-checkbox" id="difC">
                                    <input type="checkbox" id="Aextras" name="Aextras" value="Design">
                                  <div class="icon">
                                    <i class="fa fa-cutlery"></i>
                                  </div>
                                  <h6>Dificultades para comer</h6>
                                </div>
                              </div>
                              <div class="col-sm-6">
                                <div class="choice" data-toggle="wizard-checkbox" id="enfT">
                                    <input type="checkbox" id="AextrasDisease" name="AextrasDisease"  value="Code">
                                  <div class="icon">
                                    <i class="fa fa-heartbeat"></i>
                                  </div>
                                  <h6>Enfermedades</h6>
                                </div>
                              </div>
                            </div>
                          </div>
                        </div>
                        <div class="row justify-content-center" id="difComer">
                          <div class="col-sm-12">
                            <div class="input-group form-control-lg">
                              <div class="input-group-prepend">
                                <span class="input-group-text">
                                  <i class="material-icons">restaurant</i>
                                </span>
                              </div>
                              <div class="form-group">
                                <label for="exampleInput1" class="bmd-label-floating">Dificultades Para Comer</label>
                                <textarea id="difficultiesToEat" name="difficultiesToEat" class="form-control"></textarea> 
                              </div>
                            </div>
                          </div>
                        </div>
                        <div class="row justify-content-center" id="enfTrat">
                          <div class="col-sm-6">
                            <div class="input-group form-control-lg">
                              <div class="input-group-prepend">
                                <span class="input-group-text">
                                  <i class="material-icons">favorite_border</i>
                                </span>
                              </div>
                              <div class="form-group">
                                <label for="exampleInput1" class="bmd-label-floating">Enfermedades</label>
                                <textarea id="diseases" name="diseases" class="form-control"></textarea> 
                              </div>
                            </div>
                          </div>
                          <div class="col-sm-6">
                            <div class="input-group form-control-lg">
                              <div class="input-group-prepend">
                                <span class="input-group-text">
                                  <i class="material-icons">favorite</i>
                                </span>
                              </div>
                              <div class="form-group">
                                <label for="exampleInput1" class="bmd-label-floating">Tratamiento</label>
                                <textarea id="treatment" name="treatment" class="form-control"></textarea> 
                              </div>
                            </div>
                          </div>
                        </div>
                      </div>
                      <div class="tab-pane" id="dieteticos">
                        <h5 class="info-text"> Introduzca los datos para generar el plan alimenticio</h5>
                        <div class="row justify-content-center">
                          <div class="col-sm-6">
                            <div class="input-group form-control-lg">
                              <div class="input-group-prepend">
                                <span class="input-group-text">
                                  <i class="material-icons">restaurant</i>
                                </span>
                              </div>
                              <div class="form-group">
                                <label for="exampleInput1" class="bmd-label-floating">Comidas al día</label>
                                <input type="text" class="form-control" id="newMealsQty" name="newMealsQty" required>
                              </div>
                            </div>
                            <div class="input-group form-control-lg">
                              <div class="input-group-prepend">
                                <span class="input-group-text">
                                  <i class="material-icons">update</i>
                                </span>
                              </div>
                              <div class="form-group">
                                <label for="exampleInput1" class="bmd-label-floating">Duración (Semanas)</label>
                                <input type="text" class="form-control" id="timePlan" name="timePlan" required>
                              </div>
                            </div>
                            <div class="input-group form-control-lg">
                              <div class="input-group-prepend">
                                <span class="input-group-text">
                                  <i class="material-icons">av_timer</i>
                                </span>
                              </div>
                              <div class="form-group">
                                    <select class="selectpicker" id="speed" name="speed" data-style="select-with-transition" title="velocidad de resultados" required>
                                        <option value="Lento">Lento</option>
                                        <option value="Normal">Normal</option>
                                        <option value="Rapido">Rápido</option>
                                    </select>
                              </div>
                            </div>
                          </div>
                          <div class="col-sm-6">
                            <h6><i class="material-icons">fastfood</i>Alimentos Evitados</h6>
                            <div class="row">
                              <div class="col-sm-12">
                                <div class="input-group form-control-lg">
                                  <div class="input-group-prepend">
                                    <span class="input-group-text">
                                      <i class="material-icons">av_timer</i>
                                    </span>
                                  </div>
                                  <div class="form-group">
                                      <select class="selectpicker" data-style="select-with-transition" title="alimentos" id="alimentosEvitados" name="alimentosEvitados">
                                    </select>
                                  </div>

                                  <span class="btn btn-primary btn-fab btn-fab-mini btn-round" id="addA">
                                    <i class="material-icons">add</i>
                                  </span>
                                </div>
                              </div>
                            </div>
                            <input type="text" value="" class="form-control tagsinput" data-role="tagsinput" data-color="info" id="alimEv" name="alimEv" >
                          </div>
                        </div>
                        <div class="row justify-content-center">
                          <h6><i class="material-icons">local_dining</i>Distribución de Macronutrientes</h6>
                          <div class="col-sm-12">
                            <div class="row">
                              <p>Proteína(<span id="prot"></span>)</p><br>
                              <div class="col-sm-8">
                                <div id="slider1" class="slider slider-rose"></div>
                                <input type="hidden" id="proteinPercent" name="proteinPercent" value="18" />
                              </div>
                            </div>
                            <div class="row">
                              <p>Carbohidratos(<span id="carb"></span>)</p><br>
                              <div class="col-sm-8">
                                <div id="slider2" class="slider"></div>
                                <input type="hidden" id="CarboPercent" name="CarboPercent" value="50"/>
                              </div>
                            </div>
                            <div class="row">
                              <p>Lípidos(<span id="lip"></span>)</p><br>
                              <div class="col-sm-8">
                                <div id="slider3" class="slider slider-info"></div>
                                <input type="hidden" id="lipPercent" name="lipPercent" value="32"/>
                              </div>
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="card-footer">
                    <div class="mr-auto">
                      <input type="button" class="btn btn-previous btn-fill btn-default btn-wd disabled" name="previous" value="Previous">
                    </div>
                    <div class="ml-auto">
                      <input type="button" class="btn btn-next btn-fill btn-rose btn-wd" name="next" value="Siguiente">
                      <input type="submit" class="btn btn-finish btn-fill btn-rose btn-wd" name="finish" value="Guardar" style="display: none;">
                    </div>
                    <div class="clearfix"></div>
                  </div>
                </form>
              </div>
            </div>
            <!-- wizard container -->



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
  <!--  Google Maps Plugin    -->
  <!--<script src="https://maps.googleapis.com/maps/api/js?key=YOUR_KEY_HERE"></script>-->
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
      $("#difComer").hide();
      $("#enfTrat").hide();
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

        $.get("../../getAllFood", function(responseJson) {    // Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response JSON...
            $.each(responseJson, function(index, item) { // Iterate over the JSON array.
                ($("#alimentosEvitados")).append("<option value=" + item.idalimento +">" + item.nombre + "</option>");
            });
            $('#alimentosEvitados').selectpicker('refresh');
        });
        
  
  

        $('#addA').click( function(){          
          var list = $('#alimEv').val();
          //$('#alimEv').val(list+','+algo);
          $('#alimEv').tagsinput('add', $('#alimentosEvitados').val());
          //$('#alimEv').val(list+','+$('#alimentos').val());
        });
        
        
        
        

        $('#difC').click( function(){          
          if($('#difC').hasClass('active')) {
            $("#difComer").show();
          }
          else {
              $("#difComer").hide();
          }
        });

        $('#enfT').click( function(){          
          if($('#enfT').hasClass('active')) {
            $("#enfTrat").show();
          }
          else {
              $("#enfTrat").hide();
          }
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
      // Initialise the wizard
      demo.initMaterialWizard();
      setTimeout(function() {
        $('.card.card-wizard').addClass('active');
      }, 600);
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
</body>

</html>