package androidx.glance.appwidget.protobuf;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@CheckReturnValue
final class StructuralMessageInfo implements MessageInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ProtoSyntax f39258a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f39259b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int[] f39260c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final FieldInfo[] f39261d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final MessageLite f39262e;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {
    }

    @Override // androidx.glance.appwidget.protobuf.MessageInfo
    public boolean a() {
        return this.f39259b;
    }

    @Override // androidx.glance.appwidget.protobuf.MessageInfo
    public MessageLite b() {
        return this.f39262e;
    }

    @Override // androidx.glance.appwidget.protobuf.MessageInfo
    public ProtoSyntax c() {
        return this.f39258a;
    }

    public int[] d() {
        return this.f39260c;
    }

    public FieldInfo[] e() {
        return this.f39261d;
    }
}
