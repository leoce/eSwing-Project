<%@ include file="/init.jsp" %>

<%


String redirect = ParamUtil.getString(request, "redirect");
ESPlayerShotData myShotData = (ESPlayerShotData) request.getAttribute("shotData");
ESClub club = (ESClub) request.getAttribute("club");

if (myShotData == null){
	
	myShotData = new ESPlayerShotDataImpl();
	
	Calendar period = CalendarFactoryUtil.getCalendar();

	period.set(period.get(Calendar.YEAR),period.get(Calendar.MONTH),period.get(Calendar.DATE));
	
	myShotData.setCreateDate(period.getTime());
	
	
}

%>

<portlet:actionURL name="simulateSelectedShotData" var="simulateShotDataURL"/>

<aui:form id="fm" name="fm" action="<%= simulateShotDataURL.toString() %>" method="post" >
	<aui:fieldset>
	<aui:input type="hidden" name="redirect" value="<%= redirect %>" />
		<liferay-ui:panel-container id="shotDataFilter">
			<liferay-ui:panel title="Filter Shot Data" collapsible="true" extended="true">
				<aui:layout>
					<aui:column columnWidth="50" first="true">
						<aui:input id="filterByDate" checked="<%= true %>" inlineLabel="right" name="filter" type="radio" value="1" label="Date" />
			
						<aui:select name="viewByDate" width="40">
      						<aui:option value="all">
        						<liferay-ui:message key="All" />
      						</aui:option>
      						<aui:option value="today">
        						<liferay-ui:message key="today" />
      						</aui:option>
      						<aui:option value="mostRecent">
        						<liferay-ui:message key="most-recent" />
      						</aui:option>
      						<aui:option value="setDate">
        						<liferay-ui:message key="set-date" />
      						</aui:option>
    					</aui:select>
    		
    					<%
							Calendar createdDate = CalendarFactoryUtil.getCalendar();
							createdDate.setTime(myShotData.getCreateDate());
					
						%>
    					<aui:input 
							name="createDate"
        					model="<%= ESPlayerShotData.class %>"
        					bean="<%= myShotData  %>"
							value= "<%= createdDate %>" />
			
    					</aui:column>
    	
    					<aui:column columnWidth="50" last="true">
    	
    					<aui:input id="filterByClub" inlineLabel="right" name="filter" type="radio" value="2" label="Club"  />
    			
							<aui:select name="clubName">
      							<aui:option value="-1">
        							<liferay-ui:message key="please-choose" />
      							</aui:option>
      		
      							<%
    								List<ESClub> clubs =
        								ESClubLocalServiceUtil.getESClubs(QueryUtil.ALL_POS,QueryUtil.ALL_POS);
    							%>
      							<%
      								for (int i = 0; i < clubs.size(); i++) {
      				
      			
      							%>
      								<aui:option value="<%= clubs.get(i).getClubId() %>">
        								<%= clubs.get(i).getClubName() %>
      								</aui:option>
      							<%
      								}
      							%>
    						</aui:select>
    						
    						<%
    							Calendar endDate = CalendarFactoryUtil.getCalendar();
										endDate.setTime(myShotData.getCreateDate());
    						%>
    					<aui:input 
							name="createDate"
        					model="<%= ESPlayerShotData.class %>"
        					bean="<%= myShotData  %>"
							value= "<%= endDate %>" 
							label="end-date" />
    		
    					</aui:column>
    	
    			</aui:layout>
    	
		</liferay-ui:panel>
		</liferay-ui:panel-container>
	</aui:fieldset>
	
	
	<liferay-ui:search-container
      emptyResultsMessage="there-are-no-shot-data"
      delta="5" >

    <liferay-ui:search-container-results>
   		<%
    		List<ESPlayerShotData> tempResults = ActionUtil.getPlayerShotData(renderRequest);
			
    	results = ListUtil.subList(
        	tempResults, searchContainer.getStart(), searchContainer.getEnd());
    		total = tempResults.size();

    		pageContext.setAttribute("results", results);
    		pageContext.setAttribute("total", total);
    	%>
    </liferay-ui:search-container-results>

    <liferay-ui:search-container-row
        className="com.eswinggolf.portal.data.layer.club.model.ESPlayerShotData"
        keyProperty="shotDataId"
        modelVar="shotData" >
        
      <%
			String id = String.valueOf(shotData.getShotDataId());
			
        	String plns = "<porlet:namespace /> ";
			String checkBox1 = "<input type='checkbox' name='check' onClick='javascript: checkAll(this);'/>";
			String checkBox2 = "<input type='checkbox' name='plot' value='" + id + "' onClick='javascript: checkAllRev(this);' />";
		%>	
   	  <liferay-ui:search-container-column-text name="<%= checkBox1 %>" value="<%= checkBox2 %>" />
      <liferay-ui:search-container-column-text
          name="club"
          value="<%= ActionUtil.getClub(shotData.getPlayerClubId()).getClubName() %>" />
      <liferay-ui:search-container-column-text
          name="club-desc"
          value="<%= ActionUtil.getClub(shotData.getPlayerClubId()).getClubDesc() %>" /> 
      <liferay-ui:search-container-column-text
          name="loft"
          property="clubLoft" />
      <liferay-ui:search-container-column-text
      	  name="createDate" 
      	  value="<%= ActionUtil.dateFormat(shotData.getCreateDate()) %>" />
	</liferay-ui:search-container-row>
    
    <liferay-ui:search-iterator />

  </liferay-ui:search-container>
  
  	<aui:button-row>
		<aui:button type="submit" name="Ok" value="Ok"/>
		<aui:button type="cancel" name="Cancel"/>
	</aui:button-row>

</aui:form>
<aui:script>

function checkAll(obj) {
	var items = document.getElementsByName("plot");
	for (var i=0; i<items.length; i++) {
		items[i].checked = obj.checked;
	}
}
function checkAllRev(obj) {
	var items = document.getElementsByName("plot");
	var item = document.getElementsByName("check");
	size = items.length;
	if(size == getCheckedCount()) {
		item.checked = true;
	} else {
		item.checked = false;
	}
}
function getCheckedCount() {
	var items = document.getElementsByName("plot");
	checkedCount=0;
	for (i=0; i< items.length; i++)
	{
        if(items[i].checked)
        {
        	checkedCount += 1;
        }
	}
	return checkedCount;
}

</aui:script>