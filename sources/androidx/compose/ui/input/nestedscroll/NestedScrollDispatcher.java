package androidx.compose.ui.input.nestedscroll;

import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
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
public final class NestedScrollDispatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private NestedScrollNode f26742a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private NestedScrollNode f26743b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Function0 f26744c = new Function0<CoroutineScope>() { // from class: androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher$calculateNestedScrollScope$1
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final CoroutineScope invoke() {
            return this.f26746a.h();
        }
    };

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private CoroutineScope f26745d;

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0053, code lost:
    
        if (r12 == r0) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0072, code lost:
    
        if (r12 == r0) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0074, code lost:
    
        return r0;
     */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(long r8, long r10, kotlin.coroutines.Continuation r12) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r12 instanceof androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher$dispatchPostFling$1
            if (r0 == 0) goto L14
            r0 = r12
            androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher$dispatchPostFling$1 r0 = (androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher$dispatchPostFling$1) r0
            int r1 = r0.f26749c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.f26749c = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher$dispatchPostFling$1 r0 = new androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher$dispatchPostFling$1
            r0.<init>(r7, r12)
            goto L12
        L1a:
            java.lang.Object r12 = r6.f26747a
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r6.f26749c
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L3a
            if (r1 == r3) goto L36
            if (r1 != r2) goto L2e
            kotlin.ResultKt.b(r12)
            goto L75
        L2e:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L36:
            kotlin.ResultKt.b(r12)
            goto L56
        L3a:
            kotlin.ResultKt.b(r12)
            androidx.compose.ui.input.nestedscroll.NestedScrollConnection r12 = r7.g()
            if (r12 != 0) goto L64
            boolean r12 = androidx.compose.ui.ComposeUiFlags.f25103c
            if (r12 == 0) goto L64
            androidx.compose.ui.input.nestedscroll.NestedScrollNode r1 = r7.f26743b
            if (r1 == 0) goto L5d
            r6.f26749c = r3
            r2 = r8
            r4 = r10
            java.lang.Object r12 = r1.Y(r2, r4, r6)
            if (r12 != r0) goto L56
            goto L74
        L56:
            androidx.compose.ui.unit.Velocity r12 = (androidx.compose.ui.unit.Velocity) r12
            long r8 = r12.o()
            goto L82
        L5d:
            androidx.compose.ui.unit.Velocity$Companion r8 = androidx.compose.ui.unit.Velocity.f30015b
            long r8 = r8.a()
            goto L82
        L64:
            r4 = r10
            androidx.compose.ui.input.nestedscroll.NestedScrollConnection r1 = r7.g()
            if (r1 == 0) goto L7c
            r6.f26749c = r2
            r2 = r8
            java.lang.Object r12 = r1.Y(r2, r4, r6)
            if (r12 != r0) goto L75
        L74:
            return r0
        L75:
            androidx.compose.ui.unit.Velocity r12 = (androidx.compose.ui.unit.Velocity) r12
            long r8 = r12.o()
            goto L82
        L7c:
            androidx.compose.ui.unit.Velocity$Companion r8 = androidx.compose.ui.unit.Velocity.f30015b
            long r8 = r8.a()
        L82:
            androidx.compose.ui.unit.Velocity r8 = androidx.compose.ui.unit.Velocity.b(r8)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher.a(long, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final long b(long j3, long j4, int i3) {
        NestedScrollConnection nestedScrollConnectionG = g();
        return nestedScrollConnectionG != null ? nestedScrollConnectionG.H0(j3, j4, i3) : Offset.f25596b.c();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object c(long r5, kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r7 instanceof androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher$dispatchPreFling$1
            if (r0 == 0) goto L13
            r0 = r7
            androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher$dispatchPreFling$1 r0 = (androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher$dispatchPreFling$1) r0
            int r1 = r0.f26752c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f26752c = r1
            goto L18
        L13:
            androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher$dispatchPreFling$1 r0 = new androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher$dispatchPreFling$1
            r0.<init>(r4, r7)
        L18:
            java.lang.Object r7 = r0.f26750a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f26752c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.b(r7)
            goto L43
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            kotlin.ResultKt.b(r7)
            androidx.compose.ui.input.nestedscroll.NestedScrollConnection r7 = r4.g()
            if (r7 == 0) goto L4a
            r0.f26752c = r3
            java.lang.Object r7 = r7.R1(r5, r0)
            if (r7 != r1) goto L43
            return r1
        L43:
            androidx.compose.ui.unit.Velocity r7 = (androidx.compose.ui.unit.Velocity) r7
            long r5 = r7.o()
            goto L50
        L4a:
            androidx.compose.ui.unit.Velocity$Companion r5 = androidx.compose.ui.unit.Velocity.f30015b
            long r5 = r5.a()
        L50:
            androidx.compose.ui.unit.Velocity r5 = androidx.compose.ui.unit.Velocity.b(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher.c(long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final long d(long j3, int i3) {
        NestedScrollConnection nestedScrollConnectionG = g();
        return nestedScrollConnectionG != null ? nestedScrollConnectionG.J1(j3, i3) : Offset.f25596b.c();
    }

    public final CoroutineScope e() {
        CoroutineScope coroutineScope = (CoroutineScope) this.f26744c.invoke();
        if (coroutineScope != null) {
            return coroutineScope;
        }
        throw new IllegalStateException("in order to access nested coroutine scope you need to attach dispatcher to the `Modifier.nestedScroll` first.");
    }

    public final NestedScrollNode f() {
        return this.f26742a;
    }

    public final NestedScrollConnection g() {
        NestedScrollNode nestedScrollNode = this.f26742a;
        if (nestedScrollNode != null) {
            return nestedScrollNode.p2();
        }
        return null;
    }

    public final CoroutineScope h() {
        return this.f26745d;
    }

    public final void i(Function0 function0) {
        this.f26744c = function0;
    }

    public final void j(NestedScrollNode nestedScrollNode) {
        this.f26743b = nestedScrollNode;
    }

    public final void k(NestedScrollNode nestedScrollNode) {
        this.f26742a = nestedScrollNode;
    }

    public final void l(CoroutineScope coroutineScope) {
        this.f26745d = coroutineScope;
    }
}
