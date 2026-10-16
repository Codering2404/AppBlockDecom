package com.superwall.sdk.models.customer;

import com.superwall.sdk.models.product.Store;
import com.superwall.sdk.models.product.StoreSerializer;
import com.superwall.sdk.models.serialization.DateSerializer;
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
public final class NonSubscriptionTransaction {
    public static final Companion Companion = new Companion(null);
    private final boolean isConsumable;
    private final boolean isRevoked;
    private final String productId;
    private final Date purchaseDate;
    private final Store store;
    private final String transactionId;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final NonSubscriptionTransaction empty() {
            return new NonSubscriptionTransaction("", "", new Date(), false, false, Store.PLAY_STORE);
        }

        public final KSerializer<NonSubscriptionTransaction> serializer() {
            return NonSubscriptionTransaction$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ NonSubscriptionTransaction(int i3, String str, String str2, Date date, boolean z2, boolean z3, Store store, SerializationConstructorMarker serializationConstructorMarker) {
        if (31 != (i3 & 31)) {
            PluginExceptionsKt.b(i3, 31, NonSubscriptionTransaction$$serializer.INSTANCE.getDescriptor());
        }
        this.transactionId = str;
        this.productId = str2;
        this.purchaseDate = date;
        this.isConsumable = z2;
        this.isRevoked = z3;
        if ((i3 & 32) == 0) {
            this.store = Store.PLAY_STORE;
        } else {
            this.store = store;
        }
    }

    public static /* synthetic */ NonSubscriptionTransaction copy$default(NonSubscriptionTransaction nonSubscriptionTransaction, String str, String str2, Date date, boolean z2, boolean z3, Store store, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = nonSubscriptionTransaction.transactionId;
        }
        if ((i3 & 2) != 0) {
            str2 = nonSubscriptionTransaction.productId;
        }
        if ((i3 & 4) != 0) {
            date = nonSubscriptionTransaction.purchaseDate;
        }
        if ((i3 & 8) != 0) {
            z2 = nonSubscriptionTransaction.isConsumable;
        }
        if ((i3 & 16) != 0) {
            z3 = nonSubscriptionTransaction.isRevoked;
        }
        if ((i3 & 32) != 0) {
            store = nonSubscriptionTransaction.store;
        }
        boolean z4 = z3;
        Store store2 = store;
        return nonSubscriptionTransaction.copy(str, str2, date, z2, z4, store2);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$superwall_release(NonSubscriptionTransaction nonSubscriptionTransaction, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        compositeEncoder.y(serialDescriptor, 0, nonSubscriptionTransaction.transactionId);
        compositeEncoder.y(serialDescriptor, 1, nonSubscriptionTransaction.productId);
        compositeEncoder.C(serialDescriptor, 2, DateSerializer.INSTANCE, nonSubscriptionTransaction.purchaseDate);
        compositeEncoder.x(serialDescriptor, 3, nonSubscriptionTransaction.isConsumable);
        compositeEncoder.x(serialDescriptor, 4, nonSubscriptionTransaction.isRevoked);
        if (!compositeEncoder.z(serialDescriptor, 5) && nonSubscriptionTransaction.store == Store.PLAY_STORE) {
            return;
        }
        compositeEncoder.C(serialDescriptor, 5, StoreSerializer.INSTANCE, nonSubscriptionTransaction.store);
    }

    public final String component1() {
        return this.transactionId;
    }

    public final String component2() {
        return this.productId;
    }

    public final Date component3() {
        return this.purchaseDate;
    }

    public final boolean component4() {
        return this.isConsumable;
    }

    public final boolean component5() {
        return this.isRevoked;
    }

    public final Store component6() {
        return this.store;
    }

    public final NonSubscriptionTransaction copy(String transactionId, String productId, Date purchaseDate, boolean z2, boolean z3, Store store) {
        Intrinsics.checkNotNullParameter(transactionId, "transactionId");
        Intrinsics.checkNotNullParameter(productId, "productId");
        Intrinsics.checkNotNullParameter(purchaseDate, "purchaseDate");
        Intrinsics.checkNotNullParameter(store, "store");
        return new NonSubscriptionTransaction(transactionId, productId, purchaseDate, z2, z3, store);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NonSubscriptionTransaction)) {
            return false;
        }
        NonSubscriptionTransaction nonSubscriptionTransaction = (NonSubscriptionTransaction) obj;
        return Intrinsics.areEqual(this.transactionId, nonSubscriptionTransaction.transactionId) && Intrinsics.areEqual(this.productId, nonSubscriptionTransaction.productId) && Intrinsics.areEqual(this.purchaseDate, nonSubscriptionTransaction.purchaseDate) && this.isConsumable == nonSubscriptionTransaction.isConsumable && this.isRevoked == nonSubscriptionTransaction.isRevoked && this.store == nonSubscriptionTransaction.store;
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

    public final String getTransactionId() {
        return this.transactionId;
    }

    public int hashCode() {
        return (((((((((this.transactionId.hashCode() * 31) + this.productId.hashCode()) * 31) + this.purchaseDate.hashCode()) * 31) + Boolean.hashCode(this.isConsumable)) * 31) + Boolean.hashCode(this.isRevoked)) * 31) + this.store.hashCode();
    }

    public final boolean isConsumable() {
        return this.isConsumable;
    }

    public final boolean isRevoked() {
        return this.isRevoked;
    }

    public String toString() {
        return "NonSubscriptionTransaction(transactionId=" + this.transactionId + ", productId=" + this.productId + ", purchaseDate=" + this.purchaseDate + ", isConsumable=" + this.isConsumable + ", isRevoked=" + this.isRevoked + ", store=" + this.store + ")";
    }

    public NonSubscriptionTransaction(String transactionId, String productId, Date purchaseDate, boolean z2, boolean z3, Store store) {
        Intrinsics.checkNotNullParameter(transactionId, "transactionId");
        Intrinsics.checkNotNullParameter(productId, "productId");
        Intrinsics.checkNotNullParameter(purchaseDate, "purchaseDate");
        Intrinsics.checkNotNullParameter(store, "store");
        this.transactionId = transactionId;
        this.productId = productId;
        this.purchaseDate = purchaseDate;
        this.isConsumable = z2;
        this.isRevoked = z3;
        this.store = store;
    }

    public /* synthetic */ NonSubscriptionTransaction(String str, String str2, Date date, boolean z2, boolean z3, Store store, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, date, z2, z3, (i3 & 32) != 0 ? Store.PLAY_STORE : store);
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
    public static /* synthetic */ void getTransactionId$annotations() {
    }

    @SerialName
    public static /* synthetic */ void isConsumable$annotations() {
    }

    @SerialName
    public static /* synthetic */ void isRevoked$annotations() {
    }
}
