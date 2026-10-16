package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public final class zzal extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzal> CREATOR = new zzam();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f73006a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f73007b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f73008c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f73009d;

    zzal(int i3, int i4, long j3, long j4) {
        this.f73006a = i3;
        this.f73007b = i4;
        this.f73008c = j3;
        this.f73009d = j4;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzal) {
            zzal zzalVar = (zzal) obj;
            if (this.f73006a == zzalVar.f73006a && this.f73007b == zzalVar.f73007b && this.f73008c == zzalVar.f73008c && this.f73009d == zzalVar.f73009d) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.c(Integer.valueOf(this.f73007b), Integer.valueOf(this.f73006a), Long.valueOf(this.f73009d), Long.valueOf(this.f73008c));
    }

    public final String toString() {
        int i3 = this.f73006a;
        int length = String.valueOf(i3).length();
        int i4 = this.f73007b;
        int length2 = String.valueOf(i4).length();
        long j3 = this.f73009d;
        int length3 = String.valueOf(j3).length();
        long j4 = this.f73008c;
        StringBuilder sb = new StringBuilder(length + 50 + length2 + 18 + length3 + 17 + String.valueOf(j4).length());
        sb.append("NetworkLocationStatus: Wifi status: ");
        sb.append(i3);
        sb.append(" Cell status: ");
        sb.append(i4);
        sb.append(" elapsed time NS: ");
        sb.append(j3);
        sb.append(" system time ms: ");
        sb.append(j4);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int i4 = this.f73006a;
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.u(parcel, 1, i4);
        SafeParcelWriter.u(parcel, 2, this.f73007b);
        SafeParcelWriter.z(parcel, 3, this.f73008c);
        SafeParcelWriter.z(parcel, 4, this.f73009d);
        SafeParcelWriter.b(parcel, iA);
    }
}
