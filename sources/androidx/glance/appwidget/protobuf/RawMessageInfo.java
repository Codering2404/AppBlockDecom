package androidx.glance.appwidget.protobuf;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@CheckReturnValue
final class RawMessageInfo implements MessageInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MessageLite f39206a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f39207b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object[] f39208c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f39209d;

    RawMessageInfo(MessageLite messageLite, String str, Object[] objArr) {
        this.f39206a = messageLite;
        this.f39207b = str;
        this.f39208c = objArr;
        char cCharAt = str.charAt(0);
        if (cCharAt < 55296) {
            this.f39209d = cCharAt;
            return;
        }
        int i3 = cCharAt & 8191;
        int i4 = 13;
        int i5 = 1;
        while (true) {
            int i6 = i5 + 1;
            char cCharAt2 = str.charAt(i5);
            if (cCharAt2 < 55296) {
                this.f39209d = i3 | (cCharAt2 << i4);
                return;
            } else {
                i3 |= (cCharAt2 & 8191) << i4;
                i4 += 13;
                i5 = i6;
            }
        }
    }

    @Override // androidx.glance.appwidget.protobuf.MessageInfo
    public boolean a() {
        return (this.f39209d & 2) == 2;
    }

    @Override // androidx.glance.appwidget.protobuf.MessageInfo
    public MessageLite b() {
        return this.f39206a;
    }

    @Override // androidx.glance.appwidget.protobuf.MessageInfo
    public ProtoSyntax c() {
        return (this.f39209d & 1) == 1 ? ProtoSyntax.PROTO2 : ProtoSyntax.PROTO3;
    }

    Object[] d() {
        return this.f39208c;
    }

    String e() {
        return this.f39207b;
    }
}
