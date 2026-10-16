package cz.mobilesoft.coreblock.scene.insights;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class ComposableSingletons$InsightsScreenDistractionsKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComposableSingletons$InsightsScreenDistractionsKt f102577a = new ComposableSingletons$InsightsScreenDistractionsKt();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Function3 f102578b = ComposableLambdaKt.c(-96890977, false, new Function3() { // from class: cz.mobilesoft.coreblock.scene.insights.x
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$InsightsScreenDistractionsKt.c((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c(LazyItemScope item, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-96890977, i3, -1, "cz.mobilesoft.coreblock.scene.insights.ComposableSingletons$InsightsScreenDistractionsKt.lambda$-96890977.<anonymous> (InsightsScreenDistractions.kt:26)");
            }
            Modifier.Companion companion = Modifier.b8;
            float f3 = 16;
            SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composer, 6);
            TextKt.c(StringResources_androidKt.b(R.string.Kg, composer, 0), PaddingKt.k(companion, Dp.g(f3), 0.0f, 2, null), ComposeColorsKt.j(composer, 0).p(), 0L, null, null, null, 0L, null, TextAlign.h(TextAlign.f29616b.f()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).g(), composer, 48, 0, 65016);
            SpacerKt.a(SizeKt.i(companion, Dp.g(8)), composer, 6);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    public final Function3 b() {
        return f102578b;
    }
}
