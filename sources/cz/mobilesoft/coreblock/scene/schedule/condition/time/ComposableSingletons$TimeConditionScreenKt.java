package cz.mobilesoft.coreblock.scene.schedule.condition.time;

import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.ScaffoldState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import cz.mobilesoft.coreblock.scene.schedule.condition.IntervalDTO;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.collections.immutable.ExtensionsKt;
import kotlinx.collections.immutable.PersistentSet;
import org.threeten.bp.DayOfWeek;

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
public final class ComposableSingletons$TimeConditionScreenKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComposableSingletons$TimeConditionScreenKt f115676a = new ComposableSingletons$TimeConditionScreenKt();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Function2 f115677b = ComposableLambdaKt.c(342783512, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.time.a
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$TimeConditionScreenKt.e((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Function2 f115678c = ComposableLambdaKt.c(-98970983, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.time.b
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$TimeConditionScreenKt.g((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(342783512, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.condition.time.ComposableSingletons$TimeConditionScreenKt.lambda$342783512.<anonymous> (TimeConditionScreen.kt:69)");
            }
            ScaffoldState scaffoldStateG = ScaffoldKt.g(null, null, composer, 0, 3);
            PersistentSet persistentSetD = ExtensionsKt.d(DayOfWeek.TUESDAY, DayOfWeek.FRIDAY);
            TimeUnit timeUnit = TimeUnit.HOURS;
            TimeConditionViewState timeConditionViewState = new TimeConditionViewState(true, false, new TimeConditionConfigurationViewState(new Configuration(persistentSetD, null, ExtensionsKt.b(new IntervalDTO(0L, timeUnit.toMinutes(7L) + ((long) 40), null, null, 12, null), new IntervalDTO(((long) 15) + timeUnit.toMinutes(12L), timeUnit.toMinutes(14L) + ((long) 10), null, null, 12, null), new IntervalDTO(timeUnit.toMinutes(22L) + ((long) 30), 1440L, null, null, 12, null)), false, false, 26, null), true, false, false, false, null, false, 124, null));
            Object objG = composer.G();
            if (objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.time.d
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$TimeConditionScreenKt.f((TimeConditionViewEvent) obj);
                    }
                };
                composer.w(objG);
            }
            TimeConditionScreenKt.G(scaffoldStateG, timeConditionViewState, null, false, false, null, false, (Function1) objG, composer, 12583296, 120);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f(TimeConditionViewEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-98970983, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.condition.time.ComposableSingletons$TimeConditionScreenKt.lambda$-98970983.<anonymous> (TimeConditionScreen.kt:106)");
            }
            ScaffoldState scaffoldStateG = ScaffoldKt.g(null, null, composer, 0, 3);
            TimeUnit timeUnit = TimeUnit.HOURS;
            TimeConditionViewState timeConditionViewState = new TimeConditionViewState(false, false, new TimeConditionConfigurationViewState(new Configuration(null, null, ExtensionsKt.b(new IntervalDTO(((long) 15) + timeUnit.toMinutes(12L), timeUnit.toMinutes(14L) + ((long) 10), null, null, 12, null)), true, false, 19, null), false, false, false, false, null, false, 126, null), 3, null);
            Object objG = composer.G();
            if (objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.time.c
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$TimeConditionScreenKt.h((TimeConditionViewEvent) obj);
                    }
                };
                composer.w(objG);
            }
            TimeConditionScreenKt.G(scaffoldStateG, timeConditionViewState, null, false, false, null, false, (Function1) objG, composer, 12583296, 120);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(TimeConditionViewEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.f139807a;
    }
}
