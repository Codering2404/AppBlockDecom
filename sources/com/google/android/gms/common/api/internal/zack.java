package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.RegistrationMethods;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zack extends RegisterListenerMethod {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ RegistrationMethods.Builder f71799e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zack(RegistrationMethods.Builder builder, ListenerHolder listenerHolder, Feature[] featureArr, boolean z2, int i3) {
        super(listenerHolder, featureArr, z2, i3);
        this.f71799e = builder;
    }

    @Override // com.google.android.gms.common.api.internal.RegisterListenerMethod
    protected final void d(Api.AnyClient anyClient, TaskCompletionSource taskCompletionSource) {
        this.f71799e.f71607a.accept(anyClient, taskCompletionSource);
    }
}
