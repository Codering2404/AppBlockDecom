package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class AutoValue_CrashlyticsReport_Session_Event_Application_Execution extends CrashlyticsReport.Session.Event.Application.Execution {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f88868a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CrashlyticsReport.Session.Event.Application.Execution.Exception f88869b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final CrashlyticsReport.ApplicationExitInfo f88870c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final CrashlyticsReport.Session.Event.Application.Execution.Signal f88871d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List f88872e;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class Builder extends CrashlyticsReport.Session.Event.Application.Execution.Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private List f88873a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private CrashlyticsReport.Session.Event.Application.Execution.Exception f88874b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private CrashlyticsReport.ApplicationExitInfo f88875c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private CrashlyticsReport.Session.Event.Application.Execution.Signal f88876d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private List f88877e;

        Builder() {
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Builder
        public CrashlyticsReport.Session.Event.Application.Execution a() {
            List list;
            CrashlyticsReport.Session.Event.Application.Execution.Signal signal = this.f88876d;
            if (signal != null && (list = this.f88877e) != null) {
                return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution(this.f88873a, this.f88874b, this.f88875c, signal, list);
            }
            StringBuilder sb = new StringBuilder();
            if (this.f88876d == null) {
                sb.append(" signal");
            }
            if (this.f88877e == null) {
                sb.append(" binaries");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb));
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Builder
        public CrashlyticsReport.Session.Event.Application.Execution.Builder b(CrashlyticsReport.ApplicationExitInfo applicationExitInfo) {
            this.f88875c = applicationExitInfo;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Builder
        public CrashlyticsReport.Session.Event.Application.Execution.Builder c(List list) {
            if (list == null) {
                throw new NullPointerException("Null binaries");
            }
            this.f88877e = list;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Builder
        public CrashlyticsReport.Session.Event.Application.Execution.Builder d(CrashlyticsReport.Session.Event.Application.Execution.Exception exception) {
            this.f88874b = exception;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Builder
        public CrashlyticsReport.Session.Event.Application.Execution.Builder e(CrashlyticsReport.Session.Event.Application.Execution.Signal signal) {
            if (signal == null) {
                throw new NullPointerException("Null signal");
            }
            this.f88876d = signal;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Builder
        public CrashlyticsReport.Session.Event.Application.Execution.Builder f(List list) {
            this.f88873a = list;
            return this;
        }
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution
    public CrashlyticsReport.ApplicationExitInfo b() {
        return this.f88870c;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution
    public List c() {
        return this.f88872e;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution
    public CrashlyticsReport.Session.Event.Application.Execution.Exception d() {
        return this.f88869b;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution
    public CrashlyticsReport.Session.Event.Application.Execution.Signal e() {
        return this.f88871d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CrashlyticsReport.Session.Event.Application.Execution) {
            CrashlyticsReport.Session.Event.Application.Execution execution = (CrashlyticsReport.Session.Event.Application.Execution) obj;
            List list = this.f88868a;
            if (list != null ? list.equals(execution.f()) : execution.f() == null) {
                CrashlyticsReport.Session.Event.Application.Execution.Exception exception = this.f88869b;
                if (exception != null ? exception.equals(execution.d()) : execution.d() == null) {
                    CrashlyticsReport.ApplicationExitInfo applicationExitInfo = this.f88870c;
                    if (applicationExitInfo != null ? applicationExitInfo.equals(execution.b()) : execution.b() == null) {
                        if (this.f88871d.equals(execution.e()) && this.f88872e.equals(execution.c())) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution
    public List f() {
        return this.f88868a;
    }

    public int hashCode() {
        List list = this.f88868a;
        int iHashCode = ((list == null ? 0 : list.hashCode()) ^ 1000003) * 1000003;
        CrashlyticsReport.Session.Event.Application.Execution.Exception exception = this.f88869b;
        int iHashCode2 = (iHashCode ^ (exception == null ? 0 : exception.hashCode())) * 1000003;
        CrashlyticsReport.ApplicationExitInfo applicationExitInfo = this.f88870c;
        return ((((iHashCode2 ^ (applicationExitInfo != null ? applicationExitInfo.hashCode() : 0)) * 1000003) ^ this.f88871d.hashCode()) * 1000003) ^ this.f88872e.hashCode();
    }

    public String toString() {
        return "Execution{threads=" + this.f88868a + ", exception=" + this.f88869b + ", appExitInfo=" + this.f88870c + ", signal=" + this.f88871d + ", binaries=" + this.f88872e + "}";
    }

    private AutoValue_CrashlyticsReport_Session_Event_Application_Execution(List list, CrashlyticsReport.Session.Event.Application.Execution.Exception exception, CrashlyticsReport.ApplicationExitInfo applicationExitInfo, CrashlyticsReport.Session.Event.Application.Execution.Signal signal, List list2) {
        this.f88868a = list;
        this.f88869b = exception;
        this.f88870c = applicationExitInfo;
        this.f88871d = signal;
        this.f88872e = list2;
    }
}
