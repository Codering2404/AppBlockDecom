package com.google.android.gms.tagmanager;

import android.os.Message;
import android.util.Log;
import com.google.android.gms.internal.gtm.zzgc;
import com.google.android.gms.tagmanager.ContainerHolder;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzy extends zzgc {
    final /* synthetic */ zzz zza;
    private final ContainerHolder.ContainerAvailableListener zzb;

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        if (message.what != 1) {
            Log.e("GoogleTagManager", "Don't know how to handle this message.");
        } else {
            this.zzb.onContainerAvailable(this.zza, (String) message.obj);
        }
    }
}
