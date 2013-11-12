package com.cleeng.apiv3;

import java.net.MalformedURLException;
import java.net.URL;

import com.googlecode.jsonrpc4j.JsonRpcHttpClient;
import com.googlecode.jsonrpc4j.JsonRpcParam;
import com.googlecode.jsonrpc4j.ProxyUtil;

import com.cleeng.apiv3.domain.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CleengApi {

	private CleengRpc rpc;

	private interface CleengRpc {

		// Customers
		Customer getCustomer(
				@JsonRpcParam(value="customerToken") String token);

		AccessStatus getAccessStatus(
				@JsonRpcParam(value="token") String token,
				@JsonRpcParam(value="offerId") String offerId);

		AccessStatus getAccessStatus(
				@JsonRpcParam(value="token") String token,
				@JsonRpcParam(value="offerId") String offerId,
				@JsonRpcParam(value="ipAddress") String ipAddress);

		OfferIdExpiresAt updateCustomerRental(
				@JsonRpcParam(value="publisherToken") String publisherToken,
				@JsonRpcParam(value="customerEmail") String customerEmail,
				@JsonRpcParam(value="offerId") String offerId,
				@JsonRpcParam(value="rentalData") ExpiresAt rentalData);

		Items<CustomerSubscription> listCustomerSubscriptions(
				@JsonRpcParam(value="publisherToken") String publisherToken,
				@JsonRpcParam(value="customerEmail") String customerEmail,
				@JsonRpcParam(value="offset") int offset,
				@JsonRpcParam(value="limit") int limit);

		Success trackOfferImpression(
				@JsonRpcParam(value="offerId") String offerId);
		Success trackOfferImpression(
				@JsonRpcParam(value="offerId") String offerId,
				@JsonRpcParam(value= "customerToken") String customerToken);
		Success trackOfferImpression(
				@JsonRpcParam(value="offerId") String offerId,
				@JsonRpcParam(value= "customerToken") String customerToken,
				@JsonRpcParam(value= "ipAddress") String ipAddress);

		Email getCustomerEmail(
				@JsonRpcParam(value="publisherToken") String publisherToken,
				@JsonRpcParam(value="customerToken") String customerToken);

		Url prepareRemoteAuth(
				@JsonRpcParam(value="publisherToken") String publisherToken,
				@JsonRpcParam(value="customerData") CustomerData customerData,
				@JsonRpcParam(value="flowDescription") FlowDescription flowDescription);

		Token generateCustomerToken(
				@JsonRpcParam(value="publisherToken") String publisherToken,
				@JsonRpcParam(value="customerEmail") String customerEmail);

		Success updateCustomerEmail(
				@JsonRpcParam(value="publisherToken") String publisherToken,
				@JsonRpcParam(value="customerEmail") String customerEmail,
				@JsonRpcParam(value="newEmail") String newEmail);


		// Single Offers
		SingleOffer getSingleOffer(
				@JsonRpcParam(value="offerId") String offerId);

		Items<SingleOffer> listSingleOffers(
				@JsonRpcParam(value="publisherToken") String publisherToken,
				@JsonRpcParam(value="offset") int offset,
				@JsonRpcParam(value="limit") int limit);
		Items<SingleOffer> listSingleOffers(
				@JsonRpcParam(value="publisherToken") String publisherToken,
				@JsonRpcParam(value="criteria") Criteria criteria,
				@JsonRpcParam(value="offset") int offset,
				@JsonRpcParam(value="limit") int limit);

		SingleOffer createSingleOffer(
				@JsonRpcParam(value="publisherToken") String publisherToken,
				@JsonRpcParam(value="offerData") SingleOfferData offerData);

		SingleOffer updateSingleOffer(
				@JsonRpcParam(value="publisherToken") String publisherToken,
				@JsonRpcParam(value="offerId") String offerId,
				@JsonRpcParam(value="offerData") SingleOfferData offerData);

		SingleOffer deactivateSingleOffer(
				@JsonRpcParam(value="publisherToken") String publisherToken,
				@JsonRpcParam(value="offerId") String offerId);

		MultiCurrencyOfferId createMultiCurrencySingleOffer(
				@JsonRpcParam(value="publisherToken") String publisherToken,
				@JsonRpcParam(value="offerData") MultiCurrencySingleOfferData offerData,
				@JsonRpcParam(value="localizedData") LocalizedData[] localizedData);

		void updateMultiCurrencySubscriptionOffer(
				@JsonRpcParam(value="publisherToken") String publisherToken,
				@JsonRpcParam(value="multiCurrencyOfferId") String multiCurrencyOfferId,
				@JsonRpcParam(value="offerData") MultiCurrencySingleOfferData offerData,
				@JsonRpcParam(value="localizedData") LocalizedData[] localizedData);


		// Rental Offers
		RentalOffer getRentalOffer(
				@JsonRpcParam(value="offerId") String offerId);

		Items<RentalOffer> listRentalOffers(
				@JsonRpcParam(value="publisherToken") String publisherToken,
				@JsonRpcParam(value="offset") int offset,
				@JsonRpcParam(value="limit") int limit);
		Items<RentalOffer> listRentalOffers(
				@JsonRpcParam(value="publisherToken") String publisherToken,
				@JsonRpcParam(value="criteria") Criteria criteria,
				@JsonRpcParam(value="offset") int offset,
				@JsonRpcParam(value="limit") int limit);

		RentalOffer createRentalOffer(
				@JsonRpcParam(value="publisherToken") String publisherToken,
				@JsonRpcParam(value="offerData") RentalOfferData offerData);

		RentalOffer updateRentalOffer(
				@JsonRpcParam(value="publisherToken") String publisherToken,
				@JsonRpcParam(value="offerId") String offerId,
				@JsonRpcParam(value="offerData") RentalOfferData offerData);

		RentalOffer deactivateRentalOffer(
				@JsonRpcParam(value="publisherToken") String publisherToken,
				@JsonRpcParam(value="offerId") String offerId);

		MultiCurrencyOfferId createMultiCurrencyRentalOffer(
				@JsonRpcParam(value="publisherToken") String publisherToken,
				@JsonRpcParam(value="offerData") MultiCurrencyRentalOfferData offerData,
				@JsonRpcParam(value="localizedData") LocalizedData[] localizedData);

		void updateMultiCurrencySubscriptionOffer(
				@JsonRpcParam(value="publisherToken") String publisherToken,
				@JsonRpcParam(value="multiCurrencyOfferId") String multiCurrencyOfferId,
				@JsonRpcParam(value="offerData") MultiCurrencyRentalOfferData offerData,
				@JsonRpcParam(value="localizedData") LocalizedData[] localizedData);


		// Live Event Offers
		LiveEventOffer getLiveEventOffer(
				@JsonRpcParam(value="offerId") String offerId);

		Items<LiveEventOffer> listLiveEventOffers(
				@JsonRpcParam(value="publisherToken") String publisherToken,
				@JsonRpcParam(value="offset") int offset,
				@JsonRpcParam(value="limit") int limit);
		Items<LiveEventOffer> listLiveEventOffers(
				@JsonRpcParam(value="publisherToken") String publisherToken,
				@JsonRpcParam(value="criteria") Criteria criteria,
				@JsonRpcParam(value="offset") int offset,
				@JsonRpcParam(value="limit") int limit);

		LiveEventOffer createLiveEventOffer(
				@JsonRpcParam(value="publisherToken") String publisherToken,
				@JsonRpcParam(value="offerData") LiveEventOfferData offerData);

		LiveEventOffer updateLiveEventOffer(
				@JsonRpcParam(value="publisherToken") String publisherToken,
				@JsonRpcParam(value="offerId") String offerId,
				@JsonRpcParam(value="offerData") LiveEventOfferData offerData);

		LiveEventOffer deactivateLiveEventOffer(
				@JsonRpcParam(value="publisherToken") String publisherToken,
				@JsonRpcParam(value="offerId") String offerId);


		// Subscription Offers
		SubscriptionOffer getSubscriptionOffer(
				@JsonRpcParam(value="offerId") String offerId);

		Items<SubscriptionOffer> listSubscriptionOffers(
				@JsonRpcParam(value="publisherToken") String publisherToken,
				@JsonRpcParam(value="offset") int offset,
				@JsonRpcParam(value="limit") int limit);
		Items<SubscriptionOffer> listSubscriptionOffers(
				@JsonRpcParam(value="publisherToken") String publisherToken,
				@JsonRpcParam(value="criteria") Criteria criteria,
				@JsonRpcParam(value="offset") int offset,
				@JsonRpcParam(value="limit") int limit);

		SubscriptionOffer createSubscriptionOffer(
				@JsonRpcParam(value="publisherToken") String publisherToken,
				@JsonRpcParam(value="offerData") SubscriptionOfferData offerData);

		SubscriptionOffer updateSubscriptionOffer(
				@JsonRpcParam(value="publisherToken") String publisherToken,
				@JsonRpcParam(value="offerId") String offerId,
				@JsonRpcParam(value="offerData") SubscriptionOfferData offerData);

		SubscriptionOffer deactivateSubscriptionOffer(
				@JsonRpcParam(value="publisherToken") String publisherToken,
				@JsonRpcParam(value="offerId") String offerId);

		MultiCurrencyOfferId createMultiCurrencySubscriptionOffer(
				@JsonRpcParam(value="publisherToken") String publisherToken,
				@JsonRpcParam(value="offerData") MultiCurrencySubscriptionOfferData offerData,
				@JsonRpcParam(value="localizedData") LocalizedData[] localizedData);

		void updateMultiCurrencySubscriptionOffer(
				@JsonRpcParam(value="publisherToken") String publisherToken,
				@JsonRpcParam(value="multiCurrencyOfferId") String multiCurrencyOfferId,
				@JsonRpcParam(value="offerData") MultiCurrencySubscriptionOfferData offerData,
				@JsonRpcParam(value="localizedData") LocalizedData[] localizedData);


		// Pass Offers
		PassOffer getPassOffer(
				@JsonRpcParam(value="offerId") String offerId);

		Items<PassOffer> listPassOffers(
				@JsonRpcParam(value="publisherToken") String publisherToken,
				@JsonRpcParam(value="offset") int offset,
				@JsonRpcParam(value="limit") int limit);
		Items<PassOffer> listPassOffers(
				@JsonRpcParam(value="publisherToken") String publisherToken,
				@JsonRpcParam(value="criteria") Criteria criteria,
				@JsonRpcParam(value="offset") int offset,
				@JsonRpcParam(value="limit") int limit);

		PassOffer createPassOffer(
				@JsonRpcParam(value="publisherToken") String publisherToken,
				@JsonRpcParam(value="offerData") PassOfferData offerData);

		PassOffer updatePassOffer(
				@JsonRpcParam(value="publisherToken") String publisherToken,
				@JsonRpcParam(value="offerId") String offerId,
				@JsonRpcParam(value="offerData") PassOfferData offerData);

		PassOffer deactivatePassOffer(
				@JsonRpcParam(value="publisherToken") String publisherToken,
				@JsonRpcParam(value="offerId") String offerId);

		MultiCurrencyOfferId createMultiCurrencyPassOffer(
				@JsonRpcParam(value="publisherToken") String publisherToken,
				@JsonRpcParam(value="offerData") MultiCurrencyPassOfferData offerData,
				@JsonRpcParam(value="localizedData") LocalizedData[] localizedData);

		void updateMultiCurrencySubscriptionOffer(
				@JsonRpcParam(value="publisherToken") String publisherToken,
				@JsonRpcParam(value="multiCurrencyOfferId") String multiCurrencyOfferId,
				@JsonRpcParam(value="offerData") MultiCurrencyPassOfferData offerData,
				@JsonRpcParam(value="localizedData") LocalizedData[] localizedData);


		// Bundle Offers
		BundleOffer getBundleOffer(
				@JsonRpcParam(value="offerId") String offerId);

		Items<BundleOffer> listBundleOffers(
				@JsonRpcParam(value="publisherToken") String publisherToken,
				@JsonRpcParam(value="offset") int offset,
				@JsonRpcParam(value="limit") int limit);
		Items<BundleOffer> listBundleOffers(
				@JsonRpcParam(value="publisherToken") String publisherToken,
				@JsonRpcParam(value="criteria") Criteria criteria,
				@JsonRpcParam(value="offset") int offset,
				@JsonRpcParam(value="limit") int limit);

		BundleOffer createBundleOffer(
				@JsonRpcParam(value="publisherToken") String publisherToken,
				@JsonRpcParam(value="offerData") BundleOfferData offerData);

		BundleOffer updateBundleOffer(
				@JsonRpcParam(value="publisherToken") String publisherToken,
				@JsonRpcParam(value="offerId") String offerId,
				@JsonRpcParam(value="offerData") BundleOfferData offerData);

		BundleOffer deactivateBundleOffer(
				@JsonRpcParam(value="publisherToken") String publisherToken,
				@JsonRpcParam(value="offerId") String offerId);

		MultiCurrencyOfferId createMultiCurrencyBundleOffer(
				@JsonRpcParam(value="publisherToken") String publisherToken,
				@JsonRpcParam(value="offerData") MultiCurrencyBundleOfferData offerData,
				@JsonRpcParam(value="localizedData") LocalizedData[] localizedData);

		void updateMultiCurrencySubscriptionOffer(
				@JsonRpcParam(value="publisherToken") String publisherToken,
				@JsonRpcParam(value="multiCurrencyOfferId") String multiCurrencyOfferId,
				@JsonRpcParam(value="offerData") MultiCurrencyBundleOfferData offerData,
				@JsonRpcParam(value="localizedData") LocalizedData[] localizedData);


		// Associate
		Associate createAssociate(
				@JsonRpcParam(value="distributorToken") String distributorToken,
				@JsonRpcParam(value="associateData") AssociateData associateData);

		Associate updateAssociate(
				@JsonRpcParam(value="distributorToken") String distributorToken,
				@JsonRpcParam(value="associateEmail") String associateEmail,
				@JsonRpcParam(value="associateData") AssociateData associateData);

                // Coupons
                Success applyCoupon(
                        @JsonRpcParam(value="publisherToken") String publisherToken,
                        @JsonRpcParam(value="customerEmail") String customerEmail,
                        @JsonRpcParam(value="couponCode") String couponCode,
                        @JsonRpcParam(value="offerId") String offerId);

                // Coupons
                Success applyCoupon(
                        @JsonRpcParam(value="publisherToken") String publisherToken,
                        @JsonRpcParam(value="customerEmail") String customerEmail,
                        @JsonRpcParam(value="couponCode") String couponCode,
                        @JsonRpcParam(value="offerId") String offerId,
                        @JsonRpcParam(value="couponOptions") CouponOptions couponOptions);
                                
                // Reporting
                TransactionItems listTransactions(
                        @JsonRpcParam(value="publisherToken") String publisherToken,
				@JsonRpcParam(value="criteria") TransactionCriteria criteria,
				@JsonRpcParam(value="offset") int offset,
				@JsonRpcParam(value="limit") int limit);
		
	}

	public CleengApi() {
		makeRpc("https://api.cleeng.com/3.0/json-rpc");
	}

	private void makeRpc(String apiUrl) {
            try {
                JsonRpcHttpClient client = new JsonRpcHttpClient(new URL(apiUrl));
                rpc = ProxyUtil.createProxy(getClass().getClassLoader(), CleengRpc.class, client);
            } catch (MalformedURLException ex) {
                Logger.getLogger(CleengApi.class.getName()).log(Level.SEVERE, null, ex);
            }
	}

	public void enableSandbox() {
		makeRpc("https://sandbox.cleeng.com/api/3.0/json-rpc");
	}


	// Customers
	public Customer getCustomer(String customerToken) {
		return rpc.getCustomer(customerToken);
	}

	public AccessStatus getAccessStatus(String customerToken, String offerId) {
		return rpc.getAccessStatus(customerToken, offerId);
	}

	public AccessStatus getAccessStatus(String customerToken, String offerId, String ipAddress) {
		return rpc.getAccessStatus(customerToken, offerId, ipAddress);
	}

	public boolean isAccessGranted(String customerToken, String offerId) {
		return getAccessStatus(customerToken, offerId).accessGranted;
	}

	public boolean isAccessGranted(String customerToken, String offerId, String ipAddress) {
		return getAccessStatus(customerToken, offerId).accessGranted;
	}

	public OfferIdExpiresAt updateCustomerRental(String publisherToken, String customerEmail, String offerId, ExpiresAt rentalData) {
		return rpc.updateCustomerRental(publisherToken, customerEmail, offerId, rentalData);
	}

	public Items<CustomerSubscription> listCustomerSubscriptions(String publisherToken, String customerEmail, int offset, int limit) {
		return rpc.listCustomerSubscriptions(publisherToken, customerEmail, offset, limit);
	}

	private Success _trackOfferImpression(String offerId) {
		return rpc.trackOfferImpression(offerId);
	}

	private Success _trackOfferImpression(String offerId, String customerToken) {
		return rpc.trackOfferImpression(offerId, customerToken);
	}

	private Success _trackOfferImpression(String offerId, String customerToken, String ipAddress) {
		return rpc.trackOfferImpression(offerId, customerToken, ipAddress);
	}

	public Boolean trackOfferImpression(String offerId) {
		return _trackOfferImpression(offerId).success;
	}

	public Boolean trackOfferImpression(String offerId, String customerToken) {
		return _trackOfferImpression(offerId, customerToken).success;
	}

	public Boolean trackOfferImpression(String offerId, String customerToken, String ipAddress) {
		return _trackOfferImpression(offerId, customerToken, ipAddress).success;
	}

	public String getCustomerEmail(String publisherToken, String customerToken) {
		return rpc.getCustomerEmail(publisherToken, customerToken).email;
	}

	public String prepareRemoteAuth(String publisherToken, CustomerData customerData, FlowDescription flowDescription) {
		return rpc.prepareRemoteAuth(publisherToken, customerData, flowDescription).url;
	}

	public String generateCustomerToken(String publisherToken, String customerEmail) {
		return rpc.generateCustomerToken(publisherToken, customerEmail).token;
	}

	public Boolean updateCustomerEmail(String publisherToken, String customerEmail, String newEmail) {
		return rpc.updateCustomerEmail(publisherToken, customerEmail, newEmail).success;
	}


	// Single Offers
	public SingleOffer getSingleOffer(String offerId) {
		return rpc.getSingleOffer(offerId);
	}

	public Items<SingleOffer> listSingleOffers(String publisherToken, int offset, int limit) {
		return rpc.listSingleOffers(publisherToken, offset, limit);
	}

	public Items<SingleOffer> listSingleOffers(String publisherToken, Criteria criteria, int offset, int limit) {
		return rpc.listSingleOffers(publisherToken, criteria, offset, limit);
	}

	public SingleOffer createSingleOffer(String publisherToken, SingleOfferData offerData) {
		return rpc.createSingleOffer(publisherToken, offerData);
	}

	public SingleOffer updateSingleOffer(String publisherToken, String offerId, SingleOfferData offerData) {
		return rpc.updateSingleOffer(publisherToken, offerId, offerData);
	}

	public SingleOffer deactivateSingleOffer(String publisherToken, String offerId) {
		return rpc.deactivateSingleOffer(publisherToken, offerId);
	}

	public String createMultiCurrencySingleOffer(String publisherToken, MultiCurrencySingleOfferData offerData, LocalizedData[] localizedData) {
		return rpc.createMultiCurrencySingleOffer(publisherToken, offerData, localizedData).multiCurrencyOfferId;
	}

	public void updateMultiCurrencySubscriptionOffer(String publisherToken, String multiCurrencyOfferId, MultiCurrencySingleOfferData offerData, LocalizedData[] localizedData) {	
		rpc.updateMultiCurrencySubscriptionOffer(publisherToken, multiCurrencyOfferId, offerData, localizedData);
	}


	// Rental Offers
	public RentalOffer getRentalOffer(String offerId) {
		return rpc.getRentalOffer(offerId);
	}

	public Items<RentalOffer> listRentalOffers(String publisherToken, int offset, int limit) {
		return rpc.listRentalOffers(publisherToken, offset, limit);
	}

	public Items<RentalOffer> listRentalOffers(String publisherToken, Criteria criteria, int offset, int limit) {
		return rpc.listRentalOffers(publisherToken, criteria, offset, limit);
	}

	public RentalOffer createRentalOffer(String publisherToken, RentalOfferData offerData) {
		return rpc.createRentalOffer(publisherToken, offerData);
	}

	public RentalOffer updateRentalOffer(String publisherToken, String offerId, RentalOfferData offerData) {
		return rpc.updateRentalOffer(publisherToken, offerId, offerData);
	}

	public RentalOffer deactivateRentalOffer(String publisherToken, String offerId) {
		return rpc.deactivateRentalOffer(publisherToken, offerId);
	}

	public String createMultiCurrencyRentalOffer(String publisherToken, MultiCurrencyRentalOfferData offerData, LocalizedData[] localizedData) {
		return rpc.createMultiCurrencyRentalOffer(publisherToken, offerData, localizedData).multiCurrencyOfferId;
	}

	public void updateMultiCurrencySubscriptionOffer(String publisherToken, String multiCurrencyOfferId, MultiCurrencyRentalOfferData offerData, LocalizedData[] localizedData) {	
		rpc.updateMultiCurrencySubscriptionOffer(publisherToken, multiCurrencyOfferId, offerData, localizedData);
	}


	// LiveEvent Offers
	public LiveEventOffer getLiveEventOffer(String offerId) {
		return rpc.getLiveEventOffer(offerId);
	}

	public Items<LiveEventOffer> listLiveEventOffers(String publisherToken, int offset, int limit) {
		return rpc.listLiveEventOffers(publisherToken, offset, limit);
	}

	public Items<LiveEventOffer> listLiveEventOffers(String publisherToken, Criteria criteria, int offset, int limit) {
		return rpc.listLiveEventOffers(publisherToken, criteria, offset, limit);
	}

	public LiveEventOffer createLiveEventOffer(String publisherToken, LiveEventOfferData offerData) {
		return rpc.createLiveEventOffer(publisherToken, offerData);
	}

	public LiveEventOffer updateLiveEventOffer(String publisherToken, String offerId, LiveEventOfferData offerData) {
		return rpc.updateLiveEventOffer(publisherToken, offerId, offerData);
	}

	public LiveEventOffer deactivateLiveEventOffer(String publisherToken, String offerId) {
		return rpc.deactivateLiveEventOffer(publisherToken, offerId);
	}


	// Subscriptions Offers
	public SubscriptionOffer getSubscriptionOffer(String offerId) {
		return rpc.getSubscriptionOffer(offerId);
	}

	public Items<SubscriptionOffer> listSubscriptionOffers(String publisherToken, int offset, int limit) {
		return rpc.listSubscriptionOffers(publisherToken, offset, limit);
	}

	public Items<SubscriptionOffer> listSubscriptionOffers(String publisherToken, Criteria criteria, int offset, int limit) {
		return rpc.listSubscriptionOffers(publisherToken, criteria, offset, limit);
	}

	public SubscriptionOffer createSubscriptionOffer(String publisherToken, SubscriptionOfferData offerData) {
		return rpc.createSubscriptionOffer(publisherToken, offerData);
	}

	public SubscriptionOffer updateSubscriptionOffer(String publisherToken, String offerId, SubscriptionOfferData offerData) {
		return rpc.updateSubscriptionOffer(publisherToken, offerId, offerData);
	}

	public SubscriptionOffer deactivateSubscriptionOffer(String publisherToken, String offerId) {
		return rpc.deactivateSubscriptionOffer(publisherToken, offerId);
	}

	public String createMultiCurrencySubscriptionOffer(String publisherToken, MultiCurrencySubscriptionOfferData offerData, LocalizedData[] localizedData) {
		return rpc.createMultiCurrencySubscriptionOffer(publisherToken, offerData, localizedData).multiCurrencyOfferId;
	}

	public void updateMultiCurrencySubscriptionOffer(String publisherToken, String multiCurrencyOfferId, MultiCurrencySubscriptionOfferData offerData, LocalizedData[] localizedData) {	
		rpc.updateMultiCurrencySubscriptionOffer(publisherToken, multiCurrencyOfferId, offerData, localizedData);
	}


	// Pass Offers
	public PassOffer getPassOffer(String offerId) {
		return rpc.getPassOffer(offerId);
	}

	public Items<PassOffer> listPassOffers(String publisherToken, int offset, int limit) {
		return rpc.listPassOffers(publisherToken, offset, limit);
	}

	public Items<PassOffer> listPassOffers(String publisherToken, Criteria criteria, int offset, int limit) {
		return rpc.listPassOffers(publisherToken, criteria, offset, limit);
	}

	public PassOffer createPassOffer(String publisherToken, PassOfferData offerData) {
		return rpc.createPassOffer(publisherToken, offerData);
	}

	public PassOffer updatePassOffer(String publisherToken, String offerId, PassOfferData offerData) {
		return rpc.updatePassOffer(publisherToken, offerId, offerData);
	}

	public PassOffer deactivatePassOffer(String publisherToken, String offerId) {
		return rpc.deactivatePassOffer(publisherToken, offerId);
	}

	public String createMultiCurrencyPassOffer(String publisherToken, MultiCurrencyPassOfferData offerData, LocalizedData[] localizedData) {
		return rpc.createMultiCurrencyPassOffer(publisherToken, offerData, localizedData).multiCurrencyOfferId;
	}

	public void updateMultiCurrencySubscriptionOffer(String publisherToken, String multiCurrencyOfferId, MultiCurrencyPassOfferData offerData, LocalizedData[] localizedData) {	
		rpc.updateMultiCurrencySubscriptionOffer(publisherToken, multiCurrencyOfferId, offerData, localizedData);
	}


	// Bundle Offers
	public BundleOffer getBundleOffer(String offerId) {
		return rpc.getBundleOffer(offerId);
	}

	public Items<BundleOffer> listBundleOffers(String publisherToken, int offset, int limit) {
		return rpc.listBundleOffers(publisherToken, offset, limit);
	}

	public Items<BundleOffer> listBundleOffers(String publisherToken, Criteria criteria, int offset, int limit) {
		return rpc.listBundleOffers(publisherToken, criteria, offset, limit);
	}

	public BundleOffer createBundleOffer(String publisherToken, BundleOfferData offerData) {
		return rpc.createBundleOffer(publisherToken, offerData);
	}

	public BundleOffer updateBundleOffer(String publisherToken, String offerId, BundleOfferData offerData) {
		return rpc.updateBundleOffer(publisherToken, offerId, offerData);
	}

	public BundleOffer deactivateBundleOffer(String publisherToken, String offerId) {
		return rpc.deactivateBundleOffer(publisherToken, offerId);
	}

	public String createMultiCurrencyBundleOffer(String publisherToken, MultiCurrencyBundleOfferData offerData, LocalizedData[] localizedData) {
		return rpc.createMultiCurrencyBundleOffer(publisherToken, offerData, localizedData).multiCurrencyOfferId;
	}

	public void updateMultiCurrencySubscriptionOffer(String publisherToken, String multiCurrencyOfferId, MultiCurrencyBundleOfferData offerData, LocalizedData[] localizedData) {	
		rpc.updateMultiCurrencySubscriptionOffer(publisherToken, multiCurrencyOfferId, offerData, localizedData);
	}


	// Associate
	public Associate createAssociate(String distributorToken, AssociateData associateData) {
		return rpc.createAssociate(distributorToken, associateData);
	}
	public Associate updateAssociate(String distributorToken, String associateEmail, AssociateData associateData) {
		return rpc.updateAssociate(distributorToken, associateEmail, associateData);
	}

        // Coupons
        public Success applyCoupon(String publisherToken, String customerEmail, String couponCode, String offerId) {
            return rpc.applyCoupon(publisherToken, customerEmail, couponCode, offerId);
        }
        
        public Success applyCoupon(String publisherToken, String customerEmail, String couponCode, String offerId, CouponOptions couponOptions) {
            return rpc.applyCoupon(publisherToken, customerEmail, couponCode, offerId, couponOptions);
        }
        
        // Reporting
        public TransactionItems listTransactions(String publisherToken, TransactionCriteria criteria, int offset, int limit) {            
            return rpc.listTransactions(publisherToken, criteria, offset, limit);
        }                
}
