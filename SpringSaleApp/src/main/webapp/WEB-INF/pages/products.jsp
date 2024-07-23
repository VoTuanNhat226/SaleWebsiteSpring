<%-- 
    Document   : products
    Created on : Jul 20, 2024, 1:54:31 PM
    Author     : tuann
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1 class="text-center text-black mt-3">QUAN TRI SAN PHAM</h1>
<c:url value="/products" var="action"/>
<form:form method="post" action="${action}" modelAttribute="product" enctype="multipart/form-data">
    <form:errors path="*" cssClass="alert alert-danger" element="div"/>
    <div class="mb-3 mt-3">
        <label for="name" class="form-label">Ten san pham</label>
        <form:input path="name" type="text" class="form-control" id="name" placeholder="Nhap ten san pham..." name="name" />
        <form:errors path="name" cssClass="alert alert-danger" element="div"/>
    </div>
    <div class="mb-3 mt-3">
        <label for="description" class="form-label">Mo ta san pham</label>
        <form:input path="description" type="text" class="form-control" id="description" placeholder="Nhap mo ta san pham..." name="description" />
    </div>
    <div class="mb-3 mt-3">
        <label for="price" class="form-label">Gia san pham</label>
        <form:input path="price" type="number" class="form-control" id="price" placeholder="Nhap gia san pham..." name="price" />
    </div>
    <div class="mt-3 mb-3">
        <label for="cate" class="form-label">Danh muc san pham</label>
        <form:select path="categoryId" class="form-select" id="cate">
            <c:forEach items="${categorys}" var="c">
                <c:choose>
                    <c:when test="${c.id == product.categoryId.id}">
                        <option value="${c.id}" selected>${c.name}</option>
                    </c:when>
                    <c:otherwise>
                        <option value="${c.id}">${c.name}</option>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </form:select>
    </div>
    <div class="mb-3 mt-3">
        <label for="file" class="form-label">Anh san pham</label>
        <form:input path="file" accept=".png, .jpg, .webp" type="file" class="form-control" id="file" name="file" />
        <c:if test="${product.id != null}">
            <img src="${product.image}" alt="${product.name}" width="200"/>
        </c:if>
    </div>
    <div class="mb-3 mt-3">
        <form:hidden path="id"/>
        <form:hidden path="image"/>
        <button class="btn btn-success" type="submit">
            <c:choose>
                <c:when test="${product.id != null}">Cap nhat san pham</c:when>
                <c:otherwise>Them san pham</c:otherwise>
            </c:choose>
        </button>
    </div>
</form:form>
