package cz.mobilesoft.coreblock.scene.onboarding.statistics;

import androidx.compose.runtime.MutableState;
import cz.mobilesoft.coreblock.util.ViewModelState;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.onboarding.statistics.IntroReportScreenKt$ReportScreen$2$1", f = "IntroReportScreen.kt", l = {121, 123, 125}, m = "invokeSuspend", v = 1)
final class IntroReportScreenKt$ReportScreen$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f111371a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ViewModelState f111372b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ MutableState f111373c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    IntroReportScreenKt$ReportScreen$2$1(ViewModelState viewModelState, MutableState mutableState, Continuation continuation) {
        super(2, continuation);
        this.f111372b = viewModelState;
        this.f111373c = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new IntroReportScreenKt$ReportScreen$2$1(this.f111372b, this.f111373c, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x005c, code lost:
    
        if (kotlinx.coroutines.DelayKt.b(2000, r8) != r0) goto L23;
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
            int r1 = r8.f111371a
            r2 = 2000(0x7d0, double:9.88E-321)
            r4 = 3
            r5 = 2
            r6 = 1
            if (r1 == 0) goto L27
            if (r1 == r6) goto L23
            if (r1 == r5) goto L1f
            if (r1 != r4) goto L17
            kotlin.ResultKt.b(r9)
            goto L5f
        L17:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L1f:
            kotlin.ResultKt.b(r9)
            goto L4f
        L23:
            kotlin.ResultKt.b(r9)
            goto L3f
        L27:
            kotlin.ResultKt.b(r9)
            cz.mobilesoft.coreblock.util.ViewModelState r9 = r8.f111372b
            cz.mobilesoft.coreblock.util.Success r1 = cz.mobilesoft.coreblock.util.Success.f128020a
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual(r9, r1)
            if (r9 == 0) goto L66
            r8.f111371a = r6
            r6 = 100
            java.lang.Object r9 = kotlinx.coroutines.DelayKt.b(r6, r8)
            if (r9 != r0) goto L3f
            goto L5e
        L3f:
            androidx.compose.runtime.MutableState r9 = r8.f111373c
            cz.mobilesoft.coreblock.scene.onboarding.statistics.AnimationState r1 = cz.mobilesoft.coreblock.scene.onboarding.statistics.AnimationState.TrendIconInitial
            cz.mobilesoft.coreblock.scene.onboarding.statistics.IntroReportScreenKt.E(r9, r1)
            r8.f111371a = r5
            java.lang.Object r9 = kotlinx.coroutines.DelayKt.b(r2, r8)
            if (r9 != r0) goto L4f
            goto L5e
        L4f:
            androidx.compose.runtime.MutableState r9 = r8.f111373c
            cz.mobilesoft.coreblock.scene.onboarding.statistics.AnimationState r1 = cz.mobilesoft.coreblock.scene.onboarding.statistics.AnimationState.TrendIconAndData
            cz.mobilesoft.coreblock.scene.onboarding.statistics.IntroReportScreenKt.E(r9, r1)
            r8.f111371a = r4
            java.lang.Object r9 = kotlinx.coroutines.DelayKt.b(r2, r8)
            if (r9 != r0) goto L5f
        L5e:
            return r0
        L5f:
            androidx.compose.runtime.MutableState r9 = r8.f111373c
            cz.mobilesoft.coreblock.scene.onboarding.statistics.AnimationState r0 = cz.mobilesoft.coreblock.scene.onboarding.statistics.AnimationState.Report
            cz.mobilesoft.coreblock.scene.onboarding.statistics.IntroReportScreenKt.E(r9, r0)
        L66:
            kotlin.Unit r9 = kotlin.Unit.f139807a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.onboarding.statistics.IntroReportScreenKt$ReportScreen$2$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((IntroReportScreenKt$ReportScreen$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
