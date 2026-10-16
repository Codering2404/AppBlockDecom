package com.google.android.play.core.review;

import android.app.PendingIntent;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zza extends ReviewInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PendingIntent f83143a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f83144b;

    zza(PendingIntent pendingIntent, boolean z2) {
        if (pendingIntent == null) {
            throw new NullPointerException("Null pendingIntent");
        }
        this.f83143a = pendingIntent;
        this.f83144b = z2;
    }

    @Override // com.google.android.play.core.review.ReviewInfo
    final PendingIntent c() {
        return this.f83143a;
    }

    @Override // com.google.android.play.core.review.ReviewInfo
    final boolean d() {
        return this.f83144b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ReviewInfo) {
            ReviewInfo reviewInfo = (ReviewInfo) obj;
            if (this.f83143a.equals(reviewInfo.c()) && this.f83144b == reviewInfo.d()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.f83143a.hashCode() ^ 1000003) * 1000003) ^ (true != this.f83144b ? 1237 : 1231);
    }

    public final String toString() {
        return "ReviewInfo{pendingIntent=" + this.f83143a.toString() + ", isNoOp=" + this.f83144b + "}";
    }
}
