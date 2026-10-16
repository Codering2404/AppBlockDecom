package com.superwall.sdk.storage.core_data;

import android.content.Context;
import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;
import com.superwall.sdk.logger.LogLevel;
import com.superwall.sdk.logger.LogScope;
import com.superwall.sdk.logger.Logger;
import com.superwall.sdk.models.events.EventData;
import com.superwall.sdk.models.triggers.TriggerRuleOccurrence;
import com.superwall.sdk.storage.core_data.entities.ManagedEventData;
import com.superwall.sdk.storage.core_data.entities.ManagedEventDataDao;
import com.superwall.sdk.storage.core_data.entities.ManagedTriggerRuleOccurrence;
import com.superwall.sdk.storage.core_data.entities.ManagedTriggerRuleOccurrenceDao;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
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
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
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
public final class CoreDataManager implements CoroutineScope {
    private final CoroutineContext coroutineContext;
    private final CoroutineScope eventDataScope;
    private final Lazy superwallDatabase$delegate;

    /* JADX INFO: renamed from: com.superwall.sdk.storage.core_data.CoreDataManager$countEventsByNameInPeriod$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.storage.core_data.CoreDataManager", f = "CoreDataManager.kt", l = {RCHTTPStatusCodes.CREATED}, m = "countEventsByNameInPeriod")
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
            return CoreDataManager.this.countEventsByNameInPeriod(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.storage.core_data.CoreDataManager$deleteAllEntities$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.storage.core_data.CoreDataManager$deleteAllEntities$1", f = "CoreDataManager.kt", l = {92}, m = "invokeSuspend")
    static final class C29081 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C29081(Continuation<? super C29081> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CoreDataManager.this.new C29081(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            try {
                if (i3 == 0) {
                    ResultKt.b(obj);
                    ManagedTriggerRuleOccurrenceDao managedTriggerRuleOccurrenceDao = CoreDataManager.this.getSuperwallDatabase().managedTriggerRuleOccurrenceDao();
                    this.label = 1;
                    if (managedTriggerRuleOccurrenceDao.deleteAll(this) == objF) {
                        return objF;
                    }
                } else {
                    if (i3 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                }
            } catch (Throwable th) {
                Logger.debug$default(Logger.INSTANCE, LogLevel.error, LogScope.coreData, "Could not delete entities in Room database.", (Map) null, th, 8, (Object) null);
            }
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C29081) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.storage.core_data.CoreDataManager$deleteAllEntities$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.storage.core_data.CoreDataManager$deleteAllEntities$2", f = "CoreDataManager.kt", l = {104}, m = "invokeSuspend")
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CoreDataManager.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            try {
                if (i3 == 0) {
                    ResultKt.b(obj);
                    ManagedEventDataDao managedEventDataDao = CoreDataManager.this.getSuperwallDatabase().managedEventDataDao();
                    this.label = 1;
                    if (managedEventDataDao.deleteAll(this) == objF) {
                        return objF;
                    }
                } else {
                    if (i3 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                }
            } catch (Throwable th) {
                Logger.debug$default(Logger.INSTANCE, LogLevel.error, LogScope.coreData, "Could not delete entities in Room database.", (Map) null, th, 8, (Object) null);
            }
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.storage.core_data.CoreDataManager$getComputedPropertySinceEvent$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.storage.core_data.CoreDataManager", f = "CoreDataManager.kt", l = {127}, m = "getComputedPropertySinceEvent")
    static final class C29091 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C29091(Continuation<? super C29091> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CoreDataManager.this.getComputedPropertySinceEvent(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.storage.core_data.CoreDataManager$save$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.storage.core_data.CoreDataManager$save$1", f = "CoreDataManager.kt", l = {73}, m = "invokeSuspend")
    static final class C29101 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<ManagedTriggerRuleOccurrence, Unit> $completion;
        final /* synthetic */ TriggerRuleOccurrence $triggerRuleOccurrence;
        Object L$0;
        int label;
        final /* synthetic */ CoreDataManager this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C29101(TriggerRuleOccurrence triggerRuleOccurrence, CoreDataManager coreDataManager, Function1<? super ManagedTriggerRuleOccurrence, Unit> function1, Continuation<? super C29101> continuation) {
            super(2, continuation);
            this.$triggerRuleOccurrence = triggerRuleOccurrence;
            this.this$0 = coreDataManager;
            this.$completion = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C29101(this.$triggerRuleOccurrence, this.this$0, this.$completion, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            ManagedTriggerRuleOccurrence managedTriggerRuleOccurrence;
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            try {
                if (i3 == 0) {
                    ResultKt.b(obj);
                    ManagedTriggerRuleOccurrence managedTriggerRuleOccurrence2 = new ManagedTriggerRuleOccurrence(null, null, this.$triggerRuleOccurrence.getKey(), 3, null);
                    ManagedTriggerRuleOccurrenceDao managedTriggerRuleOccurrenceDao = this.this$0.getSuperwallDatabase().managedTriggerRuleOccurrenceDao();
                    this.L$0 = managedTriggerRuleOccurrence2;
                    this.label = 1;
                    if (managedTriggerRuleOccurrenceDao.insert(managedTriggerRuleOccurrence2, this) == objF) {
                        return objF;
                    }
                    managedTriggerRuleOccurrence = managedTriggerRuleOccurrence2;
                } else {
                    if (i3 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    managedTriggerRuleOccurrence = (ManagedTriggerRuleOccurrence) this.L$0;
                    ResultKt.b(obj);
                }
                Function1<ManagedTriggerRuleOccurrence, Unit> function1 = this.$completion;
                if (function1 != null) {
                    function1.invoke(managedTriggerRuleOccurrence);
                }
            } catch (Throwable th) {
                Logger.debug$default(Logger.INSTANCE, LogLevel.error, LogScope.coreData, "Error saving to Room database.", (Map) null, th, 8, (Object) null);
            }
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C29101) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.storage.core_data.CoreDataManager$saveEventData$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.storage.core_data.CoreDataManager$saveEventData$1", f = "CoreDataManager.kt", l = {46}, m = "invokeSuspend")
    static final class C29111 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<ManagedEventData, Unit> $completion;
        final /* synthetic */ EventData $eventData;
        Object L$0;
        int label;
        final /* synthetic */ CoreDataManager this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C29111(EventData eventData, CoreDataManager coreDataManager, Function1<? super ManagedEventData, Unit> function1, Continuation<? super C29111> continuation) {
            super(2, continuation);
            this.$eventData = eventData;
            this.this$0 = coreDataManager;
            this.$completion = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C29111(this.$eventData, this.this$0, this.$completion, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            ManagedEventData managedEventData;
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            try {
                if (i3 == 0) {
                    ResultKt.b(obj);
                    ManagedEventData managedEventData2 = new ManagedEventData(this.$eventData.getId(), this.$eventData.getCreatedAt(), this.$eventData.getName(), this.$eventData.getParameters());
                    ManagedEventDataDao managedEventDataDao = this.this$0.getSuperwallDatabase().managedEventDataDao();
                    this.L$0 = managedEventData2;
                    this.label = 1;
                    if (managedEventDataDao.insert(managedEventData2, this) == objF) {
                        return objF;
                    }
                    managedEventData = managedEventData2;
                } else {
                    if (i3 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    managedEventData = (ManagedEventData) this.L$0;
                    ResultKt.b(obj);
                }
                Function1<ManagedEventData, Unit> function1 = this.$completion;
                if (function1 != null) {
                    function1.invoke(managedEventData);
                }
            } catch (Throwable th) {
                Logger.debug$default(Logger.INSTANCE, LogLevel.error, LogScope.coreData, "Error saving to Room database.", (Map) null, th, 8, (Object) null);
            }
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C29111) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    public CoreDataManager(final Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.coroutineContext = CoroutineDispatcher.q0(Dispatchers.b(), 1, null, 2, null);
        this.eventDataScope = CoroutineScopeKt.a(CoroutineDispatcher.q0(Dispatchers.b(), 1, null, 2, null));
        this.superwallDatabase$delegate = LazyKt.b(new Function0() { // from class: com.superwall.sdk.storage.core_data.c
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CoreDataManager.superwallDatabase_delegate$lambda$0(context);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SuperwallDatabase getSuperwallDatabase() {
        return (SuperwallDatabase) this.superwallDatabase$delegate.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void save$default(CoreDataManager coreDataManager, TriggerRuleOccurrence triggerRuleOccurrence, Function1 function1, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            function1 = null;
        }
        coreDataManager.save(triggerRuleOccurrence, function1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void saveEventData$default(CoreDataManager coreDataManager, EventData eventData, Function1 function1, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            function1 = null;
        }
        coreDataManager.saveEventData(eventData, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SuperwallDatabase superwallDatabase_delegate$lambda$0(Context context) {
        return SuperwallDatabase.Companion.getDatabase(context);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object countEventsByNameInPeriod(java.lang.String r9, java.util.Date r10, java.util.Date r11, kotlin.coroutines.Continuation<? super java.lang.Integer> r12) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r12 instanceof com.superwall.sdk.storage.core_data.CoreDataManager.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r12
            com.superwall.sdk.storage.core_data.CoreDataManager$countEventsByNameInPeriod$1 r0 = (com.superwall.sdk.storage.core_data.CoreDataManager.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.superwall.sdk.storage.core_data.CoreDataManager$countEventsByNameInPeriod$1 r0 = new com.superwall.sdk.storage.core_data.CoreDataManager$countEventsByNameInPeriod$1
            r0.<init>(r12)
        L18:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            kotlin.ResultKt.b(r12)     // Catch: java.lang.Throwable -> L29
            goto L49
        L29:
            r0 = move-exception
            r9 = r0
            r5 = r9
            goto L50
        L2d:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L35:
            kotlin.ResultKt.b(r12)
            com.superwall.sdk.storage.core_data.SuperwallDatabase r12 = r8.getSuperwallDatabase()     // Catch: java.lang.Throwable -> L29
            com.superwall.sdk.storage.core_data.entities.ManagedEventDataDao r12 = r12.managedEventDataDao()     // Catch: java.lang.Throwable -> L29
            r0.label = r3     // Catch: java.lang.Throwable -> L29
            java.lang.Object r12 = r12.countEventsByNameInPeriod(r9, r10, r11, r0)     // Catch: java.lang.Throwable -> L29
            if (r12 != r1) goto L49
            return r1
        L49:
            java.lang.Number r12 = (java.lang.Number) r12     // Catch: java.lang.Throwable -> L29
            int r9 = r12.intValue()     // Catch: java.lang.Throwable -> L29
            goto L60
        L50:
            com.superwall.sdk.logger.Logger r0 = com.superwall.sdk.logger.Logger.INSTANCE
            com.superwall.sdk.logger.LogLevel r1 = com.superwall.sdk.logger.LogLevel.error
            com.superwall.sdk.logger.LogScope r2 = com.superwall.sdk.logger.LogScope.coreData
            r6 = 8
            r7 = 0
            java.lang.String r3 = "Error counting events by name in period from Room database."
            r4 = 0
            com.superwall.sdk.logger.Logger.debug$default(r0, r1, r2, r3, r4, r5, r6, r7)
            r9 = 0
        L60:
            java.lang.Integer r9 = kotlin.coroutines.jvm.internal.Boxing.d(r9)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.storage.core_data.CoreDataManager.countEventsByNameInPeriod(java.lang.String, java.util.Date, java.util.Date, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object countTriggerRuleOccurrences(TriggerRuleOccurrence triggerRuleOccurrence, Continuation<? super Integer> continuation) {
        ManagedTriggerRuleOccurrenceDao managedTriggerRuleOccurrenceDao = getSuperwallDatabase().managedTriggerRuleOccurrenceDao();
        TriggerRuleOccurrence.Interval interval = triggerRuleOccurrence.getInterval();
        if (!(interval instanceof TriggerRuleOccurrence.Interval.Minutes)) {
            if (Intrinsics.areEqual(interval, TriggerRuleOccurrence.Interval.Infinity.INSTANCE)) {
                return managedTriggerRuleOccurrenceDao.countTriggerRuleOccurrencesByKey(triggerRuleOccurrence.getKey(), continuation);
            }
            throw new NoWhenBranchMatchedException();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.add(12, -((TriggerRuleOccurrence.Interval.Minutes) triggerRuleOccurrence.getInterval()).getMinutes());
        Date time = calendar.getTime();
        String key = triggerRuleOccurrence.getKey();
        Intrinsics.checkNotNull(time);
        return managedTriggerRuleOccurrenceDao.countTriggerRuleOccurrencesSinceDate(time, key, continuation);
    }

    public final void deleteAllEntities() {
        BuildersKt__Builders_commonKt.d(this, null, null, new C29081(null), 3, null);
        BuildersKt__Builders_commonKt.d(this.eventDataScope, null, null, new AnonymousClass2(null), 3, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getComputedPropertySinceEvent(com.superwall.sdk.models.events.EventData r13, com.superwall.sdk.models.config.ComputedPropertyRequest r14, kotlin.coroutines.Continuation<? super java.lang.Integer> r15) {
        /*
            Method dump skipped, instruction units count: 325
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.storage.core_data.CoreDataManager.getComputedPropertySinceEvent(com.superwall.sdk.models.events.EventData, com.superwall.sdk.models.config.ComputedPropertyRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    public final void save(TriggerRuleOccurrence triggerRuleOccurrence, Function1<? super ManagedTriggerRuleOccurrence, Unit> function1) {
        Intrinsics.checkNotNullParameter(triggerRuleOccurrence, "triggerRuleOccurrence");
        BuildersKt__Builders_commonKt.d(this, null, null, new C29101(triggerRuleOccurrence, this, function1, null), 3, null);
    }

    public final void saveEventData(EventData eventData, Function1<? super ManagedEventData, Unit> function1) {
        Intrinsics.checkNotNullParameter(eventData, "eventData");
        BuildersKt__Builders_commonKt.d(this.eventDataScope, null, null, new C29111(eventData, this, function1, null), 3, null);
    }
}
