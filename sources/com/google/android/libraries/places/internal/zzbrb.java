package com.google.android.libraries.places.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbrb implements zzbwd {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Executor f76696c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzbnx f76697d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Runnable f76698e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Runnable f76699f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Runnable f76700g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private zzbwc f76701h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzbku f76694a = zzbku.a(zzbrb.class, null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f76695b = new Object();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Collection f76702i = new LinkedHashSet();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private volatile zzbra f76703j = new zzbra(null, null, null);

    zzbrb(Executor executor, zzbnx zzbnxVar) {
        this.f76696c = executor;
        this.f76697d = zzbnxVar;
    }

    @Override // com.google.android.libraries.places.internal.zzbwd
    public final void a(zzbnp zzbnpVar) {
        Runnable runnable;
        synchronized (this.f76695b) {
            try {
                if (this.f76703j.f76693b != null) {
                    return;
                }
                this.f76703j = this.f76703j.b(zzbnpVar);
                zzbnx zzbnxVar = this.f76697d;
                zzbnxVar.a(new zzbqy(this, zzbnpVar));
                if (!d() && (runnable = this.f76700g) != null) {
                    zzbnxVar.a(runnable);
                    this.f76700g = null;
                }
                this.f76697d.zza();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbwd
    public final Runnable b(zzbwc zzbwcVar) {
        this.f76701h = zzbwcVar;
        this.f76698e = new zzbqv(this, zzbwcVar);
        this.f76699f = new zzbqw(this, zzbwcVar);
        this.f76700g = new zzbqx(this, zzbwcVar);
        return null;
    }

    @Override // com.google.android.libraries.places.internal.zzbwd
    public final void c(zzbnp zzbnpVar) {
        Collection<zzbqz> collection;
        Runnable runnable;
        a(zzbnpVar);
        synchronized (this.f76695b) {
            try {
                collection = this.f76702i;
                runnable = this.f76700g;
                this.f76700g = null;
                if (!collection.isEmpty()) {
                    this.f76702i = Collections.EMPTY_LIST;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (runnable != null) {
            for (zzbqz zzbqzVar : collection) {
                Runnable runnableM = zzbqzVar.m(new zzbsi(zzbnpVar, zzbpm.REFUSED, zzbqzVar.r()));
                if (runnableM != null) {
                    ((zzbrj) runnableM).f76717a.n();
                }
            }
            zzbnx zzbnxVar = this.f76697d;
            zzbnxVar.a(runnable);
            zzbnxVar.zza();
        }
    }

    public final boolean d() {
        boolean z2;
        synchronized (this.f76695b) {
            z2 = !this.f76702i.isEmpty();
        }
        return z2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0048, code lost:
    
        r4 = new com.google.android.libraries.places.internal.zzbqz(r3, r0, r7, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0055, code lost:
    
        if (r0.a().k() == false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0057, code lost:
    
        if (r5 == null) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x005d, code lost:
    
        if (r5.h() == false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x005f, code lost:
    
        r4.s(r5.f());
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0069, code lost:
    
        r3.f76702i.add(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x006e, code lost:
    
        monitor-enter(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x006f, code lost:
    
        r5 = r3.f76702i.size();
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x008a, code lost:
    
        r3.f76697d.zza();
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x008f, code lost:
    
        return r4;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v11, types: [com.google.android.libraries.places.internal.zzbpl] */
    /* JADX WARN: Type inference failed for: r4v4, types: [com.google.android.libraries.places.internal.zzbsi] */
    /* JADX WARN: Type inference failed for: r4v5, types: [com.google.android.libraries.places.internal.zzbpl] */
    /* JADX WARN: Type inference failed for: r4v7, types: [com.google.android.libraries.places.internal.zzbqz, java.lang.Object] */
    @Override // com.google.android.libraries.places.internal.zzbpo
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.libraries.places.internal.zzbpl e(com.google.android.libraries.places.internal.zzbml r4, com.google.android.libraries.places.internal.zzbmg r5, com.google.android.libraries.places.internal.zzbis r6, com.google.android.libraries.places.internal.zzbje[] r7) {
        /*
            r3 = this;
            com.google.android.libraries.places.internal.zzbxk r0 = new com.google.android.libraries.places.internal.zzbxk     // Catch: java.lang.Throwable -> L19
            com.google.android.libraries.places.internal.zzbwq r1 = new com.google.android.libraries.places.internal.zzbwq     // Catch: java.lang.Throwable -> L19
            r1.<init>(r7)     // Catch: java.lang.Throwable -> L19
            r0.<init>(r4, r5, r6, r1)     // Catch: java.lang.Throwable -> L19
            com.google.android.libraries.places.internal.zzbra r4 = r3.f76703j     // Catch: java.lang.Throwable -> L19
        Lc:
            com.google.android.libraries.places.internal.zzbnp r5 = r4.f76693b     // Catch: java.lang.Throwable -> L19
            if (r5 == 0) goto L1c
            com.google.android.libraries.places.internal.zzbsi r4 = new com.google.android.libraries.places.internal.zzbsi     // Catch: java.lang.Throwable -> L19
            com.google.android.libraries.places.internal.zzbpm r6 = com.google.android.libraries.places.internal.zzbpm.PROCESSED     // Catch: java.lang.Throwable -> L19
            r4.<init>(r5, r6, r7)     // Catch: java.lang.Throwable -> L19
            goto L8a
        L19:
            r4 = move-exception
            goto L99
        L1c:
            com.google.android.libraries.places.internal.zzbln r5 = r4.f76692a     // Catch: java.lang.Throwable -> L19
            r6 = 0
            if (r5 == 0) goto L40
            com.google.android.libraries.places.internal.zzbli r5 = r5.a(r0)     // Catch: java.lang.Throwable -> L19
            com.google.android.libraries.places.internal.zzbis r1 = r0.a()     // Catch: java.lang.Throwable -> L19
            boolean r2 = r1.k()     // Catch: java.lang.Throwable -> L19
            com.google.android.libraries.places.internal.zzbpo r2 = com.google.android.libraries.places.internal.zzbsz.e(r5, r2)     // Catch: java.lang.Throwable -> L19
            if (r2 == 0) goto L41
            com.google.android.libraries.places.internal.zzbml r4 = r0.c()     // Catch: java.lang.Throwable -> L19
            com.google.android.libraries.places.internal.zzbmg r5 = r0.b()     // Catch: java.lang.Throwable -> L19
            com.google.android.libraries.places.internal.zzbpl r4 = r2.e(r4, r5, r1, r7)     // Catch: java.lang.Throwable -> L19
            goto L8a
        L40:
            r5 = r6
        L41:
            java.lang.Object r1 = r3.f76695b     // Catch: java.lang.Throwable -> L19
            monitor-enter(r1)     // Catch: java.lang.Throwable -> L19
            com.google.android.libraries.places.internal.zzbra r2 = r3.f76703j     // Catch: java.lang.Throwable -> L67
            if (r4 != r2) goto L93
            com.google.android.libraries.places.internal.zzbqz r4 = new com.google.android.libraries.places.internal.zzbqz     // Catch: java.lang.Throwable -> L67
            r4.<init>(r3, r0, r7, r6)     // Catch: java.lang.Throwable -> L67
            com.google.android.libraries.places.internal.zzbis r6 = r0.a()     // Catch: java.lang.Throwable -> L67
            boolean r6 = r6.k()     // Catch: java.lang.Throwable -> L67
            if (r6 == 0) goto L69
            if (r5 == 0) goto L69
            boolean r6 = r5.h()     // Catch: java.lang.Throwable -> L67
            if (r6 == 0) goto L69
            com.google.android.libraries.places.internal.zzbnp r5 = r5.f()     // Catch: java.lang.Throwable -> L67
            r4.s(r5)     // Catch: java.lang.Throwable -> L67
            goto L69
        L67:
            r4 = move-exception
            goto L97
        L69:
            java.util.Collection r5 = r3.f76702i     // Catch: java.lang.Throwable -> L67
            r5.add(r4)     // Catch: java.lang.Throwable -> L67
            monitor-enter(r1)     // Catch: java.lang.Throwable -> L67
            java.util.Collection r5 = r3.f76702i     // Catch: java.lang.Throwable -> L90
            int r5 = r5.size()     // Catch: java.lang.Throwable -> L90
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L90
            r6 = 1
            if (r5 != r6) goto L80
            com.google.android.libraries.places.internal.zzbnx r5 = r3.f76697d     // Catch: java.lang.Throwable -> L67
            java.lang.Runnable r6 = r3.f76698e     // Catch: java.lang.Throwable -> L67
            r5.a(r6)     // Catch: java.lang.Throwable -> L67
        L80:
            int r5 = r7.length     // Catch: java.lang.Throwable -> L67
            r6 = 0
        L82:
            if (r6 >= r5) goto L89
            r0 = r7[r6]     // Catch: java.lang.Throwable -> L67
            int r6 = r6 + 1
            goto L82
        L89:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L67
        L8a:
            com.google.android.libraries.places.internal.zzbnx r5 = r3.f76697d
            r5.zza()
            return r4
        L90:
            r4 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L90
            throw r4     // Catch: java.lang.Throwable -> L67
        L93:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L67
            r4 = r2
            goto Lc
        L97:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L67
            throw r4     // Catch: java.lang.Throwable -> L19
        L99:
            com.google.android.libraries.places.internal.zzbnx r5 = r3.f76697d
            r5.zza()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.zzbrb.e(com.google.android.libraries.places.internal.zzbml, com.google.android.libraries.places.internal.zzbmg, com.google.android.libraries.places.internal.zzbis, com.google.android.libraries.places.internal.zzbje[]):com.google.android.libraries.places.internal.zzbpl");
    }

    final void f(zzbln zzblnVar) {
        Runnable runnable;
        synchronized (this.f76695b) {
            this.f76703j = this.f76703j.a(zzblnVar);
            if (zzblnVar != null && d()) {
                ArrayList arrayList = new ArrayList(this.f76702i);
                ArrayList arrayList2 = new ArrayList();
                int size = arrayList.size();
                int i3 = 0;
                for (int i4 = 0; i4 < size; i4++) {
                    zzbqz zzbqzVar = (zzbqz) arrayList.get(i4);
                    zzbli zzbliVarA = zzblnVar.a(zzbqzVar.q());
                    zzbis zzbisVarA = zzbqzVar.q().a();
                    if (zzbisVarA.k() && zzbliVarA.h()) {
                        zzbqzVar.s(zzbliVarA.f());
                    }
                    zzbpo zzbpoVarE = zzbsz.e(zzbliVarA, zzbisVarA.k());
                    if (zzbpoVarE != null) {
                        Executor executorJ = this.f76696c;
                        if (zzbisVarA.j() != null) {
                            executorJ = zzbisVarA.j();
                        }
                        Runnable runnableP = zzbqzVar.p(zzbpoVarE, null);
                        if (runnableP != null) {
                            executorJ.execute(runnableP);
                        }
                        arrayList2.add(zzbqzVar);
                    }
                }
                synchronized (this.f76695b) {
                    try {
                        if (d()) {
                            int size2 = arrayList2.size();
                            while (i3 < size2) {
                                Object obj = arrayList2.get(i3);
                                i3++;
                                this.f76702i.remove((zzbqz) obj);
                            }
                            if (this.f76702i.isEmpty()) {
                                this.f76702i = new LinkedHashSet();
                            }
                            if (!d()) {
                                zzbnx zzbnxVar = this.f76697d;
                                zzbnxVar.a(this.f76699f);
                                if (this.f76703j.f76693b != null && (runnable = this.f76700g) != null) {
                                    zzbnxVar.a(runnable);
                                    this.f76700g = null;
                                }
                            }
                            this.f76697d.zza();
                        }
                    } finally {
                    }
                }
            }
        }
    }

    final /* synthetic */ Object g() {
        return this.f76695b;
    }

    final /* synthetic */ zzbnx h() {
        return this.f76697d;
    }

    final /* synthetic */ Runnable i() {
        return this.f76699f;
    }

    final /* synthetic */ Runnable j() {
        return this.f76700g;
    }

    final /* synthetic */ void k(Runnable runnable) {
        this.f76700g = null;
    }

    final /* synthetic */ zzbwc l() {
        return this.f76701h;
    }

    final /* synthetic */ Collection m() {
        return this.f76702i;
    }

    final /* synthetic */ zzbra n() {
        return this.f76703j;
    }

    @Override // com.google.android.libraries.places.internal.zzbkz
    public final zzbku zzc() {
        return this.f76694a;
    }
}
