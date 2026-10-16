package cz.mobilesoft.coreblock.view.compose;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
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
public final class ComposableSingletons$ComposeCardsKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComposableSingletons$ComposeCardsKt f130364a = new ComposableSingletons$ComposeCardsKt();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Function2 f130365b = ComposableLambdaKt.c(-225152737, false, new Function2() { // from class: cz.mobilesoft.coreblock.view.compose.u
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$ComposeCardsKt.i((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Function2 f130366c = ComposableLambdaKt.c(-1289997104, false, new Function2() { // from class: cz.mobilesoft.coreblock.view.compose.v
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$ComposeCardsKt.h((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Function2 f130367d = ComposableLambdaKt.c(-966992377, false, new Function2() { // from class: cz.mobilesoft.coreblock.view.compose.w
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$ComposeCardsKt.m((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Function2 f130368e = ComposableLambdaKt.c(-785259128, false, new Function2() { // from class: cz.mobilesoft.coreblock.view.compose.x
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$ComposeCardsKt.l((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Function2 f130369f = ComposableLambdaKt.c(-603525879, false, new Function2() { // from class: cz.mobilesoft.coreblock.view.compose.y
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$ComposeCardsKt.k((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static Function2 f130370g = ComposableLambdaKt.c(-421792630, false, new Function2() { // from class: cz.mobilesoft.coreblock.view.compose.z
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$ComposeCardsKt.j((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1289997104, i3, -1, "cz.mobilesoft.coreblock.view.compose.ComposableSingletons$ComposeCardsKt.lambda$-1289997104.<anonymous> (ComposeCards.kt:344)");
            }
            androidx.compose.material.TextKt.c("Surface card", PaddingKt.i(Modifier.b8, Dp.g(16)), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).a(), composer, 54, 0, 65532);
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
                ComposerKt.U(-225152737, i3, -1, "cz.mobilesoft.coreblock.view.compose.ComposableSingletons$ComposeCardsKt.lambda$-225152737.<anonymous> (ComposeCards.kt:73)");
            }
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
                ComposerKt.U(-421792630, i3, -1, "cz.mobilesoft.coreblock.view.compose.ComposableSingletons$ComposeCardsKt.lambda$-421792630.<anonymous> (ComposeCards.kt:381)");
            }
            androidx.compose.material.TextKt.c("Custom-colored card", PaddingKt.i(Modifier.b8, Dp.g(16)), ComposeColorsKt.j(composer, 0).p(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).a(), composer, 54, 0, 65528);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-603525879, i3, -1, "cz.mobilesoft.coreblock.view.compose.ComposableSingletons$ComposeCardsKt.lambda$-603525879.<anonymous> (ComposeCards.kt:368)");
            }
            androidx.compose.material.TextKt.c("Dashed card", PaddingKt.i(Modifier.b8, Dp.g(16)), ComposeColorsKt.j(composer, 0).p(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).a(), composer, 54, 0, 65528);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-785259128, i3, -1, "cz.mobilesoft.coreblock.view.compose.ComposableSingletons$ComposeCardsKt.lambda$-785259128.<anonymous> (ComposeCards.kt:360)");
            }
            androidx.compose.material.TextKt.c("Critical card", PaddingKt.i(Modifier.b8, Dp.g(16)), ComposeColorsKt.j(composer, 0).l0(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).a(), composer, 54, 0, 65528);
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
                ComposerKt.U(-966992377, i3, -1, "cz.mobilesoft.coreblock.view.compose.ComposableSingletons$ComposeCardsKt.lambda$-966992377.<anonymous> (ComposeCards.kt:352)");
            }
            androidx.compose.material.TextKt.c("Disabled card", PaddingKt.i(Modifier.b8, Dp.g(16)), ComposeColorsKt.j(composer, 0).s(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).a(), composer, 54, 0, 65528);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    public final Function2 g() {
        return f130365b;
    }
}
