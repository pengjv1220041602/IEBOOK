$(function () {
    bookformInit();
    formListen();

});

function bookformInit() {
    
}

function filepic() {
    $("#filepic").on("change", function () {
        return_image($("#filepic")[0], $("#picbook"));
    });
}


function formListen() {
    booksubmit();
    filepic();
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
function booksubmit() {
    $("#booksubmit").on("click", function () {
        if (validateForm()) return;
        var formdata = new FormData();
        formdata.append("id", $("#bookid").val());
        if ($("#filepic").get(0) != null && $("#filepic").get(0).files[0]!=null ) {
            formdata.append("picpathfile", $("#filepic").get(0).files[0]);
        }
        if ($("#bookpdf").get(0) != null && $("#bookpdf").get(0).files[0] != null) {
            formdata.append("bookpdf", $("#bookpdf").get(0).files[0]);
        }
        formdata.append("name", $("#name").val());
        formdata.append("kind.id", $("#kind option:selected").val());
        formdata.append("detail", $("#detail").val());
        formdata.append("author", $("#author").val());
        formdata.append("examine", 0);
        $.ajax({
            url:"/books/saveorupdatebook",
            type:"post",
            cache : false,
            contentType: false,
            processData: false,
            data:formdata,
            success:function (res) {
                if (res.success) {
                    alert("修改成功！");
                    window.location.href = "/books/examinebook";
                }
            }
        });
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