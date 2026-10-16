package cz.mobilesoft.coreblock.scene.lockscreen.backdoor;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.lockscreen.backdoor.BackdoorCodeDialog$show$2$3$2", f = "BackdoorCodeDialog.kt", l = {187, 188, 192}, m = "invokeSuspend", v = 1)
final class BackdoorCodeDialog$show$2$3$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f105624a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ BackdoorCodeDialog f105625b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BackdoorCodeDialog$show$2$3$2(BackdoorCodeDialog backdoorCodeDialog, Continuation continuation) {
        super(2, continuation);
        this.f105625b = backdoorCodeDialog;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new BackdoorCodeDialog$show$2$3$2(this.f105625b, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x004e, code lost:
    
        if (r6 != r0) goto L23;
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
            int r1 = r5.f105624a
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L25
            if (r1 == r4) goto L21
            if (r1 == r3) goto L1d
            if (r1 != r2) goto L15
            kotlin.ResultKt.b(r6)
            goto L51
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
            goto L33
        L25:
            kotlin.ResultKt.b(r6)
            cz.mobilesoft.coreblock.scene.lockscreen.backdoor.BackdoorCodeDialog r6 = r5.f105625b
            r5.f105624a = r4
            java.lang.Object r6 = cz.mobilesoft.coreblock.scene.lockscreen.backdoor.BackdoorCodeDialog.u(r6, r5)
            if (r6 != r0) goto L33
            goto L50
        L33:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            if (r6 == 0) goto L46
            cz.mobilesoft.coreblock.scene.lockscreen.backdoor.BackdoorCodeDialog r6 = r5.f105625b
            r5.f105624a = r3
            java.lang.Object r6 = cz.mobilesoft.coreblock.scene.lockscreen.backdoor.BackdoorCodeDialog.s(r6, r5)
            if (r6 != r0) goto L46
            goto L50
        L46:
            cz.mobilesoft.coreblock.scene.lockscreen.backdoor.BackdoorCodeDialog r6 = r5.f105625b
            r5.f105624a = r2
            java.lang.Object r6 = cz.mobilesoft.coreblock.scene.lockscreen.backdoor.BackdoorCodeDialog.n(r6, r5)
            if (r6 != r0) goto L51
        L50:
            return r0
        L51:
            java.lang.Number r6 = (java.lang.Number) r6
            long r0 = r6.longValue()
            r2 = 0
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 <= 0) goto L62
            cz.mobilesoft.coreblock.scene.lockscreen.backdoor.BackdoorCodeDialog r6 = r5.f105625b
            cz.mobilesoft.coreblock.scene.lockscreen.backdoor.BackdoorCodeDialog.v(r6)
        L62:
            kotlin.Unit r6 = kotlin.Unit.f139807a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.lockscreen.backdoor.BackdoorCodeDialog$show$2$3$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((BackdoorCodeDialog$show$2$3$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
