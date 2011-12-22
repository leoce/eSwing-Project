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

    <portlet:actionURL name="uploadShotData" var="uploadShotDataURL">
      <portlet:param name="resourcePrimKey" value="<%= primKey %>" />
    </portlet:actionURL>

    <liferay-ui:icon image="view" message="upload" url="<%= uploadShotDataURL.toString() %>" />
 	
  	
</liferay-ui:icon-menu>