package cz.mobilesoft.coreblock.scene.dashboard.blocking;

import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import cz.mobilesoft.coreblock.util.profile.ProfileHelper;
import cz.mobilesoft.coreblock.view.compose.profileitem.ProfileItemEvent;
import java.util.List;
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
public final class ComposableSingletons$SchedulesSectionKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComposableSingletons$SchedulesSectionKt f99940a = new ComposableSingletons$SchedulesSectionKt();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Function3 f99941b = ComposableLambdaKt.c(877518260, false, new Function3() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.n0
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$SchedulesSectionKt.j((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Function3 f99942c = ComposableLambdaKt.c(-1057037781, false, new Function3() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.o0
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$SchedulesSectionKt.n((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Function3 f99943d = ComposableLambdaKt.c(-2119514505, false, new Function3() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.p0
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$SchedulesSectionKt.o((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Function3 f99944e = ComposableLambdaKt.c(898520494, false, new Function3() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.q0
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$SchedulesSectionKt.l((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Function2 f99945f = ComposableLambdaKt.c(1410326061, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.r0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$SchedulesSectionKt.i((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1410326061, i3, -1, "cz.mobilesoft.coreblock.scene.dashboard.blocking.ComposableSingletons$SchedulesSectionKt.lambda$1410326061.<anonymous> (SchedulesSection.kt:166)");
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
    public static final Unit j(LazyItemScope item, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(877518260, i3, -1, "cz.mobilesoft.coreblock.scene.dashboard.blocking.ComposableSingletons$SchedulesSectionKt.lambda$877518260.<anonymous> (SchedulesSection.kt:71)");
            }
            Object objG = composer.G();
            if (objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.s0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$SchedulesSectionKt.k((ProfileItemEvent) obj);
                    }
                };
                composer.w(objG);
            }
            SchedulesSectionKt.B(null, (Function1) objG, composer, 48, 1);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(ProfileItemEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(LazyItemScope item, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(898520494, i3, -1, "cz.mobilesoft.coreblock.scene.dashboard.blocking.ComposableSingletons$SchedulesSectionKt.lambda$898520494.<anonymous> (SchedulesSection.kt:93)");
            }
            List listY = ProfileHelper.f129250a.y();
            Object objG = composer.G();
            if (objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.t0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$SchedulesSectionKt.m((ProfileItemEvent) obj);
                    }
                };
                composer.w(objG);
            }
            SchedulesSectionKt.t(null, listY, (Function1) objG, composer, 384, 1);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(ProfileItemEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(LazyItemScope item, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1057037781, i3, -1, "cz.mobilesoft.coreblock.scene.dashboard.blocking.ComposableSingletons$SchedulesSectionKt.lambda$-1057037781.<anonymous> (SchedulesSection.kt:75)");
            }
            SchedulesSectionKt.z(null, composer, 0, 1);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(LazyItemScope item, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-2119514505, i3, -1, "cz.mobilesoft.coreblock.scene.dashboard.blocking.ComposableSingletons$SchedulesSectionKt.lambda$-2119514505.<anonymous> (SchedulesSection.kt:89)");
            }
            SchedulesSectionKt.D(0.0f, 0, composer, 0, 3);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    public final Function2 h() {
        return f99945f;
    }
}
