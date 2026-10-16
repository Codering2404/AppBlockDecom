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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.lockscreen.backdoor.BackdoorCodeDialog$startCountdown$1", f = "BackdoorCodeDialog.kt", l = {129, 137}, m = "invokeSuspend", v = 1)
final class BackdoorCodeDialog$startCountdown$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    long f105645a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f105646b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f105647c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ BackdoorCodeDialog f105648d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BackdoorCodeDialog$startCountdown$1(BackdoorCodeDialog backdoorCodeDialog, Continuation continuation) {
        super(2, continuation);
        this.f105648d = backdoorCodeDialog;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new BackdoorCodeDialog$startCountdown$1(this.f105648d, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0029 A[PHI: r13
      0x0029: PHI (r13v3 java.lang.Object) = (r13v2 java.lang.Object), (r13v0 java.lang.Object) binds: [B:12:0x0026, B:9:0x0017] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0095  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0092 -> B:11:0x001e). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) throws java.lang.Throwable {
        /*
            r12 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r12.f105647c
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1b
            if (r1 == r3) goto L17
            if (r1 != r2) goto Lf
            goto L1b
        Lf:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L17:
            kotlin.ResultKt.b(r13)
            goto L29
        L1b:
            kotlin.ResultKt.b(r13)
        L1e:
            cz.mobilesoft.coreblock.scene.lockscreen.backdoor.BackdoorCodeDialog r13 = r12.f105648d
            r12.f105647c = r3
            java.lang.Object r13 = cz.mobilesoft.coreblock.scene.lockscreen.backdoor.BackdoorCodeDialog.n(r13, r12)
            if (r13 != r0) goto L29
            goto L94
        L29:
            java.lang.Number r13 = (java.lang.Number) r13
            long r4 = r13.longValue()
            r6 = 0
            int r13 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            java.lang.String r1 = "countdownTextView"
            r6 = 0
            java.lang.String r7 = "binding"
            if (r13 <= 0) goto L95
            r13 = 1000(0x3e8, float:1.401E-42)
            long r8 = (long) r13
            long r8 = r4 / r8
            int r13 = (int) r8
            cz.mobilesoft.coreblock.scene.lockscreen.backdoor.BackdoorCodeDialog r8 = r12.f105648d
            cz.mobilesoft.coreblock.databinding.DialogRichEditTextBinding r8 = cz.mobilesoft.coreblock.scene.lockscreen.backdoor.BackdoorCodeDialog.j(r8)
            if (r8 != 0) goto L4c
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r7)
            r8 = r6
        L4c:
            android.widget.TextView r8 = r8.f96532c
            cz.mobilesoft.coreblock.scene.lockscreen.backdoor.BackdoorCodeDialog r9 = r12.f105648d
            android.content.Context r9 = r9.B()
            int r10 = cz.mobilesoft.coreblock.R.string.E2
            java.lang.Integer r11 = kotlin.coroutines.jvm.internal.Boxing.d(r13)
            java.lang.Object[] r11 = new java.lang.Object[]{r11}
            java.lang.String r9 = r9.getString(r10, r11)
            r8.setText(r9)
            cz.mobilesoft.coreblock.scene.lockscreen.backdoor.BackdoorCodeDialog r8 = r12.f105648d
            cz.mobilesoft.coreblock.databinding.DialogRichEditTextBinding r8 = cz.mobilesoft.coreblock.scene.lockscreen.backdoor.BackdoorCodeDialog.j(r8)
            if (r8 != 0) goto L71
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r7)
            goto L72
        L71:
            r6 = r8
        L72:
            android.widget.TextView r6 = r6.f96532c
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r1)
            r1 = 0
            r6.setVisibility(r1)
            cz.mobilesoft.coreblock.scene.lockscreen.backdoor.BackdoorCodeDialog r6 = r12.f105648d
            android.widget.Button r6 = cz.mobilesoft.coreblock.scene.lockscreen.backdoor.BackdoorCodeDialog.m(r6)
            if (r6 == 0) goto L86
            r6.setEnabled(r1)
        L86:
            r12.f105645a = r4
            r12.f105646b = r13
            r12.f105647c = r2
            r4 = 1000(0x3e8, double:4.94E-321)
            java.lang.Object r13 = kotlinx.coroutines.DelayKt.b(r4, r12)
            if (r13 != r0) goto L1e
        L94:
            return r0
        L95:
            cz.mobilesoft.coreblock.scene.lockscreen.backdoor.BackdoorCodeDialog r13 = r12.f105648d
            cz.mobilesoft.coreblock.databinding.DialogRichEditTextBinding r13 = cz.mobilesoft.coreblock.scene.lockscreen.backdoor.BackdoorCodeDialog.j(r13)
            if (r13 != 0) goto La1
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r7)
            goto La2
        La1:
            r6 = r13
        La2:
            android.widget.TextView r13 = r6.f96532c
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, r1)
            r0 = 8
            r13.setVisibility(r0)
            cz.mobilesoft.coreblock.scene.lockscreen.backdoor.BackdoorCodeDialog r13 = r12.f105648d
            android.widget.Button r13 = cz.mobilesoft.coreblock.scene.lockscreen.backdoor.BackdoorCodeDialog.m(r13)
            if (r13 == 0) goto Lb7
            r13.setEnabled(r3)
        Lb7:
            kotlin.Unit r13 = kotlin.Unit.f139807a
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.lockscreen.backdoor.BackdoorCodeDialog$startCountdown$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((BackdoorCodeDialog$startCountdown$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
