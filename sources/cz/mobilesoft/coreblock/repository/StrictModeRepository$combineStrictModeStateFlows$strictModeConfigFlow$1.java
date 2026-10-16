package cz.mobilesoft.coreblock.repository;

import cz.mobilesoft.coreblock.enums.StrictModeAccessMethod;
import cz.mobilesoft.coreblock.enums.StrictModeOption;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function4;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.repository.StrictModeRepository$combineStrictModeStateFlows$strictModeConfigFlow$1", f = "StrictModeRepository.kt", l = {}, m = "invokeSuspend", v = 1)
final class StrictModeRepository$combineStrictModeStateFlows$strictModeConfigFlow$1 extends SuspendLambda implements Function4<StrictModeAccessMethod, List<? extends StrictModeAccessMethod>, List<? extends StrictModeOption>, Continuation<? super Triple<? extends StrictModeAccessMethod, ? extends List<? extends StrictModeAccessMethod>, ? extends List<? extends StrictModeOption>>>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f98270a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f98271b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    /* synthetic */ Object f98272c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    /* synthetic */ Object f98273d;

    StrictModeRepository$combineStrictModeStateFlows$strictModeConfigFlow$1(Continuation continuation) {
        super(4, continuation);
    }

    @Override // kotlin.jvm.functions.Function4
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(StrictModeAccessMethod strictModeAccessMethod, List list, List list2, Continuation continuation) {
        StrictModeRepository$combineStrictModeStateFlows$strictModeConfigFlow$1 strictModeRepository$combineStrictModeStateFlows$strictModeConfigFlow$1 = new StrictModeRepository$combineStrictModeStateFlows$strictModeConfigFlow$1(continuation);
        strictModeRepository$combineStrictModeStateFlows$strictModeConfigFlow$1.f98271b = strictModeAccessMethod;
        strictModeRepository$combineStrictModeStateFlows$strictModeConfigFlow$1.f98272c = list;
        strictModeRepository$combineStrictModeStateFlows$strictModeConfigFlow$1.f98273d = list2;
        return strictModeRepository$combineStrictModeStateFlows$strictModeConfigFlow$1.invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        StrictModeAccessMethod strictModeAccessMethod = (StrictModeAccessMethod) this.f98271b;
        List list = (List) this.f98272c;
        List list2 = (List) this.f98273d;
        IntrinsicsKt.f();
        if (this.f98270a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        return new Triple(strictModeAccessMethod, list, list2);
    }
}
