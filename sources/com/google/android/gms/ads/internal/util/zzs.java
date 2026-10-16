package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.app.KeyguardManager;
import android.app.LocaleManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Rect;
import android.hardware.display.DisplayManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.PowerManager;
import android.os.Process;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.widget.AbsListView;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.core.view.ScrollingView;
import com.facebook.GraphRequest;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.integrity.IntegrityManager;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.facebook.internal.ServerProtocol;
import com.facebook.stetho.common.Utf8Charset;
import com.google.android.gms.ads.impl.R;
import com.google.android.gms.ads.nativead.NativeAdView;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.util.ClientLibraryUtils;
import com.google.android.gms.common.util.CrashUtils;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.util.SharedPreferencesUtils;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.ads.zzbih;
import com.google.android.gms.internal.ads.zzbiq;
import com.google.android.gms.internal.ads.zzbjr;
import com.google.android.gms.internal.ads.zzbkz;
import com.google.android.gms.internal.ads.zzcbn;
import com.google.android.gms.internal.ads.zzckl;
import com.google.android.gms.internal.ads.zzcmb;
import com.google.android.gms.internal.ads.zzcmw;
import com.google.android.gms.internal.ads.zzdwl;
import com.google.android.gms.internal.ads.zzdzk;
import com.google.android.gms.internal.ads.zzdzl;
import com.google.android.gms.internal.ads.zzfkf;
import com.google.android.gms.internal.ads.zzfki;
import com.google.android.gms.internal.ads.zzgam;
import com.google.android.gms.internal.ads.zzgsx;
import com.google.android.gms.internal.ads.zzgty;
import com.google.android.gms.internal.ads.zzgua;
import com.google.android.gms.internal.ads.zzhbw;
import com.google.android.gms.internal.ads.zzink;
import com.google.common.util.concurrent.ListenableFuture;
import com.revenuecat.purchases.common.Constants;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import java.io.ByteArrayInputStream;
import java.net.HttpURLConnection;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzs {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final zzgam f70374l = new zzf(Looper.getMainLooper());

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f70381g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile String f70382h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicReference f70375a = new AtomicReference(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicReference f70376b = new AtomicReference(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AtomicReference f70377c = new AtomicReference(new Bundle());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AtomicBoolean f70378d = new AtomicBoolean();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f70379e = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Object f70380f = new Object();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f70383i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f70384j = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Executor f70385k = Executors.newSingleThreadExecutor();

    public static int A(int i3) {
        if (i3 >= 5000) {
            return i3;
        }
        if (i3 <= 0) {
            return 60000;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + 86);
        sb.append("HTTP timeout too low: ");
        sb.append(i3);
        sb.append(" milliseconds. Reverting to default timeout: 60000 milliseconds.");
        String string = sb.toString();
        int i4 = zze.f70328b;
        com.google.android.gms.ads.internal.util.client.zzo.f(string);
        return 60000;
    }

    public static final int[] B(Activity activity) {
        int[] iArrV = v(activity);
        return new int[]{com.google.android.gms.ads.internal.client.zzay.a().l(activity, iArrV[0]), com.google.android.gms.ads.internal.client.zzay.a().l(activity, iArrV[1])};
    }

    public static final boolean C(View view, Context context) {
        Context applicationContext = context.getApplicationContext();
        return x(view, applicationContext != null ? (PowerManager) applicationContext.getSystemService("power") : null, E(context));
    }

    public static final void D(Context context, Intent intent, zzdzl zzdzlVar, String str) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzoD)).booleanValue() || !(context instanceof zzcmw)) {
            y(context, intent);
            return;
        }
        try {
            Uri data = intent.getData();
            if (data != null && data.toString() != null) {
                if (data.toString().matches((String) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzoF))) {
                    ((zzcmw) context).zza(intent, 236);
                    if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzoE)).booleanValue() || zzdzlVar == null) {
                        return;
                    }
                    zzdzk zzdzkVarZza = zzdzlVar.zza();
                    zzdzkVarZza.zzc("action", "hila");
                    zzdzkVarZza.zzc("gqi", zzgua.zza(str));
                    zzdzkVarZza.zzf();
                    return;
                }
            }
            y(context, intent);
        } catch (ActivityNotFoundException e3) {
            e = e3;
            int i3 = zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.d("Error occurred while starting activity for result", e);
            com.google.android.gms.ads.internal.zzt.l().zzg(e, "AdUtil.startActivityForResult");
            y(context, intent);
        } catch (SecurityException e4) {
            e = e4;
            int i32 = zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.d("Error occurred while starting activity for result", e);
            com.google.android.gms.ads.internal.zzt.l().zzg(e, "AdUtil.startActivityForResult");
            y(context, intent);
        } catch (Exception e5) {
            int i4 = zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.d("Error occurred while starting activity for result", e5);
            com.google.android.gms.ads.internal.zzt.l().zzg(e5, "AdUtil.startActivityForResult");
            y(context, intent);
        }
    }

    private static KeyguardManager E(Context context) {
        Object systemService = context.getSystemService("keyguard");
        if (systemService == null || !(systemService instanceof KeyguardManager)) {
            return null;
        }
        return (KeyguardManager) systemService;
    }

    private static boolean F(String str, AtomicReference atomicReference, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Pattern patternCompile = (Pattern) atomicReference.get();
            if (patternCompile == null || !str2.equals(patternCompile.pattern())) {
                patternCompile = Pattern.compile(str2);
                atomicReference.set(patternCompile);
            }
            return patternCompile.matcher(str).matches();
        } catch (PatternSyntaxException unused) {
            return false;
        }
    }

    private static String G(Bundle bundle) {
        if (bundle == null) {
            return "";
        }
        String string = bundle.getString("com.google.android.gms.ads.APPLICATION_ID");
        return !TextUtils.isEmpty(string) ? (string.matches("^ca-app-pub-[0-9]{16}~[0-9]{10}$") || string.matches("^/\\d+~.+$")) ? string : "" : "";
    }

    private static Bundle H(Context context) {
        try {
            return Wrappers.a(context).c(context.getPackageName(), ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD).metaData;
        } catch (PackageManager.NameNotFoundException | NullPointerException e3) {
            zze.l("Error getting metadata", e3);
            return null;
        }
    }

    private static final void I(Context context, Uri uri) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri);
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(CustomTabsIntent.Builder builder, Bundle bundle) {
        if (bundle.isEmpty()) {
            return;
        }
        int i3 = bundle.getInt("h", -1);
        if (i3 >= 0) {
            builder.k(i3);
        }
        int i4 = bundle.getInt("cbp", -1);
        if (i4 < 0 || i4 > 2) {
            return;
        }
        builder.d(i4);
    }

    private static final void K(Context context, Intent intent) {
        try {
            context.startActivity(intent);
        } catch (Throwable unused) {
            intent.addFlags(268435456);
            context.startActivity(intent);
        }
    }

    private static final String L(final Context context, String str) {
        String strD0;
        String str2;
        if (str == null) {
            return d0();
        }
        try {
            zzce zzceVarA = zzce.a();
            if (TextUtils.isEmpty(zzceVarA.f70312a)) {
                if (ClientLibraryUtils.a()) {
                    str2 = (String) zzcb.a(context, new Callable() { // from class: com.google.android.gms.ads.internal.util.zzcc
                        @Override // java.util.concurrent.Callable
                        public final /* synthetic */ Object call() {
                            Context context2 = context;
                            SharedPreferences sharedPreferences = context2.getSharedPreferences("admob_user_agent", 0);
                            String string = sharedPreferences.getString("user_agent", "");
                            if (!TextUtils.isEmpty(string)) {
                                zze.k("User agent is already initialized on Google Play Services.");
                                return string;
                            }
                            zze.k("User agent is not initialized on Google Play Services. Initializing.");
                            String defaultUserAgent = WebSettings.getDefaultUserAgent(context2);
                            SharedPreferencesUtils.a(context2, sharedPreferences.edit().putString("user_agent", defaultUserAgent), "admob_user_agent");
                            return defaultUserAgent;
                        }
                    });
                } else {
                    final Context contextE = GooglePlayServicesUtilLight.e(context);
                    str2 = (String) zzcb.a(context, new Callable() { // from class: com.google.android.gms.ads.internal.util.zzcd
                        @Override // java.util.concurrent.Callable
                        public final /* synthetic */ Object call() {
                            SharedPreferences sharedPreferences;
                            Context context2 = contextE;
                            Context context3 = context;
                            boolean z2 = false;
                            if (context2 != null) {
                                zze.k("Attempting to read user agent from Google Play Services.");
                                sharedPreferences = context2.getSharedPreferences("admob_user_agent", 0);
                            } else {
                                zze.k("Attempting to read user agent from local cache.");
                                sharedPreferences = context3.getSharedPreferences("admob_user_agent", 0);
                                z2 = true;
                            }
                            String string = sharedPreferences.getString("user_agent", "");
                            if (!TextUtils.isEmpty(string)) {
                                return string;
                            }
                            zze.k("Reading user agent from WebSettings");
                            String defaultUserAgent = WebSettings.getDefaultUserAgent(context3);
                            if (z2) {
                                sharedPreferences.edit().putString("user_agent", defaultUserAgent).apply();
                                zze.k("Persisting user agent.");
                            }
                            return defaultUserAgent;
                        }
                    });
                }
                zzceVarA.f70312a = str2;
            }
            strD0 = zzceVarA.f70312a;
        } catch (Exception unused) {
            strD0 = null;
        }
        if (TextUtils.isEmpty(strD0)) {
            strD0 = WebSettings.getDefaultUserAgent(context);
        }
        if (TextUtils.isEmpty(strD0)) {
            strD0 = d0();
        }
        StringBuilder sb = new StringBuilder(String.valueOf(strD0).length() + 10 + str.length());
        sb.append(strD0);
        sb.append(" (Mobile; ");
        sb.append(str);
        String string = sb.toString();
        try {
            if (Wrappers.a(context).g()) {
                StringBuilder sb2 = new StringBuilder(string.length() + 4);
                sb2.append(string);
                sb2.append(";aia");
                string = sb2.toString();
            }
        } catch (Exception e3) {
            com.google.android.gms.ads.internal.zzt.l().zzg(e3, "AdUtil.getUserAgent");
        }
        return string.concat(")");
    }

    public static List U() {
        zzbih zzbihVar = zzbiq.zza;
        List listZzf = com.google.android.gms.ads.internal.client.zzba.b().zzf();
        ArrayList arrayList = new ArrayList();
        Iterator it = listZzf.iterator();
        while (it.hasNext()) {
            Iterator it2 = zzgty.zza(zzgsx.zzc(',')).zzd((String) it.next()).iterator();
            while (it2.hasNext()) {
                try {
                    arrayList.add(Long.valueOf((String) it2.next()));
                } catch (NumberFormatException unused) {
                    zze.k("Experiment ID is not a number");
                }
            }
        }
        return arrayList;
    }

    public static zzq V(Context context) {
        if (Build.VERSION.SDK_INT < 33) {
            Locale locale = context.getResources().getConfiguration().getLocales().get(0);
            return new zzq(locale.getLanguage(), locale.getCountry());
        }
        zzq zzqVar = new zzq(Locale.getDefault().getLanguage(), Locale.getDefault().getCountry());
        try {
            LocaleManager localeManagerA = b.a(context.getSystemService(a.a()));
            if (localeManagerA == null || localeManagerA.getSystemLocales().isEmpty()) {
                return zzqVar;
            }
            Locale locale2 = localeManagerA.getSystemLocales().get(0);
            return new zzq(locale2.getLanguage(), locale2.getCountry());
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.zzt.l().zzg(th, "AdUtil.getSystemDefaultLocale");
            return zzqVar;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x0007  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final boolean Z(android.view.View r2) {
        /*
            android.view.View r2 = r2.getRootView()
            r0 = 0
            if (r2 != 0) goto L9
        L7:
            r2 = r0
            goto L13
        L9:
            android.content.Context r2 = r2.getContext()
            boolean r1 = r2 instanceof android.app.Activity
            if (r1 == 0) goto L7
            android.app.Activity r2 = (android.app.Activity) r2
        L13:
            r1 = 0
            if (r2 != 0) goto L17
            return r1
        L17:
            android.view.Window r2 = r2.getWindow()
            if (r2 != 0) goto L1e
            goto L22
        L1e:
            android.view.WindowManager$LayoutParams r0 = r2.getAttributes()
        L22:
            if (r0 == 0) goto L2d
            int r2 = r0.flags
            r0 = 524288(0x80000, float:7.34684E-40)
            r2 = r2 & r0
            if (r2 == 0) goto L2d
            r2 = 1
            return r2
        L2d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.util.zzs.Z(android.view.View):boolean");
    }

    public static final int a(View view) {
        ViewParent parent = view.getParent();
        while (true) {
            if (parent == null) {
                return 0;
            }
            if (parent instanceof ScrollView) {
                return 1;
            }
            if (parent instanceof AbsListView) {
                return 2;
            }
            if (parent instanceof HorizontalScrollView) {
                return 3;
            }
            if (parent instanceof ScrollingView) {
                return 4;
            }
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzji)).booleanValue()) {
                String str = (String) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzjj);
                if (TextUtils.isEmpty(str)) {
                    continue;
                } else {
                    for (String str2 : str.split(",")) {
                        if (parent.getClass().getName().toLowerCase(Locale.ROOT).contains(str2)) {
                            return 5;
                        }
                    }
                }
            }
            parent = parent.getParent();
        }
    }

    public static final boolean a0(final Context context, final WebSettings webSettings) {
        zzcb.a(context, new Callable() { // from class: com.google.android.gms.ads.internal.util.zzn
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                zzgam zzgamVar = zzs.f70374l;
                String absolutePath = context.getDatabasePath("com.google.android.gms.ads.db").getAbsolutePath();
                WebSettings webSettings2 = webSettings;
                webSettings2.setDatabasePath(absolutePath);
                webSettings2.setDatabaseEnabled(true);
                webSettings2.setDomStorageEnabled(true);
                webSettings2.setDisplayZoomControls(false);
                webSettings2.setBuiltInZoomControls(true);
                webSettings2.setSupportZoom(true);
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzbw)).booleanValue()) {
                    webSettings2.setTextZoom(100);
                }
                webSettings2.setAllowContentAccess(false);
                return Boolean.TRUE;
            }
        });
        webSettings.setAllowFileAccessFromFileURLs(false);
        webSettings.setAllowUniversalAccessFromFileURLs(false);
        webSettings.setMediaPlaybackRequiresUserGesture(false);
        return true;
    }

    public static final String b() {
        Resources resourcesZzf = com.google.android.gms.ads.internal.zzt.l().zzf();
        return resourcesZzf != null ? resourcesZzf.getString(R.string.f69765t) : "Test Ad";
    }

    public static final void b0(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        Bundle extras = intent.getExtras() != null ? intent.getExtras() : new Bundle();
        extras.putBinder("android.support.customtabs.extra.SESSION", null);
        extras.putString("com.android.browser.application_id", context.getPackageName());
        intent.putExtras(extras);
    }

    public static final zzbo c(Context context) {
        try {
            Object objNewInstance = context.getClassLoader().loadClass("com.google.android.gms.ads.internal.util.WorkManagerUtil").getDeclaredConstructor(null).newInstance(null);
            if (objNewInstance instanceof IBinder) {
                IBinder iBinder = (IBinder) objNewInstance;
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.util.IWorkManagerUtil");
                return iInterfaceQueryLocalInterface instanceof zzbo ? (zzbo) iInterfaceQueryLocalInterface : new zzbm(iBinder);
            }
            int i3 = zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.c("Instantiated WorkManagerUtil not instance of IBinder.");
            return null;
        } catch (Exception e3) {
            com.google.android.gms.ads.internal.zzt.l().zzg(e3, "Failed to instantiate WorkManagerUtil");
            return null;
        }
    }

    public static final String c0(Context context) {
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        return G(H(context));
    }

    public static final boolean d(Context context, String str) {
        Context contextZza = zzcbn.zza(context);
        return Wrappers.a(contextZza).b(str, contextZza.getPackageName()) == 0;
    }

    static final String d0() {
        StringBuilder sb = new StringBuilder(Function.MAX_NARGS);
        sb.append("Mozilla/5.0 (Linux; U; Android");
        String str = Build.VERSION.RELEASE;
        if (str != null) {
            sb.append(" ");
            sb.append(str);
        }
        sb.append("; ");
        sb.append(Locale.getDefault());
        String str2 = Build.DEVICE;
        if (str2 != null) {
            sb.append("; ");
            sb.append(str2);
            String str3 = Build.DISPLAY;
            if (str3 != null) {
                sb.append(" Build/");
                sb.append(str3);
            }
        }
        sb.append(") AppleWebKit/533 Version/4.0 Safari/533");
        return sb.toString();
    }

    public static final boolean e(Context context) {
        try {
            return DeviceProperties.b(context);
        } catch (NoSuchMethodError unused) {
            return false;
        }
    }

    public static final String e0() {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        if (str2.startsWith(str)) {
            return str2;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 1 + str2.length());
        sb.append(str);
        sb.append(" ");
        sb.append(str2);
        return sb.toString();
    }

    public static final boolean f(String str) {
        if (!com.google.android.gms.ads.internal.util.client.zzl.j()) {
            return false;
        }
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzgg)).booleanValue()) {
            return false;
        }
        String str2 = (String) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzgi);
        if (!str2.isEmpty()) {
            for (String str3 : str2.split(";")) {
                if (str3.equals(str)) {
                    return false;
                }
            }
        }
        String str4 = (String) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzgh);
        if (str4.isEmpty()) {
            return true;
        }
        for (String str5 : str4.split(";")) {
            if (str5.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static final Integer f0(Context context) {
        Object systemService = context.getSystemService(ServerProtocol.DIALOG_PARAM_DISPLAY);
        if (systemService instanceof DisplayManager) {
            return Integer.valueOf(((DisplayManager) systemService).getDisplays().length);
        }
        return null;
    }

    public static final boolean g(Context context) {
        KeyguardManager keyguardManagerE;
        return (context == null || (keyguardManagerE = E(context)) == null || !keyguardManagerE.isKeyguardLocked()) ? false : true;
    }

    public static final DisplayMetrics g0(WindowManager windowManager) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    public static final boolean h(Context context) {
        try {
            context.getClassLoader().loadClass("com.google.android.gms.ads.internal.ClientApi");
            return false;
        } catch (ClassNotFoundException unused) {
            return true;
        } catch (Throwable th) {
            int i3 = zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.d("Error loading class.", th);
            com.google.android.gms.ads.internal.zzt.l().zzg(th, "AdUtil.isLiteSdk");
            return false;
        }
    }

    protected static final int[] h0() {
        return new int[]{0, 0};
    }

    public static final boolean i() {
        int iMyUid = Process.myUid();
        return iMyUid == 0 || iMyUid == 1000;
    }

    public static final Map i0(String str) {
        HashMap map = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                HashSet hashSet = new HashSet();
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(next);
                if (jSONArrayOptJSONArray != null) {
                    for (int i3 = 0; i3 < jSONArrayOptJSONArray.length(); i3++) {
                        String strOptString = jSONArrayOptJSONArray.optString(i3);
                        if (strOptString != null) {
                            hashSet.add(strOptString);
                        }
                    }
                    map.put(next, hashSet);
                }
            }
            return map;
        } catch (JSONException e3) {
            com.google.android.gms.ads.internal.zzt.l().zzg(e3, "AdUtil.getMapOfFileNamesToKeysFromJsonString");
            return map;
        }
    }

    public static final boolean j(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        PowerManager powerManager;
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
            if (activityManager == null || keyguardManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
                return false;
            }
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (Process.myPid() == runningAppProcessInfo.pid) {
                    if (runningAppProcessInfo.importance == 100 && !keyguardManager.inKeyguardRestrictedInputMode() && (powerManager = (PowerManager) context.getSystemService("power")) != null) {
                        return !powerManager.isScreenOn();
                    }
                    return true;
                }
            }
            return true;
        } catch (Throwable unused) {
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v6, types: [android.view.ViewParent] */
    public static final long j0(View view) {
        float fMin = Float.MAX_VALUE;
        do {
            if (!(view instanceof View)) {
                break;
            }
            View view2 = (View) view;
            fMin = Math.min(fMin, view2.getAlpha());
            view = view2.getParent();
        } while (fMin > 0.0f);
        return Math.round((fMin >= 0.0f ? fMin : 0.0f) * 100.0f);
    }

    public static final boolean k(Context context) {
        try {
            Bundle bundleH = H(context);
            String string = bundleH.getString("com.google.android.gms.ads.INTEGRATION_MANAGER");
            if (TextUtils.isEmpty(G(bundleH))) {
                if (!TextUtils.isEmpty(string)) {
                    return true;
                }
            }
        } catch (RemoteException unused) {
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final WebResourceResponse k0(Context context, String str, String str2) {
        try {
            HashMap map = new HashMap();
            map.put(GraphRequest.USER_AGENT_HEADER, com.google.android.gms.ads.internal.zzt.g().P(context, str));
            map.put("Cache-Control", "max-stale=3600");
            String str3 = (String) new zzbl(context).b(0, str2, map, null).get(60L, TimeUnit.SECONDS);
            if (str3 != null) {
                return new WebResourceResponse("application/javascript", Utf8Charset.NAME, new ByteArrayInputStream(str3.getBytes(StandardCharsets.UTF_8)));
            }
        } catch (InterruptedException | ExecutionException | TimeoutException e3) {
            int i3 = zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.g("Could not fetch MRAID JS.", e3);
        }
        return null;
    }

    public static final boolean l(Context context) {
        Window window;
        if ((context instanceof Activity) && (window = ((Activity) context).getWindow()) != null && window.getDecorView() != null) {
            Rect rect = new Rect();
            Rect rect2 = new Rect();
            window.getDecorView().getGlobalVisibleRect(rect, null);
            window.getDecorView().getWindowVisibleDisplayFrame(rect2);
            if (rect.bottom != 0 && rect2.bottom != 0 && rect.top == rect2.top) {
                return true;
            }
        }
        return false;
    }

    public static final void m(View view, int i3, MotionEvent motionEvent) {
        String strZza;
        int i4;
        int iHeight;
        int iWidth;
        String str;
        zzfkf zzfkfVarZzC;
        zzfki zzfkiVarZzaC;
        View childAt = view;
        int[] iArr = new int[2];
        Rect rect = new Rect();
        try {
            String packageName = childAt.getContext().getPackageName();
            if (childAt instanceof zzdwl) {
                childAt = ((zzdwl) childAt).getChildAt(0);
            }
            if ((childAt instanceof com.google.android.gms.ads.formats.zzh) || (childAt instanceof NativeAdView)) {
                strZza = "NATIVE";
                i4 = 1;
            } else {
                strZza = "UNKNOWN";
                i4 = 0;
            }
            if (childAt.getLocalVisibleRect(rect)) {
                iWidth = rect.width();
                iHeight = rect.height();
            } else {
                iHeight = 0;
                iWidth = 0;
            }
            com.google.android.gms.ads.internal.zzt.g();
            long jJ0 = j0(childAt);
            childAt.getLocationOnScreen(iArr);
            int i5 = iArr[0];
            int i6 = iArr[1];
            boolean z2 = childAt instanceof zzcmb;
            String str2 = IntegrityManager.INTEGRITY_TYPE_NONE;
            if (!z2 || (zzfkiVarZzaC = ((zzcmb) childAt).zzaC()) == null) {
                str = IntegrityManager.INTEGRITY_TYPE_NONE;
            } else {
                str = zzfkiVarZzaC.zzb;
                int iHashCode = childAt.hashCode();
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 1 + String.valueOf(iHashCode).length());
                sb.append(str);
                sb.append(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
                sb.append(iHashCode);
                childAt.setContentDescription(sb.toString());
            }
            if ((childAt instanceof zzckl) && (zzfkfVarZzC = ((zzckl) childAt).zzC()) != null) {
                strZza = zzfkf.zza(zzfkfVarZzC.zzb);
                i4 = zzfkfVarZzC.zze;
                str2 = zzfkfVarZzC.zzE;
            }
            String str3 = String.format(Locale.US, "<Ad hashCode=%d, package=%s, adNetCls=%s, gwsQueryId=%s, format=%s, impType=%d, class=%s, x=%d, y=%d, width=%d, height=%d, vWidth=%d, vHeight=%d, alpha=%d, state=%s>", Integer.valueOf(childAt.hashCode()), packageName, str2, str, strZza, Integer.valueOf(i4), childAt.getClass().getName(), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(childAt.getWidth()), Integer.valueOf(childAt.getHeight()), Integer.valueOf(iWidth), Integer.valueOf(iHeight), Long.valueOf(jJ0), Integer.toString(i3, 2));
            int i7 = zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.e(str3);
        } catch (Exception e3) {
            int i8 = zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.d("Failure getting view location.", e3);
        }
    }

    public static final AlertDialog.Builder n(Context context) {
        com.google.android.gms.ads.internal.zzt.j();
        return new AlertDialog.Builder(context, android.R.style.Theme.Material.Dialog.Alert);
    }

    public static final void o(Context context, String str, String str2) {
        new zzbt(context, str, str2, null, null).zzb();
    }

    public static final void p(Context context, Throwable th) {
        if (context == null) {
            return;
        }
        try {
            if (((Boolean) zzbkz.zzb.zze()).booleanValue()) {
                CrashUtils.a(context, th);
            }
        } catch (IllegalStateException unused) {
        }
    }

    public static final void q(Context context, zzfkf zzfkfVar, zzdzl zzdzlVar) {
        zzdzk zzdzkVarZza = zzdzlVar.zza();
        zzdzkVarZza.zzc("action", "can_show");
        com.google.android.gms.ads.internal.zzt.g();
        boolean zJ = j(context);
        String str = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        zzdzkVarZza.zzc("foreground", true != zJ ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        if (true == com.google.android.gms.ads.internal.zzt.k().zzf()) {
            str = AppEventsConstants.EVENT_PARAM_VALUE_YES;
        }
        zzdzkVarZza.zzc("fg_al", str);
        if (zzfkfVar != null) {
            List list = zzfkfVar.zzt;
            if (!list.isEmpty()) {
                zzdzkVarZza.zzc("ancn", (String) list.get(0));
            }
            zzdzkVarZza.zzc("ad_format", zzfkf.zza(zzfkfVar.zzb));
        }
        zzdzkVarZza.zzd();
    }

    public static final boolean r(zzfkf zzfkfVar) {
        return ((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzoY)).booleanValue() && zzfkfVar != null && zzfkfVar.zze == 4;
    }

    public static final int s(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e3) {
            String strConcat = "Could not parse value:".concat(e3.toString());
            int i3 = zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.f(strConcat);
            return 0;
        }
    }

    public static final Map t(Uri uri) {
        String encodedQuery;
        if (uri == null) {
            return null;
        }
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzt)).booleanValue()) {
            HashMap map = new HashMap();
            for (String str : uri.getQueryParameterNames()) {
                if (!TextUtils.isEmpty(str)) {
                    map.put(str, uri.getQueryParameter(str));
                }
            }
            return map;
        }
        HashMap map2 = new HashMap();
        if (!uri.isOpaque() && (encodedQuery = uri.getEncodedQuery()) != null) {
            int i3 = 0;
            while (true) {
                int iIndexOf = encodedQuery.indexOf(38, i3);
                int length = encodedQuery.length();
                if (iIndexOf != -1) {
                    length = iIndexOf;
                }
                int iIndexOf2 = encodedQuery.indexOf(61, i3);
                if (iIndexOf2 > length || iIndexOf2 == -1) {
                    iIndexOf2 = length;
                }
                map2.put(Uri.decode(encodedQuery.substring(i3, iIndexOf2)), iIndexOf2 == length ? "" : Uri.decode(encodedQuery.substring(iIndexOf2 + 1, length)));
                if (iIndexOf == -1) {
                    break;
                }
                i3 = iIndexOf + 1;
            }
        }
        return map2;
    }

    public static final int[] v(Activity activity) {
        View viewFindViewById;
        Window window = activity.getWindow();
        return (window == null || (viewFindViewById = window.findViewById(android.R.id.content)) == null) ? h0() : new int[]{viewFindViewById.getWidth(), viewFindViewById.getHeight()};
    }

    public static final int[] w(Activity activity) {
        View viewFindViewById;
        Window window = activity.getWindow();
        int[] iArrH0 = (window == null || (viewFindViewById = window.findViewById(android.R.id.content)) == null) ? h0() : new int[]{viewFindViewById.getTop(), viewFindViewById.getBottom()};
        return new int[]{com.google.android.gms.ads.internal.client.zzay.a().l(activity, iArrH0[0]), com.google.android.gms.ads.internal.client.zzay.a().l(activity, iArrH0[1])};
    }

    public static final boolean x(View view, PowerManager powerManager, KeyguardManager keyguardManager) {
        boolean z2 = com.google.android.gms.ads.internal.zzt.g().f70379e || keyguardManager == null || !keyguardManager.inKeyguardRestrictedInputMode() || Z(view);
        long jJ0 = j0(view);
        if (view.getVisibility() != 0 || !view.isShown() || ((powerManager != null && !powerManager.isScreenOn()) || !z2)) {
            return false;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzbX)).booleanValue() && !view.getLocalVisibleRect(new Rect()) && !view.getGlobalVisibleRect(new Rect())) {
            return false;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzlY)).booleanValue()) {
            if (jJ0 < ((Integer) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzma)).intValue()) {
                return false;
            }
        }
        return true;
    }

    public static final void y(Context context, Intent intent) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzmv)).booleanValue()) {
            K(context, intent);
            return;
        }
        try {
            K(context, intent);
        } catch (SecurityException e3) {
            int i3 = zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.g("", e3);
            com.google.android.gms.ads.internal.zzt.l().zzg(e3, "AdUtil.startActivityWithUnknownContext");
        }
    }

    public static final void z(Context context, Uri uri) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", uri);
            Bundle bundle = new Bundle();
            intent.putExtras(bundle);
            b0(context, intent);
            bundle.putString("com.android.browser.application_id", context.getPackageName());
            context.startActivity(intent);
            String string = uri.toString();
            StringBuilder sb = new StringBuilder(String.valueOf(string).length() + 26);
            sb.append("Opening ");
            sb.append(string);
            sb.append(" in a new browser.");
            String string2 = sb.toString();
            int i3 = zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.a(string2);
        } catch (ActivityNotFoundException e3) {
            int i4 = zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.d("No browser is found.", e3);
        }
    }

    public final void M(Context context, String str, boolean z2, HttpURLConnection httpURLConnection, boolean z3, int i3) {
        int iA = A(i3);
        StringBuilder sb = new StringBuilder(String.valueOf(iA).length() + 28);
        sb.append("HTTP timeout: ");
        sb.append(iA);
        sb.append(" milliseconds.");
        String string = sb.toString();
        int i4 = zze.f70328b;
        com.google.android.gms.ads.internal.util.client.zzo.e(string);
        httpURLConnection.setConnectTimeout(iA);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setReadTimeout(iA);
        if (TextUtils.isEmpty(httpURLConnection.getRequestProperty(GraphRequest.USER_AGENT_HEADER))) {
            httpURLConnection.setRequestProperty(GraphRequest.USER_AGENT_HEADER, P(context, str));
        }
        httpURLConnection.setUseCaches(false);
    }

    public final boolean N(Context context) {
        if (this.f70383i) {
            return false;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        zzbiq.zza(context);
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzmu)).booleanValue() || Build.VERSION.SDK_INT < 33) {
            context.getApplicationContext().registerReceiver(new zzr(this, null), intentFilter);
        } else {
            context.getApplicationContext().registerReceiver(new zzr(this, null), intentFilter, 4);
        }
        this.f70383i = true;
        return true;
    }

    public final boolean O(Context context) {
        if (this.f70384j) {
            return false;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.google.android.ads.intent.DEBUG_LOGGING_ENABLEMENT_CHANGED");
        zzbiq.zza(context);
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzmu)).booleanValue() || Build.VERSION.SDK_INT < 33) {
            context.getApplicationContext().registerReceiver(new zzp(this, null), intentFilter);
        } else {
            context.getApplicationContext().registerReceiver(new zzp(this, null), intentFilter, 4);
        }
        this.f70384j = true;
        return true;
    }

    public final String P(Context context, String str) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzmH)).booleanValue()) {
            if (this.f70382h != null) {
                return this.f70382h;
            }
            this.f70382h = L(context, str);
            return this.f70382h;
        }
        synchronized (this.f70380f) {
            try {
                String str2 = this.f70381g;
                if (str2 != null) {
                    return str2;
                }
                String strL = L(context, str);
                this.f70381g = strL;
                return strL;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final ListenableFuture Q(final Uri uri) {
        return zzhbw.zzd(new Callable() { // from class: com.google.android.gms.ads.internal.util.zzo
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                zzgam zzgamVar = zzs.f70374l;
                com.google.android.gms.ads.internal.zzt.g();
                return zzs.t(uri);
            }
        }, this.f70385k);
    }

    public final void R(final Context context, final String str, String str2, Bundle bundle, boolean z2) {
        com.google.android.gms.ads.internal.zzt.g();
        bundle.putString(DeviceRequestsHelper.DEVICE_INFO_DEVICE, e0());
        zzbih zzbihVar = zzbiq.zza;
        bundle.putString("eids", TextUtils.join(",", com.google.android.gms.ads.internal.client.zzba.b().zze()));
        if (bundle.isEmpty()) {
            int i3 = zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.a("Empty or null bundle.");
        } else {
            final String str3 = (String) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzlW);
            if (!this.f70378d.getAndSet(true)) {
                this.f70377c.set(zzac.c(context, str3, new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: com.google.android.gms.ads.internal.util.zzm
                    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
                    public final /* synthetic */ void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str4) {
                        this.f70365a.W(context, str3, sharedPreferences, str4);
                    }
                }));
            }
            bundle.putAll((Bundle) this.f70377c.get());
        }
        com.google.android.gms.ads.internal.client.zzay.a();
        com.google.android.gms.ads.internal.util.client.zzf.d(context, str, "gmob-apps", bundle, true, new com.google.android.gms.ads.internal.util.client.zze() { // from class: com.google.android.gms.ads.internal.util.zzl
            @Override // com.google.android.gms.ads.internal.util.client.zze
            public final /* synthetic */ com.google.android.gms.ads.internal.util.client.zzt zza(String str4) {
                zzgam zzgamVar = zzs.f70374l;
                com.google.android.gms.ads.internal.zzt.g();
                zzs.o(context, str, str4);
                return com.google.android.gms.ads.internal.util.client.zzt.SUCCESS;
            }
        });
    }

    public final boolean S(String str) {
        return F(str, this.f70375a, (String) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzaQ));
    }

    public final boolean T(String str) {
        return F(str, this.f70376b, (String) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzaR));
    }

    final /* synthetic */ void W(Context context, String str, SharedPreferences sharedPreferences, String str2) {
        this.f70377c.set(zzac.b(context, str));
    }

    final /* synthetic */ void X(boolean z2) {
        this.f70379e = z2;
    }

    public final int Y(Context context, Uri uri, Bundle bundle) {
        if (context == null) {
            zze.k("Trying to open chrome custom tab on a null context");
            return 3;
        }
        if (!(context instanceof Activity)) {
            I(context, uri);
            return 2;
        }
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzfA)).booleanValue()) {
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzfy)).booleanValue()) {
                I(context, uri);
                return 9;
            }
            zzbjr zzbjrVar = new zzbjr();
            zzbjrVar.zzd(new zzk(this, zzbjrVar, bundle, context, uri));
            zzbjrVar.zze((Activity) context);
            return 5;
        }
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder(com.google.android.gms.ads.internal.zzt.r().zzb());
        J(builder, bundle);
        CustomTabsIntent customTabsIntentA = builder.a();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzfN)).booleanValue()) {
            com.google.android.gms.ads.internal.client.zzay.a();
            if (com.google.android.gms.ads.internal.util.client.zzf.F()) {
                return 5;
            }
        }
        customTabsIntentA.f2637a.setPackage(zzink.zza(context));
        customTabsIntentA.a(context, uri);
        return 5;
    }
}
