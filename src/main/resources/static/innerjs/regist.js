$(function () {
   registInit();
   registListen();
});

function registInit() {

}

function registListen() {
    submitForm();
}

function submitForm() {
    $("#userregist").on("click", function () {
        if (validateForm()) return ;
        $.post(
            "/users/saveorupdateuser",
            {
                "name" : $("#name").val(),
                "username" :$("#username").val(),
                "password" :$("#password").val()
            },
            function (res) {
                if (res != null && res.success) {
                    alert("添加成功！");
                    window.location.href = "/login";
                }
            }
        );
    });
}

function validateForm() {
    $(".validates").each(function () {
        if ($(this).val() == null || $(this).val().trim().length < 1) {
            return true;
        }
    });
    return false;
}
