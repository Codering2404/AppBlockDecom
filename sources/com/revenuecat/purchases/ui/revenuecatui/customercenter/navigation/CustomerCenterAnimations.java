package com.revenuecat.purchases.ui.revenuecatui.customercenter.navigation;

import androidx.compose.animation.AnimatedContentKt;
import androidx.compose.animation.ContentTransform;
import androidx.compose.animation.EnterExitTransitionKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class CustomerCenterAnimations {
    public static final int $stable = 0;
    public static final CustomerCenterAnimations INSTANCE = new CustomerCenterAnimations();

    private CustomerCenterAnimations() {
    }

    public final ContentTransform getTransitionForNavigation(CustomerCenterDestination from, CustomerCenterDestination to, CustomerCenterNavigationState navigationState) {
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(to, "to");
        Intrinsics.checkNotNullParameter(navigationState, "navigationState");
        return navigationState.isBackwardTransition(from, to) ? AnimatedContentKt.f(EnterExitTransitionKt.D(null, new Function1<Integer, Integer>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.navigation.CustomerCenterAnimations.getTransitionForNavigation.1
            public final Integer invoke(int i3) {
                return Integer.valueOf(-i3);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).intValue());
            }
        }, 1, null), EnterExitTransitionKt.I(null, new Function1<Integer, Integer>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.navigation.CustomerCenterAnimations.getTransitionForNavigation.2
            public final Integer invoke(int i3) {
                return Integer.valueOf(i3);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).intValue());
            }
        }, 1, null)) : AnimatedContentKt.f(EnterExitTransitionKt.D(null, new Function1<Integer, Integer>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.navigation.CustomerCenterAnimations.getTransitionForNavigation.3
            public final Integer invoke(int i3) {
                return Integer.valueOf(i3);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).intValue());
            }
        }, 1, null), EnterExitTransitionKt.I(null, new Function1<Integer, Integer>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.navigation.CustomerCenterAnimations.getTransitionForNavigation.4
            public final Integer invoke(int i3) {
                return Integer.valueOf(-i3);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).intValue());
            }
        }, 1, null));
    }
}
