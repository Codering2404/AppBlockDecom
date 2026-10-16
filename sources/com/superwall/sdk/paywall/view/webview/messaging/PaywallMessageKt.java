package com.superwall.sdk.paywall.view.webview.messaging;

import com.applovin.sdk.AppLovinEventTypes;
import com.facebook.internal.NativeProtocol;
import com.revenuecat.purchases.common.responses.EntitlementsResponseJsonKeys;
import com.superwall.sdk.logger.LogLevel;
import com.superwall.sdk.logger.LogScope;
import com.superwall.sdk.logger.Logger;
import com.superwall.sdk.models.paywall.LocalNotificationType;
import com.superwall.sdk.paywall.presentation.CustomCallbackBehavior;
import com.superwall.sdk.paywall.view.webview.messaging.PaywallMessage;
import com.superwall.sdk.permissions.PermissionType;
import com.superwall.sdk.storage.core_data.ConvertersKt;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonKt;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class PaywallMessageKt {
    private static final Json json = JsonKt.b(null, new Function1() { // from class: com.superwall.sdk.paywall.view.webview.messaging.g
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return PaywallMessageKt.json$lambda$0((JsonBuilder) obj);
        }
    }, 1, null);

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit json$lambda$0(JsonBuilder Json) {
        Intrinsics.checkNotNullParameter(Json, "$this$Json");
        Json.h(true);
        return Unit.f139807a;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static final PaywallMessage parsePaywallMessage(JsonObject jsonObject) {
        JsonPrimitive jsonPrimitiveP;
        Long lS;
        JsonPrimitive jsonPrimitiveP2;
        String strG;
        JsonPrimitive jsonPrimitiveP3;
        String strG2;
        JsonPrimitive jsonPrimitiveP4;
        String strG3;
        JsonPrimitive jsonPrimitiveP5;
        String strG4;
        JsonPrimitive jsonPrimitiveP6;
        JsonPrimitive jsonPrimitiveP7;
        String strG5;
        JsonPrimitive jsonPrimitiveP8;
        String strG6;
        JsonPrimitive jsonPrimitiveP9;
        String strG7;
        JsonPrimitive jsonPrimitiveP10;
        String strG8;
        JsonPrimitive jsonPrimitiveP11;
        String strG9;
        JsonPrimitive jsonPrimitiveP12;
        String strG10;
        JsonObject jsonObjectO;
        JsonPrimitive jsonPrimitiveP13;
        JsonPrimitive jsonPrimitiveP14;
        JsonPrimitive jsonPrimitiveP15;
        JsonPrimitive jsonPrimitiveP16;
        Boolean boolF;
        JsonPrimitive jsonPrimitiveP17;
        String strG11;
        PaywallMessage.HapticFeedback.HapticType hapticTypeFromRaw;
        Object obj = jsonObject.get("event_name");
        Intrinsics.checkNotNull(obj);
        String strA = JsonElementKt.p((JsonElement) obj).a();
        String strG12 = null;
        numM = null;
        Integer numM = null;
        map = null;
        map = null;
        Map map = null;
        browserType = null;
        browserType = null;
        browserType = null;
        PaywallMessage.OpenUrl.BrowserType browserType = null;
        strG12 = null;
        switch (strA.hashCode()) {
            case -1673359981:
                if (strA.equals("schedule_notification")) {
                    JsonElement jsonElement = (JsonElement) jsonObject.get("type");
                    if (jsonElement != null && (jsonPrimitiveP6 = JsonElementKt.p(jsonElement)) != null) {
                        strG12 = JsonElementKt.g(jsonPrimitiveP6);
                    }
                    LocalNotificationType localNotificationType = Intrinsics.areEqual(strG12, "TRIAL_STARTED") ? LocalNotificationType.TrialStarted.INSTANCE : LocalNotificationType.Unsupported.INSTANCE;
                    JsonElement jsonElement2 = (JsonElement) jsonObject.get("id");
                    String str = (jsonElement2 == null || (jsonPrimitiveP5 = JsonElementKt.p(jsonElement2)) == null || (strG4 = JsonElementKt.g(jsonPrimitiveP5)) == null) ? "" : strG4;
                    JsonElement jsonElement3 = (JsonElement) jsonObject.get("title");
                    String str2 = (jsonElement3 == null || (jsonPrimitiveP4 = JsonElementKt.p(jsonElement3)) == null || (strG3 = JsonElementKt.g(jsonPrimitiveP4)) == null) ? "" : strG3;
                    JsonElement jsonElement4 = (JsonElement) jsonObject.get("subtitle");
                    String str3 = (jsonElement4 == null || (jsonPrimitiveP3 = JsonElementKt.p(jsonElement4)) == null || (strG2 = JsonElementKt.g(jsonPrimitiveP3)) == null) ? "" : strG2;
                    JsonElement jsonElement5 = (JsonElement) jsonObject.get("body");
                    String str4 = (jsonElement5 == null || (jsonPrimitiveP2 = JsonElementKt.p(jsonElement5)) == null || (strG = JsonElementKt.g(jsonPrimitiveP2)) == null) ? "" : strG;
                    JsonElement jsonElement6 = (JsonElement) jsonObject.get("delay");
                    return new PaywallMessage.ScheduleNotification(str, localNotificationType, str2, str3, str4, (jsonElement6 == null || (jsonPrimitiveP = JsonElementKt.p(jsonElement6)) == null || (lS = JsonElementKt.s(jsonPrimitiveP)) == null) ? 0L : lS.longValue());
                }
                break;
            case -1569165660:
                if (strA.equals("user_attribute_updated")) {
                    Object obj2 = jsonObject.get("attributes");
                    Intrinsics.checkNotNull(obj2);
                    Object objConvertFromJsonElement = ConvertersKt.convertFromJsonElement(JsonElementKt.n((JsonElement) obj2));
                    Intrinsics.checkNotNull(objConvertFromJsonElement, "null cannot be cast to non-null type kotlin.collections.List<kotlin.collections.Map<kotlin.String, kotlin.Any>>");
                    List<Map> list = (List) objConvertFromJsonElement;
                    LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list, 10)), 16));
                    for (Map map2 : list) {
                        Object obj3 = map2.get("key");
                        Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.String");
                        String str5 = (String) obj3;
                        Object obj4 = map2.get("value");
                        if (obj4 == null) {
                            obj4 = "";
                        }
                        Pair pairA = TuplesKt.a(str5, obj4);
                        linkedHashMap.put(pairA.e(), pairA.f());
                    }
                    return new PaywallMessage.UserAttributesUpdated(linkedHashMap);
                }
                break;
            case -1539915881:
                if (strA.equals("custom_placement")) {
                    Object obj5 = jsonObject.get("name");
                    Intrinsics.checkNotNull(obj5);
                    String strA2 = JsonElementKt.p((JsonElement) obj5).a();
                    Object obj6 = jsonObject.get(NativeProtocol.WEB_DIALOG_PARAMS);
                    Intrinsics.checkNotNull(obj6);
                    return new PaywallMessage.CustomPlacement(strA2, JsonElementKt.o((JsonElement) obj6));
                }
                break;
            case -1349088399:
                if (strA.equals("custom")) {
                    Object obj7 = jsonObject.get("data");
                    Intrinsics.checkNotNull(obj7);
                    return new PaywallMessage.Custom(JsonElementKt.p((JsonElement) obj7).a());
                }
                break;
            case -561690241:
                if (strA.equals("request_permission")) {
                    JsonElement jsonElement7 = (JsonElement) jsonObject.get("permission_type");
                    if (jsonElement7 == null || (jsonPrimitiveP7 = JsonElementKt.p(jsonElement7)) == null || (strG5 = JsonElementKt.g(jsonPrimitiveP7)) == null) {
                        throw new IllegalArgumentException("request_permission missing permission_type");
                    }
                    PermissionType permissionTypeFromRaw = PermissionType.Companion.fromRaw(strG5);
                    if (permissionTypeFromRaw == null) {
                        throw new IllegalArgumentException("Unknown permission_type: " + strG5);
                    }
                    JsonElement jsonElement8 = (JsonElement) jsonObject.get("request_id");
                    if (jsonElement8 == null || (jsonPrimitiveP8 = JsonElementKt.p(jsonElement8)) == null || (strG6 = JsonElementKt.g(jsonPrimitiveP8)) == null) {
                        throw new IllegalArgumentException("request_permission missing request_id");
                    }
                    return new PaywallMessage.RequestPermission(permissionTypeFromRaw, strG6);
                }
                break;
            case -504306182:
                if (strA.equals("open_url")) {
                    Object obj8 = jsonObject.get("url");
                    Intrinsics.checkNotNull(obj8);
                    URI uri = new URI(JsonElementKt.p((JsonElement) obj8).a());
                    JsonElement jsonElement9 = (JsonElement) jsonObject.get("browser_type");
                    if (jsonElement9 != null && (jsonPrimitiveP9 = JsonElementKt.p(jsonElement9)) != null && (strG7 = JsonElementKt.g(jsonPrimitiveP9)) != null) {
                        PaywallMessage.OpenUrl.BrowserType browserType2 = PaywallMessage.OpenUrl.BrowserType.PAYMENT_SHEET;
                        if (Intrinsics.areEqual(strG7, browserType2.getRawName())) {
                            browserType = browserType2;
                        }
                    }
                    return new PaywallMessage.OpenUrl(uri, browserType);
                }
                break;
            case 3441010:
                if (strA.equals("ping")) {
                    Object obj9 = jsonObject.get("version");
                    Intrinsics.checkNotNull(obj9);
                    return new PaywallMessage.OnReady(JsonElementKt.p((JsonElement) obj9).a());
                }
                break;
            case 94756344:
                if (strA.equals("close")) {
                    return PaywallMessage.Close.INSTANCE;
                }
                break;
            case 651675760:
                if (strA.equals("open_url_external")) {
                    Object obj10 = jsonObject.get("url");
                    Intrinsics.checkNotNull(obj10);
                    return new PaywallMessage.OpenUrlInBrowser(new URI(JsonElementKt.p((JsonElement) obj10).a()));
                }
                break;
            case 864604149:
                if (strA.equals("request_callback")) {
                    JsonElement jsonElement10 = (JsonElement) jsonObject.get("request_id");
                    if (jsonElement10 == null || (jsonPrimitiveP10 = JsonElementKt.p(jsonElement10)) == null || (strG8 = JsonElementKt.g(jsonPrimitiveP10)) == null) {
                        throw new IllegalArgumentException("request_callback missing request_id");
                    }
                    JsonElement jsonElement11 = (JsonElement) jsonObject.get("name");
                    if (jsonElement11 == null || (jsonPrimitiveP11 = JsonElementKt.p(jsonElement11)) == null || (strG9 = JsonElementKt.g(jsonPrimitiveP11)) == null) {
                        throw new IllegalArgumentException("request_callback missing name");
                    }
                    JsonElement jsonElement12 = (JsonElement) jsonObject.get("behavior");
                    if (jsonElement12 == null || (jsonPrimitiveP12 = JsonElementKt.p(jsonElement12)) == null || (strG10 = JsonElementKt.g(jsonPrimitiveP12)) == null) {
                        throw new IllegalArgumentException("request_callback missing behavior");
                    }
                    CustomCallbackBehavior customCallbackBehaviorFromRaw = CustomCallbackBehavior.Companion.fromRaw(strG10);
                    if (customCallbackBehaviorFromRaw == null) {
                        throw new IllegalArgumentException("Unknown behavior: " + strG10);
                    }
                    JsonElement jsonElement13 = (JsonElement) jsonObject.get("variables");
                    if (jsonElement13 != null && (jsonObjectO = JsonElementKt.o(jsonElement13)) != null) {
                        Object objConvertFromJsonElement2 = ConvertersKt.convertFromJsonElement(jsonObjectO);
                        if (objConvertFromJsonElement2 instanceof Map) {
                            map = (Map) objConvertFromJsonElement2;
                        }
                    }
                    return new PaywallMessage.RequestCallback(strG8, strG9, customCallbackBehaviorFromRaw, map);
                }
                break;
            case 883937877:
                if (strA.equals("page_view")) {
                    Object obj11 = jsonObject.get("page_node_id");
                    Intrinsics.checkNotNull(obj11);
                    String strA3 = JsonElementKt.p((JsonElement) obj11).a();
                    Object obj12 = jsonObject.get("flow_position");
                    Intrinsics.checkNotNull(obj12);
                    int iL = JsonElementKt.l(JsonElementKt.p((JsonElement) obj12));
                    Object obj13 = jsonObject.get("page_name");
                    Intrinsics.checkNotNull(obj13);
                    String strA4 = JsonElementKt.p((JsonElement) obj13).a();
                    Object obj14 = jsonObject.get("navigation_node_id");
                    Intrinsics.checkNotNull(obj14);
                    String strA5 = JsonElementKt.p((JsonElement) obj14).a();
                    JsonElement jsonElement14 = (JsonElement) jsonObject.get("previous_page_node_id");
                    String strG13 = (jsonElement14 == null || (jsonPrimitiveP15 = JsonElementKt.p(jsonElement14)) == null) ? null : JsonElementKt.g(jsonPrimitiveP15);
                    JsonElement jsonElement15 = (JsonElement) jsonObject.get("previous_flow_position");
                    Integer numM2 = (jsonElement15 == null || (jsonPrimitiveP14 = JsonElementKt.p(jsonElement15)) == null) ? null : JsonElementKt.m(jsonPrimitiveP14);
                    Object obj15 = jsonObject.get("type");
                    Intrinsics.checkNotNull(obj15);
                    String strA6 = JsonElementKt.p((JsonElement) obj15).a();
                    JsonElement jsonElement16 = (JsonElement) jsonObject.get("time_on_previous_page_ms");
                    if (jsonElement16 != null && (jsonPrimitiveP13 = JsonElementKt.p(jsonElement16)) != null) {
                        numM = JsonElementKt.m(jsonPrimitiveP13);
                    }
                    return new PaywallMessage.PageView(new PageViewData(strA3, iL, strA4, strA5, strG13, numM2, strA6, numM));
                }
                break;
            case 1097519758:
                if (strA.equals("restore")) {
                    return PaywallMessage.Restore.INSTANCE;
                }
                break;
            case 1742914598:
                if (strA.equals("request_store_review")) {
                    Object obj16 = jsonObject.get("review_type");
                    Intrinsics.checkNotNull(obj16);
                    String strA7 = JsonElementKt.p((JsonElement) obj16).a();
                    return new PaywallMessage.RequestReview(Intrinsics.areEqual(strA7, "external") ? PaywallMessage.RequestReview.Type.EXTERNAL : Intrinsics.areEqual(strA7, "in-app") ? PaywallMessage.RequestReview.Type.INAPP : PaywallMessage.RequestReview.Type.INAPP);
                }
                break;
            case 1743324417:
                if (strA.equals("purchase")) {
                    Object obj17 = jsonObject.get(AppLovinEventTypes.USER_VIEWED_PRODUCT);
                    Intrinsics.checkNotNull(obj17);
                    String strA8 = JsonElementKt.p((JsonElement) obj17).a();
                    Object obj18 = jsonObject.get(EntitlementsResponseJsonKeys.PRODUCT_IDENTIFIER);
                    Intrinsics.checkNotNull(obj18);
                    String strA9 = JsonElementKt.p((JsonElement) obj18).a();
                    JsonElement jsonElement17 = (JsonElement) jsonObject.get("should_dismiss");
                    return new PaywallMessage.Purchase(strA8, strA9, (jsonElement17 == null || (jsonPrimitiveP16 = JsonElementKt.p(jsonElement17)) == null || (boolF = JsonElementKt.f(jsonPrimitiveP16)) == null) ? true : boolF.booleanValue());
                }
                break;
            case 1882031149:
                if (strA.equals("haptic_feedback")) {
                    JsonElement jsonElement18 = (JsonElement) jsonObject.get("haptic_type");
                    if (jsonElement18 == null || (jsonPrimitiveP17 = JsonElementKt.p(jsonElement18)) == null || (strG11 = JsonElementKt.g(jsonPrimitiveP17)) == null || (hapticTypeFromRaw = PaywallMessage.HapticFeedback.HapticType.Companion.fromRaw(strG11)) == null) {
                        throw new IllegalArgumentException("haptic_feedback missing or unknown haptic_type");
                    }
                    return new PaywallMessage.HapticFeedback(hapticTypeFromRaw);
                }
                break;
            case 2097998776:
                if (strA.equals("open_deep_link")) {
                    Object obj19 = jsonObject.get("link");
                    Intrinsics.checkNotNull(obj19);
                    return new PaywallMessage.OpenDeepLink(new URI(JsonElementKt.p((JsonElement) obj19).a()));
                }
                break;
        }
        Logger.debug$default(Logger.INSTANCE, LogLevel.warn, LogScope.superwallCore, "Skipping paywall message with unknown event name: " + strA, (Map) null, (Throwable) null, 24, (Object) null);
        return null;
    }

    public static final Object parseWrappedPaywallMessages(String jsonString) {
        JsonPrimitive jsonPrimitiveP;
        Integer numM;
        Intrinsics.checkNotNullParameter(jsonString, "jsonString");
        try {
            Logger.debug$default(Logger.INSTANCE, LogLevel.debug, LogScope.superwallCore, "SWWebViewInterface " + jsonString, (Map) null, (Throwable) null, 24, (Object) null);
            JsonObject jsonObjectO = JsonElementKt.o(json.h(jsonString));
            JsonElement jsonElement = (JsonElement) jsonObjectO.get("version");
            int iIntValue = (jsonElement == null || (jsonPrimitiveP = JsonElementKt.p(jsonElement)) == null || (numM = JsonElementKt.m(jsonPrimitiveP)) == null) ? 1 : numM.intValue();
            Object obj = jsonObjectO.get("payload");
            Intrinsics.checkNotNull(obj);
            Object obj2 = JsonElementKt.o((JsonElement) obj).get("events");
            Intrinsics.checkNotNull(obj2);
            JsonArray jsonArrayN = JsonElementKt.n((JsonElement) obj2);
            ArrayList arrayList = new ArrayList();
            Iterator it = jsonArrayN.iterator();
            while (it.hasNext()) {
                PaywallMessage paywallMessage = parsePaywallMessage(JsonElementKt.o((JsonElement) it.next()));
                if (paywallMessage != null) {
                    arrayList.add(paywallMessage);
                }
            }
            Result.Companion companion = Result.f139772b;
            return Result.b(new WrappedPaywallMessages(iIntValue, new PayloadMessages(arrayList)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.f139772b;
            return Result.b(ResultKt.a(th));
        }
    }
}
