package com.google.android.gms.internal.ads;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.applovin.impl.privacy.consentFlow.as.KLAQHFCRAUejH;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzary implements ServiceConnection {
    final /* synthetic */ zzarz zza;
    private final zzasa zzb;

    /* synthetic */ zzary(zzarz zzarzVar, zzasa zzasaVar, byte[] bArr) {
        Objects.requireNonNull(zzarzVar);
        this.zza = zzarzVar;
        this.zzb = zzasaVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        zzasc.zzb("InstallReferrerClient", "Install Referrer service disconnected.");
        zzarz zzarzVar = this.zza;
        zzarzVar.zzf(null);
        zzarzVar.zze(0);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        zzasc.zza("InstallReferrerClient", KLAQHFCRAUejH.xxgdqold);
        zzarz zzarzVar = this.zza;
        zzarzVar.zzf(zzbei.zzb(iBinder));
        zzarzVar.zze(2);
        this.zzb.zza(0);
    }
}
