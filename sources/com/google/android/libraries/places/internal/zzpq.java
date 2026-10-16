package com.google.android.libraries.places.internal;

import android.content.Context;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.net.PlacesClient;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzpq implements zzpt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f78414a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzmy f78415b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final zzbih f78416c = zzbil.a(zzeh.a());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final zzbih f78417d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final zzbih f78418e;

    zzpq(Context context, zzmy zzmyVar) {
        this.f78414a = context;
        this.f78415b = zzmyVar;
        zzbie zzbieVarA = zzbif.a(context);
        this.f78417d = zzbieVarA;
        this.f78418e = zzbid.a(zzmu.a(zzbieVarA, zzeq.a()));
    }

    final zzmz a() {
        zzmx zzmxVarD = zzmz.d(zzms.c(this.f78414a));
        zzmxVarD.b(this.f78415b);
        return zzmxVarD.d();
    }

    @Override // com.google.android.libraries.places.internal.zzpt
    public final zzef zzb() {
        return (zzef) this.f78416c.zzb();
    }

    @Override // com.google.android.libraries.places.internal.zzpt
    public final PlacesClient zzc() {
        return Places.e(zzms.c(this.f78414a), a());
    }

    @Override // com.google.android.libraries.places.internal.zzpt
    public final zzpu zzd() {
        return new zzpv(new zzne(zzmt.a(this.f78414a), (zzex) this.f78418e.zzb()), a());
    }

    @Override // com.google.android.libraries.places.internal.zzpt
    public final zzpm zze() {
        return new zzpm(zzms.c(this.f78414a));
    }
}
