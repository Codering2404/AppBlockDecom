package com.applovin.impl;

import android.R;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.Toast;
import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.ad.AppLovinAdImpl;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.AppLovinUtils;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.MaxNetworkResponseInfo;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinSdkSettings;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.AppLovinWebViewActivity;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.AnalyticsEvents;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.net.NetworkInterface;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class yp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f65243a = {60, 60, 24, 7, 4, 12};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String[] f65244b = {" second", " minute", " hour", " day", " week", " month"};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String[] f65245c = {"s", "m", "h", "d", "w", "mth"};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final DecimalFormat f65246d = new DecimalFormat();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Random f65247e = new Random();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Boolean f65248f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static Boolean f65249g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static String f65250h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static Boolean f65251i;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a implements Comparator {
        a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(String str, String str2) {
            return str.compareToIgnoreCase(str2);
        }
    }

    public static double a(long j3) {
        return j3 / 1024.0d;
    }

    public static float b(float f3) {
        return f3 * 1000.0f;
    }

    public static double d(long j3) {
        return j3 / 1000.0d;
    }

    public static boolean e(Context context) {
        return t0.a(context).a("applovin.sdk.is_test_environment");
    }

    public static int f() {
        return 2015001;
    }

    public static Boolean g(Context context) {
        if (context == null) {
            return null;
        }
        Boolean bool = f65251i;
        if (bool != null) {
            return bool;
        }
        try {
            String strA = t0.a(context).a();
            String strB = b(context);
            if (strB == null) {
                return null;
            }
            if (strB.equals(strA)) {
                Boolean bool2 = Boolean.TRUE;
                f65251i = bool2;
                return bool2;
            }
            if (TextUtils.isEmpty(strA) && strB.equals(context.getPackageName())) {
                Boolean bool3 = Boolean.TRUE;
                f65251i = bool3;
                return bool3;
            }
            Boolean bool4 = Boolean.FALSE;
            f65251i = bool4;
            return bool4;
        } catch (Throwable th) {
            com.applovin.impl.sdk.n.b("Utils", "Unable to determine if the current process is the main process", th);
            return null;
        }
    }

    public static boolean h() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static boolean i(Context context) {
        String packageName = context.getPackageName();
        return "com.revolverolver.fliptrickster".equals(packageName) || "com.mindstormstudios.idlemakeover".equals(packageName);
    }

    public static boolean j(Context context) {
        if (context == null) {
            return false;
        }
        try {
            context.getResources();
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean k(Context context) {
        if (context == null) {
            context = com.applovin.impl.sdk.j.m();
        }
        if (context != null) {
            return t0.a(context).a("applovin.sdk.verbose_logging", false);
        }
        return false;
    }

    public static String l(Context context) {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.setPackage(context.getPackageName());
        List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
        if (listQueryIntentActivities.isEmpty()) {
            return null;
        }
        return listQueryIntentActivities.get(0).activityInfo.name;
    }

    public static int a(int i3, int i4) {
        return (i3 < 0 || i3 > 100) ? i4 : i3;
    }

    public static int b(int i3) {
        return i3 * 1024;
    }

    public static void c() {
    }

    public static Context d(Context context) {
        return j(context) ? context : com.applovin.impl.sdk.j.m();
    }

    public static boolean e(com.applovin.impl.sdk.j jVar) {
        return ((Boolean) jVar.a(sj.f63780p2)).booleanValue() ? jVar.f0().isMuted() : ((Boolean) jVar.a(sj.f63772n2)).booleanValue();
    }

    public static int f(String str) {
        int i3 = 0;
        for (String str2 : str.replaceAll("-beta", ".").split("\\.")) {
            if (str2.length() > 2) {
                com.applovin.impl.sdk.n.h("Utils", "Version number components cannot be longer than two digits -> " + str);
                return i3;
            }
            i3 = (i3 * 100) + Integer.parseInt(str2);
        }
        return !str.contains("-beta") ? (i3 * 100) + 99 : i3;
    }

    public static boolean h(Context context) {
        if (f65249g == null) {
            f65249g = Boolean.valueOf("com.applovin.apps.playables".equals(context.getPackageName()));
        }
        return f65249g.booleanValue();
    }

    public static boolean j() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                String displayName = networkInterfaces.nextElement().getDisplayName();
                if (displayName.contains("tun") || displayName.contains("ppp") || displayName.contains("ipsec")) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            com.applovin.impl.sdk.n.c("Utils", "Unable to check Network Interfaces", th);
            return false;
        }
    }

    public static void a() {
    }

    public static long b(long j3) {
        return j3 * 8;
    }

    public static double c(long j3) {
        return a(b(j3));
    }

    public static boolean d(com.applovin.impl.sdk.j jVar) {
        String str = jVar.f0().getExtraParameters().get("user_agent_collection_enabled");
        if (StringUtils.isValidString(str)) {
            return Boolean.parseBoolean(str);
        }
        return true;
    }

    public static boolean i() {
        return !a("com.applovin.sdk.AppLovinSdk");
    }

    public static boolean k() {
        Context contextM = com.applovin.impl.sdk.j.m();
        if (contextM != null) {
            return t0.a(contextM).a("applovin.sdk.verbose_logging");
        }
        return false;
    }

    public static boolean a(long j3, long j4) {
        return (j3 & j4) != 0;
    }

    public static void b() {
    }

    public static int c(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager == null) {
            return 0;
        }
        return windowManager.getDefaultDisplay().getRotation();
    }

    public static boolean a(MaxAdFormat maxAdFormat, MaxAdFormat maxAdFormat2) {
        if (maxAdFormat == null || maxAdFormat2 == null) {
            return false;
        }
        if (maxAdFormat == maxAdFormat2) {
            return true;
        }
        if (maxAdFormat.isAdViewAd() && maxAdFormat2.isAdViewAd()) {
            return true;
        }
        return maxAdFormat.isFullscreenAd() && maxAdFormat2.isFullscreenAd();
    }

    private static long b(String str) {
        if (str == null) {
            return 0L;
        }
        return new File(str).length();
    }

    public static long d(String str) {
        if (!StringUtils.isValidString(str)) {
            return Long.MAX_VALUE;
        }
        try {
            return Color.parseColor(str);
        } catch (Throwable unused) {
            return Long.MAX_VALUE;
        }
    }

    public static String e(String str) {
        if (str != null && str.length() > 4) {
            return str.substring(str.length() - 4);
        }
        return "NOKEY";
    }

    public static List a(boolean z2, com.applovin.impl.sdk.ad.b bVar, com.applovin.impl.sdk.j jVar, Context context) {
        if (bVar instanceof aq) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList(bVar.i());
        int size = arrayList2.size();
        boolean z3 = false;
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                break;
            }
            Object obj = arrayList2.get(i3);
            i3++;
            Uri uri = (Uri) obj;
            boolean zC = jVar.A().c(uri.getLastPathSegment(), context);
            boolean z4 = ((Boolean) jVar.a(sj.H5)).booleanValue() && b(uri.getPath()) == 0;
            if (!zC || z4) {
                jVar.I();
                if (com.applovin.impl.sdk.n.a()) {
                    jVar.I().b("Utils", "Cached HTML asset missing: " + uri);
                }
                arrayList.add(uri);
            }
        }
        Uri uriU0 = bVar.u0();
        if (z2 && uriU0 != null) {
            boolean zC2 = jVar.A().c(uriU0.getLastPathSegment(), context);
            if (((Boolean) jVar.a(sj.H5)).booleanValue() && b(uriU0.getPath()) == 0) {
                z3 = true;
            }
            if (!zC2 || z3) {
                jVar.I();
                if (com.applovin.impl.sdk.n.a()) {
                    jVar.I().b("Utils", "Cached video missing: " + uriU0);
                }
                arrayList.add(uriU0);
            }
        }
        return arrayList;
    }

    public static String b(Context context) {
        int iMyPid;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (context == null) {
            return null;
        }
        if (StringUtils.isValidString(f65250h)) {
            return f65250h;
        }
        try {
            iMyPid = Process.myPid();
            runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        } catch (Throwable th) {
            com.applovin.impl.sdk.n.b("Utils", "Unable to determine process name", th);
        }
        if (runningAppProcesses == null) {
            com.applovin.impl.sdk.n.c("Utils", "No running app processes. Unable to determine process name");
            return null;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (iMyPid == runningAppProcessInfo.pid) {
                String str = runningAppProcessInfo.processName;
                f65250h = str;
                return str;
            }
        }
        return null;
    }

    public static String c(String str) {
        return str.replace("ALPlayableAnalytics.trackEvent = ", "ALPlayableAnalytics.trackEvent = function (eventName) {const SDK_URL = 'applovin://com.applovin.sdk/playable_event';if (!Object.values(ALPlayableEvent).includes(eventName)) {var aTag = document.createElement('a');aTag.setAttribute('href', SDK_URL + '?success=0&type=' + encodeURIComponent(eventName));aTag.innerHTML = 'empty';aTag.click();return;}var aTag = document.createElement('a');aTag.setAttribute('href', SDK_URL + '?success=1&type=' + encodeURIComponent(eventName));aTag.innerHTML = 'empty';aTag.click();}; ALPlayableAnalytics.trackEvent_ignore = ");
    }

    public static boolean c(com.applovin.impl.sdk.j jVar) {
        String str = jVar.f0().getExtraParameters().get("run_in_release_mode");
        return ((StringUtils.isValidString(str) && Boolean.parseBoolean(str)) || (com.applovin.impl.sdk.j.m().getApplicationInfo().flags & 2) == 0) ? false : true;
    }

    public static byte[] d(byte[] bArr) throws IOException {
        if (bArr == null || bArr.length == 0 || !b(bArr)) {
            return bArr;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPInputStream gZIPInputStream = new GZIPInputStream(new ByteArrayInputStream(bArr));
        byte[] bArr2 = new byte[1024];
        while (true) {
            int i3 = gZIPInputStream.read(bArr2);
            if (i3 > 0) {
                byteArrayOutputStream.write(bArr2, 0, i3);
            } else {
                gZIPInputStream.close();
                byteArrayOutputStream.close();
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    public static String e() {
        try {
            for (Field field : Build.VERSION_CODES.class.getFields()) {
                if (field.getInt(null) == Build.VERSION.SDK_INT) {
                    return field.getName();
                }
            }
            return "";
        } catch (Throwable th) {
            com.applovin.impl.sdk.n.c("Utils", "Unable to get Android SDK codename", th);
            return "";
        }
    }

    public static boolean f(Context context) {
        if (f65248f == null) {
            f65248f = Boolean.valueOf("com.applovin.apps.dspdemo".equals(context.getPackageName()));
        }
        return f65248f.booleanValue();
    }

    public static long c(float f3) {
        return a(b(f3));
    }

    public static boolean g() {
        ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
        try {
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
        } catch (Throwable th) {
            com.applovin.impl.sdk.n.c("Utils", "Exception thrown while getting memory state.", th);
        }
        int i3 = runningAppProcessInfo.importance;
        return i3 == 100 || i3 == 200;
    }

    public static long c(byte[] bArr) {
        return a(bArr, 0);
    }

    public static String b(Class cls, String str) {
        try {
            Field fieldA = a(cls, str);
            fieldA.setAccessible(true);
            return (String) fieldA.get(null);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String d() {
        try {
            return Build.VERSION.RELEASE + " (" + e() + " - API " + Build.VERSION.SDK_INT + ")";
        } catch (Throwable th) {
            com.applovin.impl.sdk.n.c("Utils", "Unable to get Android OS info", th);
            return "";
        }
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Class.forName(str);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean b(byte[] bArr) {
        return bArr.length >= 2 && bArr[0] == 31 && bArr[1] == -117;
    }

    public static void b(String str, String str2) {
        if (str == null || str.length() <= b(8)) {
            return;
        }
        com.applovin.impl.sdk.n.j(str2, "Provided custom data parameter longer than supported (" + str.length() + " bytes, " + b(8) + " maximum)");
    }

    public static boolean a(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (a((String) it.next())) {
                return true;
            }
        }
        return false;
    }

    public static WebView b(Context context, String str) {
        return a(context, str, false);
    }

    public static void a(Closeable closeable, com.applovin.impl.sdk.j jVar) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (Throwable th) {
            if (jVar != null) {
                jVar.I();
                if (com.applovin.impl.sdk.n.a()) {
                    jVar.I().a("Utils", "Unable to close stream: " + closeable, th);
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void b(AppLovinAd appLovinAd, com.applovin.impl.sdk.j jVar) {
        if (appLovinAd instanceof AppLovinAdBase) {
            AppLovinAdBase appLovinAdBase = (AppLovinAdBase) appLovinAd;
            String strA0 = jVar.a0();
            String strA02 = appLovinAdBase.getSdk().a0();
            if (strA0.equals(strA02)) {
                return;
            }
            String str = "Ad was loaded from sdk with key: " + strA02 + ", but is being rendered from sdk with key: " + strA0;
            com.applovin.impl.sdk.n.h("AppLovinAd", str);
            jVar.C().c(ba.f58619q);
            a(str, appLovinAdBase, "AppLovinAd", jVar);
        }
    }

    public static int a(String str, String str2) {
        String digitsOnlyVersionString = StringUtils.toDigitsOnlyVersionString(str);
        String digitsOnlyVersionString2 = StringUtils.toDigitsOnlyVersionString(str2);
        try {
            String[] strArrSplit = digitsOnlyVersionString.split("\\.");
            String[] strArrSplit2 = digitsOnlyVersionString2.split("\\.");
            int iMax = Math.max(strArrSplit.length, strArrSplit2.length);
            for (int i3 = 0; i3 < iMax; i3++) {
                boolean zIsValidString = StringUtils.isValidString(strArrSplit[i3]);
                String str3 = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                String str4 = zIsValidString ? strArrSplit[i3] : AppEventsConstants.EVENT_PARAM_VALUE_NO;
                if (StringUtils.isValidString(strArrSplit2[i3])) {
                    str3 = strArrSplit2[i3];
                }
                int i4 = Integer.parseInt(str4);
                int i5 = Integer.parseInt(str3);
                if (i4 < i5) {
                    return -1;
                }
                if (i4 > i5) {
                    return 1;
                }
            }
            return 0;
        } catch (Throwable th) {
            com.applovin.impl.sdk.n.c("Utils", "Failed to process version string.", th);
            return 0;
        }
    }

    public static boolean b(com.applovin.impl.sdk.j jVar) {
        if (!z3.e()) {
            return true;
        }
        try {
            JSONObject.wrap(JSONObject.NULL);
            return true;
        } catch (Throwable th) {
            jVar.I();
            if (!com.applovin.impl.sdk.n.a()) {
                return false;
            }
            jVar.I().d("Utils", "Failed to wrap JSONObject with exception", th);
            return false;
        }
    }

    public static void a(HttpURLConnection httpURLConnection, com.applovin.impl.sdk.j jVar) {
        if (httpURLConnection == null) {
            return;
        }
        try {
            httpURLConnection.disconnect();
        } catch (Throwable th) {
            if (jVar != null) {
                jVar.I();
                if (com.applovin.impl.sdk.n.a()) {
                    jVar.I().a("Utils", "Unable to disconnect connection: " + httpURLConnection, th);
                }
            }
        }
    }

    public static boolean b(List list) {
        Context contextM = com.applovin.impl.sdk.j.m();
        if (contextM == null) {
            com.applovin.impl.sdk.n.h("Utils", "Failed to check whether or not app is member of package names");
            return false;
        }
        return list.contains(contextM.getPackageName());
    }

    public static String a(Map map, boolean z2) {
        if (map != null && !map.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            if (z2) {
                TreeMap treeMap = new TreeMap(new a());
                treeMap.putAll(map);
                map = treeMap;
            }
            for (Map.Entry entry : map.entrySet()) {
                if (sb.length() > 0) {
                    sb.append("&");
                }
                Object value = entry.getValue();
                if (value instanceof String) {
                    String str = (String) value;
                    if (str.contains("&")) {
                        value = str.replace("&", "%26");
                    }
                }
                sb.append(entry.getKey());
                sb.append('=');
                sb.append(value);
            }
            return sb.toString();
        }
        return "";
    }

    private static long a(float f3) {
        return Math.round(f3);
    }

    public static String a(Object obj) {
        if (obj instanceof fe) {
            return ((fe) obj).R();
        }
        if (ze.a(obj)) {
            return ((com.applovin.impl.sdk.ad.b) obj).I();
        }
        return null;
    }

    public static int a(Context context) {
        z3.d();
        return Settings.System.getInt(context.getContentResolver(), "always_finish_activities", 0);
    }

    public static String a(nh nhVar) {
        if (nhVar == null) {
            return "Unknown error";
        }
        Throwable cause = nhVar.getCause();
        String message = cause != null ? cause.getMessage() : AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
        return "Code: " + nhVar.f62049a + ", Name: " + nhVar.a() + ", Message: " + nhVar.getMessage() + ", Cause Class: " + (cause != null ? cause.getClass().getName() : "") + ", Cause Message: " + message;
    }

    public static Field a(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Class superclass = cls.getSuperclass();
            if (superclass == null) {
                return null;
            }
            return a(superclass, str);
        }
    }

    public static String a(Uri uri, String str, com.applovin.impl.sdk.j jVar) {
        List listC = jVar.c(sj.G0);
        String lastPathSegment = uri.getLastPathSegment();
        if (listC.contains(lastPathSegment)) {
            return lastPathSegment;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = uri.getQueryParameterNames().iterator();
        while (it.hasNext()) {
            String queryParameter = uri.getQueryParameter(it.next());
            if (StringUtils.isValidString(queryParameter)) {
                arrayList.add(queryParameter);
            }
        }
        arrayList.addAll(uri.getPathSegments());
        String strEncodeUriString = StringUtils.encodeUriString(TextUtils.join("_", arrayList));
        Integer num = (Integer) jVar.a(sj.H0);
        int length = StringUtils.emptyIfNull(strEncodeUriString).length() + StringUtils.emptyIfNull(str).length();
        if (length > num.intValue() && StringUtils.isValidString(strEncodeUriString)) {
            strEncodeUriString = strEncodeUriString.substring(length - num.intValue());
        }
        if (!StringUtils.isValidString(strEncodeUriString) || !StringUtils.isValidString(str)) {
            return strEncodeUriString;
        }
        return str + strEncodeUriString;
    }

    public static ActivityManager.MemoryInfo a(ActivityManager activityManager) {
        if (activityManager == null) {
            return null;
        }
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        try {
            activityManager.getMemoryInfo(memoryInfo);
            return memoryInfo;
        } catch (Throwable th) {
            com.applovin.impl.sdk.n.b("Utils", "Unable to collect memory info.", th);
            return null;
        }
    }

    public static List a(JSONObject jSONObject, String str, String str2, com.applovin.impl.sdk.j jVar) {
        return a(jSONObject, str, null, str2, null, false, jVar);
    }

    public static List a(JSONObject jSONObject, String str, Map map, String str2, Map map2, boolean z2, com.applovin.impl.sdk.j jVar) {
        if (map == null) {
            map = new HashMap(1);
        }
        Map map3 = map;
        map3.put("{CLCODE}", str);
        return a(jSONObject, map3, str2, map2, z2, jVar);
    }

    public static List a(JSONObject jSONObject, Map map, String str, Map map2, boolean z2, com.applovin.impl.sdk.j jVar) {
        ArrayList arrayList = new ArrayList(jSONObject.length() + 1);
        if (StringUtils.isValidString(str)) {
            arrayList.add(new s(str, null, map2, z2));
        }
        if (jSONObject.length() > 0) {
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                try {
                    String next = itKeys.next();
                    if (!TextUtils.isEmpty(next)) {
                        String strOptString = jSONObject.optString(next);
                        String strReplace = StringUtils.replace(next, map);
                        if (AppLovinSdkUtils.isValidString(strOptString)) {
                            strOptString = StringUtils.replace(strOptString, map);
                        }
                        arrayList.add(new s(strReplace, strOptString, map2, z2));
                    }
                } catch (Throwable th) {
                    jVar.I();
                    if (com.applovin.impl.sdk.n.a()) {
                        jVar.I().a("Utils", "Failed to create and add postback url.", th);
                    }
                }
            }
        }
        return arrayList;
    }

    public static String a(long j3, boolean z2) {
        String str;
        String[] strArr = z2 ? f65244b : f65245c;
        long jCurrentTimeMillis = (System.currentTimeMillis() - j3) / 1000;
        for (int i3 = 0; i3 < strArr.length; i3++) {
            long j4 = f65243a[i3];
            if (jCurrentTimeMillis < j4) {
                if (jCurrentTimeMillis <= 0) {
                    return z2 ? "just now" : "now";
                }
                String str2 = "";
                if (!z2 || jCurrentTimeMillis <= 1) {
                    str = "";
                } else {
                    str = "s";
                }
                if (z2) {
                    str2 = " ago";
                }
                return String.format("%d%s%s%s", Long.valueOf(jCurrentTimeMillis), strArr[i3], str, str2);
            }
            jCurrentTimeMillis /= j4;
        }
        return z2 ? "just now" : "now";
    }

    public static String a(int i3, Context context, com.applovin.impl.sdk.j jVar) {
        if (i3 == 0) {
            return "";
        }
        try {
            InputStream inputStreamOpenRawResource = context.getResources().openRawResource(i3);
            try {
                byte[] bArr = new byte[inputStreamOpenRawResource.available()];
                inputStreamOpenRawResource.read(bArr);
                return new String(bArr);
            } catch (IOException e3) {
                if (jVar != null) {
                    jVar.I();
                    if (com.applovin.impl.sdk.n.a()) {
                        jVar.I().a("Utils", "Opening raw resource file threw exception", e3);
                    }
                }
                return "";
            } finally {
                a(inputStreamOpenRawResource, jVar);
            }
        } catch (Throwable th) {
            if (jVar != null) {
                jVar.I();
                if (com.applovin.impl.sdk.n.a()) {
                    jVar.I().a("Utils", "Failed to retrieve resource " + i3, th);
                }
            }
            return "";
        }
    }

    public static long a(com.applovin.impl.sdk.j jVar) {
        long jLongValue = ((Long) jVar.a(sj.v5)).longValue();
        long jLongValue2 = ((Long) jVar.a(sj.w5)).longValue();
        long jCurrentTimeMillis = System.currentTimeMillis();
        return (jLongValue <= 0 || jLongValue2 <= 0) ? jCurrentTimeMillis : jCurrentTimeMillis + (jLongValue - jLongValue2);
    }

    public static boolean a(double d3) {
        if (d3 >= 100.0d) {
            return true;
        }
        return d3 > 0.0d && ((double) f65247e.nextFloat()) < d3 / 100.0d;
    }

    public static String a(AppLovinSdkSettings appLovinSdkSettings) {
        String strEmptyIfNull = StringUtils.emptyIfNull(appLovinSdkSettings.getExtraParameters().get("applovin_unity_metadata"));
        if (TextUtils.isEmpty(strEmptyIfNull)) {
            return null;
        }
        Map<String, String> mapTryToStringMap = JsonUtils.tryToStringMap(JsonUtils.jsonObjectFromJsonString(strEmptyIfNull, new JSONObject()));
        if (CollectionUtils.isEmpty(mapTryToStringMap)) {
            return null;
        }
        return mapTryToStringMap.get("UnityVersion");
    }

    public static int a(int i3) {
        return a(i3, 95);
    }

    public static h0 a(JSONObject jSONObject, com.applovin.impl.sdk.j jVar) {
        return h0.a(AppLovinAdSize.fromString(JsonUtils.getString(jSONObject, "ad_size", null)), AppLovinAdType.fromString(JsonUtils.getString(jSONObject, AppEventsConstants.EVENT_PARAM_AD_TYPE, null)), JsonUtils.getString(jSONObject, AppLovinUtils.ServerParameterKeys.ZONE_ID, null), true, JsonUtils.getBoolean(jSONObject, "is_direct_sold", Boolean.FALSE).booleanValue());
    }

    public static byte[] a(byte[] bArr) throws IOException {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        gZIPOutputStream.write(bArr);
        gZIPOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    public static boolean a(AppLovinAdSize appLovinAdSize) {
        return appLovinAdSize == AppLovinAdSize.BANNER || appLovinAdSize == AppLovinAdSize.MREC || appLovinAdSize == AppLovinAdSize.LEADER;
    }

    public static boolean a(String str, List list) {
        return StringUtils.startsWithAtLeastOnePrefix(str, list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(Context context, String str) {
        Toast toastMakeText = Toast.makeText(context, str, 0);
        toastMakeText.setMargin(0.0f, 0.1f);
        toastMakeText.show();
    }

    public static void a(String str, MaxAdFormat maxAdFormat, JSONObject jSONObject, com.applovin.impl.sdk.j jVar) {
        if (jSONObject.has("no_fill_reason")) {
            Object object = JsonUtils.getObject(jSONObject, "no_fill_reason", new Object());
            StringBuilder sb = new StringBuilder();
            sb.append("\n**************************************************\nNO FILL received:\n..ID: \"");
            sb.append(str);
            sb.append("\"\n..FORMAT: \"");
            sb.append(maxAdFormat != null ? maxAdFormat.getLabel() : "None");
            sb.append("\"\n..SDK KEY: \"");
            sb.append(jVar.a0());
            sb.append("\"\n..PACKAGE NAME: \"");
            sb.append(com.applovin.impl.sdk.j.m().getPackageName());
            sb.append("\"\n..Reason: ");
            sb.append(object);
            sb.append("\n**************************************************\n");
            String string = sb.toString();
            jVar.I();
            if (com.applovin.impl.sdk.n.a()) {
                jVar.I().b("AppLovinSdk", string);
            }
        }
    }

    public static AppLovinAd a(AppLovinAd appLovinAd, com.applovin.impl.sdk.j jVar) {
        if (!(appLovinAd instanceof com.applovin.impl.sdk.ad.c)) {
            return appLovinAd;
        }
        com.applovin.impl.sdk.ad.c cVar = (com.applovin.impl.sdk.ad.c) appLovinAd;
        AppLovinAd appLovinAdDequeueAd = jVar.j().dequeueAd(cVar.getAdZone());
        jVar.I();
        if (com.applovin.impl.sdk.n.a()) {
            jVar.I().a("Utils", "Dequeued ad for dummy ad: " + appLovinAdDequeueAd);
        }
        if (appLovinAdDequeueAd != null) {
            cVar.a(appLovinAdDequeueAd);
            ((AppLovinAdImpl) appLovinAdDequeueAd).setDummyAd(cVar);
            return appLovinAdDequeueAd;
        }
        return cVar.f();
    }

    public static void a(com.applovin.impl.sdk.j jVar, String str) {
        String strA0 = jVar.a0();
        if (((Boolean) jVar.a(sj.C)).booleanValue()) {
            if (strA0 == null || strA0.length() != 86) {
                a(TextUtils.isEmpty(strA0) ? "Empty SDK key" : "Invalid SDK key length", str, jVar);
            }
        }
    }

    public static void a(String str, String str2, Map map) {
        if (map.containsKey(str)) {
            map.put(str2, map.get(str));
            map.remove(str);
        }
    }

    private static void a(String str, AppLovinAdBase appLovinAdBase, String str2, com.applovin.impl.sdk.j jVar) {
        StringBuilder sb = new StringBuilder();
        sb.append("sdkKey=");
        sb.append(jVar.a0());
        if (appLovinAdBase != null) {
            sb.append(",adSdkKey=");
            sb.append(appLovinAdBase.getSdk().a0());
        }
        HashMap map = new HashMap();
        CollectionUtils.putStringIfValid("details", sb.toString(), map);
        CollectionUtils.putStringIfValid("error_message", str, map);
        jVar.D().a(ka.V, str2, (Map) map);
    }

    private static void a(String str, String str2, com.applovin.impl.sdk.j jVar) {
        a(str, (AppLovinAdBase) null, str2, jVar);
    }

    public static boolean a(sj sjVar, com.applovin.impl.sdk.j jVar) {
        String str = jVar.f0().getExtraParameters().get("enable_black_screen_fixes");
        if (StringUtils.isValidString(str)) {
            return Boolean.parseBoolean(str);
        }
        return ((Boolean) jVar.a(sjVar)).booleanValue();
    }

    public static boolean a(String str, com.applovin.impl.sdk.j jVar) {
        if (str == null) {
            return false;
        }
        return StringUtils.containsAtLeastOneSubstring(str, jVar.c(sj.f63804x0));
    }

    public static void a(MaxError maxError, String str, Context context) {
        StringBuilder sb = new StringBuilder();
        if (maxError.getCode() == -5001) {
            for (MaxNetworkResponseInfo maxNetworkResponseInfo : maxError.getWaterfall().getNetworkResponses()) {
                MaxError error = maxNetworkResponseInfo.getError();
                String name = maxNetworkResponseInfo.getMediatedNetwork().getName();
                sb.append("\nFailed to load " + str + " from " + name + ":\n");
                sb.append("\nMAX Error " + error.getCode() + ": " + error.getMessage() + "\n");
                sb.append("\n" + name + " Error " + error.getMediatedNetworkErrorCode() + ": " + error.getMediatedNetworkErrorMessage() + "\n\n");
            }
        } else {
            sb.append("Failed to load " + str + " with error " + maxError.getCode() + ": " + maxError.getMessage());
        }
        a("", sb.toString(), context);
    }

    public static void a(final String str, final Context context) {
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.z80
            @Override // java.lang.Runnable
            public final void run() {
                yp.a(context, str);
            }
        });
    }

    public static void a(String str, MaxAd maxAd, Context context) {
        Toast.makeText(context, maxAd.getFormat().getLabel() + ": " + str, 1).show();
    }

    public static void a(Uri uri, Activity activity, com.applovin.impl.sdk.j jVar) {
        if (activity == null) {
            activity = jVar.m0();
        }
        Intent intent = new Intent(activity, (Class<?>) AppLovinWebViewActivity.class);
        intent.putExtra(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, jVar.a0());
        intent.putExtra(AppLovinWebViewActivity.INTENT_EXTRA_KEY_LOAD_URL, uri.toString());
        activity.startActivity(intent);
    }

    public static Map a(Map map) {
        HashMap map2 = new HashMap();
        if (map != null && !map.isEmpty()) {
            for (Map.Entry entry : map.entrySet()) {
                map2.put((String) entry.getKey(), String.valueOf(entry.getValue()));
            }
        }
        return map2;
    }

    public static long a(byte[] bArr, int i3) {
        int i4 = i3 + 8;
        if (bArr.length < i4) {
            throw new IllegalArgumentException("byte array must be at least 8 bytes long");
        }
        long j3 = 0;
        while (i3 < i4) {
            j3 |= (((long) bArr[i3]) & 255) << (i3 * 8);
            i3++;
        }
        return j3;
    }

    public static Map a(Map map, com.applovin.impl.sdk.j jVar) {
        Map map2 = CollectionUtils.map(map);
        for (String str : map2.keySet()) {
            String str2 = (String) map2.get(str);
            if (str2 != null) {
                map2.put(str, StringUtils.encodeUriString(str2));
            }
        }
        return map2;
    }

    public static double a(String str, double d3) {
        try {
            return Double.parseDouble(str);
        } catch (Throwable th) {
            com.applovin.impl.sdk.n.c("Utils", "Failed to parse double from String: " + str, th);
            return d3;
        }
    }

    public static WebView a(Context context, String str, boolean z2) {
        try {
            WebView webView = new WebView(context);
            if (!z2) {
                return webView;
            }
            webView.setWebViewClient(new pi());
            return webView;
        } catch (Throwable th) {
            com.applovin.impl.sdk.n.c("Utils", "Failed to initialize WebView for " + str + ".", th);
            return null;
        }
    }

    public static void a(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setPriority(1);
        thread.start();
    }

    public static void a(String str, String str2, Context context) {
        new AlertDialog.Builder(context).setTitle(str).setMessage(str2).setNegativeButton(R.string.ok, (DialogInterface.OnClickListener) null).create().show();
    }
}
