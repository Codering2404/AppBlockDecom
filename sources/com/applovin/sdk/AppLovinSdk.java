package com.applovin.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.applovin.impl.mediation.MaxMediatedNetworkInfoImpl;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.t0;
import com.applovin.impl.ze;
import com.applovin.mediation.MaxMediatedNetworkInfo;
import com.applovin.mediation.MaxSegmentCollection;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class AppLovinSdk {
    private static final String TAG = "AppLovinSdk";
    private static AppLovinSdk instance;
    private final j coreSdk;
    public static final String VERSION = getVersion();
    public static final int VERSION_CODE = getVersionCode();
    private static final Object instanceLock = new Object();
    private static final Map<String, AppLovinSdk> sdkInstances = new HashMap(1);
    private static final Object sdkInstancesLock = new Object();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface SdkInitializationListener {
        void onSdkInitialized(AppLovinSdkConfiguration appLovinSdkConfiguration);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class a extends AppLovinSdkSettings {
        a(Context context) {
            super(context);
        }
    }

    private AppLovinSdk(j jVar) {
        this.coreSdk = jVar;
    }

    public static AppLovinSdk getInstance(Context context) {
        AppLovinSdk appLovinSdk;
        if (context == null) {
            throw new IllegalArgumentException("No context specified");
        }
        if (t0.a(context).a("applovin.sdk.key", (String) null) != null) {
            return getInstance(new a(context), context);
        }
        synchronized (instanceLock) {
            try {
                if (instance == null) {
                    j jVar = new j(context);
                    AppLovinSdk appLovinSdk2 = new AppLovinSdk(jVar);
                    jVar.a(appLovinSdk2);
                    instance = appLovinSdk2;
                }
                appLovinSdk = instance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return appLovinSdk;
    }

    private static Collection<AppLovinSdk> getInstances() {
        Collection<AppLovinSdk> collectionValues;
        AppLovinSdk appLovinSdk = instance;
        if (appLovinSdk != null) {
            return Arrays.asList(appLovinSdk);
        }
        synchronized (sdkInstancesLock) {
            collectionValues = sdkInstances.values();
        }
        return collectionValues;
    }

    private static String getVersion() {
        return "13.0.1";
    }

    private static int getVersionCode() {
        return 13000199;
    }

    private void reinitialize(Boolean bool, Boolean bool2) {
        if (this.coreSdk.x0().get() || this.coreSdk.u0()) {
            this.coreSdk.O0();
        }
        this.coreSdk.L0();
        if (bool != null) {
            this.coreSdk.I();
            if (n.a()) {
                this.coreSdk.I().d(TAG, "Toggled 'huc' to " + bool);
            }
            getEventService().trackEvent("huc", CollectionUtils.map("value", bool.toString()));
        }
        if (bool2 != null) {
            this.coreSdk.I();
            if (n.a()) {
                this.coreSdk.I().d(TAG, "Toggled 'dns' to " + bool2);
            }
            getEventService().trackEvent("dns", CollectionUtils.map("value", bool2.toString()));
        }
    }

    static void reinitializeAll(Boolean bool, Boolean bool2) {
        synchronized (sdkInstancesLock) {
            try {
                Iterator<AppLovinSdk> it = getInstances().iterator();
                while (it.hasNext()) {
                    it.next().reinitialize(bool, bool2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public j a() {
        return this.coreSdk;
    }

    public AppLovinAdService getAdService() {
        return this.coreSdk.j();
    }

    public List<MaxMediatedNetworkInfo> getAvailableMediatedNetworks() {
        JSONArray jSONArrayA = ze.a(this.coreSdk);
        ArrayList arrayList = new ArrayList(jSONArrayA.length());
        for (int i3 = 0; i3 < jSONArrayA.length(); i3++) {
            arrayList.add(new MaxMediatedNetworkInfoImpl(JsonUtils.getJSONObject(jSONArrayA, i3, (JSONObject) null)));
        }
        return arrayList;
    }

    public AppLovinCmpService getCmpService() {
        return this.coreSdk.p();
    }

    public AppLovinSdkConfiguration getConfiguration() {
        return this.coreSdk.s();
    }

    public AppLovinEventService getEventService() {
        return this.coreSdk.z();
    }

    public String getMediationProvider() {
        return this.coreSdk.N();
    }

    @Deprecated
    public AppLovinPostbackService getPostbackService() {
        return this.coreSdk.X();
    }

    public String getSdkKey() {
        return this.coreSdk.a0();
    }

    public MaxSegmentCollection getSegmentCollection() {
        return this.coreSdk.b0();
    }

    public AppLovinSdkSettings getSettings() {
        return this.coreSdk.f0();
    }

    @Deprecated
    public String getUserIdentifier() {
        return this.coreSdk.n0();
    }

    public void initialize(AppLovinSdkInitializationConfiguration appLovinSdkInitializationConfiguration, SdkInitializationListener sdkInitializationListener) {
        this.coreSdk.a(appLovinSdkInitializationConfiguration, sdkInitializationListener);
    }

    @Deprecated
    public void initializeSdk() {
    }

    public boolean isInitialized() {
        return this.coreSdk.s0();
    }

    @Deprecated
    public void setMediationProvider(String str) {
        this.coreSdk.f(str);
    }

    @Deprecated
    public void setPluginVersion(String str) {
        this.coreSdk.g(str);
    }

    @Deprecated
    public void setUserIdentifier(String str) {
        this.coreSdk.h(str);
    }

    public void showCreativeDebugger() {
        this.coreSdk.S0();
    }

    public void showMediationDebugger() {
        this.coreSdk.T0();
    }

    public String toString() {
        return "AppLovinSdk{sdkKey='" + getSdkKey() + "', isInitialized=" + isInitialized() + ", isFirstSession=" + this.coreSdk.t0() + '}';
    }

    @Deprecated
    public void initializeSdk(SdkInitializationListener sdkInitializationListener) {
        this.coreSdk.a(sdkInitializationListener);
    }

    public void showMediationDebugger(Map<String, List<?>> map) {
        this.coreSdk.a(map);
    }

    @Deprecated
    public static void initializeSdk(Context context) {
        initializeSdk(context, null);
    }

    @Deprecated
    public static void initializeSdk(Context context, SdkInitializationListener sdkInitializationListener) {
        if (context != null) {
            AppLovinSdk appLovinSdk = getInstance(context);
            if (appLovinSdk != null) {
                appLovinSdk.initializeSdk(sdkInitializationListener);
                return;
            } else {
                n.h(TAG, "Unable to initialize AppLovin SDK: SDK object not created");
                return;
            }
        }
        throw new IllegalArgumentException("No context specified");
    }

    @Deprecated
    public static AppLovinSdk getInstance(AppLovinSdkSettings appLovinSdkSettings, Context context) {
        if (context != null) {
            return getInstance(t0.a(context).a("applovin.sdk.key", ""), appLovinSdkSettings, context);
        }
        throw new IllegalArgumentException("No context specified");
    }

    @Deprecated
    public static AppLovinSdk getInstance(String str, AppLovinSdkSettings appLovinSdkSettings, Context context) {
        AppLovinSdk appLovinSdk;
        if (appLovinSdkSettings == null) {
            throw new IllegalArgumentException("No userSettings specified");
        }
        if (context != null) {
            synchronized (instanceLock) {
                try {
                    AppLovinSdk appLovinSdk2 = instance;
                    if (appLovinSdk2 != null && str.equals(appLovinSdk2.getSdkKey())) {
                        return instance;
                    }
                    synchronized (sdkInstancesLock) {
                        try {
                            Map<String, AppLovinSdk> map = sdkInstances;
                            if (map.containsKey(str)) {
                                appLovinSdk = map.get(str);
                            } else {
                                if (!TextUtils.isEmpty(str)) {
                                    String str2 = File.separator;
                                    if (str.contains(str2)) {
                                        n.h(TAG, "\n**************************************************\nINVALID SDK KEY: " + str + "\n**************************************************\n");
                                        if (!map.isEmpty()) {
                                            return map.values().iterator().next();
                                        }
                                        str = str.replace(str2, "");
                                    }
                                }
                                j jVar = new j(context);
                                jVar.a(str, appLovinSdkSettings);
                                AppLovinSdk appLovinSdk3 = new AppLovinSdk(jVar);
                                jVar.a(appLovinSdk3);
                                appLovinSdkSettings.attachAppLovinSdk(jVar);
                                map.put(str, appLovinSdk3);
                                appLovinSdk = appLovinSdk3;
                            }
                            return appLovinSdk;
                        } finally {
                        }
                    }
                } finally {
                }
            }
        }
        throw new IllegalArgumentException("No context specified");
    }
}
