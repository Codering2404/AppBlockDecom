package com.google.crypto.tink.shaded.protobuf;

import com.google.android.gms.common.api.Api;
import com.google.crypto.tink.shaded.protobuf.AbstractMessageLite;
import com.google.crypto.tink.shaded.protobuf.ArrayDecoders;
import com.google.crypto.tink.shaded.protobuf.FieldSet;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.Builder;
import com.google.crypto.tink.shaded.protobuf.Internal;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.shaded.protobuf.WireFormat;
import cz.mobilesoft.coreblock.scene.lockscreen.EI.MrGIhy;
import java.io.IOException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class GeneratedMessageLite<MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> extends AbstractMessageLite<MessageType, BuilderType> {
    private static final int MEMOIZED_SERIALIZED_SIZE_MASK = Integer.MAX_VALUE;
    private static final int MUTABLE_FLAG_MASK = Integer.MIN_VALUE;
    static final int UNINITIALIZED_HASH_CODE = 0;
    static final int UNINITIALIZED_SERIALIZED_SIZE = Integer.MAX_VALUE;
    private static Map<Object, GeneratedMessageLite<?, ?>> defaultInstanceMap = new ConcurrentHashMap();
    private int memoizedSerializedSize = -1;
    protected UnknownFieldSetLite unknownFields = UnknownFieldSetLite.c();

    /* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f86913a;

        static {
            int[] iArr = new int[WireFormat.JavaType.values().length];
            f86913a = iArr;
            try {
                iArr[WireFormat.JavaType.MESSAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f86913a[WireFormat.JavaType.ENUM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class Builder<MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> extends AbstractMessageLite.Builder<MessageType, BuilderType> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final GeneratedMessageLite f86914a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        protected GeneratedMessageLite f86915b;

        protected Builder(GeneratedMessageLite generatedMessageLite) {
            this.f86914a = generatedMessageLite;
            if (generatedMessageLite.F()) {
                throw new IllegalArgumentException("Default instance must be immutable.");
            }
            this.f86915b = I();
        }

        private static void H(Object obj, Object obj2) {
            Protobuf.a().d(obj).a(obj, obj2);
        }

        private GeneratedMessageLite I() {
            return this.f86914a.L();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder
        /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
        public GeneratedMessageLite g() {
            return this.f86914a;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.crypto.tink.shaded.protobuf.AbstractMessageLite.Builder
        /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
        public Builder o(GeneratedMessageLite generatedMessageLite) {
            return E(generatedMessageLite);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractMessageLite.Builder
        /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public Builder q(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            y();
            try {
                Protobuf.a().d(this.f86915b).h(this.f86915b, CodedInputStreamReader.Q(codedInputStream), extensionRegistryLite);
                return this;
            } catch (RuntimeException e3) {
                if (e3.getCause() instanceof IOException) {
                    throw ((IOException) e3.getCause());
                }
                throw e3;
            }
        }

        public Builder E(GeneratedMessageLite generatedMessageLite) {
            if (g().equals(generatedMessageLite)) {
                return this;
            }
            y();
            H(this.f86915b, generatedMessageLite);
            return this;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractMessageLite.Builder
        /* JADX INFO: renamed from: F, reason: merged with bridge method [inline-methods] */
        public Builder t(byte[] bArr, int i3, int i4) {
            return G(bArr, i3, i4, ExtensionRegistryLite.b());
        }

        public Builder G(byte[] bArr, int i3, int i4, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            y();
            try {
                Protobuf.a().d(this.f86915b).g(this.f86915b, bArr, i3, i3 + i4, new ArrayDecoders.Registers(extensionRegistryLite));
                return this;
            } catch (InvalidProtocolBufferException e3) {
                throw e3;
            } catch (IOException e4) {
                throw new RuntimeException("Reading from byte array should not throw IOException.", e4);
            } catch (IndexOutOfBoundsException unused) {
                throw InvalidProtocolBufferException.m();
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return GeneratedMessageLite.E(this.f86915b, false);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
        /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
        public final GeneratedMessageLite build() {
            GeneratedMessageLite generatedMessageLiteF = f();
            if (generatedMessageLiteF.isInitialized()) {
                return generatedMessageLiteF;
            }
            throw AbstractMessageLite.Builder.u(generatedMessageLiteF);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
        /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
        public GeneratedMessageLite f() {
            if (!this.f86915b.F()) {
                return this.f86915b;
            }
            this.f86915b.G();
            return this.f86915b;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractMessageLite.Builder
        /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public Builder k() {
            Builder builderE = g().e();
            builderE.f86915b = f();
            return builderE;
        }

        protected final void y() {
            if (this.f86915b.F()) {
                return;
            }
            z();
        }

        protected void z() {
            GeneratedMessageLite generatedMessageLiteI = I();
            H(generatedMessageLiteI, this.f86915b);
            this.f86915b = generatedMessageLiteI;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    protected static class DefaultInstanceBasedParser<T extends GeneratedMessageLite<T, ?>> extends AbstractParser<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final GeneratedMessageLite f86916b;

        public DefaultInstanceBasedParser(GeneratedMessageLite generatedMessageLite) {
            this.f86916b = generatedMessageLite;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Parser
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public GeneratedMessageLite a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return GeneratedMessageLite.M(this.f86916b, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class ExtendableBuilder<MessageType extends ExtendableMessage<MessageType, BuilderType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>> extends Builder<MessageType, BuilderType> implements ExtendableMessageOrBuilder<MessageType, BuilderType> {
        @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.Builder
        /* JADX INFO: renamed from: J, reason: merged with bridge method [inline-methods] */
        public final ExtendableMessage f() {
            if (!((ExtendableMessage) this.f86915b).F()) {
                return (ExtendableMessage) this.f86915b;
            }
            ((ExtendableMessage) this.f86915b).extensions.u();
            return (ExtendableMessage) super.f();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.Builder
        protected void z() {
            super.z();
            if (((ExtendableMessage) this.f86915b).extensions != FieldSet.h()) {
                GeneratedMessageLite generatedMessageLite = this.f86915b;
                ((ExtendableMessage) generatedMessageLite).extensions = ((ExtendableMessage) generatedMessageLite).extensions.clone();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class ExtendableMessage<MessageType extends ExtendableMessage<MessageType, BuilderType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>> extends GeneratedMessageLite<MessageType, BuilderType> implements ExtendableMessageOrBuilder<MessageType, BuilderType> {
        protected FieldSet<ExtensionDescriptor> extensions;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        protected class ExtensionWriter {
        }

        FieldSet Q() {
            if (this.extensions.o()) {
                this.extensions = this.extensions.clone();
            }
            return this.extensions;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite, com.google.crypto.tink.shaded.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder a() {
            return super.a();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite, com.google.crypto.tink.shaded.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder e() {
            return super.e();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite, com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder
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
        final Internal.EnumLiteMap f86917a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f86918b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final WireFormat.FieldType f86919c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final boolean f86920d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final boolean f86921f;

        @Override // com.google.crypto.tink.shaded.protobuf.FieldSet.FieldDescriptorLite
        public int J() {
            return this.f86918b;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.FieldSet.FieldDescriptorLite
        public boolean K() {
            return this.f86920d;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.FieldSet.FieldDescriptorLite
        public WireFormat.FieldType L() {
            return this.f86919c;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.FieldSet.FieldDescriptorLite
        public WireFormat.JavaType M() {
            return this.f86919c.a();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.FieldSet.FieldDescriptorLite
        public boolean N() {
            return this.f86921f;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(ExtensionDescriptor extensionDescriptor) {
            return this.f86918b - extensionDescriptor.f86918b;
        }

        public Internal.EnumLiteMap b() {
            return this.f86917a;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.FieldSet.FieldDescriptorLite
        public MessageLite.Builder w0(MessageLite.Builder builder, MessageLite messageLite) {
            return ((Builder) builder).E((GeneratedMessageLite) messageLite);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class GeneratedExtension<ContainingType extends MessageLite, Type> extends ExtensionLite<ContainingType, Type> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final MessageLite f86922a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final ExtensionDescriptor f86923b;

        public WireFormat.FieldType a() {
            return this.f86923b.L();
        }

        public MessageLite b() {
            return this.f86922a;
        }

        public int c() {
            return this.f86923b.J();
        }

        public boolean d() {
            return this.f86923b.f86920d;
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

    static Object D(java.lang.reflect.Method method, Object obj, Object... objArr) {
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

    protected static final boolean E(GeneratedMessageLite generatedMessageLite, boolean z2) {
        byte bByteValue = ((Byte) generatedMessageLite.v(MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        boolean zC = Protobuf.a().d(generatedMessageLite).c(generatedMessageLite);
        if (z2) {
            generatedMessageLite.w(MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED, zC ? generatedMessageLite : null);
        }
        return zC;
    }

    protected static Internal.ProtobufList I(Internal.ProtobufList protobufList) {
        int size = protobufList.size();
        return protobufList.c(size == 0 ? 10 : size * 2);
    }

    protected static Object K(MessageLite messageLite, String str, Object[] objArr) {
        return new RawMessageInfo(messageLite, str, objArr);
    }

    static GeneratedMessageLite M(GeneratedMessageLite generatedMessageLite, CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        GeneratedMessageLite generatedMessageLiteL = generatedMessageLite.L();
        try {
            Schema schemaD = Protobuf.a().d(generatedMessageLiteL);
            schemaD.h(generatedMessageLiteL, CodedInputStreamReader.Q(codedInputStream), extensionRegistryLite);
            schemaD.b(generatedMessageLiteL);
            return generatedMessageLiteL;
        } catch (InvalidProtocolBufferException e3) {
            e = e3;
            if (e.a()) {
                e = new InvalidProtocolBufferException(e);
            }
            throw e.k(generatedMessageLiteL);
        } catch (UninitializedMessageException e4) {
            throw e4.a().k(generatedMessageLiteL);
        } catch (IOException e5) {
            if (e5.getCause() instanceof InvalidProtocolBufferException) {
                throw ((InvalidProtocolBufferException) e5.getCause());
            }
            throw new InvalidProtocolBufferException(e5).k(generatedMessageLiteL);
        } catch (RuntimeException e6) {
            if (e6.getCause() instanceof InvalidProtocolBufferException) {
                throw ((InvalidProtocolBufferException) e6.getCause());
            }
            throw e6;
        }
    }

    protected static void N(Class cls, GeneratedMessageLite generatedMessageLite) {
        generatedMessageLite.H();
        defaultInstanceMap.put(cls, generatedMessageLite);
    }

    private int t(Schema schema) {
        return schema == null ? Protobuf.a().d(this).d(this) : schema.d(this);
    }

    protected static Internal.ProtobufList y() {
        return ProtobufArrayList.d();
    }

    static GeneratedMessageLite z(Class cls) {
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

    @Override // com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder
    /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
    public final GeneratedMessageLite g() {
        return (GeneratedMessageLite) v(MethodToInvoke.GET_DEFAULT_INSTANCE);
    }

    int B() {
        return this.memoizedHashCode;
    }

    boolean C() {
        return B() == 0;
    }

    boolean F() {
        return (this.memoizedSerializedSize & MUTABLE_FLAG_MASK) != 0;
    }

    protected void G() {
        Protobuf.a().d(this).b(this);
        H();
    }

    void H() {
        this.memoizedSerializedSize &= Api.BaseClientBuilder.API_PRIORITY_OTHER;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MessageLite
    /* JADX INFO: renamed from: J, reason: merged with bridge method [inline-methods] */
    public final Builder e() {
        return (Builder) v(MethodToInvoke.NEW_BUILDER);
    }

    GeneratedMessageLite L() {
        return (GeneratedMessageLite) v(MethodToInvoke.NEW_MUTABLE_INSTANCE);
    }

    void O(int i3) {
        this.memoizedHashCode = i3;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MessageLite
    /* JADX INFO: renamed from: P, reason: merged with bridge method [inline-methods] */
    public final Builder a() {
        return ((Builder) v(MethodToInvoke.NEW_BUILDER)).E(this);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MessageLite
    public int c() {
        return k(null);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractMessageLite
    int d() {
        return this.memoizedSerializedSize & Api.BaseClientBuilder.API_PRIORITY_OTHER;
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

    @Override // com.google.crypto.tink.shaded.protobuf.MessageLite
    public final Parser h() {
        return (Parser) v(MethodToInvoke.GET_PARSER);
    }

    public int hashCode() {
        if (F()) {
            return s();
        }
        if (C()) {
            O(s());
        }
        return B();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        return E(this, true);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.MessageLite
    public void j(CodedOutputStream codedOutputStream) {
        Protobuf.a().d(this).i(this, CodedOutputStreamWriter.Q(codedOutputStream));
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractMessageLite
    int k(Schema schema) {
        if (!F()) {
            if (d() != Integer.MAX_VALUE) {
                return d();
            }
            int iT = t(schema);
            o(iT);
            return iT;
        }
        int iT2 = t(schema);
        if (iT2 >= 0) {
            return iT2;
        }
        throw new IllegalStateException("serialized size must be non-negative, was " + iT2);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractMessageLite
    void o(int i3) {
        if (i3 >= 0) {
            this.memoizedSerializedSize = (i3 & Api.BaseClientBuilder.API_PRIORITY_OTHER) | (this.memoizedSerializedSize & MUTABLE_FLAG_MASK);
        } else {
            throw new IllegalStateException("serialized size must be non-negative, was " + i3);
        }
    }

    Object p() {
        return v(MethodToInvoke.BUILD_MESSAGE_INFO);
    }

    void q() {
        this.memoizedHashCode = 0;
    }

    void r() {
        o(Api.BaseClientBuilder.API_PRIORITY_OTHER);
    }

    int s() {
        return Protobuf.a().d(this).e(this);
    }

    public String toString() {
        return MessageLiteToString.f(this, super.toString());
    }

    protected final Builder u() {
        return (Builder) v(MethodToInvoke.NEW_BUILDER);
    }

    protected Object v(MethodToInvoke methodToInvoke) {
        return x(methodToInvoke, null, null);
    }

    protected Object w(MethodToInvoke methodToInvoke, Object obj) {
        return x(methodToInvoke, obj, null);
    }

    protected abstract Object x(MethodToInvoke methodToInvoke, Object obj, Object obj2);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    protected static final class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Class f86932a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f86933b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final byte[] f86934c;

        private Object a() {
            try {
                java.lang.reflect.Field declaredField = b().getDeclaredField("defaultInstance");
                declaredField.setAccessible(true);
                return ((MessageLite) declaredField.get(null)).e().n(this.f86934c).f();
            } catch (InvalidProtocolBufferException e3) {
                throw new RuntimeException("Unable to understand proto buffer", e3);
            } catch (ClassNotFoundException e4) {
                throw new RuntimeException("Unable to find proto buffer class: " + this.f86933b, e4);
            } catch (IllegalAccessException e5) {
                throw new RuntimeException("Unable to call parsePartialFrom", e5);
            } catch (NoSuchFieldException e6) {
                throw new RuntimeException("Unable to find defaultInstance in " + this.f86933b, e6);
            } catch (SecurityException e7) {
                throw new RuntimeException("Unable to call defaultInstance in " + this.f86933b, e7);
            }
        }

        private Class b() {
            Class cls = this.f86932a;
            return cls != null ? cls : Class.forName(this.f86933b);
        }

        protected Object readResolve() throws ObjectStreamException {
            try {
                java.lang.reflect.Field declaredField = b().getDeclaredField("DEFAULT_INSTANCE");
                declaredField.setAccessible(true);
                return ((MessageLite) declaredField.get(null)).e().n(this.f86934c).f();
            } catch (InvalidProtocolBufferException e3) {
                throw new RuntimeException("Unable to understand proto buffer", e3);
            } catch (ClassNotFoundException e4) {
                throw new RuntimeException("Unable to find proto buffer class: " + this.f86933b, e4);
            } catch (IllegalAccessException e5) {
                throw new RuntimeException("Unable to call parsePartialFrom", e5);
            } catch (NoSuchFieldException unused) {
                return a();
            } catch (SecurityException e6) {
                throw new RuntimeException(MrGIhy.qKSzgVI + this.f86933b, e6);
            }
        }
    }
}
