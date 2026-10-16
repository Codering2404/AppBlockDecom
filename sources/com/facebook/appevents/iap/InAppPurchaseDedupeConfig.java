package com.facebook.appevents.iap;

import android.os.Bundle;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.OperationalData;
import com.facebook.appevents.OperationalDataEnum;
import com.facebook.appevents.internal.Constants;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class InAppPurchaseDedupeConfig {
    public static final InAppPurchaseDedupeConfig INSTANCE = new InAppPurchaseDedupeConfig();
    private static final List<String> defaultCurrencyParameterEquivalents = CollectionsKt.listOf(AppEventsConstants.EVENT_PARAM_CURRENCY);
    private static final List<String> defaultValueParameterEquivalents = CollectionsKt.listOf(AppEventsConstants.EVENT_PARAM_VALUE_TO_SUM);
    private static final long defaultDedupeWindow = TimeUnit.MINUTES.toMillis(1);
    private static final List<Pair<String, List<String>>> defaultDedupeParameters = CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.a(Constants.IAP_PRODUCT_ID, CollectionsKt.listOf(Constants.IAP_PRODUCT_ID)), TuplesKt.a(Constants.IAP_PRODUCT_DESCRIPTION, CollectionsKt.listOf(Constants.IAP_PRODUCT_DESCRIPTION)), TuplesKt.a(Constants.IAP_PRODUCT_TITLE, CollectionsKt.listOf(Constants.IAP_PRODUCT_TITLE)), TuplesKt.a(Constants.IAP_PURCHASE_TOKEN, CollectionsKt.listOf(Constants.IAP_PURCHASE_TOKEN))});

    private InAppPurchaseDedupeConfig() {
    }

    public final Pair<Bundle, OperationalData> addDedupeParameters(Bundle bundle, Bundle bundle2, OperationalData operationalData) {
        Bundle bundle3;
        OperationalData operationalData2;
        if (bundle == null) {
            return new Pair<>(bundle2, operationalData);
        }
        try {
            bundle3 = bundle2;
            operationalData2 = operationalData;
            for (String key : bundle.keySet()) {
                try {
                    String string = bundle.getString(key);
                    if (string != null) {
                        OperationalData.Companion companion = OperationalData.Companion;
                        OperationalDataEnum operationalDataEnum = OperationalDataEnum.IAPParameters;
                        Intrinsics.checkNotNullExpressionValue(key, "key");
                        Pair<Bundle, OperationalData> pairAddParameterAndReturn = companion.addParameterAndReturn(operationalDataEnum, key, string, bundle3, operationalData2);
                        Bundle bundle4 = (Bundle) pairAddParameterAndReturn.a();
                        operationalData2 = (OperationalData) pairAddParameterAndReturn.b();
                        bundle3 = bundle4;
                    }
                } catch (Exception unused) {
                    bundle2 = bundle3;
                    operationalData = operationalData2;
                    bundle3 = bundle2;
                    operationalData2 = operationalData;
                }
            }
        } catch (Exception unused2) {
        }
        return new Pair<>(bundle3, operationalData2);
    }

    public final Currency getCurrencyOfManualEvent(Bundle bundle) {
        Iterator<String> it = getCurrencyParameterEquivalents().iterator();
        while (true) {
            String string = null;
            if (!it.hasNext()) {
                return null;
            }
            String next = it.next();
            if (bundle != null) {
                try {
                    string = bundle.getString(next);
                } catch (Exception unused) {
                    continue;
                }
            }
            if (string != null && string.length() != 0) {
                return Currency.getInstance(string);
            }
        }
    }

    public final List<String> getCurrencyParameterEquivalents() {
        FetchedAppSettings appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId());
        return ((appSettingsWithoutQuery != null ? appSettingsWithoutQuery.getCurrencyDedupeParameters() : null) == null || appSettingsWithoutQuery.getCurrencyDedupeParameters().isEmpty()) ? defaultCurrencyParameterEquivalents : appSettingsWithoutQuery.getCurrencyDedupeParameters();
    }

    public final List<Pair<String, List<String>>> getDedupeParameters(boolean z2) {
        FetchedAppSettings appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId());
        if ((appSettingsWithoutQuery != null ? appSettingsWithoutQuery.getProdDedupeParameters() : null) == null || appSettingsWithoutQuery.getProdDedupeParameters().isEmpty()) {
            return defaultDedupeParameters;
        }
        if (!z2) {
            return appSettingsWithoutQuery.getProdDedupeParameters();
        }
        ArrayList arrayList = new ArrayList();
        for (Pair<String, List<String>> pair : appSettingsWithoutQuery.getProdDedupeParameters()) {
            Iterator it = ((List) pair.f()).iterator();
            while (it.hasNext()) {
                arrayList.add(new Pair((String) it.next(), CollectionsKt.listOf(pair.e())));
            }
        }
        return arrayList;
    }

    public final long getDedupeWindow() {
        Long dedupeWindow;
        FetchedAppSettings appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId());
        return ((appSettingsWithoutQuery != null ? appSettingsWithoutQuery.getDedupeWindow() : null) == null || ((dedupeWindow = appSettingsWithoutQuery.getDedupeWindow()) != null && dedupeWindow.longValue() == 0)) ? defaultDedupeWindow : appSettingsWithoutQuery.getDedupeWindow().longValue();
    }

    public final List<Pair<String, List<String>>> getTestDedupeParameters(boolean z2) {
        List<Pair<String, List<String>>> testDedupeParameters;
        FetchedAppSettings appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId());
        if (appSettingsWithoutQuery == null || (testDedupeParameters = appSettingsWithoutQuery.getTestDedupeParameters()) == null || testDedupeParameters.isEmpty()) {
            return null;
        }
        if (!z2) {
            return appSettingsWithoutQuery.getTestDedupeParameters();
        }
        ArrayList arrayList = new ArrayList();
        for (Pair<String, List<String>> pair : appSettingsWithoutQuery.getTestDedupeParameters()) {
            Iterator it = ((List) pair.f()).iterator();
            while (it.hasNext()) {
                arrayList.add(new Pair((String) it.next(), CollectionsKt.listOf(pair.e())));
            }
        }
        return arrayList;
    }

    public final Double getValueOfManualEvent(Double d3, Bundle bundle) {
        if (d3 != null) {
            return d3;
        }
        Iterator<String> it = getValueParameterEquivalents().iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (bundle != null) {
                try {
                    return Double.valueOf(bundle.getDouble(next));
                } catch (Exception unused) {
                    continue;
                }
            }
        }
        return null;
    }

    public final List<String> getValueParameterEquivalents() {
        FetchedAppSettings appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId());
        return ((appSettingsWithoutQuery != null ? appSettingsWithoutQuery.getPurchaseValueDedupeParameters() : null) == null || appSettingsWithoutQuery.getPurchaseValueDedupeParameters().isEmpty()) ? defaultValueParameterEquivalents : appSettingsWithoutQuery.getPurchaseValueDedupeParameters();
    }
}
