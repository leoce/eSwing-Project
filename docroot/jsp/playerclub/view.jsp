<%@ include file="/init.jsp" %>

<%
  String clubId = String.valueOf(ParamUtil.getLong(request,"clubName"));
%>
<liferay-ui:success key="playerClubSaved" message="player-club-saved-successfully" />
<liferay-ui:success key="playerClubDeleted" message="playerClubDeleted" />
<liferay-ui:success key="playerClubUpdated" message="playerClubUpdated" />
<liferay-ui:error key="fields-required" message="fields-required" />
<liferay-ui:error key="error-deleting" message="error-deleting" />
<liferay-ui:error key="error-updating" message="error-updating" />

 <portlet:actionURL name="editPlayerClub" var="editPlayerClubURL">
 	<portlet:param name="resourcePrimKey" value="<%= clubId %>" />
 </portlet:actionURL>
 <portlet:actionURL name="addPlayerClub" var="addPlayerClubURL"/>

 <aui:form name="fm" action="<%= addPlayerClubURL.toString() %>" method="post">
	<aui:fieldset>
		
    	<aui:select id="clubName" name="clubName" onChange="<%= editPlayerClubURL.toString() %>">
      		<aui:option value="-1">
        		<liferay-ui:message key="please-choose" />
      		</aui:option>
      		
      		<%
    			List<ESClub> clubs = ActionUtil.getActiveClubs(renderRequest);
        			
    		%>
      		<%
      			for (int i = 0; i < clubs.size(); i++) {

      		%>
      		<aui:option value="<%= clubs.get(i).getClubId() %>" >
        		<%= clubs.get(i).getClubName() %>
      		</aui:option>
      		<%
      			}
      		%>
    	</aui:select>
		
		<aui:input id="clubDesc"
			name="clubDesc" 
			size="30" 
			/>
		
		<aui:input id="clubLoft"
			name="loft" 
			size="30" 
			/>
		
		<aui:input id="clubWeight"
			name="weight" 
			size="30" 
			/>
		
		<aui:input id="clubModel"
			name="model" 
			size="30"
			/>
		
		<aui:field-wrapper name="active">
			<aui:input checked="<%= true %>" inlineLabel="right" name="active" type="radio" value="true" label="activate" />
			<aui:input inlineLabel="right" name="active" type="radio" value="false" label="deactivate"  />
		</aui:field-wrapper>
		
		<aui:button-row>
			<aui:button type="submit" />
			<aui:button type="button" name="reset" value="Reset" />
			<aui:button type="button" name="cancel" value="Cancel" />
		</aui:button-row>
		
	</aui:fieldset>
</aui:form>
