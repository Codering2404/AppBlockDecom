package kotlinx.serialization.internal;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.MissingFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;

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
public final class PluginExceptionsKt {
    public static final void a(int[] seenArray, int[] goldenMaskArray, SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(seenArray, "seenArray");
        Intrinsics.checkNotNullParameter(goldenMaskArray, "goldenMaskArray");
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        ArrayList arrayList = new ArrayList();
        int length = goldenMaskArray.length;
        for (int i3 = 0; i3 < length; i3++) {
            int i4 = goldenMaskArray[i3] & (~seenArray[i3]);
            if (i4 != 0) {
                for (int i5 = 0; i5 < 32; i5++) {
                    if ((i4 & 1) != 0) {
                        arrayList.add(descriptor.f((i3 * 32) + i5));
                    }
                    i4 >>>= 1;
                }
            }
        }
        throw new MissingFieldException(arrayList, descriptor.i());
    }

    public static final void b(int i3, int i4, SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        ArrayList arrayList = new ArrayList();
        int i5 = (~i3) & i4;
        for (int i6 = 0; i6 < 32; i6++) {
            if ((i5 & 1) != 0) {
                arrayList.add(descriptor.f(i6));
            }
            i5 >>>= 1;
        }
        throw new MissingFieldException(arrayList, descriptor.i());
    }
}
