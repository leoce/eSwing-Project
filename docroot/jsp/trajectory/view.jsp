<%@ include file="/init.jsp" %>

<%

String redirect = PortalUtil.getCurrentURL(renderRequest);
List<Point3D> points = (List<Point3D>) request.getAttribute("points");
// String points = (String) request.getAttribute("points");
List<List<Point3D>> arrayPoints = null;//(List<List<Point3D>>) request.getAttribute("arrayPoints");

long[] shotDataIds = (long[]) request.getAttribute("arrayPoints");

if ((shotDataIds != null) || (shotDataIds.length > 0)){
	
	arrayPoints = new ArrayList<List<Point3D>>();
	for (int i=0; i < shotDataIds.length; i++){
		ESPlayerShotData shotData = ESPlayerShotDataLocalServiceUtil.getESPlayerShotData(shotDataIds[i]);

		ShotData shot = ActionUtil.shotDataConverter(shotData, true);
		TrajectoryModel simulate = new TrajectoryModel(shot,false);
		
		arrayPoints.add(simulate.getPoints());
	
	}
}
// System.out.println(points);
/*
if (arrayPoints == null){
	List<List<Point3D>> ptts = new ArrayList<List<Point3D>>();
	List<Point3D> pts = new ArrayList<Point3D>();
	List<String> spts = new ArrayList<String>();
		
		ShotData shot = new ShotData();
		Point3D point = new Point3D();
		Velocity3D velocity = new Velocity3D();
		Displacement3D displacement = new Displacement3D();
		BallPointPhysics ballPoint = new BallPointPhysics();
		
		velocity.setVelocityX(0);
		velocity.setVelocityY(0);
		velocity.setVelocityZ(0);
		
		point.setPointX(0);
		point.setPointY(0);
		point.setPointZ(0);
		
		displacement.setDisplacementX(0);
		displacement.setDisplacementY(0);
		displacement.setDisplacementZ(0);
		
		ballPoint.setDisplacement3D(displacement);
		ballPoint.setVelocity3D(velocity);
		ballPoint.setPoint3D(point);
		
		shot.set_altitude(0);
		shot.set_temperature(59);
		
		shot.setClubSpeed(92.00d);
		shot.setClubWeight(200.0d);
		shot.setClubCor(1.145);
		
		shot.setClubSpinRate(5500.0d);
		shot.setClubLoft(31.0d);
		shot.setClubFaceAngle(-2.0d);
		shot.setClubSwingPath(0.0d);
		shot.setBallBackSpin(4000);
		shot.setBallLaunchAngle(26d);
		shot.setWindDirection(0.0d);
		shot.setWindSpeed(0.0d);
		shot.setBallSpeed(150d);
		shot.setBallAOA(20.0d);
		TrajectoryModel simulate = new TrajectoryModel(shot,false);
		
		Iterator iter = simulate.getPoints().listIterator();
		
		while (iter.hasNext()){
			
			Point3D pt = (Point3D) iter.next();
			pts.add(pt);
			
		}	
		ptts.add(pts);
		Point3D p1 = new Point3D();
		Point3D p2 = new Point3D();
		Point3D p3 = new Point3D();
		p1.setPointX(0);
		p1.setPointY(0);
		p1.setPointZ(0);
		p2.setPointX(130);
		p2.setPointY(15);
		p2.setPointZ(100);
		p3.setPointX(150);
		p3.setPointY(0);
		p3.setPointZ(120);
		List<Point3D> test = new ArrayList<Point3D>();
		test.add(p1);
		test.add(p2);
		test.add(p3);
		ptts.add(test);
		arrayPoints = ptts;
}
*/
int checkArr = 0;
checkArr = (arrayPoints != null) ? 1 : 0;
if ((arrayPoints == null) & (points == null)) checkArr = 3;
%>

<div id="chart2" style="width:100%; height: 250px;"></div>
<!-- <div id="selectableLegend"></div> -->
<div id="chart1" style="width:100%; height: 400px;"></div>
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

<script type="text/javascript">

	dojo.require('dojox.charting.widget.Chart2D');
	dojo.require("dojox.charting.themes.ThreeD");
	dojo.require("dojox.charting.Theme");
	dojo.require("dojox.charting.action2d.Tooltip");
	dojo.require("dojox.charting.action2d.Magnify");
	dojo.require('dojox.charting.Chart2D');
	dojo.require("dojox.charting.themes.Claro");
	dojo.require("dojox.fx.easing");
	dojo.require("dojox.charting.widget.Legend");
	dojo.require("dojox.charting.widget.SelectableLegend");
	dojo.addClass(dojo.body(), 'claro');
	
	/* resources are ready... */
	var color = ["#cc0000", '#010808', '#CDDF84', '#000080', '#F86CB1', '#ff6600', '#660099', '#DBD404', '#072FB3'], used = [];
	var chart2, chart1, checkArr = <%= checkArr %>, tips, col = '#000',
		maxX = 0, maxY = 0, maxZ = 0;
	var deg = {
			'near': {
				'name': 'Near',
				'fill': '#82ff82',
				'distance': 10
			},
			'fair': {
				'name': 'Fair',
				'fill': '#ffff82',
				'distance': 20
			},
			'far': {
				'name': 'Far',
				'fill': '#fc8181',
				'distance': 30
			}
	};
	
	dojo.ready(function() {
		var dc = dojox.charting, d = 10;
	    chart1 = new dc.Chart2D('chart1', { title: 'Bird\'s Eye View', fill: "transparent" }).
	        addPlot('default', { type: 'Lines', markers: false, lines: true, areas: false })
	    	.setTheme(dc.themes.ThreeD)
	    	.addPlot("ball", { type: "MarkersOnly" })
			.addPlot("Grid", {type: "Grid", hAxis: "x", vAxis: "y", hMajorLines: true,
		    	hMinorLines: true, vMajorLines: true, vMinorLines: true
			})
			.addPlot("degree", { type: "Areas", markers: false, lines: false, area: true, tension: 5 })
			.addAxis('y', { vertical:true, max:d })
			.addAxis('x', { min: d*-1, max:d })
			.addSeries("Series A", [{x:0, y:0},{x:0,y:d}], { stroke:{color: "black", width: 0} });	    
	    
		chart2 = new dc.Chart2D('chart2', { title:"Ball Trajectory", fill: "transparent" })
			.setTheme(dc.themes.ThreeD)
			.addPlot("ball", { type: "MarkersOnly" })
			.addPlot('default', { type: 'Lines', markers: false, lines: true, areas: false })
			.addPlot("Grid", { type:"Grid", hAxis: "x", vAxis: "y", hMajorLines: true,
				hMinorLines: true, vMajorLines: true, vMinorLines: true })
			.addAxis('y', { vertical:true, max:d })
			.addAxis('x', { min: 0, max:d*4 })
			.addSeries("Series A", [{x:0, y:0},{x:0,y:d}], { stroke:{width: 0}, shadow: 0 });
		
		tips = new dojox.charting.action2d.Tooltip(chart1,"ball");
		tips2 = new dojox.charting.action2d.Tooltip(chart2,"ball");
		
		chart1.render();
		chart2.render();
		if (checkArr == "0") { addS(<%= points %>); } 
		else if (checkArr == "1") { addSS(<%= arrayPoints %>); }
	});
	
	function cresize(c,x,y,d) {
		var w = 0, h = 0, mydiv = document.getElementById(c);
		w = parseInt(mydiv.offsetWidth);
		h = (w/d) * (y/x);
		eval(c).resize(w,h);
	}
	
	function rcolor() {
		var n=0; 
		if (used.length == color.length) return '#000';
		while ( used[ n = Math.floor(Math.random()*color.length) ]){} 
			used[ n ] = true; 
		return color[n];
	}
	
	
	function addS(pts) {
		var x, y, z, px, py, pz, data = pts, fx = 0, fy = 0, fz = 0, data2 = [];
		
		dojo.forEach(data, function(item, i) {
			maxX = (Math.abs(item.x) > maxX) ? Math.abs(item.x) : maxX;
			maxY = (item.y > maxY) ? item.y : maxY;
			maxZ = (item.z > maxZ) ? item.z : maxZ;
			if(i == data.length-1) { fx = item.x; fy = item.y; fz = item.z; }
			data2.push({ x:item.y, y:item.z  });
		});
		px = Math.pow( 10, Math.floor( Math.log(maxX) / Math.LN10 ));
		py = Math.pow( 10, Math.floor( Math.log(maxY) / Math.LN10 ));
		pz = Math.pow( 10, Math.floor( Math.log(maxZ) / Math.LN10 ));
		x = (Math.floor(maxX / px) + 1) * px;
		y = (Math.floor(maxY / py) + 1) * py;
		z = (Math.floor(maxZ / pz) + 1) * pz;

		x = (maxX < y*0.7) ? y * 0.7 : x;
		z = (maxZ < y*0.3) ? y * 0.3 : z;
		chart1
			.addAxis('y', { majorTickStep: y/8, minorTickStep: y/8, plot: "Grid", vertical:true, max:y })
			.addAxis('x', { majorTickStep: y/8, minorTickStep: y/8, plot: "Grid", min: x*-1, max:x })
			.addSeries('Last', [{x:fx, y:fy, tooltip:"Single shot at "+fy.toFixed(0)+" yards"}], { fill:"#FFF", stroke: { color: "#333", width:7 }, plot:"ball", marker: "m-3,0 c0,-4 6,-4 6,0 m-6,0 c0,4 6,4 6,0" })    	
			.addSeries('Single', data, { plot: "default", stroke: { color: '#000', width: 2 } })
			.addSeries('Near', [{x:0,y:0},{x:deg.near.distance*-1,y:y},{x:deg.near.distance,y:y},{x:0,y:0}], { plot:"degree", fill: deg.near.fill, stroke: { width:0 } })
			.addSeries('Fair', [{x:0,y:0},{x:deg.fair.distance*-1,y:y},{x:deg.fair.distance,y:y},{x:0,y:0}], { plot:"degree", fill: deg.fair.fill, stroke: { width:0 } })
			.addSeries('Far', [{x:0,y:0},{x:deg.far.distance*-1,y:y},{x:deg.far.distance,y:y},{x:0,y:0}], { plot:"degree", fill: deg.far.fill, stroke: { width:0 } });
		
		chart2
			.addAxis('y', { majorTickStep: z/4, minorTickStep: z/4, plot: "Grid", vertical:true, max:z })
			.addAxis('x', { majorTickStep: z/4, minorTickStep: z/4, plot: "Grid", min: 0, max:y })
			.addSeries('Last', [{x:fy, y:fz, tooltip:"Single shot at "+fy.toFixed(0)+" yards"}], { fill:"#FFF", stroke: { color: "#333", width:7 }, plot:"ball", marker: "m-3,0 c0,-4 6,-4 6,0 m-6,0 c0,4 6,4 6,0" })
			.addSeries('Single2', data2, { plot: "default", stroke: { color: '#000', width: 2 } });
		cresize('chart1',x,y,2);
		cresize('chart2',y,z,0.8);
		chart1.render();
		chart2.render();
	}
	
	function addSS(ptts) {
		var x =0, y=0, z=0, px, py, pz,
			data = ptts, fx = 0, fy = 0, fz = 0;
		
		dojo.forEach(data, function(a,b) {
			var data2=[];
	    	dojo.forEach(a, function(item, i) {
	    		maxX = (Math.abs(item.x) > maxX) ? Math.abs(item.x) : maxX;
	    		maxY = (item.y > maxY) ? item.y : maxY;
	    		maxZ = (item.z > maxZ) ? item.z : maxZ;
	    		if(i == a.length-1) { fx = item.x; fy = item.y; fz = item.z}
	    		data2.push({ x:item.y, y:item.z  });
	    	});
	    	
			px = Math.pow( 10, Math.floor( Math.log(maxX) / Math.LN10 ));
			py = Math.pow( 10, Math.floor( Math.log(maxY) / Math.LN10 ));
			pz = Math.pow( 10, Math.floor( Math.log(maxZ) / Math.LN10 ));
			x = (Math.floor(maxX / px) + 1) * px;
			y = (Math.floor(maxY / py) + 1) * py;
			z = (Math.floor(maxZ / pz) + 1) * pz;
			
			col = rcolor();

	    	chart1	    		
				.addSeries("Last "+b, [{x:fx, y:fy, tooltip:"Shot "+(b+1)+" at "+fy.toFixed(0)+" yards"}], { fill:"#FFF", stroke: { color: col, width:7 }, plot:"ball", marker:"m-3,0 c0,-4 6,-4 6,0 m-6,0 c0,4 6,4 6,0" })    	
	    		.addSeries("Shot1 "+b, a, { plot: "default", stroke: { width: 2, color: col }, shadow: { width: 0 } });
	    	chart2
	    		.addSeries("Last "+b, [{x:fy, y:fz, tooltip:"Shot "+(b+1)+" at "+fy.toFixed(0)+" yards"}], { fill:"#FFF", stroke: { color: col, width:7 }, plot:"ball", marker:"m-3,0 c0,-4 6,-4 6,0 m-6,0 c0,4 6,4 6,0" })
	    		.addSeries("Shot2 "+b, data2, { plot: "default", stroke: { width: 2, color: col}, shadow: { width: 0 } });
		});
		x = (maxX < y*0.7) ? y * 0.7 : x;
		z = (maxZ < y*0.3) ? y * 0.3 : z;
		
		cresize('chart1',x,y,2);
		cresize('chart2',y,z,0.75);
		chart1
			.addAxis('y', { majorTickStep: y/8, minorTickStep: y/8, plot: "Grid", vertical:true, max:y })
			.addAxis('x', { majorTickStep: y/8, minorTickStep: y/8, plot: "Grid", min: x*-1, max:x })
			.addSeries('Near', [{x:0,y:0},{x:deg.near.distance*-1,y:y},{x:deg.near.distance,y:y},{x:0,y:0}], { plot:"degree", fill: deg.near.fill, stroke: {width:0} })
			.addSeries('Fair', [{x:0,y:0},{x:deg.fair.distance*-1,y:y},{x:deg.fair.distance,y:y},{x:0,y:0}], { plot:"degree", fill: deg.fair.fill, stroke: {width:0} })
			.addSeries('Far', [{x:0,y:0},{x:deg.far.distance*-1,y:y},{x:deg.far.distance,y:y},{x:0,y:0}], { plot:"degree", fill: deg.far.fill, stroke: {width:0} });
		chart2
			.addAxis('y', { majorTickStep: z/4, minorTickStep: z/4, plot: "Grid", vertical:true, max:z })
			.addAxis('x', { majorTickStep: z/4, minorTickStep: z/4, plot: "Grid", min: 0, max:y });
		chart1.render();
		chart2.render();

	}    
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
  	Liferay.on(
			   'simulate_one',
			   function(event) {
			     //var points = data.points;
			     addS(event.points);
			   }
			 );
     
</script>