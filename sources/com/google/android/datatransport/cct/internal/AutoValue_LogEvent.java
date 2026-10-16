package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.LogEvent;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_LogEvent extends LogEvent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f69174a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Integer f69175b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ComplianceData f69176c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f69177d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final byte[] f69178e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f69179f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final long f69180g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final NetworkConnectionInfo f69181h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final ExperimentIds f69182i;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class Builder extends LogEvent.Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Long f69183a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Integer f69184b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private ComplianceData f69185c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Long f69186d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private byte[] f69187e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private String f69188f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private Long f69189g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private NetworkConnectionInfo f69190h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private ExperimentIds f69191i;

        Builder() {
        }

        @Override // com.google.android.datatransport.cct.internal.LogEvent.Builder
        public LogEvent a() {
            String str = "";
            if (this.f69183a == null) {
                str = " eventTimeMs";
            }
            if (this.f69186d == null) {
                str = str + " eventUptimeMs";
            }
            if (this.f69189g == null) {
                str = str + " timezoneOffsetSeconds";
            }
            if (str.isEmpty()) {
                return new AutoValue_LogEvent(this.f69183a.longValue(), this.f69184b, this.f69185c, this.f69186d.longValue(), this.f69187e, this.f69188f, this.f69189g.longValue(), this.f69190h, this.f69191i);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.android.datatransport.cct.internal.LogEvent.Builder
        public LogEvent.Builder b(ComplianceData complianceData) {
            this.f69185c = complianceData;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.LogEvent.Builder
        public LogEvent.Builder c(Integer num) {
            this.f69184b = num;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.LogEvent.Builder
        public LogEvent.Builder d(long j3) {
            this.f69183a = Long.valueOf(j3);
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.LogEvent.Builder
        public LogEvent.Builder e(long j3) {
            this.f69186d = Long.valueOf(j3);
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.LogEvent.Builder
        public LogEvent.Builder f(ExperimentIds experimentIds) {
            this.f69191i = experimentIds;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.LogEvent.Builder
        public LogEvent.Builder g(NetworkConnectionInfo networkConnectionInfo) {
            this.f69190h = networkConnectionInfo;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.LogEvent.Builder
        LogEvent.Builder h(byte[] bArr) {
            this.f69187e = bArr;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.LogEvent.Builder
        LogEvent.Builder i(String str) {
            this.f69188f = str;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.LogEvent.Builder
        public LogEvent.Builder j(long j3) {
            this.f69189g = Long.valueOf(j3);
            return this;
        }
    }

    @Override // com.google.android.datatransport.cct.internal.LogEvent
    public ComplianceData b() {
        return this.f69176c;
    }

    @Override // com.google.android.datatransport.cct.internal.LogEvent
    public Integer c() {
        return this.f69175b;
    }

    @Override // com.google.android.datatransport.cct.internal.LogEvent
    public long d() {
        return this.f69174a;
    }

    @Override // com.google.android.datatransport.cct.internal.LogEvent
    public long e() {
        return this.f69177d;
    }

    public boolean equals(Object obj) {
        Integer num;
        ComplianceData complianceData;
        String str;
        NetworkConnectionInfo networkConnectionInfo;
        ExperimentIds experimentIds;
        if (obj == this) {
            return true;
        }
        if (obj instanceof LogEvent) {
            LogEvent logEvent = (LogEvent) obj;
            if (this.f69174a == logEvent.d() && ((num = this.f69175b) != null ? num.equals(logEvent.c()) : logEvent.c() == null) && ((complianceData = this.f69176c) != null ? complianceData.equals(logEvent.b()) : logEvent.b() == null) && this.f69177d == logEvent.e()) {
                if (Arrays.equals(this.f69178e, logEvent instanceof AutoValue_LogEvent ? ((AutoValue_LogEvent) logEvent).f69178e : logEvent.h()) && ((str = this.f69179f) != null ? str.equals(logEvent.i()) : logEvent.i() == null) && this.f69180g == logEvent.j() && ((networkConnectionInfo = this.f69181h) != null ? networkConnectionInfo.equals(logEvent.g()) : logEvent.g() == null) && ((experimentIds = this.f69182i) != null ? experimentIds.equals(logEvent.f()) : logEvent.f() == null)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.google.android.datatransport.cct.internal.LogEvent
    public ExperimentIds f() {
        return this.f69182i;
    }

    @Override // com.google.android.datatransport.cct.internal.LogEvent
    public NetworkConnectionInfo g() {
        return this.f69181h;
    }

    @Override // com.google.android.datatransport.cct.internal.LogEvent
    public byte[] h() {
        return this.f69178e;
    }

    public int hashCode() {
        long j3 = this.f69174a;
        int i3 = (((int) (j3 ^ (j3 >>> 32))) ^ 1000003) * 1000003;
        Integer num = this.f69175b;
        int iHashCode = (i3 ^ (num == null ? 0 : num.hashCode())) * 1000003;
        ComplianceData complianceData = this.f69176c;
        int iHashCode2 = complianceData == null ? 0 : complianceData.hashCode();
        long j4 = this.f69177d;
        int iHashCode3 = (((((iHashCode ^ iHashCode2) * 1000003) ^ ((int) (j4 ^ (j4 >>> 32)))) * 1000003) ^ Arrays.hashCode(this.f69178e)) * 1000003;
        String str = this.f69179f;
        int iHashCode4 = str == null ? 0 : str.hashCode();
        long j5 = this.f69180g;
        int i4 = (((iHashCode3 ^ iHashCode4) * 1000003) ^ ((int) ((j5 >>> 32) ^ j5))) * 1000003;
        NetworkConnectionInfo networkConnectionInfo = this.f69181h;
        int iHashCode5 = (i4 ^ (networkConnectionInfo == null ? 0 : networkConnectionInfo.hashCode())) * 1000003;
        ExperimentIds experimentIds = this.f69182i;
        return iHashCode5 ^ (experimentIds != null ? experimentIds.hashCode() : 0);
    }

    @Override // com.google.android.datatransport.cct.internal.LogEvent
    public String i() {
        return this.f69179f;
    }

    @Override // com.google.android.datatransport.cct.internal.LogEvent
    public long j() {
        return this.f69180g;
    }

    public String toString() {
        return "LogEvent{eventTimeMs=" + this.f69174a + ", eventCode=" + this.f69175b + ", complianceData=" + this.f69176c + ", eventUptimeMs=" + this.f69177d + ", sourceExtension=" + Arrays.toString(this.f69178e) + ", sourceExtensionJsonProto3=" + this.f69179f + ", timezoneOffsetSeconds=" + this.f69180g + ", networkConnectionInfo=" + this.f69181h + ", experimentIds=" + this.f69182i + "}";
    }

    private AutoValue_LogEvent(long j3, Integer num, ComplianceData complianceData, long j4, byte[] bArr, String str, long j5, NetworkConnectionInfo networkConnectionInfo, ExperimentIds experimentIds) {
        this.f69174a = j3;
        this.f69175b = num;
        this.f69176c = complianceData;
        this.f69177d = j4;
        this.f69178e = bArr;
        this.f69179f = str;
        this.f69180g = j5;
        this.f69181h = networkConnectionInfo;
        this.f69182i = experimentIds;
    }
}
