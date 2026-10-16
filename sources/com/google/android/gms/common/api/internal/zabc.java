package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zabc extends com.google.android.gms.internal.base.zau {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zabe f71700a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zabc(zabe zabeVar, Looper looper) {
        super(looper);
        this.f71700a = zabeVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i3 = message.what;
        if (i3 == 1) {
            zabe.z(this.f71700a);
            return;
        }
        if (i3 == 2) {
            zabe.y(this.f71700a);
            return;
        }
        Log.w("GoogleApiClientImpl", "Unknown message id: " + i3);
    }
}
