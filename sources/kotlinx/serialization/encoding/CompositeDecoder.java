package kotlinx.serialization.encoding;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.modules.SerializersModule;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public interface CompositeDecoder {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f142762a = new Companion();

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DefaultImpls {
        public static int a(CompositeDecoder compositeDecoder, SerialDescriptor descriptor) {
            Intrinsics.checkNotNullParameter(descriptor, "descriptor");
            return -1;
        }

        public static boolean b(CompositeDecoder compositeDecoder) {
            return false;
        }

        public static /* synthetic */ Object c(CompositeDecoder compositeDecoder, SerialDescriptor serialDescriptor, int i3, DeserializationStrategy deserializationStrategy, Object obj, int i4, Object obj2) {
            if (obj2 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decodeSerializableElement");
            }
            if ((i4 & 8) != 0) {
                obj = null;
            }
            return compositeDecoder.y(serialDescriptor, i3, deserializationStrategy, obj);
        }
    }

    char A(SerialDescriptor serialDescriptor, int i3);

    byte B(SerialDescriptor serialDescriptor, int i3);

    boolean C(SerialDescriptor serialDescriptor, int i3);

    short E(SerialDescriptor serialDescriptor, int i3);

    double F(SerialDescriptor serialDescriptor, int i3);

    SerializersModule a();

    void c(SerialDescriptor serialDescriptor);

    long f(SerialDescriptor serialDescriptor, int i3);

    int i(SerialDescriptor serialDescriptor, int i3);

    int k(SerialDescriptor serialDescriptor);

    String m(SerialDescriptor serialDescriptor, int i3);

    Object n(SerialDescriptor serialDescriptor, int i3, DeserializationStrategy deserializationStrategy, Object obj);

    int o(SerialDescriptor serialDescriptor);

    boolean p();

    Decoder r(SerialDescriptor serialDescriptor, int i3);

    float u(SerialDescriptor serialDescriptor, int i3);

    Object y(SerialDescriptor serialDescriptor, int i3, DeserializationStrategy deserializationStrategy, Object obj);
}
