package androidx.compose.animation;

import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntSize;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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
final class AnimatedEnterExitMeasurePolicy implements MeasurePolicy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AnimatedVisibilityScopeImpl f3284a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f3285b;

    public AnimatedEnterExitMeasurePolicy(AnimatedVisibilityScopeImpl animatedVisibilityScopeImpl) {
        this.f3284a = animatedVisibilityScopeImpl;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i3) {
        if (list.isEmpty()) {
            return 0;
        }
        int I = ((IntrinsicMeasurable) list.get(0)).I(i3);
        int lastIndex = CollectionsKt.getLastIndex(list);
        int i4 = 1;
        if (1 <= lastIndex) {
            while (true) {
                int I2 = ((IntrinsicMeasurable) list.get(i4)).I(i3);
                if (I2 > I) {
                    I = I2;
                }
                if (i4 == lastIndex) {
                    break;
                }
                i4++;
            }
        }
        return I;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i3) {
        if (list.isEmpty()) {
            return 0;
        }
        int iL0 = ((IntrinsicMeasurable) list.get(0)).l0(i3);
        int lastIndex = CollectionsKt.getLastIndex(list);
        int i4 = 1;
        if (1 <= lastIndex) {
            while (true) {
                int iL02 = ((IntrinsicMeasurable) list.get(i4)).l0(i3);
                if (iL02 > iL0) {
                    iL0 = iL02;
                }
                if (i4 == lastIndex) {
                    break;
                }
                i4++;
            }
        }
        return iL0;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo10measure3p2s80s(MeasureScope measureScope, List list, long j3) {
        final ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        int iMax = 0;
        int iMax2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            Placeable placeableN0 = ((Measurable) list.get(i3)).n0(j3);
            iMax = Math.max(iMax, placeableN0.X0());
            iMax2 = Math.max(iMax2, placeableN0.O0());
            arrayList.add(placeableN0);
        }
        if (measureScope.q0()) {
            this.f3285b = true;
            this.f3284a.a().setValue(IntSize.b(IntSize.c((4294967295L & ((long) iMax2)) | (((long) iMax) << 32))));
        } else if (!this.f3285b) {
            this.f3284a.a().setValue(IntSize.b(IntSize.c((4294967295L & ((long) iMax2)) | (((long) iMax) << 32))));
        }
        return MeasureScope.B0(measureScope, iMax, iMax2, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.animation.AnimatedEnterExitMeasurePolicy$measure$1
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
                List list2 = arrayList;
                int size2 = list2.size();
                for (int i4 = 0; i4 < size2; i4++) {
                    Placeable.PlacementScope.i(placementScope, (Placeable) list2.get(i4), 0, 0, 0.0f, 4, null);
                }
            }
        }, 4, null);
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i3) {
        if (list.isEmpty()) {
            return 0;
        }
        int iD0 = ((IntrinsicMeasurable) list.get(0)).d0(i3);
        int lastIndex = CollectionsKt.getLastIndex(list);
        int i4 = 1;
        if (1 <= lastIndex) {
            while (true) {
                int iD02 = ((IntrinsicMeasurable) list.get(i4)).d0(i3);
                if (iD02 > iD0) {
                    iD0 = iD02;
                }
                if (i4 == lastIndex) {
                    break;
                }
                i4++;
            }
        }
        return iD0;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i3) {
        if (list.isEmpty()) {
            return 0;
        }
        int iK0 = ((IntrinsicMeasurable) list.get(0)).k0(i3);
        int lastIndex = CollectionsKt.getLastIndex(list);
        int i4 = 1;
        if (1 <= lastIndex) {
            while (true) {
                int iK02 = ((IntrinsicMeasurable) list.get(i4)).k0(i3);
                if (iK02 > iK0) {
                    iK0 = iK02;
                }
                if (i4 == lastIndex) {
                    break;
                }
                i4++;
            }
        }
        return iK0;
    }
}
