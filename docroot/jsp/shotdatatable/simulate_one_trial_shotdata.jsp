<%@ include file="/init.jsp" %>

<%

//String redirect = ParamUtil.getString(request, "redirect");
ESTrialShotData trialData = (ESTrialShotData) request.getAttribute("trialData");
ESClub club = (ESClub) request.getAttribute("club");

if (trialData == null){
	
	trialData = new ESTrialShotDataImpl();
	
	Calendar period = CalendarFactoryUtil.getCalendar();

	period.set(period.get(Calendar.YEAR),period.get(Calendar.MONTH),period.get(Calendar.DATE));
	
	trialData.setCreateDate(period.getTime());
	
	
}


%>
<portlet:renderURL var="filterByDateURL">
	<portlet:param name="shotDataByDate" value="" />
</portlet:renderURL>

<portlet:renderURL var="filterByClubURL">
	<portlet:param name="shotDataByClub" value="" />
</portlet:renderURL>

<aui:form name="fm" >
	<aui:fieldset>
		<liferay-ui:panel-container id="trialDataFilter">
			<liferay-ui:panel title="Filter Shot Data" collapsible="true" extended="true">
				<aui:layout>
					<aui:column columnWidth="50" first="true">
						<aui:input id="filterByDate" name="filter" inlineLabel="right" 
						type="radio" label="Date" value="date" />
			
						<aui:select id="viewByDate" name="viewByDate" width="40">
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
							createdDate.setTime(trialData.getCreateDate());
					
						%>
    					<aui:input 
							name="createDate"
        					model="<%= ESTrialShotData.class %>"
        					bean="<%= trialData  %>"
							value= "<%= createdDate %>" />
			
    					</aui:column>
    	
    					<aui:column columnWidth="50" last="true">
    	
    					<aui:input id="filterByClub" inlineLabel="right" name="filter" 
    					      type="radio" label="Club" value="club"/>
    			
							<aui:select id="clubName" name="clubName">
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
										endDate.setTime(trialData.getCreateDate());
    						%>
    					<aui:input 
							name="createDate"
        					model="<%= ESTrialShotData.class %>"
        					bean="<%= trialData  %>"
							value= "<%= endDate %>" 
							label="end-date" />
    		
    					</aui:column>
    	
    			</aui:layout>
    	
		</liferay-ui:panel>
		</liferay-ui:panel-container>
	</aui:fieldset>
</aui:form>	
<liferay-ui:search-container
      emptyResultsMessage="there-are-no-shot-data"
      delta="5">

    <liferay-ui:search-container-results>
   		<%
   		   
    		List<ESTrialShotData>	tempResults = ActionUtil.getTrialShotData(renderRequest);
   			
    	results = ListUtil.subList(
        	tempResults, searchContainer.getStart(), searchContainer.getEnd());
    		total = tempResults.size();

    		pageContext.setAttribute("results", results);
    		pageContext.setAttribute("total", total);
    	%>
    </liferay-ui:search-container-results>

    <liferay-ui:search-container-row
        className="com.eswinggolf.portal.data.layer.club.model.ESTrialShotData"
        keyProperty="shotDataId"
        modelVar="shotdata" >
      <liferay-ui:search-container-column-text
          name="club"
          value="<%= ActionUtil.getClub(shotdata.getPlayerClubId()).getClubName() %>" />
      <liferay-ui:search-container-column-text
          name="club-desc"
          value="<%= ActionUtil.getClub(shotdata.getPlayerClubId()).getClubDesc() %>" />  
      <liferay-ui:search-container-column-text
          name="loft"
          property="clubLoft" />
      <liferay-ui:search-container-column-text
      	  name="createDate" 
      	  property="createDate"/>
      <liferay-ui:search-container-column-jsp
          path="/jsp/shotdatatable/simulate_actions_trial.jsp"
          align="right" />

	</liferay-ui:search-container-row>
    
    <liferay-ui:search-iterator />

  </liferay-ui:search-container>
  
