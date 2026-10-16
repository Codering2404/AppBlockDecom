package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.WorkSource;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.util.WorkSourceUtil;
import com.google.android.gms.internal.location.zzeo;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class CurrentLocationRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<CurrentLocationRequest> CREATOR = new zzj();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f72872a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f72873b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f72874c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f72875d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f72876f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f72877g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final WorkSource f72878h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final com.google.android.gms.internal.location.zze f72879i;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f72880a = 10000;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f72881b = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f72882c = 102;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f72883d = Long.MAX_VALUE;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final boolean f72884e = false;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final int f72885f = 0;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final WorkSource f72886g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final com.google.android.gms.internal.location.zze f72887h = null;

        public CurrentLocationRequest a() {
            return new CurrentLocationRequest(this.f72880a, this.f72881b, this.f72882c, this.f72883d, this.f72884e, this.f72885f, new WorkSource(this.f72886g), this.f72887h);
        }

        public Builder b(long j3) {
            Preconditions.b(j3 > 0, "durationMillis must be greater than 0");
            this.f72883d = j3;
            return this;
        }

        public Builder c(int i3) {
            zzan.a(i3);
            this.f72882c = i3;
            return this;
        }
    }

    CurrentLocationRequest(long j3, int i3, int i4, long j4, boolean z2, int i5, WorkSource workSource, com.google.android.gms.internal.location.zze zzeVar) {
        this.f72872a = j3;
        this.f72873b = i3;
        this.f72874c = i4;
        this.f72875d = j4;
        this.f72876f = z2;
        this.f72877g = i5;
        this.f72878h = workSource;
        this.f72879i = zzeVar;
    }

    public long M() {
        return this.f72875d;
    }

    public int N() {
        return this.f72873b;
    }

    public long O() {
        return this.f72872a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof CurrentLocationRequest)) {
            return false;
        }
        CurrentLocationRequest currentLocationRequest = (CurrentLocationRequest) obj;
        return this.f72872a == currentLocationRequest.f72872a && this.f72873b == currentLocationRequest.f72873b && this.f72874c == currentLocationRequest.f72874c && this.f72875d == currentLocationRequest.f72875d && this.f72876f == currentLocationRequest.f72876f && this.f72877g == currentLocationRequest.f72877g && Objects.b(this.f72878h, currentLocationRequest.f72878h) && Objects.b(this.f72879i, currentLocationRequest.f72879i);
    }

    public int g0() {
        return this.f72874c;
    }

    public int hashCode() {
        return Objects.c(Long.valueOf(this.f72872a), Integer.valueOf(this.f72873b), Integer.valueOf(this.f72874c), Long.valueOf(this.f72875d));
    }

    public final int j0() {
        return this.f72877g;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CurrentLocationRequest[");
        sb.append(zzan.b(this.f72874c));
        if (this.f72872a != Long.MAX_VALUE) {
            sb.append(", maxAge=");
            zzeo.zzc(this.f72872a, sb);
        }
        if (this.f72875d != Long.MAX_VALUE) {
            sb.append(", duration=");
            sb.append(this.f72875d);
            sb.append("ms");
        }
        if (this.f72873b != 0) {
            sb.append(", ");
            sb.append(zzq.b(this.f72873b));
        }
        if (this.f72876f) {
            sb.append(", bypass");
        }
        if (this.f72877g != 0) {
            sb.append(", ");
            sb.append(zzar.b(this.f72877g));
        }
        if (!WorkSourceUtil.d(this.f72878h)) {
            sb.append(", workSource=");
            sb.append(this.f72878h);
        }
        if (this.f72879i != null) {
            sb.append(", impersonation=");
            sb.append(this.f72879i);
        }
        sb.append(']');
        return sb.toString();
    }

    public final WorkSource w0() {
        return this.f72878h;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.z(parcel, 1, O());
        SafeParcelWriter.u(parcel, 2, N());
        SafeParcelWriter.u(parcel, 3, g0());
        SafeParcelWriter.z(parcel, 4, M());
        SafeParcelWriter.g(parcel, 5, this.f72876f);
        SafeParcelWriter.E(parcel, 6, this.f72878h, i3, false);
        SafeParcelWriter.u(parcel, 7, this.f72877g);
        SafeParcelWriter.E(parcel, 9, this.f72879i, i3, false);
        SafeParcelWriter.b(parcel, iA);
    }

    public final boolean zza() {
        return this.f72876f;
    }
}
