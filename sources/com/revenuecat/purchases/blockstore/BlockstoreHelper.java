package com.revenuecat.purchases.blockstore;

import android.content.Context;
import com.google.android.gms.auth.blockstore.Blockstore;
import com.google.android.gms.auth.blockstore.BlockstoreClient;
import com.google.android.gms.auth.blockstore.DeleteBytesRequest;
import com.google.android.gms.auth.blockstore.RetrieveBytesRequest;
import com.google.android.gms.auth.blockstore.RetrieveBytesResponse;
import com.google.android.gms.auth.blockstore.StoreBytesData;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.blockstore.BlockstoreHelper;
import com.revenuecat.purchases.common.CancellableContinuationExtensionsKt;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.identity.IdentityManager;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
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
import kotlin.text.Charsets;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class BlockstoreHelper {

    @Deprecated
    public static final int BLOCKSTORE_MAX_ENTRIES = 16;

    @Deprecated
    public static final String BLOCKSTORE_USER_ID_KEY = "com.revenuecat.purchases.app_user_id";
    private static final Companion Companion = new Companion(null);
    private final BlockstoreClient blockstoreClient;
    private final IdentityManager identityManager;
    private final CoroutineScope ioScope;
    private final CoroutineScope mainScope;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final BlockstoreClient initializeBlockstoreClient(Context applicationContext) {
            Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
            try {
                return Blockstore.a(applicationContext);
            } catch (NoClassDefFoundError e3) {
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Cannot find Blockstore at runtime. Disabling automatic backups.", e3);
                return null;
            }
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.blockstore.BlockstoreHelper$aliasCurrentAndStoredUserIdsIfNeeded$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.revenuecat.purchases.blockstore.BlockstoreHelper$aliasCurrentAndStoredUserIdsIfNeeded$1", f = "BlockstoreHelper.kt", l = {87, 100}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function0<Unit> $callback;
        final /* synthetic */ String $currentUserId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, Function0<Unit> function0, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$currentUserId = str;
            this.$callback = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return BlockstoreHelper.this.new AnonymousClass1(this.$currentUserId, this.$callback, continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:35:0x00a9, code lost:
        
            if (r8.aliasCurrentUserIdTo(r1, r7) == r0) goto L36;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 285
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.blockstore.BlockstoreHelper.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.blockstore.BlockstoreHelper$clearUserIdBackupIfNeeded$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.revenuecat.purchases.blockstore.BlockstoreHelper$clearUserIdBackupIfNeeded$1", f = "BlockstoreHelper.kt", l = {}, m = "invokeSuspend")
    static final class C23321 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ BlockstoreClient $blockstoreClient;
        final /* synthetic */ Function0<Unit> $callback;
        final /* synthetic */ DeleteBytesRequest $request;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C23321(BlockstoreClient blockstoreClient, DeleteBytesRequest deleteBytesRequest, Function0<Unit> function0, Continuation<? super C23321> continuation) {
            super(2, continuation);
            this.$blockstoreClient = blockstoreClient;
            this.$request = deleteBytesRequest;
            this.$callback = function0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$lambda$2(Function0 function0, Exception exc) {
            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Tried to clear Block store cached UserID but failed: " + exc.getMessage(), exc);
            function0.invoke();
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C23321(this.$blockstoreClient, this.$request, this.$callback, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            Task taskDeleteBytes = this.$blockstoreClient.deleteBytes(this.$request);
            final Function0<Unit> function0 = this.$callback;
            final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.revenuecat.purchases.blockstore.BlockstoreHelper.clearUserIdBackupIfNeeded.1.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke((Boolean) obj2);
                    return Unit.f139807a;
                }

                public final void invoke(Boolean bool) {
                    LogLevel logLevel = LogLevel.DEBUG;
                    LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                        currentLogHandler.d("[Purchases] - " + logLevel.name(), "Block store cached UserID cleared if any");
                    }
                    function0.invoke();
                }
            };
            Task taskAddOnSuccessListener = taskDeleteBytes.addOnSuccessListener(new OnSuccessListener() { // from class: com.revenuecat.purchases.blockstore.a
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj2) {
                    function1.invoke(obj2);
                }
            });
            final Function0<Unit> function02 = this.$callback;
            taskAddOnSuccessListener.addOnFailureListener(new OnFailureListener() { // from class: com.revenuecat.purchases.blockstore.b
                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception exc) {
                    BlockstoreHelper.C23321.invokeSuspend$lambda$2(function02, exc);
                }
            });
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C23321) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.blockstore.BlockstoreHelper$storeUserIdIfNeeded$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.revenuecat.purchases.blockstore.BlockstoreHelper$storeUserIdIfNeeded$1", f = "BlockstoreHelper.kt", l = {61, 67}, m = "invokeSuspend")
    static final class C23331 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $currentUserId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C23331(String str, Continuation<? super C23331> continuation) {
            super(2, continuation);
            this.$currentUserId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return BlockstoreHelper.this.new C23331(this.$currentUserId, continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x003e, code lost:
        
            if (r1.storeUserIdIfNeeded(r6, r4, r5) == r0) goto L23;
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
                java.lang.String r2 = "[Purchases] - ERROR"
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L24
                if (r1 == r4) goto L1e
                if (r1 != r3) goto L16
                kotlin.ResultKt.b(r6)     // Catch: java.lang.Exception -> L14
                goto L5d
            L14:
                r6 = move-exception
                goto L41
            L16:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L1e:
                kotlin.ResultKt.b(r6)     // Catch: java.lang.Exception -> L22
                goto L32
            L22:
                r6 = move-exception
                goto L60
            L24:
                kotlin.ResultKt.b(r6)
                com.revenuecat.purchases.blockstore.BlockstoreHelper r6 = com.revenuecat.purchases.blockstore.BlockstoreHelper.this     // Catch: java.lang.Exception -> L22
                r5.label = r4     // Catch: java.lang.Exception -> L22
                java.lang.Object r6 = com.revenuecat.purchases.blockstore.BlockstoreHelper.access$getBlockstoreData(r6, r5)     // Catch: java.lang.Exception -> L22
                if (r6 != r0) goto L32
                goto L40
            L32:
                java.util.Map r6 = (java.util.Map) r6     // Catch: java.lang.Exception -> L22
                com.revenuecat.purchases.blockstore.BlockstoreHelper r1 = com.revenuecat.purchases.blockstore.BlockstoreHelper.this     // Catch: java.lang.Exception -> L14
                java.lang.String r4 = r5.$currentUserId     // Catch: java.lang.Exception -> L14
                r5.label = r3     // Catch: java.lang.Exception -> L14
                java.lang.Object r6 = com.revenuecat.purchases.blockstore.BlockstoreHelper.access$storeUserIdIfNeeded(r1, r6, r4, r5)     // Catch: java.lang.Exception -> L14
                if (r6 != r0) goto L5d
            L40:
                return r0
            L41:
                com.revenuecat.purchases.LogHandler r0 = com.revenuecat.purchases.common.LogWrapperKt.getCurrentLogHandler()
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r3 = "Failed to store user Id in Block store: "
                r1.append(r3)
                java.lang.String r3 = r6.getMessage()
                r1.append(r3)
                java.lang.String r1 = r1.toString()
                r0.e(r2, r1, r6)
            L5d:
                kotlin.Unit r6 = kotlin.Unit.f139807a
                return r6
            L60:
                com.revenuecat.purchases.LogHandler r0 = com.revenuecat.purchases.common.LogWrapperKt.getCurrentLogHandler()
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r3 = "Failed to retrieve Block store data. Will not store userId. Error: "
                r1.append(r3)
                java.lang.String r3 = r6.getMessage()
                r1.append(r3)
                java.lang.String r1 = r1.toString()
                r0.e(r2, r1, r6)
                kotlin.Unit r6 = kotlin.Unit.f139807a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.blockstore.BlockstoreHelper.C23331.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C23331) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    public BlockstoreHelper(Context applicationContext, IdentityManager identityManager, BlockstoreClient blockstoreClient, CoroutineScope ioScope, CoroutineScope mainScope) {
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        Intrinsics.checkNotNullParameter(identityManager, "identityManager");
        Intrinsics.checkNotNullParameter(ioScope, "ioScope");
        Intrinsics.checkNotNullParameter(mainScope, "mainScope");
        this.identityManager = identityManager;
        this.blockstoreClient = blockstoreClient;
        this.ioScope = ioScope;
        this.mainScope = mainScope;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void aliasCurrentAndStoredUserIdsIfNeeded$callCompletion(BlockstoreHelper blockstoreHelper, Function0<Unit> function0) {
        BuildersKt__Builders_commonKt.d(blockstoreHelper.mainScope, null, null, new BlockstoreHelper$aliasCurrentAndStoredUserIdsIfNeeded$callCompletion$1(function0, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object getBlockstoreData(Continuation<? super Map<String, ? extends RetrieveBytesResponse.BlockstoreData>> continuation) {
        BlockstoreClient blockstoreClient = this.blockstoreClient;
        if (blockstoreClient == null) {
            return MapsKt.emptyMap();
        }
        RetrieveBytesRequest retrieveBytesRequestA = new RetrieveBytesRequest.Builder().b(true).a();
        Intrinsics.checkNotNullExpressionValue(retrieveBytesRequestA, "Builder()\n            .s…rue)\n            .build()");
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
        cancellableContinuationImpl.C();
        blockstoreClient.retrieveBytes(retrieveBytesRequestA).addOnSuccessListener(new BlockstoreHelper$sam$com_google_android_gms_tasks_OnSuccessListener$0(new Function1<RetrieveBytesResponse, Unit>() { // from class: com.revenuecat.purchases.blockstore.BlockstoreHelper$getBlockstoreData$2$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((RetrieveBytesResponse) obj);
                return Unit.f139807a;
            }

            public final void invoke(RetrieveBytesResponse retrieveBytesResponse) {
                CancellableContinuationExtensionsKt.safeResume(cancellableContinuationImpl, retrieveBytesResponse.M());
            }
        })).addOnFailureListener(new OnFailureListener() { // from class: com.revenuecat.purchases.blockstore.BlockstoreHelper$getBlockstoreData$2$2
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception it) {
                Intrinsics.checkNotNullParameter(it, "it");
                CancellableContinuationExtensionsKt.safeResumeWithException(cancellableContinuationImpl, it);
            }
        });
        Object objV = cancellableContinuationImpl.v();
        if (objV == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return objV;
    }

    public final void aliasCurrentAndStoredUserIdsIfNeeded(Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        String currentAppUserID = this.identityManager.getCurrentAppUserID();
        if (IdentityManager.Companion.isUserIDAnonymous(currentAppUserID)) {
            BuildersKt__Builders_commonKt.d(this.ioScope, null, null, new AnonymousClass1(currentAppUserID, callback, null), 3, null);
        } else {
            aliasCurrentAndStoredUserIdsIfNeeded$callCompletion(this, callback);
        }
    }

    public final void clearUserIdBackupIfNeeded(Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        BlockstoreClient blockstoreClient = this.blockstoreClient;
        if (blockstoreClient == null) {
            callback.invoke();
            return;
        }
        DeleteBytesRequest deleteBytesRequestA = new DeleteBytesRequest.Builder().b(CollectionsKt.listOf(BLOCKSTORE_USER_ID_KEY)).a();
        Intrinsics.checkNotNullExpressionValue(deleteBytesRequestA, "Builder()\n            .s…EY))\n            .build()");
        BuildersKt__Builders_commonKt.d(this.ioScope, null, null, new C23321(blockstoreClient, deleteBytesRequestA, callback, null), 3, null);
    }

    public final void storeUserIdIfNeeded(CustomerInfo customerInfo) {
        Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
        if (this.blockstoreClient == null) {
            return;
        }
        String currentAppUserID = this.identityManager.getCurrentAppUserID();
        if (!IdentityManager.Companion.isUserIDAnonymous(currentAppUserID) || customerInfo.getAllPurchasedProductIds().isEmpty()) {
            return;
        }
        BuildersKt__Builders_commonKt.d(this.ioScope, null, null, new C23331(currentAppUserID, null), 3, null);
    }

    public /* synthetic */ BlockstoreHelper(Context context, IdentityManager identityManager, BlockstoreClient blockstoreClient, CoroutineScope coroutineScope, CoroutineScope coroutineScope2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, identityManager, (i3 & 4) != 0 ? Companion.initializeBlockstoreClient(context) : blockstoreClient, (i3 & 8) != 0 ? CoroutineScopeKt.a(SupervisorKt.b(null, 1, null).plus(Dispatchers.b().g0(1))) : coroutineScope, (i3 & 16) != 0 ? CoroutineScopeKt.a(SupervisorKt.b(null, 1, null).plus(Dispatchers.c())) : coroutineScope2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object storeUserIdIfNeeded(Map<String, ? extends RetrieveBytesResponse.BlockstoreData> map, final String str, Continuation<? super Unit> continuation) {
        BlockstoreClient blockstoreClient = this.blockstoreClient;
        if (blockstoreClient == null) {
            return Unit.f139807a;
        }
        if (map.get(BLOCKSTORE_USER_ID_KEY) != null) {
            LogLevel logLevel = LogLevel.DEBUG;
            LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
            if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                currentLogHandler.d("[Purchases] - " + logLevel.name(), "Block store: Not storing user id since there is one already present.");
            }
            return Unit.f139807a;
        }
        if (map.size() >= 16) {
            LogLevel logLevel2 = LogLevel.DEBUG;
            LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
            if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                currentLogHandler2.d("[Purchases] - " + logLevel2.name(), "Block store: Not storing user id since block store is already full.");
            }
            return Unit.f139807a;
        }
        LogLevel logLevel3 = LogLevel.DEBUG;
        LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
            currentLogHandler3.d("[Purchases] - " + logLevel3.name(), "Block store: Storing UserID: " + str + " in Block store.");
        }
        StoreBytesData.Builder builder = new StoreBytesData.Builder();
        byte[] bytes = str.getBytes(Charsets.f140510b);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        StoreBytesData storeBytesDataA = builder.b(bytes).c(BLOCKSTORE_USER_ID_KEY).d(true).a();
        Intrinsics.checkNotNullExpressionValue(storeBytesDataA, "Builder()\n            .s…rue)\n            .build()");
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
        cancellableContinuationImpl.C();
        blockstoreClient.storeBytes(storeBytesDataA).addOnSuccessListener(new BlockstoreHelper$sam$com_google_android_gms_tasks_OnSuccessListener$0(new Function1<Integer, Unit>() { // from class: com.revenuecat.purchases.blockstore.BlockstoreHelper$storeUserIdIfNeeded$6$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Integer) obj);
                return Unit.f139807a;
            }

            public final void invoke(Integer num) {
                String str2 = str;
                LogLevel logLevel4 = LogLevel.DEBUG;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    currentLogHandler4.d("[Purchases] - " + logLevel4.name(), "Block store: User ID: " + str2 + " stored in Block store.");
                }
                CancellableContinuationExtensionsKt.safeResume(cancellableContinuationImpl, Unit.f139807a);
            }
        })).addOnFailureListener(new OnFailureListener() { // from class: com.revenuecat.purchases.blockstore.BlockstoreHelper$storeUserIdIfNeeded$6$2
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception it) {
                Intrinsics.checkNotNullParameter(it, "it");
                CancellableContinuationExtensionsKt.safeResumeWithException(cancellableContinuationImpl, it);
            }
        });
        Object objV = cancellableContinuationImpl.v();
        if (objV == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return objV == IntrinsicsKt.f() ? objV : Unit.f139807a;
    }
}
