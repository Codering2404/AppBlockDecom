package com.google.android.gms.internal.ads;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaey {
    public static final /* synthetic */ int zza = 0;
    private static final int[] zzb = {1, 2, 3, 6};
    private static final int[] zzc = {48000, 44100, 32000};
    private static final int[] zzd = {24000, 22050, 16000};
    private static final int[] zze = {2, 1, 2, 3, 3, 4, 4, 5};
    private static final int[] zzf = {32, 40, 48, 56, 64, 80, 96, 112, ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD, 160, 192, 224, Function.MAX_NARGS, 320, 384, 448, 512, 576, 640};
    private static final int[] zzg = {69, 87, 104, 121, 139, 174, 208, 243, 278, 348, 417, 487, 557, 696, 835, 975, 1114, 1253, 1393};

    public static zzv zza(zzet zzetVar, String str, String str2, zzq zzqVar) {
        zzes zzesVar = new zzes();
        zzesVar.zza(zzetVar);
        int i3 = zzc[zzesVar.zzj(2)];
        zzesVar.zzh(8);
        int i4 = zze[zzesVar.zzj(3)];
        if (zzesVar.zzj(1) != 0) {
            i4++;
        }
        int i5 = zzf[zzesVar.zzj(5)] * 1000;
        zzesVar.zzm();
        zzetVar.zzh(zzesVar.zze());
        zzt zztVar = new zzt();
        zztVar.zza(str);
        zztVar.zzo("audio/ac3");
        zztVar.zzG(i4);
        zztVar.zzH(i3);
        zztVar.zzs(zzqVar);
        zztVar.zze(str2);
        zztVar.zzi(i5);
        zztVar.zzj(i5);
        return zztVar.zzO();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.android.gms.internal.ads.zzv zzb(com.google.android.gms.internal.ads.zzet r7, java.lang.String r8, java.lang.String r9, com.google.android.gms.internal.ads.zzq r10) {
        /*
            com.google.android.gms.internal.ads.zzes r0 = new com.google.android.gms.internal.ads.zzes
            r0.<init>()
            r0.zza(r7)
            r1 = 13
            int r1 = r0.zzj(r1)
            int r1 = r1 * 1000
            r2 = 3
            r0.zzh(r2)
            r3 = 2
            int r3 = r0.zzj(r3)
            int[] r4 = com.google.android.gms.internal.ads.zzaey.zzc
            r3 = r4[r3]
            r4 = 10
            r0.zzh(r4)
            int[] r4 = com.google.android.gms.internal.ads.zzaey.zze
            int r5 = r0.zzj(r2)
            r4 = r4[r5]
            r5 = 1
            int r6 = r0.zzj(r5)
            if (r6 == 0) goto L33
            int r4 = r4 + 1
        L33:
            r0.zzh(r2)
            r2 = 4
            int r2 = r0.zzj(r2)
            r0.zzh(r5)
            if (r2 <= 0) goto L4f
            r2 = 6
            r0.zzh(r2)
            int r2 = r0.zzj(r5)
            if (r2 == 0) goto L4c
            int r4 = r4 + 2
        L4c:
            r0.zzh(r5)
        L4f:
            int r2 = r0.zzc()
            r6 = 7
            if (r2 <= r6) goto L62
            r0.zzh(r6)
            int r2 = r0.zzj(r5)
            if (r2 == 0) goto L62
            java.lang.String r2 = "audio/eac3-joc"
            goto L64
        L62:
            java.lang.String r2 = "audio/eac3"
        L64:
            r0.zzm()
            int r0 = r0.zze()
            r7.zzh(r0)
            com.google.android.gms.internal.ads.zzt r7 = new com.google.android.gms.internal.ads.zzt
            r7.<init>()
            r7.zza(r8)
            r7.zzo(r2)
            r7.zzG(r4)
            r7.zzH(r3)
            r7.zzs(r10)
            r7.zze(r9)
            r7.zzj(r1)
            com.google.android.gms.internal.ads.zzv r7 = r7.zzO()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaey.zzb(com.google.android.gms.internal.ads.zzet, java.lang.String, java.lang.String, com.google.android.gms.internal.ads.zzq):com.google.android.gms.internal.ads.zzv");
    }

    public static zzaex zzc(zzes zzesVar) {
        int iZzf;
        int i3;
        int i4;
        int i5;
        String str;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int iZzd = zzesVar.zzd();
        zzesVar.zzh(40);
        int iZzj = zzesVar.zzj(5);
        zzesVar.zzf(iZzd);
        int i11 = -1;
        if (iZzj > 10) {
            zzesVar.zzh(16);
            int iZzj2 = zzesVar.zzj(2);
            if (iZzj2 == 0) {
                i11 = 0;
            } else if (iZzj2 == 1) {
                i11 = 1;
            } else if (iZzj2 == 2) {
                i11 = 2;
            }
            zzesVar.zzh(3);
            int iZzj3 = zzesVar.zzj(11) + 1;
            int iZzj4 = zzesVar.zzj(2);
            if (iZzj4 == 3) {
                i3 = zzd[zzesVar.zzj(2)];
                i8 = 6;
                i7 = 3;
            } else {
                int iZzj5 = zzesVar.zzj(2);
                int i12 = zzb[iZzj5];
                i7 = iZzj5;
                i3 = zzc[iZzj4];
                i8 = i12;
            }
            iZzf = iZzj3 + iZzj3;
            int i13 = (iZzf * i3) / (i8 * 32);
            int iZzj6 = zzesVar.zzj(3);
            boolean zZzi = zzesVar.zzi();
            i4 = zze[iZzj6] + (zZzi ? 1 : 0);
            zzesVar.zzh(10);
            if (zzesVar.zzi()) {
                zzesVar.zzh(8);
            }
            if (iZzj6 == 0) {
                zzesVar.zzh(5);
                if (zzesVar.zzi()) {
                    zzesVar.zzh(8);
                }
                i9 = 0;
                iZzj6 = 0;
            } else {
                i9 = iZzj6;
            }
            if (i11 == 1) {
                if (zzesVar.zzi()) {
                    zzesVar.zzh(16);
                }
                i10 = 1;
            } else {
                i10 = i11;
            }
            if (zzesVar.zzi()) {
                if (i9 > 2) {
                    zzesVar.zzh(2);
                }
                if ((i9 & 1) != 0 && i9 > 2) {
                    zzesVar.zzh(6);
                }
                if ((i9 & 4) != 0) {
                    zzesVar.zzh(6);
                }
                if (zZzi && zzesVar.zzi()) {
                    zzesVar.zzh(5);
                }
                if (i10 == 0) {
                    if (zzesVar.zzi()) {
                        zzesVar.zzh(6);
                    }
                    if (i9 == 0 && zzesVar.zzi()) {
                        zzesVar.zzh(6);
                    }
                    if (zzesVar.zzi()) {
                        zzesVar.zzh(6);
                    }
                    int iZzj7 = zzesVar.zzj(2);
                    if (iZzj7 == 1) {
                        zzesVar.zzh(5);
                    } else if (iZzj7 == 2) {
                        zzesVar.zzh(12);
                    } else if (iZzj7 == 3) {
                        int iZzj8 = zzesVar.zzj(5);
                        if (zzesVar.zzi()) {
                            zzesVar.zzh(5);
                            if (zzesVar.zzi()) {
                                zzesVar.zzh(4);
                            }
                            if (zzesVar.zzi()) {
                                zzesVar.zzh(4);
                            }
                            if (zzesVar.zzi()) {
                                zzesVar.zzh(4);
                            }
                            if (zzesVar.zzi()) {
                                zzesVar.zzh(4);
                            }
                            if (zzesVar.zzi()) {
                                zzesVar.zzh(4);
                            }
                            if (zzesVar.zzi()) {
                                zzesVar.zzh(4);
                            }
                            if (zzesVar.zzi()) {
                                zzesVar.zzh(4);
                            }
                            if (zzesVar.zzi()) {
                                if (zzesVar.zzi()) {
                                    zzesVar.zzh(4);
                                }
                                if (zzesVar.zzi()) {
                                    zzesVar.zzh(4);
                                }
                            }
                        }
                        if (zzesVar.zzi()) {
                            zzesVar.zzh(5);
                            if (zzesVar.zzi()) {
                                zzesVar.zzh(7);
                                if (zzesVar.zzi()) {
                                    zzesVar.zzh(8);
                                }
                            }
                        }
                        zzesVar.zzh((iZzj8 + 2) * 8);
                        zzesVar.zzm();
                    }
                    if (i9 < 2) {
                        if (zzesVar.zzi()) {
                            zzesVar.zzh(14);
                        }
                        if (iZzj6 == 0 && zzesVar.zzi()) {
                            zzesVar.zzh(14);
                        }
                    }
                    if (!zzesVar.zzi()) {
                        i10 = 0;
                    } else if (i7 == 0) {
                        zzesVar.zzh(5);
                        i10 = 0;
                        i7 = 0;
                    } else {
                        for (int i14 = 0; i14 < i8; i14++) {
                            if (zzesVar.zzi()) {
                                zzesVar.zzh(5);
                            }
                        }
                        i10 = 0;
                    }
                }
            }
            if (zzesVar.zzi()) {
                zzesVar.zzh(5);
                if (i9 == 2) {
                    zzesVar.zzh(4);
                    i9 = 2;
                }
                if (i9 >= 6) {
                    zzesVar.zzh(2);
                }
                if (zzesVar.zzi()) {
                    zzesVar.zzh(8);
                }
                if (i9 == 0 && zzesVar.zzi()) {
                    zzesVar.zzh(8);
                }
                if (iZzj4 < 3) {
                    zzesVar.zzg();
                }
            }
            if (i10 == 0 && i7 != 3) {
                zzesVar.zzg();
            }
            if (i10 == 2 && (i7 == 3 || zzesVar.zzi())) {
                zzesVar.zzh(6);
            }
            String str2 = (zzesVar.zzi() && zzesVar.zzj(6) == 1 && zzesVar.zzj(8) == 1) ? "audio/eac3-joc" : "audio/eac3";
            i5 = i8 * Function.MAX_NARGS;
            str = str2;
            i6 = i13;
        } else {
            zzesVar.zzh(32);
            int iZzj9 = zzesVar.zzj(2);
            String str3 = iZzj9 == 3 ? null : "audio/ac3";
            int iZzj10 = zzesVar.zzj(6);
            int i15 = zzf[iZzj10 / 2] * 1000;
            iZzf = zzf(iZzj9, iZzj10);
            zzesVar.zzh(8);
            int iZzj11 = zzesVar.zzj(3);
            if ((iZzj11 & 1) != 0 && iZzj11 != 1) {
                zzesVar.zzh(2);
            }
            if ((iZzj11 & 4) != 0) {
                zzesVar.zzh(2);
            }
            if (iZzj11 == 2) {
                zzesVar.zzh(2);
            }
            i3 = iZzj9 < 3 ? zzc[iZzj9] : -1;
            i4 = zze[iZzj11] + (zzesVar.zzi() ? 1 : 0);
            i5 = 1536;
            str = str3;
            i6 = i15;
        }
        return new zzaex(str, i11, i4, i3, iZzf, i5, i6, null);
    }

    public static int zzd(byte[] bArr) {
        if (bArr.length < 6) {
            return -1;
        }
        if (((bArr[5] & 248) >> 3) <= 10) {
            byte b3 = bArr[4];
            return zzf((b3 & 192) >> 6, b3 & 63);
        }
        int i3 = bArr[2] & 7;
        int i4 = ((bArr[3] & 255) | (i3 << 8)) + 1;
        return i4 + i4;
    }

    public static int zze(ByteBuffer byteBuffer) {
        if (((byteBuffer.get(byteBuffer.position() + 5) & 248) >> 3) > 10) {
            return zzb[((byteBuffer.get(byteBuffer.position() + 4) & 192) >> 6) != 3 ? (byteBuffer.get(byteBuffer.position() + 4) & 48) >> 4 : 3] * Function.MAX_NARGS;
        }
        return 1536;
    }

    private static int zzf(int i3, int i4) {
        int i5;
        if (i3 < 0 || i3 >= 3 || i4 < 0 || (i5 = i4 >> 1) >= 19) {
            return -1;
        }
        int i6 = zzc[i3];
        if (i6 == 44100) {
            int i7 = zzg[i5] + (i4 & 1);
            return i7 + i7;
        }
        int i8 = zzf[i5];
        return i6 == 32000 ? i8 * 6 : i8 * 4;
    }
}
