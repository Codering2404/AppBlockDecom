package androidx.compose.foundation.text;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

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
final class TextMeasurePolicy implements MeasurePolicy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function0 f10061a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function0 f10062b;

    public TextMeasurePolicy(Function0 function0, Function0 function02) {
        this.f10061a = function0;
        this.f10062b = function02;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo10measure3p2s80s(MeasureScope measureScope, List list, long j3) {
        final ArrayList arrayList;
        ArrayList arrayList2 = new ArrayList(list.size());
        List list2 = list;
        int size = list2.size();
        for (int i3 = 0; i3 < size; i3++) {
            Object obj = list.get(i3);
            if (!(((Measurable) obj).p() instanceof TextRangeLayoutModifier)) {
                arrayList2.add(obj);
            }
        }
        List list3 = (List) this.f10062b.invoke();
        if (list3 != null) {
            ArrayList arrayList3 = new ArrayList(list3.size());
            int size2 = list3.size();
            for (int i4 = 0; i4 < size2; i4++) {
                Rect rect = (Rect) list3.get(i4);
                Pair pair = rect != null ? new Pair(((Measurable) arrayList2.get(i4)).n0(ConstraintsKt.b(0, (int) Math.floor(rect.p() - rect.o()), 0, (int) Math.floor(rect.i() - rect.r()), 5, null)), IntOffset.c(IntOffset.f((((long) Math.round(rect.r())) & 4294967295L) | (((long) Math.round(rect.o())) << 32)))) : null;
                if (pair != null) {
                    arrayList3.add(pair);
                }
            }
            arrayList = arrayList3;
        } else {
            arrayList = null;
        }
        ArrayList arrayList4 = new ArrayList(list.size());
        int size3 = list2.size();
        for (int i5 = 0; i5 < size3; i5++) {
            Object obj2 = list.get(i5);
            if (((Measurable) obj2).p() instanceof TextRangeLayoutModifier) {
                arrayList4.add(obj2);
            }
        }
        final List listO = BasicTextKt.o(arrayList4, this.f10061a);
        return MeasureScope.B0(measureScope, Constraints.l(j3), Constraints.k(j3), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.text.TextMeasurePolicy$measure$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj3) {
                invoke((Placeable.PlacementScope) obj3);
                return Unit.f139807a;
            }

            public final void invoke(Placeable.PlacementScope placementScope) {
                List list4 = arrayList;
                if (list4 != null) {
                    int size4 = list4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        Pair pair2 = (Pair) list4.get(i6);
                        Placeable.PlacementScope.k(placementScope, (Placeable) pair2.a(), ((IntOffset) pair2.b()).r(), 0.0f, 2, null);
                    }
                }
                List list5 = listO;
                if (list5 != null) {
                    int size5 = list5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        Pair pair3 = (Pair) list5.get(i7);
                        Placeable placeable = (Placeable) pair3.a();
                        Function0 function0 = (Function0) pair3.b();
                        Placeable.PlacementScope.k(placementScope, placeable, function0 != null ? ((IntOffset) function0.invoke()).r() : IntOffset.f29988b.b(), 0.0f, 2, null);
                    }
                }
            }
        }, 4, null);
    }
}
