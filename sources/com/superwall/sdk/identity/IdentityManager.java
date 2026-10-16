package com.superwall.sdk.identity;

import com.superwall.sdk.SdkContext;
import com.superwall.sdk.Superwall;
import com.superwall.sdk.analytics.internal.TrackingKt;
import com.superwall.sdk.analytics.internal.trackable.TrackableSuperwallEvent;
import com.superwall.sdk.config.options.SuperwallOptions;
import com.superwall.sdk.identity.IdentityContext;
import com.superwall.sdk.identity.IdentityState;
import com.superwall.sdk.misc.IOScope;
import com.superwall.sdk.misc.primitives.Reducer;
import com.superwall.sdk.misc.primitives.StateActor;
import com.superwall.sdk.misc.primitives.TypedAction;
import com.superwall.sdk.storage.Storable;
import com.superwall.sdk.storage.Storage;
import com.superwall.sdk.web.WebPaywallRedeemer;
import java.util.Map;
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
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
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
public final class IdentityManager implements IdentityContext {
    private final StateActor<IdentityContext, IdentityState> actor;
    private final Function0<Unit> completeReset;
    private final IOScope ioScope;
    private final Function1<Map<String, ? extends Object>, Unit> notifyUserChange;
    private final Function0<SuperwallOptions> options;
    private final SdkContext sdkContext;
    private final Storage storage;
    private final Function1<String, String> stringToSha;
    private final Function2<TrackableSuperwallEvent, Continuation<? super Unit>, Object> tracker;
    private final Function0<WebPaywallRedeemer> webPaywallRedeemer;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: renamed from: com.superwall.sdk.identity.IdentityManager$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.identity.IdentityManager$3", f = "IdentityManager.kt", l = {35}, m = "invokeSuspend")
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<TrackableSuperwallEvent, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;

        AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(continuation);
            anonymousClass3.L$0 = obj;
            return anonymousClass3;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(TrackableSuperwallEvent trackableSuperwallEvent, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(trackableSuperwallEvent, continuation)).invokeSuspend(Unit.f139807a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                TrackableSuperwallEvent trackableSuperwallEvent = (TrackableSuperwallEvent) this.L$0;
                Superwall companion = Superwall.Companion.getInstance();
                this.label = 1;
                if (TrackingKt.track(companion, trackableSuperwallEvent, this) == objF) {
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
    }

    /* JADX INFO: renamed from: com.superwall.sdk.identity.IdentityManager$awaitLatestIdentity$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.identity.IdentityManager$awaitLatestIdentity$2", f = "IdentityManager.kt", l = {}, m = "invokeSuspend")
    static final class AnonymousClass2 extends SuspendLambda implements Function2<IdentityState, Continuation<? super Boolean>, Object> {
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
        public final Object invoke(IdentityState identityState, Continuation<? super Boolean> continuation) {
            return ((AnonymousClass2) create(identityState, continuation)).invokeSuspend(Unit.f139807a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return Boxing.a(!((IdentityState) this.L$0).getHasPendingIdentityResolution());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public IdentityManager(Storage storage, IOScope ioScope, Function1<? super String, String> stringToSha, Function1<? super Map<String, ? extends Object>, Unit> notifyUserChange, Function0<Unit> completeReset, Function2<? super TrackableSuperwallEvent, ? super Continuation<? super Unit>, ? extends Object> tracker, Function0<SuperwallOptions> options, Function0<WebPaywallRedeemer> webPaywallRedeemer, StateActor<IdentityContext, IdentityState> actor, SdkContext sdkContext) {
        Intrinsics.checkNotNullParameter(storage, "storage");
        Intrinsics.checkNotNullParameter(ioScope, "ioScope");
        Intrinsics.checkNotNullParameter(stringToSha, "stringToSha");
        Intrinsics.checkNotNullParameter(notifyUserChange, "notifyUserChange");
        Intrinsics.checkNotNullParameter(completeReset, "completeReset");
        Intrinsics.checkNotNullParameter(tracker, "tracker");
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(webPaywallRedeemer, "webPaywallRedeemer");
        Intrinsics.checkNotNullParameter(actor, "actor");
        Intrinsics.checkNotNullParameter(sdkContext, "sdkContext");
        this.storage = storage;
        this.ioScope = ioScope;
        this.stringToSha = stringToSha;
        this.notifyUserChange = notifyUserChange;
        this.completeReset = completeReset;
        this.tracker = tracker;
        this.options = options;
        this.webPaywallRedeemer = webPaywallRedeemer;
        this.actor = actor;
        this.sdkContext = sdkContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String _init_$lambda$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$1() {
        Superwall.Companion.getInstance().reset$superwall_release(true);
        return Unit.f139807a;
    }

    private final IdentityState getIdentity() {
        return (IdentityState) getActor().getState().getValue();
    }

    public static /* synthetic */ void identify$default(IdentityManager identityManager, String str, IdentityOptions identityOptions, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            identityOptions = null;
        }
        identityManager.identify(str, identityOptions);
    }

    public static /* synthetic */ void mergeAndNotify$superwall_release$default(IdentityManager identityManager, Map map, boolean z2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z2 = true;
        }
        identityManager.mergeAndNotify$superwall_release(map, z2);
    }

    public static /* synthetic */ void mergeUserAttributes$default(IdentityManager identityManager, Map map, boolean z2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z2 = true;
        }
        identityManager.mergeUserAttributes(map, z2);
    }

    public final Object awaitLatestIdentity(Continuation<? super IdentityState> continuation) {
        return FlowKt.E(getActor().getState(), new AnonymousClass2(null), continuation);
    }

    public final void configure(boolean z2) {
        effect(new IdentityState.Actions.Configure(z2));
    }

    @Override // com.superwall.sdk.misc.primitives.BaseContext
    public void delete(Storable<?> storable) {
        IdentityContext.DefaultImpls.delete(this, storable);
    }

    @Override // com.superwall.sdk.misc.primitives.StoreContext
    public void effect(TypedAction<IdentityContext> typedAction) {
        IdentityContext.DefaultImpls.effect(this, typedAction);
    }

    @Override // com.superwall.sdk.misc.primitives.StoreContext
    public StateActor<IdentityContext, IdentityState> getActor() {
        return this.actor;
    }

    public final String getAliasId() {
        return getIdentity().getAliasId();
    }

    public final String getAppUserId() {
        return getIdentity().getAppUserId();
    }

    @Override // com.superwall.sdk.identity.IdentityContext
    public Function0<Unit> getCompleteReset() {
        return this.completeReset;
    }

    public final String getExternalAccountId() {
        return ((SuperwallOptions) this.options.invoke()).getPassIdentifiersToPlayStore() ? getUserId() : (String) this.stringToSha.invoke(getUserId());
    }

    public final Flow<Boolean> getHasIdentity() {
        final StateFlow<IdentityState> state = getActor().getState();
        final Flow<Boolean> flow = new Flow<Boolean>() { // from class: com.superwall.sdk.identity.IdentityManager$special$$inlined$map$1

            /* JADX INFO: renamed from: com.superwall.sdk.identity.IdentityManager$special$$inlined$map$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.superwall.sdk.identity.IdentityManager$special$$inlined$map$1$2$1, reason: invalid class name */
                @Metadata
                @DebugMetadata(c = "com.superwall.sdk.identity.IdentityManager$special$$inlined$map$1$2", f = "IdentityManager.kt", l = {50}, m = "emit")
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
                        boolean r0 = r6 instanceof com.superwall.sdk.identity.IdentityManager$special$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        com.superwall.sdk.identity.IdentityManager$special$$inlined$map$1$2$1 r0 = (com.superwall.sdk.identity.IdentityManager$special$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.superwall.sdk.identity.IdentityManager$special$$inlined$map$1$2$1 r0 = new com.superwall.sdk.identity.IdentityManager$special$$inlined$map$1$2$1
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        kotlin.ResultKt.b(r6)
                        goto L49
                    L29:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L31:
                        kotlin.ResultKt.b(r6)
                        kotlinx.coroutines.flow.FlowCollector r6 = r4.$this_unsafeFlow
                        com.superwall.sdk.identity.IdentityState r5 = (com.superwall.sdk.identity.IdentityState) r5
                        boolean r5 = r5.isReady()
                        java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.a(r5)
                        r0.label = r3
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L49
                        return r1
                    L49:
                        kotlin.Unit r5 = kotlin.Unit.f139807a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.identity.IdentityManager$special$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector, Continuation continuation) {
                Object objCollect = state.collect(new AnonymousClass2(flowCollector), continuation);
                return objCollect == IntrinsicsKt.f() ? objCollect : Unit.f139807a;
            }
        };
        return new Flow<Boolean>() { // from class: com.superwall.sdk.identity.IdentityManager$special$$inlined$filter$1

            /* JADX INFO: renamed from: com.superwall.sdk.identity.IdentityManager$special$$inlined$filter$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.superwall.sdk.identity.IdentityManager$special$$inlined$filter$1$2$1, reason: invalid class name */
                @Metadata
                @DebugMetadata(c = "com.superwall.sdk.identity.IdentityManager$special$$inlined$filter$1$2", f = "IdentityManager.kt", l = {50}, m = "emit")
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    Object L$1;
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
                        boolean r0 = r6 instanceof com.superwall.sdk.identity.IdentityManager$special$$inlined$filter$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        com.superwall.sdk.identity.IdentityManager$special$$inlined$filter$1$2$1 r0 = (com.superwall.sdk.identity.IdentityManager$special$$inlined$filter$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.superwall.sdk.identity.IdentityManager$special$$inlined$filter$1$2$1 r0 = new com.superwall.sdk.identity.IdentityManager$special$$inlined$filter$1$2$1
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        kotlin.ResultKt.b(r6)
                        goto L48
                    L29:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L31:
                        kotlin.ResultKt.b(r6)
                        kotlinx.coroutines.flow.FlowCollector r6 = r4.$this_unsafeFlow
                        r2 = r5
                        java.lang.Boolean r2 = (java.lang.Boolean) r2
                        boolean r2 = r2.booleanValue()
                        if (r2 == 0) goto L48
                        r0.label = r3
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L48
                        return r1
                    L48:
                        kotlin.Unit r5 = kotlin.Unit.f139807a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.identity.IdentityManager$special$$inlined$filter$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector, Continuation continuation) {
                Object objCollect = flow.collect(new AnonymousClass2(flowCollector), continuation);
                return objCollect == IntrinsicsKt.f() ? objCollect : Unit.f139807a;
            }
        };
    }

    @Override // com.superwall.sdk.identity.IdentityContext
    public Function1<Map<String, ? extends Object>, Unit> getNotifyUserChange() {
        return this.notifyUserChange;
    }

    @Override // com.superwall.sdk.misc.primitives.StoreContext
    public CoroutineScope getScope() {
        return this.ioScope;
    }

    @Override // com.superwall.sdk.identity.IdentityContext
    public SdkContext getSdkContext() {
        return this.sdkContext;
    }

    public final int getSeed() {
        return getIdentity().getSeed();
    }

    @Override // com.superwall.sdk.misc.primitives.StoreContext, com.superwall.sdk.misc.primitives.StateStore
    public StateFlow<IdentityState> getState() {
        return IdentityContext.DefaultImpls.getState(this);
    }

    @Override // com.superwall.sdk.misc.primitives.BaseContext
    public Storage getStorage() {
        return this.storage;
    }

    @Override // com.superwall.sdk.misc.primitives.BaseContext
    public Function2<TrackableSuperwallEvent, Continuation<? super Unit>, Object> getTracker() {
        return this.tracker;
    }

    public final Map<String, Object> getUserAttributes() {
        return getIdentity().getEnrichedAttributes();
    }

    public final String getUserId() {
        return getIdentity().getUserId();
    }

    @Override // com.superwall.sdk.identity.IdentityContext
    public Function0<WebPaywallRedeemer> getWebPaywallRedeemer() {
        return this.webPaywallRedeemer;
    }

    public final void identify(String userId, IdentityOptions identityOptions) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        effect(new IdentityState.Actions.Identify(userId, identityOptions));
    }

    @Override // com.superwall.sdk.misc.primitives.StoreContext
    public Object immediate(TypedAction<IdentityContext> typedAction, Continuation<? super Unit> continuation) {
        return IdentityContext.DefaultImpls.immediate(this, typedAction, continuation);
    }

    @Override // com.superwall.sdk.misc.primitives.StoreContext
    public Object immediateUntil(TypedAction<IdentityContext> typedAction, Function1<? super IdentityState, Boolean> function1, Continuation<? super Unit> continuation) {
        return IdentityContext.DefaultImpls.immediateUntil(this, typedAction, function1, continuation);
    }

    public final boolean isLoggedIn() {
        return getIdentity().isLoggedIn();
    }

    public final void mergeAndNotify$superwall_release(Map<String, ? extends Object> newUserAttributes, boolean z2) {
        Intrinsics.checkNotNullParameter(newUserAttributes, "newUserAttributes");
        effect(new IdentityState.Actions.MergeAttributes(newUserAttributes, z2, true));
    }

    public final void mergeUserAttributes(Map<String, ? extends Object> newUserAttributes, boolean z2) {
        Intrinsics.checkNotNullParameter(newUserAttributes, "newUserAttributes");
        effect(new IdentityState.Actions.MergeAttributes(newUserAttributes, z2, false));
    }

    @Override // com.superwall.sdk.misc.primitives.BaseContext
    public <T> void persist(Storable<T> storable, T t2) {
        IdentityContext.DefaultImpls.persist(this, storable, t2);
    }

    @Override // com.superwall.sdk.misc.primitives.BaseContext
    /* JADX INFO: renamed from: read-IoAF18A */
    public <T> Object mo1262readIoAF18A(Storable<T> storable) {
        return IdentityContext.DefaultImpls.m1273readIoAF18A(this, storable);
    }

    public final void reset() {
        effect(IdentityState.Actions.FullReset.INSTANCE);
    }

    @Override // com.superwall.sdk.misc.primitives.StoreContext
    public void sideEffect(Function1<? super Continuation<? super Unit>, ? extends Object> function1) {
        IdentityContext.DefaultImpls.sideEffect(this, function1);
    }

    @Override // com.superwall.sdk.misc.primitives.BaseContext
    public void track(TrackableSuperwallEvent trackableSuperwallEvent) {
        IdentityContext.DefaultImpls.track(this, trackableSuperwallEvent);
    }

    @Override // com.superwall.sdk.misc.primitives.StoreContext, com.superwall.sdk.misc.primitives.StateStore
    public void update(Reducer<IdentityState> reducer) {
        IdentityContext.DefaultImpls.update(this, reducer);
    }

    public /* synthetic */ IdentityManager(Storage storage, IOScope iOScope, Function1 function1, Function1 function12, Function0 function0, Function2 function2, Function0 function02, Function0 function03, StateActor stateActor, SdkContext sdkContext, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(storage, iOScope, (i3 & 4) != 0 ? new Function1() { // from class: com.superwall.sdk.identity.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return IdentityManager._init_$lambda$0((String) obj);
            }
        } : function1, function12, (i3 & 16) != 0 ? new Function0() { // from class: com.superwall.sdk.identity.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return IdentityManager._init_$lambda$1();
            }
        } : function0, (i3 & 32) != 0 ? new AnonymousClass3(null) : function2, function02, function03, stateActor, sdkContext);
    }
}
