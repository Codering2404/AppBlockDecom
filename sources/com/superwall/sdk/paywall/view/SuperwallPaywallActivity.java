package com.superwall.sdk.paywall.view;

import android.R;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.ComponentCaller;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Outline;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import android.view.Window;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.SystemBarStyle;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewGroupKt;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.superwall.sdk.Superwall;
import com.superwall.sdk.dependencies.DeviceHelperFactory;
import com.superwall.sdk.logger.LogLevel;
import com.superwall.sdk.logger.LogScope;
import com.superwall.sdk.logger.Logger;
import com.superwall.sdk.misc.Color_HelpersKt;
import com.superwall.sdk.misc.Either;
import com.superwall.sdk.misc.EitherKt;
import com.superwall.sdk.models.paywall.LocalNotification;
import com.superwall.sdk.models.paywall.Paywall;
import com.superwall.sdk.models.paywall.PaywallPresentationStyle;
import com.superwall.sdk.network.JsonFactory;
import com.superwall.sdk.paywall.presentation.PaywallCloseReason;
import com.superwall.sdk.paywall.presentation.PaywallInfo;
import com.superwall.sdk.paywall.presentation.internal.state.PaywallResult;
import com.superwall.sdk.paywall.view.PaywallViewState;
import com.superwall.sdk.paywall.view.SuperwallPaywallActivity;
import com.superwall.sdk.paywall.view.webview.PaywallWebUI;
import com.superwall.sdk.store.transactions.notifications.NotificationScheduler;
import com.superwall.sdk.utilities.ErrorTrackingKt;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

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
public final class SuperwallPaywallActivity extends AppCompatActivity {
    private static final String ACTIVE_PAYWALL_TAG = "active_paywall";
    public static final Companion Companion = new Companion(null);
    private static final long DEFAULT_DELAY = 300;
    private static final String IS_LIGHT_BACKGROUND_KEY = "isLightBackgroundKey";
    private static final String NOTIFICATION_CHANNEL_DESCRIPTION = "Notifications sent when a free trial is about to end.";
    public static final String NOTIFICATION_CHANNEL_ID = "com.superwall.android.notifications";
    private static final String NOTIFICATION_CHANNEL_NAME = "Trial Reminder Notifications";
    private static final String PRESENTATION_STYLE_KEY = "presentationStyleKey";
    private static final int REQUEST_CODE_NOTIFICATION_PERMISSION = 1001;
    private static final String VIEW_KEY = "viewKey";
    private BottomSheetBehavior.BottomSheetCallback bottomSheetCallback;
    private View contentView;
    private final CoroutineScope mainScope = CoroutineScopeKt.a(Dispatchers.c());
    private NotificationPermissionCallback notificationPermissionCallback;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void prepareViewForDisplay(PaywallView paywallView, String str) {
            ShimmerView shimmerView;
            paywallView.getWebView$superwall_release().enableBackgroundRendering();
            paywallView.getWebView$superwall_release().attach(paywallView);
            ViewStorageViewModel viewStorageViewModelMakeViewStore = Superwall.Companion.getInstance().getDependencyContainer$superwall_release().makeViewStore();
            Iterator it = ViewGroupKt.a(paywallView).iterator();
            while (true) {
                if (it.hasNext()) {
                    View view = (View) it.next();
                    if ((view instanceof LoadingView) || (view instanceof ShimmerView)) {
                        break;
                    }
                } else {
                    View viewRetrieveView = viewStorageViewModelMakeViewStore.retrieveView(LoadingView.TAG);
                    Intrinsics.checkNotNull(viewRetrieveView, "null cannot be cast to non-null type com.superwall.sdk.paywall.view.LoadingView");
                    PaywallPurchaseLoadingView paywallPurchaseLoadingView = (LoadingView) viewRetrieveView;
                    if (paywallView.getState().getPaywall().getPresentation().getStyle() instanceof PaywallPresentationStyle.Popup) {
                        Context context = paywallView.getContext();
                        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                        shimmerView = new ShimmerView(context, null, 2, null);
                        shimmerView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                    } else {
                        View viewRetrieveView2 = viewStorageViewModelMakeViewStore.retrieveView(ShimmerView.TAG);
                        Intrinsics.checkNotNull(viewRetrieveView2, "null cannot be cast to non-null type com.superwall.sdk.paywall.view.ShimmerView");
                        shimmerView = (ShimmerView) viewRetrieveView2;
                    }
                    paywallView.setupWith(shimmerView, paywallPurchaseLoadingView);
                }
            }
            viewStorageViewModelMakeViewStore.storeView(str, paywallView);
        }

        public static /* synthetic */ void startWithView$default(Companion companion, Context context, PaywallView paywallView, String str, PaywallPresentationStyle paywallPresentationStyle, int i3, Object obj) {
            if ((i3 & 4) != 0) {
                str = UUID.randomUUID().toString();
            }
            if ((i3 & 8) != 0) {
                paywallPresentationStyle = null;
            }
            companion.startWithView(context, paywallView, str, paywallPresentationStyle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Result startWithView$lambda$1(Context context, PaywallView paywallView, String str, PaywallPresentationStyle paywallPresentationStyle) {
            Object objM1337startWithViewOnMainBWLJW6A = SuperwallPaywallActivity.Companion.m1337startWithViewOnMainBWLJW6A(context, paywallView, str, paywallPresentationStyle);
            Throwable thE = Result.e(objM1337startWithViewOnMainBWLJW6A);
            if (thE != null) {
                paywallView.handleActivityLaunchFailure$superwall_release(thE, true);
            }
            return Result.a(objM1337startWithViewOnMainBWLJW6A);
        }

        /* JADX INFO: renamed from: startWithViewOnMain-BWLJW6A, reason: not valid java name */
        private final Object m1337startWithViewOnMainBWLJW6A(Context context, PaywallView paywallView, String str, PaywallPresentationStyle paywallPresentationStyle) {
            if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
                throw new IllegalStateException("SuperwallPaywallActivity must be prepared and launched on the main thread.");
            }
            prepareViewForDisplay(paywallView, str);
            Intent intent = new Intent(context, (Class<?>) SuperwallPaywallActivity.class);
            intent.putExtra(SuperwallPaywallActivity.VIEW_KEY, str);
            intent.putExtra(SuperwallPaywallActivity.PRESENTATION_STYLE_KEY, paywallPresentationStyle != null ? paywallPresentationStyle.toIntentString(JsonFactory.Companion.getJSON_POLYMORPHIC()) : null);
            intent.putExtra(SuperwallPaywallActivity.IS_LIGHT_BACKGROUND_KEY, Color_HelpersKt.isLightColor(paywallView.getState().getPaywall().getBackgroundColor()));
            intent.setFlags(536870912);
            Object objLaunchPaywallActivity = PaywallActivityLauncherKt.launchPaywallActivity(context, intent);
            if (Result.e(objLaunchPaywallActivity) != null) {
                Superwall.Companion.getInstance().getDependencyContainer$superwall_release().makeViewStore().removeView(str);
                paywallView.clearActivityLaunchState$superwall_release();
            }
            return objLaunchPaywallActivity;
        }

        public final void startWithView(final Context context, final PaywallView view, final String key, final PaywallPresentationStyle paywallPresentationStyle) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(key, "key");
            Function0 function0 = new Function0() { // from class: com.superwall.sdk.paywall.view.i1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return SuperwallPaywallActivity.Companion.startWithView$lambda$1(context, view, key, paywallPresentationStyle);
                }
            };
            if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
                function0.invoke();
            } else {
                BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.c()), null, null, new SuperwallPaywallActivity$Companion$startWithView$1(function0, null), 3, null);
            }
        }

        /* JADX INFO: renamed from: startWithViewForPresentation-BWLJW6A$superwall_release, reason: not valid java name */
        public final Object m1338startWithViewForPresentationBWLJW6A$superwall_release(Activity context, PaywallView view, String key, PaywallPresentationStyle paywallPresentationStyle) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(key, "key");
            return m1337startWithViewOnMainBWLJW6A(context, view, key, paywallPresentationStyle);
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface NotificationPermissionCallback {
        void onPermissionResult(boolean z2);
    }

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.view.SuperwallPaywallActivity$finish$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.view.SuperwallPaywallActivity$finish$1", f = "SuperwallPaywallActivity.kt", l = {}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SuperwallPaywallActivity.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            SuperwallPaywallActivity.this.hideBottomSheetAndFinish();
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.view.SuperwallPaywallActivity$finish$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.view.SuperwallPaywallActivity$finish$2", f = "SuperwallPaywallActivity.kt", l = {}, m = "invokeSuspend")
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SuperwallPaywallActivity.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            SuperwallPaywallActivity.this.hidePopupAndFinish();
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.view.SuperwallPaywallActivity$initBottomSheetBehavior$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class AnonymousClass4 extends BottomSheetBehavior.BottomSheetCallback {
        final /* synthetic */ BottomSheetBehavior<View> $bottomSheetBehavior;
        final /* synthetic */ Ref.IntRef $currentWebViewScroll;
        final /* synthetic */ boolean $isModal;
        final /* synthetic */ SuperwallPaywallActivity this$0;

        AnonymousClass4(boolean z2, Ref.IntRef intRef, BottomSheetBehavior<View> bottomSheetBehavior, SuperwallPaywallActivity superwallPaywallActivity) {
            this.$isModal = z2;
            this.$currentWebViewScroll = intRef;
            this.$bottomSheetBehavior = bottomSheetBehavior;
            this.this$0 = superwallPaywallActivity;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit onSlide$lambda$0(BottomSheetBehavior bottomSheetBehavior, View onView) {
            Intrinsics.checkNotNullParameter(onView, "$this$onView");
            bottomSheetBehavior.M0(!onView.canScrollVertically(-1));
            return Unit.f139807a;
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void onSlide(View bottomSheet, float f3) {
            Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
            PaywallView paywallView = this.this$0.paywallView();
            PaywallWebUI webView$superwall_release = paywallView != null ? paywallView.getWebView$superwall_release() : null;
            if (webView$superwall_release != null) {
                final BottomSheetBehavior<View> bottomSheetBehavior = this.$bottomSheetBehavior;
                webView$superwall_release.onView(new Function1() { // from class: com.superwall.sdk.paywall.view.j1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SuperwallPaywallActivity.AnonymousClass4.onSlide$lambda$0(bottomSheetBehavior, (View) obj);
                    }
                });
            }
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void onStateChanged(View bottomSheet, int i3) {
            Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
            boolean z2 = this.$isModal;
            if (z2 && i3 == 1 && this.$currentWebViewScroll.f140142a > 0) {
                this.$bottomSheetBehavior.c(3);
                return;
            }
            if (z2 && i3 == 6) {
                this.$bottomSheetBehavior.c(3);
                return;
            }
            if (i3 == 5) {
                PaywallView paywallView = this.this$0.paywallView();
                if (paywallView != null) {
                    PaywallView.dismiss$superwall_release$default(paywallView, new PaywallResult.Declined(), PaywallCloseReason.ManualClose.INSTANCE, null, 4, null);
                } else {
                    this.this$0.finish();
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.view.SuperwallPaywallActivity$onPause$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.view.SuperwallPaywallActivity$onPause$1", f = "SuperwallPaywallActivity.kt", l = {}, m = "invokeSuspend")
    static final class C28741 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PaywallView $paywallVc;
        int label;
        final /* synthetic */ SuperwallPaywallActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C28741(PaywallView paywallView, SuperwallPaywallActivity superwallPaywallActivity, Continuation<? super C28741> continuation) {
            super(2, continuation);
            this.$paywallVc = paywallView;
            this.this$0 = superwallPaywallActivity;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C28741(this.$paywallVc, this.this$0, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            this.$paywallVc.beforeOnDestroy(this.this$0.isFinishing());
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C28741) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.view.SuperwallPaywallActivity$onStop$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.view.SuperwallPaywallActivity$onStop$1", f = "SuperwallPaywallActivity.kt", l = {819}, m = "invokeSuspend")
    static final class C28751 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PaywallView $paywallVc;
        int label;
        final /* synthetic */ SuperwallPaywallActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C28751(PaywallView paywallView, SuperwallPaywallActivity superwallPaywallActivity, Continuation<? super C28751> continuation) {
            super(2, continuation);
            this.$paywallVc = paywallView;
            this.this$0 = superwallPaywallActivity;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C28751(this.$paywallVc, this.this$0, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                PaywallView paywallView = this.$paywallVc;
                boolean zIsFinishing = this.this$0.isFinishing();
                this.label = 1;
                if (paywallView.destroyed(zIsFinishing, this) == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C28751) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.view.SuperwallPaywallActivity$setupActivityWithView$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class C28761 extends OnBackPressedCallback {
        final /* synthetic */ PaywallView $view;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C28761(PaywallView paywallView) {
            super(true);
            this.$view = paywallView;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean handleOnBackPressed$lambda$1(PaywallView paywallView) {
            Function1<PaywallInfo, Boolean> onBackPressed = Superwall.Companion.getInstance().getOptions().getPaywalls().getOnBackPressed();
            if (onBackPressed != null) {
                return ((Boolean) onBackPressed.invoke(paywallView != null ? paywallView.getInfo() : null)).booleanValue();
            }
            return false;
        }

        @Override // androidx.activity.OnBackPressedCallback
        public void handleOnBackPressed() {
            PaywallViewState state;
            Paywall paywall;
            final PaywallView paywallView = SuperwallPaywallActivity.this.paywallView();
            if (BackPressBehaviorKt.isBackPressConsumedByApp((paywallView == null || (state = paywallView.getState()) == null || (paywall = state.getPaywall()) == null) ? null : paywall.getRerouteBackButton(), new Function0() { // from class: com.superwall.sdk.paywall.view.k1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Boolean.valueOf(SuperwallPaywallActivity.C28761.handleOnBackPressed$lambda$1(paywallView));
                }
            })) {
                return;
            }
            if (paywallView != null) {
                paywallView.backButtonPressed();
            } else {
                PaywallView.dismiss$superwall_release$default(this.$view, new PaywallResult.Declined(), PaywallCloseReason.ManualClose.INSTANCE, null, 4, null);
            }
        }
    }

    private final void applyFullscreenEdgeToEdge(PaywallView paywallView) {
        int backgroundColor = paywallView.getBackgroundColor();
        EdgeToEdge.b(this, null, Color_HelpersKt.isDarkColor(backgroundColor) ? SystemBarStyle.f419e.c(backgroundColor) : SystemBarStyle.f419e.d(backgroundColor, Color_HelpersKt.readableOverlayColor(backgroundColor)), 1, null);
        paywallView.getWebView$superwall_release().onView(new Function1() { // from class: com.superwall.sdk.paywall.view.x0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SuperwallPaywallActivity.applyFullscreenEdgeToEdge$lambda$6((View) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit applyFullscreenEdgeToEdge$lambda$6(View onView) {
        Intrinsics.checkNotNullParameter(onView, "$this$onView");
        ViewCompat.C0(onView, new OnApplyWindowInsetsListener() { // from class: com.superwall.sdk.paywall.view.a1
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat a(View view, WindowInsetsCompat windowInsetsCompat) {
                return SuperwallPaywallActivity.applyFullscreenEdgeToEdge$lambda$6$lambda$5(view, windowInsetsCompat);
            }
        });
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsetsCompat applyFullscreenEdgeToEdge$lambda$6$lambda$5(View v2, WindowInsetsCompat windowInsets) {
        Intrinsics.checkNotNullParameter(v2, "v");
        Intrinsics.checkNotNullParameter(windowInsets, "windowInsets");
        Insets insetsF = windowInsets.f(WindowInsetsCompat.Type.i());
        Intrinsics.checkNotNullExpressionValue(insetsF, "getInsets(...)");
        ViewGroup.LayoutParams layoutParams = v2.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.bottomMargin = insetsF.f33967d;
        v2.setLayoutParams(marginLayoutParams);
        return WindowInsetsCompat.f34517b;
    }

    private final void applyNavigationBarStyle(PaywallView paywallView) {
        int backgroundColor = paywallView.getBackgroundColor();
        EdgeToEdge.b(this, null, Color_HelpersKt.isDarkColor(backgroundColor) ? SystemBarStyle.f419e.c(backgroundColor) : SystemBarStyle.f419e.d(backgroundColor, Color_HelpersKt.readableOverlayColor(backgroundColor)), 1, null);
    }

    private final boolean areNotificationsEnabled(Context context) {
        Object systemService = getSystemService("notification");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        NotificationChannel notificationChannel = ((NotificationManager) systemService).getNotificationChannel(NOTIFICATION_CHANNEL_ID);
        if (notificationChannel == null || notificationChannel.getImportance() != 0) {
            return NotificationManagerCompat.d(context).a();
        }
        return false;
    }

    public static /* synthetic */ Object attemptToScheduleNotifications$default(SuperwallPaywallActivity superwallPaywallActivity, List list, DeviceHelperFactory deviceHelperFactory, boolean z2, Continuation continuation, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z2 = false;
        }
        return superwallPaywallActivity.attemptToScheduleNotifications(list, deviceHelperFactory, z2, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkAndRequestNotificationPermissions(Context context, NotificationPermissionCallback notificationPermissionCallback) {
        if (Build.VERSION.SDK_INT < 33) {
            notificationPermissionCallback.onPermissionResult(areNotificationsEnabled(context));
            return;
        }
        if (ContextCompat.checkSelfPermission(context, "android.permission.POST_NOTIFICATIONS") == 0) {
            notificationPermissionCallback.onPermissionResult(true);
            return;
        }
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
        Activity activity = (Activity) context;
        if (ActivityCompat.h(activity, "android.permission.POST_NOTIFICATIONS")) {
            notificationPermissionCallback.onPermissionResult(false);
        } else {
            ActivityCompat.e(activity, new String[]{"android.permission.POST_NOTIFICATIONS"}, 1001);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void createNotificationChannel() {
        NotificationChannel notificationChannel = new NotificationChannel(NOTIFICATION_CHANNEL_ID, NOTIFICATION_CHANNEL_NAME, 3);
        notificationChannel.setDescription(NOTIFICATION_CHANNEL_DESCRIPTION);
        notificationChannel.setShowBadge(false);
        Object systemService = getSystemService("notification");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        ((NotificationManager) systemService).createNotificationChannel(notificationChannel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hideBottomSheetAndFinish() {
        View view = this.contentView;
        ViewGroup viewGroup = view instanceof ViewGroup ? (ViewGroup) view : null;
        if (viewGroup != null && (viewGroup instanceof CoordinatorLayout)) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) viewGroup;
            if (coordinatorLayout.getChildCount() > 0) {
                final BottomSheetBehavior bottomSheetBehaviorS0 = BottomSheetBehavior.s0(coordinatorLayout.getChildAt(0));
                Intrinsics.checkNotNullExpressionValue(bottomSheetBehaviorS0, "from(...)");
                BottomSheetBehavior.BottomSheetCallback bottomSheetCallback = this.bottomSheetCallback;
                if (bottomSheetCallback != null) {
                    bottomSheetBehaviorS0.G0(bottomSheetCallback);
                    this.bottomSheetCallback = null;
                }
                coordinatorLayout.post(new Runnable() { // from class: com.superwall.sdk.paywall.view.c1
                    @Override // java.lang.Runnable
                    public final void run() {
                        bottomSheetBehaviorS0.c(5);
                    }
                });
            }
        }
        final int iArgb = Color.argb(200, 0, 0, 0);
        ValueAnimator valueAnimatorOfObject = ValueAnimator.ofObject(new ArgbEvaluator(), Integer.valueOf(iArgb), Integer.valueOf(Color.argb(0, 0, 0, 0)));
        valueAnimatorOfObject.setDuration(DEFAULT_DELAY);
        valueAnimatorOfObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.superwall.sdk.paywall.view.d1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                SuperwallPaywallActivity.hideBottomSheetAndFinish$lambda$21$lambda$20(iArgb, this, valueAnimator);
            }
        });
        valueAnimatorOfObject.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void hideBottomSheetAndFinish$lambda$21$lambda$20(int i3, SuperwallPaywallActivity superwallPaywallActivity, ValueAnimator animator) {
        Intrinsics.checkNotNullParameter(animator, "animator");
        Intrinsics.checkNotNull(animator.getAnimatedValue(), "null cannot be cast to non-null type kotlin.Int");
        if (((Integer) r0).intValue() / i3 < 0.1d) {
            super.finish();
        }
        Window window = superwallPaywallActivity.getWindow();
        Object animatedValue = animator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        window.setBackgroundDrawable(new ColorDrawable(((Integer) animatedValue).intValue()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hidePopupAndFinish() {
        super.finish();
    }

    private final void initBottomSheetBehavior(boolean z2, double d3) {
        PaywallView paywallView;
        PaywallWebUI webView$superwall_release;
        View view = this.contentView;
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.view.ViewGroup");
        final ViewGroup viewGroup = (ViewGroup) view;
        final BottomSheetBehavior bottomSheetBehaviorS0 = BottomSheetBehavior.s0(viewGroup.getChildAt(0));
        Intrinsics.checkNotNullExpressionValue(bottomSheetBehaviorS0, "from(...)");
        if (z2) {
            ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
            if (layoutParams == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            }
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            ((FrameLayout.LayoutParams) layoutParams).topMargin = (int) (((double) Resources.getSystem().getDisplayMetrics().heightPixels) * 0.05d);
            viewGroup.setLayoutParams(layoutParams);
        } else {
            if (d3 > 1.0d) {
                d3 /= (double) 100;
            }
            bottomSheetBehaviorS0.Q0(RangesKt.o((float) d3, 0.01f, 0.99f));
        }
        bottomSheetBehaviorS0.Y0(true);
        bottomSheetBehaviorS0.c(5);
        final int i3 = !z2 ? 6 : 3;
        if (!viewGroup.isLaidOut() || viewGroup.isLayoutRequested()) {
            viewGroup.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.superwall.sdk.paywall.view.SuperwallPaywallActivity$initBottomSheetBehavior$$inlined$doOnLayout$1
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view2, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
                    view2.removeOnLayoutChangeListener(this);
                    viewGroup.post(new SuperwallPaywallActivity$initBottomSheetBehavior$2$1(bottomSheetBehaviorS0, i3));
                }
            });
        } else {
            viewGroup.post(new SuperwallPaywallActivity$initBottomSheetBehavior$2$1(bottomSheetBehaviorS0, i3));
        }
        viewGroup.invalidate();
        final Ref.IntRef intRef = new Ref.IntRef();
        if (z2 && (paywallView = paywallView()) != null && (webView$superwall_release = paywallView.getWebView$superwall_release()) != null) {
            webView$superwall_release.setOnScrollChangeListener(new PaywallWebUI.OnScrollChangeListener() { // from class: com.superwall.sdk.paywall.view.SuperwallPaywallActivity.initBottomSheetBehavior.3
                @Override // com.superwall.sdk.paywall.view.webview.PaywallWebUI.OnScrollChangeListener
                public void onScrollChanged(int i4, int i5, int i6, int i7) {
                    intRef.f140142a = i5;
                }
            });
        }
        AnonymousClass4 anonymousClass4 = new AnonymousClass4(z2, intRef, bottomSheetBehaviorS0, this);
        this.bottomSheetCallback = anonymousClass4;
        bottomSheetBehaviorS0.e0(anonymousClass4);
    }

    private final boolean isBottomSheetView() {
        return (this.contentView instanceof CoordinatorLayout) && Build.VERSION.SDK_INT >= 30;
    }

    private final boolean isPopupView() {
        return (this.contentView instanceof ConstraintLayout) && Build.VERSION.SDK_INT >= 30;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCreate$lambda$1(SuperwallPaywallActivity superwallPaywallActivity, Resources it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return !superwallPaywallActivity.getIntent().getBooleanExtra(IS_LIGHT_BACKGROUND_KEY, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onDestroy$lambda$26(Throwable it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Logger.debug$default(Logger.INSTANCE, LogLevel.error, LogScope.paywallView, "Error cleaning up PaywallView: " + it, (Map) null, (Throwable) null, 24, (Object) null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onResume$lambda$22(View onView) {
        Intrinsics.checkNotNullParameter(onView, "$this$onView");
        onView.requestFocus();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PaywallView paywallView() {
        View view = this.contentView;
        if (view != null) {
            return (PaywallView) view.findViewWithTag(ACTIVE_PAYWALL_TAG);
        }
        return null;
    }

    private final void restorePaywallViewAfterCleanup(PaywallView paywallView, String str) {
        Either failure;
        try {
            Companion.prepareViewForDisplay(paywallView, str);
            Logger.debug$default(Logger.INSTANCE, LogLevel.debug, LogScope.paywallView, "Successfully restored PaywallView child views after cleanup", (Map) null, (Throwable) null, 24, (Object) null);
            failure = new Either.Success(Unit.f139807a);
        } catch (Throwable th) {
            if (ErrorTrackingKt.shouldLog(th)) {
                Superwall.Companion companion = Superwall.Companion;
                if (companion.getInitialized()) {
                    ErrorTrackingKt.trackError(companion.getInstance(), th);
                }
            }
            failure = new Either.Failure(th);
        }
        EitherKt.onError(failure, new Function1() { // from class: com.superwall.sdk.paywall.view.e1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SuperwallPaywallActivity.restorePaywallViewAfterCleanup$lambda$28((Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit restorePaywallViewAfterCleanup$lambda$28(Throwable it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Logger.debug$default(Logger.INSTANCE, LogLevel.error, LogScope.paywallView, "Failed to restore PaywallView after cleanup: " + it.getMessage(), (Map) null, (Throwable) null, 24, (Object) null);
        return Unit.f139807a;
    }

    private final GradientDrawable roundedBackground(float f3) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadii(new float[]{f3, f3, f3, f3, f3, f3, f3, f3});
        return gradientDrawable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void scheduleGrantedNotifications(List<LocalNotification> list, DeviceHelperFactory deviceHelperFactory, boolean z2, boolean z3, long j3) {
        List<LocalNotification> list2;
        if (z3) {
            list2 = list;
        } else {
            long jElapsedRealtime = SystemClock.elapsedRealtime() - j3;
            ArrayList arrayList = new ArrayList();
            for (LocalNotification localNotification : list) {
                LocalNotification localNotificationCopy$default = LocalNotification.copy$default(localNotification, null, null, null, null, null, localNotification.getDelay() - jElapsedRealtime, 31, null);
                if (localNotificationCopy$default.getDelay() <= 0) {
                    localNotificationCopy$default = null;
                }
                if (localNotificationCopy$default != null) {
                    arrayList.add(localNotificationCopy$default);
                }
            }
            list2 = arrayList;
        }
        if (list2.isEmpty()) {
            return;
        }
        NotificationScheduler.Companion.scheduleNotifications(list2, deviceHelperFactory, this, z2, z3);
    }

    private final void setTransparentBackground() {
        if (Build.VERSION.SDK_INT < 30) {
            getWindow().setBackgroundDrawable(new ColorDrawable(0));
            setTheme(R.style.Theme.Translucent.NoTitleBar);
            return;
        }
        setTranslucent(true);
        ValueAnimator valueAnimatorOfObject = ValueAnimator.ofObject(new ArgbEvaluator(), Integer.valueOf(Color.argb(0, 0, 0, 0)), Integer.valueOf(Color.argb(200, 0, 0, 0)));
        valueAnimatorOfObject.setDuration(600L);
        valueAnimatorOfObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.superwall.sdk.paywall.view.b1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                SuperwallPaywallActivity.setTransparentBackground$lambda$17$lambda$16(this.f93632a, valueAnimator);
            }
        });
        valueAnimatorOfObject.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setTransparentBackground$lambda$17$lambda$16(SuperwallPaywallActivity superwallPaywallActivity, ValueAnimator animator) {
        Intrinsics.checkNotNullParameter(animator, "animator");
        Window window = superwallPaywallActivity.getWindow();
        Object animatedValue = animator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        window.setBackgroundDrawable(new ColorDrawable(((Integer) animatedValue).intValue()));
    }

    private final void setupActivityWithView(PaywallView paywallView, PaywallPresentationStyle paywallPresentationStyle) {
        getWindow().getDecorView().setBackgroundColor(paywallView.getBackgroundColor());
        paywallView.registerIntent$superwall_release(this, this);
        boolean z2 = paywallPresentationStyle instanceof PaywallPresentationStyle.Drawer;
        boolean z3 = z2 || (paywallPresentationStyle instanceof PaywallPresentationStyle.Modal);
        boolean z4 = paywallPresentationStyle instanceof PaywallPresentationStyle.Popup;
        ViewParent parent = paywallView.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(paywallView);
        }
        paywallView.setTag(ACTIVE_PAYWALL_TAG);
        paywallView.setEncapsulatingActivity(new WeakReference<>(this));
        if (z3 && Build.VERSION.SDK_INT >= 30) {
            setupBottomSheetLayout(paywallView, paywallPresentationStyle instanceof PaywallPresentationStyle.Modal, z2 ? ((PaywallPresentationStyle.Drawer) paywallPresentationStyle).getHeight() : 0.0d, z2 ? ((PaywallPresentationStyle.Drawer) paywallPresentationStyle).getCornerRadius() : 0.0d);
        } else if (!z4 || Build.VERSION.SDK_INT < 30) {
            setContentView(paywallView);
        } else {
            PaywallPresentationStyle.Popup popup = (PaywallPresentationStyle.Popup) paywallPresentationStyle;
            setupPopupLayout(paywallView, popup.getHeight(), popup.getWidth(), popup.getCornerRadius());
        }
        getOnBackPressedDispatcher().i(this, new C28761(paywallView));
        try {
            ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.k();
            }
        } catch (Throwable unused) {
        }
        if (paywallPresentationStyle instanceof PaywallPresentationStyle.Push) {
            if (Build.VERSION.SDK_INT >= 34) {
                overrideActivityTransition(0, com.superwall.sdk.R.anim.slide_in_right, com.superwall.sdk.R.anim.slide_out_left);
            } else {
                overridePendingTransition(com.superwall.sdk.R.anim.slide_in_right, com.superwall.sdk.R.anim.slide_out_left);
            }
            applyFullscreenEdgeToEdge(paywallView);
            return;
        }
        if (paywallPresentationStyle instanceof PaywallPresentationStyle.Fullscreen) {
            applyFullscreenEdgeToEdge(paywallView);
            return;
        }
        if (paywallPresentationStyle instanceof PaywallPresentationStyle.FullscreenNoAnimation) {
            if (Build.VERSION.SDK_INT >= 34) {
                overrideActivityTransition(0, 0, 0);
                overrideActivityTransition(1, 0, 0);
            } else {
                overridePendingTransition(0, 0);
            }
            applyFullscreenEdgeToEdge(paywallView);
            return;
        }
        if ((paywallPresentationStyle instanceof PaywallPresentationStyle.None) || paywallPresentationStyle == null) {
            applyFullscreenEdgeToEdge(paywallView);
            return;
        }
        if ((paywallPresentationStyle instanceof PaywallPresentationStyle.Modal) || (paywallPresentationStyle instanceof PaywallPresentationStyle.Drawer)) {
            if (Build.VERSION.SDK_INT < 30) {
                applyFullscreenEdgeToEdge(paywallView);
                return;
            } else {
                applyNavigationBarStyle(paywallView);
                return;
            }
        }
        if (!(paywallPresentationStyle instanceof PaywallPresentationStyle.Popup)) {
            throw new NoWhenBranchMatchedException();
        }
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 34) {
            overrideActivityTransition(0, 0, 0);
            overrideActivityTransition(1, 0, 0);
        } else {
            overridePendingTransition(0, 0);
        }
        if (i3 < 30) {
            applyFullscreenEdgeToEdge(paywallView);
        } else {
            applyNavigationBarStyle(paywallView);
        }
    }

    private final void setupBottomSheetLayout(PaywallView paywallView, boolean z2, double d3, double d4) {
        View viewInflate = getLayoutInflater().inflate(com.superwall.sdk.R.layout.activity_bottom_sheet, (ViewGroup) null);
        setContentView(viewInflate);
        initBottomSheetBehavior(z2, d3);
        FrameLayout frameLayout = (FrameLayout) viewInflate.findViewById(com.superwall.sdk.R.id.container);
        viewInflate.setOnClickListener(new View.OnClickListener() { // from class: com.superwall.sdk.paywall.view.g1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SuperwallPaywallActivity.setupBottomSheetLayout$lambda$7(this.f93649a, view);
            }
        });
        frameLayout.addView(paywallView);
        frameLayout.requestLayout();
        frameLayout.setBackground(roundedBackground(((float) d4) * Resources.getSystem().getDisplayMetrics().density));
        ViewCompat.C0(frameLayout, new OnApplyWindowInsetsListener() { // from class: com.superwall.sdk.paywall.view.h1
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat a(View view, WindowInsetsCompat windowInsetsCompat) {
                return SuperwallPaywallActivity.setupBottomSheetLayout$lambda$8(view, windowInsetsCompat);
            }
        });
    }

    static /* synthetic */ void setupBottomSheetLayout$default(SuperwallPaywallActivity superwallPaywallActivity, PaywallView paywallView, boolean z2, double d3, double d4, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            d3 = 0.0d;
        }
        if ((i3 & 8) != 0) {
            d4 = 0.0d;
        }
        superwallPaywallActivity.setupBottomSheetLayout(paywallView, z2, d3, d4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupBottomSheetLayout$lambda$7(SuperwallPaywallActivity superwallPaywallActivity, View view) {
        PaywallView paywallView = superwallPaywallActivity.paywallView();
        if (paywallView != null) {
            PaywallView.dismiss$superwall_release$default(paywallView, new PaywallResult.Declined(), PaywallCloseReason.ManualClose.INSTANCE, null, 4, null);
        } else {
            superwallPaywallActivity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsetsCompat setupBottomSheetLayout$lambda$8(View v2, WindowInsetsCompat windowInsets) {
        Intrinsics.checkNotNullParameter(v2, "v");
        Intrinsics.checkNotNullParameter(windowInsets, "windowInsets");
        Insets insetsF = windowInsets.f(WindowInsetsCompat.Type.i());
        Intrinsics.checkNotNullExpressionValue(insetsF, "getInsets(...)");
        v2.setPadding(v2.getPaddingLeft(), v2.getPaddingTop(), v2.getPaddingRight(), insetsF.f33967d);
        return WindowInsetsCompat.f34517b;
    }

    private final void setupPopupLayout(PaywallView paywallView, double d3, double d4, double d5) {
        View viewInflate = getLayoutInflater().inflate(com.superwall.sdk.R.layout.activity_popup, (ViewGroup) null);
        setContentView(viewInflate);
        ViewCompat.C0(viewInflate, new OnApplyWindowInsetsListener() { // from class: com.superwall.sdk.paywall.view.v0
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat a(View view, WindowInsetsCompat windowInsetsCompat) {
                return SuperwallPaywallActivity.setupPopupLayout$lambda$10(view, windowInsetsCompat);
            }
        });
        FrameLayout frameLayout = (FrameLayout) viewInflate.findViewById(com.superwall.sdk.R.id.container);
        ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        ((ViewGroup.MarginLayoutParams) layoutParams2).width = 0;
        ((ViewGroup.MarginLayoutParams) layoutParams2).height = 0;
        layoutParams2.P = 2;
        layoutParams2.Q = 2;
        layoutParams2.V = RangesKt.o(((float) d4) / 100.0f, 0.01f, 1.0f);
        layoutParams2.W = RangesKt.o(((float) d3) / 100.0f, 0.01f, 1.0f);
        frameLayout.setLayoutParams(layoutParams2);
        paywallView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        final float f3 = ((float) d5) * Resources.getSystem().getDisplayMetrics().density;
        frameLayout.setClipToOutline(true);
        frameLayout.setOutlineProvider(new ViewOutlineProvider() { // from class: com.superwall.sdk.paywall.view.SuperwallPaywallActivity.setupPopupLayout.2
            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view, Outline outline) {
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(outline, "outline");
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), f3);
            }
        });
        frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.superwall.sdk.paywall.view.w0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SuperwallPaywallActivity.setupPopupLayout$lambda$11(view);
            }
        });
        frameLayout.addView(paywallView);
        frameLayout.requestLayout();
        frameLayout.setScaleX(0.0f);
        frameLayout.setScaleY(0.0f);
        frameLayout.setAlpha(0.0f);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(frameLayout, "scaleX", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(frameLayout, "scaleY", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(frameLayout, "alpha", 0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2, objectAnimatorOfFloat3);
        animatorSet.setDuration(DEFAULT_DELAY);
        animatorSet.setInterpolator(new OvershootInterpolator(1.1f));
        animatorSet.start();
    }

    static /* synthetic */ void setupPopupLayout$default(SuperwallPaywallActivity superwallPaywallActivity, PaywallView paywallView, double d3, double d4, double d5, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            d3 = 0.0d;
        }
        if ((i3 & 4) != 0) {
            d4 = 0.0d;
        }
        if ((i3 & 8) != 0) {
            d5 = 0.0d;
        }
        superwallPaywallActivity.setupPopupLayout(paywallView, d3, d4, d5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsetsCompat setupPopupLayout$lambda$10(View v2, WindowInsetsCompat windowInsets) {
        Intrinsics.checkNotNullParameter(v2, "v");
        Intrinsics.checkNotNullParameter(windowInsets, "windowInsets");
        Insets insetsF = windowInsets.f(WindowInsetsCompat.Type.i());
        Intrinsics.checkNotNullExpressionValue(insetsF, "getInsets(...)");
        v2.setPadding(insetsF.f33964a, insetsF.f33965b, insetsF.f33966c, insetsF.f33967d);
        return WindowInsetsCompat.f34517b;
    }

    public final Object attemptToScheduleNotifications(List<LocalNotification> list, DeviceHelperFactory deviceHelperFactory, boolean z2, Continuation<? super Unit> continuation) {
        Object objAttemptToScheduleNotifications$superwall_release = attemptToScheduleNotifications$superwall_release(list, deviceHelperFactory, z2, true, continuation);
        return objAttemptToScheduleNotifications$superwall_release == IntrinsicsKt.f() ? objAttemptToScheduleNotifications$superwall_release : Unit.f139807a;
    }

    public final Object attemptToScheduleNotifications$superwall_release(final List<LocalNotification> list, final DeviceHelperFactory deviceHelperFactory, final boolean z2, final boolean z3, Continuation<? super Unit> continuation) {
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
        cancellableContinuationImpl.C();
        if (list.isEmpty()) {
            Result.Companion companion = Result.f139772b;
            cancellableContinuationImpl.resumeWith(Result.b(Unit.f139807a));
        } else {
            createNotificationChannel();
            final long jElapsedRealtime = SystemClock.elapsedRealtime();
            NotificationPermissionCallback notificationPermissionCallback = this.notificationPermissionCallback;
            if (notificationPermissionCallback != null) {
                notificationPermissionCallback.onPermissionResult(false);
            }
            NotificationPermissionCallback notificationPermissionCallback2 = new NotificationPermissionCallback() { // from class: com.superwall.sdk.paywall.view.SuperwallPaywallActivity$attemptToScheduleNotifications$3$callback$1
                @Override // com.superwall.sdk.paywall.view.SuperwallPaywallActivity.NotificationPermissionCallback
                public void onPermissionResult(boolean z4) {
                    if (this.this$0.notificationPermissionCallback == this) {
                        this.this$0.notificationPermissionCallback = null;
                    }
                    if (z4) {
                        try {
                            this.this$0.scheduleGrantedNotifications(list, deviceHelperFactory, z2, z3, jElapsedRealtime);
                        } catch (Exception e3) {
                            if (cancellableContinuationImpl.isActive()) {
                                CancellableContinuation<Unit> cancellableContinuation = cancellableContinuationImpl;
                                Result.Companion companion2 = Result.f139772b;
                                cancellableContinuation.resumeWith(Result.b(ResultKt.a(e3)));
                                return;
                            }
                            return;
                        }
                    }
                    if (cancellableContinuationImpl.isActive()) {
                        CancellableContinuation<Unit> cancellableContinuation2 = cancellableContinuationImpl;
                        Result.Companion companion3 = Result.f139772b;
                        cancellableContinuation2.resumeWith(Result.b(Unit.f139807a));
                    }
                }
            };
            this.notificationPermissionCallback = notificationPermissionCallback2;
            try {
                checkAndRequestNotificationPermissions(this, notificationPermissionCallback2);
            } catch (Exception e3) {
                if (this.notificationPermissionCallback == notificationPermissionCallback2) {
                    this.notificationPermissionCallback = null;
                }
                if (cancellableContinuationImpl.isActive()) {
                    Result.Companion companion2 = Result.f139772b;
                    cancellableContinuationImpl.resumeWith(Result.b(ResultKt.a(e3)));
                }
            }
        }
        Object objV = cancellableContinuationImpl.v();
        if (objV == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return objV == IntrinsicsKt.f() ? objV : Unit.f139807a;
    }

    @Override // android.app.Activity
    public void finish() {
        if (isBottomSheetView()) {
            BuildersKt__Builders_commonKt.d(this.mainScope, null, null, new AnonymousClass1(null), 3, null);
        } else if (isPopupView()) {
            BuildersKt__Builders_commonKt.d(this.mainScope, null, null, new AnonymousClass2(null), 3, null);
        } else {
            super.finish();
            Unit unit = Unit.f139807a;
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        String stringExtra;
        AppCompatDelegate.P(true);
        String stringExtra2 = getIntent().getStringExtra(PRESENTATION_STYLE_KEY);
        PaywallPresentationStyle paywallPresentationStyleFromIntentString = stringExtra2 != null ? PaywallPresentationStyle.Companion.fromIntentString(JsonFactory.Companion.getJSON_POLYMORPHIC(), stringExtra2) : null;
        EdgeToEdge.b(this, SystemBarStyle.f419e.a(0, 0, new Function1() { // from class: com.superwall.sdk.paywall.view.f1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(SuperwallPaywallActivity.onCreate$lambda$1(this.f93648a, (Resources) obj));
            }
        }), null, 2, null);
        requestWindowFeature(1);
        super.onCreate(bundle);
        if (bundle == null || (stringExtra = bundle.getString(VIEW_KEY)) == null) {
            stringExtra = getIntent().getStringExtra(VIEW_KEY);
        }
        if (stringExtra == null) {
            Logger.debug$default(Logger.INSTANCE, LogLevel.error, LogScope.paywallView, "No view key found in savedInstanceState or intent, finishing activity", (Map) null, (Throwable) null, 24, (Object) null);
            finish();
            return;
        }
        try {
            Superwall.Companion companion = Superwall.Companion;
            ViewStorageViewModel viewStorageViewModelMakeViewStore = companion.getInstance().getDependencyContainer$superwall_release().makeViewStore();
            View viewRetrieveView = viewStorageViewModelMakeViewStore.retrieveView(stringExtra);
            PaywallView paywallView = viewRetrieveView instanceof PaywallView ? (PaywallView) viewRetrieveView : null;
            if (paywallView == null) {
                Logger.debug$default(Logger.INSTANCE, LogLevel.error, LogScope.paywallView, "PaywallView not found for key: " + stringExtra + ". Activity may have been recreated after cleanup.", (Map) null, (Throwable) null, 24, (Object) null);
                finish();
                return;
            }
            if (bundle == null || paywallView() != null) {
                setupActivityWithView(paywallView, paywallPresentationStyleFromIntentString);
                return;
            }
            Logger logger = Logger.INSTANCE;
            LogLevel logLevel = LogLevel.debug;
            LogScope logScope = LogScope.paywallView;
            Logger.debug$default(logger, logLevel, logScope, "Activity restored but PaywallView cleared - recreating with available view", (Map) null, (Throwable) null, 24, (Object) null);
            PaywallView paywallView2 = companion.getInstance().getPaywallView();
            if (paywallView2 == null) {
                Logger.debug$default(logger, LogLevel.error, logScope, "No PaywallView available in Superwall instance for recreation", (Map) null, (Throwable) null, 24, (Object) null);
                finish();
                return;
            }
            if (paywallView2.getChildCount() == 0) {
                Logger.debug$default(logger, logLevel, logScope, "PaywallView was cleaned up, restoring child views", (Map) null, (Throwable) null, 24, (Object) null);
                restorePaywallViewAfterCleanup(paywallView2, stringExtra);
            }
            viewStorageViewModelMakeViewStore.storeView(stringExtra, paywallView2);
            setupActivityWithView(paywallView2, paywallPresentationStyleFromIntentString);
        } catch (Exception unused) {
            Logger.debug$default(Logger.INSTANCE, LogLevel.error, LogScope.paywallView, "Cannot access viewStore or create view - has Superwall been initialised?", (Map) null, (Throwable) null, 24, (Object) null);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        Either failure;
        NotificationPermissionCallback notificationPermissionCallback = this.notificationPermissionCallback;
        if (notificationPermissionCallback != null) {
            notificationPermissionCallback.onPermissionResult(false);
        }
        super.onDestroy();
        View view = this.contentView;
        ViewGroup viewGroup = view instanceof ViewGroup ? (ViewGroup) view : null;
        if (viewGroup != null && (viewGroup instanceof CoordinatorLayout)) {
            BottomSheetBehavior bottomSheetBehaviorS0 = BottomSheetBehavior.s0(((CoordinatorLayout) viewGroup).getChildAt(0));
            Intrinsics.checkNotNullExpressionValue(bottomSheetBehaviorS0, "from(...)");
            BottomSheetBehavior.BottomSheetCallback bottomSheetCallback = this.bottomSheetCallback;
            if (bottomSheetCallback != null) {
                bottomSheetBehaviorS0.G0(bottomSheetCallback);
            }
        }
        String stringExtra = getIntent().getStringExtra(VIEW_KEY);
        if (stringExtra != null) {
            try {
                View viewRetrieveView = Superwall.Companion.getInstance().getDependencyContainer$superwall_release().makeViewStore().retrieveView(stringExtra);
                PaywallView paywallView = viewRetrieveView instanceof PaywallView ? (PaywallView) viewRetrieveView : null;
                if (paywallView != null) {
                    paywallView.cleanup();
                }
            } catch (Throwable th) {
                if (ErrorTrackingKt.shouldLog(th)) {
                    Superwall.Companion companion = Superwall.Companion;
                    if (companion.getInitialized()) {
                        ErrorTrackingKt.trackError(companion.getInstance(), th);
                    }
                }
                failure = new Either.Failure(th);
            }
        }
        failure = new Either.Success(Unit.f139807a);
        EitherKt.onError(failure, new Function1() { // from class: com.superwall.sdk.paywall.view.z0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SuperwallPaywallActivity.onDestroy$lambda$26((Throwable) obj);
            }
        });
        PaywallView paywallView2 = paywallView();
        if (paywallView2 != null) {
            paywallView2.cleanup();
        }
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        PaywallView paywallView3 = paywallView();
        if (paywallView3 == null) {
            paywallView3 = null;
        }
        if (paywallView3 != null) {
            paywallView3.setEncapsulatingActivity(null);
        }
        this.contentView = null;
    }

    public void onNewIntent(Intent intent, ComponentCaller caller) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNullParameter(caller, "caller");
        super.onNewIntent(intent, caller);
        Uri data = intent.getData();
        if (data != null) {
            Result.a(Superwall.Companion.m1257handleDeepLinkIoAF18A(data));
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        PaywallView paywallView = paywallView();
        if (paywallView == null) {
            return;
        }
        paywallView.getWebView$superwall_release().onPause();
        BuildersKt__Builders_commonKt.d(this.mainScope, null, null, new C28741(paywallView, this, null), 3, null);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i3, String[] permissions, int[] grantResults) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        super.onRequestPermissionsResult(i3, permissions, grantResults);
        if (i3 != 1001 || Build.VERSION.SDK_INT < 33) {
            return;
        }
        boolean z2 = !(grantResults.length == 0) && grantResults[0] == 0;
        NotificationPermissionCallback notificationPermissionCallback = this.notificationPermissionCallback;
        if (notificationPermissionCallback != null) {
            notificationPermissionCallback.onPermissionResult(z2);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        PaywallView paywallView = paywallView();
        if (paywallView == null) {
            return;
        }
        paywallView.getWebView$superwall_release().onResume();
        if (isBottomSheetView() || isPopupView()) {
            setTransparentBackground();
        }
        paywallView.onViewCreated();
        paywallView.getWebView$superwall_release().onView(new Function1() { // from class: com.superwall.sdk.paywall.view.y0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SuperwallPaywallActivity.onResume$lambda$22((View) obj);
            }
        });
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        String stringExtra = getIntent().getStringExtra(VIEW_KEY);
        if (stringExtra != null) {
            outState.putString(VIEW_KEY, stringExtra);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        PaywallView paywallView = paywallView();
        if (paywallView == null) {
            return;
        }
        if (paywallView.getState().isBrowserViewPresented()) {
            paywallView.updateState(new PaywallViewState.Updates.SetBrowserPresented(true));
        }
        paywallView.beforeViewCreated();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        PaywallView paywallView = paywallView();
        if (paywallView == null) {
            return;
        }
        BuildersKt__Builders_commonKt.d(this.mainScope, null, null, new C28751(paywallView, this, null), 3, null);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(View view) {
        super.setContentView(view);
        this.contentView = view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupPopupLayout$lambda$11(View view) {
    }
}
