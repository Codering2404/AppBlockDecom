package com.google.android.gms.location;

import android.location.Location;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class LocationResult extends AbstractSafeParcelable implements ReflectedParcelable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f72964a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final List f72963b = Collections.EMPTY_LIST;
    public static final Parcelable.Creator<LocationResult> CREATOR = new zzag();

    LocationResult(List list) {
        this.f72964a = list;
    }

    public Location M() {
        int size = this.f72964a.size();
        if (size == 0) {
            return null;
        }
        return (Location) this.f72964a.get(size - 1);
    }

    public List N() {
        return this.f72964a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof LocationResult)) {
            return false;
        }
        LocationResult locationResult = (LocationResult) obj;
        if (Build.VERSION.SDK_INT >= 31) {
            return this.f72964a.equals(locationResult.f72964a);
        }
        if (this.f72964a.size() != locationResult.f72964a.size()) {
            return false;
        }
        Iterator it = locationResult.f72964a.iterator();
        for (Location location : this.f72964a) {
            Location location2 = (Location) it.next();
            if (Double.compare(location.getLatitude(), location2.getLatitude()) != 0 || Double.compare(location.getLongitude(), location2.getLongitude()) != 0 || location.getTime() != location2.getTime() || location.getElapsedRealtimeNanos() != location2.getElapsedRealtimeNanos() || !Objects.b(location.getProvider(), location2.getProvider())) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        return Objects.c(this.f72964a);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LocationResult");
        int i3 = zzak.f73005d;
        List list = this.f72964a;
        sb.ensureCapacity(list.size() * 100);
        sb.append("[");
        Iterator it = list.iterator();
        boolean z2 = false;
        while (it.hasNext()) {
            zzak.a((Location) it.next(), sb);
            sb.append(", ");
            z2 = true;
        }
        if (z2) {
            sb.setLength(sb.length() - 2);
        }
        sb.append("]");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.K(parcel, 1, N(), false);
        SafeParcelWriter.b(parcel, iA);
    }
}
