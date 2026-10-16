package com.google.crypto.tink.shaded.protobuf;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class GeneratedMessageInfoFactory implements MessageInfoFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final GeneratedMessageInfoFactory f86912a = new GeneratedMessageInfoFactory();

    private GeneratedMessageInfoFactory() {
    }

    public static GeneratedMessageInfoFactory c() {
        return f86912a;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MessageInfoFactory
    public MessageInfo a(Class cls) {
        if (!GeneratedMessageLite.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Unsupported message type: " + cls.getName());
        }
        try {
            return (MessageInfo) GeneratedMessageLite.z(cls.asSubclass(GeneratedMessageLite.class)).p();
        } catch (Exception e3) {
            throw new RuntimeException("Unable to get message info for " + cls.getName(), e3);
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MessageInfoFactory
    public boolean b(Class cls) {
        return GeneratedMessageLite.class.isAssignableFrom(cls);
    }
}
