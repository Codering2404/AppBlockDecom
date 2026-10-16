package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.WorkSource;
import com.google.android.gms.common.internal.ClientIdentity;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.util.WorkSourceUtil;
import com.google.android.gms.location.LocationRequest;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public final class zzeg extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzeg> CREATOR = new zzeh();
    LocationRequest zza;

    zzeg(LocationRequest locationRequest, List list, boolean z2, boolean z3, boolean z4, boolean z5, String str, long j3) {
        WorkSource workSource;
        LocationRequest.Builder builder = new LocationRequest.Builder(locationRequest);
        if (list != null) {
            if (list.isEmpty()) {
                workSource = null;
            } else {
                workSource = new WorkSource();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ClientIdentity clientIdentity = (ClientIdentity) it.next();
                    WorkSourceUtil.a(workSource, clientIdentity.f71950a, clientIdentity.f71951b);
                }
            }
            builder.n(workSource);
        }
        if (z2) {
            builder.c(1);
        }
        if (z3) {
            builder.l(2);
        }
        if (z4) {
            builder.m(true);
        }
        if (z5) {
            builder.k(true);
        }
        if (j3 != Long.MAX_VALUE) {
            builder.e(j3);
        }
        this.zza = builder.a();
    }

    @Deprecated
    public static zzeg zza(String str, LocationRequest locationRequest) {
        return new zzeg(locationRequest, null, false, false, false, false, null, Long.MAX_VALUE);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzeg) {
            return Objects.b(this.zza, ((zzeg) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final String toString() {
        return this.zza.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.E(parcel, 1, this.zza, i3, false);
        SafeParcelWriter.b(parcel, iA);
    }
}
