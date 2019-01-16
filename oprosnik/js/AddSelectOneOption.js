
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
  '         <div id="'+ ++ct +'"> '+
  '             <label><input type="checkbox" name="linkurl3" value="first"><input type="text" placeholder="Вариант ответа#" style="margin-left:20px"> </label>'+
  '             <div style="text-align:right;margin-right:65px"><a href="javascript:delChild('+ k +','+ ct +')">Del</a></div>'+
  '             <br/>'+
  '         </div>'+
  '         <div id="'+ ++ct +'"> '+
  '             <label><input type="checkbox" name="linkurl3" value="first"><input type="text" placeholder="Вариант ответа#" style="margin-left:20px"> </label>'+
  '             <div style="text-align:right;margin-right:65px"><a href="javascript:delChild('+ k +','+ ct +')">Del</a></div>'+
  '             <br/>'+
  '         </div>'+
  '         <div id="'+ ++ct +'"> '+
  '             <label><input type="checkbox" name="linkurl3" value="first"><input type="text" placeholder="Вариант ответа#" style="margin-left:20px"></label> '+
  '             <div style="text-align:right;margin-right:65px"><a href="javascript:delChild('+ k +','+ ct +')">Del</a></div>'+
  '             <br/>'+
  '         </div>'+
  '</div>'+
  '<a href="javascript:add_new_Option_in_selectOneOption('+ k +')">Добавить вариант ответа</a>'+ 
  '<a href="javascript:save_selectOneOption('+ k +')">Сохранить</a>';
    

    div1.innerHTML = delLink + mainBlock;
    
    document.getElementById('oprosnik').appendChild(div1);
}

function save_selectOneOption() {
    
}


function delChild(parentId, childId)
{
    d = document;
    var ele = d.getElementById(childId);
    var parentEle = d.getElementById(parentId);
    parentEle.removeChild(ele);
}

function add_new_Option_in_selectOneOption(elementId){

    var div1 = document.createElement('div');
    div1.id = ++ct;
    var newOption =
    '     <label><input type="checkbox" name="linkurl3" value="first"><input type="text" placeholder="Вариант ответа#" style="margin-left:20px"></label>'+
    '     <div style="text-align:right;margin-right:65px"><a href="javascript:delChild('+ elementId +','+ ct +')">Del</a></div>'+
    '     <br/>';
    div1.innerHTML = newOption;
    document.getElementById(elementId).appendChild(div1);
}
