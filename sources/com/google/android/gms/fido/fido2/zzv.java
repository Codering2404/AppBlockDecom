package com.google.android.gms.fido.fido2;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zzv extends com.google.android.gms.internal.fido.zzf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f72693a;

    zzv(Fido2PrivilegedApiClient fido2PrivilegedApiClient, TaskCompletionSource taskCompletionSource) {
        this.f72693a = taskCompletionSource;
    }

    @Override // com.google.android.gms.internal.fido.zzg
    public final void zzb(List list) {
        this.f72693a.setResult(list);
    }

    @Override // com.google.android.gms.internal.fido.zzg
    public final void zzc(Status status) {
        this.f72693a.trySetException(new ApiException(status));
    }
}
