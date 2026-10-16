package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzgue implements zzgub {
    private static final zzgub zzb = zzgud.zza;
    private final zzgui zza = new zzgui();
    private volatile zzgub zzc;
    private Object zzd;

    zzgue(zzgub zzgubVar) {
        this.zzc = zzgubVar;
    }

    public final String toString() {
        Object string = this.zzc;
        if (string == zzb) {
            String strValueOf = String.valueOf(this.zzd);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 25);
            sb.append("<supplier that returned ");
            sb.append(strValueOf);
            sb.append(">");
            string = sb.toString();
        }
        String strValueOf2 = String.valueOf(string);
        StringBuilder sb2 = new StringBuilder(strValueOf2.length() + 19);
        sb2.append("Suppliers.memoize(");
        sb2.append(strValueOf2);
        sb2.append(")");
        return sb2.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzgub
    public final Object zza() {
        zzgub zzgubVar = this.zzc;
        zzgub zzgubVar2 = zzb;
        if (zzgubVar != zzgubVar2) {
            synchronized (this.zza) {
                try {
                    if (this.zzc != zzgubVar2) {
                        Object objZza = this.zzc.zza();
                        this.zzd = objZza;
                        this.zzc = zzgubVar2;
                        return objZza;
                    }
                } finally {
                }
            }
        }
        return this.zzd;
    }
}
