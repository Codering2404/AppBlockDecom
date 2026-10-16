package androidx.glance.appwidget.protobuf;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@CheckReturnValue
final class ManifestSchemaFactory implements SchemaFactory {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final MessageInfoFactory f39142b = new MessageInfoFactory() { // from class: androidx.glance.appwidget.protobuf.ManifestSchemaFactory.1
        @Override // androidx.glance.appwidget.protobuf.MessageInfoFactory
        public MessageInfo a(Class cls) {
            throw new IllegalStateException("This should never be called.");
        }

        @Override // androidx.glance.appwidget.protobuf.MessageInfoFactory
        public boolean b(Class cls) {
            return false;
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MessageInfoFactory f39143a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class CompositeMessageInfoFactory implements MessageInfoFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private MessageInfoFactory[] f39144a;

        CompositeMessageInfoFactory(MessageInfoFactory... messageInfoFactoryArr) {
            this.f39144a = messageInfoFactoryArr;
        }

        @Override // androidx.glance.appwidget.protobuf.MessageInfoFactory
        public MessageInfo a(Class cls) {
            for (MessageInfoFactory messageInfoFactory : this.f39144a) {
                if (messageInfoFactory.b(cls)) {
                    return messageInfoFactory.a(cls);
                }
            }
            throw new UnsupportedOperationException("No factory is available for message type: " + cls.getName());
        }

        @Override // androidx.glance.appwidget.protobuf.MessageInfoFactory
        public boolean b(Class cls) {
            for (MessageInfoFactory messageInfoFactory : this.f39144a) {
                if (messageInfoFactory.b(cls)) {
                    return true;
                }
            }
            return false;
        }
    }

    public ManifestSchemaFactory() {
        this(b());
    }

    private static MessageInfoFactory b() {
        return new CompositeMessageInfoFactory(GeneratedMessageInfoFactory.c(), c());
    }

    private static MessageInfoFactory c() {
        try {
            return (MessageInfoFactory) Class.forName("androidx.glance.appwidget.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", null).invoke(null, null);
        } catch (Exception unused) {
            return f39142b;
        }
    }

    private static boolean d(MessageInfo messageInfo) {
        return messageInfo.c() == ProtoSyntax.PROTO2;
    }

    private static Schema e(Class cls, MessageInfo messageInfo) {
        return GeneratedMessageLite.class.isAssignableFrom(cls) ? d(messageInfo) ? MessageSchema.U(cls, messageInfo, NewInstanceSchemas.b(), ListFieldSchema.b(), SchemaUtil.M(), ExtensionSchemas.b(), MapFieldSchemas.b()) : MessageSchema.U(cls, messageInfo, NewInstanceSchemas.b(), ListFieldSchema.b(), SchemaUtil.M(), null, MapFieldSchemas.b()) : d(messageInfo) ? MessageSchema.U(cls, messageInfo, NewInstanceSchemas.a(), ListFieldSchema.a(), SchemaUtil.H(), ExtensionSchemas.a(), MapFieldSchemas.a()) : MessageSchema.U(cls, messageInfo, NewInstanceSchemas.a(), ListFieldSchema.a(), SchemaUtil.I(), null, MapFieldSchemas.a());
    }

    @Override // androidx.glance.appwidget.protobuf.SchemaFactory
    public Schema a(Class cls) {
        SchemaUtil.J(cls);
        MessageInfo messageInfoA = this.f39143a.a(cls);
        return messageInfoA.a() ? GeneratedMessageLite.class.isAssignableFrom(cls) ? MessageSetSchema.l(SchemaUtil.M(), ExtensionSchemas.b(), messageInfoA.b()) : MessageSetSchema.l(SchemaUtil.H(), ExtensionSchemas.a(), messageInfoA.b()) : e(cls, messageInfoA);
    }

    private ManifestSchemaFactory(MessageInfoFactory messageInfoFactory) {
        this.f39143a = (MessageInfoFactory) Internal.b(messageInfoFactory, "messageInfoFactory");
    }
}
