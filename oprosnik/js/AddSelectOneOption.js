
var ct = 1;

function add_new_selectOneOption()
{
    ct++;

    // link to delete extended form elements
    var delLink = '<div style="text-align:right;margin-right:65px"><a href="javascript:delIt('+ ct +')">Del</a></div>';

    var div1 = document.createElement('div');
    div1.id = ct;

    var delLink2 = '<div style="text-align:right;margin-right:65px">'+
    '<a href="javascript:delIt('+ ++ct +')">Del</a></div>';

    var k = ++ct;
    
    var mainBlock = 
  ' <div id="'+k+'"> '+
  '     <p> Выбор одного варианта:</p>'+
  '     <input type="text" name="linkurl[]" value="" placeholder="Текст вопроса"> <br/>'+
  '         <input type="text" id="'+ ++ct +'" placeholder="Вариант ответа#1" style="margin-left:20px"> '+
  '         <div style="text-align:right;margin-right:65px"><a href="javascript:delIt('+ ct +')">Del</a></div>'+
  '         <br/>'+
  '         <input type="text" id="'+ ++ct +'" placeholder="Вариант ответа#2" style="margin-left:20px"> '+
  '         <div style="text-align:right;margin-right:65px"><a href="javascript:delIt('+ ct +')">Del</a></div>'+
  '         <br/>'+
  '         <input type="text" id="'+ ++ct +'" placeholder="Вариант ответа#3" style="margin-left:20px"> '+
  '         <div style="text-align:right;margin-right:65px"><a href="javascript:delIt('+ ct +')">Del</a></div>'+
  '         <br/>'+
  '         <a href="javascript:add_new_Option_in_selectOneOption('+ k +')">Добавить вариант ответа</a>'+
  ' </div>';

    div1.innerHTML = delLink + mainBlock;
    
    document.getElementById('oprosnik').appendChild(div1);
}

function add_new_Option_in_selectOneOption(elementId){

    var newOption = 
    '         <input type="text" id="'+ ++ct +'" placeholder="Вариант ответа#" style="margin-left:20px"> '+
    '         <div style="text-align:right;margin-right:65px"><a href="javascript:delIt('+ ct +')">Del</a></div>'+
    '         <br/>';
    document.getElementById(elementId).appendChild(newOption);
}
