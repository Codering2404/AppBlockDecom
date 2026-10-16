package cz.mobilesoft.coreblock.scene.premium.components;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.res.StringResources_androidKt;
import com.valentinilk.shimmer.Shimmer;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewEvent;
import cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewState;
import cz.mobilesoft.coreblock.scene.premium.dto.PremiumOptionDTO;
import cz.mobilesoft.coreblock.scene.premium.enums.PremiumOptionPeriod;
import cz.mobilesoft.coreblock.scene.premium.host.MySubscriptionPaywallViewModel;
import cz.mobilesoft.coreblock.util.ExternalLinksHelper;
import cz.mobilesoft.coreblock.util.Success;
import cz.mobilesoft.coreblock.util.compose.ShimmerThemeKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
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
public final class ComposableSingletons$MySubscriptionPaywallContentKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComposableSingletons$MySubscriptionPaywallContentKt f112542a = new ComposableSingletons$MySubscriptionPaywallContentKt();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Function2 f112543b = ComposableLambdaKt.c(-873360295, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.premium.components.g
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$MySubscriptionPaywallContentKt.i((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Function2 f112544c = ComposableLambdaKt.c(-478126533, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.premium.components.h
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$MySubscriptionPaywallContentKt.f((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-478126533, i3, -1, "cz.mobilesoft.coreblock.scene.premium.components.ComposableSingletons$MySubscriptionPaywallContentKt.lambda$-478126533.<anonymous> (MySubscriptionPaywallContent.kt:136)");
            }
            PaddingValues paddingValuesC = PaddingKt.c(0.0f, 0.0f, 3, null);
            Shimmer shimmerA = ShimmerThemeKt.a(null, composer, 0, 1);
            String strB = StringResources_androidKt.b(R.string.Jn, composer, 0);
            PremiumOptionPeriod premiumOptionPeriod = PremiumOptionPeriod.Yearly;
            MySubscriptionPaywallViewModel.ProductPlanScreenTypeViewState productPlanScreenTypeViewState = new MySubscriptionPaywallViewModel.ProductPlanScreenTypeViewState(CollectionsKt.listOf(TuplesKt.a(strB, StringResources_androidKt.b(premiumOptionPeriod.getTitleShort(), composer, 0))), StringResources_androidKt.b(R.string.iC, composer, 0), ExternalLinksHelper.f127866a.b(), true, true, null, false, false, 224, null);
            Success success = Success.f128020a;
            PremiumScreenViewState premiumScreenViewState = new PremiumScreenViewState(productPlanScreenTypeViewState, success, success, null, null, null, null, ExtensionsKt.a(), null, false, false, null, false, false, false, false, false, false, null, new PremiumOptionDTO(premiumOptionPeriod, false, "", StringResources_androidKt.b(R.string.fC, composer, 0), "100", null, null, null, null), null, null, false, false, false, null, StringResources_androidKt.b(R.string.vk, composer, 0), null, null, null, false, false, false, -201851528, 1, null);
            Object objG = composer.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.premium.components.i
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposableSingletons$MySubscriptionPaywallContentKt.g();
                    }
                };
                composer.w(objG);
            }
            Function0 function0 = (Function0) objG;
            Object objG2 = composer.G();
            if (objG2 == companion.a()) {
                objG2 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.premium.components.j
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$MySubscriptionPaywallContentKt.h((PremiumScreenViewEvent) obj);
                    }
                };
                composer.w(objG2);
            }
            MySubscriptionPaywallContentKt.i(paddingValuesC, premiumScreenViewState, shimmerA, function0, (Function1) objG2, composer, (Shimmer.f93784d << 6) | 27654);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(PremiumScreenViewEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-873360295, i3, -1, "cz.mobilesoft.coreblock.scene.premium.components.ComposableSingletons$MySubscriptionPaywallContentKt.lambda$-873360295.<anonymous> (MySubscriptionPaywallContent.kt:128)");
            }
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    public final Function2 e() {
        return f112543b;
    }
}
