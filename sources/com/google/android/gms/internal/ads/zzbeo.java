package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.pairip.VMRunner;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzbeo extends BroadcastReceiver {
    final /* synthetic */ zzbes zza;

    zzbeo(zzbes zzbesVar) {
        Objects.requireNonNull(zzbesVar);
        this.zza = zzbesVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        VMRunner.invoke("4PbsN8xC7saYmGdT", new Object[]{this, context, intent});
    }
}
