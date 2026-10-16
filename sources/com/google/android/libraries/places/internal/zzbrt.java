package com.google.android.libraries.places.internal;

import com.google.common.base.Preconditions;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class zzbrt implements zzbpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile boolean f76736a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private zzbpn f76737b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private zzbpl f76738c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private zzbnp f76739d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private zzbrs f76741f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f76742g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f76743h;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List f76740e = new ArrayList();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private List f76744i = new ArrayList();

    zzbrt() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0024, code lost:
    
        r0 = r1.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002c, code lost:
    
        if (r0.hasNext() == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002e, code lost:
    
        ((java.lang.Runnable) r0.next()).run();
     */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0019  */
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void n() {
        /*
            r3 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
        L5:
            monitor-enter(r3)
            java.util.List r1 = r3.f76740e     // Catch: java.lang.Throwable -> L1d
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L1d
            if (r1 == 0) goto L1f
            r0 = 0
            r3.f76740e = r0     // Catch: java.lang.Throwable -> L1d
            r0 = 1
            r3.f76736a = r0     // Catch: java.lang.Throwable -> L1d
            com.google.android.libraries.places.internal.zzbrs r0 = r3.f76741f     // Catch: java.lang.Throwable -> L1d
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L1d
            if (r0 == 0) goto L1c
            r0.d()
        L1c:
            return
        L1d:
            r0 = move-exception
            goto L3d
        L1f:
            java.util.List r1 = r3.f76740e     // Catch: java.lang.Throwable -> L1d
            r3.f76740e = r0     // Catch: java.lang.Throwable -> L1d
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L1d
            java.util.Iterator r0 = r1.iterator()
        L28:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L38
            java.lang.Object r2 = r0.next()
            java.lang.Runnable r2 = (java.lang.Runnable) r2
            r2.run()
            goto L28
        L38:
            r1.clear()
            r0 = r1
            goto L5
        L3d:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L1d
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.zzbrt.n():void");
    }

    private final void j(Runnable runnable) {
        Preconditions.A(this.f76737b != null, "May only be called after start");
        synchronized (this) {
            try {
                if (this.f76736a) {
                    runnable.run();
                } else {
                    this.f76740e.add(runnable);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void k(zzbpn zzbpnVar) {
        Iterator it = this.f76744i.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        this.f76744i = null;
        this.f76738c.a(zzbpnVar);
    }

    private final void l(zzbpl zzbplVar) {
        zzbpl zzbplVar2 = this.f76738c;
        Preconditions.D(zzbplVar2 == null, "realStream already set to %s", zzbplVar2);
        this.f76738c = zzbplVar;
        this.f76743h = System.nanoTime();
    }

    @Override // com.google.android.libraries.places.internal.zzbpl
    public final void a(zzbpn zzbpnVar) {
        zzbnp zzbnpVar;
        boolean z2;
        Preconditions.u(zzbpnVar, "listener");
        Preconditions.A(this.f76737b == null, "already started");
        synchronized (this) {
            try {
                zzbnpVar = this.f76739d;
                z2 = this.f76736a;
                if (!z2) {
                    zzbrs zzbrsVar = new zzbrs(zzbpnVar);
                    this.f76741f = zzbrsVar;
                    zzbpnVar = zzbrsVar;
                }
                this.f76737b = zzbpnVar;
                this.f76742g = System.nanoTime();
            } catch (Throwable th) {
                throw th;
            }
        }
        if (zzbnpVar != null) {
            zzbpnVar.b(zzbnpVar, zzbpm.PROCESSED, new zzbmg());
        } else if (z2) {
            k(zzbpnVar);
        }
    }

    @Override // com.google.android.libraries.places.internal.zzcab
    public final void b(zzbjj zzbjjVar) {
        Preconditions.A(this.f76737b == null, "May only be called before start");
        Preconditions.u(zzbjjVar, "compressor");
        this.f76744i.add(new zzbre(this, zzbjjVar));
    }

    @Override // com.google.android.libraries.places.internal.zzbpl
    public void c(zzbnp zzbnpVar) {
        boolean z2 = false;
        Preconditions.A(this.f76737b != null, "May only be called after start");
        Preconditions.u(zzbnpVar, "reason");
        synchronized (this) {
            try {
                if (this.f76738c == null) {
                    l(zzbwn.f77105a);
                    this.f76739d = zzbnpVar;
                } else {
                    z2 = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z2) {
            j(new zzbrm(this, zzbnpVar));
            return;
        }
        n();
        d(zzbnpVar);
        this.f76737b.b(zzbnpVar, zzbpm.PROCESSED, new zzbmg());
    }

    @Override // com.google.android.libraries.places.internal.zzbpl
    public final void e(zzbjy zzbjyVar) {
        Preconditions.A(this.f76737b == null, "May only be called before start");
        Preconditions.u(zzbjyVar, "decompressorRegistry");
        this.f76744i.add(new zzbrf(this, zzbjyVar));
    }

    @Override // com.google.android.libraries.places.internal.zzcab
    public final void f(InputStream inputStream) {
        Preconditions.A(this.f76737b != null, "May only be called after start");
        Preconditions.u(inputStream, "message");
        if (this.f76736a) {
            this.f76738c.f(inputStream);
        } else {
            j(new zzbrk(this, inputStream));
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbpl
    public void g(zzbtf zzbtfVar) {
        synchronized (this) {
            try {
                if (this.f76737b == null) {
                    return;
                }
                if (this.f76738c != null) {
                    zzbtfVar.b("buffered_nanos", Long.valueOf(this.f76743h - this.f76742g));
                    this.f76738c.g(zzbtfVar);
                } else {
                    zzbtfVar.b("buffered_nanos", Long.valueOf(System.nanoTime() - this.f76742g));
                    zzbtfVar.a("waiting_for_connection");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbpl
    public final void h(zzbjv zzbjvVar) {
        Preconditions.A(this.f76737b == null, "May only be called before start");
        this.f76744i.add(new zzbri(this, zzbjvVar));
    }

    final Runnable m(zzbpl zzbplVar) {
        synchronized (this) {
            try {
                if (this.f76738c == null) {
                    l((zzbpl) Preconditions.u(zzbplVar, "stream"));
                    zzbpn zzbpnVar = this.f76737b;
                    if (zzbpnVar == null) {
                        this.f76740e = null;
                        this.f76736a = true;
                    }
                    if (zzbpnVar != null) {
                        k(zzbpnVar);
                        return new zzbrj(this);
                    }
                }
            } finally {
            }
        }
        return null;
    }

    final /* synthetic */ zzbpl o() {
        return this.f76738c;
    }

    @Override // com.google.android.libraries.places.internal.zzbpl
    public final void zzb(int i3) {
        Preconditions.A(this.f76737b == null, "May only be called before start");
        this.f76744i.add(new zzbrh(this, i3));
    }

    @Override // com.google.android.libraries.places.internal.zzbpl
    public final void zzc(int i3) {
        Preconditions.A(this.f76737b == null, "May only be called before start");
        this.f76744i.add(new zzbrg(this, i3));
    }

    @Override // com.google.android.libraries.places.internal.zzbpl
    public final void zzk() {
        Preconditions.A(this.f76737b != null, "May only be called after start");
        j(new zzbrn(this));
    }

    @Override // com.google.android.libraries.places.internal.zzcab
    public final boolean zzm() {
        if (this.f76736a) {
            return this.f76738c.zzm();
        }
        return false;
    }

    @Override // com.google.android.libraries.places.internal.zzcab
    public final void zzr() {
        Preconditions.A(this.f76737b == null, "May only be called before start");
        this.f76744i.add(new zzbrd(this));
    }

    @Override // com.google.android.libraries.places.internal.zzcab
    public final void zzs(int i3) {
        Preconditions.A(this.f76737b != null, "May only be called after start");
        if (this.f76736a) {
            this.f76738c.zzs(i3);
        } else {
            j(new zzbrc(this, i3));
        }
    }

    @Override // com.google.android.libraries.places.internal.zzcab
    public final void zzu() {
        Preconditions.A(this.f76737b != null, "May only be called after start");
        if (this.f76736a) {
            this.f76738c.zzu();
        } else {
            j(new zzbrl(this));
        }
    }

    protected void d(zzbnp zzbnpVar) {
    }
}
