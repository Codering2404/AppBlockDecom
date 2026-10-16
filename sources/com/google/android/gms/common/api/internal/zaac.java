package com.google.android.gms.common.api.internal;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zaac implements OnCompleteListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f71640a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zaad f71641b;

    zaac(zaad zaadVar, TaskCompletionSource taskCompletionSource) {
        this.f71641b = zaadVar;
        this.f71640a = taskCompletionSource;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task task) {
        this.f71641b.f71643b.remove(this.f71640a);
    }
}
