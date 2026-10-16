package cz.mobilesoft.coreblock.util.helperextension;

import android.database.sqlite.SQLiteDatabaseLockedException;
import android.util.Log;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DelayKt;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.util.helperextension.DatabaseExtKt$retryWhenLocked$1", f = "DatabaseExt.kt", l = {86}, m = "invokeSuspend", v = 1)
final class DatabaseExtKt$retryWhenLocked$1 extends SuspendLambda implements Function4<FlowCollector<Object>, Throwable, Long, Continuation<? super Boolean>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f128505a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f128506b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    /* synthetic */ Object f128507c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    /* synthetic */ long f128508d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ int f128509f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ long f128510g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DatabaseExtKt$retryWhenLocked$1(int i3, long j3, Continuation continuation) {
        super(4, continuation);
        this.f128509f = i3;
        this.f128510g = j3;
    }

    public final Object h(FlowCollector flowCollector, Throwable th, long j3, Continuation continuation) {
        DatabaseExtKt$retryWhenLocked$1 databaseExtKt$retryWhenLocked$1 = new DatabaseExtKt$retryWhenLocked$1(this.f128509f, this.f128510g, continuation);
        databaseExtKt$retryWhenLocked$1.f128506b = flowCollector;
        databaseExtKt$retryWhenLocked$1.f128507c = th;
        databaseExtKt$retryWhenLocked$1.f128508d = j3;
        return databaseExtKt$retryWhenLocked$1.invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        return h((FlowCollector) obj, (Throwable) obj2, ((Number) obj3).longValue(), (Continuation) obj4);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        FlowCollector flowCollector = (FlowCollector) this.f128506b;
        Throwable th = (Throwable) this.f128507c;
        long j3 = this.f128508d;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f128505a;
        boolean z2 = true;
        if (i3 == 0) {
            ResultKt.b(obj);
            if (!(th instanceof SQLiteDatabaseLockedException) || j3 >= this.f128509f) {
                z2 = false;
            } else {
                String simpleName = FlowCollector.class.getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
                Log.e(simpleName, "Database locked, retrying");
                long j4 = this.f128510g;
                this.f128506b = SpillingKt.a(flowCollector);
                this.f128507c = SpillingKt.a(th);
                this.f128508d = j3;
                this.f128505a = 1;
                if (DelayKt.b(j4, this) == objF) {
                    return objF;
                }
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Boxing.a(z2);
    }
}
