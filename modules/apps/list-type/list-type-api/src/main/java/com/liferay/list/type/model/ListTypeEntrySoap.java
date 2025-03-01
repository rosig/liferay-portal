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

package com.liferay.list.type.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.list.type.service.http.ListTypeEntryServiceSoap}.
 *
 * @author Gabriel Albuquerque
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class ListTypeEntrySoap implements Serializable {

	public static ListTypeEntrySoap toSoapModel(ListTypeEntry model) {
		ListTypeEntrySoap soapModel = new ListTypeEntrySoap();

		soapModel.setMvccVersion(model.getMvccVersion());
		soapModel.setUuid(model.getUuid());
		soapModel.setListTypeEntryId(model.getListTypeEntryId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setListTypeDefinitionId(model.getListTypeDefinitionId());
		soapModel.setKey(model.getKey());
		soapModel.setName(model.getName());
		soapModel.setType(model.getType());

		return soapModel;
	}

	public static ListTypeEntrySoap[] toSoapModels(ListTypeEntry[] models) {
		ListTypeEntrySoap[] soapModels = new ListTypeEntrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ListTypeEntrySoap[][] toSoapModels(ListTypeEntry[][] models) {
		ListTypeEntrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ListTypeEntrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new ListTypeEntrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ListTypeEntrySoap[] toSoapModels(List<ListTypeEntry> models) {
		List<ListTypeEntrySoap> soapModels = new ArrayList<ListTypeEntrySoap>(
			models.size());

		for (ListTypeEntry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ListTypeEntrySoap[soapModels.size()]);
	}

	public ListTypeEntrySoap() {
	}

	public long getPrimaryKey() {
		return _listTypeEntryId;
	}

	public void setPrimaryKey(long pk) {
		setListTypeEntryId(pk);
	}

	public long getMvccVersion() {
		return _mvccVersion;
	}

	public void setMvccVersion(long mvccVersion) {
		_mvccVersion = mvccVersion;
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getListTypeEntryId() {
		return _listTypeEntryId;
	}

	public void setListTypeEntryId(long listTypeEntryId) {
		_listTypeEntryId = listTypeEntryId;
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

	public long getListTypeDefinitionId() {
		return _listTypeDefinitionId;
	}

	public void setListTypeDefinitionId(long listTypeDefinitionId) {
		_listTypeDefinitionId = listTypeDefinitionId;
	}

	public String getKey() {
		return _key;
	}

	public void setKey(String key) {
		_key = key;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getType() {
		return _type;
	}

	public void setType(String type) {
		_type = type;
	}

	private long _mvccVersion;
	private String _uuid;
	private long _listTypeEntryId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _listTypeDefinitionId;
	private String _key;
	private String _name;
	private String _type;

}