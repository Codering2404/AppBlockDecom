package androidx.compose.foundation.lazy.layout;

import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.OnGloballyPositionedModifier;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

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
public final class AwaitFirstLayoutModifier implements OnGloballyPositionedModifier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f7979a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Continuation f7980b;

    @Override // androidx.compose.ui.layout.OnGloballyPositionedModifier
    public void I(LayoutCoordinates layoutCoordinates) {
        if (this.f7979a) {
            return;
        }
        this.f7979a = true;
        Continuation continuation = this.f7980b;
        if (continuation != null) {
            Result.Companion companion = Result.f139772b;
            continuation.resumeWith(Result.b(Unit.f139807a));
        }
        this.f7980b = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object b(kotlin.coroutines.Continuation r6) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r6 instanceof androidx.compose.foundation.lazy.layout.AwaitFirstLayoutModifier$waitForFirstLayout$1
            if (r0 == 0) goto L13
            r0 = r6
            androidx.compose.foundation.lazy.layout.AwaitFirstLayoutModifier$waitForFirstLayout$1 r0 = (androidx.compose.foundation.lazy.layout.AwaitFirstLayoutModifier$waitForFirstLayout$1) r0
            int r1 = r0.f7985f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f7985f = r1
            goto L18
        L13:
            androidx.compose.foundation.lazy.layout.AwaitFirstLayoutModifier$waitForFirstLayout$1 r0 = new androidx.compose.foundation.lazy.layout.AwaitFirstLayoutModifier$waitForFirstLayout$1
            r0.<init>(r5, r6)
        L18:
            java.lang.Object r6 = r0.f7983c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f7985f
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r1 = r0.f7982b
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            java.lang.Object r0 = r0.f7981a
            androidx.compose.foundation.lazy.layout.AwaitFirstLayoutModifier r0 = (androidx.compose.foundation.lazy.layout.AwaitFirstLayoutModifier) r0
            kotlin.ResultKt.b(r6)
            goto L68
        L31:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L39:
            kotlin.ResultKt.b(r6)
            boolean r6 = r5.f7979a
            if (r6 != 0) goto L75
            kotlin.coroutines.Continuation r6 = r5.f7980b
            r0.f7981a = r5
            r0.f7982b = r6
            r0.f7985f = r3
            kotlinx.coroutines.CancellableContinuationImpl r2 = new kotlinx.coroutines.CancellableContinuationImpl
            kotlin.coroutines.Continuation r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.c(r0)
            r2.<init>(r4, r3)
            r2.C()
            a(r5, r2)
            java.lang.Object r2 = r2.v()
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            if (r2 != r3) goto L64
            kotlin.coroutines.jvm.internal.DebugProbesKt.c(r0)
        L64:
            if (r2 != r1) goto L67
            return r1
        L67:
            r1 = r6
        L68:
            if (r1 == 0) goto L75
            kotlin.Result$Companion r6 = kotlin.Result.f139772b
            kotlin.Unit r6 = kotlin.Unit.f139807a
            java.lang.Object r6 = kotlin.Result.b(r6)
            r1.resumeWith(r6)
        L75:
            kotlin.Unit r6 = kotlin.Unit.f139807a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.layout.AwaitFirstLayoutModifier.b(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
