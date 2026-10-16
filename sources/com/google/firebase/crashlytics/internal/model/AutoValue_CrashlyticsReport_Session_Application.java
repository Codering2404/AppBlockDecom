package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class AutoValue_CrashlyticsReport_Session_Application extends CrashlyticsReport.Session.Application {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f88806a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f88807b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f88808c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final CrashlyticsReport.Session.Application.Organization f88809d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f88810e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f88811f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f88812g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class Builder extends CrashlyticsReport.Session.Application.Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f88813a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f88814b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f88815c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private CrashlyticsReport.Session.Application.Organization f88816d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f88817e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private String f88818f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private String f88819g;

        Builder() {
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application.Builder
        public CrashlyticsReport.Session.Application a() {
            String str;
            String str2 = this.f88813a;
            if (str2 != null && (str = this.f88814b) != null) {
                return new AutoValue_CrashlyticsReport_Session_Application(str2, str, this.f88815c, this.f88816d, this.f88817e, this.f88818f, this.f88819g);
            }
            StringBuilder sb = new StringBuilder();
            if (this.f88813a == null) {
                sb.append(" identifier");
            }
            if (this.f88814b == null) {
                sb.append(" version");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb));
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application.Builder
        public CrashlyticsReport.Session.Application.Builder b(String str) {
            this.f88818f = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application.Builder
        public CrashlyticsReport.Session.Application.Builder c(String str) {
            this.f88819g = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application.Builder
        public CrashlyticsReport.Session.Application.Builder d(String str) {
            this.f88815c = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application.Builder
        public CrashlyticsReport.Session.Application.Builder e(String str) {
            if (str == null) {
                throw new NullPointerException("Null identifier");
            }
            this.f88813a = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application.Builder
        public CrashlyticsReport.Session.Application.Builder f(String str) {
            this.f88817e = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application.Builder
        public CrashlyticsReport.Session.Application.Builder g(String str) {
            if (str == null) {
                throw new NullPointerException("Null version");
            }
            this.f88814b = str;
            return this;
        }
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application
    public String b() {
        return this.f88811f;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application
    public String c() {
        return this.f88812g;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application
    public String d() {
        return this.f88808c;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application
    public String e() {
        return this.f88806a;
    }

    public boolean equals(Object obj) {
        String str;
        CrashlyticsReport.Session.Application.Organization organization;
        String str2;
        String str3;
        String str4;
        if (obj == this) {
            return true;
        }
        if (obj instanceof CrashlyticsReport.Session.Application) {
            CrashlyticsReport.Session.Application application = (CrashlyticsReport.Session.Application) obj;
            if (this.f88806a.equals(application.e()) && this.f88807b.equals(application.h()) && ((str = this.f88808c) != null ? str.equals(application.d()) : application.d() == null) && ((organization = this.f88809d) != null ? organization.equals(application.g()) : application.g() == null) && ((str2 = this.f88810e) != null ? str2.equals(application.f()) : application.f() == null) && ((str3 = this.f88811f) != null ? str3.equals(application.b()) : application.b() == null) && ((str4 = this.f88812g) != null ? str4.equals(application.c()) : application.c() == null)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application
    public String f() {
        return this.f88810e;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application
    public CrashlyticsReport.Session.Application.Organization g() {
        return this.f88809d;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application
    public String h() {
        return this.f88807b;
    }

    public int hashCode() {
        int iHashCode = (((this.f88806a.hashCode() ^ 1000003) * 1000003) ^ this.f88807b.hashCode()) * 1000003;
        String str = this.f88808c;
        int iHashCode2 = (iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        CrashlyticsReport.Session.Application.Organization organization = this.f88809d;
        int iHashCode3 = (iHashCode2 ^ (organization == null ? 0 : organization.hashCode())) * 1000003;
        String str2 = this.f88810e;
        int iHashCode4 = (iHashCode3 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f88811f;
        int iHashCode5 = (iHashCode4 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.f88812g;
        return iHashCode5 ^ (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "Application{identifier=" + this.f88806a + ", version=" + this.f88807b + ", displayVersion=" + this.f88808c + ", organization=" + this.f88809d + ", installationUuid=" + this.f88810e + ", developmentPlatform=" + this.f88811f + ", developmentPlatformVersion=" + this.f88812g + "}";
    }

    private AutoValue_CrashlyticsReport_Session_Application(String str, String str2, String str3, CrashlyticsReport.Session.Application.Organization organization, String str4, String str5, String str6) {
        this.f88806a = str;
        this.f88807b = str2;
        this.f88808c = str3;
        this.f88809d = organization;
        this.f88810e = str4;
        this.f88811f = str5;
        this.f88812g = str6;
    }
}
