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

<title>SB Admin 2 - Bootstrap Admin Theme</title>

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
				<a class="navbar-brand" href="index.html" style="color: white;">Bienvenido
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
					href="ServletRedireccionar.do?page=dashboard"> <i
						class="fa fa-shopping-cart" style="color: #858a91;"> Carrito</i>
				</a></li>
				<li class=""><a class="dropdown-toggle"
					href="ServletRedireccionar.do?page=dashboard"> <i
						class="fa fa-info-circle" style="color: #858a91;"> Acerca de</i>
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
								class="fa fa-dashboard fa-fw"></i> Dashboard</a></li>
						<li><a href="#"><i class="fa fa-bar-chart-o fa-fw"></i>
								Charts<span class="fa arrow"></span></a>
							<ul class="nav nav-second-level">
								<li><a href="flot.html">Flot Charts</a></li>
								<li><a href="morris.html">Morris.js Charts</a></li>
							</ul> <!-- /.nav-second-level --></li>
						<li><a href="ServletRedireccionar.do?page=categories"><i
								class="fa fa-table fa-fw"></i> Categorias</a></li>
						<li><a href="ServletRedireccionar.do?page=products"><i
								class="fa fa-table fa-fw"></i> Productos</a></li>
						<li><a href="ServletRedireccionar.do?page=tables"><i
								class="fa fa-table fa-fw"></i> Tables</a></li>
						<li><a href="ServletRedireccionar.do?page=forms"><i
								class="fa fa-edit fa-fw"></i> Forms</a></li>
						<li><a href="#"><i class="fa fa-wrench fa-fw"></i> UI
								Elements<span class="fa arrow"></span></a>
							<ul class="nav nav-second-level">
								<li><a href="panels-wells.html">Panels and Wells</a></li>
								<li><a href="buttons.html">Buttons</a></li>
								<li><a href="notifications.html">Notifications</a></li>
								<li><a href="typography.html">Typography</a></li>
								<li><a href="icons.html"> Icons</a></li>
								<li><a href="grid.html">Grid</a></li>
							</ul> <!-- /.nav-second-level --></li>
						<li><a href="#"><i class="fa fa-sitemap fa-fw"></i>
								Multi-Level Dropdown<span class="fa arrow"></span></a>
							<ul class="nav nav-second-level">
								<li><a href="#">Second Level Item</a></li>
								<li><a href="#">Second Level Item</a></li>
								<li><a href="#">Third Level <span class="fa arrow"></span></a>
									<ul class="nav nav-third-level">
										<li><a href="#">Third Level Item</a></li>
										<li><a href="#">Third Level Item</a></li>
										<li><a href="#">Third Level Item</a></li>
										<li><a href="#">Third Level Item</a></li>
									</ul> <!-- /.nav-third-level --></li>
							</ul> <!-- /.nav-second-level --></li>
						<li><a href="#"><i class="fa fa-files-o fa-fw"></i>
								Sample Pages<span class="fa arrow"></span></a>
							<ul class="nav nav-second-level">
								<li><a href="blank.html">Blank Page</a></li>
								<li><a href="login.html">Login Page</a></li>
							</ul> <!-- /.nav-second-level --></li>
					</ul>
				</div>
				<!-- /.sidebar-collapse -->
			</div>
			<!-- /.navbar-static-side -->
		</nav>
		<!-- /navigation -->

		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">Editar Categoria</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">Datos de la categoria</div>
						<div class="panel-body">
							<div class="row">
								<div class="col-lg-8">
									<form method="POST"
										action="ServletEditarProducto.do?idProducto=${producto.getIdProducto() }&returnPage=${returnPage}">
										<div class="form-group">
											<label>Nombre</label> <input name="txtNombre"
												class="form-control" value="${producto.getNombre() }">
										</div>
										<div class="form-group">
											<label>Precio</label> <input name="txtPrecio"
												class="form-control" type="number"
												value="${producto.getPrecio() }">
										</div>
										<div class="form-group">
											<label>Descripcion</label>
											<textarea name="txtDescripcion" class="form-control" rows="3">${producto.getDescripcion() }</textarea>
										</div>
										<div class="form-group">
											<label>Categoria</label> <select class="form-control"
												name="category">
												<option style="display: none"></option>
												<c:forEach var="categoria" items="${listaCategorias }">
													<c:choose>
														<c:when
															test="${categoria.getIdCategoria() == producto.getIdCategoria()}">
															<option selected="selected">${categoria.getNombre() }</option>
														</c:when>
														<c:otherwise>
															<option>${categoria.getNombre() }</option>
														</c:otherwise>
													</c:choose>

												</c:forEach>
											</select>
										</div>
										<div class="form-group">
											<label>Unidades en existencia</label> <input type="number"
												class="form-control" name="txtExistencias"
												value="${producto.getExistencias() }" required>
										</div>
										<div class="form-group">
											<label>Estado</label> <select class="form-control" name="estadoProducto">
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
										<!-- <div class="form-group">
											<label>Imagen</label><br> 
											<img src="${producto.getImagen().trim()}" alt="Responsive Image" class="img-thumbnail"> 
											<input type="hidden" value="${producto.getImagen().trim()}" name="">
											<input type="file" name="file" id="file" value="Reemplazar imagen..." accept="image/*" />
											<output id="list"></output>
											<script type="text/javascript">
												if (window.FileReader) {
													function handleFileSelect(evt) {
														var files = evt.target.files;
														var f = files[0];
														var reader = new FileReader();
														alert('wuto');
														reader.onload = (function(
																theFile) {
															return function(e) {
																document
																		.getElementById('list').innerHTML = [ '<img src="', e.target.result,'" title="', theFile.name, '" width="50" />' ]
																		.join('');
															};
														})(f);

														reader.readAsDataURL(f);
													}
												} else {
													alert('This browser does not support FileReader');
												}
												document.getElementById('file').addEventListener('change',handleFileSelect,false);
											</script>

										</div>-->
										
										<c:choose>
											<c:when test="${returnPage == 'admin'}">
												<a href="ServletRedireccionar.do?page=products" class="btn btn-default">Cancelar</a> 
											</c:when>
											<c:otherwise>
												<a href="ServletRedireccionar.do?page=dashboard" class="btn btn-default">Cancelar</a> 
											</c:otherwise>
										</c:choose>
										
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
