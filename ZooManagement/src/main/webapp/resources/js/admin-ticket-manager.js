function deleteConfirm(id) {
    var data = confirm("You are about to delete a ticket with ID " + id + ". This action cannot be undone!\nAre you sure you want to continue?");
    if (data == true) {
        document.getElementById('deleteFormId').value = id;
        document.getElementById('deleteForm').submit();
    }
}