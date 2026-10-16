package com.google.android.gms.location;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.internal.location.zzek;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public interface Geofence {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private double f72906e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private double f72907f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private float f72908g;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f72902a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f72903b = 3;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f72904c = -1;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private short f72905d = -1;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f72909h = 0;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f72910i = -1;

        public Geofence a() {
            if (this.f72902a == null) {
                throw new IllegalArgumentException("Request ID not set.");
            }
            int i3 = this.f72903b;
            if (i3 == 0) {
                throw new IllegalArgumentException("Transitions types not set.");
            }
            if ((i3 & 4) != 0 && this.f72910i < 0) {
                throw new IllegalArgumentException("Non-negative loitering delay needs to be set when transition types include GEOFENCE_TRANSITION_DWELL.");
            }
            if (this.f72904c == Long.MIN_VALUE) {
                throw new IllegalArgumentException("Expiration not set.");
            }
            if (this.f72905d == -1) {
                throw new IllegalArgumentException("Geofence region not set.");
            }
            if (this.f72909h >= 0) {
                return new zzek(this.f72902a, this.f72903b, (short) 1, this.f72906e, this.f72907f, this.f72908g, this.f72904c, this.f72909h, this.f72910i);
            }
            throw new IllegalArgumentException("Notification responsiveness should be nonnegative.");
        }

        public Builder b(double d3, double d4, float f3) {
            boolean z2 = d3 >= -90.0d && d3 <= 90.0d;
            StringBuilder sb = new StringBuilder(String.valueOf(d3).length() + 18);
            sb.append("Invalid latitude: ");
            sb.append(d3);
            Preconditions.b(z2, sb.toString());
            boolean z3 = d4 >= -180.0d && d4 <= 180.0d;
            StringBuilder sb2 = new StringBuilder(String.valueOf(d4).length() + 19);
            sb2.append("Invalid longitude: ");
            sb2.append(d4);
            Preconditions.b(z3, sb2.toString());
            boolean z4 = f3 > 0.0f;
            StringBuilder sb3 = new StringBuilder(String.valueOf(f3).length() + 16);
            sb3.append("Invalid radius: ");
            sb3.append(f3);
            Preconditions.b(z4, sb3.toString());
            this.f72905d = (short) 1;
            this.f72906e = d3;
            this.f72907f = d4;
            this.f72908g = f3;
            return this;
        }

        public Builder c(long j3) {
            if (j3 < 0) {
                this.f72904c = -1L;
                return this;
            }
            this.f72904c = DefaultClock.c().a() + j3;
            return this;
        }

        public Builder d(int i3) {
            this.f72910i = i3;
            return this;
        }

        public Builder e(String str) {
            this.f72902a = (String) Preconditions.n(str, "Request ID can't be set to null");
            return this;
        }

        public Builder f(int i3) {
            this.f72903b = i3;
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public @interface GeofenceTransition {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public @interface TransitionTypes {
    }

    String getRequestId();
}
