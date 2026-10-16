package com.superwall.sdk.storage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.superwall.sdk.analytics.internal.trackable.InternalSuperwallEvent;
import com.superwall.sdk.analytics.internal.trackable.Trackable;
import com.superwall.sdk.analytics.internal.trackable.UserInitiatedEvent;
import com.superwall.sdk.config.ConfigManager;
import com.superwall.sdk.config.options.EventTrackingBehavior;
import com.superwall.sdk.config.options.SuperwallOptions;
import com.superwall.sdk.misc.IOScope;
import com.superwall.sdk.misc.MainScope;
import com.superwall.sdk.models.events.EventData;
import com.superwall.sdk.models.events.EventsRequest;
import com.superwall.sdk.network.Network;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

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
public final class EventsQueue extends BroadcastReceiver implements CoroutineScope {
    private final ConfigManager configManager;
    private final Context context;
    private final CoroutineContext coroutineContext;
    private List<EventData> elements;
    private final IOScope ioScope;
    private Job job;
    private final MainScope mainScope;
    private final int maxEventCount;
    private final Network network;
    private final MutableSharedFlow<Long> timer;
    private EventTrackingBehavior trackingBehavior;

    /* JADX INFO: renamed from: com.superwall.sdk.storage.EventsQueue$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.storage.EventsQueue$1", f = "EventsQueue.kt", l = {42}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return EventsQueue.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                EventsQueue eventsQueue = EventsQueue.this;
                this.label = 1;
                if (eventsQueue.setupTimer(this) == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            EventsQueue.this.addObserver();
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[EventTrackingBehavior.values().length];
            try {
                iArr[EventTrackingBehavior.ALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EventTrackingBehavior.SUPERWALL_ONLY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EventTrackingBehavior.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.storage.EventsQueue$enqueue$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.storage.EventsQueue$enqueue$1", f = "EventsQueue.kt", l = {}, m = "invokeSuspend")
    static final class C29001 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ EventData $data;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C29001(EventData eventData, Continuation<? super C29001> continuation) {
            super(2, continuation);
            this.$data = eventData;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return EventsQueue.this.new C29001(this.$data, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            EventsQueue.this.elements.add(this.$data);
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C29001) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.storage.EventsQueue$flushInternal$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.storage.EventsQueue$flushInternal$2", f = "EventsQueue.kt", l = {124}, m = "invokeSuspend")
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $depth;
        int label;

        /* JADX INFO: renamed from: com.superwall.sdk.storage.EventsQueue$flushInternal$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "com.superwall.sdk.storage.EventsQueue$flushInternal$2$1", f = "EventsQueue.kt", l = {120}, m = "invokeSuspend")
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ EventsRequest $events;
            int label;
            final /* synthetic */ EventsQueue this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(EventsQueue eventsQueue, EventsRequest eventsRequest, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = eventsQueue;
                this.$events = eventsRequest;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, this.$events, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objF = IntrinsicsKt.f();
                int i3 = this.label;
                if (i3 == 0) {
                    ResultKt.b(obj);
                    Network network = this.this$0.network;
                    EventsRequest eventsRequest = this.$events;
                    this.label = 1;
                    if (network.sendEvents(eventsRequest, this) == objF) {
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

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(int i3, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$depth = i3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return EventsQueue.this.new AnonymousClass2(this.$depth, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            int i3;
            Object objF = IntrinsicsKt.f();
            int i4 = this.label;
            if (i4 == 0) {
                ResultKt.b(obj);
                if (EventsQueue.this.trackingBehavior == EventTrackingBehavior.NONE) {
                    EventsQueue.this.elements.clear();
                    return Unit.f139807a;
                }
                ArrayList arrayList = new ArrayList();
                for (int i5 = 0; i5 < EventsQueue.this.maxEventCount && !EventsQueue.this.elements.isEmpty(); i5++) {
                    arrayList.add(EventsQueue.this.elements.remove(0));
                }
                if (!arrayList.isEmpty()) {
                    BuildersKt__Builders_commonKt.d(EventsQueue.this.ioScope, null, null, new AnonymousClass1(EventsQueue.this, new EventsRequest(arrayList), null), 3, null);
                }
                if (!EventsQueue.this.elements.isEmpty() && (i3 = this.$depth) > 0) {
                    this.label = 1;
                    if (EventsQueue.this.flushInternal(i3 - 1, this) == objF) {
                        return objF;
                    }
                }
            } else {
                if (i4 != 1) {
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

    /* JADX INFO: renamed from: com.superwall.sdk.storage.EventsQueue$onReceive$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.storage.EventsQueue$onReceive$1", f = "EventsQueue.kt", l = {138}, m = "invokeSuspend")
    static final class C29011 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C29011(Continuation<? super C29011> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return EventsQueue.this.new C29011(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                EventsQueue eventsQueue = EventsQueue.this;
                this.label = 1;
                if (EventsQueue.flushInternal$default(eventsQueue, 0, this, 1, null) == objF) {
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
            return ((C29011) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.storage.EventsQueue$setTrackingBehavior$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.storage.EventsQueue$setTrackingBehavior$1", f = "EventsQueue.kt", l = {}, m = "invokeSuspend")
    static final class C29021 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ EventTrackingBehavior $behavior;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C29021(EventTrackingBehavior eventTrackingBehavior, Continuation<? super C29021> continuation) {
            super(2, continuation);
            this.$behavior = eventTrackingBehavior;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return EventsQueue.this.new C29021(this.$behavior, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            EventsQueue.this.trackingBehavior = this.$behavior;
            if (this.$behavior != EventTrackingBehavior.ALL) {
                EventsQueue.this.elements.clear();
            }
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C29021) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.storage.EventsQueue$setupTimer$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.storage.EventsQueue", f = "EventsQueue.kt", l = {57}, m = "setupTimer")
    static final class C29031 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C29031(Continuation<? super C29031> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return EventsQueue.this.setupTimer(this);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.storage.EventsQueue$setupTimer$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.storage.EventsQueue$setupTimer$2", f = "EventsQueue.kt", l = {53, 54}, m = "invokeSuspend")
    static final class C29042 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $timeInterval;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ EventsQueue this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C29042(long j3, EventsQueue eventsQueue, Continuation<? super C29042> continuation) {
            super(2, continuation);
            this.$timeInterval = j3;
            this.this$0 = eventsQueue;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C29042 c29042 = new C29042(this.$timeInterval, this.this$0, continuation);
            c29042.L$0 = obj;
            return c29042;
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x005c, code lost:
        
            if (r9.emit(r4, r8) != r0) goto L7;
         */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0034  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x005f  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x005c -> B:7:0x0015). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) throws java.lang.Throwable {
            /*
                r8 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r1 = r8.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L27
                if (r1 == r3) goto L1f
                if (r1 != r2) goto L17
                java.lang.Object r1 = r8.L$0
                kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
                kotlin.ResultKt.b(r9)
            L15:
                r9 = r1
                goto L2e
            L17:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r0)
                throw r9
            L1f:
                java.lang.Object r1 = r8.L$0
                kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
                kotlin.ResultKt.b(r9)
                goto L46
            L27:
                kotlin.ResultKt.b(r9)
                java.lang.Object r9 = r8.L$0
                kotlinx.coroutines.CoroutineScope r9 = (kotlinx.coroutines.CoroutineScope) r9
            L2e:
                boolean r1 = kotlinx.coroutines.CoroutineScopeKt.h(r9)
                if (r1 == 0) goto L5f
                long r4 = r8.$timeInterval
                r1 = 1000(0x3e8, float:1.401E-42)
                long r6 = (long) r1
                long r4 = r4 * r6
                r8.L$0 = r9
                r8.label = r3
                java.lang.Object r1 = kotlinx.coroutines.DelayKt.b(r4, r8)
                if (r1 != r0) goto L45
                goto L5e
            L45:
                r1 = r9
            L46:
                com.superwall.sdk.storage.EventsQueue r9 = r8.this$0
                kotlinx.coroutines.flow.MutableSharedFlow r9 = com.superwall.sdk.storage.EventsQueue.access$getTimer$p(r9)
                long r4 = java.lang.System.currentTimeMillis()
                java.lang.Long r4 = kotlin.coroutines.jvm.internal.Boxing.e(r4)
                r8.L$0 = r1
                r8.label = r2
                java.lang.Object r9 = r9.emit(r4, r8)
                if (r9 != r0) goto L15
            L5e:
                return r0
            L5f:
                kotlin.Unit r9 = kotlin.Unit.f139807a
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.storage.EventsQueue.C29042.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C29042) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    public EventsQueue(Context context, Network network, IOScope ioScope, MainScope mainScope, ConfigManager configManager) {
        EventTrackingBehavior eventTrackingBehavior;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(network, "network");
        Intrinsics.checkNotNullParameter(ioScope, "ioScope");
        Intrinsics.checkNotNullParameter(mainScope, "mainScope");
        Intrinsics.checkNotNullParameter(configManager, "configManager");
        this.context = context;
        this.network = network;
        this.ioScope = ioScope;
        this.mainScope = mainScope;
        this.configManager = configManager;
        this.maxEventCount = 50;
        this.elements = new ArrayList();
        this.timer = SharedFlowKt.b(0, 0, null, 7, null);
        SuperwallOptions options = configManager.getOptions();
        this.trackingBehavior = (options == null || (eventTrackingBehavior = options.getEventTrackingBehavior()) == null) ? EventTrackingBehavior.ALL : eventTrackingBehavior;
        this.coroutineContext = CoroutineDispatcher.q0(Dispatchers.b(), 1, null, 2, null);
        BuildersKt__Builders_commonKt.d(mainScope, null, null, new AnonymousClass1(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addObserver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        this.context.registerReceiver(this, intentFilter);
    }

    public static /* synthetic */ Object flushInternal$default(EventsQueue eventsQueue, int i3, Continuation continuation, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i3 = 10;
        }
        return eventsQueue.flushInternal(i3, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object setupTimer(kotlin.coroutines.Continuation<? super kotlin.Unit> r13) throws java.lang.Throwable {
        /*
            r12 = this;
            boolean r0 = r13 instanceof com.superwall.sdk.storage.EventsQueue.C29031
            if (r0 == 0) goto L13
            r0 = r13
            com.superwall.sdk.storage.EventsQueue$setupTimer$1 r0 = (com.superwall.sdk.storage.EventsQueue.C29031) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.superwall.sdk.storage.EventsQueue$setupTimer$1 r0 = new com.superwall.sdk.storage.EventsQueue$setupTimer$1
            r0.<init>(r13)
        L18:
            java.lang.Object r13 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 == r3) goto L2d
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L2d:
            kotlin.ResultKt.b(r13)
            goto L6d
        L31:
            kotlin.ResultKt.b(r13)
            com.superwall.sdk.config.ConfigManager r13 = r12.configManager
            com.superwall.sdk.config.options.SuperwallOptions r13 = r13.getOptions()
            r2 = 0
            if (r13 == 0) goto L42
            com.superwall.sdk.config.options.SuperwallOptions$NetworkEnvironment r13 = r13.getNetworkEnvironment()
            goto L43
        L42:
            r13 = r2
        L43:
            boolean r13 = r13 instanceof com.superwall.sdk.config.options.SuperwallOptions.NetworkEnvironment.Release
            if (r13 == 0) goto L4a
            r4 = 20
            goto L4c
        L4a:
            r4 = 1
        L4c:
            com.superwall.sdk.misc.IOScope r6 = r12.ioScope
            com.superwall.sdk.storage.EventsQueue$setupTimer$2 r9 = new com.superwall.sdk.storage.EventsQueue$setupTimer$2
            r9.<init>(r4, r12, r2)
            r10 = 3
            r11 = 0
            r7 = 0
            r8 = 0
            kotlinx.coroutines.Job r13 = kotlinx.coroutines.BuildersKt.d(r6, r7, r8, r9, r10, r11)
            r12.job = r13
            kotlinx.coroutines.flow.MutableSharedFlow<java.lang.Long> r13 = r12.timer
            com.superwall.sdk.storage.EventsQueue$setupTimer$3 r2 = new com.superwall.sdk.storage.EventsQueue$setupTimer$3
            r2.<init>()
            r0.label = r3
            java.lang.Object r13 = r13.collect(r2, r0)
            if (r13 != r1) goto L6d
            return r1
        L6d:
            kotlin.KotlinNothingValueException r13 = new kotlin.KotlinNothingValueException
            r13.<init>()
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.storage.EventsQueue.setupTimer(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final boolean trackingAllowed(Trackable trackable) {
        int i3 = WhenMappings.$EnumSwitchMapping$0[this.trackingBehavior.ordinal()];
        if (i3 == 1) {
            return true;
        }
        if (i3 == 2) {
            return ((trackable instanceof InternalSuperwallEvent.TriggerFire) || (trackable instanceof InternalSuperwallEvent.Attributes) || (trackable instanceof UserInitiatedEvent.Track)) ? false : true;
        }
        if (i3 == 3) {
            return false;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final void enqueue(EventData data, Trackable event) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(event, "event");
        if (trackingAllowed(event)) {
            BuildersKt__Builders_commonKt.d(this, null, null, new C29001(data, null), 3, null);
        }
    }

    public final Object flushInternal(int i3, Continuation<? super Unit> continuation) {
        BuildersKt__Builders_commonKt.d(this, null, null, new AnonymousClass2(i3, null), 3, null);
        return Unit.f139807a;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent != null ? intent.getAction() : null;
        if (action != null && action.hashCode() == -2128145023 && action.equals("android.intent.action.SCREEN_OFF")) {
            BuildersKt__Builders_commonKt.d(this.ioScope, null, null, new C29011(null), 3, null);
        }
    }

    public final void setTrackingBehavior(EventTrackingBehavior behavior) {
        Intrinsics.checkNotNullParameter(behavior, "behavior");
        BuildersKt__Builders_commonKt.d(this, null, null, new C29021(behavior, null), 3, null);
    }
}
