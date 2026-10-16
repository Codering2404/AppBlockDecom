package cz.mobilesoft.coreblock.scene.sharing;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.unit.Dp;
import cz.mobilesoft.coreblock.scene.sharing.dto.SocialsSharePayload;
import cz.mobilesoft.coreblock.scene.sharing.images.SocialShareTemplate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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
public final class ComposableSingletons$SocialSharingScreenKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComposableSingletons$SocialSharingScreenKt f119322a = new ComposableSingletons$SocialSharingScreenKt();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Function2 f119323b = ComposableLambdaKt.c(-850148596, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.sharing.a
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$SocialSharingScreenKt.d((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-850148596, i3, -1, "cz.mobilesoft.coreblock.scene.sharing.ComposableSingletons$SocialSharingScreenKt.lambda$-850148596.<anonymous> (SocialSharingScreen.kt:384)");
            }
            PaddingValues paddingValuesA = PaddingKt.a(Dp.g(0));
            SocialsSharingViewState socialsSharingViewState = new SocialsSharingViewState(0, new SocialsSharePayload(SocialsSharePayload.PeriodType.Day, CollectionsKt.listOf((Object[]) new Float[]{Float.valueOf(120.0f), Float.valueOf(90.0f), Float.valueOf(150.0f), Float.valueOf(180.0f), Float.valueOf(200.0f), Float.valueOf(160.0f), Float.valueOf(140.0f)}), null, null, 0, "4h 30m", 42, 0L, 0L, null, null, null, null, null, null, null, 65436, null), "Today", "+15 min", null, CollectionsKt.listOf((Object[]) new SocialShareTemplate[]{SocialShareTemplate.ScreenTimeSquare, SocialShareTemplate.ScreenTimePortrait, SocialShareTemplate.ScreenTimeTransparent}), 17, null);
            Object objG = composer.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.sharing.b
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$SocialSharingScreenKt.e((SocialsSharingViewEvent) obj);
                    }
                };
                composer.w(objG);
            }
            Function1 function1 = (Function1) objG;
            Object objG2 = composer.G();
            if (objG2 == companion.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.sharing.c
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposableSingletons$SocialSharingScreenKt.f();
                    }
                };
                composer.w(objG2);
            }
            SocialSharingScreenKt.p(paddingValuesA, socialsSharingViewState, function1, (Function0) objG2, composer, 3462);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(SocialsSharingViewEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f() {
        return Unit.f139807a;
    }
}
