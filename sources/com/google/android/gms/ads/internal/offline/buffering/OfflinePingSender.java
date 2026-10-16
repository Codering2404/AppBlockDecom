package com.google.android.gms.ads.internal.offline.buffering;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.internal.ads.zzbuy;
import com.google.android.gms.internal.ads.zzbyu;
import com.pairip.VMRunner;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class OfflinePingSender extends Worker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzbyu f70036a;

    public OfflinePingSender(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        this.f70036a = zzay.b().j(context, new zzbuy());
    }

    @Override // androidx.work.Worker
    public final ListenableWorker.Result doWork() {
        return (ListenableWorker.Result) VMRunner.invoke("CuhQiWISVlxR51PP", new Object[]{this});
    }
}
