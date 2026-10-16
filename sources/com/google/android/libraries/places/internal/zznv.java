package com.google.android.libraries.places.internal;

import com.google.android.gms.tasks.CancellationTokenSource;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zznv extends zzoa {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CancellationTokenSource f78299b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f78300c;

    zznv(CancellationTokenSource cancellationTokenSource, String str) {
        this.f78299b = cancellationTokenSource;
        if (str == null) {
            throw new NullPointerException("Null query");
        }
        this.f78300c = str;
    }

    @Override // com.google.android.libraries.places.internal.zzoc
    public final CancellationTokenSource a() {
        return this.f78299b;
    }

    @Override // com.google.android.libraries.places.internal.zzoa
    public final String d() {
        return this.f78300c;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzoa) {
            zzoa zzoaVar = (zzoa) obj;
            if (this.f78299b.equals(zzoaVar.a()) && this.f78300c.equals(zzoaVar.d())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.f78299b.hashCode() ^ 1000003) * 1000003) ^ this.f78300c.hashCode();
    }

    public final String toString() {
        String string = this.f78299b.toString();
        int length = string.length();
        String str = this.f78300c;
        StringBuilder sb = new StringBuilder(length + 35 + str.length() + 1);
        sb.append("AutocompleteRequest{source=");
        sb.append(string);
        sb.append(", query=");
        sb.append(str);
        sb.append("}");
        return sb.toString();
    }
}
