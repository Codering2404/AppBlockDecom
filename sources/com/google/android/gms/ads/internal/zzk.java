package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.internal.ads.zzawn;
import com.google.android.gms.internal.ads.zzawo;
import com.google.android.gms.internal.ads.zzbad;
import com.google.android.gms.internal.ads.zzbah;
import com.google.android.gms.internal.ads.zzbak;
import com.google.android.gms.internal.ads.zzbao;
import com.google.android.gms.internal.ads.zzbiq;
import com.google.android.gms.internal.ads.zzcfr;
import com.google.android.gms.internal.ads.zzfxg;
import com.google.android.gms.internal.ads.zzfyd;
import com.google.android.gms.internal.ads.zzfyx;
import com.google.android.gms.internal.ads.zzhbw;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzk implements Runnable, zzbak {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final long f70406q = System.currentTimeMillis();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected boolean f70410d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f70411f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f70412g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Executor f70413h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final zzfxg f70414i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Context f70415j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Context f70416k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private VersionInfoParcel f70417l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final VersionInfoParcel f70418m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final boolean f70419n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f70421p;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f70407a = new Vector();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicReference f70408b = new AtomicReference();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AtomicReference f70409c = new AtomicReference();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    final CountDownLatch f70420o = new CountDownLatch(1);

    public zzk(Context context, VersionInfoParcel versionInfoParcel) {
        this.f70415j = context;
        this.f70416k = context;
        this.f70417l = versionInfoParcel;
        this.f70418m = versionInfoParcel;
        ExecutorService executorServiceNewCachedThreadPool = Executors.newCachedThreadPool();
        this.f70413h = executorServiceNewCachedThreadPool;
        boolean zBooleanValue = ((Boolean) zzba.c().zzd(zzbiq.zzdn)).booleanValue();
        this.f70419n = zBooleanValue;
        this.f70414i = zzfxg.zza(context, executorServiceNewCachedThreadPool, zBooleanValue);
        this.f70411f = ((Boolean) zzba.c().zzd(zzbiq.zzdk)).booleanValue();
        this.f70412g = ((Boolean) zzba.c().zzd(zzbiq.zzdo)).booleanValue();
        if (((Boolean) zzba.c().zzd(zzbiq.zzdm)).booleanValue()) {
            this.f70421p = 2;
        } else {
            this.f70421p = 1;
        }
        if (!((Boolean) zzba.c().zzd(zzbiq.zzep)).booleanValue()) {
            this.f70410d = d();
        }
        if (((Boolean) zzba.c().zzd(zzbiq.zzem)).booleanValue()) {
            zzcfr.zza.execute(this);
            return;
        }
        zzay.a();
        if (com.google.android.gms.ads.internal.util.client.zzf.b()) {
            zzcfr.zza.execute(this);
        } else {
            run();
        }
    }

    private final void h() {
        List<Object[]> list = this.f70407a;
        zzbak zzbakVarJ = j();
        if (list.isEmpty() || zzbakVarJ == null) {
            return;
        }
        for (Object[] objArr : list) {
            try {
                int length = objArr.length;
                if (length == 1) {
                    zzbakVarJ.zzd((MotionEvent) objArr[0]);
                } else if (length == 3) {
                    zzbakVarJ.zze(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue(), ((Integer) objArr[2]).intValue());
                }
            } catch (NullPointerException unused) {
            }
        }
        this.f70407a.clear();
    }

    private final void i(boolean z2) {
        String str = this.f70417l.f70149a;
        Context contextK = k(this.f70415j);
        zzawn zzawnVarZze = zzawo.zze();
        zzawnVarZze.zzb(z2);
        zzawnVarZze.zza(str);
        this.f70408b.set(zzbao.zzt(contextK, (zzawo) zzawnVarZze.zzbu()));
    }

    private final zzbak j() {
        return g() == 2 ? (zzbak) this.f70409c.get() : (zzbak) this.f70408b.get();
    }

    private static final Context k(Context context) {
        Context applicationContext = context.getApplicationContext();
        return applicationContext == null ? context : applicationContext;
    }

    private static final zzbah l(Context context, VersionInfoParcel versionInfoParcel, boolean z2, boolean z3) {
        zzawn zzawnVarZze = zzawo.zze();
        zzawnVarZze.zzb(z2);
        zzawnVarZze.zza(versionInfoParcel.f70149a);
        return zzbah.zza(k(context), (zzawo) zzawnVarZze.zzbu(), z3);
    }

    public final boolean a() {
        try {
            this.f70420o.await();
            return true;
        } catch (InterruptedException e3) {
            int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.g("Interrupted during GADSignals creation.", e3);
            return false;
        }
    }

    public final String b(Context context, byte[] bArr) {
        zzbak zzbakVarJ;
        if (!a() || (zzbakVarJ = j()) == null) {
            return "";
        }
        h();
        try {
            return zzbakVarJ.zzl(k(context));
        } catch (NullPointerException unused) {
            return "";
        }
    }

    public final String c() {
        int i3 = this.f70421p;
        int i4 = i3 - 1;
        if (i3 != 0) {
            return i4 != 0 ? "2" : AppEventsConstants.EVENT_PARAM_VALUE_YES;
        }
        throw null;
    }

    protected final boolean d() {
        Context context = this.f70415j;
        zzh zzhVar = new zzh(this);
        zzfxg zzfxgVar = this.f70414i;
        return new zzfyx(this.f70415j, zzfyd.zzb(context, zzfxgVar), zzhVar, ((Boolean) zzba.c().zzd(zzbiq.zzdl)).booleanValue()).zzd(1);
    }

    final /* synthetic */ void e(boolean z2) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            l(this.f70416k, this.f70418m, z2, this.f70419n).zzm();
        } catch (NullPointerException e3) {
            this.f70414i.zzc(2027, System.currentTimeMillis() - jCurrentTimeMillis, e3);
        }
    }

    final /* synthetic */ zzfxg f() {
        return this.f70414i;
    }

    protected final int g() {
        if (!this.f70411f || this.f70410d) {
            return this.f70421p;
        }
        return 1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (((Boolean) zzba.c().zzd(zzbiq.zzep)).booleanValue()) {
                this.f70410d = d();
            }
            boolean z2 = this.f70417l.f70152d;
            final boolean z3 = false;
            if (!((Boolean) zzba.c().zzd(zzbiq.zzbI)).booleanValue() && z2) {
                z3 = true;
            }
            if (g() == 1) {
                i(z3);
                if (this.f70421p == 2) {
                    this.f70413h.execute(new Runnable() { // from class: com.google.android.gms.ads.internal.zzi
                        @Override // java.lang.Runnable
                        public final /* synthetic */ void run() {
                            this.f70402a.e(z3);
                        }
                    });
                }
            } else {
                long jCurrentTimeMillis = System.currentTimeMillis();
                try {
                    zzbah zzbahVarL = l(this.f70415j, this.f70417l, z3, this.f70419n);
                    this.f70409c.set(zzbahVarL);
                    if (this.f70412g && !zzbahVarL.zzb()) {
                        this.f70421p = 1;
                        i(z3);
                    }
                } catch (NullPointerException e3) {
                    this.f70421p = 1;
                    i(z3);
                    this.f70414i.zzc(2031, System.currentTimeMillis() - jCurrentTimeMillis, e3);
                }
            }
            this.f70420o.countDown();
            this.f70415j = null;
            this.f70417l = null;
        } catch (Throwable th) {
            this.f70420o.countDown();
            this.f70415j = null;
            this.f70417l = null;
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbak
    public final void zzd(MotionEvent motionEvent) {
        zzbak zzbakVarJ = j();
        if (zzbakVarJ == null) {
            this.f70407a.add(new Object[]{motionEvent});
            return;
        }
        h();
        try {
            zzbakVarJ.zzd(motionEvent);
        } catch (NullPointerException unused) {
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbak
    public final void zze(int i3, int i4, int i5) {
        zzbak zzbakVarJ = j();
        if (zzbakVarJ == null) {
            this.f70407a.add(new Object[]{Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)});
            return;
        }
        h();
        try {
            zzbakVarJ.zze(i3, i4, i5);
        } catch (NullPointerException unused) {
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbak
    public final String zzf(Context context, String str, View view, Activity activity) {
        if (!a()) {
            return "";
        }
        zzbak zzbakVarJ = j();
        if (((Boolean) zzba.c().zzd(zzbiq.zzmc)).booleanValue()) {
            zzt.g();
            com.google.android.gms.ads.internal.util.zzs.m(view, 4, null);
        }
        if (zzbakVarJ == null) {
            return "";
        }
        h();
        try {
            return zzbakVarJ.zzf(k(context), str, view, activity);
        } catch (NullPointerException unused) {
            return "";
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbak
    public final String zzg(Context context, String str, View view) {
        return zzf(context, str, view, null);
    }

    @Override // com.google.android.gms.internal.ads.zzbak
    public final void zzh(View view) {
        zzbak zzbakVarJ = j();
        if (zzbakVarJ != null) {
            try {
                zzbakVarJ.zzh(view);
            } catch (NullPointerException unused) {
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbak
    public final void zzi(StackTraceElement[] stackTraceElementArr) {
        zzbak zzbakVarJ;
        zzbak zzbakVarJ2;
        if (((Boolean) zzba.c().zzd(zzbiq.zzdH)).booleanValue()) {
            if (this.f70420o.getCount() != 0 || (zzbakVarJ2 = j()) == null) {
                return;
            }
            try {
                zzbakVarJ2.zzi(stackTraceElementArr);
                return;
            } catch (NullPointerException unused) {
                return;
            }
        }
        if (!a() || (zzbakVarJ = j()) == null) {
            return;
        }
        try {
            zzbakVarJ.zzi(stackTraceElementArr);
        } catch (NullPointerException unused2) {
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbak
    public final String zzj(Context context, View view, Activity activity) {
        try {
            if (!((Boolean) zzba.c().zzd(zzbiq.zzmb)).booleanValue()) {
                zzbak zzbakVarJ = j();
                if (((Boolean) zzba.c().zzd(zzbiq.zzmc)).booleanValue()) {
                    zzt.g();
                    com.google.android.gms.ads.internal.util.zzs.m(view, 2, null);
                }
                return zzbakVarJ != null ? zzbakVarJ.zzj(context, view, activity) : "";
            }
            if (!a()) {
                return "";
            }
            zzbak zzbakVarJ2 = j();
            if (((Boolean) zzba.c().zzd(zzbiq.zzmc)).booleanValue()) {
                zzt.g();
                com.google.android.gms.ads.internal.util.zzs.m(view, 2, null);
            }
            return zzbakVarJ2 != null ? zzbakVarJ2.zzj(context, view, activity) : "";
        } catch (NullPointerException unused) {
            return "";
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzbak
    public final String zzk(final Context context) {
        try {
            return (String) zzhbw.zzd(new Callable() { // from class: com.google.android.gms.ads.internal.zzj
                @Override // java.util.concurrent.Callable
                public final /* synthetic */ Object call() {
                    return this.f70404a.b(context, null);
                }
            }, this.f70413h).get(((Integer) zzba.c().zzd(zzbiq.zzdB)).intValue(), TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException unused) {
            return Integer.toString(17);
        } catch (TimeoutException unused2) {
            return zzbad.zza(context, this.f70418m.f70149a, f70406q, true);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbak
    public final String zzl(Context context) {
        return b(context, null);
    }
}
