package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.location.zzeo;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class LastLocationRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<LastLocationRequest> CREATOR = new zzaa();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f72920a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f72921b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f72922c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.google.android.gms.internal.location.zze f72923d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f72924a = Long.MAX_VALUE;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f72925b = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f72926c = false;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final com.google.android.gms.internal.location.zze f72927d = null;

        public LastLocationRequest a() {
            return new LastLocationRequest(this.f72924a, this.f72925b, this.f72926c, this.f72927d);
        }
    }

    LastLocationRequest(long j3, int i3, boolean z2, com.google.android.gms.internal.location.zze zzeVar) {
        this.f72920a = j3;
        this.f72921b = i3;
        this.f72922c = z2;
        this.f72923d = zzeVar;
    }

    public int M() {
        return this.f72921b;
    }

    public long N() {
        return this.f72920a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof LastLocationRequest)) {
            return false;
        }
        LastLocationRequest lastLocationRequest = (LastLocationRequest) obj;
        return this.f72920a == lastLocationRequest.f72920a && this.f72921b == lastLocationRequest.f72921b && this.f72922c == lastLocationRequest.f72922c && Objects.b(this.f72923d, lastLocationRequest.f72923d);
    }

    public int hashCode() {
        return Objects.c(Long.valueOf(this.f72920a), Integer.valueOf(this.f72921b), Boolean.valueOf(this.f72922c));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LastLocationRequest[");
        if (this.f72920a != Long.MAX_VALUE) {
            sb.append("maxAge=");
            zzeo.zzc(this.f72920a, sb);
        }
        if (this.f72921b != 0) {
            sb.append(", ");
            sb.append(zzq.b(this.f72921b));
        }
        if (this.f72922c) {
            sb.append(", bypass");
        }
        if (this.f72923d != null) {
            sb.append(", impersonation=");
            sb.append(this.f72923d);
        }
        sb.append(']');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.z(parcel, 1, N());
        SafeParcelWriter.u(parcel, 2, M());
        SafeParcelWriter.g(parcel, 3, this.f72922c);
        SafeParcelWriter.E(parcel, 5, this.f72923d, i3, false);
        SafeParcelWriter.b(parcel, iA);
    }
}
