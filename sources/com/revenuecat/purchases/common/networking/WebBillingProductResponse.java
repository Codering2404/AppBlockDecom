package com.revenuecat.purchases.common.networking;

import java.util.Map;
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
import kotlinx.serialization.internal.LinkedHashMapSerializer;
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
/* JADX INFO: loaded from: classes5.dex */
@Metadata
@Serializable
public final class WebBillingProductResponse {
    private final String defaultPurchaseOptionId;
    private final String description;
    private final String identifier;
    private final String productType;
    private final Map<String, WebBillingPurchaseOption> purchaseOptions;
    private final String title;
    public static final Companion Companion = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, null, null, null, null, new LinkedHashMapSerializer(StringSerializer.f142891a, WebBillingPurchaseOption$$serializer.INSTANCE)};

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<WebBillingProductResponse> serializer() {
            return WebBillingProductResponse$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    @Deprecated
    public /* synthetic */ WebBillingProductResponse(int i3, String str, @SerialName String str2, String str3, String str4, @SerialName String str5, @SerialName Map map, SerializationConstructorMarker serializationConstructorMarker) {
        if (39 != (i3 & 39)) {
            PluginExceptionsKt.b(i3, 39, WebBillingProductResponse$$serializer.INSTANCE.getDescriptor());
        }
        this.identifier = str;
        this.productType = str2;
        this.title = str3;
        if ((i3 & 8) == 0) {
            this.description = null;
        } else {
            this.description = str4;
        }
        if ((i3 & 16) == 0) {
            this.defaultPurchaseOptionId = null;
        } else {
            this.defaultPurchaseOptionId = str5;
        }
        this.purchaseOptions = map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WebBillingProductResponse copy$default(WebBillingProductResponse webBillingProductResponse, String str, String str2, String str3, String str4, String str5, Map map, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = webBillingProductResponse.identifier;
        }
        if ((i3 & 2) != 0) {
            str2 = webBillingProductResponse.productType;
        }
        if ((i3 & 4) != 0) {
            str3 = webBillingProductResponse.title;
        }
        if ((i3 & 8) != 0) {
            str4 = webBillingProductResponse.description;
        }
        if ((i3 & 16) != 0) {
            str5 = webBillingProductResponse.defaultPurchaseOptionId;
        }
        if ((i3 & 32) != 0) {
            map = webBillingProductResponse.purchaseOptions;
        }
        String str6 = str5;
        Map map2 = map;
        return webBillingProductResponse.copy(str, str2, str3, str4, str6, map2);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(WebBillingProductResponse webBillingProductResponse, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        compositeEncoder.y(serialDescriptor, 0, webBillingProductResponse.identifier);
        compositeEncoder.y(serialDescriptor, 1, webBillingProductResponse.productType);
        compositeEncoder.y(serialDescriptor, 2, webBillingProductResponse.title);
        if (compositeEncoder.z(serialDescriptor, 3) || webBillingProductResponse.description != null) {
            compositeEncoder.i(serialDescriptor, 3, StringSerializer.f142891a, webBillingProductResponse.description);
        }
        if (compositeEncoder.z(serialDescriptor, 4) || webBillingProductResponse.defaultPurchaseOptionId != null) {
            compositeEncoder.i(serialDescriptor, 4, StringSerializer.f142891a, webBillingProductResponse.defaultPurchaseOptionId);
        }
        compositeEncoder.C(serialDescriptor, 5, kSerializerArr[5], webBillingProductResponse.purchaseOptions);
    }

    public final String component1() {
        return this.identifier;
    }

    public final String component2() {
        return this.productType;
    }

    public final String component3() {
        return this.title;
    }

    public final String component4() {
        return this.description;
    }

    public final String component5() {
        return this.defaultPurchaseOptionId;
    }

    public final Map<String, WebBillingPurchaseOption> component6() {
        return this.purchaseOptions;
    }

    public final WebBillingProductResponse copy(String identifier, String productType, String title, String str, String str2, Map<String, WebBillingPurchaseOption> purchaseOptions) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        Intrinsics.checkNotNullParameter(productType, "productType");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(purchaseOptions, "purchaseOptions");
        return new WebBillingProductResponse(identifier, productType, title, str, str2, purchaseOptions);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WebBillingProductResponse)) {
            return false;
        }
        WebBillingProductResponse webBillingProductResponse = (WebBillingProductResponse) obj;
        return Intrinsics.areEqual(this.identifier, webBillingProductResponse.identifier) && Intrinsics.areEqual(this.productType, webBillingProductResponse.productType) && Intrinsics.areEqual(this.title, webBillingProductResponse.title) && Intrinsics.areEqual(this.description, webBillingProductResponse.description) && Intrinsics.areEqual(this.defaultPurchaseOptionId, webBillingProductResponse.defaultPurchaseOptionId) && Intrinsics.areEqual(this.purchaseOptions, webBillingProductResponse.purchaseOptions);
    }

    public final String getDefaultPurchaseOptionId() {
        return this.defaultPurchaseOptionId;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getIdentifier() {
        return this.identifier;
    }

    public final String getProductType() {
        return this.productType;
    }

    public final Map<String, WebBillingPurchaseOption> getPurchaseOptions() {
        return this.purchaseOptions;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        int iHashCode = ((((this.identifier.hashCode() * 31) + this.productType.hashCode()) * 31) + this.title.hashCode()) * 31;
        String str = this.description;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.defaultPurchaseOptionId;
        return ((iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.purchaseOptions.hashCode();
    }

    public String toString() {
        return "WebBillingProductResponse(identifier=" + this.identifier + ", productType=" + this.productType + ", title=" + this.title + ", description=" + this.description + ", defaultPurchaseOptionId=" + this.defaultPurchaseOptionId + ", purchaseOptions=" + this.purchaseOptions + ')';
    }

    public WebBillingProductResponse(String identifier, String productType, String title, String str, String str2, Map<String, WebBillingPurchaseOption> purchaseOptions) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        Intrinsics.checkNotNullParameter(productType, "productType");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(purchaseOptions, "purchaseOptions");
        this.identifier = identifier;
        this.productType = productType;
        this.title = title;
        this.description = str;
        this.defaultPurchaseOptionId = str2;
        this.purchaseOptions = purchaseOptions;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ WebBillingProductResponse(String str, String str2, String str3, String str4, String str5, Map map, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        Map map2;
        String str6;
        str4 = (i3 & 8) != 0 ? null : str4;
        if ((i3 & 16) != 0) {
            map2 = map;
            str6 = null;
        } else {
            map2 = map;
            str6 = str5;
        }
        this(str, str2, str3, str4, str6, map2);
    }

    @SerialName
    public static /* synthetic */ void getDefaultPurchaseOptionId$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getProductType$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getPurchaseOptions$annotations() {
    }
}
