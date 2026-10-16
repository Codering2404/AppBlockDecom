package com.google.android.gms.cloudmessaging;

import android.os.Looper;
import android.os.Message;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zzae extends com.google.android.gms.internal.cloudmessaging.zzf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Rpc f71386a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzae(Rpc rpc, Looper looper) {
        super(looper);
        this.f71386a = rpc;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        Rpc.g(this.f71386a, message);
    }
}
