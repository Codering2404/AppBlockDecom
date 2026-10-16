package com.applovin.impl.sdk;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.hardware.SensorManager;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Environment;
import android.os.LocaleList;
import android.os.PowerManager;
import android.os.SystemClock;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import androidx.datastore.preferences.core.SfRj.rnFwbPAQmQTnL;
import com.applovin.impl.a4;
import com.applovin.impl.ba;
import com.applovin.impl.ca;
import com.applovin.impl.d4;
import com.applovin.impl.e4;
import com.applovin.impl.em;
import com.applovin.impl.fc;
import com.applovin.impl.jn;
import com.applovin.impl.l0;
import com.applovin.impl.sdk.array.ArrayService;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sj;
import com.applovin.impl.sr;
import com.applovin.impl.tm;
import com.applovin.impl.tp;
import com.applovin.impl.uj;
import com.applovin.impl.vi;
import com.applovin.impl.wh;
import com.applovin.impl.wp;
import com.applovin.impl.yl;
import com.applovin.impl.yp;
import com.applovin.impl.z3;
import com.applovin.sdk.AppLovinBidTokenCollectionListener;
import com.applovin.sdk.AppLovinEventTypes;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.AppLovinWebViewActivity;
import com.facebook.GraphRequest;
import com.facebook.appevents.integrity.IntegrityManager;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.NativeProtocol;
import java.io.File;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class k {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static String f63391i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final AtomicReference f63392j = new AtomicReference();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final AtomicReference f63393k = new AtomicReference();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j f63394a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final n f63395b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Context f63396c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map f63397d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Map f63399f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f63400g;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Object f63398e = new Object();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final AtomicReference f63401h = new AtomicReference();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a implements em.a {
        a() {
        }

        @Override // com.applovin.impl.em.a
        public void a(l0.a aVar) {
            k.f63392j.set(aVar);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f63403a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f63404b;

        public b(String str, int i3) {
            this.f63403a = str;
            this.f63404b = i3;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f63405a = -1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f63406b = -1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Boolean f63407c = null;
    }

    protected k(j jVar) {
        if (jVar == null) {
            throw new IllegalArgumentException("No sdk specified");
        }
        this.f63394a = jVar;
        this.f63395b = jVar.I();
        this.f63396c = j.m();
        this.f63397d = z();
        this.f63399f = y();
    }

    private double A() {
        return Math.round((((double) TimeZone.getDefault().getOffset(new Date().getTime())) * 10.0d) / 3600000.0d) / 10.0d;
    }

    private Map F() {
        return yp.a(a(null, true, false));
    }

    private JSONArray I() {
        if (z3.f()) {
            return CollectionUtils.toJSONArray(Build.SUPPORTED_ABIS);
        }
        JSONArray jSONArray = new JSONArray();
        JsonUtils.putStringIfValid(jSONArray, Build.CPU_ABI);
        JsonUtils.putStringIfValid(jSONArray, Build.CPU_ABI2);
        return jSONArray;
    }

    private boolean J() {
        try {
            if (!b()) {
                if (!c()) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private boolean K() {
        ConnectivityManager connectivityManager;
        if (z3.h() && (connectivityManager = (ConnectivityManager) this.f63396c.getSystemService("connectivity")) != null) {
            try {
                return connectivityManager.getRestrictBackgroundStatus() == 3;
            } catch (Throwable th) {
                this.f63394a.I();
                if (n.a()) {
                    this.f63394a.I().a("DataCollector", "Unable to collect constrained network info.", th);
                }
            }
        }
        return false;
    }

    private Boolean L() {
        if (z3.i()) {
            return Boolean.valueOf(this.f63396c.getResources().getConfiguration().isScreenHdr());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N() {
        this.f63401h.set(o());
    }

    private int c(String str) {
        try {
            return Settings.Secure.getInt(this.f63396c.getContentResolver(), str);
        } catch (Throwable unused) {
            return -1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x01e0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private long d() {
        /*
            Method dump skipped, instruction units count: 489
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.k.d():long");
    }

    private String g() {
        int orientation = AppLovinSdkUtils.getOrientation(this.f63396c);
        return orientation == 1 ? "portrait" : orientation == 2 ? "landscape" : IntegrityManager.INTEGRITY_TYPE_NONE;
    }

    private c h() {
        c cVar = new c();
        Intent intentRegisterReceiver = this.f63396c.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        int intExtra = intentRegisterReceiver != null ? intentRegisterReceiver.getIntExtra(AppLovinEventTypes.USER_COMPLETED_LEVEL, -1) : -1;
        int intExtra2 = intentRegisterReceiver != null ? intentRegisterReceiver.getIntExtra("scale", -1) : -1;
        if (intExtra <= 0 || intExtra2 <= 0) {
            cVar.f63406b = -1;
        } else {
            cVar.f63406b = (int) ((intExtra / intExtra2) * 100.0f);
        }
        cVar.f63405a = intentRegisterReceiver != null ? intentRegisterReceiver.getIntExtra(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, -1) : -1;
        if (z3.d()) {
            cVar.f63407c = Boolean.valueOf(Settings.Global.getInt(this.f63396c.getContentResolver(), "stay_on_while_plugged_in", -1) > 0);
            return cVar;
        }
        cVar.f63407c = Boolean.valueOf(((intentRegisterReceiver.getIntExtra("plugged", -1) & 1) | 14) > 0);
        return cVar;
    }

    private String i() {
        TelephonyManager telephonyManager = (TelephonyManager) this.f63396c.getSystemService("phone");
        if (telephonyManager == null) {
            return "";
        }
        try {
            return telephonyManager.getNetworkOperatorName();
        } catch (Throwable th) {
            if (!n.a()) {
                return "";
            }
            this.f63395b.a("DataCollector", "Unable to collect carrier", th);
            return "";
        }
    }

    private String k() {
        TelephonyManager telephonyManager = (TelephonyManager) this.f63396c.getSystemService("phone");
        return telephonyManager != null ? telephonyManager.getSimCountryIso().toUpperCase(Locale.ENGLISH) : "";
    }

    private String l() {
        Point pointB = z3.b(this.f63396c);
        int i3 = pointB.x;
        int i4 = pointB.y;
        int iC = yp.c(this.f63396c);
        return ((i3 <= i4 || !(iC == 0 || iC == 2)) && (i4 <= i3 || !(iC == 1 || iC == 3))) ? b(iC) : a(iC);
    }

    private String n() {
        if (!z3.h()) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            LocaleList locales = this.f63396c.getResources().getConfiguration().getLocales();
            for (int i3 = 0; i3 < locales.size(); i3++) {
                sb.append(locales.get(i3));
                sb.append(",");
            }
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == ',') {
                sb.deleteCharAt(sb.length() - 1);
            }
            return sb.toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    private Integer o() {
        if (((AudioManager) this.f63396c.getSystemService("audio")) == null) {
            return null;
        }
        try {
            return Integer.valueOf((int) (r0.getStreamVolume(3) * ((Float) this.f63394a.a(sj.Z3)).floatValue()));
        } catch (Throwable th) {
            this.f63394a.I();
            if (n.a()) {
                this.f63394a.I().a("DataCollector", "Unable to collect device volume", th);
            }
            return null;
        }
    }

    private float p() {
        try {
            return Settings.System.getFloat(this.f63396c.getContentResolver(), "font_scale");
        } catch (Settings.SettingNotFoundException e3) {
            if (!n.a()) {
                return -1.0f;
            }
            this.f63395b.a("DataCollector", "Error collecting font scale", e3);
            return -1.0f;
        }
    }

    private boolean q() {
        SensorManager sensorManager = (SensorManager) this.f63396c.getSystemService("sensor");
        return (sensorManager == null || sensorManager.getDefaultSensor(4) == null) ? false : true;
    }

    private Map r() {
        HashMap map = new HashMap();
        CollectionUtils.putIntegerIfValid("IABTCF_gdprApplies", this.f63394a.j0().g(), map);
        CollectionUtils.putStringIfValid("IABTCF_TCString", this.f63394a.j0().k(), map);
        CollectionUtils.putStringIfValid("IABTCF_AddtlConsent", this.f63394a.j0().c(), map);
        return map;
    }

    private Boolean s() {
        AudioManager audioManager = (AudioManager) this.f63396c.getSystemService("audio");
        if (audioManager == null) {
            return null;
        }
        return Boolean.valueOf(audioManager.isMusicActive());
    }

    private Boolean t() {
        AudioManager audioManager = (AudioManager) this.f63396c.getSystemService("audio");
        if (audioManager == null) {
            return null;
        }
        return Boolean.valueOf(audioManager.isSpeakerphoneOn());
    }

    private String u() {
        TelephonyManager telephonyManager = (TelephonyManager) this.f63396c.getSystemService("phone");
        if (telephonyManager == null) {
            return "";
        }
        try {
            String networkOperator = telephonyManager.getNetworkOperator();
            return networkOperator.substring(0, Math.min(3, networkOperator.length()));
        } catch (Throwable th) {
            if (!n.a()) {
                return "";
            }
            this.f63395b.a("DataCollector", "Unable to collect mobile country code", th);
            return "";
        }
    }

    private String v() {
        TelephonyManager telephonyManager = (TelephonyManager) this.f63396c.getSystemService("phone");
        if (telephonyManager == null) {
            return "";
        }
        try {
            String networkOperator = telephonyManager.getNetworkOperator();
            return networkOperator.substring(Math.min(3, networkOperator.length()));
        } catch (Throwable th) {
            if (!n.a()) {
                return "";
            }
            this.f63395b.a("DataCollector", "Unable to collect mobile network code", th);
            return "";
        }
    }

    private String x() {
        AudioManager audioManager = (AudioManager) this.f63396c.getSystemService("audio");
        if (audioManager == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        if (z3.g()) {
            for (AudioDeviceInfo audioDeviceInfo : audioManager.getDevices(2)) {
                sb.append(audioDeviceInfo.getType());
                sb.append(",");
            }
        } else {
            if (audioManager.isWiredHeadsetOn()) {
                sb.append(3);
                sb.append(",");
            }
            if (audioManager.isBluetoothScoOn()) {
                sb.append(7);
                sb.append(",");
            }
            if (audioManager.isBluetoothA2dpOn()) {
                sb.append(8);
            }
        }
        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == ',') {
            sb.deleteCharAt(sb.length() - 1);
        }
        String string = sb.toString();
        if (TextUtils.isEmpty(string) && n.a()) {
            this.f63395b.a("DataCollector", "No sound outputs detected");
        }
        return string;
    }

    private Map y() {
        PackageInfo packageInfo;
        HashMap map = new HashMap();
        PackageManager packageManager = this.f63396c.getPackageManager();
        ApplicationInfo applicationInfo = this.f63396c.getApplicationInfo();
        long jLastModified = new File(applicationInfo.sourceDir).lastModified();
        String installerPackageName = null;
        try {
            packageInfo = packageManager.getPackageInfo(this.f63396c.getPackageName(), 0);
            try {
                installerPackageName = packageManager.getInstallerPackageName(applicationInfo.packageName);
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            packageInfo = null;
        }
        map.put(NativeProtocol.BRIDGE_ARG_APP_NAME_STRING, packageManager.getApplicationLabel(applicationInfo));
        map.put("app_version", packageInfo != null ? packageInfo.versionName : "");
        map.put("app_version_code", Integer.valueOf(packageInfo != null ? packageInfo.versionCode : -1));
        if (installerPackageName == null) {
            installerPackageName = "";
        }
        map.put("installer_name", installerPackageName);
        map.put("tg", wp.a(this.f63394a));
        map.put(GraphRequest.DEBUG_PARAM, Boolean.valueOf(yp.c(this.f63394a)));
        map.put("ia", Long.valueOf(jLastModified));
        map.put("alts_ms", Long.valueOf(j.l()));
        map.put("j8", Boolean.valueOf(j.w0()));
        map.put("ps_tpg", Boolean.valueOf(wh.d(this.f63396c)));
        map.put("ps_apg", Boolean.valueOf(wh.b(this.f63396c)));
        map.put("ps_capg", Boolean.valueOf(wh.c(this.f63396c)));
        map.put("ps_aipg", Boolean.valueOf(wh.a(this.f63396c)));
        j jVar = this.f63394a;
        uj ujVar = uj.f64230f;
        Long l3 = (Long) jVar.a(ujVar);
        if (l3 != null) {
            map.put("ia_v2", l3);
        } else {
            this.f63394a.b(ujVar, Long.valueOf(jLastModified));
        }
        map.put("sdk_version", AppLovinSdk.VERSION);
        map.put("omid_sdk_version", this.f63394a.V().c());
        CollectionUtils.putStringIfValid("ad_review_sdk_version", com.applovin.impl.v.b(), map);
        map.put("api_did", this.f63394a.a(sj.f63741g));
        map.put("first_install_v3_ms", packageInfo != null ? Long.valueOf(packageInfo.firstInstallTime) : "");
        map.put("target_sdk", Integer.valueOf(applicationInfo.targetSdkVersion));
        if (z3.h()) {
            map.put("min_sdk", Integer.valueOf(applicationInfo.minSdkVersion));
        }
        map.put("epv", Integer.valueOf(yp.f()));
        if (this.f63394a.z0()) {
            map.put("unity_version", yp.a(this.f63394a.f0()));
        }
        return map;
    }

    public Map B() {
        Map map = CollectionUtils.map(this.f63399f);
        String str = StringUtils.isValidString(f63391i) ? f63391i : this.f63396c.getApplicationInfo().packageName;
        map.put("package_name", str);
        map.put("vz", StringUtils.toShortSHA1Hash(str));
        map.put("first_install", Boolean.valueOf(this.f63394a.t0()));
        map.put("first_install_v2", Boolean.valueOf(!this.f63394a.r0()));
        map.put("test_ads", Boolean.valueOf(this.f63400g));
        map.put("muted", Boolean.valueOf(this.f63394a.f0().isMuted()));
        if (((Boolean) this.f63394a.a(sj.B3)).booleanValue()) {
            CollectionUtils.putStringIfValid("cuid", this.f63394a.o0().c(), map);
        }
        if (((Boolean) this.f63394a.a(sj.E3)).booleanValue()) {
            map.put("compass_random_token", this.f63394a.r());
        }
        if (((Boolean) this.f63394a.a(sj.G3)).booleanValue()) {
            map.put("applovin_random_token", this.f63394a.Z());
        }
        map.putAll(r());
        if (this.f63394a.Y() != null) {
            CollectionUtils.putJsonArrayIfValid("ps_topics", this.f63394a.Y().a(), map);
        }
        return map;
    }

    public b C() {
        return (b) f63393k.get();
    }

    protected String D() {
        String strEncodeToString = Base64.encodeToString(new JSONObject(F()).toString().getBytes(Charset.defaultCharset()), 2);
        return ((Boolean) this.f63394a.a(sj.c5)).booleanValue() ? vi.b(strEncodeToString, yp.a(this.f63394a), vi.a.a(((Integer) this.f63394a.a(sj.d5)).intValue()), this.f63394a.a0(), this.f63394a) : strEncodeToString;
    }

    public String E() {
        ActivityManager activityManager = (ActivityManager) this.f63396c.getSystemService("activity");
        if (activityManager == null) {
            return null;
        }
        return activityManager.getDeviceConfigurationInfo().getGlEsVersion();
    }

    public Map G() {
        return CollectionUtils.map(this.f63399f);
    }

    public Map H() {
        return CollectionUtils.map(this.f63397d);
    }

    public boolean M() {
        return this.f63400g;
    }

    public void O() {
        tm tmVarI0 = this.f63394a.i0();
        em emVar = new em(this.f63394a, new a());
        tm.b bVar = tm.b.OTHER;
        tmVarI0.a((yl) emVar, bVar);
        this.f63394a.i0().a((yl) new jn(this.f63394a, true, "setDeviceVolume", new Runnable() { // from class: com.applovin.impl.sdk.a1
            @Override // java.lang.Runnable
            public final void run() {
                this.f63173a.N();
            }
        }), bVar);
    }

    public void P() {
        synchronized (this.f63398e) {
            a(this.f63397d);
        }
    }

    public Map e() {
        HashMap map = new HashMap();
        map.put("sc", this.f63394a.a(sj.f63765m));
        map.put("sc2", this.f63394a.a(sj.f63769n));
        map.put("sc3", this.f63394a.a(sj.f63773o));
        map.put("server_installed_at", this.f63394a.a(sj.f63777p));
        CollectionUtils.putStringIfValid("persisted_data", (String) this.f63394a.a(uj.H), map);
        return map;
    }

    public l0.a f() {
        l0.a aVarB = com.applovin.impl.l0.b(this.f63396c);
        if (aVarB == null) {
            return new l0.a();
        }
        if (((Boolean) this.f63394a.a(sj.z3)).booleanValue()) {
            if (aVarB.c() && !((Boolean) this.f63394a.a(sj.y3)).booleanValue()) {
                aVarB.a("");
            }
            f63392j.set(aVarB);
        } else {
            aVarB = new l0.a();
        }
        List<String> testDeviceAdvertisingIds = this.f63394a.x0().get() ? this.f63394a.f0().getTestDeviceAdvertisingIds() : this.f63394a.G() != null ? this.f63394a.G().getTestDeviceAdvertisingIds() : null;
        if (testDeviceAdvertisingIds == null) {
            this.f63400g = false;
            return aVarB;
        }
        String strA = aVarB.a();
        if (StringUtils.isValidString(strA)) {
            this.f63400g = testDeviceAdvertisingIds.contains(strA);
        }
        b bVarC = C();
        String str = bVarC != null ? bVarC.f63403a : null;
        if (StringUtils.isValidString(str)) {
            this.f63400g = testDeviceAdvertisingIds.contains(str) | this.f63400g;
        }
        return aVarB;
    }

    public Map j() {
        d4.d dVarA = this.f63394a.t().a();
        if (dVarA == null) {
            return null;
        }
        HashMap map = new HashMap(4);
        map.put("lrm_ts_ms", String.valueOf(dVarA.c()));
        map.put("lrm_url", dVarA.d());
        map.put("lrm_ct_ms", String.valueOf(dVarA.a()));
        map.put("lrm_rs", String.valueOf(dVarA.b()));
        return map;
    }

    public Map m() {
        return a(false);
    }

    public String w() {
        return AppLovinSdkUtils.isFireOS(this.f63396c) ? "fireos" : "android";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(AppLovinBidTokenCollectionListener appLovinBidTokenCollectionListener) {
        try {
            String strD = D();
            if (StringUtils.isValidString(strD)) {
                this.f63394a.I();
                if (n.a()) {
                    this.f63394a.I().a("DataCollector", "Successfully retrieved bid token");
                }
                fc.a(appLovinBidTokenCollectionListener, strD);
                return;
            }
            this.f63394a.I();
            if (n.a()) {
                this.f63394a.I().b("DataCollector", "Empty bid token");
            }
            fc.b(appLovinBidTokenCollectionListener, "Empty bid token");
        } catch (Throwable th) {
            if (n.a()) {
                this.f63395b.a("DataCollector", "Failed to collect bid token", th);
            }
            this.f63394a.D().a("DataCollector", "collectBidToken", th);
            fc.b(appLovinBidTokenCollectionListener, "Failed to collect bid token");
        }
    }

    private boolean c() {
        String[] strArr = {"&zpz}ld&hyy&Z|yl{|zl{'hyb", "&zk`g&z|", "&zpz}ld&k`g&z|", "&zpz}ld&qk`g&z|", "&mh}h&efjhe&qk`g&z|", "&mh}h&efjhe&k`g&z|", "&zpz}ld&zm&qk`g&z|", "&zpz}ld&k`g&oh`ezhol&z|", "&mh}h&efjhe&z|"};
        for (int i3 = 0; i3 < 9; i3++) {
            if (new File(d(strArr[i3])).exists()) {
                return true;
            }
        }
        return false;
    }

    private Map z() {
        HashMap map = new HashMap(35);
        map.put("api_level", Integer.valueOf(Build.VERSION.SDK_INT));
        map.put("brand", Build.MANUFACTURER);
        map.put("brand_name", Build.BRAND);
        map.put("hardware", Build.HARDWARE);
        map.put("sim", Boolean.valueOf(AppLovinSdkUtils.isEmulator()));
        map.put("aida", Boolean.valueOf(com.applovin.impl.l0.a()));
        map.put("locale", Locale.getDefault().toString());
        map.put(DeviceRequestsHelper.DEVICE_INFO_MODEL, Build.MODEL);
        map.put("os", Build.VERSION.RELEASE);
        map.put("platform", w());
        map.put("revision", Build.DEVICE);
        map.put("tz_offset", Double.valueOf(A()));
        map.put("gy", Boolean.valueOf(q()));
        map.put("country_code", k());
        map.put("mcc", u());
        map.put(rnFwbPAQmQTnL.HszwSJrXNBEgI, v());
        map.put("carrier", i());
        map.put("tv", Boolean.valueOf(AppLovinSdkUtils.isTv(this.f63396c)));
        map.put("pc", Integer.valueOf(Runtime.getRuntime().availableProcessors()));
        map.put("hdr", L());
        map.put("supported_abis", I());
        DisplayMetrics displayMetrics = this.f63396c.getResources().getDisplayMetrics();
        if (displayMetrics != null) {
            map.put("adns", Float.valueOf(displayMetrics.density));
            map.put("adnsd", Integer.valueOf(displayMetrics.densityDpi));
            map.put("xdpi", Float.valueOf(displayMetrics.xdpi));
            map.put("ydpi", Float.valueOf(displayMetrics.ydpi));
            z3.a aVarA = z3.a(this.f63396c, this.f63394a);
            if (aVarA != null) {
                map.put("tl_cr", Integer.valueOf(aVarA.c()));
                map.put("tr_cr", Integer.valueOf(aVarA.d()));
                map.put("bl_cr", Integer.valueOf(aVarA.a()));
                map.put("br_cr", Integer.valueOf(aVarA.b()));
            }
        }
        map.put("bt_ms", Long.valueOf(System.currentTimeMillis() - SystemClock.elapsedRealtime()));
        map.put("tbalsi_ms", Long.valueOf(this.f63394a.H() - j.l()));
        CollectionUtils.putBooleanIfValid("psase", Boolean.valueOf(wh.e(this.f63396c)), map);
        CollectionUtils.putStringIfValid("process_name", yp.b(this.f63396c), map);
        CollectionUtils.putBooleanIfValid("is_main_process", yp.g(this.f63396c), map);
        try {
            PackageInfo packageInfo = this.f63396c.getPackageManager().getPackageInfo("com.android.vending", 0);
            map.put("ps_version", packageInfo.versionName);
            map.put("ps_version_code", Integer.valueOf(packageInfo.versionCode));
        } catch (Throwable unused) {
            map.put("ps_version", "");
            map.put("ps_version_code", -1);
        }
        CollectionUtils.putBooleanIfValid("play_store_disabled", tp.a(this.f63396c), map);
        a(map);
        return map;
    }

    protected void a(final AppLovinBidTokenCollectionListener appLovinBidTokenCollectionListener) {
        this.f63394a.i0().a((yl) new jn(this.f63394a, ((Boolean) this.f63394a.a(sj.M3)).booleanValue(), "DataCollector", new Runnable() { // from class: com.applovin.impl.sdk.z0
            @Override // java.lang.Runnable
            public final void run() {
                this.f63646a.b(appLovinBidTokenCollectionListener);
            }
        }), tm.b.CORE);
    }

    public Map a(Map map, boolean z2, boolean z3) {
        HashMap map2 = new HashMap(64);
        Map mapA = a(z2);
        Map mapB = B();
        Map mapJ = j();
        Map mapC0 = this.f63394a.c0();
        if (z3) {
            map2.put(DeviceRequestsHelper.DEVICE_INFO_PARAM, mapA);
            map2.put("app_info", mapB);
            if (mapJ != null) {
                map2.put("connection_info", mapJ);
            }
            if (map != null) {
                map2.put("ad_info", map);
            }
            if (!CollectionUtils.isEmpty(mapC0)) {
                map2.put("segments", mapC0);
            }
        } else {
            map2.putAll(mapA);
            map2.putAll(mapB);
            if (mapJ != null) {
                map2.putAll(mapJ);
            }
            if (map != null) {
                map2.putAll(map);
            }
            if (!CollectionUtils.isEmpty(mapC0)) {
                map2.putAll(mapC0);
            }
        }
        map2.put("accept", "custom_size,launch_app,video");
        map2.put(GraphRequest.FORMAT_PARAM, GraphRequest.FORMAT_JSON);
        CollectionUtils.putStringIfValid("mediation_provider", this.f63394a.N(), map2);
        CollectionUtils.putStringIfValid("mediation_provider_v2", this.f63394a.y(), map2);
        CollectionUtils.putStringIfValid("plugin_version", (String) this.f63394a.a(sj.K3), map2);
        CollectionUtils.putLongIfValid("tssf_ms", Long.valueOf(this.f63394a.l0()), map2);
        if (!((Boolean) this.f63394a.a(sj.a5)).booleanValue()) {
            map2.put(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.f63394a.a0());
        }
        map2.putAll(e());
        if (((Boolean) this.f63394a.a(sj.B4)).booleanValue()) {
            ca caVarC = this.f63394a.C();
            map2.put("li", Long.valueOf(caVarC.b(ba.f58607e)));
            map2.put("si", Long.valueOf(caVarC.b(ba.f58610h)));
            map2.put("mad", Long.valueOf(caVarC.b(ba.f58608f)));
            map2.put("msad", Long.valueOf(caVarC.b(ba.f58611i)));
            map2.put("pf", Long.valueOf(caVarC.b(ba.f58615m)));
            map2.put("mpf", Long.valueOf(caVarC.b(ba.f58622t)));
            map2.put("gpf", Long.valueOf(caVarC.b(ba.f58616n)));
            map2.put("asoac", Long.valueOf(caVarC.b(ba.f58620r)));
        }
        map2.put("rid", UUID.randomUUID().toString());
        return map2;
    }

    private String b(int i3) {
        if (i3 == 0) {
            return "portrait";
        }
        if (i3 == 1) {
            return "landscape_right";
        }
        if (i3 == 2) {
            return "portrait_upside_down";
        }
        if (i3 != 3) {
            return "unknown";
        }
        return "landscape_left";
    }

    public static void b(String str) {
        if (StringUtils.isValidString(j.m().getPackageManager().getInstallerPackageName(j.m().getApplicationInfo().packageName))) {
            return;
        }
        f63391i = str;
    }

    private boolean b() {
        String str = Build.TAGS;
        return str != null && str.contains(d("lz}$blpz"));
    }

    private String d(String str) {
        int length = str.length();
        int[] iArr = {11, 12, 10, 3, 2, 1, 15, 10, 15, 14};
        char[] cArr = new char[length];
        for (int i3 = 0; i3 < length; i3++) {
            cArr[i3] = str.charAt(i3);
            for (int i4 = 9; i4 >= 0; i4--) {
                cArr[i3] = (char) (cArr[i3] ^ iArr[i4]);
            }
        }
        return new String(cArr);
    }

    public Map a(boolean z2) {
        Map map;
        synchronized (this.f63398e) {
            map = CollectionUtils.map(this.f63397d);
        }
        return a(map, z2);
    }

    private void a(Map map) {
        if (((Boolean) this.f63394a.a(sj.T3)).booleanValue() && !map.containsKey("af")) {
            map.put("af", Long.valueOf(d()));
        }
        if (((Boolean) this.f63394a.a(sj.U3)).booleanValue() && !map.containsKey("font")) {
            map.put("font", Float.valueOf(p()));
        }
        if (((Boolean) this.f63394a.a(sj.b4)).booleanValue() && yp.d(this.f63394a)) {
            sr.a(this.f63394a);
        }
        if (((Boolean) this.f63394a.a(sj.p4)).booleanValue()) {
            sr.b(this.f63394a);
        }
        if (((Boolean) this.f63394a.a(sj.a4)).booleanValue() && !map.containsKey("sua")) {
            map.put("sua", System.getProperty("http.agent"));
        }
        if (((Boolean) this.f63394a.a(sj.W3)).booleanValue() && !map.containsKey("network_restricted")) {
            map.put("network_restricted", Boolean.valueOf(K()));
        }
        if (((Boolean) this.f63394a.a(sj.f4)).booleanValue()) {
            boolean z2 = false;
            boolean z3 = this.f63396c.getResources().getConfiguration().keyboard == 2;
            boolean zHasSystemFeature = this.f63396c.getPackageManager().hasSystemFeature("com.google.android.play.feature.HPE_EXPERIENCE");
            boolean zHasSystemFeature2 = this.f63396c.getPackageManager().hasSystemFeature("android.hardware.type.pc");
            if (z3 && (zHasSystemFeature || zHasSystemFeature2)) {
                z2 = true;
            }
            map.put("is_pc", Boolean.valueOf(z2));
        }
        if (((Boolean) this.f63394a.a(sj.r4)).booleanValue()) {
            CollectionUtils.putStringIfValid("oglv", E(), map);
        }
    }

    private Map a(Map map, boolean z2) {
        l0.a aVarF;
        PowerManager powerManager;
        Map map2 = CollectionUtils.map(map);
        Point pointB = z3.b(this.f63396c);
        map2.put("dx", Integer.valueOf(pointB.x));
        map2.put("dy", Integer.valueOf(pointB.y));
        DisplayMetrics displayMetrics = this.f63396c.getResources().getDisplayMetrics();
        if (displayMetrics != null) {
            map2.put("screen_size_in", Double.valueOf(Math.sqrt(Math.pow(pointB.x, 2.0d) + Math.pow(pointB.y, 2.0d)) / ((double) displayMetrics.xdpi)));
        }
        map2.put("is_tablet", Boolean.valueOf(AppLovinSdkUtils.isTablet(this.f63396c)));
        if (z2) {
            aVarF = (l0.a) f63392j.get();
            if (aVarF != null) {
                O();
            } else if (yp.h()) {
                aVarF = new l0.a();
                map2.put("inc", Boolean.TRUE);
            } else {
                aVarF = f();
            }
        } else {
            aVarF = f();
        }
        String strA = aVarF.a();
        if (StringUtils.isValidString(strA)) {
            map2.put("idfa", strA);
        }
        map2.put("dnt", Boolean.valueOf(aVarF.c()));
        map2.put("dnt_code", aVarF.b().b());
        b bVar = (b) f63393k.get();
        if (((Boolean) this.f63394a.a(sj.A3)).booleanValue() && bVar != null) {
            map2.put("idfv", bVar.f63403a);
            map2.put("idfv_scope", Integer.valueOf(bVar.f63404b));
        }
        Boolean boolB = a4.b().b(this.f63396c);
        if (boolB != null) {
            map2.put("huc", boolB);
        }
        Boolean boolB2 = a4.c().b(this.f63396c);
        if (boolB2 != null) {
            map2.put("aru", boolB2);
        }
        Boolean boolB3 = a4.a().b(this.f63396c);
        if (boolB3 != null) {
            map2.put("dns", boolB3);
        }
        if (((Boolean) this.f63394a.a(sj.N3)).booleanValue()) {
            c cVarH = h();
            CollectionUtils.putIntegerIfValid("act", Integer.valueOf(cVarH.f63405a), map2);
            CollectionUtils.putIntegerIfValid("acm", Integer.valueOf(cVarH.f63406b), map2);
            CollectionUtils.putBooleanIfValid("sowpie", cVarH.f63407c, map2);
        }
        if (((Boolean) this.f63394a.a(sj.V3)).booleanValue()) {
            map2.put("mtl", Integer.valueOf(this.f63394a.e0().getLastTrimMemoryLevel()));
        }
        if (((Boolean) this.f63394a.a(sj.Y3)).booleanValue()) {
            map2.put("adr", Boolean.valueOf(J()));
        }
        Integer numO = z2 ? (Integer) this.f63401h.get() : o();
        if (numO != null) {
            map2.put("volume", numO);
        }
        CollectionUtils.putBooleanIfValid("ma", s(), map2);
        CollectionUtils.putBooleanIfValid("spo", t(), map2);
        CollectionUtils.putBooleanIfValid("aif", Boolean.valueOf(!this.f63394a.e0().isApplicationPaused()), map2);
        CollectionUtils.putLongIfValid("af_ts_ms", Long.valueOf(this.f63394a.e0().getAppEnteredForegroundTimeMillis()), map2);
        CollectionUtils.putLongIfValid("ab_ts_ms", Long.valueOf(this.f63394a.e0().getAppEnteredBackgroundTimeMillis()), map2);
        try {
            map2.put("sb", Integer.valueOf((int) ((Settings.System.getInt(this.f63396c.getContentResolver(), "screen_brightness") / 255.0f) * 100.0f)));
        } catch (Settings.SettingNotFoundException e3) {
            if (n.a()) {
                this.f63395b.a("DataCollector", "Unable to collect screen brightness", e3);
            }
        }
        if (((Boolean) this.f63394a.a(sj.b4)).booleanValue() && yp.d(this.f63394a)) {
            sr.a(this.f63394a);
            String strA2 = sr.a();
            if (StringUtils.isValidString(strA2)) {
                map2.put("ua", strA2);
            }
        }
        if (((Boolean) this.f63394a.a(sj.p4)).booleanValue()) {
            sr.b(this.f63394a);
            CollectionUtils.putIntegerIfValid("wvvc", Integer.valueOf(sr.d()), map2);
            CollectionUtils.putStringIfValid("wvv", sr.c(), map2);
            CollectionUtils.putStringIfValid("wvpn", sr.b(), map2);
        }
        if (((Boolean) this.f63394a.a(sj.P3)).booleanValue()) {
            try {
                map2.put("fs", Long.valueOf(Environment.getDataDirectory().getFreeSpace()));
                map2.put("tds", Long.valueOf(Environment.getDataDirectory().getTotalSpace()));
            } catch (Throwable th) {
                map2.put("fs", -1);
                map2.put("tds", -1);
                if (n.a()) {
                    this.f63395b.a("DataCollector", "Unable to collect total & free space.", th);
                }
            }
        }
        if (((Boolean) this.f63394a.a(sj.Q3)).booleanValue()) {
            ActivityManager.MemoryInfo memoryInfoA = yp.a((ActivityManager) this.f63396c.getSystemService("activity"));
            if (memoryInfoA != null) {
                map2.put("fm", Long.valueOf(memoryInfoA.availMem));
                map2.put("tm", Long.valueOf(memoryInfoA.totalMem));
                map2.put("lmt", Long.valueOf(memoryInfoA.threshold));
                map2.put("lm", Boolean.valueOf(memoryInfoA.lowMemory));
            } else {
                map2.put("fm", -1);
                map2.put("tm", -1);
                map2.put("lmt", -1);
            }
        }
        if (((Boolean) this.f63394a.a(sj.R3)).booleanValue() && z3.a("android.permission.READ_PHONE_STATE", this.f63396c) && z3.h()) {
            map2.put("rat", Integer.valueOf(((TelephonyManager) this.f63396c.getSystemService("phone")).getDataNetworkType()));
        }
        if (((Boolean) this.f63394a.a(sj.O3)).booleanValue()) {
            String strX = x();
            if (!TextUtils.isEmpty(strX)) {
                map2.put("so", strX);
            }
        }
        map2.put("device_orientation", l());
        map2.put("orientation_lock", g());
        if (((Boolean) this.f63394a.a(sj.S3)).booleanValue()) {
            map2.put("vs", Boolean.valueOf(yp.j()));
        }
        if (z3.f() && (powerManager = (PowerManager) this.f63396c.getSystemService("power")) != null) {
            map2.put("lpm", Integer.valueOf(powerManager.isPowerSaveMode() ? 1 : 0));
        }
        if (((Boolean) this.f63394a.a(sj.d4)).booleanValue() && this.f63394a.d0() != null) {
            map2.put("da", Float.valueOf(this.f63394a.d0().a()));
        }
        if (((Boolean) this.f63394a.a(sj.e4)).booleanValue() && this.f63394a.d0() != null) {
            map2.put("dm", Float.valueOf(this.f63394a.d0().b()));
        }
        map2.put("mute_switch", Integer.valueOf(this.f63394a.o().a()));
        map2.put("network", e4.g(this.f63394a));
        String strN = n();
        if (StringUtils.isValidString(strN)) {
            map2.put("kb", strN);
        }
        ArrayService arrayServiceN = this.f63394a.n();
        if (arrayServiceN.isAppHubInstalled()) {
            if (arrayServiceN.getIsDirectDownloadEnabled() != null) {
                map2.put("ah_dd_enabled", arrayServiceN.getIsDirectDownloadEnabled());
            }
            map2.put("ah_sdk_version_code", Long.valueOf(arrayServiceN.getAppHubVersionCode()));
            map2.put("ah_random_user_token", StringUtils.emptyIfNull(arrayServiceN.getRandomUserToken()));
            map2.put("ah_sdk_package_name", StringUtils.emptyIfNull(arrayServiceN.getAppHubPackageName()));
        }
        return map2;
    }

    private String a(int i3) {
        if (i3 == 0) {
            return "landscape_right";
        }
        if (i3 == 1) {
            return "portrait_upside_down";
        }
        if (i3 == 2) {
            return "landscape_left";
        }
        if (i3 != 3) {
            return "unknown";
        }
        return "portrait";
    }

    public static void a(l0.a aVar) {
        f63392j.set(aVar);
    }

    public static void a(b bVar) {
        f63393k.set(bVar);
    }

    private boolean a(String str) {
        return c(str) == 1;
    }
}
