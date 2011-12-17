<%@ include file="/init.jsp" %>

<%
ESPlayerClub playerClub = (ESPlayerClub) request.getAttribute("club");
%>

<portlet:renderURL var="cancelURL">
  <portlet:param name="jspPage" value="/jsp/playerclub/view.jsp" />
</portlet:renderURL>

<portlet:actionURL name="updatePlayerClub" var="updatePlayerClubURL" />

<h2>Edit A Player\\'s Club</h2>

<aui:form
    name="fm"
    action="<%= updatePlayerClubURL.toString() %>"
    method="post">

  <aui:fieldset>

    <aui:input
        name="resourcePrimKey"
        value="<%= playerClub.getPlayerClubId() %>"
        type="hidden"
    />
    <aui:input
        name="clubId"
        value="<%= playerClub.getClubId() %>"
        type="hidden"
    />
    
    <aui:input
        name="playerId"
        value="<%= playerClub.getPlayerId() %>"
        type="hidden"
    />
    
    <aui:input
        name="loft"
        value="<%= playerClub.getLoft()%>"
        size="40"
    />
	
	<aui:input
        name="weight"
        value="<%= playerClub.getWeight()%>"
        size="40"
    />
    
	<aui:input
        name="model"
        value="<%= playerClub.getModel()%>"
        size="40"
    />
    
    <aui:input
        name="active"
        value="<%= playerClub.getActive()%>"
        size="40"
    />
    
    <aui:input
        name="modifyDate"
        value="<%= playerClub.getModifiedDate() %>"
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