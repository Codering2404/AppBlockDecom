package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.MultiContentMeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

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
public final class SegmentedButtonContentMeasurePolicy implements MultiContentMeasurePolicy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CoroutineScope f19710a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Animatable f19711b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Integer f19712c;

    public SegmentedButtonContentMeasurePolicy(CoroutineScope coroutineScope) {
        this.f19710a = coroutineScope;
    }

    public final Animatable a() {
        return this.f19711b;
    }

    @Override // androidx.compose.ui.layout.MultiContentMeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo47measure3p2s80s(final MeasureScope measureScope, List list, long j3) {
        Object obj;
        Object obj2;
        Object obj3;
        List list2 = (List) list.get(0);
        int i3 = 1;
        List list3 = (List) list.get(1);
        final ArrayList arrayList = new ArrayList(list2.size());
        int size = list2.size();
        for (int i4 = 0; i4 < size; i4++) {
            arrayList.add(((Measurable) list2.get(i4)).n0(j3));
        }
        if (arrayList.isEmpty()) {
            obj = null;
        } else {
            obj = arrayList.get(0);
            int iX0 = ((Placeable) obj).X0();
            int lastIndex = CollectionsKt.getLastIndex(arrayList);
            if (1 <= lastIndex) {
                int i5 = 1;
                while (true) {
                    Object obj4 = arrayList.get(i5);
                    int iX02 = ((Placeable) obj4).X0();
                    if (iX0 < iX02) {
                        obj = obj4;
                        iX0 = iX02;
                    }
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
        }
        Placeable placeable = (Placeable) obj;
        int iX03 = placeable != null ? placeable.X0() : 0;
        final ArrayList arrayList2 = new ArrayList(list3.size());
        int size2 = list3.size();
        for (int i6 = 0; i6 < size2; i6++) {
            arrayList2.add(((Measurable) list3.get(i6)).n0(j3));
        }
        if (arrayList2.isEmpty()) {
            obj2 = null;
        } else {
            obj2 = arrayList2.get(0);
            int iX04 = ((Placeable) obj2).X0();
            int lastIndex2 = CollectionsKt.getLastIndex(arrayList2);
            if (1 <= lastIndex2) {
                int i7 = 1;
                while (true) {
                    Object obj5 = arrayList2.get(i7);
                    int iX05 = ((Placeable) obj5).X0();
                    if (iX04 < iX05) {
                        obj2 = obj5;
                        iX04 = iX05;
                    }
                    if (i7 == lastIndex2) {
                        break;
                    }
                    i7++;
                }
            }
        }
        Placeable placeable2 = (Placeable) obj2;
        Integer numValueOf = placeable2 != null ? Integer.valueOf(placeable2.X0()) : null;
        if (arrayList2.isEmpty()) {
            obj3 = null;
        } else {
            obj3 = arrayList2.get(0);
            int iO0 = ((Placeable) obj3).O0();
            int lastIndex3 = CollectionsKt.getLastIndex(arrayList2);
            if (1 <= lastIndex3) {
                while (true) {
                    Object obj6 = arrayList2.get(i3);
                    int iO02 = ((Placeable) obj6).O0();
                    if (iO0 < iO02) {
                        obj3 = obj6;
                        iO0 = iO02;
                    }
                    if (i3 == lastIndex3) {
                        break;
                    }
                    i3++;
                }
            }
        }
        Placeable placeable3 = (Placeable) obj3;
        int iO03 = placeable3 != null ? placeable3.O0() : 0;
        SegmentedButtonDefaults segmentedButtonDefaults = SegmentedButtonDefaults.f19722a;
        int iMax = Math.max(measureScope.z0(segmentedButtonDefaults.h()), iX03) + measureScope.z0(SegmentedButtonKt.f19736a) + (numValueOf != null ? numValueOf.intValue() : 0);
        int i8 = iX03 == 0 ? (-(measureScope.z0(segmentedButtonDefaults.h()) + measureScope.z0(SegmentedButtonKt.f19736a))) / 2 : 0;
        if (this.f19712c == null) {
            this.f19712c = Integer.valueOf(i8);
        } else {
            Animatable animatable = this.f19711b;
            if (animatable == null) {
                Integer num = this.f19712c;
                Intrinsics.checkNotNull(num);
                Animatable animatable2 = new Animatable(num, VectorConvertersKt.j(IntCompanionObject.f140132a), null, null, 12, null);
                this.f19711b = animatable2;
                animatable = animatable2;
            }
            if (((Number) animatable.l()).intValue() != i8) {
                BuildersKt__Builders_commonKt.d(this.f19710a, null, null, new SegmentedButtonContentMeasurePolicy$measure$1(animatable, i8, null), 3, null);
            }
        }
        final int i9 = iO03;
        final int i10 = i8;
        return MeasureScope.B0(measureScope, iMax, i9, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.SegmentedButtonContentMeasurePolicy$measure$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj7) {
                invoke((Placeable.PlacementScope) obj7);
                return Unit.f139807a;
            }

            public final void invoke(Placeable.PlacementScope placementScope) {
                List list4 = arrayList;
                int i11 = i9;
                int size3 = list4.size();
                for (int i12 = 0; i12 < size3; i12++) {
                    Placeable placeable4 = (Placeable) list4.get(i12);
                    Placeable.PlacementScope.i(placementScope, placeable4, 0, (i11 - placeable4.O0()) / 2, 0.0f, 4, null);
                }
                int iZ0 = measureScope.z0(SegmentedButtonDefaults.f19722a.h()) + measureScope.z0(SegmentedButtonKt.f19736a);
                Animatable animatableA = this.a();
                int iIntValue = iZ0 + (animatableA != null ? ((Number) animatableA.n()).intValue() : i10);
                List list5 = arrayList2;
                int i13 = i9;
                int size4 = list5.size();
                for (int i14 = 0; i14 < size4; i14++) {
                    Placeable placeable5 = (Placeable) list5.get(i14);
                    Placeable.PlacementScope.i(placementScope, placeable5, iIntValue, (i13 - placeable5.O0()) / 2, 0.0f, 4, null);
                }
            }
        }, 4, null);
    }
}
