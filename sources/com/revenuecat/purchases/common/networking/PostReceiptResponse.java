package com.revenuecat.purchases.common.networking;

import com.revenuecat.purchases.CustomerInfo;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
@Metadata
public final class PostReceiptResponse {
    private final JSONObject body;
    private final CustomerInfo customerInfo;
    private final Map<String, PostReceiptProductInfo> productInfoByProductId;

    public PostReceiptResponse(CustomerInfo customerInfo, Map<String, PostReceiptProductInfo> map, JSONObject body) {
        Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
        Intrinsics.checkNotNullParameter(body, "body");
        this.customerInfo = customerInfo;
        this.productInfoByProductId = map;
        this.body = body;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PostReceiptResponse copy$default(PostReceiptResponse postReceiptResponse, CustomerInfo customerInfo, Map map, JSONObject jSONObject, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            customerInfo = postReceiptResponse.customerInfo;
        }
        if ((i3 & 2) != 0) {
            map = postReceiptResponse.productInfoByProductId;
        }
        if ((i3 & 4) != 0) {
            jSONObject = postReceiptResponse.body;
        }
        return postReceiptResponse.copy(customerInfo, map, jSONObject);
    }

    public final CustomerInfo component1() {
        return this.customerInfo;
    }

    public final Map<String, PostReceiptProductInfo> component2() {
        return this.productInfoByProductId;
    }

    public final JSONObject component3() {
        return this.body;
    }

    public final PostReceiptResponse copy(CustomerInfo customerInfo, Map<String, PostReceiptProductInfo> map, JSONObject body) {
        Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
        Intrinsics.checkNotNullParameter(body, "body");
        return new PostReceiptResponse(customerInfo, map, body);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PostReceiptResponse)) {
            return false;
        }
        PostReceiptResponse postReceiptResponse = (PostReceiptResponse) obj;
        return Intrinsics.areEqual(this.customerInfo, postReceiptResponse.customerInfo) && Intrinsics.areEqual(this.productInfoByProductId, postReceiptResponse.productInfoByProductId) && Intrinsics.areEqual(this.body, postReceiptResponse.body);
    }

    public final JSONObject getBody() {
        return this.body;
    }

    public final CustomerInfo getCustomerInfo() {
        return this.customerInfo;
    }

    public final Map<String, PostReceiptProductInfo> getProductInfoByProductId() {
        return this.productInfoByProductId;
    }

    public int hashCode() {
        int iHashCode = this.customerInfo.hashCode() * 31;
        Map<String, PostReceiptProductInfo> map = this.productInfoByProductId;
        return ((iHashCode + (map == null ? 0 : map.hashCode())) * 31) + this.body.hashCode();
    }

    public String toString() {
        return "PostReceiptResponse(customerInfo=" + this.customerInfo + ", productInfoByProductId=" + this.productInfoByProductId + ", body=" + this.body + ')';
    }
}
