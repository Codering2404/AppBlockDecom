package com.facebook.appevents.internal;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import androidx.media3.exoplayer.audio.wRw.CbYNFSEGaQj;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.appevents.OperationalData;
import com.facebook.appevents.OperationalDataEnum;
import com.facebook.appevents.iap.InAppPurchase;
import com.facebook.appevents.iap.InAppPurchaseManager;
import com.facebook.appevents.iap.InAppPurchaseUtils;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.ServerProtocol;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class AutomaticAnalyticsLogger {
    private static final String APP_EVENTS_IF_AUTO_LOG_SUBS = "app_events_if_auto_log_subs";
    public static final AutomaticAnalyticsLogger INSTANCE = new AutomaticAnalyticsLogger();
    private static final String TAG = AutomaticAnalyticsLogger.class.getCanonicalName();
    private static final InternalAppEventsLogger internalAppEventsLogger = new InternalAppEventsLogger(FacebookSdk.getApplicationContext());

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class PurchaseLoggingParameters {
        private Currency currency;
        private OperationalData operationalData;
        private Bundle param;
        private BigDecimal purchaseAmount;

        public PurchaseLoggingParameters(BigDecimal purchaseAmount, Currency currency, Bundle param, OperationalData operationalData) {
            Intrinsics.checkNotNullParameter(purchaseAmount, "purchaseAmount");
            Intrinsics.checkNotNullParameter(currency, "currency");
            Intrinsics.checkNotNullParameter(param, "param");
            Intrinsics.checkNotNullParameter(operationalData, "operationalData");
            this.purchaseAmount = purchaseAmount;
            this.currency = currency;
            this.param = param;
            this.operationalData = operationalData;
        }

        public final Currency getCurrency() {
            return this.currency;
        }

        public final OperationalData getOperationalData() {
            return this.operationalData;
        }

        public final Bundle getParam() {
            return this.param;
        }

        public final BigDecimal getPurchaseAmount() {
            return this.purchaseAmount;
        }

        public final void setCurrency(Currency currency) {
            Intrinsics.checkNotNullParameter(currency, "<set-?>");
            this.currency = currency;
        }

        public final void setOperationalData(OperationalData operationalData) {
            Intrinsics.checkNotNullParameter(operationalData, "<set-?>");
            this.operationalData = operationalData;
        }

        public final void setParam(Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "<set-?>");
            this.param = bundle;
        }

        public final void setPurchaseAmount(BigDecimal bigDecimal) {
            Intrinsics.checkNotNullParameter(bigDecimal, "<set-?>");
            this.purchaseAmount = bigDecimal;
        }
    }

    private AutomaticAnalyticsLogger() {
    }

    @JvmStatic
    public static final synchronized Bundle getPurchaseDedupeParameters(List<PurchaseLoggingParameters> purchaseLoggingParametersList) {
        PurchaseLoggingParameters purchaseLoggingParameters;
        Intrinsics.checkNotNullParameter(purchaseLoggingParametersList, "purchaseLoggingParametersList");
        purchaseLoggingParameters = purchaseLoggingParametersList.get(0);
        return InAppPurchaseManager.performDedupe(CollectionsKt.listOf(new InAppPurchase(AppEventsConstants.EVENT_NAME_PURCHASED, purchaseLoggingParameters.getPurchaseAmount().doubleValue(), purchaseLoggingParameters.getCurrency())), System.currentTimeMillis(), true, CollectionsKt.listOf(new Pair(purchaseLoggingParameters.getParam(), purchaseLoggingParameters.getOperationalData())));
    }

    private final List<PurchaseLoggingParameters> getPurchaseLoggingParameters(String str, String str2, InAppPurchaseUtils.BillingClientVersion billingClientVersion) {
        return getPurchaseLoggingParameters(str, str2, new HashMap(), billingClientVersion);
    }

    private final List<PurchaseLoggingParameters> getPurchaseParametersGPBLV5V7(String str, Bundle bundle, OperationalData operationalData, JSONObject jSONObject) throws JSONException {
        if (!Intrinsics.areEqual(str, InAppPurchaseUtils.IAPProductType.SUBS.getType())) {
            JSONObject jSONObject2 = jSONObject.getJSONObject(Constants.GP_IAP_ONE_TIME_PURCHASE_OFFER_DETAILS);
            if (jSONObject2 == null) {
                return null;
            }
            BigDecimal bigDecimal = new BigDecimal(jSONObject2.getLong(Constants.GP_IAP_PRICE_AMOUNT_MICROS_V5V7) / 1000000.0d);
            Currency currency = Currency.getInstance(jSONObject2.getString(Constants.GP_IAP_PRICE_CURRENCY_CODE_V5V7));
            Intrinsics.checkNotNullExpressionValue(currency, "getInstance(oneTimePurch…RICE_CURRENCY_CODE_V5V7))");
            return CollectionsKt.mutableListOf(new PurchaseLoggingParameters(bigDecimal, currency, bundle, operationalData));
        }
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArray = jSONObject.getJSONArray(Constants.GP_IAP_SUBSCRIPTION_OFFER_DETAILS);
        if (jSONArray == null) {
            return null;
        }
        int length = jSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            JSONObject jSONObject3 = jSONObject.getJSONArray(Constants.GP_IAP_SUBSCRIPTION_OFFER_DETAILS).getJSONObject(i3);
            if (jSONObject3 == null) {
                return null;
            }
            Bundle bundle2 = new Bundle(bundle);
            OperationalData operationalDataCopy = operationalData.copy();
            String basePlanId = jSONObject3.getString(Constants.GP_IAP_BASE_PLAN_ID);
            OperationalData.Companion companion = OperationalData.Companion;
            OperationalDataEnum operationalDataEnum = OperationalDataEnum.IAPParameters;
            Intrinsics.checkNotNullExpressionValue(basePlanId, "basePlanId");
            companion.addParameter(operationalDataEnum, Constants.IAP_BASE_PLAN, basePlanId, bundle2, operationalDataCopy);
            JSONObject jSONObject4 = jSONObject3.getJSONArray(Constants.GP_IAP_SUBSCRIPTION_PRICING_PHASES).getJSONObject(r11.length() - 1);
            if (jSONObject4 == null) {
                return null;
            }
            String strOptString = jSONObject4.optString(Constants.GP_IAP_BILLING_PERIOD);
            Intrinsics.checkNotNullExpressionValue(strOptString, "subscriptionJSON.optStri…IOD\n                    )");
            companion.addParameter(operationalDataEnum, Constants.IAP_SUBSCRIPTION_PERIOD, strOptString, bundle2, operationalDataCopy);
            if (!jSONObject4.has(Constants.GP_IAP_RECURRENCE_MODE) || jSONObject4.getInt(Constants.GP_IAP_RECURRENCE_MODE) == 3) {
                companion.addParameter(operationalDataEnum, Constants.IAP_SUBSCRIPTION_AUTORENEWING, "false", bundle2, operationalDataCopy);
            } else {
                companion.addParameter(operationalDataEnum, Constants.IAP_SUBSCRIPTION_AUTORENEWING, ServerProtocol.DIALOG_RETURN_SCOPES_TRUE, bundle2, operationalDataCopy);
            }
            BigDecimal bigDecimal2 = new BigDecimal(jSONObject4.getLong(Constants.GP_IAP_PRICE_AMOUNT_MICROS_V5V7) / 1000000.0d);
            Currency currency2 = Currency.getInstance(jSONObject4.getString(Constants.GP_IAP_PRICE_CURRENCY_CODE_V5V7));
            Intrinsics.checkNotNullExpressionValue(currency2, "getInstance(subscription…RICE_CURRENCY_CODE_V5V7))");
            arrayList.add(new PurchaseLoggingParameters(bigDecimal2, currency2, bundle2, operationalDataCopy));
        }
        return arrayList;
    }

    @JvmStatic
    public static final synchronized Bundle getSubscriptionDedupeParameters(List<PurchaseLoggingParameters> purchaseLoggingParametersList, String eventName) {
        ArrayList arrayList;
        long jCurrentTimeMillis;
        ArrayList arrayList2;
        try {
            Intrinsics.checkNotNullParameter(purchaseLoggingParametersList, "purchaseLoggingParametersList");
            Intrinsics.checkNotNullParameter(eventName, "eventName");
            arrayList = new ArrayList();
            for (PurchaseLoggingParameters purchaseLoggingParameters : purchaseLoggingParametersList) {
                arrayList.add(new InAppPurchase(eventName, purchaseLoggingParameters.getPurchaseAmount().doubleValue(), purchaseLoggingParameters.getCurrency()));
            }
            jCurrentTimeMillis = System.currentTimeMillis();
            List<PurchaseLoggingParameters> list = purchaseLoggingParametersList;
            arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (PurchaseLoggingParameters purchaseLoggingParameters2 : list) {
                arrayList2.add(new Pair(purchaseLoggingParameters2.getParam(), purchaseLoggingParameters2.getOperationalData()));
            }
        } catch (Throwable th) {
            throw th;
        }
        return InAppPurchaseManager.performDedupe(arrayList, jCurrentTimeMillis, true, arrayList2);
    }

    @JvmStatic
    public static final boolean isImplicitPurchaseLoggingEnabled() {
        FetchedAppSettings appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId());
        return appSettingsWithoutQuery != null && FacebookSdk.getAutoLogAppEventsEnabled() && appSettingsWithoutQuery.getIAPAutomaticLoggingEnabled();
    }

    @JvmStatic
    public static final void logActivateAppEvent() {
        Context applicationContext = FacebookSdk.getApplicationContext();
        String applicationId = FacebookSdk.getApplicationId();
        if (FacebookSdk.getAutoLogAppEventsEnabled()) {
            if (applicationContext instanceof Application) {
                AppEventsLogger.Companion.activateApp((Application) applicationContext, applicationId);
            } else {
                Log.w(TAG, "Automatic logging of basic events will not happen, because FacebookSdk.getApplicationContext() returns object that is not instance of android.app.Application. Make sure you call FacebookSdk.sdkInitialize() from Application class and pass application context.");
            }
        }
    }

    @JvmStatic
    public static final void logActivityTimeSpentEvent(String str, long j3) {
        Context applicationContext = FacebookSdk.getApplicationContext();
        FetchedAppSettings fetchedAppSettingsQueryAppSettings = FetchedAppSettingsManager.queryAppSettings(FacebookSdk.getApplicationId(), false);
        if (fetchedAppSettingsQueryAppSettings == null || !fetchedAppSettingsQueryAppSettings.getAutomaticLoggingEnabled() || j3 <= 0) {
            return;
        }
        InternalAppEventsLogger internalAppEventsLogger2 = new InternalAppEventsLogger(applicationContext);
        Bundle bundle = new Bundle(1);
        bundle.putCharSequence(Constants.AA_TIME_SPENT_SCREEN_PARAMETER_NAME, str);
        internalAppEventsLogger2.logEvent(Constants.AA_TIME_SPENT_EVENT_NAME, j3, bundle);
    }

    public static /* synthetic */ void logPurchase$default(String str, String str2, boolean z2, InAppPurchaseUtils.BillingClientVersion billingClientVersion, boolean z3, int i3, Object obj) {
        if ((i3 & 16) != 0) {
            z3 = false;
        }
        logPurchase(str, str2, z2, billingClientVersion, z3);
    }

    private final List<PurchaseLoggingParameters> getPurchaseLoggingParameters(String str, String str2, Map<String, String> map, InAppPurchaseUtils.BillingClientVersion billingClientVersion) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = new JSONObject(str2);
            Bundle bundle = new Bundle(1);
            OperationalData operationalData = new OperationalData();
            if (billingClientVersion != null) {
                OperationalData.Companion.addParameter(OperationalDataEnum.IAPParameters, Constants.IAP_AUTOLOG_IMPLEMENTATION, billingClientVersion.getType(), bundle, operationalData);
            }
            OperationalData.Companion companion = OperationalData.Companion;
            OperationalDataEnum operationalDataEnum = OperationalDataEnum.IAPParameters;
            String string = jSONObject.getString("productId");
            Intrinsics.checkNotNullExpressionValue(string, "purchaseJSON.getString(C…stants.GP_IAP_PRODUCT_ID)");
            companion.addParameter(operationalDataEnum, Constants.IAP_PRODUCT_ID, string, bundle, operationalData);
            String string2 = jSONObject.getString("productId");
            Intrinsics.checkNotNullExpressionValue(string2, "purchaseJSON.getString(C…stants.GP_IAP_PRODUCT_ID)");
            companion.addParameter(operationalDataEnum, AppEventsConstants.EVENT_PARAM_CONTENT_ID, string2, bundle, operationalData);
            companion.addParameter(operationalDataEnum, Constants.ANDROID_DYNAMIC_ADS_CONTENT_ID, "client_implicit", bundle, operationalData);
            String string3 = jSONObject.getString(Constants.GP_IAP_PURCHASE_TIME);
            Intrinsics.checkNotNullExpressionValue(string3, "purchaseJSON.getString(C…nts.GP_IAP_PURCHASE_TIME)");
            companion.addParameter(operationalDataEnum, Constants.IAP_PURCHASE_TIME, string3, bundle, operationalData);
            String string4 = jSONObject.getString("purchaseToken");
            Intrinsics.checkNotNullExpressionValue(string4, "purchaseJSON.getString(C…ts.GP_IAP_PURCHASE_TOKEN)");
            companion.addParameter(operationalDataEnum, Constants.IAP_PURCHASE_TOKEN, string4, bundle, operationalData);
            String strOptString = jSONObject.optString("packageName");
            Intrinsics.checkNotNullExpressionValue(strOptString, "purchaseJSON.optString(C…ants.GP_IAP_PACKAGE_NAME)");
            companion.addParameter(operationalDataEnum, Constants.IAP_PACKAGE_NAME, strOptString, bundle, operationalData);
            String strOptString2 = jSONObject2.optString("title");
            Intrinsics.checkNotNullExpressionValue(strOptString2, "skuDetailsJSON.optString(Constants.GP_IAP_TITLE)");
            companion.addParameter(operationalDataEnum, Constants.IAP_PRODUCT_TITLE, strOptString2, bundle, operationalData);
            String strOptString3 = jSONObject2.optString("description");
            Intrinsics.checkNotNullExpressionValue(strOptString3, "skuDetailsJSON.optString…tants.GP_IAP_DESCRIPTION)");
            companion.addParameter(operationalDataEnum, Constants.IAP_PRODUCT_DESCRIPTION, strOptString3, bundle, operationalData);
            String type = jSONObject2.optString("type");
            Intrinsics.checkNotNullExpressionValue(type, "type");
            companion.addParameter(operationalDataEnum, Constants.IAP_PRODUCT_TYPE, type, bundle, operationalData);
            String specificBillingLibraryVersion = InAppPurchaseManager.getSpecificBillingLibraryVersion();
            if (specificBillingLibraryVersion != null) {
                companion.addParameter(operationalDataEnum, Constants.IAP_BILLING_LIBRARY_VERSION, specificBillingLibraryVersion, bundle, operationalData);
            }
            for (Map.Entry<String, String> entry : map.entrySet()) {
                OperationalData.Companion.addParameter(OperationalDataEnum.IAPParameters, entry.getKey(), entry.getValue(), bundle, operationalData);
            }
            if (jSONObject2.has(Constants.GP_IAP_PRICE_AMOUNT_MICROS_V2V4)) {
                return CollectionsKt.mutableListOf(getPurchaseParametersGPBLV2V4(type, bundle, operationalData, jSONObject, jSONObject2));
            }
            if (!jSONObject2.has(Constants.GP_IAP_SUBSCRIPTION_OFFER_DETAILS) && !jSONObject2.has(Constants.GP_IAP_ONE_TIME_PURCHASE_OFFER_DETAILS)) {
                return null;
            }
            try {
                return getPurchaseParametersGPBLV5V7(type, bundle, operationalData, jSONObject2);
            } catch (JSONException e3) {
                e = e3;
                Log.e(TAG, "Error parsing in-app purchase/subscription data.", e);
                return null;
            } catch (Exception e4) {
                e = e4;
                Log.e(TAG, "Failed to get purchase logging parameters,", e);
                return null;
            }
        } catch (JSONException e5) {
            e = e5;
        } catch (Exception e6) {
            e = e6;
        }
    }

    private final PurchaseLoggingParameters getPurchaseParametersGPBLV2V4(String str, Bundle bundle, OperationalData operationalData, JSONObject jSONObject, JSONObject jSONObject2) {
        Bundle bundle2;
        OperationalData operationalData2;
        if (Intrinsics.areEqual(str, InAppPurchaseUtils.IAPProductType.SUBS.getType())) {
            OperationalData.Companion companion = OperationalData.Companion;
            OperationalDataEnum operationalDataEnum = OperationalDataEnum.IAPParameters;
            String string = Boolean.toString(jSONObject.optBoolean(CbYNFSEGaQj.NbbZpWNwvctMz, false));
            Intrinsics.checkNotNullExpressionValue(string, "toString(\n              …      )\n                )");
            bundle2 = bundle;
            operationalData2 = operationalData;
            companion.addParameter(operationalDataEnum, Constants.IAP_SUBSCRIPTION_AUTORENEWING, string, bundle2, operationalData2);
            String strOptString = jSONObject2.optString(Constants.GP_IAP_SUBSCRIPTION_PERIOD);
            Intrinsics.checkNotNullExpressionValue(strOptString, "skuDetailsJSON.optString…_IAP_SUBSCRIPTION_PERIOD)");
            companion.addParameter(operationalDataEnum, Constants.IAP_SUBSCRIPTION_PERIOD, strOptString, bundle2, operationalData2);
            String strOptString2 = jSONObject2.optString(Constants.GP_IAP_FREE_TRIAL_PERIOD);
            Intrinsics.checkNotNullExpressionValue(strOptString2, "skuDetailsJSON.optString…GP_IAP_FREE_TRIAL_PERIOD)");
            companion.addParameter(operationalDataEnum, Constants.IAP_FREE_TRIAL_PERIOD, strOptString2, bundle2, operationalData2);
            String introductoryPriceCycles = jSONObject2.optString(Constants.GP_IAP_INTRODUCTORY_PRICE_CYCLES);
            Intrinsics.checkNotNullExpressionValue(introductoryPriceCycles, "introductoryPriceCycles");
            if (introductoryPriceCycles.length() > 0) {
                companion.addParameter(operationalDataEnum, Constants.IAP_INTRO_PRICE_CYCLES, introductoryPriceCycles, bundle2, operationalData2);
            }
            String introductoryPricePeriod = jSONObject2.optString(Constants.GP_IAP_INTRODUCTORY_PRICE_PERIOD);
            Intrinsics.checkNotNullExpressionValue(introductoryPricePeriod, "introductoryPricePeriod");
            if (introductoryPricePeriod.length() > 0) {
                companion.addParameter(operationalDataEnum, Constants.IAP_INTRO_PERIOD, introductoryPricePeriod, bundle2, operationalData2);
            }
            String introductoryPriceAmountMicros = jSONObject2.optString(Constants.GP_IAP_INTRODUCTORY_PRICE_AMOUNT_MICROS);
            Intrinsics.checkNotNullExpressionValue(introductoryPriceAmountMicros, "introductoryPriceAmountMicros");
            if (introductoryPriceAmountMicros.length() > 0) {
                companion.addParameter(operationalDataEnum, Constants.IAP_INTRO_PRICE_AMOUNT_MICROS, introductoryPriceAmountMicros, bundle2, operationalData2);
            }
        } else {
            bundle2 = bundle;
            operationalData2 = operationalData;
        }
        BigDecimal bigDecimal = new BigDecimal(jSONObject2.getLong(Constants.GP_IAP_PRICE_AMOUNT_MICROS_V2V4) / 1000000.0d);
        Currency currency = Currency.getInstance(jSONObject2.getString(Constants.GP_IAP_PRICE_CURRENCY_CODE_V2V4));
        Intrinsics.checkNotNullExpressionValue(currency, "getInstance(skuDetailsJS…RICE_CURRENCY_CODE_V2V4))");
        return new PurchaseLoggingParameters(bigDecimal, currency, bundle2, operationalData2);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ba  */
    @kotlin.jvm.JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void logPurchase(java.lang.String r7, java.lang.String r8, boolean r9, com.facebook.appevents.iap.InAppPurchaseUtils.BillingClientVersion r10, boolean r11) {
        /*
            Method dump skipped, instruction units count: 232
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.internal.AutomaticAnalyticsLogger.logPurchase(java.lang.String, java.lang.String, boolean, com.facebook.appevents.iap.InAppPurchaseUtils$BillingClientVersion, boolean):void");
    }
}
