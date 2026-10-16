package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class Feature extends AbstractSafeParcelable {
    public static final Parcelable.Creator<Feature> CREATOR = new zzb();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f71442a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f71443b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f71444c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f71445d;

    public Feature(String str, int i3, long j3, boolean z2) {
        this.f71442a = str;
        this.f71443b = i3;
        this.f71444c = j3;
        this.f71445d = z2;
    }

    public boolean M() {
        return this.f71445d;
    }

    public long N() {
        long j3 = this.f71444c;
        return j3 == -1 ? this.f71443b : j3;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Feature) {
            Feature feature = (Feature) obj;
            if (Objects.b(getName(), feature.getName()) && N() == feature.N() && M() == feature.M()) {
                return true;
            }
        }
        return false;
    }

    public String getName() {
        return this.f71442a;
    }

    public final int hashCode() {
        return Objects.c(getName(), Long.valueOf(N()), Boolean.valueOf(M()));
    }

    public final String toString() {
        Objects.ToStringHelper toStringHelperD = Objects.d(this);
        toStringHelperD.a("name", getName());
        toStringHelperD.a("version", Long.valueOf(N()));
        toStringHelperD.a("is_fully_rolled_out", Boolean.valueOf(M()));
        return toStringHelperD.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.G(parcel, 1, getName(), false);
        SafeParcelWriter.u(parcel, 2, this.f71443b);
        SafeParcelWriter.z(parcel, 3, N());
        SafeParcelWriter.g(parcel, 4, M());
        SafeParcelWriter.b(parcel, iA);
    }

    public Feature(String str, long j3) {
        this(str, -1, j3, false);
    }

    public Feature(String str, long j3, boolean z2) {
        this(str, -1, j3, z2);
    }
}
