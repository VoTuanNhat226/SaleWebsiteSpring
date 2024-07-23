<%-- 
    Document   : index
    Created on : Jul 17, 2024, 7:34:06 AM
    Author     : tuann
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="text-center text-black mb-3 mt-3">DANH SACH SAN PHAM</h1>
<div class="row " style="margin-top: 20px">
    <div class="col-md-3 col-12" style="background-color: #DDDDDD; height: 350px">
        <c:url value="/" var="action"/>
        <form action="${action}">
            <div class="mb-3 mt-3">
                <label for="q" class="form-label">Tim theo ten</label>
                <input type="search" class="form-control" id="q" placeholder="Tu khoa..." name="q">
            </div>
            <div class="mb-3 mt-3">
                <label for="fromPrice" class="form-label">Gia tu (VND)</label>
                <input type="number" class="form-control" id="fromPrice" placeholder="Tu..." name="fromPrice">
            </div>
            <div class="mb-3 mt-3">
                <label for="toPrice" class="form-label">Den gia (VND)</label>
                <input type="number" class="form-control" id="toPrice" placeholder="Den..." name="toPrice">
            </div>
            <div class="mb-3 mt-3">
                <input type="submit" class="btn btn-success" value="Tim san pham"/>
            </div>
        </form>
    </div>
    <div class="col-md-7 col-12">
        <table class="table table-striped">
            <tr>
                <th>ID</th>
                <th>Hinh anh</th>
                <th>Ten</th>
                <th>Mo ta</th>
                <th>Gia</th>
                <th>Tuy chinh</th>
            </tr>
            <c:forEach items="${products}" var="p">
                <tr id="product${p.id}">
                    <td>${p.id}</td>
                    <td>
                        <img width="120" src="${p.image}" alt="${p.name}"/>
                    </td>
                    <td>${p.name}</td>
                    <td>${p.description}</td>
                    <td>${String.format("%,d", p.price)} VND</td>
                    <td>
                        <a href="<c:url value="/products/${p.id}"/>" class="btn btn-info">Cap nhat</a>
                        <c:url value="/api/products/${p.id}" var="endpoint" />
                        <button class="btn btn-danger" onclick="deleteProduct('${endpoint}', ${p.id})">Xoa</button>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div class="col-md-2 col-12">
        <a href="<c:url value="/products" />" class="btn btn-success mb-3" >Them san pham</a>
    </div>
</div>
