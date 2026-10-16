package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.RegistrationMethods;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zacl extends UnregisterListenerMethod {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ RegistrationMethods.Builder f71800b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zacl(RegistrationMethods.Builder builder, ListenerHolder.ListenerKey listenerKey) {
        super(listenerKey);
        this.f71800b = builder;
    }

    @Override // com.google.android.gms.common.api.internal.UnregisterListenerMethod
    protected final void b(Api.AnyClient anyClient, TaskCompletionSource taskCompletionSource) {
        this.f71800b.f71608b.accept(anyClient, taskCompletionSource);
    }
}
