package cz.mobilesoft.coreblock.scene.emergency_unblock;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.emergency_unblock.EmergencyUnblockViewModel$onEvent$1", f = "EmergencyUnblockViewModel.kt", l = {64, 65}, m = "invokeSuspend", v = 1)
final class EmergencyUnblockViewModel$onEvent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f101777a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ EmergencyUnblockViewModel f101778b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    EmergencyUnblockViewModel$onEvent$1(EmergencyUnblockViewModel emergencyUnblockViewModel, Continuation continuation) {
        super(2, continuation);
        this.f101778b = emergencyUnblockViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new EmergencyUnblockViewModel$onEvent$1(this.f101778b, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0049, code lost:
    
        if (r6.n(r1, r5) == r0) goto L15;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) throws java.lang.Throwable {
        /*
            r5 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r5.f101777a
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1e
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.ResultKt.b(r6)
            goto L4c
        L12:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L1a:
            kotlin.ResultKt.b(r6)
            goto L32
        L1e:
            kotlin.ResultKt.b(r6)
            cz.mobilesoft.coreblock.scene.emergency_unblock.EmergencyUnblockViewModel r6 = r5.f101778b
            cz.mobilesoft.coreblock.repository.StrictModeRepository r6 = cz.mobilesoft.coreblock.scene.emergency_unblock.EmergencyUnblockViewModel.U0(r6)
            r5.f101777a = r3
            r1 = 0
            r4 = 0
            java.lang.Object r6 = cz.mobilesoft.coreblock.repository.StrictModeRepository.g(r6, r1, r5, r3, r4)
            if (r6 != r0) goto L32
            goto L4b
        L32:
            cz.mobilesoft.coreblock.scene.emergency_unblock.EmergencyUnblockViewModel r6 = r5.f101778b
            cz.mobilesoft.coreblock.storage.room.dao.core.EmergencyUnblockingDao r6 = cz.mobilesoft.coreblock.scene.emergency_unblock.EmergencyUnblockViewModel.S0(r6)
            cz.mobilesoft.coreblock.storage.room.entity.core.EmergencyUnblockingEntity r1 = new cz.mobilesoft.coreblock.storage.room.entity.core.EmergencyUnblockingEntity
            cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt r3 = cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt.f128663a
            long r3 = r3.f()
            r1.<init>(r3)
            r5.f101777a = r2
            java.lang.Object r6 = r6.n(r1, r5)
            if (r6 != r0) goto L4c
        L4b:
            return r0
        L4c:
            kotlin.Unit r6 = kotlin.Unit.f139807a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.emergency_unblock.EmergencyUnblockViewModel$onEvent$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((EmergencyUnblockViewModel$onEvent$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
