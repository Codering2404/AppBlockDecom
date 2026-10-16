package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaqf implements zzapt {
    private final zzet zza;
    private final zzagv zzb;
    private final String zzc;
    private final int zzd;
    private final String zze;
    private zzahk zzf;
    private String zzg;
    private int zzh = 0;
    private int zzi;
    private boolean zzj;
    private boolean zzk;
    private long zzl;
    private int zzm;
    private long zzn;

    public zzaqf(String str, int i3, String str2) {
        zzet zzetVar = new zzet(4);
        this.zza = zzetVar;
        zzetVar.zzi()[0] = -1;
        this.zzb = new zzagv();
        this.zzn = -9223372036854775807L;
        this.zzc = str;
        this.zzd = i3;
        this.zze = str2;
    }

    @Override // com.google.android.gms.internal.ads.zzapt
    public final void zza() {
        this.zzh = 0;
        this.zzi = 0;
        this.zzk = false;
        this.zzn = -9223372036854775807L;
    }

    @Override // com.google.android.gms.internal.ads.zzapt
    public final void zzb(zzagb zzagbVar, zzarh zzarhVar) {
        zzarhVar.zza();
        this.zzg = zzarhVar.zzc();
        this.zzf = zzagbVar.zzu(zzarhVar.zzb(), 1);
    }

    @Override // com.google.android.gms.internal.ads.zzapt
    public final void zzc(long j3, int i3) {
        this.zzn = j3;
    }

    @Override // com.google.android.gms.internal.ads.zzapt
    public final void zzd(zzet zzetVar) {
        this.zzf.getClass();
        while (zzetVar.zzd() > 0) {
            int i3 = this.zzh;
            if (i3 == 0) {
                byte[] bArrZzi = zzetVar.zzi();
                int iZzg = zzetVar.zzg();
                int iZze = zzetVar.zze();
                while (true) {
                    if (iZzg >= iZze) {
                        zzetVar.zzh(iZze);
                        break;
                    }
                    int i4 = iZzg + 1;
                    byte b3 = bArrZzi[iZzg];
                    boolean z2 = (b3 & 255) == 255;
                    boolean z3 = this.zzk && (b3 & 224) == 224;
                    this.zzk = z2;
                    if (z3) {
                        zzetVar.zzh(i4);
                        this.zzk = false;
                        this.zza.zzi()[1] = bArrZzi[iZzg];
                        this.zzi = 2;
                        this.zzh = 1;
                        break;
                    }
                    iZzg = i4;
                }
            } else if (i3 != 1) {
                int iMin = Math.min(zzetVar.zzd(), this.zzm - this.zzi);
                this.zzf.zzc(zzetVar, iMin);
                int i5 = this.zzi + iMin;
                this.zzi = i5;
                if (i5 >= this.zzm) {
                    zzgtj.zzi(this.zzn != -9223372036854775807L);
                    this.zzf.zze(this.zzn, 1, this.zzm, 0, null);
                    this.zzn += this.zzl;
                    this.zzi = 0;
                    this.zzh = 0;
                }
            } else {
                int iMin2 = Math.min(zzetVar.zzd(), 4 - this.zzi);
                zzet zzetVar2 = this.zza;
                zzetVar.zzm(zzetVar2.zzi(), this.zzi, iMin2);
                int i6 = this.zzi + iMin2;
                this.zzi = i6;
                if (i6 >= 4) {
                    zzetVar2.zzh(0);
                    zzagv zzagvVar = this.zzb;
                    if (zzagvVar.zza(zzetVar2.zzB())) {
                        this.zzm = zzagvVar.zzc;
                        if (!this.zzj) {
                            this.zzl = (((long) zzagvVar.zzg) * 1000000) / ((long) zzagvVar.zzd);
                            zzt zztVar = new zzt();
                            zztVar.zza(this.zzg);
                            zztVar.zzn(this.zze);
                            zztVar.zzo(zzagvVar.zzb);
                            zztVar.zzp(4096);
                            zztVar.zzG(zzagvVar.zze);
                            zztVar.zzH(zzagvVar.zzd);
                            zztVar.zze(this.zzc);
                            zztVar.zzg(this.zzd);
                            this.zzf.zzA(zztVar.zzO());
                            this.zzj = true;
                        }
                        zzetVar2.zzh(0);
                        this.zzf.zzc(zzetVar2, 4);
                        this.zzh = 2;
                    } else {
                        this.zzi = 0;
                        this.zzh = 1;
                    }
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzapt
    public final void zze(boolean z2) {
    }
}
