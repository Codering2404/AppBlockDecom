package cz.mobilesoft.coreblock.scene.schedule;

import cz.mobilesoft.coreblock.repository.ScheduleRepository;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile;
import cz.mobilesoft.coreblock.util.profile.ProfileToViewDTOHelperKt;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$onScheduleChangedInDB$1", f = "ScheduleViewModel.kt", l = {1216, 1217}, m = "invokeSuspend", v = 1)
final class ScheduleViewModel$onScheduleChangedInDB$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f114930a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f114931b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    long f114932c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f114933d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f114934f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f114935g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ ScheduleViewModel f114936h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ScheduleViewModel$onScheduleChangedInDB$1(ScheduleViewModel scheduleViewModel, Continuation continuation) {
        super(2, continuation);
        this.f114936h = scheduleViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new ScheduleViewModel$onScheduleChangedInDB$1(this.f114936h, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        ScheduleViewModel scheduleViewModel;
        long jLongValue;
        Object objE;
        int i3;
        Object objT;
        ScheduleViewModel scheduleViewModel2;
        Object objF = IntrinsicsKt.f();
        int i4 = this.f114935g;
        if (i4 == 0) {
            ResultKt.b(obj);
            Long lO = this.f114936h.R2().o();
            if (lO != null) {
                scheduleViewModel = this.f114936h;
                jLongValue = lO.longValue();
                ProfileDao profileDaoH3 = scheduleViewModel.h3();
                this.f114930a = scheduleViewModel;
                this.f114932c = jLongValue;
                this.f114933d = 0;
                this.f114935g = 1;
                objE = profileDaoH3.e(jLongValue, this);
                if (objE != objF) {
                    i3 = 0;
                }
                return objF;
            }
            return Unit.f139807a;
        }
        if (i4 != 1) {
            if (i4 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            scheduleViewModel2 = (ScheduleViewModel) this.f114930a;
            ResultKt.b(obj);
            objT = obj;
            ScheduleDTO scheduleDTO = (ScheduleDTO) objT;
            scheduleViewModel2.N = scheduleDTO;
            scheduleViewModel2.O = ProfileToViewDTOHelperKt.x(scheduleDTO, scheduleViewModel2.f114592r.J());
            scheduleViewModel2.T.setValue(ScheduleDTO.b(scheduleDTO, null, null, false, false, false, false, false, false, 0, null, null, null, null, null, null, null, null, null, null, null, null, false, false, false, 0L, 0L, null, false, null, 536870911, null));
            return Unit.f139807a;
        }
        int i5 = this.f114933d;
        long j3 = this.f114932c;
        ScheduleViewModel scheduleViewModel3 = (ScheduleViewModel) this.f114930a;
        ResultKt.b(obj);
        scheduleViewModel = scheduleViewModel3;
        jLongValue = j3;
        i3 = i5;
        objE = obj;
        Profile profile = (Profile) objE;
        if (profile != null) {
            ScheduleRepository scheduleRepository = ScheduleRepository.f97962a;
            this.f114930a = scheduleViewModel;
            this.f114931b = SpillingKt.a(profile);
            this.f114932c = jLongValue;
            this.f114933d = i3;
            this.f114934f = 0;
            this.f114935g = 2;
            objT = scheduleRepository.T(profile, this);
            if (objT != objF) {
                scheduleViewModel2 = scheduleViewModel;
                ScheduleDTO scheduleDTO2 = (ScheduleDTO) objT;
                scheduleViewModel2.N = scheduleDTO2;
                scheduleViewModel2.O = ProfileToViewDTOHelperKt.x(scheduleDTO2, scheduleViewModel2.f114592r.J());
                scheduleViewModel2.T.setValue(ScheduleDTO.b(scheduleDTO2, null, null, false, false, false, false, false, false, 0, null, null, null, null, null, null, null, null, null, null, null, null, false, false, false, 0L, 0L, null, false, null, 536870911, null));
            }
            return objF;
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((ScheduleViewModel$onScheduleChangedInDB$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
