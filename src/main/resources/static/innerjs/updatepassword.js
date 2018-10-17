$(function () {
    updatepasswordInit();
    updatepasswordListen();
})

function updatepasswordInit() {

}

function updatepasswordListen() {
    btnUpdatepassword();
}

function btnUpdatepassword() {
    $("#btn-updatepassword").on("click", function () {
        // 先验证新密码
        if (validatePwd()) return ;

        $.post(
            "/users/updatePassword",
            {
                "oldPassword" : $("#oldpassword").val(),
                "newPassword" : $("#newpassword").val()
            },
            function (res) {
                if (res != null && res.success) {
                    alert("修改成功！");
                    $("input[type='password']").val("");
                } else {
                    alert("修改失败，原密码错误！");
                    $("input[type='password']").val("");
                }
            }
        );
    });
}


// 验证不通过true 通过false
function validatePwd() {
    if ($("#oldpassword").val() == null || $("#oldpassword").val().trim().length < 1) {
        return true;
    }
    if ($("#newpassword").val() == null || $("#newpassword").val().trim().length < 6) {
        return true;
    }
    if ($("#repassword").val() != $("#newpassword").val()) {
        return true;
    }
    return false;
}