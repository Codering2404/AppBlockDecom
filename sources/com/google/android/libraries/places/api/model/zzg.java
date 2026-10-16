package com.google.android.libraries.places.api.model;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
abstract class zzg extends AuthorAttribution {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f75343a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f75344b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f75345c;

    zzg(String str, String str2, String str3) {
        if (str == null) {
            throw new NullPointerException("Null name");
        }
        this.f75343a = str;
        this.f75344b = str2;
        this.f75345c = str3;
    }

    @Override // com.google.android.libraries.places.api.model.AuthorAttribution
    public final String c() {
        return this.f75345c;
    }

    @Override // com.google.android.libraries.places.api.model.AuthorAttribution
    public final String d() {
        return this.f75344b;
    }

    public final boolean equals(Object obj) {
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        if (obj instanceof AuthorAttribution) {
            AuthorAttribution authorAttribution = (AuthorAttribution) obj;
            if (this.f75343a.equals(authorAttribution.getName()) && ((str = this.f75344b) != null ? str.equals(authorAttribution.d()) : authorAttribution.d() == null) && ((str2 = this.f75345c) != null ? str2.equals(authorAttribution.c()) : authorAttribution.c() == null)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.places.api.model.AuthorAttribution
    public final String getName() {
        return this.f75343a;
    }

    public final int hashCode() {
        int iHashCode = this.f75343a.hashCode() ^ 1000003;
        String str = this.f75344b;
        int iHashCode2 = ((iHashCode * 1000003) ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.f75345c;
        return iHashCode2 ^ (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        String str = this.f75344b;
        int length = String.valueOf(str).length();
        String str2 = this.f75345c;
        int length2 = String.valueOf(str2).length();
        String str3 = this.f75343a;
        StringBuilder sb = new StringBuilder(str3.length() + 29 + length + 11 + length2 + 1);
        sb.append("AuthorAttribution{name=");
        sb.append(str3);
        sb.append(", uri=");
        sb.append(str);
        sb.append(", photoUri=");
        sb.append(str2);
        sb.append("}");
        return sb.toString();
    }
}
