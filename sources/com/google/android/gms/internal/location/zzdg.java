package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzdg extends zzs {
    final /* synthetic */ TaskCompletionSource zza;

    zzdg(TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    @Override // com.google.android.gms.internal.location.zzt
    public final void zzb(int i3, String[] strArr) {
        TaskUtil.a(new Status(GeofenceStatusCodes.b(i3)), this.zza);
    }

    @Override // com.google.android.gms.internal.location.zzt
    public final void zzc(int i3, String[] strArr) {
        TaskUtil.a(new Status(GeofenceStatusCodes.b(i3)), this.zza);
    }

    @Override // com.google.android.gms.internal.location.zzt
    public final void zzd(int i3, PendingIntent pendingIntent) {
        TaskUtil.a(new Status(GeofenceStatusCodes.b(i3)), this.zza);
    }
}
