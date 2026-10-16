package com.revenuecat.purchases.common.caching;

import com.revenuecat.purchases.PurchasesAreCompletedBy;
import com.revenuecat.purchases.common.ReceiptInfo;
import com.revenuecat.purchases.common.ReceiptInfo$$serializer;
import com.revenuecat.purchases.paywalls.events.PaywallPostReceiptData;
import com.revenuecat.purchases.paywalls.events.PaywallPostReceiptData$$serializer;
import kotlin.Deprecated;
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
/* JADX INFO: loaded from: classes5.dex */
@Metadata
@Serializable
public final class LocalTransactionMetadata {
    private final PaywallPostReceiptData paywallPostReceiptData;
    private final PurchasesAreCompletedBy purchasesAreCompletedBy;
    private final ReceiptInfo receiptInfo;
    private final String token;
    public static final Companion Companion = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, null, null, EnumsKt.b("com.revenuecat.purchases.PurchasesAreCompletedBy", PurchasesAreCompletedBy.values())};

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<LocalTransactionMetadata> serializer() {
            return LocalTransactionMetadata$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    @Deprecated
    public /* synthetic */ LocalTransactionMetadata(int i3, @SerialName String str, @SerialName ReceiptInfo receiptInfo, @SerialName PaywallPostReceiptData paywallPostReceiptData, @SerialName PurchasesAreCompletedBy purchasesAreCompletedBy, SerializationConstructorMarker serializationConstructorMarker) {
        if (11 != (i3 & 11)) {
            PluginExceptionsKt.b(i3, 11, LocalTransactionMetadata$$serializer.INSTANCE.getDescriptor());
        }
        this.token = str;
        this.receiptInfo = receiptInfo;
        if ((i3 & 4) == 0) {
            this.paywallPostReceiptData = null;
        } else {
            this.paywallPostReceiptData = paywallPostReceiptData;
        }
        this.purchasesAreCompletedBy = purchasesAreCompletedBy;
    }

    public static /* synthetic */ LocalTransactionMetadata copy$default(LocalTransactionMetadata localTransactionMetadata, String str, ReceiptInfo receiptInfo, PaywallPostReceiptData paywallPostReceiptData, PurchasesAreCompletedBy purchasesAreCompletedBy, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = localTransactionMetadata.token;
        }
        if ((i3 & 2) != 0) {
            receiptInfo = localTransactionMetadata.receiptInfo;
        }
        if ((i3 & 4) != 0) {
            paywallPostReceiptData = localTransactionMetadata.paywallPostReceiptData;
        }
        if ((i3 & 8) != 0) {
            purchasesAreCompletedBy = localTransactionMetadata.purchasesAreCompletedBy;
        }
        return localTransactionMetadata.copy(str, receiptInfo, paywallPostReceiptData, purchasesAreCompletedBy);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(LocalTransactionMetadata localTransactionMetadata, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        compositeEncoder.y(serialDescriptor, 0, localTransactionMetadata.token);
        compositeEncoder.C(serialDescriptor, 1, ReceiptInfo$$serializer.INSTANCE, localTransactionMetadata.receiptInfo);
        if (compositeEncoder.z(serialDescriptor, 2) || localTransactionMetadata.paywallPostReceiptData != null) {
            compositeEncoder.i(serialDescriptor, 2, PaywallPostReceiptData$$serializer.INSTANCE, localTransactionMetadata.paywallPostReceiptData);
        }
        compositeEncoder.C(serialDescriptor, 3, kSerializerArr[3], localTransactionMetadata.purchasesAreCompletedBy);
    }

    public final String component1() {
        return this.token;
    }

    public final ReceiptInfo component2() {
        return this.receiptInfo;
    }

    public final PaywallPostReceiptData component3() {
        return this.paywallPostReceiptData;
    }

    public final PurchasesAreCompletedBy component4() {
        return this.purchasesAreCompletedBy;
    }

    public final LocalTransactionMetadata copy(String token, ReceiptInfo receiptInfo, PaywallPostReceiptData paywallPostReceiptData, PurchasesAreCompletedBy purchasesAreCompletedBy) {
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(receiptInfo, "receiptInfo");
        Intrinsics.checkNotNullParameter(purchasesAreCompletedBy, "purchasesAreCompletedBy");
        return new LocalTransactionMetadata(token, receiptInfo, paywallPostReceiptData, purchasesAreCompletedBy);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocalTransactionMetadata)) {
            return false;
        }
        LocalTransactionMetadata localTransactionMetadata = (LocalTransactionMetadata) obj;
        return Intrinsics.areEqual(this.token, localTransactionMetadata.token) && Intrinsics.areEqual(this.receiptInfo, localTransactionMetadata.receiptInfo) && Intrinsics.areEqual(this.paywallPostReceiptData, localTransactionMetadata.paywallPostReceiptData) && this.purchasesAreCompletedBy == localTransactionMetadata.purchasesAreCompletedBy;
    }

    public final PaywallPostReceiptData getPaywallPostReceiptData() {
        return this.paywallPostReceiptData;
    }

    public final PurchasesAreCompletedBy getPurchasesAreCompletedBy() {
        return this.purchasesAreCompletedBy;
    }

    public final ReceiptInfo getReceiptInfo() {
        return this.receiptInfo;
    }

    public final String getToken() {
        return this.token;
    }

    public int hashCode() {
        int iHashCode = ((this.token.hashCode() * 31) + this.receiptInfo.hashCode()) * 31;
        PaywallPostReceiptData paywallPostReceiptData = this.paywallPostReceiptData;
        return ((iHashCode + (paywallPostReceiptData == null ? 0 : paywallPostReceiptData.hashCode())) * 31) + this.purchasesAreCompletedBy.hashCode();
    }

    public String toString() {
        return "LocalTransactionMetadata(token=" + this.token + ", receiptInfo=" + this.receiptInfo + ", paywallPostReceiptData=" + this.paywallPostReceiptData + ", purchasesAreCompletedBy=" + this.purchasesAreCompletedBy + ')';
    }

    public LocalTransactionMetadata(String token, ReceiptInfo receiptInfo, PaywallPostReceiptData paywallPostReceiptData, PurchasesAreCompletedBy purchasesAreCompletedBy) {
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(receiptInfo, "receiptInfo");
        Intrinsics.checkNotNullParameter(purchasesAreCompletedBy, "purchasesAreCompletedBy");
        this.token = token;
        this.receiptInfo = receiptInfo;
        this.paywallPostReceiptData = paywallPostReceiptData;
        this.purchasesAreCompletedBy = purchasesAreCompletedBy;
    }

    public /* synthetic */ LocalTransactionMetadata(String str, ReceiptInfo receiptInfo, PaywallPostReceiptData paywallPostReceiptData, PurchasesAreCompletedBy purchasesAreCompletedBy, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, receiptInfo, (i3 & 4) != 0 ? null : paywallPostReceiptData, purchasesAreCompletedBy);
    }

    @SerialName
    public static /* synthetic */ void getPaywallPostReceiptData$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getPurchasesAreCompletedBy$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getReceiptInfo$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getToken$annotations() {
    }
}
