<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>OnlineSales - Administrator</title>

<!-- Bootstrap Core CSS -->
<link href="assets/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- MetisMenu CSS -->
<link href="assets/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="assets/dist/css/sb-admin-2.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="assets/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>
	<div id="wrapper">
		<!-- Navigation -->
		<nav class="navbar navbar-light navbar-static-top" role="navigation"
			style="background-color: #343A40;">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" style="color: white;">Bienvenido
					${usuario.getNombre()}</a>
			</div>
			<!-- /.navbar-header -->

			<ul class="nav navbar-top-links navbar-right">
				<li class="dropdown"><a class="dropdown-toggle"
					href="ServletRedireccionar.do?page=administratorDashboard"> <i
						class="fa fa-pencil-square-o" style="color: white;"> Consola
							Administrativa</i>
				</a></li>
				<!-- /.dropdown -->
				<li class=""><a class="dropdown-toggle"
					href="ServletRedireccionar.do?page=dashboard"> <i
						class="fa fa-home" style="color: #858a91;"> Pagina Principal</i>
				</a></li>
				<li class=""><a class="dropdown-toggle"
					href="ServletRedireccionar.do?page=checkout"> <i
						class="fa fa-shopping-cart" style="color: #858a91;"> Carrito (${cantidadCarrito})</i>
				</a></li>
				<li class="dropdown"><a class="dropdown-toggle"
					href="ServletRedireccionar.do?page=logout"> <i
						class="fa fa-sign-out" style="color: #858a91;"> Cerrar Sesion</i>
				</a></li>
				<!-- /.dropdown -->
			</ul>
			<!-- /.navbar-top-links -->
			<div class="navbar-default sidebar" role="navigation">
				<div class="sidebar-nav navbar-collapse">
					<ul class="nav" id="side-menu">
						<li class="sidebar-search">
							<div class="input-group custom-search-form">
								<input type="text" class="form-control" placeholder="Search...">
								<span class="input-group-btn">
									<button class="btn btn-default" type="button">
										<i class="fa fa-search"></i>
									</button>
								</span>
							</div> <!-- /input-group -->
						</li>
						<li><a
							href="ServletRedireccionar.do?page=administratorDashboard"><i
								class="fa fa-dashboard fa-fw"></i> Consola Administrativa</a></li>
						<li><a href="ServletRedireccionar.do?page=categories"><i
								class="fa fa-tasks"></i> Categorias</a></li>
						<li><a href="ServletRedireccionar.do?page=products"><i
								class="fa fa-archive"></i> Productos</a></li>
						<li><a href="ServletRedireccionar.do?page=users"><i
								class="fa fa-user"></i> Usuarios</a></li>
						<li><a href="ServletRedireccionar.do?page=sales"><i
								class="fa fa-shopping-cart"></i> Compras</a></li>
					</ul>
				</div>
				<!-- /.sidebar-collapse -->
			</div>
		</nav>
		<!-- /navigation -->

		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">Editar Usuario</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">Datos del usuario</div>
						<div class="panel-body">
							<div class="row">
								<div class="col-lg-8">
									<form method="POST"
										action="ServletEditarUsuario.do?token=${token}&idUsuario=${usuario.getIdUsuario()}">
										<div class="form-group">
											<label>Nombre</label> <input name="txtNombre"
												class="form-control" value="${usuario.getNombre() }">
										</div>
										<div class="form-group">
											<label>Email</label> 
											<input name="txtEmail" class="form-control" value="${usuario.getEmail() }">
										</div>
										<div class="form-group">
											<label>Nick</label> 
											<input name="txtNick" class="form-control" value="${usuario.getNick() }">
										</div>
										<div class="form-group">
											<label>Password (Dejar en blanco para no cambiarla)</label> 
											<input name="txtPassword" type="password" class="form-control" value="">
										</div>										
										<div class="form-group">
											<label>Rol</label> <select class="form-control"
												name="slcRol">
												<option style="display: none"></option>
												<c:forEach var="rol" items="${listaRoles}">
													<c:choose>
														<c:when
															test="${rol.getIdRol() == usuario.getIdRol()}">
															<option selected="selected">${rol.getNombre() }</option>
														</c:when>
														<c:otherwise>
															<option>${rol.getNombre() }</option>
														</c:otherwise>
													</c:choose>

												</c:forEach>
											</select>
										</div>
										<div class="form-group">
											<label>Estado</label> 
											<select class="form-control" name="slcEstado">
												<c:choose>
													<c:when test="${producto.getEstado() == 'activo'}">
														<option selected="selected">Activo</option>
													</c:when>
													<c:otherwise>
														<option>Activo</option>
													</c:otherwise>
												</c:choose>
												<c:choose>
													<c:when test="${producto.getEstado() == 'inactivo'}">
														<option selected="selected">Inactivo</option>
													</c:when>
													<c:otherwise>
														<option>Inactivo</option>
													</c:otherwise>
												</c:choose>
												
											</select>
										</div>

										
										<a href="ServletRedireccionar.do?page=users" class="btn btn-default">Cancelar</a> 
										
										<input type="submit" class="btn btn-success" value="Guardar Cambios" />
									</form>
								</div>
								<!-- /.col-lg-6 (nested) -->

								<!-- /.col-lg-6 (nested) -->
							</div>
							<!-- /.row (nested) -->
						</div>
						<!-- /.panel-body -->
					</div>
					<!-- /.panel -->
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
		</div>
		<!-- /#page-wrapper -->

	</div>
	<!-- /#wrapper -->

	<!-- jQuery -->
	<script src="assets/vendor/jquery/jquery.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="assets/vendor/bootstrap/js/bootstrap.min.js"></script>

	<!-- Metis Menu Plugin JavaScript -->
	<script src="assets/vendor/metisMenu/metisMenu.min.js"></script>

	<!-- Custom Theme JavaScript -->
	<script src="assets/dist/js/sb-admin-2.js"></script>

</body>

</html>
