package com.google.android.gms.internal.ads;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import com.applovin.exoplayer2.common.base.Ascii;
import com.bumptech.glide.load.data.Bwyd.SbbqvQlxi;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaoq implements zzanl {
    private final zzet zza = new zzet();
    private final boolean zzb;
    private final int zzc;
    private final int zzd;
    private final String zze;
    private final float zzf;
    private final int zzg;

    public zzaoq(List list) {
        if (list.size() != 1 || (((byte[]) list.get(0)).length != 48 && ((byte[]) list.get(0)).length != 53)) {
            this.zzc = 0;
            this.zzd = -1;
            this.zze = "sans-serif";
            this.zzb = false;
            this.zzf = 0.85f;
            this.zzg = -1;
            return;
        }
        byte[] bArr = (byte[]) list.get(0);
        this.zzc = bArr[24];
        this.zzd = ((bArr[26] & 255) << 24) | ((bArr[27] & 255) << 16) | ((bArr[28] & 255) << 8) | (bArr[29] & 255);
        this.zze = true == "Serif".equals(zzfl.zzk(bArr, 43, bArr.length + (-43))) ? "serif" : "sans-serif";
        int i3 = bArr[25] * Ascii.DC4;
        this.zzg = i3;
        boolean z2 = (bArr[0] & 32) != 0;
        this.zzb = z2;
        if (z2) {
            this.zzf = Math.max(0.0f, Math.min(((bArr[11] & 255) | ((bArr[10] & 255) << 8)) / i3, 0.95f));
        } else {
            this.zzf = 0.85f;
        }
    }

    private static void zzb(SpannableStringBuilder spannableStringBuilder, int i3, int i4, int i5, int i6, int i7) {
        if (i3 != i4) {
            int i8 = i7 | 33;
            int i9 = i3 & 1;
            int i10 = i3 & 2;
            boolean z2 = true;
            if (i9 != 0) {
                if (i10 != 0) {
                    spannableStringBuilder.setSpan(new StyleSpan(3), i5, i6, i8);
                } else {
                    spannableStringBuilder.setSpan(new StyleSpan(1), i5, i6, i8);
                    z2 = false;
                }
            } else if (i10 != 0) {
                spannableStringBuilder.setSpan(new StyleSpan(2), i5, i6, i8);
            } else {
                z2 = false;
            }
            if ((i3 & 4) != 0) {
                spannableStringBuilder.setSpan(new UnderlineSpan(), i5, i6, i8);
            } else {
                if (i9 != 0 || z2) {
                    return;
                }
                spannableStringBuilder.setSpan(new StyleSpan(0), i5, i6, i8);
            }
        }
    }

    private static void zzc(SpannableStringBuilder spannableStringBuilder, int i3, int i4, int i5, int i6, int i7) {
        if (i3 != i4) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan((i3 >>> 8) | ((i3 & 255) << 24)), i5, i6, i7 | 33);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzanl
    public final void zza(byte[] bArr, int i3, int i4, zzank zzankVar, zzdt zzdtVar) {
        String strZzK;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        zzet zzetVar = this.zza;
        zzetVar.zzb(bArr, i3 + i4);
        zzetVar.zzh(i3);
        int i14 = 1;
        int i15 = 0;
        int i16 = 2;
        zzgtj.zza(zzetVar.zzd() >= 2);
        int iZzt = zzetVar.zzt();
        if (iZzt == 0) {
            strZzK = "";
        } else {
            int iZzg = zzetVar.zzg();
            Charset charsetZzR = zzetVar.zzR();
            int iZzg2 = zzetVar.zzg() - iZzg;
            if (charsetZzR == null) {
                charsetZzR = StandardCharsets.UTF_8;
            }
            strZzK = zzetVar.zzK(iZzt - iZzg2, charsetZzR);
        }
        if (strZzK.isEmpty()) {
            zzdtVar.zza(new zzand(zzgwm.zzi(), -9223372036854775807L, -9223372036854775807L));
            return;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(strZzK);
        int i17 = this.zzc;
        zzb(spannableStringBuilder, i17, 0, 0, spannableStringBuilder.length(), 16711680);
        int i18 = i17;
        int i19 = this.zzd;
        zzc(spannableStringBuilder, i19, -1, 0, spannableStringBuilder.length(), 16711680);
        int i20 = i19;
        String str = this.zze;
        int length = spannableStringBuilder.length();
        if (str != "sans-serif") {
            spannableStringBuilder.setSpan(new TypefaceSpan(str), 0, length, 16711713);
        }
        float fMax = this.zzf;
        while (zzetVar.zzd() >= 8) {
            int iZzg3 = zzetVar.zzg();
            int iZzB = zzetVar.zzB();
            int iZzB2 = zzetVar.zzB();
            if (iZzB2 == 1937013100) {
                zzgtj.zza(zzetVar.zzd() >= i16 ? i14 : i15);
                int iZzt2 = zzetVar.zzt();
                int i21 = i15;
                while (i21 < iZzt2) {
                    zzgtj.zza(zzetVar.zzd() >= 12 ? i14 : i15);
                    int iZzt3 = zzetVar.zzt();
                    int iZzt4 = zzetVar.zzt();
                    zzetVar.zzk(i16);
                    int i22 = iZzt2;
                    int iZzs = zzetVar.zzs();
                    zzetVar.zzk(i14);
                    int iZzB3 = zzetVar.zzB();
                    int length2 = spannableStringBuilder.length();
                    String str2 = SbbqvQlxi.lGhmRa;
                    int i23 = i16;
                    if (iZzt4 > length2) {
                        int length3 = spannableStringBuilder.length();
                        i8 = i18;
                        i9 = i20;
                        StringBuilder sb = new StringBuilder(String.valueOf(iZzt4).length() + 44 + String.valueOf(length3).length() + 2);
                        sb.append("Truncating styl end (");
                        sb.append(iZzt4);
                        sb.append(") to cueText.length() (");
                        sb.append(length3);
                        sb.append(").");
                        zzeg.zzc(str2, sb.toString());
                        iZzt4 = spannableStringBuilder.length();
                    } else {
                        i8 = i18;
                        i9 = i20;
                    }
                    if (iZzt3 >= iZzt4) {
                        StringBuilder sb2 = new StringBuilder(String.valueOf(iZzt3).length() + 36 + String.valueOf(iZzt4).length() + 2);
                        sb2.append("Ignoring styl with start (");
                        sb2.append(iZzt3);
                        sb2.append(") >= end (");
                        sb2.append(iZzt4);
                        sb2.append(").");
                        zzeg.zzc(str2, sb2.toString());
                        i12 = i8;
                        i11 = i21;
                        i10 = i22;
                        i13 = i9;
                    } else {
                        i10 = i22;
                        i11 = i21;
                        int i24 = i8;
                        zzb(spannableStringBuilder, iZzs, i24, iZzt3, iZzt4, 0);
                        i12 = i24;
                        i13 = i9;
                        zzc(spannableStringBuilder, iZzB3, i13, iZzt3, iZzt4, 0);
                    }
                    i16 = i23;
                    iZzt2 = i10;
                    i18 = i12;
                    i20 = i13;
                    i14 = 1;
                    i21 = i11 + 1;
                    i15 = 0;
                }
                i5 = i18;
                i6 = i20;
                i7 = i16;
            } else {
                i5 = i18;
                int i25 = i16;
                i6 = i20;
                if (iZzB2 == 1952608120 && this.zzb) {
                    i7 = i25;
                    zzgtj.zza(zzetVar.zzd() >= i7);
                    float fZzt = zzetVar.zzt();
                    int i26 = this.zzg;
                    String str3 = zzfl.zza;
                    fMax = Math.max(0.0f, Math.min(fZzt / i26, 0.95f));
                } else {
                    i7 = i25;
                }
            }
            zzetVar.zzh(iZzg3 + iZzB);
            i18 = i5;
            i16 = i7;
            i20 = i6;
            i14 = 1;
            i15 = 0;
        }
        zzcw zzcwVar = new zzcw();
        zzcwVar.zza(spannableStringBuilder);
        zzcwVar.zzf(fMax, 0);
        zzcwVar.zzg(0);
        zzdtVar.zza(new zzand(zzgwm.zzj(zzcwVar.zzr()), -9223372036854775807L, -9223372036854775807L));
    }
}
