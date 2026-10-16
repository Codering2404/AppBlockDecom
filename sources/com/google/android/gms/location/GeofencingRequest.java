package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.location.zzek;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public class GeofencingRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<GeofencingRequest> CREATOR = new zzp();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f72915a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f72916b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f72917c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List f72918a = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f72919b = 5;

        public Builder a(Geofence geofence) {
            Preconditions.b(geofence instanceof zzek, "Geofence must be created using Geofence.Builder.");
            this.f72918a.add((zzek) geofence);
            return this;
        }

        public Builder b(List list) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                a((Geofence) it.next());
            }
            return this;
        }

        public GeofencingRequest c() {
            Preconditions.b(!this.f72918a.isEmpty(), "No geofence has been added to this request.");
            return new GeofencingRequest(new ArrayList(this.f72918a), this.f72919b, null);
        }

        public Builder d(int i3) {
            this.f72919b = i3 & 7;
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public @interface InitialTrigger {
    }

    GeofencingRequest(List list, int i3, String str) {
        this.f72915a = list;
        this.f72916b = i3;
        this.f72917c = str;
    }

    public List M() {
        return new ArrayList(this.f72915a);
    }

    public int N() {
        return this.f72916b;
    }

    public String toString() {
        String strValueOf = String.valueOf(this.f72915a);
        int length = strValueOf.length();
        int i3 = this.f72916b;
        StringBuilder sb = new StringBuilder(length + 45 + String.valueOf(i3).length() + 1);
        sb.append("GeofencingRequest[geofences=");
        sb.append(strValueOf);
        sb.append(", initialTrigger=");
        sb.append(i3);
        sb.append("]");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        List list = this.f72915a;
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.K(parcel, 1, list, false);
        SafeParcelWriter.u(parcel, 2, N());
        SafeParcelWriter.G(parcel, 4, this.f72917c, false);
        SafeParcelWriter.b(parcel, iA);
    }
}
