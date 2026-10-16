package com.google.firebase.messaging.reporting;

import com.google.firebase.encoders.proto.ProtoEnum;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class MessagingClientEvent {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final MessagingClientEvent f89548p = new Builder().a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f89549a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f89550b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f89551c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final MessageType f89552d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final SDKPlatform f89553e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f89554f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f89555g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f89556h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f89557i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final String f89558j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final long f89559k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Event f89560l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final String f89561m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final long f89562n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final String f89563o;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f89564a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f89565b = "";

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f89566c = "";

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private MessageType f89567d = MessageType.UNKNOWN;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private SDKPlatform f89568e = SDKPlatform.UNKNOWN_OS;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private String f89569f = "";

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private String f89570g = "";

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f89571h = 0;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f89572i = 0;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private String f89573j = "";

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private long f89574k = 0;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private Event f89575l = Event.UNKNOWN_EVENT;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private String f89576m = "";

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private long f89577n = 0;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private String f89578o = "";

        Builder() {
        }

        public MessagingClientEvent a() {
            return new MessagingClientEvent(this.f89564a, this.f89565b, this.f89566c, this.f89567d, this.f89568e, this.f89569f, this.f89570g, this.f89571h, this.f89572i, this.f89573j, this.f89574k, this.f89575l, this.f89576m, this.f89577n, this.f89578o);
        }

        public Builder b(String str) {
            this.f89576m = str;
            return this;
        }

        public Builder c(String str) {
            this.f89570g = str;
            return this;
        }

        public Builder d(String str) {
            this.f89578o = str;
            return this;
        }

        public Builder e(Event event) {
            this.f89575l = event;
            return this;
        }

        public Builder f(String str) {
            this.f89566c = str;
            return this;
        }

        public Builder g(String str) {
            this.f89565b = str;
            return this;
        }

        public Builder h(MessageType messageType) {
            this.f89567d = messageType;
            return this;
        }

        public Builder i(String str) {
            this.f89569f = str;
            return this;
        }

        public Builder j(int i3) {
            this.f89571h = i3;
            return this;
        }

        public Builder k(long j3) {
            this.f89564a = j3;
            return this;
        }

        public Builder l(SDKPlatform sDKPlatform) {
            this.f89568e = sDKPlatform;
            return this;
        }

        public Builder m(String str) {
            this.f89573j = str;
            return this;
        }

        public Builder n(int i3) {
            this.f89572i = i3;
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum Event implements ProtoEnum {
        UNKNOWN_EVENT(0),
        MESSAGE_DELIVERED(1),
        MESSAGE_OPEN(2);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f89583a;

        Event(int i3) {
            this.f89583a = i3;
        }

        @Override // com.google.firebase.encoders.proto.ProtoEnum
        public int J() {
            return this.f89583a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum MessageType implements ProtoEnum {
        UNKNOWN(0),
        DATA_MESSAGE(1),
        TOPIC(2),
        DISPLAY_NOTIFICATION(3);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f89589a;

        MessageType(int i3) {
            this.f89589a = i3;
        }

        @Override // com.google.firebase.encoders.proto.ProtoEnum
        public int J() {
            return this.f89589a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum SDKPlatform implements ProtoEnum {
        UNKNOWN_OS(0),
        ANDROID(1),
        IOS(2),
        WEB(3);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f89595a;

        SDKPlatform(int i3) {
            this.f89595a = i3;
        }

        @Override // com.google.firebase.encoders.proto.ProtoEnum
        public int J() {
            return this.f89595a;
        }
    }

    MessagingClientEvent(long j3, String str, String str2, MessageType messageType, SDKPlatform sDKPlatform, String str3, String str4, int i3, int i4, String str5, long j4, Event event, String str6, long j5, String str7) {
        this.f89549a = j3;
        this.f89550b = str;
        this.f89551c = str2;
        this.f89552d = messageType;
        this.f89553e = sDKPlatform;
        this.f89554f = str3;
        this.f89555g = str4;
        this.f89556h = i3;
        this.f89557i = i4;
        this.f89558j = str5;
        this.f89559k = j4;
        this.f89560l = event;
        this.f89561m = str6;
        this.f89562n = j5;
        this.f89563o = str7;
    }

    public static Builder p() {
        return new Builder();
    }

    public String a() {
        return this.f89561m;
    }

    public long b() {
        return this.f89559k;
    }

    public long c() {
        return this.f89562n;
    }

    public String d() {
        return this.f89555g;
    }

    public String e() {
        return this.f89563o;
    }

    public Event f() {
        return this.f89560l;
    }

    public String g() {
        return this.f89551c;
    }

    public String h() {
        return this.f89550b;
    }

    public MessageType i() {
        return this.f89552d;
    }

    public String j() {
        return this.f89554f;
    }

    public int k() {
        return this.f89556h;
    }

    public long l() {
        return this.f89549a;
    }

    public SDKPlatform m() {
        return this.f89553e;
    }

    public String n() {
        return this.f89558j;
    }

    public int o() {
        return this.f89557i;
    }
}
