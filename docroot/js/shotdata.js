function showFullScreen(content){  
    AUI().use('aui-dialog', 'aui-overlay-manager', 'dd-constrain', 'aui-io', 'event', 'event-custom', function(A) {  
        var dialog1 = new A.Dialog({    
        title: 'Full Screen',   
        centered: true,  
        modal: true,
        draggable: true,
        width: 1000,  
        height: 600,
        scrollbars: true
         }).render();
        
        dialog1.plug(A.Plugin.IO, {uri: content });
        dialog1.show();
     });  
}

function colorPicker(){
	AUI.use('aui-color-picker',function(A){
		var colorpicker = new A.ColorPicker().render();
	})
	
}


