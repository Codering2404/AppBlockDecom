package cz.mobilesoft.coreblock.scene.permission.location;

import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeBackgroundKt;
import cz.mobilesoft.coreblock.view.compose.material3.CardsKt;
import cz.mobilesoft.coreblock.view.compose.material3.ToolbarButtonType;
import cz.mobilesoft.coreblock.view.compose.material3.ToolbarKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
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
public final class ComposableSingletons$LocationPermissionScreenKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComposableSingletons$LocationPermissionScreenKt f111827a = new ComposableSingletons$LocationPermissionScreenKt();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Function3 f111828b = ComposableLambdaKt.c(843427013, false, new Function3() { // from class: cz.mobilesoft.coreblock.scene.permission.location.a
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$LocationPermissionScreenKt.I((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Function3 f111829c = ComposableLambdaKt.c(-688012897, false, new Function3() { // from class: cz.mobilesoft.coreblock.scene.permission.location.r
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$LocationPermissionScreenKt.S((ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Function3 f111830d = ComposableLambdaKt.c(-1903376644, false, new Function3() { // from class: cz.mobilesoft.coreblock.scene.permission.location.s
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$LocationPermissionScreenKt.M((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Function3 f111831e = ComposableLambdaKt.c(240107517, false, new Function3() { // from class: cz.mobilesoft.coreblock.scene.permission.location.b
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$LocationPermissionScreenKt.F((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Function3 f111832f = ComposableLambdaKt.c(-1911375618, false, new Function3() { // from class: cz.mobilesoft.coreblock.scene.permission.location.c
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$LocationPermissionScreenKt.N((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static Function3 f111833g = ComposableLambdaKt.c(232108543, false, new Function3() { // from class: cz.mobilesoft.coreblock.scene.permission.location.d
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$LocationPermissionScreenKt.E((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static Function3 f111834h = ComposableLambdaKt.c(759337150, false, new Function3() { // from class: cz.mobilesoft.coreblock.scene.permission.location.e
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$LocationPermissionScreenKt.G((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static Function3 f111835i = ComposableLambdaKt.c(1894721689, false, new Function3() { // from class: cz.mobilesoft.coreblock.scene.permission.location.f
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$LocationPermissionScreenKt.D((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static Function3 f111836j = ComposableLambdaKt.c(-289464944, false, new Function3() { // from class: cz.mobilesoft.coreblock.scene.permission.location.g
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$LocationPermissionScreenKt.O((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static Function3 f111837k = ComposableLambdaKt.c(812748790, false, new Function3() { // from class: cz.mobilesoft.coreblock.scene.permission.location.h
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$LocationPermissionScreenKt.H((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static Function3 f111838l = ComposableLambdaKt.c(-1880124011, false, new Function3() { // from class: cz.mobilesoft.coreblock.scene.permission.location.k
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$LocationPermissionScreenKt.L((AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static Function3 f111839m = ComposableLambdaKt.c(-736885212, false, new Function3() { // from class: cz.mobilesoft.coreblock.scene.permission.location.l
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$LocationPermissionScreenKt.U((PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static Function3 f111840n = ComposableLambdaKt.c(-1471795482, false, new Function3() { // from class: cz.mobilesoft.coreblock.scene.permission.location.m
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$LocationPermissionScreenKt.K((BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static Function2 f111841o = ComposableLambdaKt.c(-701841740, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.permission.location.n
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$LocationPermissionScreenKt.T((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static Function3 f111842p = ComposableLambdaKt.c(-491544129, false, new Function3() { // from class: cz.mobilesoft.coreblock.scene.permission.location.o
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$LocationPermissionScreenKt.Q((PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static Function3 f111843q = ComposableLambdaKt.c(-1226454399, false, new Function3() { // from class: cz.mobilesoft.coreblock.scene.permission.location.p
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$LocationPermissionScreenKt.J((BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static Function2 f111844r = ComposableLambdaKt.c(-456500657, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.permission.location.q
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$LocationPermissionScreenKt.P((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D(LazyItemScope item, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1894721689, i3, -1, "cz.mobilesoft.coreblock.scene.permission.location.ComposableSingletons$LocationPermissionScreenKt.lambda$1894721689.<anonymous> (LocationPermissionScreen.kt:319)");
            }
            SpacerKt.a(PaddingKt.m(Modifier.b8, 0.0f, Dp.g(16), 0.0f, 0.0f, 13, null), composer, 6);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E(LazyItemScope item, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(232108543, i3, -1, "cz.mobilesoft.coreblock.scene.permission.location.ComposableSingletons$LocationPermissionScreenKt.lambda$232108543.<anonymous> (LocationPermissionScreen.kt:274)");
            }
            ImageKt.a(PainterResources_androidKt.c(R.drawable.q8, composer, 0), null, SizeKt.v(PaddingKt.k(Modifier.b8, 0.0f, Dp.g(12), 1, null), Dp.g(375)), null, null, 0.0f, null, composer, 432, 120);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F(LazyItemScope item, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(240107517, i3, -1, "cz.mobilesoft.coreblock.scene.permission.location.ComposableSingletons$LocationPermissionScreenKt.lambda$240107517.<anonymous> (LocationPermissionScreen.kt:254)");
            }
            TextKt.c(StringResources_androidKt.b(R.string.cj, composer, 0), PaddingKt.k(Modifier.b8, 0.0f, Dp.g(12), 1, null), ComposeColorsKt.j(composer, 0).p(), 0L, null, null, null, 0L, null, TextAlign.h(TextAlign.f29616b.a()), 0L, 0, false, 0, 0, null, MaterialTheme.f13091a.c(composer, MaterialTheme.f13092b).f(), composer, 48, 0, 65016);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G(LazyItemScope item, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(759337150, i3, -1, "cz.mobilesoft.coreblock.scene.permission.location.ComposableSingletons$LocationPermissionScreenKt.lambda$759337150.<anonymous> (LocationPermissionScreen.kt:301)");
            }
            BoxKt.a(SizeKt.h(SizeKt.i(WindowInsetsPaddingKt.d(Modifier.b8, WindowInsets_androidKt.d(WindowInsets.f7172a, composer, 6)), Dp.g(56)), 0.0f, 1, null), composer, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H(LazyItemScope item, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(812748790, i3, -1, "cz.mobilesoft.coreblock.scene.permission.location.ComposableSingletons$LocationPermissionScreenKt.lambda$812748790.<anonymous> (LocationPermissionScreen.kt:341)");
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
    public static final Unit I(LazyItemScope item, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(843427013, i3, -1, "cz.mobilesoft.coreblock.scene.permission.location.ComposableSingletons$LocationPermissionScreenKt.lambda$843427013.<anonymous> (LocationPermissionScreen.kt:222)");
            }
            BoxKt.a(SizeKt.h(SizeKt.i(WindowInsetsPaddingKt.d(Modifier.b8, WindowInsets_androidKt.d(WindowInsets.f7172a, composer, 6)), Dp.g(56)), 0.0f, 1, null), composer, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit J(BoxScope GradientBox, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(GradientBox, "$this$GradientBox");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1226454399, i3, -1, "cz.mobilesoft.coreblock.scene.permission.location.ComposableSingletons$LocationPermissionScreenKt.lambda$-1226454399.<anonymous> (LocationPermissionScreen.kt:559)");
            }
            ScaffoldKt.a(WindowInsetsPaddingKt.d(Modifier.b8, WindowInsets_androidKt.b(WindowInsets.f7172a, composer, 6)), null, null, null, null, null, 0, false, null, false, null, 0.0f, 0L, 0L, 0L, Color.f25715b.j(), 0L, f111842p, composer, 0, 12779520, 98302);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit K(BoxScope GradientBox, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(GradientBox, "$this$GradientBox");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1471795482, i3, -1, "cz.mobilesoft.coreblock.scene.permission.location.ComposableSingletons$LocationPermissionScreenKt.lambda$-1471795482.<anonymous> (LocationPermissionScreen.kt:532)");
            }
            ScaffoldKt.a(WindowInsetsPaddingKt.d(Modifier.b8, WindowInsets_androidKt.b(WindowInsets.f7172a, composer, 6)), null, null, null, null, null, 0, false, null, false, null, 0.0f, 0L, 0L, 0L, Color.f25715b.j(), 0L, f111839m, composer, 0, 12779520, 98302);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L(AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
        if (ComposerKt.M()) {
            ComposerKt.U(-1880124011, i3, -1, "cz.mobilesoft.coreblock.scene.permission.location.ComposableSingletons$LocationPermissionScreenKt.lambda$-1880124011.<anonymous> (LocationPermissionScreen.kt:403)");
        }
        cz.mobilesoft.coreblock.view.TextKt.g(StringResources_androidKt.c(R.string.J2, new Object[]{StringResources_androidKt.b(R.string.f95790f1, composer, 0)}, composer, 0), PaddingKt.m(Modifier.b8, Dp.g(32), Dp.g(8), 0.0f, 0.0f, 12, null), MaterialTheme.f13091a.c(composer, MaterialTheme.f13092b).b(), ComposeColorsKt.j(composer, 0).q(), null, 0, null, composer, 48, 112);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit M(LazyItemScope item, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1903376644, i3, -1, "cz.mobilesoft.coreblock.scene.permission.location.ComposableSingletons$LocationPermissionScreenKt.lambda$-1903376644.<anonymous> (LocationPermissionScreen.kt:230)");
            }
            CardsKt.k(SizeKt.I(SizeKt.E(PaddingKt.k(Modifier.b8, 0.0f, Dp.g(8), 1, null), null, false, 3, null), null, false, 3, null), ComposeColorsKt.j(composer, 0).c(), 0.0f, RoundedCornerShapeKt.g(), null, f111829c, composer, 196614, 20);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit N(LazyItemScope item, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1911375618, i3, -1, "cz.mobilesoft.coreblock.scene.permission.location.ComposableSingletons$LocationPermissionScreenKt.lambda$-1911375618.<anonymous> (LocationPermissionScreen.kt:264)");
            }
            TextKt.c(StringResources_androidKt.b(R.string.dj, composer, 0), PaddingKt.k(Modifier.b8, 0.0f, Dp.g(12), 1, null), ComposeColorsKt.j(composer, 0).q(), 0L, null, null, null, 0L, null, TextAlign.h(TextAlign.f29616b.a()), 0L, 0, false, 0, 0, null, MaterialTheme.f13091a.c(composer, MaterialTheme.f13092b).b(), composer, 48, 0, 65016);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit O(LazyItemScope item, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-289464944, i3, -1, "cz.mobilesoft.coreblock.scene.permission.location.ComposableSingletons$LocationPermissionScreenKt.lambda$-289464944.<anonymous> (LocationPermissionScreen.kt:336)");
            }
            LocationPermissionScreenKt.R(null, composer, 0, 1);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit P(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-456500657, i3, -1, "cz.mobilesoft.coreblock.scene.permission.location.ComposableSingletons$LocationPermissionScreenKt.lambda$-456500657.<anonymous> (LocationPermissionScreen.kt:558)");
            }
            ComposeBackgroundKt.m(null, false, false, false, null, 0L, null, f111843q, composer, 12582912, 127);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Q(PaddingValues paddingValues, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        if ((i3 & 6) == 0) {
            i3 |= composer.Z(paddingValues) ? 4 : 2;
        }
        if (composer.r((i3 & 19) != 18, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-491544129, i3, -1, "cz.mobilesoft.coreblock.scene.permission.location.ComposableSingletons$LocationPermissionScreenKt.lambda$-491544129.<anonymous> (LocationPermissionScreen.kt:563)");
            }
            Modifier modifierH = PaddingKt.h(Modifier.b8, paddingValues);
            MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.o(), false);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierH);
            ComposeUiNode.Companion companion = ComposeUiNode.f8;
            Function0 function0A = companion.a();
            if (composer.m() == null) {
                ComposablesKt.c();
            }
            composer.L();
            if (composer.i()) {
                composer.P(function0A);
            } else {
                composer.v();
            }
            Composer composerA = Updater.a(composer);
            Updater.e(composerA, measurePolicyG, companion.e());
            Updater.e(composerA, compositionLocalMapU, companion.g());
            Function2 function2B = companion.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            LocationPermissionScreenKt.O(null, composer, 0, 1);
            Object objG = composer.G();
            if (objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.permission.location.j
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposableSingletons$LocationPermissionScreenKt.R();
                    }
                };
                composer.w(objG);
            }
            ToolbarKt.e(null, (Function0) objG, null, true, ToolbarButtonType.Close, false, false, null, null, composer, 27696, 485);
            composer.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit R() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit S(ColumnScope BaseCard, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(BaseCard, "$this$BaseCard");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-688012897, i3, -1, "cz.mobilesoft.coreblock.scene.permission.location.ComposableSingletons$LocationPermissionScreenKt.lambda$-688012897.<anonymous> (LocationPermissionScreen.kt:238)");
            }
            Modifier modifierK = PaddingKt.k(PaddingKt.k(Modifier.b8, Dp.g(12), 0.0f, 2, null), 0.0f, Dp.g(8), 1, null);
            MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.e(), false);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierK);
            ComposeUiNode.Companion companion = ComposeUiNode.f8;
            Function0 function0A = companion.a();
            if (composer.m() == null) {
                ComposablesKt.c();
            }
            composer.L();
            if (composer.i()) {
                composer.P(function0A);
            } else {
                composer.v();
            }
            Composer composerA = Updater.a(composer);
            Updater.e(composerA, measurePolicyG, companion.e());
            Updater.e(composerA, compositionLocalMapU, companion.g());
            Function2 function2B = companion.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            TextKt.c(StringResources_androidKt.b(R.string.xs, composer, 0), null, ComposeColorsKt.j(composer, 0).b(), 0L, null, null, null, 0L, null, TextAlign.h(TextAlign.f29616b.a()), 0L, 0, false, 0, 0, null, MaterialTheme.f13091a.c(composer, MaterialTheme.f13092b).h(), composer, 0, 0, 65018);
            composer.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit T(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-701841740, i3, -1, "cz.mobilesoft.coreblock.scene.permission.location.ComposableSingletons$LocationPermissionScreenKt.lambda$-701841740.<anonymous> (LocationPermissionScreen.kt:531)");
            }
            ComposeBackgroundKt.m(null, false, false, false, null, 0L, null, f111840n, composer, 12582912, 127);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit U(PaddingValues paddingValues, Composer composer, int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        if ((i3 & 6) == 0) {
            i4 = (composer.Z(paddingValues) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-736885212, i4, -1, "cz.mobilesoft.coreblock.scene.permission.location.ComposableSingletons$LocationPermissionScreenKt.lambda$-736885212.<anonymous> (LocationPermissionScreen.kt:536)");
            }
            Modifier modifierH = PaddingKt.h(Modifier.b8, paddingValues);
            MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.o(), false);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierH);
            ComposeUiNode.Companion companion = ComposeUiNode.f8;
            Function0 function0A = companion.a();
            if (composer.m() == null) {
                ComposablesKt.c();
            }
            composer.L();
            if (composer.i()) {
                composer.P(function0A);
            } else {
                composer.v();
            }
            Composer composerA = Updater.a(composer);
            Updater.e(composerA, measurePolicyG, companion.e());
            Updater.e(composerA, compositionLocalMapU, companion.g());
            Function2 function2B = companion.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            LocationPermissionScreenKt.m0(null, StringResources_androidKt.b(R.string.hj, composer, 0), CollectionsKt.emptyList(), false, composer, 3456, 1);
            Object objG = composer.G();
            if (objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.permission.location.i
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposableSingletons$LocationPermissionScreenKt.V();
                    }
                };
                composer.w(objG);
            }
            ToolbarKt.e(null, (Function0) objG, null, true, ToolbarButtonType.Close, false, false, null, null, composer, 27696, 485);
            composer.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit V() {
        return Unit.f139807a;
    }

    public final Function3 A() {
        return f111834h;
    }

    public final Function3 B() {
        return f111837k;
    }

    public final Function3 C() {
        return f111828b;
    }

    public final Function3 t() {
        return f111838l;
    }

    public final Function3 u() {
        return f111830d;
    }

    public final Function3 v() {
        return f111832f;
    }

    public final Function3 w() {
        return f111836j;
    }

    public final Function3 x() {
        return f111835i;
    }

    public final Function3 y() {
        return f111833g;
    }

    public final Function3 z() {
        return f111831e;
    }
}
