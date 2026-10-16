package com.google.android.play.core.integrity;

import com.google.android.gms.tasks.Task;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class aa implements IntegrityManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final aj f82950a;

    aa(aj ajVar) {
        this.f82950a = ajVar;
    }

    @Override // com.google.android.play.core.integrity.IntegrityManager
    public final Task<IntegrityTokenResponse> requestIntegrityToken(IntegrityTokenRequest integrityTokenRequest) {
        return this.f82950a.c(integrityTokenRequest);
    }
}
