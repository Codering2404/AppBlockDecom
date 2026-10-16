package androidx.datastore.preferences.protobuf;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@CheckReturnValue
final class StructuralMessageInfo implements MessageInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ProtoSyntax f36615a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f36616b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int[] f36617c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final FieldInfo[] f36618d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final MessageLite f36619e;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {
    }

    @Override // androidx.datastore.preferences.protobuf.MessageInfo
    public boolean a() {
        return this.f36616b;
    }

    @Override // androidx.datastore.preferences.protobuf.MessageInfo
    public MessageLite b() {
        return this.f36619e;
    }

    @Override // androidx.datastore.preferences.protobuf.MessageInfo
    public ProtoSyntax c() {
        return this.f36615a;
    }

    public int[] d() {
        return this.f36617c;
    }

    public FieldInfo[] e() {
        return this.f36618d;
    }
}
