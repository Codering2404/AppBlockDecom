package com.revenuecat.purchases.common;

import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.CustomerInfoOriginalSource;
import com.revenuecat.purchases.SubscriptionInfo;
import com.revenuecat.purchases.VerificationResult;
import com.revenuecat.purchases.common.networking.HTTPResult;
import com.revenuecat.purchases.common.responses.CustomerInfoResponseJsonKeys;
import com.revenuecat.purchases.common.responses.SubscriptionInfoResponse;
import com.revenuecat.purchases.utils.JSONObjectExtensionsKt;
import com.revenuecat.purchases.utils.SerializationException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.Json;
import org.json.JSONException;
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
public final class CustomerInfoFactory {
    public static final CustomerInfoFactory INSTANCE = new CustomerInfoFactory();

    private CustomerInfoFactory() {
    }

    public static /* synthetic */ CustomerInfo buildCustomerInfo$default(CustomerInfoFactory customerInfoFactory, JSONObject jSONObject, Date date, VerificationResult verificationResult, CustomerInfoOriginalSource customerInfoOriginalSource, boolean z2, int i3, Object obj) throws JSONException {
        if ((i3 & 8) != 0) {
            customerInfoOriginalSource = CustomerInfoOriginalSource.MAIN;
        }
        CustomerInfoOriginalSource customerInfoOriginalSource2 = customerInfoOriginalSource;
        if ((i3 & 16) != 0) {
            z2 = false;
        }
        return customerInfoFactory.buildCustomerInfo(jSONObject, date, verificationResult, customerInfoOriginalSource2, z2);
    }

    private final HashMap<String, Date> parseDates(JSONObject jSONObject, String str) throws JSONException {
        HashMap<String, Date> map = new HashMap<>();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String key = itKeys.next();
            String it = jSONObject.getJSONObject(key).optString("product_plan_identifier");
            Intrinsics.checkNotNullExpressionValue(it, "it");
            if (it.length() <= 0) {
                it = null;
            }
            JSONObject expirationObject = jSONObject.getJSONObject(key);
            if (it != null) {
                String str2 = key + ':' + it;
                if (str2 != null) {
                    key = str2;
                }
            }
            Intrinsics.checkNotNullExpressionValue(key, "key");
            Intrinsics.checkNotNullExpressionValue(expirationObject, "expirationObject");
            map.put(key, JSONObjectExtensionsKt.optDate(expirationObject, str));
        }
        return map;
    }

    private final Map<String, Date> parseExpirations(JSONObject jSONObject) {
        return parseDates(jSONObject, "expires_date");
    }

    private final Map<String, Date> parsePurchaseDates(JSONObject jSONObject) {
        return parseDates(jSONObject, "purchase_date");
    }

    public final CustomerInfo buildCustomerInfo(HTTPResult httpResult) throws JSONException {
        Intrinsics.checkNotNullParameter(httpResult, "httpResult");
        return buildCustomerInfo(httpResult.getBody(), httpResult.getRequestDate(), httpResult.getVerificationResult(), httpResult.isLoadShedderResponse() ? CustomerInfoOriginalSource.LOAD_SHEDDER : CustomerInfoOriginalSource.MAIN, false);
    }

    public final Map<String, SubscriptionInfo> parseSubscriptionInfos(JSONObject subscriberJSONObject, Date requestDate) throws JSONException {
        Intrinsics.checkNotNullParameter(subscriberJSONObject, "subscriberJSONObject");
        Intrinsics.checkNotNullParameter(requestDate, "requestDate");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        JSONObject jSONObject = subscriberJSONObject.getJSONObject(CustomerInfoResponseJsonKeys.SUBSCRIPTIONS);
        try {
            Iterator<String> itKeys = jSONObject.keys();
            Intrinsics.checkNotNullExpressionValue(itKeys, "subscriptions.keys()");
            while (itKeys.hasNext()) {
                String productId = itKeys.next();
                JSONObject jSONObject2 = jSONObject.getJSONObject(productId);
                Json defaultJson = JsonProvider.Companion.getDefaultJson();
                String string = jSONObject2.toString();
                Intrinsics.checkNotNullExpressionValue(string, "subscriptionJSONObject.toString()");
                defaultJson.a();
                SubscriptionInfoResponse subscriptionInfoResponse = (SubscriptionInfoResponse) defaultJson.d(SubscriptionInfoResponse.Companion.serializer(), string);
                Intrinsics.checkNotNullExpressionValue(productId, "productId");
                Date date = requestDate;
                linkedHashMap.put(productId, new SubscriptionInfo(productId, date, subscriptionInfoResponse, null, 8, null));
                requestDate = date;
            }
        } catch (SerializationException e3) {
            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Error deserializing subscription information", e3);
        } catch (IllegalArgumentException e4) {
            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Error deserializing subscription information. The input is not a SubscriptionInfo", e4);
        }
        return linkedHashMap;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0093  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.revenuecat.purchases.CustomerInfo buildCustomerInfo(org.json.JSONObject r15, java.util.Date r16, com.revenuecat.purchases.VerificationResult r17, com.revenuecat.purchases.CustomerInfoOriginalSource r18, boolean r19) throws org.json.JSONException {
        /*
            Method dump skipped, instruction units count: 234
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.common.CustomerInfoFactory.buildCustomerInfo(org.json.JSONObject, java.util.Date, com.revenuecat.purchases.VerificationResult, com.revenuecat.purchases.CustomerInfoOriginalSource, boolean):com.revenuecat.purchases.CustomerInfo");
    }
}
