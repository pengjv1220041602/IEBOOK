$(function () {
    bookformInit();
    formListen();
});

function bookformInit() {
    
}
function formListen() {
    booksubmit();
    bookpic();
}

function booksubmit() {
    $("#booksubmit").on("click", function () {
        if (validateForm()) return;
        var formdata = new FormData();
        formdata.append("picpathfile", $("#bookpic").get(0).files[0]);
        formdata.append("picpathfile1", $("#bookpic1").get(0).files[0]);
        formdata.append("picpathfile2", $("#bookpic2").get(0).files[0]);
        formdata.append("picpathfile3", $("#bookpic3").get(0).files[0]);
        formdata.append("name", $("#name").val());
        formdata.append("kind.id", $("#kind option:selected").val());
        formdata.append("detail", $("#detail").val());
        formdata.append("author", $("#author").val());
        formdata.append("bookpdf", $("#bookpdf").get(0).files[0]);
        $.ajax({
            url:"/books/saveorupdatebook",
            type:"post",
            cache : false,
            contentType: false,
            processData: false,
            data:formdata,
            success:function (res) {
                if (res.success) {
                    alert("添加成功！");
                    window.location.href = "/books/examinebook";
                }
            }
        });
    });
}
function bookpic() {
    $("#filebook1").on("click", function () {
        $("#bookpic1").click();
    });
    $("#filebook2").on("click", function () {
        $("#bookpic2").click();
    });
    $("#filebook3").on("click", function () {
        $("#bookpic3").click();
    });
    $("#bookpic").on("change", function () {
        return_image($("#bookpic")[0], $("#picbook"));
    });
    $("#bookpic1").on("change", function () {
        return_image($("#bookpic1")[0], $("#picbook1"));
    });
    $("#bookpic2").on("change", function () {
        return_image($("#bookpic2")[0], $("#picbook2"));
    });
    $("#bookpic3").on("change", function () {
        return_image($("#bookpic3")[0], $("#picbook3"));
    });
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
function validateForm() {
    $(".validates").each(function () {
        if ($(this).val() == null || $(this).val().trim().length > 0) {
            return true;
        }
    });
    return false;
}