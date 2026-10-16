package androidx.constraintlayout.compose;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntSize;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class ConstraintLayoutKt$ConstraintLayout$measurePolicy$1$1 implements MeasurePolicy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ MutableState f30477a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Measurer f30478b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ ConstraintSetForInlineDsl f30479c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ int f30480d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ MutableState f30481e;

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo10measure3p2s80s(MeasureScope measureScope, final List list, long j3) {
        this.f30477a.getValue();
        long jX = this.f30478b.x(j3, measureScope.getLayoutDirection(), this.f30479c, list, this.f30480d);
        this.f30481e.getValue();
        int iG = IntSize.g(jX);
        int iF = IntSize.f(jX);
        final Measurer measurer = this.f30478b;
        return MeasureScope.B0(measureScope, iG, iF, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.constraintlayout.compose.ConstraintLayoutKt$ConstraintLayout$measurePolicy$1$1.1
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
                measurer.w(placementScope, list);
            }
        }, 4, null);
    }
}
