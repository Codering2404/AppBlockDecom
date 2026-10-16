package com.google.android.gms.tagmanager;

import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.api.Status;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzz implements ContainerHolder {
    private final Looper zza;
    private Container zzb;
    private Container zzc;
    private final Status zzd;
    private zzy zze;
    private zzx zzf;
    private boolean zzg;
    private TagManager zzh;

    public zzz(Status status) {
        this.zzd = status;
        this.zza = null;
    }

    private final void zzf() {
        zzy zzyVar = this.zze;
        if (zzyVar != null) {
            zzyVar.sendMessage(zzyVar.obtainMessage(1, this.zzc.zzc()));
        }
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.zzd;
    }

    public final synchronized void refresh() {
        if (this.zzg) {
            Log.e("GoogleTagManager", "Refreshing a released ContainerHolder.");
        } else {
            this.zzf.zzb();
        }
    }

    @Override // com.google.android.gms.common.api.Releasable
    public final synchronized void release() {
        if (this.zzg) {
            Log.e("GoogleTagManager", "Releasing a released ContainerHolder.");
            return;
        }
        this.zzg = true;
        this.zzh.zzc(this);
        this.zzb.zze();
        this.zzb = null;
        this.zzc = null;
        this.zzf = null;
        this.zze = null;
    }

    final String zza() {
        if (!this.zzg) {
            return this.zzb.getContainerId();
        }
        Log.e("GoogleTagManager", "getContainerId called on a released ContainerHolder.");
        return "";
    }

    final String zzb() {
        if (!this.zzg) {
            return this.zzf.zza();
        }
        Log.e("GoogleTagManager", "setCtfeUrlPathAndQuery called on a released ContainerHolder.");
        return "";
    }

    public final synchronized void zzc(Container container) {
        if (this.zzg) {
            return;
        }
        this.zzc = container;
        zzf();
    }

    public final synchronized void zzd(String str) {
        if (this.zzg) {
            return;
        }
        this.zzb.zzd(str);
    }

    final void zze(String str) {
        if (this.zzg) {
            Log.e("GoogleTagManager", "setCtfeUrlPathAndQuery called on a released ContainerHolder.");
        } else {
            this.zzf.zzc(str);
        }
    }

    public zzz(TagManager tagManager, Looper looper, Container container, zzx zzxVar) {
        this.zzh = tagManager;
        this.zza = looper == null ? Looper.getMainLooper() : looper;
        this.zzb = container;
        this.zzf = zzxVar;
        this.zzd = Status.f71537g;
        tagManager.zza(this);
    }
}
