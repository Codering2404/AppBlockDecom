package cz.mobilesoft.coreblock.view.compose.material3;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.animation.core.RepeatMode;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import com.facebook.ads.AdError;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class ComposableSingletons$RatingGraphPathKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComposableSingletons$RatingGraphPathKt f131150a = new ComposableSingletons$RatingGraphPathKt();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Function2 f131151b = ComposableLambdaKt.c(1314437055, false, new Function2() { // from class: cz.mobilesoft.coreblock.view.compose.material3.f0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$RatingGraphPathKt.f((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Function2 f131152c = ComposableLambdaKt.c(1788993061, false, new Function2() { // from class: cz.mobilesoft.coreblock.view.compose.material3.g0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$RatingGraphPathKt.g((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Function2 f131153d = ComposableLambdaKt.c(2114011584, false, new Function2() { // from class: cz.mobilesoft.coreblock.view.compose.material3.h0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$RatingGraphPathKt.h((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Function2 f131154e = ComposableLambdaKt.c(-1381381183, false, new Function2() { // from class: cz.mobilesoft.coreblock.view.compose.material3.i0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$RatingGraphPathKt.i((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Function2 f131155f = ComposableLambdaKt.c(-687042927, false, new Function2() { // from class: cz.mobilesoft.coreblock.view.compose.material3.j0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$RatingGraphPathKt.j((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1314437055, i3, -1, "cz.mobilesoft.coreblock.view.compose.material3.ComposableSingletons$RatingGraphPathKt.lambda$1314437055.<anonymous> (RatingGraphPath.kt:266)");
            }
            RatingGraphMarkerKt.c(StringResources_androidKt.b(R.string.xl, composer, 0), null, ComposeColorsKt.j(composer, 0).c0(), 0L, null, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, 0.0f, composer, 0, 0, 32762);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1788993061, i3, -1, "cz.mobilesoft.coreblock.view.compose.material3.ComposableSingletons$RatingGraphPathKt.lambda$1788993061.<anonymous> (RatingGraphPath.kt:276)");
            }
            IconKt.c(PainterResources_androidKt.c(R.drawable.A0, composer, 0), null, SizeKt.v(Modifier.b8, Dp.g(16)), Color.f25715b.l(), composer, 3504, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(2114011584, i3, -1, "cz.mobilesoft.coreblock.view.compose.material3.ComposableSingletons$RatingGraphPathKt.lambda$2114011584.<anonymous> (RatingGraphPath.kt:272)");
            }
            RatingGraphMarkerKt.c(StringResources_androidKt.b(R.string.De, composer, 0), null, ComposeColorsKt.j(composer, 0).b(), 0L, null, f131152c, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, 0.0f, composer, 196608, 0, 32730);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1381381183, i3, -1, "cz.mobilesoft.coreblock.view.compose.material3.ComposableSingletons$RatingGraphPathKt.lambda$-1381381183.<anonymous> (RatingGraphPath.kt:286)");
            }
            TextKt.c("4h 20m", null, ComposeColorsKt.j(composer, 0).c0(), 0L, null, null, null, 0L, null, TextAlign.h(TextAlign.f29616b.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).i(), composer, 6, 0, 65018);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-687042927, i3, -1, "cz.mobilesoft.coreblock.view.compose.material3.ComposableSingletons$RatingGraphPathKt.lambda$-687042927.<anonymous> (RatingGraphPath.kt:251)");
            }
            float f3 = 16;
            float f4 = 64;
            RatingGraphPathKt.s(PaddingKt.i(SizeKt.h(Modifier.b8, 0.0f, 1, null), Dp.g(f3)), Dp.g(f4), Dp.g(f4), Dp.g(80), Dp.g(f3), Dp.g(f3), 0.0f, 0.0f, null, AnimationSpecKt.e(AnimationSpecKt.n(AdError.SERVER_ERROR_CODE, 0, null, 6, null), RepeatMode.f4053b, 0L, 4, null), 0.0f, Dp.g(4), f131151b, f131153d, f131154e, null, composer, (InfiniteRepeatableSpec.f3963d << 27) | 224694, 28080, 34240);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }
}
