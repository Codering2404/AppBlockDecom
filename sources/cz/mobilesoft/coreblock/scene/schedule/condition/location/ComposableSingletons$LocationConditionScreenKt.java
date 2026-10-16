package cz.mobilesoft.coreblock.scene.schedule.condition.location;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.google.android.gms.maps.model.LatLng;
import cz.mobilesoft.coreblock.scene.schedule.condition.time.LocationConfigurationViewState;
import cz.mobilesoft.coreblock.util.Success;
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
public final class ComposableSingletons$LocationConditionScreenKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComposableSingletons$LocationConditionScreenKt f115332a = new ComposableSingletons$LocationConditionScreenKt();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Function2 f115333b = ComposableLambdaKt.c(374347417, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.location.a
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$LocationConditionScreenKt.f((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Function2 f115334c = ComposableLambdaKt.c(-533486187, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.location.b
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$LocationConditionScreenKt.i((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(374347417, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.condition.location.ComposableSingletons$LocationConditionScreenKt.lambda$374347417.<anonymous> (LocationConditionScreen.kt:133)");
            }
            LocationConfigurationViewState locationConfigurationViewState = new LocationConfigurationViewState(0, new LatLng(1.0d, 1.0d), false, null, null, null, null, null, null, null, "Hradec Králové", null, null, null, null, null, null, null, null, Success.f128020a, null, null, null, 7602237, null);
            Object objG = composer.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.location.d
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$LocationConditionScreenKt.g((LocationConditionViewEvent) obj);
                    }
                };
                composer.w(objG);
            }
            Function1 function1 = (Function1) objG;
            Object objG2 = composer.G();
            if (objG2 == companion.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.location.e
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposableSingletons$LocationConditionScreenKt.h();
                    }
                };
                composer.w(objG2);
            }
            LocationConditionScreenKt.u0(locationConfigurationViewState, false, false, false, null, false, function1, (Function0) objG2, composer, 14155776, 62);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(LocationConditionViewEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-533486187, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.condition.location.ComposableSingletons$LocationConditionScreenKt.lambda$-533486187.<anonymous> (LocationConditionScreen.kt:160)");
            }
            LocationConfigurationViewState locationConfigurationViewState = new LocationConfigurationViewState(0, new LatLng(1.0d, 1.0d), false, null, null, null, null, null, null, null, "Hradec Králové", null, null, null, null, null, null, null, null, Success.f128020a, null, null, null, 7602237, null);
            Object objG = composer.G();
            if (objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.location.c
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposableSingletons$LocationConditionScreenKt.j();
                    }
                };
                composer.w(objG);
            }
            LocationConditionScreenKt.r0(locationConfigurationViewState, (Function0) objG, composer, 48);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j() {
        return Unit.f139807a;
    }
}
