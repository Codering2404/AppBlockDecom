package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.EventInternal;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_EventInternal extends EventInternal {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f69297a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Integer f69298b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final EncodedPayload f69299c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f69300d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f69301e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Map f69302f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Integer f69303g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f69304h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final byte[] f69305i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final byte[] f69306j;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class Builder extends EventInternal.Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f69307a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Integer f69308b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private EncodedPayload f69309c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Long f69310d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Long f69311e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private Map f69312f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private Integer f69313g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private String f69314h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private byte[] f69315i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private byte[] f69316j;

        Builder() {
        }

        @Override // com.google.android.datatransport.runtime.EventInternal.Builder
        public EventInternal d() {
            String str = "";
            if (this.f69307a == null) {
                str = " transportName";
            }
            if (this.f69309c == null) {
                str = str + " encodedPayload";
            }
            if (this.f69310d == null) {
                str = str + " eventMillis";
            }
            if (this.f69311e == null) {
                str = str + " uptimeMillis";
            }
            if (this.f69312f == null) {
                str = str + " autoMetadata";
            }
            if (str.isEmpty()) {
                return new AutoValue_EventInternal(this.f69307a, this.f69308b, this.f69309c, this.f69310d.longValue(), this.f69311e.longValue(), this.f69312f, this.f69313g, this.f69314h, this.f69315i, this.f69316j);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.android.datatransport.runtime.EventInternal.Builder
        protected Map e() {
            Map map = this.f69312f;
            if (map != null) {
                return map;
            }
            throw new IllegalStateException("Property \"autoMetadata\" has not been set");
        }

        @Override // com.google.android.datatransport.runtime.EventInternal.Builder
        protected EventInternal.Builder f(Map map) {
            if (map == null) {
                throw new NullPointerException("Null autoMetadata");
            }
            this.f69312f = map;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.EventInternal.Builder
        public EventInternal.Builder g(Integer num) {
            this.f69308b = num;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.EventInternal.Builder
        public EventInternal.Builder h(EncodedPayload encodedPayload) {
            if (encodedPayload == null) {
                throw new NullPointerException("Null encodedPayload");
            }
            this.f69309c = encodedPayload;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.EventInternal.Builder
        public EventInternal.Builder i(long j3) {
            this.f69310d = Long.valueOf(j3);
            return this;
        }

        @Override // com.google.android.datatransport.runtime.EventInternal.Builder
        public EventInternal.Builder j(byte[] bArr) {
            this.f69315i = bArr;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.EventInternal.Builder
        public EventInternal.Builder k(byte[] bArr) {
            this.f69316j = bArr;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.EventInternal.Builder
        public EventInternal.Builder l(Integer num) {
            this.f69313g = num;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.EventInternal.Builder
        public EventInternal.Builder m(String str) {
            this.f69314h = str;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.EventInternal.Builder
        public EventInternal.Builder n(String str) {
            if (str == null) {
                throw new NullPointerException("Null transportName");
            }
            this.f69307a = str;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.EventInternal.Builder
        public EventInternal.Builder o(long j3) {
            this.f69311e = Long.valueOf(j3);
            return this;
        }
    }

    @Override // com.google.android.datatransport.runtime.EventInternal
    protected Map c() {
        return this.f69302f;
    }

    @Override // com.google.android.datatransport.runtime.EventInternal
    public Integer d() {
        return this.f69298b;
    }

    @Override // com.google.android.datatransport.runtime.EventInternal
    public EncodedPayload e() {
        return this.f69299c;
    }

    public boolean equals(Object obj) {
        Integer num;
        Integer num2;
        String str;
        if (obj == this) {
            return true;
        }
        if (obj instanceof EventInternal) {
            EventInternal eventInternal = (EventInternal) obj;
            if (this.f69297a.equals(eventInternal.n()) && ((num = this.f69298b) != null ? num.equals(eventInternal.d()) : eventInternal.d() == null) && this.f69299c.equals(eventInternal.e()) && this.f69300d == eventInternal.f() && this.f69301e == eventInternal.o() && this.f69302f.equals(eventInternal.c()) && ((num2 = this.f69303g) != null ? num2.equals(eventInternal.l()) : eventInternal.l() == null) && ((str = this.f69304h) != null ? str.equals(eventInternal.m()) : eventInternal.m() == null)) {
                boolean z2 = eventInternal instanceof AutoValue_EventInternal;
                if (Arrays.equals(this.f69305i, z2 ? ((AutoValue_EventInternal) eventInternal).f69305i : eventInternal.g())) {
                    if (Arrays.equals(this.f69306j, z2 ? ((AutoValue_EventInternal) eventInternal).f69306j : eventInternal.h())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // com.google.android.datatransport.runtime.EventInternal
    public long f() {
        return this.f69300d;
    }

    @Override // com.google.android.datatransport.runtime.EventInternal
    public byte[] g() {
        return this.f69305i;
    }

    @Override // com.google.android.datatransport.runtime.EventInternal
    public byte[] h() {
        return this.f69306j;
    }

    public int hashCode() {
        int iHashCode = (this.f69297a.hashCode() ^ 1000003) * 1000003;
        Integer num = this.f69298b;
        int iHashCode2 = (((iHashCode ^ (num == null ? 0 : num.hashCode())) * 1000003) ^ this.f69299c.hashCode()) * 1000003;
        long j3 = this.f69300d;
        int i3 = (iHashCode2 ^ ((int) (j3 ^ (j3 >>> 32)))) * 1000003;
        long j4 = this.f69301e;
        int iHashCode3 = (((i3 ^ ((int) (j4 ^ (j4 >>> 32)))) * 1000003) ^ this.f69302f.hashCode()) * 1000003;
        Integer num2 = this.f69303g;
        int iHashCode4 = (iHashCode3 ^ (num2 == null ? 0 : num2.hashCode())) * 1000003;
        String str = this.f69304h;
        return ((((iHashCode4 ^ (str != null ? str.hashCode() : 0)) * 1000003) ^ Arrays.hashCode(this.f69305i)) * 1000003) ^ Arrays.hashCode(this.f69306j);
    }

    @Override // com.google.android.datatransport.runtime.EventInternal
    public Integer l() {
        return this.f69303g;
    }

    @Override // com.google.android.datatransport.runtime.EventInternal
    public String m() {
        return this.f69304h;
    }

    @Override // com.google.android.datatransport.runtime.EventInternal
    public String n() {
        return this.f69297a;
    }

    @Override // com.google.android.datatransport.runtime.EventInternal
    public long o() {
        return this.f69301e;
    }

    public String toString() {
        return "EventInternal{transportName=" + this.f69297a + ", code=" + this.f69298b + ", encodedPayload=" + this.f69299c + ", eventMillis=" + this.f69300d + ", uptimeMillis=" + this.f69301e + ", autoMetadata=" + this.f69302f + ", productId=" + this.f69303g + ", pseudonymousId=" + this.f69304h + ", experimentIdsClear=" + Arrays.toString(this.f69305i) + ", experimentIdsEncrypted=" + Arrays.toString(this.f69306j) + "}";
    }

    private AutoValue_EventInternal(String str, Integer num, EncodedPayload encodedPayload, long j3, long j4, Map map, Integer num2, String str2, byte[] bArr, byte[] bArr2) {
        this.f69297a = str;
        this.f69298b = num;
        this.f69299c = encodedPayload;
        this.f69300d = j3;
        this.f69301e = j4;
        this.f69302f = map;
        this.f69303g = num2;
        this.f69304h = str2;
        this.f69305i = bArr;
        this.f69306j = bArr2;
    }
}
