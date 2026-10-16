package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class AutoValue_CrashlyticsReport_Session extends CrashlyticsReport.Session {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f88781a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f88782b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f88783c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f88784d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Long f88785e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f88786f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final CrashlyticsReport.Session.Application f88787g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final CrashlyticsReport.Session.User f88788h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final CrashlyticsReport.Session.OperatingSystem f88789i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final CrashlyticsReport.Session.Device f88790j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final List f88791k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final int f88792l;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class Builder extends CrashlyticsReport.Session.Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f88793a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f88794b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f88795c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f88796d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Long f88797e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f88798f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private CrashlyticsReport.Session.Application f88799g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private CrashlyticsReport.Session.User f88800h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private CrashlyticsReport.Session.OperatingSystem f88801i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private CrashlyticsReport.Session.Device f88802j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private List f88803k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private int f88804l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private byte f88805m;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder
        public CrashlyticsReport.Session a() {
            String str;
            String str2;
            CrashlyticsReport.Session.Application application;
            if (this.f88805m == 7 && (str = this.f88793a) != null && (str2 = this.f88794b) != null && (application = this.f88799g) != null) {
                return new AutoValue_CrashlyticsReport_Session(str, str2, this.f88795c, this.f88796d, this.f88797e, this.f88798f, application, this.f88800h, this.f88801i, this.f88802j, this.f88803k, this.f88804l);
            }
            StringBuilder sb = new StringBuilder();
            if (this.f88793a == null) {
                sb.append(" generator");
            }
            if (this.f88794b == null) {
                sb.append(" identifier");
            }
            if ((this.f88805m & 1) == 0) {
                sb.append(" startedAt");
            }
            if ((this.f88805m & 2) == 0) {
                sb.append(" crashed");
            }
            if (this.f88799g == null) {
                sb.append(" app");
            }
            if ((this.f88805m & 4) == 0) {
                sb.append(" generatorType");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb));
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder
        public CrashlyticsReport.Session.Builder b(CrashlyticsReport.Session.Application application) {
            if (application == null) {
                throw new NullPointerException("Null app");
            }
            this.f88799g = application;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder
        public CrashlyticsReport.Session.Builder c(String str) {
            this.f88795c = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder
        public CrashlyticsReport.Session.Builder d(boolean z2) {
            this.f88798f = z2;
            this.f88805m = (byte) (this.f88805m | 2);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder
        public CrashlyticsReport.Session.Builder e(CrashlyticsReport.Session.Device device) {
            this.f88802j = device;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder
        public CrashlyticsReport.Session.Builder f(Long l3) {
            this.f88797e = l3;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder
        public CrashlyticsReport.Session.Builder g(List list) {
            this.f88803k = list;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder
        public CrashlyticsReport.Session.Builder h(String str) {
            if (str == null) {
                throw new NullPointerException("Null generator");
            }
            this.f88793a = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder
        public CrashlyticsReport.Session.Builder i(int i3) {
            this.f88804l = i3;
            this.f88805m = (byte) (this.f88805m | 4);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder
        public CrashlyticsReport.Session.Builder j(String str) {
            if (str == null) {
                throw new NullPointerException("Null identifier");
            }
            this.f88794b = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder
        public CrashlyticsReport.Session.Builder l(CrashlyticsReport.Session.OperatingSystem operatingSystem) {
            this.f88801i = operatingSystem;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder
        public CrashlyticsReport.Session.Builder m(long j3) {
            this.f88796d = j3;
            this.f88805m = (byte) (this.f88805m | 1);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder
        public CrashlyticsReport.Session.Builder n(CrashlyticsReport.Session.User user) {
            this.f88800h = user;
            return this;
        }

        Builder() {
        }

        private Builder(CrashlyticsReport.Session session) {
            this.f88793a = session.g();
            this.f88794b = session.i();
            this.f88795c = session.c();
            this.f88796d = session.l();
            this.f88797e = session.e();
            this.f88798f = session.n();
            this.f88799g = session.b();
            this.f88800h = session.m();
            this.f88801i = session.k();
            this.f88802j = session.d();
            this.f88803k = session.f();
            this.f88804l = session.h();
            this.f88805m = (byte) 7;
        }
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session
    public CrashlyticsReport.Session.Application b() {
        return this.f88787g;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session
    public String c() {
        return this.f88783c;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session
    public CrashlyticsReport.Session.Device d() {
        return this.f88790j;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session
    public Long e() {
        return this.f88785e;
    }

    public boolean equals(Object obj) {
        String str;
        Long l3;
        CrashlyticsReport.Session.User user;
        CrashlyticsReport.Session.OperatingSystem operatingSystem;
        CrashlyticsReport.Session.Device device;
        List list;
        if (obj == this) {
            return true;
        }
        if (obj instanceof CrashlyticsReport.Session) {
            CrashlyticsReport.Session session = (CrashlyticsReport.Session) obj;
            if (this.f88781a.equals(session.g()) && this.f88782b.equals(session.i()) && ((str = this.f88783c) != null ? str.equals(session.c()) : session.c() == null) && this.f88784d == session.l() && ((l3 = this.f88785e) != null ? l3.equals(session.e()) : session.e() == null) && this.f88786f == session.n() && this.f88787g.equals(session.b()) && ((user = this.f88788h) != null ? user.equals(session.m()) : session.m() == null) && ((operatingSystem = this.f88789i) != null ? operatingSystem.equals(session.k()) : session.k() == null) && ((device = this.f88790j) != null ? device.equals(session.d()) : session.d() == null) && ((list = this.f88791k) != null ? list.equals(session.f()) : session.f() == null) && this.f88792l == session.h()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session
    public List f() {
        return this.f88791k;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session
    public String g() {
        return this.f88781a;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session
    public int h() {
        return this.f88792l;
    }

    public int hashCode() {
        int iHashCode = (((this.f88781a.hashCode() ^ 1000003) * 1000003) ^ this.f88782b.hashCode()) * 1000003;
        String str = this.f88783c;
        int iHashCode2 = str == null ? 0 : str.hashCode();
        long j3 = this.f88784d;
        int i3 = (((iHashCode ^ iHashCode2) * 1000003) ^ ((int) (j3 ^ (j3 >>> 32)))) * 1000003;
        Long l3 = this.f88785e;
        int iHashCode3 = (((((i3 ^ (l3 == null ? 0 : l3.hashCode())) * 1000003) ^ (this.f88786f ? 1231 : 1237)) * 1000003) ^ this.f88787g.hashCode()) * 1000003;
        CrashlyticsReport.Session.User user = this.f88788h;
        int iHashCode4 = (iHashCode3 ^ (user == null ? 0 : user.hashCode())) * 1000003;
        CrashlyticsReport.Session.OperatingSystem operatingSystem = this.f88789i;
        int iHashCode5 = (iHashCode4 ^ (operatingSystem == null ? 0 : operatingSystem.hashCode())) * 1000003;
        CrashlyticsReport.Session.Device device = this.f88790j;
        int iHashCode6 = (iHashCode5 ^ (device == null ? 0 : device.hashCode())) * 1000003;
        List list = this.f88791k;
        return ((iHashCode6 ^ (list != null ? list.hashCode() : 0)) * 1000003) ^ this.f88792l;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session
    public String i() {
        return this.f88782b;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session
    public CrashlyticsReport.Session.OperatingSystem k() {
        return this.f88789i;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session
    public long l() {
        return this.f88784d;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session
    public CrashlyticsReport.Session.User m() {
        return this.f88788h;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session
    public boolean n() {
        return this.f88786f;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session
    public CrashlyticsReport.Session.Builder o() {
        return new Builder(this);
    }

    public String toString() {
        return "Session{generator=" + this.f88781a + ", identifier=" + this.f88782b + ", appQualitySessionId=" + this.f88783c + ", startedAt=" + this.f88784d + ", endedAt=" + this.f88785e + ", crashed=" + this.f88786f + ", app=" + this.f88787g + ", user=" + this.f88788h + ", os=" + this.f88789i + ", device=" + this.f88790j + ", events=" + this.f88791k + ", generatorType=" + this.f88792l + "}";
    }

    private AutoValue_CrashlyticsReport_Session(String str, String str2, String str3, long j3, Long l3, boolean z2, CrashlyticsReport.Session.Application application, CrashlyticsReport.Session.User user, CrashlyticsReport.Session.OperatingSystem operatingSystem, CrashlyticsReport.Session.Device device, List list, int i3) {
        this.f88781a = str;
        this.f88782b = str2;
        this.f88783c = str3;
        this.f88784d = j3;
        this.f88785e = l3;
        this.f88786f = z2;
        this.f88787g = application;
        this.f88788h = user;
        this.f88789i = operatingSystem;
        this.f88790j = device;
        this.f88791k = list;
        this.f88792l = i3;
    }
}
