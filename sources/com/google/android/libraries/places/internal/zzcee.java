package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzcee extends zzceb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzcea f77703a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Object f77704b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f77705c;

    zzcee(zzcea zzceaVar) {
        super(null);
        this.f77705c = false;
        this.f77703a = zzceaVar;
    }

    @Override // com.google.android.libraries.places.internal.zzbiw
    public final void b(Object obj) {
        if (this.f77705c) {
            throw new zzbns(zzbnp.f76495l.e("More than one value received for unary call"), null);
        }
        this.f77704b = obj;
        this.f77705c = true;
    }

    @Override // com.google.android.libraries.places.internal.zzbiw
    public final void c(zzbnp zzbnpVar, zzbmg zzbmgVar) {
        if (!zzbnpVar.j()) {
            this.f77703a.C(new zzbns(zzbnpVar, zzbmgVar));
            return;
        }
        if (!this.f77705c) {
            this.f77703a.C(new zzbns(zzbnp.f76495l.e("No value received for unary call"), zzbmgVar));
        }
        this.f77703a.B(this.f77704b);
    }

    @Override // com.google.android.libraries.places.internal.zzceb
    final void e() {
        this.f77703a.F().c(2);
    }

    @Override // com.google.android.libraries.places.internal.zzbiw
    public final void a(zzbmg zzbmgVar) {
    }
}
