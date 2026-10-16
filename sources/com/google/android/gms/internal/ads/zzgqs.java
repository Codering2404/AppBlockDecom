package com.google.android.gms.internal.ads;

import android.os.IBinder;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzgqs extends zzgrt {
    private final IBinder zza;
    private final String zzb;
    private final int zzc;
    private final float zzd;
    private final int zze;
    private final String zzf;

    /* synthetic */ zzgqs(IBinder iBinder, String str, int i3, float f3, int i4, int i5, String str2, int i6, String str3, String str4, String str5, byte[] bArr) {
        this.zza = iBinder;
        this.zzb = str;
        this.zzc = i3;
        this.zzd = f3;
        this.zze = i6;
        this.zzf = str4;
    }

    public final boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzgrt) {
            zzgrt zzgrtVar = (zzgrt) obj;
            if (this.zza.equals(zzgrtVar.zza()) && ((str = this.zzb) != null ? str.equals(zzgrtVar.zzb()) : zzgrtVar.zzb() == null) && this.zzc == zzgrtVar.zzc() && Float.floatToIntBits(this.zzd) == Float.floatToIntBits(zzgrtVar.zzd())) {
                zzgrtVar.zze();
                zzgrtVar.zzf();
                zzgrtVar.zzg();
                if (this.zze == zzgrtVar.zzh()) {
                    zzgrtVar.zzi();
                    String str2 = this.zzf;
                    if (str2 != null ? str2.equals(zzgrtVar.zzj()) : zzgrtVar.zzj() == null) {
                        zzgrtVar.zzk();
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.zza.hashCode() ^ 1000003;
        String str = this.zzb;
        int iHashCode2 = (((((iHashCode * 1000003) ^ (str == null ? 0 : str.hashCode())) * 1000003) ^ this.zzc) * 1000003) ^ Float.floatToIntBits(this.zzd);
        int i3 = this.zze;
        String str2 = this.zzf;
        return ((((iHashCode2 * 1525764945) ^ i3) * (-721379959)) ^ (str2 != null ? str2.hashCode() : 0)) * 1000003;
    }

    public final String toString() {
        String string = this.zza.toString();
        int length = string.length();
        String str = this.zzb;
        int length2 = String.valueOf(str).length();
        int i3 = this.zzc;
        int length3 = String.valueOf(i3).length();
        float f3 = this.zzd;
        int length4 = String.valueOf(f3).length();
        int i4 = this.zze;
        int length5 = String.valueOf(i4).length();
        String str2 = this.zzf;
        StringBuilder sb = new StringBuilder(length + 46 + length2 + 16 + length3 + 23 + length4 + 65 + length5 + 33 + String.valueOf(str2).length() + 30);
        sb.append("OverlayDisplayShowRequest{windowToken=");
        sb.append(string);
        sb.append(", appId=");
        sb.append(str);
        sb.append(", layoutGravity=");
        sb.append(i3);
        sb.append(", layoutVerticalMargin=");
        sb.append(f3);
        sb.append(", displayMode=0, triggerMode=0, sessionToken=null, windowWidthPx=");
        sb.append(i4);
        sb.append(", deeplinkUrl=null, adFieldEnifd=");
        sb.append(str2);
        sb.append(", thirdPartyAuthCallerId=null}");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzgrt
    public final IBinder zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzgrt
    public final String zzb() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzgrt
    public final int zzc() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzgrt
    public final float zzd() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzgrt
    public final int zze() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzgrt
    public final int zzf() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzgrt
    public final String zzg() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzgrt
    public final int zzh() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzgrt
    public final String zzi() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzgrt
    public final String zzj() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.ads.zzgrt
    public final String zzk() {
        return null;
    }
}
