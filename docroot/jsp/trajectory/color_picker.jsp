<%@ include file="/init.jsp" %>

<portlet:actionURL name="changeColor" var="changeColorURL" />

<aui:form name="fm" action="<%= changeColorURL.toString() %>" method="post">
	<aui:fieldset>
	<aui:input inlineLabel="right" name="launchMonitor" type="checkbox" disabled="<%= true %>" checked="<%= false %>" label="Launch Monitor Attached" />
				
	<aui:panel id="club" label="Clubs" collapsible="true" >

			<aui:select id="rightSide" name="right" size="10" />
						
			<aui:select id="center" name="middle" size="10" />
		
			<aui:select id="leftSide" name="left" size="10" />
							
	</aui:panel>
</aui:fieldset>
</aui:form>
<aui:script>
AUI().ready('aui-color-picker',
function(A) {
	var colorNode1 = A.one('#rightSide');

	window.colorPicker = new A.ColorPicker({
		after: {
			colorChange: function(val) {
				var hex = '#' + this.get('hex');

				colorNode1.setContent('color: ' + hex);
				colorNode1.setStyle('backgroundColor', hex);
				
			}
		}
	}).render('#center');
});
</aui:script>