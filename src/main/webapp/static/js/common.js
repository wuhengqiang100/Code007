
function ResizeImages()
{
   var myimg,oldwidth,oldheight;
   var maxwidth=800;
   var maxheight=1000
   var imgs = document.getElementById('content').getElementsByTagName('img');   //通过img标签获得图片路径


   for(i=0;i<imgs.length;i++){
     myimg = imgs[i];


     if(myimg.width > myimg.height)
     {
         if(myimg.width > maxwidth)
         {
            oldwidth = myimg.width;
            myimg.height = myimg.height * (maxwidth/oldwidth);
            myimg.width = maxwidth;
         }
     }else{
         if(myimg.height > maxheight)
         {
            oldheight = myimg.height;
            myimg.width = myimg.width * (maxheight/oldheight);
            myimg.height = maxheight;
         }
     }
   }
}

function showRegister(){
    layer.open({
        type:2,//弹窗类型.iframe=2
        title:'用户注册',//标题
        closeBtn: 1,//显示关闭按钮
        anim: 0,//出现动画
        btnAlign: 'c',//按钮对齐方式
        isOutAnim:true,//弹窗关闭动画,默认打开
        maxmin: true,//显示最大最小化按钮,默认false不显示
        area:['400px','500px'],//弹窗宽度,高度
        shade: [0.8, '#393D49'],//遮罩颜色,自定义

        content:'/register.html'

    });
}
function reloadPage(){
    window.location.reload();
}