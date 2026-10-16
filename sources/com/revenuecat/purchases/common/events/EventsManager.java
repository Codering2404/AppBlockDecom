package com.revenuecat.purchases.common.events;

import com.google.common.cache.LSNn.vfptEEmYY;
import com.revenuecat.purchases.DebugEvent;
import com.revenuecat.purchases.DebugEventListener;
import com.revenuecat.purchases.DebugEventName;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.ads.events.AdEvent;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.Delay;
import com.revenuecat.purchases.common.Dispatcher;
import com.revenuecat.purchases.common.FileHelper;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.events.BackendStoredEvent;
import com.revenuecat.purchases.customercenter.events.CustomerCenterImpressionEvent;
import com.revenuecat.purchases.customercenter.events.CustomerCenterSurveyOptionChosenEvent;
import com.revenuecat.purchases.identity.IdentityManager;
import com.revenuecat.purchases.paywalls.events.CustomPaywallEvent;
import com.revenuecat.purchases.paywalls.events.PaywallEvent;
import com.revenuecat.purchases.paywalls.events.PaywallStoredEvent;
import com.revenuecat.purchases.utils.EventsFileHelper;
import com.revenuecat.purchases.utils.RateLimiter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;
import kotlinx.serialization.modules.PolymorphicModuleBuilder;
import kotlinx.serialization.modules.SerializersModuleBuilder;

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
/* JADX INFO: loaded from: classes5.dex */
@Metadata
public final class EventsManager {
    public static final String AD_EVENTS_FILE_PATH = "RevenueCat/event_store/ad_event_store.jsonl";
    public static final Companion Companion = new Companion(null);
    public static final String EVENTS_FILE_PATH_NEW = "RevenueCat/event_store/event_store.jsonl";
    public static final int EVENTS_TO_CLEAR_ON_LIMIT = 50;
    public static final double FILE_SIZE_LIMIT_KB = 2048.0d;
    private static final int FLUSH_COUNT = 50;
    private static final int MAX_FLUSH_BATCHES = 10;
    private static final String PAYWALL_EVENTS_FILE_PATH = "RevenueCat/paywall_event_store/paywall_event_store.jsonl";
    private static final UUID appSessionID;
    private static final Json json;
    private final UUID appSessionID$1;
    private DebugEventListener debugEventListener;
    private final Dispatcher eventsDispatcher;
    private final EventsFileHelper<BackendStoredEvent> fileHelper;
    private AtomicBoolean flushInProgress;
    private final IdentityManager identityManager;
    private final EventsFileHelper<PaywallStoredEvent> legacyEventsFileHelper;
    private boolean legacyFlushTriggered;
    private boolean pendingPriorityFlush;
    private final Function4<EventsRequest, Delay, Function0<Unit>, Function2<? super PurchasesError, ? super Boolean, Unit>, Unit> postEvents;
    private final RateLimiter priorityFlushRateLimiter;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final EventsFileHelper<BackendStoredEvent> adEvents(FileHelper fileHelper) {
            Intrinsics.checkNotNullParameter(fileHelper, "fileHelper");
            return new EventsFileHelper<>(fileHelper, EventsManager.AD_EVENTS_FILE_PATH, new Function1<BackendStoredEvent, String>() { // from class: com.revenuecat.purchases.common.events.EventsManager$Companion$adEvents$1
                @Override // kotlin.jvm.functions.Function1
                public final String invoke(BackendStoredEvent event) {
                    Intrinsics.checkNotNullParameter(event, "event");
                    return EventsManager.json.b(BackendStoredEvent.Companion.serializer(), event);
                }
            }, new Function1<String, BackendStoredEvent>() { // from class: com.revenuecat.purchases.common.events.EventsManager$Companion$adEvents$2
                @Override // kotlin.jvm.functions.Function1
                public final BackendStoredEvent invoke(String jsonString) {
                    Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                    return (BackendStoredEvent) EventsManager.json.d(BackendStoredEvent.Companion.serializer(), jsonString);
                }
            });
        }

        public final EventsFileHelper<BackendStoredEvent> backendEvents(FileHelper fileHelper) {
            Intrinsics.checkNotNullParameter(fileHelper, "fileHelper");
            return new EventsFileHelper<>(fileHelper, EventsManager.EVENTS_FILE_PATH_NEW, new Function1<BackendStoredEvent, String>() { // from class: com.revenuecat.purchases.common.events.EventsManager$Companion$backendEvents$1
                @Override // kotlin.jvm.functions.Function1
                public final String invoke(BackendStoredEvent event) {
                    Intrinsics.checkNotNullParameter(event, "event");
                    return EventsManager.json.b(BackendStoredEvent.Companion.serializer(), event);
                }
            }, new Function1<String, BackendStoredEvent>() { // from class: com.revenuecat.purchases.common.events.EventsManager$Companion$backendEvents$2
                @Override // kotlin.jvm.functions.Function1
                public final BackendStoredEvent invoke(String jsonString) {
                    Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                    return (BackendStoredEvent) EventsManager.json.d(BackendStoredEvent.Companion.serializer(), jsonString);
                }
            });
        }

        public final UUID getAppSessionID$purchases_defaultsBc8Release() {
            return EventsManager.appSessionID;
        }

        public final EventsFileHelper<PaywallStoredEvent> paywalls(FileHelper fileHelper) {
            Intrinsics.checkNotNullParameter(fileHelper, "fileHelper");
            return new EventsFileHelper<>(fileHelper, EventsManager.PAYWALL_EVENTS_FILE_PATH, EventsManager$Companion$paywalls$1.INSTANCE, new EventsManager$Companion$paywalls$2(PaywallStoredEvent.Companion));
        }

        private Companion() {
        }

        public static /* synthetic */ void getEVENTS_TO_CLEAR_ON_LIMIT$annotations() {
        }

        public static /* synthetic */ void getFILE_SIZE_LIMIT_KB$annotations() {
        }

        private static /* synthetic */ void getJson$annotations() {
        }
    }

    static {
        UUID uuidRandomUUID = UUID.randomUUID();
        Intrinsics.checkNotNullExpressionValue(uuidRandomUUID, "randomUUID()");
        appSessionID = uuidRandomUUID;
        json = JsonKt.b(null, new Function1<JsonBuilder, Unit>() { // from class: com.revenuecat.purchases.common.events.EventsManager$Companion$json$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((JsonBuilder) obj);
                return Unit.f139807a;
            }

            public final void invoke(JsonBuilder Json) {
                Intrinsics.checkNotNullParameter(Json, "$this$Json");
                SerializersModuleBuilder serializersModuleBuilder = new SerializersModuleBuilder();
                PolymorphicModuleBuilder polymorphicModuleBuilder = new PolymorphicModuleBuilder(Reflection.b(BackendStoredEvent.class), null);
                polymorphicModuleBuilder.b(Reflection.b(BackendStoredEvent.CustomerCenter.class), BackendStoredEvent.CustomerCenter.Companion.serializer());
                polymorphicModuleBuilder.b(Reflection.b(BackendStoredEvent.Paywalls.class), BackendStoredEvent.Paywalls.Companion.serializer());
                polymorphicModuleBuilder.b(Reflection.b(BackendStoredEvent.Ad.class), BackendStoredEvent.Ad.Companion.serializer());
                polymorphicModuleBuilder.b(Reflection.b(BackendStoredEvent.CustomPaywall.class), BackendStoredEvent.CustomPaywall.Companion.serializer());
                polymorphicModuleBuilder.a(serializersModuleBuilder);
                Json.k(serializersModuleBuilder.f());
                Json.g(false);
            }
        }, 1, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public EventsManager(UUID appSessionID2, EventsFileHelper<PaywallStoredEvent> eventsFileHelper, EventsFileHelper<BackendStoredEvent> fileHelper, IdentityManager identityManager, Dispatcher eventsDispatcher, Function4<? super EventsRequest, ? super Delay, ? super Function0<Unit>, ? super Function2<? super PurchasesError, ? super Boolean, Unit>, Unit> postEvents, RateLimiter rateLimiter) {
        Intrinsics.checkNotNullParameter(appSessionID2, "appSessionID");
        Intrinsics.checkNotNullParameter(fileHelper, "fileHelper");
        Intrinsics.checkNotNullParameter(identityManager, "identityManager");
        Intrinsics.checkNotNullParameter(eventsDispatcher, "eventsDispatcher");
        Intrinsics.checkNotNullParameter(postEvents, "postEvents");
        Intrinsics.checkNotNullParameter(rateLimiter, vfptEEmYY.HFcBeWDWScf);
        this.appSessionID$1 = appSessionID2;
        this.legacyEventsFileHelper = eventsFileHelper;
        this.fileHelper = fileHelper;
        this.identityManager = identityManager;
        this.eventsDispatcher = eventsDispatcher;
        this.postEvents = postEvents;
        this.priorityFlushRateLimiter = rateLimiter;
        this.flushInProgress = new AtomicBoolean(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkFileSizeAndClearIfNeeded() {
        if (this.fileHelper.fileSizeInKB() >= 2048.0d) {
            LogLevel logLevel = LogLevel.WARN;
            LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
            if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                currentLogHandler.w("[Purchases] - " + logLevel.name(), "Event store size limit reached. Clearing oldest events to free up space.");
            }
            this.fileHelper.clear(50);
            DebugEventListener debugEventListener = this.debugEventListener;
            if (debugEventListener != null) {
                debugEventListener.onDebugEventReceived(new DebugEvent(DebugEventName.FILE_SIZE_LIMIT_REACHED, null, 2, null));
            }
        }
    }

    private final void enqueue(Delay delay, final Function0<Unit> function0) {
        this.eventsDispatcher.enqueue(new Runnable() { // from class: com.revenuecat.purchases.common.events.a
            @Override // java.lang.Runnable
            public final void run() {
                function0.invoke();
            }
        }, delay);
    }

    static /* synthetic */ void enqueue$default(EventsManager eventsManager, Delay delay, Function0 function0, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            delay = Delay.NONE;
        }
        eventsManager.enqueue(delay, function0);
    }

    public static /* synthetic */ void flushEvents$default(EventsManager eventsManager, Delay delay, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            delay = Delay.DEFAULT;
        }
        eventsManager.flushEvents(delay);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void flushLegacyEvents() {
        final EventsFileHelper<PaywallStoredEvent> eventsFileHelper = this.legacyEventsFileHelper;
        if (eventsFileHelper == null) {
            return;
        }
        enqueue$default(this, null, new Function0<Unit>() { // from class: com.revenuecat.purchases.common.events.EventsManager.flushLegacyEvents.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m546invoke();
                return Unit.f139807a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m546invoke() {
                final List legacyPaywallsStoredEvents = EventsManager.this.getLegacyPaywallsStoredEvents();
                List listFilterNotNull = CollectionsKt.filterNotNull(legacyPaywallsStoredEvents);
                List list = listFilterNotNull;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(new BackendStoredEvent.Paywalls(((PaywallStoredEvent) it.next()).toBackendEvent()));
                }
                if (listFilterNotNull.isEmpty()) {
                    LogLevel logLevel = LogLevel.VERBOSE;
                    LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                        currentLogHandler.v("[Purchases] - " + logLevel.name(), "No legacy events to sync. Skipping legacy flush.");
                        return;
                    }
                    return;
                }
                LogLevel logLevel2 = LogLevel.VERBOSE;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.v("[Purchases] - " + logLevel2.name(), "Legacy event flush: posting " + arrayList.size() + " events.");
                }
                Function4 function4 = EventsManager.this.postEvents;
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
                int size = arrayList.size();
                int i3 = 0;
                while (i3 < size) {
                    Object obj = arrayList.get(i3);
                    i3++;
                    arrayList2.add(BackendStoredEventKt.toBackendEvent((BackendStoredEvent.Paywalls) obj));
                }
                EventsRequest eventsRequest = new EventsRequest(arrayList2);
                Delay delay = Delay.LONG;
                final EventsManager eventsManager = EventsManager.this;
                final EventsFileHelper<PaywallStoredEvent> eventsFileHelper2 = eventsFileHelper;
                Function0<Unit> function0 = new Function0<Unit>() { // from class: com.revenuecat.purchases.common.events.EventsManager.flushLegacyEvents.1.4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m547invoke();
                        return Unit.f139807a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                    public final void m547invoke() {
                        LogLevel logLevel3 = LogLevel.VERBOSE;
                        LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                            currentLogHandler3.v("[Purchases] - " + logLevel3.name(), "Legacy event flush: success.");
                        }
                        EventsManager eventsManager2 = eventsManager;
                        final EventsFileHelper<PaywallStoredEvent> eventsFileHelper3 = eventsFileHelper2;
                        final List<PaywallStoredEvent> list2 = legacyPaywallsStoredEvents;
                        EventsManager.enqueue$default(eventsManager2, null, new Function0<Unit>() { // from class: com.revenuecat.purchases.common.events.EventsManager.flushLegacyEvents.1.4.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Object invoke() {
                                m548invoke();
                                return Unit.f139807a;
                            }

                            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                            public final void m548invoke() {
                                eventsFileHelper3.clear(list2.size());
                            }
                        }, 1, null);
                    }
                };
                final EventsManager eventsManager2 = EventsManager.this;
                final EventsFileHelper<PaywallStoredEvent> eventsFileHelper3 = eventsFileHelper;
                function4.invoke(eventsRequest, delay, function0, new Function2<PurchasesError, Boolean, Unit>() { // from class: com.revenuecat.purchases.common.events.EventsManager.flushLegacyEvents.1.5
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                        invoke((PurchasesError) obj2, ((Boolean) obj3).booleanValue());
                        return Unit.f139807a;
                    }

                    public final void invoke(PurchasesError error, final boolean z2) {
                        Intrinsics.checkNotNullParameter(error, "error");
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Legacy event flush error: " + error + '.', null);
                        EventsManager eventsManager3 = eventsManager2;
                        final EventsFileHelper<PaywallStoredEvent> eventsFileHelper4 = eventsFileHelper3;
                        final List<PaywallStoredEvent> list2 = legacyPaywallsStoredEvents;
                        EventsManager.enqueue$default(eventsManager3, null, new Function0<Unit>() { // from class: com.revenuecat.purchases.common.events.EventsManager.flushLegacyEvents.1.5.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Object invoke() {
                                m549invoke();
                                return Unit.f139807a;
                            }

                            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                            public final void m549invoke() {
                                if (z2) {
                                    eventsFileHelper4.clear(list2.size());
                                }
                            }
                        }, 1, null);
                    }
                });
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void flushNextBatch(final int i3, final Delay delay) {
        DebugEventListener debugEventListener;
        if (i3 > 10) {
            LogLevel logLevel = LogLevel.VERBOSE;
            LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
            if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                currentLogHandler.v("[Purchases] - " + logLevel.name(), "Reached maximum number of flush batches (10). Stopping flush.");
            }
            onFlushComplete();
            return;
        }
        final long jCurrentTimeMillis = System.currentTimeMillis();
        final List<BackendStoredEvent> storedEvents = getStoredEvents();
        List listFilterNotNull = CollectionsKt.filterNotNull(storedEvents);
        if (listFilterNotNull.isEmpty()) {
            LogLevel logLevel2 = LogLevel.VERBOSE;
            LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
            if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                currentLogHandler2.v("[Purchases] - " + logLevel2.name(), "No new events to sync.");
            }
            if (i3 == 1 && (debugEventListener = this.debugEventListener) != null) {
                debugEventListener.onDebugEventReceived(new DebugEvent(DebugEventName.FLUSH_SKIPPED_NO_EVENTS, null, 2, null));
            }
            onFlushComplete();
            return;
        }
        LogLevel logLevel3 = LogLevel.VERBOSE;
        LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
            currentLogHandler3.v("[Purchases] - " + logLevel3.name(), "New event flush (batch " + i3 + "): posting " + listFilterNotNull.size() + " events.");
        }
        Function4<EventsRequest, Delay, Function0<Unit>, Function2<? super PurchasesError, ? super Boolean, Unit>, Unit> function4 = this.postEvents;
        List list = listFilterNotNull;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(BackendStoredEventKt.toBackendEvent((BackendStoredEvent) it.next()));
        }
        function4.invoke(new EventsRequest(arrayList), delay, new Function0<Unit>() { // from class: com.revenuecat.purchases.common.events.EventsManager.flushNextBatch.5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m550invoke();
                return Unit.f139807a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m550invoke() {
                int i4 = i3;
                LogLevel logLevel4 = LogLevel.VERBOSE;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    currentLogHandler4.v("[Purchases] - " + logLevel4.name(), "New event flush (batch " + i4 + "): success.");
                }
                DebugEventListener debugEventListener2 = EventsManager.this.getDebugEventListener();
                if (debugEventListener2 != null) {
                    debugEventListener2.onDebugEventReceived(new DebugEvent(DebugEventName.FLUSH_COMPLETED, MapsKt.mapOf(TuplesKt.a("batch_number", String.valueOf(i3)), TuplesKt.a("elapsed_millis", String.valueOf(System.currentTimeMillis() - jCurrentTimeMillis)))));
                }
                final EventsManager eventsManager = EventsManager.this;
                final List<BackendStoredEvent> list2 = storedEvents;
                final int i5 = i3;
                final Delay delay2 = delay;
                EventsManager.enqueue$default(eventsManager, null, new Function0<Unit>() { // from class: com.revenuecat.purchases.common.events.EventsManager.flushNextBatch.5.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m551invoke();
                        return Unit.f139807a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                    public final void m551invoke() {
                        eventsManager.fileHelper.clear(list2.size());
                        eventsManager.flushNextBatch(i5 + 1, delay2);
                    }
                }, 1, null);
            }
        }, new Function2<PurchasesError, Boolean, Unit>() { // from class: com.revenuecat.purchases.common.events.EventsManager.flushNextBatch.6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((PurchasesError) obj, ((Boolean) obj2).booleanValue());
                return Unit.f139807a;
            }

            public final void invoke(PurchasesError error, final boolean z2) {
                Intrinsics.checkNotNullParameter(error, "error");
                int i4 = i3;
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "New event flush (batch " + i4 + ") error: " + error + '.', null);
                DebugEventListener debugEventListener2 = EventsManager.this.getDebugEventListener();
                if (debugEventListener2 != null) {
                    DebugEventName debugEventName = DebugEventName.FLUSH_ERROR;
                    Map mapCreateMapBuilder = MapsKt.createMapBuilder();
                    mapCreateMapBuilder.put("errorCode", error.getCode().name());
                    String underlyingErrorMessage = error.getUnderlyingErrorMessage();
                    if (underlyingErrorMessage != null) {
                        mapCreateMapBuilder.put("underlyingErrorMessage", StringsKt.B1(underlyingErrorMessage, 80));
                    }
                    Unit unit = Unit.f139807a;
                    debugEventListener2.onDebugEventReceived(new DebugEvent(debugEventName, MapsKt.build(mapCreateMapBuilder)));
                }
                final EventsManager eventsManager = EventsManager.this;
                final List<BackendStoredEvent> list2 = storedEvents;
                EventsManager.enqueue$default(eventsManager, null, new Function0<Unit>() { // from class: com.revenuecat.purchases.common.events.EventsManager.flushNextBatch.6.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m552invoke();
                        return Unit.f139807a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                    public final void m552invoke() {
                        if (z2) {
                            eventsManager.fileHelper.clear(list2.size());
                        }
                        eventsManager.onFlushComplete();
                    }
                }, 1, null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<PaywallStoredEvent> getLegacyPaywallsStoredEvents() {
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.f140144a = CollectionsKt.emptyList();
        EventsFileHelper<PaywallStoredEvent> eventsFileHelper = this.legacyEventsFileHelper;
        if (eventsFileHelper != null) {
            eventsFileHelper.readFile(new Function1<Sequence<? extends PaywallStoredEvent>, Unit>() { // from class: com.revenuecat.purchases.common.events.EventsManager.getLegacyPaywallsStoredEvents.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((Sequence<PaywallStoredEvent>) obj);
                    return Unit.f139807a;
                }

                public final void invoke(Sequence<PaywallStoredEvent> sequence) {
                    Intrinsics.checkNotNullParameter(sequence, "sequence");
                    objectRef.f140144a = SequencesKt.S(SequencesKt.P(sequence, 50));
                }
            });
        }
        return (List) objectRef.f140144a;
    }

    private final List<BackendStoredEvent> getStoredEvents() {
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.f140144a = CollectionsKt.emptyList();
        this.fileHelper.readFile(new Function1<Sequence<? extends BackendStoredEvent>, Unit>() { // from class: com.revenuecat.purchases.common.events.EventsManager.getStoredEvents.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Sequence<? extends BackendStoredEvent>) obj);
                return Unit.f139807a;
            }

            public final void invoke(Sequence<? extends BackendStoredEvent> sequence) {
                Intrinsics.checkNotNullParameter(sequence, "sequence");
                objectRef.f140144a = SequencesKt.S(SequencesKt.P(sequence, 50));
            }
        });
        return (List) objectRef.f140144a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onFlushComplete() {
        this.flushInProgress.set(false);
        startPendingPriorityFlushIfNeeded();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void performPriorityFlush() {
        this.pendingPriorityFlush = true;
        if (!this.flushInProgress.get()) {
            startPendingPriorityFlushIfNeeded();
            return;
        }
        LogLevel logLevel = LogLevel.DEBUG;
        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
            currentLogHandler.d("[Purchases] - " + logLevel.name(), "Flush in progress. Queuing priority flush.");
        }
    }

    private final void startPendingPriorityFlushIfNeeded() {
        if (this.pendingPriorityFlush) {
            this.pendingPriorityFlush = false;
            if (!this.priorityFlushRateLimiter.shouldProceed()) {
                LogLevel logLevel = LogLevel.DEBUG;
                LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    currentLogHandler.d("[Purchases] - " + logLevel.name(), "Priority flush rate limited. Skipping.");
                    return;
                }
                return;
            }
            if (this.flushInProgress.getAndSet(true)) {
                LogLevel logLevel2 = LogLevel.DEBUG;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.d("[Purchases] - " + logLevel2.name(), "Flush in progress. Queuing priority flush.");
                }
                this.pendingPriorityFlush = true;
                return;
            }
            LogLevel logLevel3 = LogLevel.DEBUG;
            LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
            if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                currentLogHandler3.d("[Purchases] - " + logLevel3.name(), "Starting priority flush.");
            }
            flushNextBatch(1, Delay.NONE);
        }
    }

    public final synchronized void flushEvents(final Delay delay) {
        Intrinsics.checkNotNullParameter(delay, "delay");
        enqueue$default(this, null, new Function0<Unit>() { // from class: com.revenuecat.purchases.common.events.EventsManager.flushEvents.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m545invoke();
                return Unit.f139807a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m545invoke() {
                if (EventsManager.this.flushInProgress.getAndSet(true)) {
                    LogLevel logLevel = LogLevel.DEBUG;
                    LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                        currentLogHandler.d("[Purchases] - " + logLevel.name(), "Flush already in progress.");
                        return;
                    }
                    return;
                }
                DebugEventListener debugEventListener = EventsManager.this.getDebugEventListener();
                if (debugEventListener != null) {
                    debugEventListener.onDebugEventReceived(new DebugEvent(DebugEventName.FLUSH_STARTED, null, 2, null));
                }
                EventsManager.this.flushNextBatch(1, delay);
                if (EventsManager.this.legacyFlushTriggered) {
                    return;
                }
                EventsManager.this.legacyFlushTriggered = true;
                EventsManager.this.flushLegacyEvents();
            }
        }, 1, null);
    }

    public final synchronized DebugEventListener getDebugEventListener() {
        return this.debugEventListener;
    }

    public final synchronized void setDebugEventListener(final DebugEventListener debugEventListener) {
        try {
            this.debugEventListener = debugEventListener;
            this.fileHelper.setDebugEventCallback(debugEventListener != null ? new Function1<DebugEvent, Unit>() { // from class: com.revenuecat.purchases.common.events.EventsManager$debugEventListener$callback$1$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((DebugEvent) obj);
                    return Unit.f139807a;
                }

                public final void invoke(DebugEvent event) {
                    Intrinsics.checkNotNullParameter(event, "event");
                    debugEventListener.onDebugEventReceived(event);
                }
            } : null);
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void track(final FeatureEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        enqueue$default(this, null, new Function0<Unit>() { // from class: com.revenuecat.purchases.common.events.EventsManager.track.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m553invoke();
                return Unit.f139807a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m553invoke() {
                BackendStoredEvent backendStoredEvent;
                FeatureEvent featureEvent = event;
                LogLevel logLevel = LogLevel.DEBUG;
                LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                Config config = Config.INSTANCE;
                if (config.getLogLevel().compareTo(logLevel) <= 0) {
                    currentLogHandler.d("[Purchases] - " + logLevel.name(), "Tracking event: " + featureEvent);
                }
                FeatureEvent featureEvent2 = event;
                if (featureEvent2 instanceof PaywallEvent) {
                    backendStoredEvent = BackendStoredEventKt.toBackendStoredEvent((PaywallEvent) featureEvent2, this.identityManager.getCurrentAppUserID());
                } else if (featureEvent2 instanceof CustomerCenterImpressionEvent) {
                    String currentAppUserID = this.identityManager.getCurrentAppUserID();
                    String string = this.appSessionID$1.toString();
                    Intrinsics.checkNotNullExpressionValue(string, "appSessionID.toString()");
                    backendStoredEvent = BackendStoredEventKt.toBackendStoredEvent((CustomerCenterImpressionEvent) featureEvent2, currentAppUserID, string);
                } else if (featureEvent2 instanceof CustomerCenterSurveyOptionChosenEvent) {
                    String currentAppUserID2 = this.identityManager.getCurrentAppUserID();
                    String string2 = this.appSessionID$1.toString();
                    Intrinsics.checkNotNullExpressionValue(string2, "appSessionID.toString()");
                    backendStoredEvent = BackendStoredEventKt.toBackendStoredEvent((CustomerCenterSurveyOptionChosenEvent) featureEvent2, currentAppUserID2, string2);
                } else if (featureEvent2 instanceof AdEvent.Displayed) {
                    String currentAppUserID3 = this.identityManager.getCurrentAppUserID();
                    String string3 = this.appSessionID$1.toString();
                    Intrinsics.checkNotNullExpressionValue(string3, "appSessionID.toString()");
                    backendStoredEvent = BackendStoredEventKt.toBackendStoredEvent((AdEvent.Displayed) featureEvent2, currentAppUserID3, string3);
                } else if (featureEvent2 instanceof AdEvent.Open) {
                    String currentAppUserID4 = this.identityManager.getCurrentAppUserID();
                    String string4 = this.appSessionID$1.toString();
                    Intrinsics.checkNotNullExpressionValue(string4, "appSessionID.toString()");
                    backendStoredEvent = BackendStoredEventKt.toBackendStoredEvent((AdEvent.Open) featureEvent2, currentAppUserID4, string4);
                } else if (featureEvent2 instanceof AdEvent.Revenue) {
                    String currentAppUserID5 = this.identityManager.getCurrentAppUserID();
                    String string5 = this.appSessionID$1.toString();
                    Intrinsics.checkNotNullExpressionValue(string5, "appSessionID.toString()");
                    backendStoredEvent = BackendStoredEventKt.toBackendStoredEvent((AdEvent.Revenue) featureEvent2, currentAppUserID5, string5);
                } else if (featureEvent2 instanceof AdEvent.Loaded) {
                    String currentAppUserID6 = this.identityManager.getCurrentAppUserID();
                    String string6 = this.appSessionID$1.toString();
                    Intrinsics.checkNotNullExpressionValue(string6, "appSessionID.toString()");
                    backendStoredEvent = BackendStoredEventKt.toBackendStoredEvent((AdEvent.Loaded) featureEvent2, currentAppUserID6, string6);
                } else if (featureEvent2 instanceof AdEvent.FailedToLoad) {
                    String currentAppUserID7 = this.identityManager.getCurrentAppUserID();
                    String string7 = this.appSessionID$1.toString();
                    Intrinsics.checkNotNullExpressionValue(string7, "appSessionID.toString()");
                    backendStoredEvent = BackendStoredEventKt.toBackendStoredEvent((AdEvent.FailedToLoad) featureEvent2, currentAppUserID7, string7);
                } else if (featureEvent2 instanceof CustomPaywallEvent.Impression) {
                    String currentAppUserID8 = this.identityManager.getCurrentAppUserID();
                    String string8 = this.appSessionID$1.toString();
                    Intrinsics.checkNotNullExpressionValue(string8, "appSessionID.toString()");
                    backendStoredEvent = BackendStoredEventKt.toBackendStoredEvent((CustomPaywallEvent.Impression) featureEvent2, currentAppUserID8, string8);
                } else {
                    backendStoredEvent = null;
                }
                if (backendStoredEvent != null) {
                    this.checkFileSizeAndClearIfNeeded();
                    this.fileHelper.appendEvent(backendStoredEvent);
                    if (event.isPriorityEvent()) {
                        this.performPriorityFlush();
                        return;
                    }
                    return;
                }
                FeatureEvent featureEvent3 = event;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (config.getLogLevel().compareTo(logLevel) <= 0) {
                    currentLogHandler2.d("[Purchases] - " + logLevel.name(), "Backend event not implemented for: " + featureEvent3);
                }
            }
        }, 1, null);
    }

    public /* synthetic */ EventsManager(UUID uuid, EventsFileHelper eventsFileHelper, EventsFileHelper eventsFileHelper2, IdentityManager identityManager, Dispatcher dispatcher, Function4 function4, RateLimiter rateLimiter, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        uuid = (i3 & 1) != 0 ? appSessionID : uuid;
        if ((i3 & 64) != 0) {
            Duration.Companion companion = Duration.f140631b;
            rateLimiter = new RateLimiter(5, DurationKt.s(60, DurationUnit.f140641f), null);
        }
        this(uuid, eventsFileHelper, eventsFileHelper2, identityManager, dispatcher, function4, rateLimiter);
    }
}
