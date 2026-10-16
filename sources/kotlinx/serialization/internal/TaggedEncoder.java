package kotlinx.serialization.internal;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.InternalSerializationApi;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.modules.SerializersModule;
import kotlinx.serialization.modules.SerializersModuleBuildersKt;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
@Metadata
@InternalSerializationApi
public abstract class TaggedEncoder<Tag> implements Encoder, CompositeEncoder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayList f142895a = new ArrayList();

    private final boolean H(SerialDescriptor serialDescriptor, int i3) {
        c0(a0(serialDescriptor, i3));
        return true;
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void B(int i3) {
        Q(b0(), i3);
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public void C(SerialDescriptor descriptor, int i3, SerializationStrategy serializer, Object obj) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        if (H(descriptor, i3)) {
            e(serializer, obj);
        }
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void D(SerialDescriptor descriptor, int i3, short s2) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        U(a0(descriptor, i3), s2);
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void E(SerialDescriptor descriptor, int i3, double d3) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        M(a0(descriptor, i3), d3);
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void F(SerialDescriptor descriptor, int i3, long j3) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        R(a0(descriptor, i3), j3);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void G(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        V(b0(), value);
    }

    public void I(SerializationStrategy serializationStrategy, Object obj) {
        Encoder.DefaultImpls.c(this, serializationStrategy, obj);
    }

    protected void J(Object obj, boolean z2) {
        W(obj, Boolean.valueOf(z2));
    }

    protected void K(Object obj, byte b3) {
        W(obj, Byte.valueOf(b3));
    }

    protected void L(Object obj, char c3) {
        W(obj, Character.valueOf(c3));
    }

    protected void M(Object obj, double d3) {
        W(obj, Double.valueOf(d3));
    }

    protected void N(Object obj, SerialDescriptor enumDescriptor, int i3) {
        Intrinsics.checkNotNullParameter(enumDescriptor, "enumDescriptor");
        W(obj, Integer.valueOf(i3));
    }

    protected void O(Object obj, float f3) {
        W(obj, Float.valueOf(f3));
    }

    protected Encoder P(Object obj, SerialDescriptor inlineDescriptor) {
        Intrinsics.checkNotNullParameter(inlineDescriptor, "inlineDescriptor");
        c0(obj);
        return this;
    }

    protected void Q(Object obj, int i3) {
        W(obj, Integer.valueOf(i3));
    }

    protected void R(Object obj, long j3) {
        W(obj, Long.valueOf(j3));
    }

    protected void T(Object obj) {
        throw new SerializationException("null is not supported");
    }

    protected void U(Object obj, short s2) {
        W(obj, Short.valueOf(s2));
    }

    protected void V(Object obj, String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        W(obj, value);
    }

    protected void W(Object obj, Object value) {
        Intrinsics.checkNotNullParameter(value, "value");
        throw new SerializationException("Non-serializable " + Reflection.b(value.getClass()) + " is not supported by " + Reflection.b(getClass()) + " encoder");
    }

    protected void X(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
    }

    protected final Object Y() {
        return CollectionsKt.last((List) this.f142895a);
    }

    protected final Object Z() {
        return CollectionsKt.lastOrNull((List) this.f142895a);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public SerializersModule a() {
        return SerializersModuleBuildersKt.a();
    }

    protected abstract Object a0(SerialDescriptor serialDescriptor, int i3);

    @Override // kotlinx.serialization.encoding.Encoder
    public CompositeEncoder b(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return this;
    }

    protected final Object b0() {
        if (this.f142895a.isEmpty()) {
            throw new SerializationException("No tag in stack for requested element");
        }
        ArrayList arrayList = this.f142895a;
        return arrayList.remove(CollectionsKt.getLastIndex(arrayList));
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void c(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (!this.f142895a.isEmpty()) {
            b0();
        }
        X(descriptor);
    }

    protected final void c0(Object obj) {
        this.f142895a.add(obj);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void e(SerializationStrategy serializationStrategy, Object obj) {
        Encoder.DefaultImpls.d(this, serializationStrategy, obj);
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final Encoder f(SerialDescriptor descriptor, int i3) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return P(a0(descriptor, i3), descriptor.h(i3));
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void g(double d3) {
        M(b0(), d3);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void h(byte b3) {
        K(b0(), b3);
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public void i(SerialDescriptor descriptor, int i3, SerializationStrategy serializer, Object obj) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        if (H(descriptor, i3)) {
            I(serializer, obj);
        }
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public CompositeEncoder j(SerialDescriptor serialDescriptor, int i3) {
        return Encoder.DefaultImpls.a(this, serialDescriptor, i3);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void k(SerialDescriptor enumDescriptor, int i3) {
        Intrinsics.checkNotNullParameter(enumDescriptor, "enumDescriptor");
        N(b0(), enumDescriptor, i3);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public Encoder l(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return P(b0(), descriptor);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void m(long j3) {
        R(b0(), j3);
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void n(SerialDescriptor descriptor, int i3, char c3) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        L(a0(descriptor, i3), c3);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void o() {
        T(b0());
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void p(SerialDescriptor descriptor, int i3, byte b3) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        K(a0(descriptor, i3), b3);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void q(short s2) {
        U(b0(), s2);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void r(boolean z2) {
        J(b0(), z2);
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void s(SerialDescriptor descriptor, int i3, float f3) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        O(a0(descriptor, i3), f3);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void t(float f3) {
        O(b0(), f3);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void u(char c3) {
        L(b0(), c3);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void v() {
        S(Y());
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void w(SerialDescriptor descriptor, int i3, int i4) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Q(a0(descriptor, i3), i4);
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void x(SerialDescriptor descriptor, int i3, boolean z2) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        J(a0(descriptor, i3), z2);
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void y(SerialDescriptor descriptor, int i3, String value) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(value, "value");
        V(a0(descriptor, i3), value);
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public boolean z(SerialDescriptor serialDescriptor, int i3) {
        return CompositeEncoder.DefaultImpls.a(this, serialDescriptor, i3);
    }

    protected void S(Object obj) {
    }
}
