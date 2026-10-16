package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class AutoValue_CrashlyticsReport_Session_Event_Application extends CrashlyticsReport.Session.Event.Application {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CrashlyticsReport.Session.Event.Application.Execution f88853a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f88854b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f88855c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Boolean f88856d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final CrashlyticsReport.Session.Event.Application.ProcessDetails f88857e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List f88858f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f88859g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class Builder extends CrashlyticsReport.Session.Event.Application.Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private CrashlyticsReport.Session.Event.Application.Execution f88860a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private List f88861b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private List f88862c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Boolean f88863d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private CrashlyticsReport.Session.Event.Application.ProcessDetails f88864e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private List f88865f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f88866g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private byte f88867h;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Builder
        public CrashlyticsReport.Session.Event.Application a() {
            CrashlyticsReport.Session.Event.Application.Execution execution;
            if (this.f88867h == 1 && (execution = this.f88860a) != null) {
                return new AutoValue_CrashlyticsReport_Session_Event_Application(execution, this.f88861b, this.f88862c, this.f88863d, this.f88864e, this.f88865f, this.f88866g);
            }
            StringBuilder sb = new StringBuilder();
            if (this.f88860a == null) {
                sb.append(" execution");
            }
            if ((1 & this.f88867h) == 0) {
                sb.append(" uiOrientation");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb));
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Builder
        public CrashlyticsReport.Session.Event.Application.Builder b(List list) {
            this.f88865f = list;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Builder
        public CrashlyticsReport.Session.Event.Application.Builder c(Boolean bool) {
            this.f88863d = bool;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Builder
        public CrashlyticsReport.Session.Event.Application.Builder d(CrashlyticsReport.Session.Event.Application.ProcessDetails processDetails) {
            this.f88864e = processDetails;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Builder
        public CrashlyticsReport.Session.Event.Application.Builder e(List list) {
            this.f88861b = list;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Builder
        public CrashlyticsReport.Session.Event.Application.Builder f(CrashlyticsReport.Session.Event.Application.Execution execution) {
            if (execution == null) {
                throw new NullPointerException("Null execution");
            }
            this.f88860a = execution;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Builder
        public CrashlyticsReport.Session.Event.Application.Builder g(List list) {
            this.f88862c = list;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Builder
        public CrashlyticsReport.Session.Event.Application.Builder h(int i3) {
            this.f88866g = i3;
            this.f88867h = (byte) (this.f88867h | 1);
            return this;
        }

        Builder() {
        }

        private Builder(CrashlyticsReport.Session.Event.Application application) {
            this.f88860a = application.f();
            this.f88861b = application.e();
            this.f88862c = application.g();
            this.f88863d = application.c();
            this.f88864e = application.d();
            this.f88865f = application.b();
            this.f88866g = application.h();
            this.f88867h = (byte) 1;
        }
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application
    public List b() {
        return this.f88858f;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application
    public Boolean c() {
        return this.f88856d;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application
    public CrashlyticsReport.Session.Event.Application.ProcessDetails d() {
        return this.f88857e;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application
    public List e() {
        return this.f88854b;
    }

    public boolean equals(Object obj) {
        List list;
        List list2;
        Boolean bool;
        CrashlyticsReport.Session.Event.Application.ProcessDetails processDetails;
        List list3;
        if (obj == this) {
            return true;
        }
        if (obj instanceof CrashlyticsReport.Session.Event.Application) {
            CrashlyticsReport.Session.Event.Application application = (CrashlyticsReport.Session.Event.Application) obj;
            if (this.f88853a.equals(application.f()) && ((list = this.f88854b) != null ? list.equals(application.e()) : application.e() == null) && ((list2 = this.f88855c) != null ? list2.equals(application.g()) : application.g() == null) && ((bool = this.f88856d) != null ? bool.equals(application.c()) : application.c() == null) && ((processDetails = this.f88857e) != null ? processDetails.equals(application.d()) : application.d() == null) && ((list3 = this.f88858f) != null ? list3.equals(application.b()) : application.b() == null) && this.f88859g == application.h()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application
    public CrashlyticsReport.Session.Event.Application.Execution f() {
        return this.f88853a;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application
    public List g() {
        return this.f88855c;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application
    public int h() {
        return this.f88859g;
    }

    public int hashCode() {
        int iHashCode = (this.f88853a.hashCode() ^ 1000003) * 1000003;
        List list = this.f88854b;
        int iHashCode2 = (iHashCode ^ (list == null ? 0 : list.hashCode())) * 1000003;
        List list2 = this.f88855c;
        int iHashCode3 = (iHashCode2 ^ (list2 == null ? 0 : list2.hashCode())) * 1000003;
        Boolean bool = this.f88856d;
        int iHashCode4 = (iHashCode3 ^ (bool == null ? 0 : bool.hashCode())) * 1000003;
        CrashlyticsReport.Session.Event.Application.ProcessDetails processDetails = this.f88857e;
        int iHashCode5 = (iHashCode4 ^ (processDetails == null ? 0 : processDetails.hashCode())) * 1000003;
        List list3 = this.f88858f;
        return ((iHashCode5 ^ (list3 != null ? list3.hashCode() : 0)) * 1000003) ^ this.f88859g;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application
    public CrashlyticsReport.Session.Event.Application.Builder i() {
        return new Builder(this);
    }

    public String toString() {
        return "Application{execution=" + this.f88853a + ", customAttributes=" + this.f88854b + ", internalKeys=" + this.f88855c + ", background=" + this.f88856d + ", currentProcessDetails=" + this.f88857e + ", appProcessDetails=" + this.f88858f + ", uiOrientation=" + this.f88859g + "}";
    }

    private AutoValue_CrashlyticsReport_Session_Event_Application(CrashlyticsReport.Session.Event.Application.Execution execution, List list, List list2, Boolean bool, CrashlyticsReport.Session.Event.Application.ProcessDetails processDetails, List list3, int i3) {
        this.f88853a = execution;
        this.f88854b = list;
        this.f88855c = list2;
        this.f88856d = bool;
        this.f88857e = processDetails;
        this.f88858f = list3;
        this.f88859g = i3;
    }
}
