package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.HorizontalAlignmentLine;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
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
public final class AlignmentLineKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final MeasureResult c(MeasureScope measureScope, final AlignmentLine alignmentLine, final float f3, float f4, Measurable measurable, long j3) {
        final Placeable placeableN0 = measurable.n0(d(alignmentLine) ? Constraints.d(j3, 0, 0, 0, 0, 11, null) : Constraints.d(j3, 0, 0, 0, 0, 14, null));
        int iP0 = placeableN0.p0(alignmentLine);
        if (iP0 == Integer.MIN_VALUE) {
            iP0 = 0;
        }
        int iO0 = d(alignmentLine) ? placeableN0.O0() : placeableN0.X0();
        int iK = (d(alignmentLine) ? Constraints.k(j3) : Constraints.l(j3)) - iO0;
        final int iP = RangesKt.p((!Float.isNaN(f3) ? measureScope.z0(f3) : 0) - iP0, 0, iK);
        final int iP2 = RangesKt.p(((!Float.isNaN(f4) ? measureScope.z0(f4) : 0) - iO0) + iP0, 0, iK - iP);
        final int iX0 = d(alignmentLine) ? placeableN0.X0() : Math.max(placeableN0.X0() + iP + iP2, Constraints.n(j3));
        final int iMax = d(alignmentLine) ? Math.max(placeableN0.O0() + iP + iP2, Constraints.m(j3)) : placeableN0.O0();
        return MeasureScope.B0(measureScope, iX0, iMax, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.AlignmentLineKt$alignmentLineOffsetMeasure$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Placeable.PlacementScope) obj);
                return Unit.f139807a;
            }

            public final void invoke(Placeable.PlacementScope placementScope) {
                int iX02;
                if (AlignmentLineKt.d(alignmentLine)) {
                    iX02 = 0;
                } else {
                    iX02 = !Dp.i(f3, Dp.f29970b.c()) ? iP : (iX0 - iP2) - placeableN0.X0();
                }
                Placeable.PlacementScope.m(placementScope, placeableN0, iX02, AlignmentLineKt.d(alignmentLine) ? !Dp.i(f3, Dp.f29970b.c()) ? iP : (iMax - iP2) - placeableN0.O0() : 0, 0.0f, 4, null);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean d(AlignmentLine alignmentLine) {
        return alignmentLine instanceof HorizontalAlignmentLine;
    }

    public static final Modifier e(Modifier modifier, final AlignmentLine alignmentLine, final float f3, final float f4) {
        return modifier.then(new AlignmentLineOffsetDpElement(alignmentLine, f3, f4, InspectableValueKt.b() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.AlignmentLineKt$paddingFrom-4j6BHR0$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void c(InspectorInfo inspectorInfo) {
                inspectorInfo.d("paddingFrom");
                inspectorInfo.b().c("alignmentLine", alignmentLine);
                inspectorInfo.b().c("before", Dp.d(f3));
                inspectorInfo.b().c("after", Dp.d(f4));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c((InspectorInfo) obj);
                return Unit.f139807a;
            }
        } : InspectableValueKt.a(), null));
    }

    public static /* synthetic */ Modifier f(Modifier modifier, AlignmentLine alignmentLine, float f3, float f4, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            f3 = Dp.f29970b.c();
        }
        if ((i3 & 4) != 0) {
            f4 = Dp.f29970b.c();
        }
        return e(modifier, alignmentLine, f3, f4);
    }

    public static final Modifier g(Modifier modifier, float f3, float f4) {
        return modifier.then(!Float.isNaN(f3) ? f(Modifier.b8, androidx.compose.ui.layout.AlignmentLineKt.a(), f3, 0.0f, 4, null) : Modifier.b8).then(!Float.isNaN(f4) ? f(Modifier.b8, androidx.compose.ui.layout.AlignmentLineKt.b(), 0.0f, f4, 2, null) : Modifier.b8);
    }

    public static /* synthetic */ Modifier h(Modifier modifier, float f3, float f4, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            f3 = Dp.f29970b.c();
        }
        if ((i3 & 2) != 0) {
            f4 = Dp.f29970b.c();
        }
        return g(modifier, f3, f4);
    }
}
