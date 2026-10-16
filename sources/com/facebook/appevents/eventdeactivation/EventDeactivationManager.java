package com.facebook.appevents.eventdeactivation;

import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEvent;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class EventDeactivationManager {
    private static boolean enabled;
    public static final EventDeactivationManager INSTANCE = new EventDeactivationManager();
    private static final List<DeprecatedParamFilter> deprecatedParamFilters = new ArrayList();
    private static final Set<String> deprecatedEvents = new HashSet();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DeprecatedParamFilter {
        private List<String> deprecateParams;
        private String eventName;

        public DeprecatedParamFilter(String eventName, List<String> deprecateParams) {
            Intrinsics.checkNotNullParameter(eventName, "eventName");
            Intrinsics.checkNotNullParameter(deprecateParams, "deprecateParams");
            this.eventName = eventName;
            this.deprecateParams = deprecateParams;
        }

        public final List<String> getDeprecateParams() {
            return this.deprecateParams;
        }

        public final String getEventName() {
            return this.eventName;
        }

        public final void setDeprecateParams(List<String> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.deprecateParams = list;
        }

        public final void setEventName(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.eventName = str;
        }
    }

    private EventDeactivationManager() {
    }

    @JvmStatic
    public static final void enable() {
        if (CrashShieldHandler.isObjectCrashing(EventDeactivationManager.class)) {
            return;
        }
        try {
            enabled = true;
            INSTANCE.initialize();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, EventDeactivationManager.class);
        }
    }

    private final synchronized void initialize() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            FetchedAppSettings fetchedAppSettingsQueryAppSettings = FetchedAppSettingsManager.queryAppSettings(FacebookSdk.getApplicationId(), false);
            if (fetchedAppSettingsQueryAppSettings == null) {
                return;
            }
            String restrictiveDataSetting = fetchedAppSettingsQueryAppSettings.getRestrictiveDataSetting();
            if (restrictiveDataSetting != null && restrictiveDataSetting.length() > 0) {
                JSONObject jSONObject = new JSONObject(restrictiveDataSetting);
                deprecatedParamFilters.clear();
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String key = itKeys.next();
                    JSONObject jSONObject2 = jSONObject.getJSONObject(key);
                    if (jSONObject2 != null) {
                        if (jSONObject2.optBoolean("is_deprecated_event")) {
                            Set<String> set = deprecatedEvents;
                            Intrinsics.checkNotNullExpressionValue(key, "key");
                            set.add(key);
                        } else {
                            JSONArray jSONArrayOptJSONArray = jSONObject2.optJSONArray("deprecated_param");
                            Intrinsics.checkNotNullExpressionValue(key, "key");
                            DeprecatedParamFilter deprecatedParamFilter = new DeprecatedParamFilter(key, new ArrayList());
                            if (jSONArrayOptJSONArray != null) {
                                deprecatedParamFilter.setDeprecateParams(Utility.convertJSONArrayToList(jSONArrayOptJSONArray));
                            }
                            deprecatedParamFilters.add(deprecatedParamFilter);
                        }
                    }
                }
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    @JvmStatic
    public static final void processDeprecatedParameters(Map<String, String> parameters, String eventName) {
        if (CrashShieldHandler.isObjectCrashing(EventDeactivationManager.class)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(parameters, "parameters");
            Intrinsics.checkNotNullParameter(eventName, "eventName");
            if (enabled) {
                ArrayList arrayList = new ArrayList(parameters.keySet());
                ArrayList arrayList2 = new ArrayList(deprecatedParamFilters);
                int size = arrayList2.size();
                int i3 = 0;
                while (i3 < size) {
                    Object obj = arrayList2.get(i3);
                    i3++;
                    DeprecatedParamFilter deprecatedParamFilter = (DeprecatedParamFilter) obj;
                    if (Intrinsics.areEqual(deprecatedParamFilter.getEventName(), eventName)) {
                        int size2 = arrayList.size();
                        int i4 = 0;
                        while (i4 < size2) {
                            Object obj2 = arrayList.get(i4);
                            i4++;
                            String str = (String) obj2;
                            if (deprecatedParamFilter.getDeprecateParams().contains(str)) {
                                parameters.remove(str);
                            }
                        }
                    }
                }
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, EventDeactivationManager.class);
        }
    }

    @JvmStatic
    public static final void processEvents(List<AppEvent> events) {
        if (CrashShieldHandler.isObjectCrashing(EventDeactivationManager.class)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(events, "events");
            if (enabled) {
                Iterator<AppEvent> it = events.iterator();
                while (it.hasNext()) {
                    if (deprecatedEvents.contains(it.next().getName())) {
                        it.remove();
                    }
                }
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, EventDeactivationManager.class);
        }
    }
}
