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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$startLockSetup$1", f = "ScheduleViewModel.kt", l = {1416, 1420}, m = "invokeSuspend", v = 1)
final class ScheduleViewModel$startLockSetup$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f115014a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ LockType f115015b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ ScheduleViewModel f115016c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ boolean f115017d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f115018a;

        static {
            int[] iArr = new int[LockType.values().length];
            try {
                iArr[LockType.Time.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LockType.Charger.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f115018a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ScheduleViewModel$startLockSetup$1(LockType lockType, ScheduleViewModel scheduleViewModel, boolean z2, Continuation continuation) {
        super(2, continuation);
        this.f115015b = lockType;
        this.f115016c = scheduleViewModel;
        this.f115017d = z2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new ScheduleViewModel$startLockSetup$1(this.f115015b, this.f115016c, this.f115017d, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0042, code lost:
    
        if (r5.P0(r1, r4) == r0) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0061, code lost:
    
        if (r5.P0(r1, r4) == r0) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0063, code lost:
    
        return r0;
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
            int r1 = r4.f115014a
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1a
            if (r1 == r3) goto Le
            if (r1 != r2) goto L12
        Le:
            kotlin.ResultKt.b(r5)
            goto L64
        L12:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L1a:
            kotlin.ResultKt.b(r5)
            cz.mobilesoft.coreblock.scene.schedule.detail.LockType r5 = r4.f115015b
            int[] r1 = cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$startLockSetup$1.WhenMappings.f115018a
            int r5 = r5.ordinal()
            r5 = r1[r5]
            if (r5 == r3) goto L52
            if (r5 != r2) goto L4c
            cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager r5 = cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager.f126839a
            boolean r5 = r5.f1()
            if (r5 == 0) goto L45
            cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel r5 = r4.f115016c
            cz.mobilesoft.coreblock.scene.schedule.ScheduleViewCommand$ShowChargerLockConfirmDialog r1 = new cz.mobilesoft.coreblock.scene.schedule.ScheduleViewCommand$ShowChargerLockConfirmDialog
            boolean r3 = r4.f115017d
            r1.<init>(r3)
            r4.f115014a = r2
            java.lang.Object r5 = cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel.w2(r5, r1, r4)
            if (r5 != r0) goto L64
            goto L63
        L45:
            cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel r5 = r4.f115016c
            r0 = 0
            cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel.m2(r5, r0, r0)
            goto L64
        L4c:
            kotlin.NoWhenBranchMatchedException r5 = new kotlin.NoWhenBranchMatchedException
            r5.<init>()
            throw r5
        L52:
            cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel r5 = r4.f115016c
            cz.mobilesoft.coreblock.scene.schedule.ScheduleViewCommand$ShowTimeLockSelector r1 = new cz.mobilesoft.coreblock.scene.schedule.ScheduleViewCommand$ShowTimeLockSelector
            boolean r2 = r4.f115017d
            r1.<init>(r2)
            r4.f115014a = r3
            java.lang.Object r5 = cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel.w2(r5, r1, r4)
            if (r5 != r0) goto L64
        L63:
            return r0
        L64:
            kotlin.Unit r5 = kotlin.Unit.f139807a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$startLockSetup$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((ScheduleViewModel$startLockSetup$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
