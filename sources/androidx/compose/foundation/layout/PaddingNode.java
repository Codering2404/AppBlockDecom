package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.ConstraintsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
final class PaddingNode extends Modifier.Node implements LayoutModifierNode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f7056a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f7057b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f7058c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f7059d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f7060f;

    public /* synthetic */ PaddingNode(float f3, float f4, float f5, float f6, boolean z2, DefaultConstructorMarker defaultConstructorMarker) {
        this(f3, f4, f5, f6, z2);
    }

    public final boolean m2() {
        return this.f7060f;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo11measure3p2s80s(final MeasureScope measureScope, Measurable measurable, long j3) {
        int iZ0 = measureScope.z0(this.f7056a) + measureScope.z0(this.f7058c);
        int iZ02 = measureScope.z0(this.f7057b) + measureScope.z0(this.f7059d);
        final Placeable placeableN0 = measurable.n0(ConstraintsKt.i(j3, -iZ0, -iZ02));
        return MeasureScope.B0(measureScope, ConstraintsKt.g(j3, placeableN0.X0() + iZ0), ConstraintsKt.f(j3, placeableN0.O0() + iZ02), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.PaddingNode$measure$1
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
                if (this.f7061a.m2()) {
                    Placeable.PlacementScope.m(placementScope, placeableN0, measureScope.z0(this.f7061a.n2()), measureScope.z0(this.f7061a.o2()), 0.0f, 4, null);
                } else {
                    Placeable.PlacementScope.i(placementScope, placeableN0, measureScope.z0(this.f7061a.n2()), measureScope.z0(this.f7061a.o2()), 0.0f, 4, null);
                }
            }
        }, 4, null);
    }

    public final float n2() {
        return this.f7056a;
    }

    public final float o2() {
        return this.f7057b;
    }

    public final void p2(float f3) {
        this.f7059d = f3;
    }

    public final void q2(float f3) {
        this.f7058c = f3;
    }

    public final void r2(boolean z2) {
        this.f7060f = z2;
    }

    public final void s2(float f3) {
        this.f7056a = f3;
    }

    public final void t2(float f3) {
        this.f7057b = f3;
    }

    private PaddingNode(float f3, float f4, float f5, float f6, boolean z2) {
        this.f7056a = f3;
        this.f7057b = f4;
        this.f7058c = f5;
        this.f7059d = f6;
        this.f7060f = z2;
    }
}
