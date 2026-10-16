package kotlinx.serialization.encoding;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerializationStrategy;
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
public interface Encoder {
    void B(int i3);

    void G(String str);

    SerializersModule a();

    CompositeEncoder b(SerialDescriptor serialDescriptor);

    void e(SerializationStrategy serializationStrategy, Object obj);

    void g(double d3);

    void h(byte b3);

    CompositeEncoder j(SerialDescriptor serialDescriptor, int i3);

    void k(SerialDescriptor serialDescriptor, int i3);

    Encoder l(SerialDescriptor serialDescriptor);

    void m(long j3);

    void o();

    void q(short s2);

    void r(boolean z2);

    void t(float f3);

    void u(char c3);

    void v();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DefaultImpls {
        public static CompositeEncoder a(Encoder encoder, SerialDescriptor descriptor, int i3) {
            Intrinsics.checkNotNullParameter(descriptor, "descriptor");
            return encoder.b(descriptor);
        }

        public static void c(Encoder encoder, SerializationStrategy serializer, Object obj) {
            Intrinsics.checkNotNullParameter(serializer, "serializer");
            if (serializer.getDescriptor().b()) {
                encoder.e(serializer, obj);
            } else if (obj == null) {
                encoder.o();
            } else {
                encoder.v();
                encoder.e(serializer, obj);
            }
        }

        public static void d(Encoder encoder, SerializationStrategy serializer, Object obj) {
            Intrinsics.checkNotNullParameter(serializer, "serializer");
            serializer.serialize(encoder, obj);
        }

        public static void b(Encoder encoder) {
        }
    }
}
