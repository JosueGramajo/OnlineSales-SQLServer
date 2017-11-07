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

<title>Admin Console</title>

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
				<a class="navbar-brand" href="index.html" style="color: white;">Bienvenido
					${usuario.getNombre()}</a>
			</div>
			<!-- /.navbar-header -->

			<ul class="nav navbar-top-links navbar-right">
				<li class="dropdown"><a class="dropdown-toggle" href="#"> <i
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
					<h1 class="page-header">Productos</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
			<div class="row">
				<div class="col-lg-4">
					<a class="btn btn-success" href="#addProductModal"
						class="btn btn-success" data-toggle="modal">Agregar Productos</a>
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">Datos de las categorias
							disponibles</div>
						<!-- /.panel-heading -->
						<div class="panel-body">
							<table width="100%"
								class="table table-striped table-bordered table-hover"
								id="dataTables-example">
								<thead>
									<tr>
										<th>id</th>
										<th>Nombre</th>
										<th>Precio</th>
										<th>Categoria</th>
										<th>Imagen</th>
										<th></th>
										<th></th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="producto" items="${listaProductos}">
										<tr class="odd gradeX">
											<td>${producto.getIdProducto()}</td>
											<td>${producto.getNombre()}</td>
											<td>${producto.getPrecio() }</td>
											<td>${producto.getIdCategoria() }</td>
											<td><img src="${producto.getImagen().trim()}"
												alt="Responsive Image" class="img-thumbnail"></td>
											<td>
												<form method="POST"
													action="ServletRedireccionar.do?page=categoriesUpdate&idCategoria=${producto.getIdProducto()}">
													<input class="btn btn-info btn-block" type="submit"
														value="Editar" />
												</form>
											</td>
											<td>
												<form method="POST"
													action="ServletEliminarCategoria.do?idCategoria=${producto.getIdProducto()}">
													<input class="btn btn-danger btn-block" type="submit"
														value="Eliminar"
														onclick="return confirm('Esta seguro que desea eliminar esta categoria? \n(Los productos que tengan la categoria eliminada pasaran a tener una categoria indefinida)')" />
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

	<!-- Edit Modal HTML -->
	<div id="addProductModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<form method="POST" action="ServletAgregarProducto.do" encType="multipart/form-data">
					<div class="modal-header">
						<h4 class="modal-title">Agregar Producto</h4>
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
					</div>
					<div class="modal-body">
						<div class="form-group">
							<label>Nombre</label> <input type="text" class="form-control"
								name="txtNombre" required>
						</div>
						<div class="form-group">
							<label>Precio</label> <input type="number" class="form-control"
								name="txtPrecio" required>
						</div>
						<div class="form-group">
							<label>Descripcion</label>
							<textarea class="form-control" name="txtDescripcion"></textarea>
						</div>
						<div class="form-group">
							<label>Categoria</label> 
							<select class="form-control" name="category">
								<c:forEach var="categoria" items="${listaCategorias }">
									<option>${categoria.getNombre() }</option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group">
							<label>Unidades en existencia</label> <input type="number"
								class="form-control" name="txtExistencias" required>
						</div>
						<div class="form-group">
							<label>Imagen</label> <input type="file" name="file" id="file" value="select images..." accept="image/*"/>
						</div>
					</div>
					<div class="modal-footer">
						<input type="button" class="btn btn-default" data-dismiss="modal"
							value="Cancelar"> <input type="submit"
							class="btn btn-success" value="Agregar">
					</div>
				</form>
			</div>
		</div>
	</div>

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
