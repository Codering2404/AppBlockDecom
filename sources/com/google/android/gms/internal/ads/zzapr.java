package com.google.android.gms.internal.ads;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzapr implements zzapt {
    private final zzet zza;
    private final String zzc;
    private final int zzd;
    private String zzf;
    private zzahk zzg;
    private int zzi;
    private int zzj;
    private long zzk;
    private zzv zzl;
    private int zzm;
    private int zzn;
    private int zzh = 0;
    private long zzq = -9223372036854775807L;
    private final AtomicInteger zzb = new AtomicInteger();
    private int zzo = -1;
    private int zzp = -1;
    private final String zze = "video/mp2t";

    public zzapr(String str, int i3, int i4, String str2) {
        this.zza = new zzet(new byte[i4]);
        this.zzc = str;
        this.zzd = i3;
    }

    private final boolean zzf(zzet zzetVar, byte[] bArr, int i3) {
        int iMin = Math.min(zzetVar.zzd(), i3 - this.zzi);
        zzetVar.zzm(bArr, this.zzi, iMin);
        int i4 = this.zzi + iMin;
        this.zzi = i4;
        return i4 == i3;
    }

    @RequiresNonNull
    private final void zzg(zzafw zzafwVar) {
        int i3;
        int i4 = zzafwVar.zzb;
        if (i4 == -2147483647 || (i3 = zzafwVar.zzc) == -1) {
            return;
        }
        zzv zzvVar = this.zzl;
        if (zzvVar != null && i3 == zzvVar.zzH && i4 == zzvVar.zzI && Objects.equals(zzafwVar.zza, zzvVar.zzp)) {
            return;
        }
        zzv zzvVar2 = this.zzl;
        zzt zztVar = zzvVar2 == null ? new zzt() : zzvVar2.zza();
        zztVar.zza(this.zzf);
        zztVar.zzn(this.zze);
        zztVar.zzo(zzafwVar.zza);
        zztVar.zzG(i3);
        zztVar.zzH(i4);
        zztVar.zze(this.zzc);
        zztVar.zzg(this.zzd);
        zzv zzvVarZzO = zztVar.zzO();
        this.zzl = zzvVarZzO;
        this.zzg.zzA(zzvVarZzO);
    }

    @Override // com.google.android.gms.internal.ads.zzapt
    public final void zza() {
        this.zzh = 0;
        this.zzi = 0;
        this.zzj = 0;
        this.zzq = -9223372036854775807L;
        this.zzb.set(0);
    }

    @Override // com.google.android.gms.internal.ads.zzapt
    public final void zzb(zzagb zzagbVar, zzarh zzarhVar) {
        zzarhVar.zza();
        this.zzf = zzarhVar.zzc();
        this.zzg = zzagbVar.zzu(zzarhVar.zzb(), 1);
    }

    @Override // com.google.android.gms.internal.ads.zzapt
    public final void zzc(long j3, int i3) {
        this.zzq = j3;
    }

    @Override // com.google.android.gms.internal.ads.zzapt
    public final void zzd(zzet zzetVar) throws zzat {
        int i3;
        byte b3;
        int i4;
        byte b4;
        this.zzg.getClass();
        while (zzetVar.zzd() > 0) {
            int i5 = this.zzh;
            if (i5 == 0) {
                while (true) {
                    if (zzetVar.zzd() > 0) {
                        int i6 = this.zzj << 8;
                        this.zzj = i6;
                        int iZzs = i6 | zzetVar.zzs();
                        this.zzj = iZzs;
                        int iZza = zzafx.zza(iZzs);
                        this.zzn = iZza;
                        if (iZza != 0) {
                            byte[] bArrZzi = this.zza.zzi();
                            int i7 = this.zzj;
                            bArrZzi[0] = (byte) ((i7 >> 24) & 255);
                            bArrZzi[1] = (byte) ((i7 >> 16) & 255);
                            bArrZzi[2] = (byte) ((i7 >> 8) & 255);
                            bArrZzi[3] = (byte) (i7 & 255);
                            this.zzi = 4;
                            this.zzj = 0;
                            int i8 = this.zzn;
                            if (i8 == 3 || i8 == 4) {
                                this.zzh = 4;
                            } else if (i8 == 1) {
                                this.zzh = 1;
                            } else {
                                this.zzh = 2;
                            }
                        }
                    }
                }
            } else if (i5 == 1) {
                zzet zzetVar2 = this.zza;
                if (zzf(zzetVar, zzetVar2.zzi(), 18)) {
                    byte[] bArrZzi2 = zzetVar2.zzi();
                    if (this.zzl == null) {
                        zzv zzvVarZzb = zzafx.zzb(bArrZzi2, this.zzf, this.zzc, this.zzd, this.zze, null);
                        this.zzl = zzvVarZzb;
                        this.zzg.zzA(zzvVarZzb);
                    }
                    this.zzm = zzafx.zzc(bArrZzi2);
                    byte b5 = bArrZzi2[0];
                    if (b5 != -2) {
                        if (b5 == -1) {
                            i3 = (bArrZzi2[4] & 7) << 4;
                            b4 = bArrZzi2[7];
                        } else if (b5 != 31) {
                            i3 = (bArrZzi2[4] & 1) << 6;
                            b3 = bArrZzi2[5];
                        } else {
                            i3 = (bArrZzi2[5] & 7) << 4;
                            b4 = bArrZzi2[6];
                        }
                        i4 = b4 & 60;
                        this.zzk = zzhah.zza(zzfl.zzt(((i3 | (i4 >> 2)) + 1) * 32, this.zzl.zzI));
                        zzetVar2.zzh(0);
                        this.zzg.zzc(zzetVar2, 18);
                        this.zzh = 6;
                    } else {
                        i3 = (bArrZzi2[5] & 1) << 6;
                        b3 = bArrZzi2[4];
                    }
                    i4 = b3 & 252;
                    this.zzk = zzhah.zza(zzfl.zzt(((i3 | (i4 >> 2)) + 1) * 32, this.zzl.zzI));
                    zzetVar2.zzh(0);
                    this.zzg.zzc(zzetVar2, 18);
                    this.zzh = 6;
                }
            } else if (i5 != 2) {
                if (i5 == 3) {
                    zzet zzetVar3 = this.zza;
                    if (zzf(zzetVar, zzetVar3.zzi(), this.zzo)) {
                        zzafw zzafwVarZzd = zzafx.zzd(zzetVar3.zzi());
                        zzg(zzafwVarZzd);
                        this.zzm = zzafwVarZzd.zzd;
                        long j3 = zzafwVarZzd.zze;
                        this.zzk = j3 != -9223372036854775807L ? j3 : 0L;
                        zzetVar3.zzh(0);
                        this.zzg.zzc(zzetVar3, this.zzo);
                        this.zzh = 6;
                    }
                } else if (i5 == 4) {
                    zzet zzetVar4 = this.zza;
                    if (zzf(zzetVar, zzetVar4.zzi(), 6)) {
                        int iZzg = zzafx.zzg(zzetVar4.zzi());
                        this.zzp = iZzg;
                        int i9 = this.zzi;
                        if (i9 > iZzg) {
                            int i10 = i9 - iZzg;
                            this.zzi = i9 - i10;
                            zzetVar.zzh(zzetVar.zzg() - i10);
                        }
                        this.zzh = 5;
                    }
                } else if (i5 != 5) {
                    int iMin = Math.min(zzetVar.zzd(), this.zzm - this.zzi);
                    this.zzg.zzc(zzetVar, iMin);
                    int i11 = this.zzi + iMin;
                    this.zzi = i11;
                    if (i11 == this.zzm) {
                        zzgtj.zzi(this.zzq != -9223372036854775807L);
                        this.zzg.zze(this.zzq, this.zzn == 4 ? 0 : 1, this.zzm, 0, null);
                        this.zzq += this.zzk;
                        this.zzh = 0;
                    }
                } else {
                    zzet zzetVar5 = this.zza;
                    if (zzf(zzetVar, zzetVar5.zzi(), this.zzp)) {
                        zzafw zzafwVarZzf = zzafx.zzf(zzetVar5.zzi(), this.zzb);
                        if (this.zzn == 3) {
                            zzg(zzafwVarZzf);
                        }
                        this.zzm = zzafwVarZzf.zzd;
                        long j4 = zzafwVarZzf.zze;
                        this.zzk = j4 != -9223372036854775807L ? j4 : 0L;
                        zzetVar5.zzh(0);
                        this.zzg.zzc(zzetVar5, this.zzp);
                        this.zzh = 6;
                    }
                }
            } else {
                zzet zzetVar6 = this.zza;
                if (zzf(zzetVar, zzetVar6.zzi(), 7)) {
                    this.zzo = zzafx.zze(zzetVar6.zzi());
                    this.zzh = 3;
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzapt
    public final void zze(boolean z2) {
    }
}
