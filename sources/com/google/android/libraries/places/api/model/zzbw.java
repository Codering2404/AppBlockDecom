package com.google.android.libraries.places.api.model;

import android.net.Uri;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
abstract class zzbw extends RoutingSummary {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f75311a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Uri f75312b;

    zzbw(List list, Uri uri) {
        if (list == null) {
            throw new NullPointerException("Null legs");
        }
        this.f75311a = list;
        this.f75312b = uri;
    }

    @Override // com.google.android.libraries.places.api.model.RoutingSummary
    public final Uri c() {
        return this.f75312b;
    }

    @Override // com.google.android.libraries.places.api.model.RoutingSummary
    public final List d() {
        return this.f75311a;
    }

    public final boolean equals(Object obj) {
        Uri uri;
        if (obj == this) {
            return true;
        }
        if (obj instanceof RoutingSummary) {
            RoutingSummary routingSummary = (RoutingSummary) obj;
            if (this.f75311a.equals(routingSummary.d()) && ((uri = this.f75312b) != null ? uri.equals(routingSummary.c()) : routingSummary.c() == null)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.f75311a.hashCode() ^ 1000003;
        Uri uri = this.f75312b;
        return (iHashCode * 1000003) ^ (uri == null ? 0 : uri.hashCode());
    }

    public final String toString() {
        String string = this.f75311a.toString();
        int length = string.length();
        String strValueOf = String.valueOf(this.f75312b);
        StringBuilder sb = new StringBuilder(length + 36 + strValueOf.length() + 1);
        sb.append("RoutingSummary{legs=");
        sb.append(string);
        sb.append(", directionsUri=");
        sb.append(strValueOf);
        sb.append("}");
        return sb.toString();
    }
}
