package com.superwall.sdk.models.customer;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import com.superwall.sdk.models.product.Store;
import com.superwall.sdk.models.product.StoreSerializer;
import com.superwall.sdk.models.serialization.DateSerializer;
import com.superwall.sdk.store.abstractions.product.receipt.LatestPeriodType;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
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
public final class SubscriptionTransaction {
    private final Date expirationDate;
    private final boolean isActive;
    private final boolean isInBillingRetryPeriod;
    private final boolean isInGracePeriod;
    private final boolean isRevoked;
    private final LatestPeriodType offerType;
    private final String productId;
    private final Date purchaseDate;
    private final Store store;
    private final String subscriptionGroupId;
    private final String transactionId;
    private final boolean willRenew;
    public static final Companion Companion = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, null, null, null, null, null, null, null, null, null, LatestPeriodType.Companion.serializer(), null};

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SubscriptionTransaction empty() {
            return new SubscriptionTransaction("", "", new Date(), false, false, false, false, false, (Date) null, Store.PLAY_STORE, (LatestPeriodType) null, (String) null, 2048, (DefaultConstructorMarker) null);
        }

        public final KSerializer<SubscriptionTransaction> serializer() {
            return SubscriptionTransaction$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ SubscriptionTransaction(int i3, String str, String str2, Date date, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, Date date2, Store store, LatestPeriodType latestPeriodType, String str3, SerializationConstructorMarker serializationConstructorMarker) {
        if (511 != (i3 & 511)) {
            PluginExceptionsKt.b(i3, 511, SubscriptionTransaction$$serializer.INSTANCE.getDescriptor());
        }
        this.transactionId = str;
        this.productId = str2;
        this.purchaseDate = date;
        this.willRenew = z2;
        this.isRevoked = z3;
        this.isInGracePeriod = z4;
        this.isInBillingRetryPeriod = z5;
        this.isActive = z6;
        this.expirationDate = date2;
        if ((i3 & 512) == 0) {
            this.store = Store.PLAY_STORE;
        } else {
            this.store = store;
        }
        if ((i3 & 1024) == 0) {
            this.offerType = null;
        } else {
            this.offerType = latestPeriodType;
        }
        if ((i3 & 2048) == 0) {
            this.subscriptionGroupId = null;
        } else {
            this.subscriptionGroupId = str3;
        }
    }

    public static /* synthetic */ SubscriptionTransaction copy$default(SubscriptionTransaction subscriptionTransaction, String str, String str2, Date date, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, Date date2, Store store, LatestPeriodType latestPeriodType, String str3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = subscriptionTransaction.transactionId;
        }
        if ((i3 & 2) != 0) {
            str2 = subscriptionTransaction.productId;
        }
        if ((i3 & 4) != 0) {
            date = subscriptionTransaction.purchaseDate;
        }
        if ((i3 & 8) != 0) {
            z2 = subscriptionTransaction.willRenew;
        }
        if ((i3 & 16) != 0) {
            z3 = subscriptionTransaction.isRevoked;
        }
        if ((i3 & 32) != 0) {
            z4 = subscriptionTransaction.isInGracePeriod;
        }
        if ((i3 & 64) != 0) {
            z5 = subscriptionTransaction.isInBillingRetryPeriod;
        }
        if ((i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0) {
            z6 = subscriptionTransaction.isActive;
        }
        if ((i3 & Function.MAX_NARGS) != 0) {
            date2 = subscriptionTransaction.expirationDate;
        }
        if ((i3 & 512) != 0) {
            store = subscriptionTransaction.store;
        }
        if ((i3 & 1024) != 0) {
            latestPeriodType = subscriptionTransaction.offerType;
        }
        if ((i3 & 2048) != 0) {
            str3 = subscriptionTransaction.subscriptionGroupId;
        }
        LatestPeriodType latestPeriodType2 = latestPeriodType;
        String str4 = str3;
        Date date3 = date2;
        Store store2 = store;
        boolean z7 = z5;
        boolean z8 = z6;
        boolean z9 = z3;
        boolean z10 = z4;
        return subscriptionTransaction.copy(str, str2, date, z2, z9, z10, z7, z8, date3, store2, latestPeriodType2, str4);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$superwall_release(SubscriptionTransaction subscriptionTransaction, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        compositeEncoder.y(serialDescriptor, 0, subscriptionTransaction.transactionId);
        compositeEncoder.y(serialDescriptor, 1, subscriptionTransaction.productId);
        DateSerializer dateSerializer = DateSerializer.INSTANCE;
        compositeEncoder.C(serialDescriptor, 2, dateSerializer, subscriptionTransaction.purchaseDate);
        compositeEncoder.x(serialDescriptor, 3, subscriptionTransaction.willRenew);
        compositeEncoder.x(serialDescriptor, 4, subscriptionTransaction.isRevoked);
        compositeEncoder.x(serialDescriptor, 5, subscriptionTransaction.isInGracePeriod);
        compositeEncoder.x(serialDescriptor, 6, subscriptionTransaction.isInBillingRetryPeriod);
        compositeEncoder.x(serialDescriptor, 7, subscriptionTransaction.isActive);
        compositeEncoder.i(serialDescriptor, 8, dateSerializer, subscriptionTransaction.expirationDate);
        if (compositeEncoder.z(serialDescriptor, 9) || subscriptionTransaction.store != Store.PLAY_STORE) {
            compositeEncoder.C(serialDescriptor, 9, StoreSerializer.INSTANCE, subscriptionTransaction.store);
        }
        if (compositeEncoder.z(serialDescriptor, 10) || subscriptionTransaction.offerType != null) {
            compositeEncoder.i(serialDescriptor, 10, kSerializerArr[10], subscriptionTransaction.offerType);
        }
        if (!compositeEncoder.z(serialDescriptor, 11) && subscriptionTransaction.subscriptionGroupId == null) {
            return;
        }
        compositeEncoder.i(serialDescriptor, 11, StringSerializer.f142891a, subscriptionTransaction.subscriptionGroupId);
    }

    public final String component1() {
        return this.transactionId;
    }

    public final Store component10() {
        return this.store;
    }

    public final LatestPeriodType component11() {
        return this.offerType;
    }

    public final String component12() {
        return this.subscriptionGroupId;
    }

    public final String component2() {
        return this.productId;
    }

    public final Date component3() {
        return this.purchaseDate;
    }

    public final boolean component4() {
        return this.willRenew;
    }

    public final boolean component5() {
        return this.isRevoked;
    }

    public final boolean component6() {
        return this.isInGracePeriod;
    }

    public final boolean component7() {
        return this.isInBillingRetryPeriod;
    }

    public final boolean component8() {
        return this.isActive;
    }

    public final Date component9() {
        return this.expirationDate;
    }

    public final SubscriptionTransaction copy(String transactionId, String productId, Date purchaseDate, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, Date date, Store store, LatestPeriodType latestPeriodType, String str) {
        Intrinsics.checkNotNullParameter(transactionId, "transactionId");
        Intrinsics.checkNotNullParameter(productId, "productId");
        Intrinsics.checkNotNullParameter(purchaseDate, "purchaseDate");
        Intrinsics.checkNotNullParameter(store, "store");
        return new SubscriptionTransaction(transactionId, productId, purchaseDate, z2, z3, z4, z5, z6, date, store, latestPeriodType, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubscriptionTransaction)) {
            return false;
        }
        SubscriptionTransaction subscriptionTransaction = (SubscriptionTransaction) obj;
        return Intrinsics.areEqual(this.transactionId, subscriptionTransaction.transactionId) && Intrinsics.areEqual(this.productId, subscriptionTransaction.productId) && Intrinsics.areEqual(this.purchaseDate, subscriptionTransaction.purchaseDate) && this.willRenew == subscriptionTransaction.willRenew && this.isRevoked == subscriptionTransaction.isRevoked && this.isInGracePeriod == subscriptionTransaction.isInGracePeriod && this.isInBillingRetryPeriod == subscriptionTransaction.isInBillingRetryPeriod && this.isActive == subscriptionTransaction.isActive && Intrinsics.areEqual(this.expirationDate, subscriptionTransaction.expirationDate) && this.store == subscriptionTransaction.store && this.offerType == subscriptionTransaction.offerType && Intrinsics.areEqual(this.subscriptionGroupId, subscriptionTransaction.subscriptionGroupId);
    }

    public final Date getExpirationDate() {
        return this.expirationDate;
    }

    public final LatestPeriodType getOfferType() {
        return this.offerType;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final Date getPurchaseDate() {
        return this.purchaseDate;
    }

    public final Store getStore() {
        return this.store;
    }

    public final String getSubscriptionGroupId() {
        return this.subscriptionGroupId;
    }

    public final String getTransactionId() {
        return this.transactionId;
    }

    public final boolean getWillRenew() {
        return this.willRenew;
    }

    public int hashCode() {
        int iHashCode = ((((((((((((((this.transactionId.hashCode() * 31) + this.productId.hashCode()) * 31) + this.purchaseDate.hashCode()) * 31) + Boolean.hashCode(this.willRenew)) * 31) + Boolean.hashCode(this.isRevoked)) * 31) + Boolean.hashCode(this.isInGracePeriod)) * 31) + Boolean.hashCode(this.isInBillingRetryPeriod)) * 31) + Boolean.hashCode(this.isActive)) * 31;
        Date date = this.expirationDate;
        int iHashCode2 = (((iHashCode + (date == null ? 0 : date.hashCode())) * 31) + this.store.hashCode()) * 31;
        LatestPeriodType latestPeriodType = this.offerType;
        int iHashCode3 = (iHashCode2 + (latestPeriodType == null ? 0 : latestPeriodType.hashCode())) * 31;
        String str = this.subscriptionGroupId;
        return iHashCode3 + (str != null ? str.hashCode() : 0);
    }

    public final boolean isActive() {
        return this.isActive;
    }

    public final boolean isInBillingRetryPeriod() {
        return this.isInBillingRetryPeriod;
    }

    public final boolean isInGracePeriod() {
        return this.isInGracePeriod;
    }

    public final boolean isRevoked() {
        return this.isRevoked;
    }

    public String toString() {
        return "SubscriptionTransaction(transactionId=" + this.transactionId + ", productId=" + this.productId + ", purchaseDate=" + this.purchaseDate + ", willRenew=" + this.willRenew + ", isRevoked=" + this.isRevoked + ", isInGracePeriod=" + this.isInGracePeriod + ", isInBillingRetryPeriod=" + this.isInBillingRetryPeriod + ", isActive=" + this.isActive + ", expirationDate=" + this.expirationDate + ", store=" + this.store + ", offerType=" + this.offerType + ", subscriptionGroupId=" + this.subscriptionGroupId + ")";
    }

    public SubscriptionTransaction(String transactionId, String productId, Date purchaseDate, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, Date date, Store store, LatestPeriodType latestPeriodType, String str) {
        Intrinsics.checkNotNullParameter(transactionId, "transactionId");
        Intrinsics.checkNotNullParameter(productId, "productId");
        Intrinsics.checkNotNullParameter(purchaseDate, "purchaseDate");
        Intrinsics.checkNotNullParameter(store, "store");
        this.transactionId = transactionId;
        this.productId = productId;
        this.purchaseDate = purchaseDate;
        this.willRenew = z2;
        this.isRevoked = z3;
        this.isInGracePeriod = z4;
        this.isInBillingRetryPeriod = z5;
        this.isActive = z6;
        this.expirationDate = date;
        this.store = store;
        this.offerType = latestPeriodType;
        this.subscriptionGroupId = str;
    }

    @SerialName
    @Serializable(with = DateSerializer.class)
    public static /* synthetic */ void getExpirationDate$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getOfferType$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getProductId$annotations() {
    }

    @SerialName
    @Serializable(with = DateSerializer.class)
    public static /* synthetic */ void getPurchaseDate$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getStore$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getSubscriptionGroupId$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getTransactionId$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getWillRenew$annotations() {
    }

    @SerialName
    public static /* synthetic */ void isActive$annotations() {
    }

    @SerialName
    public static /* synthetic */ void isInBillingRetryPeriod$annotations() {
    }

    @SerialName
    public static /* synthetic */ void isInGracePeriod$annotations() {
    }

    @SerialName
    public static /* synthetic */ void isRevoked$annotations() {
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException
        */
    public /* synthetic */ SubscriptionTransaction(java.lang.String r16, java.lang.String r17, java.util.Date r18, boolean r19, boolean r20, boolean r21, boolean r22, boolean r23, java.util.Date r24, com.superwall.sdk.models.product.Store r25, com.superwall.sdk.store.abstractions.product.receipt.LatestPeriodType r26, java.lang.String r27, int r28, kotlin.jvm.internal.DefaultConstructorMarker r29) {
        /*
            r15 = this;
            r0 = r28
            r1 = r0 & 512(0x200, float:7.17E-43)
            if (r1 == 0) goto La
            com.superwall.sdk.models.product.Store r1 = com.superwall.sdk.models.product.Store.PLAY_STORE
            r12 = r1
            goto Lc
        La:
            r12 = r25
        Lc:
            r1 = r0 & 1024(0x400, float:1.435E-42)
            r2 = 0
            if (r1 == 0) goto L13
            r13 = r2
            goto L15
        L13:
            r13 = r26
        L15:
            r0 = r0 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L2e
            r14 = r2
            r3 = r16
            r4 = r17
            r5 = r18
            r6 = r19
            r7 = r20
            r8 = r21
            r9 = r22
            r10 = r23
            r11 = r24
            r2 = r15
            goto L43
        L2e:
            r14 = r27
            r2 = r15
            r3 = r16
            r4 = r17
            r5 = r18
            r6 = r19
            r7 = r20
            r8 = r21
            r9 = r22
            r10 = r23
            r11 = r24
        L43:
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.models.customer.SubscriptionTransaction.<init>(java.lang.String, java.lang.String, java.util.Date, boolean, boolean, boolean, boolean, boolean, java.util.Date, com.superwall.sdk.models.product.Store, com.superwall.sdk.store.abstractions.product.receipt.LatestPeriodType, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
