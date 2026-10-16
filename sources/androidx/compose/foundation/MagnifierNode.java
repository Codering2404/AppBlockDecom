package androidx.compose.foundation;

import android.view.View;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatableNode_androidKt;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.GlobalPositionAwareModifierNode;
import androidx.compose.ui.node.ObserverModifierNode;
import androidx.compose.ui.node.ObserverModifierNodeKt;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpSize;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelResult;

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
public final class MagnifierNode extends Modifier.Node implements GlobalPositionAwareModifierNode, DrawModifierNode, SemanticsModifierNode, ObserverModifierNode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Function1 f5000a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Function1 f5001b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Function1 f5002c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f5003d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f5004f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f5005g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f5006h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float f5007i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f5008j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private PlatformMagnifierFactory f5009k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private View f5010l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Density f5011m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private PlatformMagnifier f5012n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final MutableState f5013o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private State f5014p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private long f5015q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private IntSize f5016r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Channel f5017s;

    /* JADX INFO: renamed from: androidx.compose.foundation.MagnifierNode$onAttach$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "androidx.compose.foundation.MagnifierNode$onAttach$1", f = "Magnifier.android.kt", l = {382, 386}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f5020a;

        AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return MagnifierNode.this.new AnonymousClass1(continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x0042, code lost:
        
            if (androidx.compose.runtime.MonotonicFrameClockKt.b(r5, r4) == r0) goto L20;
         */
        /* JADX WARN: Path cross not found for [B:13:0x0029, B:16:0x0032], limit reached: 23 */
        /* JADX WARN: Path cross not found for [B:16:0x0032, B:13:0x0029], limit reached: 23 */
        /* JADX WARN: Removed duplicated region for block: B:11:0x0021  */
        /* JADX WARN: Removed duplicated region for block: B:13:0x0029  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x003a  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0038 -> B:11:0x0021). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0042 -> B:21:0x0045). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r5) throws java.lang.Throwable {
            /*
                r4 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r1 = r4.f5020a
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L1e
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                kotlin.ResultKt.b(r5)
                goto L45
            L12:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r0)
                throw r5
            L1a:
                kotlin.ResultKt.b(r5)
                goto L32
            L1e:
                kotlin.ResultKt.b(r5)
            L21:
                androidx.compose.foundation.MagnifierNode r5 = androidx.compose.foundation.MagnifierNode.this
                kotlinx.coroutines.channels.Channel r5 = androidx.compose.foundation.MagnifierNode.m2(r5)
                if (r5 == 0) goto L32
                r4.f5020a = r3
                java.lang.Object r5 = r5.v(r4)
                if (r5 != r0) goto L32
                goto L44
            L32:
                androidx.compose.foundation.MagnifierNode r5 = androidx.compose.foundation.MagnifierNode.this
                androidx.compose.foundation.PlatformMagnifier r5 = androidx.compose.foundation.MagnifierNode.o2(r5)
                if (r5 == 0) goto L21
                androidx.compose.foundation.MagnifierNode$onAttach$1$1 r5 = new kotlin.jvm.functions.Function1<java.lang.Long, kotlin.Unit>() { // from class: androidx.compose.foundation.MagnifierNode.onAttach.1.1
                    static {
                        /*
                            androidx.compose.foundation.MagnifierNode$onAttach$1$1 r0 = new androidx.compose.foundation.MagnifierNode$onAttach$1$1
                            r0.<init>()
                            
                            // error: 0x0005: SPUT (r0 I:androidx.compose.foundation.MagnifierNode$onAttach$1$1) androidx.compose.foundation.MagnifierNode.onAttach.1.1.a androidx.compose.foundation.MagnifierNode$onAttach$1$1
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.MagnifierNode.AnonymousClass1.C00091.<clinit>():void");
                    }

                    {
                        /*
                            r1 = this;
                            r0 = 1
                            r1.<init>(r0)
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.MagnifierNode.AnonymousClass1.C00091.<init>():void");
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ java.lang.Object invoke(java.lang.Object r3) {
                        /*
                            r2 = this;
                            java.lang.Number r3 = (java.lang.Number) r3
                            long r0 = r3.longValue()
                            r2.c(r0)
                            kotlin.Unit r3 = kotlin.Unit.f139807a
                            return r3
                        */
                        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.MagnifierNode.AnonymousClass1.C00091.invoke(java.lang.Object):java.lang.Object");
                    }

                    public final void c(long r1) {
                        /*
                            r0 = this;
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.MagnifierNode.AnonymousClass1.C00091.c(long):void");
                    }
                }
                r4.f5020a = r2
                java.lang.Object r5 = androidx.compose.runtime.MonotonicFrameClockKt.b(r5, r4)
                if (r5 != r0) goto L45
            L44:
                return r0
            L45:
                androidx.compose.foundation.MagnifierNode r5 = androidx.compose.foundation.MagnifierNode.this
                androidx.compose.foundation.PlatformMagnifier r5 = androidx.compose.foundation.MagnifierNode.o2(r5)
                if (r5 == 0) goto L21
                r5.c()
                goto L21
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.MagnifierNode.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    public /* synthetic */ MagnifierNode(Function1 function1, Function1 function12, Function1 function13, float f3, boolean z2, long j3, float f4, float f5, boolean z3, PlatformMagnifierFactory platformMagnifierFactory, DefaultConstructorMarker defaultConstructorMarker) {
        this(function1, function12, function13, f3, z2, j3, f4, f5, z3, platformMagnifierFactory);
    }

    private final long r2() {
        if (this.f5014p == null) {
            this.f5014p = SnapshotStateKt.e(new Function0<Offset>() { // from class: androidx.compose.foundation.MagnifierNode$anchorPositionInRoot$1
                {
                    super(0);
                }

                public final long c() {
                    LayoutCoordinates layoutCoordinatesZ = this.f5018a.z();
                    return layoutCoordinatesZ != null ? LayoutCoordinatesKt.f(layoutCoordinatesZ) : Offset.f25596b.b();
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    return Offset.d(c());
                }
            });
        }
        State state = this.f5014p;
        return state != null ? ((Offset) state.getValue()).u() : Offset.f25596b.b();
    }

    private final void s2() {
        PlatformMagnifier platformMagnifier = this.f5012n;
        if (platformMagnifier != null) {
            platformMagnifier.dismiss();
        }
        View viewA = this.f5010l;
        if (viewA == null) {
            viewA = DelegatableNode_androidKt.a(this);
        }
        View view = viewA;
        this.f5010l = view;
        Density densityK = this.f5011m;
        if (densityK == null) {
            densityK = DelegatableNodeKt.k(this);
        }
        Density density = densityK;
        this.f5011m = density;
        this.f5012n = this.f5009k.a(view, this.f5004f, this.f5005g, this.f5006h, this.f5007i, this.f5008j, density, this.f5003d);
        w2();
    }

    private final void t2(LayoutCoordinates layoutCoordinates) {
        this.f5013o.setValue(layoutCoordinates);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void v2() {
        /*
            r9 = this;
            androidx.compose.ui.unit.Density r0 = r9.f5011m
            if (r0 != 0) goto La
            androidx.compose.ui.unit.Density r0 = androidx.compose.ui.node.DelegatableNodeKt.k(r9)
            r9.f5011m = r0
        La:
            kotlin.jvm.functions.Function1 r1 = r9.f5000a
            java.lang.Object r1 = r1.invoke(r0)
            androidx.compose.ui.geometry.Offset r1 = (androidx.compose.ui.geometry.Offset) r1
            long r1 = r1.u()
            r3 = 9223372034707292159(0x7fffffff7fffffff, double:NaN)
            long r5 = r1 & r3
            r7 = 9205357640488583168(0x7fc000007fc00000, double:2.247117487993712E307)
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r5 == 0) goto L83
            long r5 = r9.r2()
            long r5 = r5 & r3
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r5 == 0) goto L83
            long r5 = r9.r2()
            long r1 = androidx.compose.ui.geometry.Offset.q(r5, r1)
            r9.f5015q = r1
            kotlin.jvm.functions.Function1 r1 = r9.f5001b
            if (r1 == 0) goto L66
            java.lang.Object r0 = r1.invoke(r0)
            androidx.compose.ui.geometry.Offset r0 = (androidx.compose.ui.geometry.Offset) r0
            long r0 = r0.u()
            androidx.compose.ui.geometry.Offset r0 = androidx.compose.ui.geometry.Offset.d(r0)
            long r1 = r0.u()
            long r1 = r1 & r3
            int r1 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r1 == 0) goto L55
            goto L56
        L55:
            r0 = 0
        L56:
            if (r0 == 0) goto L66
            long r0 = r0.u()
            long r2 = r9.r2()
            long r0 = androidx.compose.ui.geometry.Offset.q(r2, r0)
        L64:
            r5 = r0
            goto L6d
        L66:
            androidx.compose.ui.geometry.Offset$Companion r0 = androidx.compose.ui.geometry.Offset.f25596b
            long r0 = r0.b()
            goto L64
        L6d:
            androidx.compose.foundation.PlatformMagnifier r0 = r9.f5012n
            if (r0 != 0) goto L74
            r9.s2()
        L74:
            androidx.compose.foundation.PlatformMagnifier r2 = r9.f5012n
            if (r2 == 0) goto L7f
            long r3 = r9.f5015q
            float r7 = r9.f5003d
            r2.b(r3, r5, r7)
        L7f:
            r9.w2()
            return
        L83:
            androidx.compose.ui.geometry.Offset$Companion r0 = androidx.compose.ui.geometry.Offset.f25596b
            long r0 = r0.b()
            r9.f5015q = r0
            androidx.compose.foundation.PlatformMagnifier r0 = r9.f5012n
            if (r0 == 0) goto L92
            r0.dismiss()
        L92:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.MagnifierNode.v2():void");
    }

    private final void w2() {
        Density density;
        PlatformMagnifier platformMagnifier = this.f5012n;
        if (platformMagnifier == null || (density = this.f5011m) == null || IntSize.d(platformMagnifier.a(), this.f5016r)) {
            return;
        }
        Function1 function1 = this.f5002c;
        if (function1 != null) {
            function1.invoke(DpSize.c(density.o(IntSizeKt.e(platformMagnifier.a()))));
        }
        this.f5016r = IntSize.b(platformMagnifier.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LayoutCoordinates z() {
        return (LayoutCoordinates) this.f5013o.getValue();
    }

    @Override // androidx.compose.ui.node.GlobalPositionAwareModifierNode
    public void I(LayoutCoordinates layoutCoordinates) {
        t2(layoutCoordinates);
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public void N(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        semanticsPropertyReceiver.a(Magnifier_androidKt.b(), new Function0<Offset>() { // from class: androidx.compose.foundation.MagnifierNode$applySemantics$1
            {
                super(0);
            }

            public final long c() {
                return this.f5019a.f5015q;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                return Offset.d(c());
            }
        });
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public void draw(ContentDrawScope contentDrawScope) {
        contentDrawScope.i2();
        Channel channel = this.f5017s;
        if (channel != null) {
            ChannelResult.b(channel.h(Unit.f139807a));
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        w0();
        this.f5017s = ChannelKt.b(0, null, null, 7, null);
        BuildersKt__Builders_commonKt.d(getCoroutineScope(), null, CoroutineStart.f140919d, new AnonymousClass1(null), 1, null);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        PlatformMagnifier platformMagnifier = this.f5012n;
        if (platformMagnifier != null) {
            platformMagnifier.dismiss();
        }
        this.f5012n = null;
    }

    public final void u2(Function1 function1, Function1 function12, float f3, boolean z2, long j3, float f4, float f5, boolean z3, Function1 function13, PlatformMagnifierFactory platformMagnifierFactory) {
        float f6 = this.f5003d;
        long j4 = this.f5005g;
        float f7 = this.f5006h;
        boolean z4 = this.f5004f;
        float f8 = this.f5007i;
        boolean z5 = this.f5008j;
        PlatformMagnifierFactory platformMagnifierFactory2 = this.f5009k;
        View view = this.f5010l;
        Density density = this.f5011m;
        this.f5000a = function1;
        this.f5001b = function12;
        this.f5003d = f3;
        this.f5004f = z2;
        this.f5005g = j3;
        this.f5006h = f4;
        this.f5007i = f5;
        this.f5008j = z3;
        this.f5002c = function13;
        this.f5009k = platformMagnifierFactory;
        View viewA = DelegatableNode_androidKt.a(this);
        Density densityK = DelegatableNodeKt.k(this);
        if (this.f5012n != null && ((!Magnifier_androidKt.a(f3, f6) && !platformMagnifierFactory.b()) || !DpSize.h(j3, j4) || !Dp.i(f4, f7) || !Dp.i(f5, f8) || z2 != z4 || z3 != z5 || !Intrinsics.areEqual(platformMagnifierFactory, platformMagnifierFactory2) || !Intrinsics.areEqual(viewA, view) || !Intrinsics.areEqual(densityK, density))) {
            s2();
        }
        v2();
    }

    @Override // androidx.compose.ui.node.ObserverModifierNode
    public void w0() {
        ObserverModifierNodeKt.a(this, new Function0<Unit>() { // from class: androidx.compose.foundation.MagnifierNode$onObservedReadsChanged$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m30invoke();
                return Unit.f139807a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m30invoke() {
                this.f5023a.v2();
            }
        });
    }

    public /* synthetic */ MagnifierNode(Function1 function1, Function1 function12, Function1 function13, float f3, boolean z2, long j3, float f4, float f5, boolean z3, PlatformMagnifierFactory platformMagnifierFactory, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(function1, (i3 & 2) != 0 ? null : function12, (i3 & 4) != 0 ? null : function13, (i3 & 8) != 0 ? Float.NaN : f3, (i3 & 16) != 0 ? false : z2, (i3 & 32) != 0 ? DpSize.f29984b.a() : j3, (i3 & 64) != 0 ? Dp.f29970b.c() : f4, (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? Dp.f29970b.c() : f5, (i3 & Function.MAX_NARGS) != 0 ? true : z3, (i3 & 512) != 0 ? PlatformMagnifierFactory.f5107a.a() : platformMagnifierFactory, null);
    }

    private MagnifierNode(Function1 function1, Function1 function12, Function1 function13, float f3, boolean z2, long j3, float f4, float f5, boolean z3, PlatformMagnifierFactory platformMagnifierFactory) {
        this.f5000a = function1;
        this.f5001b = function12;
        this.f5002c = function13;
        this.f5003d = f3;
        this.f5004f = z2;
        this.f5005g = j3;
        this.f5006h = f4;
        this.f5007i = f5;
        this.f5008j = z3;
        this.f5009k = platformMagnifierFactory;
        this.f5013o = SnapshotStateKt.i(null, SnapshotStateKt.k());
        this.f5015q = Offset.f25596b.b();
    }
}
