package com.google.android.gms.fido.fido2;

import android.app.PendingIntent;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zzs extends com.google.android.gms.internal.fido.zzl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f72690a;

    zzs(Fido2PrivilegedApiClient fido2PrivilegedApiClient, TaskCompletionSource taskCompletionSource) {
        this.f72690a = taskCompletionSource;
    }

    @Override // com.google.android.gms.internal.fido.zzm
    public final void zzb(Status status, PendingIntent pendingIntent) {
        TaskUtil.b(status, new com.google.android.gms.internal.fido.zzi(pendingIntent), this.f72690a);
    }
}
