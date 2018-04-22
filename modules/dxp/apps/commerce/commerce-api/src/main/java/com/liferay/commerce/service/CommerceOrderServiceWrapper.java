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

package com.liferay.commerce.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CommerceOrderService}.
 *
 * @author Alessio Antonio Rendina
 * @see CommerceOrderService
 * @generated
 */
@ProviderType
public class CommerceOrderServiceWrapper implements CommerceOrderService,
	ServiceWrapper<CommerceOrderService> {
	public CommerceOrderServiceWrapper(
		CommerceOrderService commerceOrderService) {
		_commerceOrderService = commerceOrderService;
	}

	@Override
	public com.liferay.commerce.model.CommerceOrder addOrganizationCommerceOrder(
		long groupId, long siteGroupId, long orderOrganizationId,
		long shippingAddressId, java.lang.String purchaseOrderNumber)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _commerceOrderService.addOrganizationCommerceOrder(groupId,
			siteGroupId, orderOrganizationId, shippingAddressId,
			purchaseOrderNumber);
	}

	@Override
	public com.liferay.commerce.model.CommerceOrder addUserCommerceOrder(
		long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _commerceOrderService.addUserCommerceOrder(groupId);
	}

	@Override
	public com.liferay.commerce.model.CommerceOrder addUserCommerceOrder(
		long groupId, long orderUserId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _commerceOrderService.addUserCommerceOrder(groupId, orderUserId);
	}

	@Override
	public com.liferay.commerce.model.CommerceOrder approveCommerceOrder(
		long commerceOrderId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _commerceOrderService.approveCommerceOrder(commerceOrderId);
	}

	@Override
	public com.liferay.commerce.model.CommerceOrder cancelCommerceOrderPayment(
		long commerceOrderId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _commerceOrderService.cancelCommerceOrderPayment(commerceOrderId,
			serviceContext);
	}

	@Override
	public com.liferay.commerce.model.CommerceOrder checkoutCommerceOrder(
		long commerceOrderId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _commerceOrderService.checkoutCommerceOrder(commerceOrderId,
			serviceContext);
	}

	@Override
	public com.liferay.commerce.model.CommerceOrder completeCommerceOrderPayment(
		long commerceOrderId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _commerceOrderService.completeCommerceOrderPayment(commerceOrderId,
			serviceContext);
	}

	@Override
	public void deleteCommerceOrder(long commerceOrderId)
		throws com.liferay.portal.kernel.exception.PortalException {
		_commerceOrderService.deleteCommerceOrder(commerceOrderId);
	}

	@Override
	public com.liferay.commerce.model.CommerceOrder executeWorkflowTransition(
		long commerceOrderId, long workflowTaskId,
		java.lang.String transitionName, java.lang.String comment)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _commerceOrderService.executeWorkflowTransition(commerceOrderId,
			workflowTaskId, transitionName, comment);
	}

	@Override
	public com.liferay.commerce.model.CommerceOrder fetchCommerceOrder(
		long commerceOrderId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _commerceOrderService.fetchCommerceOrder(commerceOrderId);
	}

	@Override
	public com.liferay.commerce.model.CommerceOrder fetchCommerceOrder(
		long groupId, int orderStatus)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _commerceOrderService.fetchCommerceOrder(groupId, orderStatus);
	}

	@Override
	public com.liferay.commerce.model.CommerceOrder fetchCommerceOrder(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _commerceOrderService.fetchCommerceOrder(uuid, groupId);
	}

	@Override
	public int[] getAvailableOrderStatuses(long commerceOrderId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _commerceOrderService.getAvailableOrderStatuses(commerceOrderId);
	}

	@Override
	public com.liferay.commerce.model.CommerceOrder getCommerceOrder(
		long commerceOrderId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _commerceOrderService.getCommerceOrder(commerceOrderId);
	}

	@Override
	public com.liferay.commerce.model.CommerceOrder getCommerceOrderByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _commerceOrderService.getCommerceOrderByUuidAndGroupId(uuid,
			groupId);
	}

	@Override
	public java.util.List<com.liferay.commerce.model.CommerceOrder> getCommerceOrders(
		long groupId, long orderUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.commerce.model.CommerceOrder> orderByComparator)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _commerceOrderService.getCommerceOrders(groupId, orderUserId,
			start, end, orderByComparator);
	}

	@Override
	public int getCommerceOrdersCount(long groupId, long orderUserId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _commerceOrderService.getCommerceOrdersCount(groupId, orderUserId);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _commerceOrderService.getOSGiServiceIdentifier();
	}

	@Override
	public void mergeGuestCommerceOrder(long guestCommerceOrderId,
		long userCommerceOrderId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		_commerceOrderService.mergeGuestCommerceOrder(guestCommerceOrderId,
			userCommerceOrderId, serviceContext);
	}

	@Override
	public com.liferay.commerce.model.CommerceOrder reorderCommerceOrder(
		long commerceOrderId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _commerceOrderService.reorderCommerceOrder(commerceOrderId);
	}

	@Override
	public java.lang.String startCommerceOrderPayment(long commerceOrderId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _commerceOrderService.startCommerceOrderPayment(commerceOrderId,
			serviceContext);
	}

	@Override
	public com.liferay.commerce.model.CommerceOrder submitCommerceOrder(
		long commerceOrderId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _commerceOrderService.submitCommerceOrder(commerceOrderId);
	}

	@Override
	public com.liferay.commerce.model.CommerceOrder updateBillingAddress(
		long commerceOrderId, java.lang.String name,
		java.lang.String description, java.lang.String street1,
		java.lang.String street2, java.lang.String street3,
		java.lang.String city, java.lang.String zip, long commerceRegionId,
		long commerceCountryId, java.lang.String phoneNumber,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _commerceOrderService.updateBillingAddress(commerceOrderId,
			name, description, street1, street2, street3, city, zip,
			commerceRegionId, commerceCountryId, phoneNumber, serviceContext);
	}

	@Override
	public com.liferay.commerce.model.CommerceOrder updateCommerceOrder(
		long commerceOrderId, long billingAddressId, long shippingAddressId,
		long commercePaymentMethodId, long commerceShippingMethodId,
		java.lang.String shippingOptionName,
		java.lang.String purchaseOrderNumber, java.math.BigDecimal subtotal,
		java.math.BigDecimal shippingPrice, java.math.BigDecimal total,
		java.lang.String advanceStatus)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _commerceOrderService.updateCommerceOrder(commerceOrderId,
			billingAddressId, shippingAddressId, commercePaymentMethodId,
			commerceShippingMethodId, shippingOptionName, purchaseOrderNumber,
			subtotal, shippingPrice, total, advanceStatus);
	}

	@Override
	public com.liferay.commerce.model.CommerceOrder updateOrderStatus(
		long commerceOrderId, int orderStatus)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _commerceOrderService.updateOrderStatus(commerceOrderId,
			orderStatus);
	}

	@Override
	public com.liferay.commerce.model.CommerceOrder updatePaymentStatus(
		long commerceOrderId, int paymentStatus,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _commerceOrderService.updatePaymentStatus(commerceOrderId,
			paymentStatus, serviceContext);
	}

	@Override
	public com.liferay.commerce.model.CommerceOrder updatePurchaseOrderNumber(
		long commerceOrderId, java.lang.String purchaseOrderNumber)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _commerceOrderService.updatePurchaseOrderNumber(commerceOrderId,
			purchaseOrderNumber);
	}

	@Override
	public com.liferay.commerce.model.CommerceOrder updateShippingAddress(
		long commerceOrderId, java.lang.String name,
		java.lang.String description, java.lang.String street1,
		java.lang.String street2, java.lang.String street3,
		java.lang.String city, java.lang.String zip, long commerceRegionId,
		long commerceCountryId, java.lang.String phoneNumber,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _commerceOrderService.updateShippingAddress(commerceOrderId,
			name, description, street1, street2, street3, city, zip,
			commerceRegionId, commerceCountryId, phoneNumber, serviceContext);
	}

	@Override
	public com.liferay.commerce.model.CommerceOrder updateUser(
		long commerceOrderId, long userId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _commerceOrderService.updateUser(commerceOrderId, userId);
	}

	@Override
	public CommerceOrderService getWrappedService() {
		return _commerceOrderService;
	}

	@Override
	public void setWrappedService(CommerceOrderService commerceOrderService) {
		_commerceOrderService = commerceOrderService;
	}

	private CommerceOrderService _commerceOrderService;
}