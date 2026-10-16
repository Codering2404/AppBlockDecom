package cz.mobilesoft.coreblock.view.compose.skeleton;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import com.valentinilk.shimmer.Shimmer;
import cz.mobilesoft.coreblock.view.compose.skeleton.ComposableSingletons$StructuredSkeletonKt;
import kotlin.Metadata;
import kotlin.Unit;
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
public final class ComposableSingletons$StructuredSkeletonKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComposableSingletons$StructuredSkeletonKt f131947a = new ComposableSingletons$StructuredSkeletonKt();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Function3 f131948b = ComposableLambdaKt.c(1953411080, false, new Function3() { // from class: j2.g
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$StructuredSkeletonKt.w((Shimmer) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Function3 f131949c = ComposableLambdaKt.c(-1889410800, false, new Function3() { // from class: j2.p
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$StructuredSkeletonKt.C((Shimmer) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Function3 f131950d = ComposableLambdaKt.c(-1161186246, false, new Function3() { // from class: j2.q
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$StructuredSkeletonKt.z((Shimmer) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Function3 f131951e = ComposableLambdaKt.c(-705568102, false, new Function3() { // from class: j2.r
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$StructuredSkeletonKt.F((Shimmer) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Function2 f131952f = ComposableLambdaKt.c(-1244024226, false, new Function2() { // from class: j2.s
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$StructuredSkeletonKt.A((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static Function2 f131953g = ComposableLambdaKt.c(1872420440, false, new Function2() { // from class: j2.t
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$StructuredSkeletonKt.v((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static Function2 f131954h = ComposableLambdaKt.c(1482565548, false, new Function2() { // from class: j2.h
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$StructuredSkeletonKt.t((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static Function2 f131955i = ComposableLambdaKt.c(177781158, false, new Function2() { // from class: j2.i
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$StructuredSkeletonKt.u((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static Function2 f131956j = ComposableLambdaKt.c(-612035573, false, new Function2() { // from class: j2.j
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$StructuredSkeletonKt.E((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static Function2 f131957k = ComposableLambdaKt.c(-379383931, false, new Function2() { // from class: j2.k
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$StructuredSkeletonKt.D((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static Function2 f131958l = ComposableLambdaKt.c(1267922660, false, new Function2() { // from class: j2.l
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$StructuredSkeletonKt.s((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static Function2 f131959m = ComposableLambdaKt.c(-1467378210, false, new Function2() { // from class: j2.m
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$StructuredSkeletonKt.B((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static Function2 f131960n = ComposableLambdaKt.c(-1039121712, false, new Function2() { // from class: j2.n
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$StructuredSkeletonKt.x((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static Function2 f131961o = ComposableLambdaKt.c(-1143272630, false, new Function2() { // from class: j2.o
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$StructuredSkeletonKt.y((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1244024226, i3, -1, "cz.mobilesoft.coreblock.view.compose.skeleton.ComposableSingletons$StructuredSkeletonKt.lambda$-1244024226.<anonymous> (StructuredSkeleton.kt:550)");
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
    public static final Unit B(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1467378210, i3, -1, "cz.mobilesoft.coreblock.view.compose.skeleton.ComposableSingletons$StructuredSkeletonKt.lambda$-1467378210.<anonymous> (StructuredSkeleton.kt:587)");
            }
            StructuredSkeletonKt.E(true, SkeletonPresets.f131964a.g(3), PaddingKt.i(Modifier.b8, Dp.g(16)), false, null, f131958l, composer, 196998, 24);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C(Shimmer shimmer, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(shimmer, "shimmer");
        if ((i3 & 6) == 0) {
            i3 |= (i3 & 8) == 0 ? composer.Z(shimmer) : composer.I(shimmer) ? 4 : 2;
        }
        if (composer.r((i3 & 19) != 18, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1889410800, i3, -1, "cz.mobilesoft.coreblock.view.compose.skeleton.ComposableSingletons$StructuredSkeletonKt.lambda$-1889410800.<anonymous> (StructuredSkeleton.kt:230)");
            }
            StructuredSkeletonKt.A(Dp.g(120), shimmer, composer, ((i3 << 3) & 112) | (Shimmer.f93784d << 3) | 6);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-379383931, i3, -1, "cz.mobilesoft.coreblock.view.compose.skeleton.ComposableSingletons$StructuredSkeletonKt.lambda$-379383931.<anonymous> (StructuredSkeleton.kt:573)");
            }
            StructuredSkeletonKt.E(true, SkeletonPresets.f131964a.c(2), PaddingKt.i(Modifier.b8, Dp.g(16)), false, null, f131956j, composer, 196998, 24);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-612035573, i3, -1, "cz.mobilesoft.coreblock.view.compose.skeleton.ComposableSingletons$StructuredSkeletonKt.lambda$-612035573.<anonymous> (StructuredSkeleton.kt:578)");
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
    public static final Unit F(Shimmer shimmer, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(shimmer, "shimmer");
        if ((i3 & 6) == 0) {
            i3 |= (i3 & 8) == 0 ? composer.Z(shimmer) : composer.I(shimmer) ? 4 : 2;
        }
        if (composer.r((i3 & 19) != 18, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-705568102, i3, -1, "cz.mobilesoft.coreblock.view.compose.skeleton.ComposableSingletons$StructuredSkeletonKt.lambda$-705568102.<anonymous> (StructuredSkeleton.kt:295)");
            }
            StructuredSkeletonKt.A(Dp.g(120), shimmer, composer, ((i3 << 3) & 112) | (Shimmer.f93784d << 3) | 6);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1267922660, i3, -1, "cz.mobilesoft.coreblock.view.compose.skeleton.ComposableSingletons$StructuredSkeletonKt.lambda$1267922660.<anonymous> (StructuredSkeleton.kt:592)");
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
    public static final Unit t(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1482565548, i3, -1, "cz.mobilesoft.coreblock.view.compose.skeleton.ComposableSingletons$StructuredSkeletonKt.lambda$1482565548.<anonymous> (StructuredSkeleton.kt:564)");
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
    public static final Unit u(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(177781158, i3, -1, "cz.mobilesoft.coreblock.view.compose.skeleton.ComposableSingletons$StructuredSkeletonKt.lambda$177781158.<anonymous> (StructuredSkeleton.kt:559)");
            }
            StructuredSkeletonKt.E(true, SkeletonPresets.f131964a.a(4), PaddingKt.i(Modifier.b8, Dp.g(16)), false, null, f131954h, composer, 196998, 24);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1872420440, i3, -1, "cz.mobilesoft.coreblock.view.compose.skeleton.ComposableSingletons$StructuredSkeletonKt.lambda$1872420440.<anonymous> (StructuredSkeleton.kt:545)");
            }
            StructuredSkeletonKt.E(true, SkeletonPresets.f131964a.d(), PaddingKt.i(Modifier.b8, Dp.g(16)), false, null, f131952f, composer, 196998, 24);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w(Shimmer shimmer, Composer composer, int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(shimmer, "shimmer");
        if ((i3 & 6) == 0) {
            i4 = i3 | ((i3 & 8) == 0 ? composer.Z(shimmer) : composer.I(shimmer) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1953411080, i4, -1, "cz.mobilesoft.coreblock.view.compose.skeleton.ComposableSingletons$StructuredSkeletonKt.lambda$1953411080.<anonymous> (StructuredSkeleton.kt:204)");
            }
            float f3 = 16;
            Modifier modifierM = PaddingKt.m(SizeKt.h(Modifier.b8, 0.0f, 1, null), 0.0f, Dp.g(8), 0.0f, Dp.g(f3), 5, null);
            MeasurePolicy measurePolicyB = RowKt.b(Arrangement.f6574a.e(), Alignment.f25072a.i(), composer, 54);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierM);
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
            Updater.e(composerA, measurePolicyB, companion.e());
            Updater.e(composerA, compositionLocalMapU, companion.g());
            Function2 function2B = companion.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            float fG = Dp.g(160);
            float fG2 = Dp.g(28);
            RoundedCornerShape roundedCornerShapeD = RoundedCornerShapeKt.d(Dp.g(6));
            int i5 = Shimmer.f93784d;
            int i6 = (i4 << 15) & 458752;
            SkeletonItemKt.m(fG, fG2, null, roundedCornerShapeD, 0L, shimmer, composer, (i5 << 15) | 54 | i6, 20);
            SkeletonItemKt.m(Dp.g(80), Dp.g(32), null, RoundedCornerShapeKt.d(Dp.g(f3)), 0L, shimmer, composer, (i5 << 15) | 54 | i6, 20);
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
    public static final Unit x(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1039121712, i3, -1, "cz.mobilesoft.coreblock.view.compose.skeleton.ComposableSingletons$StructuredSkeletonKt.lambda$-1039121712.<anonymous> (StructuredSkeleton.kt:606)");
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
    public static final Unit y(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1143272630, i3, -1, "cz.mobilesoft.coreblock.view.compose.skeleton.ComposableSingletons$StructuredSkeletonKt.lambda$-1143272630.<anonymous> (StructuredSkeleton.kt:601)");
            }
            StructuredSkeletonKt.E(true, SkeletonPresets.f131964a.e(2), PaddingKt.i(Modifier.b8, Dp.g(16)), false, null, f131960n, composer, 196998, 24);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z(Shimmer shimmer, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(shimmer, "shimmer");
        int i4 = (i3 & 6) == 0 ? i3 | ((i3 & 8) == 0 ? composer.Z(shimmer) : composer.I(shimmer) ? 4 : 2) : i3;
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1161186246, i4, -1, "cz.mobilesoft.coreblock.view.compose.skeleton.ComposableSingletons$StructuredSkeletonKt.lambda$-1161186246.<anonymous> (StructuredSkeleton.kt:244)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierH = SizeKt.h(companion, 0.0f, 1, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.k(), composer, 0);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierH);
            ComposeUiNode.Companion companion2 = ComposeUiNode.f8;
            Function0 function0A = companion2.a();
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
            Updater.e(composerA, measurePolicyA, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            float fG = Dp.g(80);
            float f3 = 20;
            float fG2 = Dp.g(f3);
            float f4 = 4;
            RoundedCornerShape roundedCornerShapeD = RoundedCornerShapeKt.d(Dp.g(f4));
            float f5 = 12;
            Modifier modifierM = PaddingKt.m(companion, 0.0f, 0.0f, 0.0f, Dp.g(f5), 7, null);
            int i5 = Shimmer.f93784d;
            int i6 = (i4 << 15) & 458752;
            SkeletonItemKt.m(fG, fG2, modifierM, roundedCornerShapeD, 0L, shimmer, composer, (i5 << 15) | 438 | i6, 16);
            float f6 = 120;
            int i7 = (i4 << 3) & 112;
            StructuredSkeletonKt.A(Dp.g(f6), shimmer, composer, (i5 << 3) | 6 | i7);
            SpacerKt.a(SizeKt.i(companion, Dp.g(24)), composer, 6);
            SkeletonItemKt.m(Dp.g(110), Dp.g(f3), PaddingKt.m(companion, 0.0f, 0.0f, 0.0f, Dp.g(f5), 7, null), RoundedCornerShapeKt.d(Dp.g(f4)), 0L, shimmer, composer, (i5 << 15) | 438 | i6, 16);
            composer.a0(-686025971);
            for (int i8 = 0; i8 < 5; i8++) {
                StructuredSkeletonKt.A(Dp.g(f6), shimmer, composer, (Shimmer.f93784d << 3) | 6 | i7);
                SpacerKt.a(SizeKt.i(Modifier.b8, Dp.g(8)), composer, 6);
            }
            composer.U();
            composer.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    public final Function3 o() {
        return f131950d;
    }

    public final Function3 p() {
        return f131949c;
    }

    public final Function3 q() {
        return f131951e;
    }

    public final Function3 r() {
        return f131948b;
    }
}
