package com.google.android.datatransport.runtime.firebase.transport;

import com.google.firebase.encoders.proto.ProtoEnum;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class LogEventDropped {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final LogEventDropped f69417c = new Builder().a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f69418a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Reason f69419b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f69420a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Reason f69421b = Reason.REASON_UNKNOWN;

        Builder() {
        }

        public LogEventDropped a() {
            return new LogEventDropped(this.f69420a, this.f69421b);
        }

        public Builder b(long j3) {
            this.f69420a = j3;
            return this;
        }

        public Builder c(Reason reason) {
            this.f69421b = reason;
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum Reason implements ProtoEnum {
        REASON_UNKNOWN(0),
        MESSAGE_TOO_OLD(1),
        CACHE_FULL(2),
        PAYLOAD_TOO_BIG(3),
        MAX_RETRIES_REACHED(4),
        INVALID_PAYLOD(5),
        SERVER_ERROR(6);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f69430a;

        Reason(int i3) {
            this.f69430a = i3;
        }

        @Override // com.google.firebase.encoders.proto.ProtoEnum
        public int J() {
            return this.f69430a;
        }
    }

    LogEventDropped(long j3, Reason reason) {
        this.f69418a = j3;
        this.f69419b = reason;
    }

    public static Builder c() {
        return new Builder();
    }

    public long a() {
        return this.f69418a;
    }

    public Reason b() {
        return this.f69419b;
    }
}
