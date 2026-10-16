package cz.mobilesoft.coreblock.scene.more.settings.developer.remoteconfigvalues;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.unit.Dp;
import com.facebook.internal.ServerProtocol;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.collections.immutable.ExtensionsKt;

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
public final class ComposableSingletons$RemoteConfigValuesScreenKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComposableSingletons$RemoteConfigValuesScreenKt f109273a = new ComposableSingletons$RemoteConfigValuesScreenKt();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Function2 f109274b = ComposableLambdaKt.c(-2122835996, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.remoteconfigvalues.a
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$RemoteConfigValuesScreenKt.n((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Function2 f109275c = ComposableLambdaKt.c(797608549, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.remoteconfigvalues.b
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$RemoteConfigValuesScreenKt.i((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Function2 f109276d = ComposableLambdaKt.c(-1110385988, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.remoteconfigvalues.c
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$RemoteConfigValuesScreenKt.j((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(797608549, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.developer.remoteconfigvalues.ComposableSingletons$RemoteConfigValuesScreenKt.lambda$797608549.<anonymous> (RemoteConfigValuesScreen.kt:105)");
            }
            IconKt.d(VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.G0, composer, 6), StringResources_androidKt.b(R.string.N7, composer, 0), null, ComposeColorsKt.j(composer, 0).b(), composer, 0, 4);
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
                ComposerKt.U(-1110385988, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.developer.remoteconfigvalues.ComposableSingletons$RemoteConfigValuesScreenKt.lambda$-1110385988.<anonymous> (RemoteConfigValuesScreen.kt:264)");
            }
            PaddingValues paddingValuesA = PaddingKt.a(Dp.g(0));
            RemoteConfigValuesViewState remoteConfigValuesViewState = new RemoteConfigValuesViewState(false, null, "discount", ExtensionsKt.b(new RemoteConfigValue("show_ads", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE), new RemoteConfigValue("discount_earliest_hours", "24"), new RemoteConfigValue("premium_button_color", "#FFAA00")), ExtensionsKt.b(new RemoteConfigValue("discount_earliest_hours", "24")), 2, null);
            Object objG = composer.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.remoteconfigvalues.d
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposableSingletons$RemoteConfigValuesScreenKt.k();
                    }
                };
                composer.w(objG);
            }
            Function0 function0 = (Function0) objG;
            Object objG2 = composer.G();
            if (objG2 == companion.a()) {
                objG2 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.remoteconfigvalues.e
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$RemoteConfigValuesScreenKt.l((String) obj);
                    }
                };
                composer.w(objG2);
            }
            Function1 function1 = (Function1) objG2;
            Object objG3 = composer.G();
            if (objG3 == companion.a()) {
                objG3 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.remoteconfigvalues.f
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposableSingletons$RemoteConfigValuesScreenKt.m();
                    }
                };
                composer.w(objG3);
            }
            RemoteConfigValuesScreenKt.r(paddingValuesA, remoteConfigValuesViewState, function0, function1, (Function0) objG3, composer, 28086);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-2122835996, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.developer.remoteconfigvalues.ComposableSingletons$RemoteConfigValuesScreenKt.lambda$-2122835996.<anonymous> (RemoteConfigValuesScreen.kt:97)");
            }
            TextKt.c(StringResources_androidKt.b(R.string.Ua, composer, 0), null, ComposeColorsKt.j(composer, 0).L(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).h(), composer, 0, 0, 65530);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    public final Function2 g() {
        return f109274b;
    }

    public final Function2 h() {
        return f109275c;
    }
}
