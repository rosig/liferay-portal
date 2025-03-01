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

package com.liferay.commerce.tax.engine.fixed.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.commerce.tax.engine.fixed.service.http.CommerceTaxFixedRateServiceSoap}.
 *
 * @author Alessio Antonio Rendina
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class CommerceTaxFixedRateSoap implements Serializable {

	public static CommerceTaxFixedRateSoap toSoapModel(
		CommerceTaxFixedRate model) {

		CommerceTaxFixedRateSoap soapModel = new CommerceTaxFixedRateSoap();

		soapModel.setMvccVersion(model.getMvccVersion());
		soapModel.setCommerceTaxFixedRateId(model.getCommerceTaxFixedRateId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCPTaxCategoryId(model.getCPTaxCategoryId());
		soapModel.setCommerceTaxMethodId(model.getCommerceTaxMethodId());
		soapModel.setRate(model.getRate());

		return soapModel;
	}

	public static CommerceTaxFixedRateSoap[] toSoapModels(
		CommerceTaxFixedRate[] models) {

		CommerceTaxFixedRateSoap[] soapModels =
			new CommerceTaxFixedRateSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CommerceTaxFixedRateSoap[][] toSoapModels(
		CommerceTaxFixedRate[][] models) {

		CommerceTaxFixedRateSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new CommerceTaxFixedRateSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CommerceTaxFixedRateSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CommerceTaxFixedRateSoap[] toSoapModels(
		List<CommerceTaxFixedRate> models) {

		List<CommerceTaxFixedRateSoap> soapModels =
			new ArrayList<CommerceTaxFixedRateSoap>(models.size());

		for (CommerceTaxFixedRate model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new CommerceTaxFixedRateSoap[soapModels.size()]);
	}

	public CommerceTaxFixedRateSoap() {
	}

	public long getPrimaryKey() {
		return _commerceTaxFixedRateId;
	}

	public void setPrimaryKey(long pk) {
		setCommerceTaxFixedRateId(pk);
	}

	public long getMvccVersion() {
		return _mvccVersion;
	}

	public void setMvccVersion(long mvccVersion) {
		_mvccVersion = mvccVersion;
	}

	public long getCommerceTaxFixedRateId() {
		return _commerceTaxFixedRateId;
	}

	public void setCommerceTaxFixedRateId(long commerceTaxFixedRateId) {
		_commerceTaxFixedRateId = commerceTaxFixedRateId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getCPTaxCategoryId() {
		return _CPTaxCategoryId;
	}

	public void setCPTaxCategoryId(long CPTaxCategoryId) {
		_CPTaxCategoryId = CPTaxCategoryId;
	}

	public long getCommerceTaxMethodId() {
		return _commerceTaxMethodId;
	}

	public void setCommerceTaxMethodId(long commerceTaxMethodId) {
		_commerceTaxMethodId = commerceTaxMethodId;
	}

	public double getRate() {
		return _rate;
	}

	public void setRate(double rate) {
		_rate = rate;
	}

	private long _mvccVersion;
	private long _commerceTaxFixedRateId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _CPTaxCategoryId;
	private long _commerceTaxMethodId;
	private double _rate;

}