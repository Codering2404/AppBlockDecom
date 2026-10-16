package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage extends CrashlyticsReport.Session.Event.Application.Execution.BinaryImage {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f88878a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f88879b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f88880c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f88881d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class Builder extends CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f88882a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f88883b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f88884c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f88885d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private byte f88886e;

        Builder() {
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.Builder
        public CrashlyticsReport.Session.Event.Application.Execution.BinaryImage a() {
            String str;
            if (this.f88886e == 3 && (str = this.f88884c) != null) {
                return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage(this.f88882a, this.f88883b, str, this.f88885d);
            }
            StringBuilder sb = new StringBuilder();
            if ((this.f88886e & 1) == 0) {
                sb.append(" baseAddress");
            }
            if ((this.f88886e & 2) == 0) {
                sb.append(" size");
            }
            if (this.f88884c == null) {
                sb.append(" name");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb));
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.Builder
        public CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.Builder b(long j3) {
            this.f88882a = j3;
            this.f88886e = (byte) (this.f88886e | 1);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.Builder
        public CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.Builder c(String str) {
            if (str == null) {
                throw new NullPointerException("Null name");
            }
            this.f88884c = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.Builder
        public CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.Builder d(long j3) {
            this.f88883b = j3;
            this.f88886e = (byte) (this.f88886e | 2);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.Builder
        public CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.Builder e(String str) {
            this.f88885d = str;
            return this;
        }
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.BinaryImage
    public long b() {
        return this.f88878a;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.BinaryImage
    public String c() {
        return this.f88880c;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.BinaryImage
    public long d() {
        return this.f88879b;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.BinaryImage
    public String e() {
        return this.f88881d;
    }

    public boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (obj instanceof CrashlyticsReport.Session.Event.Application.Execution.BinaryImage) {
            CrashlyticsReport.Session.Event.Application.Execution.BinaryImage binaryImage = (CrashlyticsReport.Session.Event.Application.Execution.BinaryImage) obj;
            if (this.f88878a == binaryImage.b() && this.f88879b == binaryImage.d() && this.f88880c.equals(binaryImage.c()) && ((str = this.f88881d) != null ? str.equals(binaryImage.e()) : binaryImage.e() == null)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        long j3 = this.f88878a;
        long j4 = this.f88879b;
        int iHashCode = (((((((int) (j3 ^ (j3 >>> 32))) ^ 1000003) * 1000003) ^ ((int) ((j4 >>> 32) ^ j4))) * 1000003) ^ this.f88880c.hashCode()) * 1000003;
        String str = this.f88881d;
        return iHashCode ^ (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "BinaryImage{baseAddress=" + this.f88878a + ", size=" + this.f88879b + ", name=" + this.f88880c + ", uuid=" + this.f88881d + "}";
    }

    private AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage(long j3, long j4, String str, String str2) {
        this.f88878a = j3;
        this.f88879b = j4;
        this.f88880c = str;
        this.f88881d = str2;
    }
}
