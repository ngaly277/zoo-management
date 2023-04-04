function deleteConfirm(id) {
    var data = confirm("You are about to delete a ticket with ID " + id + ". This action cannot be undone!\nAre you sure you want to continue?");
    if (data == true) {
        document.getElementById('deleteFormId').value = id;
        document.getElementById('deleteForm').submit();
    }
}

function validateFormEdit() {
    var form = document.forms["editform"];

    try {
        if (parseInt(form["amount"].value) < 0) {
            throw "Invalid amount value!";
        }
        if (parseInt(form["price"].value) < 0) {
            throw "Invalid price value!";
        }
    } catch (error) {
        alert(error);
        return false;
    }
}

function validateFormAgeEdit() {
    var form = document.forms["editformage"];

    try {
        if (form["desp"].value.trim() == "") {
            throw "Age Description cannot be empty!";
        }
    } catch (error) {
        alert(error);
        return false;
    }
}