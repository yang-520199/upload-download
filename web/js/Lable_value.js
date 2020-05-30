var xmlHTTP;
function createXMLHttpRequest() {
    if (window.XMLHttpRequest){
        xmlHTTP=new XMLHttpRequest();
    }
    else {
        xmlHTTP=new ActiveXObject("Microsoft.XMLHTTP");
    }
}
function Value_lable() {
    createXMLHttpRequest();
    var student_no=document.getElementById("id");
    var url="Value_lableServlet.do?id="+escape(student_no.value);
    xmlHTTP.open("GET",url,true);
    xmlHTTP.onreadystatechange=handleStateChange;
    xmlHTTP.send(null);
}
function handleStateChange() {
    if (xmlHTTP.readyState==4){
        if (xmlHTTP.status==200){
           var messageArea=document.getElementById("lable1");
           var message1=xmlHTTP.responseXML.getElementsByTagName("message")[0].firstChild.data;
           var message2=xmlHTTP.responseXML.getElementsByTagName("message")[1].firstChild.data;
           var message3=xmlHTTP.responseXML.getElementsByTagName("message")[2].firstChild.data;


           document.getElementById("lable3").innerHTML="实验报告3<label class=\"badge badge-primary\">"+message3+"</label>";
           if (message1=="已提交"){
               messageArea.innerHTML="实验报告1 <label class=\"badge badge-primary\">"+message1+"</label>";
           }else {
               messageArea.innerHTML="实验报告1 <label class=\"badge badge-danger\">"+message1+"</label>";
           }
           if (message2=="已提交"){
               document.getElementById("lable2").innerHTML="实验报告2<label class=\"badge badge-primary\">"+message2+"</label>";
           }else {
               document.getElementById("lable2").innerHTML="实验报告2<label class=\"badge badge-danger\">"+message2+"</label>";
           }
            if (message3=="已提交"){
                document.getElementById("lable3").innerHTML="实验报告3<label class=\"badge badge-primary\">"+message2+"</label>";
            }else {
                document.getElementById("lable3").innerHTML="实验报告3<label class=\"badge badge-danger\">"+message2+"</label>";
            }
        }
    }
}