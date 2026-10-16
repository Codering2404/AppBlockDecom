package com.google.android.gms.fido.u2f;

import android.app.PendingIntent;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.internal.fido.zzt;
import com.google.android.gms.internal.fido.zzu;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zzc extends zzu {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f72779a;

    zzc(U2fApiClient u2fApiClient, TaskCompletionSource taskCompletionSource) {
        this.f72779a = taskCompletionSource;
    }

    @Override // com.google.android.gms.internal.fido.zzv
    public final void zzb(Status status, PendingIntent pendingIntent) {
        TaskUtil.b(status, new zzt(pendingIntent), this.f72779a);
    }
}
