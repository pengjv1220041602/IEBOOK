$(function () {
    registInit();
    registListen();
});

function registInit() {
    var nameId = sessionStorage.getItem("nameId");
    if (nameId != null && nameId != "undefined") {
        $("#name").val(nameId);
    }
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
        formdata.append("id", $("#userid").val())
        formdata.append("name", $("#name").val());
        formdata.append("username",$("#username").val());
        formdata.append("email", $("#email").val());
        if ($("#photo").get(0) != null && $("#photo").get(0).files[0] != null) {
            formdata.append("phfile", $("#photo").get(0).files[0]);
        }
        $.ajax({
            url:"/users/updateuser",
            cache : false,
            contentType: false,
            processData: false,
            type:"post",
            data:formdata,
            success:function (res) {
                if (res != null && res.success) {
                    sessionStorage.setItem("nameId", $("#name").val());
                    alert("修改成功！");
                    location.reload()
                } else {
                    alert("修改失败！")
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
