<%-- 
    Document   : dvdDetails
    Created on : Sep 5, 2017, 10:06:25 PM
    Author     : bruce_breslin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dvd Details</title>
    </head>
    <body>
        <div class="container">
            <h1><c:out value="${dvd.title}"/></h1>
            <hr>
            <p>Release Year: <c:out value="${dvd.releaseYear}"/></p>
            <p>Director: <c:out value="${dvd.directorName}"/></p>
            <p>Rating: <c:out value="${dvd.mpaaRating}"/></p>
            <p>Notes: <c:out value="${dvd.userNotes}"/></p>
            <a href="index">
                <input type="button" class="btn btn-default" value="Back"/>
            </a>
        </div>
    </body>
</html>
