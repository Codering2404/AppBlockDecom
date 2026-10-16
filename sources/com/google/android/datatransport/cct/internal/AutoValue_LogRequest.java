package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.LogRequest;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_LogRequest extends LogRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f69192a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f69193b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ClientInfo f69194c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Integer f69195d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f69196e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List f69197f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final QosTier f69198g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class Builder extends LogRequest.Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Long f69199a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Long f69200b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private ClientInfo f69201c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Integer f69202d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f69203e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private List f69204f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private QosTier f69205g;

        Builder() {
        }

        @Override // com.google.android.datatransport.cct.internal.LogRequest.Builder
        public LogRequest a() {
            String str = "";
            if (this.f69199a == null) {
                str = " requestTimeMs";
            }
            if (this.f69200b == null) {
                str = str + " requestUptimeMs";
            }
            if (str.isEmpty()) {
                return new AutoValue_LogRequest(this.f69199a.longValue(), this.f69200b.longValue(), this.f69201c, this.f69202d, this.f69203e, this.f69204f, this.f69205g);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.android.datatransport.cct.internal.LogRequest.Builder
        public LogRequest.Builder b(ClientInfo clientInfo) {
            this.f69201c = clientInfo;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.LogRequest.Builder
        public LogRequest.Builder c(List list) {
            this.f69204f = list;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.LogRequest.Builder
        LogRequest.Builder d(Integer num) {
            this.f69202d = num;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.LogRequest.Builder
        LogRequest.Builder e(String str) {
            this.f69203e = str;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.LogRequest.Builder
        public LogRequest.Builder f(QosTier qosTier) {
            this.f69205g = qosTier;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.LogRequest.Builder
        public LogRequest.Builder g(long j3) {
            this.f69199a = Long.valueOf(j3);
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.LogRequest.Builder
        public LogRequest.Builder h(long j3) {
            this.f69200b = Long.valueOf(j3);
            return this;
        }
    }

    @Override // com.google.android.datatransport.cct.internal.LogRequest
    public ClientInfo b() {
        return this.f69194c;
    }

    @Override // com.google.android.datatransport.cct.internal.LogRequest
    public List c() {
        return this.f69197f;
    }

    @Override // com.google.android.datatransport.cct.internal.LogRequest
    public Integer d() {
        return this.f69195d;
    }

    @Override // com.google.android.datatransport.cct.internal.LogRequest
    public String e() {
        return this.f69196e;
    }

    public boolean equals(Object obj) {
        ClientInfo clientInfo;
        Integer num;
        String str;
        List list;
        QosTier qosTier;
        if (obj == this) {
            return true;
        }
        if (obj instanceof LogRequest) {
            LogRequest logRequest = (LogRequest) obj;
            if (this.f69192a == logRequest.g() && this.f69193b == logRequest.h() && ((clientInfo = this.f69194c) != null ? clientInfo.equals(logRequest.b()) : logRequest.b() == null) && ((num = this.f69195d) != null ? num.equals(logRequest.d()) : logRequest.d() == null) && ((str = this.f69196e) != null ? str.equals(logRequest.e()) : logRequest.e() == null) && ((list = this.f69197f) != null ? list.equals(logRequest.c()) : logRequest.c() == null) && ((qosTier = this.f69198g) != null ? qosTier.equals(logRequest.f()) : logRequest.f() == null)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.datatransport.cct.internal.LogRequest
    public QosTier f() {
        return this.f69198g;
    }

    @Override // com.google.android.datatransport.cct.internal.LogRequest
    public long g() {
        return this.f69192a;
    }

    @Override // com.google.android.datatransport.cct.internal.LogRequest
    public long h() {
        return this.f69193b;
    }

    public int hashCode() {
        long j3 = this.f69192a;
        long j4 = this.f69193b;
        int i3 = (((((int) (j3 ^ (j3 >>> 32))) ^ 1000003) * 1000003) ^ ((int) ((j4 >>> 32) ^ j4))) * 1000003;
        ClientInfo clientInfo = this.f69194c;
        int iHashCode = (i3 ^ (clientInfo == null ? 0 : clientInfo.hashCode())) * 1000003;
        Integer num = this.f69195d;
        int iHashCode2 = (iHashCode ^ (num == null ? 0 : num.hashCode())) * 1000003;
        String str = this.f69196e;
        int iHashCode3 = (iHashCode2 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        List list = this.f69197f;
        int iHashCode4 = (iHashCode3 ^ (list == null ? 0 : list.hashCode())) * 1000003;
        QosTier qosTier = this.f69198g;
        return iHashCode4 ^ (qosTier != null ? qosTier.hashCode() : 0);
    }

    public String toString() {
        return "LogRequest{requestTimeMs=" + this.f69192a + ", requestUptimeMs=" + this.f69193b + ", clientInfo=" + this.f69194c + ", logSource=" + this.f69195d + ", logSourceName=" + this.f69196e + ", logEvents=" + this.f69197f + ", qosTier=" + this.f69198g + "}";
    }

    private AutoValue_LogRequest(long j3, long j4, ClientInfo clientInfo, Integer num, String str, List list, QosTier qosTier) {
        this.f69192a = j3;
        this.f69193b = j4;
        this.f69194c = clientInfo;
        this.f69195d = num;
        this.f69196e = str;
        this.f69197f = list;
        this.f69198g = qosTier;
    }
}
