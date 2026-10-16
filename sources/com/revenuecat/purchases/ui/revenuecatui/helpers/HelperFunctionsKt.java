package com.revenuecat.purchases.ui.revenuecatui.helpers;

import android.app.Activity;
import android.content.res.Configuration;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.InspectionModeKt;
import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.EntitlementInfo;
import com.revenuecat.purchases.ListenerConversionsKt;
import com.revenuecat.purchases.Purchases;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;

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
public final class HelperFunctionsKt {
    private static final ProvidableCompositionLocal<Activity> LocalActivity = CompositionLocalKt.e(null, new Function0<Activity>() { // from class: com.revenuecat.purchases.ui.revenuecatui.helpers.HelperFunctionsKt$LocalActivity$1
        @Override // kotlin.jvm.functions.Function0
        public final Activity invoke() {
            return null;
        }
    }, 1, null);

    public static final ProvidableCompositionLocal<Activity> getLocalActivity() {
        return LocalActivity;
    }

    public static final boolean isInPreviewMode(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(774792703, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.helpers.isInPreviewMode (HelperFunctions.kt:23)");
        }
        boolean zBooleanValue = ((Boolean) composer.q(InspectionModeKt.a())).booleanValue();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return zBooleanValue;
    }

    public static final Function1<CustomerInfo, Boolean> shouldDisplayBlockForEntitlementIdentifier(final String entitlement) {
        Intrinsics.checkNotNullParameter(entitlement, "entitlement");
        return new Function1<CustomerInfo, Boolean>() { // from class: com.revenuecat.purchases.ui.revenuecatui.helpers.HelperFunctionsKt.shouldDisplayBlockForEntitlementIdentifier.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(CustomerInfo customerInfo) {
                Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
                EntitlementInfo entitlementInfo = customerInfo.getEntitlements().get(entitlement);
                boolean z2 = false;
                if (entitlementInfo != null && entitlementInfo.isActive()) {
                    z2 = true;
                }
                return Boolean.valueOf(!z2);
            }
        };
    }

    public static final void shouldDisplayPaywall(final Function1<? super CustomerInfo, Boolean> shouldDisplayBlock, final Function1<? super Boolean, Unit> result) {
        Intrinsics.checkNotNullParameter(shouldDisplayBlock, "shouldDisplayBlock");
        Intrinsics.checkNotNullParameter(result, "result");
        ListenerConversionsKt.getCustomerInfoWith(Purchases.Companion.getSharedInstance(), new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.helpers.HelperFunctionsKt.shouldDisplayPaywall.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((PurchasesError) obj);
                return Unit.f139807a;
            }

            public final void invoke(PurchasesError it) {
                Intrinsics.checkNotNullParameter(it, "it");
                Logger.INSTANCE.e("Error fetching customer info to display paywall", new PurchasesException(it));
                result.invoke(Boolean.FALSE);
            }
        }, new Function1<CustomerInfo, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.helpers.HelperFunctionsKt.shouldDisplayPaywall.4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((CustomerInfo) obj);
                return Unit.f139807a;
            }

            public final void invoke(CustomerInfo it) {
                Intrinsics.checkNotNullParameter(it, "it");
                Boolean bool = (Boolean) shouldDisplayBlock.invoke(it);
                if (bool.booleanValue()) {
                    Logger.INSTANCE.d("Displaying paywall according to display logic");
                } else {
                    Logger.INSTANCE.d("Not displaying paywall according to display logic");
                }
                result.invoke(bool);
            }
        });
    }

    public static final float windowAspectRatio(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(1944383602, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.helpers.windowAspectRatio (HelperFunctions.kt:27)");
        }
        Configuration configuration = (Configuration) composer.q(AndroidCompositionLocals_androidKt.f());
        float f3 = configuration.screenHeightDp / configuration.screenWidthDp;
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return f3;
    }

    public static final Object shouldDisplayPaywall(Function1<? super CustomerInfo, Boolean> function1, Continuation<? super Boolean> continuation) {
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
        cancellableContinuationImpl.C();
        shouldDisplayPaywall(function1, new Function1<Boolean, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.helpers.HelperFunctionsKt$shouldDisplayPaywall$2$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke(((Boolean) obj).booleanValue());
                return Unit.f139807a;
            }

            public final void invoke(boolean z2) {
                CancellableContinuationExtensionsKt.safeResume(cancellableContinuationImpl, Boolean.valueOf(z2));
            }
        });
        Object objV = cancellableContinuationImpl.v();
        if (objV == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return objV;
    }
}
