package cz.mobilesoft.coreblock.util.helperextension;

import android.database.sqlite.SQLiteDatabaseLockedException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.FlowCollector;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.util.helperextension.DatabaseExtKt$retryWhenLocked$2", f = "DatabaseExt.kt", l = {}, m = "invokeSuspend", v = 1)
final class DatabaseExtKt$retryWhenLocked$2 extends SuspendLambda implements Function3<FlowCollector<Object>, Throwable, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f128511a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f128512b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Function1 f128513c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DatabaseExtKt$retryWhenLocked$2(Function1 function1, Continuation continuation) {
        super(3, continuation);
        this.f128513c = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Throwable th = (Throwable) this.f128512b;
        IntrinsicsKt.f();
        if (this.f128511a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        Function1 function1 = this.f128513c;
        if (function1 == null || !(th instanceof SQLiteDatabaseLockedException)) {
            throw th;
        }
        function1.invoke(th);
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(FlowCollector flowCollector, Throwable th, Continuation continuation) {
        DatabaseExtKt$retryWhenLocked$2 databaseExtKt$retryWhenLocked$2 = new DatabaseExtKt$retryWhenLocked$2(this.f128513c, continuation);
        databaseExtKt$retryWhenLocked$2.f128512b = th;
        return databaseExtKt$retryWhenLocked$2.invokeSuspend(Unit.f139807a);
    }
}
