package com.facebook.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.internal.gatekeeper.GateKeeper;
import com.facebook.internal.gatekeeper.GateKeeperRuntimeCache;
import com.facebook.internal.instrument.anrreport.jRA.jlWo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
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
public final class FetchedAppGateKeepersManager {
    private static final String APPLICATION_FIELDS = "fields";
    private static final long APPLICATION_GATEKEEPER_CACHE_TIMEOUT = 3600000;
    private static final String APPLICATION_GATEKEEPER_EDGE = "mobile_sdk_gk";
    private static final String APPLICATION_GATEKEEPER_FIELD = "gatekeepers";
    private static final String APPLICATION_GRAPH_DATA = "data";
    private static final String APPLICATION_PLATFORM = "platform";
    private static final String APPLICATION_SDK_VERSION = "sdk_version";
    private static final String APP_GATEKEEPERS_PREFS_KEY_FORMAT = "com.facebook.internal.APP_GATEKEEPERS.%s";
    private static final String APP_GATEKEEPERS_PREFS_STORE = "com.facebook.internal.preferences.APP_GATEKEEPERS";
    private static final String APP_PLATFORM = "android";
    private static final String TAG = "FetchedAppGateKeepersManager";
    private static volatile GateKeeperRuntimeCache gateKeeperRuntimeCache;
    private static volatile Long timestamp;
    public static final FetchedAppGateKeepersManager INSTANCE = new FetchedAppGateKeepersManager();
    private static final AtomicBoolean isLoading = new AtomicBoolean(false);
    private static final ConcurrentLinkedQueue<Callback> callbacks = new ConcurrentLinkedQueue<>();
    private static final Map<String, JSONObject> fetchedAppGateKeepers = new ConcurrentHashMap();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface Callback {
        void onCompleted();
    }

    private FetchedAppGateKeepersManager() {
    }

    private final JSONObject getAppGateKeepersQueryResponse(String str) {
        Bundle bundle = new Bundle();
        bundle.putString(APPLICATION_PLATFORM, "android");
        bundle.putString(APPLICATION_SDK_VERSION, FacebookSdk.getSdkVersion());
        bundle.putString("fields", APPLICATION_GATEKEEPER_FIELD);
        GraphRequest.Companion companion = GraphRequest.Companion;
        StringCompanionObject stringCompanionObject = StringCompanionObject.f140150a;
        String str2 = String.format("app/%s", Arrays.copyOf(new Object[]{APPLICATION_GATEKEEPER_EDGE}, 1));
        Intrinsics.checkNotNullExpressionValue(str2, "format(format, *args)");
        GraphRequest graphRequestNewGraphPathRequest = companion.newGraphPathRequest(null, str2, null);
        graphRequestNewGraphPathRequest.setParameters(bundle);
        JSONObject jsonObject = graphRequestNewGraphPathRequest.executeAndWait().getJsonObject();
        return jsonObject == null ? new JSONObject() : jsonObject;
    }

    @JvmStatic
    public static final boolean getGateKeeperForKey(String name, String str, boolean z2) {
        Boolean bool;
        Intrinsics.checkNotNullParameter(name, "name");
        Map<String, Boolean> gateKeepersForApplication = INSTANCE.getGateKeepersForApplication(str);
        return (gateKeepersForApplication.containsKey(name) && (bool = gateKeepersForApplication.get(name)) != null) ? bool.booleanValue() : z2;
    }

    private final synchronized JSONObject getGateKeepersForAppId(String str) {
        return fetchedAppGateKeepers.get(str);
    }

    private final boolean isTimestampValid(Long l3) {
        return l3 != null && System.currentTimeMillis() - l3.longValue() < APPLICATION_GATEKEEPER_CACHE_TIMEOUT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadAppGateKeepersAsync$lambda$0(String applicationId, Context context, String gateKeepersKey) {
        Intrinsics.checkNotNullParameter(applicationId, "$applicationId");
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(gateKeepersKey, "$gateKeepersKey");
        FetchedAppGateKeepersManager fetchedAppGateKeepersManager = INSTANCE;
        JSONObject appGateKeepersQueryResponse = fetchedAppGateKeepersManager.getAppGateKeepersQueryResponse(applicationId);
        if (appGateKeepersQueryResponse.length() != 0) {
            parseAppGateKeepersFromJSON$facebook_core_release(applicationId, appGateKeepersQueryResponse);
            context.getSharedPreferences(APP_GATEKEEPERS_PREFS_STORE, 0).edit().putString(gateKeepersKey, appGateKeepersQueryResponse.toString()).apply();
            timestamp = Long.valueOf(System.currentTimeMillis());
        }
        fetchedAppGateKeepersManager.pollCallbacks();
        isLoading.set(false);
    }

    @JvmStatic
    public static final synchronized JSONObject parseAppGateKeepersFromJSON$facebook_core_release(String applicationId, JSONObject jSONObject) {
        JSONObject jSONObject2;
        JSONArray jSONArrayOptJSONArray;
        try {
            Intrinsics.checkNotNullParameter(applicationId, "applicationId");
            JSONObject gateKeepersForAppId = INSTANCE.getGateKeepersForAppId(applicationId);
            jSONObject2 = gateKeepersForAppId != null ? new JSONObject(gateKeepersForAppId.toString()) : new JSONObject();
            JSONObject jSONObjectOptJSONObject = (jSONObject == null || (jSONArrayOptJSONArray = jSONObject.optJSONArray("data")) == null) ? null : jSONArrayOptJSONArray.optJSONObject(0);
            if (jSONObjectOptJSONObject == null) {
                jSONObjectOptJSONObject = new JSONObject();
            }
            JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray(APPLICATION_GATEKEEPER_FIELD);
            if (jSONArrayOptJSONArray2 == null) {
                jSONArrayOptJSONArray2 = new JSONArray();
            }
            int length = jSONArrayOptJSONArray2.length();
            for (int i3 = 0; i3 < length; i3++) {
                try {
                    JSONObject jSONObject3 = jSONArrayOptJSONArray2.getJSONObject(i3);
                    jSONObject2.put(jSONObject3.getString("key"), jSONObject3.getBoolean("value"));
                } catch (JSONException e3) {
                    Utility.logd(Utility.LOG_TAG, e3);
                }
            }
            INSTANCE.setGateKeepersForAppId(applicationId, jSONObject2);
        } catch (Throwable th) {
            throw th;
        }
        return jSONObject2;
    }

    private final void pollCallbacks() {
        Handler handler = new Handler(Looper.getMainLooper());
        while (true) {
            ConcurrentLinkedQueue<Callback> concurrentLinkedQueue = callbacks;
            if (concurrentLinkedQueue.isEmpty()) {
                return;
            }
            final Callback callbackPoll = concurrentLinkedQueue.poll();
            if (callbackPoll != null) {
                handler.post(new Runnable() { // from class: com.facebook.internal.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        callbackPoll.onCompleted();
                    }
                });
            }
        }
    }

    @JvmStatic
    public static final JSONObject queryAppGateKeepers(String applicationId, boolean z2) {
        JSONObject gateKeepersForAppId;
        Intrinsics.checkNotNullParameter(applicationId, "applicationId");
        if (!z2 && (gateKeepersForAppId = INSTANCE.getGateKeepersForAppId(applicationId)) != null) {
            return gateKeepersForAppId;
        }
        JSONObject appGateKeepersQueryResponse = INSTANCE.getAppGateKeepersQueryResponse(applicationId);
        Context applicationContext = FacebookSdk.getApplicationContext();
        StringCompanionObject stringCompanionObject = StringCompanionObject.f140150a;
        String str = String.format(APP_GATEKEEPERS_PREFS_KEY_FORMAT, Arrays.copyOf(new Object[]{applicationId}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
        applicationContext.getSharedPreferences(APP_GATEKEEPERS_PREFS_STORE, 0).edit().putString(str, appGateKeepersQueryResponse.toString()).apply();
        return parseAppGateKeepersFromJSON$facebook_core_release(applicationId, appGateKeepersQueryResponse);
    }

    @JvmStatic
    public static final void resetRuntimeGateKeeperCache() {
        GateKeeperRuntimeCache gateKeeperRuntimeCache2 = gateKeeperRuntimeCache;
        if (gateKeeperRuntimeCache2 != null) {
            GateKeeperRuntimeCache.resetCache$default(gateKeeperRuntimeCache2, null, 1, null);
        }
    }

    private final synchronized void setGateKeepersForAppId(String str, JSONObject jSONObject) {
        fetchedAppGateKeepers.put(str, jSONObject);
    }

    @JvmStatic
    public static final void setRuntimeGateKeeper(String applicationId, GateKeeper gateKeeper) {
        Intrinsics.checkNotNullParameter(applicationId, "applicationId");
        Intrinsics.checkNotNullParameter(gateKeeper, "gateKeeper");
        GateKeeperRuntimeCache gateKeeperRuntimeCache2 = gateKeeperRuntimeCache;
        if ((gateKeeperRuntimeCache2 != null ? gateKeeperRuntimeCache2.getGateKeeper(applicationId, gateKeeper.getName()) : null) == null) {
            Log.w(TAG, "Missing gatekeeper runtime cache");
            return;
        }
        GateKeeperRuntimeCache gateKeeperRuntimeCache3 = gateKeeperRuntimeCache;
        if (gateKeeperRuntimeCache3 != null) {
            gateKeeperRuntimeCache3.setGateKeeper(applicationId, gateKeeper);
        }
    }

    public static /* synthetic */ void setRuntimeGateKeeper$default(String str, GateKeeper gateKeeper, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = FacebookSdk.getApplicationId();
        }
        setRuntimeGateKeeper(str, gateKeeper);
    }

    public final Map<String, Boolean> getGateKeepersForApplication(String str) {
        loadAppGateKeepersAsync();
        if (str == null || getGateKeepersForAppId(str) == null) {
            return new HashMap();
        }
        GateKeeperRuntimeCache gateKeeperRuntimeCache2 = gateKeeperRuntimeCache;
        List<GateKeeper> listDumpGateKeepers = gateKeeperRuntimeCache2 != null ? gateKeeperRuntimeCache2.dumpGateKeepers(str) : null;
        if (listDumpGateKeepers != null) {
            HashMap map = new HashMap();
            for (GateKeeper gateKeeper : listDumpGateKeepers) {
                map.put(gateKeeper.getName(), Boolean.valueOf(gateKeeper.getValue()));
            }
            return map;
        }
        HashMap map2 = new HashMap();
        JSONObject gateKeepersForAppId = getGateKeepersForAppId(str);
        if (gateKeepersForAppId == null) {
            gateKeepersForAppId = new JSONObject();
        }
        Iterator<String> itKeys = gateKeepersForAppId.keys();
        while (itKeys.hasNext()) {
            String key = itKeys.next();
            Intrinsics.checkNotNullExpressionValue(key, "key");
            map2.put(key, Boolean.valueOf(gateKeepersForAppId.optBoolean(key)));
        }
        GateKeeperRuntimeCache gateKeeperRuntimeCache3 = gateKeeperRuntimeCache;
        if (gateKeeperRuntimeCache3 == null) {
            gateKeeperRuntimeCache3 = new GateKeeperRuntimeCache();
        }
        ArrayList arrayList = new ArrayList(map2.size());
        for (Map.Entry entry : map2.entrySet()) {
            arrayList.add(new GateKeeper((String) entry.getKey(), ((Boolean) entry.getValue()).booleanValue()));
        }
        gateKeeperRuntimeCache3.setGateKeepers(str, arrayList);
        gateKeeperRuntimeCache = gateKeeperRuntimeCache3;
        return map2;
    }

    public final void loadAppGateKeepersAsync() {
        loadAppGateKeepersAsync(null);
    }

    @JvmStatic
    public static final synchronized void loadAppGateKeepersAsync(Callback callback) {
        if (callback != null) {
            try {
                callbacks.add(callback);
            } catch (Throwable th) {
                throw th;
            }
        }
        final String applicationId = FacebookSdk.getApplicationId();
        FetchedAppGateKeepersManager fetchedAppGateKeepersManager = INSTANCE;
        if (fetchedAppGateKeepersManager.isTimestampValid(timestamp) && fetchedAppGateKeepersManager.getGateKeepersForAppId(applicationId) != null) {
            fetchedAppGateKeepersManager.pollCallbacks();
            return;
        }
        final Context applicationContext = FacebookSdk.getApplicationContext();
        StringCompanionObject stringCompanionObject = StringCompanionObject.f140150a;
        final String str = String.format(APP_GATEKEEPERS_PREFS_KEY_FORMAT, Arrays.copyOf(new Object[]{applicationId}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
        if (applicationContext == null) {
            return;
        }
        JSONObject jSONObject = null;
        String string = applicationContext.getSharedPreferences(jlWo.pkJTuGnp, 0).getString(str, null);
        if (!Utility.isNullOrEmpty(string)) {
            try {
                jSONObject = new JSONObject(string);
            } catch (JSONException e3) {
                Utility.logd(Utility.LOG_TAG, e3);
            }
            if (jSONObject != null) {
                parseAppGateKeepersFromJSON$facebook_core_release(applicationId, jSONObject);
            }
        }
        Executor executor = FacebookSdk.getExecutor();
        if (executor == null) {
            return;
        }
        if (isLoading.compareAndSet(false, true)) {
            executor.execute(new Runnable() { // from class: com.facebook.internal.f
                @Override // java.lang.Runnable
                public final void run() {
                    FetchedAppGateKeepersManager.loadAppGateKeepersAsync$lambda$0(applicationId, applicationContext, str);
                }
            });
        }
    }
}
