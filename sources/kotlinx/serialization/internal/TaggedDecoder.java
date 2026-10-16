package kotlinx.serialization.internal;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.InternalSerializationApi;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.Decoder;
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
public abstract class TaggedDecoder<Tag> implements Decoder, CompositeDecoder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayList f142893a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f142894b;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object K(TaggedDecoder taggedDecoder, DeserializationStrategy deserializationStrategy, Object obj) {
        return (deserializationStrategy.getDescriptor().b() || taggedDecoder.D()) ? taggedDecoder.M(deserializationStrategy, obj) : taggedDecoder.j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object L(TaggedDecoder taggedDecoder, DeserializationStrategy deserializationStrategy, Object obj) {
        return taggedDecoder.M(deserializationStrategy, obj);
    }

    private final Object f0(Object obj, Function0 function0) {
        e0(obj);
        Object objInvoke = function0.invoke();
        if (!this.f142894b) {
            d0();
        }
        this.f142894b = false;
        return objInvoke;
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final char A(SerialDescriptor descriptor, int i3) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return P(b0(descriptor, i3));
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final byte B(SerialDescriptor descriptor, int i3) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return O(b0(descriptor, i3));
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final boolean C(SerialDescriptor descriptor, int i3) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return N(b0(descriptor, i3));
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public boolean D() {
        Object objA0 = a0();
        if (objA0 == null) {
            return false;
        }
        return W(objA0);
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final short E(SerialDescriptor descriptor, int i3) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return X(b0(descriptor, i3));
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final double F(SerialDescriptor descriptor, int i3) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return Q(b0(descriptor, i3));
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public Object G(DeserializationStrategy deserializationStrategy) {
        return Decoder.DefaultImpls.a(this, deserializationStrategy);
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final byte H() {
        return O(d0());
    }

    protected Object M(DeserializationStrategy deserializer, Object obj) {
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        return G(deserializer);
    }

    protected boolean N(Object obj) {
        Object objZ = Z(obj);
        Intrinsics.checkNotNull(objZ, "null cannot be cast to non-null type kotlin.Boolean");
        return ((Boolean) objZ).booleanValue();
    }

    protected byte O(Object obj) {
        Object objZ = Z(obj);
        Intrinsics.checkNotNull(objZ, "null cannot be cast to non-null type kotlin.Byte");
        return ((Byte) objZ).byteValue();
    }

    protected char P(Object obj) {
        Object objZ = Z(obj);
        Intrinsics.checkNotNull(objZ, "null cannot be cast to non-null type kotlin.Char");
        return ((Character) objZ).charValue();
    }

    protected double Q(Object obj) {
        Object objZ = Z(obj);
        Intrinsics.checkNotNull(objZ, "null cannot be cast to non-null type kotlin.Double");
        return ((Double) objZ).doubleValue();
    }

    protected int R(Object obj, SerialDescriptor enumDescriptor) {
        Intrinsics.checkNotNullParameter(enumDescriptor, "enumDescriptor");
        Object objZ = Z(obj);
        Intrinsics.checkNotNull(objZ, "null cannot be cast to non-null type kotlin.Int");
        return ((Integer) objZ).intValue();
    }

    protected float S(Object obj) {
        Object objZ = Z(obj);
        Intrinsics.checkNotNull(objZ, "null cannot be cast to non-null type kotlin.Float");
        return ((Float) objZ).floatValue();
    }

    protected Decoder T(Object obj, SerialDescriptor inlineDescriptor) {
        Intrinsics.checkNotNullParameter(inlineDescriptor, "inlineDescriptor");
        e0(obj);
        return this;
    }

    protected int U(Object obj) {
        Object objZ = Z(obj);
        Intrinsics.checkNotNull(objZ, "null cannot be cast to non-null type kotlin.Int");
        return ((Integer) objZ).intValue();
    }

    protected long V(Object obj) {
        Object objZ = Z(obj);
        Intrinsics.checkNotNull(objZ, "null cannot be cast to non-null type kotlin.Long");
        return ((Long) objZ).longValue();
    }

    protected boolean W(Object obj) {
        return true;
    }

    protected short X(Object obj) {
        Object objZ = Z(obj);
        Intrinsics.checkNotNull(objZ, "null cannot be cast to non-null type kotlin.Short");
        return ((Short) objZ).shortValue();
    }

    protected String Y(Object obj) {
        Object objZ = Z(obj);
        Intrinsics.checkNotNull(objZ, "null cannot be cast to non-null type kotlin.String");
        return (String) objZ;
    }

    protected Object Z(Object obj) {
        throw new SerializationException(Reflection.b(getClass()) + " can't retrieve untyped values");
    }

    @Override // kotlinx.serialization.encoding.Decoder, kotlinx.serialization.encoding.CompositeDecoder
    public SerializersModule a() {
        return SerializersModuleBuildersKt.a();
    }

    protected final Object a0() {
        return CollectionsKt.lastOrNull((List) this.f142893a);
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public CompositeDecoder b(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return this;
    }

    protected abstract Object b0(SerialDescriptor serialDescriptor, int i3);

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public void c(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
    }

    public final ArrayList c0() {
        return this.f142893a;
    }

    protected final Object d0() {
        ArrayList arrayList = this.f142893a;
        Object objRemove = arrayList.remove(CollectionsKt.getLastIndex(arrayList));
        this.f142894b = true;
        return objRemove;
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final int e(SerialDescriptor enumDescriptor) {
        Intrinsics.checkNotNullParameter(enumDescriptor, "enumDescriptor");
        return R(d0(), enumDescriptor);
    }

    protected final void e0(Object obj) {
        this.f142893a.add(obj);
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final long f(SerialDescriptor descriptor, int i3) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return V(b0(descriptor, i3));
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final int h() {
        return U(d0());
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final int i(SerialDescriptor descriptor, int i3) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return U(b0(descriptor, i3));
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final Void j() {
        return null;
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public int k(SerialDescriptor serialDescriptor) {
        return CompositeDecoder.DefaultImpls.a(this, serialDescriptor);
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final long l() {
        return V(d0());
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final String m(SerialDescriptor descriptor, int i3) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return Y(b0(descriptor, i3));
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final Object n(SerialDescriptor descriptor, int i3, final DeserializationStrategy deserializer, final Object obj) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        return f0(b0(descriptor, i3), new Function0() { // from class: kotlinx.serialization.internal.m
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return TaggedDecoder.K(this.f142944a, deserializer, obj);
            }
        });
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public boolean p() {
        return CompositeDecoder.DefaultImpls.b(this);
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public Decoder q(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return T(d0(), descriptor);
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final Decoder r(SerialDescriptor descriptor, int i3) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return T(b0(descriptor, i3), descriptor.h(i3));
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final short s() {
        return X(d0());
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final float t() {
        return S(d0());
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final float u(SerialDescriptor descriptor, int i3) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return S(b0(descriptor, i3));
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final double v() {
        return Q(d0());
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final boolean w() {
        return N(d0());
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final char x() {
        return P(d0());
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final Object y(SerialDescriptor descriptor, int i3, final DeserializationStrategy deserializer, final Object obj) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        return f0(b0(descriptor, i3), new Function0() { // from class: kotlinx.serialization.internal.l
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return TaggedDecoder.L(this.f142941a, deserializer, obj);
            }
        });
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final String z() {
        return Y(d0());
    }
}
