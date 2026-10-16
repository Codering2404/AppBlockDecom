package androidx.compose.foundation;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
@DebugMetadata(c = "androidx.compose.foundation.CombinedClickableNode$onClickKeyUpEvent$2", f = "Clickable.kt", l = {908, 912}, m = "invokeSuspend")
final class CombinedClickableNode$onClickKeyUpEvent$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    long f4880a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    long f4881b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f4882c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ CombinedClickableNode f4883d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ long f4884f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CombinedClickableNode$onClickKeyUpEvent$2(CombinedClickableNode combinedClickableNode, long j3, Continuation continuation) {
        super(2, continuation);
        this.f4883d = combinedClickableNode;
        this.f4884f = j3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new CombinedClickableNode$onClickKeyUpEvent$2(this.f4883d, this.f4884f, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0061, code lost:
    
        if (kotlinx.coroutines.DelayKt.b(r4 - r6, r10) == r0) goto L19;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) throws java.lang.Throwable {
        /*
            r10 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r10.f4882c
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L22
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.ResultKt.b(r11)
            goto L64
        L12:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L1a:
            long r4 = r10.f4881b
            long r6 = r10.f4880a
            kotlin.ResultKt.b(r11)
            goto L46
        L22:
            kotlin.ResultKt.b(r11)
            androidx.compose.foundation.CombinedClickableNode r11 = r10.f4883d
            androidx.compose.runtime.ProvidableCompositionLocal r1 = androidx.compose.ui.platform.CompositionLocalsKt.t()
            java.lang.Object r11 = androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt.a(r11, r1)
            androidx.compose.ui.platform.ViewConfiguration r11 = (androidx.compose.ui.platform.ViewConfiguration) r11
            long r6 = r11.b()
            long r4 = r11.a()
            r10.f4880a = r6
            r10.f4881b = r4
            r10.f4882c = r3
            java.lang.Object r11 = kotlinx.coroutines.DelayKt.b(r6, r10)
            if (r11 != r0) goto L46
            goto L63
        L46:
            androidx.compose.foundation.CombinedClickableNode r11 = r10.f4883d
            androidx.collection.MutableLongObjectMap r11 = androidx.compose.foundation.CombinedClickableNode.Q2(r11)
            long r8 = r10.f4884f
            java.lang.Object r11 = r11.b(r8)
            androidx.compose.foundation.CombinedClickableNode$DoubleKeyClickState r11 = (androidx.compose.foundation.CombinedClickableNode.DoubleKeyClickState) r11
            if (r11 != 0) goto L57
            goto L5a
        L57:
            r11.c(r3)
        L5a:
            long r4 = r4 - r6
            r10.f4882c = r2
            java.lang.Object r11 = kotlinx.coroutines.DelayKt.b(r4, r10)
            if (r11 != r0) goto L64
        L63:
            return r0
        L64:
            androidx.compose.foundation.CombinedClickableNode r11 = r10.f4883d
            kotlin.jvm.functions.Function0 r11 = r11.G2()
            r11.invoke()
            kotlin.Unit r11 = kotlin.Unit.f139807a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.CombinedClickableNode$onClickKeyUpEvent$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((CombinedClickableNode$onClickKeyUpEvent$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
