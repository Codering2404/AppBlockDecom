package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Message;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzff implements zzdy {
    private Message zza;

    private zzff() {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzdy
    public final void zza() {
        Message message = this.zza;
        message.getClass();
        message.sendToTarget();
        this.zza = null;
        zzfg.zzo(this);
    }

    public final zzff zzb(Message message, zzfg zzfgVar) {
        this.zza = message;
        return this;
    }

    public final boolean zzc(Handler handler) {
        Message message = this.zza;
        message.getClass();
        boolean zSendMessageAtFrontOfQueue = handler.sendMessageAtFrontOfQueue(message);
        this.zza = null;
        zzfg.zzo(this);
        return zSendMessageAtFrontOfQueue;
    }

    /* synthetic */ zzff(byte[] bArr) {
    }
}
