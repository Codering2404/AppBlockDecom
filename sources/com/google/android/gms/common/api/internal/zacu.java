package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.util.BiConsumer;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class zacu implements RemoteCall {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BiConsumer f71814a;

    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object obj, Object obj2) {
        this.f71814a.accept((Api.AnyClient) obj, (TaskCompletionSource) obj2);
    }
}
