package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbe extends AbstractSafeParcelable implements Iterable<String> {
    public static final Parcelable.Creator<zzbe> CREATOR = new zzbf();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Bundle f73483a;

    zzbe(Bundle bundle) {
        this.f73483a = bundle;
    }

    final Object M(String str) {
        return this.f73483a.get(str);
    }

    final Long N(String str) {
        return Long.valueOf(this.f73483a.getLong(str));
    }

    final Double O(String str) {
        return Double.valueOf(this.f73483a.getDouble("value"));
    }

    final String g0(String str) {
        return this.f73483a.getString(str);
    }

    @Override // java.lang.Iterable
    public final Iterator<String> iterator() {
        return new zzbd(this);
    }

    public final int j0() {
        return this.f73483a.size();
    }

    public final String toString() {
        return this.f73483a.toString();
    }

    public final Bundle w0() {
        return new Bundle(this.f73483a);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.j(parcel, 2, w0(), false);
        SafeParcelWriter.b(parcel, iA);
    }

    final /* synthetic */ Bundle z0() {
        return this.f73483a;
    }
}
