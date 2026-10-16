package com.google.firebase.remoteconfig.interop.rollouts;

import com.google.android.material.bottomsheet.lKiE.YznnJpHcAmeoW;
import com.google.firebase.remoteconfig.interop.rollouts.RolloutAssignment;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class AutoValue_RolloutAssignment extends RolloutAssignment {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f89845b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f89846c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f89847d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f89848e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f89849f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class Builder extends RolloutAssignment.Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f89850a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f89851b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f89852c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f89853d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private long f89854e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private byte f89855f;

        Builder() {
        }

        @Override // com.google.firebase.remoteconfig.interop.rollouts.RolloutAssignment.Builder
        public RolloutAssignment a() {
            if (this.f89855f == 1 && this.f89850a != null && this.f89851b != null && this.f89852c != null && this.f89853d != null) {
                return new AutoValue_RolloutAssignment(this.f89850a, this.f89851b, this.f89852c, this.f89853d, this.f89854e);
            }
            StringBuilder sb = new StringBuilder();
            if (this.f89850a == null) {
                sb.append(" rolloutId");
            }
            if (this.f89851b == null) {
                sb.append(" variantId");
            }
            if (this.f89852c == null) {
                sb.append(" parameterKey");
            }
            if (this.f89853d == null) {
                sb.append(" parameterValue");
            }
            if ((1 & this.f89855f) == 0) {
                sb.append(" templateVersion");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb));
        }

        @Override // com.google.firebase.remoteconfig.interop.rollouts.RolloutAssignment.Builder
        public RolloutAssignment.Builder b(String str) {
            if (str == null) {
                throw new NullPointerException("Null parameterKey");
            }
            this.f89852c = str;
            return this;
        }

        @Override // com.google.firebase.remoteconfig.interop.rollouts.RolloutAssignment.Builder
        public RolloutAssignment.Builder c(String str) {
            if (str == null) {
                throw new NullPointerException("Null parameterValue");
            }
            this.f89853d = str;
            return this;
        }

        @Override // com.google.firebase.remoteconfig.interop.rollouts.RolloutAssignment.Builder
        public RolloutAssignment.Builder e(long j3) {
            this.f89854e = j3;
            this.f89855f = (byte) (this.f89855f | 1);
            return this;
        }

        @Override // com.google.firebase.remoteconfig.interop.rollouts.RolloutAssignment.Builder
        public RolloutAssignment.Builder f(String str) {
            if (str == null) {
                throw new NullPointerException("Null variantId");
            }
            this.f89851b = str;
            return this;
        }

        @Override // com.google.firebase.remoteconfig.interop.rollouts.RolloutAssignment.Builder
        public RolloutAssignment.Builder d(String str) {
            if (str == null) {
                throw new NullPointerException(YznnJpHcAmeoW.cBnUwnhHCCddPj);
            }
            this.f89850a = str;
            return this;
        }
    }

    @Override // com.google.firebase.remoteconfig.interop.rollouts.RolloutAssignment
    public String b() {
        return this.f89847d;
    }

    @Override // com.google.firebase.remoteconfig.interop.rollouts.RolloutAssignment
    public String c() {
        return this.f89848e;
    }

    @Override // com.google.firebase.remoteconfig.interop.rollouts.RolloutAssignment
    public String d() {
        return this.f89845b;
    }

    @Override // com.google.firebase.remoteconfig.interop.rollouts.RolloutAssignment
    public long e() {
        return this.f89849f;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof RolloutAssignment) {
            RolloutAssignment rolloutAssignment = (RolloutAssignment) obj;
            if (this.f89845b.equals(rolloutAssignment.d()) && this.f89846c.equals(rolloutAssignment.f()) && this.f89847d.equals(rolloutAssignment.b()) && this.f89848e.equals(rolloutAssignment.c()) && this.f89849f == rolloutAssignment.e()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.firebase.remoteconfig.interop.rollouts.RolloutAssignment
    public String f() {
        return this.f89846c;
    }

    public int hashCode() {
        int iHashCode = (((((((this.f89845b.hashCode() ^ 1000003) * 1000003) ^ this.f89846c.hashCode()) * 1000003) ^ this.f89847d.hashCode()) * 1000003) ^ this.f89848e.hashCode()) * 1000003;
        long j3 = this.f89849f;
        return iHashCode ^ ((int) (j3 ^ (j3 >>> 32)));
    }

    public String toString() {
        return "RolloutAssignment{rolloutId=" + this.f89845b + ", variantId=" + this.f89846c + ", parameterKey=" + this.f89847d + ", parameterValue=" + this.f89848e + ", templateVersion=" + this.f89849f + "}";
    }

    private AutoValue_RolloutAssignment(String str, String str2, String str3, String str4, long j3) {
        this.f89845b = str;
        this.f89846c = str2;
        this.f89847d = str3;
        this.f89848e = str4;
        this.f89849f = j3;
    }
}
