<%-- 
    Document   : displaySearchResults
    Created on : Sep 5, 2017, 11:37:12 PM
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
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <title>Search Results</title>
    </head>
    <body>
        <div class="container">
            <h1>Dvds</h1>
            <hr>
            <div class="row" id="contentArea">
                <div class="col-sm-10 col-sm-offset-1">
                    <table id="dvdTable" class="table table-hover table-striped table-bordered">
                        <tr>
                            <th width="25%">Title</th>
                            <th width="25%">Release Date</th>
                            <th width="13%">Director</th>
                            <th width="12%">Rating</th>
                            <th width="25%"></th>
                        </tr>
                        <c:forEach var="currentDvd" items="${dvdList}">
                            <tr>
                                <td>
                                    <a href="displayDvdDetails?dvdId=${currentDvd.dvdId}">
                                        <c:out value="${currentDvd.title}"/>
                                    </a>
                                </td>
                                <td>
                                    <c:out value="${currentDvd.releaseYear}"/>
                                </td>
                                <td>
                                    <c:out value="${currentDvd.directorName}"/>
                                </td>
                                <td>
                                    <c:out value="${currentDvd.mpaaRating}"/>
                                </td>
                                <td style="text-align: center">
                                    <a href="editDvdDetails?dvdId=${currentDvd.dvdId}">Edit</a> | <a href="deleteDvd?dvdId=${currentDvd.dvdId}">Delete</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
            <a href="index">
                <input type="button" class="btn btn-default" value="Back"/>
            </a>

        </div>
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>
</html>
