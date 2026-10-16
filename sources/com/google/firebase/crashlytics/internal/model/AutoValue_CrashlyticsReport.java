package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class AutoValue_CrashlyticsReport extends CrashlyticsReport {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f88719b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f88720c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f88721d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f88722e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f88723f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f88724g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f88725h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f88726i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final String f88727j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final CrashlyticsReport.Session f88728k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final CrashlyticsReport.FilesPayload f88729l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final CrashlyticsReport.ApplicationExitInfo f88730m;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class Builder extends CrashlyticsReport.Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f88731a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f88732b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f88733c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f88734d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f88735e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private String f88736f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private String f88737g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private String f88738h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private String f88739i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private CrashlyticsReport.Session f88740j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private CrashlyticsReport.FilesPayload f88741k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private CrashlyticsReport.ApplicationExitInfo f88742l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private byte f88743m;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Builder
        public CrashlyticsReport a() {
            if (this.f88743m == 1 && this.f88731a != null && this.f88732b != null && this.f88734d != null && this.f88738h != null && this.f88739i != null) {
                return new AutoValue_CrashlyticsReport(this.f88731a, this.f88732b, this.f88733c, this.f88734d, this.f88735e, this.f88736f, this.f88737g, this.f88738h, this.f88739i, this.f88740j, this.f88741k, this.f88742l);
            }
            StringBuilder sb = new StringBuilder();
            if (this.f88731a == null) {
                sb.append(" sdkVersion");
            }
            if (this.f88732b == null) {
                sb.append(" gmpAppId");
            }
            if ((1 & this.f88743m) == 0) {
                sb.append(" platform");
            }
            if (this.f88734d == null) {
                sb.append(" installationUuid");
            }
            if (this.f88738h == null) {
                sb.append(" buildVersion");
            }
            if (this.f88739i == null) {
                sb.append(" displayVersion");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb));
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Builder
        public CrashlyticsReport.Builder b(CrashlyticsReport.ApplicationExitInfo applicationExitInfo) {
            this.f88742l = applicationExitInfo;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Builder
        public CrashlyticsReport.Builder c(String str) {
            this.f88737g = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Builder
        public CrashlyticsReport.Builder d(String str) {
            if (str == null) {
                throw new NullPointerException("Null buildVersion");
            }
            this.f88738h = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Builder
        public CrashlyticsReport.Builder e(String str) {
            if (str == null) {
                throw new NullPointerException("Null displayVersion");
            }
            this.f88739i = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Builder
        public CrashlyticsReport.Builder f(String str) {
            this.f88736f = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Builder
        public CrashlyticsReport.Builder g(String str) {
            this.f88735e = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Builder
        public CrashlyticsReport.Builder h(String str) {
            if (str == null) {
                throw new NullPointerException("Null gmpAppId");
            }
            this.f88732b = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Builder
        public CrashlyticsReport.Builder i(String str) {
            if (str == null) {
                throw new NullPointerException("Null installationUuid");
            }
            this.f88734d = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Builder
        public CrashlyticsReport.Builder j(CrashlyticsReport.FilesPayload filesPayload) {
            this.f88741k = filesPayload;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Builder
        public CrashlyticsReport.Builder k(int i3) {
            this.f88733c = i3;
            this.f88743m = (byte) (this.f88743m | 1);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Builder
        public CrashlyticsReport.Builder l(String str) {
            if (str == null) {
                throw new NullPointerException("Null sdkVersion");
            }
            this.f88731a = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Builder
        public CrashlyticsReport.Builder m(CrashlyticsReport.Session session) {
            this.f88740j = session;
            return this;
        }

        Builder() {
        }

        private Builder(CrashlyticsReport crashlyticsReport) {
            this.f88731a = crashlyticsReport.m();
            this.f88732b = crashlyticsReport.i();
            this.f88733c = crashlyticsReport.l();
            this.f88734d = crashlyticsReport.j();
            this.f88735e = crashlyticsReport.h();
            this.f88736f = crashlyticsReport.g();
            this.f88737g = crashlyticsReport.d();
            this.f88738h = crashlyticsReport.e();
            this.f88739i = crashlyticsReport.f();
            this.f88740j = crashlyticsReport.n();
            this.f88741k = crashlyticsReport.k();
            this.f88742l = crashlyticsReport.c();
            this.f88743m = (byte) 1;
        }
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport
    public CrashlyticsReport.ApplicationExitInfo c() {
        return this.f88730m;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport
    public String d() {
        return this.f88725h;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport
    public String e() {
        return this.f88726i;
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        String str3;
        CrashlyticsReport.Session session;
        CrashlyticsReport.FilesPayload filesPayload;
        CrashlyticsReport.ApplicationExitInfo applicationExitInfo;
        if (obj == this) {
            return true;
        }
        if (obj instanceof CrashlyticsReport) {
            CrashlyticsReport crashlyticsReport = (CrashlyticsReport) obj;
            if (this.f88719b.equals(crashlyticsReport.m()) && this.f88720c.equals(crashlyticsReport.i()) && this.f88721d == crashlyticsReport.l() && this.f88722e.equals(crashlyticsReport.j()) && ((str = this.f88723f) != null ? str.equals(crashlyticsReport.h()) : crashlyticsReport.h() == null) && ((str2 = this.f88724g) != null ? str2.equals(crashlyticsReport.g()) : crashlyticsReport.g() == null) && ((str3 = this.f88725h) != null ? str3.equals(crashlyticsReport.d()) : crashlyticsReport.d() == null) && this.f88726i.equals(crashlyticsReport.e()) && this.f88727j.equals(crashlyticsReport.f()) && ((session = this.f88728k) != null ? session.equals(crashlyticsReport.n()) : crashlyticsReport.n() == null) && ((filesPayload = this.f88729l) != null ? filesPayload.equals(crashlyticsReport.k()) : crashlyticsReport.k() == null) && ((applicationExitInfo = this.f88730m) != null ? applicationExitInfo.equals(crashlyticsReport.c()) : crashlyticsReport.c() == null)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport
    public String f() {
        return this.f88727j;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport
    public String g() {
        return this.f88724g;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport
    public String h() {
        return this.f88723f;
    }

    public int hashCode() {
        int iHashCode = (((((((this.f88719b.hashCode() ^ 1000003) * 1000003) ^ this.f88720c.hashCode()) * 1000003) ^ this.f88721d) * 1000003) ^ this.f88722e.hashCode()) * 1000003;
        String str = this.f88723f;
        int iHashCode2 = (iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.f88724g;
        int iHashCode3 = (iHashCode2 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f88725h;
        int iHashCode4 = (((((iHashCode3 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003) ^ this.f88726i.hashCode()) * 1000003) ^ this.f88727j.hashCode()) * 1000003;
        CrashlyticsReport.Session session = this.f88728k;
        int iHashCode5 = (iHashCode4 ^ (session == null ? 0 : session.hashCode())) * 1000003;
        CrashlyticsReport.FilesPayload filesPayload = this.f88729l;
        int iHashCode6 = (iHashCode5 ^ (filesPayload == null ? 0 : filesPayload.hashCode())) * 1000003;
        CrashlyticsReport.ApplicationExitInfo applicationExitInfo = this.f88730m;
        return iHashCode6 ^ (applicationExitInfo != null ? applicationExitInfo.hashCode() : 0);
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport
    public String i() {
        return this.f88720c;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport
    public String j() {
        return this.f88722e;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport
    public CrashlyticsReport.FilesPayload k() {
        return this.f88729l;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport
    public int l() {
        return this.f88721d;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport
    public String m() {
        return this.f88719b;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport
    public CrashlyticsReport.Session n() {
        return this.f88728k;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport
    protected CrashlyticsReport.Builder o() {
        return new Builder(this);
    }

    public String toString() {
        return "CrashlyticsReport{sdkVersion=" + this.f88719b + ", gmpAppId=" + this.f88720c + ", platform=" + this.f88721d + ", installationUuid=" + this.f88722e + ", firebaseInstallationId=" + this.f88723f + ", firebaseAuthenticationToken=" + this.f88724g + ", appQualitySessionId=" + this.f88725h + ", buildVersion=" + this.f88726i + ", displayVersion=" + this.f88727j + ", session=" + this.f88728k + ", ndkPayload=" + this.f88729l + ", appExitInfo=" + this.f88730m + "}";
    }

    private AutoValue_CrashlyticsReport(String str, String str2, int i3, String str3, String str4, String str5, String str6, String str7, String str8, CrashlyticsReport.Session session, CrashlyticsReport.FilesPayload filesPayload, CrashlyticsReport.ApplicationExitInfo applicationExitInfo) {
        this.f88719b = str;
        this.f88720c = str2;
        this.f88721d = i3;
        this.f88722e = str3;
        this.f88723f = str4;
        this.f88724g = str5;
        this.f88725h = str6;
        this.f88726i = str7;
        this.f88727j = str8;
        this.f88728k = session;
        this.f88729l = filesPayload;
        this.f88730m = applicationExitInfo;
    }
}
