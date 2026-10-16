package androidx.compose.material3.carousel;

import androidx.compose.foundation.gestures.snapping.SnapPosition;
import kotlin.Metadata;
import kotlin.math.MathKt;

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
public final class KeylineSnapPositionKt {
    public static final SnapPosition a(final CarouselPageSize carouselPageSize) {
        return new SnapPosition() { // from class: androidx.compose.material3.carousel.KeylineSnapPositionKt$KeylineSnapPosition$1
            @Override // androidx.compose.foundation.gestures.snapping.SnapPosition
            public int a(int i3, int i4, int i5, int i6, int i7, int i8) {
                return KeylineSnapPositionKt.b(carouselPageSize.b(), i7, i8);
            }
        };
    }

    public static final int b(Strategy strategy, int i3, int i4) {
        if (!strategy.j()) {
            return 0;
        }
        int iQ = strategy.c().q() - strategy.c().g();
        int size = strategy.i().size() + iQ;
        int size2 = strategy.d().size() + iQ;
        int iD = MathKt.d(strategy.c().f().f() - (strategy.e() / 2.0f));
        if (i3 < size) {
            iD = MathKt.d(((KeylineList) strategy.i().get(Math.min(strategy.i().size() - 1, Math.max(0, (size - 1) - i3)))).f().f() - (strategy.e() / 2.0f));
        }
        if (i4 <= iQ + 1 || i3 < i4 - size2) {
            return iD;
        }
        return MathKt.d(((KeylineList) strategy.d().get(Math.min(strategy.d().size() - 1, Math.max(0, (i3 - i4) + size2)))).f().f() - (strategy.e() / 2.0f));
    }
}
