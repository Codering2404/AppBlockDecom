package androidx.compose.foundation.text.input.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

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
public final class AndroidTextInputSession_androidKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String[] f10202a = {"*/*", "image/*", "video/*"};

    static /* synthetic */ void c(String str, Function0 function0, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = "AndroidTextInputSession";
        }
        b(str, function0);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object d(androidx.compose.ui.platform.PlatformTextInputSession r17, androidx.compose.foundation.text.input.internal.TransformedTextFieldState r18, androidx.compose.foundation.text.input.internal.TextLayoutState r19, androidx.compose.ui.text.input.ImeOptions r20, androidx.compose.foundation.content.internal.ReceiveContentConfiguration r21, kotlin.jvm.functions.Function1 r22, kotlin.jvm.functions.Function0 r23, androidx.compose.foundation.text.input.internal.ComposeInputMethodManager r24, kotlinx.coroutines.flow.MutableSharedFlow r25, androidx.compose.ui.platform.ViewConfiguration r26, kotlin.coroutines.Continuation r27) throws java.lang.Throwable {
        /*
            r0 = r27
            boolean r1 = r0 instanceof androidx.compose.foundation.text.input.internal.AndroidTextInputSession_androidKt$platformSpecificTextInputSession$2
            if (r1 == 0) goto L15
            r1 = r0
            androidx.compose.foundation.text.input.internal.AndroidTextInputSession_androidKt$platformSpecificTextInputSession$2 r1 = (androidx.compose.foundation.text.input.internal.AndroidTextInputSession_androidKt$platformSpecificTextInputSession$2) r1
            int r2 = r1.f10206b
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.f10206b = r2
            goto L1a
        L15:
            androidx.compose.foundation.text.input.internal.AndroidTextInputSession_androidKt$platformSpecificTextInputSession$2 r1 = new androidx.compose.foundation.text.input.internal.AndroidTextInputSession_androidKt$platformSpecificTextInputSession$2
            r1.<init>(r0)
        L1a:
            java.lang.Object r0 = r1.f10205a
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r3 = r1.f10206b
            r4 = 1
            if (r3 == 0) goto L33
            if (r3 == r4) goto L2f
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L2f:
            kotlin.ResultKt.b(r0)
            goto L5a
        L33:
            kotlin.ResultKt.b(r0)
            androidx.compose.foundation.text.input.internal.AndroidTextInputSession_androidKt$platformSpecificTextInputSession$3 r5 = new androidx.compose.foundation.text.input.internal.AndroidTextInputSession_androidKt$platformSpecificTextInputSession$3
            r16 = 0
            r10 = r17
            r7 = r18
            r8 = r19
            r11 = r20
            r12 = r21
            r13 = r22
            r14 = r23
            r9 = r24
            r6 = r25
            r15 = r26
            r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            r1.f10206b = r4
            java.lang.Object r0 = kotlinx.coroutines.CoroutineScopeKt.f(r5, r1)
            if (r0 != r2) goto L5a
            return r2
        L5a:
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.AndroidTextInputSession_androidKt.d(androidx.compose.ui.platform.PlatformTextInputSession, androidx.compose.foundation.text.input.internal.TransformedTextFieldState, androidx.compose.foundation.text.input.internal.TextLayoutState, androidx.compose.ui.text.input.ImeOptions, androidx.compose.foundation.content.internal.ReceiveContentConfiguration, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function0, androidx.compose.foundation.text.input.internal.ComposeInputMethodManager, kotlinx.coroutines.flow.MutableSharedFlow, androidx.compose.ui.platform.ViewConfiguration, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object e(androidx.compose.ui.platform.PlatformTextInputSession r13, androidx.compose.foundation.text.input.internal.TransformedTextFieldState r14, androidx.compose.foundation.text.input.internal.TextLayoutState r15, androidx.compose.ui.text.input.ImeOptions r16, androidx.compose.foundation.content.internal.ReceiveContentConfiguration r17, kotlin.jvm.functions.Function1 r18, kotlin.jvm.functions.Function0 r19, kotlinx.coroutines.flow.MutableSharedFlow r20, androidx.compose.ui.platform.ViewConfiguration r21, kotlin.coroutines.Continuation r22) throws java.lang.Throwable {
        /*
            r0 = r22
            boolean r1 = r0 instanceof androidx.compose.foundation.text.input.internal.AndroidTextInputSession_androidKt$platformSpecificTextInputSession$1
            if (r1 == 0) goto L16
            r1 = r0
            androidx.compose.foundation.text.input.internal.AndroidTextInputSession_androidKt$platformSpecificTextInputSession$1 r1 = (androidx.compose.foundation.text.input.internal.AndroidTextInputSession_androidKt$platformSpecificTextInputSession$1) r1
            int r2 = r1.f10204b
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L16
            int r2 = r2 - r3
            r1.f10204b = r2
        L14:
            r12 = r1
            goto L1c
        L16:
            androidx.compose.foundation.text.input.internal.AndroidTextInputSession_androidKt$platformSpecificTextInputSession$1 r1 = new androidx.compose.foundation.text.input.internal.AndroidTextInputSession_androidKt$platformSpecificTextInputSession$1
            r1.<init>(r0)
            goto L14
        L1c:
            java.lang.Object r0 = r12.f10203a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r12.f10204b
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 == r3) goto L31
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L31:
            kotlin.ResultKt.b(r0)
            goto L58
        L35:
            kotlin.ResultKt.b(r0)
            android.view.View r0 = r13.a()
            androidx.compose.foundation.text.input.internal.ComposeInputMethodManager r9 = androidx.compose.foundation.text.input.internal.ComposeInputMethodManager_androidKt.a(r0)
            r12.f10204b = r3
            r2 = r13
            r3 = r14
            r4 = r15
            r5 = r16
            r6 = r17
            r7 = r18
            r8 = r19
            r10 = r20
            r11 = r21
            java.lang.Object r13 = d(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            if (r13 != r1) goto L58
            return r1
        L58:
            kotlin.KotlinNothingValueException r13 = new kotlin.KotlinNothingValueException
            r13.<init>()
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.AndroidTextInputSession_androidKt.e(androidx.compose.ui.platform.PlatformTextInputSession, androidx.compose.foundation.text.input.internal.TransformedTextFieldState, androidx.compose.foundation.text.input.internal.TextLayoutState, androidx.compose.ui.text.input.ImeOptions, androidx.compose.foundation.content.internal.ReceiveContentConfiguration, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function0, kotlinx.coroutines.flow.MutableSharedFlow, androidx.compose.ui.platform.ViewConfiguration, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final void b(String str, Function0 function0) {
    }
}
