package androidx.collection;

import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class ScatterMapKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long[] f3113a = {-9187201950435737345L, -1};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final MutableScatterMap f3114b = new MutableScatterMap(0);

    public static final ScatterMap a() {
        MutableScatterMap mutableScatterMap = f3114b;
        Intrinsics.checkNotNull(mutableScatterMap, "null cannot be cast to non-null type androidx.collection.ScatterMap<K of androidx.collection.ScatterMapKt.emptyScatterMap, V of androidx.collection.ScatterMapKt.emptyScatterMap>");
        return mutableScatterMap;
    }

    public static final int b(int i3) {
        if (i3 == 7) {
            return 6;
        }
        return i3 - (i3 / 8);
    }

    public static final MutableScatterMap c() {
        return new MutableScatterMap(0, 1, null);
    }

    public static final int d(int i3) {
        if (i3 == 0) {
            return 6;
        }
        return (i3 * 2) + 1;
    }

    public static final int e(int i3) {
        if (i3 > 0) {
            return (-1) >>> Integer.numberOfLeadingZeros(i3);
        }
        return 0;
    }

    public static final int f(int i3) {
        if (i3 == 7) {
            return 8;
        }
        return i3 + ((i3 - 1) / 7);
    }
}
