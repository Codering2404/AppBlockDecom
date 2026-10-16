package androidx.compose.foundation.relocation;

import androidx.compose.runtime.collection.MutableVector;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
final class BringIntoViewRequesterImpl implements BringIntoViewRequester {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MutableVector f8920a = new MutableVector(new BringIntoViewRequesterNode[16], 0);

    /* JADX WARN: Removed duplicated region for block: B:16:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0069 -> B:19:0x006c). Please report as a decompilation issue!!! */
    @Override // androidx.compose.foundation.relocation.BringIntoViewRequester
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object b(androidx.compose.ui.geometry.Rect r9, kotlin.coroutines.Continuation r10) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r10 instanceof androidx.compose.foundation.relocation.BringIntoViewRequesterImpl$bringIntoView$1
            if (r0 == 0) goto L13
            r0 = r10
            androidx.compose.foundation.relocation.BringIntoViewRequesterImpl$bringIntoView$1 r0 = (androidx.compose.foundation.relocation.BringIntoViewRequesterImpl$bringIntoView$1) r0
            int r1 = r0.f8927h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f8927h = r1
            goto L18
        L13:
            androidx.compose.foundation.relocation.BringIntoViewRequesterImpl$bringIntoView$1 r0 = new androidx.compose.foundation.relocation.BringIntoViewRequesterImpl$bringIntoView$1
            r0.<init>(r8, r10)
        L18:
            java.lang.Object r10 = r0.f8925f
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f8927h
            r3 = 1
            if (r2 == 0) goto L3e
            if (r2 != r3) goto L36
            int r9 = r0.f8924d
            int r2 = r0.f8923c
            java.lang.Object r4 = r0.f8922b
            java.lang.Object[] r4 = (java.lang.Object[]) r4
            java.lang.Object r5 = r0.f8921a
            androidx.compose.ui.geometry.Rect r5 = (androidx.compose.ui.geometry.Rect) r5
            kotlin.ResultKt.b(r10)
            r10 = r5
            goto L6c
        L36:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L3e:
            kotlin.ResultKt.b(r10)
            androidx.compose.runtime.collection.MutableVector r10 = r8.f8920a
            java.lang.Object[] r2 = r10.f24389a
            int r10 = r10.o()
            r4 = 0
            r7 = r10
            r10 = r9
            r9 = r7
            r7 = r4
            r4 = r2
            r2 = r7
        L50:
            if (r2 >= r9) goto L6e
            r5 = r4[r2]
            androidx.compose.foundation.relocation.BringIntoViewRequesterNode r5 = (androidx.compose.foundation.relocation.BringIntoViewRequesterNode) r5
            androidx.compose.foundation.relocation.BringIntoViewRequesterImpl$bringIntoView$2$1 r6 = new androidx.compose.foundation.relocation.BringIntoViewRequesterImpl$bringIntoView$2$1
            r6.<init>()
            r0.f8921a = r10
            r0.f8922b = r4
            r0.f8923c = r2
            r0.f8924d = r9
            r0.f8927h = r3
            java.lang.Object r5 = androidx.compose.ui.relocation.BringIntoViewModifierNodeKt.a(r5, r6, r0)
            if (r5 != r1) goto L6c
            return r1
        L6c:
            int r2 = r2 + r3
            goto L50
        L6e:
            kotlin.Unit r9 = kotlin.Unit.f139807a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.relocation.BringIntoViewRequesterImpl.b(androidx.compose.ui.geometry.Rect, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final MutableVector c() {
        return this.f8920a;
    }
}
