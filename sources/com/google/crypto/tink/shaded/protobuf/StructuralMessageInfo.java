package com.google.crypto.tink.shaded.protobuf;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@CheckReturnValue
final class StructuralMessageInfo implements MessageInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ProtoSyntax f87119a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f87120b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int[] f87121c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final FieldInfo[] f87122d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final MessageLite f87123e;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MessageInfo
    public boolean a() {
        return this.f87120b;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MessageInfo
    public MessageLite b() {
        return this.f87123e;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MessageInfo
    public ProtoSyntax c() {
        return this.f87119a;
    }

    public int[] d() {
        return this.f87121c;
    }

    public FieldInfo[] e() {
        return this.f87122d;
    }
}
