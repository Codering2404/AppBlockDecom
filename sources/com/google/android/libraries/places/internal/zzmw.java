package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzmw extends zzmz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f78228a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f78229b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzmy f78230c;

    /* synthetic */ zzmw(String str, int i3, zzmy zzmyVar, byte[] bArr) {
        this.f78228a = str;
        this.f78229b = i3;
        this.f78230c = zzmyVar;
    }

    @Override // com.google.android.libraries.places.internal.zzmz
    public final String a() {
        return this.f78228a;
    }

    @Override // com.google.android.libraries.places.internal.zzmz
    public final int b() {
        return this.f78229b;
    }

    @Override // com.google.android.libraries.places.internal.zzmz
    public final zzmy c() {
        return this.f78230c;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzmz) {
            zzmz zzmzVar = (zzmz) obj;
            if (this.f78228a.equals(zzmzVar.a()) && this.f78229b == zzmzVar.b() && this.f78230c.equals(zzmzVar.c())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.f78228a.hashCode() ^ 1000003) * 1000003) ^ this.f78229b) * 1000003) ^ this.f78230c.hashCode();
    }

    public final String toString() {
        String string = this.f78230c.toString();
        int i3 = this.f78229b;
        int length = String.valueOf(i3).length();
        int length2 = string.length();
        String str = this.f78228a;
        StringBuilder sb = new StringBuilder(str.length() + 40 + length + 16 + length2 + 1);
        sb.append("ClientProfile{packageName=");
        sb.append(str);
        sb.append(", versionCode=");
        sb.append(i3);
        sb.append(", requestSource=");
        sb.append(string);
        sb.append("}");
        return sb.toString();
    }
}
