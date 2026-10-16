package com.google.android.gms.cloudmessaging;

import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zzq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Messenger f71413a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzd f71414b;

    zzq(IBinder iBinder) throws RemoteException {
        String interfaceDescriptor = iBinder.getInterfaceDescriptor();
        if (Objects.equals(interfaceDescriptor, "android.os.IMessenger")) {
            this.f71413a = new Messenger(iBinder);
            this.f71414b = null;
        } else {
            if (!Objects.equals(interfaceDescriptor, "com.google.android.gms.iid.IMessengerCompat")) {
                Log.w("MessengerIpcClient", "Invalid interface descriptor: ".concat(String.valueOf(interfaceDescriptor)));
                throw new RemoteException();
            }
            this.f71414b = new zzd(iBinder);
            this.f71413a = null;
        }
    }

    final void a(Message message) throws RemoteException {
        Messenger messenger = this.f71413a;
        if (messenger != null) {
            messenger.send(message);
            return;
        }
        zzd zzdVar = this.f71414b;
        if (zzdVar == null) {
            throw new IllegalStateException("Both messengers are null");
        }
        zzdVar.d(message);
    }
}
