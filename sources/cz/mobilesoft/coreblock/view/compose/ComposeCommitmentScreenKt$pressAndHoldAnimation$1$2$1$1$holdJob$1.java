package cz.mobilesoft.coreblock.view.compose;

import androidx.compose.animation.core.FloatTweenSpec;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.input.pointer.PointerInputChange;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.view.compose.ComposeCommitmentScreenKt$pressAndHoldAnimation$1$2$1$1$holdJob$1", f = "ComposeCommitmentScreen.kt", l = {303}, m = "invokeSuspend", v = 1)
final class ComposeCommitmentScreenKt$pressAndHoldAnimation$1$2$1$1$holdJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    long f130436a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    long f130437b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f130438c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ long f130439d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ PointerInputChange f130440f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ MutableState f130441g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ Function0 f130442h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ FloatTweenSpec f130443i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final /* synthetic */ long f130444j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final /* synthetic */ Function0 f130445k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ComposeCommitmentScreenKt$pressAndHoldAnimation$1$2$1$1$holdJob$1(long j3, PointerInputChange pointerInputChange, MutableState mutableState, Function0 function0, FloatTweenSpec floatTweenSpec, long j4, Function0 function02, Continuation continuation) {
        super(2, continuation);
        this.f130439d = j3;
        this.f130440f = pointerInputChange;
        this.f130441g = mutableState;
        this.f130442h = function0;
        this.f130443i = floatTweenSpec;
        this.f130444j = j4;
        this.f130445k = function02;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new ComposeCommitmentScreenKt$pressAndHoldAnimation$1$2$1$1$holdJob$1(this.f130439d, this.f130440f, this.f130441g, this.f130442h, this.f130443i, this.f130444j, this.f130445k, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0036  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0053 -> B:16:0x0056). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r17) throws java.lang.Throwable {
        /*
            r16 = this;
            r0 = r16
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f130438c
            r3 = 1
            if (r2 == 0) goto L1d
            if (r2 != r3) goto L15
            long r4 = r0.f130437b
            long r6 = r0.f130436a
            kotlin.ResultKt.b(r17)
            goto L56
        L15:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L1d:
            kotlin.ResultKt.b(r17)
            kotlin.time.Duration$Companion r2 = kotlin.time.Duration.f140631b
            r2 = 0
            kotlin.time.DurationUnit r4 = kotlin.time.DurationUnit.f140640d
            long r4 = kotlin.time.DurationKt.s(r2, r4)
            long r6 = r0.f130439d
            r14 = r6
            r6 = r4
            r4 = r14
        L2e:
            androidx.compose.ui.input.pointer.PointerInputChange r2 = r0.f130440f
            boolean r2 = r2.i()
            if (r2 == 0) goto L9f
            androidx.compose.runtime.MutableState r2 = r0.f130441g
            java.lang.Object r2 = r2.getValue()
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 != 0) goto L9f
            kotlin.jvm.functions.Function0 r2 = r0.f130442h
            r2.invoke()
            r0.f130436a = r6
            r0.f130437b = r4
            r0.f130438c = r3
            java.lang.Object r2 = kotlinx.coroutines.DelayKt.c(r4, r0)
            if (r2 != r1) goto L56
            return r1
        L56:
            long r6 = kotlin.time.Duration.G(r6, r4)
            androidx.compose.animation.core.FloatTweenSpec r8 = r0.f130443i
            long r9 = kotlin.time.Duration.r(r6)
            long r4 = r0.f130439d
            long r4 = kotlin.time.Duration.p(r4)
            float r11 = (float) r4
            long r4 = r0.f130439d
            long r4 = kotlin.time.Duration.p(r4)
            float r12 = (float) r4
            r13 = 0
            float r2 = r8.c(r9, r11, r12, r13)
            int r2 = (int) r2
            kotlin.time.DurationUnit r4 = kotlin.time.DurationUnit.f140640d
            long r4 = kotlin.time.DurationKt.s(r2, r4)
            long r8 = r0.f130444j
            int r2 = kotlin.time.Duration.h(r6, r8)
            if (r2 < 0) goto L2e
            androidx.compose.runtime.MutableState r2 = r0.f130441g
            java.lang.Object r2 = r2.getValue()
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 != 0) goto L2e
            androidx.compose.runtime.MutableState r2 = r0.f130441g
            java.lang.Boolean r8 = kotlin.coroutines.jvm.internal.Boxing.a(r3)
            r2.setValue(r8)
            kotlin.jvm.functions.Function0 r2 = r0.f130445k
            r2.invoke()
            goto L2e
        L9f:
            kotlin.Unit r1 = kotlin.Unit.f139807a
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.view.compose.ComposeCommitmentScreenKt$pressAndHoldAnimation$1$2$1$1$holdJob$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((ComposeCommitmentScreenKt$pressAndHoldAnimation$1$2$1$1$holdJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
