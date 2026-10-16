package cz.mobilesoft.coreblock.activity.rating;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.IconKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.unit.Dp;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.view.compose.material3.RatingGraphMarkerKt;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
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
public final class ComposableSingletons$RatingFlowScreenKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComposableSingletons$RatingFlowScreenKt f95973a = new ComposableSingletons$RatingFlowScreenKt();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Function2 f95974b = ComposableLambdaKt.c(-1843436722, false, new Function2() { // from class: cz.mobilesoft.coreblock.activity.rating.c
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$RatingFlowScreenKt.n((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Function2 f95975c = ComposableLambdaKt.c(-131862604, false, new Function2() { // from class: cz.mobilesoft.coreblock.activity.rating.d
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$RatingFlowScreenKt.m((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Function2 f95976d = ComposableLambdaKt.c(735931983, false, new Function2() { // from class: cz.mobilesoft.coreblock.activity.rating.e
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$RatingFlowScreenKt.l((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Function2 f95977e = ComposableLambdaKt.c(-2109401839, false, new Function2() { // from class: cz.mobilesoft.coreblock.activity.rating.f
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$RatingFlowScreenKt.o((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Function2 f95978f = ComposableLambdaKt.c(1054540878, false, new Function2() { // from class: cz.mobilesoft.coreblock.activity.rating.g
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$RatingFlowScreenKt.j((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1054540878, i3, -1, "cz.mobilesoft.coreblock.activity.rating.ComposableSingletons$RatingFlowScreenKt.lambda$1054540878.<anonymous> (RatingFlowScreen.kt:588)");
            }
            Object objG = composer.G();
            if (objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.activity.rating.i
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$RatingFlowScreenKt.k((RatingFlowEvent) obj);
                    }
                };
                composer.w(objG);
            }
            RatingFlowScreenKt.M((Function1) objG, composer, 6);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(RatingFlowEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(735931983, i3, -1, "cz.mobilesoft.coreblock.activity.rating.ComposableSingletons$RatingFlowScreenKt.lambda$735931983.<anonymous> (RatingFlowScreen.kt:269)");
            }
            String upperCase = StringResources_androidKt.b(R.string.De, composer, 0).toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            RatingGraphMarkerKt.c(upperCase, null, ComposeColorsKt.j(composer, 0).b(), 0L, null, f95975c, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, 0.0f, composer, 196608, 0, 32730);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-131862604, i3, -1, "cz.mobilesoft.coreblock.activity.rating.ComposableSingletons$RatingFlowScreenKt.lambda$-131862604.<anonymous> (RatingFlowScreen.kt:273)");
            }
            IconKt.d(VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.A0, composer, 6), null, SizeKt.v(Modifier.b8, Dp.g(16)), Color.f25715b.l(), composer, 3504, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1843436722, i3, -1, "cz.mobilesoft.coreblock.activity.rating.ComposableSingletons$RatingFlowScreenKt.lambda$-1843436722.<anonymous> (RatingFlowScreen.kt:263)");
            }
            String upperCase = StringResources_androidKt.b(R.string.xl, composer, 0).toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            RatingGraphMarkerKt.c(upperCase, null, ComposeColorsKt.j(composer, 0).c0(), 0L, null, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, 0.0f, composer, 0, 0, 32762);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-2109401839, i3, -1, "cz.mobilesoft.coreblock.activity.rating.ComposableSingletons$RatingFlowScreenKt.lambda$-2109401839.<anonymous> (RatingFlowScreen.kt:576)");
            }
            Object objG = composer.G();
            if (objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.activity.rating.h
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposableSingletons$RatingFlowScreenKt.p();
                    }
                };
                composer.w(objG);
            }
            RatingFlowScreenKt.G("2h 10m", "1h 12m", (Function0) objG, composer, 438, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p() {
        return Unit.f139807a;
    }

    public final Function2 h() {
        return f95974b;
    }

    public final Function2 i() {
        return f95976d;
    }
}
