package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Locale;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
import org.checkerframework.dataflow.qual.Pure;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzi {
    public static final zzi zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final byte[] zze;
    public final int zzf;
    public final int zzg;
    private int zzh;

    static {
        zzh zzhVar = new zzh();
        zzhVar.zza(1);
        zzhVar.zzb(2);
        zzhVar.zzc(3);
        zza = zzhVar.zzg();
        zzh zzhVar2 = new zzh();
        zzhVar2.zza(1);
        zzhVar2.zzb(1);
        zzhVar2.zzc(2);
        zzhVar2.zzg();
        String str = zzfl.zza;
        Integer.toString(0, 36);
        Integer.toString(1, 36);
        Integer.toString(2, 36);
        Integer.toString(3, 36);
        Integer.toString(4, 36);
        Integer.toString(5, 36);
    }

    /* synthetic */ zzi(int i3, int i4, int i5, byte[] bArr, int i6, int i7, byte[] bArr2) {
        this.zzb = i3;
        this.zzc = i4;
        this.zzd = i5;
        this.zze = bArr;
        this.zzf = i6;
        this.zzg = i7;
    }

    @EnsuresNonNullIf
    public static boolean zza(zzi zziVar) {
        if (zziVar == null) {
            return true;
        }
        int i3 = zziVar.zzb;
        if (i3 != -1 && i3 != 1 && i3 != 2) {
            return false;
        }
        int i4 = zziVar.zzc;
        if (i4 != -1 && i4 != 2) {
            return false;
        }
        int i5 = zziVar.zzd;
        if ((i5 != -1 && i5 != 3) || zziVar.zze != null) {
            return false;
        }
        int i6 = zziVar.zzg;
        if (i6 != -1 && i6 != 8) {
            return false;
        }
        int i7 = zziVar.zzf;
        return i7 == -1 || i7 == 8;
    }

    @Pure
    public static int zzb(int i3) {
        if (i3 == 1) {
            return 1;
        }
        if (i3 != 9) {
            return (i3 == 4 || i3 == 5 || i3 == 6 || i3 == 7) ? 2 : -1;
        }
        return 6;
    }

    @Pure
    public static int zzc(int i3) {
        if (i3 == 1) {
            return 3;
        }
        if (i3 == 4) {
            return 10;
        }
        if (i3 == 13) {
            return 2;
        }
        if (i3 == 16) {
            return 6;
        }
        if (i3 != 18) {
            return (i3 == 6 || i3 == 7) ? 3 : -1;
        }
        return 7;
    }

    private static String zzh(int i3) {
        if (i3 == -1) {
            return "Unset color space";
        }
        if (i3 == 6) {
            return "BT2020";
        }
        if (i3 == 1) {
            return "BT709";
        }
        if (i3 == 2) {
            return "BT601";
        }
        StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + 22);
        sb.append("Undefined color space ");
        sb.append(i3);
        return sb.toString();
    }

    private static String zzi(int i3) {
        if (i3 == -1) {
            return "Unset color transfer";
        }
        if (i3 == 10) {
            return "Gamma 2.2";
        }
        if (i3 == 1) {
            return "Linear";
        }
        if (i3 == 2) {
            return "sRGB";
        }
        if (i3 == 3) {
            return "SDR SMPTE 170M";
        }
        if (i3 == 6) {
            return "ST2084 PQ";
        }
        if (i3 == 7) {
            return "HLG";
        }
        StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + 25);
        sb.append("Undefined color transfer ");
        sb.append(i3);
        return sb.toString();
    }

    private static String zzj(int i3) {
        if (i3 == -1) {
            return "Unset color range";
        }
        if (i3 == 1) {
            return "Full range";
        }
        if (i3 == 2) {
            return "Limited range";
        }
        StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + 22);
        sb.append("Undefined color range ");
        sb.append(i3);
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzi.class == obj.getClass()) {
            zzi zziVar = (zzi) obj;
            if (this.zzb == zziVar.zzb && this.zzc == zziVar.zzc && this.zzd == zziVar.zzd && Arrays.equals(this.zze, zziVar.zze) && this.zzf == zziVar.zzf && this.zzg == zziVar.zzg) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i3 = this.zzh;
        if (i3 != 0) {
            return i3;
        }
        int iHashCode = ((((((((((this.zzb + 527) * 31) + this.zzc) * 31) + this.zzd) * 31) + Arrays.hashCode(this.zze)) * 31) + this.zzf) * 31) + this.zzg;
        this.zzh = iHashCode;
        return iHashCode;
    }

    public final String toString() {
        String string;
        int i3 = this.zzf;
        int i4 = this.zzd;
        int i5 = this.zzc;
        String strZzh = zzh(this.zzb);
        String strZzj = zzj(i5);
        String strZzi = zzi(i4);
        String string2 = "NA";
        if (i3 != -1) {
            StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + 8);
            sb.append(i3);
            sb.append("bit Luma");
            string = sb.toString();
        } else {
            string = "NA";
        }
        int i6 = this.zzg;
        if (i6 != -1) {
            StringBuilder sb2 = new StringBuilder(String.valueOf(i6).length() + 10);
            sb2.append(i6);
            sb2.append("bit Chroma");
            string2 = sb2.toString();
        }
        boolean z2 = this.zze != null;
        StringBuilder sb3 = new StringBuilder(strZzh.length() + 12 + strZzj.length() + 2 + strZzi.length() + 2 + String.valueOf(z2).length() + 2 + string.length() + 2 + string2.length() + 1);
        sb3.append("ColorInfo(");
        sb3.append(strZzh);
        sb3.append(", ");
        sb3.append(strZzj);
        sb3.append(", ");
        sb3.append(strZzi);
        sb3.append(", ");
        sb3.append(z2);
        sb3.append(", ");
        sb3.append(string);
        sb3.append(", ");
        sb3.append(string2);
        sb3.append(")");
        return sb3.toString();
    }

    public final zzh zzd() {
        return new zzh(this, null);
    }

    public final boolean zze() {
        return (this.zzf == -1 || this.zzg == -1) ? false : true;
    }

    public final boolean zzf() {
        return (this.zzb == -1 || this.zzc == -1 || this.zzd == -1) ? false : true;
    }

    public final String zzg() {
        String str;
        String string;
        if (zzf()) {
            Object[] objArr = {zzh(this.zzb), zzj(this.zzc), zzi(this.zzd)};
            String str2 = zzfl.zza;
            str = String.format(Locale.US, "%s/%s/%s", objArr);
        } else {
            str = "NA/NA/NA";
        }
        if (zze()) {
            int i3 = this.zzf;
            int i4 = this.zzg;
            StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + 1 + String.valueOf(i4).length());
            sb.append(i3);
            sb.append("/");
            sb.append(i4);
            string = sb.toString();
        } else {
            string = "NA/NA";
        }
        StringBuilder sb2 = new StringBuilder(str.length() + 1 + string.length());
        sb2.append(str);
        sb2.append("/");
        sb2.append(string);
        return sb2.toString();
    }
}
