function validateInput(event) {
    var charCode = event.which || event.keyCode;
    var charTyped = String.fromCharCode(charCode);
    var regex = /^[0-9]+$/;

    if(!regex.test(charTyped)) {
        event.preventDefault();
    }
}

function validatePastedInput(event) {
    var clipboardData = event.clipboardData || window.clipboardData;
    var pastedValue = clipboardData.getData('text');
    var regex = /^[0-9]+$/;

    if(!regex.test(pastedValue)) {
        event.preventDefault();
    }
}

function validateAlphaInput(event) {
    var charCode = event.which || event.keyCode;
    var charTyped = String.fromCharCode(charCode);
    var regex = /^[a-zA-Z]+$/;

    if(!regex.test(charTyped)) {
        event.preventDefault();
    }
}

function validatePastedAlphaInput(event) {
    var clipboardData = event.clipboardData || window.clipboardData;
    var pastedValue = clipboardData.getData('text');
    var regex = /^[a-zA-Z]+$/;

    if(!regex.test(pastedValue)) {
        event.preventDefault();
    }
}

function validateEmailInput(event) {
    var charCode = event.which || event.keyCode;
    var charTyped = String.fromCharCode(charCode);
    var regex = /^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/;

    if(!regex.test(charTyped)) {
        event.preventDefault();
    }
}

function validatePastedEmailInput(event) {
    var clipboardData = event.clipboardData || window.clipboardData;
    var pastedValue = clipboardData.getData('text');
    var regex = /^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/;

    if(!regex.test(pastedValue)) {
        event.preventDefault();
    }
}