package com.google.android.libraries.places.internal;

import com.google.common.base.Preconditions;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
abstract class zzbzf implements zzbpl {
    static final zzbmc A;
    static final zzbmc B;
    private static final zzbnp C;
    private static final Random D;
    private static final boolean E;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzbml f77252a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Executor f77253b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ScheduledExecutorService f77255d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final zzbmg f77256e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zzbzg f77257f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzbta f77258g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f77259h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final zzbyo f77261j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final long f77262k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final long f77263l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final zzbze f77264m;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private zzbys f77270s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private long f77271t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private zzbpn f77272u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private zzbyp f77273v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private zzbyp f77274w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private long f77275x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private zzbnp f77276y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f77277z;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Executor f77254c = new zzbnx(new zzbxw(this));

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Object f77260i = new Object();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final zzbtf f77265n = new zzbtf();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private volatile zzbyu f77266o = new zzbyu(new ArrayList(8), Collections.EMPTY_LIST, null, null, false, false, false, 0);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final AtomicBoolean f77267p = new AtomicBoolean();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final AtomicInteger f77268q = new AtomicInteger();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final AtomicInteger f77269r = new AtomicInteger();

    static {
        zzbmb zzbmbVar = zzbmg.f76399d;
        A = zzbmc.c("grpc-previous-rpc-attempts", zzbmbVar);
        B = zzbmc.c("grpc-retry-pushback-ms", zzbmbVar);
        C = zzbnp.f76489f.e("Stream thrown away because RetriableStream committed");
        D = new Random();
        E = zzbsz.j("GRPC_EXPERIMENTAL_XDS_RLS_LB", true);
    }

    zzbzf(zzbml zzbmlVar, zzbmg zzbmgVar, zzbyo zzbyoVar, long j3, long j4, Executor executor, ScheduledExecutorService scheduledExecutorService, zzbzg zzbzgVar, zzbta zzbtaVar, zzbze zzbzeVar) {
        this.f77252a = zzbmlVar;
        this.f77261j = zzbyoVar;
        this.f77262k = j3;
        this.f77263l = j4;
        this.f77253b = executor;
        this.f77255d = scheduledExecutorService;
        this.f77256e = zzbmgVar;
        this.f77257f = zzbzgVar;
        if (zzbzgVar != null) {
            this.f77275x = zzbzgVar.f77279b;
        }
        this.f77258g = zzbtaVar;
        Preconditions.e(zzbzgVar == null || zzbtaVar == null, "Should not provide both retryPolicy and hedgingPolicy");
        this.f77259h = zzbtaVar != null;
        this.f77264m = zzbzeVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: M, reason: merged with bridge method [inline-methods] */
    public final Runnable Y(zzbzd zzbzdVar) {
        List list;
        Collection collectionSingleton;
        boolean z2;
        Future future;
        Future future2;
        synchronized (this.f77260i) {
            try {
                if (this.f77266o.f77226f != null) {
                    return null;
                }
                Collection collection = this.f77266o.f77223c;
                zzbyu zzbyuVar = this.f77266o;
                Preconditions.A(zzbyuVar.f77226f == null, "Already committed");
                List list2 = zzbyuVar.f77222b;
                if (zzbyuVar.f77223c.contains(zzbzdVar)) {
                    list = null;
                    collectionSingleton = Collections.singleton(zzbzdVar);
                    z2 = true;
                } else {
                    list = list2;
                    collectionSingleton = Collections.EMPTY_LIST;
                    z2 = false;
                }
                this.f77266o = new zzbyu(list, collectionSingleton, zzbyuVar.f77224d, zzbzdVar, zzbyuVar.f77227g, z2, zzbyuVar.f77228h, zzbyuVar.f77225e);
                this.f77261j.a(-this.f77271t);
                zzbyp zzbypVar = this.f77273v;
                boolean z3 = zzbypVar != null ? zzbypVar.f77212c : false;
                if (zzbypVar != null) {
                    Future futureB = zzbypVar.b();
                    this.f77273v = null;
                    future = futureB;
                } else {
                    future = null;
                }
                zzbyp zzbypVar2 = this.f77274w;
                if (zzbypVar2 != null) {
                    Future futureB2 = zzbypVar2.b();
                    this.f77274w = null;
                    future2 = futureB2;
                } else {
                    future2 = null;
                }
                return new zzbxy(this, collection, zzbzdVar, future, z3, future2);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: N, reason: merged with bridge method [inline-methods] */
    public final zzbzd a0(int i3, boolean z2, boolean z3) {
        AtomicInteger atomicInteger;
        int i4;
        do {
            atomicInteger = this.f77269r;
            i4 = atomicInteger.get();
            if (i4 < 0) {
                return null;
            }
        } while (!atomicInteger.compareAndSet(i4, i4 + 1));
        zzbzd zzbzdVar = new zzbzd(i3);
        zzbyj zzbyjVar = new zzbyj(this, new zzbyn(this, zzbzdVar));
        zzbmg zzbmgVar = this.f77256e;
        zzbmg zzbmgVar2 = new zzbmg();
        zzbmgVar2.f(zzbmgVar);
        if (i3 > 0) {
            zzbmgVar2.c(A, String.valueOf(i3));
        }
        zzbzdVar.f77244a = V(zzbmgVar2, zzbyjVar, i3, z2, z3);
        return zzbzdVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0037, code lost:
    
        if (r1 == null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0039, code lost:
    
        r10 = (com.google.android.libraries.places.internal.zzbnx) r9.f77254c;
        r10.a(r1);
        r10.zza();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0043, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0044, code lost:
    
        if (r4 != false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0046, code lost:
    
        r10.f77244a.a(new com.google.android.libraries.places.internal.zzbzc(r9, r10));
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0050, code lost:
    
        r0 = r10.f77244a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0056, code lost:
    
        if (r9.f77266o.f77226f != r10) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0058, code lost:
    
        r10 = r9.f77276y;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x005b, code lost:
    
        r10 = com.google.android.libraries.places.internal.zzbzf.C;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x005d, code lost:
    
        r0.c(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0060, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0088, code lost:
    
        r2 = r3.size();
        r5 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x008d, code lost:
    
        if (r5 >= r2) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x008f, code lost:
    
        r7 = (com.google.android.libraries.places.internal.zzbym) r3.get(r5);
        r7.a(r10);
        r4 = r4 | (r7 instanceof com.google.android.libraries.places.internal.zzbyt);
        r7 = r9.f77266o;
        r8 = r7.f77226f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x009f, code lost:
    
        if (r8 == null) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00a1, code lost:
    
        if (r8 != r10) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00a3, code lost:
    
        r5 = r5 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00a7, code lost:
    
        if (r7.f77227g == false) goto L62;
     */
    /* JADX INFO: renamed from: O, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b0(com.google.android.libraries.places.internal.zzbzd r10) {
        /*
            r9 = this;
            r0 = 0
            r1 = 0
            r2 = r0
            r4 = r2
            r3 = r1
        L5:
            java.lang.Object r5 = r9.f77260i
            monitor-enter(r5)
            com.google.android.libraries.places.internal.zzbyu r6 = r9.f77266o     // Catch: java.lang.Throwable -> L12
            com.google.android.libraries.places.internal.zzbzd r7 = r6.f77226f     // Catch: java.lang.Throwable -> L12
            if (r7 == 0) goto L15
            if (r7 == r10) goto L15
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L12
            goto L37
        L12:
            r10 = move-exception
            goto Lac
        L15:
            boolean r7 = r6.f77227g     // Catch: java.lang.Throwable -> L12
            if (r7 == 0) goto L1b
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L12
            goto L37
        L1b:
            java.util.List r7 = r6.f77222b     // Catch: java.lang.Throwable -> L12
            int r8 = r7.size()     // Catch: java.lang.Throwable -> L12
            if (r2 != r8) goto L61
            com.google.android.libraries.places.internal.zzbyu r0 = r6.a(r10)     // Catch: java.lang.Throwable -> L12
            r9.f77266o = r0     // Catch: java.lang.Throwable -> L12
            boolean r0 = r9.zzm()     // Catch: java.lang.Throwable -> L12
            if (r0 != 0) goto L31
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L12
            return
        L31:
            com.google.android.libraries.places.internal.zzbyk r1 = new com.google.android.libraries.places.internal.zzbyk     // Catch: java.lang.Throwable -> L12
            r1.<init>(r9)     // Catch: java.lang.Throwable -> L12
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L12
        L37:
            if (r1 == 0) goto L44
            java.util.concurrent.Executor r10 = r9.f77254c
            com.google.android.libraries.places.internal.zzbnx r10 = (com.google.android.libraries.places.internal.zzbnx) r10
            r10.a(r1)
            r10.zza()
            return
        L44:
            if (r4 != 0) goto L50
            com.google.android.libraries.places.internal.zzbpl r0 = r10.f77244a
            com.google.android.libraries.places.internal.zzbzc r1 = new com.google.android.libraries.places.internal.zzbzc
            r1.<init>(r9, r10)
            r0.a(r1)
        L50:
            com.google.android.libraries.places.internal.zzbpl r0 = r10.f77244a
            com.google.android.libraries.places.internal.zzbyu r1 = r9.f77266o
            com.google.android.libraries.places.internal.zzbzd r1 = r1.f77226f
            if (r1 != r10) goto L5b
            com.google.android.libraries.places.internal.zzbnp r10 = r9.f77276y
            goto L5d
        L5b:
            com.google.android.libraries.places.internal.zzbnp r10 = com.google.android.libraries.places.internal.zzbzf.C
        L5d:
            r0.c(r10)
            return
        L61:
            boolean r6 = r10.f77245b     // Catch: java.lang.Throwable -> L12
            if (r6 == 0) goto L67
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L12
            return
        L67:
            int r6 = r2 + 128
            int r8 = r7.size()     // Catch: java.lang.Throwable -> L12
            int r6 = java.lang.Math.min(r6, r8)     // Catch: java.lang.Throwable -> L12
            if (r3 != 0) goto L7d
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L12
            java.util.List r2 = r7.subList(r2, r6)     // Catch: java.lang.Throwable -> L12
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L12
            goto L87
        L7d:
            r3.clear()     // Catch: java.lang.Throwable -> L12
            java.util.List r2 = r7.subList(r2, r6)     // Catch: java.lang.Throwable -> L12
            r3.addAll(r2)     // Catch: java.lang.Throwable -> L12
        L87:
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L12
            int r2 = r3.size()
            r5 = r0
        L8d:
            if (r5 >= r2) goto La9
            java.lang.Object r7 = r3.get(r5)
            com.google.android.libraries.places.internal.zzbym r7 = (com.google.android.libraries.places.internal.zzbym) r7
            r7.a(r10)
            boolean r7 = r7 instanceof com.google.android.libraries.places.internal.zzbyt
            r4 = r4 | r7
            com.google.android.libraries.places.internal.zzbyu r7 = r9.f77266o
            com.google.android.libraries.places.internal.zzbzd r8 = r7.f77226f
            if (r8 == 0) goto La3
            if (r8 != r10) goto La9
        La3:
            boolean r7 = r7.f77227g
            int r5 = r5 + 1
            if (r7 == 0) goto L8d
        La9:
            r2 = r6
            goto L5
        Lac:
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L12
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.zzbzf.b0(com.google.android.libraries.places.internal.zzbzd):void");
    }

    private final void P(zzbym zzbymVar) {
        Collection collection;
        synchronized (this.f77260i) {
            try {
                if (!this.f77266o.f77221a) {
                    this.f77266o.f77222b.add(zzbymVar);
                }
                collection = this.f77266o.f77223c;
            } catch (Throwable th) {
                throw th;
            }
        }
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            zzbymVar.a((zzbzd) it.next());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: Q, reason: merged with bridge method [inline-methods] */
    public final boolean d0(zzbyu zzbyuVar) {
        return zzbyuVar.f77226f == null && zzbyuVar.f77225e < this.f77258g.f76838a && !zzbyuVar.f77228h;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: R, reason: merged with bridge method [inline-methods] */
    public final void d() {
        Future future;
        synchronized (this.f77260i) {
            try {
                zzbyp zzbypVar = this.f77274w;
                future = null;
                if (zzbypVar != null) {
                    Future futureB = zzbypVar.b();
                    this.f77274w = null;
                    future = futureB;
                }
                this.f77266o = this.f77266o.b();
            } catch (Throwable th) {
                throw th;
            }
        }
        if (future != null) {
            future.cancel(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: S, reason: merged with bridge method [inline-methods] */
    public final void i(zzbnp zzbnpVar, zzbpm zzbpmVar, zzbmg zzbmgVar) {
        this.f77270s = new zzbys(zzbnpVar, zzbpmVar, zzbmgVar);
        if (this.f77269r.addAndGet(Integer.MIN_VALUE) == Integer.MIN_VALUE) {
            zzbnx zzbnxVar = (zzbnx) this.f77254c;
            zzbnxVar.a(new zzbyl(this, zzbnpVar, zzbpmVar, zzbmgVar));
            zzbnxVar.zza();
        }
    }

    public static long X(long j3) {
        return (long) (j3 * (E ? (D.nextDouble() * 0.8d) + 0.4d : D.nextDouble()));
    }

    final /* synthetic */ AtomicInteger A() {
        return this.f77268q;
    }

    final /* synthetic */ AtomicInteger B() {
        return this.f77269r;
    }

    final /* synthetic */ zzbys C() {
        return this.f77270s;
    }

    final /* synthetic */ long D() {
        return this.f77271t;
    }

    final /* synthetic */ void E(long j3) {
        this.f77271t = j3;
    }

    final /* synthetic */ zzbpn F() {
        return this.f77272u;
    }

    final /* synthetic */ void G(zzbyp zzbypVar) {
        this.f77273v = zzbypVar;
    }

    final /* synthetic */ void H(zzbyp zzbypVar) {
        this.f77274w = zzbypVar;
    }

    final /* synthetic */ long I() {
        return this.f77275x;
    }

    final /* synthetic */ void J(long j3) {
        this.f77275x = j3;
    }

    final /* synthetic */ boolean K() {
        return this.f77277z;
    }

    final /* synthetic */ void L(boolean z2) {
        this.f77277z = true;
    }

    abstract zzbnp T();

    abstract void U();

    abstract zzbpl V(zzbmg zzbmgVar, zzbjb zzbjbVar, int i3, boolean z2, boolean z3);

    final void W(Object obj) {
        zzbyu zzbyuVar = this.f77266o;
        if (zzbyuVar.f77221a) {
            zzbyuVar.f77226f.f77244a.f(this.f77252a.e(obj));
        } else {
            P(new zzbyi(this, obj));
        }
    }

    final /* synthetic */ void Z(zzbzd zzbzdVar) {
        Runnable runnableY = Y(zzbzdVar);
        if (runnableY != null) {
            this.f77253b.execute(runnableY);
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbpl
    public final void a(zzbpn zzbpnVar) {
        zzbyp zzbypVar;
        zzbze zzbzeVar;
        this.f77272u = zzbpnVar;
        zzbnp zzbnpVarT = T();
        if (zzbnpVarT != null) {
            c(zzbnpVarT);
            return;
        }
        synchronized (this.f77260i) {
            this.f77266o.f77222b.add(new zzbyt(this));
        }
        zzbzd zzbzdVarA0 = a0(0, false, false);
        if (zzbzdVarA0 == null) {
            return;
        }
        if (this.f77259h) {
            Object obj = this.f77260i;
            synchronized (obj) {
                try {
                    this.f77266o = this.f77266o.c(zzbzdVarA0);
                    zzbypVar = null;
                    if (d0(this.f77266o) && ((zzbzeVar = this.f77264m) == null || zzbzeVar.a())) {
                        zzbypVar = new zzbyp(obj);
                        this.f77274w = zzbypVar;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (zzbypVar != null) {
                zzbypVar.a(this.f77255d.schedule(new zzbyr(this, zzbypVar), this.f77258g.f76839b, TimeUnit.NANOSECONDS));
            }
        }
        b0(zzbzdVarA0);
    }

    @Override // com.google.android.libraries.places.internal.zzcab
    public final void b(zzbjj zzbjjVar) {
        P(new zzbxz(this, zzbjjVar));
    }

    @Override // com.google.android.libraries.places.internal.zzbpl
    public final void c(zzbnp zzbnpVar) {
        zzbzd zzbzdVar;
        zzbzd zzbzdVar2 = new zzbzd(0);
        zzbzdVar2.f77244a = new zzbwn();
        Runnable runnableY = Y(zzbzdVar2);
        if (runnableY != null) {
            synchronized (this.f77260i) {
                this.f77266o = this.f77266o.a(zzbzdVar2);
            }
            runnableY.run();
            i(zzbnpVar, zzbpm.PROCESSED, new zzbmg());
            return;
        }
        synchronized (this.f77260i) {
            try {
                if (this.f77266o.f77223c.contains(this.f77266o.f77226f)) {
                    zzbzdVar = this.f77266o.f77226f;
                } else {
                    this.f77276y = zzbnpVar;
                    zzbzdVar = null;
                }
                zzbyu zzbyuVar = this.f77266o;
                this.f77266o = new zzbyu(zzbyuVar.f77222b, zzbyuVar.f77223c, zzbyuVar.f77224d, zzbyuVar.f77226f, true, zzbyuVar.f77221a, zzbyuVar.f77228h, zzbyuVar.f77225e);
            } catch (Throwable th) {
                throw th;
            }
        }
        if (zzbzdVar != null) {
            zzbzdVar.f77244a.c(zzbnpVar);
        }
    }

    final /* synthetic */ void c0(Integer num) {
        if (num == null) {
            return;
        }
        if (num.intValue() < 0) {
            d();
            return;
        }
        Object obj = this.f77260i;
        synchronized (obj) {
            try {
                zzbyp zzbypVar = this.f77274w;
                if (zzbypVar == null) {
                    return;
                }
                Future futureB = zzbypVar.b();
                zzbyp zzbypVar2 = new zzbyp(obj);
                this.f77274w = zzbypVar2;
                if (futureB != null) {
                    futureB.cancel(false);
                }
                zzbypVar2.a(this.f77255d.schedule(new zzbyr(this, zzbypVar2), num.intValue(), TimeUnit.MILLISECONDS));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbpl
    public final void e(zzbjy zzbjyVar) {
        P(new zzbyb(this, zzbjyVar));
    }

    @Override // com.google.android.libraries.places.internal.zzcab
    public final void f(InputStream inputStream) {
        throw new IllegalStateException("RetriableStream.writeMessage() should not be called directly");
    }

    @Override // com.google.android.libraries.places.internal.zzbpl
    public final void g(zzbtf zzbtfVar) {
        zzbyu zzbyuVar;
        synchronized (this.f77260i) {
            zzbtfVar.b("closed", this.f77265n);
            zzbyuVar = this.f77266o;
        }
        zzbzd zzbzdVar = zzbyuVar.f77226f;
        if (zzbzdVar != null) {
            zzbtf zzbtfVar2 = new zzbtf();
            zzbzdVar.f77244a.g(zzbtfVar2);
            zzbtfVar.b("committed", zzbtfVar2);
            return;
        }
        zzbtf zzbtfVar3 = new zzbtf();
        for (zzbzd zzbzdVar2 : zzbyuVar.f77223c) {
            zzbtf zzbtfVar4 = new zzbtf();
            zzbzdVar2.f77244a.g(zzbtfVar4);
            zzbtfVar3.a(zzbtfVar4);
        }
        zzbtfVar.b("open", zzbtfVar3);
    }

    @Override // com.google.android.libraries.places.internal.zzbpl
    public final void h(zzbjv zzbjvVar) {
        P(new zzbya(this, zzbjvVar));
    }

    final /* synthetic */ zzbml k() {
        return this.f77252a;
    }

    final /* synthetic */ Executor l() {
        return this.f77253b;
    }

    final /* synthetic */ Executor m() {
        return this.f77254c;
    }

    final /* synthetic */ ScheduledExecutorService n() {
        return this.f77255d;
    }

    final /* synthetic */ zzbzg o() {
        return this.f77257f;
    }

    final /* synthetic */ zzbta p() {
        return this.f77258g;
    }

    final /* synthetic */ boolean q() {
        return this.f77259h;
    }

    final /* synthetic */ Object r() {
        return this.f77260i;
    }

    final /* synthetic */ zzbyo s() {
        return this.f77261j;
    }

    final /* synthetic */ long t() {
        return this.f77262k;
    }

    final /* synthetic */ long u() {
        return this.f77263l;
    }

    final /* synthetic */ zzbze v() {
        return this.f77264m;
    }

    final /* synthetic */ zzbtf w() {
        return this.f77265n;
    }

    final /* synthetic */ zzbyu x() {
        return this.f77266o;
    }

    final /* synthetic */ void y(zzbyu zzbyuVar) {
        this.f77266o = zzbyuVar;
    }

    final /* synthetic */ AtomicBoolean z() {
        return this.f77267p;
    }

    @Override // com.google.android.libraries.places.internal.zzbpl
    public final void zzb(int i3) {
        P(new zzbyf(this, i3));
    }

    @Override // com.google.android.libraries.places.internal.zzbpl
    public final void zzc(int i3) {
        P(new zzbye(this, i3));
    }

    @Override // com.google.android.libraries.places.internal.zzbpl
    public final void zzk() {
        P(new zzbyd(this));
    }

    @Override // com.google.android.libraries.places.internal.zzcab
    public final boolean zzm() {
        Iterator it = this.f77266o.f77223c.iterator();
        while (it.hasNext()) {
            if (((zzbzd) it.next()).f77244a.zzm()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.places.internal.zzcab
    public final void zzr() {
        P(new zzbyg(this));
    }

    @Override // com.google.android.libraries.places.internal.zzcab
    public final void zzs(int i3) {
        zzbyu zzbyuVar = this.f77266o;
        if (zzbyuVar.f77221a) {
            zzbyuVar.f77226f.f77244a.zzs(i3);
        } else {
            P(new zzbyh(this, i3));
        }
    }

    @Override // com.google.android.libraries.places.internal.zzcab
    public final void zzu() {
        zzbyu zzbyuVar = this.f77266o;
        if (zzbyuVar.f77221a) {
            zzbyuVar.f77226f.f77244a.zzu();
        } else {
            P(new zzbyc(this));
        }
    }
}
