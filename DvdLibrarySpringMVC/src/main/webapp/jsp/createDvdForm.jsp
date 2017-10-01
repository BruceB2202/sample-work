<%-- 
    Document   : createDvdForm
    Created on : Sep 4, 2017, 9:50:09 AM
    Author     : bruce_breslin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Create Dvd</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/dvdLibraryCss.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <h1>Create Dvd</h1>
            <hr>
            <div class="row">
                <form id="createDvdForm" class="form-horizontal" role="form" method="POST" action="createDvd">
                    <div class="form-group">
                        <label for="add-dvd-title" class="control-label col-sm-2 col-sm-offset-1">Dvd Title:</label>
                        <div class="col-sm-5">
                            <input type="text" class="form-control" name="dvdTitle" placeholder="Dvd Title"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add-release-year" class="control-label col-sm-2 col-sm-offset-1">Release Year:</label>
                        <div class="col-sm-5">
                            <input type="text" class="form-control" name="releaseYear" placeholder="Release Year"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add-director" class="control-label col-sm-2 col-sm-offset-1">Director:</label>
                        <div class="col-sm-5">
                            <input type="text" class="form-control" name="director" placeholder="Director"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add-dvd-rating" class="col-sm-2 col-sm-offset-1">Rating:</label>
                        <select class="custom-select col-sm-2" name="rating">
                            <option selected>Choose Rating</option>
                            <option value="G">G</option>
                            <option value="PG">PG</option>
                            <option value="PG-13">PG-13</option>
                            <option value="R">R</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="add-user-note" class="col-sm-2 col-sm-offset-1">User Notes:</label>
                        <div class="col-sm-5">
                            <textarea style="margin-left: -65px;" rows="4" class="form-control" name="userNotes" placeholder="Enter notes."></textarea>
                        </div>
                    </div>

                    <div class="col-sm-2 col-sm-offset-3">
                        <a href="${pageContext.request.contextPath}/index">
                            <input type="button" class="btn btn-default" value="Cancel"/>
                        </a>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-2">
                            <input type="submit" class="btn btn-default" value="Create Dvd"/>
                        </div>
                    </div>

                </form>
            </div>
        </div>
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>
</html>
