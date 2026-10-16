package com.google.android.gms.analytics;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.gtm.zzax;
import com.google.android.gms.internal.gtm.zzbc;
import com.google.android.gms.internal.gtm.zzfu;
import java.lang.Thread;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzr {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static volatile zzr f70916g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f70917a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f70918b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzg f70919c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzn f70920d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile zzax f70921e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Thread.UncaughtExceptionHandler f70922f;

    zzr(Context context) {
        Context applicationContext = context.getApplicationContext();
        Preconditions.m(applicationContext);
        this.f70917a = applicationContext;
        this.f70920d = new zzn(this);
        this.f70918b = new CopyOnWriteArrayList();
        this.f70919c = new zzg();
    }

    public static zzr b(Context context) {
        Preconditions.m(context);
        if (f70916g == null) {
            synchronized (zzr.class) {
                try {
                    if (f70916g == null) {
                        f70916g = new zzr(context);
                    }
                } finally {
                }
            }
        }
        return f70916g;
    }

    public static void h() {
        if (!(Thread.currentThread() instanceof zzq)) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    public final Context a() {
        return this.f70917a;
    }

    public final zzax c() {
        if (this.f70921e == null) {
            synchronized (this) {
                try {
                    if (this.f70921e == null) {
                        zzax zzaxVar = new zzax();
                        PackageManager packageManager = this.f70917a.getPackageManager();
                        String packageName = this.f70917a.getPackageName();
                        zzaxVar.zzi(packageName);
                        zzaxVar.zzj(packageManager.getInstallerPackageName(packageName));
                        String str = null;
                        try {
                            PackageInfo packageInfo = packageManager.getPackageInfo(this.f70917a.getPackageName(), 0);
                            if (packageInfo != null) {
                                CharSequence applicationLabel = packageManager.getApplicationLabel(packageInfo.applicationInfo);
                                if (!TextUtils.isEmpty(applicationLabel)) {
                                    packageName = applicationLabel.toString();
                                }
                                str = packageInfo.versionName;
                            }
                        } catch (PackageManager.NameNotFoundException unused) {
                            Log.e("GAv4", "Error retrieving package info: appName set to " + packageName);
                        }
                        zzaxVar.zzk(packageName);
                        zzaxVar.zzl(str);
                        this.f70921e = zzaxVar;
                    }
                } finally {
                }
            }
        }
        return this.f70921e;
    }

    public final zzbc d() {
        DisplayMetrics displayMetrics = this.f70917a.getResources().getDisplayMetrics();
        zzbc zzbcVar = new zzbc();
        zzbcVar.zze(zzfu.zzd(Locale.getDefault()));
        zzbcVar.zza = displayMetrics.widthPixels;
        zzbcVar.zzb = displayMetrics.heightPixels;
        return zzbcVar;
    }

    public final Future g(Callable callable) {
        Preconditions.m(callable);
        if (!(Thread.currentThread() instanceof zzq)) {
            return this.f70920d.submit(callable);
        }
        FutureTask futureTask = new FutureTask(callable);
        futureTask.run();
        return futureTask;
    }

    public final void i(Runnable runnable) {
        Preconditions.m(runnable);
        this.f70920d.submit(runnable);
    }

    public final void j(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.f70922f = uncaughtExceptionHandler;
    }

    final void k(zzh zzhVar) {
        if (zzhVar.l()) {
            throw new IllegalStateException("Measurement prototype can't be submitted");
        }
        if (zzhVar.m()) {
            throw new IllegalStateException("Measurement can only be submitted once");
        }
        zzh zzhVar2 = new zzh(zzhVar);
        zzhVar2.i();
        this.f70920d.execute(new zzl(this, zzhVar2));
    }
}
