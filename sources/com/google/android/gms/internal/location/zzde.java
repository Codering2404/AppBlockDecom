package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzde extends zzaa {
    final /* synthetic */ TaskCompletionSource zza;

    zzde(TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    @Override // com.google.android.gms.internal.location.zzab
    public final void zzb(LocationSettingsResult locationSettingsResult) {
        TaskUtil.b(locationSettingsResult.getStatus(), new LocationSettingsResponse(locationSettingsResult), this.zza);
    }
}
