package com.google.android.gms.internal.ads;

import android.media.AudioFormat;
import android.media.AudioTrack;
import android.os.Build;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzqg {
    public static final zzqg zza;
    public final int zzb;
    public final int zzc;
    private final zzgww zzd;

    static {
        zzqg zzqgVar;
        if (Build.VERSION.SDK_INT >= 33) {
            zzgwv zzgwvVar = new zzgwv();
            for (int i3 = 1; i3 <= 10; i3++) {
                zzgwvVar.zzf(Integer.valueOf(zzfl.zzE(i3)));
            }
            zzqgVar = new zzqg(2, zzgwvVar.zzh());
        } else {
            zzqgVar = new zzqg(2, 10);
        }
        zza = zzqgVar;
    }

    public zzqg(int i3, int i4) {
        this.zzb = i3;
        this.zzc = i4;
        this.zzd = null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzqg)) {
            return false;
        }
        zzqg zzqgVar = (zzqg) obj;
        return this.zzb == zzqgVar.zzb && this.zzc == zzqgVar.zzc && Objects.equals(this.zzd, zzqgVar.zzd);
    }

    public final int hashCode() {
        zzgww zzgwwVar = this.zzd;
        return (((this.zzb * 31) + this.zzc) * 31) + (zzgwwVar == null ? 0 : zzgwwVar.hashCode());
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.zzd);
        int i3 = this.zzb;
        int length = String.valueOf(i3).length();
        int i4 = this.zzc;
        StringBuilder sb = new StringBuilder(length + 38 + String.valueOf(i4).length() + 15 + strValueOf.length() + 1);
        sb.append("AudioProfile[format=");
        sb.append(i3);
        sb.append(", maxChannelCount=");
        sb.append(i4);
        sb.append(", channelMasks=");
        sb.append(strValueOf);
        sb.append("]");
        return sb.toString();
    }

    public final boolean zza(int i3) {
        zzgww zzgwwVar = this.zzd;
        if (zzgwwVar == null) {
            return i3 <= this.zzc;
        }
        int iZzE = zzfl.zzE(i3);
        if (iZzE == 0) {
            return false;
        }
        return zzgwwVar.contains(Integer.valueOf(iZzE));
    }

    public final int zzb(int i3, zzd zzdVar) {
        if (this.zzd != null) {
            return this.zzc;
        }
        if (Build.VERSION.SDK_INT < 29) {
            Integer num = (Integer) zzqh.zzb.getOrDefault(Integer.valueOf(this.zzb), 0);
            num.getClass();
            return num.intValue();
        }
        int i4 = this.zzb;
        for (int i5 = 10; i5 > 0; i5--) {
            int iZzE = zzfl.zzE(i5);
            if (iZzE != 0 && AudioTrack.isDirectPlaybackSupported(new AudioFormat.Builder().setEncoding(i4).setSampleRate(i3).setChannelMask(iZzE).build(), zzdVar.zza())) {
                return i5;
            }
        }
        return 0;
    }

    public zzqg(int i3, Set set) {
        this.zzb = i3;
        zzgww zzgwwVarZzp = zzgww.zzp(set);
        this.zzd = zzgwwVarZzp;
        zzgza it = zzgwwVarZzp.iterator();
        int iMax = 0;
        while (it.hasNext()) {
            iMax = Math.max(iMax, Integer.bitCount(((Integer) it.next()).intValue()));
        }
        this.zzc = iMax;
    }
}
