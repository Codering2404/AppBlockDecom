package com.google.android.gms.internal.cloudmessaging;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public class zzf extends Handler {
    private final Looper zza;

    public zzf() {
        this.zza = Looper.getMainLooper();
    }

    public zzf(Looper looper) {
        super(looper);
        this.zza = Looper.getMainLooper();
    }

    public zzf(Looper looper, Handler.Callback callback) {
        super(looper, callback);
        this.zza = Looper.getMainLooper();
    }
}
