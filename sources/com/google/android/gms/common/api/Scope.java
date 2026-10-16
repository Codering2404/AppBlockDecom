package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class Scope extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<Scope> CREATOR = new zzd();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f71534a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f71535b;

    Scope(int i3, String str) {
        Preconditions.h(str, "scopeUri must not be null or empty");
        this.f71534a = i3;
        this.f71535b = str;
    }

    public String M() {
        return this.f71535b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Scope) {
            return this.f71535b.equals(((Scope) obj).f71535b);
        }
        return false;
    }

    public int hashCode() {
        return this.f71535b.hashCode();
    }

    public String toString() {
        return this.f71535b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int i4 = this.f71534a;
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.u(parcel, 1, i4);
        SafeParcelWriter.G(parcel, 2, M(), false);
        SafeParcelWriter.b(parcel, iA);
    }

    public Scope(String str) {
        this(1, str);
    }
}
