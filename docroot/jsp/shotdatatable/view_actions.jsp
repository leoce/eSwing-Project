<%@ include file="/init.jsp" %>

<%
ResultRow row = (ResultRow) request.getAttribute(
    WebKeys.SEARCH_CONTAINER_RESULT_ROW);
ESPlayerShotData myShotData = (ESPlayerShotData) row.getObject();
long groupId = 10171;//themeDisplay.getLayout().getGroupId();
String name = ESPlayerShotData.class.getName();
String primKey = String.valueOf(myShotData.getPrimaryKey());

ESClub club = ActionUtil.getClub(myShotData.getPlayerClubId());


%>

<liferay-ui:icon-menu>
	
	<c:if test="<%= permissionChecker.hasPermission(groupId, name, primKey, ActionKeys.UPDATE) %>">	
    	<portlet:actionURL name="shareShotData" var="shareShotDataURL">
      		<portlet:param name="resourcePrimKey" value="<%= primKey %>" />
    	</portlet:actionURL>

    	<liferay-ui:icon image="edit" message="share" url="<%= shareShotDataURL.toString() %>" />
 	</c:if>
 	
 	<c:if test="<%= permissionChecker.hasPermission(groupId, name, primKey, ActionKeys.UPDATE) %>">
    	<portlet:actionURL name="activateShotData" var="activateShotDataURL">
      		<portlet:param name="resourcePrimKey" value="<%= primKey %>" />
    	</portlet:actionURL>

    <liferay-ui:icon image="edit" message="activate" url="<%= activateShotDataURL.toString() %>" />
  	</c:if>
  	
  	<c:if test="<%= permissionChecker.hasPermission(groupId, name, primKey, ActionKeys.UPDATE) %>">
    	<portlet:actionURL name="deactivateShotData" var="deactivateShotDataURL">
      		<portlet:param name="resourcePrimKey" value="<%= primKey %>" />
    	</portlet:actionURL>

    <liferay-ui:icon image="edit" message="deactivate" url="<%= deactivateShotDataURL.toString() %>" />
	</c:if>
	
	<c:if test="<%= permissionChecker.hasPermission(groupId, name, primKey, ActionKeys.PERMISSIONS) %>">
    <liferay-security:permissionsURL
        modelResource="<%= ESClub.class.getName() %>"
        modelResourceDescription="<%= club.getClubDesc() %>"
        resourcePrimKey="<%= primKey %>"
        var="permissionsURL" />

    <liferay-ui:icon image="permissions" url="<%= permissionsURL.toString() %>" />
  </c:if>
	
	
</liferay-ui:icon-menu>