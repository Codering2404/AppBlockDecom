package androidx.compose.ui.layout;

import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.LookaheadDelegate;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.NodeMeasuringIntrinsics;
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
public interface ApproachLayoutModifierNode extends LayoutModifierNode {
    default int B1(ApproachIntrinsicMeasureScope approachIntrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i3) {
        NodeCoordinator coordinator$ui_release = getNode().getCoordinator$ui_release();
        Intrinsics.checkNotNull(coordinator$ui_release);
        LookaheadDelegate lookaheadDelegateS2 = coordinator$ui_release.S2();
        Intrinsics.checkNotNull(lookaheadDelegateS2);
        return lookaheadDelegateS2.w1() ? NodeMeasuringIntrinsics.f27589a.e(new NodeMeasuringIntrinsics.ApproachMeasureBlock() { // from class: androidx.compose.ui.layout.ApproachLayoutModifierNode$minApproachIntrinsicHeight$1
            @Override // androidx.compose.ui.node.NodeMeasuringIntrinsics.ApproachMeasureBlock
            public final MeasureResult a(ApproachMeasureScope approachMeasureScope, Measurable measurable, long j3) {
                return this.f27027a.N0(approachMeasureScope, measurable, j3);
            }
        }, approachIntrinsicMeasureScope, intrinsicMeasurable, i3) : intrinsicMeasurable.d0(i3);
    }

    default int I0(ApproachIntrinsicMeasureScope approachIntrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i3) {
        NodeCoordinator coordinator$ui_release = getNode().getCoordinator$ui_release();
        Intrinsics.checkNotNull(coordinator$ui_release);
        LookaheadDelegate lookaheadDelegateS2 = coordinator$ui_release.S2();
        Intrinsics.checkNotNull(lookaheadDelegateS2);
        return lookaheadDelegateS2.w1() ? NodeMeasuringIntrinsics.f27589a.g(new NodeMeasuringIntrinsics.ApproachMeasureBlock() { // from class: androidx.compose.ui.layout.ApproachLayoutModifierNode$minApproachIntrinsicWidth$1
            @Override // androidx.compose.ui.node.NodeMeasuringIntrinsics.ApproachMeasureBlock
            public final MeasureResult a(ApproachMeasureScope approachMeasureScope, Measurable measurable, long j3) {
                return this.f27028a.N0(approachMeasureScope, measurable, j3);
            }
        }, approachIntrinsicMeasureScope, intrinsicMeasurable, i3) : intrinsicMeasurable.k0(i3);
    }

    MeasureResult N0(ApproachMeasureScope approachMeasureScope, Measurable measurable, long j3);

    boolean S0(long j3);

    default int j1(ApproachIntrinsicMeasureScope approachIntrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i3) {
        NodeCoordinator coordinator$ui_release = getNode().getCoordinator$ui_release();
        Intrinsics.checkNotNull(coordinator$ui_release);
        LookaheadDelegate lookaheadDelegateS2 = coordinator$ui_release.S2();
        Intrinsics.checkNotNull(lookaheadDelegateS2);
        return lookaheadDelegateS2.w1() ? NodeMeasuringIntrinsics.f27589a.c(new NodeMeasuringIntrinsics.ApproachMeasureBlock() { // from class: androidx.compose.ui.layout.ApproachLayoutModifierNode$maxApproachIntrinsicWidth$1
            @Override // androidx.compose.ui.node.NodeMeasuringIntrinsics.ApproachMeasureBlock
            public final MeasureResult a(ApproachMeasureScope approachMeasureScope, Measurable measurable, long j3) {
                return this.f27025a.N0(approachMeasureScope, measurable, j3);
            }
        }, approachIntrinsicMeasureScope, intrinsicMeasurable, i3) : intrinsicMeasurable.l0(i3);
    }

    default boolean k2(Placeable.PlacementScope placementScope, LayoutCoordinates layoutCoordinates) {
        return false;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    default MeasureResult mo11measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j3) {
        final Placeable placeableN0 = measurable.n0(j3);
        return MeasureScope.B0(measureScope, placeableN0.X0(), placeableN0.O0(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.ui.layout.ApproachLayoutModifierNode$measure$1$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Placeable.PlacementScope) obj);
                return Unit.f139807a;
            }

            public final void invoke(Placeable.PlacementScope placementScope) {
                Placeable.PlacementScope.i(placementScope, placeableN0, 0, 0, 0.0f, 4, null);
            }
        }, 4, null);
    }

    default int n1(ApproachIntrinsicMeasureScope approachIntrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i3) {
        NodeCoordinator coordinator$ui_release = getNode().getCoordinator$ui_release();
        Intrinsics.checkNotNull(coordinator$ui_release);
        LookaheadDelegate lookaheadDelegateS2 = coordinator$ui_release.S2();
        Intrinsics.checkNotNull(lookaheadDelegateS2);
        return lookaheadDelegateS2.w1() ? NodeMeasuringIntrinsics.f27589a.a(new NodeMeasuringIntrinsics.ApproachMeasureBlock() { // from class: androidx.compose.ui.layout.ApproachLayoutModifierNode$maxApproachIntrinsicHeight$1
            @Override // androidx.compose.ui.node.NodeMeasuringIntrinsics.ApproachMeasureBlock
            public final MeasureResult a(ApproachMeasureScope approachMeasureScope, Measurable measurable, long j3) {
                return this.f27024a.N0(approachMeasureScope, measurable, j3);
            }
        }, approachIntrinsicMeasureScope, intrinsicMeasurable, i3) : intrinsicMeasurable.I(i3);
    }
}
