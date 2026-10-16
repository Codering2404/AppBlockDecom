package androidx.compose.material3;

import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;
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
final class CenteredContentMeasurePolicy implements MeasurePolicy {
    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo10measure3p2s80s(MeasureScope measureScope, List list, long j3) {
        final ArrayList arrayList;
        int iK;
        int iL = Constraints.l(j3);
        int iM = Constraints.m(j3);
        int size = list.size();
        if (size < 1) {
            return MeasureScope.B0(measureScope, iL, iM, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.CenteredContentMeasurePolicy$measure$1
                public final void invoke(Placeable.PlacementScope placementScope) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((Placeable.PlacementScope) obj);
                    return Unit.f139807a;
                }
            }, 4, null);
        }
        final Ref.IntRef intRef = new Ref.IntRef();
        int i3 = 0;
        if (Constraints.h(j3)) {
            int i4 = iL / size;
            int iJ = ExpressiveNavigationBarKt.j(size, iL);
            intRef.f140142a = iJ;
            int i5 = (iL - (iJ * 2)) / size;
            int size2 = list.size();
            for (int i6 = 0; i6 < size2; i6++) {
                int I = ((Measurable) list.get(i6)).I(i5);
                if (iM < I) {
                    iM = RangesKt.k(I, Constraints.k(j3));
                }
            }
            arrayList = new ArrayList(list.size());
            int size3 = list.size();
            while (i3 < size3) {
                Measurable measurable = (Measurable) list.get(i3);
                int iL0 = measurable.l0(Constraints.m(j3));
                if (i5 < iL0) {
                    iK = RangesKt.k(iL0, i4);
                    intRef.f140142a -= (iK - i5) / 2;
                } else {
                    iK = i5;
                }
                arrayList.add(measurable.n0(ConstraintsKt.e(j3, Constraints.f29963b.c(iK, iM))));
                i3++;
            }
        } else {
            arrayList = new ArrayList(list.size());
            int size4 = list.size();
            while (i3 < size4) {
                arrayList.add(((Measurable) list.get(i3)).n0(ConstraintsKt.e(j3, Constraints.f29963b.d(iM))));
                i3++;
            }
        }
        return MeasureScope.B0(measureScope, iL, iM, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.CenteredContentMeasurePolicy$measure$5
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
                int i7 = intRef.f140142a;
                List list2 = arrayList;
                int size5 = list2.size();
                int i8 = 0;
                int iX0 = i7;
                while (i8 < size5) {
                    Placeable placeable = (Placeable) list2.get(i8);
                    Placeable.PlacementScope placementScope2 = placementScope;
                    Placeable.PlacementScope.m(placementScope2, placeable, iX0, 0, 0.0f, 4, null);
                    iX0 += placeable.X0();
                    i8++;
                    placementScope = placementScope2;
                }
            }
        }, 4, null);
    }
}
