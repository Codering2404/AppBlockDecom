package com.superwall.sdk.analytics.session;

import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import com.google.firebase.sessions.api.ITd.wgbAZXYjrv;
import com.superwall.sdk.Superwall;
import com.superwall.sdk.analytics.internal.TrackingKt;
import com.superwall.sdk.analytics.internal.trackable.InternalSuperwallEvent;
import com.superwall.sdk.config.ConfigManager;
import com.superwall.sdk.config.models.ConfigState;
import com.superwall.sdk.dependencies.DeviceHelperFactory;
import com.superwall.sdk.dependencies.UserAttributesEventFactory;
import com.superwall.sdk.misc.Either;
import com.superwall.sdk.misc.IOScope;
import com.superwall.sdk.models.config.Config;
import com.superwall.sdk.storage.LocalStorage;
import com.superwall.sdk.utilities.ErrorTrackingKt;
import java.util.Date;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;

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
public final class AppSessionManager implements DefaultLifecycleObserver {
    private AppSession appSession;
    private Long appSessionTimeout;
    private final IOScope backgroundScope;
    private final ConfigManager configManager;
    private final Factory delegate;
    private boolean didTrackAppLaunch;
    private Date lastAppClose;
    private final LocalStorage storage;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface Factory extends AppManagerDelegate, DeviceHelperFactory, UserAttributesEventFactory {
    }

    /* JADX INFO: renamed from: com.superwall.sdk.analytics.session.AppSessionManager$listenForAppSessionTimeout$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.analytics.session.AppSessionManager$listenForAppSessionTimeout$1", f = "AppSessionManager.kt", l = {80}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AppSessionManager.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                final StateFlow<ConfigState> configState$superwall_release = AppSessionManager.this.configManager.getConfigState$superwall_release();
                Flow<Config> flow = new Flow<Config>() { // from class: com.superwall.sdk.analytics.session.AppSessionManager$listenForAppSessionTimeout$1$invokeSuspend$$inlined$mapNotNull$1

                    /* JADX INFO: renamed from: com.superwall.sdk.analytics.session.AppSessionManager$listenForAppSessionTimeout$1$invokeSuspend$$inlined$mapNotNull$1$2, reason: invalid class name */
                    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                    @Metadata
                    public static final class AnonymousClass2<T> implements FlowCollector {
                        final /* synthetic */ FlowCollector $this_unsafeFlow;

                        /* JADX INFO: renamed from: com.superwall.sdk.analytics.session.AppSessionManager$listenForAppSessionTimeout$1$invokeSuspend$$inlined$mapNotNull$1$2$1, reason: invalid class name */
                        @Metadata
                        @DebugMetadata(c = "com.superwall.sdk.analytics.session.AppSessionManager$listenForAppSessionTimeout$1$invokeSuspend$$inlined$mapNotNull$1$2", f = "AppSessionManager.kt", l = {52}, m = "emit")
                        public static final class AnonymousClass1 extends ContinuationImpl {
                            Object L$0;
                            int label;
                            /* synthetic */ Object result;

                            public AnonymousClass1(Continuation continuation) {
                                super(continuation);
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Object invokeSuspend(Object obj) {
                                this.result = obj;
                                this.label |= Integer.MIN_VALUE;
                                return AnonymousClass2.this.emit(null, this);
                            }
                        }

                        public AnonymousClass2(FlowCollector flowCollector) {
                            this.$this_unsafeFlow = flowCollector;
                        }

                        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct code enable 'Show inconsistent code' option in preferences
                        */
                        public final java.lang.Object emit(java.lang.Object r5, kotlin.coroutines.Continuation r6) throws java.lang.Throwable {
                            /*
                                r4 = this;
                                boolean r0 = r6 instanceof com.superwall.sdk.analytics.session.AppSessionManager$listenForAppSessionTimeout$1$invokeSuspend$$inlined$mapNotNull$1.AnonymousClass2.AnonymousClass1
                                if (r0 == 0) goto L13
                                r0 = r6
                                com.superwall.sdk.analytics.session.AppSessionManager$listenForAppSessionTimeout$1$invokeSuspend$$inlined$mapNotNull$1$2$1 r0 = (com.superwall.sdk.analytics.session.AppSessionManager$listenForAppSessionTimeout$1$invokeSuspend$$inlined$mapNotNull$1.AnonymousClass2.AnonymousClass1) r0
                                int r1 = r0.label
                                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                                r3 = r1 & r2
                                if (r3 == 0) goto L13
                                int r1 = r1 - r2
                                r0.label = r1
                                goto L18
                            L13:
                                com.superwall.sdk.analytics.session.AppSessionManager$listenForAppSessionTimeout$1$invokeSuspend$$inlined$mapNotNull$1$2$1 r0 = new com.superwall.sdk.analytics.session.AppSessionManager$listenForAppSessionTimeout$1$invokeSuspend$$inlined$mapNotNull$1$2$1
                                r0.<init>(r6)
                            L18:
                                java.lang.Object r6 = r0.result
                                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                                int r2 = r0.label
                                r3 = 1
                                if (r2 == 0) goto L31
                                if (r2 != r3) goto L29
                                kotlin.ResultKt.b(r6)
                                goto L47
                            L29:
                                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                                r5.<init>(r6)
                                throw r5
                            L31:
                                kotlin.ResultKt.b(r6)
                                kotlinx.coroutines.flow.FlowCollector r6 = r4.$this_unsafeFlow
                                com.superwall.sdk.config.models.ConfigState r5 = (com.superwall.sdk.config.models.ConfigState) r5
                                com.superwall.sdk.models.config.Config r5 = com.superwall.sdk.config.models.ConfigStateKt.getConfig(r5)
                                if (r5 == 0) goto L47
                                r0.label = r3
                                java.lang.Object r5 = r6.emit(r5, r0)
                                if (r5 != r1) goto L47
                                return r1
                            L47:
                                kotlin.Unit r5 = kotlin.Unit.f139807a
                                return r5
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.analytics.session.AppSessionManager$listenForAppSessionTimeout$1$invokeSuspend$$inlined$mapNotNull$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                        }
                    }

                    @Override // kotlinx.coroutines.flow.Flow
                    public Object collect(FlowCollector flowCollector, Continuation continuation) {
                        Object objCollect = configState$superwall_release.collect(new AnonymousClass2(flowCollector), continuation);
                        return objCollect == IntrinsicsKt.f() ? objCollect : Unit.f139807a;
                    }
                };
                final AppSessionManager appSessionManager = AppSessionManager.this;
                FlowCollector flowCollector = new FlowCollector() { // from class: com.superwall.sdk.analytics.session.AppSessionManager.listenForAppSessionTimeout.1.2
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((Config) obj2, (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(Config config, Continuation<? super Unit> continuation) {
                        appSessionManager.setAppSessionTimeout(Boxing.e(config.getAppSessionTimeout()));
                        if (!appSessionManager.didTrackAppLaunch) {
                            appSessionManager.sessionCouldRefresh();
                        }
                        return Unit.f139807a;
                    }
                };
                this.label = 1;
                if (flow.collect(flowCollector, this) == objF) {
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

    /* JADX INFO: renamed from: com.superwall.sdk.analytics.session.AppSessionManager$onStart$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.analytics.session.AppSessionManager$onStart$1", f = "AppSessionManager.kt", l = {57}, m = "invokeSuspend")
    static final class C27771 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C27771(Continuation<? super C27771> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C27771(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                Superwall companion = Superwall.Companion.getInstance();
                InternalSuperwallEvent.AppOpen appOpen = new InternalSuperwallEvent.AppOpen(null, 1, null);
                this.label = 1;
                if (TrackingKt.track(companion, appOpen, this) == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                ((Result) obj).j();
            }
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C27771) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.analytics.session.AppSessionManager$onStop$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.analytics.session.AppSessionManager$onStop$1", f = "AppSessionManager.kt", l = {66}, m = "invokeSuspend")
    static final class C27781 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C27781(Continuation<? super C27781> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C27781(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                Superwall companion = Superwall.Companion.getInstance();
                InternalSuperwallEvent.AppClose appClose = new InternalSuperwallEvent.AppClose(null, 1, null);
                this.label = 1;
                if (TrackingKt.track(companion, appClose, this) == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                ((Result) obj).j();
            }
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C27781) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.analytics.session.AppSessionManager$trackAppLaunch$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.analytics.session.AppSessionManager$trackAppLaunch$1", f = "AppSessionManager.kt", l = {146}, m = "invokeSuspend")
    static final class C27791 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C27791(Continuation<? super C27791> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C27791(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                Superwall companion = Superwall.Companion.getInstance();
                InternalSuperwallEvent.AppLaunch appLaunch = new InternalSuperwallEvent.AppLaunch(null, 1, null);
                this.label = 1;
                if (TrackingKt.track(companion, appLaunch, this) == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                ((Result) obj).j();
            }
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C27791) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    public AppSessionManager(ConfigManager configManager, LocalStorage storage, Factory delegate, IOScope backgroundScope) {
        Intrinsics.checkNotNullParameter(configManager, "configManager");
        Intrinsics.checkNotNullParameter(storage, "storage");
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        Intrinsics.checkNotNullParameter(backgroundScope, "backgroundScope");
        this.configManager = configManager;
        this.storage = storage;
        this.delegate = delegate;
        this.backgroundScope = backgroundScope;
        this.appSession = new AppSession((String) null, (Date) null, (Date) null, 7, (DefaultConstructorMarker) null);
        listenForAppSessionTimeout();
    }

    private final void detectNewSession() {
        Object objD;
        try {
            if (AppSessionLogic.INSTANCE.didStartNewSession(this.lastAppClose, this.appSessionTimeout)) {
                setAppSession(new AppSession((String) null, (Date) null, (Date) null, 7, (DefaultConstructorMarker) null));
                BuildersKt__Builders_commonKt.d(this.backgroundScope, null, null, new AppSessionManager$detectNewSession$1$1(this, null), 3, null);
                objD = BuildersKt__Builders_commonKt.d(this.backgroundScope, null, null, new AppSessionManager$detectNewSession$1$2(this, null), 3, null);
            } else {
                this.appSession.setEndAt(null);
                objD = Unit.f139807a;
            }
            new Either.Success(objD);
        } catch (Throwable th) {
            if (ErrorTrackingKt.shouldLog(th)) {
                Superwall.Companion companion = Superwall.Companion;
                if (companion.getInitialized()) {
                    ErrorTrackingKt.trackError(companion.getInstance(), th);
                }
            }
            new Either.Failure(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sessionCouldRefresh() {
        try {
            detectNewSession();
            trackAppLaunch();
            new Either.Success(BuildersKt__Builders_commonKt.d(this.backgroundScope, null, null, new AppSessionManager$sessionCouldRefresh$1$1(this, null), 3, null));
        } catch (Throwable th) {
            if (ErrorTrackingKt.shouldLog(th)) {
                Superwall.Companion companion = Superwall.Companion;
                if (companion.getInitialized()) {
                    ErrorTrackingKt.trackError(companion.getInstance(), th);
                }
            }
            new Either.Failure(th);
        }
    }

    private final void trackAppLaunch() {
        if (this.didTrackAppLaunch) {
            return;
        }
        BuildersKt__Builders_commonKt.d(this.backgroundScope, null, null, new C27791(null), 3, null);
        this.didTrackAppLaunch = true;
    }

    private final void willTerminate() {
        this.appSession.setEndAt(new Date());
    }

    public final AppSession getAppSession() {
        return this.appSession;
    }

    public final Long getAppSessionTimeout() {
        return this.appSessionTimeout;
    }

    public final void listenForAppSessionTimeout() {
        BuildersKt__Builders_commonKt.d(this.backgroundScope, null, null, new AnonymousClass1(null), 3, null);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* bridge */ /* synthetic */ void onCreate(LifecycleOwner lifecycleOwner) {
        super.onCreate(lifecycleOwner);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* bridge */ /* synthetic */ void onDestroy(LifecycleOwner lifecycleOwner) {
        super.onDestroy(lifecycleOwner);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* bridge */ /* synthetic */ void onPause(LifecycleOwner lifecycleOwner) {
        super.onPause(lifecycleOwner);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* bridge */ /* synthetic */ void onResume(LifecycleOwner lifecycleOwner) {
        super.onResume(lifecycleOwner);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onStart(LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        super.onStart(owner);
        BuildersKt__Builders_commonKt.d(this.backgroundScope, null, null, new C27771(null), 3, null);
        sessionCouldRefresh();
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onStop(LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        super.onStop(owner);
        BuildersKt__Builders_commonKt.d(this.backgroundScope, null, null, new C27781(null), 3, null);
        this.lastAppClose = new Date();
        this.appSession.setEndAt(new Date());
    }

    public final void setAppSessionTimeout(Long l3) {
        this.appSessionTimeout = l3;
    }

    public final void setAppSession(AppSession appSession) {
        Intrinsics.checkNotNullParameter(appSession, wgbAZXYjrv.toWuufKcapB);
        this.appSession = appSession;
        BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.c()), null, null, new AppSessionManager$appSession$1(this, appSession, null), 3, null);
    }
}
