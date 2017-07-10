$(document).ready(function() {

    loadMenu();

    //on-click handlers for money adding buttons
    var balance = 0.00;
    $('#addDollarBtn').click(function(event) {
        clearChangeDisplay();
        balance += 1.00;
        clearMessageDisplay();
        clearCreditDisplay();
        displayCreditsAvail(balance);
    });
    $('#addQuarterBtn').click(function(event) {
        clearChangeDisplay();
        balance += 0.25;
        clearMessageDisplay();
        clearCreditDisplay();
        displayCreditsAvail(balance);
    });
    $('#addDimeBtn').click(function(event) {
        clearChangeDisplay();
        balance += 0.10;
        clearMessageDisplay();
        clearCreditDisplay();
        displayCreditsAvail(balance);
    });
    $('#addNickleBtn').click(function(event) {
        clearChangeDisplay();
        balance += 0.05;
        clearMessageDisplay();
        clearCreditDisplay();
        displayCreditsAvail(balance);
    });

    //on-click handler for purchaseItemBtn
    $('#makePurchaseBtn').click(function(event) {
        var itemSelected = $('#itemSelectionWindow').val();
        if (itemSelected == 'Select Item') {
            clearMessageDisplay();
            $('#messageDisplay').val('No item selected.');
        } else {
            $.ajax({
                type: 'GET',
                url: 'http://localhost:8080/money/' + balance.toFixed(2) + '/item/' + itemSelected,
                success: function(change) {
                    clearSelectedItemDisplay();
                    clearMessageDisplay();
                    $('#messageDisplay').val('Thank You!');
                    clearCreditDisplay();
                    balance = 0;
                    displayCreditsAvail(balance);
                    clearChangeDisplay();
                    displayChange(change);
                    clearMenu();
                    loadMenu();
                },
                error: function(xhr, status, error) {
                    var errorMessageText = xhr.responseText.substring(12, xhr.responseText.length - 2);
                    clearChangeDisplay();
                    clearMessageDisplay();
                    $('#messageDisplay').val(errorMessageText);
                }
            });
        }
    });

    //on-click handler for changeReturnBtn
    $('#changeReturnBtn').click(function(event) {
        clearChangeDisplay();
        clearSelectedItemDisplay();
        clearMessageDisplay();
        calculateChange(balance);
        clearCreditDisplay();
        balance = 0.00;
        displayCreditsAvail(balance);
    });




});

function clearSelectedItemDisplay(){
    $('#itemSelectionWindow').val(' ');
}


function displayCreditsAvail(balance) {
    $('#creditsInsertedDisplay').val('$' + balance.toFixed(2));
}

function clearCreditDisplay() {
    $('#creditsInsertedDisplay').empty();
}

function clearMessageDisplay() {
    $('#messageDisplay').empty();
}

function clearMenu() {
    $('#menuDisplay').empty();
}

function loadMenu() {

    var menuWindow = $('#menuDisplay');

    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/items',
        success: function(data, status) {
            $.each(data, function(index, item) {
                var snackId = item.id;
                var snackName = item.name;
                var price = item.price.toFixed(2);
                var quantity = item.quantity;

                var button = '<div class="col-sm-4 menuItemBtns">';
                button += '<div class="btn btn-default btn-block" onclick="showInChoosenItemDisplay(' + snackId + ')">';
                button += '<p class="text-left">' + snackId + '</p>';
                button += '<h4 class="text-center">' + snackName + '</h4>';
                button += '<h5 class="text-center"> $' + price + '</h5><br>';
                button += '<p class="text-center">Remaining: ' + quantity + '</p>';
                button += '</div></div>'

                menuWindow.append(button);
            });
        },
        error: function() {
            $('#messageDisplay').val('Out of order!');
        }
    });

}

function showInChoosenItemDisplay(snackId) {
    $('#itemSelectionWindow').val(snackId);
}

function clearChangeDisplay() {
    $('#changeReturnDisplay').val(' ');
}

function displayChange(change) {
    var quartersToGive = change.quarters;
    var dimesToGive = change.dimes;
    var nickelsToGive = change.nickels;
    var penniesToGive = change.pennies;
    var changeToGive = 'Quarters: ' + quartersToGive;
    changeToGive += '\nDimes: ' + dimesToGive;
    changeToGive += '\nNickels: ' + nickelsToGive;
    changeToGive += '\nPennies: ' + penniesToGive;
    $('#changeReturnDisplay').val(changeToGive);
}

function calculateChange(balance) {
    var quarters = 0;
    var dimes = 0;
    var nickels = 0;
    var pennies = 0;

    var balanceInCents = balance * 100;
    if(balanceInCents > 24) {
        quarters = Math.floor(balanceInCents / 25);
        balanceInCents = balanceInCents % 25;
        $("quarters").value = quarters
    }

    if(balanceInCents > 9) {
        dimes = Math.floor(balanceInCents / 10);
        balanceInCents = balanceInCents % 10;
        $("dimes").value = dimes
    }

    if(balanceInCents > 4) {
        nickels = Math.floor(balanceInCents / 5);
        balanceInCents = balanceInCents % 5;
        $("nickels").value = nickels
    }

    if(balanceInCents > 0) {
        pennies = Math.floor(balanceInCents);
        balanceInCents = balanceInCents % 1;
        $("pennies").value = pennies
    }

    var changeMessage = 'Quarters: ' + quarters;
    changeMessage += '\nDimes: ' + dimes;
    changeMessage += '\nNickels: ' + nickels;
    changeMessage += '\nPennies: ' + pennies;
    $('#changeReturnDisplay').val(changeMessage);


}
