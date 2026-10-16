package com.google.android.libraries.places.api.model;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
abstract class zzcb extends SubDestination {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f75324a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f75325b;

    zzcb(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("Null id");
        }
        this.f75324a = str;
        if (str2 == null) {
            throw new NullPointerException("Null name");
        }
        this.f75325b = str2;
    }

    @Override // com.google.android.libraries.places.api.model.SubDestination
    public final String c() {
        return this.f75324a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SubDestination) {
            SubDestination subDestination = (SubDestination) obj;
            if (this.f75324a.equals(subDestination.c()) && this.f75325b.equals(subDestination.getName())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.places.api.model.SubDestination
    public final String getName() {
        return this.f75325b;
    }

    public final int hashCode() {
        return ((this.f75324a.hashCode() ^ 1000003) * 1000003) ^ this.f75325b.hashCode();
    }

    public final String toString() {
        String str = this.f75324a;
        int length = str.length();
        String str2 = this.f75325b;
        StringBuilder sb = new StringBuilder(length + 25 + str2.length() + 1);
        sb.append("SubDestination{id=");
        sb.append(str);
        sb.append(", name=");
        sb.append(str2);
        sb.append("}");
        return sb.toString();
    }
}
