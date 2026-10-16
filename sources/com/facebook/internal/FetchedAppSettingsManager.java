package com.facebook.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import androidx.compose.material.icons.twotone.Phg.QaXmqxvjHhxVy;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.codeless.internal.UnityReflection;
import com.facebook.appevents.internal.AutomaticAnalyticsLogger;
import com.facebook.appevents.internal.Constants;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.facebook.internal.FetchedAppSettings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
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
public final class FetchedAppSettingsManager {
    private static final String ANDROID_DEDUPE_KEY = "FBAndroidSDK";
    private static final String APPLICATION_FIELDS = "fields";
    private static final String APP_SETTINGS_PREFS_KEY_FORMAT = "com.facebook.internal.APP_SETTINGS.%s";
    private static final String APP_SETTINGS_PREFS_STORE = "com.facebook.internal.preferences.APP_SETTINGS";
    private static final String APP_SETTING_APP_EVENTS_CONFIG = "app_events_config";
    private static final int AUTOMATIC_LOGGING_ENABLED_BITMASK_FIELD = 8;
    private static final String BLOCKLIST_EVENTS_KEY = "blocklist_events";
    private static final int CODELESS_EVENTS_ENABLED_BITMASK_FIELD = 32;
    private static final String DEDUPE_KEY = "iap_manual_and_auto_log_dedup_keys";
    private static final String DEDUPE_WINDOW = "iap_manual_and_auto_log_dedup_window_millis";
    private static final int IAP_AUTOMATIC_LOGGING_ENABLED_BITMASK_FIELD = 16;
    private static final String KEY = "key";
    private static final String MACA_RULES_KEY = "maca_rules";
    private static final int MONITOR_ENABLED_BITMASK_FIELD = 16384;
    private static final String PROD_DEDUPE_KEY = "prod_keys";
    private static final String REDACTED_EVENTS_KEY = "redacted_events";
    private static final String SDK_UPDATE_MESSAGE = "sdk_update_message";
    private static final String SENSITIVE_PARAMS_KEY = "sensitive_params";
    private static final String STANDARD_PARAMS_KEY = "standard_params";
    private static final String STD_PARAMS_BLOCKED_KEY = "standard_params_blocked";
    private static final String STD_PARAMS_SCHEMA_KEY = "standard_params_schema";
    private static final String TEST_DEDUPE_KEY = "test_keys";
    private static final int TRACK_UNINSTALL_ENABLED_BITMASK_FIELD = 256;
    private static final String VALUE = "value";
    private static volatile boolean isUnityInit;
    private static volatile boolean printedSDKUpdatedMessage;
    private static volatile JSONArray unityEventBindings;
    public static final FetchedAppSettingsManager INSTANCE = new FetchedAppSettingsManager();
    private static final String TAG = FetchedAppSettingsManager.class.getSimpleName();
    private static final String APP_SETTING_SUPPORTS_IMPLICIT_SDK_LOGGING = "supports_implicit_sdk_logging";
    private static final String APP_SETTING_NUX_CONTENT = "gdpv4_nux_content";
    private static final String APP_SETTING_NUX_ENABLED = "gdpv4_nux_enabled";
    private static final String APP_SETTING_DIALOG_CONFIGS = "android_dialog_configs";
    private static final String APP_SETTING_ANDROID_SDK_ERROR_CATEGORIES = "android_sdk_error_categories";
    private static final String APP_SETTING_APP_EVENTS_SESSION_TIMEOUT = "app_events_session_timeout";
    private static final String APP_SETTING_APP_EVENTS_FEATURE_BITMASK = "app_events_feature_bitmask";
    private static final String APP_SETTING_APP_EVENTS_EVENT_BINDINGS = "auto_event_mapping_android";
    private static final String APP_SETTING_SMART_LOGIN_OPTIONS = "seamless_login";
    private static final String SMART_LOGIN_BOOKMARK_ICON_URL = "smart_login_bookmark_icon_url";
    private static final String SMART_LOGIN_MENU_ICON_URL = "smart_login_menu_icon_url";
    private static final String APP_SETTING_RESTRICTIVE_EVENT_FILTER_FIELD = "restrictive_data_filter_params";
    private static final String APP_SETTING_APP_EVENTS_AAM_RULE = "aam_rules";
    private static final String SUGGESTED_EVENTS_SETTING = "suggested_events_setting";
    private static final String PROTECTED_MODE_RULES = "protected_mode_rules";
    public static final String AUTO_LOG_APP_EVENTS_DEFAULT_FIELD = "auto_log_app_events_default";
    public static final String AUTO_LOG_APP_EVENT_ENABLED_FIELD = "auto_log_app_events_enabled";
    private static final List<String> APP_SETTING_FIELDS = CollectionsKt.listOf((Object[]) new String[]{APP_SETTING_SUPPORTS_IMPLICIT_SDK_LOGGING, APP_SETTING_NUX_CONTENT, APP_SETTING_NUX_ENABLED, APP_SETTING_DIALOG_CONFIGS, APP_SETTING_ANDROID_SDK_ERROR_CATEGORIES, APP_SETTING_APP_EVENTS_SESSION_TIMEOUT, APP_SETTING_APP_EVENTS_FEATURE_BITMASK, APP_SETTING_APP_EVENTS_EVENT_BINDINGS, APP_SETTING_SMART_LOGIN_OPTIONS, SMART_LOGIN_BOOKMARK_ICON_URL, SMART_LOGIN_MENU_ICON_URL, APP_SETTING_RESTRICTIVE_EVENT_FILTER_FIELD, APP_SETTING_APP_EVENTS_AAM_RULE, SUGGESTED_EVENTS_SETTING, PROTECTED_MODE_RULES, AUTO_LOG_APP_EVENTS_DEFAULT_FIELD, AUTO_LOG_APP_EVENT_ENABLED_FIELD, "app_events_config.os_version(" + Build.VERSION.RELEASE + ')'});
    private static final Map<String, FetchedAppSettings> fetchedAppSettings = new ConcurrentHashMap();
    private static final AtomicReference<FetchAppSettingState> loadingState = new AtomicReference<>(FetchAppSettingState.NOT_LOADED);
    private static final ConcurrentLinkedQueue<FetchedAppSettingsCallback> fetchedAppSettingsCallbacks = new ConcurrentLinkedQueue<>();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public enum FetchAppSettingState {
        NOT_LOADED,
        LOADING,
        SUCCESS,
        ERROR
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface FetchedAppSettingsCallback {
        void onError();

        void onSuccess(FetchedAppSettings fetchedAppSettings);
    }

    private FetchedAppSettingsManager() {
    }

    @JvmStatic
    public static final void getAppSettingsAsync(FetchedAppSettingsCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        fetchedAppSettingsCallbacks.add(callback);
        loadAppSettingsAsync();
    }

    private final JSONObject getAppSettingsQueryResponse(String str) {
        Bundle bundle = new Bundle();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(APP_SETTING_FIELDS);
        bundle.putString("fields", TextUtils.join(",", arrayList));
        GraphRequest graphRequestNewGraphPathRequest = GraphRequest.Companion.newGraphPathRequest(null, "app", null);
        graphRequestNewGraphPathRequest.setForceApplicationRequest(true);
        graphRequestNewGraphPathRequest.setParameters(bundle);
        JSONObject jsonObject = graphRequestNewGraphPathRequest.executeAndWait().getJsonObject();
        return jsonObject == null ? new JSONObject() : jsonObject;
    }

    @JvmStatic
    public static final FetchedAppSettings getAppSettingsWithoutQuery(String str) {
        if (str != null) {
            return fetchedAppSettings.get(str);
        }
        return null;
    }

    @JvmStatic
    public static final Map<String, Boolean> getCachedMigratedAutoLogValuesInAppSettings() {
        JSONObject jSONObject;
        Context applicationContext = FacebookSdk.getApplicationContext();
        String applicationId = FacebookSdk.getApplicationId();
        StringCompanionObject stringCompanionObject = StringCompanionObject.f140150a;
        String str = String.format(APP_SETTINGS_PREFS_KEY_FORMAT, Arrays.copyOf(new Object[]{applicationId}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
        String string = applicationContext.getSharedPreferences(APP_SETTINGS_PREFS_STORE, 0).getString(str, null);
        if (!Utility.isNullOrEmpty(string)) {
            if (string == null) {
                throw new IllegalStateException("Required value was null.");
            }
            try {
                jSONObject = new JSONObject(string);
            } catch (JSONException e3) {
                Utility.logd(Utility.LOG_TAG, e3);
                jSONObject = null;
            }
            if (jSONObject != null) {
                return INSTANCE.parseMigratedAutoLogValues(jSONObject);
            }
        }
        return null;
    }

    @JvmStatic
    public static final void loadAppSettingsAsync() {
        final Context applicationContext = FacebookSdk.getApplicationContext();
        final String applicationId = FacebookSdk.getApplicationId();
        if (Utility.isNullOrEmpty(applicationId)) {
            loadingState.set(FetchAppSettingState.ERROR);
            INSTANCE.pollCallbacks();
            return;
        }
        if (fetchedAppSettings.containsKey(applicationId)) {
            loadingState.set(FetchAppSettingState.SUCCESS);
            INSTANCE.pollCallbacks();
            return;
        }
        AtomicReference<FetchAppSettingState> atomicReference = loadingState;
        FetchAppSettingState fetchAppSettingState = FetchAppSettingState.NOT_LOADED;
        FetchAppSettingState fetchAppSettingState2 = FetchAppSettingState.LOADING;
        if (!androidx.compose.animation.core.h.a(atomicReference, fetchAppSettingState, fetchAppSettingState2) && !androidx.compose.animation.core.h.a(atomicReference, FetchAppSettingState.ERROR, fetchAppSettingState2)) {
            INSTANCE.pollCallbacks();
            return;
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.f140150a;
        final String str = String.format(APP_SETTINGS_PREFS_KEY_FORMAT, Arrays.copyOf(new Object[]{applicationId}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
        FacebookSdk.getExecutor().execute(new Runnable() { // from class: com.facebook.internal.g
            @Override // java.lang.Runnable
            public final void run() {
                FetchedAppSettingsManager.loadAppSettingsAsync$lambda$0(applicationContext, str, applicationId);
            }
        });
    }

    private final List<String> parseCurrencyAndValueDedupeParameters(JSONObject jSONObject, String str) {
        JSONArray jSONArray;
        if (jSONObject != null) {
            try {
                jSONArray = jSONObject.getJSONArray(DEDUPE_KEY);
            } catch (Exception unused) {
            }
        } else {
            jSONArray = null;
        }
        if (jSONArray == null) {
            return null;
        }
        int length = jSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
            if (Intrinsics.areEqual(jSONObject2.getString("key"), PROD_DEDUPE_KEY)) {
                JSONArray jSONArray2 = jSONObject2.getJSONArray("value");
                int length2 = jSONArray2.length();
                for (int i4 = 0; i4 < length2; i4++) {
                    JSONObject jSONObject3 = jSONArray2.getJSONObject(i4);
                    if (Intrinsics.areEqual(jSONObject3.getString("key"), str)) {
                        JSONArray jSONArray3 = jSONObject3.getJSONArray("value");
                        ArrayList arrayList = new ArrayList();
                        int length3 = jSONArray3.length();
                        for (int i5 = 0; i5 < length3; i5++) {
                            arrayList.add(jSONArray3.getJSONObject(i5).getString("value"));
                        }
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.addAll(arrayList);
                        return arrayList2;
                    }
                }
            }
        }
        return null;
    }

    private final ArrayList<Pair<String, List<String>>> parseDedupeParameters(JSONObject jSONObject, boolean z2) {
        JSONArray jSONArray;
        ArrayList<Pair<String, List<String>>> arrayList;
        ArrayList<Pair<String, List<String>>> arrayList2 = null;
        if (jSONObject != null) {
            try {
                jSONArray = jSONObject.getJSONArray(DEDUPE_KEY);
            } catch (Exception unused) {
                return arrayList2;
            }
        } else {
            jSONArray = null;
        }
        if (jSONArray == null) {
            return null;
        }
        int length = jSONArray.length();
        ArrayList<Pair<String, List<String>>> arrayList3 = null;
        int i3 = 0;
        while (i3 < length) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
            String string = jSONObject2.getString("key");
            if ((!Intrinsics.areEqual(string, PROD_DEDUPE_KEY) || !z2) && (!Intrinsics.areEqual(string, TEST_DEDUPE_KEY) || z2)) {
                JSONArray jSONArray2 = jSONObject2.getJSONArray("value");
                int length2 = jSONArray2.length();
                int i4 = 0;
                while (i4 < length2) {
                    JSONObject jSONObject3 = jSONArray2.getJSONObject(i4);
                    String string2 = jSONObject3.getString("key");
                    if (Intrinsics.areEqual(string2, AppEventsConstants.EVENT_PARAM_VALUE_TO_SUM) || Intrinsics.areEqual(string2, AppEventsConstants.EVENT_PARAM_CURRENCY)) {
                        arrayList = arrayList2;
                    } else {
                        JSONArray jSONArray3 = jSONObject3.getJSONArray("value");
                        ArrayList arrayList4 = new ArrayList();
                        int length3 = jSONArray3.length();
                        int i5 = 0;
                        while (i5 < length3) {
                            ArrayList<Pair<String, List<String>>> arrayList5 = arrayList2;
                            try {
                                arrayList4.add(jSONArray3.getJSONObject(i5).getString("value"));
                                i5++;
                                arrayList2 = arrayList5;
                            } catch (Exception unused2) {
                                return arrayList5;
                            }
                        }
                        arrayList = arrayList2;
                        if (arrayList3 == null) {
                            arrayList3 = new ArrayList<>();
                        }
                        arrayList3.add(new Pair<>(string2, arrayList4));
                    }
                    i4++;
                    arrayList2 = arrayList;
                }
            }
            i3++;
            arrayList2 = arrayList2;
        }
        return arrayList3;
    }

    static /* synthetic */ ArrayList parseDedupeParameters$default(FetchedAppSettingsManager fetchedAppSettingsManager, JSONObject jSONObject, boolean z2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z2 = false;
        }
        return fetchedAppSettingsManager.parseDedupeParameters(jSONObject, z2);
    }

    private final Long parseDedupeWindow(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                return Long.valueOf(jSONObject.optLong(DEDUPE_WINDOW));
            } catch (Exception unused) {
            }
        }
        return null;
    }

    private final Map<String, Map<String, FetchedAppSettings.DialogFeatureConfig>> parseDialogConfigurations(JSONObject jSONObject) {
        JSONArray jSONArrayOptJSONArray;
        HashMap map = new HashMap();
        if (jSONObject != null && (jSONArrayOptJSONArray = jSONObject.optJSONArray("data")) != null) {
            int length = jSONArrayOptJSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                FetchedAppSettings.DialogFeatureConfig.Companion companion = FetchedAppSettings.DialogFeatureConfig.Companion;
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i3);
                Intrinsics.checkNotNullExpressionValue(jSONObjectOptJSONObject, "dialogConfigData.optJSONObject(i)");
                FetchedAppSettings.DialogFeatureConfig dialogConfig = companion.parseDialogConfig(jSONObjectOptJSONObject);
                if (dialogConfig != null) {
                    String dialogName = dialogConfig.getDialogName();
                    Map map2 = (Map) map.get(dialogName);
                    if (map2 == null) {
                        map2 = new HashMap();
                        map.put(dialogName, map2);
                    }
                    map2.put(dialogConfig.getFeatureName(), dialogConfig);
                }
            }
        }
        return map;
    }

    private final Map<String, Boolean> parseMigratedAutoLogValues(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        HashMap map = new HashMap();
        if (!jSONObject.isNull(AUTO_LOG_APP_EVENTS_DEFAULT_FIELD)) {
            try {
                map.put(AUTO_LOG_APP_EVENTS_DEFAULT_FIELD, Boolean.valueOf(jSONObject.getBoolean(AUTO_LOG_APP_EVENTS_DEFAULT_FIELD)));
            } catch (JSONException e3) {
                Utility.logd(Utility.LOG_TAG, e3);
            }
        }
        if (!jSONObject.isNull(AUTO_LOG_APP_EVENT_ENABLED_FIELD)) {
            try {
                map.put(AUTO_LOG_APP_EVENT_ENABLED_FIELD, Boolean.valueOf(jSONObject.getBoolean(AUTO_LOG_APP_EVENT_ENABLED_FIELD)));
            } catch (JSONException e4) {
                Utility.logd(Utility.LOG_TAG, e4);
            }
        }
        if (map.isEmpty()) {
            return null;
        }
        return map;
    }

    private final JSONArray parseProtectedModeRules(JSONObject jSONObject, String str) {
        if (jSONObject != null) {
            return jSONObject.optJSONArray(str);
        }
        return null;
    }

    private final synchronized void pollCallbacks() {
        FetchAppSettingState fetchAppSettingState = loadingState.get();
        if (FetchAppSettingState.NOT_LOADED != fetchAppSettingState && FetchAppSettingState.LOADING != fetchAppSettingState) {
            final FetchedAppSettings fetchedAppSettings2 = fetchedAppSettings.get(FacebookSdk.getApplicationId());
            Handler handler = new Handler(Looper.getMainLooper());
            if (FetchAppSettingState.ERROR == fetchAppSettingState) {
                while (true) {
                    ConcurrentLinkedQueue<FetchedAppSettingsCallback> concurrentLinkedQueue = fetchedAppSettingsCallbacks;
                    if (concurrentLinkedQueue.isEmpty()) {
                        return;
                    }
                    final FetchedAppSettingsCallback fetchedAppSettingsCallbackPoll = concurrentLinkedQueue.poll();
                    handler.post(new Runnable() { // from class: com.facebook.internal.h
                        @Override // java.lang.Runnable
                        public final void run() {
                            fetchedAppSettingsCallbackPoll.onError();
                        }
                    });
                }
            } else {
                while (true) {
                    ConcurrentLinkedQueue<FetchedAppSettingsCallback> concurrentLinkedQueue2 = fetchedAppSettingsCallbacks;
                    if (concurrentLinkedQueue2.isEmpty()) {
                        return;
                    }
                    final FetchedAppSettingsCallback fetchedAppSettingsCallbackPoll2 = concurrentLinkedQueue2.poll();
                    handler.post(new Runnable() { // from class: com.facebook.internal.i
                        @Override // java.lang.Runnable
                        public final void run() {
                            fetchedAppSettingsCallbackPoll2.onSuccess(fetchedAppSettings2);
                        }
                    });
                }
            }
        }
    }

    @JvmStatic
    public static final FetchedAppSettings queryAppSettings(String applicationId, boolean z2) {
        Intrinsics.checkNotNullParameter(applicationId, "applicationId");
        if (!z2) {
            Map<String, FetchedAppSettings> map = fetchedAppSettings;
            if (map.containsKey(applicationId)) {
                return map.get(applicationId);
            }
        }
        FetchedAppSettingsManager fetchedAppSettingsManager = INSTANCE;
        FetchedAppSettings appSettingsFromJSON$facebook_core_release = fetchedAppSettingsManager.parseAppSettingsFromJSON$facebook_core_release(applicationId, fetchedAppSettingsManager.getAppSettingsQueryResponse(applicationId));
        if (Intrinsics.areEqual(applicationId, FacebookSdk.getApplicationId())) {
            loadingState.set(FetchAppSettingState.SUCCESS);
            fetchedAppSettingsManager.pollCallbacks();
        }
        return appSettingsFromJSON$facebook_core_release;
    }

    @JvmStatic
    public static final void setIsUnityInit(boolean z2) {
        isUnityInit = z2;
        if (unityEventBindings == null || !isUnityInit) {
            return;
        }
        UnityReflection.sendEventMapping(String.valueOf(unityEventBindings));
    }

    public final FetchedAppSettings parseAppSettingsFromJSON$facebook_core_release(String applicationId, JSONObject settingsJSON) {
        Intrinsics.checkNotNullParameter(applicationId, "applicationId");
        Intrinsics.checkNotNullParameter(settingsJSON, "settingsJSON");
        JSONArray jSONArrayOptJSONArray = settingsJSON.optJSONArray(APP_SETTING_ANDROID_SDK_ERROR_CATEGORIES);
        FacebookRequestErrorClassification.Companion companion = FacebookRequestErrorClassification.Companion;
        FacebookRequestErrorClassification facebookRequestErrorClassificationCreateFromJSON = companion.createFromJSON(jSONArrayOptJSONArray);
        if (facebookRequestErrorClassificationCreateFromJSON == null) {
            facebookRequestErrorClassificationCreateFromJSON = companion.getDefaultErrorClassification();
        }
        FacebookRequestErrorClassification facebookRequestErrorClassification = facebookRequestErrorClassificationCreateFromJSON;
        int iOptInt = settingsJSON.optInt(APP_SETTING_APP_EVENTS_FEATURE_BITMASK, 0);
        boolean z2 = (iOptInt & 8) != 0;
        boolean z3 = (iOptInt & 16) != 0;
        boolean z4 = (iOptInt & 32) != 0;
        boolean z5 = (iOptInt & 256) != 0;
        boolean z6 = (iOptInt & MONITOR_ENABLED_BITMASK_FIELD) != 0;
        JSONArray jSONArrayOptJSONArray2 = settingsJSON.optJSONArray(APP_SETTING_APP_EVENTS_EVENT_BINDINGS);
        unityEventBindings = jSONArrayOptJSONArray2;
        if (unityEventBindings != null && InternalSettings.isUnityApp()) {
            UnityReflection.sendEventMapping(jSONArrayOptJSONArray2 != null ? jSONArrayOptJSONArray2.toString() : null);
        }
        JSONObject jSONObjectOptJSONObject = settingsJSON.optJSONObject(APP_SETTING_APP_EVENTS_CONFIG);
        boolean zOptBoolean = settingsJSON.optBoolean(APP_SETTING_SUPPORTS_IMPLICIT_SDK_LOGGING, false);
        String strOptString = settingsJSON.optString(APP_SETTING_NUX_CONTENT, "");
        Intrinsics.checkNotNullExpressionValue(strOptString, "settingsJSON.optString(A…_SETTING_NUX_CONTENT, \"\")");
        boolean zOptBoolean2 = settingsJSON.optBoolean(APP_SETTING_NUX_ENABLED, false);
        int iOptInt2 = settingsJSON.optInt(APP_SETTING_APP_EVENTS_SESSION_TIMEOUT, Constants.getDefaultAppEventsSessionTimeoutInSeconds());
        EnumSet<SmartLoginOption> options = SmartLoginOption.Companion.parseOptions(settingsJSON.optLong(APP_SETTING_SMART_LOGIN_OPTIONS));
        Map<String, Map<String, FetchedAppSettings.DialogFeatureConfig>> dialogConfigurations = parseDialogConfigurations(settingsJSON.optJSONObject(APP_SETTING_DIALOG_CONFIGS));
        String strOptString2 = settingsJSON.optString(SMART_LOGIN_BOOKMARK_ICON_URL);
        Intrinsics.checkNotNullExpressionValue(strOptString2, "settingsJSON.optString(S…_LOGIN_BOOKMARK_ICON_URL)");
        String strOptString3 = settingsJSON.optString(SMART_LOGIN_MENU_ICON_URL);
        Intrinsics.checkNotNullExpressionValue(strOptString3, "settingsJSON.optString(SMART_LOGIN_MENU_ICON_URL)");
        String strOptString4 = settingsJSON.optString(SDK_UPDATE_MESSAGE);
        Intrinsics.checkNotNullExpressionValue(strOptString4, "settingsJSON.optString(SDK_UPDATE_MESSAGE)");
        FetchedAppSettings fetchedAppSettings2 = new FetchedAppSettings(zOptBoolean, strOptString, zOptBoolean2, iOptInt2, options, dialogConfigurations, z2, facebookRequestErrorClassification, strOptString2, strOptString3, z3, z4, jSONArrayOptJSONArray2, strOptString4, z5, z6, settingsJSON.optString(APP_SETTING_APP_EVENTS_AAM_RULE), settingsJSON.optString(SUGGESTED_EVENTS_SETTING), settingsJSON.optString(APP_SETTING_RESTRICTIVE_EVENT_FILTER_FIELD), parseProtectedModeRules(settingsJSON.optJSONObject(PROTECTED_MODE_RULES), STANDARD_PARAMS_KEY), parseProtectedModeRules(settingsJSON.optJSONObject(PROTECTED_MODE_RULES), MACA_RULES_KEY), parseMigratedAutoLogValues(settingsJSON), parseProtectedModeRules(settingsJSON.optJSONObject(PROTECTED_MODE_RULES), BLOCKLIST_EVENTS_KEY), parseProtectedModeRules(settingsJSON.optJSONObject(PROTECTED_MODE_RULES), REDACTED_EVENTS_KEY), parseProtectedModeRules(settingsJSON.optJSONObject(PROTECTED_MODE_RULES), SENSITIVE_PARAMS_KEY), parseProtectedModeRules(settingsJSON.optJSONObject(PROTECTED_MODE_RULES), STD_PARAMS_SCHEMA_KEY), parseProtectedModeRules(settingsJSON.optJSONObject(PROTECTED_MODE_RULES), STD_PARAMS_BLOCKED_KEY), parseCurrencyAndValueDedupeParameters(jSONObjectOptJSONObject, AppEventsConstants.EVENT_PARAM_CURRENCY), parseCurrencyAndValueDedupeParameters(jSONObjectOptJSONObject, AppEventsConstants.EVENT_PARAM_VALUE_TO_SUM), parseDedupeParameters$default(this, jSONObjectOptJSONObject, false, 2, null), parseDedupeParameters(jSONObjectOptJSONObject, true), parseDedupeWindow(settingsJSON.optJSONObject(APP_SETTING_APP_EVENTS_CONFIG)));
        fetchedAppSettings.put(applicationId, fetchedAppSettings2);
        return fetchedAppSettings2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadAppSettingsAsync$lambda$0(Context context, String str, String applicationId) {
        JSONObject jSONObject;
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(str, QaXmqxvjHhxVy.GCLVsVHXAAkrNx);
        Intrinsics.checkNotNullParameter(applicationId, "$applicationId");
        SharedPreferences sharedPreferences = context.getSharedPreferences(APP_SETTINGS_PREFS_STORE, 0);
        FetchedAppSettings appSettingsFromJSON$facebook_core_release = null;
        String string = sharedPreferences.getString(str, null);
        if (!Utility.isNullOrEmpty(string)) {
            if (string == null) {
                throw new IllegalStateException("Required value was null.");
            }
            try {
                jSONObject = new JSONObject(string);
            } catch (JSONException e3) {
                Utility.logd(Utility.LOG_TAG, e3);
                jSONObject = null;
            }
            if (jSONObject != null) {
                appSettingsFromJSON$facebook_core_release = INSTANCE.parseAppSettingsFromJSON$facebook_core_release(applicationId, jSONObject);
            }
        }
        FetchedAppSettingsManager fetchedAppSettingsManager = INSTANCE;
        JSONObject appSettingsQueryResponse = fetchedAppSettingsManager.getAppSettingsQueryResponse(applicationId);
        if (appSettingsQueryResponse != null) {
            fetchedAppSettingsManager.parseAppSettingsFromJSON$facebook_core_release(applicationId, appSettingsQueryResponse);
            sharedPreferences.edit().putString(str, appSettingsQueryResponse.toString()).apply();
        }
        if (appSettingsFromJSON$facebook_core_release != null) {
            String sdkUpdateMessage = appSettingsFromJSON$facebook_core_release.getSdkUpdateMessage();
            if (!printedSDKUpdatedMessage && sdkUpdateMessage != null && sdkUpdateMessage.length() > 0) {
                printedSDKUpdatedMessage = true;
                Log.w(TAG, sdkUpdateMessage);
            }
        }
        FetchedAppGateKeepersManager.queryAppGateKeepers(applicationId, true);
        AutomaticAnalyticsLogger.logActivateAppEvent();
        loadingState.set(fetchedAppSettings.containsKey(applicationId) ? FetchAppSettingState.SUCCESS : FetchAppSettingState.ERROR);
        fetchedAppSettingsManager.pollCallbacks();
    }
}
