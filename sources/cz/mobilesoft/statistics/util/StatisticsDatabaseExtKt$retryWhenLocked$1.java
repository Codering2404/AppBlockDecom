package cz.mobilesoft.statistics.util;

import android.database.sqlite.SQLiteDatabaseLockedException;
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
@DebugMetadata(c = "cz.mobilesoft.statistics.util.StatisticsDatabaseExtKt$retryWhenLocked$1", f = "StatisticsDatabaseExt.kt", l = {27}, m = "invokeSuspend", v = 1)
final class StatisticsDatabaseExtKt$retryWhenLocked$1 extends SuspendLambda implements Function4<FlowCollector<Object>, Throwable, Long, Continuation<? super Boolean>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f133856a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f133857b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    /* synthetic */ long f133858c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ int f133859d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ long f133860f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StatisticsDatabaseExtKt$retryWhenLocked$1(int i3, long j3, Continuation continuation) {
        super(4, continuation);
        this.f133859d = i3;
        this.f133860f = j3;
    }

    public final Object h(FlowCollector flowCollector, Throwable th, long j3, Continuation continuation) {
        StatisticsDatabaseExtKt$retryWhenLocked$1 statisticsDatabaseExtKt$retryWhenLocked$1 = new StatisticsDatabaseExtKt$retryWhenLocked$1(this.f133859d, this.f133860f, continuation);
        statisticsDatabaseExtKt$retryWhenLocked$1.f133857b = th;
        statisticsDatabaseExtKt$retryWhenLocked$1.f133858c = j3;
        return statisticsDatabaseExtKt$retryWhenLocked$1.invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        return h((FlowCollector) obj, (Throwable) obj2, ((Number) obj3).longValue(), (Continuation) obj4);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Throwable th = (Throwable) this.f133857b;
        long j3 = this.f133858c;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f133856a;
        boolean z2 = true;
        if (i3 == 0) {
            ResultKt.b(obj);
            if (!(th instanceof SQLiteDatabaseLockedException) || j3 >= this.f133859d) {
                z2 = false;
            } else {
                long j4 = this.f133860f;
                this.f133857b = SpillingKt.a(th);
                this.f133858c = j3;
                this.f133856a = 1;
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
