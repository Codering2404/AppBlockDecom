package cz.mobilesoft.coreblock.scene.insights;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.insights.InsightsViewModel$onEvent$8", f = "InsightsViewModel.kt", l = {488, 491}, m = "invokeSuspend", v = 1)
final class InsightsViewModel$onEvent$8 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f102790a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ InsightsViewModel f102791b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InsightsViewModel$onEvent$8(InsightsViewModel insightsViewModel, Continuation continuation) {
        super(1, continuation);
        this.f102791b = insightsViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new InsightsViewModel$onEvent$8(this.f102791b, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0059, code lost:
    
        if (r9.U0(r8) == r0) goto L19;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) throws java.lang.Throwable {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r8.f102790a
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1e
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.ResultKt.b(r9)
            goto L5c
        L12:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L1a:
            kotlin.ResultKt.b(r9)
            goto L4d
        L1e:
            kotlin.ResultKt.b(r9)
            cz.mobilesoft.coreblock.scene.insights.InsightsViewModel r9 = r8.f102791b
            cz.mobilesoft.coreblock.scene.insights.InsightsViewState r9 = cz.mobilesoft.coreblock.scene.insights.InsightsViewModel.x1(r9)
            boolean r9 = r9.P()
            if (r9 == 0) goto L4d
            cz.mobilesoft.coreblock.scene.insights.InsightsViewModel r9 = r8.f102791b
            cz.mobilesoft.coreblock.scene.insights.InsightsViewState r9 = cz.mobilesoft.coreblock.scene.insights.InsightsViewModel.x1(r9)
            long r4 = r9.Q()
            r6 = 1
            long r4 = r4 + r6
            r6 = 3
            int r9 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r9 != 0) goto L4d
            cz.mobilesoft.coreblock.scene.insights.InsightsViewModel r9 = r8.f102791b
            cz.mobilesoft.coreblock.scene.insights.InsightsViewCommand$ShowMoodCheckInDisableDialog r1 = cz.mobilesoft.coreblock.scene.insights.InsightsViewCommand.ShowMoodCheckInDisableDialog.f102667a
            r8.f102790a = r3
            java.lang.Object r9 = cz.mobilesoft.coreblock.scene.insights.InsightsViewModel.N1(r9, r1, r8)
            if (r9 != r0) goto L4d
            goto L5b
        L4d:
            cz.mobilesoft.coreblock.scene.insights.InsightsViewModel r9 = r8.f102791b
            cz.mobilesoft.coreblock.storage.datastore.StatisticsDataStore r9 = cz.mobilesoft.coreblock.scene.insights.InsightsViewModel.H1(r9)
            r8.f102790a = r2
            java.lang.Object r9 = r9.U0(r8)
            if (r9 != r0) goto L5c
        L5b:
            return r0
        L5c:
            kotlin.Unit r9 = kotlin.Unit.f139807a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.insights.InsightsViewModel$onEvent$8.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((InsightsViewModel$onEvent$8) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
