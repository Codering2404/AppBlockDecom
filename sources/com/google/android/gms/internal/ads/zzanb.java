package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzanb extends zzamz {
    private zzana zza;
    private int zzb;
    private boolean zzc;
    private zzhd zzd;
    private zzhb zze;

    zzanb() {
    }

    @Override // com.google.android.gms.internal.ads.zzamz
    protected final void zza(boolean z2) {
        super.zza(z2);
        if (z2) {
            this.zza = null;
            this.zzd = null;
            this.zze = null;
        }
        this.zzb = 0;
        this.zzc = false;
    }

    @Override // com.google.android.gms.internal.ads.zzamz
    protected final long zzb(zzet zzetVar) {
        if ((zzetVar.zzi()[0] & 1) == 1) {
            return -1L;
        }
        zzana zzanaVar = this.zza;
        zzanaVar.getClass();
        byte b3 = zzetVar.zzi()[0];
        zzhd zzhdVar = zzanaVar.zza;
        zzhc[] zzhcVarArr = zzanaVar.zzd;
        int i3 = zzhcVarArr[(b3 >> 1) & (255 >>> (8 - zzhe.zza(zzhcVarArr.length + (-1))))].zza ? zzhdVar.zzf : zzhdVar.zze;
        int i4 = this.zzc ? (this.zzb + i3) / 4 : 0;
        if (zzetVar.zzj() < zzetVar.zze() + 4) {
            byte[] bArrCopyOf = Arrays.copyOf(zzetVar.zzi(), zzetVar.zze() + 4);
            zzetVar.zzb(bArrCopyOf, bArrCopyOf.length);
        } else {
            zzetVar.zzf(zzetVar.zze() + 4);
        }
        long j3 = i4;
        byte[] bArrZzi = zzetVar.zzi();
        bArrZzi[zzetVar.zze() - 4] = (byte) (j3 & 255);
        bArrZzi[zzetVar.zze() - 3] = (byte) ((j3 >>> 8) & 255);
        bArrZzi[zzetVar.zze() - 2] = (byte) ((j3 >>> 16) & 255);
        bArrZzi[zzetVar.zze() - 1] = (byte) ((j3 >>> 24) & 255);
        this.zzc = true;
        this.zzb = i3;
        return j3;
    }

    @Override // com.google.android.gms.internal.ads.zzamz
    @EnsuresNonNullIf
    protected final boolean zzc(zzet zzetVar, long j3, zzamx zzamxVar) throws IOException {
        zzana zzanaVar;
        int i3;
        int iZzb;
        int i4;
        int[] iArr;
        int i5;
        long jFloor;
        if (this.zza != null) {
            zzamxVar.zza.getClass();
            return false;
        }
        zzhd zzhdVar = this.zzd;
        int i6 = 1;
        if (zzhdVar == null) {
            zzhe.zzc(1, zzetVar, false);
            int iZzI = zzetVar.zzI();
            int iZzs = zzetVar.zzs();
            int iZzI2 = zzetVar.zzI();
            int iZzC = zzetVar.zzC();
            int i7 = iZzC <= 0 ? -1 : iZzC;
            int iZzC2 = zzetVar.zzC();
            int i8 = iZzC2 <= 0 ? -1 : iZzC2;
            int iZzC3 = zzetVar.zzC();
            int i9 = iZzC3 <= 0 ? -1 : iZzC3;
            int iZzs2 = zzetVar.zzs();
            this.zzd = new zzhd(iZzI, iZzs, iZzI2, i7, i8, i9, (int) Math.pow(2.0d, iZzs2 & 15), (int) Math.pow(2.0d, (iZzs2 & 240) >> 4), 1 == (zzetVar.zzs() & 1), Arrays.copyOf(zzetVar.zzi(), zzetVar.zze()));
        } else {
            int i10 = 4;
            zzhb zzhbVar = this.zze;
            if (zzhbVar == null) {
                this.zze = zzhe.zzb(zzetVar, true, true);
            } else {
                byte[] bArr = new byte[zzetVar.zze()];
                System.arraycopy(zzetVar.zzi(), 0, bArr, 0, zzetVar.zze());
                int i11 = zzhdVar.zza;
                int i12 = 5;
                zzhe.zzc(5, zzetVar, false);
                int iZzs3 = zzetVar.zzs() + 1;
                zzha zzhaVar = new zzha(zzetVar.zzi());
                zzhaVar.zzc(zzetVar.zzg() * 8);
                int i13 = 0;
                while (true) {
                    int i14 = 2;
                    int i15 = 16;
                    if (i13 >= iZzs3) {
                        int i16 = i6;
                        int i17 = 6;
                        int iZzb2 = zzhaVar.zzb(6) + i16;
                        for (int i18 = 0; i18 < iZzb2; i18++) {
                            if (zzhaVar.zzb(16) != 0) {
                                throw zzat.zzb("placeholder of time domain transforms not zeroed out", null);
                            }
                        }
                        int iZzb3 = zzhaVar.zzb(6) + i16;
                        int i19 = 0;
                        while (true) {
                            int i20 = 3;
                            if (i19 < iZzb3) {
                                int iZzb4 = zzhaVar.zzb(i15);
                                if (iZzb4 == 0) {
                                    int i21 = 8;
                                    zzhaVar.zzc(8);
                                    zzhaVar.zzc(16);
                                    zzhaVar.zzc(16);
                                    zzhaVar.zzc(6);
                                    zzhaVar.zzc(8);
                                    int iZzb5 = zzhaVar.zzb(4) + 1;
                                    int i22 = 0;
                                    while (i22 < iZzb5) {
                                        zzhaVar.zzc(i21);
                                        i22++;
                                        i21 = 8;
                                    }
                                } else {
                                    if (iZzb4 != i16) {
                                        StringBuilder sb = new StringBuilder(String.valueOf(iZzb4).length() + 41);
                                        sb.append("floor type greater than 1 not decodable: ");
                                        sb.append(iZzb4);
                                        throw zzat.zzb(sb.toString(), null);
                                    }
                                    int iZzb6 = zzhaVar.zzb(5);
                                    int[] iArr2 = new int[iZzb6];
                                    int i23 = -1;
                                    for (int i24 = 0; i24 < iZzb6; i24++) {
                                        int iZzb7 = zzhaVar.zzb(4);
                                        iArr2[i24] = iZzb7;
                                        if (iZzb7 > i23) {
                                            i23 = iZzb7;
                                        }
                                    }
                                    int i25 = i23 + 1;
                                    int[] iArr3 = new int[i25];
                                    int i26 = 0;
                                    while (i26 < i25) {
                                        int i27 = 1;
                                        iArr3[i26] = zzhaVar.zzb(i20) + 1;
                                        int iZzb8 = zzhaVar.zzb(2);
                                        if (iZzb8 > 0) {
                                            i4 = 8;
                                            zzhaVar.zzc(8);
                                        } else {
                                            i4 = 8;
                                        }
                                        int i28 = i25;
                                        int i29 = 0;
                                        while (true) {
                                            int i30 = i27 << iZzb8;
                                            iArr = iArr2;
                                            if (i29 < i30) {
                                                zzhaVar.zzc(i4);
                                                i29++;
                                                iArr2 = iArr;
                                                i4 = 8;
                                                i27 = 1;
                                            }
                                        }
                                        i26++;
                                        iArr2 = iArr;
                                        i25 = i28;
                                        i20 = 3;
                                    }
                                    int[] iArr4 = iArr2;
                                    zzhaVar.zzc(2);
                                    int iZzb9 = zzhaVar.zzb(4);
                                    int i31 = 0;
                                    int i32 = 0;
                                    for (int i33 = 0; i33 < iZzb6; i33++) {
                                        i31 += iArr3[iArr4[i33]];
                                        while (i32 < i31) {
                                            zzhaVar.zzc(iZzb9);
                                            i32++;
                                        }
                                    }
                                }
                                i19++;
                                i17 = 6;
                                i15 = 16;
                                i16 = 1;
                            } else {
                                int i34 = 1;
                                int iZzb10 = zzhaVar.zzb(i17) + 1;
                                int i35 = 0;
                                while (i35 < iZzb10) {
                                    if (zzhaVar.zzb(16) > 2) {
                                        throw zzat.zzb("residueType greater than 2 is not decodable", null);
                                    }
                                    zzhaVar.zzc(24);
                                    zzhaVar.zzc(24);
                                    zzhaVar.zzc(24);
                                    int iZzb11 = zzhaVar.zzb(i17) + i34;
                                    int i36 = 8;
                                    zzhaVar.zzc(8);
                                    int[] iArr5 = new int[iZzb11];
                                    for (int i37 = 0; i37 < iZzb11; i37++) {
                                        iArr5[i37] = ((zzhaVar.zza() ? zzhaVar.zzb(5) : 0) * 8) + zzhaVar.zzb(3);
                                    }
                                    int i38 = 0;
                                    while (i38 < iZzb11) {
                                        int i39 = 0;
                                        while (i39 < i36) {
                                            if ((iArr5[i38] & (1 << i39)) != 0) {
                                                zzhaVar.zzc(i36);
                                            }
                                            i39++;
                                            i36 = 8;
                                        }
                                        i38++;
                                        i36 = 8;
                                    }
                                    i35++;
                                    i17 = 6;
                                    i34 = 1;
                                }
                                int iZzb12 = zzhaVar.zzb(i17) + 1;
                                for (int i40 = 0; i40 < iZzb12; i40++) {
                                    int iZzb13 = zzhaVar.zzb(16);
                                    if (iZzb13 != 0) {
                                        StringBuilder sb2 = new StringBuilder(String.valueOf(iZzb13).length() + 41);
                                        sb2.append("mapping type other than 0 not supported: ");
                                        sb2.append(iZzb13);
                                        zzeg.zze("VorbisUtil", sb2.toString());
                                    } else {
                                        if (zzhaVar.zza()) {
                                            i3 = 1;
                                            iZzb = zzhaVar.zzb(4) + 1;
                                        } else {
                                            i3 = 1;
                                            iZzb = 1;
                                        }
                                        if (zzhaVar.zza()) {
                                            int iZzb14 = zzhaVar.zzb(8) + i3;
                                            for (int i41 = 0; i41 < iZzb14; i41++) {
                                                int i42 = i11 - 1;
                                                zzhaVar.zzc(zzhe.zza(i42));
                                                zzhaVar.zzc(zzhe.zza(i42));
                                            }
                                        }
                                        if (zzhaVar.zzb(2) != 0) {
                                            throw zzat.zzb("to reserved bits must be zero after mapping coupling steps", null);
                                        }
                                        if (iZzb > 1) {
                                            for (int i43 = 0; i43 < i11; i43++) {
                                                zzhaVar.zzc(4);
                                            }
                                        }
                                        for (int i44 = 0; i44 < iZzb; i44++) {
                                            zzhaVar.zzc(8);
                                            zzhaVar.zzc(8);
                                            zzhaVar.zzc(8);
                                        }
                                    }
                                }
                                int iZzb15 = zzhaVar.zzb(6);
                                int i45 = iZzb15 + 1;
                                zzhc[] zzhcVarArr = new zzhc[i45];
                                for (int i46 = 0; i46 < i45; i46++) {
                                    zzhcVarArr[i46] = new zzhc(zzhaVar.zza(), zzhaVar.zzb(16), zzhaVar.zzb(16), zzhaVar.zzb(8));
                                }
                                if (!zzhaVar.zza()) {
                                    throw zzat.zzb("framing bit after modes not set as expected", null);
                                }
                                zzanaVar = new zzana(zzhdVar, zzhbVar, bArr, zzhcVarArr, zzhe.zza(iZzb15));
                            }
                        }
                    } else {
                        if (zzhaVar.zzb(24) != 5653314) {
                            int iZzd = zzhaVar.zzd();
                            StringBuilder sb3 = new StringBuilder(String.valueOf(iZzd).length() + 55);
                            sb3.append("expected code book to start with [0x56, 0x43, 0x42] at ");
                            sb3.append(iZzd);
                            throw zzat.zzb(sb3.toString(), null);
                        }
                        int iZzb16 = zzhaVar.zzb(16);
                        int iZzb17 = zzhaVar.zzb(24);
                        if (zzhaVar.zza()) {
                            zzhaVar.zzc(i12);
                            for (int iZzb18 = 0; iZzb18 < iZzb17; iZzb18 += zzhaVar.zzb(zzhe.zza(iZzb17 - iZzb18))) {
                            }
                        } else {
                            boolean zZza = zzhaVar.zza();
                            for (int i47 = 0; i47 < iZzb17; i47++) {
                                if (!zZza) {
                                    zzhaVar.zzc(i12);
                                } else if (zzhaVar.zza()) {
                                    zzhaVar.zzc(i12);
                                }
                            }
                        }
                        int i48 = i10;
                        int iZzb19 = zzhaVar.zzb(i48);
                        if (iZzb19 > 2) {
                            StringBuilder sb4 = new StringBuilder(String.valueOf(iZzb19).length() + 42);
                            sb4.append("lookup type greater than 2 not decodable: ");
                            sb4.append(iZzb19);
                            throw zzat.zzb(sb4.toString(), null);
                        }
                        if (iZzb19 != i6) {
                            if (iZzb19 != 2) {
                                i5 = i6;
                            }
                            i13++;
                            i6 = i5;
                            i10 = 4;
                            i12 = 5;
                        } else {
                            i14 = iZzb19;
                        }
                        zzhaVar.zzc(32);
                        zzhaVar.zzc(32);
                        int iZzb20 = zzhaVar.zzb(i48) + i6;
                        zzhaVar.zzc(i6);
                        if (i14 != i6) {
                            i5 = i6;
                            jFloor = ((long) iZzb16) * ((long) iZzb17);
                        } else if (iZzb16 != 0) {
                            i5 = i6;
                            jFloor = (long) Math.floor(Math.pow(iZzb17, 1.0d / ((double) iZzb16)));
                        } else {
                            i5 = i6;
                            jFloor = 0;
                        }
                        zzhaVar.zzc((int) (jFloor * ((long) iZzb20)));
                        i13++;
                        i6 = i5;
                        i10 = 4;
                        i12 = 5;
                    }
                }
            }
        }
        zzanaVar = null;
        this.zza = zzanaVar;
        if (zzanaVar == null) {
            return true;
        }
        ArrayList arrayList = new ArrayList();
        zzhd zzhdVar2 = zzanaVar.zza;
        arrayList.add(zzhdVar2.zzg);
        arrayList.add(zzanaVar.zzc);
        zzap zzapVarZzb = zzahm.zzb(zzgwm.zzr(zzanaVar.zzb.zza));
        zzt zztVar = new zzt();
        zztVar.zzn("audio/ogg");
        zztVar.zzo("audio/vorbis");
        zztVar.zzi(zzhdVar2.zzd);
        zztVar.zzj(zzhdVar2.zzc);
        zztVar.zzG(zzhdVar2.zza);
        zztVar.zzH(zzhdVar2.zzb);
        zztVar.zzr(arrayList);
        zztVar.zzl(zzapVarZzb);
        zzamxVar.zza = zztVar.zzO();
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzamz
    protected final void zzj(long j3) {
        super.zzj(j3);
        this.zzc = j3 != 0;
        zzhd zzhdVar = this.zzd;
        this.zzb = zzhdVar != null ? zzhdVar.zze : 0;
    }
}
