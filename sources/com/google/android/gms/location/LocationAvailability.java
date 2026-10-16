package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class LocationAvailability extends AbstractSafeParcelable implements ReflectedParcelable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f72930a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f72931b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f72932c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int f72933d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zzal[] f72934f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final LocationAvailability f72928g = new LocationAvailability(0, 1, 1, 0, null, true);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final LocationAvailability f72929h = new LocationAvailability(1000, 1, 1, 0, null, false);
    public static final Parcelable.Creator<LocationAvailability> CREATOR = new zzab();

    LocationAvailability(int i3, int i4, int i5, long j3, zzal[] zzalVarArr, boolean z2) {
        this.f72933d = i3 < 1000 ? 0 : 1000;
        this.f72930a = i4;
        this.f72931b = i5;
        this.f72932c = j3;
        this.f72934f = zzalVarArr;
    }

    public boolean M() {
        return this.f72933d < 1000;
    }

    public boolean equals(Object obj) {
        if (obj instanceof LocationAvailability) {
            LocationAvailability locationAvailability = (LocationAvailability) obj;
            if (this.f72930a == locationAvailability.f72930a && this.f72931b == locationAvailability.f72931b && this.f72932c == locationAvailability.f72932c && this.f72933d == locationAvailability.f72933d && Arrays.equals(this.f72934f, locationAvailability.f72934f)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Objects.c(Integer.valueOf(this.f72933d));
    }

    public String toString() {
        boolean zM = M();
        StringBuilder sb = new StringBuilder(String.valueOf(zM).length() + 22);
        sb.append("LocationAvailability[");
        sb.append(zM);
        sb.append("]");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int i4 = this.f72930a;
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.u(parcel, 1, i4);
        SafeParcelWriter.u(parcel, 2, this.f72931b);
        SafeParcelWriter.z(parcel, 3, this.f72932c);
        SafeParcelWriter.u(parcel, 4, this.f72933d);
        SafeParcelWriter.J(parcel, 5, this.f72934f, i3, false);
        SafeParcelWriter.g(parcel, 6, M());
        SafeParcelWriter.b(parcel, iA);
    }
}
