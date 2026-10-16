package kotlinx.serialization.encoding;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.NoOpEncoder;

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
@ExperimentalSerializationApi
public abstract class AbstractEncoder implements Encoder, CompositeEncoder {
    @Override // kotlinx.serialization.encoding.Encoder
    public void B(int i3) {
        J(Integer.valueOf(i3));
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
        if (H(descriptor, i3)) {
            q(s2);
        }
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void E(SerialDescriptor descriptor, int i3, double d3) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (H(descriptor, i3)) {
            g(d3);
        }
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void F(SerialDescriptor descriptor, int i3, long j3) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (H(descriptor, i3)) {
            m(j3);
        }
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void G(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        J(value);
    }

    public boolean H(SerialDescriptor descriptor, int i3) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return true;
    }

    public void I(SerializationStrategy serializationStrategy, Object obj) {
        Encoder.DefaultImpls.c(this, serializationStrategy, obj);
    }

    public void J(Object value) {
        Intrinsics.checkNotNullParameter(value, "value");
        throw new SerializationException("Non-serializable " + Reflection.b(value.getClass()) + " is not supported by " + Reflection.b(getClass()) + " encoder");
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public CompositeEncoder b(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return this;
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public void c(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void e(SerializationStrategy serializationStrategy, Object obj) {
        Encoder.DefaultImpls.d(this, serializationStrategy, obj);
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final Encoder f(SerialDescriptor descriptor, int i3) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return H(descriptor, i3) ? l(descriptor.h(i3)) : NoOpEncoder.f142848a;
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void g(double d3) {
        J(Double.valueOf(d3));
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void h(byte b3) {
        J(Byte.valueOf(b3));
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
    public void k(SerialDescriptor enumDescriptor, int i3) {
        Intrinsics.checkNotNullParameter(enumDescriptor, "enumDescriptor");
        J(Integer.valueOf(i3));
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public Encoder l(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return this;
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void m(long j3) {
        J(Long.valueOf(j3));
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void n(SerialDescriptor descriptor, int i3, char c3) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (H(descriptor, i3)) {
            u(c3);
        }
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void o() {
        throw new SerializationException("'null' is not supported by default");
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void p(SerialDescriptor descriptor, int i3, byte b3) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (H(descriptor, i3)) {
            h(b3);
        }
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void q(short s2) {
        J(Short.valueOf(s2));
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void r(boolean z2) {
        J(Boolean.valueOf(z2));
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void s(SerialDescriptor descriptor, int i3, float f3) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (H(descriptor, i3)) {
            t(f3);
        }
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void t(float f3) {
        J(Float.valueOf(f3));
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void u(char c3) {
        J(Character.valueOf(c3));
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void v() {
        Encoder.DefaultImpls.b(this);
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void w(SerialDescriptor descriptor, int i3, int i4) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (H(descriptor, i3)) {
            B(i4);
        }
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void x(SerialDescriptor descriptor, int i3, boolean z2) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (H(descriptor, i3)) {
            r(z2);
        }
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void y(SerialDescriptor descriptor, int i3, String value) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(value, "value");
        if (H(descriptor, i3)) {
            G(value);
        }
    }

    public boolean z(SerialDescriptor serialDescriptor, int i3) {
        return CompositeEncoder.DefaultImpls.a(this, serialDescriptor, i3);
    }
}
