package kotlinx.serialization.internal;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.InternalSerializationApi;
import kotlinx.serialization.KSerializer;
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
@InternalSerializationApi
public abstract class AbstractCollectionSerializer<Element, Collection, Builder> implements KSerializer<Collection> {
    public /* synthetic */ AbstractCollectionSerializer(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static /* synthetic */ void i(AbstractCollectionSerializer abstractCollectionSerializer, CompositeDecoder compositeDecoder, int i3, Object obj, boolean z2, int i4, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: readElement");
        }
        if ((i4 & 8) != 0) {
            z2 = true;
        }
        abstractCollectionSerializer.h(compositeDecoder, i3, obj, z2);
    }

    private final int j(CompositeDecoder compositeDecoder, Object obj) {
        int iK = compositeDecoder.k(getDescriptor());
        c(obj, iK);
        return iK;
    }

    protected abstract Object a();

    protected abstract int b(Object obj);

    protected abstract void c(Object obj, int i3);

    protected abstract Iterator d(Object obj);

    @Override // kotlinx.serialization.DeserializationStrategy
    public Object deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        return f(decoder, null);
    }

    protected abstract int e(Object obj);

    public final Object f(Decoder decoder, Object obj) {
        Object objA;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        if (obj == null || (objA = k(obj)) == null) {
            objA = a();
        }
        Object obj2 = objA;
        int iB = b(obj2);
        CompositeDecoder compositeDecoderB = decoder.b(getDescriptor());
        if (!compositeDecoderB.p()) {
            while (true) {
                int iO = compositeDecoderB.o(getDescriptor());
                if (iO == -1) {
                    break;
                }
                i(this, compositeDecoderB, iB + iO, obj2, false, 8, null);
            }
        } else {
            g(compositeDecoderB, obj2, iB, j(compositeDecoderB, obj2));
        }
        compositeDecoderB.c(getDescriptor());
        return l(obj2);
    }

    protected abstract void g(CompositeDecoder compositeDecoder, Object obj, int i3, int i4);

    protected abstract void h(CompositeDecoder compositeDecoder, int i3, Object obj, boolean z2);

    protected abstract Object k(Object obj);

    protected abstract Object l(Object obj);

    private AbstractCollectionSerializer() {
    }
}
