package com.google.firebase.crashlytics.internal.model;

import com.applovin.exoplayer2.common.base.Ascii;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class AutoValue_CrashlyticsReport_ApplicationExitInfo extends CrashlyticsReport.ApplicationExitInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f88744a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f88745b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f88746c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f88747d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f88748e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f88749f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final long f88750g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f88751h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final List f88752i;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class Builder extends CrashlyticsReport.ApplicationExitInfo.Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f88753a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f88754b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f88755c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f88756d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private long f88757e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private long f88758f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private long f88759g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private String f88760h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private List f88761i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private byte f88762j;

        Builder() {
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo.Builder
        public CrashlyticsReport.ApplicationExitInfo a() {
            String str;
            if (this.f88762j == 63 && (str = this.f88754b) != null) {
                return new AutoValue_CrashlyticsReport_ApplicationExitInfo(this.f88753a, str, this.f88755c, this.f88756d, this.f88757e, this.f88758f, this.f88759g, this.f88760h, this.f88761i);
            }
            StringBuilder sb = new StringBuilder();
            if ((this.f88762j & 1) == 0) {
                sb.append(" pid");
            }
            if (this.f88754b == null) {
                sb.append(" processName");
            }
            if ((this.f88762j & 2) == 0) {
                sb.append(" reasonCode");
            }
            if ((this.f88762j & 4) == 0) {
                sb.append(" importance");
            }
            if ((this.f88762j & 8) == 0) {
                sb.append(" pss");
            }
            if ((this.f88762j & Ascii.DLE) == 0) {
                sb.append(" rss");
            }
            if ((this.f88762j & 32) == 0) {
                sb.append(" timestamp");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb));
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo.Builder
        public CrashlyticsReport.ApplicationExitInfo.Builder b(List list) {
            this.f88761i = list;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo.Builder
        public CrashlyticsReport.ApplicationExitInfo.Builder c(int i3) {
            this.f88756d = i3;
            this.f88762j = (byte) (this.f88762j | 4);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo.Builder
        public CrashlyticsReport.ApplicationExitInfo.Builder d(int i3) {
            this.f88753a = i3;
            this.f88762j = (byte) (this.f88762j | 1);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo.Builder
        public CrashlyticsReport.ApplicationExitInfo.Builder e(String str) {
            if (str == null) {
                throw new NullPointerException("Null processName");
            }
            this.f88754b = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo.Builder
        public CrashlyticsReport.ApplicationExitInfo.Builder f(long j3) {
            this.f88757e = j3;
            this.f88762j = (byte) (this.f88762j | 8);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo.Builder
        public CrashlyticsReport.ApplicationExitInfo.Builder g(int i3) {
            this.f88755c = i3;
            this.f88762j = (byte) (this.f88762j | 2);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo.Builder
        public CrashlyticsReport.ApplicationExitInfo.Builder h(long j3) {
            this.f88758f = j3;
            this.f88762j = (byte) (this.f88762j | Ascii.DLE);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo.Builder
        public CrashlyticsReport.ApplicationExitInfo.Builder i(long j3) {
            this.f88759g = j3;
            this.f88762j = (byte) (this.f88762j | 32);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo.Builder
        public CrashlyticsReport.ApplicationExitInfo.Builder j(String str) {
            this.f88760h = str;
            return this;
        }
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo
    public List b() {
        return this.f88752i;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo
    public int c() {
        return this.f88747d;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo
    public int d() {
        return this.f88744a;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo
    public String e() {
        return this.f88745b;
    }

    public boolean equals(Object obj) {
        String str;
        List list;
        if (obj == this) {
            return true;
        }
        if (obj instanceof CrashlyticsReport.ApplicationExitInfo) {
            CrashlyticsReport.ApplicationExitInfo applicationExitInfo = (CrashlyticsReport.ApplicationExitInfo) obj;
            if (this.f88744a == applicationExitInfo.d() && this.f88745b.equals(applicationExitInfo.e()) && this.f88746c == applicationExitInfo.g() && this.f88747d == applicationExitInfo.c() && this.f88748e == applicationExitInfo.f() && this.f88749f == applicationExitInfo.h() && this.f88750g == applicationExitInfo.i() && ((str = this.f88751h) != null ? str.equals(applicationExitInfo.j()) : applicationExitInfo.j() == null) && ((list = this.f88752i) != null ? list.equals(applicationExitInfo.b()) : applicationExitInfo.b() == null)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo
    public long f() {
        return this.f88748e;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo
    public int g() {
        return this.f88746c;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo
    public long h() {
        return this.f88749f;
    }

    public int hashCode() {
        int iHashCode = (((((((this.f88744a ^ 1000003) * 1000003) ^ this.f88745b.hashCode()) * 1000003) ^ this.f88746c) * 1000003) ^ this.f88747d) * 1000003;
        long j3 = this.f88748e;
        int i3 = (iHashCode ^ ((int) (j3 ^ (j3 >>> 32)))) * 1000003;
        long j4 = this.f88749f;
        int i4 = (i3 ^ ((int) (j4 ^ (j4 >>> 32)))) * 1000003;
        long j5 = this.f88750g;
        int i5 = (i4 ^ ((int) (j5 ^ (j5 >>> 32)))) * 1000003;
        String str = this.f88751h;
        int iHashCode2 = (i5 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        List list = this.f88752i;
        return iHashCode2 ^ (list != null ? list.hashCode() : 0);
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo
    public long i() {
        return this.f88750g;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo
    public String j() {
        return this.f88751h;
    }

    public String toString() {
        return "ApplicationExitInfo{pid=" + this.f88744a + ", processName=" + this.f88745b + ", reasonCode=" + this.f88746c + ", importance=" + this.f88747d + ", pss=" + this.f88748e + ", rss=" + this.f88749f + ", timestamp=" + this.f88750g + ", traceFile=" + this.f88751h + ", buildIdMappingForArch=" + this.f88752i + "}";
    }

    private AutoValue_CrashlyticsReport_ApplicationExitInfo(int i3, String str, int i4, int i5, long j3, long j4, long j5, String str2, List list) {
        this.f88744a = i3;
        this.f88745b = str;
        this.f88746c = i4;
        this.f88747d = i5;
        this.f88748e = j3;
        this.f88749f = j4;
        this.f88750g = j5;
        this.f88751h = str2;
        this.f88752i = list;
    }
}
