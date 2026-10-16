package androidx.compose.foundation;

import android.content.Context;
import android.os.Build;
import android.widget.EdgeEffect;
import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerId;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNode;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.math.MathKt;

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
public final class AndroidEdgeEffectOverscrollEffect implements OverscrollEffect {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Density f4550a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f4551b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final EdgeEffectWrapper f4552c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final MutableState f4553d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f4554e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f4555f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f4556g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f4557h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final SuspendingPointerInputModifierNode f4558i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final DelegatableNode f4559j;

    public /* synthetic */ AndroidEdgeEffectOverscrollEffect(Context context, Density density, long j3, PaddingValues paddingValues, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, density, j3, paddingValues);
    }

    private final void g() {
        boolean z2;
        EdgeEffectWrapper edgeEffectWrapper = this.f4552c;
        EdgeEffect edgeEffect = edgeEffectWrapper.f4908d;
        boolean z3 = true;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            z2 = !edgeEffect.isFinished();
        } else {
            z2 = false;
        }
        EdgeEffect edgeEffect2 = edgeEffectWrapper.f4909e;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            z2 = !edgeEffect2.isFinished() || z2;
        }
        EdgeEffect edgeEffect3 = edgeEffectWrapper.f4910f;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            z2 = !edgeEffect3.isFinished() || z2;
        }
        EdgeEffect edgeEffect4 = edgeEffectWrapper.f4911g;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            if (edgeEffect4.isFinished() && !z2) {
                z3 = false;
            }
            z2 = z3;
        }
        if (z2) {
            j();
        }
    }

    private final float k(long j3) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (h() >> 32));
        int i3 = (int) (j3 & 4294967295L);
        float fIntBitsToFloat2 = Float.intBitsToFloat(i3) / Float.intBitsToFloat((int) (this.f4556g & 4294967295L));
        EdgeEffect edgeEffectG = this.f4552c.g();
        EdgeEffectCompat edgeEffectCompat = EdgeEffectCompat.f4901a;
        return edgeEffectCompat.c(edgeEffectG) == 0.0f ? (-edgeEffectCompat.e(edgeEffectG, -fIntBitsToFloat2, 1 - fIntBitsToFloat)) * Float.intBitsToFloat((int) (this.f4556g & 4294967295L)) : Float.intBitsToFloat(i3);
    }

    private final float l(long j3) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (h() & 4294967295L));
        int i3 = (int) (j3 >> 32);
        float fIntBitsToFloat2 = Float.intBitsToFloat(i3) / Float.intBitsToFloat((int) (this.f4556g >> 32));
        EdgeEffect edgeEffectI = this.f4552c.i();
        EdgeEffectCompat edgeEffectCompat = EdgeEffectCompat.f4901a;
        return edgeEffectCompat.c(edgeEffectI) == 0.0f ? edgeEffectCompat.e(edgeEffectI, fIntBitsToFloat2, 1 - fIntBitsToFloat) * Float.intBitsToFloat((int) (this.f4556g >> 32)) : Float.intBitsToFloat(i3);
    }

    private final float m(long j3) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (h() & 4294967295L));
        int i3 = (int) (j3 >> 32);
        float fIntBitsToFloat2 = Float.intBitsToFloat(i3) / Float.intBitsToFloat((int) (this.f4556g >> 32));
        EdgeEffect edgeEffectK = this.f4552c.k();
        EdgeEffectCompat edgeEffectCompat = EdgeEffectCompat.f4901a;
        return edgeEffectCompat.c(edgeEffectK) == 0.0f ? (-edgeEffectCompat.e(edgeEffectK, -fIntBitsToFloat2, fIntBitsToFloat)) * Float.intBitsToFloat((int) (this.f4556g >> 32)) : Float.intBitsToFloat(i3);
    }

    private final float n(long j3) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (h() >> 32));
        int i3 = (int) (j3 & 4294967295L);
        float fIntBitsToFloat2 = Float.intBitsToFloat(i3) / Float.intBitsToFloat((int) (this.f4556g & 4294967295L));
        EdgeEffect edgeEffectM = this.f4552c.m();
        EdgeEffectCompat edgeEffectCompat = EdgeEffectCompat.f4901a;
        return edgeEffectCompat.c(edgeEffectM) == 0.0f ? edgeEffectCompat.e(edgeEffectM, fIntBitsToFloat2, fIntBitsToFloat) * Float.intBitsToFloat((int) (this.f4556g & 4294967295L)) : Float.intBitsToFloat(i3);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean o(long r11) {
        /*
            r10 = this;
            androidx.compose.foundation.EdgeEffectWrapper r0 = r10.f4552c
            boolean r0 = r0.s()
            r1 = 32
            r2 = 0
            r3 = 0
            if (r0 == 0) goto L2d
            long r4 = r11 >> r1
            int r0 = (int) r4
            float r4 = java.lang.Float.intBitsToFloat(r0)
            int r4 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r4 >= 0) goto L2d
            androidx.compose.foundation.EdgeEffectCompat r4 = androidx.compose.foundation.EdgeEffectCompat.f4901a
            androidx.compose.foundation.EdgeEffectWrapper r5 = r10.f4552c
            android.widget.EdgeEffect r5 = r5.i()
            float r0 = java.lang.Float.intBitsToFloat(r0)
            r4.f(r5, r0)
            androidx.compose.foundation.EdgeEffectWrapper r0 = r10.f4552c
            boolean r0 = r0.s()
            goto L2e
        L2d:
            r0 = r3
        L2e:
            androidx.compose.foundation.EdgeEffectWrapper r4 = r10.f4552c
            boolean r4 = r4.v()
            r5 = 1
            if (r4 == 0) goto L5f
            long r6 = r11 >> r1
            int r1 = (int) r6
            float r4 = java.lang.Float.intBitsToFloat(r1)
            int r4 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r4 <= 0) goto L5f
            androidx.compose.foundation.EdgeEffectCompat r4 = androidx.compose.foundation.EdgeEffectCompat.f4901a
            androidx.compose.foundation.EdgeEffectWrapper r6 = r10.f4552c
            android.widget.EdgeEffect r6 = r6.k()
            float r1 = java.lang.Float.intBitsToFloat(r1)
            r4.f(r6, r1)
            if (r0 != 0) goto L5e
            androidx.compose.foundation.EdgeEffectWrapper r0 = r10.f4552c
            boolean r0 = r0.v()
            if (r0 == 0) goto L5c
            goto L5e
        L5c:
            r0 = r3
            goto L5f
        L5e:
            r0 = r5
        L5f:
            androidx.compose.foundation.EdgeEffectWrapper r1 = r10.f4552c
            boolean r1 = r1.z()
            r6 = 4294967295(0xffffffff, double:2.1219957905E-314)
            if (r1 == 0) goto L94
            long r8 = r11 & r6
            int r1 = (int) r8
            float r4 = java.lang.Float.intBitsToFloat(r1)
            int r4 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r4 >= 0) goto L94
            androidx.compose.foundation.EdgeEffectCompat r4 = androidx.compose.foundation.EdgeEffectCompat.f4901a
            androidx.compose.foundation.EdgeEffectWrapper r8 = r10.f4552c
            android.widget.EdgeEffect r8 = r8.m()
            float r1 = java.lang.Float.intBitsToFloat(r1)
            r4.f(r8, r1)
            if (r0 != 0) goto L93
            androidx.compose.foundation.EdgeEffectWrapper r0 = r10.f4552c
            boolean r0 = r0.z()
            if (r0 == 0) goto L91
            goto L93
        L91:
            r0 = r3
            goto L94
        L93:
            r0 = r5
        L94:
            androidx.compose.foundation.EdgeEffectWrapper r1 = r10.f4552c
            boolean r1 = r1.p()
            if (r1 == 0) goto Lc2
            long r11 = r11 & r6
            int r11 = (int) r11
            float r12 = java.lang.Float.intBitsToFloat(r11)
            int r12 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r12 <= 0) goto Lc2
            androidx.compose.foundation.EdgeEffectCompat r12 = androidx.compose.foundation.EdgeEffectCompat.f4901a
            androidx.compose.foundation.EdgeEffectWrapper r1 = r10.f4552c
            android.widget.EdgeEffect r1 = r1.g()
            float r11 = java.lang.Float.intBitsToFloat(r11)
            r12.f(r1, r11)
            if (r0 != 0) goto Lc1
            androidx.compose.foundation.EdgeEffectWrapper r11 = r10.f4552c
            boolean r11 = r11.p()
            if (r11 == 0) goto Lc0
            goto Lc1
        Lc0:
            return r3
        Lc1:
            return r5
        Lc2:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect.o(long):boolean");
    }

    @Override // androidx.compose.foundation.OverscrollEffect
    public boolean a() {
        EdgeEffectWrapper edgeEffectWrapper = this.f4552c;
        EdgeEffect edgeEffect = edgeEffectWrapper.f4908d;
        if (edgeEffect != null && EdgeEffectCompat.f4901a.c(edgeEffect) != 0.0f) {
            return true;
        }
        EdgeEffect edgeEffect2 = edgeEffectWrapper.f4909e;
        if (edgeEffect2 != null && EdgeEffectCompat.f4901a.c(edgeEffect2) != 0.0f) {
            return true;
        }
        EdgeEffect edgeEffect3 = edgeEffectWrapper.f4910f;
        if (edgeEffect3 != null && EdgeEffectCompat.f4901a.c(edgeEffect3) != 0.0f) {
            return true;
        }
        EdgeEffect edgeEffect4 = edgeEffectWrapper.f4911g;
        return (edgeEffect4 == null || EdgeEffectCompat.f4901a.c(edgeEffect4) == 0.0f) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x023e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b8 A[PHI: r11
      0x00b8: PHI (r11v9 float) = (r11v8 float), (r11v12 float) binds: [B:43:0x00e9, B:32:0x00b1] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0132 A[PHI: r14
      0x0132: PHI (r14v9 float) = (r14v8 float), (r14v12 float) binds: [B:67:0x0162, B:56:0x012b] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // androidx.compose.foundation.OverscrollEffect
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long b(long r20, int r22, kotlin.jvm.functions.Function1 r23) {
        /*
            Method dump skipped, instruction units count: 612
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect.b(long, int, kotlin.jvm.functions.Function1):long");
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0055, code lost:
    
        if (r14.invoke(r12, r0) == r1) goto L50;
     */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // androidx.compose.foundation.OverscrollEffect
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object c(long r12, kotlin.jvm.functions.Function2 r14, kotlin.coroutines.Continuation r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 449
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect.c(long, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // androidx.compose.foundation.OverscrollEffect
    public DelegatableNode getNode() {
        return this.f4559j;
    }

    public final long h() {
        long jB = this.f4551b;
        if ((9223372034707292159L & jB) == 9205357640488583168L) {
            jB = SizeKt.b(this.f4556g);
        }
        float fIntBitsToFloat = Float.intBitsToFloat((int) (jB >> 32)) / Float.intBitsToFloat((int) (this.f4556g >> 32));
        return Offset.e((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (jB & 4294967295L)) / Float.intBitsToFloat((int) (this.f4556g & 4294967295L)))) & 4294967295L) | (Float.floatToRawIntBits(fIntBitsToFloat) << 32));
    }

    public final MutableState i() {
        return this.f4553d;
    }

    public final void j() {
        if (this.f4554e) {
            this.f4553d.setValue(Unit.f139807a);
        }
    }

    public final void p(long j3) {
        boolean zF = Size.f(this.f4556g, Size.f25617b.b());
        boolean zF2 = Size.f(j3, this.f4556g);
        this.f4556g = j3;
        if (!zF2) {
            EdgeEffectWrapper edgeEffectWrapper = this.f4552c;
            int iD = MathKt.d(Float.intBitsToFloat((int) (j3 >> 32)));
            edgeEffectWrapper.C(IntSize.c((((long) MathKt.d(Float.intBitsToFloat((int) (j3 & 4294967295L)))) & 4294967295L) | (((long) iD) << 32)));
        }
        if (zF || zF2) {
            return;
        }
        g();
    }

    private AndroidEdgeEffectOverscrollEffect(Context context, Density density, long j3, PaddingValues paddingValues) {
        this.f4550a = density;
        this.f4551b = Offset.f25596b.b();
        EdgeEffectWrapper edgeEffectWrapper = new EdgeEffectWrapper(context, ColorKt.k(j3));
        this.f4552c = edgeEffectWrapper;
        this.f4553d = SnapshotStateKt.i(Unit.f139807a, SnapshotStateKt.k());
        this.f4554e = true;
        this.f4556g = Size.f25617b.b();
        this.f4557h = PointerId.a(-1L);
        SuspendingPointerInputModifierNode suspendingPointerInputModifierNodeA = SuspendingPointerInputFilterKt.a(new PointerInputEventHandler() { // from class: androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect$pointerInputNode$1

            /* JADX INFO: renamed from: androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect$pointerInputNode$1$1, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            @DebugMetadata(c = "androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect$pointerInputNode$1$1", f = "AndroidOverscroll.android.kt", l = {783, 787}, m = "invokeSuspend")
            static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                int f4566a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                private /* synthetic */ Object f4567b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                final /* synthetic */ AndroidEdgeEffectOverscrollEffect f4568c;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect, Continuation continuation) {
                    super(2, continuation);
                    this.f4568c = androidEdgeEffectOverscrollEffect;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation create(Object obj, Continuation continuation) {
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f4568c, continuation);
                    anonymousClass1.f4567b = obj;
                    return anonymousClass1;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation continuation) {
                    return ((AnonymousClass1) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.f139807a);
                }

                /* JADX WARN: Code restructure failed: missing block: B:16:0x005e, code lost:
                
                    if (r15 != r0) goto L18;
                 */
                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x005e -> B:18:0x0061). Please report as a decompilation issue!!! */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object invokeSuspend(java.lang.Object r15) throws java.lang.Throwable {
                    /*
                        Method dump skipped, instruction units count: 227
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect$pointerInputNode$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
                }
            }

            @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
            public final Object invoke(PointerInputScope pointerInputScope, Continuation continuation) {
                Object objE = ForEachGestureKt.e(pointerInputScope, new AnonymousClass1(this.f4565a, null), continuation);
                return objE == IntrinsicsKt.f() ? objE : Unit.f139807a;
            }
        });
        this.f4558i = suspendingPointerInputModifierNodeA;
        this.f4559j = Build.VERSION.SDK_INT >= 31 ? new StretchOverscrollNode(suspendingPointerInputModifierNodeA, this, edgeEffectWrapper) : new GlowOverscrollNode(suspendingPointerInputModifierNodeA, this, edgeEffectWrapper, paddingValues);
    }
}
