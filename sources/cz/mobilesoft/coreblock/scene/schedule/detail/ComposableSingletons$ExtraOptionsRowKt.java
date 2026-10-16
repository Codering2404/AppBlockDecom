package cz.mobilesoft.coreblock.scene.schedule.detail;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import cz.mobilesoft.coreblock.enums.PremiumState;
import cz.mobilesoft.coreblock.scene.schedule.ScheduleViewEvent;
import cz.mobilesoft.coreblock.scene.schedule.detail.ExtraOption;
import cz.mobilesoft.coreblock.scene.schedule.detail.ScheduleViewState;
import kotlin.Metadata;
import kotlin.Unit;
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
public final class ComposableSingletons$ExtraOptionsRowKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComposableSingletons$ExtraOptionsRowKt f116529a = new ComposableSingletons$ExtraOptionsRowKt();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Function2 f116530b = ComposableLambdaKt.c(1361110457, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.b2
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$ExtraOptionsRowKt.e((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Function2 f116531c = ComposableLambdaKt.c(-780455654, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.c2
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$ExtraOptionsRowKt.g((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1361110457, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.detail.ComposableSingletons$ExtraOptionsRowKt.lambda$1361110457.<anonymous> (ExtraOptionsRow.kt:54)");
            }
            ScheduleViewState.DetailViewState detailViewState = new ScheduleViewState.DetailViewState(null, null, null, false, false, null, null, null, false, null, null, PremiumState.Subscription.Yearly.INSTANCE, null, false, false, null, false, false, false, false, false, false, false, null, null, ExtensionsKt.b(new ExtraOption.AddNewlyInstalledApps(true), new ExtraOption.AdultContentBlocking(false), new ExtraOption.InAppPurchasesBlocking(false), new ExtraOption.BlockUnsupportedBrowsers(false)), 33552383, null);
            Object objG = composer.G();
            if (objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.e2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$ExtraOptionsRowKt.f((ScheduleViewEvent) obj);
                    }
                };
                composer.w(objG);
            }
            ExtraOptionsRowKt.v(detailViewState, false, (Function1) objG, composer, 432);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f(ScheduleViewEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-780455654, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.detail.ComposableSingletons$ExtraOptionsRowKt.lambda$-780455654.<anonymous> (ExtraOptionsRow.kt:74)");
            }
            ScheduleViewState.DetailViewState detailViewState = new ScheduleViewState.DetailViewState(null, null, null, false, false, null, null, null, false, null, null, null, null, false, false, null, false, false, false, false, false, false, false, null, null, ExtensionsKt.b(new ExtraOption.AddNewlyInstalledApps(true), new ExtraOption.AdultContentBlocking(false), new ExtraOption.InAppPurchasesBlocking(false), new ExtraOption.BlockUnsupportedBrowsers(false)), 33554431, null);
            Object objG = composer.G();
            if (objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.d2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$ExtraOptionsRowKt.h((ScheduleViewEvent) obj);
                    }
                };
                composer.w(objG);
            }
            ExtraOptionsRowKt.v(detailViewState, false, (Function1) objG, composer, 432);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(ScheduleViewEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.f139807a;
    }
}
