package androidx.room;

import java.util.concurrent.RejectedExecutionException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.ThreadContextElementKt;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata
final /* synthetic */ class RoomDatabaseKt__RoomDatabase_androidKt {
    public static final Object b(RoomDatabase roomDatabase, Function1 function1, Continuation continuation) {
        return (roomDatabase.inCompatibilityMode() && roomDatabase.isOpenInternal$room_runtime() && roomDatabase.inTransaction()) ? function1.invoke(continuation) : continuation.getContext().get(RoomExternalOperationElement.f52336a) == null ? function1.invoke(continuation) : RoomDatabaseKt.h(roomDatabase, function1, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CoroutineContext c(RoomDatabase roomDatabase, ContinuationInterceptor continuationInterceptor) {
        CoroutineContext coroutineContextPlus = continuationInterceptor.plus(new TransactionElement(continuationInterceptor));
        return coroutineContextPlus.plus(ThreadContextElementKt.a(roomDatabase.getSuspendingTransactionContext(), coroutineContextPlus));
    }

    private static final Object d(final RoomDatabase roomDatabase, final Function2 function2, Continuation continuation) {
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
        cancellableContinuationImpl.C();
        try {
            roomDatabase.getTransactionExecutor().execute(new Runnable() { // from class: androidx.room.RoomDatabaseKt__RoomDatabase_androidKt$startTransactionCoroutine$2$1

                /* JADX INFO: renamed from: androidx.room.RoomDatabaseKt__RoomDatabase_androidKt$startTransactionCoroutine$2$1$1, reason: invalid class name */
                /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                @Metadata
                @DebugMetadata(c = "androidx.room.RoomDatabaseKt__RoomDatabase_androidKt$startTransactionCoroutine$2$1$1", f = "RoomDatabase.android.kt", l = {2087}, m = "invokeSuspend")
                static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    int f52325a;

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    private /* synthetic */ Object f52326b;

                    /* JADX INFO: renamed from: c, reason: collision with root package name */
                    final /* synthetic */ RoomDatabase f52327c;

                    /* JADX INFO: renamed from: d, reason: collision with root package name */
                    final /* synthetic */ CancellableContinuation f52328d;

                    /* JADX INFO: renamed from: f, reason: collision with root package name */
                    final /* synthetic */ Function2 f52329f;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass1(RoomDatabase roomDatabase, CancellableContinuation cancellableContinuation, Function2 function2, Continuation continuation) {
                        super(2, continuation);
                        this.f52327c = roomDatabase;
                        this.f52328d = cancellableContinuation;
                        this.f52329f = function2;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation create(Object obj, Continuation continuation) {
                        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f52327c, this.f52328d, this.f52329f, continuation);
                        anonymousClass1.f52326b = obj;
                        return anonymousClass1;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) throws Throwable {
                        Continuation continuation;
                        Object objF = IntrinsicsKt.f();
                        int i3 = this.f52325a;
                        if (i3 == 0) {
                            ResultKt.b(obj);
                            CoroutineContext.Element element = ((CoroutineScope) this.f52326b).getCoroutineContext().get(ContinuationInterceptor.t8);
                            Intrinsics.checkNotNull(element);
                            CoroutineContext coroutineContextC = RoomDatabaseKt__RoomDatabase_androidKt.c(this.f52327c, (ContinuationInterceptor) element);
                            CancellableContinuation cancellableContinuation = this.f52328d;
                            Result.Companion companion = Result.f139772b;
                            Function2 function2 = this.f52329f;
                            this.f52326b = cancellableContinuation;
                            this.f52325a = 1;
                            obj = BuildersKt.g(coroutineContextC, function2, this);
                            if (obj == objF) {
                                return objF;
                            }
                            continuation = cancellableContinuation;
                        } else {
                            if (i3 != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            continuation = (Continuation) this.f52326b;
                            ResultKt.b(obj);
                        }
                        continuation.resumeWith(Result.b(obj));
                        return Unit.f139807a;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                        return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
                    }
                }

                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        BuildersKt.e(cancellableContinuationImpl.getContext().minusKey(ContinuationInterceptor.t8), new AnonymousClass1(roomDatabase, cancellableContinuationImpl, function2, null));
                    } catch (Throwable th) {
                        cancellableContinuationImpl.cancel(th);
                    }
                }
            });
        } catch (RejectedExecutionException e3) {
            cancellableContinuationImpl.cancel(new IllegalStateException("Unable to acquire a thread to perform the database transaction.", e3));
        }
        Object objV = cancellableContinuationImpl.v();
        if (objV == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return objV;
    }

    public static final Object e(RoomDatabase roomDatabase, Function1 function1, Continuation continuation) {
        return RoomDatabaseKt.h(roomDatabase, new RoomDatabaseKt__RoomDatabase_androidKt$withTransaction$2(roomDatabase, function1, null), continuation);
    }

    public static final Object f(RoomDatabase roomDatabase, Function1 function1, Continuation continuation) {
        RoomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1 roomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1 = new RoomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1(function1, null);
        TransactionElement transactionElement = (TransactionElement) continuation.getContext().get(TransactionElement.f52383b);
        ContinuationInterceptor continuationInterceptorD = transactionElement != null ? transactionElement.d() : null;
        return continuationInterceptorD != null ? BuildersKt.g(continuationInterceptorD, roomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1, continuation) : d(roomDatabase, roomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1, continuation);
    }
}
