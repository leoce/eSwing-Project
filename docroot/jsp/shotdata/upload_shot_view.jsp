<%@ include file="/init.jsp" %>

<%
ShotData shotData = (ShotData) request.getAttribute("shotData");

%>

<portlet:renderURL var="cancelURL">
  <portlet:param name="jspPage" value="/jsp/shotdata/view.jsp" />
</portlet:renderURL>

<portlet:renderURL var="addSubscriptionURL">
  <portlet:param name="jspPage" value="http://localhost:8080/web/test/trial-subscription-registration" />
</portlet:renderURL>

<portlet:actionURL name="simulateShotData" var="simulateShotDataURL" />

<aui:form
    name="fm"
    action="<%= simulateShotDataURL.toString() %>"
    method="post">

  <aui:fieldset>
    
    <aui:input inlineLabel="right" 
    	name="launchMonitor" 
    	type="checkbox" 
    	disabled="true" 
    	checked="<%= shotData.isLaunchMonitor() %>" 
    	label="Launch Monitor Attached" />
    <liferay-ui:panel-container>
	<liferay-ui:panel title="Clubs" collapsible="true" extended="true">			
		<aui:layout>
		<aui:column columnWidth="50" first="true">
			
			<aui:select name="clubName">
      	
      			<aui:option value="<%= shotData.getClubId() %>">
        			<%= shotData.getClubName() %>
      			</aui:option>
     
    		</aui:select>
				
				<aui:input 
					id="shotData1" 
					name="clubSpeed" 
					size="10" 
					value="<%= shotData.getClubSpeed() %>"/>
						
				<aui:input 
					id="shotData2" 
					name="faceAngle" 
					size="10" 
					value="<%= shotData.getClubFaceAngle() %>"/>
				
		</aui:column>
		<aui:column columnWidth="50" last="true">
		
			<aui:input 
				id="shotData3" 
				name="loft" 
				size="10" 
				value="<%= shotData.getClubLoft() %>"/>
							
			<aui:input 
				id="shotData4" 
				name="spinRate" 
				size="10" 
				value="<%= shotData.getClubSpinRate() %>"/>
						
			<aui:input 
				id="shotData5" 
				name="swingPath" 
				size="10" 
				value="<%= shotData.getClubSwingPath() %>"/>
				
		</aui:column>
		</aui:layout>
	</liferay-ui:panel>
	<!-- Ball Parameters Panel -->
	<liferay-ui:panel title="Ball Parameters" collapsible="true" extended="true">
	
		<aui:select name="compression" width="40">
      		<aui:option value="">
        		<liferay-ui:message key="please-choose" />
      		</aui:option>
			<c:choose>
        	
            <c:when test='<%= shotData.getBallCompression() == 0.89d  %>'>
              <aui:option value="low" selected="true">
                <liferay-ui:message key="low" />
              </aui:option>
            </c:when>
            <c:when test='<%= shotData.getBallCompression() == 1.0d %>'>
              <aui:option value="normal" selected="true">
                <liferay-ui:message key="normal" />
              </aui:option>
            </c:when>
            <c:when test='<%= shotData.getBallCompression() == 1.02d %>'>
              <aui:option value="high" selected="true">
                <liferay-ui:message key="high" />
              </aui:option>
            </c:when>
            <c:when test='<%= shotData.getBallCompression() == 1.03d %>'>
              <aui:option value="limited" selected="true">
                <liferay-ui:message key="limited-flight" />
              </aui:option>
            </c:when>
            <c:otherwise>
              <aui:option value="normal">
                <liferay-ui:message key="normal" />
              </aui:option>
            </c:otherwise>
          </c:choose>
        </aui:select>
        
		<aui:input 
			id="shotdata8" 
			name="angleOfAttack" 
			size="20" 
			value="<%= shotData.getBallAOA() %>"/> 
		<aui:input 
			id="shotData7" 
			name="initialBallVelocity" 
			size="20" 
			size="<%= shotData.getBallSpeed() %>"/>
		
	</liferay-ui:panel>
	<liferay-ui:panel title="Environmental Factors" collapsible="true" extended="true">
	
		<aui:layout>
		<aui:column columnWidth="50" first="true">
		<aui:input 
			id="shotData9" 
			name="windDirection" 
			size="10" 
			value="<%= shotData.getWindDirection() %>"/>
		
		<aui:input 
			id="shotData10" 
			name="windSpeed" 
			size="10" 
			value="<%= shotData.getWindSpeed() %>"/>
			
		</aui:column>
		<aui:column columnWidth="50" last="true">
				
		<aui:input 
			id="shotData11" 
			name="ambientTemp" 
			size="10" 
			value="<%= shotData.get_temperature()  %>"/>
		
		<aui:input 
			id="shotData12" 
			name="barPressureAlt" 
			size="10" 
			value="<%= shotData.get_altitude() %>"/>
			
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
		<aui:button type="submit" name="simulate" value="Simulate" />
	  	<aui:button id="register" type="button" name="save" value="Save & Register" onclick="<%= addSubscriptionURL.toString() %>"/>   
      	<aui:button type="cancel" value="Cancel" onClick="<%= cancelURL.toString() %>" />
    </aui:button-row>

  </aui:fieldset>

</aui:form>