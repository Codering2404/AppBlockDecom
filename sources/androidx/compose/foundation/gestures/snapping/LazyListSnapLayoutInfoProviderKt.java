package androidx.compose.foundation.gestures.snapping;

import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.TargetedFlingBehavior;
import androidx.compose.foundation.gestures.snapping.SnapPosition;
import androidx.compose.foundation.lazy.LazyListItemInfo;
import androidx.compose.foundation.lazy.LazyListLayoutInfo;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.unit.Density;
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
public final class LazyListSnapLayoutInfoProviderKt {
    public static final SnapLayoutInfoProvider a(final LazyListState lazyListState, final SnapPosition snapPosition) {
        return new SnapLayoutInfoProvider() { // from class: androidx.compose.foundation.gestures.snapping.LazyListSnapLayoutInfoProviderKt$SnapLayoutInfoProvider$1
            private final int c() {
                LazyListLayoutInfo lazyListLayoutInfoD = d();
                int size = 0;
                if (lazyListLayoutInfoD.h().isEmpty()) {
                    return 0;
                }
                int size2 = lazyListLayoutInfoD.h().size();
                Iterator it = lazyListLayoutInfoD.h().iterator();
                while (it.hasNext()) {
                    size += ((LazyListItemInfo) it.next()).getSize();
                }
                return size / size2;
            }

            private final LazyListLayoutInfo d() {
                return lazyListState.y();
            }

            @Override // androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider
            public float a(float f3) {
                List listH = d().h();
                SnapPosition snapPosition2 = snapPosition;
                int size = listH.size();
                float f4 = Float.NEGATIVE_INFINITY;
                float f5 = Float.POSITIVE_INFINITY;
                for (int i3 = 0; i3 < size; i3++) {
                    LazyListItemInfo lazyListItemInfo = (LazyListItemInfo) listH.get(i3);
                    LazyLayoutMeasuredItem lazyLayoutMeasuredItem = lazyListItemInfo instanceof LazyLayoutMeasuredItem ? (LazyLayoutMeasuredItem) lazyListItemInfo : null;
                    if (lazyLayoutMeasuredItem == null || !lazyLayoutMeasuredItem.h()) {
                        float fA = SnapPositionKt.a(LazyListSnapLayoutInfoProviderKt.d(d()), d().c(), d().b(), lazyListItemInfo.getSize(), lazyListItemInfo.getOffset(), lazyListItemInfo.getIndex(), snapPosition2, d().e());
                        if (fA <= 0.0f && fA > f4) {
                            f4 = fA;
                        }
                        if (fA >= 0.0f && fA < f5) {
                            f5 = fA;
                        }
                    }
                }
                return SnapFlingBehaviorKt.j(LazyListSnapLayoutInfoProviderKt.c(lazyListState.r(), f3), f4, f5);
            }

            @Override // androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider
            public float b(float f3, float f4) {
                return RangesKt.e(Math.abs(f4) - c(), 0.0f) * Math.signum(f4);
            }
        };
    }

    public static /* synthetic */ SnapLayoutInfoProvider b(LazyListState lazyListState, SnapPosition snapPosition, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            snapPosition = SnapPosition.Center.f6486a;
        }
        return a(lazyListState, snapPosition);
    }

    public static final int c(Density density, float f3) {
        return Math.abs(f3) < density.M1(SnapFlingBehaviorKt.m()) ? FinalSnappingItem.f6430b.a() : f3 > 0.0f ? FinalSnappingItem.f6430b.b() : FinalSnappingItem.f6430b.c();
    }

    public static final int d(LazyListLayoutInfo lazyListLayoutInfo) {
        return (int) (lazyListLayoutInfo.getOrientation() == Orientation.f6031a ? lazyListLayoutInfo.a() & 4294967295L : lazyListLayoutInfo.a() >> 32);
    }

    public static final FlingBehavior e(LazyListState lazyListState, SnapPosition snapPosition, Composer composer, int i3, int i4) {
        if ((i4 & 2) != 0) {
            snapPosition = SnapPosition.Center.f6486a;
        }
        if (ComposerKt.M()) {
            ComposerKt.U(-338621290, i3, -1, "androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior (LazyListSnapLayoutInfoProvider.kt:115)");
        }
        boolean z2 = (((i3 & 14) ^ 6) > 4 && composer.Z(lazyListState)) || (i3 & 6) == 4;
        Object objG = composer.G();
        if (z2 || objG == Composer.f23746a.a()) {
            objG = a(lazyListState, snapPosition);
            composer.w(objG);
        }
        TargetedFlingBehavior targetedFlingBehaviorN = SnapFlingBehaviorKt.n((SnapLayoutInfoProvider) objG, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return targetedFlingBehaviorN;
    }
}
