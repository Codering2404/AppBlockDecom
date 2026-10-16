package com.revenuecat.purchases.ui.revenuecatui.components.timeline;

import androidx.compose.ui.unit.Dp;
import com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentState;
import com.revenuecat.purchases.ui.revenuecatui.extensions.SizeConstraintExtensionsKt;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
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
final class TimelineComponentViewKt$TimelineComponentView$2$biggestIconWidth$2$1 extends Lambda implements Function0<Dp> {
    final /* synthetic */ TimelineComponentState $timelineState;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TimelineComponentViewKt$TimelineComponentView$2$biggestIconWidth$2$1(TimelineComponentState timelineComponentState) {
        super(0);
        this.$timelineState = timelineComponentState;
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke-lTKBWiU, reason: not valid java name and merged with bridge method [inline-methods] */
    public final Dp invoke() {
        Iterator it = this.$timelineState.getItems().iterator();
        if (!it.hasNext()) {
            return null;
        }
        Dp dpDpOrNull = SizeConstraintExtensionsKt.dpOrNull(((TimelineComponentState.ItemState) it.next()).getIcon().getSize().getWidth());
        Dp dpD = Dp.d(dpDpOrNull != null ? dpDpOrNull.l() : Dp.g(0));
        while (it.hasNext()) {
            Dp dpDpOrNull2 = SizeConstraintExtensionsKt.dpOrNull(((TimelineComponentState.ItemState) it.next()).getIcon().getSize().getWidth());
            Dp dpD2 = Dp.d(dpDpOrNull2 != null ? dpDpOrNull2.l() : Dp.g(0));
            if (dpD.compareTo(dpD2) < 0) {
                dpD = dpD2;
            }
        }
        return dpD;
    }
}
