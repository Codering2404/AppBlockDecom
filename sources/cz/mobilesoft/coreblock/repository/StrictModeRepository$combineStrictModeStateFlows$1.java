package cz.mobilesoft.coreblock.repository;

import cz.mobilesoft.coreblock.enums.StrictModeAccessMethod;
import cz.mobilesoft.coreblock.enums.StrictModeOption;
import cz.mobilesoft.coreblock.repository.StrictModeRepository;
import cz.mobilesoft.coreblock.scene.strictmode3.StrictModeStateDto;
import cz.mobilesoft.coreblock.storage.room.dto.blocking.ProfileWithIntervals;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function5;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.repository.StrictModeRepository$combineStrictModeStateFlows$1", f = "StrictModeRepository.kt", l = {}, m = "invokeSuspend", v = 1)
final class StrictModeRepository$combineStrictModeStateFlows$1 extends SuspendLambda implements Function5<List<? extends ProfileWithIntervals>, Triple<? extends StrictModeAccessMethod, ? extends List<? extends StrictModeAccessMethod>, ? extends List<? extends StrictModeOption>>, StrictModeRepository.AccessMethodConfigValues, StrictModeRepository.ExtraConfig, Continuation<? super StrictModeStateDto>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f98253a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f98254b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    /* synthetic */ Object f98255c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    /* synthetic */ Object f98256d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    /* synthetic */ Object f98257f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ StrictModeRepository f98258g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StrictModeRepository$combineStrictModeStateFlows$1(StrictModeRepository strictModeRepository, Continuation continuation) {
        super(5, continuation);
        this.f98258g = strictModeRepository;
    }

    @Override // kotlin.jvm.functions.Function5
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(List list, Triple triple, StrictModeRepository.AccessMethodConfigValues accessMethodConfigValues, StrictModeRepository.ExtraConfig extraConfig, Continuation continuation) {
        StrictModeRepository$combineStrictModeStateFlows$1 strictModeRepository$combineStrictModeStateFlows$1 = new StrictModeRepository$combineStrictModeStateFlows$1(this.f98258g, continuation);
        strictModeRepository$combineStrictModeStateFlows$1.f98254b = list;
        strictModeRepository$combineStrictModeStateFlows$1.f98255c = triple;
        strictModeRepository$combineStrictModeStateFlows$1.f98256d = accessMethodConfigValues;
        strictModeRepository$combineStrictModeStateFlows$1.f98257f = extraConfig;
        return strictModeRepository$combineStrictModeStateFlows$1.invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        List list = (List) this.f98254b;
        Triple triple = (Triple) this.f98255c;
        StrictModeRepository.AccessMethodConfigValues accessMethodConfigValues = (StrictModeRepository.AccessMethodConfigValues) this.f98256d;
        StrictModeRepository.ExtraConfig extraConfig = (StrictModeRepository.ExtraConfig) this.f98257f;
        IntrinsicsKt.f();
        if (this.f98253a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        StrictModeAccessMethod strictModeAccessMethod = (StrictModeAccessMethod) triple.a();
        List list2 = (List) triple.b();
        List list3 = (List) triple.c();
        boolean zContains = list2.contains(StrictModeAccessMethod.FollowSchedules);
        return new StrictModeStateDto(this.f98258g.c(list, zContains, StrictModeRepository.f98230m.a(list2, extraConfig.c())), list, strictModeAccessMethod, list2, this.f98258g.v(strictModeAccessMethod, accessMethodConfigValues), list3, accessMethodConfigValues.b(), accessMethodConfigValues.a(), extraConfig.a(), extraConfig.b());
    }
}
