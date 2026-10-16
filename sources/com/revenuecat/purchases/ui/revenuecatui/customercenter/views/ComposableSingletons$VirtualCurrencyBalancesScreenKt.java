package com.revenuecat.purchases.ui.revenuecatui.customercenter.views;

import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.data.CustomerCenterConfigTestData;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.views.VirtualCurrencyBalancesScreenViewState;
import com.revenuecat.purchases.virtualcurrencies.VirtualCurrency;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
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
public final class ComposableSingletons$VirtualCurrencyBalancesScreenKt {
    public static final ComposableSingletons$VirtualCurrencyBalancesScreenKt INSTANCE = new ComposableSingletons$VirtualCurrencyBalancesScreenKt();

    /* JADX INFO: renamed from: lambda-1, reason: not valid java name */
    public static Function3<LazyItemScope, Composer, Integer, Unit> f25lambda1 = ComposableLambdaKt.c(-1342872368, false, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.ComposableSingletons$VirtualCurrencyBalancesScreenKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke((LazyItemScope) obj, (Composer) obj2, ((Number) obj3).intValue());
            return Unit.f139807a;
        }

        public final void invoke(LazyItemScope item, Composer composer, int i3) {
            Intrinsics.checkNotNullParameter(item, "$this$item");
            if ((i3 & 17) == 16 && composer.l()) {
                composer.Q();
                return;
            }
            if (ComposerKt.M()) {
                ComposerKt.U(-1342872368, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.ComposableSingletons$VirtualCurrencyBalancesScreenKt.lambda-1.<anonymous> (VirtualCurrencyBalancesScreen.kt:77)");
            }
            CustomerCenterLoadingViewKt.CustomerCenterLoadingView(composer, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-2, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f26lambda2 = ComposableLambdaKt.c(1446237222, false, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.ComposableSingletons$VirtualCurrencyBalancesScreenKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return Unit.f139807a;
        }

        public final void invoke(Composer composer, int i3) {
            if ((i3 & 3) == 2 && composer.l()) {
                composer.Q();
                return;
            }
            if (ComposerKt.M()) {
                ComposerKt.U(1446237222, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.ComposableSingletons$VirtualCurrencyBalancesScreenKt.lambda-2.<anonymous> (VirtualCurrencyBalancesScreen.kt:191)");
            }
            CustomerCenterConfigTestData customerCenterConfigTestData = CustomerCenterConfigTestData.INSTANCE;
            VirtualCurrencyBalancesScreenKt.InternalVirtualCurrencyBalancesScreen(customerCenterConfigTestData.getStandardAppearance(), CustomerCenterConfigTestData.customerCenterData$default(customerCenterConfigTestData, false, false, 3, null).getLocalization(), new VirtualCurrencyBalancesScreenViewState.Loaded(CollectionsKt.emptyList()), null, composer, 0, 8);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-3, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f27lambda3 = ComposableLambdaKt.c(-1872635862, false, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.ComposableSingletons$VirtualCurrencyBalancesScreenKt$lambda-3$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return Unit.f139807a;
        }

        public final void invoke(Composer composer, int i3) {
            if ((i3 & 3) == 2 && composer.l()) {
                composer.Q();
                return;
            }
            if (ComposerKt.M()) {
                ComposerKt.U(-1872635862, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.ComposableSingletons$VirtualCurrencyBalancesScreenKt.lambda-3.<anonymous> (VirtualCurrencyBalancesScreen.kt:206)");
            }
            CustomerCenterConfigTestData customerCenterConfigTestData = CustomerCenterConfigTestData.INSTANCE;
            VirtualCurrencyBalancesScreenKt.InternalVirtualCurrencyBalancesScreen(customerCenterConfigTestData.getStandardAppearance(), CustomerCenterConfigTestData.customerCenterData$default(customerCenterConfigTestData, false, false, 3, null).getLocalization(), new VirtualCurrencyBalancesScreenViewState.Loaded(CollectionsKt.sortedWith(customerCenterConfigTestData.getFourVirtualCurrencies().getAll().values(), new Comparator() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.ComposableSingletons$VirtualCurrencyBalancesScreenKt$lambda-3$1$invoke$$inlined$sortedByDescending$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t2, T t3) {
                    return ComparisonsKt.d(Integer.valueOf(((VirtualCurrency) t3).getBalance()), Integer.valueOf(((VirtualCurrency) t2).getBalance()));
                }
            })), null, composer, 0, 8);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-4, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f28lambda4 = ComposableLambdaKt.c(1987147076, false, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.ComposableSingletons$VirtualCurrencyBalancesScreenKt$lambda-4$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return Unit.f139807a;
        }

        public final void invoke(Composer composer, int i3) {
            if ((i3 & 3) == 2 && composer.l()) {
                composer.Q();
                return;
            }
            if (ComposerKt.M()) {
                ComposerKt.U(1987147076, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.ComposableSingletons$VirtualCurrencyBalancesScreenKt.lambda-4.<anonymous> (VirtualCurrencyBalancesScreen.kt:223)");
            }
            CustomerCenterConfigTestData customerCenterConfigTestData = CustomerCenterConfigTestData.INSTANCE;
            VirtualCurrencyBalancesScreenKt.InternalVirtualCurrencyBalancesScreen(customerCenterConfigTestData.getStandardAppearance(), CustomerCenterConfigTestData.customerCenterData$default(customerCenterConfigTestData, false, false, 3, null).getLocalization(), new VirtualCurrencyBalancesScreenViewState.Loaded(CollectionsKt.sortedWith(customerCenterConfigTestData.getFiveVirtualCurrencies().getAll().values(), new Comparator() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.ComposableSingletons$VirtualCurrencyBalancesScreenKt$lambda-4$1$invoke$$inlined$sortedByDescending$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t2, T t3) {
                    return ComparisonsKt.d(Integer.valueOf(((VirtualCurrency) t3).getBalance()), Integer.valueOf(((VirtualCurrency) t2).getBalance()));
                }
            })), null, composer, 0, 8);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-5, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f29lambda5 = ComposableLambdaKt.c(-1907101527, false, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.ComposableSingletons$VirtualCurrencyBalancesScreenKt$lambda-5$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return Unit.f139807a;
        }

        public final void invoke(Composer composer, int i3) {
            if ((i3 & 3) == 2 && composer.l()) {
                composer.Q();
                return;
            }
            if (ComposerKt.M()) {
                ComposerKt.U(-1907101527, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.ComposableSingletons$VirtualCurrencyBalancesScreenKt.lambda-5.<anonymous> (VirtualCurrencyBalancesScreen.kt:240)");
            }
            CustomerCenterConfigTestData customerCenterConfigTestData = CustomerCenterConfigTestData.INSTANCE;
            VirtualCurrencyBalancesScreenKt.InternalVirtualCurrencyBalancesScreen(customerCenterConfigTestData.getStandardAppearance(), CustomerCenterConfigTestData.customerCenterData$default(customerCenterConfigTestData, false, false, 3, null).getLocalization(), VirtualCurrencyBalancesScreenViewState.Loading.INSTANCE, null, composer, 384, 8);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-6, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f30lambda6 = ComposableLambdaKt.c(669156317, false, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.ComposableSingletons$VirtualCurrencyBalancesScreenKt$lambda-6$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return Unit.f139807a;
        }

        public final void invoke(Composer composer, int i3) {
            if ((i3 & 3) == 2 && composer.l()) {
                composer.Q();
                return;
            }
            if (ComposerKt.M()) {
                ComposerKt.U(669156317, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.ComposableSingletons$VirtualCurrencyBalancesScreenKt.lambda-6.<anonymous> (VirtualCurrencyBalancesScreen.kt:255)");
            }
            CustomerCenterConfigTestData customerCenterConfigTestData = CustomerCenterConfigTestData.INSTANCE;
            VirtualCurrencyBalancesScreenKt.InternalVirtualCurrencyBalancesScreen(customerCenterConfigTestData.getStandardAppearance(), CustomerCenterConfigTestData.customerCenterData$default(customerCenterConfigTestData, false, false, 3, null).getLocalization(), new VirtualCurrencyBalancesScreenViewState.Error(new PurchasesError(PurchasesErrorCode.UnknownError, "Mock error")), null, composer, 0, 8);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
    });

    /* JADX INFO: renamed from: getLambda-1$revenuecatui_defaultsBc8Release, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m1018getLambda1$revenuecatui_defaultsBc8Release() {
        return f25lambda1;
    }

    /* JADX INFO: renamed from: getLambda-2$revenuecatui_defaultsBc8Release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1019getLambda2$revenuecatui_defaultsBc8Release() {
        return f26lambda2;
    }

    /* JADX INFO: renamed from: getLambda-3$revenuecatui_defaultsBc8Release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1020getLambda3$revenuecatui_defaultsBc8Release() {
        return f27lambda3;
    }

    /* JADX INFO: renamed from: getLambda-4$revenuecatui_defaultsBc8Release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1021getLambda4$revenuecatui_defaultsBc8Release() {
        return f28lambda4;
    }

    /* JADX INFO: renamed from: getLambda-5$revenuecatui_defaultsBc8Release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1022getLambda5$revenuecatui_defaultsBc8Release() {
        return f29lambda5;
    }

    /* JADX INFO: renamed from: getLambda-6$revenuecatui_defaultsBc8Release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1023getLambda6$revenuecatui_defaultsBc8Release() {
        return f30lambda6;
    }
}
