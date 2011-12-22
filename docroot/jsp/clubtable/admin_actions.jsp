<%@ include file="/init.jsp" %>

<%
ResultRow row = (ResultRow) request.getAttribute(
    WebKeys.SEARCH_CONTAINER_RESULT_ROW);
ESPlayerClub myPlayerClub = (ESPlayerClub) row.getObject();
long groupId = themeDisplay.getLayout().getGroupId();
String name = ESPlayerClub.class.getName();
String primKey = String.valueOf(myPlayerClub.getPrimaryKey());
%>

<liferay-ui:icon-menu>

  <c:if test="<%= permissionChecker.hasPermission(groupId, name, primKey, ActionKeys.UPDATE) %>">
    <portlet:actionURL name="editPlayerClub" var="editURL" windowState="normal">
      <portlet:param name="resourcePrimKey" value="<%= primKey %>" />
    </portlet:actionURL>

    <liferay-ui:icon image="edit" message="Edit" url="<%= editURL.toString() %>" />
  </c:if>

  <c:if test="<%= permissionChecker.hasPermission(groupId, name, primKey, ActionKeys.DELETE) %>">
    <portlet:actionURL name="deletePlayerClub" var="deleteURL">
      <portlet:param name="resourcePrimKey" value="<%= primKey %>" />
    </portlet:actionURL>

    <liferay-ui:icon-delete url="<%= deleteURL.toString() %>" />
  </c:if>

  <c:if test="<%= permissionChecker.hasPermission(groupId, name, primKey, ActionKeys.PERMISSIONS) %>">
    <liferay-security:permissionsURL
        modelResource="<%= ESPlayerClub.class.getName() %>"
        modelResourceDescription="<%= myPlayerClub.getClubDesc() %>"
        resourcePrimKey="<%= primKey %>"
        var="permissionsURL" />

    <liferay-ui:icon image="permissions" url="<%= permissionsURL.toString() %>" />
  </c:if>
</liferay-ui:icon-menu>