<%-- 
    Document   : stats
    Created on : Jul 27, 2024, 2:39:49 PM
    Author     : tuann
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1 class="text-black text-center mt-3">THONG KE DOANH THU</h1>
<div class="row">
    <div class="col-md-5 col-12">
        <table class="table table-striped">
            <tr>
                <th>ID</th>
                <th>Ten san pham</th>
                <th>Doanh thu</th>
            </tr>
            
            <c:forEach items="${revenues}" var="r">
                <tr>
                    <td>${r[0]}</td>
                    <td>${r[1]}</td>
                    <td>${String.format("%,d", r[2])} VND</td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div class="col-md-7 col-12">

    </div>
</div>