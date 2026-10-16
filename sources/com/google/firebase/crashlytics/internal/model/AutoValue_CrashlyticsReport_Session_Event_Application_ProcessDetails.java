package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import cz.mobilesoft.coreblock.view.screen.ohO.MHoiDDglUlPJC;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class AutoValue_CrashlyticsReport_Session_Event_Application_ProcessDetails extends CrashlyticsReport.Session.Event.Application.ProcessDetails {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f88923a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f88924b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f88925c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f88926d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class Builder extends CrashlyticsReport.Session.Event.Application.ProcessDetails.Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f88927a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f88928b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f88929c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f88930d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private byte f88931e;

        Builder() {
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.ProcessDetails.Builder
        public CrashlyticsReport.Session.Event.Application.ProcessDetails a() {
            String str;
            if (this.f88931e == 7 && (str = this.f88927a) != null) {
                return new AutoValue_CrashlyticsReport_Session_Event_Application_ProcessDetails(str, this.f88928b, this.f88929c, this.f88930d);
            }
            StringBuilder sb = new StringBuilder();
            if (this.f88927a == null) {
                sb.append(" processName");
            }
            if ((this.f88931e & 1) == 0) {
                sb.append(" pid");
            }
            if ((this.f88931e & 2) == 0) {
                sb.append(" importance");
            }
            if ((this.f88931e & 4) == 0) {
                sb.append(" defaultProcess");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb));
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.ProcessDetails.Builder
        public CrashlyticsReport.Session.Event.Application.ProcessDetails.Builder b(boolean z2) {
            this.f88930d = z2;
            this.f88931e = (byte) (this.f88931e | 4);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.ProcessDetails.Builder
        public CrashlyticsReport.Session.Event.Application.ProcessDetails.Builder c(int i3) {
            this.f88929c = i3;
            this.f88931e = (byte) (this.f88931e | 2);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.ProcessDetails.Builder
        public CrashlyticsReport.Session.Event.Application.ProcessDetails.Builder d(int i3) {
            this.f88928b = i3;
            this.f88931e = (byte) (this.f88931e | 1);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.ProcessDetails.Builder
        public CrashlyticsReport.Session.Event.Application.ProcessDetails.Builder e(String str) {
            if (str == null) {
                throw new NullPointerException("Null processName");
            }
            this.f88927a = str;
            return this;
        }
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.ProcessDetails
    public int b() {
        return this.f88925c;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.ProcessDetails
    public int c() {
        return this.f88924b;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.ProcessDetails
    public String d() {
        return this.f88923a;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.ProcessDetails
    public boolean e() {
        return this.f88926d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CrashlyticsReport.Session.Event.Application.ProcessDetails) {
            CrashlyticsReport.Session.Event.Application.ProcessDetails processDetails = (CrashlyticsReport.Session.Event.Application.ProcessDetails) obj;
            if (this.f88923a.equals(processDetails.d()) && this.f88924b == processDetails.c() && this.f88925c == processDetails.b() && this.f88926d == processDetails.e()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((((this.f88923a.hashCode() ^ 1000003) * 1000003) ^ this.f88924b) * 1000003) ^ this.f88925c) * 1000003) ^ (this.f88926d ? 1231 : 1237);
    }

    private AutoValue_CrashlyticsReport_Session_Event_Application_ProcessDetails(String str, int i3, int i4, boolean z2) {
        this.f88923a = str;
        this.f88924b = i3;
        this.f88925c = i4;
        this.f88926d = z2;
    }

    public String toString() {
        return "ProcessDetails{processName=" + this.f88923a + MHoiDDglUlPJC.FAf + this.f88924b + ", importance=" + this.f88925c + ", defaultProcess=" + this.f88926d + "}";
    }
}
