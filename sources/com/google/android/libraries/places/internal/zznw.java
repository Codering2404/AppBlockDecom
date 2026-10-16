package com.google.android.libraries.places.internal;

import com.google.android.gms.tasks.CancellationTokenSource;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zznw extends zzob {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CancellationTokenSource f78301b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f78302c;

    zznw(CancellationTokenSource cancellationTokenSource, String str) {
        this.f78301b = cancellationTokenSource;
        if (str == null) {
            throw new NullPointerException("Null placeId");
        }
        this.f78302c = str;
    }

    @Override // com.google.android.libraries.places.internal.zzoc
    public final CancellationTokenSource a() {
        return this.f78301b;
    }

    @Override // com.google.android.libraries.places.internal.zzob
    public final String d() {
        return this.f78302c;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzob) {
            zzob zzobVar = (zzob) obj;
            if (this.f78301b.equals(zzobVar.a()) && this.f78302c.equals(zzobVar.d())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.f78301b.hashCode() ^ 1000003) * 1000003) ^ this.f78302c.hashCode();
    }

    public final String toString() {
        String string = this.f78301b.toString();
        int length = string.length();
        String str = this.f78302c;
        StringBuilder sb = new StringBuilder(length + 30 + str.length() + 1);
        sb.append("PlaceRequest{source=");
        sb.append(string);
        sb.append(", placeId=");
        sb.append(str);
        sb.append("}");
        return sb.toString();
    }
}
