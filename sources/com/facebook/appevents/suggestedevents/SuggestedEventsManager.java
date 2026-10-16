package com.facebook.appevents.suggestedevents;

import android.app.Activity;
import com.facebook.FacebookSdk;
import com.facebook.appevents.internal.ActivityLifecycleTracker;
import com.facebook.appevents.ml.ModelManager;
import com.facebook.appevents.suggestedevents.SuggestedEventsManager;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.io.File;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class SuggestedEventsManager {
    private static final String ELIGIBLE_EVENTS_KEY = "eligible_for_prediction_events";
    private static final String PRODUCTION_EVENTS_KEY = "production_events";
    public static final SuggestedEventsManager INSTANCE = new SuggestedEventsManager();
    private static final AtomicBoolean enabled = new AtomicBoolean(false);
    private static final Set<String> productionEvents = new LinkedHashSet();
    private static final Set<String> eligibleEvents = new LinkedHashSet();

    private SuggestedEventsManager() {
    }

    @JvmStatic
    public static final synchronized void enable() {
        if (CrashShieldHandler.isObjectCrashing(SuggestedEventsManager.class)) {
            return;
        }
        try {
            FacebookSdk.getExecutor().execute(new Runnable() { // from class: n.a
                @Override // java.lang.Runnable
                public final void run() {
                    SuggestedEventsManager.enable$lambda$0();
                }
            });
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, SuggestedEventsManager.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void enable$lambda$0() {
        if (CrashShieldHandler.isObjectCrashing(SuggestedEventsManager.class)) {
            return;
        }
        try {
            AtomicBoolean atomicBoolean = enabled;
            if (atomicBoolean.get()) {
                return;
            }
            atomicBoolean.set(true);
            INSTANCE.initialize();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, SuggestedEventsManager.class);
        }
    }

    private final void initialize() {
        String suggestedEventsSetting;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            FetchedAppSettings fetchedAppSettingsQueryAppSettings = FetchedAppSettingsManager.queryAppSettings(FacebookSdk.getApplicationId(), false);
            if (fetchedAppSettingsQueryAppSettings != null && (suggestedEventsSetting = fetchedAppSettingsQueryAppSettings.getSuggestedEventsSetting()) != null) {
                populateEventsFromRawJsonString$facebook_core_release(suggestedEventsSetting);
                if (productionEvents.isEmpty() && eligibleEvents.isEmpty()) {
                    return;
                }
                File ruleFile = ModelManager.getRuleFile(ModelManager.Task.MTML_APP_EVENT_PREDICTION);
                if (ruleFile == null) {
                    return;
                }
                FeatureExtractor.initialize(ruleFile);
                Activity currentActivity = ActivityLifecycleTracker.getCurrentActivity();
                if (currentActivity != null) {
                    trackActivity(currentActivity);
                }
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    @JvmStatic
    public static final boolean isEligibleEvents$facebook_core_release(String event) {
        if (CrashShieldHandler.isObjectCrashing(SuggestedEventsManager.class)) {
            return false;
        }
        try {
            Intrinsics.checkNotNullParameter(event, "event");
            return eligibleEvents.contains(event);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, SuggestedEventsManager.class);
            return false;
        }
    }

    @JvmStatic
    public static final boolean isEnabled() {
        if (CrashShieldHandler.isObjectCrashing(SuggestedEventsManager.class)) {
            return false;
        }
        try {
            return enabled.get();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, SuggestedEventsManager.class);
            return false;
        }
    }

    @JvmStatic
    public static final boolean isProductionEvents$facebook_core_release(String event) {
        if (CrashShieldHandler.isObjectCrashing(SuggestedEventsManager.class)) {
            return false;
        }
        try {
            Intrinsics.checkNotNullParameter(event, "event");
            return productionEvents.contains(event);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, SuggestedEventsManager.class);
            return false;
        }
    }

    @JvmStatic
    public static final void trackActivity(Activity activity) {
        if (CrashShieldHandler.isObjectCrashing(SuggestedEventsManager.class)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(activity, "activity");
            try {
                if (!enabled.get() || !FeatureExtractor.isInitialized() || (productionEvents.isEmpty() && eligibleEvents.isEmpty())) {
                    ViewObserver.Companion.stopTrackingActivity(activity);
                    return;
                }
                ViewObserver.Companion.startTrackingActivity(activity);
            } catch (Exception unused) {
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, SuggestedEventsManager.class);
        }
    }

    public final void populateEventsFromRawJsonString$facebook_core_release(String str) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has(PRODUCTION_EVENTS_KEY)) {
                JSONArray jSONArray = jSONObject.getJSONArray(PRODUCTION_EVENTS_KEY);
                int length = jSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    Set<String> set = productionEvents;
                    String string = jSONArray.getString(i3);
                    Intrinsics.checkNotNullExpressionValue(string, "jsonArray.getString(i)");
                    set.add(string);
                }
            }
            if (jSONObject.has(ELIGIBLE_EVENTS_KEY)) {
                JSONArray jSONArray2 = jSONObject.getJSONArray(ELIGIBLE_EVENTS_KEY);
                int length2 = jSONArray2.length();
                for (int i4 = 0; i4 < length2; i4++) {
                    Set<String> set2 = eligibleEvents;
                    String string2 = jSONArray2.getString(i4);
                    Intrinsics.checkNotNullExpressionValue(string2, "jsonArray.getString(i)");
                    set2.add(string2);
                }
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }
}
