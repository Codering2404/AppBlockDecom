package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zzp implements Handler.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzq f72122a;

    /* synthetic */ zzp(zzq zzqVar, byte[] bArr) {
        java.util.Objects.requireNonNull(zzqVar);
        this.f72122a = zzqVar;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i3 = message.what;
        if (i3 == 0) {
            zzq zzqVar = this.f72122a;
            synchronized (zzqVar.g()) {
                try {
                    zzn zznVar = (zzn) message.obj;
                    zzo zzoVar = (zzo) zzqVar.g().get(zznVar);
                    if (zzoVar != null && zzoVar.g()) {
                        if (zzoVar.d()) {
                            zzoVar.a("GmsClientSupervisor");
                        }
                        zzqVar.g().remove(zznVar);
                    }
                } finally {
                }
            }
            return true;
        }
        if (i3 != 1) {
            return false;
        }
        zzq zzqVar2 = this.f72122a;
        synchronized (zzqVar2.g()) {
            try {
                zzn zznVar2 = (zzn) message.obj;
                zzo zzoVar2 = (zzo) zzqVar2.g().get(zznVar2);
                if (zzoVar2 != null && zzoVar2.e() == 3) {
                    String strValueOf = String.valueOf(zznVar2);
                    StringBuilder sb = new StringBuilder(strValueOf.length() + 47);
                    sb.append("Timeout waiting for ServiceConnection callback ");
                    sb.append(strValueOf);
                    Log.e("GmsClientSupervisor", sb.toString(), new Exception());
                    ComponentName componentNameI = zzoVar2.i();
                    if (componentNameI == null) {
                        componentNameI = zznVar2.c();
                    }
                    if (componentNameI == null) {
                        String strB = zznVar2.b();
                        Preconditions.m(strB);
                        componentNameI = new ComponentName(strB, "unknown");
                    }
                    zzoVar2.onServiceDisconnected(componentNameI);
                }
            } finally {
            }
        }
        return true;
    }
}
