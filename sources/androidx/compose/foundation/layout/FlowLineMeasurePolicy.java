package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

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
public interface FlowLineMeasurePolicy extends RowColumnMeasurePolicy {
    @Override // androidx.compose.foundation.layout.RowColumnMeasurePolicy
    default long a(int i3, int i4, int i5, int i6, boolean z2) {
        return b() ? RowKt.a(z2, i3, i4, i5, i6) : ColumnKt.b(z2, i3, i4, i5, i6);
    }

    boolean b();

    @Override // androidx.compose.foundation.layout.RowColumnMeasurePolicy
    default void c(int i3, int[] iArr, int[] iArr2, MeasureScope measureScope) {
        if (b()) {
            i().c(measureScope, i3, iArr, measureScope.getLayoutDirection(), iArr2);
        } else {
            j().b(measureScope, i3, iArr, iArr2);
        }
    }

    @Override // androidx.compose.foundation.layout.RowColumnMeasurePolicy
    default MeasureResult d(final Placeable[] placeableArr, MeasureScope measureScope, final int i3, final int[] iArr, int i4, final int i5, final int[] iArr2, final int i6, final int i7, final int i8) {
        int i9;
        int i10;
        if (b()) {
            i10 = i4;
            i9 = i5;
        } else {
            i9 = i4;
            i10 = i5;
        }
        final LayoutDirection layoutDirection = b() ? LayoutDirection.f30001a : measureScope.getLayoutDirection();
        return MeasureScope.B0(measureScope, i10, i9, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.FlowLineMeasurePolicy$placeHelper$1$1
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
                Placeable.PlacementScope placementScope2;
                int[] iArr3 = iArr2;
                int i11 = iArr3 != null ? iArr3[i6] : 0;
                int i12 = i7;
                while (i12 < i8) {
                    Placeable placeable = placeableArr[i12];
                    Intrinsics.checkNotNull(placeable);
                    int iK = this.k(placeable, i5, layoutDirection, i3) + i11;
                    if (this.b()) {
                        placementScope2 = placementScope;
                        Placeable.PlacementScope.i(placementScope2, placeable, iArr[i12 - i7], iK, 0.0f, 4, null);
                    } else {
                        placementScope2 = placementScope;
                        Placeable.PlacementScope.i(placementScope2, placeable, iK, iArr[i12 - i7], 0.0f, 4, null);
                    }
                    i12++;
                    placementScope = placementScope2;
                }
            }
        }, 4, null);
    }

    @Override // androidx.compose.foundation.layout.RowColumnMeasurePolicy
    default int e(Placeable placeable) {
        return b() ? placeable.S0() : placeable.Q0();
    }

    @Override // androidx.compose.foundation.layout.RowColumnMeasurePolicy
    default int f(Placeable placeable) {
        return b() ? placeable.Q0() : placeable.S0();
    }

    CrossAxisAlignment g();

    Arrangement.Horizontal i();

    Arrangement.Vertical j();

    default int k(Placeable placeable, int i3, LayoutDirection layoutDirection, int i4) {
        CrossAxisAlignment crossAxisAlignmentG;
        RowColumnParentData rowColumnParentDataD = RowColumnImplKt.d(placeable);
        if (rowColumnParentDataD == null || (crossAxisAlignmentG = rowColumnParentDataD.a()) == null) {
            crossAxisAlignmentG = g();
        }
        return crossAxisAlignmentG.a(i3 - f(placeable), layoutDirection, placeable, i4);
    }
}
