package androidx.compose.foundation.gestures.snapping;

import androidx.compose.foundation.lazy.grid.LazyGridItemInfo;
import androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo;
import androidx.compose.foundation.lazy.grid.LazyGridState;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

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
public final class LazyGridSnapLayoutInfoProviderKt$SnapLayoutInfoProvider$1 implements SnapLayoutInfoProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ LazyGridState f6435a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ SnapPosition f6436b;

    private final int c() {
        LazyGridLayoutInfo lazyGridLayoutInfoD = d();
        int iC = 0;
        if (lazyGridLayoutInfoD.h().isEmpty()) {
            return 0;
        }
        int size = lazyGridLayoutInfoD.h().size();
        Iterator it = lazyGridLayoutInfoD.h().iterator();
        while (it.hasNext()) {
            iC += LazyGridSnapLayoutInfoProviderKt.c((LazyGridItemInfo) it.next(), lazyGridLayoutInfoD.getOrientation());
        }
        return iC / size;
    }

    private final LazyGridLayoutInfo d() {
        return this.f6435a.w();
    }

    @Override // androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider
    public float a(float f3) {
        List listH = d().h();
        SnapPosition snapPosition = this.f6436b;
        int size = listH.size();
        float f4 = Float.NEGATIVE_INFINITY;
        float f5 = Float.POSITIVE_INFINITY;
        for (int i3 = 0; i3 < size; i3++) {
            LazyGridItemInfo lazyGridItemInfo = (LazyGridItemInfo) listH.get(i3);
            float fA = SnapPositionKt.a(LazyGridSnapLayoutInfoProviderKt.a(d()), d().c(), d().b(), LazyGridSnapLayoutInfoProviderKt.c(lazyGridItemInfo, d().getOrientation()), LazyGridSnapLayoutInfoProviderKt.b(lazyGridItemInfo, d().getOrientation()), lazyGridItemInfo.getIndex(), snapPosition, d().e());
            if (fA <= 0.0f && fA > f4) {
                f4 = fA;
            }
            if (fA >= 0.0f && fA < f5) {
                f5 = fA;
            }
        }
        return SnapFlingBehaviorKt.j(LazyListSnapLayoutInfoProviderKt.c(this.f6435a.q(), f3), f4, f5);
    }

    @Override // androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider
    public float b(float f3, float f4) {
        return RangesKt.e(Math.abs(f4) - c(), 0.0f) * Math.signum(f4);
    }
}
