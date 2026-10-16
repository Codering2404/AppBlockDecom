package kotlin.jvm.internal;

import kotlin.Metadata;
import kotlin.collections.BooleanIterator;
import kotlin.collections.ByteIterator;
import kotlin.collections.CharIterator;
import kotlin.collections.DoubleIterator;
import kotlin.collections.FloatIterator;
import kotlin.collections.IntIterator;
import kotlin.collections.LongIterator;
import kotlin.collections.ShortIterator;

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
public final class ArrayIteratorsKt {
    public static final BooleanIterator a(boolean[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return new ArrayBooleanIterator(array);
    }

    public static final ByteIterator b(byte[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return new ArrayByteIterator(array);
    }

    public static final CharIterator c(char[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return new ArrayCharIterator(array);
    }

    public static final DoubleIterator d(double[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return new ArrayDoubleIterator(array);
    }

    public static final FloatIterator e(float[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return new ArrayFloatIterator(array);
    }

    public static final IntIterator f(int[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return new ArrayIntIterator(array);
    }

    public static final LongIterator g(long[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return new ArrayLongIterator(array);
    }

    public static final ShortIterator h(short[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return new ArrayShortIterator(array);
    }
}
