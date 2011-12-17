<%
ResultRow row = (ResultRow) request.getAttribute(
    WebKeys.SEARCH_CONTAINER_RESULT_ROW);
ESPlayerShotData myShotData = (ESPlayerShotData) row.getObject();
long groupId = themeDisplay.getLayout().getGroupId();
String name = ESPlayerShotData.class.getName();
String primKey = String.valueOf(myShotData.getPrimaryKey());

ESClub club = ActionUtil.getClub(myShotData.getPlayerClubId());

%>

<liferay-ui:icon-menu>

  <c:if test="<%= permissionChecker.hasPermission(groupId, name, primKey, ActionKeys.UPDATE) %>">
    <portlet:actionURL name="uploadShotData" var="uploadShotDataURL">
      <portlet:param name="resourcePrimKey" value="<%= primKey %>" />
    </portlet:actionURL>

    <liferay-ui:icon image="view" message="share" url="<%= shareShotDataURL.toString() %>" />
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