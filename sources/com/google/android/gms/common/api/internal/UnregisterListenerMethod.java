package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class UnregisterListenerMethod<A extends Api.AnyClient, L> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ListenerHolder.ListenerKey f71622a;

    protected UnregisterListenerMethod(ListenerHolder.ListenerKey listenerKey) {
        this.f71622a = listenerKey;
    }

    public ListenerHolder.ListenerKey a() {
        return this.f71622a;
    }

    protected abstract void b(Api.AnyClient anyClient, TaskCompletionSource taskCompletionSource);
}
