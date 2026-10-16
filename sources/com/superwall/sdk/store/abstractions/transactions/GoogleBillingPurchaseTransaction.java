package com.superwall.sdk.store.abstractions.transactions;

import com.android.billingclient.api.Purchase;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import com.superwall.sdk.models.serialization.DateSerializer;
import com.superwall.sdk.store.abstractions.transactions.StoreTransactionState;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.Transient;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@Serializable
public final class GoogleBillingPurchaseTransaction implements StoreTransactionType {
    public static final Companion Companion = new Companion(null);
    private final String appAccountToken;
    private final String appBundleId;
    private final Date expirationDate;
    private final Boolean isUpgraded;
    private final String offerId;
    private final Date originalTransactionDate;
    private final String originalTransactionIdentifier;
    private StorePayment payment;
    private final String purchaseToken;
    private final Date revocationDate;
    private final String signature;
    private final StoreTransactionState state;
    private final String storeTransactionId;
    private final String subscriptionGroupId;
    private final Date transactionDate;
    private Purchase underlyingSK2Transaction;
    private final String webOrderLineItemID;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<GoogleBillingPurchaseTransaction> serializer() {
            return GoogleBillingPurchaseTransaction$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ GoogleBillingPurchaseTransaction(int i3, Date date, String str, StoreTransactionState storeTransactionState, String str2, Date date2, String str3, String str4, String str5, Boolean bool, Date date3, String str6, Date date4, String str7, String str8, StorePayment storePayment, String str9, SerializationConstructorMarker serializationConstructorMarker) {
        if (65535 != (i3 & 65535)) {
            PluginExceptionsKt.b(i3, 65535, GoogleBillingPurchaseTransaction$$serializer.INSTANCE.getDescriptor());
        }
        this.underlyingSK2Transaction = null;
        this.transactionDate = date;
        this.originalTransactionIdentifier = str;
        this.state = storeTransactionState;
        this.storeTransactionId = str2;
        this.originalTransactionDate = date2;
        this.webOrderLineItemID = str3;
        this.appBundleId = str4;
        this.subscriptionGroupId = str5;
        this.isUpgraded = bool;
        this.expirationDate = date3;
        this.offerId = str6;
        this.revocationDate = date4;
        this.appAccountToken = str7;
        this.purchaseToken = str8;
        this.payment = storePayment;
        this.signature = str9;
    }

    public static /* synthetic */ GoogleBillingPurchaseTransaction copy$default(GoogleBillingPurchaseTransaction googleBillingPurchaseTransaction, Purchase purchase, Date date, String str, StoreTransactionState storeTransactionState, String str2, Date date2, String str3, String str4, String str5, Boolean bool, Date date3, String str6, Date date4, String str7, String str8, StorePayment storePayment, String str9, int i3, Object obj) {
        String str10;
        StorePayment storePayment2;
        Purchase purchase2;
        GoogleBillingPurchaseTransaction googleBillingPurchaseTransaction2;
        String str11;
        Date date5;
        String str12;
        StoreTransactionState storeTransactionState2;
        String str13;
        Date date6;
        String str14;
        String str15;
        String str16;
        Boolean bool2;
        Date date7;
        String str17;
        Date date8;
        String str18;
        Purchase purchase3 = (i3 & 1) != 0 ? googleBillingPurchaseTransaction.underlyingSK2Transaction : purchase;
        Date date9 = (i3 & 2) != 0 ? googleBillingPurchaseTransaction.transactionDate : date;
        String str19 = (i3 & 4) != 0 ? googleBillingPurchaseTransaction.originalTransactionIdentifier : str;
        StoreTransactionState storeTransactionState3 = (i3 & 8) != 0 ? googleBillingPurchaseTransaction.state : storeTransactionState;
        String str20 = (i3 & 16) != 0 ? googleBillingPurchaseTransaction.storeTransactionId : str2;
        Date date10 = (i3 & 32) != 0 ? googleBillingPurchaseTransaction.originalTransactionDate : date2;
        String str21 = (i3 & 64) != 0 ? googleBillingPurchaseTransaction.webOrderLineItemID : str3;
        String str22 = (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? googleBillingPurchaseTransaction.appBundleId : str4;
        String str23 = (i3 & Function.MAX_NARGS) != 0 ? googleBillingPurchaseTransaction.subscriptionGroupId : str5;
        Boolean bool3 = (i3 & 512) != 0 ? googleBillingPurchaseTransaction.isUpgraded : bool;
        Date date11 = (i3 & 1024) != 0 ? googleBillingPurchaseTransaction.expirationDate : date3;
        String str24 = (i3 & 2048) != 0 ? googleBillingPurchaseTransaction.offerId : str6;
        Date date12 = (i3 & 4096) != 0 ? googleBillingPurchaseTransaction.revocationDate : date4;
        String str25 = (i3 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? googleBillingPurchaseTransaction.appAccountToken : str7;
        Purchase purchase4 = purchase3;
        String str26 = (i3 & 16384) != 0 ? googleBillingPurchaseTransaction.purchaseToken : str8;
        StorePayment storePayment3 = (i3 & 32768) != 0 ? googleBillingPurchaseTransaction.payment : storePayment;
        if ((i3 & NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) != 0) {
            storePayment2 = storePayment3;
            str10 = googleBillingPurchaseTransaction.signature;
            str11 = str26;
            date5 = date9;
            str12 = str19;
            storeTransactionState2 = storeTransactionState3;
            str13 = str20;
            date6 = date10;
            str14 = str21;
            str15 = str22;
            str16 = str23;
            bool2 = bool3;
            date7 = date11;
            str17 = str24;
            date8 = date12;
            str18 = str25;
            purchase2 = purchase4;
            googleBillingPurchaseTransaction2 = googleBillingPurchaseTransaction;
        } else {
            str10 = str9;
            storePayment2 = storePayment3;
            purchase2 = purchase4;
            googleBillingPurchaseTransaction2 = googleBillingPurchaseTransaction;
            str11 = str26;
            date5 = date9;
            str12 = str19;
            storeTransactionState2 = storeTransactionState3;
            str13 = str20;
            date6 = date10;
            str14 = str21;
            str15 = str22;
            str16 = str23;
            bool2 = bool3;
            date7 = date11;
            str17 = str24;
            date8 = date12;
            str18 = str25;
        }
        return googleBillingPurchaseTransaction2.copy(purchase2, date5, str12, storeTransactionState2, str13, date6, str14, str15, str16, bool2, date7, str17, date8, str18, str11, storePayment2, str10);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$superwall_release(GoogleBillingPurchaseTransaction googleBillingPurchaseTransaction, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        DateSerializer dateSerializer = DateSerializer.INSTANCE;
        compositeEncoder.i(serialDescriptor, 0, dateSerializer, googleBillingPurchaseTransaction.getTransactionDate());
        StringSerializer stringSerializer = StringSerializer.f142891a;
        compositeEncoder.i(serialDescriptor, 1, stringSerializer, googleBillingPurchaseTransaction.getOriginalTransactionIdentifier());
        compositeEncoder.C(serialDescriptor, 2, StoreTransactionStateSerializer.INSTANCE, googleBillingPurchaseTransaction.getState());
        compositeEncoder.i(serialDescriptor, 3, stringSerializer, googleBillingPurchaseTransaction.getStoreTransactionId());
        compositeEncoder.i(serialDescriptor, 4, dateSerializer, googleBillingPurchaseTransaction.getOriginalTransactionDate());
        compositeEncoder.i(serialDescriptor, 5, stringSerializer, googleBillingPurchaseTransaction.getWebOrderLineItemID());
        compositeEncoder.i(serialDescriptor, 6, stringSerializer, googleBillingPurchaseTransaction.getAppBundleId());
        compositeEncoder.i(serialDescriptor, 7, stringSerializer, googleBillingPurchaseTransaction.getSubscriptionGroupId());
        compositeEncoder.i(serialDescriptor, 8, BooleanSerializer.f142767a, googleBillingPurchaseTransaction.isUpgraded());
        compositeEncoder.i(serialDescriptor, 9, dateSerializer, googleBillingPurchaseTransaction.getExpirationDate());
        compositeEncoder.i(serialDescriptor, 10, stringSerializer, googleBillingPurchaseTransaction.getOfferId());
        compositeEncoder.i(serialDescriptor, 11, dateSerializer, googleBillingPurchaseTransaction.getRevocationDate());
        compositeEncoder.i(serialDescriptor, 12, stringSerializer, googleBillingPurchaseTransaction.getAppAccountToken());
        compositeEncoder.y(serialDescriptor, 13, googleBillingPurchaseTransaction.getPurchaseToken());
        compositeEncoder.C(serialDescriptor, 14, StorePayment$$serializer.INSTANCE, googleBillingPurchaseTransaction.getPayment());
        compositeEncoder.i(serialDescriptor, 15, stringSerializer, googleBillingPurchaseTransaction.getSignature());
    }

    public final Purchase component1() {
        return this.underlyingSK2Transaction;
    }

    public final Boolean component10() {
        return this.isUpgraded;
    }

    public final Date component11() {
        return this.expirationDate;
    }

    public final String component12() {
        return this.offerId;
    }

    public final Date component13() {
        return this.revocationDate;
    }

    public final String component14() {
        return this.appAccountToken;
    }

    public final String component15() {
        return this.purchaseToken;
    }

    public final StorePayment component16() {
        return this.payment;
    }

    public final String component17() {
        return this.signature;
    }

    public final Date component2() {
        return this.transactionDate;
    }

    public final String component3() {
        return this.originalTransactionIdentifier;
    }

    public final StoreTransactionState component4() {
        return this.state;
    }

    public final String component5() {
        return this.storeTransactionId;
    }

    public final Date component6() {
        return this.originalTransactionDate;
    }

    public final String component7() {
        return this.webOrderLineItemID;
    }

    public final String component8() {
        return this.appBundleId;
    }

    public final String component9() {
        return this.subscriptionGroupId;
    }

    public final GoogleBillingPurchaseTransaction copy(Purchase purchase, Date date, String str, StoreTransactionState state, String str2, Date date2, String str3, String str4, String str5, Boolean bool, Date date3, String str6, Date date4, String str7, String purchaseToken, StorePayment payment, String str8) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(purchaseToken, "purchaseToken");
        Intrinsics.checkNotNullParameter(payment, "payment");
        return new GoogleBillingPurchaseTransaction(purchase, date, str, state, str2, date2, str3, str4, str5, bool, date3, str6, date4, str7, purchaseToken, payment, str8);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GoogleBillingPurchaseTransaction)) {
            return false;
        }
        GoogleBillingPurchaseTransaction googleBillingPurchaseTransaction = (GoogleBillingPurchaseTransaction) obj;
        return Intrinsics.areEqual(this.underlyingSK2Transaction, googleBillingPurchaseTransaction.underlyingSK2Transaction) && Intrinsics.areEqual(this.transactionDate, googleBillingPurchaseTransaction.transactionDate) && Intrinsics.areEqual(this.originalTransactionIdentifier, googleBillingPurchaseTransaction.originalTransactionIdentifier) && Intrinsics.areEqual(this.state, googleBillingPurchaseTransaction.state) && Intrinsics.areEqual(this.storeTransactionId, googleBillingPurchaseTransaction.storeTransactionId) && Intrinsics.areEqual(this.originalTransactionDate, googleBillingPurchaseTransaction.originalTransactionDate) && Intrinsics.areEqual(this.webOrderLineItemID, googleBillingPurchaseTransaction.webOrderLineItemID) && Intrinsics.areEqual(this.appBundleId, googleBillingPurchaseTransaction.appBundleId) && Intrinsics.areEqual(this.subscriptionGroupId, googleBillingPurchaseTransaction.subscriptionGroupId) && Intrinsics.areEqual(this.isUpgraded, googleBillingPurchaseTransaction.isUpgraded) && Intrinsics.areEqual(this.expirationDate, googleBillingPurchaseTransaction.expirationDate) && Intrinsics.areEqual(this.offerId, googleBillingPurchaseTransaction.offerId) && Intrinsics.areEqual(this.revocationDate, googleBillingPurchaseTransaction.revocationDate) && Intrinsics.areEqual(this.appAccountToken, googleBillingPurchaseTransaction.appAccountToken) && Intrinsics.areEqual(this.purchaseToken, googleBillingPurchaseTransaction.purchaseToken) && Intrinsics.areEqual(this.payment, googleBillingPurchaseTransaction.payment) && Intrinsics.areEqual(this.signature, googleBillingPurchaseTransaction.signature);
    }

    @Override // com.superwall.sdk.store.abstractions.transactions.StoreTransactionType
    public String getAppAccountToken() {
        return this.appAccountToken;
    }

    @Override // com.superwall.sdk.store.abstractions.transactions.StoreTransactionType
    public String getAppBundleId() {
        return this.appBundleId;
    }

    @Override // com.superwall.sdk.store.abstractions.transactions.StoreTransactionType
    public Date getExpirationDate() {
        return this.expirationDate;
    }

    @Override // com.superwall.sdk.store.abstractions.transactions.StoreTransactionType
    public String getOfferId() {
        return this.offerId;
    }

    @Override // com.superwall.sdk.store.abstractions.transactions.StoreTransactionType
    public Date getOriginalTransactionDate() {
        return this.originalTransactionDate;
    }

    @Override // com.superwall.sdk.store.abstractions.transactions.StoreTransactionType
    public String getOriginalTransactionIdentifier() {
        return this.originalTransactionIdentifier;
    }

    @Override // com.superwall.sdk.store.abstractions.transactions.StoreTransactionType
    public StorePayment getPayment() {
        return this.payment;
    }

    @Override // com.superwall.sdk.store.abstractions.transactions.StoreTransactionType
    public String getPurchaseToken() {
        return this.purchaseToken;
    }

    @Override // com.superwall.sdk.store.abstractions.transactions.StoreTransactionType
    public Date getRevocationDate() {
        return this.revocationDate;
    }

    @Override // com.superwall.sdk.store.abstractions.transactions.StoreTransactionType
    public String getSignature() {
        return this.signature;
    }

    @Override // com.superwall.sdk.store.abstractions.transactions.StoreTransactionType
    public StoreTransactionState getState() {
        return this.state;
    }

    @Override // com.superwall.sdk.store.abstractions.transactions.StoreTransactionType
    public String getStoreTransactionId() {
        return this.storeTransactionId;
    }

    @Override // com.superwall.sdk.store.abstractions.transactions.StoreTransactionType
    public String getSubscriptionGroupId() {
        return this.subscriptionGroupId;
    }

    @Override // com.superwall.sdk.store.abstractions.transactions.StoreTransactionType
    public Date getTransactionDate() {
        return this.transactionDate;
    }

    public final Purchase getUnderlyingSK2Transaction() {
        return this.underlyingSK2Transaction;
    }

    @Override // com.superwall.sdk.store.abstractions.transactions.StoreTransactionType
    public String getWebOrderLineItemID() {
        return this.webOrderLineItemID;
    }

    public int hashCode() {
        Purchase purchase = this.underlyingSK2Transaction;
        int iHashCode = (purchase == null ? 0 : purchase.hashCode()) * 31;
        Date date = this.transactionDate;
        int iHashCode2 = (iHashCode + (date == null ? 0 : date.hashCode())) * 31;
        String str = this.originalTransactionIdentifier;
        int iHashCode3 = (((iHashCode2 + (str == null ? 0 : str.hashCode())) * 31) + this.state.hashCode()) * 31;
        String str2 = this.storeTransactionId;
        int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Date date2 = this.originalTransactionDate;
        int iHashCode5 = (iHashCode4 + (date2 == null ? 0 : date2.hashCode())) * 31;
        String str3 = this.webOrderLineItemID;
        int iHashCode6 = (iHashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.appBundleId;
        int iHashCode7 = (iHashCode6 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.subscriptionGroupId;
        int iHashCode8 = (iHashCode7 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Boolean bool = this.isUpgraded;
        int iHashCode9 = (iHashCode8 + (bool == null ? 0 : bool.hashCode())) * 31;
        Date date3 = this.expirationDate;
        int iHashCode10 = (iHashCode9 + (date3 == null ? 0 : date3.hashCode())) * 31;
        String str6 = this.offerId;
        int iHashCode11 = (iHashCode10 + (str6 == null ? 0 : str6.hashCode())) * 31;
        Date date4 = this.revocationDate;
        int iHashCode12 = (iHashCode11 + (date4 == null ? 0 : date4.hashCode())) * 31;
        String str7 = this.appAccountToken;
        int iHashCode13 = (((((iHashCode12 + (str7 == null ? 0 : str7.hashCode())) * 31) + this.purchaseToken.hashCode()) * 31) + this.payment.hashCode()) * 31;
        String str8 = this.signature;
        return iHashCode13 + (str8 != null ? str8.hashCode() : 0);
    }

    @Override // com.superwall.sdk.store.abstractions.transactions.StoreTransactionType
    public Boolean isUpgraded() {
        return this.isUpgraded;
    }

    public void setPayment(StorePayment storePayment) {
        Intrinsics.checkNotNullParameter(storePayment, "<set-?>");
        this.payment = storePayment;
    }

    public final void setUnderlyingSK2Transaction(Purchase purchase) {
        this.underlyingSK2Transaction = purchase;
    }

    public String toString() {
        return "GoogleBillingPurchaseTransaction(underlyingSK2Transaction=" + this.underlyingSK2Transaction + ", transactionDate=" + this.transactionDate + ", originalTransactionIdentifier=" + this.originalTransactionIdentifier + ", state=" + this.state + ", storeTransactionId=" + this.storeTransactionId + ", originalTransactionDate=" + this.originalTransactionDate + ", webOrderLineItemID=" + this.webOrderLineItemID + ", appBundleId=" + this.appBundleId + ", subscriptionGroupId=" + this.subscriptionGroupId + ", isUpgraded=" + this.isUpgraded + ", expirationDate=" + this.expirationDate + ", offerId=" + this.offerId + ", revocationDate=" + this.revocationDate + ", appAccountToken=" + this.appAccountToken + ", purchaseToken=" + this.purchaseToken + ", payment=" + this.payment + ", signature=" + this.signature + ")";
    }

    public GoogleBillingPurchaseTransaction(Purchase purchase, Date date, String str, StoreTransactionState state, String str2, Date date2, String str3, String str4, String str5, Boolean bool, Date date3, String str6, Date date4, String str7, String purchaseToken, StorePayment payment, String str8) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(purchaseToken, "purchaseToken");
        Intrinsics.checkNotNullParameter(payment, "payment");
        this.underlyingSK2Transaction = purchase;
        this.transactionDate = date;
        this.originalTransactionIdentifier = str;
        this.state = state;
        this.storeTransactionId = str2;
        this.originalTransactionDate = date2;
        this.webOrderLineItemID = str3;
        this.appBundleId = str4;
        this.subscriptionGroupId = str5;
        this.isUpgraded = bool;
        this.expirationDate = date3;
        this.offerId = str6;
        this.revocationDate = date4;
        this.appAccountToken = str7;
        this.purchaseToken = purchaseToken;
        this.payment = payment;
        this.signature = str8;
    }

    @SerialName
    public static /* synthetic */ void getAppAccountToken$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getAppBundleId$annotations() {
    }

    @SerialName
    @Serializable(with = DateSerializer.class)
    public static /* synthetic */ void getExpirationDate$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getOfferId$annotations() {
    }

    @SerialName
    @Serializable(with = DateSerializer.class)
    public static /* synthetic */ void getOriginalTransactionDate$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getOriginalTransactionIdentifier$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getPurchaseToken$annotations() {
    }

    @SerialName
    @Serializable(with = DateSerializer.class)
    public static /* synthetic */ void getRevocationDate$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getState$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getStoreTransactionId$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getSubscriptionGroupId$annotations() {
    }

    @SerialName
    @Serializable(with = DateSerializer.class)
    public static /* synthetic */ void getTransactionDate$annotations() {
    }

    @Transient
    public static /* synthetic */ void getUnderlyingSK2Transaction$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getWebOrderLineItemID$annotations() {
    }

    @SerialName
    public static /* synthetic */ void isUpgraded$annotations() {
    }

    public /* synthetic */ GoogleBillingPurchaseTransaction(Purchase purchase, Date date, String str, StoreTransactionState storeTransactionState, String str2, Date date2, String str3, String str4, String str5, Boolean bool, Date date3, String str6, Date date4, String str7, String str8, StorePayment storePayment, String str9, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : purchase, date, str, storeTransactionState, str2, date2, str3, str4, str5, bool, date3, str6, date4, str7, str8, storePayment, str9);
    }

    public GoogleBillingPurchaseTransaction(Purchase transaction) {
        Intrinsics.checkNotNullParameter(transaction, "transaction");
        Date date = new Date(transaction.e());
        String strA = transaction.a();
        StoreTransactionState.Purchased purchased = StoreTransactionState.Purchased.INSTANCE;
        String strA2 = transaction.a();
        Date date2 = new Date(transaction.e());
        StorePayment storePayment = new StorePayment(transaction);
        String strF = transaction.f();
        Intrinsics.checkNotNullExpressionValue(strF, "getPurchaseToken(...)");
        this(transaction, date, strA, purchased, strA2, date2, null, null, null, null, null, null, null, null, strF, storePayment, transaction.g());
    }
}
