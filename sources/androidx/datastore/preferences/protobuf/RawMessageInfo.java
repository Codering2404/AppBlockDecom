package androidx.datastore.preferences.protobuf;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@CheckReturnValue
final class RawMessageInfo implements MessageInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MessageLite f36560a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f36561b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object[] f36562c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f36563d;

    RawMessageInfo(MessageLite messageLite, String str, Object[] objArr) {
        this.f36560a = messageLite;
        this.f36561b = str;
        this.f36562c = objArr;
        char cCharAt = str.charAt(0);
        if (cCharAt < 55296) {
            this.f36563d = cCharAt;
            return;
        }
        int i3 = cCharAt & 8191;
        int i4 = 13;
        int i5 = 1;
        while (true) {
            int i6 = i5 + 1;
            char cCharAt2 = str.charAt(i5);
            if (cCharAt2 < 55296) {
                this.f36563d = i3 | (cCharAt2 << i4);
                return;
            } else {
                i3 |= (cCharAt2 & 8191) << i4;
                i4 += 13;
                i5 = i6;
            }
        }
    }

    @Override // androidx.datastore.preferences.protobuf.MessageInfo
    public boolean a() {
        return (this.f36563d & 2) == 2;
    }

    @Override // androidx.datastore.preferences.protobuf.MessageInfo
    public MessageLite b() {
        return this.f36560a;
    }

    @Override // androidx.datastore.preferences.protobuf.MessageInfo
    public ProtoSyntax c() {
        int i3 = this.f36563d;
        return (i3 & 1) != 0 ? ProtoSyntax.PROTO2 : (i3 & 4) == 4 ? ProtoSyntax.EDITIONS : ProtoSyntax.PROTO3;
    }

    Object[] d() {
        return this.f36562c;
    }

    String e() {
        return this.f36561b;
    }
}
