package cz.mobilesoft.coreblock.scene.streaks.milestone;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.streaks.milestone.StreakMilestoneScreenKt$StreakMilestoneScreen$1$1", f = "StreakMilestoneScreen.kt", l = {79, 81, 83, 85}, m = "invokeSuspend", v = 1)
final class StreakMilestoneScreenKt$StreakMilestoneScreen$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f120945a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ MutableState f120946b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ MutableState f120947c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ MutableState f120948d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ MutableState f120949f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StreakMilestoneScreenKt$StreakMilestoneScreen$1$1(MutableState mutableState, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4, Continuation continuation) {
        super(2, continuation);
        this.f120946b = mutableState;
        this.f120947c = mutableState2;
        this.f120948d = mutableState3;
        this.f120949f = mutableState4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new StreakMilestoneScreenKt$StreakMilestoneScreen$1$1(this.f120946b, this.f120947c, this.f120948d, this.f120949f, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0083, code lost:
    
        if (kotlinx.coroutines.DelayKt.c(r3, r9) != r0) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006e  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) throws java.lang.Throwable {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r9.f120945a
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 300(0x12c, float:4.2E-43)
            r6 = 1
            if (r1 == 0) goto L2e
            if (r1 == r6) goto L2a
            if (r1 == r4) goto L26
            if (r1 == r3) goto L22
            if (r1 != r2) goto L1a
            kotlin.ResultKt.b(r10)
            goto L86
        L1a:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L22:
            kotlin.ResultKt.b(r10)
            goto L6e
        L26:
            kotlin.ResultKt.b(r10)
            goto L58
        L2a:
            kotlin.ResultKt.b(r10)
            goto L42
        L2e:
            kotlin.ResultKt.b(r10)
            kotlin.time.Duration$Companion r10 = kotlin.time.Duration.f140631b
            kotlin.time.DurationUnit r10 = kotlin.time.DurationUnit.f140640d
            long r7 = kotlin.time.DurationKt.s(r5, r10)
            r9.f120945a = r6
            java.lang.Object r10 = kotlinx.coroutines.DelayKt.c(r7, r9)
            if (r10 != r0) goto L42
            goto L85
        L42:
            androidx.compose.runtime.MutableState r10 = r9.f120946b
            cz.mobilesoft.coreblock.scene.streaks.milestone.StreakMilestoneScreenKt.x(r10, r6)
            kotlin.time.Duration$Companion r10 = kotlin.time.Duration.f140631b
            kotlin.time.DurationUnit r10 = kotlin.time.DurationUnit.f140640d
            long r7 = kotlin.time.DurationKt.s(r5, r10)
            r9.f120945a = r4
            java.lang.Object r10 = kotlinx.coroutines.DelayKt.c(r7, r9)
            if (r10 != r0) goto L58
            goto L85
        L58:
            androidx.compose.runtime.MutableState r10 = r9.f120947c
            cz.mobilesoft.coreblock.scene.streaks.milestone.StreakMilestoneScreenKt.y(r10, r6)
            kotlin.time.Duration$Companion r10 = kotlin.time.Duration.f140631b
            kotlin.time.DurationUnit r10 = kotlin.time.DurationUnit.f140640d
            long r4 = kotlin.time.DurationKt.s(r5, r10)
            r9.f120945a = r3
            java.lang.Object r10 = kotlinx.coroutines.DelayKt.c(r4, r9)
            if (r10 != r0) goto L6e
            goto L85
        L6e:
            androidx.compose.runtime.MutableState r10 = r9.f120948d
            cz.mobilesoft.coreblock.scene.streaks.milestone.StreakMilestoneScreenKt.z(r10, r6)
            kotlin.time.Duration$Companion r10 = kotlin.time.Duration.f140631b
            r10 = 650(0x28a, float:9.11E-43)
            kotlin.time.DurationUnit r1 = kotlin.time.DurationUnit.f140640d
            long r3 = kotlin.time.DurationKt.s(r10, r1)
            r9.f120945a = r2
            java.lang.Object r10 = kotlinx.coroutines.DelayKt.c(r3, r9)
            if (r10 != r0) goto L86
        L85:
            return r0
        L86:
            androidx.compose.runtime.MutableState r10 = r9.f120949f
            cz.mobilesoft.coreblock.scene.streaks.milestone.StreakMilestoneScreenKt.w(r10, r6)
            kotlin.Unit r10 = kotlin.Unit.f139807a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.streaks.milestone.StreakMilestoneScreenKt$StreakMilestoneScreen$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((StreakMilestoneScreenKt$StreakMilestoneScreen$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
