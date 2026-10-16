package cz.mobilesoft.coreblock.scene.more.settings.developer;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.material.SnackbarHostState;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.ArrowBackKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.view.compose.ThemedSnackbarHostKt;
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
public final class ComposableSingletons$DeveloperSettingsScreenKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComposableSingletons$DeveloperSettingsScreenKt f108261a = new ComposableSingletons$DeveloperSettingsScreenKt();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Function2 f108262b = ComposableLambdaKt.c(-298813275, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.m
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$DeveloperSettingsScreenKt.o((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Function2 f108263c = ComposableLambdaKt.c(-1595135932, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.n
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$DeveloperSettingsScreenKt.m((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Function3 f108264d = ComposableLambdaKt.c(-1235075475, false, new Function3() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.o
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$DeveloperSettingsScreenKt.l((SnackbarHostState) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Function3 f108265e = ComposableLambdaKt.c(-262040888, false, new Function3() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.p
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$DeveloperSettingsScreenKt.n((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Function3 f108266f = ComposableLambdaKt.c(1643559299, false, new Function3() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.q
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$DeveloperSettingsScreenKt.k((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(LazyItemScope item, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1643559299, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.developer.ComposableSingletons$DeveloperSettingsScreenKt.lambda$1643559299.<anonymous> (DeveloperSettingsScreen.kt:231)");
            }
            SpacerKt.a(SizeKt.v(Modifier.b8, Dp.g(16)), composer, 6);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(SnackbarHostState it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(it, "it");
        if ((i3 & 6) == 0) {
            i3 |= composer.Z(it) ? 4 : 2;
        }
        if (composer.r((i3 & 19) != 18, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1235075475, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.developer.ComposableSingletons$DeveloperSettingsScreenKt.lambda$-1235075475.<anonymous> (DeveloperSettingsScreen.kt:151)");
            }
            ThemedSnackbarHostKt.b(it, null, composer, i3 & 14, 2);
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
                ComposerKt.U(-1595135932, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.developer.ComposableSingletons$DeveloperSettingsScreenKt.lambda$-1595135932.<anonymous> (DeveloperSettingsScreen.kt:139)");
            }
            IconKt.d(ArrowBackKt.a(Icons.f15145a.a()), "Back", null, ComposeColorsKt.j(composer, 0).p(), composer, 48, 4);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(LazyItemScope item, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-262040888, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.developer.ComposableSingletons$DeveloperSettingsScreenKt.lambda$-262040888.<anonymous> (DeveloperSettingsScreen.kt:206)");
            }
            DeveloperSettingsComponentsKt.t(null, composer, 0, 1);
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
                ComposerKt.U(-298813275, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.developer.ComposableSingletons$DeveloperSettingsScreenKt.lambda$-298813275.<anonymous> (DeveloperSettingsScreen.kt:131)");
            }
            TextKt.c(StringResources_androidKt.b(R.string.Fb, composer, 0), null, ComposeColorsKt.j(composer, 0).p(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).h(), composer, 0, 0, 65530);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    public final Function3 f() {
        return f108264d;
    }

    public final Function2 g() {
        return f108263c;
    }

    public final Function3 h() {
        return f108265e;
    }

    public final Function2 i() {
        return f108262b;
    }

    public final Function3 j() {
        return f108266f;
    }
}
