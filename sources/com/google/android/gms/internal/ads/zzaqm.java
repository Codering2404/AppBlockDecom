package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaqm implements zzari {
    private final zzapt zza;
    private final zzes zzb = new zzes(new byte[10], 10);
    private int zzc = 0;
    private int zzd;
    private zzfi zze;
    private boolean zzf;
    private boolean zzg;
    private boolean zzh;
    private int zzi;
    private int zzj;
    private boolean zzk;

    public zzaqm(zzapt zzaptVar) {
        this.zza = zzaptVar;
    }

    private final void zze(int i3) {
        this.zzc = i3;
        this.zzd = 0;
    }

    private final boolean zzf(zzet zzetVar, byte[] bArr, int i3) {
        int iMin = Math.min(zzetVar.zzd(), i3 - this.zzd);
        if (iMin <= 0) {
            return true;
        }
        if (bArr == null) {
            zzetVar.zzk(iMin);
        } else {
            zzetVar.zzm(bArr, this.zzd, iMin);
        }
        int i4 = this.zzd + iMin;
        this.zzd = i4;
        return i4 == i3;
    }

    @Override // com.google.android.gms.internal.ads.zzari
    public final void zza(zzfi zzfiVar, zzagb zzagbVar, zzarh zzarhVar) {
        this.zze = zzfiVar;
        this.zza.zzb(zzagbVar, zzarhVar);
    }

    @Override // com.google.android.gms.internal.ads.zzari
    public final void zzb() {
        this.zzc = 0;
        this.zzd = 0;
        this.zzh = false;
        this.zza.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzari
    public final void zzc(zzet zzetVar, int i3) throws zzat {
        int i4;
        int i5;
        long jZze;
        long j3;
        this.zze.getClass();
        int i6 = -1;
        int i7 = 2;
        if ((i3 & 1) != 0) {
            int i8 = this.zzc;
            if (i8 != 0 && i8 != 1) {
                if (i8 != 2) {
                    int i9 = this.zzj;
                    if (i9 != -1) {
                        StringBuilder sb = new StringBuilder(String.valueOf(i9).length() + 48);
                        sb.append("Unexpected start indicator: expected ");
                        sb.append(i9);
                        sb.append(" more bytes");
                        zzeg.zzc("PesReader", sb.toString());
                    }
                    this.zza.zze(zzetVar.zze() == 0);
                } else {
                    zzeg.zzc("PesReader", "Unexpected start indicator reading extended header");
                }
            }
            zze(1);
        }
        int i10 = i3;
        while (zzetVar.zzd() > 0) {
            int i11 = this.zzc;
            if (i11 == 0) {
                i4 = i7;
                zzetVar.zzk(zzetVar.zzd());
            } else if (i11 != 1) {
                if (i11 != i7) {
                    int iZzd = zzetVar.zzd();
                    int i12 = this.zzj;
                    int i13 = i12 == i6 ? 0 : iZzd - i12;
                    if (i13 > 0) {
                        iZzd -= i13;
                        zzetVar.zzf(zzetVar.zzg() + iZzd);
                    }
                    zzapt zzaptVar = this.zza;
                    zzaptVar.zzd(zzetVar);
                    int i14 = this.zzj;
                    if (i14 != i6) {
                        int i15 = i14 - iZzd;
                        this.zzj = i15;
                        if (i15 == 0) {
                            zzaptVar.zze(false);
                            zze(1);
                        }
                    }
                } else {
                    int iMin = Math.min(10, this.zzi);
                    zzes zzesVar = this.zzb;
                    if (zzf(zzetVar, zzesVar.zza, iMin) && zzf(zzetVar, null, this.zzi)) {
                        zzesVar.zzf(0);
                        if (this.zzf) {
                            zzesVar.zzh(4);
                            long jZzj = zzesVar.zzj(3);
                            zzesVar.zzh(1);
                            int iZzj = zzesVar.zzj(15) << 15;
                            zzesVar.zzh(1);
                            long jZzj2 = zzesVar.zzj(15);
                            zzesVar.zzh(1);
                            if (this.zzh || !this.zzg) {
                                j3 = jZzj;
                            } else {
                                zzesVar.zzh(4);
                                j3 = jZzj;
                                long jZzj3 = ((long) zzesVar.zzj(3)) << 30;
                                zzesVar.zzh(1);
                                int iZzj2 = zzesVar.zzj(15) << 15;
                                zzesVar.zzh(1);
                                long jZzj4 = zzesVar.zzj(15);
                                zzesVar.zzh(1);
                                this.zze.zze(jZzj3 | ((long) iZzj2) | jZzj4);
                                this.zzh = true;
                            }
                            jZze = this.zze.zze(jZzj2 | (j3 << 30) | ((long) iZzj));
                        } else {
                            jZze = -9223372036854775807L;
                        }
                        i10 |= true != this.zzk ? 0 : 4;
                        this.zza.zzc(jZze, i10);
                        zze(3);
                        i6 = -1;
                        i7 = 2;
                    }
                }
                i4 = i7;
            } else {
                zzes zzesVar2 = this.zzb;
                if (zzf(zzetVar, zzesVar2.zza, 9)) {
                    zzesVar2.zzf(0);
                    int iZzj3 = zzesVar2.zzj(24);
                    if (iZzj3 != 1) {
                        StringBuilder sb2 = new StringBuilder(String.valueOf(iZzj3).length() + 30);
                        sb2.append("Unexpected start code prefix: ");
                        sb2.append(iZzj3);
                        zzeg.zzc("PesReader", sb2.toString());
                        i6 = -1;
                        this.zzj = -1;
                        i5 = 0;
                        i4 = 2;
                    } else {
                        zzesVar2.zzh(8);
                        int iZzj4 = zzesVar2.zzj(16);
                        zzesVar2.zzh(5);
                        this.zzk = zzesVar2.zzi();
                        i4 = 2;
                        zzesVar2.zzh(2);
                        this.zzf = zzesVar2.zzi();
                        this.zzg = zzesVar2.zzi();
                        zzesVar2.zzh(6);
                        int iZzj5 = zzesVar2.zzj(8);
                        this.zzi = iZzj5;
                        if (iZzj4 == 0) {
                            this.zzj = -1;
                            i6 = -1;
                        } else {
                            int i16 = (iZzj4 - 3) - iZzj5;
                            this.zzj = i16;
                            if (i16 < 0) {
                                StringBuilder sb3 = new StringBuilder(String.valueOf(i16).length() + 36);
                                sb3.append("Found negative packet payload size: ");
                                sb3.append(i16);
                                zzeg.zzc("PesReader", sb3.toString());
                                i6 = -1;
                                this.zzj = -1;
                            } else {
                                i6 = -1;
                            }
                        }
                        i5 = 2;
                    }
                    zze(i5);
                } else {
                    i6 = -1;
                    i4 = 2;
                }
            }
            i7 = i4;
        }
    }

    public final boolean zzd(boolean z2) {
        return this.zzc == 3 && this.zzj == -1;
    }
}
