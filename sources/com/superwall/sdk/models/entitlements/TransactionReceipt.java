package com.superwall.sdk.models.entitlements;

import com.applovin.sdk.AppLovinEventTypes;
import com.superwall.sdk.models.entitlements.TransactionReceipt;
import java.lang.annotation.Annotation;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
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
public final class TransactionReceipt {
    private final String orderId;
    private final String productId;
    private final ProductType productType;
    private final String purchaseToken;
    private final String type;
    public static final Companion Companion = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, null, null, ProductType.Companion.serializer(), null};

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<TransactionReceipt> serializer() {
            return TransactionReceipt$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    public static final class ProductType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ProductType[] $VALUES;
        private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate;
        public static final Companion Companion;

        @SerialName
        public static final ProductType IAP = new ProductType("IAP", 0);

        @SerialName
        public static final ProductType SUBSCRIPTION = new ProductType("SUBSCRIPTION", 1);

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            private Companion() {
            }

            private final /* synthetic */ KSerializer get$cachedSerializer() {
                return (KSerializer) ProductType.$cachedSerializer$delegate.getValue();
            }

            public final KSerializer<ProductType> serializer() {
                return get$cachedSerializer();
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        private static final /* synthetic */ ProductType[] $values() {
            return new ProductType[]{IAP, SUBSCRIPTION};
        }

        static {
            ProductType[] productTypeArr$values = $values();
            $VALUES = productTypeArr$values;
            $ENTRIES = EnumEntriesKt.a(productTypeArr$values);
            Companion = new Companion(null);
            $cachedSerializer$delegate = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0() { // from class: e0.e
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return TransactionReceipt.ProductType._init_$_anonymous_();
                }
            });
        }

        private ProductType(String str, int i3) {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _init_$_anonymous_() {
            return EnumsKt.a("com.superwall.sdk.models.entitlements.TransactionReceipt.ProductType", values(), new String[]{AppLovinEventTypes.USER_COMPLETED_IN_APP_PURCHASE, "subscription"}, new Annotation[][]{null, null}, null);
        }

        public static EnumEntries<ProductType> getEntries() {
            return $ENTRIES;
        }

        public static ProductType valueOf(String str) {
            return (ProductType) Enum.valueOf(ProductType.class, str);
        }

        public static ProductType[] values() {
            return (ProductType[]) $VALUES.clone();
        }
    }

    public /* synthetic */ TransactionReceipt(int i3, String str, String str2, String str3, ProductType productType, String str4, SerializationConstructorMarker serializationConstructorMarker) {
        if (13 != (i3 & 13)) {
            PluginExceptionsKt.b(i3, 13, TransactionReceipt$$serializer.INSTANCE.getDescriptor());
        }
        this.purchaseToken = str;
        if ((i3 & 2) == 0) {
            this.orderId = null;
        } else {
            this.orderId = str2;
        }
        this.productId = str3;
        this.productType = productType;
        if ((i3 & 16) == 0) {
            this.type = "Android";
        } else {
            this.type = str4;
        }
    }

    public static /* synthetic */ TransactionReceipt copy$default(TransactionReceipt transactionReceipt, String str, String str2, String str3, ProductType productType, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = transactionReceipt.purchaseToken;
        }
        if ((i3 & 2) != 0) {
            str2 = transactionReceipt.orderId;
        }
        if ((i3 & 4) != 0) {
            str3 = transactionReceipt.productId;
        }
        if ((i3 & 8) != 0) {
            productType = transactionReceipt.productType;
        }
        return transactionReceipt.copy(str, str2, str3, productType);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$superwall_release(TransactionReceipt transactionReceipt, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        compositeEncoder.y(serialDescriptor, 0, transactionReceipt.purchaseToken);
        if (compositeEncoder.z(serialDescriptor, 1) || transactionReceipt.orderId != null) {
            compositeEncoder.i(serialDescriptor, 1, StringSerializer.f142891a, transactionReceipt.orderId);
        }
        compositeEncoder.y(serialDescriptor, 2, transactionReceipt.productId);
        compositeEncoder.C(serialDescriptor, 3, kSerializerArr[3], transactionReceipt.productType);
        if (!compositeEncoder.z(serialDescriptor, 4) && Intrinsics.areEqual(transactionReceipt.type, "Android")) {
            return;
        }
        compositeEncoder.y(serialDescriptor, 4, transactionReceipt.type);
    }

    public final String component1() {
        return this.purchaseToken;
    }

    public final String component2() {
        return this.orderId;
    }

    public final String component3() {
        return this.productId;
    }

    public final ProductType component4() {
        return this.productType;
    }

    public final TransactionReceipt copy(String purchaseToken, String str, String productId, ProductType productType) {
        Intrinsics.checkNotNullParameter(purchaseToken, "purchaseToken");
        Intrinsics.checkNotNullParameter(productId, "productId");
        Intrinsics.checkNotNullParameter(productType, "productType");
        return new TransactionReceipt(purchaseToken, str, productId, productType);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TransactionReceipt)) {
            return false;
        }
        TransactionReceipt transactionReceipt = (TransactionReceipt) obj;
        return Intrinsics.areEqual(this.purchaseToken, transactionReceipt.purchaseToken) && Intrinsics.areEqual(this.orderId, transactionReceipt.orderId) && Intrinsics.areEqual(this.productId, transactionReceipt.productId) && this.productType == transactionReceipt.productType;
    }

    public final String getOrderId() {
        return this.orderId;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final ProductType getProductType() {
        return this.productType;
    }

    public final String getPurchaseToken() {
        return this.purchaseToken;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        int iHashCode = this.purchaseToken.hashCode() * 31;
        String str = this.orderId;
        return ((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.productId.hashCode()) * 31) + this.productType.hashCode();
    }

    public String toString() {
        return "TransactionReceipt(purchaseToken=" + this.purchaseToken + ", orderId=" + this.orderId + ", productId=" + this.productId + ", productType=" + this.productType + ")";
    }

    public TransactionReceipt(String purchaseToken, String str, String productId, ProductType productType) {
        Intrinsics.checkNotNullParameter(purchaseToken, "purchaseToken");
        Intrinsics.checkNotNullParameter(productId, "productId");
        Intrinsics.checkNotNullParameter(productType, "productType");
        this.purchaseToken = purchaseToken;
        this.orderId = str;
        this.productId = productId;
        this.productType = productType;
        this.type = "Android";
    }

    public /* synthetic */ TransactionReceipt(String str, String str2, String str3, ProductType productType, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? null : str2, str3, productType);
    }

    @SerialName
    public static /* synthetic */ void getOrderId$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getProductId$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getProductType$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getPurchaseToken$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getType$annotations() {
    }
}
