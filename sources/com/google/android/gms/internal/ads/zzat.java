package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public class zzat extends IOException {
    public final boolean zza;
    public final int zzb;

    protected zzat(String str, Throwable th, boolean z2, int i3) {
        super(str, th);
        this.zza = z2;
        this.zzb = i3;
    }

    public static zzat zza(String str, Throwable th) {
        return new zzat(str, th, true, 0);
    }

    public static zzat zzb(String str, Throwable th) {
        return new zzat(str, th, true, 1);
    }

    public static zzat zzc(String str) {
        return new zzat(str, null, false, 1);
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        String message = super.getMessage();
        String strConcat = message != null ? message.concat(" ") : "";
        boolean z2 = this.zza;
        int i3 = this.zzb;
        StringBuilder sb = new StringBuilder(strConcat.length() + 20 + String.valueOf(z2).length() + 11 + String.valueOf(i3).length() + 1);
        sb.append(strConcat);
        sb.append("{contentIsMalformed=");
        sb.append(z2);
        sb.append(", dataType=");
        sb.append(i3);
        sb.append("}");
        return sb.toString();
    }
}
