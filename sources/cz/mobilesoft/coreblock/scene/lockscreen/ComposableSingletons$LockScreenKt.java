package cz.mobilesoft.coreblock.scene.lockscreen;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material.IconKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.Dp;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.enums.PremiumState;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParserException;

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
public final class ComposableSingletons$LockScreenKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComposableSingletons$LockScreenKt f105329a = new ComposableSingletons$LockScreenKt();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Function3 f105330b = ComposableLambdaKt.c(1116054908, false, new Function3() { // from class: cz.mobilesoft.coreblock.scene.lockscreen.k
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$LockScreenKt.k((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Function2 f105331c = ComposableLambdaKt.c(-767604587, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.lockscreen.l
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$LockScreenKt.p((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Function2 f105332d = ComposableLambdaKt.c(637503756, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.lockscreen.m
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$LockScreenKt.o((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Function2 f105333e = ComposableLambdaKt.c(1958504496, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.lockscreen.n
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$LockScreenKt.l((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Function2 f105334f = ComposableLambdaKt.c(1962783587, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.lockscreen.o
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$LockScreenKt.m((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(RowScope TextButton, Composer composer, int i3) throws XmlPullParserException, IOException {
        Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1116054908, i3, -1, "cz.mobilesoft.coreblock.scene.lockscreen.ComposableSingletons$LockScreenKt.lambda$1116054908.<anonymous> (LockScreen.kt:175)");
            }
            ImageVector imageVectorB = VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.h5, composer, 6);
            long jQ0 = ComposeColorsKt.j(composer, 0).q0();
            Modifier.Companion companion = Modifier.b8;
            IconKt.b(imageVectorB, "Av. settings", SizeKt.v(companion, Dp.g(24)), jQ0, composer, 432, 0);
            SpacerKt.a(SizeKt.v(companion, Dp.g(4)), composer, 6);
            TextKt.c(StringResources_androidKt.b(R.string.f95837q2, composer, 0), null, ComposeColorsKt.j(composer, 0).q0(), 0L, null, FontWeight.f29233b.b(), null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.f13091a.c(composer, MaterialTheme.f13092b).j(), composer, 196608, 0, 65498);
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
                ComposerKt.U(1958504496, i3, -1, "cz.mobilesoft.coreblock.scene.lockscreen.ComposableSingletons$LockScreenKt.lambda$1958504496.<anonymous> (LockScreen.kt:351)");
            }
            IconKt.b(VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.M3, composer, 6), "More", null, Color.r(ComposeColorsKt.j(composer, 0).q0(), 0.6f, 0.0f, 0.0f, 0.0f, 14, null), composer, 48, 4);
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
                ComposerKt.U(1962783587, i3, -1, "cz.mobilesoft.coreblock.scene.lockscreen.ComposableSingletons$LockScreenKt.lambda$1962783587.<anonymous> (LockScreen.kt:799)");
            }
            LockViewState lockViewState = new LockViewState(null, null, 0, 0, false, 0, false, false, false, false, false, false, false, null, false, null, null, null, null, null, null, null, false, null, null, false, null, 0.0f, false, false, false, null, null, null, false, PremiumState.Subscription.Yearly.INSTANCE, -1, 7, null);
            Object objG = composer.G();
            if (objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.lockscreen.p
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$LockScreenKt.n((LockViewEvent) obj);
                    }
                };
                composer.w(objG);
            }
            LockScreenKt.D(lockViewState, (Function1) objG, false, false, null, composer, 48, 28);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(LockViewEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(637503756, i3, -1, "cz.mobilesoft.coreblock.scene.lockscreen.ComposableSingletons$LockScreenKt.lambda$637503756.<anonymous> (LockScreen.kt:341)");
            }
            IconKt.b(VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.X1, composer, 6), null, null, Color.r(ComposeColorsKt.j(composer, 0).q0(), 0.6f, 0.0f, 0.0f, 0.0f, 14, null), composer, 48, 4);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-767604587, i3, -1, "cz.mobilesoft.coreblock.scene.lockscreen.ComposableSingletons$LockScreenKt.lambda$-767604587.<anonymous> (LockScreen.kt:304)");
            }
            IconKt.b(VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.C1, composer, 6), "Close", null, ComposeColorsKt.j(composer, 0).b(), composer, 48, 4);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    public final Function2 g() {
        return f105331c;
    }

    public final Function3 h() {
        return f105330b;
    }

    public final Function2 i() {
        return f105333e;
    }

    public final Function2 j() {
        return f105332d;
    }
}
