package com.superwall.sdk.store.abstractions.product.receipt;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import com.superwall.sdk.storage.DateSerializer;
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
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

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
public final class StoredEntitlementTransaction implements EntitlementTransaction {
    private final Date expirationDate;
    private final boolean isActive;
    private final boolean isInBillingRetryPeriod;
    private final boolean isInGracePeriod;
    private final boolean isRevoked;
    private final Date originalPurchaseDate;
    private final String productId;
    private final EntitlementTransactionType productType;
    private final Date purchaseDate;
    private final Date renewedAt;
    private final String transactionId;
    private final boolean willRenew;
    public static final Companion Companion = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, null, null, null, null, null, EnumsKt.b("com.superwall.sdk.store.abstractions.product.receipt.EntitlementTransactionType", EntitlementTransactionType.values()), null, null, null, null, null};

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final StoredEntitlementTransaction from(EntitlementTransaction transaction) {
            Intrinsics.checkNotNullParameter(transaction, "transaction");
            return new StoredEntitlementTransaction(transaction.getProductId(), transaction.getTransactionId(), transaction.getPurchaseDate(), transaction.getOriginalPurchaseDate(), transaction.getExpirationDate(), transaction.isRevoked(), transaction.getProductType(), transaction.getWillRenew(), transaction.getRenewedAt(), transaction.isInGracePeriod(), transaction.isInBillingRetryPeriod(), transaction.isActive());
        }

        public final KSerializer<StoredEntitlementTransaction> serializer() {
            return StoredEntitlementTransaction$$serializer.INSTANCE;
        }

        public final StoredEntitlementTransaction withUpdatedActiveStatus(StoredEntitlementTransaction stored, boolean z2) {
            Intrinsics.checkNotNullParameter(stored, "stored");
            return StoredEntitlementTransaction.copy$default(stored, null, null, null, null, null, false, null, !z2 ? false : stored.getWillRenew(), null, false, false, z2, 1919, null);
        }

        private Companion() {
        }
    }

    public /* synthetic */ StoredEntitlementTransaction(int i3, String str, String str2, Date date, Date date2, Date date3, boolean z2, EntitlementTransactionType entitlementTransactionType, boolean z3, Date date4, boolean z4, boolean z5, boolean z6, SerializationConstructorMarker serializationConstructorMarker) {
        if (4095 != (i3 & 4095)) {
            PluginExceptionsKt.b(i3, 4095, StoredEntitlementTransaction$$serializer.INSTANCE.getDescriptor());
        }
        this.productId = str;
        this.transactionId = str2;
        this.purchaseDate = date;
        this.originalPurchaseDate = date2;
        this.expirationDate = date3;
        this.isRevoked = z2;
        this.productType = entitlementTransactionType;
        this.willRenew = z3;
        this.renewedAt = date4;
        this.isInGracePeriod = z4;
        this.isInBillingRetryPeriod = z5;
        this.isActive = z6;
    }

    public static /* synthetic */ StoredEntitlementTransaction copy$default(StoredEntitlementTransaction storedEntitlementTransaction, String str, String str2, Date date, Date date2, Date date3, boolean z2, EntitlementTransactionType entitlementTransactionType, boolean z3, Date date4, boolean z4, boolean z5, boolean z6, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = storedEntitlementTransaction.productId;
        }
        if ((i3 & 2) != 0) {
            str2 = storedEntitlementTransaction.transactionId;
        }
        if ((i3 & 4) != 0) {
            date = storedEntitlementTransaction.purchaseDate;
        }
        if ((i3 & 8) != 0) {
            date2 = storedEntitlementTransaction.originalPurchaseDate;
        }
        if ((i3 & 16) != 0) {
            date3 = storedEntitlementTransaction.expirationDate;
        }
        if ((i3 & 32) != 0) {
            z2 = storedEntitlementTransaction.isRevoked;
        }
        if ((i3 & 64) != 0) {
            entitlementTransactionType = storedEntitlementTransaction.productType;
        }
        if ((i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0) {
            z3 = storedEntitlementTransaction.willRenew;
        }
        if ((i3 & Function.MAX_NARGS) != 0) {
            date4 = storedEntitlementTransaction.renewedAt;
        }
        if ((i3 & 512) != 0) {
            z4 = storedEntitlementTransaction.isInGracePeriod;
        }
        if ((i3 & 1024) != 0) {
            z5 = storedEntitlementTransaction.isInBillingRetryPeriod;
        }
        if ((i3 & 2048) != 0) {
            z6 = storedEntitlementTransaction.isActive;
        }
        boolean z7 = z5;
        boolean z8 = z6;
        Date date5 = date4;
        boolean z9 = z4;
        EntitlementTransactionType entitlementTransactionType2 = entitlementTransactionType;
        boolean z10 = z3;
        Date date6 = date3;
        boolean z11 = z2;
        return storedEntitlementTransaction.copy(str, str2, date, date2, date6, z11, entitlementTransactionType2, z10, date5, z9, z7, z8);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$superwall_release(StoredEntitlementTransaction storedEntitlementTransaction, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        compositeEncoder.y(serialDescriptor, 0, storedEntitlementTransaction.getProductId());
        compositeEncoder.y(serialDescriptor, 1, storedEntitlementTransaction.getTransactionId());
        DateSerializer dateSerializer = DateSerializer.INSTANCE;
        compositeEncoder.C(serialDescriptor, 2, dateSerializer, storedEntitlementTransaction.getPurchaseDate());
        compositeEncoder.C(serialDescriptor, 3, dateSerializer, storedEntitlementTransaction.getOriginalPurchaseDate());
        compositeEncoder.i(serialDescriptor, 4, dateSerializer, storedEntitlementTransaction.getExpirationDate());
        compositeEncoder.x(serialDescriptor, 5, storedEntitlementTransaction.isRevoked());
        compositeEncoder.C(serialDescriptor, 6, kSerializerArr[6], storedEntitlementTransaction.getProductType());
        compositeEncoder.x(serialDescriptor, 7, storedEntitlementTransaction.getWillRenew());
        compositeEncoder.i(serialDescriptor, 8, dateSerializer, storedEntitlementTransaction.getRenewedAt());
        compositeEncoder.x(serialDescriptor, 9, storedEntitlementTransaction.isInGracePeriod());
        compositeEncoder.x(serialDescriptor, 10, storedEntitlementTransaction.isInBillingRetryPeriod());
        compositeEncoder.x(serialDescriptor, 11, storedEntitlementTransaction.isActive());
    }

    public final String component1() {
        return this.productId;
    }

    public final boolean component10() {
        return this.isInGracePeriod;
    }

    public final boolean component11() {
        return this.isInBillingRetryPeriod;
    }

    public final boolean component12() {
        return this.isActive;
    }

    public final String component2() {
        return this.transactionId;
    }

    public final Date component3() {
        return this.purchaseDate;
    }

    public final Date component4() {
        return this.originalPurchaseDate;
    }

    public final Date component5() {
        return this.expirationDate;
    }

    public final boolean component6() {
        return this.isRevoked;
    }

    public final EntitlementTransactionType component7() {
        return this.productType;
    }

    public final boolean component8() {
        return this.willRenew;
    }

    public final Date component9() {
        return this.renewedAt;
    }

    public final StoredEntitlementTransaction copy(String productId, String transactionId, Date purchaseDate, Date originalPurchaseDate, Date date, boolean z2, EntitlementTransactionType productType, boolean z3, Date date2, boolean z4, boolean z5, boolean z6) {
        Intrinsics.checkNotNullParameter(productId, "productId");
        Intrinsics.checkNotNullParameter(transactionId, "transactionId");
        Intrinsics.checkNotNullParameter(purchaseDate, "purchaseDate");
        Intrinsics.checkNotNullParameter(originalPurchaseDate, "originalPurchaseDate");
        Intrinsics.checkNotNullParameter(productType, "productType");
        return new StoredEntitlementTransaction(productId, transactionId, purchaseDate, originalPurchaseDate, date, z2, productType, z3, date2, z4, z5, z6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StoredEntitlementTransaction)) {
            return false;
        }
        StoredEntitlementTransaction storedEntitlementTransaction = (StoredEntitlementTransaction) obj;
        return Intrinsics.areEqual(this.productId, storedEntitlementTransaction.productId) && Intrinsics.areEqual(this.transactionId, storedEntitlementTransaction.transactionId) && Intrinsics.areEqual(this.purchaseDate, storedEntitlementTransaction.purchaseDate) && Intrinsics.areEqual(this.originalPurchaseDate, storedEntitlementTransaction.originalPurchaseDate) && Intrinsics.areEqual(this.expirationDate, storedEntitlementTransaction.expirationDate) && this.isRevoked == storedEntitlementTransaction.isRevoked && this.productType == storedEntitlementTransaction.productType && this.willRenew == storedEntitlementTransaction.willRenew && Intrinsics.areEqual(this.renewedAt, storedEntitlementTransaction.renewedAt) && this.isInGracePeriod == storedEntitlementTransaction.isInGracePeriod && this.isInBillingRetryPeriod == storedEntitlementTransaction.isInBillingRetryPeriod && this.isActive == storedEntitlementTransaction.isActive;
    }

    @Override // com.superwall.sdk.store.abstractions.product.receipt.EntitlementTransaction
    public Date getExpirationDate() {
        return this.expirationDate;
    }

    @Override // com.superwall.sdk.store.abstractions.product.receipt.EntitlementTransaction
    public Date getOriginalPurchaseDate() {
        return this.originalPurchaseDate;
    }

    @Override // com.superwall.sdk.store.abstractions.product.receipt.EntitlementTransaction
    public String getProductId() {
        return this.productId;
    }

    @Override // com.superwall.sdk.store.abstractions.product.receipt.EntitlementTransaction
    public EntitlementTransactionType getProductType() {
        return this.productType;
    }

    @Override // com.superwall.sdk.store.abstractions.product.receipt.EntitlementTransaction
    public Date getPurchaseDate() {
        return this.purchaseDate;
    }

    @Override // com.superwall.sdk.store.abstractions.product.receipt.EntitlementTransaction
    public Date getRenewedAt() {
        return this.renewedAt;
    }

    @Override // com.superwall.sdk.store.abstractions.product.receipt.EntitlementTransaction
    public String getTransactionId() {
        return this.transactionId;
    }

    @Override // com.superwall.sdk.store.abstractions.product.receipt.EntitlementTransaction
    public boolean getWillRenew() {
        return this.willRenew;
    }

    public int hashCode() {
        int iHashCode = ((((((this.productId.hashCode() * 31) + this.transactionId.hashCode()) * 31) + this.purchaseDate.hashCode()) * 31) + this.originalPurchaseDate.hashCode()) * 31;
        Date date = this.expirationDate;
        int iHashCode2 = (((((((iHashCode + (date == null ? 0 : date.hashCode())) * 31) + Boolean.hashCode(this.isRevoked)) * 31) + this.productType.hashCode()) * 31) + Boolean.hashCode(this.willRenew)) * 31;
        Date date2 = this.renewedAt;
        return ((((((iHashCode2 + (date2 != null ? date2.hashCode() : 0)) * 31) + Boolean.hashCode(this.isInGracePeriod)) * 31) + Boolean.hashCode(this.isInBillingRetryPeriod)) * 31) + Boolean.hashCode(this.isActive);
    }

    @Override // com.superwall.sdk.store.abstractions.product.receipt.EntitlementTransaction
    public boolean isActive() {
        return this.isActive;
    }

    @Override // com.superwall.sdk.store.abstractions.product.receipt.EntitlementTransaction
    public boolean isInBillingRetryPeriod() {
        return this.isInBillingRetryPeriod;
    }

    @Override // com.superwall.sdk.store.abstractions.product.receipt.EntitlementTransaction
    public boolean isInGracePeriod() {
        return this.isInGracePeriod;
    }

    @Override // com.superwall.sdk.store.abstractions.product.receipt.EntitlementTransaction
    public boolean isRevoked() {
        return this.isRevoked;
    }

    public String toString() {
        return "StoredEntitlementTransaction(productId=" + this.productId + ", transactionId=" + this.transactionId + ", purchaseDate=" + this.purchaseDate + ", originalPurchaseDate=" + this.originalPurchaseDate + ", expirationDate=" + this.expirationDate + ", isRevoked=" + this.isRevoked + ", productType=" + this.productType + ", willRenew=" + this.willRenew + ", renewedAt=" + this.renewedAt + ", isInGracePeriod=" + this.isInGracePeriod + ", isInBillingRetryPeriod=" + this.isInBillingRetryPeriod + ", isActive=" + this.isActive + ")";
    }

    public StoredEntitlementTransaction(String productId, String transactionId, Date purchaseDate, Date originalPurchaseDate, Date date, boolean z2, EntitlementTransactionType productType, boolean z3, Date date2, boolean z4, boolean z5, boolean z6) {
        Intrinsics.checkNotNullParameter(productId, "productId");
        Intrinsics.checkNotNullParameter(transactionId, "transactionId");
        Intrinsics.checkNotNullParameter(purchaseDate, "purchaseDate");
        Intrinsics.checkNotNullParameter(originalPurchaseDate, "originalPurchaseDate");
        Intrinsics.checkNotNullParameter(productType, "productType");
        this.productId = productId;
        this.transactionId = transactionId;
        this.purchaseDate = purchaseDate;
        this.originalPurchaseDate = originalPurchaseDate;
        this.expirationDate = date;
        this.isRevoked = z2;
        this.productType = productType;
        this.willRenew = z3;
        this.renewedAt = date2;
        this.isInGracePeriod = z4;
        this.isInBillingRetryPeriod = z5;
        this.isActive = z6;
    }

    @SerialName
    @Serializable(with = DateSerializer.class)
    public static /* synthetic */ void getExpirationDate$annotations() {
    }

    @SerialName
    @Serializable(with = DateSerializer.class)
    public static /* synthetic */ void getOriginalPurchaseDate$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getProductId$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getProductType$annotations() {
    }

    @SerialName
    @Serializable(with = DateSerializer.class)
    public static /* synthetic */ void getPurchaseDate$annotations() {
    }

    @SerialName
    @Serializable(with = DateSerializer.class)
    public static /* synthetic */ void getRenewedAt$annotations() {
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
}
