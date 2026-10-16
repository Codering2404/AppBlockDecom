package com.superwall.sdk.storage;

import android.content.Context;
import com.facebook.share.HKJ.pnxuebdT;
import com.superwall.sdk.Superwall;
import com.superwall.sdk.logger.LogLevel;
import com.superwall.sdk.logger.LogScope;
import com.superwall.sdk.logger.Logger;
import com.superwall.sdk.misc.Either;
import com.superwall.sdk.misc.EitherKt;
import com.superwall.sdk.storage.Cache;
import com.superwall.sdk.storage.memory.LRUCache;
import com.superwall.sdk.storage.memory.PerpetualCache;
import com.superwall.sdk.utilities.ErrorTrackingKt;
import java.io.File;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.serialization.json.Json;

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
public final class Cache implements CoroutineScope {
    public static final Companion Companion = new Companion(null);
    private static final String appSpecificDocumentDirectoryPrefix = "com.superwall.document.appSpecific.Store";
    private static final String cacheDirectoryPrefix = "com.superwall.cache.Store";
    private static final long defaultMaxCachePeriodInSecond = 604800;
    private static final String ioQueuePrefix = "com.superwall.queue.Store";
    private static final String userSpecificDocumentDirectoryPrefix = "com.superwall.document.userSpecific.Store";
    private final /* synthetic */ CoroutineScope $$delegate_0;
    private final Context context;
    private final CoroutineContext ioQueue;
    private final Json json;
    private final LRUCache<String, Object> memCache;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.storage.Cache$cleanDiskCache$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.storage.Cache$cleanDiskCache$1", f = "Cache.kt", l = {}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$2(Throwable th) {
            Logger.debug$default(Logger.INSTANCE, LogLevel.error, LogScope.cache, "Unable to clean disk cache", (Map) null, th, 8, (Object) null);
            return Unit.f139807a;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return Cache.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Either failure;
            File[] fileArrListFiles;
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            try {
                File cacheDir = Cache.this.getContext().getCacheDir();
                if (cacheDir.exists() && (fileArrListFiles = cacheDir.listFiles()) != null) {
                    for (File file : fileArrListFiles) {
                        file.delete();
                    }
                }
                failure = new Either.Success(Unit.f139807a);
            } catch (Throwable th) {
                if (ErrorTrackingKt.shouldLog(th)) {
                    Superwall.Companion companion = Superwall.Companion;
                    if (companion.getInitialized()) {
                        ErrorTrackingKt.trackError(companion.getInstance(), th);
                    }
                }
                failure = new Either.Failure(th);
            }
            EitherKt.onError(failure, new Function1() { // from class: com.superwall.sdk.storage.a
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return Cache.AnonymousClass1.invokeSuspend$lambda$2((Throwable) obj2);
                }
            });
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.storage.Cache$delete$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.storage.Cache$delete$1", f = "Cache.kt", l = {}, m = "invokeSuspend")
    static final class C28981 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Storable<T> $storable;
        int label;
        final /* synthetic */ Cache this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C28981(Storable<T> storable, Cache cache, Continuation<? super C28981> continuation) {
            super(2, continuation);
            this.$storable = storable;
            this.this$0 = cache;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C28981(this.$storable, this.this$0, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            Storable<T> storable = this.$storable;
            try {
                try {
                    File file = storable.file(this.this$0.getContext());
                    if (file.exists()) {
                        file.delete();
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                    Logger.debug$default(Logger.INSTANCE, LogLevel.error, LogScope.cache, "Unable to delete key: " + storable.getKey(), (Map) null, th, 8, (Object) null);
                }
                new Either.Success(Unit.f139807a);
            } catch (Throwable th2) {
                if (ErrorTrackingKt.shouldLog(th2)) {
                    Superwall.Companion companion = Superwall.Companion;
                    if (companion.getInitialized()) {
                        ErrorTrackingKt.trackError(companion.getInstance(), th2);
                    }
                }
                new Either.Failure(th2);
            }
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C28981) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.storage.Cache$write$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.storage.Cache$write$1", f = "Cache.kt", l = {}, m = "invokeSuspend")
    static final class C28991 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ T $data;
        final /* synthetic */ Storable<T> $storable;
        int label;
        final /* synthetic */ Cache this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C28991(Storable<T> storable, Cache cache, T t2, Continuation<? super C28991> continuation) {
            super(2, continuation);
            this.$storable = storable;
            this.this$0 = cache;
            this.$data = t2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C28991(this.$storable, this.this$0, this.$data, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            try {
                FilesKt.i(this.$storable.file(this.this$0.getContext()), this.this$0.json.b(this.$storable.getSerializer(), this.$data), Charsets.f140510b);
            } catch (Throwable th) {
                Logger.debug$default(Logger.INSTANCE, LogLevel.error, LogScope.cache, "Unable to write key: " + this.$storable.getKey(), (Map) null, th, 8, (Object) null);
            }
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C28991) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    public Cache(Context context, CoroutineContext ioQueue, Json json) {
        Intrinsics.checkNotNullParameter(context, pnxuebdT.TBCJaPAZkLcvAn);
        Intrinsics.checkNotNullParameter(ioQueue, "ioQueue");
        Intrinsics.checkNotNullParameter(json, "json");
        this.$$delegate_0 = CoroutineScopeKt.a(ioQueue);
        this.context = context;
        this.ioQueue = ioQueue;
        this.json = json;
        this.memCache = new LRUCache<>(new PerpetualCache(), 1000);
    }

    private final void cleanDiskCache() {
        BuildersKt__Builders_commonKt.d(this, null, null, new AnonymousClass1(null), 3, null);
    }

    public final void clean() {
        this.memCache.clear();
        cleanDiskCache();
    }

    public final <T> void delete(Storable<T> storable) {
        Intrinsics.checkNotNullParameter(storable, "storable");
        this.memCache.remove(storable.getKey());
        BuildersKt__Builders_commonKt.d(this, null, null, new C28981(storable, this, null), 3, null);
    }

    public final Context getContext() {
        return this.context;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.$$delegate_0.getCoroutineContext();
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final <T> T read(Storable<T> storable) {
        Intrinsics.checkNotNullParameter(storable, "storable");
        T t2 = null;
        try {
            Object obj = this.memCache.get(storable.getKey());
            if (obj != null) {
                t2 = (T) obj;
            }
        } catch (ClassCastException e3) {
            this.memCache.remove(storable.getKey());
            Logger.debug$default(Logger.INSTANCE, LogLevel.error, LogScope.cache, "ClassCastException reading from memory cache for key: " + storable.getKey(), (Map) null, e3, 8, (Object) null);
        }
        if (t2 == null) {
            File file = storable.file(this.context);
            if (file.exists()) {
                String strF = "";
                try {
                    strF = FilesKt.f(file, Charsets.f140510b);
                    t2 = (T) this.json.d(storable.getSerializer(), strF);
                    if (t2 != null) {
                        this.memCache.set(storable.getKey(), t2);
                        Unit unit = Unit.f139807a;
                    }
                } catch (Throwable th) {
                    Logger.debug$default(Logger.INSTANCE, LogLevel.error, LogScope.cache, "Unable to read key: " + storable.getKey() + ", got " + strF, (Map) null, th, 8, (Object) null);
                    Unit unit2 = Unit.f139807a;
                }
            }
        }
        return t2;
    }

    public final <T> void write(Storable<T> storable, T data) {
        Intrinsics.checkNotNullParameter(storable, "storable");
        Intrinsics.checkNotNullParameter(data, "data");
        this.memCache.set(storable.getKey(), data);
        BuildersKt__Builders_commonKt.d(this, null, null, new C28991(storable, this, data, null), 3, null);
    }

    public /* synthetic */ Cache(Context context, CoroutineContext coroutineContext, Json json, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? CoroutineDispatcher.q0(Dispatchers.b(), 1, null, 2, null) : coroutineContext, json);
    }
}
