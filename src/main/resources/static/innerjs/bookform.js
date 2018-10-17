$(function () {
    bookformInit();
    formListen();
});

function bookformInit() {
    
}
function formListen() {
    booksubmit();
}

function booksubmit() {
    $("#booksubmit").on("click", function () {
        if (validateForm()) return;

        $.post("/books/addbook",
            {
                "name":$("#name").val(),
                "kind.id":$("#kind option:selected").val(),
                "detail":$("#detail").val(),
                "author":$("#author").val()
            },
            function (res) {
                if (res.success) {
                    alert("添加成功！");
                }
            }
        );
    });
}

function validateForm() {
    $(".validates").each(function () {
        if ($(this).val() == null || $(this).val().trim().length > 0) {
            return true;
        }
    });
    return false;
}