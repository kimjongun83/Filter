<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Page</title>
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<!-- Font Awesome -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css"
	rel="stylesheet" />
	
<!-- JS-->
<script src="https://code.jquery.com/jquery-3.5.1.min.js"
    integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
</head>
<body>
    <div class="container-md">
        <!-- START FORM -->
        <div class="py-5">
            <h2 class="text-uppercase text-center">Quản Lý Sản Phẩm</h2>
            <form action="<%= request.getContextPath() %>/products/add" method="post">
            <div class="mb-3">
                    <label class="form-label">Mã sản phẩm:</label>
                    <input type="text" class="form-control" name="productID">
                </div>
                <div class="mb-3">
                    <label class="form-label">Tên sản phẩm:</label>
                    <input type="text" class="form-control" name="productName">
                </div>
                <div class="mb-3">
                    <label class="form-label">Mô tả:</label>
                    <input type="text" class="form-control" name="productDescription">
                </div>
                <div class="mb-3">
                    <label class="form-label">Giá bán:</label>
                    <input type="number" step="any" class="form-control" name="productPrice">
                </div>
                <div class="mb-3">
                    <label class="form-label">Số lượng:</label>
                    <input type="number" class="form-control" name="productStock">
                </div>
                <button type="submit" class="btn btn-primary">Lưu lại</button>
            </form>
        </div>
        <!-- END FORM -->

        <!-- START TABLE -->
        <table class="table">
            <thead>
                <tr>
                    <th scope="col">Mã</th>
                    <th scope="col">Tên sản phẩm</th>
                    <th scope="col">Mô tả</th>
                    <th scope="col">Giá bán</th>
                    <th scope="col">Số lượng</th>
                    <th scope="col">Xóa</th>
                </tr>
            </thead>
            <tbody>
            	<c:forEach var="product" items="${products}">
				<tr class="product-item" data-index="${ product.ID }">
                    <th scope="row">${product.ID }</th>
                    <td>${product.name }</td>
                    <td>${product.description }</td>
                    <td>${product.price }</td>
                    <td>${product.stock }</td>
                    <td><a class="btn btn-danger btn-delete" value="${product.ID }"><i class="fa fa-trash" aria-hidden="true"></i></a></td>
               	</tr>            	
            	</c:forEach>
            </tbody>
        </table>
        <!-- END FORM -->
    </div>
    <script>
    	// REMOVE PRODUCT
    	$(document).on('click', '.btn-delete', function(e){
    		e.preventDefault();
    		if (confirm("Bạn có chắc chắn muốn xóa sản phẩm này ?")){
    			var productID = $(this).attr('value');
        		$.ajax({
        			type: 'POST',
        			url: '<%=request.getContextPath()%>/products/remove',
        			data: {
        				productID: productID,
        				action: 'post'
        			},
        			success: function(){
        				$('.product-item[data-index="' + productID + '"]').remove();
        			}
        		})
    		}
    	})
    </script>
</body>
</html>