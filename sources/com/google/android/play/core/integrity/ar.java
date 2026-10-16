package com.google.android.play.core.integrity;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class ar extends ResultReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ as f82985a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ar(as asVar, Handler handler) {
        super(handler);
        this.f82985a = asVar;
    }

    @Override // android.os.ResultReceiver
    public final void onReceiveResult(int i3, Bundle bundle) {
        if (i3 == 1) {
            this.f82985a.f82986a.trySetResult(3);
        } else if (i3 == 2) {
            this.f82985a.f82986a.trySetResult(2);
        } else {
            if (i3 != 3) {
                return;
            }
            this.f82985a.f82986a.trySetResult(1);
        }
    }
}
