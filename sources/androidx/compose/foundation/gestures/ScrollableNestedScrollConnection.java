package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
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
final class ScrollableNestedScrollConnection implements NestedScrollConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ScrollingLogic f6099a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f6100b;

    public ScrollableNestedScrollConnection(ScrollingLogic scrollingLogic, boolean z2) {
        this.f6099a = scrollingLogic;
        this.f6100b = z2;
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    public long H0(long j3, long j4, int i3) {
        return this.f6100b ? this.f6099a.v(j4) : Offset.f25596b.c();
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0060, code lost:
    
        if (r5 == r8) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0074, code lost:
    
        if (r5 == r8) goto L29;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object Y(long r4, long r6, kotlin.coroutines.Continuation r8) throws java.lang.Throwable {
        /*
            r3 = this;
            boolean r4 = r8 instanceof androidx.compose.foundation.gestures.ScrollableNestedScrollConnection$onPostFling$1
            if (r4 == 0) goto L13
            r4 = r8
            androidx.compose.foundation.gestures.ScrollableNestedScrollConnection$onPostFling$1 r4 = (androidx.compose.foundation.gestures.ScrollableNestedScrollConnection$onPostFling$1) r4
            int r5 = r4.f6104d
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r5 & r0
            if (r1 == 0) goto L13
            int r5 = r5 - r0
            r4.f6104d = r5
            goto L18
        L13:
            androidx.compose.foundation.gestures.ScrollableNestedScrollConnection$onPostFling$1 r4 = new androidx.compose.foundation.gestures.ScrollableNestedScrollConnection$onPostFling$1
            r4.<init>(r3, r8)
        L18:
            java.lang.Object r5 = r4.f6102b
            java.lang.Object r8 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r0 = r4.f6104d
            r1 = 2
            r2 = 1
            if (r0 == 0) goto L3c
            if (r0 == r2) goto L36
            if (r0 != r1) goto L2e
            long r6 = r4.f6101a
            kotlin.ResultKt.b(r5)
            goto L77
        L2e:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L36:
            long r6 = r4.f6101a
            kotlin.ResultKt.b(r5)
            goto L63
        L3c:
            kotlin.ResultKt.b(r5)
            boolean r5 = r3.f6100b
            if (r5 == 0) goto L82
            boolean r5 = androidx.compose.foundation.ComposeFoundationFlags.f4886b
            if (r5 == 0) goto L6a
            androidx.compose.foundation.gestures.ScrollingLogic r5 = r3.f6099a
            boolean r5 = r5.s()
            if (r5 == 0) goto L56
            androidx.compose.ui.unit.Velocity$Companion r4 = androidx.compose.ui.unit.Velocity.f30015b
            long r4 = r4.a()
            goto L7d
        L56:
            androidx.compose.foundation.gestures.ScrollingLogic r5 = r3.f6099a
            r4.f6101a = r6
            r4.f6104d = r2
            java.lang.Object r5 = r5.p(r6, r4)
            if (r5 != r8) goto L63
            goto L76
        L63:
            androidx.compose.ui.unit.Velocity r5 = (androidx.compose.ui.unit.Velocity) r5
            long r4 = r5.o()
            goto L7d
        L6a:
            androidx.compose.foundation.gestures.ScrollingLogic r5 = r3.f6099a
            r4.f6101a = r6
            r4.f6104d = r1
            java.lang.Object r5 = r5.p(r6, r4)
            if (r5 != r8) goto L77
        L76:
            return r8
        L77:
            androidx.compose.ui.unit.Velocity r5 = (androidx.compose.ui.unit.Velocity) r5
            long r4 = r5.o()
        L7d:
            long r4 = androidx.compose.ui.unit.Velocity.k(r6, r4)
            goto L88
        L82:
            androidx.compose.ui.unit.Velocity$Companion r4 = androidx.compose.ui.unit.Velocity.f30015b
            long r4 = r4.a()
        L88:
            androidx.compose.ui.unit.Velocity r4 = androidx.compose.ui.unit.Velocity.b(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ScrollableNestedScrollConnection.Y(long, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void a(boolean z2) {
        this.f6100b = z2;
    }
}
