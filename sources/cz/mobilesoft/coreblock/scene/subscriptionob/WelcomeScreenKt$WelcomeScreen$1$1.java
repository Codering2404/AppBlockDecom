package cz.mobilesoft.coreblock.scene.subscriptionob;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.subscriptionob.WelcomeScreenKt$WelcomeScreen$1$1", f = "WelcomeScreen.kt", l = {68, 71, 74, 77}, m = "invokeSuspend", v = 1)
final class WelcomeScreenKt$WelcomeScreen$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f122739a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ MutableState f122740b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ MutableState f122741c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ MutableState f122742d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ MutableState f122743f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    WelcomeScreenKt$WelcomeScreen$1$1(MutableState mutableState, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4, Continuation continuation) {
        super(2, continuation);
        this.f122740b = mutableState;
        this.f122741c = mutableState2;
        this.f122742d = mutableState3;
        this.f122743f = mutableState4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new WelcomeScreenKt$WelcomeScreen$1$1(this.f122740b, this.f122741c, this.f122742d, this.f122743f, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x006f, code lost:
    
        if (kotlinx.coroutines.DelayKt.b(1000, r10) != r0) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0060  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) throws java.lang.Throwable {
        /*
            r10 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r10.f122739a
            r2 = 1000(0x3e8, double:4.94E-321)
            r4 = 500(0x1f4, double:2.47E-321)
            r6 = 4
            r7 = 3
            r8 = 2
            r9 = 1
            if (r1 == 0) goto L30
            if (r1 == r9) goto L2c
            if (r1 == r8) goto L28
            if (r1 == r7) goto L24
            if (r1 != r6) goto L1c
            kotlin.ResultKt.b(r11)
            goto L72
        L1c:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L24:
            kotlin.ResultKt.b(r11)
            goto L60
        L28:
            kotlin.ResultKt.b(r11)
            goto L4e
        L2c:
            kotlin.ResultKt.b(r11)
            goto L3c
        L30:
            kotlin.ResultKt.b(r11)
            r10.f122739a = r9
            java.lang.Object r11 = kotlinx.coroutines.DelayKt.b(r4, r10)
            if (r11 != r0) goto L3c
            goto L71
        L3c:
            androidx.compose.runtime.MutableState r11 = r10.f122740b
            java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.Boxing.a(r9)
            r11.setValue(r1)
            r10.f122739a = r8
            java.lang.Object r11 = kotlinx.coroutines.DelayKt.b(r4, r10)
            if (r11 != r0) goto L4e
            goto L71
        L4e:
            androidx.compose.runtime.MutableState r11 = r10.f122741c
            java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.Boxing.a(r9)
            r11.setValue(r1)
            r10.f122739a = r7
            java.lang.Object r11 = kotlinx.coroutines.DelayKt.b(r2, r10)
            if (r11 != r0) goto L60
            goto L71
        L60:
            androidx.compose.runtime.MutableState r11 = r10.f122742d
            java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.Boxing.a(r9)
            r11.setValue(r1)
            r10.f122739a = r6
            java.lang.Object r11 = kotlinx.coroutines.DelayKt.b(r2, r10)
            if (r11 != r0) goto L72
        L71:
            return r0
        L72:
            androidx.compose.runtime.MutableState r11 = r10.f122743f
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.a(r9)
            r11.setValue(r0)
            kotlin.Unit r11 = kotlin.Unit.f139807a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.subscriptionob.WelcomeScreenKt$WelcomeScreen$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((WelcomeScreenKt$WelcomeScreen$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
