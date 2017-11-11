<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML>
<html>
<head>
<title>OnlineSales</title>
<link href="assets/detail_resources/css/bootstrap.css" rel="stylesheet"
	type="text/css" media="all" />
<link href="assets/detail_resources/css/style.css" rel="stylesheet"
	type="text/css" media="all" />
<link href="assets/detail_resources/css/owl.carousel.css"
	rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Swim Wear Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
		Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript">
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 

</script>

<script src="assets/detail_resources/js/jquery.min.js"></script>

<!-- Custom Fonts -->
<link href="assets/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">

<!-- cart -->
<script src="assets/detail_resources/js/simpleCart.min.js">
	
</script>
<!-- cart -->
<script type="text/javascript"
	src="assets/detail_resources/js/bootstrap-3.1.1.min.js"></script>
<script src="assets/detail_resources/js/imagezoom.js"></script>

<!-- FlexSlider -->
<script defer src="assets/detail_resources/js/jquery.flexslider.js"></script>
<link rel="stylesheet" href="assets/detail_resources/css/flexslider.css"
	type="text/css" media="screen" />

<script>
	// Can also be used with $(document).ready()
	$(window).load(function() {
		$('.flexslider').flexslider({
			animation : "slide",
			controlNav : "thumbnails"
		});
	});
</script>



</head>
<body>
	<!--header-->
	<div class="header">
		<div class="header-top">
			<div class="container">
				<div class="top-right">
					<ul>
						<li class="fa nav-item active">
							<a class="nav-link" href="ServletRedireccionar.do?page=dashboard">
								<i class="fa fa-home"></i> Pagina Principal <span class="sr-only">(current)</span>
							</a>
						</li>
						<li class="fa nav-item">
							<a class="nav-link" href="ServletRedireccionar.do?page=checkout">
								<i class="fa fa-shopping-cart" aria-hidden="true"></i> Carrito (${cantidadCarrito})
							</a>
						</li>
					</ul>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
		</div>

		<div class="container">
			<div class="row text-center">
				<div class=".col-md-6 .col-md-offset-3">
					<br> <br>
					<h2 style="color: #0fad00">Se realizo la compra con exito!!!</h2>
					<img src="assets/img/check.png">
					<h1>${producto.getNombre() }</h1>
					<p style="font-size: 20px; color: #5C5C5C;">Gracias por tu preferencia y realizar tu compra con nosotros, esperamos que vuelvas pronto</p><br><br>
					<a href="ServletRedireccionar.do?page=dashboard"
						class="btn btn-default">     Continuar Comprando     </a> <br><br>
					<a href="ReportServlet.do"
						class="btn btn-info">     Generar Factura     </a> <br><br><br><br>
					<br>
				</div>

			</div>
		</div>
</body>
</html>