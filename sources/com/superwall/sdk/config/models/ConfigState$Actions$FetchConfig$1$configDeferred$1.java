package com.superwall.sdk.config.models;

import com.superwall.sdk.config.ConfigContext;
import com.superwall.sdk.config.models.ConfigState;
import com.superwall.sdk.misc.Either;
import com.superwall.sdk.models.config.Config;
import com.superwall.sdk.models.config.FeatureFlags;
import com.superwall.sdk.network.NetworkError;
import com.superwall.sdk.network.SuperwallAPI;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;

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
@DebugMetadata(c = "com.superwall.sdk.config.models.ConfigState$Actions$FetchConfig$1$configDeferred$1", f = "ConfigState.kt", l = {95, 118}, m = "invokeSuspend")
final class ConfigState$Actions$FetchConfig$1$configDeferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Either<? extends Config, NetworkError>>, Object> {
    final /* synthetic */ ConfigContext $$this$exec;
    final /* synthetic */ long $cacheLimit;
    final /* synthetic */ Ref.LongRef $configDuration;
    final /* synthetic */ AtomicInteger $configRetryCount;
    final /* synthetic */ Ref.BooleanRef $isConfigFromCache;
    final /* synthetic */ Config $oldConfig;
    long J$0;
    int label;

    /* JADX INFO: renamed from: com.superwall.sdk.config.models.ConfigState$Actions$FetchConfig$1$configDeferred$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.config.models.ConfigState$Actions$FetchConfig$1$configDeferred$1$1", f = "ConfigState.kt", l = {97}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Either<? extends Config, NetworkError>>, Object> {
        final /* synthetic */ ConfigContext $$this$exec;
        final /* synthetic */ AtomicInteger $configRetryCount;
        final /* synthetic */ Ref.BooleanRef $isConfigFromCache;
        final /* synthetic */ Config $oldConfig;
        int label;

        /* JADX INFO: renamed from: com.superwall.sdk.config.models.ConfigState$Actions$FetchConfig$1$configDeferred$1$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "com.superwall.sdk.config.models.ConfigState$Actions$FetchConfig$1$configDeferred$1$1$1", f = "ConfigState.kt", l = {100}, m = "invokeSuspend")
        static final class C02341 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
            final /* synthetic */ ConfigContext $$this$exec;
            final /* synthetic */ AtomicInteger $configRetryCount;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C02341(ConfigContext configContext, AtomicInteger atomicInteger, Continuation<? super C02341> continuation) {
                super(1, continuation);
                this.$$this$exec = configContext;
                this.$configRetryCount = atomicInteger;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new C02341(this.$$this$exec, this.$configRetryCount, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objF = IntrinsicsKt.f();
                int i3 = this.label;
                if (i3 == 0) {
                    ResultKt.b(obj);
                    this.$$this$exec.update(ConfigState.Updates.SetRetrying.INSTANCE);
                    this.$configRetryCount.incrementAndGet();
                    Function1<Continuation<? super Unit>, Object> awaitUtilNetwork = this.$$this$exec.getAwaitUtilNetwork();
                    this.label = 1;
                    if (awaitUtilNetwork.invoke(this) == objF) {
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
                return ((C02341) create(continuation)).invokeSuspend(Unit.f139807a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ConfigContext configContext, AtomicInteger atomicInteger, Ref.BooleanRef booleanRef, Config config, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$$this$exec = configContext;
            this.$configRetryCount = atomicInteger;
            this.$isConfigFromCache = booleanRef;
            this.$oldConfig = config;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$$this$exec, this.$configRetryCount, this.$isConfigFromCache, this.$oldConfig, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                SuperwallAPI network = this.$$this$exec.getNetwork();
                C02341 c02341 = new C02341(this.$$this$exec, this.$configRetryCount, null);
                this.label = 1;
                obj = network.getConfig(c02341, this);
                if (obj == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            Either either = (Either) obj;
            Ref.BooleanRef booleanRef = this.$isConfigFromCache;
            Config config = this.$oldConfig;
            if (!(either instanceof Either.Failure)) {
                return either;
            }
            booleanRef.f140137a = true;
            return new Either.Success(config);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Either<Config, NetworkError>> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.config.models.ConfigState$Actions$FetchConfig$1$configDeferred$1$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.config.models.ConfigState$Actions$FetchConfig$1$configDeferred$1$3", f = "ConfigState.kt", l = {121}, m = "invokeSuspend")
    static final class AnonymousClass3 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ ConfigContext $$this$exec;
        final /* synthetic */ AtomicInteger $configRetryCount;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(ConfigContext configContext, AtomicInteger atomicInteger, Continuation<? super AnonymousClass3> continuation) {
            super(1, continuation);
            this.$$this$exec = configContext;
            this.$configRetryCount = atomicInteger;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass3(this.$$this$exec, this.$configRetryCount, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                this.$$this$exec.update(ConfigState.Updates.SetRetrying.INSTANCE);
                this.$configRetryCount.incrementAndGet();
                Function1<Continuation<? super Unit>, Object> awaitUtilNetwork = this.$$this$exec.getAwaitUtilNetwork();
                this.label = 1;
                if (awaitUtilNetwork.invoke(this) == objF) {
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ConfigState$Actions$FetchConfig$1$configDeferred$1(Config config, long j3, ConfigContext configContext, AtomicInteger atomicInteger, Ref.BooleanRef booleanRef, Ref.LongRef longRef, Continuation<? super ConfigState$Actions$FetchConfig$1$configDeferred$1> continuation) {
        super(2, continuation);
        this.$oldConfig = config;
        this.$cacheLimit = j3;
        this.$$this$exec = configContext;
        this.$configRetryCount = atomicInteger;
        this.$isConfigFromCache = booleanRef;
        this.$configDuration = longRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ConfigState$Actions$FetchConfig$1$configDeferred$1(this.$oldConfig, this.$cacheLimit, this.$$this$exec, this.$configRetryCount, this.$isConfigFromCache, this.$configDuration, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        long j3;
        FeatureFlags featureFlags;
        Throwable th;
        long j4;
        Either success;
        Object objF = IntrinsicsKt.f();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.b(obj);
            long jCurrentTimeMillis = System.currentTimeMillis();
            Config config = this.$oldConfig;
            if (config == null || (featureFlags = config.getFeatureFlags()) == null || !featureFlags.getEnableConfigRefresh()) {
                SuperwallAPI network = this.$$this$exec.getNetwork();
                AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.$$this$exec, this.$configRetryCount, null);
                this.J$0 = jCurrentTimeMillis;
                this.label = 2;
                obj = network.getConfig(anonymousClass3, this);
                if (obj != objF) {
                    j3 = jCurrentTimeMillis;
                    success = (Either) obj;
                    j4 = j3;
                }
            } else {
                try {
                    long j5 = this.$cacheLimit;
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$$this$exec, this.$configRetryCount, this.$isConfigFromCache, this.$oldConfig, null);
                    this.J$0 = jCurrentTimeMillis;
                    this.label = 1;
                    obj = TimeoutKt.d(j5, anonymousClass1, this);
                    if (obj != objF) {
                        j4 = jCurrentTimeMillis;
                        success = (Either) obj;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    j4 = jCurrentTimeMillis;
                    th.printStackTrace();
                    Config config2 = this.$oldConfig;
                    this.$isConfigFromCache.f140137a = true;
                    success = new Either.Success(config2);
                }
            }
            return objF;
        }
        if (i3 == 1) {
            j4 = this.J$0;
            try {
                ResultKt.b(obj);
                success = (Either) obj;
            } catch (Throwable th3) {
                th = th3;
                th.printStackTrace();
                Config config22 = this.$oldConfig;
                this.$isConfigFromCache.f140137a = true;
                success = new Either.Success(config22);
            }
        } else {
            if (i3 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            j3 = this.J$0;
            ResultKt.b(obj);
            success = (Either) obj;
            j4 = j3;
        }
        this.$configDuration.f140143a = System.currentTimeMillis() - j4;
        return success;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Either<Config, NetworkError>> continuation) {
        return ((ConfigState$Actions$FetchConfig$1$configDeferred$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
