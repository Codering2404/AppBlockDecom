package kotlinx.serialization.internal;

import com.facebook.share.HKJ.pnxuebdT;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.PrimitiveArrayBuilder;

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
public abstract class PrimitiveArraySerializer<Element, Array, Builder extends PrimitiveArrayBuilder<Array>> extends CollectionLikeSerializer<Element, Array, Builder> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SerialDescriptor f142877b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PrimitiveArraySerializer(KSerializer primitiveSerializer) {
        super(primitiveSerializer, null);
        Intrinsics.checkNotNullParameter(primitiveSerializer, "primitiveSerializer");
        this.f142877b = new PrimitiveArrayDescriptor(primitiveSerializer.getDescriptor());
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    protected final Iterator d(Object obj) {
        throw new IllegalStateException("This method lead to boxing and must not be used, use writeContents instead");
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer, kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        return f(decoder, null);
    }

    @Override // kotlinx.serialization.internal.CollectionLikeSerializer, kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return this.f142877b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public final PrimitiveArrayBuilder a() {
        return (PrimitiveArrayBuilder) k(r());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public final int b(PrimitiveArrayBuilder primitiveArrayBuilder) {
        Intrinsics.checkNotNullParameter(primitiveArrayBuilder, "<this>");
        return primitiveArrayBuilder.d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public final void c(PrimitiveArrayBuilder primitiveArrayBuilder, int i3) {
        Intrinsics.checkNotNullParameter(primitiveArrayBuilder, "<this>");
        primitiveArrayBuilder.b(i3);
    }

    protected abstract Object r();

    @Override // kotlinx.serialization.internal.CollectionLikeSerializer, kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        int iE = e(obj);
        SerialDescriptor serialDescriptor = this.f142877b;
        CompositeEncoder compositeEncoderJ = encoder.j(serialDescriptor, iE);
        u(compositeEncoderJ, obj, iE);
        compositeEncoderJ.c(serialDescriptor);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public final Object l(PrimitiveArrayBuilder primitiveArrayBuilder) {
        Intrinsics.checkNotNullParameter(primitiveArrayBuilder, "<this>");
        return primitiveArrayBuilder.a();
    }

    protected abstract void u(CompositeEncoder compositeEncoder, Object obj, int i3);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.CollectionLikeSerializer
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public final void n(PrimitiveArrayBuilder primitiveArrayBuilder, int i3, Object obj) {
        Intrinsics.checkNotNullParameter(primitiveArrayBuilder, "<this>");
        throw new IllegalStateException(pnxuebdT.pMOjccexwhK);
    }
}
