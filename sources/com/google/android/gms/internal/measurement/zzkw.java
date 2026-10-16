package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzkw {
    public int zza;
    public long zzb;
    public Object zzc;
    public final zzlr zzd;
    public int zze;

    zzkw() {
        int i3 = zzlr.zzb;
        int i4 = zznu.zza;
        this.zzd = zzlr.zza;
    }

    static /* synthetic */ String zza(int i3, int i4, byte b3, String str, String str2) {
        StringBuilder sb = new StringBuilder(String.valueOf(i4).length() + b3 + String.valueOf(i3).length());
        sb.append(str);
        sb.append(i4);
        sb.append(str2);
        sb.append(i3);
        return sb.toString();
    }

    zzkw(zzlr zzlrVar) {
        zzlrVar.getClass();
        this.zzd = zzlrVar;
    }
}
