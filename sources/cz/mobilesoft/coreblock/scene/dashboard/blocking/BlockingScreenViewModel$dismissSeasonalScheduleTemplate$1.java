package cz.mobilesoft.coreblock.scene.dashboard.blocking;

import cz.mobilesoft.coreblock.enums.ScheduleTemplate;
import cz.mobilesoft.coreblock.storage.datastore.CoreDataStore;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$dismissSeasonalScheduleTemplate$1", f = "BlockingScreenViewModel.kt", l = {1031}, m = "invokeSuspend", v = 1)
final class BlockingScreenViewModel$dismissSeasonalScheduleTemplate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f99697a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f99698b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f99699c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ ScheduleTemplate f99700d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ BlockingScreenViewModel f99701f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BlockingScreenViewModel$dismissSeasonalScheduleTemplate$1(ScheduleTemplate scheduleTemplate, BlockingScreenViewModel blockingScreenViewModel, Continuation continuation) {
        super(2, continuation);
        this.f99700d = scheduleTemplate;
        this.f99701f = blockingScreenViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new BlockingScreenViewModel$dismissSeasonalScheduleTemplate$1(this.f99700d, this.f99701f, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f99699c;
        if (i3 == 0) {
            ResultKt.b(obj);
            String seasonalTemplateId = this.f99700d.getSeasonalTemplateId();
            if (seasonalTemplateId != null) {
                CoreDataStore coreDataStoreW1 = this.f99701f.W1();
                this.f99697a = SpillingKt.a(seasonalTemplateId);
                this.f99698b = 0;
                this.f99699c = 1;
                if (coreDataStoreW1.P4(seasonalTemplateId, this) == objF) {
                    return objF;
                }
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((BlockingScreenViewModel$dismissSeasonalScheduleTemplate$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
