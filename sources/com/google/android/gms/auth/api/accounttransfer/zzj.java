package com.google.android.gms.auth.api.accounttransfer;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.auth.zzan;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
class zzj extends zzan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final zzl f71009a;

    public zzj(zzl zzlVar) {
        this.f71009a = zzlVar;
    }

    @Override // com.google.android.gms.internal.auth.zzan, com.google.android.gms.internal.auth.zzat
    public final void zzd(Status status) {
        TaskCompletionSource taskCompletionSource = this.f71009a.f71010d;
        int i3 = AccountTransferClient.f70997d;
        taskCompletionSource.setException(new AccountTransferException(status));
    }
}
