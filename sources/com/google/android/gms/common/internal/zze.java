package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zze implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f72100a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ BaseGmsClient f72101b;

    public zze(BaseGmsClient baseGmsClient, int i3) {
        java.util.Objects.requireNonNull(baseGmsClient);
        this.f72101b = baseGmsClient;
        this.f72100a = i3;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        BaseGmsClient baseGmsClient = this.f72101b;
        if (iBinder == null) {
            baseGmsClient.zzf(16);
            return;
        }
        synchronized (baseGmsClient.zzh()) {
            try {
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                baseGmsClient.zzi((iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IGmsServiceBroker)) ? new zzaa(iBinder) : (IGmsServiceBroker) iInterfaceQueryLocalInterface);
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f72101b.zzb(0, null, this.f72100a);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        BaseGmsClient baseGmsClient = this.f72101b;
        synchronized (baseGmsClient.zzh()) {
            baseGmsClient.zzi(null);
        }
        BaseGmsClient baseGmsClient2 = this.f72101b;
        int i3 = this.f72100a;
        Handler handler = baseGmsClient2.zzb;
        handler.sendMessage(handler.obtainMessage(6, i3, 1));
    }
}
