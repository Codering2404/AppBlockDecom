package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzals implements zzahf {
    public static final zzals zza = new zzals(true);
    public static final zzals zzb = new zzals(false);
    public final boolean zzc;

    private zzals(boolean z2) {
        this.zzc = z2;
    }

    public final String toString() {
        boolean z2 = !this.zzc;
        StringBuilder sb = new StringBuilder(String.valueOf(z2).length() + 33);
        sb.append("IncorrectFragmentation{expected=");
        sb.append(z2);
        sb.append("}");
        return sb.toString();
    }
}
