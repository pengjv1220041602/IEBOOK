$(function () {
    // 登录初始化事件
    loginInit();
    // 表单触发事件
    formListen();
});

function loginInit() {
    
}
function formListen() {
    $("#btnLogin").on("click", function () {
       login();
    });
}
function login() {
    // 验证事件
    if (!validateForm()) return ;

    $.ajax({
        url:"/userLogin",
        type:"post",
        data:{
            username : $("#username").val(),
            password : $("#password").val()
        },
        success:function (res) {
            if (res.success) {
               location.href = "/home";
            }
        },
        error : function (res) {
            
        }
    })

}

function validateForm() {
    var result = true;
    $(".inuser").each(function () {
        if ($(this).val() == null) {
            result = false;
        }
    });
    return result;
}