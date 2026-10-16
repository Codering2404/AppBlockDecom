package androidx.compose.ui.input.nestedscroll;

import androidx.compose.ui.ComposeUiFlags;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.node.TraversableNodeKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
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
public final class NestedScrollNode extends Modifier.Node implements TraversableNode, NestedScrollConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private NestedScrollConnection f26755a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private NestedScrollDispatcher f26756b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private NestedScrollNode f26757c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Object f26758d;

    public NestedScrollNode(NestedScrollConnection nestedScrollConnection, NestedScrollDispatcher nestedScrollDispatcher) {
        this.f26755a = nestedScrollConnection;
        this.f26756b = nestedScrollDispatcher == null ? new NestedScrollDispatcher() : nestedScrollDispatcher;
        this.f26758d = "androidx.compose.ui.input.nestedscroll.NestedScrollNode";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CoroutineScope n2() {
        CoroutineScope coroutineScopeN2;
        NestedScrollNode nestedScrollNodeP2 = p2();
        if (nestedScrollNodeP2 != null && (coroutineScopeN2 = nestedScrollNodeP2.n2()) != null) {
            return coroutineScopeN2;
        }
        CoroutineScope coroutineScopeH = this.f26756b.h();
        if (coroutineScopeH != null) {
            return coroutineScopeH;
        }
        throw new IllegalStateException("in order to access nested coroutine scope you need to attach dispatcher to the `Modifier.nestedScroll` first.");
    }

    private final NestedScrollConnection o2() {
        if (isAttached()) {
            return p2();
        }
        return null;
    }

    private final void q2() {
        if (this.f26756b.f() == this) {
            this.f26756b.k(null);
        }
    }

    private final void r2(NestedScrollDispatcher nestedScrollDispatcher) {
        q2();
        if (nestedScrollDispatcher == null) {
            this.f26756b = new NestedScrollDispatcher();
        } else if (!Intrinsics.areEqual(nestedScrollDispatcher, this.f26756b)) {
            this.f26756b = nestedScrollDispatcher;
        }
        if (isAttached()) {
            s2();
        }
    }

    private final void s2() {
        this.f26756b.k(this);
        if (ComposeUiFlags.f25103c) {
            this.f26756b.j(null);
            this.f26757c = null;
        }
        this.f26756b.i(new Function0<CoroutineScope>() { // from class: androidx.compose.ui.input.nestedscroll.NestedScrollNode$updateDispatcherFields$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final CoroutineScope invoke() {
                return this.f26770a.n2();
            }
        });
        this.f26756b.l(getCoroutineScope());
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    public long H0(long j3, long j4, int i3) {
        long jH0 = this.f26755a.H0(j3, j4, i3);
        NestedScrollConnection nestedScrollConnectionO2 = o2();
        return Offset.q(jH0, nestedScrollConnectionO2 != null ? nestedScrollConnectionO2.H0(Offset.q(j3, jH0), Offset.p(j4, jH0), i3) : Offset.f25596b.c());
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    public long J1(long j3, int i3) {
        NestedScrollConnection nestedScrollConnectionO2 = o2();
        long jJ1 = nestedScrollConnectionO2 != null ? nestedScrollConnectionO2.J1(j3, i3) : Offset.f25596b.c();
        return Offset.q(jJ1, this.f26755a.J1(Offset.p(j3, jJ1), i3));
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x007a, code lost:
    
        if (r11 != r1) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object R1(long r9, kotlin.coroutines.Continuation r11) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r11 instanceof androidx.compose.ui.input.nestedscroll.NestedScrollNode$onPreFling$1
            if (r0 == 0) goto L13
            r0 = r11
            androidx.compose.ui.input.nestedscroll.NestedScrollNode$onPreFling$1 r0 = (androidx.compose.ui.input.nestedscroll.NestedScrollNode$onPreFling$1) r0
            int r1 = r0.f26769f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f26769f = r1
            goto L18
        L13:
            androidx.compose.ui.input.nestedscroll.NestedScrollNode$onPreFling$1 r0 = new androidx.compose.ui.input.nestedscroll.NestedScrollNode$onPreFling$1
            r0.<init>(r8, r11)
        L18:
            java.lang.Object r11 = r0.f26767c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f26769f
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L40
            if (r2 == r4) goto L36
            if (r2 != r3) goto L2e
            long r9 = r0.f26766b
            kotlin.ResultKt.b(r11)
            goto L7d
        L2e:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L36:
            long r9 = r0.f26766b
            java.lang.Object r2 = r0.f26765a
            androidx.compose.ui.input.nestedscroll.NestedScrollNode r2 = (androidx.compose.ui.input.nestedscroll.NestedScrollNode) r2
            kotlin.ResultKt.b(r11)
            goto L57
        L40:
            kotlin.ResultKt.b(r11)
            androidx.compose.ui.input.nestedscroll.NestedScrollConnection r11 = r8.o2()
            if (r11 == 0) goto L61
            r0.f26765a = r8
            r0.f26766b = r9
            r0.f26769f = r4
            java.lang.Object r11 = r11.R1(r9, r0)
            if (r11 != r1) goto L56
            goto L7c
        L56:
            r2 = r8
        L57:
            androidx.compose.ui.unit.Velocity r11 = (androidx.compose.ui.unit.Velocity) r11
            long r4 = r11.o()
        L5d:
            r6 = r4
            r4 = r9
            r9 = r6
            goto L69
        L61:
            androidx.compose.ui.unit.Velocity$Companion r11 = androidx.compose.ui.unit.Velocity.f30015b
            long r4 = r11.a()
            r2 = r8
            goto L5d
        L69:
            androidx.compose.ui.input.nestedscroll.NestedScrollConnection r11 = r2.f26755a
            long r4 = androidx.compose.ui.unit.Velocity.k(r4, r9)
            r2 = 0
            r0.f26765a = r2
            r0.f26766b = r9
            r0.f26769f = r3
            java.lang.Object r11 = r11.R1(r4, r0)
            if (r11 != r1) goto L7d
        L7c:
            return r1
        L7d:
            androidx.compose.ui.unit.Velocity r11 = (androidx.compose.ui.unit.Velocity) r11
            long r0 = r11.o()
            long r9 = androidx.compose.ui.unit.Velocity.l(r9, r0)
            androidx.compose.ui.unit.Velocity r9 = androidx.compose.ui.unit.Velocity.b(r9)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.nestedscroll.NestedScrollNode.R1(long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // androidx.compose.ui.node.TraversableNode
    public Object U() {
        return this.f26758d;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object Y(long r11, long r13, kotlin.coroutines.Continuation r15) throws java.lang.Throwable {
        /*
            r10 = this;
            boolean r0 = r15 instanceof androidx.compose.ui.input.nestedscroll.NestedScrollNode$onPostFling$1
            if (r0 == 0) goto L14
            r0 = r15
            androidx.compose.ui.input.nestedscroll.NestedScrollNode$onPostFling$1 r0 = (androidx.compose.ui.input.nestedscroll.NestedScrollNode$onPostFling$1) r0
            int r1 = r0.f26764g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.f26764g = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            androidx.compose.ui.input.nestedscroll.NestedScrollNode$onPostFling$1 r0 = new androidx.compose.ui.input.nestedscroll.NestedScrollNode$onPostFling$1
            r0.<init>(r10, r15)
            goto L12
        L1a:
            java.lang.Object r15 = r6.f26762d
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r6.f26764g
            r7 = 2
            r2 = 1
            if (r1 == 0) goto L45
            if (r1 == r2) goto L39
            if (r1 != r7) goto L31
            long r11 = r6.f26760b
            kotlin.ResultKt.b(r15)
            goto L95
        L31:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L39:
            long r13 = r6.f26761c
            long r11 = r6.f26760b
            java.lang.Object r1 = r6.f26759a
            androidx.compose.ui.input.nestedscroll.NestedScrollNode r1 = (androidx.compose.ui.input.nestedscroll.NestedScrollNode) r1
            kotlin.ResultKt.b(r15)
            goto L5e
        L45:
            kotlin.ResultKt.b(r15)
            androidx.compose.ui.input.nestedscroll.NestedScrollConnection r1 = r10.f26755a
            r6.f26759a = r10
            r6.f26760b = r11
            r6.f26761c = r13
            r6.f26764g = r2
            r2 = r11
            r4 = r13
            java.lang.Object r15 = r1.Y(r2, r4, r6)
            if (r15 != r0) goto L5b
            goto L93
        L5b:
            r1 = r10
            r11 = r2
            r13 = r4
        L5e:
            androidx.compose.ui.unit.Velocity r15 = (androidx.compose.ui.unit.Velocity) r15
            long r8 = r15.o()
            boolean r15 = androidx.compose.ui.ComposeUiFlags.f25103c
            if (r15 == 0) goto L77
            boolean r15 = r1.isAttached()
            if (r15 == 0) goto L74
            androidx.compose.ui.input.nestedscroll.NestedScrollConnection r15 = r1.o2()
        L72:
            r1 = r15
            goto L7c
        L74:
            androidx.compose.ui.input.nestedscroll.NestedScrollNode r15 = r1.f26757c
            goto L72
        L77:
            androidx.compose.ui.input.nestedscroll.NestedScrollConnection r15 = r1.o2()
            goto L72
        L7c:
            if (r1 == 0) goto L9d
            long r2 = androidx.compose.ui.unit.Velocity.l(r11, r8)
            long r4 = androidx.compose.ui.unit.Velocity.k(r13, r8)
            r11 = 0
            r6.f26759a = r11
            r6.f26760b = r8
            r6.f26764g = r7
            java.lang.Object r15 = r1.Y(r2, r4, r6)
            if (r15 != r0) goto L94
        L93:
            return r0
        L94:
            r11 = r8
        L95:
            androidx.compose.ui.unit.Velocity r15 = (androidx.compose.ui.unit.Velocity) r15
            long r13 = r15.o()
            r8 = r11
            goto La3
        L9d:
            androidx.compose.ui.unit.Velocity$Companion r11 = androidx.compose.ui.unit.Velocity.f30015b
            long r13 = r11.a()
        La3:
            long r11 = androidx.compose.ui.unit.Velocity.l(r8, r13)
            androidx.compose.ui.unit.Velocity r11 = androidx.compose.ui.unit.Velocity.b(r11)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.nestedscroll.NestedScrollNode.Y(long, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        s2();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        if (ComposeUiFlags.f25103c) {
            NestedScrollNode nestedScrollNode = (NestedScrollNode) NestedScrollNodeKt.b(this);
            this.f26757c = nestedScrollNode;
            this.f26756b.j(nestedScrollNode);
        }
        q2();
    }

    public final NestedScrollNode p2() {
        if (isAttached()) {
            return (NestedScrollNode) TraversableNodeKt.b(this);
        }
        return null;
    }

    public final void t2(NestedScrollConnection nestedScrollConnection, NestedScrollDispatcher nestedScrollDispatcher) {
        this.f26755a = nestedScrollConnection;
        r2(nestedScrollDispatcher);
    }
}
