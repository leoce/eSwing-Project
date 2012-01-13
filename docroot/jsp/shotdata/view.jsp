<%@ include file="/init.jsp" %>

<%

	ShotData shot = (ShotData) request.getAttribute("shotData");
	boolean isRegistered = false;//true;
	double firmness = 0.0d;
	
	String redirect = PortalUtil.getCurrentURL(renderRequest);
	boolean hasShotData = false;
	
	if (shot != null){
		hasShotData = true;
		
		firmness = ParamUtil.getDouble(request,"firmness");
		isRegistered  = ParamUtil.getBoolean(request,"registered");
	}

	boolean normal = true;
	boolean low = false;
	boolean high = false;
	boolean limitedFlight = false;
	
	boolean carryOnly = true;
	boolean normalFirmness = false;
	boolean hardFirmness = false;

%>

<portlet:actionURL name="simulateShotData" var="simulateShotDataURL" />

<portlet:actionURL name="addSubscription" var="addSubscriptionURL" />

<portlet:renderURL var="shotDataURL" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>" >
	<portlet:param name="jspPage" value="/jsp/shotdatatable/simulate_one_shotdata.jsp" />
	<portlet:param name="redirect" value="<%= redirect %>" />
</portlet:renderURL>

 <form id="fm" name="fm" >
	<aui:fieldset>
	<%
		if (hasShotData){
	%>	
	 <aui:input inlineLabel="right" 
    	name="launchMonitor" 
    	type="checkbox" 
    	disabled="true" 
    	checked="<%= shot.isLaunchMonitor() %>" 
    	label="Launch Monitor Attached" 
    	visible="<%= shot.isLaunchMonitor() %>"/>
    <%} %>
    <liferay-ui:panel-container>
	<liferay-ui:panel title="Clubs" collapsible="true" >			
		<aui:layout>
		<aui:column columnWidth="50" first="true">
			<%
			
			List<ESClub> clubs =
        		ESClubLocalServiceUtil.getESClubs(QueryUtil.ALL_POS,QueryUtil.ALL_POS);
    		
    		%>
			
    		<aui:select name="clubName">
    			<% if (hasShotData) {%>
    			<aui:option value="<%= shot.getClubId() %>">
        			<%= shot.getClubName() %>
      			</aui:option>
    			<%} else { %>
      			<aui:option value="-1">
        			<liferay-ui:message key="please-choose" />
      			</aui:option>
      	<% }
      			for (int i = 0; i < clubs.size(); i++) {
      	%>
      			<aui:option value="<%= clubs.get(i).getClubId() %>">
        			<%= clubs.get(i).getClubName() %>
      			</aui:option>
      	<%
      			}
      	%>
      	
    	</aui:select>
			
			<% if (hasShotData){ %>
				<aui:input 
				id="shotData1" 
				name="clubSpeed" 
				size="10" 
				value="<%= shot.getClubSpeed() %>"/>
						
			<aui:input 
				id="shotData2" 
				name="faceAngle" 
				size="10" 
				value="<%= shot.getClubFaceAngle() %>"/>
			<%} else { %>	
			<aui:input 
				id="shotData1" 
				name="clubSpeed" 
				size="10" 
				value="0"/>
						
			<aui:input 
				id="shotData2" 
				name="faceAngle" 
				size="10" 
				value="0"/>
			<%} %>	
		</aui:column>
		<aui:column columnWidth="50" last="true">
		
		<% if (hasShotData){ %>
			<aui:input 
				id="shotData3" 
				name="loft" 
				size="10" 
				value="<%= shot.getClubLoft() %>"/>
							
			<aui:input 
				id="shotData4" 
				name="spinRate" 
				size="10" 
				value="<%= shot.getClubSpinRate() %>"/>
						
			<aui:input 
				id="shotData5" 
				name="swingPath" 
				size="10" 
				value="<%= shot.getClubSwingPath() %>"/>
		<%} else { %>
			<aui:input 
				id="shotData3" 
				name="loft" 
				size="10" 
				value="0"/>
							
			<aui:input 
				id="shotData4" 
				name="spinRate" 
				size="10" 
				value="0"/>
						
			<aui:input 
				id="shotData5" 
				name="swingPath" 
				size="10" 
				value="0"/>
		<%} %>		
		</aui:column>
		
		</aui:layout>
	</liferay-ui:panel>
	
	<liferay-ui:panel title="Ball Parameters" collapsible="true">
		
		<%
			if (hasShotData){
				double ballCompression = shot.getBallCompression();
				
				if (ballCompression == 1.0){
					normal = true;
					low = false;
					high = false;
					limitedFlight = false;
				}
			}
		%>
		<aui:select name="compression" width="40">
      		<aui:option value="low" selected="<%= low %>">
        		<liferay-ui:message key="low" />
      		</aui:option>
      		<aui:option value="normal" selected="<%= normal %>">
        		<liferay-ui:message key="normal" />
      		</aui:option>
      		<aui:option value="high" selected="<%= high %>">
        		<liferay-ui:message key="high" />
      		</aui:option>
      		<aui:option value="limitedFlight" selected="<%= limitedFlight %>">
        		<liferay-ui:message key="limited-flight" />
      		</aui:option>
      	</aui:select>
		
		<%if (hasShotData){ %>
		<aui:input 
			id="shotData6" 
			name="angleOfAttack" 
			size="20" 
			value="<%= shot.getBallAOA() %>"/> 
		<aui:input 
			id="shotData7" 
			name="initialBallVelocity" 
			size="20" 
			value="<%= shot.getBallSpeed() %>"/>
		<%} else { %>
		<aui:input 
			id="shotData6" 
			name="angleOfAttack" 
			size="20" 
			value="0"/> 
		<aui:input 
			id="shotData7" 
			name="initialBallVelocity" 
			size="20" 
			value="0"/>
		<%} %>
	</liferay-ui:panel>
	<liferay-ui:panel title="Environmental Factors" collapsible="true" >
	
		<aui:layout>
		<aui:column columnWidth="50" first="true">
		
		<%if (hasShotData){ %>
			<aui:input 
				id="shotData8" 
				name="windDirection" 
				size="10" 
				value="<%= shot.getWindDirection() %>"/>
			<aui:input 
				id="shotData9" 
				name="windSpeed" 
				size="10" 
				value="<%= shot.getWindSpeed() %>"/>
		<%} else { %>
			<aui:input 
				id="shotData8" 
				name="windDirection" 
				size="10" 
				value="0"/>
			<aui:input 
				id="shotData9" 
				name="windSpeed" 
				size="10" 
				value="0"/>
		<%} %>
		</aui:column>
		<aui:column columnWidth="50" last="true">
			<%if (hasShotData){ %>
				<aui:input 
					id="shotData10" 
					name="ambientTemp" 
					size="10" 
					value="<%= shot.get_temperature() %>"/>
				<aui:input 
					id="shotData11" 
					name="barPressureAlt" 
					size="10" 
					value="<%= shot.get_altitude() %>"/>
			<%} else { %>		
				<aui:input 
					id="shotData10" 
					name="ambientTemp" 
					size="10" 
					value="0"/>
				<aui:input 
					id="shotData11" 
					name="barPressureAlt" 
					size="10" 
					value="0"/>
			<%} %>
		</aui:column>
		</aui:layout>
	</liferay-ui:panel>
	<liferay-ui:panel title="Fairway Firmnesss" collapsible="true" >
	
		<aui:layout>
		
			<%
				if (hasShotData){
					if (firmness == 1.0){
						carryOnly = false;
						normalFirmness = true;
						hardFirmness = false;
					}
					
				}
			%>
			<aui:field-wrapper name="fairway">
				<aui:input checked="<%= carryOnly %>" inlineLabel="right" name="fairway" type="radio" value="carry only" label="Carry Only - (No Roll)" />
				<aui:input checked="<%= normalFirmness %>" inlineLabel="right" name="fairway" type="radio" value="Normal" label="Normal - (Carry Only + 10%)"  />
				<aui:input checked="<%= hardFirmness %>" inlineLabel="right" name="fairway" type="radio" value="Hard" label="Hard - (Carry Only + 15%)" />
			</aui:field-wrapper>
				
		</aui:layout>
	</liferay-ui:panel>
	</liferay-ui:panel-container>
		<aui:button-row>
			<aui:button type="button" name="upload" value="Upload Shot" onClick="javascript: openPopup('Display Shot Data');"/>
			<aui:button type="submit" name="simulate" value="Simulate" />
		</aui:button-row>
		
	</aui:fieldset>
	
</form>
<portlet:resourceURL var="actionURL">
    <portlet:param name="fetchDataAction" value="/jsp/shotdata/data.jsp"/>
</portlet:resourceURL>
<script type="text/javascript">

function openPopup(title){  
       AUI().use('aui-dialog', 'aui-overlay-manager', 'dd-constrain', 'aui-io', 'event', 'event-custom', function(A) {  
           var dialog = new A.Dialog({    
           title: title,   
           centered: true,  
           modal: true,
           draggable: true,
           width: 700,  
           height: 400,
           scrollbars: true
            }).render();
           
           dialog.plug(A.Plugin.IO, {uri: '<%= shotDataURL.toString() %>' });
           dialog.show();
        });  
}
AUI().use('node', 'slider', function(A) {

    var mySlider = new A.Slider();
   
    var sliderNodeIDString = '#' + '<portlet:namespace/>' + 'shotData1';
    mySlider.render("#horiz_value");
   
}); 
jQuery(document).ready(function(){
	jQuery.validator.addMethod("clubName", function(value, element) {
		return (value>0);
	}, "Please choose a club.");
	jQuery("#fm").validate({
		submitHandler: function() {
			AUI().use('aui-io-request', function(A){
				A.io.request("<%= actionURL.toString() %>", {
					dataType: 'json',
					form: {
					   id: 'fm'
					  },
					on: {
						success: function() {
							var json = eval(this.get('responseData'));
							Liferay.fire('simulate_one', { points: eval(json.points) });
							
						}
					}
					  });
			});	
			return false;
		},
		rules: {
		    "<portlet:namespace/>clubName": "clubName"
		  }
	});

});

</script>