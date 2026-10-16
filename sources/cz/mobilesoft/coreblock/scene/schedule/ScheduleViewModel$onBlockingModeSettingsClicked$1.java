package cz.mobilesoft.coreblock.scene.schedule;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$onBlockingModeSettingsClicked$1", f = "ScheduleViewModel.kt", l = {1584, 1587}, m = "invokeSuspend", v = 1)
final class ScheduleViewModel$onBlockingModeSettingsClicked$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f114758a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f114759b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ ScheduleViewModel f114760c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ScheduleViewModel$onBlockingModeSettingsClicked$1(ScheduleViewModel scheduleViewModel, Continuation continuation) {
        super(2, continuation);
        this.f114760c = scheduleViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new ScheduleViewModel$onBlockingModeSettingsClicked$1(this.f114760c, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0065, code lost:
    
        if (r1.P0(r2, r6) == r0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0074, code lost:
    
        if (r1.P0(r3, r6) == r0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0076, code lost:
    
        return r0;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) throws java.lang.Throwable {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r6.f114759b
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1b
            if (r1 == r3) goto L17
            if (r1 != r2) goto Lf
            goto L17
        Lf:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L17:
            kotlin.ResultKt.b(r7)
            goto L7c
        L1b:
            kotlin.ResultKt.b(r7)
            cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel r7 = r6.f114760c
            cz.mobilesoft.coreblock.scene.schedule.detail.ScheduleViewState r7 = cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel.q1(r7)
            cz.mobilesoft.coreblock.scene.schedule.detail.ScheduleViewState$DetailViewState r7 = r7.g()
            cz.mobilesoft.coreblock.scene.schedule.detail.AppBlockingSettings r7 = r7.c()
            boolean r7 = r7.c()
            if (r7 != 0) goto L77
            cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel r1 = r6.f114760c
            boolean r1 = cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel.j2(r1)
            if (r1 == 0) goto L68
            cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel r1 = r6.f114760c
            cz.mobilesoft.coreblock.scene.schedule.detail.ScheduleViewState r1 = cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel.q1(r1)
            cz.mobilesoft.coreblock.scene.schedule.detail.ScheduleViewState$DetailViewState r1 = r1.g()
            boolean r1 = r1.D()
            if (r1 != 0) goto L68
            cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel r1 = r6.f114760c
            cz.mobilesoft.coreblock.scene.schedule.ScheduleViewCommand$ShowSnackBar r2 = new cz.mobilesoft.coreblock.scene.schedule.ScheduleViewCommand$ShowSnackBar
            cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel r4 = r6.f114760c
            cz.mobilesoft.coreblock.enums.StrictModeTitleAlternatives$Companion r5 = cz.mobilesoft.coreblock.enums.StrictModeTitleAlternatives.Companion
            int r5 = r5.a()
            java.lang.String r4 = cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel.X1(r4, r5)
            r2.<init>(r4)
            r6.f114758a = r7
            r6.f114759b = r3
            java.lang.Object r7 = cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel.w2(r1, r2, r6)
            if (r7 != r0) goto L7c
            goto L76
        L68:
            cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel r1 = r6.f114760c
            cz.mobilesoft.coreblock.scene.schedule.ScheduleViewCommand$ShowBlockingModeSettings r3 = cz.mobilesoft.coreblock.scene.schedule.ScheduleViewCommand.ShowBlockingModeSettings.f114513a
            r6.f114758a = r7
            r6.f114759b = r2
            java.lang.Object r7 = cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel.w2(r1, r3, r6)
            if (r7 != r0) goto L7c
        L76:
            return r0
        L77:
            cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel r7 = r6.f114760c
            cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel.n2(r7)
        L7c:
            kotlin.Unit r7 = kotlin.Unit.f139807a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$onBlockingModeSettingsClicked$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((ScheduleViewModel$onBlockingModeSettingsClicked$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
