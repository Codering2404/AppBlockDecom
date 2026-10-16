package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zztg extends zzcp {
    private zzhaf zzd;
    private zzhaf zze;

    /* JADX WARN: Removed duplicated region for block: B:28:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0123  */
    @Override // com.google.android.gms.internal.ads.zzco
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzd(java.nio.ByteBuffer r15) {
        /*
            Method dump skipped, instruction units count: 316
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zztg.zzd(java.nio.ByteBuffer):void");
    }

    @Override // com.google.android.gms.internal.ads.zzcp
    public final zzcl zzm(zzcl zzclVar) throws zzcn {
        zzhaf zzhafVar = this.zzd;
        if (zzhafVar == null) {
            return zzcl.zza;
        }
        int i3 = zzclVar.zzd;
        if (!zzfl.zzD(i3)) {
            throw new zzcn("Unhandled input format:", zzclVar);
        }
        int iZzh = zzhafVar.zzh();
        int i4 = zzclVar.zzc;
        boolean z2 = i4 != iZzh;
        int i5 = 0;
        while (i5 < iZzh) {
            int iZzi = zzhafVar.zzi(i5);
            if (iZzi >= i4) {
                String string = zzhafVar.toString();
                StringBuilder sb = new StringBuilder(string.length() + 59);
                sb.append("Channel map (");
                sb.append(string);
                sb.append(") trying to access non-existent input channel.");
                throw new zzcn(sb.toString(), zzclVar);
            }
            z2 |= iZzi != i5;
            i5++;
        }
        return z2 ? new zzcl(zzclVar.zzb, iZzh, i3) : zzcl.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzcp
    protected final void zzo(zzcm zzcmVar) {
        this.zze = this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzcp
    protected final void zzp() {
        this.zze = null;
        this.zzd = null;
    }

    public final void zzq(zzhaf zzhafVar) {
        this.zzd = zzhafVar;
    }
}
