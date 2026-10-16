package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class RegisterListenerMethod<A extends Api.AnyClient, L> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ListenerHolder f71600a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Feature[] f71601b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f71602c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f71603d;

    protected RegisterListenerMethod(ListenerHolder listenerHolder, Feature[] featureArr, boolean z2, int i3) {
        this.f71600a = listenerHolder;
        this.f71601b = featureArr;
        this.f71602c = z2;
        this.f71603d = i3;
    }

    public void a() {
        this.f71600a.a();
    }

    public ListenerHolder.ListenerKey b() {
        return this.f71600a.b();
    }

    public Feature[] c() {
        return this.f71601b;
    }

    protected abstract void d(Api.AnyClient anyClient, TaskCompletionSource taskCompletionSource);

    public final int e() {
        return this.f71603d;
    }

    public final boolean f() {
        return this.f71602c;
    }
}
