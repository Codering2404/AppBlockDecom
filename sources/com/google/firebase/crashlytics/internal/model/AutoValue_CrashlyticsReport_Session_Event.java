package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class AutoValue_CrashlyticsReport_Session_Event extends CrashlyticsReport.Session.Event {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f88840a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f88841b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final CrashlyticsReport.Session.Event.Application f88842c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final CrashlyticsReport.Session.Event.Device f88843d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final CrashlyticsReport.Session.Event.Log f88844e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final CrashlyticsReport.Session.Event.RolloutsState f88845f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class Builder extends CrashlyticsReport.Session.Event.Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f88846a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f88847b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private CrashlyticsReport.Session.Event.Application f88848c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private CrashlyticsReport.Session.Event.Device f88849d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private CrashlyticsReport.Session.Event.Log f88850e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private CrashlyticsReport.Session.Event.RolloutsState f88851f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private byte f88852g;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Builder
        public CrashlyticsReport.Session.Event a() {
            String str;
            CrashlyticsReport.Session.Event.Application application;
            CrashlyticsReport.Session.Event.Device device;
            if (this.f88852g == 1 && (str = this.f88847b) != null && (application = this.f88848c) != null && (device = this.f88849d) != null) {
                return new AutoValue_CrashlyticsReport_Session_Event(this.f88846a, str, application, device, this.f88850e, this.f88851f);
            }
            StringBuilder sb = new StringBuilder();
            if ((1 & this.f88852g) == 0) {
                sb.append(" timestamp");
            }
            if (this.f88847b == null) {
                sb.append(" type");
            }
            if (this.f88848c == null) {
                sb.append(" app");
            }
            if (this.f88849d == null) {
                sb.append(" device");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb));
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Builder
        public CrashlyticsReport.Session.Event.Builder b(CrashlyticsReport.Session.Event.Application application) {
            if (application == null) {
                throw new NullPointerException("Null app");
            }
            this.f88848c = application;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Builder
        public CrashlyticsReport.Session.Event.Builder c(CrashlyticsReport.Session.Event.Device device) {
            if (device == null) {
                throw new NullPointerException("Null device");
            }
            this.f88849d = device;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Builder
        public CrashlyticsReport.Session.Event.Builder d(CrashlyticsReport.Session.Event.Log log) {
            this.f88850e = log;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Builder
        public CrashlyticsReport.Session.Event.Builder e(CrashlyticsReport.Session.Event.RolloutsState rolloutsState) {
            this.f88851f = rolloutsState;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Builder
        public CrashlyticsReport.Session.Event.Builder f(long j3) {
            this.f88846a = j3;
            this.f88852g = (byte) (this.f88852g | 1);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Builder
        public CrashlyticsReport.Session.Event.Builder g(String str) {
            if (str == null) {
                throw new NullPointerException("Null type");
            }
            this.f88847b = str;
            return this;
        }

        Builder() {
        }

        private Builder(CrashlyticsReport.Session.Event event) {
            this.f88846a = event.f();
            this.f88847b = event.g();
            this.f88848c = event.b();
            this.f88849d = event.c();
            this.f88850e = event.d();
            this.f88851f = event.e();
            this.f88852g = (byte) 1;
        }
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event
    public CrashlyticsReport.Session.Event.Application b() {
        return this.f88842c;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event
    public CrashlyticsReport.Session.Event.Device c() {
        return this.f88843d;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event
    public CrashlyticsReport.Session.Event.Log d() {
        return this.f88844e;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event
    public CrashlyticsReport.Session.Event.RolloutsState e() {
        return this.f88845f;
    }

    public boolean equals(Object obj) {
        CrashlyticsReport.Session.Event.Log log;
        CrashlyticsReport.Session.Event.RolloutsState rolloutsState;
        if (obj == this) {
            return true;
        }
        if (obj instanceof CrashlyticsReport.Session.Event) {
            CrashlyticsReport.Session.Event event = (CrashlyticsReport.Session.Event) obj;
            if (this.f88840a == event.f() && this.f88841b.equals(event.g()) && this.f88842c.equals(event.b()) && this.f88843d.equals(event.c()) && ((log = this.f88844e) != null ? log.equals(event.d()) : event.d() == null) && ((rolloutsState = this.f88845f) != null ? rolloutsState.equals(event.e()) : event.e() == null)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event
    public long f() {
        return this.f88840a;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event
    public String g() {
        return this.f88841b;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event
    public CrashlyticsReport.Session.Event.Builder h() {
        return new Builder(this);
    }

    public int hashCode() {
        long j3 = this.f88840a;
        int iHashCode = (((((((((int) (j3 ^ (j3 >>> 32))) ^ 1000003) * 1000003) ^ this.f88841b.hashCode()) * 1000003) ^ this.f88842c.hashCode()) * 1000003) ^ this.f88843d.hashCode()) * 1000003;
        CrashlyticsReport.Session.Event.Log log = this.f88844e;
        int iHashCode2 = (iHashCode ^ (log == null ? 0 : log.hashCode())) * 1000003;
        CrashlyticsReport.Session.Event.RolloutsState rolloutsState = this.f88845f;
        return iHashCode2 ^ (rolloutsState != null ? rolloutsState.hashCode() : 0);
    }

    public String toString() {
        return "Event{timestamp=" + this.f88840a + ", type=" + this.f88841b + ", app=" + this.f88842c + ", device=" + this.f88843d + ", log=" + this.f88844e + ", rollouts=" + this.f88845f + "}";
    }

    private AutoValue_CrashlyticsReport_Session_Event(long j3, String str, CrashlyticsReport.Session.Event.Application application, CrashlyticsReport.Session.Event.Device device, CrashlyticsReport.Session.Event.Log log, CrashlyticsReport.Session.Event.RolloutsState rolloutsState) {
        this.f88840a = j3;
        this.f88841b = str;
        this.f88842c = application;
        this.f88843d = device;
        this.f88844e = log;
        this.f88845f = rolloutsState;
    }
}
