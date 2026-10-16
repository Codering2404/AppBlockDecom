package androidx.room.util;

import androidx.collection.LongSparseArray;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
final /* synthetic */ class RelationUtil__RelationUtilKt {
    public static final void a(LongSparseArray map, boolean z2, Function1 fetchBlock) {
        Intrinsics.checkNotNullParameter(map, "map");
        Intrinsics.checkNotNullParameter(fetchBlock, "fetchBlock");
        LongSparseArray longSparseArray = new LongSparseArray(999);
        int iR = map.r();
        int i3 = 0;
        int i4 = 0;
        while (i3 < iR) {
            if (z2) {
                longSparseArray.m(map.k(i3), map.s(i3));
            } else {
                longSparseArray.m(map.k(i3), null);
            }
            i3++;
            i4++;
            if (i4 == 999) {
                fetchBlock.invoke(longSparseArray);
                if (!z2) {
                    map.o(longSparseArray);
                }
                longSparseArray.b();
                i4 = 0;
            }
        }
        if (i4 > 0) {
            fetchBlock.invoke(longSparseArray);
            if (z2) {
                return;
            }
            map.o(longSparseArray);
        }
    }
}
