package androidx.glance.appwidget.protobuf;

import androidx.glance.appwidget.protobuf.AbstractMessageLite;
import androidx.glance.appwidget.protobuf.ArrayDecoders;
import androidx.glance.appwidget.protobuf.FieldSet;
import androidx.glance.appwidget.protobuf.GeneratedMessageLite;
import androidx.glance.appwidget.protobuf.GeneratedMessageLite.Builder;
import androidx.glance.appwidget.protobuf.Internal;
import androidx.glance.appwidget.protobuf.MessageLite;
import androidx.glance.appwidget.protobuf.WireFormat;
import com.google.android.gms.common.api.Api;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class GeneratedMessageLite<MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> extends AbstractMessageLite<MessageType, BuilderType> {
    private static final int MEMOIZED_SERIALIZED_SIZE_MASK = Integer.MAX_VALUE;
    private static final int MUTABLE_FLAG_MASK = Integer.MIN_VALUE;
    static final int UNINITIALIZED_HASH_CODE = 0;
    static final int UNINITIALIZED_SERIALIZED_SIZE = Integer.MAX_VALUE;
    private static Map<Object, GeneratedMessageLite<?, ?>> defaultInstanceMap = new ConcurrentHashMap();
    private int memoizedSerializedSize = -1;
    protected UnknownFieldSetLite unknownFields = UnknownFieldSetLite.c();

    /* JADX INFO: renamed from: androidx.glance.appwidget.protobuf.GeneratedMessageLite$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f39052a;

        static {
            int[] iArr = new int[WireFormat.JavaType.values().length];
            f39052a = iArr;
            try {
                iArr[WireFormat.JavaType.MESSAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f39052a[WireFormat.JavaType.ENUM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class Builder<MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> extends AbstractMessageLite.Builder<MessageType, BuilderType> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final GeneratedMessageLite f39053a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        protected GeneratedMessageLite f39054b;

        protected Builder(GeneratedMessageLite generatedMessageLite) {
            this.f39053a = generatedMessageLite;
            if (generatedMessageLite.H()) {
                throw new IllegalArgumentException("Default instance must be immutable.");
            }
            this.f39054b = J();
        }

        private static void I(Object obj, Object obj2) {
            Protobuf.a().d(obj).a(obj, obj2);
        }

        private GeneratedMessageLite J() {
            return this.f39053a.N();
        }

        protected void A() {
            GeneratedMessageLite generatedMessageLiteJ = J();
            I(generatedMessageLiteJ, this.f39054b);
            this.f39054b = generatedMessageLiteJ;
        }

        @Override // androidx.glance.appwidget.protobuf.MessageLiteOrBuilder
        /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
        public GeneratedMessageLite g() {
            return this.f39053a;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.glance.appwidget.protobuf.AbstractMessageLite.Builder
        /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
        public Builder p(GeneratedMessageLite generatedMessageLite) {
            return F(generatedMessageLite);
        }

        @Override // androidx.glance.appwidget.protobuf.AbstractMessageLite.Builder
        /* JADX INFO: renamed from: E, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public Builder r(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            z();
            try {
                Protobuf.a().d(this.f39054b).h(this.f39054b, CodedInputStreamReader.Q(codedInputStream), extensionRegistryLite);
                return this;
            } catch (RuntimeException e3) {
                if (e3.getCause() instanceof IOException) {
                    throw ((IOException) e3.getCause());
                }
                throw e3;
            }
        }

        public Builder F(GeneratedMessageLite generatedMessageLite) {
            if (g().equals(generatedMessageLite)) {
                return this;
            }
            z();
            I(this.f39054b, generatedMessageLite);
            return this;
        }

        @Override // androidx.glance.appwidget.protobuf.AbstractMessageLite.Builder
        /* JADX INFO: renamed from: G, reason: merged with bridge method [inline-methods] */
        public Builder u(byte[] bArr, int i3, int i4) {
            return H(bArr, i3, i4, ExtensionRegistryLite.b());
        }

        public Builder H(byte[] bArr, int i3, int i4, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            z();
            try {
                Protobuf.a().d(this.f39054b).i(this.f39054b, bArr, i3, i3 + i4, new ArrayDecoders.Registers(extensionRegistryLite));
                return this;
            } catch (InvalidProtocolBufferException e3) {
                throw e3;
            } catch (IOException e4) {
                throw new RuntimeException("Reading from byte array should not throw IOException.", e4);
            } catch (IndexOutOfBoundsException unused) {
                throw InvalidProtocolBufferException.m();
            }
        }

        @Override // androidx.glance.appwidget.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return GeneratedMessageLite.G(this.f39054b, false);
        }

        @Override // androidx.glance.appwidget.protobuf.MessageLite.Builder
        /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
        public final GeneratedMessageLite build() {
            GeneratedMessageLite generatedMessageLiteF = f();
            if (generatedMessageLiteF.isInitialized()) {
                return generatedMessageLiteF;
            }
            throw AbstractMessageLite.Builder.v(generatedMessageLiteF);
        }

        @Override // androidx.glance.appwidget.protobuf.MessageLite.Builder
        /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
        public GeneratedMessageLite f() {
            if (!this.f39054b.H()) {
                return this.f39054b;
            }
            this.f39054b.I();
            return this.f39054b;
        }

        @Override // androidx.glance.appwidget.protobuf.AbstractMessageLite.Builder
        /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public Builder m() {
            Builder builderE = g().e();
            builderE.f39054b = f();
            return builderE;
        }

        protected final void z() {
            if (this.f39054b.H()) {
                return;
            }
            A();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class DefaultInstanceBasedParser<T extends GeneratedMessageLite<T, ?>> extends AbstractParser<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final GeneratedMessageLite f39055b;

        public DefaultInstanceBasedParser(GeneratedMessageLite generatedMessageLite) {
            this.f39055b = generatedMessageLite;
        }

        @Override // androidx.glance.appwidget.protobuf.Parser
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public GeneratedMessageLite a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return GeneratedMessageLite.P(this.f39055b, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class ExtendableBuilder<MessageType extends ExtendableMessage<MessageType, BuilderType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>> extends Builder<MessageType, BuilderType> implements ExtendableMessageOrBuilder<MessageType, BuilderType> {
        @Override // androidx.glance.appwidget.protobuf.GeneratedMessageLite.Builder
        protected void A() {
            super.A();
            if (((ExtendableMessage) this.f39054b).extensions != FieldSet.h()) {
                GeneratedMessageLite generatedMessageLite = this.f39054b;
                ((ExtendableMessage) generatedMessageLite).extensions = ((ExtendableMessage) generatedMessageLite).extensions.clone();
            }
        }

        @Override // androidx.glance.appwidget.protobuf.GeneratedMessageLite.Builder
        /* JADX INFO: renamed from: K, reason: merged with bridge method [inline-methods] */
        public final ExtendableMessage f() {
            if (!((ExtendableMessage) this.f39054b).H()) {
                return (ExtendableMessage) this.f39054b;
            }
            ((ExtendableMessage) this.f39054b).extensions.u();
            return (ExtendableMessage) super.f();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class ExtendableMessage<MessageType extends ExtendableMessage<MessageType, BuilderType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>> extends GeneratedMessageLite<MessageType, BuilderType> implements ExtendableMessageOrBuilder<MessageType, BuilderType> {
        protected FieldSet<ExtensionDescriptor> extensions;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        protected class ExtensionWriter {
        }

        FieldSet T() {
            if (this.extensions.o()) {
                this.extensions = this.extensions.clone();
            }
            return this.extensions;
        }

        @Override // androidx.glance.appwidget.protobuf.GeneratedMessageLite, androidx.glance.appwidget.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder a() {
            return super.a();
        }

        @Override // androidx.glance.appwidget.protobuf.GeneratedMessageLite, androidx.glance.appwidget.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder e() {
            return super.e();
        }

        @Override // androidx.glance.appwidget.protobuf.GeneratedMessageLite, androidx.glance.appwidget.protobuf.MessageLiteOrBuilder
        public /* bridge */ /* synthetic */ MessageLite g() {
            return super.g();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface ExtendableMessageOrBuilder<MessageType extends ExtendableMessage<MessageType, BuilderType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>> extends MessageLiteOrBuilder {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ExtensionDescriptor implements FieldSet.FieldDescriptorLite<ExtensionDescriptor> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Internal.EnumLiteMap f39056a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f39057b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final WireFormat.FieldType f39058c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final boolean f39059d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final boolean f39060f;

        @Override // androidx.glance.appwidget.protobuf.FieldSet.FieldDescriptorLite
        public int J() {
            return this.f39057b;
        }

        @Override // androidx.glance.appwidget.protobuf.FieldSet.FieldDescriptorLite
        public boolean K() {
            return this.f39059d;
        }

        @Override // androidx.glance.appwidget.protobuf.FieldSet.FieldDescriptorLite
        public WireFormat.FieldType L() {
            return this.f39058c;
        }

        @Override // androidx.glance.appwidget.protobuf.FieldSet.FieldDescriptorLite
        public WireFormat.JavaType M() {
            return this.f39058c.a();
        }

        @Override // androidx.glance.appwidget.protobuf.FieldSet.FieldDescriptorLite
        public boolean N() {
            return this.f39060f;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(ExtensionDescriptor extensionDescriptor) {
            return this.f39057b - extensionDescriptor.f39057b;
        }

        public Internal.EnumLiteMap b() {
            return this.f39056a;
        }

        @Override // androidx.glance.appwidget.protobuf.FieldSet.FieldDescriptorLite
        public MessageLite.Builder z0(MessageLite.Builder builder, MessageLite messageLite) {
            return ((Builder) builder).F((GeneratedMessageLite) messageLite);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class GeneratedExtension<ContainingType extends MessageLite, Type> extends ExtensionLite<ContainingType, Type> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final MessageLite f39061a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final ExtensionDescriptor f39062b;

        public WireFormat.FieldType a() {
            return this.f39062b.L();
        }

        public MessageLite b() {
            return this.f39061a;
        }

        public int c() {
            return this.f39062b.J();
        }

        public boolean d() {
            return this.f39062b.f39059d;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum MethodToInvoke {
        GET_MEMOIZED_IS_INITIALIZED,
        SET_MEMOIZED_IS_INITIALIZED,
        BUILD_MESSAGE_INFO,
        NEW_MUTABLE_INSTANCE,
        NEW_BUILDER,
        GET_DEFAULT_INSTANCE,
        GET_PARSER
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    protected static final class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Class f39071a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f39072b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final byte[] f39073c;

        private Object a() {
            try {
                java.lang.reflect.Field declaredField = b().getDeclaredField("defaultInstance");
                declaredField.setAccessible(true);
                return ((MessageLite) declaredField.get(null)).e().n(this.f39073c).f();
            } catch (InvalidProtocolBufferException e3) {
                throw new RuntimeException("Unable to understand proto buffer", e3);
            } catch (ClassNotFoundException e4) {
                throw new RuntimeException("Unable to find proto buffer class: " + this.f39072b, e4);
            } catch (IllegalAccessException e5) {
                throw new RuntimeException("Unable to call parsePartialFrom", e5);
            } catch (NoSuchFieldException e6) {
                throw new RuntimeException("Unable to find defaultInstance in " + this.f39072b, e6);
            } catch (SecurityException e7) {
                throw new RuntimeException("Unable to call defaultInstance in " + this.f39072b, e7);
            }
        }

        private Class b() {
            Class cls = this.f39071a;
            return cls != null ? cls : Class.forName(this.f39072b);
        }

        protected Object readResolve() throws ObjectStreamException {
            try {
                java.lang.reflect.Field declaredField = b().getDeclaredField("DEFAULT_INSTANCE");
                declaredField.setAccessible(true);
                return ((MessageLite) declaredField.get(null)).e().n(this.f39073c).f();
            } catch (InvalidProtocolBufferException e3) {
                throw new RuntimeException("Unable to understand proto buffer", e3);
            } catch (ClassNotFoundException e4) {
                throw new RuntimeException("Unable to find proto buffer class: " + this.f39072b, e4);
            } catch (IllegalAccessException e5) {
                throw new RuntimeException("Unable to call parsePartialFrom", e5);
            } catch (NoSuchFieldException unused) {
                return a();
            } catch (SecurityException e6) {
                throw new RuntimeException("Unable to call DEFAULT_INSTANCE in " + this.f39072b, e6);
            }
        }
    }

    protected static Internal.ProtobufList A() {
        return ProtobufArrayList.d();
    }

    static GeneratedMessageLite B(Class cls) {
        GeneratedMessageLite<?, ?> generatedMessageLite = defaultInstanceMap.get(cls);
        if (generatedMessageLite == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                generatedMessageLite = defaultInstanceMap.get(cls);
            } catch (ClassNotFoundException e3) {
                throw new IllegalStateException("Class initialization cannot fail.", e3);
            }
        }
        if (generatedMessageLite != null) {
            return generatedMessageLite;
        }
        GeneratedMessageLite<?, ?> generatedMessageLiteG = ((GeneratedMessageLite) UnsafeUtil.l(cls)).g();
        if (generatedMessageLiteG == null) {
            throw new IllegalStateException();
        }
        defaultInstanceMap.put(cls, generatedMessageLiteG);
        return generatedMessageLiteG;
    }

    static Object F(java.lang.reflect.Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e3) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e3);
        } catch (InvocationTargetException e4) {
            Throwable cause = e4.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    protected static final boolean G(GeneratedMessageLite generatedMessageLite, boolean z2) {
        byte bByteValue = ((Byte) generatedMessageLite.x(MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        boolean zC = Protobuf.a().d(generatedMessageLite).c(generatedMessageLite);
        if (z2) {
            generatedMessageLite.y(MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED, zC ? generatedMessageLite : null);
        }
        return zC;
    }

    protected static Internal.ProtobufList K(Internal.ProtobufList protobufList) {
        int size = protobufList.size();
        return protobufList.c(size == 0 ? 10 : size * 2);
    }

    protected static Object M(MessageLite messageLite, String str, Object[] objArr) {
        return new RawMessageInfo(messageLite, str, objArr);
    }

    protected static GeneratedMessageLite O(GeneratedMessageLite generatedMessageLite, InputStream inputStream) {
        return r(P(generatedMessageLite, CodedInputStream.f(inputStream), ExtensionRegistryLite.b()));
    }

    static GeneratedMessageLite P(GeneratedMessageLite generatedMessageLite, CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        GeneratedMessageLite generatedMessageLiteN = generatedMessageLite.N();
        try {
            Schema schemaD = Protobuf.a().d(generatedMessageLiteN);
            schemaD.h(generatedMessageLiteN, CodedInputStreamReader.Q(codedInputStream), extensionRegistryLite);
            schemaD.b(generatedMessageLiteN);
            return generatedMessageLiteN;
        } catch (InvalidProtocolBufferException e3) {
            e = e3;
            if (e.a()) {
                e = new InvalidProtocolBufferException(e);
            }
            throw e.k(generatedMessageLiteN);
        } catch (UninitializedMessageException e4) {
            throw e4.a().k(generatedMessageLiteN);
        } catch (IOException e5) {
            if (e5.getCause() instanceof InvalidProtocolBufferException) {
                throw ((InvalidProtocolBufferException) e5.getCause());
            }
            throw new InvalidProtocolBufferException(e5).k(generatedMessageLiteN);
        } catch (RuntimeException e6) {
            if (e6.getCause() instanceof InvalidProtocolBufferException) {
                throw ((InvalidProtocolBufferException) e6.getCause());
            }
            throw e6;
        }
    }

    protected static void Q(Class cls, GeneratedMessageLite generatedMessageLite) {
        generatedMessageLite.J();
        defaultInstanceMap.put(cls, generatedMessageLite);
    }

    private static GeneratedMessageLite r(GeneratedMessageLite generatedMessageLite) throws InvalidProtocolBufferException {
        if (generatedMessageLite == null || generatedMessageLite.isInitialized()) {
            return generatedMessageLite;
        }
        throw generatedMessageLite.m().a().k(generatedMessageLite);
    }

    private int v(Schema schema) {
        return schema == null ? Protobuf.a().d(this).d(this) : schema.d(this);
    }

    @Override // androidx.glance.appwidget.protobuf.MessageLiteOrBuilder
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public final GeneratedMessageLite g() {
        return (GeneratedMessageLite) x(MethodToInvoke.GET_DEFAULT_INSTANCE);
    }

    int D() {
        return this.memoizedHashCode;
    }

    boolean E() {
        return D() == 0;
    }

    boolean H() {
        return (this.memoizedSerializedSize & MUTABLE_FLAG_MASK) != 0;
    }

    protected void I() {
        Protobuf.a().d(this).b(this);
        J();
    }

    void J() {
        this.memoizedSerializedSize &= Api.BaseClientBuilder.API_PRIORITY_OTHER;
    }

    @Override // androidx.glance.appwidget.protobuf.MessageLite
    /* JADX INFO: renamed from: L, reason: merged with bridge method [inline-methods] */
    public final Builder e() {
        return (Builder) x(MethodToInvoke.NEW_BUILDER);
    }

    GeneratedMessageLite N() {
        return (GeneratedMessageLite) x(MethodToInvoke.NEW_MUTABLE_INSTANCE);
    }

    void R(int i3) {
        this.memoizedHashCode = i3;
    }

    @Override // androidx.glance.appwidget.protobuf.MessageLite
    /* JADX INFO: renamed from: S, reason: merged with bridge method [inline-methods] */
    public final Builder a() {
        return ((Builder) x(MethodToInvoke.NEW_BUILDER)).F(this);
    }

    @Override // androidx.glance.appwidget.protobuf.MessageLite
    public int c() {
        return k(null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return Protobuf.a().d(this).f(this, (GeneratedMessageLite) obj);
        }
        return false;
    }

    @Override // androidx.glance.appwidget.protobuf.MessageLite
    public final Parser h() {
        return (Parser) x(MethodToInvoke.GET_PARSER);
    }

    public int hashCode() {
        if (H()) {
            return u();
        }
        if (E()) {
            R(u());
        }
        return D();
    }

    @Override // androidx.glance.appwidget.protobuf.MessageLite
    public void i(CodedOutputStream codedOutputStream) {
        Protobuf.a().d(this).g(this, CodedOutputStreamWriter.Q(codedOutputStream));
    }

    @Override // androidx.glance.appwidget.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        return G(this, true);
    }

    @Override // androidx.glance.appwidget.protobuf.AbstractMessageLite
    int j() {
        return this.memoizedSerializedSize & Api.BaseClientBuilder.API_PRIORITY_OTHER;
    }

    @Override // androidx.glance.appwidget.protobuf.AbstractMessageLite
    int k(Schema schema) {
        if (!H()) {
            if (j() != Integer.MAX_VALUE) {
                return j();
            }
            int iV = v(schema);
            o(iV);
            return iV;
        }
        int iV2 = v(schema);
        if (iV2 >= 0) {
            return iV2;
        }
        throw new IllegalStateException("serialized size must be non-negative, was " + iV2);
    }

    @Override // androidx.glance.appwidget.protobuf.AbstractMessageLite
    void o(int i3) {
        if (i3 >= 0) {
            this.memoizedSerializedSize = (i3 & Api.BaseClientBuilder.API_PRIORITY_OTHER) | (this.memoizedSerializedSize & MUTABLE_FLAG_MASK);
        } else {
            throw new IllegalStateException("serialized size must be non-negative, was " + i3);
        }
    }

    Object q() {
        return x(MethodToInvoke.BUILD_MESSAGE_INFO);
    }

    void s() {
        this.memoizedHashCode = 0;
    }

    void t() {
        o(Api.BaseClientBuilder.API_PRIORITY_OTHER);
    }

    public String toString() {
        return MessageLiteToString.f(this, super.toString());
    }

    int u() {
        return Protobuf.a().d(this).e(this);
    }

    protected final Builder w() {
        return (Builder) x(MethodToInvoke.NEW_BUILDER);
    }

    protected Object x(MethodToInvoke methodToInvoke) {
        return z(methodToInvoke, null, null);
    }

    protected Object y(MethodToInvoke methodToInvoke, Object obj) {
        return z(methodToInvoke, obj, null);
    }

    protected abstract Object z(MethodToInvoke methodToInvoke, Object obj, Object obj2);
}
