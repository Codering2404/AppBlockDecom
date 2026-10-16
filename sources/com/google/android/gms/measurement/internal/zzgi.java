package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.math.BigInteger;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgi extends zzg {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f73684c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f73685d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f73686e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f73687f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f73688g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f73689h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final long f73690i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final long f73691j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private List f73692k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f73693l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f73694m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private String f73695n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private String f73696o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private long f73697p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private String f73698q;

    zzgi(zzic zzicVar, long j3, long j4) {
        super(zzicVar);
        this.f73697p = 0L;
        this.f73698q = null;
        this.f73690i = j3;
        this.f73691j = j4;
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    protected final boolean m() {
        return true;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(15:0|2|(1:4)(17:79|6|(1:10)(2:11|(1:13))|83|14|(4:16|(1:18)(1:20)|77|21)|26|(2:28|(2:30|(2:32|(2:34|(2:36|(2:38|(1:40)(1:41))(1:42))(1:43))(1:44))(1:45))(1:46))(1:47)|48|81|49|(1:51)(1:52)|53|(1:55)|59|(2:62|(1:64)(4:65|(3:68|(1:86)(1:87)|66)|85|71))(1:71)|(2:73|74)(2:75|76))|5|26|(0)(0)|48|81|49|(0)(0)|53|(0)|59|(0)(0)|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0199, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x019a, code lost:
    
        r11.f73997a.a().o().c("Fetching Google App Id failed with exception. appId", com.google.android.gms.measurement.internal.zzgu.x(r1), r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0187 A[Catch: IllegalStateException -> 0x0199, TRY_LEAVE, TryCatch #2 {IllegalStateException -> 0x0199, blocks: (B:49:0x016d, B:53:0x0183, B:55:0x0187), top: B:81:0x016d }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0202  */
    @Override // com.google.android.gms.measurement.internal.zzg
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected final void n() {
        /*
            Method dump skipped, instruction units count: 517
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzgi.n():void");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r2v0 com.google.android.gms.measurement.internal.zzr, still in use, count: 2, list:
          (r2v0 com.google.android.gms.measurement.internal.zzr) from 0x018d: MOVE (r21v1 com.google.android.gms.measurement.internal.zzr) = (r2v0 com.google.android.gms.measurement.internal.zzr) (LINE:398)
          (r2v0 com.google.android.gms.measurement.internal.zzr) from 0x0188: MOVE (r21v4 com.google.android.gms.measurement.internal.zzr) = (r2v0 com.google.android.gms.measurement.internal.zzr) (LINE:393)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
        	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:91)
        	at jadx.core.utils.InsnRemover.addAndUnbind(InsnRemover.java:57)
        	at jadx.core.dex.visitors.ModVisitor.removeStep(ModVisitor.java:463)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:97)
        */
    final com.google.android.gms.measurement.internal.zzr o(java.lang.String r45) {
        /*
            Method dump skipped, instruction units count: 847
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzgi.o(java.lang.String):com.google.android.gms.measurement.internal.zzr");
    }

    final void p() {
        String str;
        h();
        zzic zzicVar = this.f73997a;
        if (zzicVar.x().w().o(zzjk.ANALYTICS_STORAGE)) {
            byte[] bArr = new byte[16];
            zzicVar.C().q0().nextBytes(bArr);
            str = String.format(Locale.US, "%032x", new BigInteger(1, bArr));
        } else {
            zzicVar.a().v().a("Analytics Storage consent is not granted");
            str = null;
        }
        zzicVar.a().v().a(String.format("Resetting session stitching token to %s", str == null ? "null" : "not null"));
        this.f73696o = str;
        this.f73697p = zzicVar.e().currentTimeMillis();
    }

    final String q() {
        j();
        Preconditions.m(this.f73684c);
        return this.f73684c;
    }

    final String r() {
        h();
        j();
        Preconditions.m(this.f73695n);
        return this.f73695n;
    }

    final String s() {
        j();
        Preconditions.m(this.f73688g);
        return this.f73688g;
    }

    final int t() {
        j();
        return this.f73686e;
    }

    final long u() {
        return this.f73691j;
    }

    final int v() {
        j();
        return this.f73694m;
    }

    final List w() {
        return this.f73692k;
    }

    final boolean x(String str) {
        String str2 = this.f73698q;
        boolean z2 = false;
        if (str2 != null && !str2.equals(str)) {
            z2 = true;
        }
        this.f73698q = str;
        return z2;
    }
}
