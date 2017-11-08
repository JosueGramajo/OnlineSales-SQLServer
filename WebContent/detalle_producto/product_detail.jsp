<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML>
<html>
<head>
<title>Swim Wear a E-Commerce online Shopping Category Flat
	Bootstrap Responsive Website Template| Single :: w3layouts</title>
<link href="detail_resources/css/bootstrap.css" rel="stylesheet"
	type="text/css" media="all" />
<link href="detail_resources/css/style.css" rel="stylesheet"
	type="text/css" media="all" />
<link href="detail_resources/css/owl.carousel.css" rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Swim Wear Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
		Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript">
	
	
	
	
	
	
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 







</script>
<script src="detail_resources/js/jquery.min.js"></script>

<!-- Custom Fonts -->
<link href="assets/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">

<!-- cart -->
<script src="detail_resources/js/simpleCart.min.js">
	
</script>
<!-- cart -->
<script type="text/javascript"
	src="detail_resources/js/bootstrap-3.1.1.min.js"></script>
<script src="detail_resources/js/imagezoom.js"></script>

<!-- FlexSlider -->
<script defer src="detail_resources/js/jquery.flexslider.js"></script>
<link rel="stylesheet" href="detail_resources/css/flexslider.css"
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
						<li class="fa nav-item active"><a class="nav-link" href="#"><i
								class="fa fa-home"></i> Pagina Principal <span class="sr-only">(current)</span>
						</a></li>
						<li class="fa nav-item"><a class="nav-link" href="#"><i
								class="fa fa-shopping-cart" aria-hidden="true"></i> Carrito</a></li>
					</ul>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>

		<!--header-->
		<div class="content">
			<div class="single">
				<div class="container">
					<div class="single-grids">
						<div class="col-md-4 single-grid1">
							<h2>account</h2>
							<ul>
								<li><a href="#">Forgot Your Password</a></li>
								<li><a href="#">my account</a></li>
								<li><a href="#">address books</a></li>
								<li><a href="#">wishlist</a></li>
								<li><a href="#">reward points</a></li>
								<li><a href="#">return</a></li>
								<li><a href="#">transaction</a></li>
							</ul>
						</div>
						<div class="col-md-4 single-grid">
							<div class="flexslider">
								<ul class="slides">
									<li data-thumb="${producto.getImagen() }">
										<div class="thumb-image">
											<img src="${producto.getImagen() }" data-imagezoom="true"
												class="img-responsive">
										</div>
									</li>

									<li data-thumb="">
										<div class="thumb-image">
											<img src=""
												data-imagezoom="true" class="img-responsive">
										</div>
									</li>
									<li data-thumb="">
										<div class="thumb-image">
											<img src=""
												data-imagezoom="true" class="img-responsive">
										</div>
									</li>
								</ul>
							</div>
						</div>
						<div class="col-md-4 single-grid simpleCart_shelfItem">
							<h3>${producto.getNombre() }</h3>
							<p>${producto.getDescripcion() }</p>
							<ul class="size">
								<h3>Precio</h3>
								<h5 class="item_price" style="color: #279B27">Q.${producto.getPrecio() }</h5>
							</ul>
							<ul class="size">
								<h3>Existencias</h3>
								<h4 style="color: #279B27">Quedan (${producto.getExistencias() }) unidades en existencia</h4>
							</ul>

							<!--  
							<ul class="size">
								<h3>Size</h3>
								<li><a href="#">25</a></li>
								<li><a href="#">26</a></li>
								<li><a href="#">27</a></li>
								<li><a href="#">28</a></li>
								<li><a href="#">29</a></li>
								<li><a href="#">30</a></li>
								<li><a href="#">31</a></li>
								<li><a href="#">32</a></li>
								<li><a href="#">33</a></li>
							</ul>
							-->

							<div class="galry">
								<h4 class="text-muted">&#9733; &#9733; &#9733; &#9733;
									&#9734;</h4>
							</div>

							<p class="qty">Cantidad :</p>
							<input min="1" type="number" id="quantity" name="quantity"
								value="1" class="form-control input-small">
							<div class="btn_form">
								<a href="#" class="add-cart item_add">AGREGAR AL CARRITO</a>
							</div>
							<div class="tag">
								<p>
									Categoria : <a href="#"> ${categoria.getNombre() } </a>
								</p>
							</div>
						</div>
						<div class="clearfix"></div>
					</div>
				</div>
			</div>

			<!-- collapse -->
			<div class="related-products">
				<div class="container">
					<h3>Productos Relacionados</h3>

					<div class="product-model-sec single-product-grids">


						<c:forEach var="producto" items="${productosRelacionados}">
							<div class="product-grid single-product">
								<a href="#">
									<div class="more-product">
										<span> </span>
									</div>
									<div class="product-img b-link-stripe b-animate-go  thickbox">
										<img src="${producto.getImagen() }"
											class="img-responsive" alt="">
										<div class="b-wrapper">
											<h4 class="b-animate b-from-left  b-delay03">
												<button>+</button>
											</h4>
										</div>
									</div>
								</a>
								<div class="product-info simpleCart_shelfItem">
									<div class="product-info-cust prt_name">
										<h4>${producto.getNombre() }</h4>
										<span class="item_price">Q.${producto.getPrecio() }</span>
										<div class="clearfix"></div>
									</div>
								</div>
							</div>
						</c:forEach>

					</div>
				</div>
			</div>
		</div>
</body>
</html>