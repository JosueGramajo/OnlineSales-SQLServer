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
						<li class="fa nav-item active"><a class="nav-link"
							href="ServletRedireccionar.do?page=dashboard"> <i
								class="fa fa-home"></i> Pagina Principal <span class="sr-only">(current)</span>
						</a></li>
					</ul>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>

		<!--header-->
		<!-- checkout -->
		<div class="content">
			<div class="cart-items">
				<div class="container">
					<h2>Carrito de compras (${cantidadCarrito})</h2>

					<c:forEach var="item" items="${cartList}">
						<div class="cart-header">
							<a class="close1" href="ServletEliminarCarrito.do?token=${token}&idProducto=${item.getProducto().getIdProducto()}"> </a>
							<div class="cart-sec simpleCart_shelfItem">
								<div class="cart-item cyc">
									<img src="${item.getProducto().getImagen() }"
										class="img-responsive" alt="">
								</div>
								<div class="cart-item-info">
									<h1>${item.getProducto().getNombre() }</h1>
									<br>
									<div>
										<h2>Precio : Q.${item.getProducto().getPrecio()}</h2>
									</div>
									<div>
										<h2 style="float: left;">Cantidad : ${item.getCantidad()}</h2>
										<h2 style="float: right;">Subtotal: Q.${item.getCantidad() * item.getProducto().getPrecio() }</h2>
										<div class="clearfix"></div>
									</div>
								</div>
								<div class="clearfix"></div>
							</div>
						</div>
						<hr />
					</c:forEach>
	
					<div  style="text-align: right">
						<h1>Total : Q.${total}</h1>
					</div><br><br>
					<div style="text-align: right;">
						<c:choose>
							<c:when test="${cartList.size() == 0}">
								<a class="btn btn-success" href="ServletRedireccionar.do?page=dashboard" class="btn btn-success">REGRESAR</a>
							</c:when>
							<c:otherwise>
								<a class="btn btn-success" href="#addCategoryModal" class="btn btn-success" data-toggle="modal">REALIZAR COMPRA</a>
							</c:otherwise>
						</c:choose>
					</div>
					
				</div>
			</div>
		</div>
		
		
	<!-- Edit Modal HTML -->
	<div id="addCategoryModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<form method="POST" action="ServletRealizarCompra.do?token=${token}">
					<div class="modal-header">
						<h4 class="modal-title">Ingresar datos de facturacion</h4>
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
					</div>
					<div class="modal-body">
						<div class="form-group">
							<label>Nombre</label> <input type="text" class="form-control"
								name="txtNombre" required>
						</div>
						<div class="form-group">
							<label>Nit</label> <input type="text" class="form-control"
								name="txtNit" required>
						</div>
						<div class="form-group">
							<label>Direccion</label>
							<textarea class="form-control" name="txtDireccion"></textarea>
						</div>
						
						<input type="hidden" value="${total }" name="txtTotal"/>
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
</body>
</html>