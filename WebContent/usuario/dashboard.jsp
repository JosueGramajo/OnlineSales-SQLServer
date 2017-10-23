<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Shop Homepage - Start Bootstrap Template</title>

<!-- Bootstrap core CSS -->
<link href="assets/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="assets/css/shop-homepage.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="assets/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

</head>

<body>

	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
		<div class="container">
			<a class="navbar-brand" href="#">Start Bootstrap</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<c:if test="${usuario.getIdRol() == 1}">
						<li class="fa nav-item">
							<a class="nav-link" href="ServletRedireccionar.do?page=administratorDashboard"><i class="fa fa-pencil-square-o" style="color: #858a91;"></i>    Consola administrativa</a>
						</li>
					</c:if>
					<li class="fa nav-item active"><a class="nav-link" href="#"><i class="fa fa-home"></i>    Pagina Principal
							<span class="sr-only">(current)</span>
					</a></li>
					<li class="fa nav-item"><a class="nav-link" href="#"><i class="fa fa-shopping-cart" aria-hidden="true"></i>    Carrito</a></li>
					<li class="fa nav-item"><a class="nav-link" href="#"><i class="fa fa-info-circle"></i>    Acerca de</a>
					</li>
					<li class="fa nav-item"><a class="nav-link" href="#"><i class="fa fa-sign-out fa-fw"></i>  Cerrar Sesion</a>
					</li>
				</ul>
			</div>
		</div>
	</nav>

	<!-- Page Content -->
	<div class="container">

		<div class="row">

			<div class="col-lg-3">

				<h1 class="my-4">${nombreUsuario }</h1>
				<div class="list-group">
					<c:forEach var="categoria" items="${listaCategorias}">
						<a href="#" class="list-group-item">${categoria.getNombre()}</a>
					</c:forEach>
				</div>

			</div>
			<!-- /.col-lg-3 -->

			<div class="col-lg-9">

				<div id="carouselExampleIndicators" class="carousel slide my-4"
					data-ride="carousel">
					<ol class="carousel-indicators">
						<li data-target="#carouselExampleIndicators" data-slide-to="0"
							class="active"></li>
						<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
						<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
						<li data-target="#carouselExampleIndicators" data-slide-to="3"></li>
					</ol>
					<div class="carousel-inner" role="listbox">
						<div class="carousel-item active">
							<img class="d-block img-fluid" src="testAssets/banner1.png"
								alt="First slide">
						</div>
						<div class="carousel-item">
							<img class="d-block img-fluid" src="testAssets/banner2.png"
								alt="Second slide">
						</div>
						<div class="carousel-item">
							<img class="d-block img-fluid" src="testAssets/banner3.png"
								alt="Third slide">
						</div>
						<div class="carousel-item">
							<img class="d-block img-fluid" src="testAssets/banner4.png"
								alt="Third slide">
						</div>
					</div>
					<a class="carousel-control-prev" href="#carouselExampleIndicators"
						role="button" data-slide="prev"> <span
						class="carousel-control-prev-icon" aria-hidden="true"></span> <span
						class="sr-only">Previous</span>
					</a> <a class="carousel-control-next" href="#carouselExampleIndicators"
						role="button" data-slide="next"> <span
						class="carousel-control-next-icon" aria-hidden="true"></span> <span
						class="sr-only">Next</span>
					</a>
				</div>
				
			<div class="row">
				<c:forEach var="producto" items="${listaProductos}">
					
						<div class="col-lg-4 col-md-6 mb-4">
							<div class="card h-100">
								<a href="#"><img class="card-img-top"
									src="${producto.getImagen()}" alt=""></a>
								<div class="card-body">
									<h4 class="card-title">
										<a href="#">${producto.getNombre()}</a>
									</h4>
									<h5>$24.99</h5>
									<p class="card-text">${producto.getImagen()}</p>
								</div>
								<div class="card-footer">
									<small class="text-muted">&#9733; &#9733; &#9733;
										&#9733; &#9734;</small>
								</div>
								<c:if test="${usuario.getIdRol() == 1}">
									<div class="card-footer">
										<button type="button" class="btn btn-danger btn-block">Eliminar</button>
									</div>
									<div class="card-footer">
										<button type="button" class="btn btn-info btn-block">Editar</button>
									</div>
								</c:if>
							</div>
						</div>
						
								
				</c:forEach>
			</div>	

				<!-- /.row -->

			</div>
			<!-- /.col-lg-9 -->

		</div>
		<!-- /.row -->

	</div>
	<!-- /.container -->

	<!-- Footer -->
	<footer class="py-5 bg-dark">
		<div class="container">
			<p class="m-0 text-center text-white">Copyright &copy; Your
				Website 2017</p>
		</div>
		<!-- /.container -->
	</footer>

	<!-- Bootstrap core JavaScript -->
	<script src="assets/jquery/jquery.min.js"></script>
	<script src="assets/popper/popper.min.js"></script>
	<script src="assets/bootstrap/js/bootstrap.min.js"></script>

</body>

</html>
