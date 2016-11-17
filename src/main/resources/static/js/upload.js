/**
 * Created by ubuntu on 16-11-16.
 *
 */

$("#upload").click(function () {
    if(!validUpload()) return;
    $("#file").upload({
        action: "/upload/batch/picture",
        oncomplete: function (result) {
            var message = result.responseText;
            if (result.status == 200) {
                $("#img").attr("src", "file/" + message.split(":"))
                $.ligerDialog.success("上传图片成功");
            } else {
                $.ligerDialog.error(message);
            }
        },
        onprogress: function (e) {
            $("#progress").html("上传进度： " + (e.onloadend / e.total * 100).toFixed(2) + "%");
        }
    });
});


// 验证图片格式
function validUpload() {
    var img = $("#file").val();
    if (img = "") {
        $.ligerDialog.error("请上传图片");
        return false;
    }
    if (!img.endWith(".png") && !img.endWith(".jpg")) {
       $.ligerDialog.error("图片格式不正确");
        return false;
    }
    return true;
}
