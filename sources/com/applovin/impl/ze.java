package com.applovin.impl;

import android.content.Context;
import android.text.TextUtils;
import com.applovin.impl.mediation.MaxMediatedNetworkInfoImpl;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxMediatedNetworkInfo;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import com.google.android.gms.ads.AdSize;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class ze {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final TreeMap f65428a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map f65429b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final List f65430c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static JSONArray f65431d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Map f65432e = new HashMap();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Object f65433f = new Object();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Map f65434g = Collections.synchronizedMap(new HashMap(1));

    static {
        TreeMap treeMap = new TreeMap();
        f65428a = treeMap;
        treeMap.put("com.applovin.mediation.adapters.AdjoeAdsMediationAdapter", "adjoe Ads");
        treeMap.put("com.applovin.mediation.adapters.AmazonAdMarketplaceMediationAdapter", "Amazon Publisher Services");
        treeMap.put("com.applovin.mediation.adapters.AppLovinMediationAdapter", "AppLovin");
        treeMap.put("com.applovin.mediation.adapters.BidMachineMediationAdapter", "BidMachine");
        treeMap.put("com.applovin.mediation.adapters.BigoAdsMediationAdapter", "Bigo Ads");
        treeMap.put("com.applovin.mediation.adapters.ByteDanceMediationAdapter", "Pangle");
        treeMap.put("com.applovin.mediation.adapters.ChartboostMediationAdapter", "Chartboost");
        treeMap.put("com.applovin.mediation.adapters.CSJMediationAdapter", "CSJ");
        treeMap.put("com.applovin.mediation.adapters.DataseatMediationAdapter", "Dataseat");
        treeMap.put("com.applovin.mediation.adapters.FacebookMediationAdapter", "Facebook");
        treeMap.put("com.applovin.mediation.adapters.GoogleMediationAdapter", "AdMob");
        treeMap.put("com.applovin.mediation.adapters.GoogleAdManagerMediationAdapter", "Google Ad Manager");
        treeMap.put("com.applovin.mediation.adapters.HyprMXMediationAdapter", "HyprMX");
        treeMap.put("com.applovin.mediation.adapters.InMobiMediationAdapter", "InMobi");
        treeMap.put("com.applovin.mediation.adapters.InneractiveMediationAdapter", "Fyber");
        treeMap.put("com.applovin.mediation.adapters.IronSourceMediationAdapter", "ironSource");
        treeMap.put("com.applovin.mediation.adapters.LineMediationAdapter", "LINE");
        treeMap.put("com.applovin.mediation.adapters.MaioMediationAdapter", "Maio");
        treeMap.put("com.applovin.mediation.adapters.MintegralMediationAdapter", "Mintegral");
        treeMap.put("com.applovin.mediation.adapters.MobileFuseMediationAdapter", "MobileFuse");
        treeMap.put("com.applovin.mediation.adapters.MolocoMediationAdapter", "Moloco");
        treeMap.put("com.applovin.mediation.adapters.MyTargetMediationAdapter", "myTarget");
        treeMap.put("com.applovin.mediation.adapters.OguryMediationAdapter", "Ogury");
        treeMap.put("com.applovin.mediation.adapters.OguryPresageMediationAdapter", "Ogury Presage");
        treeMap.put("com.applovin.mediation.adapters.PangleMediationAdapter", "Pangle");
        treeMap.put("com.applovin.mediation.adapters.PubMaticMediationAdapter", "PubMatic");
        treeMap.put("com.applovin.mediation.adapters.SayGamesMediationAdapter", "SayGames");
        treeMap.put("com.applovin.mediation.adapters.SmaatoMediationAdapter", "Smaato");
        treeMap.put("com.applovin.mediation.adapters.TencentMediationAdapter", "Tencent");
        treeMap.put("com.applovin.mediation.adapters.UnityAdsMediationAdapter", "Unity Ads");
        treeMap.put("com.applovin.mediation.adapters.VerveMediationAdapter", "Verve");
        treeMap.put("com.applovin.mediation.adapters.VungleMediationAdapter", "Vungle");
        treeMap.put("com.applovin.mediation.adapters.YandexMediationAdapter", "Yandex");
        treeMap.put("com.applovin.mediation.adapters.LinkedInDSPAdapter", "LinkedIn");
        treeMap.put("com.applovin.mediation.adapters.AdColonyMediationAdapter", "AdColony");
        treeMap.put("com.applovin.mediation.adapters.AmazonMediationAdapter", "Amazon");
        treeMap.put("com.applovin.mediation.adapters.AmazonPublisherServicesMediationAdapter", "Amazon Publisher Services");
        treeMap.put("com.applovin.mediation.adapters.CriteoMediationAdapter", "Criteo");
        treeMap.put("com.applovin.mediation.adapters.NendMediationAdapter", "Nend");
        treeMap.put("com.applovin.mediation.adapters.SnapMediationAdapter", "Snap");
        treeMap.put("com.applovin.mediation.adapters.TapjoyMediationAdapter", "Tapjoy");
        treeMap.put("com.applovin.mediation.adapters.VerizonAdsMediationAdapter", "Verizon");
        treeMap.put("com.applovin.mediation.adapters.YahooMediationAdapter", "Yahoo");
        treeMap.put("com.applovin.mediation.ALYsoNetworkMediationAdapter", "YSO Network");
        treeMap.put("com.applovin.mediation.adapters.YsoNetworkMediationAdapter", "YSO Network");
        f65430c = new ArrayList(treeMap.keySet());
        HashMap map = new HashMap();
        f65429b = map;
        map.put("com.applovin.mediation.adapters.BidMachineMediationAdapter", "3.0.1.1");
        map.put("com.applovin.mediation.adapters.ByteDanceMediationAdapter", "6.2.0.5.2");
        map.put("com.applovin.mediation.adapters.ChartboostMediationAdapter", "9.7.0.3");
        map.put("com.applovin.mediation.adapters.FacebookMediationAdapter", "6.17.0.1");
        map.put("com.applovin.mediation.adapters.GoogleMediationAdapter", "23.3.0.1");
        map.put("com.applovin.mediation.adapters.GoogleAdManagerMediationAdapter", "23.3.0.1");
        map.put("com.applovin.mediation.adapters.HyprMXMediationAdapter", "6.4.2.1");
        map.put("com.applovin.mediation.adapters.InMobiMediationAdapter", "10.7.7.1");
        map.put("com.applovin.mediation.adapters.InneractiveMediationAdapter", "8.3.1.1");
        map.put("com.applovin.mediation.adapters.IronSourceMediationAdapter", "8.3.0.0.2");
        map.put("com.applovin.mediation.adapters.LineMediationAdapter", "2024.8.27.1");
        map.put("com.applovin.mediation.adapters.MintegralMediationAdapter", "16.8.51.1");
        map.put("com.applovin.mediation.adapters.MobileFuseMediationAdapter", "1.7.6.1");
        map.put("com.applovin.mediation.adapters.MolocoMediationAdapter", "3.1.0.1");
        map.put("com.applovin.mediation.adapters.MyTargetMediationAdapter", "5.22.1.1");
        map.put("com.applovin.mediation.adapters.PubMaticMediationAdapter", "3.9.0.2");
        map.put("com.applovin.mediation.adapters.SmaatoMediationAdapter", "22.7.0.1");
        map.put("com.applovin.mediation.adapters.UnityAdsMediationAdapter", "4.12.2.1");
        map.put("com.applovin.mediation.adapters.VerveMediationAdapter", "3.0.4.1");
        map.put("com.applovin.mediation.adapters.VungleMediationAdapter", "7.4.1.1");
        map.put("com.applovin.mediation.adapters.YandexMediationAdapter", "7.4.0.1");
    }

    public static MaxAdapter a(String str, com.applovin.impl.sdk.j jVar) {
        Class<?> cls;
        if (TextUtils.isEmpty(str)) {
            jVar.I();
            if (com.applovin.impl.sdk.n.a()) {
                jVar.I().b("AppLovinSdk", "Failed to create adapter instance. No class name provided");
            }
            return null;
        }
        try {
            cls = Class.forName(str);
        } catch (ClassNotFoundException unused) {
        } catch (Throwable th) {
            jVar.I();
            if (com.applovin.impl.sdk.n.a()) {
                jVar.I().a("AppLovinSdk", "Failed to load: " + str, th);
            }
        }
        if (MaxAdapter.class.isAssignableFrom(cls)) {
            return (MaxAdapter) cls.getConstructor(AppLovinSdk.class).newInstance(jVar.q0());
        }
        jVar.I();
        if (com.applovin.impl.sdk.n.a()) {
            jVar.I().b("AppLovinSdk", str + " error: not an instance of '" + MaxAdapter.class.getName() + "'.");
        }
        return null;
    }

    public static boolean b(Object obj) {
        return (obj instanceof fe) && "APPLOVIN".equals(((fe) obj).k());
    }

    private static void b(com.applovin.impl.sdk.j jVar) {
        MaxAdapter maxAdapterA;
        synchronized (f65433f) {
            for (int i3 = 0; i3 < f65431d.length(); i3++) {
                try {
                    JSONObject jSONObject = JsonUtils.getJSONObject(f65431d, i3, (JSONObject) null);
                    String string = JsonUtils.getString(jSONObject, "class", "");
                    if (!StringUtils.isValidString(JsonUtils.getString(jSONObject, "sdk_version", "")) && (maxAdapterA = a(string, jVar)) != null) {
                        String strA = a(maxAdapterA);
                        if (StringUtils.isValidString(strA)) {
                            JsonUtils.putString(jSONObject, "sdk_version", strA);
                            f65432e.put(string, new MaxMediatedNetworkInfoImpl(jSONObject));
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static String a(MaxAdapter maxAdapter) {
        try {
            return StringUtils.emptyIfNull(maxAdapter.getSdkVersion());
        } catch (Throwable th) {
            com.applovin.impl.sdk.n.c("MediationUtils", "Failed to retrieve SDK version for adapter: " + maxAdapter, th);
            return "";
        }
    }

    public static AppLovinSdkUtils.Size a(int i3, MaxAdFormat maxAdFormat, Context context) {
        if (i3 < 0) {
            try {
                i3 = AppLovinSdkUtils.pxToDp(context, z3.a(context).x);
            } catch (Throwable unused) {
                return maxAdFormat.getSize();
            }
        }
        Map map = f65434g;
        AppLovinSdkUtils.Size size = (AppLovinSdkUtils.Size) map.get(Integer.valueOf(i3));
        if (size != null) {
            return size;
        }
        AdSize adSize = AdSize.f69645j;
        Method method = AdSize.class.getMethod("getCurrentOrientationAnchoredAdaptiveBannerAdSize", Context.class, Integer.TYPE);
        Method method2 = AdSize.class.getMethod("getWidth", null);
        Method method3 = AdSize.class.getMethod("getHeight", null);
        Object objInvoke = method.invoke(null, context, Integer.valueOf(i3));
        AppLovinSdkUtils.Size size2 = new AppLovinSdkUtils.Size(((Integer) method2.invoke(objInvoke, null)).intValue(), ((Integer) method3.invoke(objInvoke, null)).intValue());
        map.put(Integer.valueOf(i3), size2);
        return size2;
    }

    public static boolean a(Object obj) {
        return (obj instanceof com.applovin.impl.sdk.ad.b) && StringUtils.isValidString(((com.applovin.impl.sdk.ad.b) obj).I());
    }

    private static boolean a(MaxAdapter maxAdapter, String str) {
        return TextUtils.isEmpty(str) || yp.a(maxAdapter.getAdapterVersion(), str) >= 0;
    }

    public static boolean a(JSONObject jSONObject, String str, com.applovin.impl.sdk.j jVar) {
        if (!JsonUtils.containsJSONObjectContainingInt(jSONObject.optJSONArray("no_fill_reason"), 1035, "code")) {
            return false;
        }
        jVar.D().a(ka.V, "invalid_or_disabled_ad_unit_id", CollectionUtils.hashMap("ad_unit_id", str), "invalid_or_disabled_ad_unit_id" + str);
        return true;
    }

    public static JSONArray a(com.applovin.impl.sdk.j jVar) {
        synchronized (f65433f) {
            try {
                if (f65431d != null) {
                    b(jVar);
                    return f65431d;
                }
                f65431d = new JSONArray();
                for (String str : f65430c) {
                    MaxAdapter maxAdapterA = a(str, jVar);
                    if (maxAdapterA != null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("name", f65428a.get(str));
                            jSONObject.put("class", str);
                            jSONObject.put("sdk_version", a(maxAdapterA));
                            jSONObject.put("version", maxAdapterA.getAdapterVersion());
                            jSONObject.put("is_supported", a(maxAdapterA, (String) f65429b.get(str)));
                        } catch (Throwable unused) {
                        }
                        f65431d.put(jSONObject);
                        f65432e.put(str, new MaxMediatedNetworkInfoImpl(jSONObject));
                    }
                }
                return f65431d;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static MaxMediatedNetworkInfo a(String str) {
        MaxMediatedNetworkInfo maxMediatedNetworkInfo;
        synchronized (f65433f) {
            maxMediatedNetworkInfo = (MaxMediatedNetworkInfo) f65432e.get(str);
        }
        if (maxMediatedNetworkInfo != null) {
            return maxMediatedNetworkInfo;
        }
        JSONObject jSONObject = new JSONObject();
        JsonUtils.putString(jSONObject, "class", str);
        return new MaxMediatedNetworkInfoImpl(jSONObject);
    }
}
