package com.google.android.gms.ads.internal.util.client;

import android.app.ActivityManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.appsflyer.AppsFlyerProperties;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import com.google.android.gms.ads.admanager.AdManagerInterstitialAd;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzfp;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.preload.PreloadConfiguration;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.ads.zzbiq;
import com.google.android.gms.internal.ads.zzbkz;
import com.google.android.gms.internal.ads.zzgam;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.UUID;
import kotlin.comparisons.xn.YvFRmou;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzf {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Handler f70162b = new zzgam(Looper.getMainLooper());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f70163c = AdView.class.getName();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f70164d = InterstitialAd.class.getName();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f70165e = AdManagerAdView.class.getName();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f70166f = AdManagerInterstitialAd.class.getName();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f70167g = AdLoader.class.getName();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f70168a = -1.0f;

    public static boolean A(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith((String) zzbkz.zzd.zze());
    }

    public static int B(Context context, int i3) {
        DisplayMetrics displayMetrics;
        Configuration configuration;
        if (context == null) {
            return -1;
        }
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        Resources resources = context.getResources();
        if (resources == null || (displayMetrics = resources.getDisplayMetrics()) == null || (configuration = resources.getConfiguration()) == null) {
            return -1;
        }
        int i4 = configuration.orientation;
        if (i3 == 0) {
            i3 = i4;
        }
        return i3 == i4 ? Math.round(displayMetrics.heightPixels / displayMetrics.density) : Math.round(displayMetrics.widthPixels / displayMetrics.density);
    }

    public static PreloadConfiguration C(zzfp zzfpVar) {
        String str = zzfpVar.f69947a;
        AdFormat adFormatA = AdFormat.a(zzfpVar.f69948b);
        if (adFormatA == null) {
            return null;
        }
        com.google.android.gms.ads.internal.client.zzm zzmVar = zzfpVar.f69949c;
        AdRequest.Builder builder = new AdRequest.Builder();
        List list = zzmVar.f69968f;
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                builder.b((String) it.next());
            }
        }
        builder.i(zzmVar.f69976n);
        Bundle bundle = zzmVar.f69977o;
        for (String str2 : bundle.keySet()) {
            builder.a(str2, bundle.getString(str2));
        }
        builder.e(zzmVar.f69987y);
        String str3 = zzmVar.f69975m;
        if (str3 != null) {
            builder.f(str3);
        }
        builder.g(zzmVar.f69985w);
        builder.h(zzmVar.f69979q);
        AdRequest adRequestM = builder.m();
        PreloadConfiguration.Builder builder2 = new PreloadConfiguration.Builder(str, adFormatA);
        builder2.b(adRequestM);
        builder2.c(zzfpVar.f69950d);
        return builder2.a();
    }

    public static final int D(DisplayMetrics displayMetrics, int i3) {
        return (int) TypedValue.applyDimension(1, i3, displayMetrics);
    }

    public static final String E(StackTraceElement[] stackTraceElementArr, String str) {
        int i3;
        String className;
        int i4 = 0;
        while (true) {
            i3 = i4 + 1;
            if (i3 >= stackTraceElementArr.length) {
                className = null;
                break;
            }
            StackTraceElement stackTraceElement = stackTraceElementArr[i4];
            String className2 = stackTraceElement.getClassName();
            if ("loadAd".equalsIgnoreCase(stackTraceElement.getMethodName()) && (f70163c.equalsIgnoreCase(className2) || f70164d.equalsIgnoreCase(className2) || f70165e.equalsIgnoreCase(className2) || f70166f.equalsIgnoreCase(className2) || f70167g.equalsIgnoreCase(className2))) {
                break;
            }
            i4 = i3;
        }
        className = stackTraceElementArr[i3].getClassName();
        if (str != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(str, ".");
            StringBuilder sb = new StringBuilder();
            if (stringTokenizer.hasMoreElements()) {
                sb.append(stringTokenizer.nextToken());
                for (int i5 = 2; i5 > 0 && stringTokenizer.hasMoreElements(); i5--) {
                    sb.append(".");
                    sb.append(stringTokenizer.nextToken());
                }
                str = sb.toString();
            }
            if (className != null && !className.contains(str)) {
                return className;
            }
        }
        return null;
    }

    public static final boolean F() {
        boolean zBooleanValue = ((Boolean) zzba.c().zzd(zzbiq.zzmP)).booleanValue();
        if (Build.VERSION.SDK_INT < 31) {
            return Build.DEVICE.startsWith("generic");
        }
        String str = Build.FINGERPRINT;
        if (str.contains("generic") || str.contains("emulator")) {
            return true;
        }
        return zBooleanValue && Build.HARDWARE.contains("ranchu");
    }

    public static final boolean G(Context context, int i3) {
        return GoogleApiAvailabilityLight.h().j(context, i3) == 0;
    }

    public static final boolean a(Context context) {
        int iJ = GoogleApiAvailabilityLight.h().j(context, 12451000);
        return iJ == 0 || iJ == 2;
    }

    public static final boolean b() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static final int c(DisplayMetrics displayMetrics, int i3) {
        return Math.round(i3 / displayMetrics.density);
    }

    public static final int e(Context context, int i3) {
        return D(context.getResources().getDisplayMetrics(), i3);
    }

    public static final String f(Context context) {
        zzbiq.zza(context);
        ContentResolver contentResolver = context.getContentResolver();
        String string = contentResolver == null ? null : Settings.Secure.getString(contentResolver, "android_id");
        if (string == null || F()) {
            string = "emulator";
        }
        return g(string, "MD5");
    }

    private static String g(String str, String str2) {
        for (int i3 = 0; i3 < 2; i3++) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(str2);
                messageDigest.update(str.getBytes());
                return String.format(Locale.US, "%032X", new BigInteger(1, messageDigest.digest()));
            } catch (ArithmeticException unused) {
                return null;
            } catch (NoSuchAlgorithmException unused2) {
            }
        }
        return null;
    }

    private final JSONArray h(Collection collection) {
        JSONArray jSONArray = new JSONArray();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            i(jSONArray, it.next());
        }
        return jSONArray;
    }

    private final void i(JSONArray jSONArray, Object obj) {
        if (obj instanceof Bundle) {
            jSONArray.put(y((Bundle) obj));
            return;
        }
        if (obj instanceof Map) {
            jSONArray.put(w((Map) obj));
            return;
        }
        if (obj instanceof Collection) {
            jSONArray.put(h((Collection) obj));
        } else if (obj instanceof Object[]) {
            jSONArray.put(z((Object[]) obj));
        } else {
            jSONArray.put(obj);
        }
    }

    private final void j(JSONObject jSONObject, String str, Object obj) throws JSONException {
        if (((Boolean) zzba.c().zzd(zzbiq.zzs)).booleanValue()) {
            str = String.valueOf(str);
        }
        if (obj instanceof Bundle) {
            jSONObject.put(str, y((Bundle) obj));
            return;
        }
        if (obj instanceof Map) {
            jSONObject.put(str, w((Map) obj));
            return;
        }
        if (obj instanceof Collection) {
            jSONObject.put(String.valueOf(str), h((Collection) obj));
            return;
        }
        if (obj instanceof Object[]) {
            jSONObject.put(str, h(Arrays.asList((Object[]) obj)));
            return;
        }
        int i3 = 0;
        if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            int length = iArr.length;
            Integer[] numArr = new Integer[length];
            while (i3 < length) {
                numArr[i3] = Integer.valueOf(iArr[i3]);
                i3++;
            }
            jSONObject.put(str, z(numArr));
            return;
        }
        if (obj instanceof double[]) {
            double[] dArr = (double[]) obj;
            int length2 = dArr.length;
            Double[] dArr2 = new Double[length2];
            while (i3 < length2) {
                dArr2[i3] = Double.valueOf(dArr[i3]);
                i3++;
            }
            jSONObject.put(str, z(dArr2));
            return;
        }
        if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            int length3 = jArr.length;
            Long[] lArr = new Long[length3];
            while (i3 < length3) {
                lArr[i3] = Long.valueOf(jArr[i3]);
                i3++;
            }
            jSONObject.put(str, z(lArr));
            return;
        }
        if (!(obj instanceof boolean[])) {
            jSONObject.put(str, obj);
            return;
        }
        boolean[] zArr = (boolean[]) obj;
        int length4 = zArr.length;
        Boolean[] boolArr = new Boolean[length4];
        while (i3 < length4) {
            boolArr[i3] = Boolean.valueOf(zArr[i3]);
            i3++;
        }
        jSONObject.put(str, z(boolArr));
    }

    private static final void k(ViewGroup viewGroup, com.google.android.gms.ads.internal.client.zzr zzrVar, String str, int i3, int i4) {
        if (viewGroup.getChildCount() != 0) {
            return;
        }
        Context context = viewGroup.getContext();
        TextView textView = new TextView(context);
        textView.setGravity(17);
        textView.setText(str);
        textView.setTextColor(i3);
        textView.setBackgroundColor(i4);
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setBackgroundColor(i3);
        int iE = e(context, 3);
        int i5 = zzrVar.f70009g;
        int i6 = zzrVar.f70006c;
        frameLayout.addView(textView, new FrameLayout.LayoutParams(i5 - iE, i6 - iE, 17));
        viewGroup.addView(frameLayout, i5, i6);
    }

    public static Object o(Map map, Object obj, Object obj2) {
        return map.containsKey(obj) ? map.get(obj) : obj2;
    }

    public static ActivityManager.MemoryInfo p(Context context) {
        ActivityManager activityManager;
        if (context == null || (activityManager = (ActivityManager) context.getSystemService("activity")) == null) {
            return null;
        }
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        try {
            activityManager.getMemoryInfo(memoryInfo);
            return memoryInfo;
        } catch (NullPointerException unused) {
            zzo.f("Error retrieving the memory information.");
            return memoryInfo;
        }
    }

    public static String q(Context context) {
        if (context == null) {
            return null;
        }
        try {
            Bundle bundle = Wrappers.a(context).c(context.getPackageName(), ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD).metaData;
            if (bundle != null && bundle.containsKey("com.google.unity.ads.UNITY_VERSION")) {
                return bundle.getString("com.google.unity.ads.UNITY_VERSION");
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return null;
    }

    public static String r(String str) {
        return g(str, "MD5");
    }

    public static String s(String str) {
        return g(str, "SHA-256");
    }

    public static String u() {
        UUID uuidRandomUUID = UUID.randomUUID();
        byte[] byteArray = BigInteger.valueOf(uuidRandomUUID.getLeastSignificantBits()).toByteArray();
        byte[] byteArray2 = BigInteger.valueOf(uuidRandomUUID.getMostSignificantBits()).toByteArray();
        String string = new BigInteger(1, byteArray).toString();
        for (int i3 = 0; i3 < 2; i3++) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(byteArray);
                messageDigest.update(byteArray2);
                byte[] bArr = new byte[8];
                System.arraycopy(messageDigest.digest(), 0, bArr, 0, 8);
                string = new BigInteger(1, bArr).toString();
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        return string;
    }

    public static AdSize v(Context context, int i3, int i4, int i5) {
        int iB = B(context, i5);
        if (iB == -1) {
            return AdSize.f69653r;
        }
        return new AdSize(i3, Math.max(Math.min(i3 > 655 ? Math.round((i3 / 728.0f) * 90.0f) : i3 > 632 ? 81 : i3 > 526 ? Math.round((i3 / 468.0f) * 60.0f) : i3 > 432 ? 68 : Math.round((i3 / 320.0f) * 50.0f), Math.min(90, Math.round(iB * 0.15f))), 50));
    }

    public final int l(Context context, int i3) {
        if (this.f70168a < 0.0f) {
            synchronized (this) {
                try {
                    if (this.f70168a < 0.0f) {
                        WindowManager windowManager = (WindowManager) context.getSystemService("window");
                        if (windowManager == null) {
                            return 0;
                        }
                        Display defaultDisplay = windowManager.getDefaultDisplay();
                        DisplayMetrics displayMetrics = new DisplayMetrics();
                        defaultDisplay.getMetrics(displayMetrics);
                        this.f70168a = displayMetrics.density;
                    }
                } finally {
                }
            }
        }
        return Math.round(i3 / this.f70168a);
    }

    public final void m(ViewGroup viewGroup, com.google.android.gms.ads.internal.client.zzr zzrVar, String str, String str2) {
        if (str2 != null) {
            zzo.f(str2);
        }
        k(viewGroup, zzrVar, str, -65536, -16777216);
    }

    public final void n(ViewGroup viewGroup, com.google.android.gms.ads.internal.client.zzr zzrVar, String str) {
        k(viewGroup, zzrVar, "Ads by Google", -16777216, -1);
    }

    public final void t(final Context context, String str, String str2, Bundle bundle, boolean z2) {
        d(context, str, "gmob-apps", bundle, true, new zze() { // from class: com.google.android.gms.ads.internal.util.client.zzd
            @Override // com.google.android.gms.ads.internal.util.client.zze
            public final /* synthetic */ zzt zza(String str3) {
                new zzc(this.f70160a, context, str3).start();
                return zzt.SUCCESS;
            }
        });
    }

    public final JSONObject w(Map map) throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            for (String str : map.keySet()) {
                j(jSONObject, str, map.get(str));
            }
            return jSONObject;
        } catch (ClassCastException e3) {
            throw new JSONException("Could not convert map to JSON: ".concat(String.valueOf(e3.getMessage())));
        }
    }

    public final JSONObject x(Bundle bundle, JSONObject jSONObject) {
        if (bundle != null) {
            try {
                return y(bundle);
            } catch (JSONException e3) {
                zzo.d("Error converting Bundle to JSON", e3);
            }
        }
        return null;
    }

    public final JSONObject y(Bundle bundle) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        for (String str : bundle.keySet()) {
            j(jSONObject, str, bundle.get(str));
        }
        return jSONObject;
    }

    final JSONArray z(Object[] objArr) {
        JSONArray jSONArray = new JSONArray();
        for (Object obj : objArr) {
            i(jSONArray, obj);
        }
        return jSONArray;
    }

    public static final void d(Context context, String str, String str2, Bundle bundle, boolean z2, zze zzeVar) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext == null) {
            applicationContext = context;
        }
        bundle.putString("os", Build.VERSION.RELEASE);
        bundle.putString("api", String.valueOf(Build.VERSION.SDK_INT));
        bundle.putString(AppsFlyerProperties.APP_ID, applicationContext.getPackageName());
        if (str == null) {
            int iB = GoogleApiAvailabilityLight.h().b(context);
            StringBuilder sb = new StringBuilder(String.valueOf(iB).length() + 10);
            sb.append(iB);
            sb.append(".261210000");
            str = sb.toString();
        }
        bundle.putString("js", str);
        Uri.Builder builderAppendQueryParameter = new Uri.Builder().scheme("https").path(YvFRmou.QlBblQYP).appendQueryParameter("id", "gmob-apps");
        for (String str3 : bundle.keySet()) {
            builderAppendQueryParameter.appendQueryParameter(str3, bundle.getString(str3));
        }
        zzeVar.zza(builderAppendQueryParameter.toString());
    }
}
