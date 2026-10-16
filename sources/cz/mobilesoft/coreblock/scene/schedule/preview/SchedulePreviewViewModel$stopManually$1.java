package cz.mobilesoft.coreblock.scene.schedule.preview;

import com.facebook.internal.FacebookRequestErrorClassification;
import cz.mobilesoft.coreblock.scene.dashboard.blocking.ProfileViewDTO;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel$stopManually$1", f = "SchedulePreviewViewModel.kt", l = {488, FacebookRequestErrorClassification.ESC_APP_INACTIVE, 494}, m = "invokeSuspend", v = 1)
final class SchedulePreviewViewModel$stopManually$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f117562a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f117563b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ SchedulePreviewViewModel f117564c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ ProfileViewDTO f117565d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SchedulePreviewViewModel$stopManually$1(SchedulePreviewViewModel schedulePreviewViewModel, ProfileViewDTO profileViewDTO, Continuation continuation) {
        super(2, continuation);
        this.f117564c = schedulePreviewViewModel;
        this.f117565d = profileViewDTO;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new SchedulePreviewViewModel$stopManually$1(this.f117564c, this.f117565d, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0088, code lost:
    
        if (r8.S(r3, r7) != r0) goto L25;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) throws java.lang.Throwable {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r7.f117563b
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L2e
            if (r1 == r4) goto L2a
            if (r1 == r3) goto L22
            if (r1 != r2) goto L1a
            java.lang.Object r0 = r7.f117562a
            cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile r0 = (cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile) r0
            kotlin.ResultKt.b(r8)
            goto L8b
        L1a:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L22:
            java.lang.Object r1 = r7.f117562a
            cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile r1 = (cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile) r1
            kotlin.ResultKt.b(r8)
            goto L70
        L2a:
            kotlin.ResultKt.b(r8)
            goto L46
        L2e:
            kotlin.ResultKt.b(r8)
            cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel r8 = r7.f117564c
            cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao r8 = cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel.a1(r8)
            cz.mobilesoft.coreblock.scene.dashboard.blocking.ProfileViewDTO r1 = r7.f117565d
            long r5 = r1.k()
            r7.f117563b = r4
            java.lang.Object r8 = r8.e(r5, r7)
            if (r8 != r0) goto L46
            goto L8a
        L46:
            r1 = r8
            cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile r1 = (cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile) r1
            if (r1 != 0) goto L4e
            kotlin.Unit r8 = kotlin.Unit.f139807a
            return r8
        L4e:
            r4 = 0
            r1.m0(r4)
            r4 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r1.h0(r4)
            cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel r8 = r7.f117564c
            cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao r8 = cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel.a1(r8)
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.a(r1)
            r7.f117562a = r4
            r7.f117563b = r3
            java.lang.Object r8 = r8.p(r1, r7)
            if (r8 != r0) goto L70
            goto L8a
        L70:
            cz.mobilesoft.coreblock.repository.ScheduleRepository r8 = cz.mobilesoft.coreblock.repository.ScheduleRepository.f97962a
            cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel r3 = r7.f117564c
            cz.mobilesoft.coreblock.repository.PremiumRepositoryV2 r3 = cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel.Z0(r3)
            cz.mobilesoft.coreblock.enums.PremiumState r3 = r3.J()
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.a(r1)
            r7.f117562a = r1
            r7.f117563b = r2
            java.lang.Object r8 = r8.S(r3, r7)
            if (r8 != r0) goto L8b
        L8a:
            return r0
        L8b:
            kotlin.Unit r8 = kotlin.Unit.f139807a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel$stopManually$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((SchedulePreviewViewModel$stopManually$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
