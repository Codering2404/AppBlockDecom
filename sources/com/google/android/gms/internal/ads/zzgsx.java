package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzgsx implements zzgtk {
    protected zzgsx() {
    }

    public static zzgsx zzc(char c3) {
        return new zzgsu(c3);
    }

    @Override // com.google.android.gms.internal.ads.zzgtk
    @Deprecated
    public final /* synthetic */ boolean zza(Object obj) {
        return zzb(((Character) obj).charValue());
    }

    public abstract boolean zzb(char c3);
}
