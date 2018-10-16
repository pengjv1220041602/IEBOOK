$(function () {
   kindformsubmit();
});

function kindformsubmit() {
    $("#btn-kind").on("click", function () {
       if (!validateForm()) return;
       $.post("/kinds/addkind", {"name" : $("#kindname").val()}, function (res) {
           if (res.success) {
               alert("添加成功！");
               location.reload();
           } else {
               alert("添加失败！");
           }
       });
    });
}

function validateForm() {
    if ($("#kindname").val() != null && $("#kindname").val().trim().length > 0) {
        return true;
    }
    return false;
}