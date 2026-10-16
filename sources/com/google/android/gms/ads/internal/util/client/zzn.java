package com.google.android.gms.ads.internal.util.client;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zzn extends zzx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f70187a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f70188b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final double f70189c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f70190d;

    zzn(int i3, int i4, double d3, boolean z2) {
        this.f70187a = i3;
        this.f70188b = i4;
        this.f70189c = d3;
        this.f70190d = z2;
    }

    @Override // com.google.android.gms.ads.internal.util.client.zzx
    public final int a() {
        return this.f70187a;
    }

    @Override // com.google.android.gms.ads.internal.util.client.zzx
    public final int b() {
        return this.f70188b;
    }

    @Override // com.google.android.gms.ads.internal.util.client.zzx
    public final double c() {
        return this.f70189c;
    }

    @Override // com.google.android.gms.ads.internal.util.client.zzx
    public final boolean d() {
        return this.f70190d;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzx) {
            zzx zzxVar = (zzx) obj;
            if (this.f70187a == zzxVar.a() && this.f70188b == zzxVar.b() && Double.doubleToLongBits(this.f70189c) == Double.doubleToLongBits(zzxVar.c()) && this.f70190d == zzxVar.d()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        double d3 = this.f70189c;
        return ((((int) (Double.doubleToLongBits(d3) ^ (Double.doubleToLongBits(d3) >>> 32))) ^ ((((this.f70187a ^ 1000003) * 1000003) ^ this.f70188b) * 1000003)) * 1000003) ^ (true != this.f70190d ? 1237 : 1231);
    }

    public final String toString() {
        int i3 = this.f70187a;
        int length = String.valueOf(i3).length();
        int i4 = this.f70188b;
        int length2 = String.valueOf(i4).length();
        double d3 = this.f70189c;
        int length3 = String.valueOf(d3).length();
        boolean z2 = this.f70190d;
        StringBuilder sb = new StringBuilder(length + 44 + length2 + 20 + length3 + 25 + String.valueOf(z2).length() + 1);
        sb.append("PingStrategy{maxAttempts=");
        sb.append(i3);
        sb.append(", initialBackoffMs=");
        sb.append(i4);
        sb.append(", backoffMultiplier=");
        sb.append(d3);
        sb.append(", bufferAfterMaxAttempts=");
        sb.append(z2);
        sb.append("}");
        return sb.toString();
    }
}
