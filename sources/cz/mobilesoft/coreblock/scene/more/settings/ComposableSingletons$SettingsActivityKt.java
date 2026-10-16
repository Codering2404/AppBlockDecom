package cz.mobilesoft.coreblock.scene.more.settings;

import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.navigation.NavBackStackEntry;
import com.facebook.stetho.inspector.helper.qp.sKeKFMqmvNzY;
import cz.mobilesoft.coreblock.scene.more.settings.ComposableSingletons$SettingsActivityKt;
import cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences.BlockingPreferencesScreenKt;
import cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsScreenKt;
import cz.mobilesoft.coreblock.scene.more.settings.notification.NotificationSettingsScreenKt;
import cz.mobilesoft.coreblock.scene.more.settings.statistics.StatisticsSettingsScreenKt;
import cz.mobilesoft.coreblock.scene.more.settings.timenudge.TimeNudgeSettingsScreenKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
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
public final class ComposableSingletons$SettingsActivityKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComposableSingletons$SettingsActivityKt f108025a = new ComposableSingletons$SettingsActivityKt();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Function4 f108026b = ComposableLambdaKt.c(185745839, false, new Function4() { // from class: c1.h
        @Override // kotlin.jvm.functions.Function4
        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            return ComposableSingletons$SettingsActivityKt.k((AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Function4 f108027c = ComposableLambdaKt.c(334663768, false, new Function4() { // from class: c1.i
        @Override // kotlin.jvm.functions.Function4
        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            return ComposableSingletons$SettingsActivityKt.l((AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Function4 f108028d = ComposableLambdaKt.c(-633297161, false, new Function4() { // from class: c1.j
        @Override // kotlin.jvm.functions.Function4
        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            return ComposableSingletons$SettingsActivityKt.o((AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
        }
    });

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Function4 f108029e = ComposableLambdaKt.c(-1601258090, false, new Function4() { // from class: c1.k
        @Override // kotlin.jvm.functions.Function4
        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            return ComposableSingletons$SettingsActivityKt.n((AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
        }
    });

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Function4 f108030f = ComposableLambdaKt.c(757787348, false, new Function4() { // from class: c1.l
        @Override // kotlin.jvm.functions.Function4
        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            return ComposableSingletons$SettingsActivityKt.m((AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(185745839, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.ComposableSingletons$SettingsActivityKt.lambda$185745839.<anonymous> (SettingsActivity.kt:101)");
        }
        GeneralSettingsScreenKt.A(composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(757787348, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.ComposableSingletons$SettingsActivityKt.lambda$757787348.<anonymous> (SettingsActivity.kt:121)");
        }
        TimeNudgeSettingsScreenKt.F(null, composer, 0, 1);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(-1601258090, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.ComposableSingletons$SettingsActivityKt.lambda$-1601258090.<anonymous> (SettingsActivity.kt:110)");
        }
        StatisticsSettingsScreenKt.o(null, composer, 0, 1);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(-633297161, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.ComposableSingletons$SettingsActivityKt.lambda$-633297161.<anonymous> (SettingsActivity.kt:107)");
        }
        NotificationSettingsScreenKt.a0(composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    public final Function4 f() {
        return f108029e;
    }

    public final Function4 g() {
        return f108028d;
    }

    public final Function4 h() {
        return f108026b;
    }

    public final Function4 i() {
        return f108027c;
    }

    public final Function4 j() {
        return f108030f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(AnimatedContentScope animatedContentScope, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(animatedContentScope, sKeKFMqmvNzY.bsisHIkXYLRc);
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(334663768, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.ComposableSingletons$SettingsActivityKt.lambda$334663768.<anonymous> (SettingsActivity.kt:104)");
        }
        BlockingPreferencesScreenKt.F(composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }
}
