<%-- 
    Document   : header
    Created on : Jul 20, 2024, 1:33:55 PM
    Author     : tuann
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-sm navbar-dark" style="background-color: #0866ff">
    <div class="container-fluid">
        <a class="navbar-brand" href="<c:url value="/"/>">CellPhone-Admin</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="collapsibleNavbar">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/"/>" style=" color:#fff">Trang chu</a>
                </li>
                <c:forEach items="${categorys}" var="c">
                    <c:url value="/" var="cateUrl">
                        <c:param name="cateId" value="${c.id}"/>
                    </c:url>
                    <li class="nav-item">
                        <a class="nav-link" href="${cateUrl}" style=" color:#fff">${c.name}</a>
                    </li>
                </c:forEach>
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/stats"/>" style=" color:#fff">Thong ke</a>
                </li>
                <s:authorize access="!isAuthenticated()">
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/login"/>" style=" color:#fff">Dang nhap</a>
                    </li>
                </s:authorize>
                <s:authorize access="isAuthenticated()">
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/"/>" style=" color:#fff">Welcome <s:authentication property="principal.username"/></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/logout"/>" style=" color:#fff">Dang xuat</a>
                    </li>
                </s:authorize>
            </ul>
        </div>
    </div>
</nav>
