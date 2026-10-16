package com.revenuecat.purchases.ui.revenuecatui.components.text;

import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.text.TextStyle;
import com.revenuecat.purchases.paywalls.components.properties.FontWeight;
import com.revenuecat.purchases.ui.revenuecatui.components.PreviewHelpersKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyles;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

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
public final class ComposableSingletons$TextComponentViewKt {
    public static final ComposableSingletons$TextComponentViewKt INSTANCE = new ComposableSingletons$TextComponentViewKt();

    /* JADX INFO: renamed from: lambda-1, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f10lambda1 = ComposableLambdaKt.c(765510784, false, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.text.ComposableSingletons$TextComponentViewKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return Unit.f139807a;
        }

        public final void invoke(Composer composer, int i3) {
            if ((i3 & 3) == 2 && composer.l()) {
                composer.Q();
                return;
            }
            if (ComposerKt.M()) {
                ComposerKt.U(765510784, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.text.ComposableSingletons$TextComponentViewKt.lambda-1.<anonymous> (TextComponentView.kt:206)");
            }
            TextComponentViewKt.TextComponentView(PreviewHelpersKt.previewTextComponentStyle$default("Experience Pro today!", new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(Color.f25715b.a())), null, 2, null), 34, FontWeight.EXTRA_BOLD, null, null, null, null, false, null, null, null, null, null, null, null, 65520, null), PreviewHelpersKt.previewEmptyState(null, composer, 0, 1), null, null, composer, 0, 12);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-2, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f11lambda2 = ComposableLambdaKt.c(55915153, false, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.text.ComposableSingletons$TextComponentViewKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return Unit.f139807a;
        }

        public final void invoke(Composer composer, int i3) {
            if ((i3 & 3) == 2 && composer.l()) {
                composer.Q();
                return;
            }
            if (ComposerKt.M()) {
                ComposerKt.U(55915153, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.text.ComposableSingletons$TextComponentViewKt.lambda-2.<anonymous> (TextComponentView.kt:205)");
            }
            TextKt.a(TextStyle.e((TextStyle) composer.q(TextKt.f()), Color.f25715b.b(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), ComposableSingletons$TextComponentViewKt.INSTANCE.m846getLambda1$revenuecatui_defaultsBc8Release(), composer, 48);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
    });

    /* JADX INFO: renamed from: getLambda-1$revenuecatui_defaultsBc8Release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m846getLambda1$revenuecatui_defaultsBc8Release() {
        return f10lambda1;
    }

    /* JADX INFO: renamed from: getLambda-2$revenuecatui_defaultsBc8Release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m847getLambda2$revenuecatui_defaultsBc8Release() {
        return f11lambda2;
    }
}
