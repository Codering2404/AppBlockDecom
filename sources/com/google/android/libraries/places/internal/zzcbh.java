package com.google.android.libraries.places.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzcbh extends zzbte {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzcbp f77407b;

    zzcbh(zzcbp zzcbpVar) {
        Objects.requireNonNull(zzcbpVar);
        this.f77407b = zzcbpVar;
    }

    @Override // com.google.android.libraries.places.internal.zzbte
    protected final void d() {
        this.f77407b.i().zzc(true);
    }

    @Override // com.google.android.libraries.places.internal.zzbte
    protected final void e() {
        this.f77407b.i().zzc(false);
    }
}
