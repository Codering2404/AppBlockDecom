package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import javax.annotation.ParametersAreNonnullByDefault;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
@ParametersAreNonnullByDefault
public final class zzbfg {
    private final int zza;
    private final int zzb;
    private final int zzc;
    private final boolean zzd;
    private final zzbfv zze;
    private final zzbgc zzf;
    private int zzn;
    private final Object zzg = new Object();
    private final ArrayList zzh = new ArrayList();
    private final ArrayList zzi = new ArrayList();
    private final ArrayList zzj = new ArrayList();
    private int zzk = 0;
    private int zzl = 0;
    private int zzm = 0;
    private String zzo = "";
    private String zzp = "";
    private String zzq = "";

    public zzbfg(int i3, int i4, int i5, int i6, int i7, int i8, int i9, boolean z2) {
        this.zza = i3;
        this.zzb = i4;
        this.zzc = i5;
        this.zzd = z2;
        this.zze = new zzbfv(i6);
        this.zzf = new zzbgc(i7, i8, i9);
    }

    private final void zzm(String str, boolean z2, float f3, float f4, float f5, float f6) {
        if (str != null) {
            if (str.length() < this.zzc) {
                return;
            }
            synchronized (this.zzg) {
                try {
                    this.zzh.add(str);
                    this.zzk += str.length();
                    if (z2) {
                        this.zzi.add(str);
                        this.zzj.add(new zzbfr(f3, f4, f5, f6, r10.size() - 1));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    private static final String zzn(ArrayList arrayList, int i3) {
        if (arrayList.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int size = arrayList.size();
        int i4 = 0;
        while (i4 < size) {
            sb.append((String) arrayList.get(i4));
            sb.append(' ');
            i4++;
            if (sb.length() > 100) {
                break;
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        String string = sb.toString();
        return string.length() < 100 ? string : string.substring(0, 100);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzbfg)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        String str = ((zzbfg) obj).zzo;
        return str != null && str.equals(this.zzo);
    }

    public final int hashCode() {
        return this.zzo.hashCode();
    }

    public final String toString() {
        ArrayList arrayList = this.zzh;
        int i3 = this.zzl;
        int i4 = this.zzn;
        int i5 = this.zzk;
        String strZzn = zzn(arrayList, 100);
        String strZzn2 = zzn(this.zzi, 100);
        String str = this.zzo;
        String str2 = this.zzp;
        String str3 = this.zzq;
        int length = String.valueOf(i3).length();
        int length2 = String.valueOf(i4).length();
        int length3 = String.valueOf(i5).length();
        int length4 = String.valueOf(strZzn).length();
        int length5 = String.valueOf(strZzn2).length();
        int length6 = String.valueOf(str).length();
        StringBuilder sb = new StringBuilder(length + 32 + length2 + 14 + length3 + 8 + length4 + 14 + length5 + 12 + length6 + 20 + String.valueOf(str2).length() + 32 + String.valueOf(str3).length());
        sb.append("ActivityContent fetchId: ");
        sb.append(i3);
        sb.append(" score:");
        sb.append(i4);
        sb.append(" total_length:");
        sb.append(i5);
        sb.append("\n text: ");
        sb.append(strZzn);
        sb.append("\n viewableText");
        sb.append(strZzn2);
        sb.append("\n signture: ");
        sb.append(str);
        sb.append("\n viewableSignture: ");
        sb.append(str2);
        sb.append("\n viewableSignatureForVertical: ");
        sb.append(str3);
        return sb.toString();
    }

    public final boolean zza() {
        boolean z2;
        synchronized (this.zzg) {
            z2 = this.zzm == 0;
        }
        return z2;
    }

    public final String zzb() {
        return this.zzo;
    }

    public final String zzc() {
        return this.zzq;
    }

    public final void zzd() {
        synchronized (this.zzg) {
            this.zzm--;
        }
    }

    public final void zze() {
        synchronized (this.zzg) {
            this.zzm++;
        }
    }

    public final void zzf(String str, boolean z2, float f3, float f4, float f5, float f6) {
        zzm(str, z2, f3, f4, f5, f6);
        synchronized (this.zzg) {
            try {
                if (this.zzm < 0) {
                    int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
                    com.google.android.gms.ads.internal.util.client.zzo.a("ActivityContent: negative number of WebViews.");
                }
                zzi();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzg(String str, boolean z2, float f3, float f4, float f5, float f6) {
        zzm(str, z2, f3, f4, f5, f6);
    }

    public final void zzh() {
        synchronized (this.zzg) {
            try {
                int iZzj = zzj(this.zzk, this.zzl);
                if (iZzj > this.zzn) {
                    this.zzn = iZzj;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzi() {
        synchronized (this.zzg) {
            try {
                int iZzj = zzj(this.zzk, this.zzl);
                if (iZzj > this.zzn) {
                    this.zzn = iZzj;
                    if (!com.google.android.gms.ads.internal.zzt.l().zzo().zzc()) {
                        zzbfv zzbfvVar = this.zze;
                        this.zzo = zzbfvVar.zza(this.zzh);
                        this.zzp = zzbfvVar.zza(this.zzi);
                    }
                    if (!com.google.android.gms.ads.internal.zzt.l().zzo().zze()) {
                        this.zzq = this.zzf.zza(this.zzi, this.zzj);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    final int zzj(int i3, int i4) {
        return this.zzd ? this.zzb : (i3 * this.zza) + (i4 * this.zzb);
    }

    public final void zzk(int i3) {
        this.zzl = i3;
    }

    final int zzl() {
        return this.zzk;
    }
}
