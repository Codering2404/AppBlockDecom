package androidx.compose.ui.viewinterop;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.Region;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import androidx.compose.runtime.ComposeNodeLifecycleCallback;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.ui.ComposeUiFlags;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.ui.input.pointer.PointerInteropFilter_androidKt;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.node.OwnerScope;
import androidx.compose.ui.node.OwnerSnapshotObserver;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.platform.NestedScrollInteropConnectionKt;
import androidx.compose.ui.platform.WindowRecomposer_androidKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.VelocityKt;
import androidx.core.graphics.Insets;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public class AndroidViewHolder extends ViewGroup implements NestedScrollingParent3, ComposeNodeLifecycleCallback, OwnerScope, OnApplyWindowInsetsListener {
    public static final Companion B = new Companion(null);
    public static final int C = 8;
    private static final Function1 D = AndroidViewHolder$Companion$OnCommitAffectingUpdate$1.f30078a;
    private final LayoutNode A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f30052a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final NestedScrollDispatcher f30053b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final View f30054c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Owner f30055d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Function0 f30056f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f30057g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Function0 f30058h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Function0 f30059i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Modifier f30060j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Function1 f30061k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Density f30062l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Function1 f30063m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private LifecycleOwner f30064n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private SavedStateRegistryOwner f30065o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final int[] f30066p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private long f30067q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private WindowInsetsCompat f30068r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final Function0 f30069s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final Function0 f30070t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private Function1 f30071u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final int[] f30072v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f30073w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f30074x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final NestedScrollingParentHelper f30075y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f30076z;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.viewinterop.AndroidViewHolder$onNestedFling$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "androidx.compose.ui.viewinterop.AndroidViewHolder$onNestedFling$1", f = "AndroidViewHolder.android.kt", l = {639, 641}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f30096a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f30097b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ AndroidViewHolder f30098c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f30099d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(boolean z2, AndroidViewHolder androidViewHolder, long j3, Continuation continuation) {
            super(2, continuation);
            this.f30097b = z2;
            this.f30098c = androidViewHolder;
            this.f30099d = j3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f30097b, this.f30098c, this.f30099d, continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x003c, code lost:
        
            if (r4.a(r5, r7, r10) == r0) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0055, code lost:
        
            if (r1.a(r2, r4, r10) == r0) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0057, code lost:
        
            return r0;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r11) throws java.lang.Throwable {
            /*
                r10 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r1 = r10.f30096a
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L1f
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                kotlin.ResultKt.b(r11)
                goto L58
            L12:
                java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r11.<init>(r0)
                throw r11
            L1a:
                kotlin.ResultKt.b(r11)
                r6 = r10
                goto L58
            L1f:
                kotlin.ResultKt.b(r11)
                boolean r11 = r10.f30097b
                if (r11 != 0) goto L3f
                androidx.compose.ui.viewinterop.AndroidViewHolder r11 = r10.f30098c
                androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher r4 = androidx.compose.ui.viewinterop.AndroidViewHolder.d(r11)
                androidx.compose.ui.unit.Velocity$Companion r11 = androidx.compose.ui.unit.Velocity.f30015b
                long r5 = r11.a()
                long r7 = r10.f30099d
                r10.f30096a = r3
                r9 = r10
                java.lang.Object r11 = r4.a(r5, r7, r9)
                r6 = r9
                if (r11 != r0) goto L58
                goto L57
            L3f:
                r6 = r10
                androidx.compose.ui.viewinterop.AndroidViewHolder r11 = r6.f30098c
                androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher r1 = androidx.compose.ui.viewinterop.AndroidViewHolder.d(r11)
                r11 = r2
                long r2 = r6.f30099d
                androidx.compose.ui.unit.Velocity$Companion r4 = androidx.compose.ui.unit.Velocity.f30015b
                long r4 = r4.a()
                r6.f30096a = r11
                java.lang.Object r11 = r1.a(r2, r4, r6)
                if (r11 != r0) goto L58
            L57:
                return r0
            L58:
                kotlin.Unit r11 = kotlin.Unit.f139807a
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.viewinterop.AndroidViewHolder.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.viewinterop.AndroidViewHolder$onNestedPreFling$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "androidx.compose.ui.viewinterop.AndroidViewHolder$onNestedPreFling$1", f = "AndroidViewHolder.android.kt", l = {650}, m = "invokeSuspend")
    static final class C03471 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f30100a;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f30102c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03471(long j3, Continuation continuation) {
            super(2, continuation);
            this.f30102c = j3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return AndroidViewHolder.this.new C03471(this.f30102c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f30100a;
            if (i3 == 0) {
                ResultKt.b(obj);
                NestedScrollDispatcher nestedScrollDispatcher = AndroidViewHolder.this.f30053b;
                long j3 = this.f30102c;
                this.f30100a = 1;
                if (nestedScrollDispatcher.c(j3, this) == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C03471) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    public AndroidViewHolder(Context context, CompositionContext compositionContext, int i3, NestedScrollDispatcher nestedScrollDispatcher, View view, Owner owner) {
        super(context);
        this.f30052a = i3;
        this.f30053b = nestedScrollDispatcher;
        this.f30054c = view;
        this.f30055d = owner;
        if (compositionContext != null) {
            WindowRecomposer_androidKt.i(this, compositionContext);
        }
        setSaveFromParentEnabled(false);
        addView(view);
        ViewCompat.K0(this, new WindowInsetsAnimationCompat.Callback() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder.2
            {
                super(1);
            }

            @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
            public WindowInsetsCompat e(WindowInsetsCompat windowInsetsCompat, List list) {
                return AndroidViewHolder.this.B(windowInsetsCompat);
            }

            @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
            public WindowInsetsAnimationCompat.BoundsCompat f(WindowInsetsAnimationCompat windowInsetsAnimationCompat, WindowInsetsAnimationCompat.BoundsCompat boundsCompat) {
                return AndroidViewHolder.this.A(boundsCompat);
            }
        });
        ViewCompat.C0(this, this);
        this.f30056f = new Function0<Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$update$1
            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m274invoke() {
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m274invoke();
                return Unit.f139807a;
            }
        };
        this.f30058h = new Function0<Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$reset$1
            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m271invoke() {
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m271invoke();
                return Unit.f139807a;
            }
        };
        this.f30059i = new Function0<Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$release$1
            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m270invoke() {
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m270invoke();
                return Unit.f139807a;
            }
        };
        Modifier.Companion companion = Modifier.b8;
        this.f30060j = companion;
        this.f30062l = DensityKt.b(1.0f, 0.0f, 2, null);
        this.f30066p = new int[2];
        this.f30067q = IntSize.f29998b.a();
        this.f30069s = new Function0<Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$runUpdate$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m273invoke();
                return Unit.f139807a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m273invoke() {
                if (this.f30106a.f30057g && this.f30106a.isAttachedToWindow()) {
                    ViewParent parent = this.f30106a.getView().getParent();
                    AndroidViewHolder androidViewHolder = this.f30106a;
                    if (parent == androidViewHolder) {
                        androidViewHolder.getSnapshotObserver().i(this.f30106a, AndroidViewHolder.D, this.f30106a.getUpdate());
                    }
                }
            }
        };
        this.f30070t = new Function0<Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$runInvalidate$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m272invoke();
                return Unit.f139807a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m272invoke() {
                this.f30105a.getLayoutNode().N0();
            }
        };
        this.f30072v = new int[2];
        this.f30073w = Integer.MIN_VALUE;
        this.f30074x = Integer.MIN_VALUE;
        this.f30075y = new NestedScrollingParentHelper(this);
        final LayoutNode layoutNode = new LayoutNode(false, 0, 3, null);
        layoutNode.L1(true);
        layoutNode.N1(this);
        final Modifier modifierA = OnGloballyPositionedModifierKt.a(DrawModifierKt.b(GraphicsLayerModifierKt.c(PointerInteropFilter_androidKt.a(SemanticsModifierKt.e(NestedScrollModifierKt.a(companion, AndroidViewHolder_androidKt.f30108a, nestedScrollDispatcher), true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$layoutNode$1$coreModifier$1
            public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((SemanticsPropertyReceiver) obj);
                return Unit.f139807a;
            }
        }), this), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new Function1<DrawScope, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$layoutNode$1$coreModifier$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((DrawScope) obj);
                return Unit.f139807a;
            }

            public final void invoke(DrawScope drawScope) {
                AndroidViewHolder androidViewHolder = this.f30091a;
                LayoutNode layoutNode2 = layoutNode;
                AndroidViewHolder androidViewHolder2 = this;
                Canvas canvasG = drawScope.Q1().g();
                if (androidViewHolder.getView().getVisibility() != 8) {
                    androidViewHolder.f30076z = true;
                    Owner ownerA0 = layoutNode2.A0();
                    AndroidComposeView androidComposeView = ownerA0 instanceof AndroidComposeView ? (AndroidComposeView) ownerA0 : null;
                    if (androidComposeView != null) {
                        androidComposeView.t0(androidViewHolder2, AndroidCanvas_androidKt.d(canvasG));
                    }
                    androidViewHolder.f30076z = false;
                }
            }
        }), new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$layoutNode$1$coreModifier$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((LayoutCoordinates) obj);
                return Unit.f139807a;
            }

            public final void invoke(LayoutCoordinates layoutCoordinates) {
                WindowInsets windowInsetsY;
                AndroidViewHolder_androidKt.f(this.f30094a, layoutNode);
                this.f30094a.f30055d.l(this.f30094a);
                int i4 = this.f30094a.f30066p[0];
                int i5 = this.f30094a.f30066p[1];
                this.f30094a.getView().getLocationOnScreen(this.f30094a.f30066p);
                long j3 = this.f30094a.f30067q;
                this.f30094a.f30067q = layoutCoordinates.a();
                WindowInsetsCompat windowInsetsCompat = this.f30094a.f30068r;
                if (windowInsetsCompat != null) {
                    if ((i4 == this.f30094a.f30066p[0] && i5 == this.f30094a.f30066p[1] && IntSize.e(j3, this.f30094a.f30067q)) || (windowInsetsY = this.f30094a.B(windowInsetsCompat).y()) == null) {
                        return;
                    }
                    this.f30094a.getView().dispatchApplyWindowInsets(windowInsetsY);
                }
            }
        });
        layoutNode.e(i3);
        layoutNode.l(this.f30060j.then(modifierA));
        this.f30061k = new Function1<Modifier, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$layoutNode$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void c(Modifier modifier) {
                layoutNode.l(modifier.then(modifierA));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c((Modifier) obj);
                return Unit.f139807a;
            }
        };
        layoutNode.d(this.f30062l);
        this.f30063m = new Function1<Density, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$layoutNode$1$2
            {
                super(1);
            }

            public final void c(Density density) {
                layoutNode.d(density);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c((Density) obj);
                return Unit.f139807a;
            }
        };
        layoutNode.T1(new Function1<Owner, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$layoutNode$1$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void c(Owner owner2) {
                AndroidComposeView androidComposeView = owner2 instanceof AndroidComposeView ? (AndroidComposeView) owner2 : null;
                if (androidComposeView != null) {
                    androidComposeView.k0(this.f30082a, layoutNode);
                }
                ViewParent parent = this.f30082a.getView().getParent();
                AndroidViewHolder androidViewHolder = this.f30082a;
                if (parent != androidViewHolder) {
                    androidViewHolder.addView(androidViewHolder.getView());
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c((Owner) obj);
                return Unit.f139807a;
            }
        });
        layoutNode.U1(new Function1<Owner, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$layoutNode$1$4
            {
                super(1);
            }

            public final void c(Owner owner2) {
                if (ComposeUiFlags.f25105e && this.f30084a.hasFocus()) {
                    owner2.getFocusOwner().v(true);
                }
                AndroidComposeView androidComposeView = owner2 instanceof AndroidComposeView ? (AndroidComposeView) owner2 : null;
                if (androidComposeView != null) {
                    androidComposeView.S0(this.f30084a);
                }
                this.f30084a.removeAllViewsInLayout();
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c((Owner) obj);
                return Unit.f139807a;
            }
        });
        layoutNode.k(new MeasurePolicy() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$layoutNode$1$5
            private final int a(int i4) {
                AndroidViewHolder androidViewHolder = this.f30085a;
                ViewGroup.LayoutParams layoutParams = androidViewHolder.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams);
                androidViewHolder.measure(androidViewHolder.E(0, i4, layoutParams.width), View.MeasureSpec.makeMeasureSpec(0, 0));
                return this.f30085a.getMeasuredHeight();
            }

            private final int b(int i4) {
                AndroidViewHolder androidViewHolder = this.f30085a;
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                AndroidViewHolder androidViewHolder2 = this.f30085a;
                ViewGroup.LayoutParams layoutParams = androidViewHolder2.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams);
                androidViewHolder.measure(iMakeMeasureSpec, androidViewHolder2.E(0, i4, layoutParams.height));
                return this.f30085a.getMeasuredWidth();
            }

            @Override // androidx.compose.ui.layout.MeasurePolicy
            public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i4) {
                return a(i4);
            }

            @Override // androidx.compose.ui.layout.MeasurePolicy
            public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i4) {
                return b(i4);
            }

            @Override // androidx.compose.ui.layout.MeasurePolicy
            /* JADX INFO: renamed from: measure-3p2s80s */
            public MeasureResult mo10measure3p2s80s(MeasureScope measureScope, List list, long j3) {
                if (this.f30085a.getChildCount() == 0) {
                    return MeasureScope.B0(measureScope, Constraints.n(j3), Constraints.m(j3), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$layoutNode$1$5$measure$1
                        public final void invoke(Placeable.PlacementScope placementScope) {
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((Placeable.PlacementScope) obj);
                            return Unit.f139807a;
                        }
                    }, 4, null);
                }
                if (Constraints.n(j3) != 0) {
                    this.f30085a.getChildAt(0).setMinimumWidth(Constraints.n(j3));
                }
                if (Constraints.m(j3) != 0) {
                    this.f30085a.getChildAt(0).setMinimumHeight(Constraints.m(j3));
                }
                AndroidViewHolder androidViewHolder = this.f30085a;
                int iN = Constraints.n(j3);
                int iL = Constraints.l(j3);
                ViewGroup.LayoutParams layoutParams = this.f30085a.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams);
                int iE = androidViewHolder.E(iN, iL, layoutParams.width);
                AndroidViewHolder androidViewHolder2 = this.f30085a;
                int iM = Constraints.m(j3);
                int iK = Constraints.k(j3);
                ViewGroup.LayoutParams layoutParams2 = this.f30085a.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams2);
                androidViewHolder.measure(iE, androidViewHolder2.E(iM, iK, layoutParams2.height));
                int measuredWidth = this.f30085a.getMeasuredWidth();
                int measuredHeight = this.f30085a.getMeasuredHeight();
                final AndroidViewHolder androidViewHolder3 = this.f30085a;
                final LayoutNode layoutNode2 = layoutNode;
                return MeasureScope.B0(measureScope, measuredWidth, measuredHeight, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$layoutNode$1$5$measure$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((Placeable.PlacementScope) obj);
                        return Unit.f139807a;
                    }

                    public final void invoke(Placeable.PlacementScope placementScope) {
                        AndroidViewHolder_androidKt.f(androidViewHolder3, layoutNode2);
                    }
                }, 4, null);
            }

            @Override // androidx.compose.ui.layout.MeasurePolicy
            public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i4) {
                return a(i4);
            }

            @Override // androidx.compose.ui.layout.MeasurePolicy
            public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i4) {
                return b(i4);
            }
        });
        this.A = layoutNode;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final WindowInsetsAnimationCompat.BoundsCompat A(WindowInsetsAnimationCompat.BoundsCompat boundsCompat) {
        NodeCoordinator nodeCoordinatorZ = this.A.Z();
        if (nodeCoordinatorZ.m()) {
            long jD = IntOffsetKt.d(LayoutCoordinatesKt.f(nodeCoordinatorZ));
            int iK = IntOffset.k(jD);
            if (iK < 0) {
                iK = 0;
            }
            int iL = IntOffset.l(jD);
            int i3 = iL < 0 ? 0 : iL;
            long jA = LayoutCoordinatesKt.d(nodeCoordinatorZ).a();
            int i4 = (int) (jA >> 32);
            int i5 = (int) (jA & 4294967295L);
            long jA2 = nodeCoordinatorZ.a();
            long jD2 = IntOffsetKt.d(nodeCoordinatorZ.x0(Offset.e((4294967295L & ((long) Float.floatToRawIntBits((int) (jA2 & 4294967295L)))) | (((long) Float.floatToRawIntBits((int) (jA2 >> 32))) << 32))));
            int iK2 = i4 - IntOffset.k(jD2);
            if (iK2 < 0) {
                iK2 = 0;
            }
            int iL2 = i5 - IntOffset.l(jD2);
            int i6 = iL2 >= 0 ? iL2 : 0;
            if (iK != 0 || i3 != 0 || iK2 != 0 || i6 != 0) {
                int i7 = iK;
                int i8 = iK2;
                return new WindowInsetsAnimationCompat.BoundsCompat(z(boundsCompat.a(), i7, i3, i8, i6), z(boundsCompat.b(), i7, i3, i8, i6));
            }
        }
        return boundsCompat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final WindowInsetsCompat B(WindowInsetsCompat windowInsetsCompat) {
        if (windowInsetsCompat.n()) {
            NodeCoordinator nodeCoordinatorZ = this.A.Z();
            if (nodeCoordinatorZ.m()) {
                long jD = IntOffsetKt.d(LayoutCoordinatesKt.f(nodeCoordinatorZ));
                int iK = IntOffset.k(jD);
                if (iK < 0) {
                    iK = 0;
                }
                int iL = IntOffset.l(jD);
                if (iL < 0) {
                    iL = 0;
                }
                long jA = LayoutCoordinatesKt.d(nodeCoordinatorZ).a();
                int i3 = (int) (jA >> 32);
                int i4 = (int) (jA & 4294967295L);
                long jA2 = nodeCoordinatorZ.a();
                long jD2 = IntOffsetKt.d(nodeCoordinatorZ.x0(Offset.e((((long) Float.floatToRawIntBits((int) (jA2 & 4294967295L))) & 4294967295L) | (((long) Float.floatToRawIntBits((int) (jA2 >> 32))) << 32))));
                int iK2 = i3 - IntOffset.k(jD2);
                if (iK2 < 0) {
                    iK2 = 0;
                }
                int iL2 = i4 - IntOffset.l(jD2);
                int i5 = iL2 < 0 ? 0 : iL2;
                if (iK != 0 || iL != 0 || iK2 != 0 || i5 != 0) {
                    return windowInsetsCompat.p(iK, iL, iK2, i5);
                }
            }
        }
        return windowInsetsCompat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(Function0 function0) {
        function0.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int E(int i3, int i4, int i5) {
        return (i5 >= 0 || i3 == i4) ? View.MeasureSpec.makeMeasureSpec(RangesKt.p(i5, i3, i4), 1073741824) : (i5 != -2 || i4 == Integer.MAX_VALUE) ? (i5 != -1 || i4 == Integer.MAX_VALUE) ? View.MeasureSpec.makeMeasureSpec(0, 0) : View.MeasureSpec.makeMeasureSpec(i4, 1073741824) : View.MeasureSpec.makeMeasureSpec(i4, Integer.MIN_VALUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final OwnerSnapshotObserver getSnapshotObserver() {
        if (!isAttachedToWindow()) {
            InlineClassHelperKt.c("Expected AndroidViewHolder to be attached when observing reads.");
        }
        return this.f30055d.getSnapshotObserver();
    }

    private final Insets z(Insets insets, int i3, int i4, int i5, int i6) {
        int i7 = insets.f33964a - i3;
        if (i7 < 0) {
            i7 = 0;
        }
        int i8 = insets.f33965b - i4;
        if (i8 < 0) {
            i8 = 0;
        }
        int i9 = insets.f33966c - i5;
        if (i9 < 0) {
            i9 = 0;
        }
        int i10 = insets.f33967d - i6;
        return Insets.b(i7, i8, i9, i10 >= 0 ? i10 : 0);
    }

    public final void C() {
        if (!this.f30076z) {
            this.A.N0();
            return;
        }
        View view = this.f30054c;
        final Function0 function0 = this.f30070t;
        view.postOnAnimation(new Runnable() { // from class: androidx.compose.ui.viewinterop.a
            @Override // java.lang.Runnable
            public final void run() {
                AndroidViewHolder.D(function0);
            }
        });
    }

    public final void F() {
        int i3;
        int i4 = this.f30073w;
        if (i4 == Integer.MIN_VALUE || (i3 = this.f30074x) == Integer.MIN_VALUE) {
            return;
        }
        measure(i4, i3);
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public WindowInsetsCompat a(View view, WindowInsetsCompat windowInsetsCompat) {
        this.f30068r = new WindowInsetsCompat(windowInsetsCompat);
        return B(windowInsetsCompat);
    }

    @Override // androidx.compose.ui.node.OwnerScope
    public boolean a1() {
        return isAttachedToWindow();
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public void b() {
        this.f30059i.invoke();
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public void f() {
        this.f30058h.invoke();
        if (ComposeUiFlags.f25106f && hasFocus() && isInTouchMode() && Build.VERSION.SDK_INT > 28) {
            findFocus().clearFocus();
        }
        removeAllViewsInLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean gatherTransparentRegion(Region region) {
        if (region == null) {
            return true;
        }
        getLocationInWindow(this.f30072v);
        int[] iArr = this.f30072v;
        int i3 = iArr[0];
        region.op(i3, iArr[1], i3 + getWidth(), this.f30072v[1] + getHeight(), Region.Op.DIFFERENCE);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return getClass().getName();
    }

    public final Density getDensity() {
        return this.f30062l;
    }

    public final View getInteropView() {
        return this.f30054c;
    }

    public final LayoutNode getLayoutNode() {
        return this.A;
    }

    @Override // android.view.View
    public ViewGroup.LayoutParams getLayoutParams() {
        ViewGroup.LayoutParams layoutParams = this.f30054c.getLayoutParams();
        return layoutParams == null ? new ViewGroup.LayoutParams(-1, -1) : layoutParams;
    }

    public final LifecycleOwner getLifecycleOwner() {
        return this.f30064n;
    }

    public final Modifier getModifier() {
        return this.f30060j;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.f30075y.a();
    }

    public final Function1<Density, Unit> getOnDensityChanged$ui_release() {
        return this.f30063m;
    }

    public final Function1<Modifier, Unit> getOnModifierChanged$ui_release() {
        return this.f30061k;
    }

    public final Function1<Boolean, Unit> getOnRequestDisallowInterceptTouchEvent$ui_release() {
        return this.f30071u;
    }

    public final Function0<Unit> getRelease() {
        return this.f30059i;
    }

    public final Function0<Unit> getReset() {
        return this.f30058h;
    }

    public final SavedStateRegistryOwner getSavedStateRegistryOwner() {
        return this.f30065o;
    }

    public final Function0<Unit> getUpdate() {
        return this.f30056f;
    }

    public final View getView() {
        return this.f30054c;
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public void i() {
        if (this.f30054c.getParent() != this) {
            addView(this.f30054c);
        } else {
            this.f30058h.invoke();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ViewParent invalidateChildInParent(int[] iArr, Rect rect) {
        super.invalidateChildInParent(iArr, rect);
        C();
        return null;
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        return this.f30054c.isNestedScrollingEnabled();
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void j(View view, View view2, int i3, int i4) {
        this.f30075y.c(view, view2, i3, i4);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void k(View view, int i3) {
        this.f30075y.e(view, i3);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void l(View view, int i3, int i4, int[] iArr, int i5) {
        if (isNestedScrollingEnabled()) {
            NestedScrollDispatcher nestedScrollDispatcher = this.f30053b;
            float fG = AndroidViewHolder_androidKt.g(i3);
            long jD = nestedScrollDispatcher.d(Offset.e((((long) Float.floatToRawIntBits(AndroidViewHolder_androidKt.g(i4))) & 4294967295L) | (Float.floatToRawIntBits(fG) << 32)), AndroidViewHolder_androidKt.i(i5));
            iArr[0] = NestedScrollInteropConnectionKt.f(Float.intBitsToFloat((int) (jD >> 32)));
            iArr[1] = NestedScrollInteropConnectionKt.f(Float.intBitsToFloat((int) (jD & 4294967295L)));
        }
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public void n(View view, int i3, int i4, int i5, int i6, int i7, int[] iArr) {
        if (isNestedScrollingEnabled()) {
            NestedScrollDispatcher nestedScrollDispatcher = this.f30053b;
            float fG = AndroidViewHolder_androidKt.g(i3);
            long jE = Offset.e((((long) Float.floatToRawIntBits(AndroidViewHolder_androidKt.g(i4))) & 4294967295L) | (Float.floatToRawIntBits(fG) << 32));
            float fG2 = AndroidViewHolder_androidKt.g(i5);
            long jB = nestedScrollDispatcher.b(jE, Offset.e((((long) Float.floatToRawIntBits(AndroidViewHolder_androidKt.g(i6))) & 4294967295L) | (Float.floatToRawIntBits(fG2) << 32)), AndroidViewHolder_androidKt.i(i7));
            iArr[0] = NestedScrollInteropConnectionKt.f(Float.intBitsToFloat((int) (jB >> 32)));
            iArr[1] = NestedScrollInteropConnectionKt.f(Float.intBitsToFloat((int) (jB & 4294967295L)));
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void o(View view, int i3, int i4, int i5, int i6, int i7) {
        if (isNestedScrollingEnabled()) {
            NestedScrollDispatcher nestedScrollDispatcher = this.f30053b;
            float fG = AndroidViewHolder_androidKt.g(i3);
            long jE = Offset.e((((long) Float.floatToRawIntBits(AndroidViewHolder_androidKt.g(i4))) & 4294967295L) | (Float.floatToRawIntBits(fG) << 32));
            float fG2 = AndroidViewHolder_androidKt.g(i5);
            nestedScrollDispatcher.b(jE, Offset.e((((long) Float.floatToRawIntBits(AndroidViewHolder_androidKt.g(i6))) & 4294967295L) | (Float.floatToRawIntBits(fG2) << 32)), AndroidViewHolder_androidKt.i(i7));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f30069s.invoke();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onDescendantInvalidated(View view, View view2) {
        super.onDescendantInvalidated(view, view2);
        C();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getSnapshotObserver().a(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i3, int i4, int i5, int i6) {
        this.f30054c.layout(0, 0, i5 - i3, i6 - i4);
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i4) {
        if (this.f30054c.getParent() != this) {
            setMeasuredDimension(View.MeasureSpec.getSize(i3), View.MeasureSpec.getSize(i4));
            return;
        }
        if (this.f30054c.getVisibility() == 8) {
            setMeasuredDimension(0, 0);
            return;
        }
        this.f30054c.measure(i3, i4);
        setMeasuredDimension(this.f30054c.getMeasuredWidth(), this.f30054c.getMeasuredHeight());
        this.f30073w = i3;
        this.f30074x = i4;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(View view, float f3, float f4, boolean z2) {
        if (!isNestedScrollingEnabled()) {
            return false;
        }
        BuildersKt__Builders_commonKt.d(this.f30053b.e(), null, null, new AnonymousClass1(z2, this, VelocityKt.a(AndroidViewHolder_androidKt.h(f3), AndroidViewHolder_androidKt.h(f4)), null), 3, null);
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f3, float f4) {
        if (!isNestedScrollingEnabled()) {
            return false;
        }
        BuildersKt__Builders_commonKt.d(this.f30053b.e(), null, null, new C03471(VelocityKt.a(AndroidViewHolder_androidKt.h(f3), AndroidViewHolder_androidKt.h(f4)), null), 3, null);
        return false;
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i3) {
        super.onWindowVisibilityChanged(i3);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean p(View view, View view2, int i3, int i4) {
        return ((i3 & 2) == 0 && (i3 & 1) == 0) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z2) {
        Function1 function1 = this.f30071u;
        if (function1 != null) {
            function1.invoke(Boolean.valueOf(z2));
        }
        super.requestDisallowInterceptTouchEvent(z2);
    }

    public final void setDensity(Density density) {
        if (density != this.f30062l) {
            this.f30062l = density;
            Function1 function1 = this.f30063m;
            if (function1 != null) {
                function1.invoke(density);
            }
        }
    }

    public final void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        if (lifecycleOwner != this.f30064n) {
            this.f30064n = lifecycleOwner;
            ViewTreeLifecycleOwner.b(this, lifecycleOwner);
        }
    }

    public final void setModifier(Modifier modifier) {
        if (modifier != this.f30060j) {
            this.f30060j = modifier;
            Function1 function1 = this.f30061k;
            if (function1 != null) {
                function1.invoke(modifier);
            }
        }
    }

    public final void setOnDensityChanged$ui_release(Function1<? super Density, Unit> function1) {
        this.f30063m = function1;
    }

    public final void setOnModifierChanged$ui_release(Function1<? super Modifier, Unit> function1) {
        this.f30061k = function1;
    }

    public final void setOnRequestDisallowInterceptTouchEvent$ui_release(Function1<? super Boolean, Unit> function1) {
        this.f30071u = function1;
    }

    protected final void setRelease(Function0<Unit> function0) {
        this.f30059i = function0;
    }

    protected final void setReset(Function0<Unit> function0) {
        this.f30058h = function0;
    }

    public final void setSavedStateRegistryOwner(SavedStateRegistryOwner savedStateRegistryOwner) {
        if (savedStateRegistryOwner != this.f30065o) {
            this.f30065o = savedStateRegistryOwner;
            ViewTreeSavedStateRegistryOwner.b(this, savedStateRegistryOwner);
        }
    }

    protected final void setUpdate(Function0<Unit> function0) {
        this.f30056f = function0;
        this.f30057g = true;
        this.f30069s.invoke();
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return true;
    }
}
