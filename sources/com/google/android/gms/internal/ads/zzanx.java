package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.SparseArray;
import com.applovin.exoplayer2.common.base.Ascii;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzanx implements zzanl {
    private static final byte[] zza = {0, 7, 8, Ascii.SI};
    private static final byte[] zzb = {0, 119, -120, -1};
    private static final byte[] zzc = {0, 17, 34, 51, 68, 85, 102, 119, -120, -103, -86, -69, -52, -35, -18, -1};
    private final Paint zzd;
    private final Paint zze;
    private final Canvas zzf;
    private final zzanq zzg;
    private final zzanp zzh;
    private final zzanw zzi;
    private Bitmap zzj;

    public zzanx(List list) {
        zzet zzetVar = new zzet((byte[]) list.get(0));
        int iZzt = zzetVar.zzt();
        int iZzt2 = zzetVar.zzt();
        Paint paint = new Paint();
        this.zzd = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        paint.setPathEffect(null);
        Paint paint2 = new Paint();
        this.zze = paint2;
        paint2.setStyle(Paint.Style.FILL);
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        paint2.setPathEffect(null);
        this.zzf = new Canvas();
        this.zzg = new zzanq(719, 575, 0, 719, 0, 575);
        this.zzh = new zzanp(0, zzd(), zze(), zzf());
        this.zzi = new zzanw(iZzt, iZzt2);
    }

    private static zzanp zzb(zzes zzesVar, int i3) {
        int iZzj;
        int iZzj2;
        int iZzj3;
        int iZzj4;
        int i4 = 8;
        int iZzj5 = zzesVar.zzj(8);
        zzesVar.zzh(8);
        int[] iArrZzd = zzd();
        int[] iArrZze = zze();
        int[] iArrZzf = zzf();
        int i5 = i3 - 2;
        while (i5 > 0) {
            int iZzj6 = zzesVar.zzj(i4);
            int iZzj7 = zzesVar.zzj(i4);
            int[] iArr = (iZzj7 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? iArrZzd : (iZzj7 & 64) != 0 ? iArrZze : iArrZzf;
            if ((iZzj7 & 1) != 0) {
                iZzj3 = zzesVar.zzj(i4);
                iZzj4 = zzesVar.zzj(i4);
                iZzj = zzesVar.zzj(i4);
                iZzj2 = zzesVar.zzj(i4);
                i5 -= 6;
            } else {
                int iZzj8 = zzesVar.zzj(6) << 2;
                int iZzj9 = zzesVar.zzj(4) << 4;
                i5 -= 4;
                iZzj = zzesVar.zzj(4) << 4;
                iZzj2 = zzesVar.zzj(2) << 6;
                iZzj3 = iZzj8;
                iZzj4 = iZzj9;
            }
            if (iZzj3 == 0) {
                iZzj2 = 255;
            }
            if (iZzj3 == 0) {
                iZzj = 0;
            }
            if (iZzj3 == 0) {
                iZzj4 = 0;
            }
            double d3 = iZzj3;
            String str = zzfl.zza;
            double d4 = iZzj4 - 128;
            double d5 = iZzj - 128;
            iArr[iZzj6] = zzg((byte) (255 - (iZzj2 & 255)), Math.max(0, Math.min((int) (d3 + (1.402d * d4)), 255)), Math.max(0, Math.min((int) ((d3 - (0.34414d * d5)) - (d4 * 0.71414d)), 255)), Math.max(0, Math.min((int) (d3 + (d5 * 1.772d)), 255)));
            iZzj5 = iZzj5;
            i4 = 8;
        }
        return new zzanp(iZzj5, iArrZzd, iArrZze, iArrZzf);
    }

    private static zzanr zzc(zzes zzesVar) {
        byte[] bArr;
        int iZzj = zzesVar.zzj(16);
        zzesVar.zzh(4);
        int iZzj2 = zzesVar.zzj(2);
        boolean zZzi = zzesVar.zzi();
        zzesVar.zzh(1);
        byte[] bArr2 = zzfl.zzb;
        if (iZzj2 != 1) {
            if (iZzj2 == 0) {
                int iZzj3 = zzesVar.zzj(16);
                int iZzj4 = zzesVar.zzj(16);
                if (iZzj3 > 0) {
                    bArr2 = new byte[iZzj3];
                    zzesVar.zzn(bArr2, 0, iZzj3);
                }
                if (iZzj4 > 0) {
                    bArr = new byte[iZzj4];
                    zzesVar.zzn(bArr, 0, iZzj4);
                }
            }
            return new zzanr(iZzj, zZzi, bArr2, bArr);
        }
        zzesVar.zzh(zzesVar.zzj(8) * 16);
        bArr = bArr2;
        return new zzanr(iZzj, zZzi, bArr2, bArr);
    }

    private static int[] zzd() {
        return new int[]{0, -1, -16777216, -8421505};
    }

    private static int[] zze() {
        int[] iArr = new int[16];
        iArr[0] = 0;
        for (int i3 = 1; i3 < 16; i3++) {
            int i4 = i3 & 4;
            int i5 = i3 & 2;
            int i6 = i3 & 1;
            if (i3 < 8) {
                iArr[i3] = zzg(255, 1 != i6 ? 0 : 255, i5 != 0 ? 255 : 0, i4 != 0 ? 255 : 0);
            } else {
                iArr[i3] = zzg(255, 1 != i6 ? 0 : 127, i5 != 0 ? 127 : 0, i4 == 0 ? 0 : 127);
            }
        }
        return iArr;
    }

    private static int[] zzf() {
        int[] iArr = new int[Function.MAX_NARGS];
        iArr[0] = 0;
        for (int i3 = 0; i3 < 256; i3++) {
            if (i3 < 8) {
                iArr[i3] = zzg(63, 1 != (i3 & 1) ? 0 : 255, (i3 & 2) != 0 ? 255 : 0, (i3 & 4) == 0 ? 0 : 255);
            } else {
                int i4 = i3 & 136;
                if (i4 == 0) {
                    iArr[i3] = zzg(255, (1 != (i3 & 1) ? 0 : 85) + ((i3 & 16) != 0 ? 170 : 0), ((i3 & 2) != 0 ? 85 : 0) + ((i3 & 32) != 0 ? 170 : 0), ((i3 & 4) == 0 ? 0 : 85) + ((i3 & 64) == 0 ? 0 : 170));
                } else if (i4 == 8) {
                    iArr[i3] = zzg(127, (1 != (i3 & 1) ? 0 : 85) + ((i3 & 16) != 0 ? 170 : 0), ((i3 & 2) != 0 ? 85 : 0) + ((i3 & 32) != 0 ? 170 : 0), ((i3 & 4) == 0 ? 0 : 85) + ((i3 & 64) == 0 ? 0 : 170));
                } else if (i4 == 128) {
                    iArr[i3] = zzg(255, (1 != (i3 & 1) ? 0 : 43) + 127 + ((i3 & 16) != 0 ? 85 : 0), ((i3 & 2) != 0 ? 43 : 0) + 127 + ((i3 & 32) != 0 ? 85 : 0), ((i3 & 4) == 0 ? 0 : 43) + 127 + ((i3 & 64) == 0 ? 0 : 85));
                } else if (i4 == 136) {
                    iArr[i3] = zzg(255, (1 != (i3 & 1) ? 0 : 43) + ((i3 & 16) != 0 ? 85 : 0), ((i3 & 2) != 0 ? 43 : 0) + ((i3 & 32) != 0 ? 85 : 0), ((i3 & 4) == 0 ? 0 : 43) + ((i3 & 64) == 0 ? 0 : 85));
                }
            }
        }
        return iArr;
    }

    private static int zzg(int i3, int i4, int i5, int i6) {
        return (i3 << 24) | (i4 << 16) | (i5 << 8) | i6;
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x01d0 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0201 A[LOOP:3: B:89:0x0163->B:122:0x0201, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01fa A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0171  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void zzh(byte[] r22, int[] r23, int r24, int r25, int r26, android.graphics.Paint r27, android.graphics.Canvas r28) {
        /*
            Method dump skipped, instruction units count: 546
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzanx.zzh(byte[], int[], int, int, int, android.graphics.Paint, android.graphics.Canvas):void");
    }

    private static byte[] zzi(int i3, int i4, zzes zzesVar) {
        byte[] bArr = new byte[i3];
        for (int i5 = 0; i5 < i3; i5++) {
            bArr[i5] = (byte) zzesVar.zzj(i4);
        }
        return bArr;
    }

    @Override // com.google.android.gms.internal.ads.zzanl
    public final void zza(byte[] bArr, int i3, int i4, zzank zzankVar, zzdt zzdtVar) {
        boolean z2;
        zzand zzandVar;
        Canvas canvas;
        char c3;
        char c4;
        char c5;
        int i5;
        zzanw zzanwVar;
        Canvas canvas2;
        int i6;
        int i7;
        int i8;
        zzanu zzanuVar;
        int iZzj;
        int iZzj2;
        int iZzj3;
        int iZzj4;
        int i9;
        int iZzj5;
        zzes zzesVar = new zzes(bArr, i3 + i4);
        zzesVar.zzf(i3);
        while (true) {
            z2 = true;
            if (zzesVar.zzc() >= 48 && zzesVar.zzj(8) == 15) {
                zzanw zzanwVar2 = this.zzi;
                int iZzj6 = zzesVar.zzj(8);
                int iZzj7 = zzesVar.zzj(16);
                int iZzj8 = zzesVar.zzj(16);
                int iZze = zzesVar.zze() + iZzj8;
                if (iZzj8 * 8 > zzesVar.zzc()) {
                    zzeg.zzc("DvbParser", "Data field length exceeds limit");
                    zzesVar.zzh(zzesVar.zzc());
                } else {
                    switch (iZzj6) {
                        case 16:
                            if (iZzj7 == zzanwVar2.zza) {
                                zzans zzansVar = zzanwVar2.zzi;
                                int iZzj9 = zzesVar.zzj(8);
                                int iZzj10 = zzesVar.zzj(4);
                                int iZzj11 = zzesVar.zzj(2);
                                zzesVar.zzh(2);
                                SparseArray sparseArray = new SparseArray();
                                for (int i10 = iZzj8 - 2; i10 > 0; i10 -= 6) {
                                    int iZzj12 = zzesVar.zzj(8);
                                    zzesVar.zzh(8);
                                    sparseArray.put(iZzj12, new zzant(zzesVar.zzj(16), zzesVar.zzj(16)));
                                }
                                zzans zzansVar2 = new zzans(iZzj9, iZzj10, iZzj11, sparseArray);
                                if (zzansVar2.zzb != 0) {
                                    zzanwVar2.zzi = zzansVar2;
                                    zzanwVar2.zzc.clear();
                                    zzanwVar2.zzd.clear();
                                    zzanwVar2.zze.clear();
                                } else if (zzansVar != null) {
                                    if (zzansVar.zza != zzansVar2.zza) {
                                        zzanwVar2.zzi = zzansVar2;
                                    }
                                }
                            }
                            break;
                        case 17:
                            zzans zzansVar3 = zzanwVar2.zzi;
                            if (iZzj7 == zzanwVar2.zza && zzansVar3 != null) {
                                int iZzj13 = zzesVar.zzj(8);
                                zzesVar.zzh(4);
                                boolean zZzi = zzesVar.zzi();
                                zzesVar.zzh(3);
                                int iZzj14 = zzesVar.zzj(16);
                                int iZzj15 = zzesVar.zzj(16);
                                int iZzj16 = zzesVar.zzj(3);
                                int iZzj17 = zzesVar.zzj(3);
                                zzesVar.zzh(2);
                                int iZzj18 = zzesVar.zzj(8);
                                int iZzj19 = zzesVar.zzj(8);
                                int iZzj20 = zzesVar.zzj(4);
                                int iZzj21 = zzesVar.zzj(2);
                                zzesVar.zzh(2);
                                int i11 = iZzj8 - 10;
                                SparseArray sparseArray2 = new SparseArray();
                                while (i11 > 0) {
                                    int iZzj22 = zzesVar.zzj(16);
                                    int iZzj23 = zzesVar.zzj(2);
                                    int iZzj24 = zzesVar.zzj(2);
                                    int iZzj25 = zzesVar.zzj(12);
                                    zzesVar.zzh(4);
                                    int iZzj26 = zzesVar.zzj(12);
                                    int i12 = i11 - 6;
                                    if (iZzj23 == 1) {
                                        i11 -= 8;
                                        iZzj = zzesVar.zzj(8);
                                        iZzj2 = zzesVar.zzj(8);
                                    } else if (iZzj23 == 2) {
                                        iZzj23 = 2;
                                        i11 -= 8;
                                        iZzj = zzesVar.zzj(8);
                                        iZzj2 = zzesVar.zzj(8);
                                    } else {
                                        i11 = i12;
                                        iZzj = 0;
                                        iZzj2 = 0;
                                    }
                                    sparseArray2.put(iZzj22, new zzanv(iZzj23, iZzj24, iZzj25, iZzj26, iZzj, iZzj2));
                                }
                                zzanu zzanuVar2 = new zzanu(iZzj13, zZzi, iZzj14, iZzj15, iZzj16, iZzj17, iZzj18, iZzj19, iZzj20, iZzj21, sparseArray2);
                                if (zzansVar3.zzb == 0 && (zzanuVar = (zzanu) zzanwVar2.zzc.get(zzanuVar2.zza)) != null) {
                                    int i13 = 0;
                                    while (true) {
                                        SparseArray sparseArray3 = zzanuVar.zzj;
                                        if (i13 < sparseArray3.size()) {
                                            zzanuVar2.zzj.put(sparseArray3.keyAt(i13), (zzanv) sparseArray3.valueAt(i13));
                                            i13++;
                                        }
                                    }
                                }
                                zzanwVar2.zzc.put(zzanuVar2.zza, zzanuVar2);
                            }
                            break;
                        case 18:
                            if (iZzj7 == zzanwVar2.zza) {
                                zzanp zzanpVarZzb = zzb(zzesVar, iZzj8);
                                zzanwVar2.zzd.put(zzanpVarZzb.zza, zzanpVarZzb);
                            } else if (iZzj7 == zzanwVar2.zzb) {
                                zzanp zzanpVarZzb2 = zzb(zzesVar, iZzj8);
                                zzanwVar2.zzf.put(zzanpVarZzb2.zza, zzanpVarZzb2);
                            }
                            break;
                        case 19:
                            if (iZzj7 == zzanwVar2.zza) {
                                zzanr zzanrVarZzc = zzc(zzesVar);
                                zzanwVar2.zze.put(zzanrVarZzc.zza, zzanrVarZzc);
                            } else if (iZzj7 == zzanwVar2.zzb) {
                                zzanr zzanrVarZzc2 = zzc(zzesVar);
                                zzanwVar2.zzg.put(zzanrVarZzc2.zza, zzanrVarZzc2);
                            }
                            break;
                        case 20:
                            if (iZzj7 == zzanwVar2.zza) {
                                zzesVar.zzh(4);
                                boolean zZzi2 = zzesVar.zzi();
                                zzesVar.zzh(3);
                                int iZzj27 = zzesVar.zzj(16);
                                int iZzj28 = zzesVar.zzj(16);
                                if (zZzi2) {
                                    int iZzj29 = zzesVar.zzj(16);
                                    iZzj3 = zzesVar.zzj(16);
                                    iZzj5 = zzesVar.zzj(16);
                                    iZzj4 = zzesVar.zzj(16);
                                    i9 = iZzj29;
                                } else {
                                    iZzj3 = iZzj27;
                                    iZzj4 = iZzj28;
                                    i9 = 0;
                                    iZzj5 = 0;
                                }
                                zzanwVar2.zzh = new zzanq(iZzj27, iZzj28, i9, iZzj3, iZzj5, iZzj4);
                            }
                            break;
                    }
                    zzesVar.zzo(iZze - zzesVar.zze());
                }
            }
        }
        zzanw zzanwVar3 = this.zzi;
        zzans zzansVar4 = zzanwVar3.zzi;
        if (zzansVar4 == null) {
            zzandVar = new zzand(zzgwm.zzi(), -9223372036854775807L, -9223372036854775807L);
        } else {
            zzanq zzanqVar = zzanwVar3.zzh;
            if (zzanqVar == null) {
                zzanqVar = this.zzg;
            }
            Bitmap bitmap = this.zzj;
            if (bitmap == null || zzanqVar.zza + 1 != bitmap.getWidth() || zzanqVar.zzb + 1 != this.zzj.getHeight()) {
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(zzanqVar.zza + 1, zzanqVar.zzb + 1, Bitmap.Config.ARGB_8888);
                this.zzj = bitmapCreateBitmap;
                this.zzf.setBitmap(bitmapCreateBitmap);
            }
            ArrayList arrayList = new ArrayList();
            SparseArray sparseArray4 = zzansVar4.zzc;
            int i14 = 0;
            while (i14 < sparseArray4.size()) {
                Canvas canvas3 = this.zzf;
                canvas3.save();
                zzant zzantVar = (zzant) sparseArray4.valueAt(i14);
                zzanu zzanuVar3 = (zzanu) zzanwVar3.zzc.get(sparseArray4.keyAt(i14));
                int i15 = zzantVar.zza + zzanqVar.zzc;
                int i16 = zzantVar.zzb + zzanqVar.zze;
                int i17 = zzanuVar3.zzc;
                int i18 = i15 + i17;
                boolean z3 = z2;
                int iMin = Math.min(i18, zzanqVar.zzd);
                int i19 = zzanuVar3.zzd;
                int i20 = i16 + i19;
                canvas3.clipRect(i15, i16, iMin, Math.min(i20, zzanqVar.zzf));
                int i21 = zzanuVar3.zzf;
                zzanp zzanpVar = (zzanp) zzanwVar3.zzd.get(i21);
                if (zzanpVar == null && (zzanpVar = (zzanp) zzanwVar3.zzf.get(i21)) == null) {
                    zzanpVar = this.zzh;
                }
                SparseArray sparseArray5 = zzanuVar3.zzj;
                SparseArray sparseArray6 = sparseArray4;
                int i22 = i14;
                int i23 = 0;
                while (i23 < sparseArray5.size()) {
                    int iKeyAt = sparseArray5.keyAt(i23);
                    int i24 = i23;
                    zzanv zzanvVar = (zzanv) sparseArray5.valueAt(i23);
                    SparseArray sparseArray7 = sparseArray5;
                    zzanr zzanrVar = (zzanr) zzanwVar3.zze.get(iKeyAt);
                    if (zzanrVar == null) {
                        zzanrVar = (zzanr) zzanwVar3.zzg.get(iKeyAt);
                    }
                    if (zzanrVar != null) {
                        Paint paint = zzanrVar.zzb ? null : this.zzd;
                        i7 = i17;
                        int i25 = zzanuVar3.zze;
                        zzanwVar = zzanwVar3;
                        int i26 = zzanvVar.zza + i15;
                        int i27 = i16 + zzanvVar.zzb;
                        canvas2 = canvas3;
                        i6 = i15;
                        int[] iArr = i25 == 3 ? zzanpVar.zzd : i25 == 2 ? zzanpVar.zzc : zzanpVar.zzb;
                        i8 = i18;
                        zzh(zzanrVar.zzc, iArr, i25, i26, i27, paint, canvas2);
                        zzh(zzanrVar.zzd, iArr, i25, i26, i27 + 1, paint, canvas2);
                    } else {
                        zzanwVar = zzanwVar3;
                        canvas2 = canvas3;
                        i6 = i15;
                        i7 = i17;
                        i8 = i18;
                    }
                    i15 = i6;
                    i18 = i8;
                    i23 = i24 + 1;
                    i17 = i7;
                    canvas3 = canvas2;
                    sparseArray5 = sparseArray7;
                    zzanwVar3 = zzanwVar;
                }
                zzanw zzanwVar4 = zzanwVar3;
                Canvas canvas4 = canvas3;
                int i28 = i15;
                int i29 = i17;
                int i30 = i18;
                float f3 = i16;
                float f4 = i28;
                if (zzanuVar3.zzb) {
                    int i31 = zzanuVar3.zze;
                    if (i31 == 3) {
                        i5 = zzanpVar.zzd[zzanuVar3.zzg];
                        c5 = 2;
                    } else {
                        c5 = 2;
                        i5 = i31 == 2 ? zzanpVar.zzc[zzanuVar3.zzh] : zzanpVar.zzb[zzanuVar3.zzi];
                    }
                    Paint paint2 = this.zze;
                    paint2.setColor(i5);
                    float f5 = i30;
                    c4 = c5;
                    c3 = 3;
                    canvas = canvas4;
                    canvas.drawRect(f4, f3, f5, i20, paint2);
                } else {
                    canvas = canvas4;
                    c3 = 3;
                    c4 = 2;
                }
                zzcw zzcwVar = new zzcw();
                zzcwVar.zzc(Bitmap.createBitmap(this.zzj, i28, i16, i29, i19));
                float f6 = zzanqVar.zza;
                zzcwVar.zzi(f4 / f6);
                zzcwVar.zzj(0);
                float f7 = zzanqVar.zzb;
                zzcwVar.zzf(f3 / f7, 0);
                zzcwVar.zzg(0);
                zzcwVar.zzm(i29 / f6);
                zzcwVar.zzn(i19 / f7);
                arrayList.add(zzcwVar.zzr());
                canvas.drawColor(0, PorterDuff.Mode.CLEAR);
                canvas.restore();
                i14 = i22 + 1;
                z2 = z3;
                zzanwVar3 = zzanwVar4;
                sparseArray4 = sparseArray6;
            }
            zzandVar = new zzand(arrayList, -9223372036854775807L, -9223372036854775807L);
        }
        zzdtVar.zza(zzandVar);
    }
}
