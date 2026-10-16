package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzain extends zzaim {
    private final zzet zzb;
    private final zzet zzc;
    private int zzd;
    private boolean zze;
    private boolean zzf;
    private int zzg;

    public zzain(zzahk zzahkVar) {
        super(zzahkVar);
        this.zzb = new zzet(zzgp.zza);
        this.zzc = new zzet(4);
    }

    @Override // com.google.android.gms.internal.ads.zzaim
    protected final boolean zza(zzet zzetVar) throws zzail {
        int iZzs = zzetVar.zzs();
        int i3 = iZzs >> 4;
        int i4 = iZzs & 15;
        if (i4 == 7) {
            this.zzg = i3;
            return i3 != 5;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(i4).length() + 28);
        sb.append("Video format not supported: ");
        sb.append(i4);
        throw new zzail(sb.toString());
    }

    @Override // com.google.android.gms.internal.ads.zzaim
    protected final boolean zzb(zzet zzetVar, long j3) throws zzat {
        int i3;
        int iZzs = zzetVar.zzs();
        long jZzy = zzetVar.zzy();
        if (iZzs == 0) {
            if (!this.zze) {
                zzet zzetVar2 = new zzet(new byte[zzetVar.zzd()]);
                zzetVar.zzm(zzetVar2.zzi(), 0, zzetVar.zzd());
                zzafd zzafdVarZza = zzafd.zza(zzetVar2);
                this.zzd = zzafdVarZza.zzb;
                zzt zztVar = new zzt();
                zztVar.zzn("video/x-flv");
                zztVar.zzo("video/avc");
                zztVar.zzk(zzafdVarZza.zzl);
                zztVar.zzv(zzafdVarZza.zzc);
                zztVar.zzw(zzafdVarZza.zzd);
                zztVar.zzB(zzafdVarZza.zzk);
                zztVar.zzr(zzafdVarZza.zza);
                this.zza.zzA(zztVar.zzO());
                this.zze = true;
                return false;
            }
        } else if (iZzs == 1 && this.zze) {
            int i4 = this.zzg == 1 ? 1 : 0;
            if (this.zzf) {
                i3 = i4;
            } else if (i4 != 0) {
                i3 = 1;
            }
            zzet zzetVar3 = this.zzc;
            byte[] bArrZzi = zzetVar3.zzi();
            bArrZzi[0] = 0;
            bArrZzi[1] = 0;
            bArrZzi[2] = 0;
            int i5 = 4 - this.zzd;
            int i6 = 0;
            while (zzetVar.zzd() > 0) {
                zzetVar.zzm(zzetVar3.zzi(), i5, this.zzd);
                zzetVar3.zzh(0);
                zzet zzetVar4 = this.zzb;
                int iZzH = zzetVar3.zzH();
                zzetVar4.zzh(0);
                zzahk zzahkVar = this.zza;
                zzahkVar.zzc(zzetVar4, 4);
                zzahkVar.zzc(zzetVar, iZzH);
                i6 = i6 + 4 + iZzH;
            }
            this.zza.zze(j3 + (jZzy * 1000), i3, i6, 0, null);
            this.zzf = true;
            return true;
        }
        return false;
    }
}
