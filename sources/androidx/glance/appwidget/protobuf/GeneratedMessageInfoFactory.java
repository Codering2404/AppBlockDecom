package androidx.glance.appwidget.protobuf;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
class GeneratedMessageInfoFactory implements MessageInfoFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final GeneratedMessageInfoFactory f39051a = new GeneratedMessageInfoFactory();

    private GeneratedMessageInfoFactory() {
    }

    public static GeneratedMessageInfoFactory c() {
        return f39051a;
    }

    @Override // androidx.glance.appwidget.protobuf.MessageInfoFactory
    public MessageInfo a(Class cls) {
        if (!GeneratedMessageLite.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Unsupported message type: " + cls.getName());
        }
        try {
            return (MessageInfo) GeneratedMessageLite.B(cls.asSubclass(GeneratedMessageLite.class)).q();
        } catch (Exception e3) {
            throw new RuntimeException("Unable to get message info for " + cls.getName(), e3);
        }
    }

    @Override // androidx.glance.appwidget.protobuf.MessageInfoFactory
    public boolean b(Class cls) {
        return GeneratedMessageLite.class.isAssignableFrom(cls);
    }
}
