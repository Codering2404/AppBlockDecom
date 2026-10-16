package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
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
public final class RowMeasurePolicy implements MeasurePolicy, RowColumnMeasurePolicy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Arrangement.Horizontal f7094a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Alignment.Vertical f7095b;

    public RowMeasurePolicy(Arrangement.Horizontal horizontal, Alignment.Vertical vertical) {
        this.f7094a = horizontal;
        this.f7095b = vertical;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int m(Placeable placeable, RowColumnParentData rowColumnParentData, int i3, int i4) {
        CrossAxisAlignment crossAxisAlignmentA = rowColumnParentData != null ? rowColumnParentData.a() : null;
        return crossAxisAlignmentA != null ? crossAxisAlignmentA.a(i3 - placeable.O0(), LayoutDirection.f30001a, placeable, i4) : this.f7095b.a(0, i3 - placeable.O0());
    }

    @Override // androidx.compose.foundation.layout.RowColumnMeasurePolicy
    public long a(int i3, int i4, int i5, int i6, boolean z2) {
        return RowKt.a(z2, i3, i4, i5, i6);
    }

    @Override // androidx.compose.foundation.layout.RowColumnMeasurePolicy
    public void c(int i3, int[] iArr, int[] iArr2, MeasureScope measureScope) {
        this.f7094a.c(measureScope, i3, iArr, measureScope.getLayoutDirection(), iArr2);
    }

    @Override // androidx.compose.foundation.layout.RowColumnMeasurePolicy
    public MeasureResult d(final Placeable[] placeableArr, MeasureScope measureScope, final int i3, final int[] iArr, int i4, final int i5, int[] iArr2, int i6, int i7, int i8) {
        return MeasureScope.B0(measureScope, i4, i5, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.RowMeasurePolicy$placeHelper$1$1
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
                RowMeasurePolicy rowMeasurePolicy = this;
                int i9 = i5;
                int i10 = i3;
                int[] iArr3 = iArr;
                int length = placeableArr2.length;
                int i11 = 0;
                int i12 = 0;
                while (i11 < length) {
                    Placeable placeable = placeableArr2[i11];
                    Intrinsics.checkNotNull(placeable);
                    Placeable.PlacementScope.i(placementScope, placeable, iArr3[i12], rowMeasurePolicy.m(placeable, RowColumnImplKt.d(placeable), i9, i10), 0.0f, 4, null);
                    i11++;
                    i12++;
                }
            }
        }, 4, null);
    }

    @Override // androidx.compose.foundation.layout.RowColumnMeasurePolicy
    public int e(Placeable placeable) {
        return placeable.X0();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RowMeasurePolicy)) {
            return false;
        }
        RowMeasurePolicy rowMeasurePolicy = (RowMeasurePolicy) obj;
        return Intrinsics.areEqual(this.f7094a, rowMeasurePolicy.f7094a) && Intrinsics.areEqual(this.f7095b, rowMeasurePolicy.f7095b);
    }

    @Override // androidx.compose.foundation.layout.RowColumnMeasurePolicy
    public int f(Placeable placeable) {
        return placeable.O0();
    }

    public int hashCode() {
        return (this.f7094a.hashCode() * 31) + this.f7095b.hashCode();
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i3) {
        return IntrinsicMeasureBlocks.f6985a.a(list, i3, intrinsicMeasureScope.z0(this.f7094a.a()));
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i3) {
        return IntrinsicMeasureBlocks.f6985a.b(list, i3, intrinsicMeasureScope.z0(this.f7094a.a()));
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo10measure3p2s80s(MeasureScope measureScope, List list, long j3) {
        return RowColumnMeasurePolicyKt.a(this, Constraints.n(j3), Constraints.m(j3), Constraints.l(j3), Constraints.k(j3), measureScope.z0(this.f7094a.a()), measureScope, list, new Placeable[list.size()], 0, list.size(), (3072 & 1024) != 0 ? null : null, (3072 & 2048) != 0 ? 0 : 0);
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i3) {
        return IntrinsicMeasureBlocks.f6985a.c(list, i3, intrinsicMeasureScope.z0(this.f7094a.a()));
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i3) {
        return IntrinsicMeasureBlocks.f6985a.d(list, i3, intrinsicMeasureScope.z0(this.f7094a.a()));
    }

    public String toString() {
        return "RowMeasurePolicy(horizontalArrangement=" + this.f7094a + ", verticalAlignment=" + this.f7095b + ')';
    }
}
