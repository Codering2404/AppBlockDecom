package androidx.room.paging;

import androidx.paging.PagingSource;
import androidx.room.RoomDatabase;
import androidx.room.RoomRawQuery;
import androidx.room.TransactionScope;
import androidx.room.Transactor;
import androidx.room.paging.util.RoomPagingUtil;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Add missing generic type declarations: [Value] */
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
@DebugMetadata(c = "androidx.room.paging.CommonLimitOffsetImpl$initialLoad$2", f = "LimitOffsetPagingSource.kt", l = {124}, m = "invokeSuspend")
final class CommonLimitOffsetImpl$initialLoad$2<Value> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super PagingSource.LoadResult<Integer, Value>>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f52679a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ CommonLimitOffsetImpl f52680b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ PagingSource.LoadParams f52681c;

    /* JADX INFO: renamed from: androidx.room.paging.CommonLimitOffsetImpl$initialLoad$2$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "androidx.room.paging.CommonLimitOffsetImpl$initialLoad$2$1", f = "LimitOffsetPagingSource.kt", l = {126}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function2<Transactor, Continuation<? super PagingSource.LoadResult<Integer, Value>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f52682a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f52683b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ CommonLimitOffsetImpl f52684c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ PagingSource.LoadParams f52685d;

        /* JADX INFO: renamed from: androidx.room.paging.CommonLimitOffsetImpl$initialLoad$2$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "androidx.room.paging.CommonLimitOffsetImpl$initialLoad$2$1$1", f = "LimitOffsetPagingSource.kt", l = {127, 129}, m = "invokeSuspend")
        static final class C00871 extends SuspendLambda implements Function2<TransactionScope<PagingSource.LoadResult<Integer, Value>>, Continuation<? super PagingSource.LoadResult<Integer, Value>>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f52686a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ CommonLimitOffsetImpl f52687b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ PagingSource.LoadParams f52688c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00871(CommonLimitOffsetImpl commonLimitOffsetImpl, PagingSource.LoadParams loadParams, Continuation continuation) {
                super(2, continuation);
                this.f52687b = commonLimitOffsetImpl;
                this.f52688c = loadParams;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                return new C00871(this.f52687b, this.f52688c, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
            public final Object invoke(TransactionScope transactionScope, Continuation continuation) {
                return ((C00871) create(transactionScope, continuation)).invokeSuspend(Unit.f139807a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objF = IntrinsicsKt.f();
                int i3 = this.f52686a;
                if (i3 == 0) {
                    ResultKt.b(obj);
                    RoomRawQuery roomRawQuery = this.f52687b.f52672e;
                    RoomDatabase roomDatabase = this.f52687b.f52671d;
                    this.f52686a = 1;
                    obj = RoomPagingUtil.e(roomRawQuery, roomDatabase, this);
                    if (obj != objF) {
                    }
                }
                if (i3 != 1) {
                    if (i3 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                    return obj;
                }
                ResultKt.b(obj);
                int iIntValue = ((Number) obj).intValue();
                this.f52687b.j().set(iIntValue);
                PagingSource.LoadParams loadParams = this.f52688c;
                RoomRawQuery roomRawQuery2 = this.f52687b.f52672e;
                Function3 function3 = this.f52687b.f52670c;
                this.f52686a = 2;
                Object objD = RoomPagingUtil.d(loadParams, roomRawQuery2, iIntValue, function3, this);
                return objD == objF ? objF : objD;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(CommonLimitOffsetImpl commonLimitOffsetImpl, PagingSource.LoadParams loadParams, Continuation continuation) {
            super(2, continuation);
            this.f52684c = commonLimitOffsetImpl;
            this.f52685d = loadParams;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f52684c, this.f52685d, continuation);
            anonymousClass1.f52683b = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public final Object invoke(Transactor transactor, Continuation continuation) {
            return ((AnonymousClass1) create(transactor, continuation)).invokeSuspend(Unit.f139807a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f52682a;
            if (i3 != 0) {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                return obj;
            }
            ResultKt.b(obj);
            Transactor transactor = (Transactor) this.f52683b;
            Transactor.SQLiteTransactionType sQLiteTransactionType = Transactor.SQLiteTransactionType.f52389a;
            C00871 c00871 = new C00871(this.f52684c, this.f52685d, null);
            this.f52682a = 1;
            Object objA = transactor.a(sQLiteTransactionType, c00871, this);
            return objA == objF ? objF : objA;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CommonLimitOffsetImpl$initialLoad$2(CommonLimitOffsetImpl commonLimitOffsetImpl, PagingSource.LoadParams loadParams, Continuation continuation) {
        super(2, continuation);
        this.f52680b = commonLimitOffsetImpl;
        this.f52681c = loadParams;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new CommonLimitOffsetImpl$initialLoad$2(this.f52680b, this.f52681c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f52679a;
        if (i3 != 0) {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return obj;
        }
        ResultKt.b(obj);
        RoomDatabase roomDatabase = this.f52680b.f52671d;
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f52680b, this.f52681c, null);
        this.f52679a = 1;
        Object objUseConnection = roomDatabase.useConnection(true, anonymousClass1, this);
        return objUseConnection == objF ? objF : objUseConnection;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((CommonLimitOffsetImpl$initialLoad$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
