package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.util.ClientLibraryUtils;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.ParametersAreNonnullByDefault;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
@ParametersAreNonnullByDefault
public final class zzcdz {
    private final AtomicReference zzb = new AtomicReference(null);
    private final Object zzc = new Object();
    private String zzd = null;
    final AtomicBoolean zza = new AtomicBoolean(false);
    private final AtomicInteger zze = new AtomicInteger(-1);
    private final AtomicReference zzf = new AtomicReference(null);
    private final AtomicReference zzg = new AtomicReference(null);
    private final ConcurrentMap zzh = new ConcurrentHashMap(9);
    private final Object zzi = new Object();

    public static final Bundle zzq(Map map) {
        Bundle bundle = new Bundle();
        if (map != null) {
            for (String str : map.keySet()) {
                try {
                    if (Objects.equals(str, "value")) {
                        bundle.putDouble(str, Double.parseDouble((String) map.get(str)));
                    } else {
                        bundle.putString(str, (String) map.get(str));
                    }
                } catch (NullPointerException | NumberFormatException unused) {
                }
            }
        }
        return bundle;
    }

    static final boolean zzr(Context context) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzaX)).booleanValue()) {
            return false;
        }
        if (DynamiteModule.a(context, ModuleDescriptor.MODULE_ID) < ((Integer) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzaY)).intValue()) {
            return false;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzaZ)).booleanValue()) {
            try {
                context.getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics");
                return false;
            } catch (ClassNotFoundException unused) {
            }
        }
        return true;
    }

    private final void zzs(Context context, String str, String str2, Bundle bundle) {
        if (zza(context)) {
            Bundle bundle2 = new Bundle();
            try {
                bundle2.putLong("_aeid", Long.parseLong(str2));
            } catch (NullPointerException | NumberFormatException e3) {
                String strValueOf = String.valueOf(str2);
                int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
                com.google.android.gms.ads.internal.util.client.zzo.d("Invalid event ID: ".concat(strValueOf), e3);
            }
            if ("_ac".equals(str)) {
                bundle2.putInt("_r", 1);
            }
            if (bundle != null) {
                bundle2.putAll(bundle);
            }
            if (zzx(context, "com.google.android.gms.measurement.AppMeasurement", this.zzf, true)) {
                ConcurrentMap concurrentMap = this.zzh;
                Method declaredMethod = (Method) concurrentMap.get("logEventInternal");
                if (declaredMethod == null) {
                    try {
                        declaredMethod = context.getClassLoader().loadClass("com.google.android.gms.measurement.AppMeasurement").getDeclaredMethod("logEventInternal", String.class, String.class, Bundle.class);
                        concurrentMap.put("logEventInternal", declaredMethod);
                    } catch (Exception unused) {
                        zzw("logEventInternal", true);
                        declaredMethod = null;
                    }
                }
                try {
                    declaredMethod.invoke(this.zzf.get(), "am", str, bundle2);
                } catch (Exception unused2) {
                    zzw("logEventInternal", true);
                }
            }
        }
    }

    private final Method zzt(Context context, String str) {
        ConcurrentMap concurrentMap = this.zzh;
        Method method = (Method) concurrentMap.get(str);
        if (method != null) {
            return method;
        }
        try {
            Method declaredMethod = context.getClassLoader().loadClass("com.google.android.gms.measurement.AppMeasurement").getDeclaredMethod(str, null);
            concurrentMap.put(str, declaredMethod);
            return declaredMethod;
        } catch (Exception unused) {
            zzw(str, false);
            return null;
        }
    }

    private final void zzu(Context context, String str, String str2) {
        if (zzx(context, "com.google.android.gms.measurement.AppMeasurement", this.zzf, true)) {
            ConcurrentMap concurrentMap = this.zzh;
            Method declaredMethod = (Method) concurrentMap.get(str2);
            if (declaredMethod == null) {
                try {
                    declaredMethod = context.getClassLoader().loadClass("com.google.android.gms.measurement.AppMeasurement").getDeclaredMethod(str2, String.class);
                    concurrentMap.put(str2, declaredMethod);
                } catch (Exception unused) {
                    zzw(str2, false);
                    declaredMethod = null;
                }
            }
            try {
                declaredMethod.invoke(this.zzf.get(), str);
                StringBuilder sb = new StringBuilder(str2.length() + 37 + String.valueOf(str).length());
                sb.append("Invoke Firebase method ");
                sb.append(str2);
                sb.append(", Ad Unit Id: ");
                sb.append(str);
                com.google.android.gms.ads.internal.util.zze.k(sb.toString());
            } catch (Exception unused2) {
                zzw(str2, false);
            }
        }
    }

    private final Object zzv(String str, Context context) {
        AtomicReference atomicReference = this.zzf;
        if (!zzx(context, "com.google.android.gms.measurement.AppMeasurement", atomicReference, true)) {
            return null;
        }
        try {
            return zzt(context, str).invoke(atomicReference.get(), null);
        } catch (Exception unused) {
            zzw(str, true);
            return null;
        }
    }

    private final void zzw(String str, boolean z2) {
        AtomicBoolean atomicBoolean = this.zza;
        if (atomicBoolean.get()) {
            return;
        }
        StringBuilder sb = new StringBuilder(str.length() + 30);
        sb.append("Invoke Firebase method ");
        sb.append(str);
        sb.append(" error.");
        String string = sb.toString();
        int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
        com.google.android.gms.ads.internal.util.client.zzo.f(string);
        if (z2) {
            com.google.android.gms.ads.internal.util.client.zzo.f("The Google Mobile Ads SDK will not integrate with Firebase. Admob/Firebase integration requires the latest Firebase SDK jar, but Firebase SDK is either missing or out of date");
            atomicBoolean.set(true);
        }
    }

    private final boolean zzx(Context context, String str, AtomicReference atomicReference, boolean z2) {
        if (atomicReference.get() != null) {
            return true;
        }
        try {
            androidx.compose.animation.core.h.a(atomicReference, null, context.getClassLoader().loadClass(str).getDeclaredMethod("getInstance", Context.class).invoke(null, context));
            return true;
        } catch (Exception unused) {
            zzw("getInstance", z2);
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean zza(android.content.Context r6) {
        /*
            r5 = this;
            com.google.android.gms.internal.ads.zzbih r0 = com.google.android.gms.internal.ads.zzbiq.zzaP
            com.google.android.gms.internal.ads.zzbio r1 = com.google.android.gms.ads.internal.client.zzba.c()
            java.lang.Object r0 = r1.zzd(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            r1 = 0
            if (r0 == 0) goto L63
            java.util.concurrent.atomic.AtomicBoolean r0 = r5.zza
            boolean r0 = r0.get()
            if (r0 == 0) goto L1c
            goto L63
        L1c:
            com.google.android.gms.internal.ads.zzbih r0 = com.google.android.gms.internal.ads.zzbiq.zzba
            com.google.android.gms.internal.ads.zzbio r2 = com.google.android.gms.ads.internal.client.zzba.c()
            java.lang.Object r0 = r2.zzd(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            r2 = 1
            if (r0 == 0) goto L30
            return r2
        L30:
            java.util.concurrent.atomic.AtomicInteger r0 = r5.zze
            int r3 = r0.get()
            r4 = -1
            if (r3 != r4) goto L5c
            com.google.android.gms.ads.internal.client.zzay.a()
            r3 = 12451000(0xbdfcb8, float:1.7447567E-38)
            boolean r3 = com.google.android.gms.ads.internal.util.client.zzf.G(r6, r3)
            if (r3 != 0) goto L59
            com.google.android.gms.ads.internal.client.zzay.a()
            boolean r6 = com.google.android.gms.ads.internal.util.client.zzf.a(r6)
            if (r6 == 0) goto L59
            int r6 = com.google.android.gms.ads.internal.util.zze.f70328b
            java.lang.String r6 = "Google Play Service is out of date, the Google Mobile Ads SDK will not integrate with Firebase. Admob/Firebase integration requires updated Google Play Service."
            com.google.android.gms.ads.internal.util.client.zzo.f(r6)
            r0.set(r1)
            goto L5c
        L59:
            r0.set(r2)
        L5c:
            int r6 = r0.get()
            if (r6 != r2) goto L63
            return r2
        L63:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcdz.zza(android.content.Context):boolean");
    }

    public final void zzb(Context context, com.google.android.gms.ads.internal.client.zzfr zzfrVar) {
        zzcea.zzb(context).zza().zzc(zzfrVar);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzbc)).booleanValue() && zza(context) && zzr(context)) {
            synchronized (this.zzi) {
            }
        }
    }

    public final void zzc(Context context, com.google.android.gms.ads.internal.client.zzm zzmVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzbc)).booleanValue() && zza(context) && zzr(context)) {
            synchronized (this.zzi) {
            }
        }
    }

    public final void zzd(Context context, String str) {
        if (zza(context)) {
            zzu(context, str, "beginAdUnitExposure");
        }
    }

    public final void zze(Context context, String str) {
        if (zza(context)) {
            zzu(context, str, "endAdUnitExposure");
        }
    }

    public final String zzf(Context context) {
        if (zza(context)) {
            AtomicReference atomicReference = this.zzf;
            if (zzx(context, "com.google.android.gms.measurement.AppMeasurement", atomicReference, true)) {
                try {
                    String str = (String) zzt(context, "getCurrentScreenName").invoke(atomicReference.get(), null);
                    if (str == null) {
                        str = (String) zzt(context, "getCurrentScreenClass").invoke(atomicReference.get(), null);
                    }
                    return str == null ? "" : str;
                } catch (Exception unused) {
                    zzw("getCurrentScreenName", false);
                }
            }
        }
        return "";
    }

    @Deprecated
    public final void zzg(Context context, String str) {
        if (zza(context) && (context instanceof Activity) && zzx(context, "com.google.firebase.analytics.FirebaseAnalytics", this.zzg, false)) {
            ConcurrentMap concurrentMap = this.zzh;
            Method declaredMethod = (Method) concurrentMap.get("setCurrentScreen");
            if (declaredMethod == null) {
                try {
                    declaredMethod = context.getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics").getDeclaredMethod("setCurrentScreen", Activity.class, String.class, String.class);
                    concurrentMap.put("setCurrentScreen", declaredMethod);
                } catch (Exception unused) {
                    zzw("setCurrentScreen", false);
                    declaredMethod = null;
                }
            }
            try {
                declaredMethod.invoke(this.zzg.get(), (Activity) context, str, context.getPackageName());
            } catch (Exception unused2) {
                zzw("setCurrentScreen", false);
            }
        }
    }

    public final String zzh(Context context) {
        if (!zza(context)) {
            return null;
        }
        synchronized (this.zzc) {
            try {
                String str = this.zzd;
                if (str != null) {
                    return str;
                }
                String str2 = (String) zzv("getGmpAppId", context);
                this.zzd = str2;
                return str2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final String zzi(final Context context) {
        ExecutorService threadPoolExecutor;
        if (!zza(context)) {
            return null;
        }
        long jLongValue = ((Long) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzaV)).longValue();
        if (jLongValue < 0) {
            return (String) zzv("getAppInstanceId", context);
        }
        AtomicReference atomicReference = this.zzb;
        if (atomicReference.get() == null) {
            if (ClientLibraryUtils.a()) {
                threadPoolExecutor = zzgal.zza().zza(((Integer) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzaW)).intValue(), new zzcdx(this), 2);
            } else {
                zzbih zzbihVar = zzbiq.zzaW;
                threadPoolExecutor = new ThreadPoolExecutor(((Integer) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbihVar)).intValue(), ((Integer) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbihVar)).intValue(), 1L, TimeUnit.MINUTES, new LinkedBlockingQueue(), new zzcdx(this));
            }
            androidx.compose.animation.core.h.a(atomicReference, null, threadPoolExecutor);
        }
        try {
            return (String) ((ExecutorService) atomicReference.get()).submit(new Callable() { // from class: com.google.android.gms.internal.ads.zzcdy
                @Override // java.util.concurrent.Callable
                public final /* synthetic */ Object call() {
                    return this.zza.zzp(context);
                }
            }).get(jLongValue, TimeUnit.MILLISECONDS);
        } catch (TimeoutException unused) {
            return "TIME_OUT";
        } catch (Exception unused2) {
            return null;
        }
    }

    public final String zzj(Context context) {
        Object objZzv;
        if (zza(context) && (objZzv = zzv("generateEventId", context)) != null) {
            return objZzv.toString();
        }
        return null;
    }

    public final void zzk(Context context, String str, Map map) {
        zzs(context, "_ac", str, zzq(map));
    }

    public final void zzl(Context context, String str, Map map) {
        zzs(context, "_ai", str, zzq(map));
    }

    public final void zzm(Context context, String str) {
        zzs(context, "_aq", str, null);
    }

    public final void zzn(Context context, String str) {
        zzs(context, "_aa", str, null);
    }

    public final void zzo(Context context, String str, String str2, String str3, int i3) {
        if (zza(context)) {
            Bundle bundle = new Bundle();
            bundle.putString("_ai", str2);
            bundle.putString("reward_type", str3);
            bundle.putInt("reward_value", i3);
            zzs(context, "_ar", str, bundle);
            StringBuilder sb = new StringBuilder(String.valueOf(str3).length() + 64 + String.valueOf(i3).length());
            sb.append("Log a Firebase reward video event, reward type: ");
            sb.append(str3);
            sb.append(", reward value: ");
            sb.append(i3);
            com.google.android.gms.ads.internal.util.zze.k(sb.toString());
        }
    }

    final /* synthetic */ String zzp(Context context) {
        return (String) zzv("getAppInstanceId", context);
    }
}
