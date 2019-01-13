
var ct = 1;

function add_new_select()
{
    ct++;
    var div1 = document.createElement('div');
    div1.id = ct;
    // link to delete extended form elements
    var delLink = '<div style="text-align:right;margin-right:65px"><a href="javascript:delIt('+ ct +')">Del</a></div>';
    div1.innerHTML = document.getElementById('newSelect').innerHTML + delLink;
    document.getElementById('oprosnik').appendChild(div1);
}