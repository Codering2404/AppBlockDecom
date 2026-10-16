package com.google.android.gms.measurement.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzoj extends zzay {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ zzok f74384e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzoj(zzok zzokVar, zzjg zzjgVar) {
        super(zzjgVar);
        Objects.requireNonNull(zzokVar);
        this.f74384e = zzokVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzay
    public final void a() {
        zzok zzokVar = this.f74384e;
        zzokVar.n();
        zzokVar.f73997a.a().w().a("Starting upload from DelayedRunnable");
        zzokVar.f74388b.r();
    }
}
