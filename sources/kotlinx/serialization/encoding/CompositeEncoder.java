package kotlinx.serialization.encoding;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;

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
public interface CompositeEncoder {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DefaultImpls {
        public static boolean a(CompositeEncoder compositeEncoder, SerialDescriptor descriptor, int i3) {
            Intrinsics.checkNotNullParameter(descriptor, "descriptor");
            return true;
        }
    }

    void C(SerialDescriptor serialDescriptor, int i3, SerializationStrategy serializationStrategy, Object obj);

    void D(SerialDescriptor serialDescriptor, int i3, short s2);

    void E(SerialDescriptor serialDescriptor, int i3, double d3);

    void F(SerialDescriptor serialDescriptor, int i3, long j3);

    void c(SerialDescriptor serialDescriptor);

    Encoder f(SerialDescriptor serialDescriptor, int i3);

    void i(SerialDescriptor serialDescriptor, int i3, SerializationStrategy serializationStrategy, Object obj);

    void n(SerialDescriptor serialDescriptor, int i3, char c3);

    void p(SerialDescriptor serialDescriptor, int i3, byte b3);

    void s(SerialDescriptor serialDescriptor, int i3, float f3);

    void w(SerialDescriptor serialDescriptor, int i3, int i4);

    void x(SerialDescriptor serialDescriptor, int i3, boolean z2);

    void y(SerialDescriptor serialDescriptor, int i3, String str);

    boolean z(SerialDescriptor serialDescriptor, int i3);
}
