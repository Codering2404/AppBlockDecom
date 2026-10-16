package cz.mobilesoft.coreblock.scene.insights.weekly;

import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.text.AnnotatedString;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class ComposableSingletons$ComponentsKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComposableSingletons$ComponentsKt f103864a = new ComposableSingletons$ComponentsKt();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Function3 f103865b = ComposableLambdaKt.c(-289080643, false, new Function3() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.l
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$ComponentsKt.l((BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Function3 f103866c = ComposableLambdaKt.c(-774663733, false, new Function3() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.m
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$ComponentsKt.o((ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Function2 f103867d = ComposableLambdaKt.c(-752287823, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.n
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$ComponentsKt.m((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Function3 f103868e = ComposableLambdaKt.c(970670281, false, new Function3() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.o
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$ComponentsKt.k((ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Function2 f103869f = ComposableLambdaKt.c(1664323491, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.p
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$ComponentsKt.i((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1664323491, i3, -1, "cz.mobilesoft.coreblock.scene.insights.weekly.ComposableSingletons$ComponentsKt.lambda$1664323491.<anonymous> (Components.kt:212)");
            }
            AnnotatedString annotatedString = new AnnotatedString("Very long subtitle that is very long and should be truncated", null, 2, null);
            Object objG = composer.G();
            if (objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.r
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$ComponentsKt.j((Offset) obj);
                    }
                };
                composer.w(objG);
            }
            ComponentsKt.k("Heading", annotatedString, false, (Function1) objG, f103868e, composer, 28086, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(Offset offset) {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(ColumnScope BaseWeeklyInsightsScreen, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(BaseWeeklyInsightsScreen, "$this$BaseWeeklyInsightsScreen");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(970670281, i3, -1, "cz.mobilesoft.coreblock.scene.insights.weekly.ComposableSingletons$ComponentsKt.lambda$970670281.<anonymous> (Components.kt:218)");
            }
            TextKt.c("Another very long text that should be truncated as well", null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 6, 0, 131070);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(BoxScope boxScope, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(boxScope, "<this>");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-289080643, i3, -1, "cz.mobilesoft.coreblock.scene.insights.weekly.ComposableSingletons$ComponentsKt.lambda$-289080643.<anonymous> (Components.kt:121)");
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
    public static final Unit m(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-752287823, i3, -1, "cz.mobilesoft.coreblock.scene.insights.weekly.ComposableSingletons$ComponentsKt.lambda$-752287823.<anonymous> (Components.kt:198)");
            }
            AnnotatedString annotatedString = new AnnotatedString("Very long subtitle that is very long and should be truncated", null, 2, null);
            Object objG = composer.G();
            if (objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.q
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$ComponentsKt.n((Offset) obj);
                    }
                };
                composer.w(objG);
            }
            ComponentsKt.k("Heading", annotatedString, false, (Function1) objG, f103866c, composer, 27702, 4);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(Offset offset) {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(ColumnScope BaseWeeklyInsightsScreen, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(BaseWeeklyInsightsScreen, "$this$BaseWeeklyInsightsScreen");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-774663733, i3, -1, "cz.mobilesoft.coreblock.scene.insights.weekly.ComposableSingletons$ComponentsKt.lambda$-774663733.<anonymous> (Components.kt:203)");
            }
            TextKt.c("Content", null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 6, 0, 131070);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    public final Function3 h() {
        return f103865b;
    }
}
