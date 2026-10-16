package cz.mobilesoft.coreblock.scene.more.settings.developer;

import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import java.util.List;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class ComposableSingletons$DeveloperSettingsDialogsKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComposableSingletons$DeveloperSettingsDialogsKt f108252a = new ComposableSingletons$DeveloperSettingsDialogsKt();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Function2 f108253b = ComposableLambdaKt.c(682860511, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.c
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$DeveloperSettingsDialogsKt.t((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Function2 f108254c = ComposableLambdaKt.c(2019670577, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.d
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$DeveloperSettingsDialogsKt.r((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Function2 f108255d = ComposableLambdaKt.c(-780503076, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.e
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$DeveloperSettingsDialogsKt.A((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Function2 f108256e = ComposableLambdaKt.c(-1499836850, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.f
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$DeveloperSettingsDialogsKt.v((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Function2 f108257f = ComposableLambdaKt.c(-1472722145, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.g
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$DeveloperSettingsDialogsKt.u((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static Function2 f108258g = ComposableLambdaKt.c(205176352, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.h
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$DeveloperSettingsDialogsKt.s((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static Function2 f108259h = ComposableLambdaKt.c(-1794682791, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.i
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$DeveloperSettingsDialogsKt.w((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static Function2 f108260i = ComposableLambdaKt.c(-2070136521, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.j
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$DeveloperSettingsDialogsKt.x((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-780503076, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.developer.ComposableSingletons$DeveloperSettingsDialogsKt.lambda$-780503076.<anonymous> (DeveloperSettingsDialogs.kt:723)");
            }
            TextKt.c("Enter JSON configuration", null, ComposeColorsKt.j(composer, 0).q(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).b(), composer, 6, 0, 65530);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(2019670577, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.developer.ComposableSingletons$DeveloperSettingsDialogsKt.lambda$2019670577.<anonymous> (DeveloperSettingsDialogs.kt:652)");
            }
            TextKt.c("Enter group name", null, ComposeColorsKt.j(composer, 0).q(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).b(), composer, 6, 0, 65530);
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
                ComposerKt.U(205176352, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.developer.ComposableSingletons$DeveloperSettingsDialogsKt.lambda$205176352.<anonymous> (DeveloperSettingsDialogs.kt:956)");
            }
            TextKt.c("Paste JSON here", null, ComposeColorsKt.j(composer, 0).q(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).b(), composer, 6, 0, 65530);
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
                ComposerKt.U(682860511, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.developer.ComposableSingletons$DeveloperSettingsDialogsKt.lambda$682860511.<anonymous> (DeveloperSettingsDialogs.kt:554)");
            }
            TextKt.c("Enter campaign ID", null, ComposeColorsKt.j(composer, 0).q(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).a(), composer, 6, 0, 65530);
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
                ComposerKt.U(-1472722145, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.developer.ComposableSingletons$DeveloperSettingsDialogsKt.lambda$-1472722145.<anonymous> (DeveloperSettingsDialogs.kt:886)");
            }
            TextKt.c("Enter remote config mock data", null, ComposeColorsKt.j(composer, 0).q(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).b(), composer, 6, 0, 65530);
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
                ComposerKt.U(-1499836850, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.developer.ComposableSingletons$DeveloperSettingsDialogsKt.lambda$-1499836850.<anonymous> (DeveloperSettingsDialogs.kt:796)");
            }
            TextKt.c("Enter minutes", null, ComposeColorsKt.j(composer, 0).q(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).a(), composer, 6, 0, 65530);
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
                ComposerKt.U(-1794682791, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.developer.ComposableSingletons$DeveloperSettingsDialogsKt.lambda$-1794682791.<anonymous> (DeveloperSettingsDialogs.kt:1207)");
            }
            TextKt.c("3o,l,3o", null, ComposeColorsKt.j(composer, 0).s(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).a(), composer, 6, 0, 65530);
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
                ComposerKt.U(-2070136521, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.developer.ComposableSingletons$DeveloperSettingsDialogsKt.lambda$-2070136521.<anonymous> (DeveloperSettingsDialogs.kt:1310)");
            }
            Object objG = composer.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.k
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$DeveloperSettingsDialogsKt.y((List) obj);
                    }
                };
                composer.w(objG);
            }
            Function1 function1 = (Function1) objG;
            Object objG2 = composer.G();
            if (objG2 == companion.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.l
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposableSingletons$DeveloperSettingsDialogsKt.z();
                    }
                };
                composer.w(objG2);
            }
            DeveloperSettingsDialogsKt.M2(function1, (Function0) objG2, composer, 54);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y(List it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z() {
        return Unit.f139807a;
    }

    public final Function2 k() {
        return f108257f;
    }

    public final Function2 l() {
        return f108256e;
    }

    public final Function2 m() {
        return f108259h;
    }

    public final Function2 n() {
        return f108255d;
    }

    public final Function2 o() {
        return f108254c;
    }

    public final Function2 p() {
        return f108258g;
    }

    public final Function2 q() {
        return f108253b;
    }
}
