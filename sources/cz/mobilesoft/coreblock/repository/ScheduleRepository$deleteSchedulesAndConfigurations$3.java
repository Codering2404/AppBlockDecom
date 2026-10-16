package cz.mobilesoft.coreblock.repository;

import java.util.List;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.repository.ScheduleRepository$deleteSchedulesAndConfigurations$3", f = "ScheduleRepository.kt", l = {918, 920, 922}, m = "invokeSuspend", v = 1)
final class ScheduleRepository$deleteSchedulesAndConfigurations$3 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f98009a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ List f98010b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ List f98011c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ScheduleRepository$deleteSchedulesAndConfigurations$3(List list, List list2, Continuation continuation) {
        super(1, continuation);
        this.f98010b = list;
        this.f98011c = list2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new ScheduleRepository$deleteSchedulesAndConfigurations$3(this.f98010b, this.f98011c, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0056, code lost:
    
        if (r6.u(r1, r5) != r0) goto L21;
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
            int r1 = r5.f98009a
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L25
            if (r1 == r4) goto L21
            if (r1 == r3) goto L1d
            if (r1 != r2) goto L15
            kotlin.ResultKt.b(r6)
            goto L59
        L15:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L1d:
            kotlin.ResultKt.b(r6)
            goto L46
        L21:
            kotlin.ResultKt.b(r6)
            goto L35
        L25:
            kotlin.ResultKt.b(r6)
            cz.mobilesoft.coreblock.repository.ScheduleRepository r6 = cz.mobilesoft.coreblock.repository.ScheduleRepository.f97962a
            java.util.List r1 = r5.f98010b
            r5.f98009a = r4
            java.lang.Object r6 = cz.mobilesoft.coreblock.repository.ScheduleRepository.e(r6, r1, r5)
            if (r6 != r0) goto L35
            goto L58
        L35:
            cz.mobilesoft.coreblock.repository.ScheduleRepository r6 = cz.mobilesoft.coreblock.repository.ScheduleRepository.f97962a
            cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao r6 = cz.mobilesoft.coreblock.repository.ScheduleRepository.l(r6)
            java.util.List r1 = r5.f98011c
            r5.f98009a = r3
            java.lang.Object r6 = r6.h(r1, r5)
            if (r6 != r0) goto L46
            goto L58
        L46:
            cz.mobilesoft.coreblock.repository.ScheduleRepository r6 = cz.mobilesoft.coreblock.repository.ScheduleRepository.f97962a
            cz.mobilesoft.coreblock.repository.StrictModeRepository r6 = cz.mobilesoft.coreblock.repository.ScheduleRepository.o(r6)
            java.util.List r1 = r5.f98010b
            java.util.Collection r1 = (java.util.Collection) r1
            r5.f98009a = r2
            java.lang.Object r6 = r6.u(r1, r5)
            if (r6 != r0) goto L59
        L58:
            return r0
        L59:
            kotlin.Unit r6 = kotlin.Unit.f139807a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.repository.ScheduleRepository$deleteSchedulesAndConfigurations$3.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((ScheduleRepository$deleteSchedulesAndConfigurations$3) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
