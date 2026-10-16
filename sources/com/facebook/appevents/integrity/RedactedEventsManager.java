package com.facebook.appevents.integrity;

import com.facebook.FacebookSdk;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
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
public final class RedactedEventsManager {
    private static boolean enabled;
    public static final RedactedEventsManager INSTANCE = new RedactedEventsManager();
    private static Map<String, HashSet<String>> redactedEvents = new HashMap();

    private RedactedEventsManager() {
    }

    @JvmStatic
    public static final void disable() {
        if (CrashShieldHandler.isObjectCrashing(RedactedEventsManager.class)) {
            return;
        }
        try {
            enabled = false;
            redactedEvents = new HashMap();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, RedactedEventsManager.class);
        }
    }

    @JvmStatic
    public static final void enable() {
        if (CrashShieldHandler.isObjectCrashing(RedactedEventsManager.class)) {
            return;
        }
        try {
            INSTANCE.loadRedactedEvents();
            if (redactedEvents.isEmpty()) {
                return;
            }
            enabled = true;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, RedactedEventsManager.class);
        }
    }

    private final String getRedactionString(String str) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            for (String str2 : redactedEvents.keySet()) {
                HashSet<String> hashSet = redactedEvents.get(str2);
                if (hashSet != null && hashSet.contains(str)) {
                    return str2;
                }
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    private final void loadRedactedEvents() {
        HashSet<String> hashSetConvertJSONArrayToHashSet;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            FetchedAppSettings fetchedAppSettingsQueryAppSettings = FetchedAppSettingsManager.queryAppSettings(FacebookSdk.getApplicationId(), false);
            if (fetchedAppSettingsQueryAppSettings == null) {
                return;
            }
            try {
                redactedEvents = new HashMap();
                JSONArray redactedEvents2 = fetchedAppSettingsQueryAppSettings.getRedactedEvents();
                if (redactedEvents2 == null || redactedEvents2.length() == 0) {
                    return;
                }
                int length = redactedEvents2.length();
                for (int i3 = 0; i3 < length; i3++) {
                    JSONObject jSONObject = redactedEvents2.getJSONObject(i3);
                    boolean zHas = jSONObject.has("key");
                    boolean zHas2 = jSONObject.has("value");
                    if (zHas && zHas2) {
                        String string = jSONObject.getString("key");
                        JSONArray jSONArray = jSONObject.getJSONArray("value");
                        if (string != null && (hashSetConvertJSONArrayToHashSet = Utility.convertJSONArrayToHashSet(jSONArray)) != null) {
                            redactedEvents.put(string, hashSetConvertJSONArrayToHashSet);
                        }
                    }
                }
            } catch (Exception unused) {
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    @JvmStatic
    public static final String processEventsRedaction(String eventName) {
        if (CrashShieldHandler.isObjectCrashing(RedactedEventsManager.class)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(eventName, "eventName");
            if (enabled) {
                String redactionString = INSTANCE.getRedactionString(eventName);
                if (redactionString != null) {
                    return redactionString;
                }
            }
            return eventName;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, RedactedEventsManager.class);
            return null;
        }
    }
}
