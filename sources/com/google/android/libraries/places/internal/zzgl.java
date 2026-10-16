package com.google.android.libraries.places.internal;

import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.libraries.places.api.net.SearchByTextResponse;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final /* synthetic */ class zzgl implements SuccessContinuation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzgm f77854a;

    @Override // com.google.android.gms.tasks.SuccessContinuation
    public final /* synthetic */ Task then(Object obj) {
        return this.f77854a.a((SearchByTextResponse) obj);
    }
}
