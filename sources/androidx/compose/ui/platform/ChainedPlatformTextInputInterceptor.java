package androidx.compose.ui.platform;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import kotlin.Metadata;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
final class ChainedPlatformTextInputInterceptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ChainedPlatformTextInputInterceptor f27932a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MutableState f27933b;

    public ChainedPlatformTextInputInterceptor(PlatformTextInputInterceptor platformTextInputInterceptor, ChainedPlatformTextInputInterceptor chainedPlatformTextInputInterceptor) {
        this.f27932a = chainedPlatformTextInputInterceptor;
        this.f27933b = SnapshotStateKt__SnapshotStateKt.e(platformTextInputInterceptor, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PlatformTextInputInterceptor b() {
        return (PlatformTextInputInterceptor) this.f27933b.getValue();
    }

    private final void c(PlatformTextInputInterceptor platformTextInputInterceptor) {
        this.f27933b.setValue(platformTextInputInterceptor);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object d(androidx.compose.ui.node.Owner r6, kotlin.jvm.functions.Function2 r7, kotlin.coroutines.Continuation r8) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r8 instanceof androidx.compose.ui.platform.ChainedPlatformTextInputInterceptor$textInputSession$1
            if (r0 == 0) goto L13
            r0 = r8
            androidx.compose.ui.platform.ChainedPlatformTextInputInterceptor$textInputSession$1 r0 = (androidx.compose.ui.platform.ChainedPlatformTextInputInterceptor$textInputSession$1) r0
            int r1 = r0.f27936c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f27936c = r1
            goto L18
        L13:
            androidx.compose.ui.platform.ChainedPlatformTextInputInterceptor$textInputSession$1 r0 = new androidx.compose.ui.platform.ChainedPlatformTextInputInterceptor$textInputSession$1
            r0.<init>(r5, r8)
        L18:
            java.lang.Object r8 = r0.f27934a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f27936c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 == r3) goto L2d
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L2d:
            kotlin.ResultKt.b(r8)
            goto L45
        L31:
            kotlin.ResultKt.b(r8)
            androidx.compose.ui.platform.ChainedPlatformTextInputInterceptor r8 = r5.f27932a
            androidx.compose.ui.platform.ChainedPlatformTextInputInterceptor$textInputSession$2 r2 = new androidx.compose.ui.platform.ChainedPlatformTextInputInterceptor$textInputSession$2
            r4 = 0
            r2.<init>(r7, r5, r4)
            r0.f27936c = r3
            java.lang.Object r6 = androidx.compose.ui.platform.PlatformTextInputModifierNodeKt.b(r6, r8, r2, r0)
            if (r6 != r1) goto L45
            return r1
        L45:
            kotlin.KotlinNothingValueException r6 = new kotlin.KotlinNothingValueException
            r6.<init>()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.ChainedPlatformTextInputInterceptor.d(androidx.compose.ui.node.Owner, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void e(PlatformTextInputInterceptor platformTextInputInterceptor) {
        c(platformTextInputInterceptor);
    }
}
