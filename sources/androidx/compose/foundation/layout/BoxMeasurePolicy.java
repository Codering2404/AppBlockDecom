package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

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
final class BoxMeasurePolicy implements MeasurePolicy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Alignment f6627a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f6628b;

    public BoxMeasurePolicy(Alignment alignment, boolean z2) {
        this.f6627a = alignment;
        this.f6628b = z2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BoxMeasurePolicy)) {
            return false;
        }
        BoxMeasurePolicy boxMeasurePolicy = (BoxMeasurePolicy) obj;
        return Intrinsics.areEqual(this.f6627a, boxMeasurePolicy.f6627a) && this.f6628b == boxMeasurePolicy.f6628b;
    }

    public int hashCode() {
        return (this.f6627a.hashCode() * 31) + Boolean.hashCode(this.f6628b);
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo10measure3p2s80s(final MeasureScope measureScope, final List list, long j3) {
        int iN;
        int iM;
        Placeable placeableN0;
        if (list.isEmpty()) {
            return MeasureScope.B0(measureScope, Constraints.n(j3), Constraints.m(j3), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.BoxMeasurePolicy$measure$1
                public final void invoke(Placeable.PlacementScope placementScope) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((Placeable.PlacementScope) obj);
                    return Unit.f139807a;
                }
            }, 4, null);
        }
        long jB = this.f6628b ? j3 : Constraints.b(j3 & (-8589934589L));
        if (list.size() == 1) {
            final Measurable measurable = (Measurable) list.get(0);
            if (BoxKt.f(measurable)) {
                iN = Constraints.n(j3);
                iM = Constraints.m(j3);
                placeableN0 = measurable.n0(Constraints.f29963b.c(Constraints.n(j3), Constraints.m(j3)));
            } else {
                placeableN0 = measurable.n0(jB);
                iN = Math.max(Constraints.n(j3), placeableN0.X0());
                iM = Math.max(Constraints.m(j3), placeableN0.O0());
            }
            final int i3 = iN;
            final int i4 = iM;
            final Placeable placeable = placeableN0;
            return MeasureScope.B0(measureScope, i3, i4, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.BoxMeasurePolicy$measure$2
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
                    BoxKt.h(placementScope, placeable, measurable, measureScope.getLayoutDirection(), i3, i4, this.f6627a);
                }
            }, 4, null);
        }
        final Placeable[] placeableArr = new Placeable[list.size()];
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.f140142a = Constraints.n(j3);
        final Ref.IntRef intRef2 = new Ref.IntRef();
        intRef2.f140142a = Constraints.m(j3);
        List list2 = list;
        int size = list2.size();
        boolean z2 = false;
        for (int i5 = 0; i5 < size; i5++) {
            Measurable measurable2 = (Measurable) list.get(i5);
            if (BoxKt.f(measurable2)) {
                z2 = true;
            } else {
                Placeable placeableN02 = measurable2.n0(jB);
                placeableArr[i5] = placeableN02;
                intRef.f140142a = Math.max(intRef.f140142a, placeableN02.X0());
                intRef2.f140142a = Math.max(intRef2.f140142a, placeableN02.O0());
            }
        }
        if (z2) {
            int i6 = intRef.f140142a;
            int i7 = i6 != Integer.MAX_VALUE ? i6 : 0;
            int i8 = intRef2.f140142a;
            long jA = ConstraintsKt.a(i7, i6, i8 != Integer.MAX_VALUE ? i8 : 0, i8);
            int size2 = list2.size();
            for (int i9 = 0; i9 < size2; i9++) {
                Measurable measurable3 = (Measurable) list.get(i9);
                if (BoxKt.f(measurable3)) {
                    placeableArr[i9] = measurable3.n0(jA);
                }
            }
        }
        return MeasureScope.B0(measureScope, intRef.f140142a, intRef2.f140142a, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.BoxMeasurePolicy$measure$5
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
                Placeable[] placeableArr2 = placeableArr;
                List list3 = list;
                MeasureScope measureScope2 = measureScope;
                Ref.IntRef intRef3 = intRef;
                Ref.IntRef intRef4 = intRef2;
                BoxMeasurePolicy boxMeasurePolicy = this;
                int length = placeableArr2.length;
                int i10 = 0;
                int i11 = 0;
                while (i10 < length) {
                    Placeable placeable2 = placeableArr2[i10];
                    Intrinsics.checkNotNull(placeable2, "null cannot be cast to non-null type androidx.compose.ui.layout.Placeable");
                    BoxKt.h(placementScope, placeable2, (Measurable) list3.get(i11), measureScope2.getLayoutDirection(), intRef3.f140142a, intRef4.f140142a, boxMeasurePolicy.f6627a);
                    i10++;
                    i11++;
                }
            }
        }, 4, null);
    }

    public String toString() {
        return "BoxMeasurePolicy(alignment=" + this.f6627a + ", propagateMinConstraints=" + this.f6628b + ')';
    }
}
