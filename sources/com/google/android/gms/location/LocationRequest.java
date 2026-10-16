package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.os.WorkSource;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.util.WorkSourceUtil;
import com.google.android.gms.internal.location.zzeo;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class LocationRequest extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<LocationRequest> CREATOR = new zzaf();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f72935a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f72936b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f72937c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f72938d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f72939f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f72940g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f72941h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f72942i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f72943j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final int f72944k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final int f72945l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final boolean f72946m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final WorkSource f72947n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final com.google.android.gms.internal.location.zze f72948o;

    @Deprecated
    public LocationRequest() {
        this(102, 3600000L, 600000L, 0L, Long.MAX_VALUE, Long.MAX_VALUE, Api.BaseClientBuilder.API_PRIORITY_OTHER, 0.0f, true, 3600000L, 0, 0, false, new WorkSource(), null);
    }

    public static LocationRequest M() {
        return new LocationRequest(102, 3600000L, 600000L, 0L, Long.MAX_VALUE, Long.MAX_VALUE, Api.BaseClientBuilder.API_PRIORITY_OTHER, 0.0f, true, 3600000L, 0, 0, false, new WorkSource(), null);
    }

    private static String V2(long j3) {
        return j3 == Long.MAX_VALUE ? "∞" : zzeo.zzb(j3);
    }

    public long J2() {
        return this.f72937c;
    }

    public int K2() {
        return this.f72935a;
    }

    public boolean L2() {
        long j3 = this.f72938d;
        return j3 > 0 && (j3 >> 1) >= this.f72936b;
    }

    public boolean M2() {
        return this.f72935a == 105;
    }

    public long N() {
        return this.f72939f;
    }

    public boolean N2() {
        return this.f72942i;
    }

    public int O() {
        return this.f72944k;
    }

    public LocationRequest O2(long j3) {
        Preconditions.b(j3 > 0, "durationMillis must be greater than 0");
        this.f72939f = j3;
        return this;
    }

    public LocationRequest P2(long j3) {
        Preconditions.c(j3 >= 0, "illegal fastest interval: %d", Long.valueOf(j3));
        this.f72937c = j3;
        return this;
    }

    public LocationRequest Q2(long j3) {
        Preconditions.b(j3 >= 0, "intervalMillis must be greater than or equal to 0");
        long j4 = this.f72937c;
        long j5 = this.f72936b;
        if (j4 == j5 / 6) {
            this.f72937c = j3 / 6;
        }
        if (this.f72943j == j5) {
            this.f72943j = j3;
        }
        this.f72936b = j3;
        return this;
    }

    public LocationRequest R2(int i3) {
        zzan.a(i3);
        this.f72935a = i3;
        return this;
    }

    public final boolean S2() {
        return this.f72946m;
    }

    public final WorkSource T2() {
        return this.f72947n;
    }

    public final com.google.android.gms.internal.location.zze U2() {
        return this.f72948o;
    }

    public boolean equals(Object obj) {
        if (obj instanceof LocationRequest) {
            LocationRequest locationRequest = (LocationRequest) obj;
            if (this.f72935a == locationRequest.f72935a && ((M2() || this.f72936b == locationRequest.f72936b) && this.f72937c == locationRequest.f72937c && L2() == locationRequest.L2() && ((!L2() || this.f72938d == locationRequest.f72938d) && this.f72939f == locationRequest.f72939f && this.f72940g == locationRequest.f72940g && this.f72941h == locationRequest.f72941h && this.f72942i == locationRequest.f72942i && this.f72944k == locationRequest.f72944k && this.f72945l == locationRequest.f72945l && this.f72946m == locationRequest.f72946m && this.f72947n.equals(locationRequest.f72947n) && Objects.b(this.f72948o, locationRequest.f72948o)))) {
                return true;
            }
        }
        return false;
    }

    public long g0() {
        return this.f72936b;
    }

    public float h1() {
        return this.f72941h;
    }

    public int hashCode() {
        return Objects.c(Integer.valueOf(this.f72935a), Long.valueOf(this.f72936b), Long.valueOf(this.f72937c), this.f72947n);
    }

    public long j0() {
        return this.f72943j;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Request[");
        if (M2()) {
            sb.append(zzan.b(this.f72935a));
            if (this.f72938d > 0) {
                sb.append("/");
                zzeo.zzc(this.f72938d, sb);
            }
        } else {
            sb.append("@");
            if (L2()) {
                zzeo.zzc(this.f72936b, sb);
                sb.append("/");
                zzeo.zzc(this.f72938d, sb);
            } else {
                zzeo.zzc(this.f72936b, sb);
            }
            sb.append(" ");
            sb.append(zzan.b(this.f72935a));
        }
        if (M2() || this.f72937c != this.f72936b) {
            sb.append(", minUpdateInterval=");
            sb.append(V2(this.f72937c));
        }
        if (this.f72941h > 0.0d) {
            sb.append(", minUpdateDistance=");
            sb.append(this.f72941h);
        }
        if (!M2() ? this.f72943j != this.f72936b : this.f72943j != Long.MAX_VALUE) {
            sb.append(", maxUpdateAge=");
            sb.append(V2(this.f72943j));
        }
        if (this.f72939f != Long.MAX_VALUE) {
            sb.append(", duration=");
            zzeo.zzc(this.f72939f, sb);
        }
        if (this.f72940g != Integer.MAX_VALUE) {
            sb.append(", maxUpdates=");
            sb.append(this.f72940g);
        }
        if (this.f72945l != 0) {
            sb.append(", ");
            sb.append(zzar.b(this.f72945l));
        }
        if (this.f72944k != 0) {
            sb.append(", ");
            sb.append(zzq.b(this.f72944k));
        }
        if (this.f72942i) {
            sb.append(", waitForAccurateLocation");
        }
        if (this.f72946m) {
            sb.append(", bypass");
        }
        if (!WorkSourceUtil.d(this.f72947n)) {
            sb.append(", ");
            sb.append(this.f72947n);
        }
        if (this.f72948o != null) {
            sb.append(", impersonation=");
            sb.append(this.f72948o);
        }
        sb.append(']');
        return sb.toString();
    }

    public long w0() {
        return this.f72938d;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.u(parcel, 1, K2());
        SafeParcelWriter.z(parcel, 2, g0());
        SafeParcelWriter.z(parcel, 3, J2());
        SafeParcelWriter.u(parcel, 6, z0());
        SafeParcelWriter.q(parcel, 7, h1());
        SafeParcelWriter.z(parcel, 8, w0());
        SafeParcelWriter.g(parcel, 9, N2());
        SafeParcelWriter.z(parcel, 10, N());
        SafeParcelWriter.z(parcel, 11, j0());
        SafeParcelWriter.u(parcel, 12, O());
        SafeParcelWriter.u(parcel, 13, this.f72945l);
        SafeParcelWriter.g(parcel, 15, this.f72946m);
        SafeParcelWriter.E(parcel, 16, this.f72947n, i3, false);
        SafeParcelWriter.E(parcel, 17, this.f72948o, i3, false);
        SafeParcelWriter.b(parcel, iA);
    }

    public int z0() {
        return this.f72940g;
    }

    public final int zza() {
        return this.f72945l;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f72949a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f72950b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f72951c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f72952d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private long f72953e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f72954f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private float f72955g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f72956h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private long f72957i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private int f72958j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private int f72959k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private boolean f72960l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private WorkSource f72961m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private com.google.android.gms.internal.location.zze f72962n;

        public Builder(int i3, long j3) {
            this(j3);
            j(i3);
        }

        public LocationRequest a() {
            int i3 = this.f72949a;
            long j3 = this.f72950b;
            long jMin = this.f72951c;
            if (jMin == -1) {
                jMin = j3;
            } else if (i3 != 105) {
                jMin = Math.min(jMin, j3);
            }
            long jMax = Math.max(this.f72952d, this.f72950b);
            long j4 = this.f72953e;
            int i4 = this.f72954f;
            float f3 = this.f72955g;
            boolean z2 = this.f72956h;
            long j5 = this.f72957i;
            if (j5 == -1) {
                j5 = this.f72950b;
            }
            return new LocationRequest(i3, j3, jMin, jMax, Long.MAX_VALUE, j4, i4, f3, z2, j5, this.f72958j, this.f72959k, this.f72960l, new WorkSource(this.f72961m), this.f72962n);
        }

        public Builder b(long j3) {
            Preconditions.b(j3 > 0, "durationMillis must be greater than 0");
            this.f72953e = j3;
            return this;
        }

        public Builder c(int i3) {
            zzq.a(i3);
            this.f72958j = i3;
            return this;
        }

        public Builder d(long j3) {
            Preconditions.b(j3 >= 0, "intervalMillis must be greater than or equal to 0");
            this.f72950b = j3;
            return this;
        }

        public Builder e(long j3) {
            boolean z2 = true;
            if (j3 != -1 && j3 < 0) {
                z2 = false;
            }
            Preconditions.b(z2, "maxUpdateAgeMillis must be greater than or equal to 0, or IMPLICIT_MAX_UPDATE_AGE");
            this.f72957i = j3;
            return this;
        }

        public Builder f(long j3) {
            Preconditions.b(j3 >= 0, "maxUpdateDelayMillis must be greater than or equal to 0");
            this.f72952d = j3;
            return this;
        }

        public Builder g(int i3) {
            Preconditions.b(i3 > 0, "maxUpdates must be greater than 0");
            this.f72954f = i3;
            return this;
        }

        public Builder h(float f3) {
            Preconditions.b(f3 >= 0.0f, "minUpdateDistanceMeters must be greater than or equal to 0");
            this.f72955g = f3;
            return this;
        }

        public Builder i(long j3) {
            boolean z2 = true;
            if (j3 != -1 && j3 < 0) {
                z2 = false;
            }
            Preconditions.b(z2, "minUpdateIntervalMillis must be greater than or equal to 0, or IMPLICIT_MIN_UPDATE_INTERVAL");
            this.f72951c = j3;
            return this;
        }

        public Builder j(int i3) {
            zzan.a(i3);
            this.f72949a = i3;
            return this;
        }

        public Builder k(boolean z2) {
            this.f72956h = z2;
            return this;
        }

        public final Builder l(int i3) {
            zzar.a(i3);
            this.f72959k = i3;
            return this;
        }

        public final Builder m(boolean z2) {
            this.f72960l = z2;
            return this;
        }

        public final Builder n(WorkSource workSource) {
            this.f72961m = workSource;
            return this;
        }

        public Builder(long j3) {
            this.f72949a = 102;
            this.f72951c = -1L;
            this.f72952d = 0L;
            this.f72953e = Long.MAX_VALUE;
            this.f72954f = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            this.f72955g = 0.0f;
            this.f72956h = true;
            this.f72957i = -1L;
            this.f72958j = 0;
            this.f72959k = 0;
            this.f72960l = false;
            this.f72961m = null;
            this.f72962n = null;
            d(j3);
        }

        public Builder(LocationRequest locationRequest) {
            this(locationRequest.K2(), locationRequest.g0());
            i(locationRequest.J2());
            f(locationRequest.w0());
            b(locationRequest.N());
            g(locationRequest.z0());
            h(locationRequest.h1());
            k(locationRequest.N2());
            e(locationRequest.j0());
            c(locationRequest.O());
            int iZza = locationRequest.zza();
            zzar.a(iZza);
            this.f72959k = iZza;
            this.f72960l = locationRequest.S2();
            this.f72961m = locationRequest.T2();
            com.google.android.gms.internal.location.zze zzeVarU2 = locationRequest.U2();
            boolean z2 = true;
            if (zzeVarU2 != null && zzeVarU2.zza()) {
                z2 = false;
            }
            Preconditions.a(z2);
            this.f72962n = zzeVarU2;
        }
    }

    LocationRequest(int i3, long j3, long j4, long j5, long j6, long j7, int i4, float f3, boolean z2, long j8, int i5, int i6, boolean z3, WorkSource workSource, com.google.android.gms.internal.location.zze zzeVar) {
        this.f72935a = i3;
        if (i3 == 105) {
            this.f72936b = Long.MAX_VALUE;
        } else {
            this.f72936b = j3;
        }
        this.f72937c = j4;
        this.f72938d = j5;
        this.f72939f = j6 == Long.MAX_VALUE ? j7 : Math.min(Math.max(1L, j6 - SystemClock.elapsedRealtime()), j7);
        this.f72940g = i4;
        this.f72941h = f3;
        this.f72942i = z2;
        this.f72943j = j8 != -1 ? j8 : j3;
        this.f72944k = i5;
        this.f72945l = i6;
        this.f72946m = z3;
        this.f72947n = workSource;
        this.f72948o = zzeVar;
    }
}
