package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzarh {
    private final String zza;
    private final int zzb;
    private final int zzc;
    private int zzd;
    private String zze;

    public zzarh(int i3, int i4, int i5) {
        String string;
        if (i3 != Integer.MIN_VALUE) {
            StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + 1);
            sb.append(i3);
            sb.append("/");
            string = sb.toString();
        } else {
            string = "";
        }
        this.zza = string;
        this.zzb = i4;
        this.zzc = i5;
        this.zzd = Integer.MIN_VALUE;
        this.zze = "";
    }

    private final void zzd() {
        if (this.zzd == Integer.MIN_VALUE) {
            throw new IllegalStateException("generateNewId() must be called before retrieving ids.");
        }
    }

    public final void zza() {
        int i3 = this.zzd;
        int i4 = i3 == Integer.MIN_VALUE ? this.zzb : i3 + this.zzc;
        this.zzd = i4;
        String str = this.zza;
        StringBuilder sb = new StringBuilder(str.length() + String.valueOf(i4).length());
        sb.append(str);
        sb.append(i4);
        this.zze = sb.toString();
    }

    public final int zzb() {
        zzd();
        return this.zzd;
    }

    public final String zzc() {
        zzd();
        return this.zze;
    }
}
