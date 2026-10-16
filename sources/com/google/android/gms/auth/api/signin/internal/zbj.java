package com.google.android.gms.auth.api.signin.internal;

import com.google.android.gms.common.api.Status;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zbj extends zba {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zbk f71256a;

    zbj(zbk zbkVar) {
        this.f71256a = zbkVar;
    }

    @Override // com.google.android.gms.auth.api.signin.internal.zba, com.google.android.gms.auth.api.signin.internal.zbr
    public final void z3(Status status) {
        this.f71256a.setResult(status);
    }
}
