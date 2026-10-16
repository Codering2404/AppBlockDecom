package androidx.room.coroutines;

import androidx.room.Transactor;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

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
@DebugMetadata(c = "androidx.room.coroutines.PassthroughConnection$withTransaction$2", f = "PassthroughConnectionPool.kt", l = {103}, m = "invokeSuspend")
final class PassthroughConnection$withTransaction$2 extends SuspendLambda implements Function1<Continuation<? super Object>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f52559a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ PassthroughConnection f52560b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Transactor.SQLiteTransactionType f52561c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Function2 f52562d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PassthroughConnection$withTransaction$2(PassthroughConnection passthroughConnection, Transactor.SQLiteTransactionType sQLiteTransactionType, Function2 function2, Continuation continuation) {
        super(1, continuation);
        this.f52560b = passthroughConnection;
        this.f52561c = sQLiteTransactionType;
        this.f52562d = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new PassthroughConnection$withTransaction$2(this.f52560b, this.f52561c, this.f52562d, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Exception {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f52559a;
        if (i3 != 0) {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return obj;
        }
        ResultKt.b(obj);
        PassthroughConnection passthroughConnection = this.f52560b;
        Transactor.SQLiteTransactionType sQLiteTransactionType = this.f52561c;
        Function2 function2 = this.f52562d;
        this.f52559a = 1;
        Object objG = passthroughConnection.g(sQLiteTransactionType, function2, this);
        return objG == objF ? objF : objG;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((PassthroughConnection$withTransaction$2) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
