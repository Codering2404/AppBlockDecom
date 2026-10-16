package com.revenuecat.purchases.ui.revenuecatui.components.timeline;

import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.compose.ConstrainScope;
import androidx.constraintlayout.compose.ConstrainedLayoutReference;
import androidx.constraintlayout.compose.Dimension;
import androidx.constraintlayout.compose.HorizontalAnchorable;
import androidx.constraintlayout.compose.VerticalAnchorable;
import com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentState;
import kotlin.Metadata;
import kotlin.Pair;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
final class TimelineComponentViewKt$TimelineComponentView$2$6$1$1 extends Lambda implements Function1<ConstrainScope, Unit> {
    final /* synthetic */ ConstrainedLayoutReference $currentIconRef;
    final /* synthetic */ boolean $isLastItem;
    final /* synthetic */ TimelineComponentState.ItemState $item;
    final /* synthetic */ ConstrainedLayoutReference $nextIconRef;
    final /* synthetic */ float $nextItemIconHalfSize;
    final /* synthetic */ Pair<Dp, Dp> $offsets;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TimelineComponentViewKt$TimelineComponentView$2$6$1$1(Pair<Dp, Dp> pair, TimelineComponentState.ItemState itemState, ConstrainedLayoutReference constrainedLayoutReference, boolean z2, ConstrainedLayoutReference constrainedLayoutReference2, float f3) {
        super(1);
        this.$offsets = pair;
        this.$item = itemState;
        this.$currentIconRef = constrainedLayoutReference;
        this.$isLastItem = z2;
        this.$nextIconRef = constrainedLayoutReference2;
        this.$nextItemIconHalfSize = f3;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ConstrainScope) obj);
        return Unit.f139807a;
    }

    public final void invoke(ConstrainScope constrainAs) {
        Intrinsics.checkNotNullParameter(constrainAs, "$this$constrainAs");
        VerticalAnchorable.b(constrainAs.g(), constrainAs.f().d(), ((Dp) this.$offsets.e()).l(), 0.0f, 4, null);
        Dimension.Companion companion = Dimension.f30535a;
        constrainAs.m(companion.d(Dp.g(this.$item.getConnector() != null ? r1.getWidth() : 0)));
        HorizontalAnchorable.a(constrainAs.h(), this.$currentIconRef.e(), 0.0f, 0.0f, 6, null);
        if (this.$isLastItem) {
            HorizontalAnchorable.a(constrainAs.c(), constrainAs.f().b(), ((Dp) this.$offsets.f()).l(), 0.0f, 4, null);
        } else {
            HorizontalAnchorable horizontalAnchorableC = constrainAs.c();
            ConstrainedLayoutReference constrainedLayoutReference = this.$nextIconRef;
            Intrinsics.checkNotNull(constrainedLayoutReference);
            HorizontalAnchorable.a(horizontalAnchorableC, constrainedLayoutReference.b(), Dp.g(this.$nextItemIconHalfSize + ((Dp) this.$offsets.f()).l()), 0.0f, 4, null);
        }
        constrainAs.k(companion.a());
    }
}
