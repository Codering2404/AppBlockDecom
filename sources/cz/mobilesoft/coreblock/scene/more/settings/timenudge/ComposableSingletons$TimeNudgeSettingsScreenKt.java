package cz.mobilesoft.coreblock.scene.more.settings.timenudge;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import cz.mobilesoft.coreblock.enums.Permission;
import cz.mobilesoft.coreblock.util.permissions.PermissionDTO;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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
public final class ComposableSingletons$TimeNudgeSettingsScreenKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComposableSingletons$TimeNudgeSettingsScreenKt f110266a = new ComposableSingletons$TimeNudgeSettingsScreenKt();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Function2 f110267b = ComposableLambdaKt.c(1616409063, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.settings.timenudge.a
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$TimeNudgeSettingsScreenKt.k((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Function2 f110268c = ComposableLambdaKt.c(-1167449605, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.settings.timenudge.b
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$TimeNudgeSettingsScreenKt.q((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Function2 f110269d = ComposableLambdaKt.c(840985592, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.settings.timenudge.c
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$TimeNudgeSettingsScreenKt.m((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Function2 f110270e = ComposableLambdaKt.c(-346412607, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.settings.timenudge.d
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$TimeNudgeSettingsScreenKt.s((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Function2 f110271f = ComposableLambdaKt.c(853454752, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.settings.timenudge.e
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$TimeNudgeSettingsScreenKt.o((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1616409063, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.timenudge.ComposableSingletons$TimeNudgeSettingsScreenKt.lambda$1616409063.<anonymous> (TimeNudgeSettingsScreen.kt:439)");
            }
            TimeNudgeSettingsViewState timeNudgeSettingsViewState = new TimeNudgeSettingsViewState(true, CollectionsKt.listOf("com.instagram.android"), CollectionsKt.listOf(new PermissionDTO(Permission.ALARM_EXACT.f96997d, false, false, 6, null)), false, 8, null);
            Object objG = composer.G();
            if (objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.timenudge.j
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$TimeNudgeSettingsScreenKt.l((TimeNudgeSettingsViewEvent) obj);
                    }
                };
                composer.w(objG);
            }
            TimeNudgeSettingsScreenKt.A(timeNudgeSettingsViewState, (Function1) objG, null, composer, 48, 4);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(TimeNudgeSettingsViewEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(840985592, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.timenudge.ComposableSingletons$TimeNudgeSettingsScreenKt.lambda$840985592.<anonymous> (TimeNudgeSettingsScreen.kt:469)");
            }
            TimeNudgeSettingsViewState timeNudgeSettingsViewState = new TimeNudgeSettingsViewState(false, CollectionsKt.listOf("com.instagram.android"), CollectionsKt.emptyList(), false, 8, null);
            Object objG = composer.G();
            if (objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.timenudge.i
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$TimeNudgeSettingsScreenKt.n((TimeNudgeSettingsViewEvent) obj);
                    }
                };
                composer.w(objG);
            }
            TimeNudgeSettingsScreenKt.A(timeNudgeSettingsViewState, (Function1) objG, null, composer, 48, 4);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(TimeNudgeSettingsViewEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(853454752, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.timenudge.ComposableSingletons$TimeNudgeSettingsScreenKt.lambda$853454752.<anonymous> (TimeNudgeSettingsScreen.kt:500)");
            }
            TimeNudgeSettingsViewState timeNudgeSettingsViewState = new TimeNudgeSettingsViewState(false, null, null, false, 11, null);
            Object objG = composer.G();
            if (objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.timenudge.g
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$TimeNudgeSettingsScreenKt.p((TimeNudgeSettingsViewEvent) obj);
                    }
                };
                composer.w(objG);
            }
            TimeNudgeSettingsScreenKt.A(timeNudgeSettingsViewState, (Function1) objG, null, composer, 48, 4);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(TimeNudgeSettingsViewEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1167449605, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.timenudge.ComposableSingletons$TimeNudgeSettingsScreenKt.lambda$-1167449605.<anonymous> (TimeNudgeSettingsScreen.kt:454)");
            }
            TimeNudgeSettingsViewState timeNudgeSettingsViewState = new TimeNudgeSettingsViewState(true, CollectionsKt.listOf((Object[]) new String[]{"com.instagram.android", "com.zhiliaoapp.musically"}), CollectionsKt.emptyList(), false, 8, null);
            Object objG = composer.G();
            if (objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.timenudge.h
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$TimeNudgeSettingsScreenKt.r((TimeNudgeSettingsViewEvent) obj);
                    }
                };
                composer.w(objG);
            }
            TimeNudgeSettingsScreenKt.A(timeNudgeSettingsViewState, (Function1) objG, null, composer, 48, 4);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r(TimeNudgeSettingsViewEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-346412607, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.timenudge.ComposableSingletons$TimeNudgeSettingsScreenKt.lambda$-346412607.<anonymous> (TimeNudgeSettingsScreen.kt:484)");
            }
            TimeNudgeSettingsViewState timeNudgeSettingsViewState = new TimeNudgeSettingsViewState(true, CollectionsKt.emptyList(), CollectionsKt.emptyList(), true);
            Object objG = composer.G();
            if (objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.timenudge.f
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$TimeNudgeSettingsScreenKt.t((TimeNudgeSettingsViewEvent) obj);
                    }
                };
                composer.w(objG);
            }
            TimeNudgeSettingsScreenKt.A(timeNudgeSettingsViewState, (Function1) objG, null, composer, 48, 4);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(TimeNudgeSettingsViewEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.f139807a;
    }
}
