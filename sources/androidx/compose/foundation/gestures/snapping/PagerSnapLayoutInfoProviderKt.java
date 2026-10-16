package androidx.compose.foundation.gestures.snapping;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.pager.PageInfo;
import androidx.compose.foundation.pager.PagerLayoutInfo;
import androidx.compose.foundation.pager.PagerLayoutInfoKt;
import androidx.compose.foundation.pager.PagerSnapDistance;
import androidx.compose.foundation.pager.PagerState;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function3;
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
public final class PagerSnapLayoutInfoProviderKt {
    public static final SnapLayoutInfoProvider a(final PagerState pagerState, final PagerSnapDistance pagerSnapDistance, final Function3 function3) {
        return new SnapLayoutInfoProvider() { // from class: androidx.compose.foundation.gestures.snapping.PagerSnapLayoutInfoProviderKt$SnapLayoutInfoProvider$1
            private final Pair e(SnapPosition snapPosition, float f3) {
                float f4;
                List listY = c().y();
                PagerState pagerState2 = pagerState;
                int size = listY.size();
                int i3 = 0;
                float f5 = Float.NEGATIVE_INFINITY;
                float f6 = Float.POSITIVE_INFINITY;
                while (true) {
                    f4 = 0.0f;
                    if (i3 >= size) {
                        break;
                    }
                    PageInfo pageInfo = (PageInfo) listY.get(i3);
                    float fA = SnapPositionKt.a(PagerLayoutInfoKt.a(c()), c().c(), c().b(), c().w(), pageInfo.getOffset(), pageInfo.getIndex(), snapPosition, pagerState2.H());
                    if (fA <= 0.0f && fA > f5) {
                        f5 = fA;
                    }
                    if (fA >= 0.0f && fA < f6) {
                        f6 = fA;
                    }
                    i3++;
                }
                if (f5 == Float.NEGATIVE_INFINITY) {
                    f5 = f6;
                }
                if (f6 == Float.POSITIVE_INFINITY) {
                    f6 = f5;
                }
                if (!pagerState.f()) {
                    if (PagerSnapLayoutInfoProviderKt.e(pagerState, f3)) {
                        f5 = 0.0f;
                        f6 = 0.0f;
                    } else {
                        f6 = 0.0f;
                    }
                }
                if (pagerState.d()) {
                    f4 = f5;
                } else if (!PagerSnapLayoutInfoProviderKt.e(pagerState, f3)) {
                    f6 = 0.0f;
                }
                return TuplesKt.a(Float.valueOf(f4), Float.valueOf(f6));
            }

            @Override // androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider
            public float a(float f3) {
                Pair pairE = e(pagerState.C().E(), f3);
                float fFloatValue = ((Number) pairE.a()).floatValue();
                float fFloatValue2 = ((Number) pairE.b()).floatValue();
                float fFloatValue3 = ((Number) function3.invoke(Float.valueOf(f3), Float.valueOf(fFloatValue), Float.valueOf(fFloatValue2))).floatValue();
                if (!(fFloatValue3 == fFloatValue || fFloatValue3 == fFloatValue2 || fFloatValue3 == 0.0f)) {
                    InlineClassHelperKt.c("Final Snapping Offset Should Be one of " + fFloatValue + ", " + fFloatValue2 + " or 0.0");
                }
                if (d(fFloatValue3)) {
                    return fFloatValue3;
                }
                return 0.0f;
            }

            @Override // androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider
            public float b(float f3, float f4) {
                int I = pagerState.I() + pagerState.K();
                if (I == 0) {
                    return 0.0f;
                }
                int iY = f3 < 0.0f ? pagerState.y() + 1 : pagerState.y();
                int iF = RangesKt.f(Math.abs((RangesKt.p(pagerSnapDistance.a(iY, RangesKt.p(((int) (f4 / I)) + iY, 0, pagerState.H()), f3, pagerState.I(), pagerState.K()), 0, pagerState.H()) - iY) * I) - I, 0);
                return iF == 0 ? iF : iF * Math.signum(f3);
            }

            public final PagerLayoutInfo c() {
                return pagerState.C();
            }

            public final boolean d(float f3) {
                return (f3 == Float.POSITIVE_INFINITY || f3 == Float.NEGATIVE_INFINITY) ? false : true;
            }
        };
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0086 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final float c(androidx.compose.foundation.pager.PagerState r5, androidx.compose.ui.unit.LayoutDirection r6, float r7, float r8, float r9, float r10) {
        /*
            boolean r0 = e(r5, r8)
            androidx.compose.foundation.pager.PagerLayoutInfo r1 = r5.C()
            androidx.compose.foundation.gestures.Orientation r1 = r1.getOrientation()
            androidx.compose.foundation.gestures.Orientation r2 = androidx.compose.foundation.gestures.Orientation.f6031a
            if (r1 != r2) goto L11
            goto L1b
        L11:
            androidx.compose.ui.unit.LayoutDirection r1 = androidx.compose.ui.unit.LayoutDirection.f30001a
            if (r6 != r1) goto L16
            goto L1b
        L16:
            if (r0 != 0) goto L1a
            r0 = 1
            goto L1b
        L1a:
            r0 = 0
        L1b:
            androidx.compose.foundation.pager.PagerLayoutInfo r6 = r5.C()
            int r6 = r6.w()
            r1 = 0
            if (r6 != 0) goto L28
            r2 = r1
            goto L2e
        L28:
            float r2 = d(r5)
            float r6 = (float) r6
            float r2 = r2 / r6
        L2e:
            int r6 = (int) r2
            float r6 = (float) r6
            float r6 = r2 - r6
            androidx.compose.ui.unit.Density r3 = r5.x()
            int r8 = androidx.compose.foundation.gestures.snapping.LazyListSnapLayoutInfoProviderKt.c(r3, r8)
            androidx.compose.foundation.gestures.snapping.FinalSnappingItem$Companion r3 = androidx.compose.foundation.gestures.snapping.FinalSnappingItem.f6430b
            int r4 = r3.a()
            boolean r4 = androidx.compose.foundation.gestures.snapping.FinalSnappingItem.f(r8, r4)
            if (r4 == 0) goto L71
            float r6 = java.lang.Math.abs(r6)
            int r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r6 <= 0) goto L51
            if (r0 == 0) goto L86
            goto L7b
        L51:
            float r6 = java.lang.Math.abs(r2)
            float r5 = r5.N()
            float r5 = java.lang.Math.abs(r5)
            int r5 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1))
            if (r5 < 0) goto L64
            if (r0 == 0) goto L7b
            goto L86
        L64:
            float r5 = java.lang.Math.abs(r9)
            float r6 = java.lang.Math.abs(r10)
            int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r5 >= 0) goto L7b
            goto L86
        L71:
            int r5 = r3.b()
            boolean r5 = androidx.compose.foundation.gestures.snapping.FinalSnappingItem.f(r8, r5)
            if (r5 == 0) goto L7c
        L7b:
            return r10
        L7c:
            int r5 = r3.c()
            boolean r5 = androidx.compose.foundation.gestures.snapping.FinalSnappingItem.f(r8, r5)
            if (r5 == 0) goto L87
        L86:
            return r9
        L87:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.snapping.PagerSnapLayoutInfoProviderKt.c(androidx.compose.foundation.pager.PagerState, androidx.compose.ui.unit.LayoutDirection, float, float, float, float):float");
    }

    private static final float d(PagerState pagerState) {
        return pagerState.C().getOrientation() == Orientation.f6032b ? Float.intBitsToFloat((int) (pagerState.V() >> 32)) : Float.intBitsToFloat((int) (pagerState.V() & 4294967295L));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean e(PagerState pagerState, float f3) {
        boolean zX = pagerState.C().x();
        boolean z2 = (pagerState.X() ? -f3 : d(pagerState)) > 0.0f;
        return (z2 && zX) || !(z2 || zX);
    }
}
