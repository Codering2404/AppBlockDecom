package com.google.android.gms.fido.fido2;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zzj extends com.google.android.gms.internal.fido.zzd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f72676a;

    zzj(Fido2ApiClient fido2ApiClient, TaskCompletionSource taskCompletionSource) {
        this.f72676a = taskCompletionSource;
    }

    @Override // com.google.android.gms.internal.fido.zze
    public final void zzb(boolean z2) {
        this.f72676a.setResult(Boolean.valueOf(z2));
    }

    @Override // com.google.android.gms.internal.fido.zze
    public final void zzc(Status status) {
        this.f72676a.trySetException(new ApiException(status));
    }
}
