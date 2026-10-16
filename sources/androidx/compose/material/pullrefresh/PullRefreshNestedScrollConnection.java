package androidx.compose.material.pullrefresh;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

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
final class PullRefreshNestedScrollConnection implements NestedScrollConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function1 f15283a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function2 f15284b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f15285c;

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    public long H0(long j3, long j4, int i3) {
        return !this.f15285c ? Offset.f25596b.c() : (!NestedScrollSource.e(i3, NestedScrollSource.f26772b.b()) || Offset.n(j4) <= 0.0f) ? Offset.f25596b.c() : OffsetKt.a(0.0f, ((Number) this.f15283a.invoke(Float.valueOf(Offset.n(j4)))).floatValue());
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    public long J1(long j3, int i3) {
        return !this.f15285c ? Offset.f25596b.c() : (!NestedScrollSource.e(i3, NestedScrollSource.f26772b.b()) || Offset.n(j3) >= 0.0f) ? Offset.f25596b.c() : OffsetKt.a(0.0f, ((Number) this.f15283a.invoke(Float.valueOf(Offset.n(j3)))).floatValue());
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object R1(long r5, kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r7 instanceof androidx.compose.material.pullrefresh.PullRefreshNestedScrollConnection$onPreFling$1
            if (r0 == 0) goto L13
            r0 = r7
            androidx.compose.material.pullrefresh.PullRefreshNestedScrollConnection$onPreFling$1 r0 = (androidx.compose.material.pullrefresh.PullRefreshNestedScrollConnection$onPreFling$1) r0
            int r1 = r0.f15289d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f15289d = r1
            goto L18
        L13:
            androidx.compose.material.pullrefresh.PullRefreshNestedScrollConnection$onPreFling$1 r0 = new androidx.compose.material.pullrefresh.PullRefreshNestedScrollConnection$onPreFling$1
            r0.<init>(r4, r7)
        L18:
            java.lang.Object r7 = r0.f15287b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f15289d
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            float r5 = r0.f15286a
            kotlin.ResultKt.b(r7)
            goto L4d
        L2b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L33:
            kotlin.ResultKt.b(r7)
            kotlin.jvm.functions.Function2 r7 = r4.f15284b
            float r5 = androidx.compose.ui.unit.Velocity.i(r5)
            java.lang.Float r5 = kotlin.coroutines.jvm.internal.Boxing.c(r5)
            r6 = 0
            r0.f15286a = r6
            r0.f15289d = r3
            java.lang.Object r7 = r7.invoke(r5, r0)
            if (r7 != r1) goto L4c
            return r1
        L4c:
            r5 = r6
        L4d:
            java.lang.Number r7 = (java.lang.Number) r7
            float r6 = r7.floatValue()
            long r5 = androidx.compose.ui.unit.VelocityKt.a(r5, r6)
            androidx.compose.ui.unit.Velocity r5 = androidx.compose.ui.unit.Velocity.b(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.pullrefresh.PullRefreshNestedScrollConnection.R1(long, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
