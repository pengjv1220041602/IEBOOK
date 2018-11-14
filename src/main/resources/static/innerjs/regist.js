$(function () {
   registInit();
   registListen();
});

function registInit() {

}

function registListen() {
    submitForm();
    $("#photo").on("change",function () {
        return_image($("#photo")[0], $("#photo-show"));
    })
}
/* 回显图片 */
function return_image(fileEle, imgEle) {
    var fileReader = new FileReader();
    var files = fileEle.files[0];
    fileReader.readAsDataURL(files);
    fileReader.onloadend = function(e) {
        imgEle.prop("src", this.result);
    }
}
function submitForm() {
    $("#userregist").on("click", function () {
        if (validateForm()) return ;
        var formdata = new FormData();
        formdata.append("name", $("#name").val());
        formdata.append("username",$("#username").val());
        formdata.append("password", $("#password").val());
        formdata.append("email", $("#email").val());
        formdata.append("phfile", $("#photo").get(0).files[0]);
        $.ajax({
            url:"/saveuser",
            cache : false,
            contentType: false,
            processData: false,
            type:"post",
            data:formdata,
            success:function (res) {
                if (res != null && res.success) {
                    alert("添加成功！");
                    window.location.href = "/login";
                }
            }
        });
    })
}
function validateForm() {
    $(".validates").each(function () {
        if ($(this).val() == null || $(this).val().trim().length < 1) {
            return true;
        }
    });
    return false;
}
