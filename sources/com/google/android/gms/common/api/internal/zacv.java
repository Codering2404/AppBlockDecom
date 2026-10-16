package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zacv extends TaskApiCall {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ TaskApiCall.Builder f71815d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zacv(TaskApiCall.Builder builder, Feature[] featureArr, boolean z2, int i3) {
        super(featureArr, z2, i3);
        this.f71815d = builder;
    }

    @Override // com.google.android.gms.common.api.internal.TaskApiCall
    protected final void b(Api.AnyClient anyClient, TaskCompletionSource taskCompletionSource) {
        this.f71815d.f71618a.accept(anyClient, taskCompletionSource);
    }
}
