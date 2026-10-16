package androidx.compose.ui.input.pointer;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

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
public final class SuspendingPointerInputModifierNodeImpl extends Modifier.Node implements SuspendingPointerInputModifierNode, PointerInputScope, Density {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Object f26942a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Object f26943b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Object[] f26944c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Function2 f26945d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private PointerInputEventHandler f26946f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Job f26947g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private PointerEvent f26948h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final MutableVector f26949i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Object f26950j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final MutableVector f26951k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private PointerEvent f26952l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private long f26953m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f26954n;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    final class PointerEventHandlerCoroutine<R> implements AwaitPointerEventScope, Density, Continuation<R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Continuation f26956a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final /* synthetic */ SuspendingPointerInputModifierNodeImpl f26957b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private CancellableContinuation f26958c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private PointerEventPass f26959d = PointerEventPass.f26831b;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final CoroutineContext f26960f = EmptyCoroutineContext.f139889a;

        public PointerEventHandlerCoroutine(Continuation continuation) {
            this.f26956a = continuation;
            this.f26957b = SuspendingPointerInputModifierNodeImpl.this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        /* JADX WARN: Type inference failed for: r11v0, types: [long] */
        /* JADX WARN: Type inference failed for: r11v1, types: [kotlinx.coroutines.Job] */
        /* JADX WARN: Type inference failed for: r11v3, types: [kotlinx.coroutines.Job] */
        /* JADX WARN: Type inference failed for: r11v7 */
        /* JADX WARN: Type inference failed for: r11v8 */
        /* JADX WARN: Type inference failed for: r13v0, types: [kotlin.jvm.functions.Function2] */
        @Override // androidx.compose.ui.input.pointer.AwaitPointerEventScope
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.Object C0(long r11, kotlin.jvm.functions.Function2 r13, kotlin.coroutines.Continuation r14) throws java.lang.Throwable {
            /*
                r10 = this;
                boolean r0 = r14 instanceof androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$1
                if (r0 == 0) goto L13
                r0 = r14
                androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$1 r0 = (androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$1) r0
                int r1 = r0.f26965d
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f26965d = r1
                goto L18
            L13:
                androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$1 r0 = new androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$1
                r0.<init>(r10, r14)
            L18:
                java.lang.Object r14 = r0.f26963b
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r2 = r0.f26965d
                r3 = 1
                if (r2 == 0) goto L38
                if (r2 != r3) goto L30
                java.lang.Object r11 = r0.f26962a
                kotlinx.coroutines.Job r11 = (kotlinx.coroutines.Job) r11
                kotlin.ResultKt.b(r14)     // Catch: java.lang.Throwable -> L2d
                goto L76
            L2d:
                r0 = move-exception
                r12 = r0
                goto L7c
            L30:
                java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
                r11.<init>(r12)
                throw r11
            L38:
                kotlin.ResultKt.b(r14)
                r4 = 0
                int r14 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
                if (r14 > 0) goto L57
                kotlinx.coroutines.CancellableContinuation r14 = r10.f26958c
                if (r14 == 0) goto L57
                kotlin.Result$Companion r2 = kotlin.Result.f139772b
                androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException r2 = new androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException
                r2.<init>(r11)
                java.lang.Object r2 = kotlin.ResultKt.a(r2)
                java.lang.Object r2 = kotlin.Result.b(r2)
                r14.resumeWith(r2)
            L57:
                androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl r14 = androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl.this
                kotlinx.coroutines.CoroutineScope r4 = r14.getCoroutineScope()
                androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$job$1 r7 = new androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeout$job$1
                r14 = 0
                r7.<init>(r11, r10, r14)
                r8 = 3
                r9 = 0
                r5 = 0
                r6 = 0
                kotlinx.coroutines.Job r11 = kotlinx.coroutines.BuildersKt.d(r4, r5, r6, r7, r8, r9)
                r0.f26962a = r11     // Catch: java.lang.Throwable -> L2d
                r0.f26965d = r3     // Catch: java.lang.Throwable -> L2d
                java.lang.Object r14 = r13.invoke(r10, r0)     // Catch: java.lang.Throwable -> L2d
                if (r14 != r1) goto L76
                return r1
            L76:
                androidx.compose.ui.input.pointer.CancelTimeoutCancellationException r12 = androidx.compose.ui.input.pointer.CancelTimeoutCancellationException.f26782a
                r11.cancel(r12)
                return r14
            L7c:
                androidx.compose.ui.input.pointer.CancelTimeoutCancellationException r13 = androidx.compose.ui.input.pointer.CancelTimeoutCancellationException.f26782a
                r11.cancel(r13)
                throw r12
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine.C0(long, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
        }

        @Override // androidx.compose.ui.unit.Density
        public float F(int i3) {
            return this.f26957b.F(i3);
        }

        @Override // androidx.compose.ui.unit.Density
        public float G(float f3) {
            return this.f26957b.G(f3);
        }

        @Override // androidx.compose.ui.unit.Density
        public float J0(long j3) {
            return this.f26957b.J0(j3);
        }

        @Override // androidx.compose.ui.unit.FontScaling
        public float K1() {
            return this.f26957b.K1();
        }

        @Override // androidx.compose.ui.unit.Density
        public long M(long j3) {
            return this.f26957b.M(j3);
        }

        @Override // androidx.compose.ui.unit.Density
        public float M1(float f3) {
            return this.f26957b.M1(f3);
        }

        public final void S(Throwable th) {
            CancellableContinuation cancellableContinuation = this.f26958c;
            if (cancellableContinuation != null) {
                cancellableContinuation.cancel(th);
            }
            this.f26958c = null;
        }

        public final void T(PointerEvent pointerEvent, PointerEventPass pointerEventPass) {
            CancellableContinuation cancellableContinuation;
            if (pointerEventPass != this.f26959d || (cancellableContinuation = this.f26958c) == null) {
                return;
            }
            this.f26958c = null;
            cancellableContinuation.resumeWith(Result.b(pointerEvent));
        }

        @Override // androidx.compose.ui.input.pointer.AwaitPointerEventScope
        public Object T0(PointerEventPass pointerEventPass, Continuation continuation) {
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
            cancellableContinuationImpl.C();
            this.f26959d = pointerEventPass;
            this.f26958c = cancellableContinuationImpl;
            Object objV = cancellableContinuationImpl.v();
            if (objV == IntrinsicsKt.f()) {
                DebugProbesKt.c(continuation);
            }
            return objV;
        }

        @Override // androidx.compose.ui.unit.Density
        public int T1(long j3) {
            return this.f26957b.T1(j3);
        }

        @Override // androidx.compose.ui.input.pointer.AwaitPointerEventScope
        public PointerEvent U0() {
            return SuspendingPointerInputModifierNodeImpl.this.f26948h;
        }

        @Override // androidx.compose.ui.input.pointer.AwaitPointerEventScope
        public long a() {
            return SuspendingPointerInputModifierNodeImpl.this.f26953m;
        }

        @Override // kotlin.coroutines.Continuation
        public CoroutineContext getContext() {
            return this.f26960f;
        }

        @Override // androidx.compose.ui.unit.Density
        public float getDensity() {
            return this.f26957b.getDensity();
        }

        @Override // androidx.compose.ui.input.pointer.AwaitPointerEventScope
        public ViewConfiguration getViewConfiguration() {
            return SuspendingPointerInputModifierNodeImpl.this.getViewConfiguration();
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // androidx.compose.ui.input.pointer.AwaitPointerEventScope
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.Object h0(long r5, kotlin.jvm.functions.Function2 r7, kotlin.coroutines.Continuation r8) throws java.lang.Throwable {
            /*
                r4 = this;
                boolean r0 = r8 instanceof androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeoutOrNull$1
                if (r0 == 0) goto L13
                r0 = r8
                androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeoutOrNull$1 r0 = (androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeoutOrNull$1) r0
                int r1 = r0.f26971c
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f26971c = r1
                goto L18
            L13:
                androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeoutOrNull$1 r0 = new androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine$withTimeoutOrNull$1
                r0.<init>(r4, r8)
            L18:
                java.lang.Object r8 = r0.f26969a
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r2 = r0.f26971c
                r3 = 1
                if (r2 == 0) goto L31
                if (r2 != r3) goto L29
                kotlin.ResultKt.b(r8)     // Catch: androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException -> L3e
                return r8
            L29:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L31:
                kotlin.ResultKt.b(r8)
                r0.f26971c = r3     // Catch: androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException -> L3e
                java.lang.Object r5 = r4.C0(r5, r7, r0)     // Catch: androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException -> L3e
                if (r5 != r1) goto L3d
                return r1
            L3d:
                return r5
            L3e:
                r5 = 0
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine.h0(long, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
        }

        @Override // androidx.compose.ui.unit.FontScaling
        public long n(float f3) {
            return this.f26957b.n(f3);
        }

        @Override // androidx.compose.ui.unit.Density
        public long o(long j3) {
            return this.f26957b.o(j3);
        }

        @Override // androidx.compose.ui.unit.FontScaling
        public float q(long j3) {
            return this.f26957b.q(j3);
        }

        @Override // kotlin.coroutines.Continuation
        public void resumeWith(Object obj) {
            Object obj2 = SuspendingPointerInputModifierNodeImpl.this.f26950j;
            SuspendingPointerInputModifierNodeImpl suspendingPointerInputModifierNodeImpl = SuspendingPointerInputModifierNodeImpl.this;
            synchronized (obj2) {
                suspendingPointerInputModifierNodeImpl.f26949i.s(this);
                Unit unit = Unit.f139807a;
            }
            this.f26956a.resumeWith(obj);
        }

        @Override // androidx.compose.ui.unit.Density
        public long v(float f3) {
            return this.f26957b.v(f3);
        }

        @Override // androidx.compose.ui.input.pointer.AwaitPointerEventScope
        public long v0() {
            return SuspendingPointerInputModifierNodeImpl.this.v0();
        }

        @Override // androidx.compose.ui.unit.Density
        public int z0(float f3) {
            return this.f26957b.z0(f3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f26972a;

        static {
            int[] iArr = new int[PointerEventPass.values().length];
            try {
                iArr[PointerEventPass.f26830a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PointerEventPass.f26832c.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PointerEventPass.f26831b.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f26972a = iArr;
        }
    }

    public SuspendingPointerInputModifierNodeImpl(Object obj, Object obj2, Object[] objArr, PointerInputEventHandler pointerInputEventHandler) {
        this.f26942a = obj;
        this.f26943b = obj2;
        this.f26944c = objArr;
        this.f26946f = pointerInputEventHandler;
        this.f26948h = SuspendingPointerInputFilterKt.f26939a;
        MutableVector mutableVector = new MutableVector(new PointerEventHandlerCoroutine[16], 0);
        this.f26949i = mutableVector;
        this.f26950j = mutableVector;
        this.f26951k = new MutableVector(new PointerEventHandlerCoroutine[16], 0);
        this.f26953m = IntSize.f29998b.a();
    }

    private final void r2(PointerEvent pointerEvent, PointerEventPass pointerEventPass) {
        synchronized (this.f26950j) {
            MutableVector mutableVector = this.f26951k;
            mutableVector.d(mutableVector.o(), this.f26949i);
        }
        try {
            int i3 = WhenMappings.f26972a[pointerEventPass.ordinal()];
            if (i3 == 1 || i3 == 2) {
                MutableVector mutableVector2 = this.f26951k;
                Object[] objArr = mutableVector2.f24389a;
                int iO = mutableVector2.o();
                for (int i4 = 0; i4 < iO; i4++) {
                    ((PointerEventHandlerCoroutine) objArr[i4]).T(pointerEvent, pointerEventPass);
                }
            } else if (i3 == 3) {
                MutableVector mutableVector3 = this.f26951k;
                int iO2 = mutableVector3.o() - 1;
                Object[] objArr2 = mutableVector3.f24389a;
                if (iO2 < objArr2.length) {
                    while (iO2 >= 0) {
                        ((PointerEventHandlerCoroutine) objArr2[iO2]).T(pointerEvent, pointerEventPass);
                        iO2--;
                    }
                }
            }
        } finally {
            this.f26951k.i();
        }
    }

    @Override // androidx.compose.ui.unit.FontScaling
    public float K1() {
        return DelegatableNodeKt.o(this).U().K1();
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputScope
    public void M0(boolean z2) {
        this.f26954n = z2;
    }

    @Override // androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNode
    public void O0() {
        Job job = this.f26947g;
        if (job != null) {
            job.cancel((CancellationException) new PointerInputResetException());
            this.f26947g = null;
        }
    }

    public long a() {
        return this.f26953m;
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public void b2() {
        O0();
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputScope
    public Object c0(Function2 function2, Continuation continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
        cancellableContinuationImpl.C();
        final PointerEventHandlerCoroutine pointerEventHandlerCoroutine = new PointerEventHandlerCoroutine(cancellableContinuationImpl);
        synchronized (this.f26950j) {
            this.f26949i.b(pointerEventHandlerCoroutine);
            Continuation continuationA = ContinuationKt.a(function2, pointerEventHandlerCoroutine, pointerEventHandlerCoroutine);
            Result.Companion companion = Result.f139772b;
            continuationA.resumeWith(Result.b(Unit.f139807a));
        }
        cancellableContinuationImpl.m(new Function1<Throwable, Unit>() { // from class: androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$awaitPointerEventScope$2$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return Unit.f139807a;
            }

            public final void invoke(Throwable th) {
                pointerEventHandlerCoroutine.S(th);
            }
        });
        Object objV = cancellableContinuationImpl.v();
        if (objV == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return objV;
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public void g0(PointerEvent pointerEvent, PointerEventPass pointerEventPass, long j3) {
        this.f26953m = j3;
        if (pointerEventPass == PointerEventPass.f26830a) {
            this.f26948h = pointerEvent;
        }
        if (this.f26947g == null) {
            this.f26947g = BuildersKt__Builders_commonKt.d(getCoroutineScope(), null, CoroutineStart.f140919d, new SuspendingPointerInputModifierNodeImpl$onPointerEvent$1(this, null), 1, null);
        }
        r2(pointerEvent, pointerEventPass);
        List listC = pointerEvent.c();
        int size = listC.size();
        boolean z2 = false;
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                z2 = true;
                break;
            } else if (!PointerEventKt.d((PointerInputChange) listC.get(i3))) {
                break;
            } else {
                i3++;
            }
        }
        if (z2) {
            pointerEvent = null;
        }
        this.f26952l = pointerEvent;
    }

    @Override // androidx.compose.ui.unit.Density
    public float getDensity() {
        return DelegatableNodeKt.o(this).U().getDensity();
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputScope
    public ViewConfiguration getViewConfiguration() {
        return DelegatableNodeKt.o(this).E0();
    }

    @Override // androidx.compose.ui.node.DelegatableNode, androidx.compose.ui.node.PointerInputModifierNode
    public void onDensityChange() {
        O0();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        O0();
        super.onDetach();
    }

    public PointerInputEventHandler s2() {
        return this.f26946f;
    }

    public final void t2(Object obj, Object obj2, Object[] objArr, PointerInputEventHandler pointerInputEventHandler) {
        boolean z2 = !Intrinsics.areEqual(this.f26942a, obj);
        this.f26942a = obj;
        if (!Intrinsics.areEqual(this.f26943b, obj2)) {
            z2 = true;
        }
        this.f26943b = obj2;
        Object[] objArr2 = this.f26944c;
        if (objArr2 != null && objArr == null) {
            z2 = true;
        }
        if (objArr2 == null && objArr != null) {
            z2 = true;
        }
        if (objArr2 != null && objArr != null && !Arrays.equals(objArr, objArr2)) {
            z2 = true;
        }
        this.f26944c = objArr;
        if (s2().getClass() == pointerInputEventHandler.getClass() ? z2 : true) {
            O0();
        }
        this.f26946f = pointerInputEventHandler;
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public void u1() {
        PointerEvent pointerEvent = this.f26952l;
        if (pointerEvent == null) {
            return;
        }
        List listC = pointerEvent.c();
        int size = listC.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (((PointerInputChange) listC.get(i3)).i()) {
                List listC2 = pointerEvent.c();
                ArrayList arrayList = new ArrayList(listC2.size());
                int size2 = listC2.size();
                for (int i4 = 0; i4 < size2; i4++) {
                    PointerInputChange pointerInputChange = (PointerInputChange) listC2.get(i4);
                    arrayList.add(new PointerInputChange(pointerInputChange.f(), pointerInputChange.o(), pointerInputChange.h(), false, pointerInputChange.j(), pointerInputChange.o(), pointerInputChange.h(), pointerInputChange.i(), pointerInputChange.i(), pointerInputChange.n(), 0L, 1024, (DefaultConstructorMarker) null));
                }
                PointerEvent pointerEvent2 = new PointerEvent(arrayList);
                this.f26948h = pointerEvent2;
                r2(pointerEvent2, PointerEventPass.f26830a);
                r2(pointerEvent2, PointerEventPass.f26831b);
                r2(pointerEvent2, PointerEventPass.f26832c);
                this.f26952l = null;
                return;
            }
        }
    }

    public long v0() {
        long jM = M(getViewConfiguration().e());
        long jA = a();
        return Size.d((((long) Float.floatToRawIntBits(Math.max(0.0f, Float.intBitsToFloat((int) (jM >> 32)) - ((int) (jA >> 32))) / 2.0f)) << 32) | (((long) Float.floatToRawIntBits(Math.max(0.0f, Float.intBitsToFloat((int) (jM & 4294967295L)) - ((int) (jA & 4294967295L))) / 2.0f)) & 4294967295L));
    }

    public SuspendingPointerInputModifierNodeImpl(Object obj, Object obj2, Object[] objArr, Function2 function2) {
        this(obj, obj2, objArr, new PointerInputEventHandler() { // from class: androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl.1
            @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
            public final Object invoke(PointerInputScope pointerInputScope, Continuation continuation) {
                return Unit.f139807a;
            }
        });
        this.f26945d = function2;
    }
}
