package cz.mobilesoft.coreblock.scene.insights.weekly;

import androidx.compose.runtime.MutableState;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.insights.weekly.WeeklyInsightsIntroScreenKt$IntroScreen$1$1", f = "WeeklyInsightsIntroScreen.kt", l = {65, 68}, m = "invokeSuspend", v = 1)
final class WeeklyInsightsIntroScreenKt$IntroScreen$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f103904a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ MutableState f103905b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ MutableState f103906c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    WeeklyInsightsIntroScreenKt$IntroScreen$1$1(MutableState mutableState, MutableState mutableState2, Continuation continuation) {
        super(2, continuation);
        this.f103905b = mutableState;
        this.f103906c = mutableState2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new WeeklyInsightsIntroScreenKt$IntroScreen$1$1(this.f103905b, this.f103906c, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x003d, code lost:
    
        if (kotlinx.coroutines.DelayKt.b(1000, r6) == r0) goto L15;
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
            int r1 = r6.f103904a
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1e
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.ResultKt.b(r7)
            goto L40
        L12:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L1a:
            kotlin.ResultKt.b(r7)
            goto L2c
        L1e:
            kotlin.ResultKt.b(r7)
            r6.f103904a = r3
            r4 = 500(0x1f4, double:2.47E-321)
            java.lang.Object r7 = kotlinx.coroutines.DelayKt.b(r4, r6)
            if (r7 != r0) goto L2c
            goto L3f
        L2c:
            androidx.compose.runtime.MutableState r7 = r6.f103905b
            java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.Boxing.a(r3)
            r7.setValue(r1)
            r6.f103904a = r2
            r1 = 1000(0x3e8, double:4.94E-321)
            java.lang.Object r7 = kotlinx.coroutines.DelayKt.b(r1, r6)
            if (r7 != r0) goto L40
        L3f:
            return r0
        L40:
            androidx.compose.runtime.MutableState r7 = r6.f103906c
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.a(r3)
            r7.setValue(r0)
            kotlin.Unit r7 = kotlin.Unit.f139807a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.insights.weekly.WeeklyInsightsIntroScreenKt$IntroScreen$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((WeeklyInsightsIntroScreenKt$IntroScreen$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
