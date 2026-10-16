package cz.mobilesoft.coreblock.scene.schedule;

import cz.mobilesoft.coreblock.scene.schedule.detail.ScheduleViewState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$onEvent$7", f = "ScheduleViewModel.kt", l = {906, 912}, m = "invokeSuspend", v = 1)
final class ScheduleViewModel$onEvent$7 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f114832a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ScheduleViewEvent f114833b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ ScheduleViewModel f114834c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ScheduleViewModel$onEvent$7(ScheduleViewEvent scheduleViewEvent, ScheduleViewModel scheduleViewModel, Continuation continuation) {
        super(1, continuation);
        this.f114833b = scheduleViewEvent;
        this.f114834c = scheduleViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ScheduleViewState y(ScheduleViewState scheduleViewState) {
        return ScheduleViewState.b(scheduleViewState, null, null, false, null, false, false, false, true, null, null, null, null, null, false, null, null, null, 130943, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ScheduleViewState z(ScheduleViewState scheduleViewState) {
        return ScheduleViewState.b(scheduleViewState, null, null, false, null, false, false, false, false, null, null, null, null, null, false, null, null, null, 131039, null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new ScheduleViewModel$onEvent$7(this.f114833b, this.f114834c, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x006e, code lost:
    
        if (r5.o(r1, true, r4) == r0) goto L21;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r5) throws java.lang.Throwable {
        /*
            r4 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r4.f114832a
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1e
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.ResultKt.b(r5)
            goto L71
        L12:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L1a:
            kotlin.ResultKt.b(r5)
            goto L4c
        L1e:
            kotlin.ResultKt.b(r5)
            cz.mobilesoft.coreblock.util.analytics.AnswersHelper r5 = cz.mobilesoft.coreblock.util.analytics.AnswersHelper.f128199a
            cz.mobilesoft.coreblock.scene.schedule.ScheduleViewEvent r1 = r4.f114833b
            cz.mobilesoft.coreblock.scene.schedule.ScheduleViewEvent$OnCategoriesAllowed r1 = (cz.mobilesoft.coreblock.scene.schedule.ScheduleViewEvent.OnCategoriesAllowed) r1
            boolean r1 = r1.a()
            r5.f1(r1)
            cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel r5 = r4.f114834c
            cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStore r5 = cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel.L1(r5)
            cz.mobilesoft.coreblock.scene.schedule.ScheduleViewEvent r1 = r4.f114833b
            cz.mobilesoft.coreblock.scene.schedule.ScheduleViewEvent$OnCategoriesAllowed r1 = (cz.mobilesoft.coreblock.scene.schedule.ScheduleViewEvent.OnCategoriesAllowed) r1
            boolean r1 = r1.a()
            if (r1 == 0) goto L41
            cz.mobilesoft.coreblock.enums.TripleState r1 = cz.mobilesoft.coreblock.enums.TripleState.True
            goto L43
        L41:
            cz.mobilesoft.coreblock.enums.TripleState r1 = cz.mobilesoft.coreblock.enums.TripleState.False
        L43:
            r4.f114832a = r3
            java.lang.Object r5 = r5.H0(r1, r4)
            if (r5 != r0) goto L4c
            goto L70
        L4c:
            cz.mobilesoft.coreblock.scene.schedule.ScheduleViewEvent r5 = r4.f114833b
            cz.mobilesoft.coreblock.scene.schedule.ScheduleViewEvent$OnCategoriesAllowed r5 = (cz.mobilesoft.coreblock.scene.schedule.ScheduleViewEvent.OnCategoriesAllowed) r5
            boolean r5 = r5.a()
            if (r5 == 0) goto L71
            cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel r5 = r4.f114834c
            cz.mobilesoft.coreblock.scene.schedule.d4 r1 = new cz.mobilesoft.coreblock.scene.schedule.d4
            r1.<init>()
            cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel.I2(r5, r1)
            cz.mobilesoft.coreblock.repository.ApplicationRepository r5 = cz.mobilesoft.coreblock.repository.ApplicationRepository.f97454a
            cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel r1 = r4.f114834c
            android.content.Context r1 = r1.A0()
            r4.f114832a = r2
            java.lang.Object r5 = r5.o(r1, r3, r4)
            if (r5 != r0) goto L71
        L70:
            return r0
        L71:
            cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel r5 = r4.f114834c
            cz.mobilesoft.coreblock.scene.schedule.e4 r0 = new cz.mobilesoft.coreblock.scene.schedule.e4
            r0.<init>()
            cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel.I2(r5, r0)
            kotlin.Unit r5 = kotlin.Unit.f139807a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$onEvent$7.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((ScheduleViewModel$onEvent$7) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
