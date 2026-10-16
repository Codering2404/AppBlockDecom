package cz.mobilesoft.coreblock.scene.insights;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.insights.InsightsScreenHabitsListKt$UsageSection$1$1", f = "InsightsScreenHabitsList.kt", l = {}, m = "invokeSuspend", v = 1)
final class InsightsScreenHabitsListKt$UsageSection$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f102631a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ SnapshotStateMap f102632b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ MutableState f102633c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InsightsScreenHabitsListKt$UsageSection$1$1(SnapshotStateMap snapshotStateMap, MutableState mutableState, Continuation continuation) {
        super(2, continuation);
        this.f102632b = snapshotStateMap;
        this.f102633c = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new InsightsScreenHabitsListKt$UsageSection$1$1(this.f102632b, this.f102633c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.f();
        if (this.f102631a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        Integer num = (Integer) CollectionsKt.maxOrNull((Iterable) this.f102632b.values());
        int iIntValue = num != null ? num.intValue() : 0;
        if (iIntValue > InsightsScreenHabitsListKt.u(this.f102633c)) {
            InsightsScreenHabitsListKt.v(this.f102633c, iIntValue);
        }
        System.out.println((Object) ("Calculated Max Width Px: " + InsightsScreenHabitsListKt.u(this.f102633c)));
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((InsightsScreenHabitsListKt$UsageSection$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
