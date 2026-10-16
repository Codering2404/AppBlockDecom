package com.facebook.appevents.integrity;

import android.os.Bundle;
import com.facebook.FacebookSdk;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
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
public final class StdParamsEnforcementManager {
    private static boolean enabled;
    public static final StdParamsEnforcementManager INSTANCE = new StdParamsEnforcementManager();
    private static Map<String, HashSet<String>> regexRestrictionsConfig = new HashMap();
    private static Map<String, HashSet<String>> enumRestrictionsConfig = new HashMap();

    private StdParamsEnforcementManager() {
    }

    private final void configureSchemaRestrictions(JSONArray jSONArray) {
        if (CrashShieldHandler.isObjectCrashing(this) || jSONArray == null) {
            return;
        }
        try {
            if (enabled) {
                return;
            }
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i3);
                String key = jSONObject.getString("key");
                if (key != null && key.length() != 0) {
                    try {
                        JSONArray jSONArray2 = jSONObject.getJSONArray("value");
                        int length2 = jSONArray2.length();
                        for (int i4 = 0; i4 < length2; i4++) {
                            boolean z2 = jSONArray2.getJSONObject(i4).getBoolean("require_exact_match");
                            HashSet<String> hashSetLoadSet = loadSet(jSONArray2.getJSONObject(i4).getJSONArray("potential_matches"));
                            if (z2) {
                                Map<String, HashSet<String>> map = enumRestrictionsConfig;
                                Intrinsics.checkNotNullExpressionValue(key, "key");
                                HashSet<String> hashSet = enumRestrictionsConfig.get(key);
                                if (hashSet != null) {
                                    hashSet.addAll(hashSetLoadSet);
                                    hashSetLoadSet = hashSet;
                                }
                                map.put(key, hashSetLoadSet);
                            } else {
                                Map<String, HashSet<String>> map2 = regexRestrictionsConfig;
                                Intrinsics.checkNotNullExpressionValue(key, "key");
                                HashSet<String> hashSet2 = regexRestrictionsConfig.get(key);
                                if (hashSet2 != null) {
                                    hashSet2.addAll(hashSetLoadSet);
                                    hashSetLoadSet = hashSet2;
                                }
                                map2.put(key, hashSetLoadSet);
                            }
                        }
                    } catch (Exception unused) {
                        enumRestrictionsConfig.remove(key);
                        regexRestrictionsConfig.remove(key);
                    }
                }
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    @JvmStatic
    public static final void disable() {
        if (CrashShieldHandler.isObjectCrashing(StdParamsEnforcementManager.class)) {
            return;
        }
        try {
            enabled = false;
            regexRestrictionsConfig = new HashMap();
            enumRestrictionsConfig = new HashMap();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, StdParamsEnforcementManager.class);
        }
    }

    @JvmStatic
    public static final void enable() {
        if (CrashShieldHandler.isObjectCrashing(StdParamsEnforcementManager.class)) {
            return;
        }
        try {
            if (enabled) {
                return;
            }
            INSTANCE.loadConfigs();
            enabled = (regexRestrictionsConfig.isEmpty() && enumRestrictionsConfig.isEmpty()) ? false : true;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, StdParamsEnforcementManager.class);
        }
    }

    private final boolean isAnyEnumMatched(String str, Set<String> set) {
        if (!CrashShieldHandler.isObjectCrashing(this) && set != null) {
            try {
                Set<String> set2 = set;
                if ((set2 instanceof Collection) && set2.isEmpty()) {
                    return false;
                }
                for (String str2 : set2) {
                    Locale locale = Locale.ROOT;
                    String lowerCase = str2.toLowerCase(locale);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                    String lowerCase2 = str.toLowerCase(locale);
                    Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                    if (Intrinsics.areEqual(lowerCase, lowerCase2)) {
                        return true;
                    }
                }
                return false;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
        return false;
    }

    private final boolean isAnyRegexMatched(String str, Set<String> set) {
        if (!CrashShieldHandler.isObjectCrashing(this) && set != null) {
            try {
                Set<String> set2 = set;
                if ((set2 instanceof Collection) && set2.isEmpty()) {
                    return false;
                }
                Iterator<T> it = set2.iterator();
                while (it.hasNext()) {
                    if (new Regex((String) it.next()).k(str)) {
                        return true;
                    }
                }
                return false;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
        return false;
    }

    private final void loadConfigs() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            FetchedAppSettings fetchedAppSettingsQueryAppSettings = FetchedAppSettingsManager.queryAppSettings(FacebookSdk.getApplicationId(), false);
            if (fetchedAppSettingsQueryAppSettings == null) {
                return;
            }
            configureSchemaRestrictions(fetchedAppSettingsQueryAppSettings.getSchemaRestrictions());
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    private final HashSet<String> loadSet(JSONArray jSONArray) {
        try {
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return null;
            }
            try {
                HashSet<String> hashSetConvertJSONArrayToHashSet = Utility.convertJSONArrayToHashSet(jSONArray);
                return hashSetConvertJSONArrayToHashSet == null ? new HashSet<>() : hashSetConvertJSONArrayToHashSet;
            } catch (Exception unused) {
                return new HashSet<>();
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    @JvmStatic
    public static final void processFilterParamSchemaBlocking(Bundle bundle) {
        int i3;
        if (CrashShieldHandler.isObjectCrashing(StdParamsEnforcementManager.class)) {
            return;
        }
        try {
            if (enabled && bundle != null) {
                ArrayList arrayList = new ArrayList();
                Iterator<String> it = bundle.keySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    String key = it.next();
                    String strValueOf = String.valueOf(bundle.get(key));
                    boolean z2 = regexRestrictionsConfig.get(key) != null;
                    i3 = enumRestrictionsConfig.get(key) != null ? 1 : 0;
                    if (z2 || i3 != 0) {
                        StdParamsEnforcementManager stdParamsEnforcementManager = INSTANCE;
                        boolean zIsAnyRegexMatched = stdParamsEnforcementManager.isAnyRegexMatched(strValueOf, regexRestrictionsConfig.get(key));
                        boolean zIsAnyEnumMatched = stdParamsEnforcementManager.isAnyEnumMatched(strValueOf, enumRestrictionsConfig.get(key));
                        if (!zIsAnyRegexMatched && !zIsAnyEnumMatched) {
                            Intrinsics.checkNotNullExpressionValue(key, "key");
                            arrayList.add(key);
                        }
                    }
                }
                int size = arrayList.size();
                while (i3 < size) {
                    Object obj = arrayList.get(i3);
                    i3++;
                    bundle.remove((String) obj);
                }
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, StdParamsEnforcementManager.class);
        }
    }
}
