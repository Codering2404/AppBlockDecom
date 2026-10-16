package com.google.android.gms.internal.ads;

import com.facebook.internal.NativeProtocol;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzabr implements zzabl {
    private int zza;
    private int zzb;
    private int zzc = 0;
    private zzabj[] zzd = new zzabj[100];

    public zzabr(boolean z2, int i3) {
    }

    @Override // com.google.android.gms.internal.ads.zzabl
    public final synchronized zzabj zza() {
        zzabj zzabjVar;
        try {
            this.zzb++;
            int i3 = this.zzc;
            if (i3 > 0) {
                zzabj[] zzabjVarArr = this.zzd;
                int i4 = i3 - 1;
                this.zzc = i4;
                zzabjVar = zzabjVarArr[i4];
                if (zzabjVar == null) {
                    throw null;
                }
                zzabjVarArr[i4] = null;
            } else {
                zzabjVar = new zzabj(new byte[NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST], 0);
                int i5 = this.zzb;
                zzabj[] zzabjVarArr2 = this.zzd;
                int length = zzabjVarArr2.length;
                if (i5 > length) {
                    this.zzd = (zzabj[]) Arrays.copyOf(zzabjVarArr2, length + length);
                    return zzabjVar;
                }
            }
            return zzabjVar;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzabl
    public final synchronized void zzb(zzabj zzabjVar) {
        zzabj[] zzabjVarArr = this.zzd;
        int i3 = this.zzc;
        this.zzc = i3 + 1;
        zzabjVarArr[i3] = zzabjVar;
        this.zzb--;
    }

    @Override // com.google.android.gms.internal.ads.zzabl
    public final synchronized void zzc(zzabk zzabkVar) {
        while (zzabkVar != null) {
            zzabj[] zzabjVarArr = this.zzd;
            int i3 = this.zzc;
            this.zzc = i3 + 1;
            zzabjVarArr[i3] = zzabkVar.zzd();
            this.zzb--;
            zzabkVar = zzabkVar.zze();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzabl
    public final synchronized void zzd() {
        int i3 = this.zza;
        String str = zzfl.zza;
        int iMax = Math.max(0, ((i3 + 65535) / NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) - this.zzb);
        int i4 = this.zzc;
        if (iMax >= i4) {
            return;
        }
        Arrays.fill(this.zzd, iMax, i4, (Object) null);
        this.zzc = iMax;
    }

    public final synchronized void zze() {
        zzf(0);
    }

    public final synchronized void zzf(int i3) {
        int i4 = this.zza;
        this.zza = i3;
        if (i3 < i4) {
            zzd();
        }
    }

    public final synchronized int zzg() {
        return this.zzb * NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
    }

    public final synchronized int zzh() {
        return this.zzc * NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
    }
}
