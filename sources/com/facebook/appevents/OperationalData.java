package com.facebook.appevents;

import android.os.Bundle;
import com.facebook.FacebookException;
import com.facebook.appevents.internal.Constants;
import com.facebook.share.HKJ.pnxuebdT;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONObject;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class OperationalData {
    public static final Companion Companion = new Companion(null);
    private static final Set<String> iapOperationalAndCustomParameters;
    private static final Set<String> iapOperationalParameters;
    private static final Map<OperationalDataEnum, Pair<Set<String>, Set<String>>> parameterClassifications;
    private final Map<OperationalDataEnum, Map<String, Object>> operationalData = new LinkedHashMap();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[ParameterClassification.values().length];
                try {
                    iArr[ParameterClassification.CustomData.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[ParameterClassification.OperationalData.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[ParameterClassification.CustomAndOperationalData.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Pair<Bundle, OperationalData> addParameterAndReturn(OperationalDataEnum typeOfParameter, String key, String value, Bundle bundle, OperationalData operationalData) {
            Intrinsics.checkNotNullParameter(typeOfParameter, "typeOfParameter");
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            int i3 = WhenMappings.$EnumSwitchMapping$0[getParameterClassification(typeOfParameter, key).ordinal()];
            if (i3 == 1) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                bundle.putCharSequence(key, value);
            } else if (i3 == 2) {
                if (operationalData == null) {
                    operationalData = new OperationalData();
                }
                operationalData.addParameter(typeOfParameter, key, value);
            } else if (i3 == 3) {
                if (operationalData == null) {
                    operationalData = new OperationalData();
                }
                if (bundle == null) {
                    bundle = new Bundle();
                }
                operationalData.addParameter(typeOfParameter, key, value);
                bundle.putCharSequence(key, value);
            }
            return new Pair<>(bundle, operationalData);
        }

        public final Object getParameter(OperationalDataEnum typeOfParameter, String key, Bundle bundle, OperationalData operationalData) {
            Intrinsics.checkNotNullParameter(typeOfParameter, "typeOfParameter");
            Intrinsics.checkNotNullParameter(key, "key");
            Object parameter = operationalData != null ? operationalData.getParameter(typeOfParameter, key) : null;
            return parameter == null ? bundle != null ? bundle.getCharSequence(key) : null : parameter;
        }

        public final ParameterClassification getParameterClassification(OperationalDataEnum typeOfParameter, String parameter) {
            Intrinsics.checkNotNullParameter(typeOfParameter, "typeOfParameter");
            Intrinsics.checkNotNullParameter(parameter, "parameter");
            Pair pair = (Pair) OperationalData.parameterClassifications.get(typeOfParameter);
            Set set = pair != null ? (Set) pair.e() : null;
            Pair pair2 = (Pair) OperationalData.parameterClassifications.get(typeOfParameter);
            Set set2 = pair2 != null ? (Set) pair2.f() : null;
            return (set == null || !set.contains(parameter)) ? (set2 == null || !set2.contains(parameter)) ? ParameterClassification.CustomData : ParameterClassification.CustomAndOperationalData : ParameterClassification.OperationalData;
        }

        private Companion() {
        }

        public final void addParameter(OperationalDataEnum typeOfParameter, String str, String value, Bundle customEventsParams, OperationalData operationalData) {
            Intrinsics.checkNotNullParameter(typeOfParameter, "typeOfParameter");
            Intrinsics.checkNotNullParameter(str, pnxuebdT.crnMFd);
            Intrinsics.checkNotNullParameter(value, "value");
            Intrinsics.checkNotNullParameter(customEventsParams, "customEventsParams");
            Intrinsics.checkNotNullParameter(operationalData, "operationalData");
            int i3 = WhenMappings.$EnumSwitchMapping$0[getParameterClassification(typeOfParameter, str).ordinal()];
            if (i3 == 1) {
                customEventsParams.putCharSequence(str, value);
                return;
            }
            if (i3 == 2) {
                operationalData.addParameter(typeOfParameter, str, value);
            } else {
                if (i3 != 3) {
                    return;
                }
                operationalData.addParameter(typeOfParameter, str, value);
                customEventsParams.putCharSequence(str, value);
            }
        }
    }

    static {
        Set<String> of = SetsKt.setOf((Object[]) new String[]{Constants.IAP_PACKAGE_NAME, Constants.IAP_SUBSCRIPTION_AUTORENEWING, Constants.IAP_FREE_TRIAL_PERIOD, Constants.IAP_INTRO_PRICE_AMOUNT_MICROS, Constants.IAP_INTRO_PRICE_CYCLES, Constants.IAP_BASE_PLAN, Constants.EVENT_PARAM_IS_IMPLICIT_PURCHASE_LOGGING_ENABLED, Constants.IAP_AUTOLOG_IMPLEMENTATION, Constants.EVENT_PARAM_IS_AUTOLOG_APP_EVENTS_ENABLED, Constants.IAP_BILLING_LIBRARY_VERSION, Constants.IAP_SUBSCRIPTION_PERIOD, Constants.IAP_PURCHASE_TOKEN, Constants.IAP_NON_DEDUPED_EVENT_TIME, Constants.IAP_ACTUAL_DEDUP_RESULT, Constants.IAP_ACTUAL_DEDUP_KEY_USED, Constants.IAP_TEST_DEDUP_RESULT, Constants.IAP_TEST_DEDUP_KEY_USED});
        iapOperationalParameters = of;
        Set<String> of2 = SetsKt.setOf((Object[]) new String[]{Constants.IAP_PRODUCT_ID, Constants.IAP_PRODUCT_TYPE, Constants.IAP_PURCHASE_TIME});
        iapOperationalAndCustomParameters = of2;
        parameterClassifications = MapsKt.mapOf(TuplesKt.a(OperationalDataEnum.IAPParameters, new Pair(of, of2)));
    }

    public final void addParameter(OperationalDataEnum type, String key, Object value) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        try {
            AppEvent.Companion.validateIdentifier(key);
            if (!(value instanceof String) && !(value instanceof Number)) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.f140150a;
                String str = String.format("Parameter value '%s' for key '%s' should be a string or a numeric type.", Arrays.copyOf(new Object[]{value, key}, 2));
                Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
                throw new FacebookException(str);
            }
            if (!this.operationalData.containsKey(type)) {
                this.operationalData.put(type, new LinkedHashMap());
            }
            Map<String, Object> map = this.operationalData.get(type);
            if (map != null) {
                map.put(key, value);
            }
        } catch (Exception unused) {
        }
    }

    public final OperationalData copy() {
        OperationalData operationalData = new OperationalData();
        for (OperationalDataEnum operationalDataEnum : this.operationalData.keySet()) {
            Map<String, Object> map = this.operationalData.get(operationalDataEnum);
            if (map != null) {
                for (String str : map.keySet()) {
                    Object obj = map.get(str);
                    if (obj != null) {
                        operationalData.addParameter(operationalDataEnum, str, obj);
                    }
                }
            }
        }
        return operationalData;
    }

    public final Object getParameter(OperationalDataEnum type, String key) {
        Map<String, Object> map;
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(key, "key");
        if (this.operationalData.containsKey(type) && (map = this.operationalData.get(type)) != null) {
            return map.get(key);
        }
        return null;
    }

    public final JSONObject toJSON() {
        JSONObject jSONObject;
        try {
            Map<OperationalDataEnum, Map<String, Object>> map = this.operationalData;
            LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(map.size()));
            for (Object obj : map.entrySet()) {
                linkedHashMap.put(((OperationalDataEnum) ((Map.Entry) obj).getKey()).getValue(), ((Map.Entry) obj).getValue());
            }
            jSONObject = new JSONObject(MapsKt.toMap(linkedHashMap));
        } catch (Exception unused) {
            jSONObject = null;
        }
        return jSONObject == null ? new JSONObject() : jSONObject;
    }
}
