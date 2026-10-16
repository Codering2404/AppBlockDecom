package com.google.android.gms.internal.p000authapi;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zbao extends zbq {
    final /* synthetic */ TaskCompletionSource zba;

    zbao(zbaq zbaqVar, TaskCompletionSource taskCompletionSource) {
        this.zba = taskCompletionSource;
    }

    @Override // com.google.android.gms.internal.p000authapi.zbr
    public final void zbb(Status status, PendingIntent pendingIntent) throws RemoteException {
        TaskUtil.b(status, pendingIntent, this.zba);
    }
}
