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

<!-- DataTables CSS -->
<link href="assets/vendor/datatables-plugins/dataTables.bootstrap.css"
	rel="stylesheet">

<!-- DataTables Responsive CSS -->
<link
	href="assets/vendor/datatables-responsive/dataTables.responsive.css"
	rel="stylesheet">

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
					<h1 class="page-header">Compras</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->

			<br>
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">Datos de las compras</div>
						<!-- /.panel-heading -->
						<div class="panel-body">
							<table width="100%"
								class="table table-striped table-bordered table-hover"
								id="dataTables-example">
								<thead>
									<tr>
										<th>Numero de Factura</th>
										<th>Usuario</th>
										<th>Total</th>
										<th>Fecha</th>
										<th>Detalle</th>
									</tr>
								</thead>
								<!-- Esto es el cuerpo de la tabla aqui se hace tal lsdjflsd -->
								<tbody>
									<c:forEach var="compra" items="${listaCompras}">
										<tr class="odd gradeX">
											<td>${compra.getNoFactura()}</td>
											<td>${compra.getNombre()}</td>
											<td>Q.${compra.getTotal() }</td>
											<td>${compra.getFecha() }</td>
											<td>
												<form method="POST" action="ServletRedireccionar.do?page=saleDetail&idFactura=${compra.getIdFactura()}">
													<input class="btn btn-info btn-block" type="submit" value="Ver Detalle" />
												</form>
											</td>
										</tr>
									</c:forEach>

								</tbody>
							</table>
						</div>
						<!-- /.panel-body -->
					</div>
					<!-- /.panel -->
				</div>
				<!-- /.col-lg-12 -->
			</div>
		</div>
	</div>
	<!-- /#wrapper -->

	<!-- jQuery -->
	<script src="assets/vendor/jquery/jquery.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="assets/vendor/bootstrap/js/bootstrap.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="assets/js/bootstrap-confirmation.js"></script>

	<!-- Metis Menu Plugin JavaScript -->
	<script src="assets/vendor/metisMenu/metisMenu.min.js"></script>

	<!-- DataTables JavaScript -->
	<script src="assets/vendor/datatables/js/jquery.dataTables.min.js"></script>
	<script
		src="assets/vendor/datatables-plugins/dataTables.bootstrap.min.js"></script>
	<script
		src="assets/vendor/datatables-responsive/dataTables.responsive.js"></script>

	<!-- Custom Theme JavaScript -->
	<script src="assets/dist/js/sb-admin-2.js"></script>

	<!-- Page-Level Demo Scripts - Tables - Use for reference -->
	<script>
		$(document).ready(function() {
			$('#dataTables-example').DataTable({
				responsive : true
			});
		});
	</script>

</body>

</html>
