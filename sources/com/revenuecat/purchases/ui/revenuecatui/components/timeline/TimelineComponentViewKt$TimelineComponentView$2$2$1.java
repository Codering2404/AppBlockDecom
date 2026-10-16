package com.revenuecat.purchases.ui.revenuecatui.components.timeline;

import androidx.compose.runtime.State;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.compose.ConstrainScope;
import androidx.constraintlayout.compose.ConstrainedLayoutReference;
import androidx.constraintlayout.compose.ConstraintLayoutBaseScope;
import com.revenuecat.purchases.paywalls.components.TimelineComponent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
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
final class TimelineComponentViewKt$TimelineComponentView$2$2$1 extends Lambda implements Function1<ConstrainScope, Unit> {
    final /* synthetic */ State<Dp> $biggestIconWidth$delegate;
    final /* synthetic */ ConstraintLayoutBaseScope.HorizontalAnchor $currentPreviousItem;
    final /* synthetic */ ConstrainedLayoutReference $descriptionRef;
    final /* synthetic */ TimelineComponentState $timelineState;
    final /* synthetic */ ConstrainedLayoutReference $titleRef;

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
    TimelineComponentViewKt$TimelineComponentView$2$2$1(TimelineComponentState timelineComponentState, ConstraintLayoutBaseScope.HorizontalAnchor horizontalAnchor, ConstrainedLayoutReference constrainedLayoutReference, ConstrainedLayoutReference constrainedLayoutReference2, State<Dp> state) {
        super(1);
        this.$timelineState = timelineComponentState;
        this.$currentPreviousItem = horizontalAnchor;
        this.$titleRef = constrainedLayoutReference;
        this.$descriptionRef = constrainedLayoutReference2;
        this.$biggestIconWidth$delegate = state;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ConstrainScope) obj);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x008f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void invoke(androidx.constraintlayout.compose.ConstrainScope r15) {
        /*
            r14 = this;
            java.lang.String r0 = "$this$constrainAs"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentState r0 = r14.$timelineState
            com.revenuecat.purchases.paywalls.components.TimelineComponent$IconAlignment r0 = r0.getIconAlignment()
            int[] r1 = com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentViewKt$TimelineComponentView$2$2$1.WhenMappings.$EnumSwitchMapping$0
            int r0 = r0.ordinal()
            r0 = r1[r0]
            r1 = 1
            if (r0 == r1) goto L50
            r1 = 2
            if (r0 == r1) goto L1a
            goto L7b
        L1a:
            androidx.constraintlayout.compose.HorizontalAnchorable r2 = r15.h()
            androidx.constraintlayout.compose.ConstrainedLayoutReference r0 = r14.$titleRef
            androidx.constraintlayout.compose.ConstraintLayoutBaseScope$HorizontalAnchor r3 = r0.e()
            r6 = 6
            r7 = 0
            r4 = 0
            r5 = 0
            androidx.constraintlayout.compose.HorizontalAnchorable.a(r2, r3, r4, r5, r6, r7)
            androidx.constraintlayout.compose.HorizontalAnchorable r8 = r15.c()
            androidx.constraintlayout.compose.ConstrainedLayoutReference r0 = r14.$descriptionRef
            androidx.constraintlayout.compose.ConstraintLayoutBaseScope$HorizontalAnchor r9 = r0.b()
            r12 = 6
            r13 = 0
            r10 = 0
            r11 = 0
            androidx.constraintlayout.compose.HorizontalAnchorable.a(r8, r9, r10, r11, r12, r13)
            androidx.constraintlayout.compose.VerticalAnchorable r0 = r15.g()
            androidx.constraintlayout.compose.ConstrainedLayoutReference r1 = r15.f()
            androidx.constraintlayout.compose.ConstraintLayoutBaseScope$VerticalAnchor r1 = r1.d()
            r4 = 6
            r5 = 0
            r2 = 0
            r3 = 0
            androidx.constraintlayout.compose.VerticalAnchorable.b(r0, r1, r2, r3, r4, r5)
            goto L7b
        L50:
            androidx.constraintlayout.compose.HorizontalAnchorable r6 = r15.h()
            androidx.constraintlayout.compose.ConstraintLayoutBaseScope$HorizontalAnchor r0 = r14.$currentPreviousItem
            if (r0 != 0) goto L60
            androidx.constraintlayout.compose.ConstrainedLayoutReference r0 = r15.f()
            androidx.constraintlayout.compose.ConstraintLayoutBaseScope$HorizontalAnchor r0 = r0.e()
        L60:
            r7 = r0
            r10 = 6
            r11 = 0
            r8 = 0
            r9 = 0
            androidx.constraintlayout.compose.HorizontalAnchorable.a(r6, r7, r8, r9, r10, r11)
            androidx.constraintlayout.compose.VerticalAnchorable r0 = r15.g()
            androidx.constraintlayout.compose.ConstrainedLayoutReference r1 = r15.f()
            androidx.constraintlayout.compose.ConstraintLayoutBaseScope$VerticalAnchor r1 = r1.d()
            r4 = 6
            r5 = 0
            r2 = 0
            r3 = 0
            androidx.constraintlayout.compose.VerticalAnchorable.b(r0, r1, r2, r3, r4, r5)
        L7b:
            androidx.compose.runtime.State<androidx.compose.ui.unit.Dp> r0 = r14.$biggestIconWidth$delegate
            androidx.compose.ui.unit.Dp r0 = com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentViewKt.access$TimelineComponentView$lambda$13$lambda$1(r0)
            if (r0 == 0) goto L8f
            float r0 = r0.l()
            androidx.constraintlayout.compose.Dimension$Companion r1 = androidx.constraintlayout.compose.Dimension.f30535a
            androidx.constraintlayout.compose.Dimension r0 = r1.d(r0)
            if (r0 != 0) goto L95
        L8f:
            androidx.constraintlayout.compose.Dimension$Companion r0 = androidx.constraintlayout.compose.Dimension.f30535a
            androidx.constraintlayout.compose.Dimension r0 = r0.c()
        L95:
            r15.m(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentViewKt$TimelineComponentView$2$2$1.invoke(androidx.constraintlayout.compose.ConstrainScope):void");
    }
}
