package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzh {
    private Long A;
    private long B;
    private String C;
    private int D;
    private int E;
    private long F;
    private String G;
    private byte[] H;
    private int I;
    private long J;
    private long K;
    private long L;
    private long M;
    private long N;
    private long O;
    private String P;
    private boolean Q;
    private long R;
    private long S;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzic f73755a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f73756b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f73757c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f73758d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f73759e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f73760f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f73761g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f73762h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f73763i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f73764j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f73765k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f73766l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private long f73767m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private long f73768n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f73769o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f73770p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private Boolean f73771q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private long f73772r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private List f73773s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private String f73774t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f73775u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private long f73776v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private long f73777w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f73778x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f73779y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private Long f73780z;

    zzh(zzic zzicVar, String str) {
        Preconditions.m(zzicVar);
        Preconditions.g(str);
        this.f73755a = zzicVar;
        this.f73756b = str;
        zzicVar.b().h();
    }

    public final boolean A() {
        this.f73755a.b().h();
        return this.Q;
    }

    public final void A0(long j3) {
        this.f73755a.b().h();
        this.Q |= this.f73762h != j3;
        this.f73762h = j3;
    }

    public final int B() {
        this.f73755a.b().h();
        return this.D;
    }

    public final long B0() {
        this.f73755a.b().h();
        return this.f73763i;
    }

    public final void C(int i3) {
        this.f73755a.b().h();
        this.Q |= this.D != i3;
        this.D = i3;
    }

    public final void C0(long j3) {
        this.f73755a.b().h();
        this.Q |= this.f73763i != j3;
        this.f73763i = j3;
    }

    public final int D() {
        this.f73755a.b().h();
        return this.E;
    }

    public final String D0() {
        this.f73755a.b().h();
        return this.f73764j;
    }

    public final void E(int i3) {
        this.f73755a.b().h();
        this.Q |= this.E != i3;
        this.E = i3;
    }

    public final void E0(String str) {
        this.f73755a.b().h();
        this.Q |= !Objects.equals(this.f73764j, str);
        this.f73764j = str;
    }

    public final void F(long j3) {
        this.f73755a.b().h();
        this.Q |= this.F != j3;
        this.F = j3;
    }

    public final long F0() {
        this.f73755a.b().h();
        return this.f73765k;
    }

    public final long G() {
        this.f73755a.b().h();
        return this.F;
    }

    public final void G0(long j3) {
        this.f73755a.b().h();
        this.Q |= this.f73765k != j3;
        this.f73765k = j3;
    }

    public final void H(String str) {
        this.f73755a.b().h();
        this.Q |= this.G != str;
        this.G = str;
    }

    public final String H0() {
        this.f73755a.b().h();
        return this.f73766l;
    }

    public final String I() {
        this.f73755a.b().h();
        return this.G;
    }

    public final void I0(String str) {
        this.f73755a.b().h();
        this.Q |= !Objects.equals(this.f73766l, str);
        this.f73766l = str;
    }

    public final void J(byte[] bArr) {
        this.f73755a.b().h();
        this.Q |= this.H != bArr;
        this.H = bArr;
    }

    public final long J0() {
        this.f73755a.b().h();
        return this.f73767m;
    }

    public final byte[] K() {
        this.f73755a.b().h();
        return this.H;
    }

    public final void K0(long j3) {
        this.f73755a.b().h();
        this.Q |= this.f73767m != j3;
        this.f73767m = j3;
    }

    public final void L(int i3) {
        this.f73755a.b().h();
        this.Q |= this.I != i3;
        this.I = i3;
    }

    public final long L0() {
        this.f73755a.b().h();
        return this.f73768n;
    }

    public final int M() {
        this.f73755a.b().h();
        return this.I;
    }

    public final String N() {
        this.f73755a.b().h();
        String str = this.P;
        O(null);
        return str;
    }

    public final void O(String str) {
        this.f73755a.b().h();
        this.Q |= !Objects.equals(this.P, str);
        this.P = str;
    }

    public final boolean P() {
        this.f73755a.b().h();
        return this.f73770p;
    }

    public final void Q(boolean z2) {
        this.f73755a.b().h();
        this.Q |= this.f73770p != z2;
        this.f73770p = z2;
    }

    public final Boolean R() {
        this.f73755a.b().h();
        return this.f73771q;
    }

    public final void S(Boolean bool) {
        this.f73755a.b().h();
        this.Q |= !Objects.equals(this.f73771q, bool);
        this.f73771q = bool;
    }

    public final List T() {
        this.f73755a.b().h();
        return this.f73773s;
    }

    public final void U(List list) {
        this.f73755a.b().h();
        if (Objects.equals(this.f73773s, list)) {
            return;
        }
        this.Q = true;
        this.f73773s = list != null ? new ArrayList(list) : null;
    }

    public final boolean V() {
        this.f73755a.b().h();
        return this.f73775u;
    }

    public final void W(boolean z2) {
        this.f73755a.b().h();
        this.Q |= this.f73775u != z2;
        this.f73775u = z2;
    }

    public final long X() {
        this.f73755a.b().h();
        return this.f73776v;
    }

    public final void Y(long j3) {
        this.f73755a.b().h();
        this.Q |= this.f73776v != j3;
        this.f73776v = j3;
    }

    public final long Z() {
        this.f73755a.b().h();
        return this.f73777w;
    }

    public final void a(long j3) {
        this.f73755a.b().h();
        this.Q |= this.f73768n != j3;
        this.f73768n = j3;
    }

    public final void a0(long j3) {
        this.f73755a.b().h();
        this.Q |= this.f73777w != j3;
        this.f73777w = j3;
    }

    public final long b() {
        this.f73755a.b().h();
        return this.f73772r;
    }

    public final int b0() {
        this.f73755a.b().h();
        return this.f73778x;
    }

    public final void c(long j3) {
        this.f73755a.b().h();
        this.Q |= this.f73772r != j3;
        this.f73772r = j3;
    }

    public final void c0(int i3) {
        this.f73755a.b().h();
        this.Q |= this.f73778x != i3;
        this.f73778x = i3;
    }

    public final boolean d() {
        this.f73755a.b().h();
        return this.f73769o;
    }

    public final boolean d0() {
        this.f73755a.b().h();
        return this.f73779y;
    }

    public final void e(boolean z2) {
        this.f73755a.b().h();
        this.Q |= this.f73769o != z2;
        this.f73769o = z2;
    }

    public final void e0(boolean z2) {
        this.f73755a.b().h();
        this.Q |= this.f73779y != z2;
        this.f73779y = z2;
    }

    public final void f(long j3) {
        Preconditions.a(j3 >= 0);
        this.f73755a.b().h();
        this.Q |= this.f73761g != j3;
        this.f73761g = j3;
    }

    public final Long f0() {
        this.f73755a.b().h();
        return this.f73780z;
    }

    public final long g() {
        this.f73755a.b().h();
        return this.f73761g;
    }

    public final void g0(Long l3) {
        this.f73755a.b().h();
        this.Q |= !Objects.equals(this.f73780z, l3);
        this.f73780z = l3;
    }

    public final long h() {
        this.f73755a.b().h();
        return this.R;
    }

    public final Long h0() {
        this.f73755a.b().h();
        return this.A;
    }

    public final void i(long j3) {
        this.f73755a.b().h();
        this.Q |= this.R != j3;
        this.R = j3;
    }

    public final void i0(Long l3) {
        this.f73755a.b().h();
        this.Q |= !Objects.equals(this.A, l3);
        this.A = l3;
    }

    public final long j() {
        this.f73755a.b().h();
        return this.S;
    }

    public final long j0() {
        this.f73755a.b().h();
        return this.B;
    }

    public final void k(long j3) {
        this.f73755a.b().h();
        this.Q |= this.S != j3;
        this.S = j3;
    }

    public final void k0(long j3) {
        this.f73755a.b().h();
        this.Q |= this.B != j3;
        this.B = j3;
    }

    public final void l() {
        zzic zzicVar = this.f73755a;
        zzicVar.b().h();
        long j3 = this.f73761g + 1;
        if (j3 > 2147483647L) {
            zzicVar.a().r().b("Bundle index overflow. appId", zzgu.x(this.f73756b));
            j3 = 0;
        }
        this.Q = true;
        this.f73761g = j3;
    }

    public final String l0() {
        this.f73755a.b().h();
        return this.C;
    }

    public final void m(long j3) {
        zzic zzicVar = this.f73755a;
        zzicVar.b().h();
        long j4 = this.f73761g + j3;
        if (j4 > 2147483647L) {
            zzicVar.a().r().b("Bundle index overflow. appId", zzgu.x(this.f73756b));
            j4 = (-1) + j3;
        }
        long j5 = this.F + 1;
        if (j5 > 2147483647L) {
            zzicVar.a().r().b("Delivery index overflow. appId", zzgu.x(this.f73756b));
            j5 = 0;
        }
        this.Q = true;
        this.f73761g = j4;
        this.F = j5;
    }

    public final void m0(String str) {
        this.f73755a.b().h();
        this.Q |= this.C != str;
        this.C = str;
    }

    public final long n() {
        this.f73755a.b().h();
        return this.J;
    }

    public final void n0() {
        this.f73755a.b().h();
        this.Q = false;
    }

    public final void o(long j3) {
        this.f73755a.b().h();
        this.Q |= this.J != j3;
        this.J = j3;
    }

    public final String o0() {
        this.f73755a.b().h();
        return this.f73756b;
    }

    public final long p() {
        this.f73755a.b().h();
        return this.K;
    }

    public final String p0() {
        this.f73755a.b().h();
        return this.f73757c;
    }

    public final void q(long j3) {
        this.f73755a.b().h();
        this.Q |= this.K != j3;
        this.K = j3;
    }

    public final void q0(String str) {
        this.f73755a.b().h();
        this.Q |= !Objects.equals(this.f73757c, str);
        this.f73757c = str;
    }

    public final long r() {
        this.f73755a.b().h();
        return this.L;
    }

    public final String r0() {
        this.f73755a.b().h();
        return this.f73758d;
    }

    public final void s(long j3) {
        this.f73755a.b().h();
        this.Q |= this.L != j3;
        this.L = j3;
    }

    public final void s0(String str) {
        this.f73755a.b().h();
        if (true == TextUtils.isEmpty(str)) {
            str = null;
        }
        this.Q |= true ^ Objects.equals(this.f73758d, str);
        this.f73758d = str;
    }

    public final long t() {
        this.f73755a.b().h();
        return this.M;
    }

    public final String t0() {
        this.f73755a.b().h();
        return this.f73774t;
    }

    public final void u(long j3) {
        this.f73755a.b().h();
        this.Q |= this.M != j3;
        this.M = j3;
    }

    public final void u0(String str) {
        this.f73755a.b().h();
        this.Q |= !Objects.equals(this.f73774t, str);
        this.f73774t = str;
    }

    public final long v() {
        this.f73755a.b().h();
        return this.O;
    }

    public final String v0() {
        this.f73755a.b().h();
        return this.f73759e;
    }

    public final void w(long j3) {
        this.f73755a.b().h();
        this.Q |= this.O != j3;
        this.O = j3;
    }

    public final void w0(String str) {
        this.f73755a.b().h();
        this.Q |= !Objects.equals(this.f73759e, str);
        this.f73759e = str;
    }

    public final long x() {
        this.f73755a.b().h();
        return this.N;
    }

    public final String x0() {
        this.f73755a.b().h();
        return this.f73760f;
    }

    public final void y(long j3) {
        this.f73755a.b().h();
        this.Q |= this.N != j3;
        this.N = j3;
    }

    public final void y0(String str) {
        this.f73755a.b().h();
        this.Q |= !Objects.equals(this.f73760f, str);
        this.f73760f = str;
    }

    public final String z() {
        this.f73755a.b().h();
        return this.P;
    }

    public final long z0() {
        this.f73755a.b().h();
        return this.f73762h;
    }
}
