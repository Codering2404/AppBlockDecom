package cz.mobilesoft.coreblock.scene.schedule;

import cz.mobilesoft.coreblock.scene.schedule.detail.LockType;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$onLockTypeClicked$1", f = "ScheduleViewModel.kt", l = {1395, 1403}, m = "invokeSuspend", v = 1)
final class ScheduleViewModel$onLockTypeClicked$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f114862a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f114863b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f114864c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ ScheduleViewModel f114865d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ LockType f114866f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ScheduleViewModel$onLockTypeClicked$1(ScheduleViewModel scheduleViewModel, LockType lockType, Continuation continuation) {
        super(2, continuation);
        this.f114865d = scheduleViewModel;
        this.f114866f = lockType;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new ScheduleViewModel$onLockTypeClicked$1(this.f114865d, this.f114866f, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0045, code lost:
    
        if (r1.P0(r2, r6) == r0) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0084, code lost:
    
        if (r3.P0(r4, r6) == r0) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0086, code lost:
    
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
            int r1 = r6.f114864c
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1f
            if (r1 == r3) goto L17
            if (r1 != r2) goto Lf
            goto L17
        Lf:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L17:
            java.lang.Object r0 = r6.f114862a
            java.lang.String r0 = (java.lang.String) r0
            kotlin.ResultKt.b(r7)
            goto L8f
        L1f:
            kotlin.ResultKt.b(r7)
            cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel r7 = r6.f114865d
            cz.mobilesoft.coreblock.scene.schedule.detail.ScheduleViewState r7 = cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel.q1(r7)
            cz.mobilesoft.coreblock.scene.schedule.detail.ScheduleViewState$DetailViewState r7 = r7.g()
            java.lang.String r7 = r7.o()
            if (r7 == 0) goto L48
            cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel r1 = r6.f114865d
            cz.mobilesoft.coreblock.scene.schedule.ScheduleViewCommand$ShowInvalidForSavingDialog r2 = new cz.mobilesoft.coreblock.scene.schedule.ScheduleViewCommand$ShowInvalidForSavingDialog
            r2.<init>(r7)
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.a(r7)
            r6.f114862a = r7
            r6.f114864c = r3
            java.lang.Object r7 = cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel.w2(r1, r2, r6)
            if (r7 != r0) goto L8f
            goto L86
        L48:
            cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel r1 = r6.f114865d
            cz.mobilesoft.coreblock.scene.schedule.ScheduleDTO r1 = cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel.p1(r1)
            cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel r3 = r6.f114865d
            cz.mobilesoft.coreblock.scene.schedule.ScheduleDTO r3 = cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel.H1(r3)
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r3)
            if (r1 != 0) goto L87
            cz.mobilesoft.coreblock.scene.schedule.detail.LockType r1 = r6.f114866f
            cz.mobilesoft.coreblock.scene.schedule.detail.LockType r3 = cz.mobilesoft.coreblock.scene.schedule.detail.LockType.Charger
            if (r1 != r3) goto L6b
            cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager r1 = cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager.f126839a
            boolean r1 = r1.f1()
            if (r1 != 0) goto L6b
            int r1 = cz.mobilesoft.coreblock.R.string.jj
            goto L6d
        L6b:
            int r1 = cz.mobilesoft.coreblock.R.string.l8
        L6d:
            cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel r3 = r6.f114865d
            cz.mobilesoft.coreblock.scene.schedule.ScheduleViewCommand$ShowUnsavedChangesBeforeLockingDialog r4 = new cz.mobilesoft.coreblock.scene.schedule.ScheduleViewCommand$ShowUnsavedChangesBeforeLockingDialog
            cz.mobilesoft.coreblock.scene.schedule.detail.LockType r5 = r6.f114866f
            r4.<init>(r1, r5)
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.a(r7)
            r6.f114862a = r7
            r6.f114863b = r1
            r6.f114864c = r2
            java.lang.Object r7 = cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel.w2(r3, r4, r6)
            if (r7 != r0) goto L8f
        L86:
            return r0
        L87:
            cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel r7 = r6.f114865d
            cz.mobilesoft.coreblock.scene.schedule.detail.LockType r0 = r6.f114866f
            r1 = 0
            cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel.E2(r7, r0, r1)
        L8f:
            kotlin.Unit r7 = kotlin.Unit.f139807a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$onLockTypeClicked$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((ScheduleViewModel$onLockTypeClicked$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
