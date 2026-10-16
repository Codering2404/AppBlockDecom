package com.revenuecat.purchases.ui.revenuecatui.customercenter;

import android.app.Activity;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

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
final class InternalCustomerCenterKt$InternalCustomerCenter$4$1 extends Lambda implements Function1<DisposableEffectScope, DisposableEffectResult> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ LifecycleOwner $lifecycleOwner;
    final /* synthetic */ CustomerCenterViewModel $viewModel;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            try {
                iArr[Lifecycle.Event.ON_STOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Lifecycle.Event.ON_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Lifecycle.Event.ON_RESUME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InternalCustomerCenterKt$InternalCustomerCenter$4$1(LifecycleOwner lifecycleOwner, CustomerCenterViewModel customerCenterViewModel, Activity activity) {
        super(1);
        this.$lifecycleOwner = lifecycleOwner;
        this.$viewModel = customerCenterViewModel;
        this.$activity = activity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$0(CustomerCenterViewModel customerCenterViewModel, Activity activity, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(event, "event");
        int i3 = WhenMappings.$EnumSwitchMapping$0[event.ordinal()];
        if (i3 == 1) {
            customerCenterViewModel.onActivityStopped(activity != null && activity.isChangingConfigurations());
        } else if (i3 == 2) {
            customerCenterViewModel.onActivityStarted();
        } else {
            if (i3 != 3) {
                return;
            }
            customerCenterViewModel.onActivityResumed();
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        final CustomerCenterViewModel customerCenterViewModel = this.$viewModel;
        final Activity activity = this.$activity;
        final LifecycleEventObserver lifecycleEventObserver = new LifecycleEventObserver() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.a
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void j(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                InternalCustomerCenterKt$InternalCustomerCenter$4$1.invoke$lambda$0(customerCenterViewModel, activity, lifecycleOwner, event);
            }
        };
        this.$lifecycleOwner.getLifecycle().addObserver(lifecycleEventObserver);
        final LifecycleOwner lifecycleOwner = this.$lifecycleOwner;
        return new DisposableEffectResult() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.InternalCustomerCenterKt$InternalCustomerCenter$4$1$invoke$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                lifecycleOwner.getLifecycle().removeObserver(lifecycleEventObserver);
            }
        };
    }
}
