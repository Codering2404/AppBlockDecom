package com.google.android.libraries.places.internal;

import com.google.common.base.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzblf extends zzbln {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzbli f76369a;

    public zzblf(zzbli zzbliVar) {
        this.f76369a = (zzbli) Preconditions.u(zzbliVar, "result");
    }

    @Override // com.google.android.libraries.places.internal.zzbln
    public final zzbli a(zzblj zzbljVar) {
        return this.f76369a;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzblf) {
            return this.f76369a.equals(((zzblf) obj).f76369a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f76369a.hashCode();
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.f76369a);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 19);
        sb.append("FixedResultPicker(");
        sb.append(strValueOf);
        sb.append(")");
        return sb.toString();
    }
}
