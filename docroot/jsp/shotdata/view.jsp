<%@ include file="/init.jsp" %>

<%

	ShotData shot = (ShotData) request.getAttribute("shotData");
	//boolean isRegistered = ActionUtil.isRegisteredMember(renderRequest);
	boolean isRegistered = true;
	String redirect = PortalUtil.getCurrentURL(renderRequest);
	boolean hasShotData = false;
	
	if (shot != null)
		hasShotData = true;
	


%>

<portlet:actionURL name="simulateShotData" var="simulateShotDataURL" />

<portlet:actionURL name="addSubscription" var="addSubscriptionURL" />

<portlet:renderURL var="uploadShotDataURL" windowState="<%= LiferayWindowState.EXCLUSIVE.toString()%>" >
	<portlet:param name="jspPage" value="/jsp/shotdatatable/simulate_one_shotdata.jsp" />
</portlet:renderURL>

 <aui:form name="fm" action="<%= simulateShotDataURL.toString() %>" method="post">
	<aui:fieldset>	
	
	<liferay-ui:panel-container>
	<liferay-ui:panel title="Clubs" collapsible="true" extended="true">			
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
	
	<liferay-ui:panel title="Ball Parameters" collapsible="true" extended="true">
		<aui:select name="compression" width="40">
      		<aui:option value="low">
        		<liferay-ui:message key="low" />
      		</aui:option>
      		<aui:option value="normal" selected="<%= true %>">
        		<liferay-ui:message key="normal" />
      		</aui:option>
      		<aui:option value="high">
        		<liferay-ui:message key="high" />
      		</aui:option>
      		<aui:option value="limitedFlight">
        		<liferay-ui:message key="limited-flight" />
      		</aui:option>
      	</aui:select>
		
		<%if (hasShotData){ %>
		<aui:input 
			id="shotdata8" 
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
			id="shotdata8" 
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
	<liferay-ui:panel title="Environmental Factors" collapsible="true" extended="true">
	
		<aui:layout>
		<aui:column columnWidth="50" first="true">
		
		<%if (hasShotData){ %>
			<aui:input 
				id="shotData9" 
				name="windDirection" 
				size="10" 
				value="<%= shot.getWindDirection() %>"/>
			<aui:input 
				id="shotData10" 
				name="windSpeed" 
				size="10" 
				value="<%= shot.getWindSpeed() %>"/>
		<%} else { %>
			<aui:input 
				id="shotData9" 
				name="windDirection" 
				size="10" 
				value="0"/>
			<aui:input 
				id="shotData10" 
				name="windSpeed" 
				size="10" 
				value="0"/>
		<%} %>
		</aui:column>
		<aui:column columnWidth="50" last="true">
			<%if (hasShotData){ %>
				<aui:input 
					id="shotData11" 
					name="ambientTemp" 
					size="10" 
					value="<%= shot.get_temperature() %>"/>
				<aui:input 
					id="shotData12" 
					name="barPressureAlt" 
					size="10" 
					value="<%= shot.get_altitude() %>"/>
			<%} else { %>		
				<aui:input 
					id="shotData11" 
					name="ambientTemp" 
					size="10" 
					value="0"/>
				<aui:input 
					id="shotData12" 
					name="barPressureAlt" 
					size="10" 
					value="0"/>
			<%} %>
		</aui:column>
		</aui:layout>
	</liferay-ui:panel>
	<liferay-ui:panel title="Fairway Firmnesss" collapsible="true" extended="true">
	
		<aui:layout>
		
			<aui:field-wrapper name="fairway">
				<aui:input checked="<%= true %>" inlineLabel="right" name="fairway" type="radio" value="1" label="Carry Only - (No Roll)" />
				<aui:input inlineLabel="right" name="fairway" type="radio" value="2" label="Normal - (Carry Only + 10%)"  />
				<aui:input inlineLabel="right" name="fairway" type="radio" value="3" label="Hard - (Carry Only + 15%)" />
			</aui:field-wrapper>
				
		</aui:layout>
	</liferay-ui:panel>
	</liferay-ui:panel-container>
		<aui:button-row>
			<aui:button type="button" name="upload" value="Upload Shot" onClick="javascript: openPopup('Display Shot Data');"/>
			<aui:button type="submit" name="simulate" value="Simulate" />
			<aui:button type="button" name="save" value="Save & Register" onClick="<%= addSubscriptionURL.toString() %>" disabled="<%= !hasShotData %>" visible="<%= isRegistered %>"/>
		</aui:button-row>
		
	</aui:fieldset>
	
</aui:form>
<aui:script>
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
           
           dialog.plug(A.Plugin.IO, {uri: '<%= uploadShotDataURL %>' });
           dialog.show();
        });  
}
</aui:script>