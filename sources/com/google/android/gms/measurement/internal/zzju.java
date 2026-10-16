package com.google.android.gms.measurement.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzju extends zzay {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ zzlj f74037e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzju(zzlj zzljVar, zzjg zzjgVar) {
        super(zzjgVar);
        Objects.requireNonNull(zzljVar);
        this.f74037e = zzljVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzay
    public final void a() {
        final zzlj zzljVarB = this.f74037e.f73997a.B();
        Objects.requireNonNull(zzljVarB);
        new Thread(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzjt
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                zzljVarB.u0();
            }
        }).start();
    }
}
