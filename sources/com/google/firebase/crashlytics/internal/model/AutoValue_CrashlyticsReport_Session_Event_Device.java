package com.google.firebase.crashlytics.internal.model;

import com.applovin.exoplayer2.common.base.Ascii;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class AutoValue_CrashlyticsReport_Session_Event_Device extends CrashlyticsReport.Session.Event.Device {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Double f88932a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f88933b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f88934c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f88935d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f88936e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f88937f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class Builder extends CrashlyticsReport.Session.Event.Device.Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Double f88938a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f88939b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f88940c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f88941d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private long f88942e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private long f88943f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private byte f88944g;

        Builder() {
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device.Builder
        public CrashlyticsReport.Session.Event.Device a() {
            if (this.f88944g == 31) {
                return new AutoValue_CrashlyticsReport_Session_Event_Device(this.f88938a, this.f88939b, this.f88940c, this.f88941d, this.f88942e, this.f88943f);
            }
            StringBuilder sb = new StringBuilder();
            if ((this.f88944g & 1) == 0) {
                sb.append(" batteryVelocity");
            }
            if ((this.f88944g & 2) == 0) {
                sb.append(" proximityOn");
            }
            if ((this.f88944g & 4) == 0) {
                sb.append(" orientation");
            }
            if ((this.f88944g & 8) == 0) {
                sb.append(" ramUsed");
            }
            if ((this.f88944g & Ascii.DLE) == 0) {
                sb.append(" diskUsed");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb));
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device.Builder
        public CrashlyticsReport.Session.Event.Device.Builder b(Double d3) {
            this.f88938a = d3;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device.Builder
        public CrashlyticsReport.Session.Event.Device.Builder c(int i3) {
            this.f88939b = i3;
            this.f88944g = (byte) (this.f88944g | 1);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device.Builder
        public CrashlyticsReport.Session.Event.Device.Builder d(long j3) {
            this.f88943f = j3;
            this.f88944g = (byte) (this.f88944g | Ascii.DLE);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device.Builder
        public CrashlyticsReport.Session.Event.Device.Builder e(int i3) {
            this.f88941d = i3;
            this.f88944g = (byte) (this.f88944g | 4);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device.Builder
        public CrashlyticsReport.Session.Event.Device.Builder f(boolean z2) {
            this.f88940c = z2;
            this.f88944g = (byte) (this.f88944g | 2);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device.Builder
        public CrashlyticsReport.Session.Event.Device.Builder g(long j3) {
            this.f88942e = j3;
            this.f88944g = (byte) (this.f88944g | 8);
            return this;
        }
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device
    public Double b() {
        return this.f88932a;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device
    public int c() {
        return this.f88933b;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device
    public long d() {
        return this.f88937f;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device
    public int e() {
        return this.f88935d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CrashlyticsReport.Session.Event.Device) {
            CrashlyticsReport.Session.Event.Device device = (CrashlyticsReport.Session.Event.Device) obj;
            Double d3 = this.f88932a;
            if (d3 != null ? d3.equals(device.b()) : device.b() == null) {
                if (this.f88933b == device.c() && this.f88934c == device.g() && this.f88935d == device.e() && this.f88936e == device.f() && this.f88937f == device.d()) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device
    public long f() {
        return this.f88936e;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device
    public boolean g() {
        return this.f88934c;
    }

    public int hashCode() {
        Double d3 = this.f88932a;
        int iHashCode = ((((((((d3 == null ? 0 : d3.hashCode()) ^ 1000003) * 1000003) ^ this.f88933b) * 1000003) ^ (this.f88934c ? 1231 : 1237)) * 1000003) ^ this.f88935d) * 1000003;
        long j3 = this.f88936e;
        long j4 = this.f88937f;
        return ((iHashCode ^ ((int) (j3 ^ (j3 >>> 32)))) * 1000003) ^ ((int) (j4 ^ (j4 >>> 32)));
    }

    public String toString() {
        return "Device{batteryLevel=" + this.f88932a + ", batteryVelocity=" + this.f88933b + ", proximityOn=" + this.f88934c + ", orientation=" + this.f88935d + ", ramUsed=" + this.f88936e + ", diskUsed=" + this.f88937f + "}";
    }

    private AutoValue_CrashlyticsReport_Session_Event_Device(Double d3, int i3, boolean z2, int i4, long j3, long j4) {
        this.f88932a = d3;
        this.f88933b = i3;
        this.f88934c = z2;
        this.f88935d = i4;
        this.f88936e = j3;
        this.f88937f = j4;
    }
}
