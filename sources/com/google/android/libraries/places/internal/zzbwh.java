package com.google.android.libraries.places.internal;

import com.google.common.base.Preconditions;
import java.io.Closeable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbwh implements Closeable, zzbqe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private zzbwe f77070a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f77071b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzcaa f77072c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzcal f77073d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private zzbjw f77074f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f77076h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private zzbpy f77077i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f77079k;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f77082n;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f77085q = 1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f77075g = 5;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private zzbpy f77078j = new zzbpy();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f77080l = false;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f77081m = -1;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f77083o = false;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private volatile boolean f77084p = false;

    public zzbwh(zzbwe zzbweVar, zzbjw zzbjwVar, int i3, zzcaa zzcaaVar, zzcal zzcalVar) {
        this.f77070a = (zzbwe) Preconditions.u(zzbweVar, "sink");
        this.f77074f = (zzbjw) Preconditions.u(zzbjwVar, "decompressor");
        this.f77071b = i3;
        this.f77072c = (zzcaa) Preconditions.u(zzcaaVar, "statsTraceCtx");
        this.f77073d = (zzcal) Preconditions.u(zzcalVar, "transportTracer");
    }

    private final boolean i() {
        return this.f77078j.zzf() == 0;
    }

    @Override // com.google.android.libraries.places.internal.zzbqe
    public final void a(zzbxo zzbxoVar) throws Throwable {
        Preconditions.u(zzbxoVar, "data");
        boolean z2 = true;
        try {
            if (!f() && !this.f77083o) {
                this.f77078j.b(zzbxoVar);
                try {
                    j();
                    return;
                } catch (Throwable th) {
                    th = th;
                    z2 = false;
                    if (z2) {
                        zzbxoVar.close();
                    }
                    throw th;
                }
            }
            zzbxoVar.close();
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbqe
    public final void b(zzbjw zzbjwVar) {
        Preconditions.A(true, "Already set full stream decompressor");
        this.f77074f = (zzbjw) Preconditions.u(zzbjwVar, "Can't pass an empty decompressor");
    }

    final void c(zzbwe zzbweVar) {
        this.f77070a = zzbweVar;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, com.google.android.libraries.places.internal.zzbqe
    public final void close() {
        if (f()) {
            return;
        }
        zzbpy zzbpyVar = this.f77077i;
        boolean z2 = false;
        if (zzbpyVar != null && zzbpyVar.zzf() > 0) {
            z2 = true;
        }
        try {
            zzbpy zzbpyVar2 = this.f77078j;
            if (zzbpyVar2 != null) {
                zzbpyVar2.close();
            }
            zzbpy zzbpyVar3 = this.f77077i;
            if (zzbpyVar3 != null) {
                zzbpyVar3.close();
            }
            this.f77078j = null;
            this.f77077i = null;
            this.f77070a.zzb(z2);
        } catch (Throwable th) {
            this.f77078j = null;
            this.f77077i = null;
            throw th;
        }
    }

    public final boolean f() {
        return this.f77078j == null;
    }

    @Override // com.google.android.libraries.places.internal.zzbqe
    public final void zza(int i3) {
        this.f77071b = i3;
    }

    @Override // com.google.android.libraries.places.internal.zzbqe
    public final void zzc(int i3) {
        Preconditions.e(true, "numMessages must be > 0");
        if (f()) {
            return;
        }
        this.f77079k += (long) i3;
        j();
    }

    @Override // com.google.android.libraries.places.internal.zzbqe
    public final void zze() {
        if (f()) {
            return;
        }
        if (i()) {
            close();
        } else {
            this.f77083o = true;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x006c, code lost:
    
        if (r4 <= 0) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x006e, code lost:
    
        r13.f77070a.b(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0075, code lost:
    
        if (r13.f77085q != 2) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0077, code lost:
    
        r13.f77072c.m(r4);
        r13.f77082n += r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0082, code lost:
    
        r4 = r13.f77085q;
        r5 = r4 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0087, code lost:
    
        if (r4 == 0) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0089, code lost:
    
        if (r5 == 0) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x008b, code lost:
    
        if (r5 == 1) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x008f, code lost:
    
        if (r4 == 1) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0091, code lost:
    
        r1 = cz.mobilesoft.coreblock.scene.lockscreen.EI.MrGIhy.tyAOicYiLwRXks;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0095, code lost:
    
        r1 = "HEADER";
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0097, code lost:
    
        r5 = new java.lang.StringBuilder(r1.length() + 15);
        r5.append("Invalid state: ");
        r5.append(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00af, code lost:
    
        throw new java.lang.AssertionError(r5.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00b0, code lost:
    
        r7 = r13.f77072c;
        r8 = r13.f77081m;
        r9 = r13.f77082n;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00bb, code lost:
    
        if (true == r13.f77076h) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00bd, code lost:
    
        r11 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00bf, code lost:
    
        r11 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00c0, code lost:
    
        r7.i(r8, r9, r11);
        r13.f77082n = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00c7, code lost:
    
        if (r13.f77076h == false) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00c9, code lost:
    
        r3 = r13.f77074f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00cd, code lost:
    
        if (r3 == com.google.android.libraries.places.internal.zzbjh.f76278a) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00cf, code lost:
    
        r8 = r13.f77077i;
        r9 = com.google.android.libraries.places.internal.zzbxr.f77169b;
        r8 = new com.google.android.libraries.places.internal.zzbwg(r3.b(new com.google.android.libraries.places.internal.zzbxp(r8)), r13.f77071b, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00e4, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00ea, code lost:
    
        throw new java.lang.RuntimeException(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00f8, code lost:
    
        throw new com.google.android.libraries.places.internal.zzbns(com.google.android.libraries.places.internal.zzbnp.f76495l.e("Can't decode compressed gRPC message as compression not configured"), null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00f9, code lost:
    
        r7.l(r13.f77077i.zzf());
        r3 = r13.f77077i;
        r7 = com.google.android.libraries.places.internal.zzbxr.f77169b;
        r8 = new com.google.android.libraries.places.internal.zzbxp(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x010c, code lost:
    
        r13.f77077i = null;
        r13.f77070a.a(new com.google.android.libraries.places.internal.zzbwf(r8, null));
        r13.f77085q = 1;
        r13.f77075g = 5;
        r13.f77079k--;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0124, code lost:
    
        r4 = r13.f77077i.zzg();
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x012c, code lost:
    
        if ((r4 & 254) != 0) goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0130, code lost:
    
        if (1 == (r4 & 1)) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0132, code lost:
    
        r4 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0134, code lost:
    
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0135, code lost:
    
        r13.f77076h = r4;
        r4 = r13.f77077i;
        r4.a(4);
        r4 = r4.zzg() | (((r4.zzg() << 24) | (r4.zzg() << 16)) | (r4.zzg() << 8));
        r13.f77075g = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0158, code lost:
    
        if (r4 < 0) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x015c, code lost:
    
        if (r4 > r13.f77071b) goto L109;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x015e, code lost:
    
        r4 = r13.f77081m + 1;
        r13.f77081m = r4;
        r13.f77072c.g(r4);
        r13.f77073d.d();
        r13.f77085q = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x01a2, code lost:
    
        throw new com.google.android.libraries.places.internal.zzbns(com.google.android.libraries.places.internal.zzbnp.f76495l.e("gRPC frame header malformed: reserved bits not zero"), null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x01a3, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x01be, code lost:
    
        if (r13.f77083o == false) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x01c4, code lost:
    
        if (i() == false) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x01c6, code lost:
    
        close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x01cb, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void j() {
        /*
            Method dump skipped, instruction units count: 463
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.zzbwh.j():void");
    }
}
