package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.LayoutModifierNodeKt;
import androidx.compose.ui.unit.Dp;
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
final class OffsetNode extends Modifier.Node implements LayoutModifierNode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f7021a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f7022b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f7023c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f7024d;

    public /* synthetic */ OffsetNode(float f3, float f4, boolean z2, DefaultConstructorMarker defaultConstructorMarker) {
        this(f3, f4, z2);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public boolean getShouldAutoInvalidate() {
        return this.f7024d;
    }

    public final boolean m2() {
        return this.f7023c;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo11measure3p2s80s(final MeasureScope measureScope, Measurable measurable, long j3) {
        final Placeable placeableN0 = measurable.n0(j3);
        return MeasureScope.B0(measureScope, placeableN0.X0(), placeableN0.O0(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.OffsetNode$measure$1
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
                if (this.f7025a.m2()) {
                    Placeable.PlacementScope.m(placementScope, placeableN0, measureScope.z0(this.f7025a.n2()), measureScope.z0(this.f7025a.o2()), 0.0f, 4, null);
                } else {
                    Placeable.PlacementScope.i(placementScope, placeableN0, measureScope.z0(this.f7025a.n2()), measureScope.z0(this.f7025a.o2()), 0.0f, 4, null);
                }
            }
        }, 4, null);
    }

    public final float n2() {
        return this.f7021a;
    }

    public final float o2() {
        return this.f7022b;
    }

    public final void p2(float f3, float f4, boolean z2) {
        if (!Dp.i(this.f7021a, f3) || !Dp.i(this.f7022b, f4) || this.f7023c != z2) {
            LayoutModifierNodeKt.c(this);
        }
        this.f7021a = f3;
        this.f7022b = f4;
        this.f7023c = z2;
    }

    private OffsetNode(float f3, float f4, boolean z2) {
        this.f7021a = f3;
        this.f7022b = f4;
        this.f7023c = z2;
    }
}
