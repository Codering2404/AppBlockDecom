package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zaab implements PendingResult.StatusListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ BasePendingResult f71638a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zaad f71639b;

    zaab(zaad zaadVar, BasePendingResult basePendingResult) {
        this.f71639b = zaadVar;
        this.f71638a = basePendingResult;
    }

    @Override // com.google.android.gms.common.api.PendingResult.StatusListener
    public final void a(Status status) {
        this.f71639b.f71642a.remove(this.f71638a);
    }
}
