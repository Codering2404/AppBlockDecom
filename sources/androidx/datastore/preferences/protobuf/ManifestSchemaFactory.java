package androidx.datastore.preferences.protobuf;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@CheckReturnValue
final class ManifestSchemaFactory implements SchemaFactory {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final MessageInfoFactory f36495b = new MessageInfoFactory() { // from class: androidx.datastore.preferences.protobuf.ManifestSchemaFactory.1
        @Override // androidx.datastore.preferences.protobuf.MessageInfoFactory
        public MessageInfo a(Class cls) {
            throw new IllegalStateException("This should never be called.");
        }

        @Override // androidx.datastore.preferences.protobuf.MessageInfoFactory
        public boolean b(Class cls) {
            return false;
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MessageInfoFactory f36496a;

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.ManifestSchemaFactory$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f36497a;

        static {
            int[] iArr = new int[ProtoSyntax.values().length];
            f36497a = iArr;
            try {
                iArr[ProtoSyntax.PROTO3.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class CompositeMessageInfoFactory implements MessageInfoFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private MessageInfoFactory[] f36498a;

        CompositeMessageInfoFactory(MessageInfoFactory... messageInfoFactoryArr) {
            this.f36498a = messageInfoFactoryArr;
        }

        @Override // androidx.datastore.preferences.protobuf.MessageInfoFactory
        public MessageInfo a(Class cls) {
            for (MessageInfoFactory messageInfoFactory : this.f36498a) {
                if (messageInfoFactory.b(cls)) {
                    return messageInfoFactory.a(cls);
                }
            }
            throw new UnsupportedOperationException("No factory is available for message type: " + cls.getName());
        }

        @Override // androidx.datastore.preferences.protobuf.MessageInfoFactory
        public boolean b(Class cls) {
            for (MessageInfoFactory messageInfoFactory : this.f36498a) {
                if (messageInfoFactory.b(cls)) {
                    return true;
                }
            }
            return false;
        }
    }

    public ManifestSchemaFactory() {
        this(c());
    }

    private static boolean b(MessageInfo messageInfo) {
        return AnonymousClass2.f36497a[messageInfo.c().ordinal()] != 1;
    }

    private static MessageInfoFactory c() {
        return new CompositeMessageInfoFactory(GeneratedMessageInfoFactory.c(), d());
    }

    private static MessageInfoFactory d() {
        if (Protobuf.f36554d) {
            return f36495b;
        }
        try {
            return (MessageInfoFactory) Class.forName("androidx.datastore.preferences.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", null).invoke(null, null);
        } catch (Exception unused) {
            return f36495b;
        }
    }

    private static Schema e(Class cls, MessageInfo messageInfo) {
        if (f(cls)) {
            return MessageSchema.S(cls, messageInfo, NewInstanceSchemas.b(), ListFieldSchemas.b(), SchemaUtil.L(), b(messageInfo) ? ExtensionSchemas.b() : null, MapFieldSchemas.b());
        }
        NewInstanceSchema newInstanceSchemaA = NewInstanceSchemas.a();
        ExtensionSchema extensionSchemaA = null;
        ListFieldSchema listFieldSchemaA = ListFieldSchemas.a();
        UnknownFieldSchema unknownFieldSchemaK = SchemaUtil.K();
        if (b(messageInfo)) {
            extensionSchemaA = ExtensionSchemas.a();
        }
        return MessageSchema.S(cls, messageInfo, newInstanceSchemaA, listFieldSchemaA, unknownFieldSchemaK, extensionSchemaA, MapFieldSchemas.a());
    }

    private static boolean f(Class cls) {
        return Protobuf.f36554d || GeneratedMessageLite.class.isAssignableFrom(cls);
    }

    @Override // androidx.datastore.preferences.protobuf.SchemaFactory
    public Schema a(Class cls) {
        SchemaUtil.H(cls);
        MessageInfo messageInfoA = this.f36496a.a(cls);
        return messageInfoA.a() ? f(cls) ? MessageSetSchema.l(SchemaUtil.L(), ExtensionSchemas.b(), messageInfoA.b()) : MessageSetSchema.l(SchemaUtil.K(), ExtensionSchemas.a(), messageInfoA.b()) : e(cls, messageInfoA);
    }

    private ManifestSchemaFactory(MessageInfoFactory messageInfoFactory) {
        this.f36496a = (MessageInfoFactory) Internal.b(messageInfoFactory, "messageInfoFactory");
    }
}
