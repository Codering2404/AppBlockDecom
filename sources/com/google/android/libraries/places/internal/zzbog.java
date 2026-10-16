package com.google.android.libraries.places.internal;

import com.google.common.base.Preconditions;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class zzbog extends zzbok implements zzbpl, zzbwk {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Logger f76538g = Logger.getLogger(zzbog.class.getName());

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f76539h = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzcal f76540b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzbsq f76541c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f76542d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private zzbmg f76543e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile boolean f76544f;

    protected zzbog(zzcan zzcanVar, zzcaa zzcaaVar, zzcal zzcalVar, zzbmg zzbmgVar, zzbis zzbisVar, boolean z2) {
        Preconditions.u(zzbmgVar, "headers");
        this.f76540b = (zzcal) Preconditions.u(zzcalVar, "transportTracer");
        this.f76542d = !Boolean.TRUE.equals(zzbisVar.i(zzbsz.f76833n));
        this.f76541c = new zzbwl(this, zzcanVar, zzcaaVar);
        this.f76543e = zzbmgVar;
    }

    @Override // com.google.android.libraries.places.internal.zzbpl
    public final void a(zzbpn zzbpnVar) {
        m().s(zzbpnVar);
        n().c(this.f76543e, null);
        this.f76543e = null;
    }

    @Override // com.google.android.libraries.places.internal.zzbpl
    public final void c(zzbnp zzbnpVar) {
        Preconditions.e(!zzbnpVar.j(), "Should not cancel with OK status");
        this.f76544f = true;
        n().a(zzbnpVar);
    }

    @Override // com.google.android.libraries.places.internal.zzbwk
    public final void d(zzcam zzcamVar, boolean z2, boolean z3, int i3) {
        boolean z4 = true;
        if (zzcamVar == null && !z2) {
            z4 = false;
        }
        Preconditions.e(z4, "null frame before EOS");
        n().b(zzcamVar, z2, z3, i3);
    }

    @Override // com.google.android.libraries.places.internal.zzbpl
    public final void e(zzbjy zzbjyVar) {
        m().y(zzbjyVar);
    }

    @Override // com.google.android.libraries.places.internal.zzbpl
    public final void g(zzbtf zzbtfVar) {
        zzbtfVar.b("remote_addr", zzam().a(zzbkg.f76317a));
    }

    @Override // com.google.android.libraries.places.internal.zzbpl
    public final void h(zzbjv zzbjvVar) {
        zzbmg zzbmgVar = this.f76543e;
        zzbmc zzbmcVar = zzbsz.f76822c;
        zzbmgVar.d(zzbmcVar);
        this.f76543e.c(zzbmcVar, Long.valueOf(zzbjvVar.c(TimeUnit.NANOSECONDS)));
    }

    @Override // com.google.android.libraries.places.internal.zzbok
    protected final zzbsq i() {
        return this.f76541c;
    }

    @Override // com.google.android.libraries.places.internal.zzbok
    protected /* bridge */ /* synthetic */ zzboj j() {
        throw null;
    }

    protected abstract zzbof m();

    protected abstract zzbod n();

    public final boolean o() {
        return this.f76542d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final zzcal p() {
        return this.f76540b;
    }

    @Override // com.google.android.libraries.places.internal.zzbpl
    public final void zzb(int i3) {
        this.f76541c.zzf(i3);
    }

    @Override // com.google.android.libraries.places.internal.zzbpl
    public final void zzc(int i3) {
        m().i(i3);
    }

    @Override // com.google.android.libraries.places.internal.zzbpl
    public final void zzk() {
        if (m().t()) {
            return;
        }
        m().z();
        i().zzd();
    }

    @Override // com.google.android.libraries.places.internal.zzcab
    public final boolean zzm() {
        return j().p() && !this.f76544f;
    }
}
