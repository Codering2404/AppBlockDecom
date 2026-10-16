package cz.mobilesoft.coreblock.scene.timenudge.select;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.timenudge.select.TimeNudgeSelectViewModel$onSave$1", f = "TimeNudgeSelectViewModel.kt", l = {31, 35}, m = "invokeSuspend", v = 1)
final class TimeNudgeSelectViewModel$onSave$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f122941a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f122942b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ TimeNudgeSelectViewModel f122943c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TimeNudgeSelectViewModel$onSave$1(TimeNudgeSelectViewModel timeNudgeSelectViewModel, Continuation continuation) {
        super(1, continuation);
        this.f122943c = timeNudgeSelectViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new TimeNudgeSelectViewModel$onSave$1(this.f122943c, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x00a4, code lost:
    
        if (r7.P0(r3, r6) == r0) goto L21;
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
            int r1 = r6.f122942b
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L27
            if (r1 == r3) goto L1f
            if (r1 != r2) goto L17
            java.lang.Object r0 = r6.f122941a
            java.util.Set r0 = (java.util.Set) r0
            kotlin.ResultKt.b(r7)
            goto La7
        L17:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L1f:
            java.lang.Object r1 = r6.f122941a
            java.util.Set r1 = (java.util.Set) r1
            kotlin.ResultKt.b(r7)
            goto L88
        L27:
            kotlin.ResultKt.b(r7)
            cz.mobilesoft.coreblock.scene.timenudge.select.TimeNudgeSelectViewModel r7 = r6.f122943c
            cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewState r7 = cz.mobilesoft.coreblock.scene.timenudge.select.TimeNudgeSelectViewModel.N2(r7)
            cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewState$ApplicationViewState r7 = r7.c()
            java.util.Map r7 = r7.d()
            java.util.LinkedHashMap r1 = new java.util.LinkedHashMap
            r1.<init>()
            java.util.Set r7 = r7.entrySet()
            java.util.Iterator r7 = r7.iterator()
        L45:
            boolean r4 = r7.hasNext()
            if (r4 == 0) goto L6d
            java.lang.Object r4 = r7.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            java.lang.Object r5 = r4.getValue()
            cz.mobilesoft.coreblock.scene.selection.ApplicationStateDTO r5 = (cz.mobilesoft.coreblock.scene.selection.ApplicationStateDTO) r5
            cz.mobilesoft.coreblock.dto.ApplicationDTO r5 = r5.c()
            boolean r5 = r5.h()
            if (r5 == 0) goto L45
            java.lang.Object r5 = r4.getKey()
            java.lang.Object r4 = r4.getValue()
            r1.put(r5, r4)
            goto L45
        L6d:
            java.util.Set r7 = r1.keySet()
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.Set r1 = kotlin.collections.CollectionsKt.toSet(r7)
            cz.mobilesoft.coreblock.scene.timenudge.select.TimeNudgeSelectViewModel r7 = r6.f122943c
            cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStore r7 = cz.mobilesoft.coreblock.scene.timenudge.select.TimeNudgeSelectViewModel.O2(r7)
            r6.f122941a = r1
            r6.f122942b = r3
            java.lang.Object r7 = r7.b1(r1, r6)
            if (r7 != r0) goto L88
            goto La6
        L88:
            cz.mobilesoft.coreblock.util.analytics.AnswersHelper r7 = cz.mobilesoft.coreblock.util.analytics.AnswersHelper.f128199a
            int r3 = r1.size()
            r7.Z7(r3)
            cz.mobilesoft.coreblock.util.runnability.JobHelper.m()
            cz.mobilesoft.coreblock.scene.timenudge.select.TimeNudgeSelectViewModel r7 = r6.f122943c
            cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewCommand$Close r3 = cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewCommand.Close.f118178a
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.a(r1)
            r6.f122941a = r1
            r6.f122942b = r2
            java.lang.Object r7 = cz.mobilesoft.coreblock.scene.timenudge.select.TimeNudgeSelectViewModel.P2(r7, r3, r6)
            if (r7 != r0) goto La7
        La6:
            return r0
        La7:
            kotlin.Unit r7 = kotlin.Unit.f139807a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.timenudge.select.TimeNudgeSelectViewModel$onSave$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((TimeNudgeSelectViewModel$onSave$1) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
