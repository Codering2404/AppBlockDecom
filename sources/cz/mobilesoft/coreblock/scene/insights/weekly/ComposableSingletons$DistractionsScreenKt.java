package cz.mobilesoft.coreblock.scene.insights.weekly;

import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.unit.Dp;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.view.compose.IconCircleBackgroundKt;
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
public final class ComposableSingletons$DistractionsScreenKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComposableSingletons$DistractionsScreenKt f103872a = new ComposableSingletons$DistractionsScreenKt();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Function3 f103873b = ComposableLambdaKt.c(1158174306, false, new Function3() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.t
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$DistractionsScreenKt.c((BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c(BoxScope AppIcon, Composer composer, int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(AppIcon, "$this$AppIcon");
        if ((i3 & 6) == 0) {
            i4 = (composer.Z(AppIcon) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1158174306, i4, -1, "cz.mobilesoft.coreblock.scene.insights.weekly.ComposableSingletons$DistractionsScreenKt.lambda$1158174306.<anonymous> (DistractionsScreen.kt:267)");
            }
            IconCircleBackgroundKt.c(AppIcon.f(ClipKt.a(Modifier.b8, RoundedCornerShapeKt.g()), Alignment.f25072a.c()), Dp.g(24), Dp.g(4), VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.f95554q0, composer, 6), ComposeColorsKt.j(composer, 0).b(), ComposeColorsKt.j(composer, 0).X(), null, composer, 432, 64);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    public final Function3 b() {
        return f103873b;
    }
}
