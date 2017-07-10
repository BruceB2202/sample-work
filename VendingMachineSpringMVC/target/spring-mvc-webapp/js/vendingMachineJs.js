$(document).ready(function () {



//on-click handlers for money adding buttons
    var balance = 0.00;

    $('#addDollarBtn').click(function (event) {
        balance += 1.00;
        clearCreditDisplay();
        displayCreditsAvail(balance);
    });
    $('#addQuarterBtn').click(function (event) {
        balance += 0.25;
        clearCreditDisplay();
        displayCreditsAvail(balance);
    });
    $('#addDimeBtn').click(function (event) {
        balance += 0.10;
        clearCreditDisplay();
        displayCreditsAvail(balance);
    });
    $('#addNickleBtn').click(function (event) {
        balance += 0.05;
        clearCreditDisplay();
        displayCreditsAvail(balance);
    });
    $('#makePurchaseBtn').click(function (event) {
        balance = 0.00;
    });
    $('#changeReturnBtn').click(function (event) {
            balance = 0.00;
    });
    $('#makePurchaseBtn').click(function (event) {
       $('#purchaseChangeForm').attr("action", "vendProduct");
       $('#purchaseChangeForm').submit();
    });
    $('#changeReturnBtn').click(function (event) {
       $('#purchaseChangeForm').attr("action", "getChange");
       $('#purchaseChangeForm').submit();
    });
});

function clearChangeDisplay() {
    $('#changeReturnDisplay').val(' ');
}

function clearSelectedItemDisplay() {
    $('#itemSelectionWindow').val(' ');
}

function displayWantedItemInSelection(productId) {
    $('#itemSelectionWindow').val(productId);
}

function displayCreditsAvail(balance) {
    $('#creditsInsertedDisplay').val(balance.toFixed(2));
}

function clearCreditDisplay() {
    $('#creditsInsertedDisplay').val(' ');
}

function clearMessageDisplay() {
    $('#messageDisplay').val(' ');
}

function clearMenu() {
    $('#menuDisplay').empty();
}

function resetChangeReturnDisplay() {
    $('#changeReturnDisplay').val("Quarters: \n Dimes: \n Nickels: \n Pennies:");
}

function defaultItemSelection() {
    $('#itemSelectionWindow').val("1");
}