package com.revenuecat.purchases.ui.revenuecatui.components.timeline;

import androidx.constraintlayout.compose.ConstrainScope;
import androidx.constraintlayout.compose.ConstrainedLayoutReference;
import androidx.constraintlayout.compose.ConstraintLayoutBaseScope;
import androidx.constraintlayout.compose.Dimension;
import androidx.constraintlayout.compose.HorizontalAnchorable;
import androidx.constraintlayout.compose.VerticalAnchorable;
import com.revenuecat.purchases.paywalls.components.TimelineComponent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
final class TimelineComponentViewKt$TimelineComponentView$2$4$1 extends Lambda implements Function1<ConstrainScope, Unit> {
    final /* synthetic */ ConstraintLayoutBaseScope.HorizontalAnchor $currentPreviousItem;
    final /* synthetic */ ConstraintLayoutBaseScope.VerticalAnchor $iconEndBarrier;
    final /* synthetic */ ConstrainedLayoutReference $iconRef;
    final /* synthetic */ TimelineComponentState $timelineState;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TimelineComponent.IconAlignment.values().length];
            try {
                iArr[TimelineComponent.IconAlignment.Title.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TimelineComponent.IconAlignment.TitleAndDescription.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TimelineComponentViewKt$TimelineComponentView$2$4$1(TimelineComponentState timelineComponentState, ConstrainedLayoutReference constrainedLayoutReference, ConstraintLayoutBaseScope.HorizontalAnchor horizontalAnchor, ConstraintLayoutBaseScope.VerticalAnchor verticalAnchor) {
        super(1);
        this.$timelineState = timelineComponentState;
        this.$iconRef = constrainedLayoutReference;
        this.$currentPreviousItem = horizontalAnchor;
        this.$iconEndBarrier = verticalAnchor;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ConstrainScope) obj);
        return Unit.f139807a;
    }

    public final void invoke(ConstrainScope constrainAs) {
        Intrinsics.checkNotNullParameter(constrainAs, "$this$constrainAs");
        int i3 = WhenMappings.$EnumSwitchMapping$0[this.$timelineState.getIconAlignment().ordinal()];
        if (i3 == 1) {
            ConstrainScope.b(constrainAs, this.$iconRef, 0.0f, 2, null);
        } else if (i3 == 2) {
            HorizontalAnchorable horizontalAnchorableH = constrainAs.h();
            ConstraintLayoutBaseScope.HorizontalAnchor horizontalAnchorE = this.$currentPreviousItem;
            if (horizontalAnchorE == null) {
                horizontalAnchorE = constrainAs.f().e();
            }
            HorizontalAnchorable.a(horizontalAnchorableH, horizontalAnchorE, 0.0f, 0.0f, 6, null);
        }
        VerticalAnchorable.b(constrainAs.g(), this.$iconEndBarrier, 0.0f, 0.0f, 6, null);
        VerticalAnchorable.b(constrainAs.e(), constrainAs.f().c(), 0.0f, 0.0f, 6, null);
        Dimension.Companion companion = Dimension.f30535a;
        constrainAs.m(companion.b());
        constrainAs.k(companion.b());
        constrainAs.l(0.0f);
    }
}
