package com.google.android.gms.ads.internal.util.client;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zzm extends zzw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f70184a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f70185b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f70186c;

    zzm(int i3, int i4, boolean z2) {
        this.f70184a = i3;
        this.f70185b = i4;
        this.f70186c = z2;
    }

    @Override // com.google.android.gms.ads.internal.util.client.zzw
    public final int a() {
        return this.f70184a;
    }

    @Override // com.google.android.gms.ads.internal.util.client.zzw
    public final int b() {
        return this.f70185b;
    }

    @Override // com.google.android.gms.ads.internal.util.client.zzw
    public final boolean c() {
        return this.f70186c;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzw) {
            zzw zzwVar = (zzw) obj;
            if (this.f70184a == zzwVar.a() && this.f70185b == zzwVar.b() && this.f70186c == zzwVar.c()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (true != this.f70186c ? 1237 : 1231) ^ ((((this.f70184a ^ 1000003) * 1000003) ^ this.f70185b) * 1000003);
    }

    public final String toString() {
        int i3 = this.f70184a;
        int length = String.valueOf(i3).length();
        int i4 = this.f70185b;
        int length2 = String.valueOf(i4).length();
        boolean z2 = this.f70186c;
        StringBuilder sb = new StringBuilder(length + 59 + length2 + 26 + String.valueOf(z2).length() + 1);
        sb.append("OfflineAdConfig{impressionPrerequisite=");
        sb.append(i3);
        sb.append(", clickPrerequisite=");
        sb.append(i4);
        sb.append(", notificationFlowEnabled=");
        sb.append(z2);
        sb.append("}");
        return sb.toString();
    }
}
