package com.superwall.sdk.deeplinks;

import android.net.Uri;
import com.superwall.sdk.Superwall;
import com.superwall.sdk.analytics.internal.trackable.TrackableSuperwallEvent;
import com.superwall.sdk.config.models.ConfigurationStatus;
import com.superwall.sdk.debug.DebugManager;
import com.superwall.sdk.logger.LogLevel;
import com.superwall.sdk.logger.LogScope;
import com.superwall.sdk.logger.Logger;
import com.superwall.sdk.misc.Either;
import com.superwall.sdk.misc.IOScope;
import com.superwall.sdk.utilities.ErrorTrackingKt;
import com.superwall.sdk.web.WebPaywallRedeemer;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedDeque;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

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
public final class DeepLinkRouter {
    public static final Companion Companion = new Companion(null);
    private static ConcurrentLinkedDeque<Uri> unhandledDeepLinks = new ConcurrentLinkedDeque<>();
    private final DebugManager debugManager;
    private final IOScope ioScope;
    private final WebPaywallRedeemer redeemer;
    private final Function2<TrackableSuperwallEvent, Continuation<? super Unit>, Object> track;

    /* JADX INFO: renamed from: com.superwall.sdk.deeplinks.DeepLinkRouter$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.deeplinks.DeepLinkRouter$1", f = "DeepLinkRouter.kt", l = {61, 62}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        /* JADX INFO: renamed from: com.superwall.sdk.deeplinks.DeepLinkRouter$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "com.superwall.sdk.deeplinks.DeepLinkRouter$1$1", f = "DeepLinkRouter.kt", l = {}, m = "invokeSuspend")
        static final class C02381 extends SuspendLambda implements Function2<Boolean, Continuation<? super Boolean>, Object> {
            /* synthetic */ boolean Z$0;
            int label;

            C02381(Continuation<? super C02381> continuation) {
                super(2, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C02381 c02381 = new C02381(continuation);
                c02381.Z$0 = ((Boolean) obj).booleanValue();
                return c02381;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return invoke(((Boolean) obj).booleanValue(), (Continuation<? super Boolean>) obj2);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                IntrinsicsKt.f();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                return Boxing.a(this.Z$0);
            }

            public final Object invoke(boolean z2, Continuation<? super Boolean> continuation) {
                return ((C02381) create(Boolean.valueOf(z2), continuation)).invokeSuspend(Unit.f139807a);
            }
        }

        /* JADX INFO: renamed from: com.superwall.sdk.deeplinks.DeepLinkRouter$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "com.superwall.sdk.deeplinks.DeepLinkRouter$1$2", f = "DeepLinkRouter.kt", l = {}, m = "invokeSuspend")
        static final class AnonymousClass2 extends SuspendLambda implements Function2<ConfigurationStatus, Continuation<? super Boolean>, Object> {
            /* synthetic */ Object L$0;
            int label;

            AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(continuation);
                anonymousClass2.L$0 = obj;
                return anonymousClass2;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(ConfigurationStatus configurationStatus, Continuation<? super Boolean> continuation) {
                return ((AnonymousClass2) create(configurationStatus, continuation)).invokeSuspend(Unit.f139807a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                IntrinsicsKt.f();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                return Boxing.a(((ConfigurationStatus) this.L$0) instanceof ConfigurationStatus.Configured);
            }
        }

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return DeepLinkRouter.this.new AnonymousClass1(continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x004b, code lost:
        
            if (kotlinx.coroutines.flow.FlowKt.E(r6, r1, r5) == r0) goto L15;
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
                r2 = 0
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L1f
                if (r1 == r4) goto L1b
                if (r1 != r3) goto L13
                kotlin.ResultKt.b(r6)
                goto L4e
            L13:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L1b:
                kotlin.ResultKt.b(r6)
                goto L36
            L1f:
                kotlin.ResultKt.b(r6)
                com.superwall.sdk.Superwall$Companion r6 = com.superwall.sdk.Superwall.Companion
                kotlinx.coroutines.flow.Flow r6 = r6.getHasInitialized()
                com.superwall.sdk.deeplinks.DeepLinkRouter$1$1 r1 = new com.superwall.sdk.deeplinks.DeepLinkRouter$1$1
                r1.<init>(r2)
                r5.label = r4
                java.lang.Object r6 = kotlinx.coroutines.flow.FlowKt.E(r6, r1, r5)
                if (r6 != r0) goto L36
                goto L4d
            L36:
                com.superwall.sdk.Superwall$Companion r6 = com.superwall.sdk.Superwall.Companion
                com.superwall.sdk.Superwall r6 = r6.getInstance()
                kotlinx.coroutines.flow.Flow r6 = r6.getConfigurationStateListener()
                com.superwall.sdk.deeplinks.DeepLinkRouter$1$2 r1 = new com.superwall.sdk.deeplinks.DeepLinkRouter$1$2
                r1.<init>(r2)
                r5.label = r3
                java.lang.Object r6 = kotlinx.coroutines.flow.FlowKt.E(r6, r1, r5)
                if (r6 != r0) goto L4e
            L4d:
                return r0
            L4e:
                java.util.concurrent.ConcurrentLinkedDeque r6 = com.superwall.sdk.deeplinks.DeepLinkRouter.access$getUnhandledDeepLinks$cp()
                boolean r6 = r6.isEmpty()
                if (r6 != 0) goto L72
                java.util.concurrent.ConcurrentLinkedDeque r6 = com.superwall.sdk.deeplinks.DeepLinkRouter.access$getUnhandledDeepLinks$cp()
                java.lang.Object r6 = r6.pop()
                android.net.Uri r6 = (android.net.Uri) r6
                com.superwall.sdk.deeplinks.DeepLinkRouter r0 = com.superwall.sdk.deeplinks.DeepLinkRouter.this
                kotlin.jvm.internal.Intrinsics.checkNotNull(r6)
                r0.m1268handleDeepLinkIoAF18A(r6)
                java.util.concurrent.ConcurrentLinkedDeque r0 = com.superwall.sdk.deeplinks.DeepLinkRouter.access$getUnhandledDeepLinks$cp()
                r0.remove(r6)
                goto L4e
            L72:
                kotlin.Unit r6 = kotlin.Unit.f139807a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.deeplinks.DeepLinkRouter.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: renamed from: handleDeepLink-IoAF18A, reason: not valid java name */
        public final Object m1269handleDeepLinkIoAF18A(Uri uri) {
            Intrinsics.checkNotNullParameter(uri, "uri");
            Superwall.Companion companion = Superwall.Companion;
            if (companion.getInitialized() && (companion.getInstance().getConfigurationState() instanceof ConfigurationStatus.Configured)) {
                Result.a(companion.getInstance().getDependencyContainer$superwall_release().getDeepLinkRouter$superwall_release().m1268handleDeepLinkIoAF18A(uri));
            } else {
                DeepLinkRouter.unhandledDeepLinks.add(uri);
            }
            Logger logger = Logger.INSTANCE;
            LogLevel logLevel = LogLevel.info;
            LogScope logScope = LogScope.deepLinks;
            Logger.debug$default(logger, logLevel, logScope, "Superwall handling provided deep link", (Map) null, (Throwable) null, 24, (Object) null);
            if (Result.h(DeepLinkRouterKt.getRedeemableCode(uri)) || Result.h(DebugManager.Companion.m1267outcomeForDeepLinkIoAF18A(uri))) {
                return Result.b(Boolean.TRUE);
            }
            Logger.debug$default(logger, logLevel, logScope, "Superwall not handling the provided deep link", (Map) null, (Throwable) null, 24, (Object) null);
            return Result.b(ResultKt.a(new IllegalArgumentException("Not a superwall link")));
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DeepLinkRouter(WebPaywallRedeemer redeemer, IOScope ioScope, DebugManager debugManager, Function2<? super TrackableSuperwallEvent, ? super Continuation<? super Unit>, ? extends Object> track) {
        Intrinsics.checkNotNullParameter(redeemer, "redeemer");
        Intrinsics.checkNotNullParameter(ioScope, "ioScope");
        Intrinsics.checkNotNullParameter(debugManager, "debugManager");
        Intrinsics.checkNotNullParameter(track, "track");
        this.redeemer = redeemer;
        this.ioScope = ioScope;
        this.debugManager = debugManager;
        this.track = track;
        BuildersKt__Builders_commonKt.d(ioScope, null, null, new AnonymousClass1(null), 3, null);
    }

    public final DebugManager getDebugManager() {
        return this.debugManager;
    }

    public final IOScope getIoScope() {
        return this.ioScope;
    }

    public final WebPaywallRedeemer getRedeemer() {
        return this.redeemer;
    }

    public final Function2<TrackableSuperwallEvent, Continuation<? super Unit>, Object> getTrack() {
        return this.track;
    }

    /* JADX INFO: renamed from: handleDeepLink-IoAF18A, reason: not valid java name */
    public final Object m1268handleDeepLinkIoAF18A(Uri uri) {
        Either failure;
        Intrinsics.checkNotNullParameter(uri, "uri");
        try {
            BuildersKt__Builders_commonKt.d(this.ioScope, null, null, new DeepLinkRouter$handleDeepLink$1$1(this, uri, null), 3, null);
            Object objMo1346handleDeepLinkIoAF18A = this.redeemer.getDeepLinkReferrer$superwall_release().mo1346handleDeepLinkIoAF18A(uri);
            if (Result.h(objMo1346handleDeepLinkIoAF18A)) {
                BuildersKt__Builders_commonKt.d(this.ioScope, null, null, new DeepLinkRouter$handleDeepLink$1$handledAsRedemption$1$1(this, (String) objMo1346handleDeepLinkIoAF18A, null), 3, null);
            }
            failure = new Either.Success(Boolean.valueOf(Result.h(objMo1346handleDeepLinkIoAF18A) ? true : this.debugManager.handle(uri)));
        } catch (Throwable th) {
            if (ErrorTrackingKt.shouldLog(th)) {
                Superwall.Companion companion = Superwall.Companion;
                if (companion.getInitialized()) {
                    ErrorTrackingKt.trackError(companion.getInstance(), th);
                }
            }
            failure = new Either.Failure(th);
        }
        if (failure instanceof Either.Success) {
            Result.Companion companion2 = Result.f139772b;
            return Result.b(((Either.Success) failure).getValue());
        }
        if (!(failure instanceof Either.Failure)) {
            throw new NoWhenBranchMatchedException();
        }
        Result.Companion companion3 = Result.f139772b;
        return Result.b(ResultKt.a(((Either.Failure) failure).getError()));
    }

    public /* synthetic */ DeepLinkRouter(WebPaywallRedeemer webPaywallRedeemer, IOScope iOScope, DebugManager debugManager, Function2 function2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(webPaywallRedeemer, (i3 & 2) != 0 ? new IOScope(null, 1, null) : iOScope, debugManager, function2);
    }
}
