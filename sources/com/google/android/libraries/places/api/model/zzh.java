package com.google.android.libraries.places.api.model;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
abstract class zzh extends AuthorAttributions {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f75349a;

    zzh(List list) {
        if (list == null) {
            throw new NullPointerException("Null asList");
        }
        this.f75349a = list;
    }

    @Override // com.google.android.libraries.places.api.model.AuthorAttributions
    public final List c() {
        return this.f75349a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AuthorAttributions) {
            return this.f75349a.equals(((AuthorAttributions) obj).c());
        }
        return false;
    }

    public final int hashCode() {
        return this.f75349a.hashCode() ^ 1000003;
    }

    public final String toString() {
        String string = this.f75349a.toString();
        StringBuilder sb = new StringBuilder(string.length() + 27);
        sb.append("AuthorAttributions{asList=");
        sb.append(string);
        sb.append("}");
        return sb.toString();
    }
}
