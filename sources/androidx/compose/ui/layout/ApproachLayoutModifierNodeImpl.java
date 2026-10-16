package androidx.compose.ui.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

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
final class ApproachLayoutModifierNodeImpl extends Modifier.Node implements ApproachLayoutModifierNode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Function3 f27029a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Function1 f27030b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Function2 f27031c;

    public ApproachLayoutModifierNodeImpl(Function3 function3, Function1 function1, Function2 function2) {
        this.f27029a = function3;
        this.f27030b = function1;
        this.f27031c = function2;
    }

    @Override // androidx.compose.ui.layout.ApproachLayoutModifierNode
    public MeasureResult N0(ApproachMeasureScope approachMeasureScope, Measurable measurable, long j3) {
        return (MeasureResult) this.f27029a.invoke(approachMeasureScope, measurable, Constraints.a(j3));
    }

    @Override // androidx.compose.ui.layout.ApproachLayoutModifierNode
    public boolean S0(long j3) {
        return ((Boolean) this.f27030b.invoke(IntSize.b(j3))).booleanValue();
    }

    @Override // androidx.compose.ui.layout.ApproachLayoutModifierNode
    public boolean k2(Placeable.PlacementScope placementScope, LayoutCoordinates layoutCoordinates) {
        return ((Boolean) this.f27031c.invoke(placementScope, layoutCoordinates)).booleanValue();
    }

    public final void m2(Function3 function3) {
        this.f27029a = function3;
    }

    public final void n2(Function1 function1) {
        this.f27030b = function1;
    }

    public final void o2(Function2 function2) {
        this.f27031c = function2;
    }
}
