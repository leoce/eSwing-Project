<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.Collections" %>
<%@ page import="com.liferay.portal.kernel.util.HtmlUtil" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.kernel.util.CalendarFactoryUtil" %>
<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow" %>
<%@ page import="com.liferay.portal.kernel.dao.search.SearchEntry" %>
<%@ page import="com.liferay.portal.kernel.dao.search.RowChecker" %>
<%@ page import="com.liferay.portal.kernel.exception.SystemException" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import="com.liferay.portal.security.permission.ActionKeys" %>
<%@ page import="com.liferay.portal.kernel.util.ListUtil" %>
<%@ page import="com.liferay.portal.util.PortalUtil" %>
<%@ page import="com.liferay.portal.service.permission.PortalPermissionUtil" %>
<%@ page import="com.liferay.portal.service.permission.PortletPermissionUtil" %>
<%@ page import="com.liferay.portal.kernel.dao.orm.QueryUtil" %>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@ page import="com.eswinggolf.portal.data.layer.club.model.ESClub" %>
<%@ page import="com.eswinggolf.portal.data.layer.club.model.impl.ESClubImpl" %>
<%@ page import="com.eswinggolf.portal.data.layer.club.model.ESPlayerClub" %>
<%@ page import="com.eswinggolf.portal.data.layer.club.service.ESClubLocalServiceUtil" %>
<%@ page import="com.eswinggolf.player.shotdata.trajectory.model.ShotData" %>
<%@ page import="com.eswinggolf.player.shotdata.trajectory.model.TrajectoryModel" %>
<%@ page import="com.eswinggolf.player.shotdata.trajectory.model.Point3D" %>
<%@ page import="com.eswinggolf.portal.data.layer.club.model.ESPlayerShotData" %>
<%@ page import="com.eswinggolf.portal.data.layer.club.model.impl.ESPlayerShotDataImpl" %>
<%@ page import="com.eswinggolf.portal.data.layer.club.service.ESPlayerShotDataLocalServiceUtil" %>
<%@ page import="com.eswinggolf.portal.data.layer.club.model.ESTrialShotData" %>
<%@ page import="com.eswinggolf.portal.data.layer.club.model.impl.ESTrialShotDataImpl" %>
<%@ page import="com.eswinggolf.portal.data.layer.club.service.ESTrialShotDataLocalServiceUtil" %>
<%@ page import="com.liferay.portal.service.permission.PortalPermissionUtil" %>
<%@ page import="com.liferay.portal.service.permission.PortletPermissionUtil" %>
<%@ page import="com.eswinggolf.club.profile.portlet.ActionUtil" %>

<%@ page import="javax.portlet.PortletURL" %>


<portlet:defineObjects />

<liferay-theme:defineObjects />