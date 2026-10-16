package com.revenuecat.purchases.common.diagnostics;

import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.common.Backend;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.Dispatcher;
import com.revenuecat.purchases.common.LogWrapperKt;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import org.json.JSONObject;

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
public final class DiagnosticsSynchronizer implements DiagnosticsEventTrackerListener {
    public static final Companion Companion = new Companion(null);
    public static final int MAX_EVENTS_TO_SYNC_PER_REQUEST = 200;
    public static final int MAX_NUMBER_POST_RETRIES = 3;
    private final Backend backend;
    private final Dispatcher diagnosticsDispatcher;
    private final DiagnosticsFileHelper diagnosticsFileHelper;
    private final DiagnosticsHelper diagnosticsHelper;
    private final DiagnosticsTracker diagnosticsTracker;
    private final AtomicBoolean isSyncing;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ void getMAX_EVENTS_TO_SYNC_PER_REQUEST$annotations() {
        }

        public static /* synthetic */ void getMAX_NUMBER_POST_RETRIES$annotations() {
        }
    }

    public DiagnosticsSynchronizer(DiagnosticsHelper diagnosticsHelper, DiagnosticsFileHelper diagnosticsFileHelper, DiagnosticsTracker diagnosticsTracker, Backend backend, Dispatcher diagnosticsDispatcher) {
        Intrinsics.checkNotNullParameter(diagnosticsHelper, "diagnosticsHelper");
        Intrinsics.checkNotNullParameter(diagnosticsFileHelper, "diagnosticsFileHelper");
        Intrinsics.checkNotNullParameter(diagnosticsTracker, "diagnosticsTracker");
        Intrinsics.checkNotNullParameter(backend, "backend");
        Intrinsics.checkNotNullParameter(diagnosticsDispatcher, "diagnosticsDispatcher");
        this.diagnosticsHelper = diagnosticsHelper;
        this.diagnosticsFileHelper = diagnosticsFileHelper;
        this.diagnosticsTracker = diagnosticsTracker;
        this.backend = backend;
        this.diagnosticsDispatcher = diagnosticsDispatcher;
        this.isSyncing = new AtomicBoolean(false);
    }

    private final void enqueue(final Function0<Unit> function0) {
        Dispatcher.enqueue$default(this.diagnosticsDispatcher, new Runnable() { // from class: com.revenuecat.purchases.common.diagnostics.a
            @Override // java.lang.Runnable
            public final void run() {
                function0.invoke();
            }
        }, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<JSONObject> getEventsToSync() {
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.f140144a = CollectionsKt.emptyList();
        this.diagnosticsFileHelper.readFileAsJson(new Function1<Sequence<? extends JSONObject>, Unit>() { // from class: com.revenuecat.purchases.common.diagnostics.DiagnosticsSynchronizer.getEventsToSync.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Sequence<? extends JSONObject>) obj);
                return Unit.f139807a;
            }

            public final void invoke(Sequence<? extends JSONObject> sequence) {
                Intrinsics.checkNotNullParameter(sequence, "sequence");
                objectRef.f140144a = SequencesKt.S(SequencesKt.P(sequence, 200));
            }
        });
        return (List) objectRef.f140144a;
    }

    private final void syncDiagnosticsFileIfBigEnough() {
        enqueue(new Function0<Unit>() { // from class: com.revenuecat.purchases.common.diagnostics.DiagnosticsSynchronizer.syncDiagnosticsFileIfBigEnough.1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m528invoke();
                return Unit.f139807a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m528invoke() {
                if (DiagnosticsSynchronizer.this.diagnosticsFileHelper.isDiagnosticsFileBigEnoughToSync()) {
                    LogLevel logLevel = LogLevel.VERBOSE;
                    LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                        currentLogHandler.v("[Purchases] - " + logLevel.name(), "Diagnostics file is big enough to sync. Syncing it.");
                    }
                    DiagnosticsSynchronizer.this.syncDiagnosticsFileIfNeeded();
                }
            }
        });
    }

    public final AtomicBoolean isSyncing() {
        return this.isSyncing;
    }

    @Override // com.revenuecat.purchases.common.diagnostics.DiagnosticsEventTrackerListener
    public void onEventTracked() {
        syncDiagnosticsFileIfBigEnough();
    }

    public final void syncDiagnosticsFileIfNeeded() {
        enqueue(new Function0<Unit>() { // from class: com.revenuecat.purchases.common.diagnostics.DiagnosticsSynchronizer.syncDiagnosticsFileIfNeeded.1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() throws Throwable {
                m529invoke();
                return Unit.f139807a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m529invoke() throws Throwable {
                try {
                    if (DiagnosticsSynchronizer.this.isSyncing().getAndSet(true)) {
                        LogLevel logLevel = LogLevel.VERBOSE;
                        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                            currentLogHandler.v("[Purchases] - " + logLevel.name(), "Already syncing diagnostics file.");
                            return;
                        }
                        return;
                    }
                    List<? extends JSONObject> eventsToSync = DiagnosticsSynchronizer.this.getEventsToSync();
                    final int size = eventsToSync.size();
                    if (size != 0) {
                        Backend backend = DiagnosticsSynchronizer.this.backend;
                        final DiagnosticsSynchronizer diagnosticsSynchronizer = DiagnosticsSynchronizer.this;
                        Function1<JSONObject, Unit> function1 = new Function1<JSONObject, Unit>() { // from class: com.revenuecat.purchases.common.diagnostics.DiagnosticsSynchronizer.syncDiagnosticsFileIfNeeded.1.3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((JSONObject) obj);
                                return Unit.f139807a;
                            }

                            public final void invoke(JSONObject it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                LogLevel logLevel2 = LogLevel.VERBOSE;
                                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                                    currentLogHandler2.v("[Purchases] - " + logLevel2.name(), "Synced diagnostics file successfully.");
                                }
                                diagnosticsSynchronizer.diagnosticsHelper.clearConsecutiveNumberOfErrors();
                                diagnosticsSynchronizer.diagnosticsFileHelper.clear(size);
                                diagnosticsSynchronizer.isSyncing().set(false);
                            }
                        };
                        final DiagnosticsSynchronizer diagnosticsSynchronizer2 = DiagnosticsSynchronizer.this;
                        backend.postDiagnostics(eventsToSync, function1, new Function2<PurchasesError, Boolean, Unit>() { // from class: com.revenuecat.purchases.common.diagnostics.DiagnosticsSynchronizer.syncDiagnosticsFileIfNeeded.1.4
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((PurchasesError) obj, ((Boolean) obj2).booleanValue());
                                return Unit.f139807a;
                            }

                            public final void invoke(PurchasesError error, boolean z2) {
                                Intrinsics.checkNotNullParameter(error, "error");
                                if (z2) {
                                    LogLevel logLevel2 = LogLevel.VERBOSE;
                                    LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                                    Config config = Config.INSTANCE;
                                    if (config.getLogLevel().compareTo(logLevel2) <= 0) {
                                        currentLogHandler2.v("[Purchases] - " + logLevel2.name(), "Error syncing diagnostics file: " + error + ". Will retry the next time the SDK is initialized");
                                    }
                                    if (diagnosticsSynchronizer2.diagnosticsHelper.increaseConsecutiveNumberOfErrors() >= 3) {
                                        LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                                        if (config.getLogLevel().compareTo(logLevel2) <= 0) {
                                            currentLogHandler3.v("[Purchases] - " + logLevel2.name(), "Error syncing diagnostics file: " + error + ". This was the final attempt (3). Deleting diagnostics file without posting.");
                                        }
                                        diagnosticsSynchronizer2.diagnosticsHelper.resetDiagnosticsStatus();
                                        diagnosticsSynchronizer2.diagnosticsTracker.trackMaxDiagnosticsSyncRetriesReached();
                                    }
                                } else {
                                    LogLevel logLevel3 = LogLevel.VERBOSE;
                                    LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                                        currentLogHandler4.v("[Purchases] - " + logLevel3.name(), "Error syncing diagnostics file: " + error + ". Deleting diagnostics file without retrying.");
                                    }
                                    diagnosticsSynchronizer2.diagnosticsHelper.resetDiagnosticsStatus();
                                    diagnosticsSynchronizer2.diagnosticsTracker.trackClearingDiagnosticsAfterFailedSync();
                                }
                                diagnosticsSynchronizer2.isSyncing().set(false);
                            }
                        });
                        return;
                    }
                    LogLevel logLevel2 = LogLevel.VERBOSE;
                    LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                        currentLogHandler2.v("[Purchases] - " + logLevel2.name(), "No diagnostics to sync.");
                    }
                    DiagnosticsSynchronizer.this.isSyncing().set(false);
                } catch (Exception e3) {
                    LogLevel logLevel3 = LogLevel.VERBOSE;
                    LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                        currentLogHandler3.v("[Purchases] - " + logLevel3.name(), "Error syncing diagnostics file: " + e3);
                    }
                    try {
                        DiagnosticsSynchronizer.this.diagnosticsHelper.resetDiagnosticsStatus();
                    } catch (IOException e4) {
                        LogLevel logLevel4 = LogLevel.VERBOSE;
                        LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                            currentLogHandler4.v("[Purchases] - " + logLevel4.name(), "Error deleting diagnostics file: " + e4);
                        }
                    }
                    DiagnosticsSynchronizer.this.isSyncing().set(false);
                }
            }
        });
    }
}
