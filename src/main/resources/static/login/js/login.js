$(function () {
    // 登录初始化事件
    loginInit();
    // 表单触发事件
    formListen();
});
function refreshVi () {
    $("#img-code").prop("src", "/viCode?rand="+new Date());
}
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
            password : $("#password").val(),
            code : $("#txt-code").val()
        },
        success:function (res) {
            if (res.success) {
            	console.log(res.data.power);
                location.href = "/main";
            } else {
                $("#img-code").prop("src", "");
                $("#img-code").prop("src", "/viCode?rand="+new Date());
                $("#tip-error").text(res.message)
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


// 回车事件
document.onkeyup = function (e) {//按键信息对象以函数参数的形式传递进来了，就是那个e
//    var code = e.charCode || e.keyCode;  //取出按键信息中的按键代码(大部分浏览器通过keyCode属性获取按键代码，但少部分浏览器使用的却是charCode)
    var e = e || window.event;
    if (e.keyCode == 13) {
        //此处编写用户敲回车后的代码
        login();
    }
}