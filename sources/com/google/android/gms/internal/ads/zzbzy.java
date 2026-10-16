package com.google.android.gms.internal.ads;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.WebView;
import com.appsflyer.AppsFlyerProperties;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.wrappers.Wrappers;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.ParametersAreNonnullByDefault;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
@ParametersAreNonnullByDefault
public final class zzbzy implements zzcaa {
    public static zzcaa zza;
    static zzcaa zzb;
    static zzcaa zzc;
    static Boolean zzd;
    private static final Object zze = new Object();
    private final Object zzf;
    private final Context zzg;
    private final WeakHashMap zzh;
    private final ExecutorService zzi;
    private final VersionInfoParcel zzj;
    private final PackageInfo zzk;
    private final String zzl;
    private final String zzm;
    private final AtomicBoolean zzn;
    private boolean zzo;
    private Set zzp;

    /* JADX WARN: Removed duplicated region for block: B:11:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected zzbzy(android.content.Context r3, com.google.android.gms.ads.internal.util.client.VersionInfoParcel r4) {
        /*
            Method dump skipped, instruction units count: 207
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbzy.<init>(android.content.Context, com.google.android.gms.ads.internal.util.client.VersionInfoParcel):void");
    }

    public static zzcaa zza(Context context) {
        synchronized (zze) {
            try {
                if (zza == null) {
                    if (zzj(context)) {
                        zza = new zzbzy(context, VersionInfoParcel.M());
                    } else {
                        zza = new zzbzz();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zza;
    }

    public static zzcaa zzb(Context context, VersionInfoParcel versionInfoParcel) {
        synchronized (zze) {
            try {
                if (zzc == null) {
                    boolean z2 = false;
                    if (((Boolean) zzbki.zzc.zze()).booleanValue()) {
                        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zziC)).booleanValue() || ((Boolean) zzbki.zza.zze()).booleanValue()) {
                            z2 = true;
                        }
                    }
                    if (zzj(context)) {
                        zzbzy zzbzyVar = new zzbzy(context, versionInfoParcel);
                        zzbzyVar.zzl();
                        zzbzyVar.zzk();
                        zzc = zzbzyVar;
                    } else if (!z2 || context == null) {
                        zzc = new zzbzz();
                    } else {
                        zzbzy zzbzyVar2 = new zzbzy(context, versionInfoParcel, true);
                        zzbzyVar2.zzl();
                        zzbzyVar2.zzk();
                        zzc = zzbzyVar2;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzc;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003b A[Catch: all -> 0x0039, TryCatch #0 {all -> 0x0039, blocks: (B:4:0x0003, B:6:0x0007, B:8:0x0019, B:11:0x002d, B:14:0x003b, B:15:0x0042), top: B:20:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.android.gms.internal.ads.zzcaa zzc(android.content.Context r3) {
        /*
            java.lang.Object r0 = com.google.android.gms.internal.ads.zzbzy.zze
            monitor-enter(r0)
            com.google.android.gms.internal.ads.zzcaa r1 = com.google.android.gms.internal.ads.zzbzy.zzb     // Catch: java.lang.Throwable -> L39
            if (r1 != 0) goto L42
            com.google.android.gms.internal.ads.zzbih r1 = com.google.android.gms.internal.ads.zzbiq.zziD     // Catch: java.lang.Throwable -> L39
            com.google.android.gms.internal.ads.zzbio r2 = com.google.android.gms.ads.internal.client.zzba.c()     // Catch: java.lang.Throwable -> L39
            java.lang.Object r1 = r2.zzd(r1)     // Catch: java.lang.Throwable -> L39
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch: java.lang.Throwable -> L39
            boolean r1 = r1.booleanValue()     // Catch: java.lang.Throwable -> L39
            if (r1 == 0) goto L3b
            com.google.android.gms.internal.ads.zzbih r1 = com.google.android.gms.internal.ads.zzbiq.zziC     // Catch: java.lang.Throwable -> L39
            com.google.android.gms.internal.ads.zzbio r2 = com.google.android.gms.ads.internal.client.zzba.c()     // Catch: java.lang.Throwable -> L39
            java.lang.Object r1 = r2.zzd(r1)     // Catch: java.lang.Throwable -> L39
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch: java.lang.Throwable -> L39
            boolean r1 = r1.booleanValue()     // Catch: java.lang.Throwable -> L39
            if (r1 != 0) goto L3b
            if (r3 == 0) goto L3b
            com.google.android.gms.internal.ads.zzbzy r1 = new com.google.android.gms.internal.ads.zzbzy     // Catch: java.lang.Throwable -> L39
            com.google.android.gms.ads.internal.util.client.VersionInfoParcel r2 = com.google.android.gms.ads.internal.util.client.VersionInfoParcel.M()     // Catch: java.lang.Throwable -> L39
            r1.<init>(r3, r2)     // Catch: java.lang.Throwable -> L39
            com.google.android.gms.internal.ads.zzbzy.zzb = r1     // Catch: java.lang.Throwable -> L39
            goto L42
        L39:
            r3 = move-exception
            goto L46
        L3b:
            com.google.android.gms.internal.ads.zzbzz r3 = new com.google.android.gms.internal.ads.zzbzz     // Catch: java.lang.Throwable -> L39
            r3.<init>()     // Catch: java.lang.Throwable -> L39
            com.google.android.gms.internal.ads.zzbzy.zzb = r3     // Catch: java.lang.Throwable -> L39
        L42:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L39
            com.google.android.gms.internal.ads.zzcaa r3 = com.google.android.gms.internal.ads.zzbzy.zzb
            return r3
        L46:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L39
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbzy.zzc(android.content.Context):com.google.android.gms.internal.ads.zzcaa");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0035 A[Catch: all -> 0x0033, TryCatch #0 {all -> 0x0033, blocks: (B:4:0x0003, B:6:0x0007, B:8:0x0019, B:10:0x002b, B:13:0x0035, B:14:0x003c), top: B:19:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.android.gms.internal.ads.zzcaa zzd(android.content.Context r3, com.google.android.gms.ads.internal.util.client.VersionInfoParcel r4) {
        /*
            java.lang.Object r0 = com.google.android.gms.internal.ads.zzbzy.zze
            monitor-enter(r0)
            com.google.android.gms.internal.ads.zzcaa r1 = com.google.android.gms.internal.ads.zzbzy.zzb     // Catch: java.lang.Throwable -> L33
            if (r1 != 0) goto L3c
            com.google.android.gms.internal.ads.zzbih r1 = com.google.android.gms.internal.ads.zzbiq.zziD     // Catch: java.lang.Throwable -> L33
            com.google.android.gms.internal.ads.zzbio r2 = com.google.android.gms.ads.internal.client.zzba.c()     // Catch: java.lang.Throwable -> L33
            java.lang.Object r1 = r2.zzd(r1)     // Catch: java.lang.Throwable -> L33
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch: java.lang.Throwable -> L33
            boolean r1 = r1.booleanValue()     // Catch: java.lang.Throwable -> L33
            if (r1 == 0) goto L35
            com.google.android.gms.internal.ads.zzbih r1 = com.google.android.gms.internal.ads.zzbiq.zziC     // Catch: java.lang.Throwable -> L33
            com.google.android.gms.internal.ads.zzbio r2 = com.google.android.gms.ads.internal.client.zzba.c()     // Catch: java.lang.Throwable -> L33
            java.lang.Object r1 = r2.zzd(r1)     // Catch: java.lang.Throwable -> L33
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch: java.lang.Throwable -> L33
            boolean r1 = r1.booleanValue()     // Catch: java.lang.Throwable -> L33
            if (r1 != 0) goto L35
            com.google.android.gms.internal.ads.zzbzy r1 = new com.google.android.gms.internal.ads.zzbzy     // Catch: java.lang.Throwable -> L33
            r1.<init>(r3, r4)     // Catch: java.lang.Throwable -> L33
            com.google.android.gms.internal.ads.zzbzy.zzb = r1     // Catch: java.lang.Throwable -> L33
            goto L3c
        L33:
            r3 = move-exception
            goto L40
        L35:
            com.google.android.gms.internal.ads.zzbzz r3 = new com.google.android.gms.internal.ads.zzbzz     // Catch: java.lang.Throwable -> L33
            r3.<init>()     // Catch: java.lang.Throwable -> L33
            com.google.android.gms.internal.ads.zzbzy.zzb = r3     // Catch: java.lang.Throwable -> L33
        L3c:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L33
            com.google.android.gms.internal.ads.zzcaa r3 = com.google.android.gms.internal.ads.zzbzy.zzb
            return r3
        L40:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L33
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbzy.zzd(android.content.Context, com.google.android.gms.ads.internal.util.client.VersionInfoParcel):com.google.android.gms.internal.ads.zzcaa");
    }

    public static String zze(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public static String zzf(Throwable th) {
        return zzgua.zza(com.google.android.gms.ads.internal.util.client.zzf.s(zze(th)));
    }

    private static boolean zzj(Context context) {
        if (context == null) {
            return false;
        }
        synchronized (zze) {
            try {
                if (zzd == null) {
                    zzd = Boolean.valueOf(com.google.android.gms.ads.internal.client.zzay.h().nextInt(100) < ((Integer) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzoi)).intValue());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (zzd.booleanValue()) {
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zziC)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    private final void zzk() {
        Thread.setDefaultUncaughtExceptionHandler(new zzbzv(this, Thread.getDefaultUncaughtExceptionHandler()));
    }

    private final void zzl() {
        Thread thread = Looper.getMainLooper().getThread();
        if (thread == null) {
            return;
        }
        synchronized (this.zzf) {
            this.zzh.put(thread, Boolean.TRUE);
        }
        thread.setUncaughtExceptionHandler(new zzbzw(this, thread.getUncaughtExceptionHandler()));
    }

    protected final void zzg(Thread thread, Throwable th) {
        if (th != null) {
            boolean zA = false;
            boolean zEquals = false;
            for (Throwable cause = th; cause != null; cause = cause.getCause()) {
                for (StackTraceElement stackTraceElement : cause.getStackTrace()) {
                    zA |= com.google.android.gms.ads.internal.util.client.zzf.A(stackTraceElement.getClassName());
                    zEquals |= zzbzy.class.getName().equals(stackTraceElement.getClassName());
                }
            }
            int iIntValue = ((Integer) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zziE)).intValue();
            if (iIntValue > 0) {
                if (this.zzp.size() >= iIntValue) {
                    return;
                }
                String strZzf = zzf(th);
                if (this.zzp.contains(strZzf)) {
                    return;
                } else {
                    this.zzp.add(strZzf);
                }
            }
            if (!zA || zEquals) {
                return;
            }
            if (!this.zzo) {
                zzh(th, "");
            }
            if (this.zzn.getAndSet(true) || !((Boolean) zzbki.zzc.zze()).booleanValue()) {
                return;
            }
            zzbib.zzb(this.zzg);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcaa
    public final void zzh(Throwable th, String str) {
        if (this.zzo) {
            return;
        }
        zzi(th, str, 1.0f);
    }

    @Override // com.google.android.gms.internal.ads.zzcaa
    public final void zzi(Throwable th, String str, float f3) {
        Throwable th2;
        boolean zG;
        String packageName;
        ActivityManager.MemoryInfo memoryInfoP;
        if (this.zzo) {
            return;
        }
        Handler handler = com.google.android.gms.ads.internal.util.client.zzf.f70162b;
        int i3 = 0;
        if (((Boolean) zzbkz.zze.zze()).booleanValue()) {
            th2 = th;
        } else {
            LinkedList linkedList = new LinkedList();
            for (Throwable cause = th; cause != null; cause = cause.getCause()) {
                linkedList.push(cause);
            }
            th2 = null;
            while (!linkedList.isEmpty()) {
                Throwable th3 = (Throwable) linkedList.pop();
                StackTraceElement[] stackTrace = th3.getStackTrace();
                boolean z2 = ((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzdf)).booleanValue() && stackTrace != null && stackTrace.length == 0 && com.google.android.gms.ads.internal.util.client.zzf.A(th3.getClass().getName());
                ArrayList arrayList = new ArrayList();
                arrayList.add(new StackTraceElement(th3.getClass().getName(), "<filtered>", "<filtered>", 1));
                for (StackTraceElement stackTraceElement : stackTrace) {
                    if (com.google.android.gms.ads.internal.util.client.zzf.A(stackTraceElement.getClassName())) {
                        arrayList.add(stackTraceElement);
                        z2 = true;
                    } else {
                        String className = stackTraceElement.getClassName();
                        if (!TextUtils.isEmpty(className) && (className.startsWith("android.") || className.startsWith("java."))) {
                            arrayList.add(stackTraceElement);
                        } else {
                            arrayList.add(new StackTraceElement("<filtered>", "<filtered>", "<filtered>", 1));
                        }
                    }
                }
                if (z2) {
                    th2 = th2 == null ? new Throwable(th3.getMessage()) : new Throwable(th3.getMessage(), th2);
                    th2.setStackTrace((StackTraceElement[]) arrayList.toArray(new StackTraceElement[0]));
                }
            }
        }
        if (th2 != null) {
            String name = th.getClass().getName();
            String strZze = zze(th);
            String strZzf = ((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzkd)).booleanValue() ? zzf(th) : "";
            double d3 = f3;
            double dRandom = Math.random();
            int i4 = f3 > 0.0f ? (int) (1.0f / f3) : 1;
            if (dRandom < d3) {
                ArrayList arrayList2 = new ArrayList();
                try {
                    zG = Wrappers.a(this.zzg).g();
                } catch (Throwable th4) {
                    com.google.android.gms.ads.internal.util.client.zzo.d("Error fetching instant app info", th4);
                    zG = false;
                }
                try {
                    packageName = this.zzg.getPackageName();
                } catch (Throwable unused) {
                    com.google.android.gms.ads.internal.util.client.zzo.f("Cannot obtain package name, proceeding.");
                    packageName = "unknown";
                }
                Uri.Builder builderAppendQueryParameter = new Uri.Builder().scheme("https").path("//pagead2.googlesyndication.com/pagead/gen_204").appendQueryParameter("is_aia", Boolean.toString(zG)).appendQueryParameter("id", "gmob-apps-report-exception").appendQueryParameter("os", Build.VERSION.RELEASE).appendQueryParameter("api", String.valueOf(Build.VERSION.SDK_INT));
                String str2 = Build.MANUFACTURER;
                String string = Build.MODEL;
                if (!string.startsWith(str2)) {
                    StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 1 + string.length());
                    sb.append(str2);
                    sb.append(" ");
                    sb.append(string);
                    string = sb.toString();
                }
                Uri.Builder builderAppendQueryParameter2 = builderAppendQueryParameter.appendQueryParameter(DeviceRequestsHelper.DEVICE_INFO_DEVICE, string);
                VersionInfoParcel versionInfoParcel = this.zzj;
                Uri.Builder builderAppendQueryParameter3 = builderAppendQueryParameter2.appendQueryParameter("js", versionInfoParcel.f70149a).appendQueryParameter(AppsFlyerProperties.APP_ID, packageName).appendQueryParameter("exceptiontype", name).appendQueryParameter("stacktrace", strZze).appendQueryParameter("eids", TextUtils.join(",", com.google.android.gms.ads.internal.client.zzba.b().zze())).appendQueryParameter("exceptionkey", str).appendQueryParameter("cl", "885195211").appendQueryParameter("rc", "dev").appendQueryParameter("sampling_rate", Integer.toString(i4)).appendQueryParameter("pb_tm", String.valueOf(zzbkz.zzc.zze()));
                Context context = this.zzg;
                Uri.Builder builderAppendQueryParameter4 = builderAppendQueryParameter3.appendQueryParameter("gmscv", String.valueOf(GoogleApiAvailabilityLight.h().b(context)));
                boolean z3 = versionInfoParcel.f70153f;
                String str3 = AppEventsConstants.EVENT_PARAM_VALUE_YES;
                Uri.Builder builderAppendQueryParameter5 = builderAppendQueryParameter4.appendQueryParameter("lite", true != z3 ? AppEventsConstants.EVENT_PARAM_VALUE_NO : AppEventsConstants.EVENT_PARAM_VALUE_YES);
                if (!TextUtils.isEmpty(strZzf)) {
                    builderAppendQueryParameter5.appendQueryParameter("hash", strZzf);
                }
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zziJ)).booleanValue() && (memoryInfoP = com.google.android.gms.ads.internal.util.client.zzf.p(context)) != null) {
                    builderAppendQueryParameter5.appendQueryParameter("available_memory", Long.toString(memoryInfoP.availMem));
                    builderAppendQueryParameter5.appendQueryParameter("total_memory", Long.toString(memoryInfoP.totalMem));
                    if (true != memoryInfoP.lowMemory) {
                        str3 = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                    }
                    builderAppendQueryParameter5.appendQueryParameter("is_low_memory", str3);
                }
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zziI)).booleanValue()) {
                    String str4 = this.zzl;
                    if (!TextUtils.isEmpty(str4)) {
                        builderAppendQueryParameter5.appendQueryParameter("countrycode", str4);
                    }
                    String str5 = this.zzm;
                    if (!TextUtils.isEmpty(str5)) {
                        builderAppendQueryParameter5.appendQueryParameter("psv", str5);
                    }
                    PackageInfo currentWebViewPackage = WebView.getCurrentWebViewPackage();
                    if (currentWebViewPackage != null) {
                        builderAppendQueryParameter5.appendQueryParameter("wvvc", Integer.toString(currentWebViewPackage.versionCode));
                        builderAppendQueryParameter5.appendQueryParameter("wvvn", currentWebViewPackage.versionName);
                        builderAppendQueryParameter5.appendQueryParameter("wvpn", currentWebViewPackage.packageName);
                    }
                }
                PackageInfo packageInfo = this.zzk;
                if (packageInfo != null) {
                    builderAppendQueryParameter5.appendQueryParameter("appvc", String.valueOf(packageInfo.versionCode));
                    builderAppendQueryParameter5.appendQueryParameter("appvn", packageInfo.versionName);
                }
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzmU)).booleanValue()) {
                    builderAppendQueryParameter5.appendQueryParameter("uev", zzgua.zza(com.google.android.gms.ads.internal.util.client.zzf.q(this.zzg)));
                }
                arrayList2.add(builderAppendQueryParameter5.toString());
                int size = arrayList2.size();
                while (i3 < size) {
                    Object obj = arrayList2.get(i3);
                    i3++;
                    final String str6 = (String) obj;
                    final com.google.android.gms.ads.internal.util.client.zzu zzuVar = new com.google.android.gms.ads.internal.util.client.zzu(this.zzg, null);
                    this.zzi.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbzx
                        @Override // java.lang.Runnable
                        public final /* synthetic */ void run() {
                            zzuVar.b(str6, null);
                        }
                    });
                }
            }
        }
    }

    protected zzbzy(Context context, VersionInfoParcel versionInfoParcel, boolean z2) {
        this(context, versionInfoParcel);
        this.zzo = true;
    }
}
