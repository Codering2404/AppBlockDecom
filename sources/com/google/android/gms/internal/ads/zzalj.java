package com.google.android.gms.internal.ads;

import android.util.Pair;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzalj {
    public static final /* synthetic */ int zza = 0;
    private static final byte[] zzb;

    static {
        String str = zzfl.zza;
        zzb = "OpusHead".getBytes(StandardCharsets.UTF_8);
    }

    public static int zza(int i3) {
        return (i3 >> 24) & 255;
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x00e5, code lost:
    
        r26 = -9223372036854775807L;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x028a  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0293  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x0502  */
    /* JADX WARN: Removed duplicated region for block: B:293:0x053a  */
    /* JADX WARN: Removed duplicated region for block: B:581:0x0c74  */
    /* JADX WARN: Removed duplicated region for block: B:582:0x0c76  */
    /* JADX WARN: Removed duplicated region for block: B:616:0x0dda  */
    /* JADX WARN: Removed duplicated region for block: B:617:0x0dde  */
    /* JADX WARN: Removed duplicated region for block: B:627:0x0e45  */
    /* JADX WARN: Removed duplicated region for block: B:628:0x0e70  */
    /* JADX WARN: Removed duplicated region for block: B:638:0x0236 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x015d A[PHI: r9 r12 r13
      0x015d: PHI (r9v4 int) = (r9v3 int), (r9v5 int) binds: [B:71:0x013e, B:80:0x014f] A[DONT_GENERATE, DONT_INLINE]
      0x015d: PHI (r12v2 int) = (r12v1 int), (r12v4 int) binds: [B:71:0x013e, B:80:0x014f] A[DONT_GENERATE, DONT_INLINE]
      0x015d: PHI (r13v5 int) = (r13v4 int), (r13v6 int) binds: [B:71:0x013e, B:80:0x014f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0184  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.List zzb(com.google.android.gms.internal.ads.zzfx r85, com.google.android.gms.internal.ads.zzagr r86, long r87, com.google.android.gms.internal.ads.zzq r89, boolean r90, boolean r91, com.google.android.gms.internal.ads.zzgta r92, boolean r93) throws com.google.android.gms.internal.ads.zzat {
        /*
            Method dump skipped, instruction units count: 3711
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzalj.zzb(com.google.android.gms.internal.ads.zzfx, com.google.android.gms.internal.ads.zzagr, long, com.google.android.gms.internal.ads.zzq, boolean, boolean, com.google.android.gms.internal.ads.zzgta, boolean):java.util.List");
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x00da  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.android.gms.internal.ads.zzap zzc(com.google.android.gms.internal.ads.zzfy r14) {
        /*
            Method dump skipped, instruction units count: 317
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzalj.zzc(com.google.android.gms.internal.ads.zzfy):com.google.android.gms.internal.ads.zzap");
    }

    public static zzgb zzd(zzet zzetVar) {
        long jZzD;
        long jZzD2;
        zzetVar.zzh(8);
        if (zza(zzetVar.zzB()) == 0) {
            jZzD = zzetVar.zzz();
            jZzD2 = zzetVar.zzz();
        } else {
            jZzD = zzetVar.zzD();
            jZzD2 = zzetVar.zzD();
        }
        return new zzgb(jZzD, jZzD2, zzetVar.zzz());
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0089, code lost:
    
        r8 = r12.zzB();
        r10 = r12.zzB();
        r9 = r9 - 16;
        r11 = new byte[r9];
        r12.zzm(r11, 0, r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0098, code lost:
    
        r9 = new com.google.android.gms.internal.ads.zzfv(r7, r11, r10, r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x009e, code lost:
    
        com.google.android.gms.internal.ads.zzeg.zzc("MetadataUtil", "Failed to parse metadata entry with key: ".concat(java.lang.String.valueOf(r7)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00ad, code lost:
    
        r9 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.android.gms.internal.ads.zzap zze(com.google.android.gms.internal.ads.zzfx r12) {
        /*
            Method dump skipped, instruction units count: 236
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzalj.zze(com.google.android.gms.internal.ads.zzfx):com.google.android.gms.internal.ads.zzap");
    }

    public static void zzf(zzet zzetVar) {
        int iZzg = zzetVar.zzg();
        zzetVar.zzk(4);
        if (zzetVar.zzB() != 1751411826) {
            iZzg += 4;
        }
        zzetVar.zzh(iZzg);
    }

    static zzap zzh(zzet zzetVar) {
        try {
            zzetVar.zzk(5);
            int iZzB = zzetVar.zzB();
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < iZzB; i3++) {
                long jZzD = zzetVar.zzD() / 10000;
                if (jZzD < 0) {
                    jZzD = -9223372036854775807L;
                }
                arrayList.add(zzaiv.zzb(jZzD, -9223372036854775807L, zzetVar.zzK(zzetVar.zzs(), StandardCharsets.UTF_8)));
            }
            if (arrayList.isEmpty()) {
                return null;
            }
            return new zzap(arrayList);
        } catch (IndexOutOfBoundsException unused) {
            return null;
        }
    }

    private static zzap zzi(zzet zzetVar) {
        short sZzv = zzetVar.zzv();
        zzetVar.zzk(2);
        String strZzK = zzetVar.zzK(sZzv, StandardCharsets.UTF_8);
        int iMax = Math.max(strZzK.lastIndexOf(43), strZzK.lastIndexOf(45));
        try {
            return new zzap(-9223372036854775807L, new zzga(Float.parseFloat(strZzK.substring(0, iMax)), Float.parseFloat(strZzK.substring(iMax, strZzK.length() - 1))));
        } catch (IndexOutOfBoundsException | NumberFormatException unused) {
            return null;
        }
    }

    private static int zzj(zzet zzetVar) {
        zzetVar.zzh(16);
        return zzetVar.zzB();
    }

    private static String zzk(byte[] bArr, int i3, int i4) {
        zzgtj.zzi(bArr.length == 64);
        ArrayList arrayList = new ArrayList(16);
        for (int i5 = 0; i5 < bArr.length - 3; i5 += 4) {
            int iZze = zzhah.zze(bArr[i5], bArr[i5 + 1], bArr[i5 + 2], bArr[i5 + 3]);
            String str = zzfl.zza;
            int i6 = ((iZze >> 8) & 255) - 128;
            int i7 = (iZze >> 16) & 255;
            int i8 = (iZze & 255) - 128;
            arrayList.add(String.format("%06x", Integer.valueOf(Math.max(0, Math.min(i7 + ((i8 * 17790) / ColorExtractionConstants.MAX_PIXEL_SAMPLES), 255)) | (Math.max(0, Math.min(((i6 * 14075) / ColorExtractionConstants.MAX_PIXEL_SAMPLES) + i7, 255)) << 16) | (Math.max(0, Math.min((i7 - ((i8 * 3455) / ColorExtractionConstants.MAX_PIXEL_SAMPLES)) - ((i6 * 7169) / ColorExtractionConstants.MAX_PIXEL_SAMPLES), 255)) << 8))));
        }
        String strZzd = zzgtd.zzd(arrayList, ", ");
        StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + 7 + String.valueOf(i4).length() + 10 + strZzd.length() + 1);
        sb.append("size: ");
        sb.append(i3);
        sb.append("x");
        sb.append(i4);
        sb.append("\npalette: ");
        sb.append(strZzd);
        sb.append("\n");
        return sb.toString();
    }

    private static zzi zzl(zzet zzetVar) {
        zzh zzhVar = new zzh();
        byte[] bArrZzi = zzetVar.zzi();
        zzes zzesVar = new zzes(bArrZzi, bArrZzi.length);
        zzesVar.zzf(zzetVar.zzg() * 8);
        zzesVar.zzo(1);
        int iZzj = zzesVar.zzj(8);
        for (int i3 = 0; i3 < iZzj; i3++) {
            zzesVar.zzo(1);
            int iZzj2 = zzesVar.zzj(8);
            for (int i4 = 0; i4 < iZzj2; i4++) {
                zzesVar.zzh(6);
                boolean zZzi = zzesVar.zzi();
                zzesVar.zzg();
                zzesVar.zzo(11);
                zzesVar.zzh(4);
                int iZzj3 = zzesVar.zzj(4) + 8;
                zzhVar.zze(iZzj3);
                zzhVar.zzf(iZzj3);
                zzesVar.zzo(1);
                if (zZzi) {
                    int iZzj4 = zzesVar.zzj(8);
                    int iZzj5 = zzesVar.zzj(8);
                    zzesVar.zzo(1);
                    boolean zZzi2 = zzesVar.zzi();
                    zzhVar.zza(zzi.zzb(iZzj4));
                    zzhVar.zzb(true != zZzi2 ? 2 : 1);
                    zzhVar.zzc(zzi.zzc(iZzj5));
                }
            }
        }
        return zzhVar.zzg();
    }

    private static ByteBuffer zzm() {
        return ByteBuffer.allocate(25).order(ByteOrder.LITTLE_ENDIAN);
    }

    private static Pair zzn(zzfx zzfxVar) {
        zzfy zzfyVarZzc = zzfxVar.zzc(1701606260);
        if (zzfyVarZzc == null) {
            return null;
        }
        zzet zzetVar = zzfyVarZzc.zza;
        zzetVar.zzh(8);
        int iZza = zza(zzetVar.zzB());
        int iZzH = zzetVar.zzH();
        long[] jArr = new long[iZzH];
        long[] jArr2 = new long[iZzH];
        for (int i3 = 0; i3 < iZzH; i3++) {
            jArr[i3] = iZza == 1 ? zzetVar.zzJ() : zzetVar.zzz();
            jArr2[i3] = iZza == 1 ? zzetVar.zzD() : zzetVar.zzB();
            if (zzetVar.zzv() != 1) {
                throw new IllegalArgumentException("Unsupported media rate.");
            }
            zzetVar.zzk(2);
        }
        return Pair.create(jArr, jArr2);
    }

    /* JADX WARN: Removed duplicated region for block: B:76:0x013f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void zzo(com.google.android.gms.internal.ads.zzet r34, int r35, int r36, int r37, int r38, java.lang.String r39, boolean r40, com.google.android.gms.internal.ads.zzq r41, com.google.android.gms.internal.ads.zzalf r42, int r43) throws com.google.android.gms.internal.ads.zzat {
        /*
            Method dump skipped, instruction units count: 1798
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzalj.zzo(com.google.android.gms.internal.ads.zzet, int, int, int, int, java.lang.String, boolean, com.google.android.gms.internal.ads.zzq, com.google.android.gms.internal.ads.zzalf, int):void");
    }

    private static zzala zzp(zzet zzetVar, int i3) {
        zzetVar.zzh(i3 + 12);
        zzetVar.zzk(1);
        zzs(zzetVar);
        zzetVar.zzk(2);
        int iZzs = zzetVar.zzs();
        if ((iZzs & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0) {
            zzetVar.zzk(2);
        }
        if ((iZzs & 64) != 0) {
            zzetVar.zzk(zzetVar.zzs());
        }
        if ((iZzs & 32) != 0) {
            zzetVar.zzk(2);
        }
        zzetVar.zzk(1);
        zzs(zzetVar);
        String strZze = zzas.zze(zzetVar.zzs());
        if ("audio/mpeg".equals(strZze) || "audio/vnd.dts".equals(strZze) || "audio/vnd.dts.hd".equals(strZze)) {
            return new zzala(strZze, null, -1L, -1L);
        }
        zzetVar.zzk(4);
        long jZzz = zzetVar.zzz();
        long jZzz2 = zzetVar.zzz();
        zzetVar.zzk(1);
        int iZzs2 = zzs(zzetVar);
        long j3 = jZzz2;
        byte[] bArr = new byte[iZzs2];
        zzetVar.zzm(bArr, 0, iZzs2);
        if (j3 <= 0) {
            j3 = -1;
        }
        return new zzala(strZze, bArr, j3, jZzz > 0 ? jZzz : -1L);
    }

    private static zzaky zzq(zzet zzetVar, int i3) {
        zzetVar.zzh(i3 + 8);
        zzetVar.zzk(4);
        return new zzaky(zzetVar.zzz(), zzetVar.zzz());
    }

    private static Pair zzr(zzet zzetVar, int i3, int i4) throws zzat {
        Integer num;
        zzamj zzamjVar;
        Pair pairCreate;
        int i5;
        int i6;
        Integer num2;
        boolean z2;
        int iZzg = zzetVar.zzg();
        while (iZzg - i3 < i4) {
            zzetVar.zzh(iZzg);
            int iZzB = zzetVar.zzB();
            zzagc.zza(iZzB > 0, "childAtomSize must be positive");
            if (zzetVar.zzB() == 1936289382) {
                int i7 = iZzg + 8;
                int i8 = 0;
                int i9 = -1;
                Integer numValueOf = null;
                String strZzK = null;
                while (i7 - iZzg < iZzB) {
                    zzetVar.zzh(i7);
                    int iZzB2 = zzetVar.zzB();
                    int iZzB3 = zzetVar.zzB();
                    if (iZzB3 == 1718775137) {
                        numValueOf = Integer.valueOf(zzetVar.zzB());
                    } else if (iZzB3 == 1935894637) {
                        zzetVar.zzk(4);
                        strZzK = zzetVar.zzK(4, StandardCharsets.UTF_8);
                    } else if (iZzB3 == 1935894633) {
                        i9 = i7;
                        i8 = iZzB2;
                    }
                    i7 += iZzB2;
                }
                byte[] bArr = null;
                if ("cenc".equals(strZzK) || "cbc1".equals(strZzK) || "cens".equals(strZzK) || "cbcs".equals(strZzK)) {
                    zzagc.zza(numValueOf != null, "frma atom is mandatory");
                    zzagc.zza(i9 != -1, "schi atom is mandatory");
                    int i10 = i9 + 8;
                    while (true) {
                        if (i10 - i9 >= i8) {
                            num = numValueOf;
                            zzamjVar = null;
                            break;
                        }
                        zzetVar.zzh(i10);
                        int iZzB4 = zzetVar.zzB();
                        if (zzetVar.zzB() == 1952804451) {
                            int iZza = zza(zzetVar.zzB());
                            zzetVar.zzk(1);
                            if (iZza == 0) {
                                zzetVar.zzk(1);
                                i6 = 0;
                                i5 = 0;
                            } else {
                                int iZzs = zzetVar.zzs();
                                i5 = iZzs & 15;
                                i6 = (iZzs & 240) >> 4;
                            }
                            if (zzetVar.zzs() == 1) {
                                num2 = numValueOf;
                                z2 = true;
                            } else {
                                num2 = numValueOf;
                                z2 = false;
                            }
                            int iZzs2 = zzetVar.zzs();
                            byte[] bArr2 = new byte[16];
                            zzetVar.zzm(bArr2, 0, 16);
                            if (z2 && iZzs2 == 0) {
                                int iZzs3 = zzetVar.zzs();
                                byte[] bArr3 = new byte[iZzs3];
                                zzetVar.zzm(bArr3, 0, iZzs3);
                                bArr = bArr3;
                            }
                            num = num2;
                            zzamjVar = new zzamj(z2, strZzK, iZzs2, bArr2, i6, i5, bArr);
                        } else {
                            i10 += iZzB4;
                        }
                    }
                    zzagc.zza(zzamjVar != null, "tenc atom is mandatory");
                    String str = zzfl.zza;
                    pairCreate = Pair.create(num, zzamjVar);
                } else {
                    pairCreate = null;
                }
                if (pairCreate != null) {
                    return pairCreate;
                }
            }
            iZzg += iZzB;
        }
        return null;
    }

    private static int zzs(zzet zzetVar) {
        int iZzs = zzetVar.zzs();
        int i3 = iZzs & 127;
        while ((iZzs & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) == 128) {
            iZzs = zzetVar.zzs();
            i3 = (i3 << 7) | (iZzs & 127);
        }
        return i3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:123:0x02f1  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x033e  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0397  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x039a  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x03fa  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0439  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0448  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01e6  */
    /* JADX WARN: Type inference failed for: r15v16 */
    /* JADX WARN: Type inference failed for: r15v17 */
    /* JADX WARN: Type inference failed for: r15v5 */
    /* JADX WARN: Type inference failed for: r15v6 */
    /* JADX WARN: Type inference failed for: r15v7 */
    /* JADX WARN: Type inference failed for: r15v8 */
    /* JADX WARN: Type inference failed for: r23v31 */
    /* JADX WARN: Type inference failed for: r23v32 */
    /* JADX WARN: Type inference failed for: r23v33 */
    /* JADX WARN: Type inference failed for: r23v7 */
    /* JADX WARN: Type inference failed for: r23v8 */
    /* JADX WARN: Type inference failed for: r23v9 */
    /* JADX WARN: Type inference failed for: r29v2, types: [int[], java.lang.Object] */
    /* JADX WARN: Type inference failed for: r29v6, types: [int[]] */
    /* JADX WARN: Type inference failed for: r2v50 */
    /* JADX WARN: Type inference failed for: r31v0 */
    /* JADX WARN: Type inference failed for: r31v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r31v2 */
    /* JADX WARN: Type inference failed for: r38v0 */
    /* JADX WARN: Type inference failed for: r38v1 */
    /* JADX WARN: Type inference failed for: r45v14, types: [int[]] */
    /* JADX WARN: Type inference failed for: r45v15 */
    /* JADX WARN: Type inference failed for: r45v16 */
    /* JADX WARN: Type inference failed for: r4v20 */
    /* JADX WARN: Type inference failed for: r4v36 */
    /* JADX WARN: Type inference failed for: r4v47 */
    /* JADX WARN: Type inference failed for: r4v49 */
    /* JADX WARN: Type inference failed for: r4v6, types: [int[]] */
    /* JADX WARN: Type inference failed for: r4v74 */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v19, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v20 */
    /* JADX WARN: Type inference failed for: r5v21 */
    /* JADX WARN: Type inference failed for: r5v22 */
    /* JADX WARN: Type inference failed for: r5v39 */
    /* JADX WARN: Type inference failed for: r5v40 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.android.gms.internal.ads.zzaml zzg(com.google.android.gms.internal.ads.zzami r44, com.google.android.gms.internal.ads.zzfx r45, com.google.android.gms.internal.ads.zzagr r46, boolean r47) throws com.google.android.gms.internal.ads.zzat {
        /*
            Method dump skipped, instruction units count: 1811
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzalj.zzg(com.google.android.gms.internal.ads.zzami, com.google.android.gms.internal.ads.zzfx, com.google.android.gms.internal.ads.zzagr, boolean):com.google.android.gms.internal.ads.zzaml");
    }
}
