<%@ include file="/init.jsp" %>

<%
ESClub club = (ESClub) request.getAttribute("club");
%>

<portlet:renderURL var="cancelURL">
  <portlet:param name="jspPage" value="/jsp/club/view.jsp" />
</portlet:renderURL>

<portlet:actionURL name="updateClub" var="updateClubURL" />

<h3>Edit A Club</h3>

<aui:form
    name="fm"
    action="<%= updateClubURL.toString() %>"
    method="post">

  <aui:fieldset>

    <aui:input
        name="resourcePrimKey"
        value="<%= club.getClubId() %>"
        type="hidden"
    />
    <aui:input
        name="clubName"
        value="<%= club.getClubName() %>"
        size="30"
    />
    
    <aui:input
        name="clubDesc"
        value="<%= club.getClubDesc() %>"
        size="30"
    />
	
	<aui:layout>
		<aui:column columnWidth="50" first="true">
    		
			<aui:input 
				name="loft"
				value="<%= club.getLoft() %>"
				size="10" 
			/>
			
			<aui:input 
				name="nomSr"
				value="<%= club.getNomSr() %>" 
				size="10"
			/>
			
			<aui:input 
				name="nomSpeed"
				value="<%= club.getNomSpeed() %>" 
				size="10"
			/>
		</aui:column>
		<aui:column columnWidth="50" last="true">
			
			<aui:input 
				name="coR"
				value="<%= club.getCoR() %>" 
				size="10"
			/>
			
			<aui:input 
				name="weight"
				value="<%= club.getWeight() %>" 
				size="10"
			/>
			
			<aui:input 
				name="model"
				value="<%= club.getModel() %>" 
				size="10"
			/>
			
		</aui:column>
	</aui:layout>
	
	<aui:field-wrapper name="active">
	 	<% if (club.getActive()){ %>
	 		<aui:input checked="<%= true %>" inlineLabel="right" name="active" type="radio" value="1" label="Yes" />
	 		<aui:input inlineLabel="right" name="active" type="radio" value="2" label="No"  />
	 	<% } else { %>
	 		<aui:input inlineLabel="right" name="active" type="radio" value="1" label="Yes" />
			<aui:input checked="<%= true %>" inlineLabel="right" name="active" type="radio" value="2" label="No"  />
		<% } %>	
	</aui:field-wrapper>
	
    <aui:input
        name="modifiedDate"
        value="<%= club.getModifiedDate() %>"
        type="hidden"
    />
    
    <aui:button-row>

      <aui:button type="submit"/>
      <aui:button
          type="cancel"
          value="Cancel"
          onClick="<%= cancelURL.toString() %>"
    />

    </aui:button-row>

  </aui:fieldset>

</aui:form>