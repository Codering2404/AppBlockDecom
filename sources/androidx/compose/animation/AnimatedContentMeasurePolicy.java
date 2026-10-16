package androidx.compose.animation;

import androidx.compose.animation.AnimatedContentTransitionScopeImpl;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.IntRange;

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
final class AnimatedContentMeasurePolicy implements MeasurePolicy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AnimatedContentTransitionScopeImpl f3231a;

    public AnimatedContentMeasurePolicy(AnimatedContentTransitionScopeImpl animatedContentTransitionScopeImpl) {
        this.f3231a = animatedContentTransitionScopeImpl;
    }

    public final AnimatedContentTransitionScopeImpl a() {
        return this.f3231a;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i3) {
        Integer numValueOf;
        if (list.isEmpty()) {
            numValueOf = null;
        } else {
            numValueOf = Integer.valueOf(((IntrinsicMeasurable) list.get(0)).I(i3));
            int lastIndex = CollectionsKt.getLastIndex(list);
            int i4 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Integer numValueOf2 = Integer.valueOf(((IntrinsicMeasurable) list.get(i4)).I(i3));
                    if (numValueOf2.compareTo(numValueOf) > 0) {
                        numValueOf = numValueOf2;
                    }
                    if (i4 == lastIndex) {
                        break;
                    }
                    i4++;
                }
            }
        }
        if (numValueOf != null) {
            return numValueOf.intValue();
        }
        return 0;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i3) {
        Integer numValueOf;
        if (list.isEmpty()) {
            numValueOf = null;
        } else {
            numValueOf = Integer.valueOf(((IntrinsicMeasurable) list.get(0)).l0(i3));
            int lastIndex = CollectionsKt.getLastIndex(list);
            int i4 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Integer numValueOf2 = Integer.valueOf(((IntrinsicMeasurable) list.get(i4)).l0(i3));
                    if (numValueOf2.compareTo(numValueOf) > 0) {
                        numValueOf = numValueOf2;
                    }
                    if (i4 == lastIndex) {
                        break;
                    }
                    i4++;
                }
            }
        }
        if (numValueOf != null) {
            return numValueOf.intValue();
        }
        return 0;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
    public MeasureResult mo10measure3p2s80s(MeasureScope measureScope, List list, long j3) {
        Placeable placeable;
        Placeable placeable2;
        final int iX0;
        final int iO0;
        int size = list.size();
        final Placeable[] placeableArr = new Placeable[size];
        long jA = IntSize.f29998b.a();
        List list2 = list;
        int size2 = list2.size();
        int i3 = 0;
        while (true) {
            placeable = null;
            if (i3 >= size2) {
                break;
            }
            Measurable measurable = (Measurable) list.get(i3);
            Object objP = measurable.p();
            AnimatedContentTransitionScopeImpl.ChildData childData = objP instanceof AnimatedContentTransitionScopeImpl.ChildData ? (AnimatedContentTransitionScopeImpl.ChildData) objP : null;
            if (childData != null && childData.a()) {
                Placeable placeableN0 = measurable.n0(j3);
                long jC = IntSize.c((((long) placeableN0.X0()) << 32) | (((long) placeableN0.O0()) & 4294967295L));
                Unit unit = Unit.f139807a;
                placeableArr[i3] = placeableN0;
                jA = jC;
            }
            i3++;
        }
        int size3 = list2.size();
        for (int i4 = 0; i4 < size3; i4++) {
            Measurable measurable2 = (Measurable) list.get(i4);
            if (placeableArr[i4] == null) {
                placeableArr[i4] = measurable2.n0(j3);
            }
        }
        if (measureScope.q0()) {
            iX0 = (int) (jA >> 32);
        } else {
            if (size == 0) {
                placeable2 = null;
            } else {
                placeable2 = placeableArr[0];
                int lastIndex = ArraysKt.getLastIndex(placeableArr);
                if (lastIndex != 0) {
                    int iX02 = placeable2 != null ? placeable2.X0() : 0;
                    IntIterator it = new IntRange(1, lastIndex).iterator();
                    while (it.hasNext()) {
                        Placeable placeable3 = placeableArr[it.nextInt()];
                        int iX03 = placeable3 != null ? placeable3.X0() : 0;
                        if (iX02 < iX03) {
                            placeable2 = placeable3;
                            iX02 = iX03;
                        }
                    }
                }
            }
            iX0 = placeable2 != null ? placeable2.X0() : 0;
        }
        if (measureScope.q0()) {
            iO0 = (int) (jA & 4294967295L);
        } else {
            if (size != 0) {
                placeable = placeableArr[0];
                int lastIndex2 = ArraysKt.getLastIndex(placeableArr);
                if (lastIndex2 != 0) {
                    int iO02 = placeable != null ? placeable.O0() : 0;
                    IntIterator it2 = new IntRange(1, lastIndex2).iterator();
                    while (it2.hasNext()) {
                        Placeable placeable4 = placeableArr[it2.nextInt()];
                        int iO03 = placeable4 != null ? placeable4.O0() : 0;
                        if (iO02 < iO03) {
                            placeable = placeable4;
                            iO02 = iO03;
                        }
                    }
                }
            }
            iO0 = placeable != null ? placeable.O0() : 0;
        }
        if (!measureScope.q0()) {
            this.f3231a.s(IntSize.c((((long) iX0) << 32) | (((long) iO0) & 4294967295L)));
        }
        return MeasureScope.B0(measureScope, iX0, iO0, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.animation.AnimatedContentMeasurePolicy$measure$3
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
                Placeable[] placeableArr2;
                Placeable[] placeableArr3 = placeableArr;
                AnimatedContentMeasurePolicy animatedContentMeasurePolicy = this;
                int i5 = iX0;
                int i6 = iO0;
                int length = placeableArr3.length;
                int i7 = 0;
                while (i7 < length) {
                    Placeable placeable5 = placeableArr3[i7];
                    if (placeable5 != null) {
                        placeableArr2 = placeableArr3;
                        long jA2 = animatedContentMeasurePolicy.a().k().a(IntSize.c((((long) placeable5.X0()) << 32) | (((long) placeable5.O0()) & 4294967295L)), IntSize.c((((long) i6) & 4294967295L) | (((long) i5) << 32)), LayoutDirection.f30001a);
                        Placeable.PlacementScope.i(placementScope, placeable5, IntOffset.k(jA2), IntOffset.l(jA2), 0.0f, 4, null);
                    } else {
                        placeableArr2 = placeableArr3;
                    }
                    i7++;
                    placeableArr3 = placeableArr2;
                }
            }
        }, 4, null);
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i3) {
        Integer numValueOf;
        if (list.isEmpty()) {
            numValueOf = null;
        } else {
            numValueOf = Integer.valueOf(((IntrinsicMeasurable) list.get(0)).d0(i3));
            int lastIndex = CollectionsKt.getLastIndex(list);
            int i4 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Integer numValueOf2 = Integer.valueOf(((IntrinsicMeasurable) list.get(i4)).d0(i3));
                    if (numValueOf2.compareTo(numValueOf) > 0) {
                        numValueOf = numValueOf2;
                    }
                    if (i4 == lastIndex) {
                        break;
                    }
                    i4++;
                }
            }
        }
        if (numValueOf != null) {
            return numValueOf.intValue();
        }
        return 0;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i3) {
        Integer numValueOf;
        if (list.isEmpty()) {
            numValueOf = null;
        } else {
            numValueOf = Integer.valueOf(((IntrinsicMeasurable) list.get(0)).k0(i3));
            int lastIndex = CollectionsKt.getLastIndex(list);
            int i4 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Integer numValueOf2 = Integer.valueOf(((IntrinsicMeasurable) list.get(i4)).k0(i3));
                    if (numValueOf2.compareTo(numValueOf) > 0) {
                        numValueOf = numValueOf2;
                    }
                    if (i4 == lastIndex) {
                        break;
                    }
                    i4++;
                }
            }
        }
        if (numValueOf != null) {
            return numValueOf.intValue();
        }
        return 0;
    }
}
