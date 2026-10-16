package com.google.crypto.tink.shaded.protobuf;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@CheckReturnValue
final class RawMessageInfo implements MessageInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MessageLite f87067a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f87068b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object[] f87069c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f87070d;

    RawMessageInfo(MessageLite messageLite, String str, Object[] objArr) {
        this.f87067a = messageLite;
        this.f87068b = str;
        this.f87069c = objArr;
        char cCharAt = str.charAt(0);
        if (cCharAt < 55296) {
            this.f87070d = cCharAt;
            return;
        }
        int i3 = cCharAt & 8191;
        int i4 = 13;
        int i5 = 1;
        while (true) {
            int i6 = i5 + 1;
            char cCharAt2 = str.charAt(i5);
            if (cCharAt2 < 55296) {
                this.f87070d = i3 | (cCharAt2 << i4);
                return;
            } else {
                i3 |= (cCharAt2 & 8191) << i4;
                i4 += 13;
                i5 = i6;
            }
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MessageInfo
    public boolean a() {
        return (this.f87070d & 2) == 2;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MessageInfo
    public MessageLite b() {
        return this.f87067a;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MessageInfo
    public ProtoSyntax c() {
        return (this.f87070d & 1) == 1 ? ProtoSyntax.PROTO2 : ProtoSyntax.PROTO3;
    }

    Object[] d() {
        return this.f87069c;
    }

    String e() {
        return this.f87068b;
    }
}
