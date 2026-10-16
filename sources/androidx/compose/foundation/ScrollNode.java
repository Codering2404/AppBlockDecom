package androidx.compose.foundation;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.semantics.ScrollAxisRange;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Constraints;
import com.google.android.gms.common.api.Api;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.RangesKt;

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
public final class ScrollNode extends Modifier.Node implements LayoutModifierNode, SemanticsModifierNode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ScrollState f5124a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f5125b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f5126c;

    public ScrollNode(ScrollState scrollState, boolean z2, boolean z3) {
        this.f5124a = scrollState;
        this.f5125b = z2;
        this.f5126c = z3;
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public void N(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.G0(semanticsPropertyReceiver, true);
        ScrollAxisRange scrollAxisRange = new ScrollAxisRange(new Function0<Float>() { // from class: androidx.compose.foundation.ScrollNode$applySemantics$accessibilityScrollState$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                return Float.valueOf(this.f5127a.n2().n());
            }
        }, new Function0<Float>() { // from class: androidx.compose.foundation.ScrollNode$applySemantics$accessibilityScrollState$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                return Float.valueOf(this.f5128a.n2().m());
            }
        }, this.f5125b);
        if (this.f5126c) {
            SemanticsPropertiesKt.I0(semanticsPropertyReceiver, scrollAxisRange);
        } else {
            SemanticsPropertiesKt.j0(semanticsPropertyReceiver, scrollAxisRange);
        }
    }

    public final boolean m2() {
        return this.f5125b;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i3) {
        if (!this.f5126c) {
            i3 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        }
        return intrinsicMeasurable.I(i3);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i3) {
        if (this.f5126c) {
            i3 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        }
        return intrinsicMeasurable.l0(i3);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo11measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j3) {
        CheckScrollableContainerConstraintsKt.a(j3, this.f5126c ? Orientation.f6031a : Orientation.f6032b);
        boolean z2 = this.f5126c;
        int iL = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        int iK = z2 ? Integer.MAX_VALUE : Constraints.k(j3);
        if (this.f5126c) {
            iL = Constraints.l(j3);
        }
        final Placeable placeableN0 = measurable.n0(Constraints.d(j3, 0, iL, 0, iK, 5, null));
        int iK2 = RangesKt.k(placeableN0.X0(), Constraints.l(j3));
        int iK3 = RangesKt.k(placeableN0.O0(), Constraints.k(j3));
        final int iO0 = placeableN0.O0() - iK3;
        int iX0 = placeableN0.X0() - iK2;
        if (!this.f5126c) {
            iO0 = iX0;
        }
        this.f5124a.o(iO0);
        this.f5124a.q(this.f5126c ? iK3 : iK2);
        return MeasureScope.B0(measureScope, iK2, iK3, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.ScrollNode$measure$1
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
                int iN = this.f5129a.n2().n();
                int i3 = iO0;
                if (iN < 0) {
                    iN = 0;
                }
                if (iN <= i3) {
                    i3 = iN;
                }
                int i4 = this.f5129a.m2() ? i3 - iO0 : -i3;
                final int i5 = this.f5129a.o2() ? 0 : i4;
                final int i6 = this.f5129a.o2() ? i4 : 0;
                final Placeable placeable = placeableN0;
                placementScope.B(new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.ScrollNode$measure$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((Placeable.PlacementScope) obj);
                        return Unit.f139807a;
                    }

                    public final void invoke(Placeable.PlacementScope placementScope2) {
                        Placeable.PlacementScope.q(placementScope2, placeable, i5, i6, 0.0f, null, 12, null);
                    }
                });
            }
        }, 4, null);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i3) {
        if (!this.f5126c) {
            i3 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        }
        return intrinsicMeasurable.d0(i3);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i3) {
        if (this.f5126c) {
            i3 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        }
        return intrinsicMeasurable.k0(i3);
    }

    public final ScrollState n2() {
        return this.f5124a;
    }

    public final boolean o2() {
        return this.f5126c;
    }

    public final void p2(boolean z2) {
        this.f5125b = z2;
    }

    public final void q2(ScrollState scrollState) {
        this.f5124a = scrollState;
    }

    public final void r2(boolean z2) {
        this.f5126c = z2;
    }
}
