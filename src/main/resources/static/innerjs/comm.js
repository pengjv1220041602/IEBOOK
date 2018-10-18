/*查询地址栏后的参数*/
//使用方法：调用此方法，加上对应的字符串即可返回对应的value ： 例如：?title=hello   GetQueryString("title")===>hello
function GetQueryString (name) {
    var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if(r!=null)return  unescape(r[2]); return null;
}


