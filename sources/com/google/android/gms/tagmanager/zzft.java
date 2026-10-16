package com.google.android.gms.tagmanager;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzft extends Number implements Comparable {
    private double zza;
    private long zzb;
    private final boolean zzc = false;

    private zzft(double d3) {
        this.zza = d3;
    }

    public static zzft zzc(Double d3) {
        return new zzft(d3.doubleValue());
    }

    public static zzft zzd(long j3) {
        return new zzft(j3);
    }

    public static zzft zze(String str) throws NumberFormatException {
        try {
            try {
                return new zzft(Long.parseLong(str));
            } catch (NumberFormatException unused) {
                throw new NumberFormatException(String.valueOf(str).concat(" is not a valid TypedNumber"));
            }
        } catch (NumberFormatException unused2) {
            return new zzft(Double.parseDouble(str));
        }
    }

    @Override // java.lang.Number
    public final byte byteValue() {
        return (byte) zzb();
    }

    @Override // java.lang.Number
    public final double doubleValue() {
        return this.zzc ? this.zzb : this.zza;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof zzft) && compareTo((zzft) obj) == 0;
    }

    @Override // java.lang.Number
    public final float floatValue() {
        return (float) doubleValue();
    }

    public final int hashCode() {
        return new Long(zzb()).hashCode();
    }

    @Override // java.lang.Number
    public final int intValue() {
        return (int) zzb();
    }

    @Override // java.lang.Number
    public final long longValue() {
        return zzb();
    }

    @Override // java.lang.Number
    public final short shortValue() {
        return (short) zzb();
    }

    public final String toString() {
        return this.zzc ? Long.toString(this.zzb) : Double.toString(this.zza);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final int compareTo(zzft zzftVar) {
        return (this.zzc && zzftVar.zzc) ? new Long(this.zzb).compareTo(Long.valueOf(zzftVar.zzb)) : Double.compare(doubleValue(), zzftVar.doubleValue());
    }

    public final long zzb() {
        return this.zzc ? this.zzb : (long) this.zza;
    }

    public final boolean zzf() {
        return !this.zzc;
    }

    public final boolean zzg() {
        return this.zzc;
    }

    private zzft(long j3) {
        this.zzb = j3;
    }
}
