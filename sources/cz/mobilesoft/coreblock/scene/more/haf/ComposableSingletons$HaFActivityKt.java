package cz.mobilesoft.coreblock.scene.more.haf;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.material.IconKt;
import androidx.compose.material.ProgressIndicatorKt;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.PrimitiveResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class ComposableSingletons$HaFActivityKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComposableSingletons$HaFActivityKt f107538a = new ComposableSingletons$HaFActivityKt();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Function2 f107539b = ComposableLambdaKt.c(1226449529, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.haf.a
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$HaFActivityKt.q((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Function2 f107540c = ComposableLambdaKt.c(-1971199878, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.haf.b
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$HaFActivityKt.w((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Function3 f107541d = ComposableLambdaKt.c(-1459285420, false, new Function3() { // from class: cz.mobilesoft.coreblock.scene.more.haf.c
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$HaFActivityKt.u((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Function3 f107542e = ComposableLambdaKt.c(-1113027114, false, new Function3() { // from class: cz.mobilesoft.coreblock.scene.more.haf.d
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$HaFActivityKt.t((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Function3 f107543f = ComposableLambdaKt.c(-1507430953, false, new Function3() { // from class: cz.mobilesoft.coreblock.scene.more.haf.e
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$HaFActivityKt.v((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static Function3 f107544g = ComposableLambdaKt.c(1723758549, false, new Function3() { // from class: cz.mobilesoft.coreblock.scene.more.haf.f
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$HaFActivityKt.r((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static Function3 f107545h = ComposableLambdaKt.c(1813962278, false, new Function3() { // from class: cz.mobilesoft.coreblock.scene.more.haf.g
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$HaFActivityKt.s((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static Function2 f107546i = ComposableLambdaKt.c(-837970055, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.haf.h
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$HaFActivityKt.x((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1226449529, i3, -1, "cz.mobilesoft.coreblock.scene.more.haf.ComposableSingletons$HaFActivityKt.lambda$1226449529.<anonymous> (HaFActivity.kt:255)");
            }
            TextKt.c(StringResources_androidKt.b(R.string.Dv, composer, 0), PaddingKt.m(Modifier.b8, 0.0f, Dp.g(4), 0.0f, 0.0f, 13, null), ComposeColorsKt.j(composer, 0).M(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).a(), composer, 48, 0, 65528);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r(LazyItemScope item, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1723758549, i3, -1, "cz.mobilesoft.coreblock.scene.more.haf.ComposableSingletons$HaFActivityKt.lambda$1723758549.<anonymous> (HaFActivity.kt:372)");
            }
            SpacerKt.a(SizeKt.i(Modifier.b8, PrimitiveResources_androidKt.a(R.dimen.f95468b, composer, 0)), composer, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s(LazyItemScope item, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1813962278, i3, -1, "cz.mobilesoft.coreblock.scene.more.haf.ComposableSingletons$HaFActivityKt.lambda$1813962278.<anonymous> (HaFActivity.kt:414)");
            }
            SpacerKt.a(SizeKt.i(Modifier.b8, PrimitiveResources_androidKt.a(R.dimen.f95468b, composer, 0)), composer, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(LazyItemScope item, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1113027114, i3, -1, "cz.mobilesoft.coreblock.scene.more.haf.ComposableSingletons$HaFActivityKt.lambda$-1113027114.<anonymous> (HaFActivity.kt:323)");
            }
            SpacerKt.a(SizeKt.i(Modifier.b8, Dp.g(16)), composer, 6);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u(LazyItemScope item, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1459285420, i3, -1, "cz.mobilesoft.coreblock.scene.more.haf.ComposableSingletons$HaFActivityKt.lambda$-1459285420.<anonymous> (HaFActivity.kt:296)");
            }
            ProgressIndicatorKt.b(SizeKt.I(SizeKt.h(Modifier.b8, 0.0f, 1, null), Alignment.f25072a.g(), false, 2, null), 0L, 0.0f, 0L, 0, composer, 6, 30);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v(LazyItemScope item, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1507430953, i3, -1, "cz.mobilesoft.coreblock.scene.more.haf.ComposableSingletons$HaFActivityKt.lambda$-1507430953.<anonymous> (HaFActivity.kt:325)");
            }
            TextKt.c(StringResources_androidKt.b(R.string.mk, composer, 0), PaddingKt.m(Modifier.b8, Dp.g(8), 0.0f, 0.0f, 0.0f, 14, null), ComposeColorsKt.j(composer, 0).O(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).i(), composer, 48, 0, 65528);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1971199878, i3, -1, "cz.mobilesoft.coreblock.scene.more.haf.ComposableSingletons$HaFActivityKt.lambda$-1971199878.<anonymous> (HaFActivity.kt:263)");
            }
            IconKt.a(PainterResources_androidKt.c(R.drawable.Z4, composer, 0), "", null, ComposeColorsKt.j(composer, 0).M(), composer, 48, 4);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-837970055, i3, -1, "cz.mobilesoft.coreblock.scene.more.haf.ComposableSingletons$HaFActivityKt.lambda$-837970055.<anonymous> (HaFActivity.kt:452)");
            }
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    public final Function3 i() {
        return f107542e;
    }

    public final Function3 j() {
        return f107541d;
    }

    public final Function3 k() {
        return f107543f;
    }

    public final Function2 l() {
        return f107540c;
    }

    public final Function2 m() {
        return f107546i;
    }

    public final Function2 n() {
        return f107539b;
    }

    public final Function3 o() {
        return f107544g;
    }

    public final Function3 p() {
        return f107545h;
    }
}
