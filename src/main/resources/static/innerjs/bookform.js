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
        var formdata = new FormData();
        formdata.append("picpathfile", $("#bookpic").get(0).files[0]);
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
            function (res) {
                if (res.success) {
                    alert("添加成功！");
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