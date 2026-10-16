package cz.mobilesoft.coreblock.repository;

import cz.mobilesoft.coreblock.storage.room.dto.blocking.ProfileWithIntervals;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.repository.StrictModeRepository$combineStrictModeStateFlows$profilesWithTriggerFlow$1", f = "StrictModeRepository.kt", l = {}, m = "invokeSuspend", v = 1)
final class StrictModeRepository$combineStrictModeStateFlows$profilesWithTriggerFlow$1 extends SuspendLambda implements Function3<List<? extends ProfileWithIntervals>, Integer, Continuation<? super List<? extends ProfileWithIntervals>>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f98268a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f98269b;

    StrictModeRepository$combineStrictModeStateFlows$profilesWithTriggerFlow$1(Continuation continuation) {
        super(3, continuation);
    }

    public final Object h(List list, int i3, Continuation continuation) {
        StrictModeRepository$combineStrictModeStateFlows$profilesWithTriggerFlow$1 strictModeRepository$combineStrictModeStateFlows$profilesWithTriggerFlow$1 = new StrictModeRepository$combineStrictModeStateFlows$profilesWithTriggerFlow$1(continuation);
        strictModeRepository$combineStrictModeStateFlows$profilesWithTriggerFlow$1.f98269b = list;
        return strictModeRepository$combineStrictModeStateFlows$profilesWithTriggerFlow$1.invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return h((List) obj, ((Number) obj2).intValue(), (Continuation) obj3);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        List list = (List) this.f98269b;
        IntrinsicsKt.f();
        if (this.f98268a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        return list;
    }
}
