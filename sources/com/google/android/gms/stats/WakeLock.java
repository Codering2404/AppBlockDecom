package com.google.android.gms.stats;

import android.content.Context;
import android.os.PowerManager;
import android.os.WorkSource;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.common.util.WorkSourceUtil;
import com.google.android.gms.internal.stats.zzh;
import com.google.android.gms.internal.stats.zzi;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public class WakeLock {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final long f74585r = TimeUnit.DAYS.toMillis(366);

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static volatile ScheduledExecutorService f74586s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final Object f74587t = new Object();

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static volatile zzd f74588u = new zzb();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f74589a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final PowerManager.WakeLock f74590b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f74591c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Future f74592d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f74593e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Set f74594f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f74595g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f74596h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    com.google.android.gms.internal.stats.zzb f74597i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Clock f74598j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private WorkSource f74599k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final String f74600l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final String f74601m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Context f74602n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Map f74603o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private AtomicInteger f74604p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final ScheduledExecutorService f74605q;

    public WakeLock(Context context, int i3, String str) {
        String packageName = context.getPackageName();
        this.f74589a = new Object();
        this.f74591c = 0;
        this.f74594f = new HashSet();
        this.f74595g = true;
        this.f74598j = DefaultClock.c();
        this.f74603o = new HashMap();
        this.f74604p = new AtomicInteger(0);
        Preconditions.n(context, "WakeLock: context must not be null");
        Preconditions.h(str, "WakeLock: wakeLockName must not be empty");
        this.f74602n = context.getApplicationContext();
        this.f74601m = str;
        this.f74597i = null;
        if ("com.google.android.gms".equals(context.getPackageName())) {
            this.f74600l = str;
        } else {
            String strValueOf = String.valueOf(str);
            this.f74600l = strValueOf.length() != 0 ? "*gcore*:".concat(strValueOf) : new String("*gcore*:");
        }
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager == null) {
            StringBuilder sb = new StringBuilder(29);
            sb.append((CharSequence) "expected a non-null reference", 0, 29);
            throw new zzi(sb.toString());
        }
        PowerManager.WakeLock wakeLockNewWakeLock = powerManager.newWakeLock(i3, str);
        this.f74590b = wakeLockNewWakeLock;
        if (WorkSourceUtil.c(context)) {
            WorkSource workSourceB = WorkSourceUtil.b(context, Strings.b(packageName) ? context.getPackageName() : packageName);
            this.f74599k = workSourceB;
            if (workSourceB != null) {
                i(wakeLockNewWakeLock, workSourceB);
            }
        }
        ScheduledExecutorService scheduledExecutorServiceUnconfigurableScheduledExecutorService = f74586s;
        if (scheduledExecutorServiceUnconfigurableScheduledExecutorService == null) {
            synchronized (f74587t) {
                try {
                    scheduledExecutorServiceUnconfigurableScheduledExecutorService = f74586s;
                    if (scheduledExecutorServiceUnconfigurableScheduledExecutorService == null) {
                        zzh.zza();
                        scheduledExecutorServiceUnconfigurableScheduledExecutorService = Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(1));
                        f74586s = scheduledExecutorServiceUnconfigurableScheduledExecutorService;
                    }
                } finally {
                }
            }
        }
        this.f74605q = scheduledExecutorServiceUnconfigurableScheduledExecutorService;
    }

    public static /* synthetic */ void e(WakeLock wakeLock) {
        synchronized (wakeLock.f74589a) {
            try {
                if (wakeLock.b()) {
                    Log.e("WakeLock", String.valueOf(wakeLock.f74600l).concat(" ** IS FORCE-RELEASED ON TIMEOUT **"));
                    wakeLock.g();
                    if (wakeLock.b()) {
                        wakeLock.f74591c = 1;
                        wakeLock.h(0);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final String f(String str) {
        if (this.f74595g) {
            TextUtils.isEmpty(null);
        }
        return null;
    }

    private final void g() {
        if (this.f74594f.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList(this.f74594f);
        this.f74594f.clear();
        if (arrayList.size() <= 0) {
            return;
        }
        throw null;
    }

    private final void h(int i3) {
        synchronized (this.f74589a) {
            try {
                if (b()) {
                    if (this.f74595g) {
                        int i4 = this.f74591c - 1;
                        this.f74591c = i4;
                        if (i4 > 0) {
                            return;
                        }
                    } else {
                        this.f74591c = 0;
                    }
                    g();
                    Iterator it = this.f74603o.values().iterator();
                    while (it.hasNext()) {
                        ((zzc) it.next()).f74607a = 0;
                    }
                    this.f74603o.clear();
                    Future future = this.f74592d;
                    if (future != null) {
                        future.cancel(false);
                        this.f74592d = null;
                        this.f74593e = 0L;
                    }
                    this.f74596h = 0;
                    if (this.f74590b.isHeld()) {
                        try {
                            try {
                                this.f74590b.release();
                                if (this.f74597i != null) {
                                    this.f74597i = null;
                                }
                            } catch (RuntimeException e3) {
                                if (!e3.getClass().equals(RuntimeException.class)) {
                                    throw e3;
                                }
                                Log.e("WakeLock", String.valueOf(this.f74600l).concat(" failed to release!"), e3);
                                if (this.f74597i != null) {
                                    this.f74597i = null;
                                }
                            }
                        } catch (Throwable th) {
                            if (this.f74597i != null) {
                                this.f74597i = null;
                            }
                            throw th;
                        }
                    } else {
                        Log.e("WakeLock", String.valueOf(this.f74600l).concat(" should be held!"));
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private static void i(PowerManager.WakeLock wakeLock, WorkSource workSource) {
        try {
            wakeLock.setWorkSource(workSource);
        } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException e3) {
            Log.wtf("WakeLock", e3.toString());
        }
    }

    public void a(long j3) {
        this.f74604p.incrementAndGet();
        long jMax = Math.max(Math.min(Long.MAX_VALUE, f74585r), 1L);
        if (j3 > 0) {
            jMax = Math.min(j3, jMax);
        }
        synchronized (this.f74589a) {
            try {
                if (!b()) {
                    this.f74597i = com.google.android.gms.internal.stats.zzb.zza(false, null);
                    this.f74590b.acquire();
                    this.f74598j.a();
                }
                this.f74591c++;
                this.f74596h++;
                f(null);
                zzc zzcVar = (zzc) this.f74603o.get(null);
                if (zzcVar == null) {
                    zzcVar = new zzc(null);
                    this.f74603o.put(null, zzcVar);
                }
                zzcVar.f74607a++;
                long jA = this.f74598j.a();
                long j4 = Long.MAX_VALUE - jA > jMax ? jA + jMax : Long.MAX_VALUE;
                if (j4 > this.f74593e) {
                    this.f74593e = j4;
                    Future future = this.f74592d;
                    if (future != null) {
                        future.cancel(false);
                    }
                    this.f74592d = this.f74605q.schedule(new Runnable() { // from class: com.google.android.gms.stats.zza
                        @Override // java.lang.Runnable
                        public final void run() {
                            WakeLock.e(this.f74606a);
                        }
                    }, jMax, TimeUnit.MILLISECONDS);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean b() {
        boolean z2;
        synchronized (this.f74589a) {
            z2 = this.f74591c > 0;
        }
        return z2;
    }

    public void c() {
        if (this.f74604p.decrementAndGet() < 0) {
            Log.e("WakeLock", String.valueOf(this.f74600l).concat(" release without a matched acquire!"));
        }
        synchronized (this.f74589a) {
            try {
                f(null);
                if (this.f74603o.containsKey(null)) {
                    zzc zzcVar = (zzc) this.f74603o.get(null);
                    if (zzcVar != null) {
                        int i3 = zzcVar.f74607a - 1;
                        zzcVar.f74607a = i3;
                        if (i3 == 0) {
                            this.f74603o.remove(null);
                        }
                    }
                } else {
                    Log.w("WakeLock", String.valueOf(this.f74600l).concat(" counter does not exist"));
                }
                h(0);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void d(boolean z2) {
        synchronized (this.f74589a) {
            this.f74595g = z2;
        }
    }
}
