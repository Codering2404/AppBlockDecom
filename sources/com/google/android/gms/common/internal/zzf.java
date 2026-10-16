package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzf extends zza {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final IBinder f72102g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ BaseGmsClient f72103h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzf(BaseGmsClient baseGmsClient, int i3, IBinder iBinder, Bundle bundle) {
        super(baseGmsClient, i3, bundle);
        java.util.Objects.requireNonNull(baseGmsClient);
        this.f72103h = baseGmsClient;
        this.f72102g = iBinder;
    }

    @Override // com.google.android.gms.common.internal.zza
    protected final boolean e() {
        try {
            IBinder iBinder = this.f72102g;
            Preconditions.m(iBinder);
            String interfaceDescriptor = iBinder.getInterfaceDescriptor();
            BaseGmsClient baseGmsClient = this.f72103h;
            if (!baseGmsClient.getServiceDescriptor().equals(interfaceDescriptor)) {
                String serviceDescriptor = baseGmsClient.getServiceDescriptor();
                StringBuilder sb = new StringBuilder(String.valueOf(serviceDescriptor).length() + 34 + String.valueOf(interfaceDescriptor).length());
                sb.append("service descriptor mismatch: ");
                sb.append(serviceDescriptor);
                sb.append(" vs. ");
                sb.append(interfaceDescriptor);
                Log.w("GmsClient", sb.toString());
                return false;
            }
            IInterface iInterfaceCreateServiceInterface = baseGmsClient.createServiceInterface(this.f72102g);
            if (iInterfaceCreateServiceInterface == null || !(baseGmsClient.zze(2, 4, iInterfaceCreateServiceInterface) || baseGmsClient.zze(3, 4, iInterfaceCreateServiceInterface))) {
                return false;
            }
            baseGmsClient.zzn(null);
            BaseGmsClient.BaseConnectionCallbacks baseConnectionCallbacksZzk = baseGmsClient.zzk();
            Bundle connectionHint = baseGmsClient.getConnectionHint();
            if (baseConnectionCallbacksZzk == null) {
                return true;
            }
            baseGmsClient.zzk().onConnected(connectionHint);
            return true;
        } catch (RemoteException unused) {
            Log.w("GmsClient", "service probably died");
            return false;
        }
    }

    @Override // com.google.android.gms.common.internal.zza
    protected final void f(ConnectionResult connectionResult) {
        BaseGmsClient baseGmsClient = this.f72103h;
        if (baseGmsClient.zzl() != null) {
            baseGmsClient.zzl().onConnectionFailed(connectionResult);
        }
        baseGmsClient.onConnectionFailed(connectionResult);
    }
}
