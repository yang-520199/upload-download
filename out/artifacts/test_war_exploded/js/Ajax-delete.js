var xmlHTTP;
function createXMLHttpRequest() {
    if (window.XMLHttpRequest){
        xmlHTTP=new XMLHttpRequest();
    }else {
        xmlHTTP =new ActiveXObject("Microsoft.XMLHTTP");
    }
}
function remove2() {
    createXMLHttpRequest();
    var student_no=document.getElementById("id");
    // var file_num=document.getElementById("file_num");
    var url="DeleteServlet.do?file_num=2&id="+escape(student_no.value);
    xmlHTTP.open("GET",url,true);
    xmlHTTP.onreadystatechange=handleStateChange2;
    xmlHTTP.send(null);
}
function handleStateChange2() {
    if (xmlHTTP.readyState==4){
        if (xmlHTTP.status==200){
            alert("成功删除，请重新上传!")

        }
    }
}
function remove1() {
    createXMLHttpRequest();
    var student_no=document.getElementById("id");
    // var file_num=document.getElementById("file_num");
    var url="DeleteServlet.do?file_num=1&id="+escape(student_no.value);
    xmlHTTP.open("GET",url,true);
    xmlHTTP.onreadystatechange=handleStateChange2;
    xmlHTTP.send(null);
}
function remove3() {
    createXMLHttpRequest();
    var student_no=document.getElementById("id");
    // var file_num=document.getElementById("file_num");
    var url="DeleteServlet.do?file_num=3&id="+escape(student_no.value);
    xmlHTTP.open("GET",url,true);
    xmlHTTP.onreadystatechange=handleStateChange2;
    xmlHTTP.send(null);
}
function listFile() {
    createXMLHttpRequest();
    var student_no=document.getElementById("id");
    // var file_num=document.getElementById("file_num");
    var url="ListFileServlet.do?id="+escape(student_no.value);
    xmlHTTP.open("GET",url,true);
    xmlHTTP.onreadystatechange=handleStateChange1;
    xmlHTTP.send(null);
}
function handleStateChange1() {
    if (xmlHTTP.readyState==4){
        if (xmlHTTP.status==200){
            window.location="http://localhost:8080/test_war_exploded/ListFileServlet.do"
        }
    }
}