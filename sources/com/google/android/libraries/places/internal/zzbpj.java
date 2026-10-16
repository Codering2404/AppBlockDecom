package com.google.android.libraries.places.internal;

import com.google.common.base.Preconditions;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbpj implements zzbpn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzbiw f76603a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private zzbnp f76604b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ zzbpk f76605c;

    public zzbpj(zzbpk zzbpkVar, zzbiw zzbiwVar) {
        Objects.requireNonNull(zzbpkVar);
        this.f76605c = zzbpkVar;
        this.f76603a = (zzbiw) Preconditions.u(zzbiwVar, "observer");
    }

    @Override // com.google.android.libraries.places.internal.zzbpn
    public final void a(zzbmg zzbmgVar) {
        int i3 = zzcew.f77735a;
        this.f76605c.j().execute(new zzbpf(this, zzcew.b(), zzbmgVar));
    }

    @Override // com.google.android.libraries.places.internal.zzbpn
    public final void b(zzbnp zzbnpVar, zzbpm zzbpmVar, zzbmg zzbmgVar) {
        int i3 = zzcew.f77735a;
        zzbpk zzbpkVar = this.f76605c;
        zzbjv zzbjvVarG = zzbpkVar.g();
        if (zzbnpVar.g() == zzbnm.CANCELLED && zzbjvVarG != null && zzbjvVarG.b()) {
            zzbnpVar = zzbpkVar.m().c();
            zzbmgVar = new zzbmg();
        }
        zzbpkVar.j().execute(new zzbph(this, zzcew.b(), zzbnpVar, zzbmgVar));
    }

    @Override // com.google.android.libraries.places.internal.zzcad
    public final void c(zzcac zzcacVar) {
        int i3 = zzcew.f77735a;
        this.f76605c.j().execute(new zzbpg(this, zzcew.b(), zzcacVar));
    }

    final /* synthetic */ void d(zzbnp zzbnpVar) {
        this.f76604b = zzbnpVar;
        this.f76605c.o().c(zzbnpVar);
    }

    final /* synthetic */ zzbiw e() {
        return this.f76603a;
    }

    final /* synthetic */ zzbnp f() {
        return this.f76604b;
    }

    @Override // com.google.android.libraries.places.internal.zzcad
    public final void zzd() {
        zzbpk zzbpkVar = this.f76605c;
        zzbmj zzbmjVarA = zzbpkVar.i().a();
        if (zzbmjVarA == zzbmj.UNARY || zzbmjVarA == zzbmj.SERVER_STREAMING) {
            return;
        }
        zzbpkVar.j().execute(new zzbpi(this, zzcew.b()));
    }
}
