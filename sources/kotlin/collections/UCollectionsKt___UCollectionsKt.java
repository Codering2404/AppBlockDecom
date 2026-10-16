package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.UIntArray;
import kotlin.ULong;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.jvm.internal.Intrinsics;

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
class UCollectionsKt___UCollectionsKt {
    public static final int sumOfUByte(Iterable<UByte> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator<UByte> it = iterable.iterator();
        int iB = 0;
        while (it.hasNext()) {
            iB = UInt.b(iB + UInt.b(it.next().f() & 255));
        }
        return iB;
    }

    public static final int sumOfUInt(Iterable<UInt> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator<UInt> it = iterable.iterator();
        int iB = 0;
        while (it.hasNext()) {
            iB = UInt.b(iB + it.next().f());
        }
        return iB;
    }

    public static final long sumOfULong(Iterable<ULong> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator<ULong> it = iterable.iterator();
        long jB = 0;
        while (it.hasNext()) {
            jB = ULong.b(jB + it.next().g());
        }
        return jB;
    }

    public static final int sumOfUShort(Iterable<UShort> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator<UShort> it = iterable.iterator();
        int iB = 0;
        while (it.hasNext()) {
            iB = UInt.b(iB + UInt.b(it.next().f() & 65535));
        }
        return iB;
    }

    public static final byte[] toUByteArray(Collection<UByte> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        byte[] bArrB = UByteArray.b(collection.size());
        Iterator<UByte> it = collection.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            UByteArray.t(bArrB, i3, it.next().f());
            i3++;
        }
        return bArrB;
    }

    public static final int[] toUIntArray(Collection<UInt> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        int[] iArrB = UIntArray.b(collection.size());
        Iterator<UInt> it = collection.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            UIntArray.t(iArrB, i3, it.next().f());
            i3++;
        }
        return iArrB;
    }

    public static final long[] toULongArray(Collection<ULong> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        long[] jArrB = ULongArray.b(collection.size());
        Iterator<ULong> it = collection.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            ULongArray.t(jArrB, i3, it.next().g());
            i3++;
        }
        return jArrB;
    }

    public static final short[] toUShortArray(Collection<UShort> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        short[] sArrB = UShortArray.b(collection.size());
        Iterator<UShort> it = collection.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            UShortArray.t(sArrB, i3, it.next().f());
            i3++;
        }
        return sArrB;
    }
}
