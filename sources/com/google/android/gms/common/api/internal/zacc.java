package com.google.android.gms.common.api.internal;

import android.app.Activity;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zacc extends zap {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private TaskCompletionSource f71779f;

    @Override // com.google.android.gms.common.api.internal.zap
    protected final void b(ConnectionResult connectionResult, int i3) {
        String strO = connectionResult.O();
        if (strO == null) {
            strO = "Error connecting to Google Play services";
        }
        this.f71779f.setException(new ApiException(new Status(connectionResult, strO, connectionResult.N())));
    }

    @Override // com.google.android.gms.common.api.internal.zap
    protected final void c() {
        Activity activityI = this.mLifecycleFragment.i();
        if (activityI == null) {
            this.f71779f.trySetException(new ApiException(new Status(8)));
            return;
        }
        int i3 = this.f71859d.i(activityI);
        if (i3 == 0) {
            this.f71779f.trySetResult(null);
        } else {
            if (this.f71779f.getTask().isComplete()) {
                return;
            }
            h(new ConnectionResult(i3, null), 0);
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void onDestroy() {
        super.onDestroy();
        this.f71779f.trySetException(new CancellationException("Host activity was destroyed before Google Play services could be made available."));
    }
}
