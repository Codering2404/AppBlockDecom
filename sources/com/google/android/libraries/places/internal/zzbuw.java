package com.google.android.libraries.places.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbuw extends zzbte {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzbvr f76930b;

    /* synthetic */ zzbuw(zzbvr zzbvrVar, byte[] bArr) {
        Objects.requireNonNull(zzbvrVar);
        this.f76930b = zzbvrVar;
    }

    @Override // com.google.android.libraries.places.internal.zzbte
    protected final void d() {
        this.f76930b.X();
    }

    @Override // com.google.android.libraries.places.internal.zzbte
    protected final void e() {
        zzbvr zzbvrVar = this.f76930b;
        if (zzbvrVar.u().get()) {
            return;
        }
        zzbvrVar.f0();
    }
}
