<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Book Store Template, Free CSS Template, CSS Website Layout</title>
<meta name="keywords" content="Book Store Template, Free CSS Template, CSS Website Layout, CSS, HTML" />
<meta name="description" content="Book Store Template, Free CSS Template, Download CSS Website" />
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<c:if test="${productlist==null}">
<c:redirect url="ProductController"></c:redirect>
</c:if>
<!--  Free CSS Templates from www.templatemo.com -->
<div id="templatemo_container">
<jsp:include page="Menu.jsp"/>
  <!-- end of menu -->
     <!-- end of header -->
    <jsp:include page="Header.jsp"/>
    
    <div id="templatemo_content">
     
        <div id="templatemo_content_left">
         <div class="templatemo_content_left_section">
             <h1>Categories</h1>
                <ul>
                <c:forEach items="${categorylist}" var="category">
               
                    <li><a href="ProductController?action=getAllProductByCategory&id">${category.categorycode}-${category.categorydesc }</a></li>
                </c:forEach>                  
             </ul>
            </div>
   <div class="templatemo_content_left_section">
             <h1>Bestsellers</h1>
                <ul>
                    <li><a href="#">Vestibulum ullamcorper</a></li>
                    <li><a href="#">Maece nas metus</a></li>
                    <li><a href="#">In sed risus ac feli</a></li>
                    <li><a href="#">Praesent mattis varius</a></li>
                    <li><a href="#">Maece nas metus</a></li>
                    <li><a href="#">In sed risus ac feli</a></li>
                    <li><a href="http://www.flashmo.com" target="_parent">Flash Templates</a></li>
                    <li><a href="http://www.templatemo.com" target="_parent">CSS Templates</a></li>
                    <li><a href="http://www.webdesignmo.com" target="_parent">Web Design</a></li>
                    <li><a href="http://www.photovaco.com" target="_parent">Free Photos</a></li>
             </ul>
            </div>
            
            <div class="templatemo_content_left_section">                
                <a href="http://validator.w3.org/check?uri=referer"><img style="border:0;width:88px;height:31px" src="http://www.w3.org/Icons/valid-xhtml10" alt="Valid XHTML 1.0 Transitional" width="88" height="31" vspace="8" border="0" /></a>
<a href="http://jigsaw.w3.org/css-validator/check/referer"><img style="border:0;width:88px;height:31px"  src="http://jigsaw.w3.org/css-validator/images/vcss-blue" alt="Valid CSS!" vspace="8" border="0" /></a>
   </div>
        </div> <!-- end of content left -->
        
        <div id="templatemo_content_right">
        <c:forEach items="${productlist}" var="product" varStatus="status">
         <div class="templatemo_product_box">
             <h1>${product.code} <span>(by Best Author)</span></h1>
          <img src="images/templatemo_image_01.jpg" alt="image" />
                <div class="product_info">
                 <p>${product.description}</p>
                  <h3>RS.${product.price}</h3>
                    <div class="buy_now_button"><a href="ProductController?action=addToCart&id=${product.id }">Add to Cart</a></div>
                    <div class="detail_button"><a href="ProductController?action=productDetails&id=${product.id }">Detail</a></div>
                </div>
                <div class="cleaner">&nbsp;</div>
            </div>
            <c:if test="${status.index%2==0}">
            <div class="cleaner_with_width">&nbsp;</div>
            </c:if>
            <c:if test="${status.index%2!=0}">
            <div class="cleaner_with_height">&nbsp;</div>
            </c:if>
            </c:forEach>`
            <div class="templatemo_product_box">
             <h1>Cooking  <span>(by New Author)</span></h1>
            <img src="images/templatemo_image_02.jpg" alt="image" />
                <div class="product_info">
                 <p>Aliquam a dui, ac magna quis est eleifend dictum.</p>
                    <h3>$35</h3>
                    <div class="buy_now_button"><a href="subpage.html">Buy Now</a></div>
                    <div class="detail_button"><a href="subpage.html">Detail</a></div>
                </div>
                <div class="cleaner">&nbsp;</div>
            </div>
            
            <div class="cleaner_with_height">&nbsp;</div>
            
            <div class="templatemo_product_box">
             <h1>Gardening <span>(by Famous Author)</span></h1>
          <img src="images/templatemo_image_03.jpg" alt="image" />
                <div class="product_info">
                 <p>Ut fringilla enim sed turpis. Sed justo dolor, convallis at.</p>
                    <h3>$65</h3>
                    <div class="buy_now_button"><a href="subpage.html">Buy Now</a></div>
                    <div class="detail_button"><a href="subpage.html">Detail</a></div>
                </div>
                <div class="cleaner">&nbsp;</div>
            </div>
            
            <div class="cleaner_with_width">&nbsp;</div>
            
            <div class="templatemo_product_box">
             <h1>Sushi Book  <span>(by Japanese Name)</span></h1>
             <img src="images/templatemo_image_04.jpg" alt="image" />
                <div class="product_info">
                 <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. </p>
                    <h3>$45</h3>
                    <div class="buy_now_button"><a href="subpage.html">Buy Now</a></div>
                    <div class="detail_button"><a href="subpage.html">Detail</a></div>
                </div>
                <div class="cleaner">&nbsp;</div>
            </div>
            
            <div class="cleaner_with_height">&nbsp;</div>
            
            <a href="subpage.html"><img src="images/templatemo_ads.jpg" alt="ads" /></a>
        </div> <!-- end of content right -->
    
     <div class="cleaner_with_height">&nbsp;</div>
    </div> <!-- end of content -->
    
    <jsp:include page="Footer.jsp"/> 
    <!-- end of footer -->
<!--  Free CSS Template www.templatemo.com -->
</div> <!-- end of container -->
<div align=center>This template  downloaded form <a href='http://all-free-download.com/free-website-templates/'>free website templates</a></div></body>
</html>