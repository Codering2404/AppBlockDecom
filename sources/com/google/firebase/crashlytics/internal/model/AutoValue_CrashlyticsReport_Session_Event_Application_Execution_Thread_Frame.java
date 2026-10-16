package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame extends CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f88912a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f88913b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f88914c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f88915d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f88916e;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class Builder extends CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f88917a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f88918b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f88919c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f88920d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f88921e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private byte f88922f;

        Builder() {
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder
        public CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame a() {
            String str;
            if (this.f88922f == 7 && (str = this.f88918b) != null) {
                return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame(this.f88917a, str, this.f88919c, this.f88920d, this.f88921e);
            }
            StringBuilder sb = new StringBuilder();
            if ((this.f88922f & 1) == 0) {
                sb.append(" pc");
            }
            if (this.f88918b == null) {
                sb.append(" symbol");
            }
            if ((this.f88922f & 2) == 0) {
                sb.append(" offset");
            }
            if ((this.f88922f & 4) == 0) {
                sb.append(" importance");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb));
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder
        public CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder b(String str) {
            this.f88919c = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder
        public CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder c(int i3) {
            this.f88921e = i3;
            this.f88922f = (byte) (this.f88922f | 4);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder
        public CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder d(long j3) {
            this.f88920d = j3;
            this.f88922f = (byte) (this.f88922f | 2);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder
        public CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder e(long j3) {
            this.f88917a = j3;
            this.f88922f = (byte) (this.f88922f | 1);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder
        public CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder f(String str) {
            if (str == null) {
                throw new NullPointerException("Null symbol");
            }
            this.f88918b = str;
            return this;
        }
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame
    public String b() {
        return this.f88914c;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame
    public int c() {
        return this.f88916e;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame
    public long d() {
        return this.f88915d;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame
    public long e() {
        return this.f88912a;
    }

    public boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (obj instanceof CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame) {
            CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame frame = (CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame) obj;
            if (this.f88912a == frame.e() && this.f88913b.equals(frame.f()) && ((str = this.f88914c) != null ? str.equals(frame.b()) : frame.b() == null) && this.f88915d == frame.d() && this.f88916e == frame.c()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame
    public String f() {
        return this.f88913b;
    }

    public int hashCode() {
        long j3 = this.f88912a;
        int iHashCode = (((((int) (j3 ^ (j3 >>> 32))) ^ 1000003) * 1000003) ^ this.f88913b.hashCode()) * 1000003;
        String str = this.f88914c;
        int iHashCode2 = (iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        long j4 = this.f88915d;
        return ((iHashCode2 ^ ((int) ((j4 >>> 32) ^ j4))) * 1000003) ^ this.f88916e;
    }

    public String toString() {
        return "Frame{pc=" + this.f88912a + ", symbol=" + this.f88913b + ", file=" + this.f88914c + ", offset=" + this.f88915d + ", importance=" + this.f88916e + "}";
    }

    private AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame(long j3, String str, String str2, long j4, int i3) {
        this.f88912a = j3;
        this.f88913b = str;
        this.f88914c = str2;
        this.f88915d = j4;
        this.f88916e = i3;
    }
}
