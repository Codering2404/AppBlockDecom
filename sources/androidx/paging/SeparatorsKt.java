package androidx.paging;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
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
public final class SeparatorsKt {
    public static final void a(List list, Object obj, TransformablePage transformablePage, TransformablePage transformablePage2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        int[] iArrE = transformablePage != null ? transformablePage.e() : null;
        int[] iArrE2 = transformablePage2 != null ? transformablePage2.e() : null;
        if (iArrE != null && iArrE2 != null) {
            iArrE = CollectionsKt.toIntArray(CollectionsKt.sorted(ArraysKt.distinct(ArraysKt.plus(iArrE, iArrE2))));
        } else if (iArrE == null && iArrE2 != null) {
            iArrE = iArrE2;
        } else if (iArrE == null || iArrE2 != null) {
            throw new IllegalArgumentException("Separator page expected adjacentPageBefore or adjacentPageAfter, but both were null.");
        }
        b(list, obj, iArrE, i3, i4);
    }

    public static final void b(List list, Object obj, int[] originalPageOffsets, int i3, int i4) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(originalPageOffsets, "originalPageOffsets");
        if (obj == null) {
            return;
        }
        list.add(d(obj, originalPageOffsets, i3, i4));
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x00d1 -> B:12:0x0043). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object c(androidx.paging.TransformablePage r11, kotlin.jvm.functions.Function3 r12, kotlin.coroutines.Continuation r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 279
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.SeparatorsKt.c(androidx.paging.TransformablePage, kotlin.jvm.functions.Function3, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final TransformablePage d(Object separator, int[] originalPageOffsets, int i3, int i4) {
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(originalPageOffsets, "originalPageOffsets");
        return new TransformablePage(originalPageOffsets, CollectionsKt.listOf(separator), i3, CollectionsKt.listOf(Integer.valueOf(i4)));
    }
}
