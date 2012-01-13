<%@ include file="/init.jsp" %>
<%
ResultRow row = (ResultRow) request.getAttribute(
    WebKeys.SEARCH_CONTAINER_RESULT_ROW);
ESPlayerShotData myShotData = (ESPlayerShotData) row.getObject();
String primKey = String.valueOf(myShotData.getPrimaryKey());

%>

<liferay-ui:icon-menu>

    <portlet:actionURL name="uploadShotData" var="uploadShotDataURL">
      <portlet:param name="resourcePrimKey" value="<%= primKey %>" />
    </portlet:actionURL>

    <liferay-ui:icon image="view" message="upload" url="<%= uploadShotDataURL.toString() %>"  />

</liferay-ui:icon-menu>