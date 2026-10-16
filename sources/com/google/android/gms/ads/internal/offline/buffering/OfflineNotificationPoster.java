package com.google.android.gms.ads.internal.offline.buffering;

import android.content.Context;
import android.os.RemoteException;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbuy;
import com.google.android.gms.internal.ads.zzbyu;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class OfflineNotificationPoster extends Worker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzbyu f70035a;

    public OfflineNotificationPoster(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        this.f70035a = zzay.b().j(context, new zzbuy());
    }

    @Override // androidx.work.Worker
    public final ListenableWorker.Result doWork() {
        try {
            this.f70035a.zzj(ObjectWrapper.i5(getApplicationContext()), new zza(getInputData().j(ShareConstants.MEDIA_URI), getInputData().j("gws_query_id"), getInputData().j("image_url")));
            return ListenableWorker.Result.c();
        } catch (RemoteException unused) {
            return ListenableWorker.Result.a();
        }
    }
}
