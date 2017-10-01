<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Dvd Library</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/dvdLibraryCss.css" rel="stylesheet">
    </head>
    <body>
        <div class="container-fluid">
            <div class="row" id ="searchArea">
                <a href="${pageContext.request.contextPath}/displayCreateDvdForm">
                    <button id="createDvd" action="createDvd" type="submit" class="btn btn-default col-sm-1 col-sm-offset-1">Create Dvd</button>
                </a>
                <form action="searchDvds" method="GET" id="searchForm" class="col-sm-9">
                    <input type="submit" class="btn btn-default col-sm-offset-2" style="margin-right: 15px;" id="searchSubmit" value="Search"/>
                    <div class="btn-group">
                        <select class="custom-select" id="searchDropdown" name="searchCategory">
                            <option selected>Search Category</option>
                            <option value="dvd_name">Title</option>
                            <option value="release_date">Release Year</option>
                            <option value="director_name">Director</option>
                            <option value="mpaa_rating">Rating</option>
                        </select>
                        <input type="text" size="35" name="searchTerm" id="searchTerm" value="Search Term"/>
                </form>
            </div>
            <hr style="border: 0; height: 1px; color: black; background-color: black">
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
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>

