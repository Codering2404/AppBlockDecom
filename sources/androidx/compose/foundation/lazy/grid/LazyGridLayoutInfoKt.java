package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.gestures.Orientation;
import java.util.List;
import kotlin.Metadata;

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
public final class LazyGridLayoutInfoKt {
    public static final int a(LazyGridLayoutInfo lazyGridLayoutInfo) {
        boolean z2 = lazyGridLayoutInfo.getOrientation() == Orientation.f6031a;
        List listH = lazyGridLayoutInfo.h();
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i3 < listH.size()) {
            int iB = b(z2, lazyGridLayoutInfo, i3);
            if (iB == -1) {
                i3++;
            } else {
                int iMax = 0;
                while (i3 < listH.size() && b(z2, lazyGridLayoutInfo, i3) == iB) {
                    iMax = Math.max(iMax, (int) (z2 ? ((LazyGridItemInfo) listH.get(i3)).a() & 4294967295L : ((LazyGridItemInfo) listH.get(i3)).a() >> 32));
                    i3++;
                }
                i4 += iMax;
                i5++;
            }
        }
        return (i4 / i5) + lazyGridLayoutInfo.f();
    }

    private static final int b(boolean z2, LazyGridLayoutInfo lazyGridLayoutInfo, int i3) {
        return z2 ? ((LazyGridItemInfo) lazyGridLayoutInfo.h().get(i3)).j() : ((LazyGridItemInfo) lazyGridLayoutInfo.h().get(i3)).b();
    }
}
