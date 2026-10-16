package cz.mobilesoft.coreblock.scene.premium.components;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.valentinilk.shimmer.Shimmer;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewEvent;
import cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewState;
import cz.mobilesoft.coreblock.scene.premium.host.PaywallLayout;
import cz.mobilesoft.coreblock.util.compose.ShimmerThemeKt;
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
public final class ComposableSingletons$StandardPaywallContentKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComposableSingletons$StandardPaywallContentKt f112565a = new ComposableSingletons$StandardPaywallContentKt();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Function2 f112566b = ComposableLambdaKt.c(-1574219821, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.premium.components.c0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$StandardPaywallContentKt.d((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1574219821, i3, -1, "cz.mobilesoft.coreblock.scene.premium.components.ComposableSingletons$StandardPaywallContentKt.lambda$-1574219821.<anonymous> (StandardPaywallContent.kt:127)");
            }
            PaddingValues paddingValuesC = PaddingKt.c(0.0f, 0.0f, 3, null);
            PremiumScreenViewState premiumScreenViewState = new PremiumScreenViewState(new PremiumScreenViewState.PremiumScreenTypeViewState() { // from class: cz.mobilesoft.coreblock.scene.premium.components.ComposableSingletons$StandardPaywallContentKt$lambda$-1574219821$1$1

                /* JADX INFO: renamed from: j, reason: collision with root package name */
                private final int f112567j = R.string.bC;

                @Override // cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewState.PremiumScreenTypeViewState
                public Integer b() {
                    return Integer.valueOf(this.f112567j);
                }
            }, null, null, null, null, null, null, null, null, false, false, null, false, false, false, false, false, false, null, null, null, null, false, false, false, null, null, null, null, null, false, false, false, -2, 1, null);
            Shimmer shimmerA = ShimmerThemeKt.a(null, composer, 0, 1);
            Object objG = composer.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.premium.components.d0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposableSingletons$StandardPaywallContentKt.e();
                    }
                };
                composer.w(objG);
            }
            Function0 function0 = (Function0) objG;
            Object objG2 = composer.G();
            if (objG2 == companion.a()) {
                objG2 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.premium.components.e0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$StandardPaywallContentKt.f((PremiumScreenViewEvent) obj);
                    }
                };
                composer.w(objG2);
            }
            StandardPaywallContentKt.h(paddingValuesC, premiumScreenViewState, shimmerA, false, function0, (Function1) objG2, new PaywallLayout.Standard(true, true, true, true, true, false, 32, null), composer, 224262 | (Shimmer.f93784d << 6));
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f(PremiumScreenViewEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.f139807a;
    }
}
