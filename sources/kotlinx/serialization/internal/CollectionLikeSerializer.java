package kotlinx.serialization.internal;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder;

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
public abstract class CollectionLikeSerializer<Element, Collection, Builder> extends AbstractCollectionSerializer<Element, Collection, Builder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final KSerializer f142788a;

    public /* synthetic */ CollectionLikeSerializer(KSerializer kSerializer, DefaultConstructorMarker defaultConstructorMarker) {
        this(kSerializer);
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    protected final void g(CompositeDecoder decoder, Object obj, int i3, int i4) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        if (i4 < 0) {
            throw new IllegalArgumentException("Size must be known in advance when using READ_ALL");
        }
        for (int i5 = 0; i5 < i4; i5++) {
            h(decoder, i3 + i5, obj, false);
        }
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public abstract SerialDescriptor getDescriptor();

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    protected void h(CompositeDecoder decoder, int i3, Object obj, boolean z2) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        n(obj, i3, CompositeDecoder.DefaultImpls.c(decoder, getDescriptor(), i3, this.f142788a, null, 8, null));
    }

    protected abstract void n(Object obj, int i3, Object obj2);

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, Object obj) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        int iE = e(obj);
        SerialDescriptor descriptor = getDescriptor();
        CompositeEncoder compositeEncoderJ = encoder.j(descriptor, iE);
        Iterator itD = d(obj);
        for (int i3 = 0; i3 < iE; i3++) {
            compositeEncoderJ.C(getDescriptor(), i3, this.f142788a, itD.next());
        }
        compositeEncoderJ.c(descriptor);
    }

    private CollectionLikeSerializer(KSerializer kSerializer) {
        super(null);
        this.f142788a = kSerializer;
    }
}
