<%-- 
    Document   : editDvdForm
    Created on : Sep 5, 2017, 3:28:20 PM
    Author     : bruce_breslin
--%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
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
            <h1>Edit Dvd</h1>
            <hr>
            <sf:form class="form-horizontal" role="form" modelAttribute="dvd"
                     action="editDvd" method="POST">
                <div class="form-group">
                    <label for="add-dvd-title" class="control-label col-sm-2 col-sm-offset-1">Dvd Title:</label>
                    <div class="col-sm-5">
                        <sf:input type="text" class="form-control" id="add-dvd-title"
                                  path="title" placeholder="Dvd Title"/>
                        <sf:errors path="title" cssclass="error"></sf:errors>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add-release-year" class="control-label col-sm-2 col-sm-offset-1">Release Year:</label>
                        <div class="col-sm-5">
                        <sf:input type="text" class="form-control" id="add-release-year"
                                  path="releaseYear" placeholder="ReleaseYear"/>
                        <sf:errors path="releaseYear" cssclass="error"></sf:errors>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add-director" class="control-label col-sm-2 col-sm-offset-1">Director:</label>                         
                        <div class="col-sm-5">
                        <sf:input type="text" class="form-control" id="add-director"
                                  path="directorName" placeholder="Director"/>
                        <sf:errors path="directorName" cssclass="error"></sf:errors>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add-dvd-rating" class="col-sm-2 col-sm-offset-1">Rating:</label>
                        <div class="col-sm-5">
                        <sf:select class="custom-select col-sm-4" name="rating" id="add-rating" path="mpaaRating" placeholder="Rating">
                            <option selected>Choose Rating</option>
                            <option value="G">G</option>
                            <option value="PG">PG</option>
                            <option value="PG-13">PG-13</option>
                            <option value="R">R</option>
                        </sf:select>
                        <sf:errors path="mpaaRating" cssclass="error"></sf:errors>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add-user-note" class="col-sm-2 col-sm-offset-1">User Notes:</label>
                        <div class="col-md-8">
                        <sf:input type="text" class="form-control" id="add-user-note"
                                  path="userNotes" placeholder="User Notes"/>
                        <sf:errors path="userNotes" cssclass="error"></sf:errors>
                        <sf:hidden path="dvdId"/>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-md-offset-4 col-md-8">
                        <a href="index">
                            <input type="button" class="btn btn-default" value="Cancel"/>
                        </a>
                        <input type="submit" class="btn btn-default" value="Update Dvd"/>
                    </div>
                </div>
            </sf:form>

        </div>
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>
</html>
