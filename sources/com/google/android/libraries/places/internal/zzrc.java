package com.google.android.libraries.places.internal;

import com.google.common.base.Preconditions;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
abstract class zzrc extends zzqx {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zzro f78502f;

    zzrc(String str, UUID uuid, String str2, zzro zzroVar, zzrt zzrtVar) {
        super("<skip trace>", uuid, str2, zzrtVar);
        Preconditions.d(zzroVar.e());
        this.f78502f = zzroVar;
    }

    @Override // com.google.android.libraries.places.internal.zzrv
    public final zzro zzg() {
        return zzro.a(this.f78502f, zzj());
    }
}
