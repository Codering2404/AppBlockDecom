package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception extends CrashlyticsReport.Session.Event.Application.Execution.Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f88887a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f88888b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f88889c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final CrashlyticsReport.Session.Event.Application.Execution.Exception f88890d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f88891e;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class Builder extends CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f88892a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f88893b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private List f88894c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private CrashlyticsReport.Session.Event.Application.Execution.Exception f88895d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f88896e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private byte f88897f;

        Builder() {
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder
        public CrashlyticsReport.Session.Event.Application.Execution.Exception a() {
            String str;
            List list;
            if (this.f88897f == 1 && (str = this.f88892a) != null && (list = this.f88894c) != null) {
                return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception(str, this.f88893b, list, this.f88895d, this.f88896e);
            }
            StringBuilder sb = new StringBuilder();
            if (this.f88892a == null) {
                sb.append(" type");
            }
            if (this.f88894c == null) {
                sb.append(" frames");
            }
            if ((1 & this.f88897f) == 0) {
                sb.append(" overflowCount");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb));
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder
        public CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder b(CrashlyticsReport.Session.Event.Application.Execution.Exception exception) {
            this.f88895d = exception;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder
        public CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder c(List list) {
            if (list == null) {
                throw new NullPointerException("Null frames");
            }
            this.f88894c = list;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder
        public CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder d(int i3) {
            this.f88896e = i3;
            this.f88897f = (byte) (this.f88897f | 1);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder
        public CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder e(String str) {
            this.f88893b = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder
        public CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder f(String str) {
            if (str == null) {
                throw new NullPointerException("Null type");
            }
            this.f88892a = str;
            return this;
        }
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception
    public CrashlyticsReport.Session.Event.Application.Execution.Exception b() {
        return this.f88890d;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception
    public List c() {
        return this.f88889c;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception
    public int d() {
        return this.f88891e;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception
    public String e() {
        return this.f88888b;
    }

    public boolean equals(Object obj) {
        String str;
        CrashlyticsReport.Session.Event.Application.Execution.Exception exception;
        if (obj == this) {
            return true;
        }
        if (obj instanceof CrashlyticsReport.Session.Event.Application.Execution.Exception) {
            CrashlyticsReport.Session.Event.Application.Execution.Exception exception2 = (CrashlyticsReport.Session.Event.Application.Execution.Exception) obj;
            if (this.f88887a.equals(exception2.f()) && ((str = this.f88888b) != null ? str.equals(exception2.e()) : exception2.e() == null) && this.f88889c.equals(exception2.c()) && ((exception = this.f88890d) != null ? exception.equals(exception2.b()) : exception2.b() == null) && this.f88891e == exception2.d()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception
    public String f() {
        return this.f88887a;
    }

    public int hashCode() {
        int iHashCode = (this.f88887a.hashCode() ^ 1000003) * 1000003;
        String str = this.f88888b;
        int iHashCode2 = (((iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003) ^ this.f88889c.hashCode()) * 1000003;
        CrashlyticsReport.Session.Event.Application.Execution.Exception exception = this.f88890d;
        return ((iHashCode2 ^ (exception != null ? exception.hashCode() : 0)) * 1000003) ^ this.f88891e;
    }

    public String toString() {
        return "Exception{type=" + this.f88887a + ", reason=" + this.f88888b + ", frames=" + this.f88889c + ", causedBy=" + this.f88890d + ", overflowCount=" + this.f88891e + "}";
    }

    private AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception(String str, String str2, List list, CrashlyticsReport.Session.Event.Application.Execution.Exception exception, int i3) {
        this.f88887a = str;
        this.f88888b = str2;
        this.f88889c = list;
        this.f88890d = exception;
        this.f88891e = i3;
    }
}
