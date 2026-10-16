package kotlinx.serialization.encoding;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.Decoder;

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
public abstract class AbstractDecoder implements Decoder, CompositeDecoder {
    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final char A(SerialDescriptor descriptor, int i3) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return x();
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final byte B(SerialDescriptor descriptor, int i3) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return H();
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final boolean C(SerialDescriptor descriptor, int i3) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return w();
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public boolean D() {
        return true;
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final short E(SerialDescriptor descriptor, int i3) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return s();
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final double F(SerialDescriptor descriptor, int i3) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return v();
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public Object G(DeserializationStrategy deserializationStrategy) {
        return Decoder.DefaultImpls.a(this, deserializationStrategy);
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public byte H() {
        Object objJ = J();
        Intrinsics.checkNotNull(objJ, "null cannot be cast to non-null type kotlin.Byte");
        return ((Byte) objJ).byteValue();
    }

    public Object I(DeserializationStrategy deserializer, Object obj) {
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        return G(deserializer);
    }

    public Object J() {
        throw new SerializationException(Reflection.b(getClass()) + " can't retrieve untyped values");
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public CompositeDecoder b(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return this;
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public void c(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public int e(SerialDescriptor enumDescriptor) {
        Intrinsics.checkNotNullParameter(enumDescriptor, "enumDescriptor");
        Object objJ = J();
        Intrinsics.checkNotNull(objJ, "null cannot be cast to non-null type kotlin.Int");
        return ((Integer) objJ).intValue();
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final long f(SerialDescriptor descriptor, int i3) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return l();
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public int h() {
        Object objJ = J();
        Intrinsics.checkNotNull(objJ, "null cannot be cast to non-null type kotlin.Int");
        return ((Integer) objJ).intValue();
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final int i(SerialDescriptor descriptor, int i3) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return h();
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public Void j() {
        return null;
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public int k(SerialDescriptor serialDescriptor) {
        return CompositeDecoder.DefaultImpls.a(this, serialDescriptor);
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public long l() {
        Object objJ = J();
        Intrinsics.checkNotNull(objJ, "null cannot be cast to non-null type kotlin.Long");
        return ((Long) objJ).longValue();
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final String m(SerialDescriptor descriptor, int i3) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return z();
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final Object n(SerialDescriptor descriptor, int i3, DeserializationStrategy deserializer, Object obj) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        return (deserializer.getDescriptor().b() || D()) ? I(deserializer, obj) : j();
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public boolean p() {
        return CompositeDecoder.DefaultImpls.b(this);
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public Decoder q(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return this;
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public Decoder r(SerialDescriptor descriptor, int i3) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return q(descriptor.h(i3));
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public short s() {
        Object objJ = J();
        Intrinsics.checkNotNull(objJ, "null cannot be cast to non-null type kotlin.Short");
        return ((Short) objJ).shortValue();
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public float t() {
        Object objJ = J();
        Intrinsics.checkNotNull(objJ, "null cannot be cast to non-null type kotlin.Float");
        return ((Float) objJ).floatValue();
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final float u(SerialDescriptor descriptor, int i3) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return t();
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public double v() {
        Object objJ = J();
        Intrinsics.checkNotNull(objJ, "null cannot be cast to non-null type kotlin.Double");
        return ((Double) objJ).doubleValue();
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public boolean w() {
        Object objJ = J();
        Intrinsics.checkNotNull(objJ, "null cannot be cast to non-null type kotlin.Boolean");
        return ((Boolean) objJ).booleanValue();
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public char x() {
        Object objJ = J();
        Intrinsics.checkNotNull(objJ, "null cannot be cast to non-null type kotlin.Char");
        return ((Character) objJ).charValue();
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public Object y(SerialDescriptor descriptor, int i3, DeserializationStrategy deserializer, Object obj) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        return I(deserializer, obj);
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public String z() {
        Object objJ = J();
        Intrinsics.checkNotNull(objJ, "null cannot be cast to non-null type kotlin.String");
        return (String) objJ;
    }
}
