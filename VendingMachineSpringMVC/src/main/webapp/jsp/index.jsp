<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Vending Machine</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/vendingMachineCSS.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <h1 id="pageTitle" class="text-center">Vending Machine</h1>
            <hr>
            <div class="row" id="mainPageArea">
                <!-- Begin menu section -->
                <div class="col-sm-8" id="menuDisplayArea">
                    <c:forEach var="currentSnack" items="${inventory}">

                        <div class="col-sm-4 menuItemBtns">
                            <div class="btn btn-default btn-block" onclick="displayWantedItemInSelection(${currentSnack.productId})">
                                <p class="text-left"><c:out value="${currentSnack.productId}"/></p>
                                <h4 class="text-center"><c:out value="${currentSnack.productName}"/></h4>
                                <h5 class="text-center"><c:out value="${currentSnack.productCost}"/></h5><br>
                                <p class="text-center">Remaining: <c:out value="${currentSnack.productInStock}"/></p>
                            </div>
                        </div>

                    </c:forEach>
                </div>


                <!--Begin input output section -->
                <div class="col-sm-4" id="ioSection">
                    <form class="form-horizontal" id="purchaseChangeForm" role="form" method="GET" action="vendProduct">
                        <div class="form-group text-center" id="ioForm">
                            <label for="creditsInsertedDisplay">Total $ In</label>
                            <input type="text" class="form-control" id="creditsInsertedDisplay" name="balance" readonly="readonly" value="${balance}">
                            <div class="row" style="margin-top: 20px;">
                                <input type="button" class="btn btn-success col-sm-3 col-sm-offset-2" value="$1.00" id="addDollarBtn">
                                <input type="button" class="btn btn-success col-sm-3 col-sm-offset-1" value="$0.25" id="addQuarterBtn">
                            </div>
                            <div class="row" style="margin-top: 8px; margin-bottom: 15px;">
                                <input type="button" class="btn btn-success col-sm-3 col-sm-offset-2" value="$0.10" id="addDimeBtn">
                                <input type="button" class="btn btn-success col-sm-3 col-sm-offset-1" value="$0.05" id="addNickleBtn">
                            </div>
                            <label for="messageDisplay">Messages</label>
                            <input type="text" class="form-control" id="messageDisplay" name="errors" readonly="readonly" value="${message}${errorMessage}">
                            <div class="row" style="margin-top: 15px;">
                                <label for="itemSelectionWindow">Item: </label>
                                <input type="text" class="text-center" id="itemSelectionWindow" name="productId" readonly="readonly" value="${productId}">
                            </div>
                            <input type="button" class="btn btn-primary col-sm-8 col-sm-offset-2" value="Purchase Item" id="makePurchaseBtn" style="margin-top: 10px; margin-bottom: 15px;">
                            <label for="changeReturnDisplay">Change</label>
                            <textarea class="form-control" rows="5" id="changeReturnDisplay" readonly="read">
                            Quarters: ${quarters}
                            Dimes: ${dimes}
                            Nickels: ${nickels}
                            Pennies: ${pennies}
                            </textarea>
                            <input type="button" class="btn btn-primary col-sm-8 col-sm-offset-2" id="changeReturnBtn" value="Change Return" style="margin-top: 10px;">
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/vendingMachineJs.js"></script>

    </body>
</html>