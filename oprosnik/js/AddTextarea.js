

var ct = 1;
function add_new_textarea()
{
    ct++;
    var div1 = document.createElement('div');
    div1.id = ct;
    // link to delete extended form elements
    var delLink = '<div style="text-align:right;margin-right:65px"><a href="javascript:delIt('+ ct +')">Del</a></div>';
    div1.innerHTML = document.getElementById('newTextarea').innerHTML + delLink;
    document.getElementById('oprosnik').appendChild(div1);
}




// // function to delete the newly added set of elements
// function delIt(eleId)
// {
//     d = document;
//     var ele = d.getElementById(eleId);
//     var parentEle = d.getElementById('oprosnik');
//     parentEle.removeChild(ele);
// }
