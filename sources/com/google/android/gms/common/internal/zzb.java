package com.google.android.gms.common.internal;

import android.app.PendingIntent;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zzb extends com.google.android.gms.internal.common.zzg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ BaseGmsClient f72094a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzb(BaseGmsClient baseGmsClient, Looper looper) {
        super(looper);
        java.util.Objects.requireNonNull(baseGmsClient);
        this.f72094a = baseGmsClient;
    }

    private static final void a(Message message) {
        zzc zzcVar = (zzc) message.obj;
        if (zzcVar != null) {
            zzcVar.c();
        }
    }

    private static final boolean b(Message message) {
        int i3 = message.what;
        return i3 == 2 || i3 == 1 || i3 == 7;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        BaseGmsClient baseGmsClient = this.f72094a;
        if (baseGmsClient.zzd.get() != message.arg1) {
            if (b(message)) {
                a(message);
                return;
            }
            return;
        }
        int i3 = message.what;
        if ((i3 == 1 || i3 == 7 || ((i3 == 4 && !baseGmsClient.enableLocalFallback()) || message.what == 5)) && !baseGmsClient.isConnecting()) {
            a(message);
            return;
        }
        int i4 = message.what;
        if (i4 == 4) {
            baseGmsClient.zzn(new ConnectionResult(message.arg2));
            if (baseGmsClient.zzg() && !baseGmsClient.zzo()) {
                baseGmsClient.zzd(3, null);
                return;
            }
            ConnectionResult connectionResultZzm = baseGmsClient.zzm() != null ? baseGmsClient.zzm() : new ConnectionResult(8);
            baseGmsClient.zzc.a(connectionResultZzm);
            baseGmsClient.onConnectionFailed(connectionResultZzm);
            return;
        }
        if (i4 == 5) {
            ConnectionResult connectionResultZzm2 = baseGmsClient.zzm() != null ? baseGmsClient.zzm() : new ConnectionResult(8);
            baseGmsClient.zzc.a(connectionResultZzm2);
            baseGmsClient.onConnectionFailed(connectionResultZzm2);
            return;
        }
        if (i4 == 3) {
            Object obj = message.obj;
            ConnectionResult connectionResult = new ConnectionResult(message.arg2, obj instanceof PendingIntent ? (PendingIntent) obj : null);
            baseGmsClient.zzc.a(connectionResult);
            baseGmsClient.onConnectionFailed(connectionResult);
            return;
        }
        if (i4 == 6) {
            baseGmsClient.zzd(5, null);
            if (baseGmsClient.zzk() != null) {
                baseGmsClient.zzk().onConnectionSuspended(message.arg2);
            }
            baseGmsClient.onConnectionSuspended(message.arg2);
            baseGmsClient.zze(5, 1, null);
            return;
        }
        if (i4 == 2 && !baseGmsClient.isConnected()) {
            a(message);
            return;
        }
        if (b(message)) {
            ((zzc) message.obj).b();
            return;
        }
        int i5 = message.what;
        StringBuilder sb = new StringBuilder(String.valueOf(i5).length() + 34);
        sb.append("Don't know how to handle message: ");
        sb.append(i5);
        Log.wtf("GmsClient", sb.toString(), new Exception());
    }
}
