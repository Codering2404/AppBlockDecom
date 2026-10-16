package com.superwall.sdk.paywall.view.webview.messaging;

import android.app.Activity;
import android.webkit.JavascriptInterface;
import com.facebook.internal.AnalyticsEvents;
import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;
import com.revenuecat.purchases.common.responses.EntitlementsResponseJsonKeys;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.superwall.sdk.analytics.internal.trackable.InternalSuperwallEvent;
import com.superwall.sdk.analytics.internal.trackable.TrackableSuperwallEvent;
import com.superwall.sdk.analytics.superwall.SuperwallEvents;
import com.superwall.sdk.config.options.EventTrackingBehavior;
import com.superwall.sdk.config.options.SuperwallOptions;
import com.superwall.sdk.dependencies.OptionsFactory;
import com.superwall.sdk.dependencies.VariablesFactory;
import com.superwall.sdk.logger.LogLevel;
import com.superwall.sdk.logger.LogScope;
import com.superwall.sdk.logger.Loggable;
import com.superwall.sdk.logger.Logger;
import com.superwall.sdk.misc.MainScope;
import com.superwall.sdk.models.paywall.LocalNotification;
import com.superwall.sdk.models.paywall.Paywall;
import com.superwall.sdk.paywall.presentation.CustomCallback;
import com.superwall.sdk.paywall.presentation.CustomCallbackRegistry;
import com.superwall.sdk.paywall.presentation.CustomCallbackResult;
import com.superwall.sdk.paywall.presentation.CustomCallbackResultStatus;
import com.superwall.sdk.paywall.presentation.PaywallInfo;
import com.superwall.sdk.paywall.view.PaywallView;
import com.superwall.sdk.paywall.view.PaywallViewState;
import com.superwall.sdk.paywall.view.delegate.PaywallLoadingState;
import com.superwall.sdk.paywall.view.webview.SendPaywallMessages;
import com.superwall.sdk.paywall.view.webview.messaging.PaywallMessage;
import com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler;
import com.superwall.sdk.paywall.view.webview.messaging.PaywallWebEvent;
import com.superwall.sdk.permissions.PermissionStatus;
import com.superwall.sdk.permissions.PermissionType;
import com.superwall.sdk.permissions.UserPermissions;
import com.superwall.sdk.storage.core_data.ConvertersKt;
import cz.mobilesoft.coreblock.view.screen.ohO.MHoiDDglUlPJC;
import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonKt;
import kotlinx.serialization.json.JsonObject;

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
public final class PaywallMessageHandler implements SendPaywallMessages {
    private final CustomCallbackRegistry customCallbackRegistry;
    private final Function1<String, String> encodeToB64;
    private final VariablesFactory factory;
    private final Function0<Activity> getActivity;
    private final Function0<PaywallView> getView;
    private final Set<Job> inFlightTemplateSends;
    private final CoroutineScope ioScope;
    private final Json json;
    private final Object lifecycleLock;
    private final MainScope mainScope;
    private PaywallMessageHandlerDelegate messageHandler;
    private final OptionsFactory options;
    private final Queue<PendingLifecycle> queue;
    private final Function1<Map<String, ? extends Object>, Unit> setAttributes;
    private final Function2<TrackableSuperwallEvent, Continuation<? super Unit>, Object> track;
    private final UserPermissions userPermissions;
    private static final Companion Companion = new Companion(null);
    private static final String selectionString = "var css = '*{-webkit-touch-callout:none;-webkit-user-select:none} .w-webflow-badge { display: none !important; }';\n                    var head = document.head || document.getElementsByTagName('head')[0];\n                    var style = document.createElement('style'); style.type = 'text/css';\n                    style.appendChild(document.createTextNode(css)); head.appendChild(style); ";
    private static final String preventZoom = "var meta = document.createElement('meta');\n                        meta.name = 'viewport';\n                        meta.content = 'width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no';\n                        var head = document.getElementsByTagName('head')[0];\n                        head.appendChild(meta);";

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String getPreventZoom() {
            return PaywallMessageHandler.preventZoom;
        }

        public final String getSelectionString() {
            return PaywallMessageHandler.selectionString;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[PaywallMessage.RequestReview.Type.values().length];
            try {
                iArr[PaywallMessage.RequestReview.Type.EXTERNAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[PaywallMessage.HapticFeedback.HapticType.values().length];
            try {
                iArr2[PaywallMessage.HapticFeedback.HapticType.LIGHT.ordinal()] = 1;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr2[PaywallMessage.HapticFeedback.HapticType.MEDIUM.ordinal()] = 2;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[PaywallMessage.HapticFeedback.HapticType.HEAVY.ordinal()] = 3;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[PaywallMessage.HapticFeedback.HapticType.SUCCESS.ordinal()] = 4;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[PaywallMessage.HapticFeedback.HapticType.WARNING.ordinal()] = 5;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[PaywallMessage.HapticFeedback.HapticType.ERROR.ordinal()] = 6;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[PaywallMessage.HapticFeedback.HapticType.SELECTION.ordinal()] = 7;
            } catch (NoSuchFieldError unused8) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler$awaitInFlightTemplates$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler", f = "PaywallMessageHandler.kt", l = {146}, m = "awaitInFlightTemplates")
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PaywallMessageHandler.this.awaitInFlightTemplates(this);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler$didLoadWebView$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler", f = "PaywallMessageHandler.kt", l = {525, 551}, m = "didLoadWebView")
    static final class C28851 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C28851(Continuation<? super C28851> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PaywallMessageHandler.this.didLoadWebView(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler$didLoadWebView$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler$didLoadWebView$2", f = "PaywallMessageHandler.kt", l = {504, 507}, m = "invokeSuspend")
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Date $loadedAt;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Date date, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$loadedAt = date;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PaywallMessageHandler.this.new AnonymousClass2(this.$loadedAt, continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x006a, code lost:
        
            if (r1.passEventTrackingBehaviorToWebView(r6, r5) != r0) goto L18;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) throws java.lang.Throwable {
            /*
                r5 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r1 = r5.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L1e
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                kotlin.ResultKt.b(r6)
                goto L6d
            L12:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L1a:
                kotlin.ResultKt.b(r6)
                goto L54
            L1e:
                kotlin.ResultKt.b(r6)
                com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler r6 = com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler.this
                com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandlerDelegate r6 = r6.getMessageHandler()
                if (r6 == 0) goto L6d
                com.superwall.sdk.paywall.view.PaywallViewState$Updates$WebLoadingEnded r1 = new com.superwall.sdk.paywall.view.PaywallViewState$Updates$WebLoadingEnded
                java.util.Date r4 = r5.$loadedAt
                r1.<init>(r4)
                r6.updateState(r1)
                com.superwall.sdk.paywall.view.PaywallViewState r6 = r6.getState()
                com.superwall.sdk.paywall.presentation.PaywallInfo r6 = r6.getInfo()
                com.superwall.sdk.analytics.internal.trackable.InternalSuperwallEvent$PaywallWebviewLoad r1 = new com.superwall.sdk.analytics.internal.trackable.InternalSuperwallEvent$PaywallWebviewLoad
                com.superwall.sdk.analytics.internal.trackable.InternalSuperwallEvent$PaywallWebviewLoad$State$Complete r4 = new com.superwall.sdk.analytics.internal.trackable.InternalSuperwallEvent$PaywallWebviewLoad$State$Complete
                r4.<init>()
                r1.<init>(r4, r6)
                com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler r6 = com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler.this
                kotlin.jvm.functions.Function2 r6 = com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler.access$getTrack$p(r6)
                r5.label = r3
                java.lang.Object r6 = r6.invoke(r1, r5)
                if (r6 != r0) goto L54
                goto L6c
            L54:
                com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler r6 = com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler.this
                com.superwall.sdk.dependencies.OptionsFactory r6 = com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler.access$getOptions$p(r6)
                com.superwall.sdk.config.options.SuperwallOptions r6 = r6.makeSuperwallOptions()
                com.superwall.sdk.config.options.EventTrackingBehavior r6 = r6.getEventTrackingBehavior()
                com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler r1 = com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler.this
                r5.label = r2
                java.lang.Object r6 = r1.passEventTrackingBehaviorToWebView(r6, r5)
                if (r6 != r0) goto L6d
            L6c:
                return r0
            L6d:
                kotlin.Unit r6 = kotlin.Unit.f139807a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler$didLoadWebView$6, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler$didLoadWebView$6", f = "PaywallMessageHandler.kt", l = {}, m = "invokeSuspend")
    static final class AnonymousClass6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $scriptSrc;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass6(String str, Continuation<? super AnonymousClass6> continuation) {
            super(2, continuation);
            this.$scriptSrc = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$2(String str, String str2) {
            if (str2 != null) {
                Logger logger = Logger.INSTANCE;
                LogLevel logLevel = LogLevel.error;
                LogScope logScope = LogScope.paywallView;
                Exception exc = new Exception(str2);
                Loggable.Companion companion = Loggable.Companion;
                if (companion.willLog(logLevel, logScope)) {
                    companion.emit(logLevel, logScope, "Error Evaluating JS", MapsKt.mapOf(TuplesKt.a("message", str)), exc);
                }
            }
            return Unit.f139807a;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PaywallMessageHandler.this.new AnonymousClass6(this.$scriptSrc, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            JobKt.k(getContext());
            PaywallMessageHandlerDelegate messageHandler = PaywallMessageHandler.this.getMessageHandler();
            if (messageHandler != null) {
                final String str = this.$scriptSrc;
                messageHandler.evaluate(str, new Function1() { // from class: com.superwall.sdk.paywall.view.webview.messaging.e
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return PaywallMessageHandler.AnonymousClass6.invokeSuspend$lambda$2(str, (String) obj2);
                    }
                });
            }
            PaywallMessageHandlerDelegate messageHandler2 = PaywallMessageHandler.this.getMessageHandler();
            if (messageHandler2 != null) {
                messageHandler2.evaluate(PaywallMessageHandler.Companion.getSelectionString(), null);
            }
            PaywallMessageHandlerDelegate messageHandler3 = PaywallMessageHandler.this.getMessageHandler();
            if (messageHandler3 != null) {
                messageHandler3.evaluate(PaywallMessageHandler.Companion.getPreventZoom(), null);
            }
            PaywallMessageHandler.this.flushPendingMessagesInternal();
            PaywallMessageHandlerDelegate messageHandler4 = PaywallMessageHandler.this.getMessageHandler();
            if (messageHandler4 == null) {
                return null;
            }
            messageHandler4.updateState(new PaywallViewState.Updates.SetLoadingState(PaywallLoadingState.Ready.INSTANCE));
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass6) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler$flushPendingMessages$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler$flushPendingMessages$1", f = "PaywallMessageHandler.kt", l = {}, m = "invokeSuspend")
    static final class C28861 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        /* JADX INFO: renamed from: com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler$flushPendingMessages$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler$flushPendingMessages$1$1", f = "PaywallMessageHandler.kt", l = {}, m = "invokeSuspend")
        static final class C02521 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ PaywallMessageHandler this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C02521(PaywallMessageHandler paywallMessageHandler, Continuation<? super C02521> continuation) {
                super(2, continuation);
                this.this$0 = paywallMessageHandler;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C02521(this.this$0, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                IntrinsicsKt.f();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                this.this$0.flushPendingMessagesInternal();
                return Unit.f139807a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C02521) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
            }
        }

        C28861(Continuation<? super C28861> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PaywallMessageHandler.this.new C28861(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            BuildersKt__Builders_commonKt.d(PaywallMessageHandler.this.mainScope, null, null, new C02521(PaywallMessageHandler.this, null), 3, null);
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C28861) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler$getState$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler", f = "PaywallMessageHandler.kt", l = {999}, m = "getState")
    static final class C28871 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C28871(Continuation<? super C28871> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PaywallMessageHandler.this.getState(this);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler$getState$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler$getState$2", f = "PaywallMessageHandler.kt", l = {1041}, m = "invokeSuspend")
    static final class C28882 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Map<String, ? extends Object>>, Object> {
        final /* synthetic */ String $messageScript;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C28882(String str, Continuation<? super C28882> continuation) {
            super(2, continuation);
            this.$messageScript = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PaywallMessageHandler.this.new C28882(this.$messageScript, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Map<String, ? extends Object>> continuation) {
            return ((C28882) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 != 0) {
                if (i3 == 1) {
                    ResultKt.b(obj);
                    return obj;
                }
                throw new IllegalStateException(MHoiDDglUlPJC.pKGroKjMgGD);
            }
            ResultKt.b(obj);
            PaywallMessageHandler paywallMessageHandler = PaywallMessageHandler.this;
            String str = this.$messageScript;
            this.L$0 = paywallMessageHandler;
            this.L$1 = str;
            this.label = 1;
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(this), 1);
            cancellableContinuationImpl.C();
            BuildersKt__Builders_commonKt.d(paywallMessageHandler.mainScope, null, null, new PaywallMessageHandler$getState$2$1$1(paywallMessageHandler, str, cancellableContinuationImpl, null), 3, null);
            Object objV = cancellableContinuationImpl.v();
            if (objV == IntrinsicsKt.f()) {
                DebugProbesKt.c(this);
            }
            if (objV == objF) {
                return objF;
            }
            return objV;
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler$handle$10, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler$handle$10", f = "PaywallMessageHandler.kt", l = {337}, m = "invokeSuspend")
    static final class AnonymousClass10 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PaywallMessage $message;
        final /* synthetic */ Paywall $paywall;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass10(Paywall paywall, PaywallMessage paywallMessage, Continuation<? super AnonymousClass10> continuation) {
            super(2, continuation);
            this.$paywall = paywall;
            this.$message = paywallMessage;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PaywallMessageHandler.this.new AnonymousClass10(this.$paywall, this.$message, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                PaywallMessageHandler paywallMessageHandler = PaywallMessageHandler.this;
                String rawName = SuperwallEvents.FreeTrialStart.getRawName();
                Paywall paywall = this.$paywall;
                PaywallMessage paywallMessage = this.$message;
                Map mapCreateMapBuilder = MapsKt.createMapBuilder();
                PaywallMessage.TrialStarted trialStarted = (PaywallMessage.TrialStarted) paywallMessage;
                Long trialEndDate = trialStarted.getTrialEndDate();
                if (trialEndDate != null) {
                    mapCreateMapBuilder.put("trial_end_date", Boxing.e(trialEndDate.longValue()));
                }
                mapCreateMapBuilder.put(EntitlementsResponseJsonKeys.PRODUCT_IDENTIFIER, trialStarted.getProductIdentifier());
                Unit unit = Unit.f139807a;
                Map mapBuild = MapsKt.build(mapCreateMapBuilder);
                this.label = 1;
                if (paywallMessageHandler.pass(rawName, paywall, mapBuild, this) == objF) {
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
            return ((AnonymousClass10) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler$handle$11, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler$handle$11", f = "PaywallMessageHandler.kt", l = {372}, m = "invokeSuspend")
    static final class AnonymousClass11 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PaywallMessage $message;
        final /* synthetic */ PaywallInfo $paywallInfo;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass11(PaywallInfo paywallInfo, PaywallMessage paywallMessage, Continuation<? super AnonymousClass11> continuation) {
            super(2, continuation);
            this.$paywallInfo = paywallInfo;
            this.$message = paywallMessage;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PaywallMessageHandler.this.new AnonymousClass11(this.$paywallInfo, this.$message, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                Function2 function2 = PaywallMessageHandler.this.track;
                InternalSuperwallEvent.PaywallPageView paywallPageView = new InternalSuperwallEvent.PaywallPageView(this.$paywallInfo, ((PaywallMessage.PageView) this.$message).getData());
                this.label = 1;
                if (function2.invoke(paywallPageView, this) == objF) {
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
            return ((AnonymousClass11) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler$handle$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler$handle$3", f = "PaywallMessageHandler.kt", l = {250}, m = "invokeSuspend")
    static final class AnonymousClass3 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Paywall $paywall;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(Paywall paywall, Continuation<? super AnonymousClass3> continuation) {
            super(1, continuation);
            this.$paywall = paywall;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return PaywallMessageHandler.this.new AnonymousClass3(this.$paywall, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                PaywallMessageHandler paywallMessageHandler = PaywallMessageHandler.this;
                Paywall paywall = this.$paywall;
                this.label = 1;
                if (paywallMessageHandler.passTemplatesToWebView(paywall, this) == objF) {
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

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler$handle$5, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler$handle$5", f = "PaywallMessageHandler.kt", l = {297}, m = "invokeSuspend")
    static final class AnonymousClass5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Paywall $paywall;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass5(Paywall paywall, Continuation<? super AnonymousClass5> continuation) {
            super(2, continuation);
            this.$paywall = paywall;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PaywallMessageHandler.this.new AnonymousClass5(this.$paywall, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                PaywallMessageHandler paywallMessageHandler = PaywallMessageHandler.this;
                Paywall paywall = this.$paywall;
                this.label = 1;
                if (PaywallMessageHandler.pass$default(paywallMessageHandler, "back_button_input", paywall, null, this, 4, null) == objF) {
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
            return ((AnonymousClass5) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler$handle$6, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler$handle$6", f = "PaywallMessageHandler.kt", l = {RCHTTPStatusCodes.NOT_MODIFIED}, m = "invokeSuspend")
    static final class C28896 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Paywall $paywall;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C28896(Paywall paywall, Continuation<? super C28896> continuation) {
            super(2, continuation);
            this.$paywall = paywall;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PaywallMessageHandler.this.new C28896(this.$paywall, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                PaywallMessageHandler paywallMessageHandler = PaywallMessageHandler.this;
                String rawName = SuperwallEvents.RestoreFail.getRawName();
                Paywall paywall = this.$paywall;
                this.label = 1;
                if (PaywallMessageHandler.pass$default(paywallMessageHandler, rawName, paywall, null, this, 4, null) == objF) {
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
            return ((C28896) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler$handle$7, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler$handle$7", f = "PaywallMessageHandler.kt", l = {311}, m = "invokeSuspend")
    static final class AnonymousClass7 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Paywall $paywall;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass7(Paywall paywall, Continuation<? super AnonymousClass7> continuation) {
            super(2, continuation);
            this.$paywall = paywall;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PaywallMessageHandler.this.new AnonymousClass7(this.$paywall, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                PaywallMessageHandler paywallMessageHandler = PaywallMessageHandler.this;
                String rawName = SuperwallEvents.TransactionStart.getRawName();
                Paywall paywall = this.$paywall;
                this.label = 1;
                if (PaywallMessageHandler.pass$default(paywallMessageHandler, rawName, paywall, null, this, 4, null) == objF) {
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
            return ((AnonymousClass7) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler$handle$8, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler$handle$8", f = "PaywallMessageHandler.kt", l = {317}, m = "invokeSuspend")
    static final class AnonymousClass8 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Paywall $paywall;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass8(Paywall paywall, Continuation<? super AnonymousClass8> continuation) {
            super(2, continuation);
            this.$paywall = paywall;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PaywallMessageHandler.this.new AnonymousClass8(this.$paywall, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                PaywallMessageHandler paywallMessageHandler = PaywallMessageHandler.this;
                String rawName = SuperwallEvents.TransactionAbandon.getRawName();
                Paywall paywall = this.$paywall;
                this.label = 1;
                if (PaywallMessageHandler.pass$default(paywallMessageHandler, rawName, paywall, null, this, 4, null) == objF) {
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
            return ((AnonymousClass8) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler$handle$9, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler$handle$9", f = "PaywallMessageHandler.kt", l = {327}, m = "invokeSuspend")
    static final class AnonymousClass9 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PaywallMessage $message;
        final /* synthetic */ Paywall $paywall;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass9(Paywall paywall, PaywallMessage paywallMessage, Continuation<? super AnonymousClass9> continuation) {
            super(2, continuation);
            this.$paywall = paywall;
            this.$message = paywallMessage;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PaywallMessageHandler.this.new AnonymousClass9(this.$paywall, this.$message, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                PaywallMessageHandler paywallMessageHandler = PaywallMessageHandler.this;
                String rawName = SuperwallEvents.TransactionComplete.getRawName();
                Paywall paywall = this.$paywall;
                Map mapMapOf = MapsKt.mapOf(TuplesKt.a(EntitlementsResponseJsonKeys.PRODUCT_IDENTIFIER, ((PaywallMessage.TransactionComplete) this.$message).getProductIdentifier()));
                this.label = 1;
                if (paywallMessageHandler.pass(rawName, paywall, mapMapOf, this) == objF) {
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
            return ((AnonymousClass9) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler$handleRequestCallback$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler$handleRequestCallback$1", f = "PaywallMessageHandler.kt", l = {824}, m = "invokeSuspend")
    static final class C28901 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PaywallMessage.RequestCallback $request;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C28901(PaywallMessage.RequestCallback requestCallback, Continuation<? super C28901> continuation) {
            super(2, continuation);
            this.$request = requestCallback;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PaywallMessageHandler.this.new C28901(this.$request, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                PaywallMessageHandler paywallMessageHandler = PaywallMessageHandler.this;
                String requestId = this.$request.getRequestId();
                String name = this.$request.getName();
                CustomCallbackResultStatus customCallbackResultStatus = CustomCallbackResultStatus.FAILURE;
                this.label = 1;
                if (paywallMessageHandler.sendCallbackResult(requestId, name, customCallbackResultStatus, null, this) == objF) {
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
            return ((C28901) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler$handleRequestCallback$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler$handleRequestCallback$2", f = "PaywallMessageHandler.kt", l = {842, 853}, m = "invokeSuspend")
    static final class C28912 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<CustomCallback, Continuation<? super CustomCallbackResult>, Object> $callbackHandler;
        final /* synthetic */ PaywallMessage.RequestCallback $request;
        int label;
        final /* synthetic */ PaywallMessageHandler this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C28912(PaywallMessage.RequestCallback requestCallback, Function2<? super CustomCallback, ? super Continuation<? super CustomCallbackResult>, ? extends Object> function2, PaywallMessageHandler paywallMessageHandler, Continuation<? super C28912> continuation) {
            super(2, continuation);
            this.$request = requestCallback;
            this.$callbackHandler = function2;
            this.this$0 = paywallMessageHandler;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C28912(this.$request, this.$callbackHandler, this.this$0, continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:21:0x008b, code lost:
        
            if (r3.sendCallbackResult(r4, r5, r6, r7, r12) == r1) goto L22;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r13) throws java.lang.Throwable {
            /*
                r12 = this;
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r0 = r12.label
                r2 = 2
                r3 = 1
                if (r0 == 0) goto L23
                if (r0 == r3) goto L1b
                if (r0 != r2) goto L13
                kotlin.ResultKt.b(r13)
                goto L8e
            L13:
                java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r13.<init>(r0)
                throw r13
            L1b:
                kotlin.ResultKt.b(r13)     // Catch: java.lang.Exception -> L1f
                goto L42
            L1f:
                r0 = move-exception
                r13 = r0
                r9 = r13
                goto L45
            L23:
                kotlin.ResultKt.b(r13)
                com.superwall.sdk.paywall.presentation.CustomCallback r13 = new com.superwall.sdk.paywall.presentation.CustomCallback     // Catch: java.lang.Exception -> L1f
                com.superwall.sdk.paywall.view.webview.messaging.PaywallMessage$RequestCallback r0 = r12.$request     // Catch: java.lang.Exception -> L1f
                java.lang.String r0 = r0.getName()     // Catch: java.lang.Exception -> L1f
                com.superwall.sdk.paywall.view.webview.messaging.PaywallMessage$RequestCallback r4 = r12.$request     // Catch: java.lang.Exception -> L1f
                java.util.Map r4 = r4.getVariables()     // Catch: java.lang.Exception -> L1f
                r13.<init>(r0, r4)     // Catch: java.lang.Exception -> L1f
                kotlin.jvm.functions.Function2<com.superwall.sdk.paywall.presentation.CustomCallback, kotlin.coroutines.Continuation<? super com.superwall.sdk.paywall.presentation.CustomCallbackResult>, java.lang.Object> r0 = r12.$callbackHandler     // Catch: java.lang.Exception -> L1f
                r12.label = r3     // Catch: java.lang.Exception -> L1f
                java.lang.Object r13 = r0.invoke(r13, r12)     // Catch: java.lang.Exception -> L1f
                if (r13 != r1) goto L42
                goto L8d
            L42:
                com.superwall.sdk.paywall.presentation.CustomCallbackResult r13 = (com.superwall.sdk.paywall.presentation.CustomCallbackResult) r13     // Catch: java.lang.Exception -> L1f
                goto L6e
            L45:
                com.superwall.sdk.logger.Logger r4 = com.superwall.sdk.logger.Logger.INSTANCE
                com.superwall.sdk.logger.LogLevel r5 = com.superwall.sdk.logger.LogLevel.error
                com.superwall.sdk.logger.LogScope r6 = com.superwall.sdk.logger.LogScope.superwallCore
                java.lang.String r13 = r9.getMessage()
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r7 = "Error executing custom callback: "
                r0.append(r7)
                r0.append(r13)
                java.lang.String r7 = r0.toString()
                r10 = 8
                r11 = 0
                r8 = 0
                com.superwall.sdk.logger.Logger.debug$default(r4, r5, r6, r7, r8, r9, r10, r11)
                com.superwall.sdk.paywall.presentation.CustomCallbackResult$Companion r13 = com.superwall.sdk.paywall.presentation.CustomCallbackResult.Companion
                r0 = 0
                com.superwall.sdk.paywall.presentation.CustomCallbackResult r13 = com.superwall.sdk.paywall.presentation.CustomCallbackResult.Companion.failure$default(r13, r0, r3, r0)
            L6e:
                com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler r3 = r12.this$0
                com.superwall.sdk.paywall.view.webview.messaging.PaywallMessage$RequestCallback r0 = r12.$request
                java.lang.String r4 = r0.getRequestId()
                com.superwall.sdk.paywall.view.webview.messaging.PaywallMessage$RequestCallback r0 = r12.$request
                java.lang.String r5 = r0.getName()
                com.superwall.sdk.paywall.presentation.CustomCallbackResultStatus r6 = r13.getStatus()
                java.util.Map r7 = r13.getData()
                r12.label = r2
                r8 = r12
                java.lang.Object r13 = com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler.access$sendCallbackResult(r3, r4, r5, r6, r7, r8)
                if (r13 != r1) goto L8e
            L8d:
                return r1
            L8e:
                kotlin.Unit r13 = kotlin.Unit.f139807a
                return r13
            */
            throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler.C28912.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C28912) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler$handleRequestPermission$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler$handleRequestPermission$1", f = "PaywallMessageHandler.kt", l = {689}, m = "invokeSuspend")
    static final class C28921 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $paywallIdentifier;
        final /* synthetic */ String $permissionName;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C28921(String str, String str2, Continuation<? super C28921> continuation) {
            super(2, continuation);
            this.$permissionName = str;
            this.$paywallIdentifier = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PaywallMessageHandler.this.new C28921(this.$permissionName, this.$paywallIdentifier, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                Function2 function2 = PaywallMessageHandler.this.track;
                InternalSuperwallEvent.Permission permission = new InternalSuperwallEvent.Permission(InternalSuperwallEvent.Permission.State.Requested, this.$permissionName, this.$paywallIdentifier);
                this.label = 1;
                if (function2.invoke(permission, this) == objF) {
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
            return ((C28921) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler$handleRequestPermission$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler$handleRequestPermission$2", f = "PaywallMessageHandler.kt", l = {706}, m = "invokeSuspend")
    static final class C28932 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PaywallMessage.RequestPermission $request;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C28932(PaywallMessage.RequestPermission requestPermission, Continuation<? super C28932> continuation) {
            super(2, continuation);
            this.$request = requestPermission;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PaywallMessageHandler.this.new C28932(this.$request, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                PaywallMessageHandler paywallMessageHandler = PaywallMessageHandler.this;
                String requestId = this.$request.getRequestId();
                PermissionType permissionType = this.$request.getPermissionType();
                PermissionStatus permissionStatus = PermissionStatus.UNSUPPORTED;
                this.label = 1;
                if (paywallMessageHandler.sendPermissionResult(requestId, permissionType, permissionStatus, this) == objF) {
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
            return ((C28932) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler$handleRequestPermission$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler$handleRequestPermission$3", f = "PaywallMessageHandler.kt", l = {718, 732, 742, 752}, m = "invokeSuspend")
    static final class C28943 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Activity $activity;
        final /* synthetic */ String $paywallIdentifier;
        final /* synthetic */ String $permissionName;
        final /* synthetic */ PaywallMessage.RequestPermission $request;
        Object L$0;
        int label;

        /* JADX INFO: renamed from: com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler$handleRequestPermission$3$WhenMappings */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[PermissionStatus.values().length];
                try {
                    iArr[PermissionStatus.GRANTED.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[PermissionStatus.DENIED.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[PermissionStatus.UNSUPPORTED.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C28943(Activity activity, PaywallMessage.RequestPermission requestPermission, String str, String str2, Continuation<? super C28943> continuation) {
            super(2, continuation);
            this.$activity = activity;
            this.$request = requestPermission;
            this.$permissionName = str;
            this.$paywallIdentifier = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PaywallMessageHandler.this.new C28943(this.$activity, this.$request, this.$permissionName, this.$paywallIdentifier, continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:37:0x00da, code lost:
        
            if (r15.sendPermissionResult(r3, r4, r0, r14) != r1) goto L39;
         */
        /* JADX WARN: Removed duplicated region for block: B:36:0x00c3 A[PHI: r0
          0x00c3: PHI (r0v4 com.superwall.sdk.permissions.PermissionStatus) = 
          (r0v3 com.superwall.sdk.permissions.PermissionStatus)
          (r0v3 com.superwall.sdk.permissions.PermissionStatus)
          (r0v7 com.superwall.sdk.permissions.PermissionStatus)
         binds: [B:34:0x00c0, B:31:0x00a4, B:11:0x0021] A[DONT_GENERATE, DONT_INLINE]] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r15) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 224
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler.C28943.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C28943) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler$hapticFeedback$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler$hapticFeedback$1", f = "PaywallMessageHandler.kt", l = {}, m = "invokeSuspend")
    static final class C28951 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C28951(Continuation<? super C28951> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PaywallMessageHandler.this.new C28951(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            PaywallView paywallView = (PaywallView) PaywallMessageHandler.this.getView.invoke();
            if (paywallView != null) {
                Boxing.a(paywallView.performHapticFeedback(1));
            }
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C28951) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler$passMessageToWebView$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler$passMessageToWebView$4", f = "PaywallMessageHandler.kt", l = {}, m = "invokeSuspend")
    static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $templateScript;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(String str, Continuation<? super AnonymousClass4> continuation) {
            super(2, continuation);
            this.$templateScript = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$2(String str, String str2) {
            if (str2 != null) {
                Logger logger = Logger.INSTANCE;
                LogLevel logLevel = LogLevel.error;
                LogScope logScope = LogScope.paywallView;
                Exception exc = new Exception(str2);
                Loggable.Companion companion = Loggable.Companion;
                if (companion.willLog(logLevel, logScope)) {
                    companion.emit(logLevel, logScope, "Error Evaluating JS", MapsKt.mapOf(TuplesKt.a("message", str)), exc);
                }
            }
            return Unit.f139807a;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PaywallMessageHandler.this.new AnonymousClass4(this.$templateScript, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            JobKt.k(getContext());
            PaywallMessageHandlerDelegate messageHandler = PaywallMessageHandler.this.getMessageHandler();
            if (messageHandler == null) {
                return null;
            }
            final String str = this.$templateScript;
            messageHandler.evaluate(str, new Function1() { // from class: com.superwall.sdk.paywall.view.webview.messaging.f
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return PaywallMessageHandler.AnonymousClass4.invokeSuspend$lambda$2(str, (String) obj2);
                }
            });
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass4) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler$passTemplatesToWebView$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler", f = "PaywallMessageHandler.kt", l = {450, 457}, m = "passTemplatesToWebView")
    static final class C28961 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C28961(Continuation<? super C28961> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PaywallMessageHandler.this.passTemplatesToWebView(null, this);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler$sendLifecycleWhenReady$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler$sendLifecycleWhenReady$2", f = "PaywallMessageHandler.kt", l = {170, 182}, m = "invokeSuspend")
    static final class C28972 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PendingLifecycle $pending;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C28972(PendingLifecycle pendingLifecycle, Continuation<? super C28972> continuation) {
            super(2, continuation);
            this.$pending = pendingLifecycle;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PaywallMessageHandler.this.new C28972(this.$pending, continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:34:0x0085, code lost:
        
            if (com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler.pass$default(r3, r4, r5, null, r10, 4, null) == r0) goto L35;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r11) throws java.lang.Throwable {
            /*
                r10 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r1 = r10.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L1f
                if (r1 == r3) goto L1b
                if (r1 != r2) goto L13
                kotlin.ResultKt.b(r11)
                goto L88
            L13:
                java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r11.<init>(r0)
                throw r11
            L1b:
                kotlin.ResultKt.b(r11)
                goto L2d
            L1f:
                kotlin.ResultKt.b(r11)
                com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler r11 = com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler.this
                r10.label = r3
                java.lang.Object r11 = com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler.access$awaitInFlightTemplates(r11, r10)
                if (r11 != r0) goto L2d
                goto L87
            L2d:
                com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler$PendingLifecycle r11 = r10.$pending
                kotlin.jvm.functions.Function0 r11 = r11.getShouldSend()
                java.lang.Object r11 = r11.invoke()
                java.lang.Boolean r11 = (java.lang.Boolean) r11
                boolean r11 = r11.booleanValue()
                if (r11 != 0) goto L42
                kotlin.Unit r11 = kotlin.Unit.f139807a
                return r11
            L42:
                com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler r11 = com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler.this
                com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandlerDelegate r11 = r11.getMessageHandler()
                if (r11 == 0) goto L8b
                com.superwall.sdk.paywall.view.PaywallViewState r11 = r11.getState()
                if (r11 == 0) goto L8b
                com.superwall.sdk.models.paywall.Paywall r5 = r11.getPaywall()
                if (r5 != 0) goto L57
                goto L8b
            L57:
                java.lang.String r11 = r5.getPaywalljsVersion()
                if (r11 != 0) goto L60
                kotlin.Unit r11 = kotlin.Unit.f139807a
                return r11
            L60:
                com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler$PendingLifecycle r11 = r10.$pending
                com.superwall.sdk.paywall.view.webview.messaging.PaywallMessage r11 = r11.getMessage()
                boolean r11 = r11 instanceof com.superwall.sdk.paywall.view.webview.messaging.PaywallMessage.PaywallOpen
                if (r11 == 0) goto L72
                com.superwall.sdk.analytics.superwall.SuperwallEvents r11 = com.superwall.sdk.analytics.superwall.SuperwallEvents.PaywallOpen
                java.lang.String r11 = r11.getRawName()
            L70:
                r4 = r11
                goto L79
            L72:
                com.superwall.sdk.analytics.superwall.SuperwallEvents r11 = com.superwall.sdk.analytics.superwall.SuperwallEvents.PaywallClose
                java.lang.String r11 = r11.getRawName()
                goto L70
            L79:
                com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler r3 = com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler.this
                r10.label = r2
                r6 = 0
                r8 = 4
                r9 = 0
                r7 = r10
                java.lang.Object r11 = com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler.pass$default(r3, r4, r5, r6, r7, r8, r9)
                if (r11 != r0) goto L88
            L87:
                return r0
            L88:
                kotlin.Unit r11 = kotlin.Unit.f139807a
                return r11
            L8b:
                kotlin.Unit r11 = kotlin.Unit.f139807a
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler.C28972.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C28972) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PaywallMessageHandler(VariablesFactory factory, OptionsFactory options, Function2<? super TrackableSuperwallEvent, ? super Continuation<? super Unit>, ? extends Object> track, Function1<? super Map<String, ? extends Object>, Unit> setAttributes, Function0<PaywallView> getView, MainScope mainScope, CoroutineScope ioScope, Json json, Function1<? super String, String> encodeToB64, UserPermissions userPermissions, Function0<? extends Activity> getActivity, CustomCallbackRegistry customCallbackRegistry) {
        Intrinsics.checkNotNullParameter(factory, "factory");
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(track, "track");
        Intrinsics.checkNotNullParameter(setAttributes, "setAttributes");
        Intrinsics.checkNotNullParameter(getView, "getView");
        Intrinsics.checkNotNullParameter(mainScope, "mainScope");
        Intrinsics.checkNotNullParameter(ioScope, "ioScope");
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(encodeToB64, "encodeToB64");
        Intrinsics.checkNotNullParameter(userPermissions, "userPermissions");
        Intrinsics.checkNotNullParameter(getActivity, "getActivity");
        Intrinsics.checkNotNullParameter(customCallbackRegistry, "customCallbackRegistry");
        this.factory = factory;
        this.options = options;
        this.track = track;
        this.setAttributes = setAttributes;
        this.getView = getView;
        this.mainScope = mainScope;
        this.ioScope = ioScope;
        this.json = json;
        this.encodeToB64 = encodeToB64;
        this.userPermissions = userPermissions;
        this.getActivity = getActivity;
        this.customCallbackRegistry = customCallbackRegistry;
        this.lifecycleLock = new Object();
        this.inFlightTemplateSends = new LinkedHashSet();
        this.queue = new ConcurrentLinkedQueue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$0(JsonBuilder Json) {
        Intrinsics.checkNotNullParameter(Json, "$this$Json");
        Json.f(true);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object awaitInFlightTemplates(kotlin.coroutines.Continuation<? super kotlin.Unit> r9) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r9 instanceof com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r9
            com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler$awaitInFlightTemplates$1 r0 = (com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler$awaitInFlightTemplates$1 r0 = new com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler$awaitInFlightTemplates$1
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.b(r9)
            goto L45
        L29:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L31:
            kotlin.ResultKt.b(r9)
            com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler$awaitInFlightTemplates$completed$1 r9 = new com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler$awaitInFlightTemplates$completed$1
            r2 = 0
            r9.<init>(r8, r2)
            r0.label = r3
            r2 = 10000(0x2710, double:4.9407E-320)
            java.lang.Object r9 = kotlinx.coroutines.TimeoutKt.e(r2, r9, r0)
            if (r9 != r1) goto L45
            return r1
        L45:
            kotlin.Unit r9 = (kotlin.Unit) r9
            if (r9 != 0) goto L59
            com.superwall.sdk.logger.Logger r0 = com.superwall.sdk.logger.Logger.INSTANCE
            com.superwall.sdk.logger.LogLevel r1 = com.superwall.sdk.logger.LogLevel.warn
            com.superwall.sdk.logger.LogScope r2 = com.superwall.sdk.logger.LogScope.paywallView
            r6 = 24
            r7 = 0
            java.lang.String r3 = "Timed out waiting for template_variables; sending lifecycle anyway"
            r4 = 0
            r5 = 0
            com.superwall.sdk.logger.Logger.debug$default(r0, r1, r2, r3, r4, r5, r6, r7)
        L59:
            kotlin.Unit r9 = kotlin.Unit.f139807a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler.awaitInFlightTemplates(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void detectHiddenPaywallEvent(String str, Map<String, ? extends Object> map) {
        PaywallViewState state;
        PaywallMessageHandlerDelegate paywallMessageHandlerDelegate = this.messageHandler;
        if (paywallMessageHandlerDelegate == null || (state = paywallMessageHandlerDelegate.getState()) == null || !state.isPresented()) {
            Map mapMutableMapOf = MapsKt.mutableMapOf(TuplesKt.a("self", this), TuplesKt.a("Superwall.instance.paywallViewController", String.valueOf(this.getView.invoke())), TuplesKt.a("event", str));
            if (map != null) {
                mapMutableMapOf.putAll(map);
            }
            Logger.debug$default(Logger.INSTANCE, LogLevel.error, LogScope.paywallView, "Received Event on Hidden Superwall", mapMutableMapOf, (Throwable) null, 16, (Object) null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void detectHiddenPaywallEvent$default(PaywallMessageHandler paywallMessageHandler, String str, Map map, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            map = null;
        }
        paywallMessageHandler.detectHiddenPaywallEvent(str, map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object didLoadWebView(com.superwall.sdk.models.paywall.Paywall r27, java.util.Date r28, kotlin.coroutines.Continuation<? super kotlin.Unit> r29) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 294
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler.didLoadWebView(com.superwall.sdk.models.paywall.Paywall, java.util.Date, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void flushPendingMessagesInternal() {
        ArrayList arrayList = new ArrayList();
        while (true) {
            PendingLifecycle pendingLifecyclePoll = this.queue.poll();
            if (pendingLifecyclePoll == null) {
                break;
            } else {
                arrayList.add(pendingLifecyclePoll);
            }
        }
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            sendLifecycleWhenReady((PendingLifecycle) obj);
        }
    }

    private final void handleCustomEvent(String str) {
        detectHiddenPaywallEvent("custom", MapsKt.mapOf(TuplesKt.a("custom_event", str)));
        PaywallMessageHandlerDelegate paywallMessageHandlerDelegate = this.messageHandler;
        if (paywallMessageHandlerDelegate != null) {
            paywallMessageHandlerDelegate.eventDidOccur(new PaywallWebEvent.Custom(str));
        }
    }

    private final void handleCustomPlacement(String str, JsonObject jsonObject) {
        PaywallMessageHandlerDelegate paywallMessageHandlerDelegate = this.messageHandler;
        if (paywallMessageHandlerDelegate != null) {
            paywallMessageHandlerDelegate.eventDidOccur(new PaywallWebEvent.CustomPlacement(str, jsonObject));
        }
    }

    private final void handleRequestCallback(PaywallMessage.RequestCallback requestCallback) {
        String identifier;
        PaywallViewState state;
        Paywall paywall;
        PaywallMessageHandlerDelegate paywallMessageHandlerDelegate = this.messageHandler;
        if (paywallMessageHandlerDelegate == null || (state = paywallMessageHandlerDelegate.getState()) == null || (paywall = state.getPaywall()) == null || (identifier = paywall.getIdentifier()) == null) {
            identifier = "";
        }
        PaywallMessageHandlerDelegate paywallMessageHandlerDelegate2 = this.messageHandler;
        if (paywallMessageHandlerDelegate2 != null) {
            paywallMessageHandlerDelegate2.eventDidOccur(new PaywallWebEvent.RequestCallback(requestCallback.getName(), requestCallback.getBehavior(), requestCallback.getRequestId(), requestCallback.getVariables()));
        }
        Function2<CustomCallback, Continuation<? super CustomCallbackResult>, Object> handler = this.customCallbackRegistry.getHandler(identifier);
        if (handler != null) {
            BuildersKt__Builders_commonKt.d(this.ioScope, null, null, new C28912(requestCallback, handler, this, null), 3, null);
            return;
        }
        Logger.debug$default(Logger.INSTANCE, LogLevel.warn, LogScope.superwallCore, "No custom callback handler registered for callback: " + requestCallback.getName(), (Map) null, (Throwable) null, 24, (Object) null);
        BuildersKt__Builders_commonKt.d(this.ioScope, null, null, new C28901(requestCallback, null), 3, null);
    }

    private final void handleRequestPermission(PaywallMessage.RequestPermission requestPermission) {
        String identifier;
        PaywallViewState state;
        Paywall paywall;
        Activity activity = (Activity) this.getActivity.invoke();
        PaywallMessageHandlerDelegate paywallMessageHandlerDelegate = this.messageHandler;
        if (paywallMessageHandlerDelegate == null || (state = paywallMessageHandlerDelegate.getState()) == null || (paywall = state.getPaywall()) == null || (identifier = paywall.getIdentifier()) == null) {
            identifier = "";
        }
        String str = identifier;
        String rawValue = requestPermission.getPermissionType().getRawValue();
        PaywallMessageHandlerDelegate paywallMessageHandlerDelegate2 = this.messageHandler;
        if (paywallMessageHandlerDelegate2 != null) {
            paywallMessageHandlerDelegate2.eventDidOccur(new PaywallWebEvent.RequestPermission(requestPermission.getPermissionType(), requestPermission.getRequestId()));
        }
        BuildersKt__Builders_commonKt.d(this.ioScope, null, null, new C28921(rawValue, str, null), 3, null);
        if (activity != null) {
            BuildersKt__Builders_commonKt.d(this.ioScope, null, null, new C28943(activity, requestPermission, rawValue, str, null), 3, null);
        } else {
            Logger.debug$default(Logger.INSTANCE, LogLevel.error, LogScope.superwallCore, "Cannot request permission - no activity available", (Map) null, (Throwable) null, 24, (Object) null);
            BuildersKt__Builders_commonKt.d(this.ioScope, null, null, new C28932(requestPermission, null), 3, null);
        }
    }

    private final void handleRequestReview(PaywallMessage.RequestReview requestReview) {
        hapticFeedback();
        PaywallMessageHandlerDelegate paywallMessageHandlerDelegate = this.messageHandler;
        if (paywallMessageHandlerDelegate != null) {
            paywallMessageHandlerDelegate.eventDidOccur(new PaywallWebEvent.RequestReview(WhenMappings.$EnumSwitchMapping$0[requestReview.getType().ordinal()] == 1 ? PaywallWebEvent.RequestReview.Type.EXTERNAL : PaywallWebEvent.RequestReview.Type.INAPP));
        }
    }

    private final void hapticFeedback() {
        SuperwallOptions superwallOptionsMakeSuperwallOptions = this.options.makeSuperwallOptions();
        boolean zIsHapticFeedbackEnabled = superwallOptionsMakeSuperwallOptions.getPaywalls().isHapticFeedbackEnabled();
        boolean zIsGameControllerEnabled = superwallOptionsMakeSuperwallOptions.isGameControllerEnabled();
        if (!zIsHapticFeedbackEnabled || zIsGameControllerEnabled) {
            return;
        }
        BuildersKt__Builders_commonKt.d(this.mainScope, null, null, new C28951(null), 3, null);
    }

    private final void launchTemplateSend(Function1<? super Continuation<? super Unit>, ? extends Object> function1) {
        synchronized (this.lifecycleLock) {
            launchTemplateSendLocked(function1);
            Unit unit = Unit.f139807a;
        }
    }

    private final void launchTemplateSendLocked(Function1<? super Continuation<? super Unit>, ? extends Object> function1) {
        final Job jobD = BuildersKt__Builders_commonKt.d(this.ioScope, null, CoroutineStart.f140917b, new PaywallMessageHandler$launchTemplateSendLocked$job$1(function1, null), 1, null);
        this.inFlightTemplateSends.add(jobD);
        jobD.invokeOnCompletion(new Function1() { // from class: com.superwall.sdk.paywall.view.webview.messaging.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PaywallMessageHandler.launchTemplateSendLocked$lambda$3(this.f93719a, jobD, (Throwable) obj);
            }
        });
        jobD.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit launchTemplateSendLocked$lambda$3(PaywallMessageHandler paywallMessageHandler, Job job, Throwable th) {
        synchronized (paywallMessageHandler.lifecycleLock) {
            paywallMessageHandler.inFlightTemplateSends.remove(job);
        }
        return Unit.f139807a;
    }

    private final void openDeepLink(String str) {
        detectHiddenPaywallEvent("openDeepLink", MapsKt.mapOf(TuplesKt.a("url", str)));
        hapticFeedback();
        PaywallMessageHandlerDelegate paywallMessageHandlerDelegate = this.messageHandler;
        if (paywallMessageHandlerDelegate != null) {
            paywallMessageHandlerDelegate.openDeepLink(str);
        }
    }

    private final void openUrl(URI uri, boolean z2) {
        detectHiddenPaywallEvent("openUrl", MapsKt.mapOf(TuplesKt.a("url", uri.toString())));
        hapticFeedback();
        PaywallMessageHandlerDelegate paywallMessageHandlerDelegate = this.messageHandler;
        if (paywallMessageHandlerDelegate != null) {
            paywallMessageHandlerDelegate.eventDidOccur(new PaywallWebEvent.OpenedURL(uri));
        }
        if (z2) {
            PaywallMessageHandlerDelegate paywallMessageHandlerDelegate2 = this.messageHandler;
            if (paywallMessageHandlerDelegate2 != null) {
                String string = uri.toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                paywallMessageHandlerDelegate2.presentPaymentSheet(string);
                return;
            }
            return;
        }
        PaywallMessageHandlerDelegate paywallMessageHandlerDelegate3 = this.messageHandler;
        if (paywallMessageHandlerDelegate3 != null) {
            String string2 = uri.toString();
            Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
            paywallMessageHandlerDelegate3.presentBrowserInApp(string2);
        }
    }

    private final void openUrlInBrowser(URI uri) {
        detectHiddenPaywallEvent("openUrlInSafari", MapsKt.mapOf(TuplesKt.a("url", uri)));
        hapticFeedback();
        PaywallMessageHandlerDelegate paywallMessageHandlerDelegate = this.messageHandler;
        if (paywallMessageHandlerDelegate != null) {
            paywallMessageHandlerDelegate.eventDidOccur(new PaywallWebEvent.OpenedUrlInChrome(uri));
        }
        PaywallMessageHandlerDelegate paywallMessageHandlerDelegate2 = this.messageHandler;
        if (paywallMessageHandlerDelegate2 != null) {
            String string = uri.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            paywallMessageHandlerDelegate2.presentBrowserExternal(string);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object pass(String str, Paywall paywall, Map<String, ? extends Object> map, Continuation<? super Unit> continuation) {
        String strB;
        List listListOf = CollectionsKt.listOf(MapsKt.plus(MapsKt.mapOf(TuplesKt.a("event_name", str), TuplesKt.a("paywall_id", paywall.getDatabaseId()), TuplesKt.a("paywall_identifier", paywall.getIdentifier())), map));
        try {
            Json json = this.json;
            JsonElement jsonElementConvertToJsonElement = ConvertersKt.convertToJsonElement(listListOf);
            json.a();
            strB = json.b(JsonElement.Companion.serializer(), jsonElementConvertToJsonElement);
        } catch (Throwable th) {
            th.printStackTrace();
            strB = "{\"event_name\":\"" + str + "\"}";
        }
        Object objPassMessageToWebView = passMessageToWebView((String) this.encodeToB64.invoke(strB), continuation);
        return objPassMessageToWebView == IntrinsicsKt.f() ? objPassMessageToWebView : Unit.f139807a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ Object pass$default(PaywallMessageHandler paywallMessageHandler, String str, Paywall paywall, Map map, Continuation continuation, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            map = MapsKt.emptyMap();
        }
        return paywallMessageHandler.pass(str, paywall, map, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object passMessageToWebView(String str, Continuation<? super Unit> continuation) {
        String str2 = "\n      window.paywall.accept64('" + str + "');\n    ";
        Logger logger = Logger.INSTANCE;
        LogLevel logLevel = LogLevel.debug;
        LogScope logScope = LogScope.paywallView;
        Loggable.Companion companion = Loggable.Companion;
        if (companion.willLog(logLevel, logScope)) {
            companion.emit(logLevel, logScope, "Posting Message", MapsKt.mapOf(TuplesKt.a("message", str2)), null);
        }
        return BuildersKt.g(Dispatchers.c(), new AnonymousClass4(str2, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x007f, code lost:
    
        if (r11.passMessageToWebView((java.lang.String) r12, r7) == r0) goto L33;
     */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object passTemplatesToWebView(com.superwall.sdk.models.paywall.Paywall r11, kotlin.coroutines.Continuation<? super kotlin.Unit> r12) throws java.lang.Throwable {
        /*
            r10 = this;
            boolean r0 = r12 instanceof com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler.C28961
            if (r0 == 0) goto L14
            r0 = r12
            com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler$passTemplatesToWebView$1 r0 = (com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler.C28961) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.label = r1
        L12:
            r7 = r0
            goto L1a
        L14:
            com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler$passTemplatesToWebView$1 r0 = new com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler$passTemplatesToWebView$1
            r0.<init>(r12)
            goto L12
        L1a:
            java.lang.Object r12 = r7.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r7.label
            r8 = 0
            r9 = 2
            r2 = 1
            if (r1 == 0) goto L3f
            if (r1 == r2) goto L37
            if (r1 != r9) goto L2f
            kotlin.ResultKt.b(r12)
            goto L82
        L2f:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L37:
            java.lang.Object r11 = r7.L$0
            com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler r11 = (com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler) r11
            kotlin.ResultKt.b(r12)
            goto L75
        L3f:
            kotlin.ResultKt.b(r12)
            com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandlerDelegate r12 = r10.messageHandler
            if (r12 == 0) goto L5e
            com.superwall.sdk.paywall.view.PaywallViewState r12 = r12.getState()
            if (r12 == 0) goto L5e
            com.superwall.sdk.paywall.presentation.internal.PresentationRequest r12 = r12.getRequest()
            if (r12 == 0) goto L5e
            com.superwall.sdk.paywall.presentation.internal.request.PresentationInfo r12 = r12.getPresentationInfo()
            if (r12 == 0) goto L5e
            com.superwall.sdk.models.events.EventData r12 = r12.getEventData()
            r4 = r12
            goto L5f
        L5e:
            r4 = r8
        L5f:
            TemplateLogic r1 = defpackage.TemplateLogic.f51a
            com.superwall.sdk.dependencies.VariablesFactory r5 = r10.factory
            r12 = r2
            kotlinx.serialization.json.Json r2 = r10.json
            kotlin.jvm.functions.Function1<java.lang.String, java.lang.String> r6 = r10.encodeToB64
            r7.L$0 = r10
            r7.label = r12
            r3 = r11
            java.lang.Object r12 = r1.a(r2, r3, r4, r5, r6, r7)
            if (r12 != r0) goto L74
            goto L81
        L74:
            r11 = r10
        L75:
            java.lang.String r12 = (java.lang.String) r12
            r7.L$0 = r8
            r7.label = r9
            java.lang.Object r11 = r11.passMessageToWebView(r12, r7)
            if (r11 != r0) goto L82
        L81:
            return r0
        L82:
            kotlin.Unit r11 = kotlin.Unit.f139807a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler.passTemplatesToWebView(com.superwall.sdk.models.paywall.Paywall, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void purchaseProduct(String str, boolean z2) {
        detectHiddenPaywallEvent$default(this, "purchase", null, 2, null);
        hapticFeedback();
        PaywallMessageHandlerDelegate paywallMessageHandlerDelegate = this.messageHandler;
        if (paywallMessageHandlerDelegate != null) {
            paywallMessageHandlerDelegate.eventDidOccur(new PaywallWebEvent.InitiatePurchase(str, z2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object replaceNullsWithEmpty(Object obj) {
        if (obj == null) {
            return "";
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(map.size()));
            for (Map.Entry entry : map.entrySet()) {
                linkedHashMap.put(entry.getKey(), replaceNullsWithEmpty(entry.getValue()));
            }
            return linkedHashMap;
        }
        if (!(obj instanceof List)) {
            return obj;
        }
        Iterable iterable = (Iterable) obj;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(replaceNullsWithEmpty(it.next()));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean resetForWebViewReload$lambda$7$lambda$6(PaywallMessageHandler paywallMessageHandler, Date date) {
        PaywallMessageHandlerDelegate paywallMessageHandlerDelegate = paywallMessageHandler.messageHandler;
        PaywallViewState state = paywallMessageHandlerDelegate != null ? paywallMessageHandlerDelegate.getState() : null;
        return state != null && state.isPresented() && !state.getClosedForBackground() && state.getLastOpen() == date;
    }

    private final void restorePurchases() {
        detectHiddenPaywallEvent$default(this, "restore", null, 2, null);
        hapticFeedback();
        PaywallMessageHandlerDelegate paywallMessageHandlerDelegate = this.messageHandler;
        if (paywallMessageHandlerDelegate != null) {
            paywallMessageHandlerDelegate.eventDidOccur(PaywallWebEvent.InitiateRestore.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object sendCallbackResult(String str, String str2, CustomCallbackResultStatus customCallbackResultStatus, Map<String, ? extends Object> map, Continuation<? super Unit> continuation) {
        Map mapMutableMapOf = MapsKt.mutableMapOf(TuplesKt.a("event_name", "callback_result"), TuplesKt.a("request_id", str), TuplesKt.a("name", str2), TuplesKt.a(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, customCallbackResultStatus.getRawValue()));
        if (map != null) {
            mapMutableMapOf.put("data", map);
        }
        List listListOf = CollectionsKt.listOf(mapMutableMapOf);
        try {
            Json json = this.json;
            JsonElement jsonElementConvertToJsonElement = ConvertersKt.convertToJsonElement(listListOf);
            json.a();
            String strB = json.b(JsonElement.Companion.serializer(), jsonElementConvertToJsonElement);
            Logger.debug$default(Logger.INSTANCE, LogLevel.debug, LogScope.superwallCore, "Sending callback_result: " + strB, (Map) null, (Throwable) null, 24, (Object) null);
            Object objPassMessageToWebView = passMessageToWebView((String) this.encodeToB64.invoke(strB), continuation);
            return objPassMessageToWebView == IntrinsicsKt.f() ? objPassMessageToWebView : Unit.f139807a;
        } catch (Throwable th) {
            Logger.debug$default(Logger.INSTANCE, LogLevel.error, LogScope.superwallCore, "Error encoding callback result: " + th.getMessage(), (Map) null, th, 8, (Object) null);
            return Unit.f139807a;
        }
    }

    private final void sendLifecycleWhenReady(PendingLifecycle pendingLifecycle) {
        PaywallViewState state;
        Paywall paywall;
        synchronized (this.lifecycleLock) {
            try {
                PaywallMessageHandlerDelegate paywallMessageHandlerDelegate = this.messageHandler;
                if (((paywallMessageHandlerDelegate == null || (state = paywallMessageHandlerDelegate.getState()) == null || (paywall = state.getPaywall()) == null) ? null : paywall.getPaywalljsVersion()) == null) {
                    this.queue.offer(pendingLifecycle);
                } else {
                    Unit unit = Unit.f139807a;
                    BuildersKt__Builders_commonKt.d(this.ioScope, null, null, new C28972(pendingLifecycle, null), 3, null);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object sendPermissionResult(String str, PermissionType permissionType, PermissionStatus permissionStatus, Continuation<? super Unit> continuation) {
        List listListOf = CollectionsKt.listOf(MapsKt.mapOf(TuplesKt.a("event_name", "permission_result"), TuplesKt.a("permission_type", permissionType.getRawValue()), TuplesKt.a("request_id", str), TuplesKt.a(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, permissionStatus.getRawValue())));
        try {
            Json json = this.json;
            JsonElement jsonElementConvertToJsonElement = ConvertersKt.convertToJsonElement(listListOf);
            json.a();
            String strB = json.b(JsonElement.Companion.serializer(), jsonElementConvertToJsonElement);
            Logger.debug$default(Logger.INSTANCE, LogLevel.debug, LogScope.superwallCore, "Sending permission_result: " + strB, (Map) null, (Throwable) null, 24, (Object) null);
            Object objPassMessageToWebView = passMessageToWebView((String) this.encodeToB64.invoke(strB), continuation);
            return objPassMessageToWebView == IntrinsicsKt.f() ? objPassMessageToWebView : Unit.f139807a;
        } catch (Throwable th) {
            Logger.debug$default(Logger.INSTANCE, LogLevel.error, LogScope.superwallCore, "Error encoding permission result: " + th.getMessage(), (Map) null, th, 8, (Object) null);
            return Unit.f139807a;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void triggerHapticFeedback(com.superwall.sdk.paywall.view.webview.messaging.PaywallMessage.HapticFeedback.HapticType r8) {
        /*
            r7 = this;
            com.superwall.sdk.dependencies.OptionsFactory r0 = r7.options     // Catch: java.lang.Throwable -> L2d
            com.superwall.sdk.config.options.SuperwallOptions r0 = r0.makeSuperwallOptions()     // Catch: java.lang.Throwable -> L2d
            com.superwall.sdk.config.options.PaywallOptions r1 = r0.getPaywalls()     // Catch: java.lang.Throwable -> L2d
            boolean r1 = r1.isHapticFeedbackEnabled()     // Catch: java.lang.Throwable -> L2d
            if (r1 == 0) goto L56
            boolean r0 = r0.isGameControllerEnabled()     // Catch: java.lang.Throwable -> L2d
            if (r0 == 0) goto L17
            goto L56
        L17:
            int[] r0 = com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler.WhenMappings.$EnumSwitchMapping$1     // Catch: java.lang.Throwable -> L2d
            int r8 = r8.ordinal()     // Catch: java.lang.Throwable -> L2d
            r8 = r0[r8]     // Catch: java.lang.Throwable -> L2d
            r0 = 1
            r1 = 30
            r2 = 4
            r3 = 0
            switch(r8) {
                case 1: goto L30;
                case 2: goto L41;
                case 3: goto L39;
                case 4: goto L3b;
                case 5: goto L39;
                case 6: goto L32;
                case 7: goto L30;
                default: goto L27;
            }     // Catch: java.lang.Throwable -> L2d
        L27:
            kotlin.NoWhenBranchMatchedException r8 = new kotlin.NoWhenBranchMatchedException     // Catch: java.lang.Throwable -> L2d
            r8.<init>()     // Catch: java.lang.Throwable -> L2d
            throw r8     // Catch: java.lang.Throwable -> L2d
        L2d:
            r0 = move-exception
            r8 = r0
            goto L57
        L30:
            r0 = r2
            goto L41
        L32:
            int r8 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L2d
            if (r8 < r1) goto L39
            r0 = 17
            goto L41
        L39:
            r0 = r3
            goto L41
        L3b:
            int r8 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L2d
            if (r8 < r1) goto L41
            r0 = 16
        L41:
            com.superwall.sdk.misc.MainScope r1 = r7.mainScope     // Catch: java.lang.Throwable -> L2d
            com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler$triggerHapticFeedback$1$1 r4 = new com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler$triggerHapticFeedback$1$1     // Catch: java.lang.Throwable -> L2d
            r8 = 0
            r4.<init>(r7, r0, r8)     // Catch: java.lang.Throwable -> L2d
            r5 = 3
            r6 = 0
            r2 = 0
            r3 = 0
            kotlinx.coroutines.Job r8 = kotlinx.coroutines.BuildersKt.d(r1, r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L2d
            com.superwall.sdk.misc.Either$Success r0 = new com.superwall.sdk.misc.Either$Success     // Catch: java.lang.Throwable -> L2d
            r0.<init>(r8)     // Catch: java.lang.Throwable -> L2d
        L56:
            return
        L57:
            boolean r0 = com.superwall.sdk.utilities.ErrorTrackingKt.shouldLog(r8)
            if (r0 == 0) goto L6c
            com.superwall.sdk.Superwall$Companion r0 = com.superwall.sdk.Superwall.Companion
            boolean r1 = r0.getInitialized()
            if (r1 == 0) goto L6c
            com.superwall.sdk.Superwall r0 = r0.getInstance()
            com.superwall.sdk.utilities.ErrorTrackingKt.trackError(r0, r8)
        L6c:
            com.superwall.sdk.misc.Either$Failure r0 = new com.superwall.sdk.misc.Either$Failure
            r0.<init>(r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler.triggerHapticFeedback(com.superwall.sdk.paywall.view.webview.messaging.PaywallMessage$HapticFeedback$HapticType):void");
    }

    public final void flushPendingMessages() {
        BuildersKt__Builders_commonKt.d(this.ioScope, null, null, new C28861(null), 3, null);
    }

    public final PaywallMessageHandlerDelegate getMessageHandler() {
        return this.messageHandler;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getState(kotlin.coroutines.Continuation<? super java.util.Map<java.lang.String, ? extends java.lang.Object>> r13) {
        /*
            r12 = this;
            boolean r0 = r13 instanceof com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler.C28871
            if (r0 == 0) goto L13
            r0 = r13
            com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler$getState$1 r0 = (com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler.C28871) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler$getState$1 r0 = new com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler$getState$1
            r0.<init>(r13)
        L18:
            java.lang.Object r13 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.b(r13)
            goto L60
        L29:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L31:
            kotlin.ResultKt.b(r13)
            com.superwall.sdk.logger.Logger r4 = com.superwall.sdk.logger.Logger.INSTANCE
            com.superwall.sdk.logger.LogLevel r5 = com.superwall.sdk.logger.LogLevel.debug
            com.superwall.sdk.logger.LogScope r6 = com.superwall.sdk.logger.LogScope.paywallView
            java.lang.String r13 = "message"
            java.lang.String r2 = "window.app.getAllState();"
            kotlin.Pair r13 = kotlin.TuplesKt.a(r13, r2)
            java.util.Map r8 = kotlin.collections.MapsKt.mapOf(r13)
            r10 = 16
            r11 = 0
            java.lang.String r7 = "Getting state"
            r9 = 0
            com.superwall.sdk.logger.Logger.debug$default(r4, r5, r6, r7, r8, r9, r10, r11)
            com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler$getState$2 r13 = new com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler$getState$2
            r4 = 0
            r13.<init>(r2, r4)
            r0.label = r3
            r2 = 1000(0x3e8, double:4.94E-321)
            java.lang.Object r13 = kotlinx.coroutines.TimeoutKt.e(r2, r13, r0)
            if (r13 != r1) goto L60
            return r1
        L60:
            java.util.Map r13 = (java.util.Map) r13
            if (r13 != 0) goto L68
            java.util.Map r13 = kotlin.collections.MapsKt.emptyMap()
        L68:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler.getState(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.superwall.sdk.paywall.view.webview.SendPaywallMessages
    public void handle(PaywallMessage message) {
        PaywallViewState state;
        Paywall paywall;
        PaywallViewState state2;
        PaywallInfo info;
        PaywallViewState state3;
        Intrinsics.checkNotNullParameter(message, "message");
        Logger logger = Logger.INSTANCE;
        LogLevel logLevel = LogLevel.debug;
        LogScope logScope = LogScope.superwallCore;
        Loggable.Companion companion = Loggable.Companion;
        Function0 function0 = null;
        Object[] objArr = 0;
        if (companion.willLog(logLevel, logScope)) {
            PaywallMessageHandlerDelegate paywallMessageHandlerDelegate = this.messageHandler;
            Paywall paywall2 = (paywallMessageHandlerDelegate == null || (state3 = paywallMessageHandlerDelegate.getState()) == null) ? null : state3.getPaywall();
            companion.emit(logLevel, logScope, "!! PaywallMessageHandler: Handling message: " + message + " " + paywall2 + ", delegeate: " + this.messageHandler, null, null);
        }
        PaywallMessageHandlerDelegate paywallMessageHandlerDelegate2 = this.messageHandler;
        if (paywallMessageHandlerDelegate2 == null || (state = paywallMessageHandlerDelegate2.getState()) == null || (paywall = state.getPaywall()) == null) {
            return;
        }
        if (companion.willLog(logLevel, logScope)) {
            companion.emit(logLevel, logScope, "!! PaywallMessageHandler: Paywall: " + paywall + ", delegeate: " + this.messageHandler, null, null);
        }
        if (message instanceof PaywallMessage.TemplateParamsAndUserAttributes) {
            launchTemplateSend(new AnonymousClass3(paywall, null));
            return;
        }
        if (message instanceof PaywallMessage.OnReady) {
            Date date = new Date();
            Logger.debug$default(Logger.INSTANCE, logLevel, logScope, "!! PaywallMessageHandler: Ready !!", (Map) null, (Throwable) null, 24, (Object) null);
            synchronized (this.lifecycleLock) {
                try {
                    PaywallMessageHandlerDelegate paywallMessageHandlerDelegate3 = this.messageHandler;
                    if (paywallMessageHandlerDelegate3 != null) {
                        paywallMessageHandlerDelegate3.updateState(new PaywallViewState.Updates.SetPaywallJsVersion(((PaywallMessage.OnReady) message).getPaywallJsVersion()));
                    }
                    launchTemplateSendLocked(new PaywallMessageHandler$handle$4$1(this, paywall, date, null));
                    Unit unit = Unit.f139807a;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return;
        }
        if (message instanceof PaywallMessage.Close) {
            hapticFeedback();
            PaywallMessageHandlerDelegate paywallMessageHandlerDelegate4 = this.messageHandler;
            if (paywallMessageHandlerDelegate4 != null) {
                paywallMessageHandlerDelegate4.eventDidOccur(PaywallWebEvent.Closed.INSTANCE);
                return;
            }
            return;
        }
        if (message instanceof PaywallMessage.OpenUrl) {
            PaywallMessage.OpenUrl openUrl = (PaywallMessage.OpenUrl) message;
            openUrl(openUrl.getUrl(), openUrl.getBrowserType() == PaywallMessage.OpenUrl.BrowserType.PAYMENT_SHEET);
            return;
        }
        if (message instanceof PaywallMessage.OpenUrlInBrowser) {
            openUrlInBrowser(((PaywallMessage.OpenUrlInBrowser) message).getUrl());
            return;
        }
        if (message instanceof PaywallMessage.OpenDeepLink) {
            String string = ((PaywallMessage.OpenDeepLink) message).getUrl().toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            openDeepLink(string);
            return;
        }
        if (message instanceof PaywallMessage.Restore) {
            restorePurchases();
            return;
        }
        if (message instanceof PaywallMessage.Purchase) {
            PaywallMessage.Purchase purchase = (PaywallMessage.Purchase) message;
            purchaseProduct(purchase.getProductId(), purchase.getShouldDismiss());
            return;
        }
        if ((message instanceof PaywallMessage.PaywallOpen) || (message instanceof PaywallMessage.PaywallClose)) {
            sendLifecycleWhenReady(new PendingLifecycle(message, function0, 2, objArr == true ? 1 : 0));
            return;
        }
        if (message instanceof PaywallMessage.BackButtonPressed) {
            BuildersKt__Builders_commonKt.d(this.ioScope, null, null, new AnonymousClass5(paywall, null), 3, null);
            return;
        }
        if (message instanceof PaywallMessage.Custom) {
            handleCustomEvent(((PaywallMessage.Custom) message).getData());
            return;
        }
        if (message instanceof PaywallMessage.CustomPlacement) {
            PaywallMessage.CustomPlacement customPlacement = (PaywallMessage.CustomPlacement) message;
            handleCustomPlacement(customPlacement.getName(), customPlacement.getParams());
            return;
        }
        if (message instanceof PaywallMessage.RestoreFailed) {
            BuildersKt__Builders_commonKt.d(this.ioScope, null, null, new C28896(paywall, null), 3, null);
            return;
        }
        if (message instanceof PaywallMessage.RequestReview) {
            handleRequestReview((PaywallMessage.RequestReview) message);
            return;
        }
        if (message instanceof PaywallMessage.TransactionStart) {
            BuildersKt__Builders_commonKt.d(this.ioScope, null, null, new AnonymousClass7(paywall, null), 3, null);
            return;
        }
        if (message instanceof PaywallMessage.TransactionAbandon) {
            BuildersKt__Builders_commonKt.d(this.ioScope, null, null, new AnonymousClass8(paywall, null), 3, null);
            return;
        }
        if (message instanceof PaywallMessage.UserAttributesUpdated) {
            this.setAttributes.invoke(((PaywallMessage.UserAttributesUpdated) message).getData());
            return;
        }
        if (message instanceof PaywallMessage.TransactionComplete) {
            BuildersKt__Builders_commonKt.d(this.ioScope, null, null, new AnonymousClass9(paywall, message, null), 3, null);
            return;
        }
        if (message instanceof PaywallMessage.TrialStarted) {
            BuildersKt__Builders_commonKt.d(this.ioScope, null, null, new AnonymousClass10(paywall, message, null), 3, null);
            return;
        }
        if (message instanceof PaywallMessage.ScheduleNotification) {
            PaywallMessageHandlerDelegate paywallMessageHandlerDelegate5 = this.messageHandler;
            if (paywallMessageHandlerDelegate5 != null) {
                PaywallMessage.ScheduleNotification scheduleNotification = (PaywallMessage.ScheduleNotification) message;
                paywallMessageHandlerDelegate5.eventDidOccur(new PaywallWebEvent.ScheduleNotification(new LocalNotification(scheduleNotification.getId(), scheduleNotification.getType(), scheduleNotification.getTitle(), scheduleNotification.getSubtitle(), scheduleNotification.getBody(), scheduleNotification.getDelay())));
                return;
            }
            return;
        }
        if (message instanceof PaywallMessage.RequestPermission) {
            handleRequestPermission((PaywallMessage.RequestPermission) message);
            return;
        }
        if (message instanceof PaywallMessage.RequestCallback) {
            handleRequestCallback((PaywallMessage.RequestCallback) message);
            return;
        }
        if (message instanceof PaywallMessage.HapticFeedback) {
            triggerHapticFeedback(((PaywallMessage.HapticFeedback) message).getHapticType());
            return;
        }
        if (message instanceof PaywallMessage.PageView) {
            PaywallMessageHandlerDelegate paywallMessageHandlerDelegate6 = this.messageHandler;
            if (paywallMessageHandlerDelegate6 == null || (state2 = paywallMessageHandlerDelegate6.getState()) == null || (info = state2.getInfo()) == null) {
                return;
            }
            BuildersKt__Builders_commonKt.d(this.ioScope, null, null, new AnonymousClass11(info, message, null), 3, null);
            return;
        }
        Logger.debug$default(Logger.INSTANCE, LogLevel.error, logScope, "!! PaywallMessageHandler: Unknown message type: " + message, (Map) null, (Throwable) null, 24, (Object) null);
    }

    public final Object passEventTrackingBehaviorToWebView(EventTrackingBehavior eventTrackingBehavior, Continuation<? super Unit> continuation) {
        List listListOf = CollectionsKt.listOf(MapsKt.mapOf(TuplesKt.a("event_name", "event_tracking_behavior"), TuplesKt.a("behavior", eventTrackingBehavior.getDescription())));
        try {
            Json json = this.json;
            JsonElement jsonElementConvertToJsonElement = ConvertersKt.convertToJsonElement(listListOf);
            json.a();
            Object objPassMessageToWebView = passMessageToWebView((String) this.encodeToB64.invoke(json.b(JsonElement.Companion.serializer(), jsonElementConvertToJsonElement)), continuation);
            return objPassMessageToWebView == IntrinsicsKt.f() ? objPassMessageToWebView : Unit.f139807a;
        } catch (Throwable th) {
            Logger.debug$default(Logger.INSTANCE, LogLevel.error, LogScope.superwallCore, "Error encoding event_tracking_behavior: " + th.getMessage(), (Map) null, th, 8, (Object) null);
            return Unit.f139807a;
        }
    }

    @JavascriptInterface
    public final void postMessage(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        Logger logger = Logger.INSTANCE;
        LogLevel logLevel = LogLevel.debug;
        LogScope logScope = LogScope.superwallCore;
        Loggable.Companion companion = Loggable.Companion;
        if (companion.willLog(logLevel, logScope)) {
            companion.emit(logLevel, logScope, "SWWebViewInterface: " + message, null, null);
        }
        Object wrappedPaywallMessages = PaywallMessageKt.parseWrappedPaywallMessages(message);
        Throwable thE = Result.e(wrappedPaywallMessages);
        if (thE != null) {
            thE.printStackTrace();
            Logger.debug$default(Logger.INSTANCE, logLevel, logScope, "SWWebViewInterface: Error parsing message - " + thE, (Map) null, (Throwable) null, 24, (Object) null);
            return;
        }
        for (PaywallMessage paywallMessage : ((WrappedPaywallMessages) wrappedPaywallMessages).getPayload().getMessages()) {
            Logger logger2 = Logger.INSTANCE;
            LogLevel logLevel2 = LogLevel.debug;
            LogScope logScope2 = LogScope.superwallCore;
            Loggable.Companion companion2 = Loggable.Companion;
            if (companion2.willLog(logLevel2, logScope2)) {
                companion2.emit(logLevel2, logScope2, "SWWebViewInterface: " + paywallMessage.getClass().getSimpleName(), null, null);
            }
            handle(paywallMessage);
        }
    }

    public final void resetForWebViewReload$superwall_release() {
        synchronized (this.lifecycleLock) {
            try {
                Iterator it = CollectionsKt.toList(this.inFlightTemplateSends).iterator();
                while (it.hasNext()) {
                    Job.DefaultImpls.b((Job) it.next(), null, 1, null);
                }
                this.inFlightTemplateSends.clear();
                this.queue.clear();
                PaywallMessageHandlerDelegate paywallMessageHandlerDelegate = this.messageHandler;
                PaywallViewState state = paywallMessageHandlerDelegate != null ? paywallMessageHandlerDelegate.getState() : null;
                PaywallMessageHandlerDelegate paywallMessageHandlerDelegate2 = this.messageHandler;
                if (paywallMessageHandlerDelegate2 != null) {
                    paywallMessageHandlerDelegate2.updateState(new PaywallViewState.Updates.SetPaywallJsVersion(null));
                }
                if (state != null && state.isPresented() && !state.getClosedForBackground()) {
                    final Date lastOpen = state.getLastOpen();
                    this.queue.offer(new PendingLifecycle(PaywallMessage.PaywallOpen.INSTANCE, new Function0() { // from class: com.superwall.sdk.paywall.view.webview.messaging.c
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Boolean.valueOf(PaywallMessageHandler.resetForWebViewReload$lambda$7$lambda$6(this.f93721a, lastOpen));
                        }
                    }));
                }
                Unit unit = Unit.f139807a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void setMessageHandler(PaywallMessageHandlerDelegate paywallMessageHandlerDelegate) {
        this.messageHandler = paywallMessageHandlerDelegate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class PendingLifecycle {
        private final PaywallMessage message;
        private final Function0<Boolean> shouldSend;

        public PendingLifecycle(PaywallMessage message, Function0<Boolean> shouldSend) {
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(shouldSend, "shouldSend");
            this.message = message;
            this.shouldSend = shouldSend;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean _init_$lambda$0() {
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ PendingLifecycle copy$default(PendingLifecycle pendingLifecycle, PaywallMessage paywallMessage, Function0 function0, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                paywallMessage = pendingLifecycle.message;
            }
            if ((i3 & 2) != 0) {
                function0 = pendingLifecycle.shouldSend;
            }
            return pendingLifecycle.copy(paywallMessage, function0);
        }

        public final PaywallMessage component1() {
            return this.message;
        }

        public final Function0<Boolean> component2() {
            return this.shouldSend;
        }

        public final PendingLifecycle copy(PaywallMessage message, Function0<Boolean> shouldSend) {
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(shouldSend, "shouldSend");
            return new PendingLifecycle(message, shouldSend);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PendingLifecycle)) {
                return false;
            }
            PendingLifecycle pendingLifecycle = (PendingLifecycle) obj;
            return Intrinsics.areEqual(this.message, pendingLifecycle.message) && Intrinsics.areEqual(this.shouldSend, pendingLifecycle.shouldSend);
        }

        public final PaywallMessage getMessage() {
            return this.message;
        }

        public final Function0<Boolean> getShouldSend() {
            return this.shouldSend;
        }

        public int hashCode() {
            return (this.message.hashCode() * 31) + this.shouldSend.hashCode();
        }

        public String toString() {
            return "PendingLifecycle(message=" + this.message + ", shouldSend=" + this.shouldSend + ")";
        }

        public /* synthetic */ PendingLifecycle(PaywallMessage paywallMessage, Function0 function0, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(paywallMessage, (i3 & 2) != 0 ? new Function0() { // from class: com.superwall.sdk.paywall.view.webview.messaging.d
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Boolean.valueOf(PaywallMessageHandler.PendingLifecycle._init_$lambda$0());
                }
            } : function0);
        }
    }

    public /* synthetic */ PaywallMessageHandler(VariablesFactory variablesFactory, OptionsFactory optionsFactory, Function2 function2, Function1 function1, Function0 function0, MainScope mainScope, CoroutineScope coroutineScope, Json json, Function1 function12, UserPermissions userPermissions, Function0 function02, CustomCallbackRegistry customCallbackRegistry, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(variablesFactory, optionsFactory, function2, function1, function0, mainScope, coroutineScope, (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? JsonKt.b(null, new Function1() { // from class: com.superwall.sdk.paywall.view.webview.messaging.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PaywallMessageHandler._init_$lambda$0((JsonBuilder) obj);
            }
        }, 1, null) : json, function12, userPermissions, function02, customCallbackRegistry);
    }
}
