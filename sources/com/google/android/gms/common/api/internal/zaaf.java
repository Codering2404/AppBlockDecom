package com.google.android.gms.common.api.internal;

import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zaaf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ApiKey f71646a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TaskCompletionSource f71647b = new TaskCompletionSource();

    public zaaf(ApiKey apiKey) {
        this.f71646a = apiKey;
    }

    public final ApiKey a() {
        return this.f71646a;
    }

    public final TaskCompletionSource b() {
        return this.f71647b;
    }
}
