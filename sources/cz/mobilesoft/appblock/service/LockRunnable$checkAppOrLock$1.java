package cz.mobilesoft.appblock.service;

import cz.mobilesoft.coreblock.usecase.GetForegroundAppsUseCase;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.appblock.service.LockRunnable$checkAppOrLock$1", f = "LockRunnable.kt", l = {777, 778, 780, 781, 782}, m = "invokeSuspend", v = 1)
final class LockRunnable$checkAppOrLock$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f94456a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ GetForegroundAppsUseCase.AppsDTO f94457b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ LockRunnable f94458c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LockRunnable$checkAppOrLock$1(GetForegroundAppsUseCase.AppsDTO appsDTO, LockRunnable lockRunnable, Continuation continuation) {
        super(1, continuation);
        this.f94457b = appsDTO;
        this.f94458c = lockRunnable;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new LockRunnable$checkAppOrLock$1(this.f94457b, this.f94458c, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x00ae, code lost:
    
        if (r9.U1(r3, r8) != r0) goto L37;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0087 A[PHI: r9
      0x0087: PHI (r9v17 java.lang.Object) = (r9v16 java.lang.Object), (r9v0 java.lang.Object) binds: [B:27:0x0084, B:13:0x0029] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0091  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) throws java.lang.Throwable {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r8.f94456a
            r2 = 5
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            if (r1 == 0) goto L35
            if (r1 == r6) goto L31
            if (r1 == r5) goto L2d
            if (r1 == r4) goto L29
            if (r1 == r3) goto L24
            if (r1 != r2) goto L1c
            kotlin.ResultKt.b(r9)
            goto Lb1
        L1c:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L24:
            kotlin.ResultKt.b(r9)
            goto L9c
        L29:
            kotlin.ResultKt.b(r9)
            goto L87
        L2d:
            kotlin.ResultKt.b(r9)
            goto L74
        L31:
            kotlin.ResultKt.b(r9)
            goto L55
        L35:
            kotlin.ResultKt.b(r9)
            cz.mobilesoft.coreblock.usecase.GetForegroundAppsUseCase$AppsDTO r9 = r8.f94457b
            java.lang.String r1 = "com.google.android.packageinstaller"
            boolean r9 = r9.c(r1)
            if (r9 == 0) goto L74
            cz.mobilesoft.appblock.service.LockRunnable r9 = r8.f94458c
            cz.mobilesoft.coreblock.storage.datastore.StrictModeDataStore r9 = cz.mobilesoft.appblock.service.LockRunnable.s(r9)
            kotlinx.coroutines.flow.Flow r9 = r9.m0()
            r8.f94456a = r6
            java.lang.Object r9 = kotlinx.coroutines.flow.FlowKt.D(r9, r8)
            if (r9 != r0) goto L55
            goto Lb0
        L55:
            java.util.List r9 = (java.util.List) r9
            cz.mobilesoft.coreblock.enums.StrictModeOption r1 = cz.mobilesoft.coreblock.enums.StrictModeOption.BlockUninstalling
            boolean r9 = r9.contains(r1)
            if (r9 == 0) goto L74
            cz.mobilesoft.appblock.service.LockRunnable r9 = r8.f94458c
            cz.mobilesoft.coreblock.storage.datastore.EventDataStore r9 = cz.mobilesoft.appblock.service.LockRunnable.m(r9)
            cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt r1 = cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt.f128663a
            long r6 = r1.f()
            r8.f94456a = r5
            java.lang.Object r9 = r9.P1(r6, r8)
            if (r9 != r0) goto L74
            goto Lb0
        L74:
            cz.mobilesoft.appblock.service.LockRunnable r9 = r8.f94458c
            cz.mobilesoft.coreblock.storage.datastore.StrictModeDataStore r9 = cz.mobilesoft.appblock.service.LockRunnable.s(r9)
            kotlinx.coroutines.flow.Flow r9 = r9.m0()
            r8.f94456a = r4
            java.lang.Object r9 = kotlinx.coroutines.flow.FlowKt.D(r9, r8)
            if (r9 != r0) goto L87
            goto Lb0
        L87:
            java.util.List r9 = (java.util.List) r9
            cz.mobilesoft.coreblock.enums.StrictModeOption r1 = cz.mobilesoft.coreblock.enums.StrictModeOption.BlockSplitScreen
            boolean r9 = r9.contains(r1)
            if (r9 == 0) goto Lb1
            r8.f94456a = r3
            r3 = 500(0x1f4, double:2.47E-321)
            java.lang.Object r9 = kotlinx.coroutines.DelayKt.b(r3, r8)
            if (r9 != r0) goto L9c
            goto Lb0
        L9c:
            cz.mobilesoft.appblock.service.LockRunnable r9 = r8.f94458c
            cz.mobilesoft.coreblock.storage.datastore.EventDataStore r9 = cz.mobilesoft.appblock.service.LockRunnable.m(r9)
            cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt r1 = cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt.f128663a
            long r3 = r1.f()
            r8.f94456a = r2
            java.lang.Object r9 = r9.U1(r3, r8)
            if (r9 != r0) goto Lb1
        Lb0:
            return r0
        Lb1:
            kotlin.Unit r9 = kotlin.Unit.f139807a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.appblock.service.LockRunnable$checkAppOrLock$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((LockRunnable$checkAppOrLock$1) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
