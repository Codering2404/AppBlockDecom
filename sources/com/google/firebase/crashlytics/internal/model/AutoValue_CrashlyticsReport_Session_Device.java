package com.google.firebase.crashlytics.internal.model;

import com.applovin.exoplayer2.common.base.Ascii;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class AutoValue_CrashlyticsReport_Session_Device extends CrashlyticsReport.Session.Device {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f88821a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f88822b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f88823c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f88824d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f88825e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f88826f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f88827g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f88828h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f88829i;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class Builder extends CrashlyticsReport.Session.Device.Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f88830a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f88831b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f88832c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f88833d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private long f88834e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f88835f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f88836g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private String f88837h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private String f88838i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private byte f88839j;

        Builder() {
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device.Builder
        public CrashlyticsReport.Session.Device a() {
            String str;
            String str2;
            String str3;
            if (this.f88839j == 63 && (str = this.f88831b) != null && (str2 = this.f88837h) != null && (str3 = this.f88838i) != null) {
                return new AutoValue_CrashlyticsReport_Session_Device(this.f88830a, str, this.f88832c, this.f88833d, this.f88834e, this.f88835f, this.f88836g, str2, str3);
            }
            StringBuilder sb = new StringBuilder();
            if ((this.f88839j & 1) == 0) {
                sb.append(" arch");
            }
            if (this.f88831b == null) {
                sb.append(" model");
            }
            if ((this.f88839j & 2) == 0) {
                sb.append(" cores");
            }
            if ((this.f88839j & 4) == 0) {
                sb.append(" ram");
            }
            if ((this.f88839j & 8) == 0) {
                sb.append(" diskSpace");
            }
            if ((this.f88839j & Ascii.DLE) == 0) {
                sb.append(" simulator");
            }
            if ((this.f88839j & 32) == 0) {
                sb.append(" state");
            }
            if (this.f88837h == null) {
                sb.append(" manufacturer");
            }
            if (this.f88838i == null) {
                sb.append(" modelClass");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb));
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device.Builder
        public CrashlyticsReport.Session.Device.Builder b(int i3) {
            this.f88830a = i3;
            this.f88839j = (byte) (this.f88839j | 1);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device.Builder
        public CrashlyticsReport.Session.Device.Builder c(int i3) {
            this.f88832c = i3;
            this.f88839j = (byte) (this.f88839j | 2);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device.Builder
        public CrashlyticsReport.Session.Device.Builder d(long j3) {
            this.f88834e = j3;
            this.f88839j = (byte) (this.f88839j | 8);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device.Builder
        public CrashlyticsReport.Session.Device.Builder e(String str) {
            if (str == null) {
                throw new NullPointerException("Null manufacturer");
            }
            this.f88837h = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device.Builder
        public CrashlyticsReport.Session.Device.Builder f(String str) {
            if (str == null) {
                throw new NullPointerException("Null model");
            }
            this.f88831b = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device.Builder
        public CrashlyticsReport.Session.Device.Builder g(String str) {
            if (str == null) {
                throw new NullPointerException("Null modelClass");
            }
            this.f88838i = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device.Builder
        public CrashlyticsReport.Session.Device.Builder h(long j3) {
            this.f88833d = j3;
            this.f88839j = (byte) (this.f88839j | 4);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device.Builder
        public CrashlyticsReport.Session.Device.Builder i(boolean z2) {
            this.f88835f = z2;
            this.f88839j = (byte) (this.f88839j | Ascii.DLE);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device.Builder
        public CrashlyticsReport.Session.Device.Builder j(int i3) {
            this.f88836g = i3;
            this.f88839j = (byte) (this.f88839j | 32);
            return this;
        }
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device
    public int b() {
        return this.f88821a;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device
    public int c() {
        return this.f88823c;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device
    public long d() {
        return this.f88825e;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device
    public String e() {
        return this.f88828h;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CrashlyticsReport.Session.Device) {
            CrashlyticsReport.Session.Device device = (CrashlyticsReport.Session.Device) obj;
            if (this.f88821a == device.b() && this.f88822b.equals(device.f()) && this.f88823c == device.c() && this.f88824d == device.h() && this.f88825e == device.d() && this.f88826f == device.j() && this.f88827g == device.i() && this.f88828h.equals(device.e()) && this.f88829i.equals(device.g())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device
    public String f() {
        return this.f88822b;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device
    public String g() {
        return this.f88829i;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device
    public long h() {
        return this.f88824d;
    }

    public int hashCode() {
        int iHashCode = (((((this.f88821a ^ 1000003) * 1000003) ^ this.f88822b.hashCode()) * 1000003) ^ this.f88823c) * 1000003;
        long j3 = this.f88824d;
        int i3 = (iHashCode ^ ((int) (j3 ^ (j3 >>> 32)))) * 1000003;
        long j4 = this.f88825e;
        return ((((((((i3 ^ ((int) (j4 ^ (j4 >>> 32)))) * 1000003) ^ (this.f88826f ? 1231 : 1237)) * 1000003) ^ this.f88827g) * 1000003) ^ this.f88828h.hashCode()) * 1000003) ^ this.f88829i.hashCode();
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device
    public int i() {
        return this.f88827g;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device
    public boolean j() {
        return this.f88826f;
    }

    public String toString() {
        return "Device{arch=" + this.f88821a + ", model=" + this.f88822b + ", cores=" + this.f88823c + ", ram=" + this.f88824d + ", diskSpace=" + this.f88825e + ", simulator=" + this.f88826f + ", state=" + this.f88827g + ", manufacturer=" + this.f88828h + ", modelClass=" + this.f88829i + "}";
    }

    private AutoValue_CrashlyticsReport_Session_Device(int i3, String str, int i4, long j3, long j4, boolean z2, int i5, String str2, String str3) {
        this.f88821a = i3;
        this.f88822b = str;
        this.f88823c = i4;
        this.f88824d = j3;
        this.f88825e = j4;
        this.f88826f = z2;
        this.f88827g = i5;
        this.f88828h = str2;
        this.f88829i = str3;
    }
}
