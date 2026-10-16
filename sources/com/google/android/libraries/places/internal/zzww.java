package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class zzww {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzvp f78785a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f78786b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f78787c = -1;

    public zzww(zzvp zzvpVar) {
        zzxb.a(zzvpVar, "context");
        this.f78785a = zzvpVar;
    }

    protected abstract void c(int i3, int i4, zzwr zzwrVar);

    protected abstract Object d();

    public final zzwx e() {
        return this.f78785a.a();
    }

    public final String f() {
        return this.f78785a.b();
    }

    public final int g() {
        return this.f78787c + 1;
    }

    public final void h(int i3, int i4, zzwr zzwrVar) {
        if (zzwrVar.b() < 32) {
            this.f78786b |= 1 << zzwrVar.b();
        }
        this.f78787c = Math.max(this.f78787c, zzwrVar.b());
        c(i3, i4, zzwrVar);
    }

    public final Object i() {
        zzvp zzvpVar = this.f78785a;
        zzvpVar.a().a(this);
        int i3 = this.f78786b;
        if (((i3 + 1) & i3) != 0 || (this.f78787c > 31 && i3 != -1)) {
            throw zzwy.d(String.format("unreferenced arguments [first missing index=%d]", Integer.valueOf(Integer.numberOfTrailingZeros(~i3))), zzvpVar.b());
        }
        return d();
    }
}
