package com.superwall.sdk.debug;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import com.facebook.internal.AnalyticsEvents;
import com.superwall.sdk.BuildConfig;
import com.superwall.sdk.R;
import com.superwall.sdk.Superwall;
import com.superwall.sdk.debug.localizations.SWLocalizationActivity;
import com.superwall.sdk.dependencies.RequestFactory;
import com.superwall.sdk.dependencies.ViewFactory;
import com.superwall.sdk.logger.LogLevel;
import com.superwall.sdk.logger.LogScope;
import com.superwall.sdk.logger.Logger;
import com.superwall.sdk.models.entitlements.SubscriptionStatus;
import com.superwall.sdk.models.paywall.Paywall;
import com.superwall.sdk.network.Network;
import com.superwall.sdk.paywall.manager.PaywallManager;
import com.superwall.sdk.paywall.presentation.internal.InternalPresentationKt;
import com.superwall.sdk.paywall.presentation.internal.PresentationRequest;
import com.superwall.sdk.paywall.presentation.internal.PresentationRequestType;
import com.superwall.sdk.paywall.presentation.internal.request.PresentationInfo;
import com.superwall.sdk.paywall.presentation.internal.state.PaywallSkippedReason;
import com.superwall.sdk.paywall.presentation.internal.state.PaywallState;
import com.superwall.sdk.paywall.request.PaywallRequestManager;
import com.superwall.sdk.store.StoreManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.xn.YvFRmou;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlowKt;

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
public final class DebugView extends ConstraintLayout implements AppCompatActivityEncapsulatable {
    private final Lazy activityIndicator$delegate;
    private final Lazy bottomButton$delegate;
    private final Lazy consoleButton$delegate;
    private final Context context;
    private final DebugManager debugManager;
    private AppCompatActivity encapsulatingActivity;
    private final Lazy exitButton$delegate;
    private final Factory factory;
    private String initialLocaleIdentifier;
    private boolean isActive;
    private final int lightBackgroundColor;
    private final Lazy logoImageView$delegate;
    private final Network network;
    private Paywall paywall;
    private String paywallDatabaseId;
    private String paywallIdentifier;
    private final PaywallManager paywallManager;
    private final PaywallRequestManager paywallRequestManager;
    private List<Paywall> paywalls;
    private final Lazy previewContainerView$delegate;
    private final Lazy previewPickerButton$delegate;
    private TextView previewTextView;
    private View previewViewContent;
    private final int primaryColor;
    private final StoreManager storeManager;

    /* JADX INFO: renamed from: com.superwall.sdk.debug.DebugView$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.debug.DebugView$1", f = "DebugView.kt", l = {324}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return DebugView.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                DebugView debugView = DebugView.this;
                this.label = 1;
                if (debugView.loadPreview(this) == objF) {
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
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class AlertOption {
        private final Function1<Continuation<? super Unit>, Object> action;
        private final int style;
        private final String title;

        public AlertOption() {
            this(null, null, 0, 7, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ AlertOption copy$default(AlertOption alertOption, String str, Function1 function1, int i3, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                str = alertOption.title;
            }
            if ((i4 & 2) != 0) {
                function1 = alertOption.action;
            }
            if ((i4 & 4) != 0) {
                i3 = alertOption.style;
            }
            return alertOption.copy(str, function1, i3);
        }

        public final String component1() {
            return this.title;
        }

        public final Function1<Continuation<? super Unit>, Object> component2() {
            return this.action;
        }

        public final int component3() {
            return this.style;
        }

        public final AlertOption copy(String str, Function1<? super Continuation<? super Unit>, ? extends Object> function1, int i3) {
            return new AlertOption(str, function1, i3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AlertOption)) {
                return false;
            }
            AlertOption alertOption = (AlertOption) obj;
            return Intrinsics.areEqual(this.title, alertOption.title) && Intrinsics.areEqual(this.action, alertOption.action) && this.style == alertOption.style;
        }

        public final Function1<Continuation<? super Unit>, Object> getAction() {
            return this.action;
        }

        public final int getStyle() {
            return this.style;
        }

        public final String getTitle() {
            return this.title;
        }

        public int hashCode() {
            String str = this.title;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            Function1<Continuation<? super Unit>, Object> function1 = this.action;
            return ((iHashCode + (function1 != null ? function1.hashCode() : 0)) * 31) + Integer.hashCode(this.style);
        }

        public String toString() {
            return "AlertOption(title=" + this.title + ", action=" + this.action + ", style=" + this.style + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public AlertOption(String str, Function1<? super Continuation<? super Unit>, ? extends Object> function1, int i3) {
            this.title = str;
            this.action = function1;
            this.style = i3;
        }

        public /* synthetic */ AlertOption(String str, Function1 function1, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            this((i4 & 1) != 0 ? "" : str, (i4 & 2) != 0 ? null : function1, (i4 & 4) != 0 ? -1 : i3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface Factory extends RequestFactory, ViewFactory {
    }

    /* JADX INFO: renamed from: com.superwall.sdk.debug.DebugView$addPaywallPreview$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.debug.DebugView", f = "DebugView.kt", l = {598}, m = "addPaywallPreview")
    static final class C27901 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C27901(Continuation<? super C27901> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DebugView.this.addPaywallPreview(this);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.debug.DebugView$finishLoadingPreview$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.debug.DebugView", f = "DebugView.kt", l = {569, 572, 579}, m = "finishLoadingPreview")
    static final class C27911 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C27911(Continuation<? super C27911> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DebugView.this.finishLoadingPreview(this);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.debug.DebugView$finishLoadingPreview$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.debug.DebugView$finishLoadingPreview$2", f = "DebugView.kt", l = {582}, m = "invokeSuspend")
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef<Paywall> $paywall;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Ref.ObjectRef<Paywall> objectRef, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$paywall = objectRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return DebugView.this.new AnonymousClass2(this.$paywall, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                TextView textView = DebugView.this.previewTextView;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("previewTextView");
                    textView = null;
                }
                textView.setText(((Paywall) this.$paywall.f140144a).getName());
                DebugView.this.getActivityIndicator().setVisibility(4);
                DebugView debugView = DebugView.this;
                this.label = 1;
                if (debugView.addPaywallPreview(this) == objF) {
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
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.debug.DebugView$loadAndShowPaywall$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.debug.DebugView$loadAndShowPaywall$1", f = "DebugView.kt", l = {861}, m = "invokeSuspend")
    static final class C27921 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ MutableSharedFlow<PaywallState> $publisher;
        int label;
        final /* synthetic */ DebugView this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C27921(MutableSharedFlow<PaywallState> mutableSharedFlow, DebugView debugView, Continuation<? super C27921> continuation) {
            super(2, continuation);
            this.$publisher = mutableSharedFlow;
            this.this$0 = debugView;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C27921(this.$publisher, this.this$0, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                MutableSharedFlow<PaywallState> mutableSharedFlow = this.$publisher;
                final DebugView debugView = this.this$0;
                FlowCollector flowCollector = new FlowCollector() { // from class: com.superwall.sdk.debug.DebugView.loadAndShowPaywall.1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((PaywallState) obj2, (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(PaywallState paywallState, Continuation<? super Unit> continuation) {
                        String str;
                        if (paywallState instanceof PaywallState.Presented) {
                            ResourcesCompat.f(debugView.getResources(), R.drawable.play_button, null);
                        } else if (paywallState instanceof PaywallState.Skipped) {
                            PaywallSkippedReason paywallSkippedReason = ((PaywallState.Skipped) paywallState).getPaywallSkippedReason();
                            if (paywallSkippedReason instanceof PaywallSkippedReason.Holdout) {
                                str = "The user was assigned to a holdout.";
                            } else if (paywallSkippedReason instanceof PaywallSkippedReason.NoAudienceMatch) {
                                str = "The user didn't match a rule.";
                            } else if (paywallSkippedReason instanceof PaywallSkippedReason.PlacementNotFound) {
                                str = "Couldn't find event.";
                            } else {
                                if (!(paywallSkippedReason instanceof PaywallSkippedReason.UserIsSubscribed)) {
                                    throw new NoWhenBranchMatchedException();
                                }
                                str = YvFRmou.fSD;
                            }
                            DebugView.presentAlert$default(debugView, "Paywall Skipped", str, null, 4, null);
                            ResourcesCompat.f(debugView.getResources(), R.drawable.play_button, null);
                        } else if (!(paywallState instanceof PaywallState.Dismissed)) {
                            if (!(paywallState instanceof PaywallState.PresentationError)) {
                                throw new NoWhenBranchMatchedException();
                            }
                            Logger.debug$default(Logger.INSTANCE, LogLevel.error, LogScope.debugView, "Failed to Show Paywall", (Map) null, (Throwable) null, 24, (Object) null);
                            DebugView.presentAlert$default(debugView, "Presentation Error", ((PaywallState.PresentationError) paywallState).getError().getLocalizedMessage(), null, 4, null);
                            ResourcesCompat.f(debugView.getResources(), R.drawable.play_button, null);
                        }
                        return Unit.f139807a;
                    }
                };
                this.label = 1;
                if (mutableSharedFlow.collect(flowCollector, this) == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            throw new KotlinNothingValueException();
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C27921) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.debug.DebugView$loadAndShowPaywall$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.debug.DebugView$loadAndShowPaywall$2", f = "DebugView.kt", l = {912}, m = "invokeSuspend")
    static final class C27932 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PresentationRequest $presentationRequest;
        final /* synthetic */ MutableSharedFlow<PaywallState> $publisher;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C27932(PresentationRequest presentationRequest, MutableSharedFlow<PaywallState> mutableSharedFlow, Continuation<? super C27932> continuation) {
            super(2, continuation);
            this.$presentationRequest = presentationRequest;
            this.$publisher = mutableSharedFlow;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C27932(this.$presentationRequest, this.$publisher, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                Superwall companion = Superwall.Companion.getInstance();
                PresentationRequest presentationRequest = this.$presentationRequest;
                MutableSharedFlow<PaywallState> mutableSharedFlow = this.$publisher;
                this.label = 1;
                if (InternalPresentationKt.internallyPresent(companion, presentationRequest, mutableSharedFlow, this) == objF) {
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
            return ((C27932) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.debug.DebugView$loadPreview$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.debug.DebugView", f = "DebugView.kt", l = {525, 535, 538, 548}, m = "loadPreview")
    static final class C27941 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C27941(Continuation<? super C27941> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DebugView.this.loadPreview(this);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.debug.DebugView$loadPreview$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.debug.DebugView$loadPreview$2", f = "DebugView.kt", l = {}, m = "invokeSuspend")
    static final class C27952 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C27952(Continuation<? super C27952> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return DebugView.this.new C27952(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            DebugView.this.getActivityIndicator().setVisibility(0);
            View view = DebugView.this.previewViewContent;
            if (view != null) {
                ViewParent parent = view.getParent();
                ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
                if (viewGroup != null) {
                    viewGroup.removeView(view);
                    return Unit.f139807a;
                }
            }
            return null;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C27952) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.debug.DebugView$pressedConsoleButton$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    /* synthetic */ class C27961 extends AdaptedFunctionReference implements Function1<Continuation<? super Unit>, Object>, SuspendFunction {
        C27961(Object obj) {
            super(1, obj, DebugView.class, "showLocalizationPicker", "showLocalizationPicker()V", 4);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return DebugView.pressedConsoleButton$showLocalizationPicker((DebugView) this.receiver, continuation);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.debug.DebugView$pressedConsoleButton$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    /* synthetic */ class C27972 extends FunctionReferenceImpl implements Function1<Continuation<? super Unit>, Object>, SuspendFunction {
        C27972(Object obj) {
            super(1, obj, DebugView.class, "showConsole", "showConsole(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((DebugView) this.receiver).showConsole(continuation);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.debug.DebugView$showConsole$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.debug.DebugView", f = "DebugView.kt", l = {743}, m = "showConsole")
    static final class C27981 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C27981(Continuation<? super C27981> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DebugView.this.showConsole(this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DebugView(Context context, StoreManager storeManager, Network network, PaywallRequestManager paywallRequestManager, PaywallManager paywallManager, DebugManager debugManager, Factory factory) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(storeManager, "storeManager");
        Intrinsics.checkNotNullParameter(network, "network");
        Intrinsics.checkNotNullParameter(paywallRequestManager, "paywallRequestManager");
        Intrinsics.checkNotNullParameter(paywallManager, "paywallManager");
        Intrinsics.checkNotNullParameter(debugManager, "debugManager");
        Intrinsics.checkNotNullParameter(factory, "factory");
        this.context = context;
        this.storeManager = storeManager;
        this.network = network;
        this.paywallRequestManager = paywallRequestManager;
        this.paywallManager = paywallManager;
        this.debugManager = debugManager;
        this.factory = factory;
        this.paywalls = CollectionsKt.emptyList();
        this.logoImageView$delegate = LazyKt.b(new Function0() { // from class: com.superwall.sdk.debug.h
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DebugView.logoImageView_delegate$lambda$1(this.f93514a);
            }
        });
        this.exitButton$delegate = LazyKt.b(new Function0() { // from class: com.superwall.sdk.debug.i
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DebugView.exitButton_delegate$lambda$5(this.f93515a);
            }
        });
        this.consoleButton$delegate = LazyKt.b(new Function0() { // from class: com.superwall.sdk.debug.j
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DebugView.consoleButton_delegate$lambda$9(this.f93516a);
            }
        });
        this.activityIndicator$delegate = LazyKt.b(new Function0() { // from class: com.superwall.sdk.debug.k
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DebugView.activityIndicator_delegate$lambda$11(this.f93517a);
            }
        });
        this.primaryColor = Color.parseColor("#75FFF1");
        this.lightBackgroundColor = Color.parseColor("#181A1E");
        this.bottomButton$delegate = LazyKt.b(new Function0() { // from class: com.superwall.sdk.debug.l
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DebugView.bottomButton_delegate$lambda$18(this.f93518a);
            }
        });
        this.previewPickerButton$delegate = LazyKt.b(new Function0() { // from class: com.superwall.sdk.debug.m
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DebugView.previewPickerButton_delegate$lambda$24(this.f93523a);
            }
        });
        this.previewContainerView$delegate = LazyKt.b(new Function0() { // from class: com.superwall.sdk.debug.n
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DebugView.previewContainerView_delegate$lambda$27(this.f93524a);
            }
        });
        this.initialLocaleIdentifier = Superwall.Companion.getInstance().getOptions().getLocaleIdentifier();
        addSubviews();
        BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.b()), null, null, new AnonymousClass1(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ProgressBar activityIndicator_delegate$lambda$11(DebugView debugView) {
        ProgressBar progressBar = new ProgressBar(debugView.context);
        progressBar.setId(View.generateViewId());
        progressBar.setIndeterminate(true);
        progressBar.setVisibility(0);
        progressBar.setLayoutParams(new ConstraintLayout.LayoutParams(-2, -2));
        return progressBar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LinearLayout bottomButton_delegate$lambda$18(final DebugView debugView) {
        debugView.setId(View.generateViewId());
        LinearLayout linearLayout = new LinearLayout(debugView.context);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(17);
        linearLayout.setClickable(true);
        linearLayout.setId(View.generateViewId());
        linearLayout.setFocusable(true);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#203133"));
        gradientDrawable.setCornerRadius(70.0f);
        linearLayout.setBackground(gradientDrawable);
        ImageView imageView = new ImageView(linearLayout.getContext());
        imageView.setId(View.generateViewId());
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setImageResource(R.drawable.play_button);
        imageView.setColorFilter(debugView.primaryColor);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = 8;
        imageView.setLayoutParams(layoutParams);
        linearLayout.addView(imageView);
        TextView textView = new TextView(linearLayout.getContext());
        textView.setId(View.generateViewId());
        textView.setText("Preview");
        textView.setTextSize(17.0f);
        textView.setTypeface(null, 1);
        textView.setTextColor(debugView.primaryColor);
        textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        linearLayout.addView(textView);
        linearLayout.setPadding(32, 16, 32, 16);
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.superwall.sdk.debug.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f93513a.pressedBottomButton();
            }
        });
        return linearLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LinearLayout consoleButton_delegate$lambda$9(final DebugView debugView) {
        LinearLayout linearLayout = new LinearLayout(debugView.context);
        linearLayout.setId(View.generateViewId());
        linearLayout.setOrientation(0);
        linearLayout.setGravity(17);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        ImageView imageView = new ImageView(linearLayout.getContext());
        Drawable drawable = ContextCompat.getDrawable(imageView.getContext(), R.drawable.debugger);
        Drawable drawableMutate = drawable != null ? drawable.mutate() : null;
        if (drawableMutate != null) {
            drawableMutate.setColorFilter(new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_ATOP));
        }
        imageView.setImageDrawable(drawableMutate);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setAlpha(0.5f);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        linearLayout.addView(imageView);
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.superwall.sdk.debug.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f93512a.pressedConsoleButton();
            }
        });
        return linearLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LinearLayout exitButton_delegate$lambda$5(final DebugView debugView) {
        LinearLayout linearLayout = new LinearLayout(debugView.context);
        linearLayout.setId(View.generateViewId());
        linearLayout.setOrientation(0);
        linearLayout.setGravity(17);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        ImageView imageView = new ImageView(linearLayout.getContext());
        Drawable drawable = ContextCompat.getDrawable(imageView.getContext(), R.drawable.exit);
        Drawable drawableMutate = drawable != null ? drawable.mutate() : null;
        if (drawableMutate != null) {
            drawableMutate.setColorFilter(new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_ATOP));
        }
        imageView.setImageDrawable(drawableMutate);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setAlpha(0.5f);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        linearLayout.addView(imageView);
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.superwall.sdk.debug.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f93508a.pressedExitButton();
            }
        });
        return linearLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ProgressBar getActivityIndicator() {
        return (ProgressBar) this.activityIndicator$delegate.getValue();
    }

    private final LinearLayout getBottomButton() {
        return (LinearLayout) this.bottomButton$delegate.getValue();
    }

    private final LinearLayout getConsoleButton() {
        return (LinearLayout) this.consoleButton$delegate.getValue();
    }

    private final LinearLayout getExitButton() {
        return (LinearLayout) this.exitButton$delegate.getValue();
    }

    private final ImageView getLogoImageView() {
        return (ImageView) this.logoImageView$delegate.getValue();
    }

    private final ConstraintLayout getPreviewContainerView() {
        return (ConstraintLayout) this.previewContainerView$delegate.getValue();
    }

    private final LinearLayout getPreviewPickerButton() {
        return (LinearLayout) this.previewPickerButton$delegate.getValue();
    }

    public static /* synthetic */ void loadAndShowPaywall$default(DebugView debugView, boolean z2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z2 = false;
        }
        debugView.loadAndShowPaywall(z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ImageView logoImageView_delegate$lambda$1(DebugView debugView) {
        ImageView imageView = new ImageView(debugView.context);
        imageView.setId(View.generateViewId());
        imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.superwall_logo));
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setBackgroundColor(0);
        imageView.setClipToOutline(true);
        imageView.setVisibility(0);
        imageView.setLayoutParams(new ConstraintLayout.LayoutParams(-2, -2));
        return imageView;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void presentAlert$default(DebugView debugView, String str, String str2, List list, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            list = CollectionsKt.emptyList();
        }
        debugView.presentAlert(str, str2, list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void presentAlert$lambda$46(List list, DialogInterface dialogInterface, int i3) {
        BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.b()), null, null, new DebugView$presentAlert$1$1((AlertOption) list.get(i3), null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void presentAlert$lambda$47(AlertDialog alertDialog) {
        Window window = alertDialog.getWindow();
        View viewFindViewById = window != null ? window.findViewById(androidx.appcompat.R.id.f746n) : null;
        if (viewFindViewById != null) {
            viewFindViewById.setBackground(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ Object pressedConsoleButton$showLocalizationPicker(DebugView debugView, Continuation continuation) {
        debugView.showLocalizationPicker();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void pressedExitButton() {
        AppCompatActivity encapsulatingActivity = getEncapsulatingActivity();
        if (encapsulatingActivity != null) {
            encapsulatingActivity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void pressedPreview() {
        String str = this.paywallDatabaseId;
        if (str == null) {
            return;
        }
        List<Paywall> list = this.paywalls;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (Paywall paywall : list) {
            String name = paywall.getName();
            if (Intrinsics.areEqual(str, paywall.getDatabaseId())) {
                name = name + " ✓";
            }
            arrayList.add(new AlertOption(name, new DebugView$pressedPreview$options$1$alert$1(this, paywall, null), 0, 4, null));
        }
        presentAlert("Your Paywalls", null, arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ConstraintLayout previewContainerView_delegate$lambda$27(final DebugView debugView) {
        ConstraintLayout constraintLayout = new ConstraintLayout(debugView.context);
        constraintLayout.setId(View.generateViewId());
        constraintLayout.setFocusable(true);
        constraintLayout.setLayoutParams(new ConstraintLayout.LayoutParams(0, 0));
        constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: com.superwall.sdk.debug.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f93525a.pressedPreview();
            }
        });
        return constraintLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LinearLayout previewPickerButton_delegate$lambda$24(final DebugView debugView) {
        LinearLayout linearLayout = new LinearLayout(debugView.context);
        linearLayout.setId(View.generateViewId());
        linearLayout.setOrientation(0);
        linearLayout.setGravity(17);
        linearLayout.setBackgroundColor(debugView.lightBackgroundColor);
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        TextView textView = new TextView(linearLayout.getContext());
        textView.setId(View.generateViewId());
        textView.setText("");
        textView.setTextSize(14.0f);
        textView.setTypeface(null, 1);
        textView.setTextColor(debugView.primaryColor);
        textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        debugView.previewTextView = textView;
        linearLayout.addView(textView);
        ImageView imageView = new ImageView(linearLayout.getContext());
        imageView.setId(View.generateViewId());
        imageView.setImageResource(R.drawable.down_arrow);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setColorFilter(debugView.primaryColor);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = 8;
        imageView.setLayoutParams(layoutParams);
        linearLayout.addView(imageView);
        linearLayout.setPadding(10, 10, 10, 10);
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.superwall.sdk.debug.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f93507a.pressedPreview();
            }
        });
        return linearLayout;
    }

    private final void showLocalizationPicker() {
        SWLocalizationActivity.Companion.setCompletion(new Function1() { // from class: com.superwall.sdk.debug.e
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DebugView.showLocalizationPicker$lambda$42(this.f93511a, (String) obj);
            }
        });
        AppCompatActivity encapsulatingActivity = getEncapsulatingActivity();
        if (encapsulatingActivity == null) {
            return;
        }
        encapsulatingActivity.startActivity(new Intent(encapsulatingActivity, (Class<?>) SWLocalizationActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showLocalizationPicker$lambda$42(DebugView debugView, String locale) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        Superwall.Companion.getInstance().setLocaleIdentifier(locale);
        BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.b()), null, null, new DebugView$showLocalizationPicker$1$1(debugView, null), 3, null);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object addPaywallPreview(kotlin.coroutines.Continuation<? super kotlin.Unit> r8) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 273
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.debug.DebugView.addPaywallPreview(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void addSubviews() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        addView(getActivityIndicator(), layoutParams);
        addView(getLogoImageView(), layoutParams);
        addView(getConsoleButton(), layoutParams);
        addView(getExitButton(), layoutParams);
        addView(getBottomButton(), layoutParams);
        addView(getPreviewContainerView(), layoutParams);
        addView(getPreviewPickerButton(), layoutParams);
        getPreviewContainerView().setClipToOutline(false);
        setBackgroundColor(this.lightBackgroundColor);
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.o(this);
        constraintSet.r(getPreviewContainerView().getId(), 6, 0, 6);
        constraintSet.r(getPreviewContainerView().getId(), 7, 0, 7);
        constraintSet.s(getPreviewContainerView().getId(), 3, getLogoImageView().getId(), 4, dpToPx(5));
        constraintSet.s(getPreviewContainerView().getId(), 4, getBottomButton().getId(), 3, dpToPx(5));
        constraintSet.u(getPreviewContainerView().getId(), 0);
        constraintSet.v(getLogoImageView().getId(), 0);
        constraintSet.u(getLogoImageView().getId(), dpToPx(20));
        constraintSet.s(getLogoImageView().getId(), 3, 0, 3, dpToPx(30));
        constraintSet.r(getLogoImageView().getId(), 6, getConsoleButton().getId(), 7);
        constraintSet.r(getLogoImageView().getId(), 7, getExitButton().getId(), 6);
        constraintSet.s(getConsoleButton().getId(), 6, 0, 6, dpToPx(25));
        constraintSet.s(getConsoleButton().getId(), 3, 0, 3, dpToPx(30));
        constraintSet.v(getConsoleButton().getId(), dpToPx(44));
        constraintSet.s(getExitButton().getId(), 7, 0, 7, dpToPx(25));
        constraintSet.s(getExitButton().getId(), 3, 0, 3, dpToPx(30));
        constraintSet.v(getExitButton().getId(), dpToPx(44));
        constraintSet.r(getActivityIndicator().getId(), 6, getPreviewContainerView().getId(), 6);
        constraintSet.r(getActivityIndicator().getId(), 7, getPreviewContainerView().getId(), 7);
        constraintSet.r(getActivityIndicator().getId(), 3, getPreviewContainerView().getId(), 3);
        constraintSet.r(getActivityIndicator().getId(), 4, getPreviewContainerView().getId(), 4);
        constraintSet.s(getBottomButton().getId(), 6, 0, 6, dpToPx(25));
        constraintSet.s(getBottomButton().getId(), 7, 0, 7, dpToPx(25));
        constraintSet.u(getBottomButton().getId(), dpToPx(60));
        constraintSet.s(getBottomButton().getId(), 4, 0, 4, dpToPx(30));
        constraintSet.s(getPreviewPickerButton().getId(), 6, getPreviewContainerView().getId(), 6, dpToPx(25));
        constraintSet.s(getPreviewPickerButton().getId(), 7, getPreviewContainerView().getId(), 7, dpToPx(25));
        constraintSet.u(getPreviewPickerButton().getId(), dpToPx(30));
        constraintSet.s(getPreviewPickerButton().getId(), 4, getBottomButton().getId(), 3, dpToPx(10));
        constraintSet.i(this);
    }

    public final int dpToPx(int i3) {
        return (int) (i3 * getResources().getDisplayMetrics().density);
    }

    /* JADX WARN: Code restructure failed: missing block: B:61:0x013d, code lost:
    
        if (kotlinx.coroutines.BuildersKt.g(r0, r5, r6) != r2) goto L66;
     */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object finishLoadingPreview(kotlin.coroutines.Continuation<? super kotlin.Unit> r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 344
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.debug.DebugView.finishLoadingPreview(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.superwall.sdk.debug.AppCompatActivityEncapsulatable
    public AppCompatActivity getEncapsulatingActivity() {
        return this.encapsulatingActivity;
    }

    public final String getPaywallDatabaseId$superwall_release() {
        return this.paywallDatabaseId;
    }

    public final boolean isActive$superwall_release() {
        return this.isActive;
    }

    public final void loadAndShowPaywall(boolean z2) {
        String str = this.paywallIdentifier;
        if (str == null) {
            return;
        }
        PresentationRequest presentationRequestMakePresentationRequest = this.factory.makePresentationRequest(new PresentationInfo.FromIdentifier(str, z2), null, getEncapsulatingActivity(), Boolean.TRUE, StateFlowKt.a(SubscriptionStatus.Inactive.INSTANCE), Superwall.Companion.getInstance().isPaywallPresented(), PresentationRequestType.Presentation.INSTANCE);
        MutableSharedFlow mutableSharedFlowB = SharedFlowKt.b(0, 0, null, 7, null);
        BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.c()), null, null, new C27921(mutableSharedFlowB, this, null), 3, null);
        BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.b()), null, null, new C27932(presentationRequestMakePresentationRequest, mutableSharedFlowB, null), 3, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0097, code lost:
    
        if (r2.finishLoadingPreview(r0) == r1) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00c7, code lost:
    
        if (r2.finishLoadingPreview(r0) == r1) goto L43;
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object loadPreview(kotlin.coroutines.Continuation<? super kotlin.Unit> r9) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 205
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.debug.DebugView.loadPreview(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void presentAlert(String str, String str2, final List<AlertOption> options) {
        View viewFindViewById;
        WindowManager.LayoutParams attributes;
        Intrinsics.checkNotNullParameter(options, "options");
        AppCompatActivity encapsulatingActivity = getEncapsulatingActivity();
        if (encapsulatingActivity == null) {
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(encapsulatingActivity);
        builder.setTitle(str);
        builder.setMessage(str2);
        List<AlertOption> list = options;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((AlertOption) it.next()).getTitle());
        }
        builder.setItems((String[]) arrayList.toArray(new String[0]), new DialogInterface.OnClickListener() { // from class: com.superwall.sdk.debug.c
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                DebugView.presentAlert$lambda$46(options, dialogInterface, i3);
            }
        });
        final AlertDialog alertDialogCreate = builder.create();
        Window window = alertDialogCreate.getWindow();
        if (window != null && (attributes = window.getAttributes()) != null) {
            attributes.gravity = 80;
        }
        Window window2 = alertDialogCreate.getWindow();
        if (window2 != null) {
            window2.setLayout(-1, -2);
        }
        alertDialogCreate.show();
        Window window3 = alertDialogCreate.getWindow();
        if (window3 == null || (viewFindViewById = window3.findViewById(androidx.appcompat.R.id.f746n)) == null) {
            return;
        }
        viewFindViewById.post(new Runnable() { // from class: com.superwall.sdk.debug.d
            @Override // java.lang.Runnable
            public final void run() {
                DebugView.presentAlert$lambda$47(alertDialogCreate);
            }
        });
    }

    public final void pressedBottomButton() {
        presentAlert("Which version?", null, CollectionsKt.listOf((Object[]) new AlertOption[]{new AlertOption("With Free Trial", new DebugView$pressedBottomButton$alertOptions$1(this, null), -1), new AlertOption("Without Free Trial", new DebugView$pressedBottomButton$alertOptions$2(this, null), -1)}));
    }

    public final void pressedConsoleButton() {
        String str;
        String strValueOf = "";
        try {
            PackageInfo packageInfo = this.context.getPackageManager().getPackageInfo(this.context.getPackageName(), 0);
            str = packageInfo.versionName;
            if (str == null) {
                str = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
            }
            try {
                strValueOf = String.valueOf(packageInfo.getLongVersionCode());
            } catch (PackageManager.NameNotFoundException unused) {
            }
        } catch (PackageManager.NameNotFoundException unused2) {
            str = "";
        }
        presentAlert("Superwall v" + BuildConfig.SDK_VERSION + " | App v" + str + " (" + strValueOf + ")", null, CollectionsKt.listOf((Object[]) new AlertOption[]{new AlertOption("Localization", new C27961(this), 0, 4, null), new AlertOption("Templates", new C27972(this), 0, 4, null)}));
    }

    public final void setActive$superwall_release(boolean z2) {
        this.isActive = z2;
    }

    @Override // com.superwall.sdk.debug.AppCompatActivityEncapsulatable
    public void setEncapsulatingActivity(AppCompatActivity appCompatActivity) {
        this.encapsulatingActivity = appCompatActivity;
    }

    public final void setPaywallDatabaseId$superwall_release(String str) {
        this.paywallDatabaseId = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object showConsole(kotlin.coroutines.Continuation<? super kotlin.Unit> r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 231
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.debug.DebugView.showConsole(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void viewDestroyed() {
        this.paywallManager.resetCache();
        this.debugManager.setDebuggerLaunched(false);
        Superwall.Companion.getInstance().getOptions().setLocaleIdentifier(this.initialLocaleIdentifier);
    }
}
