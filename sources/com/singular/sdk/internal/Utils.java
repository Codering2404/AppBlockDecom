package com.singular.sdk.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Looper;
import android.provider.Settings;
import androidx.media3.exoplayer.audio.wRw.CbYNFSEGaQj;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.common.Utf8Charset;
import com.google.android.gms.appset.AppSet;
import com.google.android.gms.appset.AppSetIdInfo;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.singular.sdk.SingularLinkHandler;
import com.singular.sdk.SingularLinkParams;
import com.singular.sdk.internal.services.SingularTimeProvider;
import com.singular.sdk.internal.services.TimeService;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public class Utils {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static double f92743b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static int f92744c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f92745d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final SingularLog f92742a = SingularLog.f(Utils.class.getSimpleName());

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static TimeService f92746e = new TimeService(new SingularTimeProvider());

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static String f92747f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static String f92748g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static String f92749h = null;

    static long A(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("pref-event-index", 0);
        return P(sharedPreferences, sharedPreferences.getLong("event-index", -1L));
    }

    public static String B() {
        return f92749h;
    }

    public static Set C() {
        HashSet hashSet = new HashSet();
        hashSet.add("");
        hashSet.add("9774d56d682e549c");
        hashSet.add("unknown");
        hashSet.add("000000000000000");
        hashSet.add("Android");
        hashSet.add("DEFACE");
        hashSet.add("00000000-0000-0000-0000-000000000000");
        hashSet.add("0000-0000");
        return hashSet;
    }

    static Locale D(Configuration configuration) {
        Locale localeD = SLReflectionUtils.d(configuration);
        return localeD != null ? localeD : SLReflectionUtils.c(configuration);
    }

    public static String E(Context context) {
        return context.getSharedPreferences("pref_persisted_asid", 0).getString("persisted_asid", null);
    }

    public static String F(Context context) {
        try {
            String str = (String) SLReflectionUtils.f(q(context), "getId", null, new Object[0]);
            if (W(str)) {
                return null;
            }
            return str;
        } catch (Throwable th) {
            f92742a.c("Failed to get Play Store Ad ID: " + l(th));
            return null;
        }
    }

    public static String G(Context context) {
        try {
            String strB = ExternalAIFAHelper.b(context);
            if (W(strB)) {
                return null;
            }
            return strB;
        } catch (Throwable th) {
            f92742a.c("Failed to get Play Store Ad ID by backup method: " + l(th));
            return null;
        }
    }

    static String H(SingularInstance singularInstance) {
        String str;
        String str2 = singularInstance.q().f92560v;
        String str3 = f92747f;
        return (str3 == null || (str = f92748g) == null) ? str2 : String.format("%s-%s/%s", str2, str3, str);
    }

    static UUID I(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("pref-singular-id", 0);
        String string = sharedPreferences.getString("singular-id", null);
        return string != null ? UUID.fromString(string) : h(sharedPreferences);
    }

    public static String J(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    static String[] K() {
        return SLReflectionUtils.e();
    }

    public static String L() {
        return f92747f;
    }

    static boolean M(final SingularLinkParams singularLinkParams) {
        if (SLPushNotificationsManager.e().d().booleanValue()) {
            f92742a.a("Push notifications: app was opened with push notification link, skipping deeplink handler invocation.");
            return false;
        }
        final SingularLinkHandler singularLinkHandler = SingularInstance.u().C().f92429n;
        if (singularLinkParams.b() == null || singularLinkHandler == null) {
            return false;
        }
        new Runnable() { // from class: com.singular.sdk.internal.Utils.3
            @Override // java.lang.Runnable
            public void run() {
                singularLinkHandler.a(singularLinkParams);
            }
        }.run();
        return true;
    }

    static void N(Uri uri) {
        String strI = i(uri);
        if (strI != null) {
            M(new SingularLinkParams(strI, j(uri), false, uri));
        }
    }

    private static byte[] O(String str) {
        try {
            int length = str.length();
            byte[] bArr = new byte[length / 2];
            for (int i3 = 0; i3 < length; i3 += 2) {
                bArr[i3 / 2] = (byte) ((Character.digit(str.charAt(i3), 16) << 4) + Character.digit(str.charAt(i3 + 1), 16));
            }
            return bArr;
        } catch (Throwable th) {
            f92742a.c("Failed to convert hex string to byte array: " + l(th));
            return null;
        }
    }

    private static long P(SharedPreferences sharedPreferences, long j3) {
        long j4 = j3 + 1;
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putLong("event-index", j4);
        editorEdit.commit();
        return j4;
    }

    static boolean Q(Context context) {
        try {
            Settings.Secure.getInt(context.getContentResolver(), "limit_ad_tracking");
            return true;
        } catch (Settings.SettingNotFoundException e3) {
            f92742a.a("Amazon limit ad tracking setting not found: " + l(e3));
            return false;
        }
    }

    static boolean R(Context context) {
        return Settings.Secure.getInt(context.getContentResolver(), "limit_ad_tracking") != 0;
    }

    static boolean S(Uri uri) {
        SingularLog singularLog = f92742a;
        singularLog.a("Checking if link is branded link");
        if (uri == null) {
            singularLog.a("link is null");
            return false;
        }
        if (SingularInstance.u() == null) {
            singularLog.c("Singular instance is null. cannot check branded links");
            return false;
        }
        if (SingularInstance.u().C() == null) {
            singularLog.a("singular config is null. cannot check branded links");
            return false;
        }
        if (SingularInstance.u().C().f92435t == null || SingularInstance.u().C().f92435t.size() == 0) {
            singularLog.a("branded domains is null or empty");
            return false;
        }
        if (uri.getScheme() == null) {
            uri = Uri.parse("https://" + uri.toString());
        }
        return d0(uri, SingularInstance.u().C().f92435t);
    }

    static boolean T(Uri uri) {
        SingularInstance singularInstanceU = SingularInstance.u();
        if (uri != null && singularInstanceU != null && singularInstanceU.C() != null && singularInstanceU.C().f92434s != null && singularInstanceU.C().f92434s.size() != 0) {
            if (uri.getScheme() == null) {
                uri = Uri.parse("https://" + uri.toString());
            }
            return d0(uri, singularInstanceU.C().f92434s);
        }
        SingularLog singularLog = f92742a;
        StringBuilder sb = new StringBuilder();
        sb.append("isESPLink: returning false - ");
        sb.append(uri == null ? "link == null " : "");
        sb.append(singularInstanceU == null ? "instance == null" : singularInstanceU.C() == null ? "getSingularConfig() == null" : singularInstanceU.C().f92434s == null ? "espDomains is null" : "espDomains is empty");
        singularLog.a(sb.toString());
        return false;
    }

    public static boolean U(String str) {
        return str == null || str.trim().length() == 0;
    }

    static boolean V() {
        return SLReflectionUtils.a("com.google.android.gms.ads.identifier.AdvertisingIdClient") != null;
    }

    public static boolean W(String str) {
        if (U(str)) {
            return false;
        }
        return C().contains(str) || Pattern.compile("^[0-]+$").matcher(str).matches();
    }

    public static boolean X(Context context, String str) {
        return context.getSharedPreferences("singular-licensing-api", 0).getBoolean(str, false);
    }

    public static boolean Y(Context context) {
        try {
            return ((Boolean) SLReflectionUtils.f(q(context), "isLimitAdTrackingEnabled", null, new Object[0])).booleanValue();
        } catch (Throwable th) {
            f92742a.c("Failed to check if limited tracking is enabled: " + l(th));
            return false;
        }
    }

    static boolean Z() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    static boolean a0() {
        return SingularInstance.u().C().f92432q;
    }

    static boolean b0(Uri uri) {
        return (T(uri) || S(uri) || c0(uri)) && i(uri) == null;
    }

    static boolean c0(Uri uri) {
        if (uri != null) {
            return uri.getHost() != null && uri.getHost().endsWith("sng.link");
        }
        f92742a.a("isSingularLinkDomain: URI is null");
        return false;
    }

    static boolean d() {
        SingularInstance.u().C().f92432q = false;
        return false;
    }

    private static boolean d0(Uri uri, List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (uri.getHost() != null && uri.getHost().equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean e(Context context) {
        return context.getSharedPreferences("pref_asid_is_singular_id", 0).getBoolean("asid_is_singular_id", false);
    }

    static double e0(long j3) {
        return f92746e.b(j3);
    }

    static String f(byte[] bArr) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        char[] cArr2 = new char[bArr.length * 2];
        for (int i3 = 0; i3 < bArr.length; i3++) {
            byte b3 = bArr[i3];
            int i4 = i3 * 2;
            cArr2[i4] = cArr[(b3 & 255) >>> 4];
            cArr2[i4 + 1] = cArr[b3 & Ascii.SI];
        }
        return new String(cArr2);
    }

    public static void f0(Context context, String str) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("pref_persisted_asid", 0).edit();
        editorEdit.putString("persisted_asid", str);
        editorEdit.commit();
    }

    public static void g() {
        f92743b = 0.0d;
    }

    public static void g0(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("pref_retry_count", 0);
        sharedPreferences.edit().remove(n(str)).commit();
    }

    static Uri h0(Uri uri) {
        try {
            URL url = new URL(uri.toString());
            HttpURLConnection httpURLConnectionD = url.getProtocol().equalsIgnoreCase("https") ? SingularRequestHandler.d(url) : SingularRequestHandler.c(url);
            httpURLConnectionD.setInstanceFollowRedirects(false);
            httpURLConnectionD.connect();
            String headerField = httpURLConnectionD.getHeaderField("Location");
            if (headerField != null) {
                return Uri.parse(headerField);
            }
            f92742a.a("resolveESPLink: Location header is null, no redirect URL found for ESP link: " + uri);
            return null;
        } catch (IOException e3) {
            f92742a.c("Failed to resolve ESP link: " + l(e3));
            return null;
        }
    }

    static String i(Uri uri) {
        if (uri == null) {
            f92742a.a("Cannot extract deep link: link is null");
            return null;
        }
        if (T(uri) || S(uri) || c0(uri)) {
            String queryParameter = uri.getQueryParameter("_android_dl");
            return queryParameter != null ? queryParameter : uri.getQueryParameter("_dl");
        }
        f92742a.a("Cannot extract deep link: link is not from a valid domain. Link: " + uri);
        return null;
    }

    public static void i0(Context context) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("pref_asid_is_singular_id", 0).edit();
        editorEdit.putBoolean("asid_is_singular_id", true);
        editorEdit.commit();
    }

    static String j(Uri uri) {
        return uri.getQueryParameter("_p");
    }

    public static void j0(Context context, String str) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("install-openUri", 0).edit();
        editorEdit.putString("openUri", str);
        editorEdit.commit();
    }

    public static String k(String str, String str2) {
        return (U(str) || U(str2) || str.length() < str2.length() || !str.endsWith(str2)) ? str : str.substring(0, str.length() - str2.length());
    }

    private static void k0(Context context) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("singular-first-install", 0).edit();
        editorEdit.putBoolean("wasOpenedAfterInstall", true);
        editorEdit.commit();
    }

    public static String l(Throwable th) {
        return "Exception: \n" + th.getMessage() + "\nStack trace: \n" + J(th);
    }

    public static void l0(Context context, String str) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("singular-licensing-api", 0).edit();
        editorEdit.putBoolean(str, true);
        editorEdit.commit();
    }

    static String m(long j3) {
        return new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z").format(Long.valueOf(j3));
    }

    public static void m0(String str, Context context, int i3) {
        try {
            String strN = n(str);
            SharedPreferences.Editor editorEdit = context.getSharedPreferences("pref_retry_count", 0).edit();
            editorEdit.putInt(strN, i3);
            editorEdit.commit();
        } catch (Throwable th) {
            f92742a.c(l(th));
        }
    }

    private static String n(String str) {
        return "rc-" + str;
    }

    public static void n0(String str) {
        f92745d = str;
    }

    public static int o() {
        return f92744c;
    }

    public static void o0(String str) {
        f92749h = str;
    }

    public static double p() {
        return f92743b;
    }

    static String p0(String str, String str2) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            messageDigest.update(str2.getBytes(Utf8Charset.NAME));
            messageDigest.update(str.getBytes(Utf8Charset.NAME));
            return f(messageDigest.digest());
        } catch (Throwable th) {
            SingularLog singularLog = f92742a;
            singularLog.d("error in sha1Hash()", th);
            singularLog.c("sha1Hash: returning null due to error generating SHA-1 hash");
            return null;
        }
    }

    private static Object q(Context context) {
        return SLReflectionUtils.h("com.google.android.gms.ads.identifier.AdvertisingIdClient", "getAdvertisingIdInfo", new Class[]{Context.class}, context);
    }

    static boolean q0(Uri uri) {
        if (uri == null) {
            f92742a.a("validateSingularLink: link is null");
            return false;
        }
        if (uri.getScheme() == null) {
            uri = Uri.parse("https://" + uri.toString());
        }
        if (uri.getHost() != null) {
            return true;
        }
        f92742a.a("validateSingularLink: link has no host. Link: " + uri);
        return false;
    }

    static String r(Context context) {
        try {
            return Settings.Secure.getString(context.getContentResolver(), "advertising_id");
        } catch (Throwable th) {
            f92742a.c("Failed to get Amazon ID: " + l(th));
            return null;
        }
    }

    public static String r0(String str) {
        try {
            byte[] bArrO = O(str);
            byte[] bArr = new byte[4];
            int length = bArrO.length - 4;
            byte[] bArr2 = new byte[length];
            System.arraycopy(bArrO, 0, bArr, 0, 4);
            System.arraycopy(bArrO, 4, bArr2, 0, length);
            byte[] bArr3 = new byte[length];
            for (int i3 = 0; i3 < length; i3++) {
                bArr3[i3] = (byte) (bArr2[i3] ^ bArr[i3 % 4]);
            }
            return new String(bArr3);
        } catch (Throwable th) {
            f92742a.c("Failed to XOR decrypt: " + l(th));
            return null;
        }
    }

    public static int s(Context context, String str) {
        int i3 = context.getSharedPreferences("pref_retry_count", 0).getInt(n(str), 0);
        m0(str, context, i3 + 1);
        return i3;
    }

    static boolean t(Context context) {
        if (context.getSharedPreferences("singular-first-install", 0).getBoolean("wasOpenedAfterInstall", false)) {
            return false;
        }
        k0(context);
        return true;
    }

    static String u(Context context) {
        String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
        return !C().contains(string) ? string : "None";
    }

    static String v(Context context) {
        try {
            SingularLog singularLog = f92742a;
            singularLog.a("Utils: trying to fetch app set id");
            Task<AppSetIdInfo> appSetIdInfo = AppSet.getClient(context).getAppSetIdInfo();
            final LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
            final long jY = y();
            appSetIdInfo.addOnSuccessListener(new OnSuccessListener<AppSetIdInfo>() { // from class: com.singular.sdk.internal.Utils.1
                @Override // com.google.android.gms.tasks.OnSuccessListener
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onSuccess(AppSetIdInfo appSetIdInfo2) {
                    Utils.f92742a.a("Utils: app set id success listener invoked.");
                    int unused = Utils.f92744c = appSetIdInfo2.getScope();
                    linkedBlockingQueue.offer(appSetIdInfo2.getId());
                    double unused2 = Utils.f92743b = Utils.e0(jY);
                }
            });
            appSetIdInfo.addOnFailureListener(new OnFailureListener() { // from class: com.singular.sdk.internal.Utils.2
                @Override // com.google.android.gms.tasks.OnFailureListener
                public void onFailure(Exception exc) {
                    Utils.f92742a.c("Utils: fetch app set id failed with exception: " + Utils.l(exc));
                    double unused = Utils.f92743b = -1.0d;
                    linkedBlockingQueue.offer("");
                }
            });
            String str = (String) linkedBlockingQueue.poll(1L, TimeUnit.SECONDS);
            singularLog.a("Utils: fetched app set id value: " + str);
            if (U(str)) {
                return null;
            }
            return str;
        } catch (Throwable th) {
            f92742a.c("Utils: caught exception in fetching app set id: " + l(th));
            f92743b = -2.0d;
            return null;
        }
    }

    public static String w(Context context) {
        return context.getSharedPreferences("install-openUri", 0).getString("openUri", null);
    }

    static String x() {
        return SLReflectionUtils.b();
    }

    public static long y() {
        return f92746e.a();
    }

    public static String z() {
        return f92745d;
    }

    private static UUID h(SharedPreferences sharedPreferences) {
        UUID uuidRandomUUID = UUID.randomUUID();
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString(CbYNFSEGaQj.oyEEut, uuidRandomUUID.toString());
        editorEdit.commit();
        return uuidRandomUUID;
    }
}
