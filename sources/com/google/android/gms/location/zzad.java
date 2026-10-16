package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzad extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzad> CREATOR = new zzae();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f73000a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.google.android.gms.internal.location.zze f73001b;

    zzad(boolean z2, com.google.android.gms.internal.location.zze zzeVar) {
        this.f73000a = z2;
        this.f73001b = zzeVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzad)) {
            return false;
        }
        zzad zzadVar = (zzad) obj;
        return this.f73000a == zzadVar.f73000a && Objects.b(this.f73001b, zzadVar.f73001b);
    }

    public final int hashCode() {
        return Objects.c(Boolean.valueOf(this.f73000a));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LocationAvailabilityRequest[");
        if (this.f73000a) {
            sb.append("bypass, ");
        }
        if (this.f73001b != null) {
            sb.append("impersonation=");
            sb.append(this.f73001b);
            sb.append(", ");
        }
        sb.setLength(sb.length() - 2);
        sb.append(']');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        boolean z2 = this.f73000a;
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.g(parcel, 1, z2);
        SafeParcelWriter.E(parcel, 2, this.f73001b, i3, false);
        SafeParcelWriter.b(parcel, iA);
    }
}
