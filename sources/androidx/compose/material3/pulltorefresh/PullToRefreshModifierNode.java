package androidx.compose.material3.pulltorefresh;

import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollNodeKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class PullToRefreshModifierNode extends DelegatingNode implements CompositionLocalConsumerModifierNode, NestedScrollConnection {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f22258c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Function0 f22259d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f22260f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private PullToRefreshState f22261g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f22262h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private DelegatableNode f22263i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final MutableFloatState f22264j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final MutableFloatState f22265k;

    /* JADX INFO: renamed from: androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode$onAttach$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode$onAttach$1", f = "PullToRefresh.kt", l = {287, 289}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f22274a;

        AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return PullToRefreshModifierNode.this.new AnonymousClass1(continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x0034, code lost:
        
            if (r5.d(1.0f, r4) == r0) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0044, code lost:
        
            if (r5.d(0.0f, r4) == r0) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0046, code lost:
        
            return r0;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r5) throws java.lang.Throwable {
            /*
                r4 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r1 = r4.f22274a
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L1b
                if (r1 == r3) goto L17
                if (r1 != r2) goto Lf
                goto L17
            Lf:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r0)
                throw r5
            L17:
                kotlin.ResultKt.b(r5)
                goto L47
            L1b:
                kotlin.ResultKt.b(r5)
                androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode r5 = androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode.this
                boolean r5 = r5.H2()
                if (r5 == 0) goto L37
                androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode r5 = androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode.this
                androidx.compose.material3.pulltorefresh.PullToRefreshState r5 = r5.E2()
                r4.f22274a = r3
                r1 = 1065353216(0x3f800000, float:1.0)
                java.lang.Object r5 = r5.d(r1, r4)
                if (r5 != r0) goto L47
                goto L46
            L37:
                androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode r5 = androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode.this
                androidx.compose.material3.pulltorefresh.PullToRefreshState r5 = r5.E2()
                r4.f22274a = r2
                r1 = 0
                java.lang.Object r5 = r5.d(r1, r4)
                if (r5 != r0) goto L47
            L46:
                return r0
            L47:
                kotlin.Unit r5 = kotlin.Unit.f139807a
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode$update$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode$update$1", f = "PullToRefresh.kt", l = {333, 335}, m = "invokeSuspend")
    static final class C03381 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f22287a;

        C03381(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return PullToRefreshModifierNode.this.new C03381(continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x002e, code lost:
        
            if (r5.x2(r4) == r0) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0039, code lost:
        
            if (r5.y2(r4) == r0) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x003b, code lost:
        
            return r0;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r5) throws java.lang.Throwable {
            /*
                r4 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r1 = r4.f22287a
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L1b
                if (r1 == r3) goto L17
                if (r1 != r2) goto Lf
                goto L17
            Lf:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r0)
                throw r5
            L17:
                kotlin.ResultKt.b(r5)
                goto L3c
            L1b:
                kotlin.ResultKt.b(r5)
                androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode r5 = androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode.this
                boolean r5 = r5.H2()
                if (r5 != 0) goto L31
                androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode r5 = androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode.this
                r4.f22287a = r3
                java.lang.Object r5 = androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode.s2(r5, r4)
                if (r5 != r0) goto L3c
                goto L3b
            L31:
                androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode r5 = androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode.this
                r4.f22287a = r2
                java.lang.Object r5 = androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode.t2(r5, r4)
                if (r5 != r0) goto L3c
            L3b:
                return r0
            L3c:
                kotlin.Unit r5 = kotlin.Unit.f139807a
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode.C03381.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C03381) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    public /* synthetic */ PullToRefreshModifierNode(boolean z2, Function0 function0, boolean z3, PullToRefreshState pullToRefreshState, float f3, DefaultConstructorMarker defaultConstructorMarker) {
        this(z2, function0, z3, pullToRefreshState, f3);
    }

    private final long A2(long j3) {
        float fC2;
        if (this.f22258c) {
            fC2 = 0.0f;
        } else {
            float fE = RangesKt.e(C2() + Offset.n(j3), 0.0f);
            fC2 = fE - C2();
            J2(fE);
            P2(z2());
        }
        return OffsetKt.a(0.0f, fC2);
    }

    private final float B2() {
        return C2() * 0.5f;
    }

    private final float C2() {
        return this.f22265k.c();
    }

    private final float D2() {
        return B2() / F2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int F2() {
        return ((Density) CompositionLocalConsumerModifierNodeKt.a(this, CompositionLocalsKt.f())).z0(this.f22262h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float G2() {
        return this.f22264j.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object I2(float r7, kotlin.coroutines.Continuation r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode$onRelease$1
            if (r0 == 0) goto L13
            r0 = r8
            androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode$onRelease$1 r0 = (androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode$onRelease$1) r0
            int r1 = r0.f22286f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f22286f = r1
            goto L18
        L13:
            androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode$onRelease$1 r0 = new androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode$onRelease$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.f22284c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f22286f
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L45
            if (r2 == r4) goto L3b
            if (r2 != r3) goto L33
            float r7 = r0.f22283b
            java.lang.Object r0 = r0.f22282a
            androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode r0 = (androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode) r0
            kotlin.ResultKt.b(r8)
            goto L80
        L33:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3b:
            float r7 = r0.f22283b
            java.lang.Object r0 = r0.f22282a
            androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode r0 = (androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode) r0
            kotlin.ResultKt.b(r8)
            goto L6c
        L45:
            kotlin.ResultKt.b(r8)
            boolean r8 = r6.f22258c
            if (r8 == 0) goto L51
            java.lang.Float r7 = kotlin.coroutines.jvm.internal.Boxing.c(r5)
            return r7
        L51:
            float r8 = r6.B2()
            int r2 = r6.F2()
            float r2 = (float) r2
            int r8 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r8 <= 0) goto L72
            r0.f22282a = r6
            r0.f22283b = r7
            r0.f22286f = r4
            java.lang.Object r8 = r6.y2(r0)
            if (r8 != r1) goto L6b
            goto L7e
        L6b:
            r0 = r6
        L6c:
            kotlin.jvm.functions.Function0 r8 = r0.f22259d
            r8.invoke()
            goto L80
        L72:
            r0.f22282a = r6
            r0.f22283b = r7
            r0.f22286f = r3
            java.lang.Object r8 = r6.x2(r0)
            if (r8 != r1) goto L7f
        L7e:
            return r1
        L7f:
            r0 = r6
        L80:
            float r8 = r0.C2()
            int r8 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1))
            if (r8 != 0) goto L8a
        L88:
            r7 = r5
            goto L8f
        L8a:
            int r8 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r8 >= 0) goto L8f
            goto L88
        L8f:
            r0.J2(r5)
            java.lang.Float r7 = kotlin.coroutines.jvm.internal.Boxing.c(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode.I2(float, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void J2(float f3) {
        this.f22265k.s(f3);
    }

    private final void P2(float f3) {
        this.f22264j.s(f3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object x2(kotlin.coroutines.Continuation r5) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r5 instanceof androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode$animateToHidden$1
            if (r0 == 0) goto L13
            r0 = r5
            androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode$animateToHidden$1 r0 = (androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode$animateToHidden$1) r0
            int r1 = r0.f22269d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f22269d = r1
            goto L18
        L13:
            androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode$animateToHidden$1 r0 = new androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode$animateToHidden$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.f22267b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f22269d
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r0 = r0.f22266a
            androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode r0 = (androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode) r0
            kotlin.ResultKt.b(r5)
            goto L46
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L35:
            kotlin.ResultKt.b(r5)
            androidx.compose.material3.pulltorefresh.PullToRefreshState r5 = r4.f22261g
            r0.f22266a = r4
            r0.f22269d = r3
            java.lang.Object r5 = r5.b(r0)
            if (r5 != r1) goto L45
            return r1
        L45:
            r0 = r4
        L46:
            r5 = 0
            r0.J2(r5)
            r0.P2(r5)
            kotlin.Unit r5 = kotlin.Unit.f139807a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode.x2(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object y2(kotlin.coroutines.Continuation r5) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r5 instanceof androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode$animateToThreshold$1
            if (r0 == 0) goto L13
            r0 = r5
            androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode$animateToThreshold$1 r0 = (androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode$animateToThreshold$1) r0
            int r1 = r0.f22273d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f22273d = r1
            goto L18
        L13:
            androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode$animateToThreshold$1 r0 = new androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode$animateToThreshold$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.f22271b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f22273d
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r0 = r0.f22270a
            androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode r0 = (androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode) r0
            kotlin.ResultKt.b(r5)
            goto L46
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L35:
            kotlin.ResultKt.b(r5)
            androidx.compose.material3.pulltorefresh.PullToRefreshState r5 = r4.f22261g
            r0.f22270a = r4
            r0.f22273d = r3
            java.lang.Object r5 = r5.e(r0)
            if (r5 != r1) goto L45
            return r1
        L45:
            r0 = r4
        L46:
            int r5 = r0.F2()
            float r5 = (float) r5
            r0.J2(r5)
            int r5 = r0.F2()
            float r5 = (float) r5
            r0.P2(r5)
            kotlin.Unit r5 = kotlin.Unit.f139807a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode.y2(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final float z2() {
        if (B2() <= F2()) {
            return B2();
        }
        float fO = RangesKt.o(Math.abs(D2()) - 1.0f, 0.0f, 2.0f);
        return F2() + (F2() * (fO - (((float) Math.pow(fO, 2)) / 4)));
    }

    public final PullToRefreshState E2() {
        return this.f22261g;
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    public long H0(long j3, long j4, int i3) {
        if (this.f22261g.c()) {
            return Offset.f25596b.c();
        }
        if (!this.f22260f) {
            return Offset.f25596b.c();
        }
        if (!NestedScrollSource.e(i3, NestedScrollSource.f26772b.b())) {
            return Offset.f25596b.c();
        }
        long jA2 = A2(j4);
        BuildersKt__Builders_commonKt.d(getCoroutineScope(), null, null, new PullToRefreshModifierNode$onPostScroll$1(this, null), 3, null);
        return jA2;
    }

    public final boolean H2() {
        return this.f22258c;
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    public long J1(long j3, int i3) {
        return this.f22261g.c() ? Offset.f25596b.c() : !this.f22260f ? Offset.f25596b.c() : (!NestedScrollSource.e(i3, NestedScrollSource.f26772b.b()) || Offset.n(j3) >= 0.0f) ? Offset.f25596b.c() : A2(j3);
    }

    public final void K2(boolean z2) {
        this.f22260f = z2;
    }

    public final void L2(Function0 function0) {
        this.f22259d = function0;
    }

    public final void M2(boolean z2) {
        this.f22258c = z2;
    }

    public final void N2(PullToRefreshState pullToRefreshState) {
        this.f22261g = pullToRefreshState;
    }

    public final void O2(float f3) {
        this.f22262h = f3;
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
            boolean r0 = r7 instanceof androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode$onPreFling$1
            if (r0 == 0) goto L13
            r0 = r7
            androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode$onPreFling$1 r0 = (androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode$onPreFling$1) r0
            int r1 = r0.f22281d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f22281d = r1
            goto L18
        L13:
            androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode$onPreFling$1 r0 = new androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode$onPreFling$1
            r0.<init>(r4, r7)
        L18:
            java.lang.Object r7 = r0.f22279b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f22281d
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            float r5 = r0.f22278a
            kotlin.ResultKt.b(r7)
            goto L47
        L2b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L33:
            kotlin.ResultKt.b(r7)
            float r5 = androidx.compose.ui.unit.Velocity.i(r5)
            r6 = 0
            r0.f22278a = r6
            r0.f22281d = r3
            java.lang.Object r7 = r4.I2(r5, r0)
            if (r7 != r1) goto L46
            return r1
        L46:
            r5 = r6
        L47:
            java.lang.Number r7 = (java.lang.Number) r7
            float r6 = r7.floatValue()
            long r5 = androidx.compose.ui.unit.VelocityKt.a(r5, r6)
            androidx.compose.ui.unit.Velocity r5 = androidx.compose.ui.unit.Velocity.b(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.pulltorefresh.PullToRefreshModifierNode.R1(long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        m2(this.f22263i);
        BuildersKt__Builders_commonKt.d(getCoroutineScope(), null, null, new AnonymousClass1(null), 3, null);
    }

    public final void update() {
        BuildersKt__Builders_commonKt.d(getCoroutineScope(), null, null, new C03381(null), 3, null);
    }

    private PullToRefreshModifierNode(boolean z2, Function0 function0, boolean z3, PullToRefreshState pullToRefreshState, float f3) {
        this.f22258c = z2;
        this.f22259d = function0;
        this.f22260f = z3;
        this.f22261g = pullToRefreshState;
        this.f22262h = f3;
        this.f22263i = NestedScrollNodeKt.c(this, null);
        this.f22264j = PrimitiveSnapshotStateKt.a(0.0f);
        this.f22265k = PrimitiveSnapshotStateKt.a(0.0f);
    }
}
