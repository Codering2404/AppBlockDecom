package cz.mobilesoft.coreblock.scene.schedule.condition.wifi;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.ScaffoldState;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.style.TextAlign;
import com.facebook.stetho.websocket.CloseCodes;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.scene.schedule.condition.time.Wifi;
import cz.mobilesoft.coreblock.scene.schedule.condition.time.WifiConfigurationViewState;
import cz.mobilesoft.coreblock.util.Success;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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
public final class ComposableSingletons$WifiConditionScreenKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComposableSingletons$WifiConditionScreenKt f115983a = new ComposableSingletons$WifiConditionScreenKt();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Function2 f115984b = ComposableLambdaKt.c(-1402073267, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.wifi.a
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$WifiConditionScreenKt.s((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Function2 f115985c = ComposableLambdaKt.c(469861857, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.wifi.b
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$WifiConditionScreenKt.p((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Function2 f115986d = ComposableLambdaKt.c(-1942273714, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.wifi.c
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$WifiConditionScreenKt.w((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Function2 f115987e = ComposableLambdaKt.c(-144823251, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.wifi.d
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$WifiConditionScreenKt.v((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Function2 f115988f = ComposableLambdaKt.c(203369011, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.wifi.e
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$WifiConditionScreenKt.o((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static Function2 f115989g = ComposableLambdaKt.c(-821834212, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.wifi.f
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$WifiConditionScreenKt.x((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(203369011, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.condition.wifi.ComposableSingletons$WifiConditionScreenKt.lambda$203369011.<anonymous> (WifiConditionScreen.kt:680)");
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
    public static final Unit p(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(469861857, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.condition.wifi.ComposableSingletons$WifiConditionScreenKt.lambda$469861857.<anonymous> (WifiConditionScreen.kt:154)");
            }
            ScaffoldState scaffoldStateG = ScaffoldKt.g(null, null, composer, 0, 3);
            WifiConditionViewState wifiConditionViewState = new WifiConditionViewState(false, false, null, new WifiConfigurationViewState(Success.f128020a, false, false, null, ExtensionsKt.d("Network 1"), null, null, false, false, false, CloseCodes.CLOSED_ABNORMALLY, null), 7, null);
            Object objG = composer.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.wifi.g
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposableSingletons$WifiConditionScreenKt.q();
                    }
                };
                composer.w(objG);
            }
            Function0 function0 = (Function0) objG;
            Object objG2 = composer.G();
            if (objG2 == companion.a()) {
                objG2 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.wifi.h
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$WifiConditionScreenKt.r((WifiConditionViewEvent) obj);
                    }
                };
                composer.w(objG2);
            }
            WifiConditionScreenKt.l0(scaffoldStateG, wifiConditionViewState, false, false, false, null, function0, (Function1) objG2, composer, 14155776, 60);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r(WifiConditionViewEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1402073267, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.condition.wifi.ComposableSingletons$WifiConditionScreenKt.lambda$-1402073267.<anonymous> (WifiConditionScreen.kt:111)");
            }
            ScaffoldState scaffoldStateG = ScaffoldKt.g(null, null, composer, 0, 3);
            List listMutableListOf = CollectionsKt.mutableListOf(new Wifi("Network 1", "Network 1", true, false, false, true, 24, null), new Wifi("Network 1b", "Network 1b", true, false, false, false, 24, null), new Wifi("Network 1c", "Network 1c", false, false, false, true, 28, null));
            for (int i4 = 2; i4 < 21; i4++) {
                listMutableListOf.add(new Wifi("Network " + i4, "Network " + i4, false, false, false, false, 60, null));
            }
            WifiConfigurationViewState wifiConfigurationViewState = new WifiConfigurationViewState(Success.f128020a, false, false, null, null, ExtensionsKt.h(listMutableListOf), null, false, false, false, 990, null);
            Object objG = composer.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.wifi.i
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$WifiConditionScreenKt.t((WifiConditionViewEvent) obj);
                    }
                };
                composer.w(objG);
            }
            Function1 function1 = (Function1) objG;
            Object objG2 = composer.G();
            if (objG2 == companion.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.wifi.j
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposableSingletons$WifiConditionScreenKt.u();
                    }
                };
                composer.w(objG2);
            }
            WifiConditionScreenKt.R0(scaffoldStateG, wifiConfigurationViewState, false, false, false, null, function1, (Function0) objG2, composer, 14155776, 60);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(WifiConditionViewEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-144823251, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.condition.wifi.ComposableSingletons$WifiConditionScreenKt.lambda$-144823251.<anonymous> (WifiConditionScreen.kt:608)");
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
    public static final Unit w(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1942273714, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.condition.wifi.ComposableSingletons$WifiConditionScreenKt.lambda$-1942273714.<anonymous> (WifiConditionScreen.kt:598)");
            }
            TextKt.c(StringResources_androidKt.b(R.string.nH, composer, 0), SizeKt.h(Modifier.b8, 0.0f, 1, null), ComposeColorsKt.j(composer, 0).M(), 0L, null, null, null, 0L, null, TextAlign.h(TextAlign.f29616b.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).g(), composer, 48, 0, 65016);
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
                ComposerKt.U(-821834212, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.condition.wifi.ComposableSingletons$WifiConditionScreenKt.lambda$-821834212.<anonymous> (WifiConditionScreen.kt:696)");
            }
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    public final Function2 k() {
        return f115987e;
    }

    public final Function2 l() {
        return f115986d;
    }

    public final Function2 m() {
        return f115989g;
    }

    public final Function2 n() {
        return f115988f;
    }
}
