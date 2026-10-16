package com.google.android.play.core.appupdate;

import android.os.Bundle;
import android.os.ResultReceiver;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zze extends ResultReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f82909a;

    @Override // android.os.ResultReceiver
    public final void onReceiveResult(int i3, Bundle bundle) {
        if (i3 == 1) {
            this.f82909a.trySetResult(-1);
        } else if (i3 != 2) {
            this.f82909a.trySetResult(1);
        } else {
            this.f82909a.trySetResult(0);
        }
    }
}
