package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzcec extends zzceb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzcej f77696a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzcdz f77697b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f77698c;

    zzcec(zzcej zzcejVar, zzcdz zzcdzVar) {
        super(null);
        this.f77696a = zzcejVar;
        this.f77697b = zzcdzVar;
    }

    @Override // com.google.android.libraries.places.internal.zzbiw
    public final void b(Object obj) {
        if (this.f77698c) {
            throw new zzbns(zzbnp.f76495l.e("More than one responses received for unary or client-streaming call"), null);
        }
        this.f77698c = true;
        this.f77696a.zzc(obj);
    }

    @Override // com.google.android.libraries.places.internal.zzbiw
    public final void c(zzbnp zzbnpVar, zzbmg zzbmgVar) {
        if (zzbnpVar.j()) {
            this.f77696a.zzb();
        } else {
            this.f77696a.zza(new zzbns(zzbnpVar, zzbmgVar));
        }
    }

    @Override // com.google.android.libraries.places.internal.zzceb
    final void e() {
        this.f77697b.a(1);
    }

    @Override // com.google.android.libraries.places.internal.zzbiw
    public final void d() {
    }

    @Override // com.google.android.libraries.places.internal.zzbiw
    public final void a(zzbmg zzbmgVar) {
    }
}
