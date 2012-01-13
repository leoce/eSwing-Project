<%@ include file="/init.jsp" %>

<%

ESPlayerShotData shotData = (ESPlayerShotData) request.getAttribute("shotData");
ESClub club = (ESClub) request.getAttribute("club");


if (shotData == null){
	
	shotData = new ESPlayerShotDataImpl();
	
	Calendar period = CalendarFactoryUtil.getCalendar();

	period.set(period.get(Calendar.YEAR),period.get(Calendar.MONTH),period.get(Calendar.DATE));
	
	shotData.setCreateDate(period.getTime());
	
	
}


%>

<portlet:actionURL name="uploadShotData" var="uploadShotDataURL"/>

 <portlet:actionURL name="shareShotData" var="shareShotDataURL">
	<portlet:param name="jspPage" value="/jsp/shotdatatable/view_actions.jsp" />
</portlet:actionURL>

<portlet:actionURL name="activateShotData" var="activateShotDataURL">
	<portlet:param name="jspPage" value="/jsp/shotdatatable/view_actions.jsp" />
</portlet:actionURL>

<portlet:actionURL name="deactivateShotData" var="deactivateShotDataURL">
	<portlet:param name="jspPage" value="/jsp/shotdatatable/view_actions.jsp" />
</portlet:actionURL>

<aui:form name="fm" >
	<aui:fieldset>
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
							createdDate.setTime(shotData.getCreateDate());
					
						%>
    					<aui:input 
							name="createDate"
        					model="<%= ESPlayerShotData.class %>"
        					bean="<%= shotData  %>"
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
										endDate.setTime(shotData.getCreateDate());
    						%>
    					<aui:input 
							name="createDate"
        					model="<%= ESPlayerShotData.class %>"
        					bean="<%= shotData  %>"
							value= "<%= endDate %>" 
							label="end-date" />
    		
    					</aui:column>
    	
    			</aui:layout>
    	
		</liferay-ui:panel>
		</liferay-ui:panel-container>
		
		<aui:button-row>
			<aui:button type="button" name="share" value="Share" onClick="<%= shareShotDataURL.toString() %>"/>
			<aui:button type="button" name="activate" value="Activate" onClick="<%= activateShotDataURL.toString() %>"/>
			<aui:button type="button" name="deactivate" value="Deactivate" onClick="<%= deactivateShotDataURL.toString() %>"/>
		</aui:button-row>
	</aui:fieldset>
	</aui:form>
	
<liferay-ui:search-container
      emptyResultsMessage="there-are-no-shot-data"
      delta="10"
      rowChecker="<%= new RowChecker(renderResponse) %>">

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
        modelVar="shotdata" >
		
      <liferay-ui:search-container-column-text
          name="club"
          value="<%= ActionUtil.getClub(shotdata.getPlayerClubId()).getClubName() %>" orderable="<%= true %>" orderableProperty="playerClubId"/>
      <liferay-ui:search-container-column-text
          name="club-desc"
          value="<%= ActionUtil.getClub(shotdata.getPlayerClubId()).getClubDesc() %>" />  
      <liferay-ui:search-container-column-text
          name="loft"
          property="clubLoft" orderable="<%= true %>" orderableProperty="clubLoft" />
      <liferay-ui:search-container-column-text
      	  name="createDate" 
      	  value="<%= ActionUtil.dateFormat(shotdata.getCreateDate()) %>" orderable="<%= true %>" orderableProperty="createDate"/>      	  
      <liferay-ui:search-container-column-text name="Active" >
      		<aui:input type="checkbox" name="active" value="<%= shotdata.isActive() %>" disabled="<%= true %>"/>
      </liferay-ui:search-container-column-text>      
       <liferay-ui:search-container-column-jsp
          path="/jsp/shotdatatable/view_actions.jsp"
          align="right" />
	</liferay-ui:search-container-row>
    
    <liferay-ui:search-iterator />

  </liferay-ui:search-container>