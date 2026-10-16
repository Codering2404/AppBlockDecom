package com.applovin.impl;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.text.format.Formatter;
import com.applovin.impl.ka;
import com.applovin.impl.sdk.AppLovinError;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxError;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinEventTypes;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.facebook.stetho.common.Utf8Charset;
import com.revenuecat.purchases.common.Constants;
import java.io.File;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.Thread;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class la {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f61175g = (int) TimeUnit.SECONDS.toMillis(30);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private JSONObject f61176a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ExecutorService f61177b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map f61178c = Collections.synchronizedMap(new HashMap());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Set f61179d = Collections.synchronizedSet(new HashSet());

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected final com.applovin.impl.sdk.j f61180e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected final com.applovin.impl.sdk.n f61181f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.applovin.impl.sdk.j f61182a;

        /* JADX INFO: renamed from: com.applovin.impl.la$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class C0108a implements Thread.UncaughtExceptionHandler {
            C0108a() {
            }

            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(Thread thread, Throwable th) {
                a.this.f61182a.I();
                if (com.applovin.impl.sdk.n.a()) {
                    a.this.f61182a.I().a("HealthEventsReporter", "Caught unhandled exception", th);
                }
            }
        }

        a(com.applovin.impl.sdk.j jVar) {
            this.f61182a = jVar;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, "AppLovinSdk:health_events_reporter");
            thread.setDaemon(true);
            thread.setPriority(((Integer) this.f61182a.a(sj.U)).intValue());
            thread.setUncaughtExceptionHandler(new C0108a());
            return thread;
        }
    }

    public la(com.applovin.impl.sdk.j jVar) {
        this.f61180e = jVar;
        this.f61181f = jVar.I();
        this.f61177b = Executors.newFixedThreadPool(1, new a(jVar));
    }

    private void c(ka kaVar, Object obj, List list) {
        HttpURLConnection httpURLConnection;
        Throwable th;
        if (kaVar.a() == ka.b.AD || kaVar.a() == ka.b.USER_SESSION || !yp.a(((Integer) this.f61180e.a(sj.D)).intValue())) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Map map = (Map) it.next();
            try {
                httpURLConnection = (HttpURLConnection) a(kaVar, obj, map).openConnection();
            } catch (Throwable th2) {
                httpURLConnection = null;
                th = th2;
            }
            try {
                int i3 = f61175g;
                httpURLConnection.setConnectTimeout(i3);
                httpURLConnection.setReadTimeout(i3);
                httpURLConnection.setDefaultUseCaches(false);
                httpURLConnection.setAllowUserInteraction(false);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setInstanceFollowRedirects(true);
                httpURLConnection.setDoOutput(false);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setRequestProperty("AppLovin-Event-Type", kaVar.b());
                int responseCode = httpURLConnection.getResponseCode();
                if (com.applovin.impl.sdk.n.a()) {
                    this.f61181f.a("HealthEventsReporter", kaVar.b() + " reported with code " + responseCode + " and extra parameters " + map);
                }
                this.f61178c.put(kaVar, Long.valueOf(System.currentTimeMillis()));
            } catch (Throwable th3) {
                th = th3;
                try {
                    if (com.applovin.impl.sdk.n.a()) {
                        this.f61181f.d("HealthEventsReporter", "Failed to report " + kaVar.b() + " with extra parameters " + map, th);
                    }
                    yp.a(httpURLConnection, this.f61180e);
                } finally {
                    yp.a(httpURLConnection, this.f61180e);
                }
            }
        }
    }

    private void d(ka kaVar, final Object obj, List list) {
        final String str = (String) this.f61180e.a(sj.E);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        double dA = kaVar.a(this.f61180e);
        if (yp.a(dA)) {
            if (((Boolean) this.f61180e.a(sj.K)).booleanValue()) {
                a(str, kaVar, obj, a(kaVar, dA, obj, list));
                return;
            }
            la laVar = this;
            ka kaVar2 = kaVar;
            Iterator it = list.iterator();
            while (it.hasNext()) {
                final JSONObject jSONObjectA = laVar.a(kaVar2, dA, obj, Collections.singletonList((Map) it.next()));
                ExecutorService executorService = laVar.f61177b;
                final la laVar2 = laVar;
                final ka kaVar3 = kaVar2;
                kaVar2 = kaVar3;
                executorService.execute(new Runnable() { // from class: com.applovin.impl.cz
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f59034a.a(str, kaVar3, obj, jSONObjectA);
                    }
                });
                laVar = this;
                dA = dA;
            }
        }
    }

    private URL a(ka kaVar, Object obj, Map map) throws UnsupportedEncodingException {
        StringBuilder sb = new StringBuilder("https://ms.applovin.com/1.0/sdk/error");
        sb.append("?");
        Iterator it = b(kaVar, obj, map).entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String strEncode = URLEncoder.encode((String) entry.getKey(), Utf8Charset.NAME);
            String strEncode2 = URLEncoder.encode((String) entry.getValue(), Utf8Charset.NAME);
            sb.append(strEncode);
            sb.append("=");
            sb.append(strEncode2);
            if (it.hasNext()) {
                sb.append("&");
            }
        }
        return new URL(sb.toString());
    }

    private Map b(ka kaVar, Object obj, Map map) {
        HashMap map2 = new HashMap();
        map2.put("type", kaVar.b());
        if (kaVar == ka.P || kaVar == ka.f60951d0 || kaVar == ka.f60947b0) {
            if (((Boolean) this.f61180e.a(sj.p4)).booleanValue()) {
                CollectionUtils.putStringIfValid("wvvc", String.valueOf(sr.d()), map2);
                CollectionUtils.putStringIfValid("wvv", sr.c(), map2);
                CollectionUtils.putStringIfValid("wvpn", sr.b(), map2);
            }
            CollectionUtils.putStringIfValid("oglv", this.f61180e.x().E(), map2);
        }
        Map mapH = this.f61180e.x().H();
        map2.put("platform", String.valueOf(mapH.get("platform")));
        map2.put("country_code", String.valueOf(mapH.get("country_code")));
        map2.put("cc", this.f61180e.s().getCountryCode());
        map2.put("applovin_random_token", this.f61180e.Z());
        map2.put("compass_random_token", this.f61180e.r());
        map2.put(DeviceRequestsHelper.DEVICE_INFO_MODEL, Build.MODEL);
        map2.put("brand", Build.MANUFACTURER);
        map2.put("brand_name", Build.BRAND);
        map2.put("hardware", Build.HARDWARE);
        map2.put("revision", Build.DEVICE);
        map2.put("os", Build.VERSION.RELEASE);
        map2.put("api_level", String.valueOf(Build.VERSION.SDK_INT));
        map2.put("sdk_version", String.valueOf(AppLovinSdk.VERSION));
        CollectionUtils.putStringIfValid("ad_review_sdk_version", v.b(), map2);
        map2.put("md", (String) this.f61180e.a(sj.f63797v));
        a(map2);
        a(obj, map2);
        if (map != null) {
            map2.putAll(map);
        }
        return map2;
    }

    public static Map a(com.applovin.impl.sdk.ad.b bVar) {
        return a(bVar, false, (com.applovin.impl.sdk.j) null);
    }

    public static Map a(com.applovin.impl.sdk.ad.b bVar, boolean z2, com.applovin.impl.sdk.j jVar) {
        HashMap map = new HashMap();
        if (bVar != null) {
            CollectionUtils.putStringIfValid("ad_domain", bVar.getAdDomain(), map);
            CollectionUtils.putStringIfValid("ad_id", String.valueOf(bVar.getAdIdNumber()), map);
            MaxAdFormat maxAdFormatD = bVar.getAdZone().d();
            CollectionUtils.putStringIfValid("ad_format", maxAdFormatD != null ? maxAdFormatD.getLabel() : null, map);
            CollectionUtils.putStringIfValid("ad_zone_id", bVar.getAdZone().e(), map);
            CollectionUtils.putStringIfValid("clcode", bVar.getClCode(), map);
            CollectionUtils.putStringIfValid("dsp_id", bVar.getDspId(), map);
            CollectionUtils.putStringIfValid("dsp_name", bVar.getDspName(), map);
            CollectionUtils.putStringIfValid("ad_size", bVar.getSize().getLabel(), map);
            CollectionUtils.putBooleanIfValid("is_persisted_ad", Boolean.valueOf(bVar.G0()), map);
            if (z2) {
                if (((Boolean) jVar.a(sj.N)).booleanValue()) {
                    List listI = bVar.i();
                    HashMap map2 = new HashMap();
                    Iterator it = listI.iterator();
                    while (it.hasNext()) {
                        String path = ((Uri) it.next()).getPath();
                        map2.put(path, Formatter.formatFileSize(com.applovin.impl.sdk.j.m(), new File(path).length()));
                    }
                    map.put("path", map2.toString());
                }
                if ((bVar instanceof com.applovin.impl.sdk.ad.a) && ((Boolean) jVar.a(sj.O)).booleanValue()) {
                    map.put("details", ((com.applovin.impl.sdk.ad.a) bVar).l1());
                }
            }
        }
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(String str, ka kaVar, Object obj, JSONObject jSONObject) {
        byte[] bytes;
        HttpURLConnection httpURLConnection;
        HttpURLConnection httpURLConnection2 = null;
        try {
            URL url = new URL(str);
            bytes = jSONObject.toString().getBytes(Utf8Charset.NAME);
            httpURLConnection = (HttpURLConnection) url.openConnection();
        } catch (Throwable th) {
            th = th;
        }
        try {
            int i3 = f61175g;
            httpURLConnection.setConnectTimeout(i3);
            httpURLConnection.setReadTimeout(i3);
            httpURLConnection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
            httpURLConnection.setDefaultUseCaches(false);
            httpURLConnection.setAllowUserInteraction(false);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setInstanceFollowRedirects(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setFixedLengthStreamingMode(bytes.length);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("AppLovin-Event-Type", kaVar.b());
            OutputStream outputStream = httpURLConnection.getOutputStream();
            outputStream.write(bytes);
            outputStream.close();
            int responseCode = httpURLConnection.getResponseCode();
            if (com.applovin.impl.sdk.n.a()) {
                this.f61181f.a("HealthEventsReporter", kaVar.b() + " reported with code " + responseCode);
            }
            this.f61178c.put(kaVar, Long.valueOf(System.currentTimeMillis()));
            yp.a(httpURLConnection, this.f61180e);
        } catch (Throwable th2) {
            th = th2;
            httpURLConnection2 = httpURLConnection;
            try {
                if (com.applovin.impl.sdk.n.a()) {
                    this.f61181f.d("HealthEventsReporter", "Failed to report " + kaVar.b(), th);
                }
            } finally {
                yp.a(httpURLConnection2, this.f61180e);
            }
        }
    }

    private AppLovinAdSize a(h0 h0Var, com.applovin.impl.sdk.ad.b bVar) {
        AppLovinAdSize appLovinAdSizeF = h0Var != null ? h0Var.f() : null;
        if (appLovinAdSizeF != null) {
            return appLovinAdSizeF;
        }
        if (bVar != null) {
            return bVar.getSize();
        }
        return null;
    }

    private JSONObject a(ka kaVar, double d3, Object obj, List list) {
        JSONObject jSONObject = new JSONObject();
        JsonUtils.putLong(jSONObject, "ts_ms", System.currentTimeMillis());
        if (kaVar == ka.P || kaVar == ka.f60951d0 || kaVar == ka.f60947b0) {
            if (((Boolean) this.f61180e.a(sj.p4)).booleanValue()) {
                JsonUtils.putStringIfValid(jSONObject, "wvvc", String.valueOf(sr.d()));
                JsonUtils.putStringIfValid(jSONObject, "wvv", sr.c());
                JsonUtils.putStringIfValid(jSONObject, "wvpn", sr.b());
            }
            JsonUtils.putStringIfValid(jSONObject, "oglv", this.f61180e.x().E());
        }
        JSONObject jSONObject2 = new JSONObject();
        Map mapH = this.f61180e.x().H();
        JsonUtils.putObject(jSONObject2, "platform", mapH.get("platform"));
        JsonUtils.putObject(jSONObject2, "os", mapH.get("os"));
        JsonUtils.putObject(jSONObject2, "brand", mapH.get("brand"));
        JsonUtils.putObject(jSONObject2, DeviceRequestsHelper.DEVICE_INFO_MODEL, mapH.get(DeviceRequestsHelper.DEVICE_INFO_MODEL));
        JsonUtils.putObject(jSONObject2, "revision", mapH.get("revision"));
        JsonUtils.putObject(jSONObject2, "country_code", mapH.get("country_code"));
        JsonUtils.putObject(jSONObject2, "cc", this.f61180e.s().getCountryCode());
        JsonUtils.putObject(jSONObject2, "applovin_random_token", this.f61180e.Z());
        JsonUtils.putObject(jSONObject2, "ad_review_sdk_version", StringUtils.emptyIfNull(v.b()));
        Map mapB = this.f61180e.x().B();
        JsonUtils.putObject(jSONObject2, "sdk_version", mapB.get("sdk_version"));
        JsonUtils.putObject(jSONObject2, "plugin_version", this.f61180e.a(sj.K3));
        JsonUtils.putObject(jSONObject2, "app_version", mapB.get("app_version"));
        JsonUtils.putObject(jSONObject2, "package_name", mapB.get("package_name"));
        JsonUtils.putObject(jSONObject2, "first_install", Boolean.toString(Boolean.TRUE.equals((Boolean) mapB.get("first_install_v2"))));
        JsonUtils.putObject(jSONObject2, "md", this.f61180e.a(sj.f63797v));
        JsonUtils.putObject(jSONObject2, "mediation_provider", this.f61180e.N());
        JsonUtils.putObject(jSONObject, "shared_fields", jSONObject2);
        JSONArray jSONArray = new JSONArray();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Map map = (Map) it.next();
            JSONObject jSONObject3 = new JSONObject();
            JsonUtils.putDouble(jSONObject3, "ts_ms", System.currentTimeMillis());
            JsonUtils.putString(jSONObject3, "type", kaVar.b());
            JsonUtils.putDouble(jSONObject3, "weight", d3);
            JsonUtils.putString(jSONObject3, AppLovinEventTypes.USER_COMPLETED_LEVEL, "DEBUG");
            a(obj, map);
            JsonUtils.putAll(jSONObject3, (Map<String, ?>) map);
            jSONArray.put(jSONObject3);
        }
        JsonUtils.putObject(jSONObject, "events", jSONArray);
        return jSONObject;
    }

    public static Map a(fe feVar) {
        Map mapA = a((oe) feVar);
        CollectionUtils.putStringIfValid("bcode", feVar.B(), mapA);
        CollectionUtils.putStringIfValid("creative_id", feVar.getCreativeId(), mapA);
        CollectionUtils.putStringIfValid("ad_unit_id", feVar.getAdUnitId(), mapA);
        CollectionUtils.putStringIfValid("ad_format", feVar.getFormat().getLabel(), mapA);
        return mapA;
    }

    private List a(String str) {
        List<Integer> integerList = JsonUtils.getIntegerList(this.f61176a, StringUtils.getHost(str), null);
        return integerList == null ? JsonUtils.getIntegerList(this.f61176a, "default", null) : integerList;
    }

    private boolean a(ka kaVar, long j3) {
        Long l3 = (Long) this.f61178c.get(kaVar);
        return System.currentTimeMillis() - (l3 != null ? l3.longValue() : -1L) < j3;
    }

    public void a() {
        this.f61176a = JsonUtils.deserialize((String) this.f61180e.a(sj.M));
    }

    public void a(String str, String str2, int i3) {
        a(str, str2, i3, new HashMap());
    }

    public void a(String str, String str2, int i3, HashMap map) {
        List listA = a(str2);
        boolean z2 = listA != null;
        if (z2 && listA.contains(Integer.valueOf(i3))) {
            return;
        }
        if (z2 || i3 >= 400) {
            map.put("source", str);
            map.put("url", StringUtils.emptyIfNull(str2));
            map.put("code", String.valueOf(i3));
            a(ka.Y, (Map) map);
        }
    }

    private void a(Object obj, Map map) {
        if (map == null) {
            return;
        }
        if (obj == null) {
            obj = this.f61180e.B().a();
        }
        if (obj instanceof com.applovin.impl.sdk.ad.b) {
            map.put("fs_ad_network", "AppLovin");
            map.put("fs_ad_creative_id", Long.toString(((com.applovin.impl.sdk.ad.b) obj).getAdIdNumber()));
        } else if (obj instanceof fe) {
            fe feVar = (fe) obj;
            map.put("fs_ad_network", feVar.getNetworkName());
            map.put("fs_ad_creative_id", feVar.getCreativeId());
        } else {
            map.put("fs_ad_network", "None");
            map.put("fs_ad_creative_id", "None");
        }
    }

    private void a(Map map) {
        String packageName;
        PackageInfo packageInfo;
        PackageManager packageManager;
        String str = "";
        try {
            packageManager = com.applovin.impl.sdk.j.m().getPackageManager();
            packageName = com.applovin.impl.sdk.j.m().getPackageName();
        } catch (Throwable unused) {
            packageName = "";
        }
        try {
            packageInfo = packageManager.getPackageInfo(packageName, 0);
        } catch (Throwable unused2) {
            packageInfo = null;
        }
        map.put("package_name", packageName);
        if (packageInfo != null) {
            str = packageInfo.versionName;
        }
        map.put("app_version", str);
        map.put("app_version_code", String.valueOf(packageInfo != null ? packageInfo.versionCode : 0));
    }

    public void a(final ka kaVar, final Object obj, final List list, long j3) {
        if (a(kaVar, j3)) {
            return;
        }
        try {
            if (yp.h()) {
                this.f61177b.execute(new Runnable() { // from class: com.applovin.impl.bz
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f58787a.b(kaVar, obj, list);
                    }
                });
            } else {
                b(kaVar, obj, list);
            }
        } catch (Throwable th) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f61181f.d("HealthEventsReporter", "Failed to report " + kaVar.b() + " with extra parameters collection " + list, th);
            }
        }
    }

    public void a(ka kaVar, h0 h0Var, AppLovinError appLovinError) {
        a(kaVar, h0Var, (com.applovin.impl.sdk.ad.b) null, appLovinError);
    }

    private void a(ka kaVar, h0 h0Var, com.applovin.impl.sdk.ad.b bVar, AppLovinError appLovinError) {
        if (((Boolean) this.f61180e.a(sj.L)).booleanValue() && this.f61180e.y0()) {
            return;
        }
        HashMap map = new HashMap();
        if (bVar != null) {
            map.putAll(a(bVar));
        }
        if (h0Var != null) {
            CollectionUtils.putStringIfValid("ad_zone_id", h0Var.e(), map);
            MaxAdFormat maxAdFormatD = h0Var.d();
            if (maxAdFormatD != null) {
                CollectionUtils.putStringIfValid("ad_format", maxAdFormatD.getLabel(), map);
            }
        }
        AppLovinAdSize appLovinAdSizeA = a(h0Var, bVar);
        if (appLovinAdSizeA != null) {
            CollectionUtils.putStringIfValid("ad_size", appLovinAdSizeA.getLabel(), map);
        }
        if (appLovinError != null) {
            CollectionUtils.putStringIfValid("error_message", appLovinError.getMessage(), map);
            CollectionUtils.putStringIfValid("error_code", String.valueOf(appLovinError.getCode()), map);
        }
        a(kaVar, (Map) map);
    }

    public void a(ka kaVar, fe feVar) {
        a(kaVar, feVar.getFormat(), feVar.getAdUnitId(), feVar, (MaxError) null);
    }

    public void a(ka kaVar, fe feVar, MaxError maxError) {
        a(kaVar, feVar.getFormat(), feVar.getAdUnitId(), feVar, maxError);
    }

    public void a(ka kaVar, com.applovin.impl.sdk.ad.b bVar) {
        a(kaVar, bVar != null ? bVar.getAdZone() : null, bVar, (AppLovinError) null);
    }

    private void a(ka kaVar, MaxAdFormat maxAdFormat, String str, fe feVar, MaxError maxError) {
        HashMap map = new HashMap();
        if (feVar != null) {
            map.putAll(a(feVar));
        } else {
            CollectionUtils.putStringIfValid("ad_unit_id", str, map);
            CollectionUtils.putStringIfValid("ad_format", maxAdFormat.getLabel(), map);
        }
        if (maxError != null) {
            CollectionUtils.putStringIfValid("error_message", maxError.getMessage(), map);
            CollectionUtils.putStringIfValid("error_code", String.valueOf(maxError.getCode()), map);
            CollectionUtils.putStringIfValid("mediated_network_error_message", maxError.getMediatedNetworkErrorMessage(), map);
            CollectionUtils.putStringIfValid("mediated_network_error_code", String.valueOf(maxError.getMediatedNetworkErrorCode()), map);
        }
        a(kaVar, (Map) map);
    }

    public void a(ka kaVar, MaxAdFormat maxAdFormat, String str, MaxError maxError) {
        a(kaVar, maxAdFormat, str, (fe) null, maxError);
    }

    public void a(ka kaVar, Object obj, Map map, long j3) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(map);
        a(kaVar, obj, arrayList, j3);
    }

    public void a(ka kaVar, String str) {
        a(kaVar, str, (Map) new HashMap());
    }

    public void a(ka kaVar, String str, Map map) {
        map.put("source", str);
        a(kaVar, map);
    }

    public void a(ka kaVar, String str, Map map, String str2) {
        if (!StringUtils.isValidString(str2) || this.f61179d.add(str2)) {
            map.put("source", str);
            a(kaVar, str, map);
        }
    }

    public void a(ka kaVar, Map map) {
        a(kaVar, (Object) null, map, 0L);
    }

    public void a(ka kaVar, Map map, long j3) {
        a(kaVar, (Object) null, map, j3);
    }

    public void a(String str, String str2, Throwable th) {
        a(str, str2, th, new HashMap());
    }

    public void a(String str, String str2, Throwable th, Map map) {
        a(str + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + str2, th, map);
    }

    public void a(String str, Throwable th) {
        a(str, th, new HashMap());
    }

    public void a(String str, Throwable th, Map map) {
        map.put("source", str);
        map.put("top_main_method", th.toString());
        ArrayList arrayList = new ArrayList();
        arrayList.add(map);
        for (Throwable th2 : th.getSuppressed()) {
            HashMap map2 = new HashMap();
            CollectionUtils.putStringIfValid("source", str, map2);
            CollectionUtils.putStringIfValid("top_main_method", th.toString(), map2);
            CollectionUtils.putStringIfValid("suppressed_throwable", th2.toString(), map2);
            arrayList.add(map2);
        }
        a(ka.R, (Object) null, arrayList, 0L);
    }

    public void a(String str, String str2, com.applovin.impl.sdk.ad.b bVar) {
        HashMap map = new HashMap();
        map.put("source", str);
        map.put("error_message", str2);
        if (bVar != null) {
            map.putAll(a(bVar, true, this.f61180e));
            boolean zK0 = bVar.K0();
            map.put("is_video_stream", String.valueOf(zK0));
            if (zK0 && (bVar instanceof com.applovin.impl.sdk.ad.a)) {
                CollectionUtils.putStringIfValid("video_url", ((com.applovin.impl.sdk.ad.a) bVar).o1(), map);
            } else {
                CollectionUtils.putStringIfValid("video_url", bVar.Q(), map);
            }
        }
        a(ka.W, (Map) map);
    }

    public static Map a(oe oeVar) {
        HashMap map = new HashMap(3);
        CollectionUtils.putStringIfValid("network_name", oeVar.c(), map);
        String strB = oeVar.b();
        CollectionUtils.putStringIfValid("adapter_class", oeVar.b(), map);
        CollectionUtils.putStringIfValid("adapter_version", ze.a(strB).getAdapterVersion(), map);
        return map;
    }

    public static Map a(MaxError maxError) {
        HashMap map = new HashMap(4);
        CollectionUtils.putStringIfValid("error_message", maxError.getMessage(), map);
        CollectionUtils.putStringIfValid("error_code", String.valueOf(maxError.getCode()), map);
        CollectionUtils.putStringIfValid("mediated_network_error_message", maxError.getMediatedNetworkErrorMessage(), map);
        CollectionUtils.putStringIfValid("mediated_network_error_code", String.valueOf(maxError.getMediatedNetworkErrorCode()), map);
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(ka kaVar, Object obj, List list) {
        if (AppLovinSdkUtils.isEmulator()) {
            return;
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f61181f.a("HealthEventsReporter", "Reporting " + kaVar.b() + " with extra parameters collection " + list);
        }
        c(kaVar, obj, list);
        d(kaVar, obj, list);
    }
}
