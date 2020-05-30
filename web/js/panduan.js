function check() {
    let seq_id = document.getElementById('customFile1').files[0].name
    // alert(seq_id)
    const index = seq_id.lastIndexOf(".");
    let  etx=seq_id.substring(index);
    if (etx !=".pdf"){
        alert("你所选择的文件不是指定的pdf文件格式，请重新选择")

        document.getElementById("customFile1").value="";

    }

}
function check2() {
    let filename=document.getElementById('customFile2').files[0].name
    const index=filename.lastIndexOf(".");
    let etx=filename.substring(index);
    if (etx !=".pdf"){
        alert("你所选择的文件不是指定的pdf文件格式，请重新选择")
        document.getElementById('customFile2').value="";
    }

}
function check3() {
    let filename=document.getElementById('customFile3').files[0].name
    const index=filename.lastIndexOf(".");

    let etx=filename.substring(index);
    if (etx !=".pdf"){
        alert("你所选择的文件不是指定的pdf文件格式，请重新选择")
        document.getElementById('customFile3').value="";
    }

}
