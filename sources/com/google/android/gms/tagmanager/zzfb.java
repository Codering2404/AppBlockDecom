package com.google.android.gms.tagmanager;

import android.os.Handler;
import android.os.Message;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzfb implements Handler.Callback {
    final /* synthetic */ zzfd zza;

    zzfb(zzfd zzfdVar) {
        this.zza = zzfdVar;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        if (message.what == 1 && zzfe.zza.equals(message.obj)) {
            this.zza.zza.zza();
            zzfd zzfdVar = this.zza;
            if (!zzfdVar.zza.zzm()) {
                zzfdVar.zzc(1800000L);
            }
        }
        return true;
    }
}
