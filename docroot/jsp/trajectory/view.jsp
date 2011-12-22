<%@ include file="/init.jsp" %>

<%

String redirect = PortalUtil.getCurrentURL(renderRequest);
List<Point3D> points = (List<Point3D>) request.getAttribute("points");

List<List<Point3D>> arrayPoints = (List<List<Point3D>>) request.getAttribute("arrayPoints");

if (arrayPoints != null){
	
	Iterator iter = arrayPoints.iterator();
	
	while (iter.hasNext()){
		
		List<Point3D> list = (List<Point3D>) iter.next();
		
		Iterator iter2 = list.iterator();
		
		while (iter2.hasNext()){
			
			Point3D point = (Point3D) iter2.next();
			
			System.out.println(point.toString());
		}
	}
}
if (points != null){
	Iterator iter = points.iterator();

	while (iter.hasNext()){
	
		Point3D point = (Point3D) iter.next();
	
		System.out.println(point.toString());
	}
}
%>


<portlet:renderURL var="uploadShotDataURL" windowState="<%= LiferayWindowState.EXCLUSIVE.toString()%>" >
	<portlet:param name="jspPage" value="/jsp/shotdatatable/simulate_many_shotdata.jsp" />
	<portlet:param name="redirect" value="<%= redirect %>" />
</portlet:renderURL>

<portlet:renderURL var="changeColorURL" windowState="<%= LiferayWindowState.EXCLUSIVE.toString()%>" >
	<portlet:param name="jspPage" value="/jsp/trajectory/color_picker.jsp" />
</portlet:renderURL>

<portlet:renderURL var="viewFullScreenURL" windowState="<%= LiferayWindowState.EXCLUSIVE.toString()%>" >
	<portlet:param name="jspPage" value="/jsp/trajectory/view.jsp" />
</portlet:renderURL>

<aui:form id="<portlet:namespace/>LoadShotDataForm" name="fm" action="<%= uploadShotDataURL.toString() %>" method="post">
	<aui:fieldset>
		<aui:layout>
		<aui:column columnWidth="25" first="true">
			<aui:button type="button" name="uploadFile" value="Display Shot Data" onClick="javascript: uploadShotPopup(); "/>
		</aui:column>
		<aui:column columnWidth="25">
			<aui:button type="button" name="clearScreen" value="Clear Shot Data" />
		</aui:column>
		<aui:column columnWidth="25" >
			<aui:button type="button" name="changeColor" value="Change Graph Color" onClick="javascript: colorPickerPopup(); " />
		</aui:column>
		<aui:column columnWidth="25" last="true">
			<aui:button type="button" name="viewFull" value="View Full Screen" onclick="javascript: showFullScreen(); "/>
		</aui:column>
		</aui:layout>
	</aui:fieldset>
	
</aui:form>
<aui:script>
function uploadShotPopup(){  
       AUI().use('aui-dialog', 'aui-overlay-manager', 'dd-constrain', 'aui-io', 'event', 'event-custom', function(A) {  
           var dialog = new A.Dialog({    
           title: 'Display Shot Data',   
           centered: true,  
           modal: true,
           draggable: true,
           width: 700,  
           height: 400,
           scrollbars: true
            }).render();
           
           dialog.plug(A.Plugin.IO, {uri: '<%= uploadShotDataURL %>' });
           dialog.show();
        });  
}

function colorPickerPopup(){  
       AUI().use('aui-dialog', 'aui-overlay-manager', 'dd-constrain', 'aui-io', 'event', 'event-custom', function(A) {  
           var dialog = new A.Dialog({    
           title: 'Pick Color',   
           centered: true,  
           modal: true,
           draggable: true,
           width: 300,  
           height: 200,
           scrollbars: true
            }).render();
           
           dialog.plug(A.Plugin.IO, {uri: '<%= changeColorURL %>' });
           dialog.show();
        });  
}

function showFullScreen(){  
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
        
        dialog1.plug(A.Plugin.IO, {uri: '<%= viewFullScreenURL %>' });
        dialog1.show();
     });  
}
</aui:script>