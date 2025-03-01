/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.mobile.device.rules.web.internal.rule.group.rule;

import com.liferay.mobile.device.rules.model.MDRRule;
import com.liferay.mobile.device.rules.rule.RuleHandler;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.mobile.device.Device;
import com.liferay.portal.kernel.mobile.device.Dimensions;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnicodeProperties;
import com.liferay.portal.kernel.util.Validator;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import org.osgi.service.component.annotations.Component;

/**
 * @author Edward Han
 * @author Milen Daynkov
 */
@Component(immediate = true, service = RuleHandler.class)
public class SimpleRuleHandler implements RuleHandler {

	public static final String PROPERTY_OS = "os";

	public static final String PROPERTY_SCREEN_PHYSICAL_HEIGHT_MAX =
		"screen-physical-height-max";

	public static final String PROPERTY_SCREEN_PHYSICAL_HEIGHT_MIN =
		"screen-physical-height-min";

	public static final String PROPERTY_SCREEN_PHYSICAL_WIDTH_MAX =
		"screen-physical-width-max";

	public static final String PROPERTY_SCREEN_PHYSICAL_WIDTH_MIN =
		"screen-physical-width-min";

	public static final String PROPERTY_SCREEN_RESOLUTION_HEIGHT_MAX =
		"screen-resolution-height-max";

	public static final String PROPERTY_SCREEN_RESOLUTION_HEIGHT_MIN =
		"screen-resolution-height-min";

	public static final String PROPERTY_SCREEN_RESOLUTION_WIDTH_MAX =
		"screen-resolution-width-max";

	public static final String PROPERTY_SCREEN_RESOLUTION_WIDTH_MIN =
		"screen-resolution-width-min";

	public static final String PROPERTY_TABLET = "tablet";

	@Override
	public boolean evaluateRule(MDRRule mdrRule, ThemeDisplay themeDisplay) {
		Device device = themeDisplay.getDevice();

		if (device == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(
					"Rule evaluation is not possible because the information " +
						"about the device is not available");
			}

			return false;
		}

		if (!_isValidMultiValue(mdrRule, PROPERTY_OS, device.getOS()) ||
			!_isValidBooleanValue(
				mdrRule, PROPERTY_TABLET, device.isTablet())) {

			return false;
		}

		Dimensions screenPhysicalSize = device.getScreenPhysicalSize();

		if (!_isValidRangeValue(
				mdrRule, PROPERTY_SCREEN_PHYSICAL_HEIGHT_MAX,
				PROPERTY_SCREEN_PHYSICAL_HEIGHT_MIN,
				screenPhysicalSize.getHeight()) ||
			!_isValidRangeValue(
				mdrRule, PROPERTY_SCREEN_PHYSICAL_WIDTH_MAX,
				PROPERTY_SCREEN_PHYSICAL_WIDTH_MIN,
				screenPhysicalSize.getWidth())) {

			return false;
		}

		Dimensions screenResolution = device.getScreenResolution();

		if (!_isValidRangeValue(
				mdrRule, PROPERTY_SCREEN_RESOLUTION_HEIGHT_MAX,
				PROPERTY_SCREEN_RESOLUTION_HEIGHT_MIN,
				screenResolution.getHeight()) ||
			!_isValidRangeValue(
				mdrRule, PROPERTY_SCREEN_RESOLUTION_WIDTH_MAX,
				PROPERTY_SCREEN_RESOLUTION_WIDTH_MIN,
				screenResolution.getWidth())) {

			return false;
		}

		return true;
	}

	@Override
	public String getEditorJSP() {
		return "/rule/simple_rule.jsp";
	}

	@Override
	public Collection<String> getPropertyNames() {
		return _propertyNames;
	}

	@Override
	public String getType() {
		return SimpleRuleHandler.class.getName();
	}

	private StringBundler _getLogStringBundler(
		MDRRule mdrRule, String value, boolean valid) {

		StringBundler sb = new StringBundler(6);

		sb.append("Rule ");
		sb.append(mdrRule.getNameCurrentValue());
		sb.append(" with the value ");
		sb.append(value);
		sb.append(" is ");

		if (!valid) {
			sb.append("not ");
		}

		return sb;
	}

	private boolean _isValidBooleanValue(
		MDRRule mdrRule, String property, boolean value) {

		UnicodeProperties typeSettingsUnicodeProperties =
			mdrRule.getTypeSettingsProperties();

		String validValueString = typeSettingsUnicodeProperties.get(property);

		if (Validator.isNull(validValueString)) {
			return true;
		}

		boolean ruleValue = GetterUtil.getBoolean(validValueString);

		if (ruleValue != value) {
			_logBooleanValue(mdrRule, property, value, false);

			return false;
		}

		_logBooleanValue(mdrRule, property, value, true);

		return true;
	}

	private boolean _isValidMultiValue(
		MDRRule mdrRule, String property, String value) {

		UnicodeProperties typeSettingsUnicodeProperties =
			mdrRule.getTypeSettingsProperties();

		String validValueString = typeSettingsUnicodeProperties.get(property);

		if (Validator.isNull(validValueString)) {
			return true;
		}

		String[] validValues = StringUtil.split(validValueString);

		if (!ArrayUtil.contains(validValues, value)) {
			_logMultiValue(mdrRule, property, value, validValues, false);

			return false;
		}

		_logMultiValue(mdrRule, property, value, validValues, true);

		return true;
	}

	private boolean _isValidRangeValue(
		MDRRule mdrRule, String maxProperty, String minProperty, float value) {

		UnicodeProperties typeSettingsUnicodeProperties =
			mdrRule.getTypeSettingsProperties();

		String max = typeSettingsUnicodeProperties.get(maxProperty);
		String min = typeSettingsUnicodeProperties.get(minProperty);

		if (Validator.isNull(max) && Validator.isNull(min)) {
			_logRangeValue(
				mdrRule, maxProperty, minProperty, value, max, min, true);

			return true;
		}

		if (Validator.isNotNull(max)) {
			float maxFloat = GetterUtil.getFloat(max);

			if (value > maxFloat) {
				_logRangeValue(
					mdrRule, maxProperty, minProperty, value, max, min, false);

				return false;
			}

			_logRangeValue(
				mdrRule, maxProperty, minProperty, value, max, min, true);
		}

		if (Validator.isNotNull(min)) {
			float minFloat = GetterUtil.getFloat(min);

			if (value < minFloat) {
				_logRangeValue(
					mdrRule, maxProperty, minProperty, value, max, min, false);

				return false;
			}

			_logRangeValue(
				mdrRule, maxProperty, minProperty, value, max, min, true);
		}

		return true;
	}

	private void _logBooleanValue(
		MDRRule mdrRule, String property, boolean value, boolean valid) {

		if (!_log.isDebugEnabled()) {
			return;
		}

		StringBundler sb = _getLogStringBundler(
			mdrRule, String.valueOf(value), valid);

		sb.append("the value configured for the property ");
		sb.append(property);

		_log.debug(sb.toString());
	}

	private void _logMultiValue(
		MDRRule mdrRule, String property, String value, String[] validValues,
		boolean valid) {

		if (!_log.isDebugEnabled()) {
			return;
		}

		StringBundler sb = _getLogStringBundler(mdrRule, value, valid);

		sb.append("among the allowed values of ");
		sb.append(StringUtil.merge(validValues));
		sb.append(" for the property \"");
		sb.append(property);
		sb.append("\"");

		_log.debug(sb.toString());
	}

	private void _logRangeValue(
		MDRRule mdrRule, String maxProperty, String minProperty, float value,
		String max, String min, boolean valid) {

		if (!_log.isDebugEnabled()) {
			return;
		}

		StringBundler sb = _getLogStringBundler(
			mdrRule, String.valueOf(value), valid);

		sb.append("within the allowed range");

		if (Validator.isNotNull(max) && Validator.isNotNull(min)) {
			sb.append(" of ");
			sb.append(min);
			sb.append(" and ");
			sb.append(max);
			sb.append(" for the minimum property \"");
			sb.append(minProperty);
			sb.append("\" and the maximum property \"");
			sb.append(maxProperty);
			sb.append("\"");
		}

		_log.debug(sb.toString());
	}

	private static final Log _log = LogFactoryUtil.getLog(
		SimpleRuleHandler.class);

	private final Collection<String> _propertyNames =
		Collections.unmodifiableCollection(
			Arrays.asList(
				PROPERTY_OS, PROPERTY_SCREEN_PHYSICAL_WIDTH_MAX,
				PROPERTY_SCREEN_PHYSICAL_WIDTH_MIN,
				PROPERTY_SCREEN_PHYSICAL_HEIGHT_MAX,
				PROPERTY_SCREEN_PHYSICAL_HEIGHT_MIN,
				PROPERTY_SCREEN_RESOLUTION_WIDTH_MAX,
				PROPERTY_SCREEN_RESOLUTION_WIDTH_MIN,
				PROPERTY_SCREEN_RESOLUTION_HEIGHT_MAX,
				PROPERTY_SCREEN_RESOLUTION_HEIGHT_MIN, PROPERTY_TABLET));

}