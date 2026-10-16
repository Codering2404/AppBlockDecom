package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread extends CrashlyticsReport.Session.Event.Application.Execution.Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f88905a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f88906b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f88907c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class Builder extends CrashlyticsReport.Session.Event.Application.Execution.Thread.Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f88908a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f88909b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private List f88910c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private byte f88911d;

        Builder() {
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Builder
        public CrashlyticsReport.Session.Event.Application.Execution.Thread a() {
            String str;
            List list;
            if (this.f88911d == 1 && (str = this.f88908a) != null && (list = this.f88910c) != null) {
                return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread(str, this.f88909b, list);
            }
            StringBuilder sb = new StringBuilder();
            if (this.f88908a == null) {
                sb.append(" name");
            }
            if ((1 & this.f88911d) == 0) {
                sb.append(" importance");
            }
            if (this.f88910c == null) {
                sb.append(" frames");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb));
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Builder
        public CrashlyticsReport.Session.Event.Application.Execution.Thread.Builder b(List list) {
            if (list == null) {
                throw new NullPointerException("Null frames");
            }
            this.f88910c = list;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Builder
        public CrashlyticsReport.Session.Event.Application.Execution.Thread.Builder c(int i3) {
            this.f88909b = i3;
            this.f88911d = (byte) (this.f88911d | 1);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Builder
        public CrashlyticsReport.Session.Event.Application.Execution.Thread.Builder d(String str) {
            if (str == null) {
                throw new NullPointerException("Null name");
            }
            this.f88908a = str;
            return this;
        }
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread
    public List b() {
        return this.f88907c;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread
    public int c() {
        return this.f88906b;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread
    public String d() {
        return this.f88905a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CrashlyticsReport.Session.Event.Application.Execution.Thread) {
            CrashlyticsReport.Session.Event.Application.Execution.Thread thread = (CrashlyticsReport.Session.Event.Application.Execution.Thread) obj;
            if (this.f88905a.equals(thread.d()) && this.f88906b == thread.c() && this.f88907c.equals(thread.b())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((this.f88905a.hashCode() ^ 1000003) * 1000003) ^ this.f88906b) * 1000003) ^ this.f88907c.hashCode();
    }

    public String toString() {
        return "Thread{name=" + this.f88905a + ", importance=" + this.f88906b + ", frames=" + this.f88907c + "}";
    }

    private AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread(String str, int i3, List list) {
        this.f88905a = str;
        this.f88906b = i3;
        this.f88907c = list;
    }
}
