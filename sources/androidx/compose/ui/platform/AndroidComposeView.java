package androidx.compose.ui.platform;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Point;
import android.os.Build;
import android.os.SystemClock;
import android.os.Trace;
import android.util.LongSparseArray;
import android.util.SparseArray;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStructure;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.AnimationUtils;
import android.view.autofill.AutofillManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.collection.IntObjectMapKt;
import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableObjectList;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.ComposeUiFlags;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.SessionMutex;
import androidx.compose.ui.autofill.AndroidAutofill;
import androidx.compose.ui.autofill.AndroidAutofillManager;
import androidx.compose.ui.autofill.AndroidAutofill_androidKt;
import androidx.compose.ui.autofill.Autofill;
import androidx.compose.ui.autofill.AutofillCallback;
import androidx.compose.ui.autofill.AutofillTree;
import androidx.compose.ui.autofill.PlatformAutofillManagerImpl;
import androidx.compose.ui.contentcapture.AndroidContentCaptureManager;
import androidx.compose.ui.draganddrop.AndroidDragAndDropManager;
import androidx.compose.ui.draganddrop.ComposeDragShadowBuilder;
import androidx.compose.ui.draganddrop.DragAndDropTransferData;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.focus.FocusInteropUtils_androidKt;
import androidx.compose.ui.focus.FocusOwner;
import androidx.compose.ui.focus.FocusOwnerImpl;
import androidx.compose.ui.focus.FocusOwnerImplKt;
import androidx.compose.ui.focus.FocusTargetNode;
import androidx.compose.ui.focus.FocusTraversalKt;
import androidx.compose.ui.focus.TwoDimensionalFocusSearchKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.AndroidGraphicsContext_androidKt;
import androidx.compose.ui.graphics.CanvasHolder;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.graphics.RectHelper_androidKt;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.PlatformHapticFeedback;
import androidx.compose.ui.input.InputMode;
import androidx.compose.ui.input.InputModeManager;
import androidx.compose.ui.input.InputModeManagerImpl;
import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.KeyEvent;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.input.pointer.MatrixPositionCalculator;
import androidx.compose.ui.input.pointer.MotionEventAdapter;
import androidx.compose.ui.input.pointer.PointerIcon;
import androidx.compose.ui.input.pointer.PointerIconService;
import androidx.compose.ui.input.pointer.PointerInputEvent;
import androidx.compose.ui.input.pointer.PointerInputEventData;
import androidx.compose.ui.input.pointer.PointerInputEventProcessor;
import androidx.compose.ui.input.pointer.PointerInputEventProcessorKt;
import androidx.compose.ui.input.pointer.PointerKeyboardModifiers;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNode;
import androidx.compose.ui.input.rotary.RotaryInputModifierKt;
import androidx.compose.ui.input.rotary.RotaryScrollEvent;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.PlaceableKt;
import androidx.compose.ui.layout.RootMeasurePolicy;
import androidx.compose.ui.modifier.ModifierLocalManager;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import androidx.compose.ui.node.MeasureAndLayoutDelegate;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.OwnedLayer;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.node.OwnerSnapshotObserver;
import androidx.compose.ui.node.PointerInputModifierNode;
import androidx.compose.ui.node.RootForTest;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.platform.ViewLayer;
import androidx.compose.ui.scrollcapture.ScrollCapture;
import androidx.compose.ui.semantics.EmptySemanticsElement;
import androidx.compose.ui.semantics.EmptySemanticsModifier;
import androidx.compose.ui.semantics.SemanticsOwner;
import androidx.compose.ui.spatial.RectManager;
import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontFamilyResolver_androidKt;
import androidx.compose.ui.text.input.PlatformTextInputService;
import androidx.compose.ui.text.input.TextInputService;
import androidx.compose.ui.text.input.TextInputServiceAndroid;
import androidx.compose.ui.unit.AndroidDensity_androidKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.viewinterop.AndroidViewHolder;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import com.google.android.gms.common.api.Api;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;
import kotlin.Deprecated;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.Ref;

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
public final class AndroidComposeView extends ViewGroup implements Owner, ViewRootForTest, MatrixPositionCalculator, DefaultLifecycleObserver {
    public static final Companion L0 = new Companion(null);
    public static final int M0 = 8;
    private static Class N0;
    private static Method O0;
    private final AutofillTree A;
    private final WeakCache A0;
    private final List B;
    private final MutableObjectList B0;
    private List C;
    private final AndroidComposeView$resendMotionEventRunnable$1 C0;
    private boolean D;
    private final Runnable D0;
    private boolean E;
    private boolean E0;
    private final MotionEventAdapter F;
    private final Function0 F0;
    private final PointerInputEventProcessor G;
    private final CalculateMatrixToWindow G0;
    private Function1 H;
    private boolean H0;
    private final AndroidAutofill I;
    private final ScrollCapture I0;
    private final AndroidAutofillManager J;
    private final PointerIconService J0;
    private boolean K;
    private int K0;
    private final AndroidClipboardManager L;
    private final AndroidClipboard M;
    private final OwnerSnapshotObserver N;
    private boolean O;
    private AndroidViewsHandler P;
    private DrawChildContainer Q;
    private Constraints R;
    private boolean S;
    private final MeasureAndLayoutDelegate T;
    private long U;
    private final int[] V;
    private final float[] W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f27679a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private final float[] f27680a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f27681b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private final float[] f27682b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final LayoutNodeDrawScope f27683c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private long f27684c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final MutableState f27685d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private boolean f27686d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private long f27687e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final EmptySemanticsModifier f27688f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private boolean f27689f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final EmptySemanticsElement f27690g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private final MutableState f27691g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final AndroidComposeView$bringIntoViewNode$1 f27692h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private final State f27693h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final FocusOwner f27694i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private Function1 f27695i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private CoroutineContext f27696j;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private final ViewTreeObserver.OnGlobalLayoutListener f27697j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final AndroidDragAndDropManager f27698k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    private final ViewTreeObserver.OnScrollChangedListener f27699k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final LazyWindowInfo f27700l;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    private final ViewTreeObserver.OnTouchModeChangeListener f27701l0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f27702m;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    private final TextInputServiceAndroid f27703m0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Modifier f27704n;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    private final TextInputService f27705n0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Modifier f27706o;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    private final AtomicReference f27707o0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final CanvasHolder f27708p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    private final SoftwareKeyboardController f27709p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final ViewConfiguration f27710q;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    private final Font.ResourceLoader f27711q0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final LayoutNode f27712r;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    private final MutableState f27713r0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final MutableIntObjectMap f27714s;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    private int f27715s0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final RectManager f27716t;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    private final MutableState f27717t0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final RootForTest f27718u;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    private final HapticFeedback f27719u0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final SemanticsOwner f27720v;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    private final InputModeManagerImpl f27721v0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final AndroidComposeViewAccessibilityDelegateCompat f27722w;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    private final ModifierLocalManager f27723w0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private AndroidContentCaptureManager f27724x;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    private final TextToolbar f27725x0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final AndroidAccessibilityManager f27726y;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    private MotionEvent f27727y0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final GraphicsContext f27728z;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    private long f27729z0;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean b() {
            try {
                if (AndroidComposeView.N0 == null) {
                    AndroidComposeView.N0 = Class.forName("android.os.SystemProperties");
                    Class cls = AndroidComposeView.N0;
                    AndroidComposeView.O0 = cls != null ? cls.getDeclaredMethod("getBoolean", String.class, Boolean.TYPE) : null;
                }
                Method method = AndroidComposeView.O0;
                Object objInvoke = method != null ? method.invoke(null, "debug.layout", Boolean.FALSE) : null;
                Boolean bool = objInvoke instanceof Boolean ? (Boolean) objInvoke : null;
                if (bool != null) {
                    return bool.booleanValue();
                }
                return false;
            } catch (Exception unused) {
                return false;
            }
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ViewTreeOwners {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final LifecycleOwner f27730a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final SavedStateRegistryOwner f27731b;

        public ViewTreeOwners(LifecycleOwner lifecycleOwner, SavedStateRegistryOwner savedStateRegistryOwner) {
            this.f27730a = lifecycleOwner;
            this.f27731b = savedStateRegistryOwner;
        }

        public final LifecycleOwner a() {
            return this.f27730a;
        }

        public final SavedStateRegistryOwner b() {
            return this.f27731b;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v13, types: [androidx.compose.ui.platform.AndroidComposeView$resendMotionEventRunnable$1] */
    /* JADX WARN: Type inference failed for: r5v0, types: [androidx.compose.ui.Modifier, androidx.compose.ui.platform.AndroidComposeView$bringIntoViewNode$1] */
    public AndroidComposeView(Context context, CoroutineContext coroutineContext) {
        AndroidComposeView androidComposeView;
        AndroidAutofillManager androidAutofillManager;
        super(context);
        Offset.Companion companion = Offset.f25596b;
        this.f27679a = companion.b();
        int i3 = 1;
        this.f27681b = true;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        Object[] objArr3 = 0;
        this.f27683c = new LayoutNodeDrawScope(0 == true ? 1 : 0, i3, 0 == true ? 1 : 0);
        this.f27685d = SnapshotStateKt.i(AndroidDensity_androidKt.a(context), SnapshotStateKt.o());
        EmptySemanticsModifier emptySemanticsModifier = new EmptySemanticsModifier();
        this.f27688f = emptySemanticsModifier;
        EmptySemanticsElement emptySemanticsElement = new EmptySemanticsElement(emptySemanticsModifier);
        this.f27690g = emptySemanticsElement;
        ?? r5 = new ModifierNodeElement<BringIntoViewOnScreenResponderNode>() { // from class: androidx.compose.ui.platform.AndroidComposeView$bringIntoViewNode$1
            @Override // androidx.compose.ui.node.ModifierNodeElement
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public BringIntoViewOnScreenResponderNode create() {
                return new BringIntoViewOnScreenResponderNode(this.f27736a);
            }

            @Override // androidx.compose.ui.node.ModifierNodeElement
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void update(BringIntoViewOnScreenResponderNode bringIntoViewOnScreenResponderNode) {
                bringIntoViewOnScreenResponderNode.m2(this.f27736a);
            }

            public boolean equals(Object obj) {
                return obj == this;
            }

            public int hashCode() {
                return this.f27736a.hashCode();
            }

            @Override // androidx.compose.ui.node.ModifierNodeElement
            public void inspectableProperties(InspectorInfo inspectorInfo) {
                inspectorInfo.d("BringIntoViewOnScreen");
            }
        };
        this.f27692h = r5;
        this.f27694i = new FocusOwnerImpl(new AndroidComposeView$focusOwner$1(this), new AndroidComposeView$focusOwner$2(this), new AndroidComposeView$focusOwner$3(this), new AndroidComposeView$focusOwner$4(this), new AndroidComposeView$focusOwner$5(this), new MutablePropertyReference0Impl(this) { // from class: androidx.compose.ui.platform.AndroidComposeView$focusOwner$6
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                return ((AndroidComposeView) this.receiver).getLayoutDirection();
            }
        });
        this.f27696j = coroutineContext;
        this.f27698k = new AndroidDragAndDropManager(new AndroidComposeView$dragAndDropManager$1(this));
        this.f27700l = new LazyWindowInfo();
        Modifier.Companion companion2 = Modifier.b8;
        Modifier modifierA = KeyInputModifierKt.a(companion2, new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView$keyInputModifier$1
            {
                super(1);
            }

            public final Boolean c(android.view.KeyEvent keyEvent) {
                final FocusDirection focusDirectionW0 = this.f27744a.w0(keyEvent);
                if (focusDirectionW0 == null || !KeyEventType.f(KeyEvent_androidKt.b(keyEvent), KeyEventType.f26731b.a())) {
                    return Boolean.FALSE;
                }
                Integer numC = FocusInteropUtils_androidKt.c(focusDirectionW0.o());
                if (ComposeUiFlags.f25105e && this.f27744a.hasFocus() && numC != null && this.f27744a.L0(focusDirectionW0.o())) {
                    return Boolean.TRUE;
                }
                Rect rectK0 = this.f27744a.K0();
                Boolean boolW = this.f27744a.getFocusOwner().w(focusDirectionW0.o(), rectK0, new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView$keyInputModifier$1$focusWasMovedOrCancelled$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                    public final Boolean invoke(FocusTargetNode focusTargetNode) {
                        return Boolean.valueOf(focusTargetNode.R(focusDirectionW0.o()));
                    }
                });
                if (boolW != null ? boolW.booleanValue() : true) {
                    return Boolean.TRUE;
                }
                if (!FocusOwnerImplKt.a(focusDirectionW0.o())) {
                    return Boolean.FALSE;
                }
                if (numC != null) {
                    View viewU0 = this.f27744a.u0(numC.intValue());
                    if (Intrinsics.areEqual(viewU0, this.f27744a)) {
                        viewU0 = null;
                    }
                    if (viewU0 != null) {
                        android.graphics.Rect rectA = rectK0 != null ? RectHelper_androidKt.a(rectK0) : null;
                        if (rectA == null) {
                            throw new IllegalStateException("Invalid rect");
                        }
                        viewU0.getLocationInWindow(this.f27744a.V);
                        int i4 = this.f27744a.V[0];
                        int i5 = this.f27744a.V[1];
                        AndroidComposeView androidComposeView2 = this.f27744a;
                        androidComposeView2.getLocationInWindow(androidComposeView2.V);
                        rectA.offset(this.f27744a.V[0] - i4, this.f27744a.V[1] - i5);
                        if (FocusInteropUtils_androidKt.b(viewU0, numC, rectA)) {
                            return Boolean.TRUE;
                        }
                    }
                }
                if (!this.f27744a.getFocusOwner().o(false, true, false, focusDirectionW0.o())) {
                    return Boolean.TRUE;
                }
                Boolean boolW2 = this.f27744a.getFocusOwner().w(focusDirectionW0.o(), null, new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView$keyInputModifier$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                    public final Boolean invoke(FocusTargetNode focusTargetNode) {
                        return Boolean.valueOf(focusTargetNode.R(focusDirectionW0.o()));
                    }
                });
                return Boolean.valueOf(boolW2 != null ? boolW2.booleanValue() : true);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return c(((KeyEvent) obj).f());
            }
        });
        this.f27704n = modifierA;
        Modifier modifierA2 = RotaryInputModifierKt.a(companion2, new Function1<RotaryScrollEvent, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView$rotaryInputModifier$1
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(RotaryScrollEvent rotaryScrollEvent) {
                return Boolean.FALSE;
            }
        });
        this.f27706o = modifierA2;
        this.f27708p = new CanvasHolder();
        this.f27710q = new AndroidViewConfiguration(android.view.ViewConfiguration.get(context));
        Object[] objArr4 = 0;
        LayoutNode layoutNode = new LayoutNode(false, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        layoutNode.k(RootMeasurePolicy.f27208b);
        layoutNode.d(getDensity());
        layoutNode.h(getViewConfiguration());
        layoutNode.l(companion2.then(emptySemanticsElement).then(modifierA2).then(modifierA).then(getFocusOwner().a()).then(getDragAndDropManager().c()).then(r5));
        this.f27712r = layoutNode;
        this.f27714s = IntObjectMapKt.c();
        this.f27716t = new RectManager(getLayoutNodes());
        this.f27718u = this;
        this.f27720v = new SemanticsOwner(getRoot(), emptySemanticsModifier, getLayoutNodes());
        AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat = new AndroidComposeViewAccessibilityDelegateCompat(this);
        this.f27722w = androidComposeViewAccessibilityDelegateCompat;
        this.f27724x = new AndroidContentCaptureManager(this, new AndroidComposeView$contentCaptureManager$1(this));
        this.f27726y = new AndroidAccessibilityManager(context);
        this.f27728z = AndroidGraphicsContext_androidKt.a(this);
        this.A = new AutofillTree();
        this.B = new ArrayList();
        this.F = new MotionEventAdapter();
        this.G = new PointerInputEventProcessor(getRoot());
        this.H = new Function1<Configuration, Unit>() { // from class: androidx.compose.ui.platform.AndroidComposeView$configurationChangeObserver$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c((Configuration) obj);
                return Unit.f139807a;
            }

            public final void c(Configuration configuration) {
            }
        };
        this.I = m0() ? new AndroidAutofill(this, getAutofillTree()) : null;
        if (m0()) {
            AutofillManager autofillManager = (AutofillManager) context.getSystemService(AutofillManager.class);
            if (autofillManager == null) {
                InlineClassHelperKt.d("Autofill service could not be located.");
                throw new KotlinNothingValueException();
            }
            androidComposeView = this;
            androidAutofillManager = new AndroidAutofillManager(new PlatformAutofillManagerImpl(autofillManager), getSemanticsOwner(), androidComposeView, getRectManager(), context.getPackageName());
        } else {
            androidComposeView = this;
            androidAutofillManager = null;
        }
        androidComposeView.J = androidAutofillManager;
        androidComposeView.L = new AndroidClipboardManager(context);
        androidComposeView.M = new AndroidClipboard(getClipboardManager());
        androidComposeView.N = new OwnerSnapshotObserver(new AndroidComposeView$snapshotObserver$1(this));
        androidComposeView.T = new MeasureAndLayoutDelegate(getRoot());
        long j3 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        androidComposeView.U = IntOffset.f((j3 & 4294967295L) | (j3 << 32));
        androidComposeView.V = new int[]{0, 0};
        float[] fArrC = Matrix.c(null, 1, null);
        androidComposeView.W = fArrC;
        androidComposeView.f27680a0 = Matrix.c(null, 1, null);
        androidComposeView.f27682b0 = Matrix.c(null, 1, null);
        androidComposeView.f27684c0 = -1L;
        androidComposeView.f27687e0 = companion.a();
        androidComposeView.f27689f0 = true;
        androidComposeView.f27691g0 = SnapshotStateKt__SnapshotStateKt.e(null, null, 2, null);
        androidComposeView.f27693h0 = SnapshotStateKt.e(new Function0<ViewTreeOwners>() { // from class: androidx.compose.ui.platform.AndroidComposeView$viewTreeOwners$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final AndroidComposeView.ViewTreeOwners invoke() {
                return this.f27765a.get_viewTreeOwners();
            }
        });
        androidComposeView.f27697j0 = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: androidx.compose.ui.platform.b
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                AndroidComposeView.y0(this.f28359a);
            }
        };
        androidComposeView.f27699k0 = new ViewTreeObserver.OnScrollChangedListener() { // from class: androidx.compose.ui.platform.c
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public final void onScrollChanged() {
                AndroidComposeView.W0(this.f28360a);
            }
        };
        androidComposeView.f27701l0 = new ViewTreeObserver.OnTouchModeChangeListener() { // from class: androidx.compose.ui.platform.d
            @Override // android.view.ViewTreeObserver.OnTouchModeChangeListener
            public final void onTouchModeChanged(boolean z2) {
                AndroidComposeView.c1(this.f28365a, z2);
            }
        };
        TextInputServiceAndroid textInputServiceAndroid = new TextInputServiceAndroid(getView(), this);
        androidComposeView.f27703m0 = textInputServiceAndroid;
        androidComposeView.f27705n0 = new TextInputService((PlatformTextInputService) AndroidComposeView_androidKt.h().invoke(textInputServiceAndroid));
        androidComposeView.f27707o0 = SessionMutex.a();
        androidComposeView.f27709p0 = new DelegatingSoftwareKeyboardController(getTextInputService());
        androidComposeView.f27711q0 = new AndroidFontResourceLoader(context);
        androidComposeView.f27713r0 = SnapshotStateKt.i(FontFamilyResolver_androidKt.a(context), SnapshotStateKt.o());
        androidComposeView.f27715s0 = x0(context.getResources().getConfiguration());
        LayoutDirection layoutDirectionE = FocusInteropUtils_androidKt.e(context.getResources().getConfiguration().getLayoutDirection());
        androidComposeView.f27717t0 = SnapshotStateKt__SnapshotStateKt.e(layoutDirectionE == null ? LayoutDirection.f30001a : layoutDirectionE, null, 2, null);
        androidComposeView.f27719u0 = new PlatformHapticFeedback(this);
        androidComposeView.f27721v0 = new InputModeManagerImpl(isInTouchMode() ? InputMode.f26627b.b() : InputMode.f26627b.a(), new Function1<InputMode, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView$_inputModeManager$1
            {
                super(1);
            }

            public final Boolean c(int i4) {
                InputMode.Companion companion3 = InputMode.f26627b;
                return Boolean.valueOf(InputMode.f(i4, companion3.b()) ? this.f27732a.isInTouchMode() : InputMode.f(i4, companion3.a()) ? this.f27732a.isInTouchMode() ? this.f27732a.requestFocusFromTouch() : true : false);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return c(((InputMode) obj).i());
            }
        }, objArr3 == true ? 1 : 0);
        androidComposeView.f27723w0 = new ModifierLocalManager(this);
        androidComposeView.f27725x0 = new AndroidTextToolbar(this);
        androidComposeView.A0 = new WeakCache();
        androidComposeView.B0 = new MutableObjectList(objArr4 == true ? 1 : 0, i3, objArr2 == true ? 1 : 0);
        androidComposeView.C0 = new Runnable() { // from class: androidx.compose.ui.platform.AndroidComposeView$resendMotionEventRunnable$1
            @Override // java.lang.Runnable
            public void run() {
                this.f27758a.removeCallbacks(this);
                MotionEvent motionEvent = this.f27758a.f27727y0;
                if (motionEvent != null) {
                    boolean z2 = motionEvent.getToolType(0) == 3;
                    int actionMasked = motionEvent.getActionMasked();
                    if (z2) {
                        if (actionMasked == 10 || actionMasked == 1) {
                            return;
                        }
                    } else if (actionMasked == 1) {
                        return;
                    }
                    int i4 = 7;
                    if (actionMasked != 7 && actionMasked != 9) {
                        i4 = 2;
                    }
                    AndroidComposeView androidComposeView2 = this.f27758a;
                    androidComposeView2.Z0(motionEvent, i4, androidComposeView2.f27729z0, false);
                }
            }
        };
        androidComposeView.D0 = new Runnable() { // from class: androidx.compose.ui.platform.e
            @Override // java.lang.Runnable
            public final void run() {
                AndroidComposeView.X0(this.f28366a);
            }
        };
        androidComposeView.F0 = new Function0<Unit>() { // from class: androidx.compose.ui.platform.AndroidComposeView$resendMotionEventOnLayout$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m248invoke();
                return Unit.f139807a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m248invoke() {
                MotionEvent motionEvent = this.f27757a.f27727y0;
                if (motionEvent != null) {
                    int actionMasked = motionEvent.getActionMasked();
                    if (actionMasked == 7 || actionMasked == 9) {
                        this.f27757a.f27729z0 = SystemClock.uptimeMillis();
                        AndroidComposeView androidComposeView2 = this.f27757a;
                        androidComposeView2.post(androidComposeView2.C0);
                    }
                }
            }
        };
        int i4 = Build.VERSION.SDK_INT;
        androidComposeView.G0 = i4 < 29 ? new CalculateMatrixToWindowApi21(fArrC, objArr == true ? 1 : 0) : new CalculateMatrixToWindowApi29();
        addOnAttachStateChangeListener(androidComposeView.f27724x);
        setWillNotDraw(false);
        setFocusable(true);
        AndroidComposeViewVerificationHelperMethodsO.f27829a.a(this, 1, false);
        setFocusableInTouchMode(true);
        setClipChildren(false);
        ViewCompat.m0(this, androidComposeViewAccessibilityDelegateCompat);
        Function1 function1A = ViewRootForTest.i8.a();
        if (function1A != null) {
            function1A.invoke(this);
        }
        setOnDragListener(getDragAndDropManager());
        getRoot().z(this);
        if (i4 >= 29) {
            AndroidComposeViewForceDarkModeQ.f27823a.a(this);
        }
        androidComposeView.I0 = i4 >= 31 ? new ScrollCapture() : null;
        androidComposeView.J0 = new PointerIconService() { // from class: androidx.compose.ui.platform.AndroidComposeView$pointerIconService$1

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private PointerIcon f27748a = PointerIcon.f26847a.a();

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private PointerIcon f27749b;

            @Override // androidx.compose.ui.input.pointer.PointerIconService
            public void a(PointerIcon pointerIcon) {
                if (pointerIcon == null) {
                    pointerIcon = PointerIcon.f26847a.a();
                }
                this.f27748a = pointerIcon;
                AndroidComposeViewVerificationHelperMethodsN.f27828a.a(this.f27750c, pointerIcon);
            }

            @Override // androidx.compose.ui.input.pointer.PointerIconService
            public PointerIcon b() {
                return this.f27749b;
            }

            @Override // androidx.compose.ui.input.pointer.PointerIconService
            public void c(PointerIcon pointerIcon) {
                this.f27749b = pointerIcon;
            }
        };
    }

    private final boolean A0(final MotionEvent motionEvent) {
        android.view.ViewConfiguration viewConfiguration = android.view.ViewConfiguration.get(getContext());
        float f3 = -motionEvent.getAxisValue(26);
        return getFocusOwner().l(new RotaryScrollEvent(ViewConfigurationCompat.h(viewConfiguration, getContext()) * f3, f3 * ViewConfigurationCompat.e(viewConfiguration, getContext()), motionEvent.getEventTime(), motionEvent.getDeviceId()), new Function0<Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView$handleRotaryEvent$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.valueOf(super/*android.view.View*/.dispatchGenericMotionEvent(motionEvent));
            }
        });
    }

    private final boolean B0(MotionEvent motionEvent, MotionEvent motionEvent2) {
        return (motionEvent2.getSource() == motionEvent.getSource() && motionEvent2.getToolType(0) == motionEvent.getToolType(0)) ? false : true;
    }

    private final void C0(LayoutNode layoutNode) {
        layoutNode.O0();
        MutableVector mutableVectorH0 = layoutNode.H0();
        Object[] objArr = mutableVectorH0.f24389a;
        int iO = mutableVectorH0.o();
        for (int i3 = 0; i3 < iO; i3++) {
            C0((LayoutNode) objArr[i3]);
        }
    }

    private final void D0(LayoutNode layoutNode) {
        MeasureAndLayoutDelegate.J(this.T, layoutNode, false, 2, null);
        MutableVector mutableVectorH0 = layoutNode.H0();
        Object[] objArr = mutableVectorH0.f24389a;
        int iO = mutableVectorH0.o();
        for (int i3 = 0; i3 < iO; i3++) {
            D0((LayoutNode) objArr[i3]);
        }
    }

    private final boolean E0(MotionEvent motionEvent) {
        boolean z2 = (Float.floatToRawIntBits(motionEvent.getX()) & Api.BaseClientBuilder.API_PRIORITY_OTHER) >= 2139095040 || (Float.floatToRawIntBits(motionEvent.getY()) & Api.BaseClientBuilder.API_PRIORITY_OTHER) >= 2139095040 || (Float.floatToRawIntBits(motionEvent.getRawX()) & Api.BaseClientBuilder.API_PRIORITY_OTHER) >= 2139095040 || (Float.floatToRawIntBits(motionEvent.getRawY()) & Api.BaseClientBuilder.API_PRIORITY_OTHER) >= 2139095040;
        if (!z2) {
            int pointerCount = motionEvent.getPointerCount();
            for (int i3 = 1; i3 < pointerCount; i3++) {
                z2 = (Float.floatToRawIntBits(motionEvent.getX(i3)) & Api.BaseClientBuilder.API_PRIORITY_OTHER) >= 2139095040 || (Float.floatToRawIntBits(motionEvent.getY(i3)) & Api.BaseClientBuilder.API_PRIORITY_OTHER) >= 2139095040 || (Build.VERSION.SDK_INT >= 29 && !MotionEventVerifierApi29.f28128a.a(motionEvent, i3));
                if (z2) {
                    break;
                }
            }
        }
        return z2;
    }

    private final boolean F0(MotionEvent motionEvent) {
        int actionMasked;
        return motionEvent.getButtonState() != 0 || (actionMasked = motionEvent.getActionMasked()) == 0 || actionMasked == 2 || actionMasked == 6;
    }

    private final boolean G0(MotionEvent motionEvent) {
        float x2 = motionEvent.getX();
        float y2 = motionEvent.getY();
        return 0.0f <= x2 && x2 <= ((float) getWidth()) && 0.0f <= y2 && y2 <= ((float) getHeight());
    }

    private final boolean H0(MotionEvent motionEvent) {
        MotionEvent motionEvent2;
        return (motionEvent.getPointerCount() == 1 && (motionEvent2 = this.f27727y0) != null && motionEvent2.getPointerCount() == motionEvent.getPointerCount() && motionEvent.getRawX() == motionEvent2.getRawX() && motionEvent.getRawY() == motionEvent2.getRawY()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J0() {
        if (isFocused() || (!ComposeUiFlags.f25105e && hasFocus())) {
            super.clearFocus();
        } else if (hasFocus()) {
            View viewFindFocus = findFocus();
            if (viewFindFocus != null) {
                viewFindFocus.clearFocus();
            }
            super.clearFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Rect K0() {
        if (isFocused()) {
            return getFocusOwner().r();
        }
        View viewFindFocus = findFocus();
        if (viewFindFocus != null) {
            return FocusInteropUtils_androidKt.a(viewFindFocus, this);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean L0(int i3) {
        AndroidViewsHandler androidViewsHandler;
        View viewFindNextFocusFromRect;
        if (!ComposeUiFlags.f25105e) {
            FocusDirection.Companion companion = FocusDirection.f25444b;
            if (FocusDirection.l(i3, companion.b()) || FocusDirection.l(i3, companion.c())) {
                return false;
            }
            Integer numC = FocusInteropUtils_androidKt.c(i3);
            if (numC == null) {
                throw new IllegalStateException("Invalid focus direction");
            }
            int iIntValue = numC.intValue();
            Rect rectK0 = K0();
            rectA = rectK0 != null ? RectHelper_androidKt.a(rectK0) : null;
            FocusFinder focusFinder = FocusFinder.getInstance();
            View viewFindNextFocus = rectA == null ? focusFinder.findNextFocus(this, findFocus(), iIntValue) : focusFinder.findNextFocusFromRect(this, rectA, iIntValue);
            if (viewFindNextFocus != null) {
                return FocusInteropUtils_androidKt.b(viewFindNextFocus, Integer.valueOf(iIntValue), rectA);
            }
            return false;
        }
        FocusDirection.Companion companion2 = FocusDirection.f25444b;
        if (FocusDirection.l(i3, companion2.b()) || FocusDirection.l(i3, companion2.c()) || !hasFocus() || (androidViewsHandler = this.P) == null) {
            return false;
        }
        Integer numC2 = FocusInteropUtils_androidKt.c(i3);
        if (numC2 == null) {
            throw new IllegalStateException("Invalid focus direction");
        }
        int iIntValue2 = numC2.intValue();
        View rootView = getRootView();
        Intrinsics.checkNotNull(rootView, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) rootView;
        View viewFindFocus = viewGroup.findFocus();
        if (viewFindFocus == null) {
            throw new IllegalStateException("view hasFocus but root can't find it");
        }
        FocusFinder focusFinder2 = FocusFinder.getInstance();
        if (FocusOwnerImplKt.a(i3) && androidViewsHandler.hasFocus()) {
            viewFindNextFocusFromRect = focusFinder2.findNextFocus(viewGroup, viewFindFocus, iIntValue2);
        } else {
            Rect rectK02 = K0();
            rectA = rectK02 != null ? RectHelper_androidKt.a(rectK02) : null;
            viewFindNextFocusFromRect = focusFinder2.findNextFocusFromRect(viewGroup, rectA, iIntValue2);
            if (viewFindNextFocusFromRect != null) {
                viewFindNextFocusFromRect.getLocationInWindow(this.V);
            }
            int[] iArr = this.V;
            int i4 = iArr[0];
            int i5 = iArr[1];
            getLocationInWindow(iArr);
            if (rectA != null) {
                int[] iArr2 = this.V;
                rectA.offset(iArr2[0] - i4, iArr2[1] - i5);
            }
        }
        if (viewFindNextFocusFromRect == null || viewFindNextFocusFromRect == viewFindFocus) {
            return false;
        }
        View focusedChild = androidViewsHandler.getFocusedChild();
        ViewParent parent = viewFindNextFocusFromRect.getParent();
        while (parent != null && parent != focusedChild) {
            parent = parent.getParent();
        }
        if (parent == null) {
            return false;
        }
        return FocusInteropUtils_androidKt.b(viewFindNextFocusFromRect, Integer.valueOf(iIntValue2), rectA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean M0(FocusDirection focusDirection, Rect rect) {
        Integer numC;
        if (isFocused() || hasFocus()) {
            return true;
        }
        return super.requestFocus((focusDirection == null || (numC = FocusInteropUtils_androidKt.c(focusDirection.o())) == null) ? 130 : numC.intValue(), rect != null ? RectHelper_androidKt.a(rect) : null);
    }

    private final long N0(int i3, int i4) {
        return ULong.b(ULong.b(i4) | ULong.b(ULong.b(i3) << 32));
    }

    private final void O0() {
        if (this.f27686d0) {
            return;
        }
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        if (jCurrentAnimationTimeMillis != this.f27684c0) {
            this.f27684c0 = jCurrentAnimationTimeMillis;
            Q0();
            ViewParent parent = getParent();
            View view = this;
            while (parent instanceof ViewGroup) {
                view = (View) parent;
                parent = ((ViewGroup) view).getParent();
            }
            view.getLocationOnScreen(this.V);
            int[] iArr = this.V;
            float f3 = iArr[0];
            float f4 = iArr[1];
            view.getLocationInWindow(iArr);
            this.f27687e0 = Offset.e((((long) Float.floatToRawIntBits(f3 - this.V[0])) << 32) | (((long) Float.floatToRawIntBits(f4 - r0[1])) & 4294967295L));
        }
    }

    private final void P0(MotionEvent motionEvent) {
        this.f27684c0 = AnimationUtils.currentAnimationTimeMillis();
        Q0();
        float[] fArr = this.f27680a0;
        float x2 = motionEvent.getX();
        long jF = Matrix.f(fArr, Offset.e((((long) Float.floatToRawIntBits(motionEvent.getY())) & 4294967295L) | (Float.floatToRawIntBits(x2) << 32)));
        this.f27687e0 = Offset.e((((long) Float.floatToRawIntBits(motionEvent.getRawX() - Float.intBitsToFloat((int) (jF >> 32)))) << 32) | (((long) Float.floatToRawIntBits(motionEvent.getRawY() - Float.intBitsToFloat((int) (jF & 4294967295L)))) & 4294967295L));
    }

    private final void Q0() {
        this.G0.a(this, this.f27680a0);
        InvertMatrixKt.a(this.f27680a0, this.f27682b0);
    }

    private final void U0(LayoutNode layoutNode) {
        if (isLayoutRequested() || !isAttachedToWindow()) {
            return;
        }
        if (layoutNode != null) {
            while (layoutNode != null && layoutNode.q0() == LayoutNode.UsageByParent.f27392a && p0(layoutNode)) {
                layoutNode = layoutNode.B0();
            }
            if (layoutNode == getRoot()) {
                requestLayout();
                return;
            }
        }
        if (getWidth() == 0 || getHeight() == 0) {
            requestLayout();
        } else {
            invalidate();
        }
    }

    static /* synthetic */ void V0(AndroidComposeView androidComposeView, LayoutNode layoutNode, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            layoutNode = null;
        }
        androidComposeView.U0(layoutNode);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W0(AndroidComposeView androidComposeView) {
        androidComposeView.d1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X0(AndroidComposeView androidComposeView) {
        androidComposeView.E0 = false;
        MotionEvent motionEvent = androidComposeView.f27727y0;
        Intrinsics.checkNotNull(motionEvent);
        if (motionEvent.getActionMasked() != 10) {
            throw new IllegalStateException("The ACTION_HOVER_EXIT event was not cleared.");
        }
        androidComposeView.Y0(motionEvent);
    }

    private final int Y0(MotionEvent motionEvent) {
        Object obj;
        if (this.H0) {
            this.H0 = false;
            this.f27700l.d(PointerKeyboardModifiers.b(motionEvent.getMetaState()));
        }
        PointerInputEvent pointerInputEventC = this.F.c(motionEvent, this);
        if (pointerInputEventC == null) {
            this.G.c();
            return PointerInputEventProcessorKt.a(false, false);
        }
        List listB = pointerInputEventC.b();
        int size = listB.size() - 1;
        if (size >= 0) {
            while (true) {
                int i3 = size - 1;
                obj = listB.get(size);
                if (((PointerInputEventData) obj).b()) {
                    break;
                }
                if (i3 < 0) {
                    break;
                }
                size = i3;
            }
            obj = null;
        } else {
            obj = null;
        }
        PointerInputEventData pointerInputEventData = (PointerInputEventData) obj;
        if (pointerInputEventData != null) {
            this.f27679a = pointerInputEventData.f();
        }
        int iB = this.G.b(pointerInputEventC, this, G0(motionEvent));
        int actionMasked = motionEvent.getActionMasked();
        if ((actionMasked != 0 && actionMasked != 5) || (iB & 1) != 0) {
            return iB;
        }
        this.F.e(motionEvent.getPointerId(motionEvent.getActionIndex()));
        return iB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z0(MotionEvent motionEvent, int i3, long j3, boolean z2) {
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = -1;
        if (actionMasked != 1) {
            if (actionMasked == 6) {
                actionIndex = motionEvent.getActionIndex();
            }
        } else if (i3 != 9 && i3 != 10) {
            actionIndex = 0;
        }
        int pointerCount = motionEvent.getPointerCount() - (actionIndex >= 0 ? 1 : 0);
        if (pointerCount == 0) {
            return;
        }
        MotionEvent.PointerProperties[] pointerPropertiesArr = new MotionEvent.PointerProperties[pointerCount];
        for (int i4 = 0; i4 < pointerCount; i4++) {
            pointerPropertiesArr[i4] = new MotionEvent.PointerProperties();
        }
        MotionEvent.PointerCoords[] pointerCoordsArr = new MotionEvent.PointerCoords[pointerCount];
        for (int i5 = 0; i5 < pointerCount; i5++) {
            pointerCoordsArr[i5] = new MotionEvent.PointerCoords();
        }
        int i6 = 0;
        while (i6 < pointerCount) {
            int i7 = ((actionIndex < 0 || i6 < actionIndex) ? 0 : 1) + i6;
            motionEvent.getPointerProperties(i7, pointerPropertiesArr[i6]);
            MotionEvent.PointerCoords pointerCoords = pointerCoordsArr[i6];
            motionEvent.getPointerCoords(i7, pointerCoords);
            float f3 = pointerCoords.x;
            long jH = H(Offset.e((((long) Float.floatToRawIntBits(pointerCoords.y)) & 4294967295L) | (((long) Float.floatToRawIntBits(f3)) << 32)));
            pointerCoords.x = Float.intBitsToFloat((int) (jH >> 32));
            pointerCoords.y = Float.intBitsToFloat((int) (jH & 4294967295L));
            i6++;
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent.getDownTime() == motionEvent.getEventTime() ? j3 : motionEvent.getDownTime(), j3, i3, pointerCount, pointerPropertiesArr, pointerCoordsArr, motionEvent.getMetaState(), z2 ? 0 : motionEvent.getButtonState(), motionEvent.getXPrecision(), motionEvent.getYPrecision(), motionEvent.getDeviceId(), motionEvent.getEdgeFlags(), motionEvent.getSource(), motionEvent.getFlags());
        PointerInputEvent pointerInputEventC = this.F.c(motionEventObtain, this);
        Intrinsics.checkNotNull(pointerInputEventC);
        this.G.b(pointerInputEventC, this, true);
        motionEventObtain.recycle();
    }

    static /* synthetic */ void a1(AndroidComposeView androidComposeView, MotionEvent motionEvent, int i3, long j3, boolean z2, int i4, Object obj) {
        if ((i4 & 8) != 0) {
            z2 = true;
        }
        androidComposeView.Z0(motionEvent, i3, j3, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean b1(DragAndDropTransferData dragAndDropTransferData, long j3, Function1 function1) {
        Resources resources = getContext().getResources();
        return AndroidComposeViewStartDragAndDropN.f27825a.a(this, dragAndDropTransferData, new ComposeDragShadowBuilder(DensityKt.a(resources.getDisplayMetrics().density, resources.getConfiguration().fontScale), j3, function1, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c1(AndroidComposeView androidComposeView, boolean z2) {
        androidComposeView.f27721v0.b(z2 ? InputMode.f26627b.b() : InputMode.f26627b.a());
    }

    private final void d1() {
        getLocationOnScreen(this.V);
        long j3 = this.U;
        int iK = IntOffset.k(j3);
        int iL = IntOffset.l(j3);
        int[] iArr = this.V;
        boolean z2 = false;
        int i3 = iArr[0];
        if (iK != i3 || iL != iArr[1] || this.f27684c0 < 0) {
            this.U = IntOffset.f((((long) i3) << 32) | (((long) iArr[1]) & 4294967295L));
            if (iK != Integer.MAX_VALUE && iL != Integer.MAX_VALUE) {
                getRoot().f0().w().s2();
                z2 = true;
            }
        }
        O0();
        getRectManager().t(this.U, IntOffsetKt.d(this.f27687e0), this.f27680a0);
        this.T.c(z2);
        if (ComposeUiFlags.f25102b) {
            getRectManager().d();
        }
    }

    private final void e1() {
        MutableState mutableState = this.f27700l.f28124b;
        if (mutableState != null) {
            mutableState.setValue(IntSize.b(AndroidWindowInfo_androidKt.d(this)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ViewTreeOwners get_viewTreeOwners() {
        return (ViewTreeOwners) this.f27691g0.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l0(int i3, AccessibilityNodeInfo accessibilityNodeInfo, String str) {
        int iE;
        if (Intrinsics.areEqual(str, this.f27722w.c0())) {
            int iE2 = this.f27722w.e0().e(i3, -1);
            if (iE2 != -1) {
                accessibilityNodeInfo.getExtras().putInt(str, iE2);
                return;
            }
            return;
        }
        if (!Intrinsics.areEqual(str, this.f27722w.b0()) || (iE = this.f27722w.d0().e(i3, -1)) == -1) {
            return;
        }
        accessibilityNodeInfo.getExtras().putInt(str, iE);
    }

    private final boolean m0() {
        return true;
    }

    private final boolean p0(LayoutNode layoutNode) {
        if (this.S) {
            return true;
        }
        LayoutNode layoutNodeB0 = layoutNode.B0();
        return (layoutNodeB0 == null || layoutNodeB0.Y()) ? false : true;
    }

    private final void q0(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = viewGroup.getChildAt(i3);
            if (childAt instanceof AndroidComposeView) {
                ((AndroidComposeView) childAt).E();
            } else if (childAt instanceof ViewGroup) {
                q0((ViewGroup) childAt);
            }
        }
    }

    private final long r0(int i3) {
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        if (mode == Integer.MIN_VALUE) {
            return N0(0, size);
        }
        if (mode == 0) {
            return N0(0, Api.BaseClientBuilder.API_PRIORITY_OTHER);
        }
        if (mode == 1073741824) {
            return N0(size, size);
        }
        throw new IllegalStateException();
    }

    private final void s0() {
        if (this.E) {
            getViewTreeObserver().dispatchOnGlobalLayout();
            this.E = false;
        }
    }

    private void setDensity(Density density) {
        this.f27685d.setValue(density);
    }

    private void setFontFamilyResolver(FontFamily.Resolver resolver) {
        this.f27713r0.setValue(resolver);
    }

    private void setLayoutDirection(LayoutDirection layoutDirection) {
        this.f27717t0.setValue(layoutDirection);
    }

    private final void set_viewTreeOwners(ViewTreeOwners viewTreeOwners) {
        this.f27691g0.setValue(viewTreeOwners);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View u0(int i3) {
        FocusFinder focusFinder = FocusFinder.getInstance();
        View viewFindNextFocus = this;
        while (viewFindNextFocus != null) {
            View rootView = getRootView();
            Intrinsics.checkNotNull(rootView, "null cannot be cast to non-null type android.view.ViewGroup");
            viewFindNextFocus = focusFinder.findNextFocus((ViewGroup) rootView, viewFindNextFocus, i3);
            if (viewFindNextFocus != null && !AndroidComposeView_androidKt.e(this, viewFindNextFocus)) {
                return viewFindNextFocus;
            }
        }
        return null;
    }

    private final View v0(int i3, View view) throws NoSuchMethodException {
        if (Build.VERSION.SDK_INT < 29) {
            Method declaredMethod = View.class.getDeclaredMethod("getAccessibilityViewId", null);
            declaredMethod.setAccessible(true);
            if (Intrinsics.areEqual(declaredMethod.invoke(view, null), Integer.valueOf(i3))) {
                return view;
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i4 = 0; i4 < childCount; i4++) {
                    View viewV0 = v0(i3, viewGroup.getChildAt(i4));
                    if (viewV0 != null) {
                        return viewV0;
                    }
                }
            }
        }
        return null;
    }

    private final int x0(Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 31) {
            return configuration.fontWeightAdjustment;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y0(AndroidComposeView androidComposeView) {
        androidComposeView.d1();
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final int z0(android.view.MotionEvent r17) {
        /*
            Method dump skipped, instruction units count: 302
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeView.z0(android.view.MotionEvent):int");
    }

    @Override // androidx.compose.ui.node.Owner
    public void A() {
        if (Build.VERSION.SDK_INT >= 35) {
            if (this.K0 == 0) {
                AndroidComposeViewSensitiveContent35.f27824a.a(getView(), true);
            }
            this.K0++;
        }
    }

    @Override // androidx.compose.ui.node.Owner
    public void B(LayoutNode layoutNode) {
        AndroidAutofillManager androidAutofillManager;
        getLayoutNodes().o(layoutNode.v());
        this.T.x(layoutNode);
        T0();
        if (ComposeUiFlags.f25102b) {
            getRectManager().q(layoutNode);
        }
        if (m0() && ComposeUiFlags.f25104d && (androidAutofillManager = this.J) != null) {
            androidAutofillManager.f(layoutNode);
        }
    }

    @Override // androidx.compose.ui.platform.ViewRootForTest
    public void C() {
        C0(getRoot());
    }

    @Override // androidx.compose.ui.node.Owner
    public void D(Function0 function0) {
        if (this.B0.a(function0)) {
            return;
        }
        this.B0.n(function0);
    }

    @Override // androidx.compose.ui.node.Owner
    public void E() {
        AndroidAutofillManager androidAutofillManager;
        if (this.K) {
            getSnapshotObserver().b();
            this.K = false;
        }
        AndroidViewsHandler androidViewsHandler = this.P;
        if (androidViewsHandler != null) {
            q0(androidViewsHandler);
        }
        if (m0() && ComposeUiFlags.f25104d && (androidAutofillManager = this.J) != null) {
            androidAutofillManager.g();
        }
        while (this.B0.h() && this.B0.d(0) != null) {
            int iE = this.B0.e();
            for (int i3 = 0; i3 < iE; i3++) {
                Function0 function0 = (Function0) this.B0.d(i3);
                this.B0.E(i3, null);
                if (function0 != null) {
                    function0.invoke();
                }
            }
            this.B0.B(0, iE);
        }
    }

    @Override // androidx.compose.ui.node.Owner
    public void F() {
        this.f27722w.q0();
        this.f27724x.w();
    }

    @Override // androidx.compose.ui.node.Owner
    public void G(LayoutNode layoutNode) {
        AndroidAutofillManager androidAutofillManager;
        if (ComposeUiFlags.f25102b) {
            getRectManager().q(layoutNode);
        }
        if (m0() && ComposeUiFlags.f25104d && (androidAutofillManager = this.J) != null) {
            androidAutofillManager.h(layoutNode);
        }
    }

    @Override // androidx.compose.ui.input.pointer.PositionCalculator
    public long H(long j3) {
        O0();
        long jF = Matrix.f(this.f27680a0, j3);
        float fIntBitsToFloat = Float.intBitsToFloat((int) (jF >> 32)) + Float.intBitsToFloat((int) (this.f27687e0 >> 32));
        return Offset.e((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (jF & 4294967295L)) + Float.intBitsToFloat((int) (this.f27687e0 & 4294967295L)))) & 4294967295L) | (Float.floatToRawIntBits(fIntBitsToFloat) << 32));
    }

    @Override // androidx.compose.ui.node.Owner
    public void I() {
        if (Build.VERSION.SDK_INT >= 35) {
            if (this.K0 == 1) {
                AndroidComposeViewSensitiveContent35.f27824a.a(getView(), false);
            }
            this.K0--;
        }
    }

    public final void I0(OwnedLayer ownedLayer, boolean z2) {
        if (!z2) {
            if (this.D) {
                return;
            }
            this.B.remove(ownedLayer);
            List list = this.C;
            if (list != null) {
                list.remove(ownedLayer);
                return;
            }
            return;
        }
        if (!this.D) {
            this.B.add(ownedLayer);
            return;
        }
        List arrayList = this.C;
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.C = arrayList;
        }
        arrayList.add(ownedLayer);
    }

    public final boolean R0(OwnedLayer ownedLayer) {
        if (this.Q != null) {
            ViewLayer.f28240q.b();
        }
        this.A0.c(ownedLayer);
        this.B.remove(ownedLayer);
        return true;
    }

    public final void S0(final AndroidViewHolder androidViewHolder) {
        D(new Function0<Unit>() { // from class: androidx.compose.ui.platform.AndroidComposeView$removeAndroidView$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m247invoke();
                return Unit.f139807a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m247invoke() {
                this.f27751a.getAndroidViewsHandler$ui_release().removeViewInLayout(androidViewHolder);
                this.f27751a.getAndroidViewsHandler$ui_release().getLayoutNodeToHolder().remove(this.f27751a.getAndroidViewsHandler$ui_release().getHolderToLayoutNode().remove(androidViewHolder));
                androidViewHolder.setImportantForAccessibility(0);
            }
        });
    }

    public final void T0() {
        this.K = true;
    }

    @Override // androidx.compose.ui.node.Owner
    public void a(boolean z2) {
        Function0 function0;
        if (this.T.n() || this.T.o()) {
            Trace.beginSection("AndroidOwner:measureAndLayout");
            if (z2) {
                try {
                    function0 = this.F0;
                } catch (Throwable th) {
                    Trace.endSection();
                    throw th;
                }
            } else {
                function0 = null;
            }
            if (this.T.t(function0)) {
                requestLayout();
            }
            MeasureAndLayoutDelegate.d(this.T, false, 1, null);
            s0();
            Unit unit = Unit.f139807a;
            Trace.endSection();
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        addView(view, -1);
    }

    @Override // android.view.View
    public void autofill(SparseArray sparseArray) {
        AndroidAutofillManager androidAutofillManager;
        if (m0()) {
            if (ComposeUiFlags.f25104d && (androidAutofillManager = this.J) != null) {
                androidAutofillManager.k(sparseArray);
            }
            AndroidAutofill androidAutofill = this.I;
            if (androidAutofill != null) {
                AndroidAutofill_androidKt.a(androidAutofill, sparseArray);
            }
        }
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i3) {
        return this.f27722w.P(false, i3, this.f27679a);
    }

    @Override // android.view.View
    public boolean canScrollVertically(int i3) {
        return this.f27722w.P(true, i3, this.f27679a);
    }

    @Override // androidx.compose.ui.node.Owner
    public void d(LayoutNode layoutNode, boolean z2, boolean z3) {
        if (z2) {
            if (this.T.E(layoutNode, z3)) {
                V0(this, null, 1, null);
            }
        } else if (this.T.H(layoutNode, z3)) {
            V0(this, null, 1, null);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (!isAttachedToWindow()) {
            C0(getRoot());
        }
        Owner.c(this, false, 1, null);
        Snapshot.f24914e.f();
        this.D = true;
        CanvasHolder canvasHolder = this.f27708p;
        Canvas canvasB = canvasHolder.a().B();
        canvasHolder.a().C(canvas);
        getRoot().H(canvasHolder.a(), null);
        canvasHolder.a().C(canvasB);
        if (!this.B.isEmpty()) {
            int size = this.B.size();
            for (int i3 = 0; i3 < size; i3++) {
                ((OwnedLayer) this.B.get(i3)).k();
            }
        }
        if (ViewLayer.f28240q.b()) {
            int iSave = canvas.save();
            canvas.clipRect(0.0f, 0.0f, 0.0f, 0.0f);
            super.dispatchDraw(canvas);
            canvas.restoreToCount(iSave);
        }
        this.B.clear();
        this.D = false;
        List list = this.C;
        if (list != null) {
            Intrinsics.checkNotNull(list);
            this.B.addAll(list);
            list.clear();
        }
        if (ComposeUiFlags.f25102b) {
            getRectManager().d();
        }
    }

    @Override // android.view.View
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        if (this.E0) {
            removeCallbacks(this.D0);
            if (motionEvent.getActionMasked() == 8) {
                this.E0 = false;
            } else {
                this.D0.run();
            }
        }
        return motionEvent.getActionMasked() == 8 ? (E0(motionEvent) || !isAttachedToWindow()) ? super.dispatchGenericMotionEvent(motionEvent) : motionEvent.isFromSource(4194304) ? A0(motionEvent) : (z0(motionEvent) & 1) != 0 : super.dispatchGenericMotionEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        if (this.E0) {
            removeCallbacks(this.D0);
            this.D0.run();
        }
        if (!E0(motionEvent) && isAttachedToWindow()) {
            this.f27722w.W(motionEvent);
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 7) {
                if (actionMasked == 10 && G0(motionEvent)) {
                    if (motionEvent.getToolType(0) == 3 && motionEvent.getButtonState() != 0) {
                        return false;
                    }
                    MotionEvent motionEvent2 = this.f27727y0;
                    if (motionEvent2 != null) {
                        motionEvent2.recycle();
                    }
                    this.f27727y0 = MotionEvent.obtainNoHistory(motionEvent);
                    this.E0 = true;
                    postDelayed(this.D0, 8L);
                    return false;
                }
            } else if (!H0(motionEvent)) {
                return false;
            }
            if ((z0(motionEvent) & 1) != 0) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(final android.view.KeyEvent keyEvent) {
        if (!isFocused()) {
            return getFocusOwner().k(KeyEvent.b(keyEvent), new Function0<Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView.dispatchKeyEvent.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Boolean invoke() {
                    return Boolean.valueOf(AndroidComposeView.super.dispatchKeyEvent(keyEvent));
                }
            });
        }
        this.f27700l.d(PointerKeyboardModifiers.b(keyEvent.getMetaState()));
        return FocusOwner.f(getFocusOwner(), KeyEvent.b(keyEvent), null, 2, null) || super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEventPreIme(android.view.KeyEvent keyEvent) {
        return (isFocused() && getFocusOwner().g(KeyEvent.b(keyEvent))) || super.dispatchKeyEventPreIme(keyEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchProvideStructure(ViewStructure viewStructure) {
        super.dispatchProvideStructure(viewStructure);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.E0) {
            removeCallbacks(this.D0);
            MotionEvent motionEvent2 = this.f27727y0;
            Intrinsics.checkNotNull(motionEvent2);
            if (motionEvent.getActionMasked() != 0 || B0(motionEvent, motionEvent2)) {
                this.D0.run();
            } else {
                this.E0 = false;
            }
        }
        if (E0(motionEvent) || !isAttachedToWindow() || (motionEvent.getActionMasked() == 2 && !H0(motionEvent))) {
            return false;
        }
        int iZ0 = z0(motionEvent);
        if ((iZ0 & 2) != 0) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        return (iZ0 & 1) != 0;
    }

    @Override // androidx.compose.ui.node.Owner
    public long f(long j3) {
        O0();
        return Matrix.f(this.f27680a0, j3);
    }

    public final View findViewByAccessibilityIdTraversal(int i3) throws IllegalAccessException, InvocationTargetException {
        try {
            if (Build.VERSION.SDK_INT < 29) {
                return v0(i3, this);
            }
            Method declaredMethod = View.class.getDeclaredMethod("findViewByAccessibilityIdTraversal", Integer.TYPE);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(this, Integer.valueOf(i3));
            if (objInvoke instanceof View) {
                return (View) objInvoke;
            }
            return null;
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public View focusSearch(View view, int i3) {
        Rect rectA;
        if (view == null || this.T.m()) {
            return super.focusSearch(view, i3);
        }
        View viewFindNextFocus = FocusFinder.getInstance().findNextFocus(this, view, i3);
        if (view != this || (rectA = getFocusOwner().r()) == null) {
            rectA = FocusInteropUtils_androidKt.a(view, this);
        }
        FocusDirection focusDirectionD = FocusInteropUtils_androidKt.d(i3);
        int iO = focusDirectionD != null ? focusDirectionD.o() : FocusDirection.f25444b.a();
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        if (getFocusOwner().w(iO, rectA, new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView$focusSearch$searchResult$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(FocusTargetNode focusTargetNode) {
                objectRef.f140144a = focusTargetNode;
                return Boolean.TRUE;
            }
        }) != null) {
            if (objectRef.f140144a != null) {
                if (viewFindNextFocus != null) {
                    if (FocusOwnerImplKt.a(iO)) {
                        return super.focusSearch(view, i3);
                    }
                    Object obj = objectRef.f140144a;
                    Intrinsics.checkNotNull(obj);
                    if (TwoDimensionalFocusSearchKt.m(FocusTraversalKt.d((FocusTargetNode) obj), FocusInteropUtils_androidKt.a(viewFindNextFocus, this), rectA, iO)) {
                    }
                }
                return this;
            }
            if (viewFindNextFocus == null) {
            }
            return viewFindNextFocus;
        }
        return view;
    }

    @Override // androidx.compose.ui.node.Owner
    public void g(LayoutNode layoutNode) {
        this.T.G(layoutNode);
        V0(this, null, 1, null);
    }

    public final AndroidViewsHandler getAndroidViewsHandler$ui_release() {
        if (this.P == null) {
            AndroidViewsHandler androidViewsHandler = new AndroidViewsHandler(getContext());
            this.P = androidViewsHandler;
            addView(androidViewsHandler);
            requestLayout();
        }
        AndroidViewsHandler androidViewsHandler2 = this.P;
        Intrinsics.checkNotNull(androidViewsHandler2);
        return androidViewsHandler2;
    }

    @Override // androidx.compose.ui.node.Owner
    public Autofill getAutofill() {
        return this.I;
    }

    @Override // androidx.compose.ui.node.Owner
    public androidx.compose.ui.autofill.AutofillManager getAutofillManager() {
        return this.J;
    }

    @Override // androidx.compose.ui.node.Owner
    public AutofillTree getAutofillTree() {
        return this.A;
    }

    public final Function1<Configuration, Unit> getConfigurationChangeObserver() {
        return this.H;
    }

    public final AndroidContentCaptureManager getContentCaptureManager$ui_release() {
        return this.f27724x;
    }

    @Override // androidx.compose.ui.node.Owner
    public CoroutineContext getCoroutineContext() {
        return this.f27696j;
    }

    @Override // androidx.compose.ui.node.Owner
    public Density getDensity() {
        return (Density) this.f27685d.getValue();
    }

    @Override // androidx.compose.ui.node.Owner
    public FocusOwner getFocusOwner() {
        return this.f27694i;
    }

    @Override // android.view.View
    public void getFocusedRect(android.graphics.Rect rect) {
        Rect rectK0 = K0();
        if (rectK0 != null) {
            rect.left = Math.round(rectK0.o());
            rect.top = Math.round(rectK0.r());
            rect.right = Math.round(rectK0.p());
            rect.bottom = Math.round(rectK0.i());
            return;
        }
        if (Intrinsics.areEqual(getFocusOwner().w(FocusDirection.f25444b.a(), null, new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView.getFocusedRect.1
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(FocusTargetNode focusTargetNode) {
                return Boolean.TRUE;
            }
        }), Boolean.TRUE)) {
            super.getFocusedRect(rect);
        } else {
            rect.set(Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
        }
    }

    @Override // androidx.compose.ui.node.Owner
    public FontFamily.Resolver getFontFamilyResolver() {
        return (FontFamily.Resolver) this.f27713r0.getValue();
    }

    @Override // androidx.compose.ui.node.Owner
    public Font.ResourceLoader getFontLoader() {
        return this.f27711q0;
    }

    @Override // androidx.compose.ui.node.Owner
    public GraphicsContext getGraphicsContext() {
        return this.f27728z;
    }

    @Override // androidx.compose.ui.node.Owner
    public HapticFeedback getHapticFeedBack() {
        return this.f27719u0;
    }

    public boolean getHasPendingMeasureOrLayout() {
        return this.T.n();
    }

    @Override // android.view.View
    public int getImportantForAutofill() {
        return 1;
    }

    @Override // androidx.compose.ui.node.Owner
    public InputModeManager getInputModeManager() {
        return this.f27721v0;
    }

    public final long getLastMatrixRecalculationAnimationTime$ui_release() {
        return this.f27684c0;
    }

    @Override // android.view.View, android.view.ViewParent, androidx.compose.ui.node.Owner
    public LayoutDirection getLayoutDirection() {
        return (LayoutDirection) this.f27717t0.getValue();
    }

    public long getMeasureIteration() {
        return this.T.s();
    }

    @Override // androidx.compose.ui.node.Owner
    public ModifierLocalManager getModifierLocalManager() {
        return this.f27723w0;
    }

    @Override // androidx.compose.ui.node.Owner
    public Placeable.PlacementScope getPlacementScope() {
        return PlaceableKt.b(this);
    }

    @Override // androidx.compose.ui.node.Owner
    public PointerIconService getPointerIconService() {
        return this.J0;
    }

    @Override // androidx.compose.ui.node.Owner
    public RectManager getRectManager() {
        return this.f27716t;
    }

    @Override // androidx.compose.ui.node.Owner
    public LayoutNode getRoot() {
        return this.f27712r;
    }

    public RootForTest getRootForTest() {
        return this.f27718u;
    }

    public final boolean getScrollCaptureInProgress$ui_release() {
        ScrollCapture scrollCapture;
        if (Build.VERSION.SDK_INT < 31 || (scrollCapture = this.I0) == null) {
            return false;
        }
        return scrollCapture.c();
    }

    @Override // androidx.compose.ui.node.Owner
    public SemanticsOwner getSemanticsOwner() {
        return this.f27720v;
    }

    @Override // androidx.compose.ui.node.Owner
    public LayoutNodeDrawScope getSharedDrawScope() {
        return this.f27683c;
    }

    @Override // androidx.compose.ui.node.Owner
    public boolean getShowLayoutBounds() {
        return this.O;
    }

    @Override // androidx.compose.ui.node.Owner
    public OwnerSnapshotObserver getSnapshotObserver() {
        return this.N;
    }

    @Override // androidx.compose.ui.node.Owner
    public SoftwareKeyboardController getSoftwareKeyboardController() {
        return this.f27709p0;
    }

    @Override // androidx.compose.ui.node.Owner
    public TextInputService getTextInputService() {
        return this.f27705n0;
    }

    @Override // androidx.compose.ui.node.Owner
    public TextToolbar getTextToolbar() {
        return this.f27725x0;
    }

    @Override // androidx.compose.ui.node.Owner
    public ViewConfiguration getViewConfiguration() {
        return this.f27710q;
    }

    public final ViewTreeOwners getViewTreeOwners() {
        return (ViewTreeOwners) this.f27693h0.getValue();
    }

    @Override // androidx.compose.ui.node.Owner
    public WindowInfo getWindowInfo() {
        return this.f27700l;
    }

    public final AndroidAutofillManager get_autofillManager$ui_release() {
        return this.J;
    }

    @Override // androidx.compose.ui.node.Owner
    public void h(LayoutNode layoutNode, int i3) {
        AndroidAutofillManager androidAutofillManager;
        if (m0() && ComposeUiFlags.f25104d && (androidAutofillManager = this.J) != null) {
            androidAutofillManager.j(layoutNode, i3);
        }
        getRectManager().l(layoutNode, layoutNode.f0().w().C1(), true);
    }

    @Override // androidx.compose.ui.node.Owner
    public void i(LayoutNode layoutNode, int i3) {
        getLayoutNodes().o(i3);
        getLayoutNodes().r(layoutNode.v(), layoutNode);
    }

    @Override // androidx.compose.ui.node.Owner
    public void k(LayoutNode layoutNode) {
        this.f27722w.p0(layoutNode);
        this.f27724x.v();
    }

    public final void k0(AndroidViewHolder androidViewHolder, final LayoutNode layoutNode) {
        getAndroidViewsHandler$ui_release().getHolderToLayoutNode().put(androidViewHolder, layoutNode);
        getAndroidViewsHandler$ui_release().addView(androidViewHolder);
        getAndroidViewsHandler$ui_release().getLayoutNodeToHolder().put(layoutNode, androidViewHolder);
        androidViewHolder.setImportantForAccessibility(1);
        ViewCompat.m0(androidViewHolder, new AccessibilityDelegateCompat() { // from class: androidx.compose.ui.platform.AndroidComposeView$addAndroidView$1
            /* JADX WARN: Removed duplicated region for block: B:19:0x0054  */
            @Override // androidx.core.view.AccessibilityDelegateCompat
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void g(android.view.View r5, androidx.core.view.accessibility.AccessibilityNodeInfoCompat r6) {
                /*
                    Method dump skipped, instruction units count: 216
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeView$addAndroidView$1.g(android.view.View, androidx.core.view.accessibility.AccessibilityNodeInfoCompat):void");
            }
        });
    }

    @Override // androidx.compose.ui.node.Owner
    public void l(View view) {
        this.E = true;
    }

    @Override // androidx.compose.ui.node.Owner
    public void m(LayoutNode layoutNode, boolean z2) {
        this.T.i(layoutNode, z2);
    }

    public final Object n0(Continuation continuation) {
        Object objO = this.f27722w.O(continuation);
        return objO == IntrinsicsKt.f() ? objO : Unit.f139807a;
    }

    public final Object o0(Continuation continuation) {
        Object objE = this.f27724x.e(continuation);
        return objE == IntrinsicsKt.f() ? objE : Unit.f139807a;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        LifecycleOwner lifecycleOwnerA;
        Lifecycle lifecycle;
        LifecycleOwner lifecycleOwnerA2;
        AndroidAutofill androidAutofill;
        super.onAttachedToWindow();
        this.f27700l.f(hasWindowFocus());
        this.f27700l.e(new Function0<IntSize>() { // from class: androidx.compose.ui.platform.AndroidComposeView.onAttachedToWindow.1
            {
                super(0);
            }

            public final long c() {
                return AndroidWindowInfo_androidKt.d(AndroidComposeView.this);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                return IntSize.b(c());
            }
        });
        e1();
        D0(getRoot());
        C0(getRoot());
        getSnapshotObserver().k();
        if (m0() && (androidAutofill = this.I) != null) {
            AutofillCallback.f25216a.a(androidAutofill);
        }
        LifecycleOwner lifecycleOwnerA3 = ViewTreeLifecycleOwner.a(this);
        SavedStateRegistryOwner savedStateRegistryOwnerA = ViewTreeSavedStateRegistryOwner.a(this);
        ViewTreeOwners viewTreeOwners = getViewTreeOwners();
        Lifecycle lifecycle2 = null;
        if (viewTreeOwners == null || (lifecycleOwnerA3 != null && savedStateRegistryOwnerA != null && (lifecycleOwnerA3 != viewTreeOwners.a() || savedStateRegistryOwnerA != viewTreeOwners.a()))) {
            if (lifecycleOwnerA3 == null) {
                throw new IllegalStateException("Composed into the View which doesn't propagate ViewTreeLifecycleOwner!");
            }
            if (savedStateRegistryOwnerA == null) {
                throw new IllegalStateException("Composed into the View which doesn't propagateViewTreeSavedStateRegistryOwner!");
            }
            if (viewTreeOwners != null && (lifecycleOwnerA = viewTreeOwners.a()) != null && (lifecycle = lifecycleOwnerA.getLifecycle()) != null) {
                lifecycle.removeObserver(this);
            }
            lifecycleOwnerA3.getLifecycle().addObserver(this);
            ViewTreeOwners viewTreeOwners2 = new ViewTreeOwners(lifecycleOwnerA3, savedStateRegistryOwnerA);
            set_viewTreeOwners(viewTreeOwners2);
            Function1 function1 = this.f27695i0;
            if (function1 != null) {
                function1.invoke(viewTreeOwners2);
            }
            this.f27695i0 = null;
        }
        this.f27721v0.b(isInTouchMode() ? InputMode.f26627b.b() : InputMode.f26627b.a());
        ViewTreeOwners viewTreeOwners3 = getViewTreeOwners();
        if (viewTreeOwners3 != null && (lifecycleOwnerA2 = viewTreeOwners3.a()) != null) {
            lifecycle2 = lifecycleOwnerA2.getLifecycle();
        }
        if (lifecycle2 == null) {
            InlineClassHelperKt.d("No lifecycle owner exists");
            throw new KotlinNothingValueException();
        }
        lifecycle2.addObserver(this);
        lifecycle2.addObserver(this.f27724x);
        getViewTreeObserver().addOnGlobalLayoutListener(this.f27697j0);
        getViewTreeObserver().addOnScrollChangedListener(this.f27699k0);
        getViewTreeObserver().addOnTouchModeChangeListener(this.f27701l0);
        if (Build.VERSION.SDK_INT >= 31) {
            AndroidComposeViewTranslationCallbackS.f27827a.b(this);
        }
        AndroidAutofillManager androidAutofillManager = this.J;
        if (androidAutofillManager != null) {
            getFocusOwner().b().n(androidAutofillManager);
            getSemanticsOwner().b().n(androidAutofillManager);
        }
    }

    @Override // android.view.View
    public boolean onCheckIsTextEditor() {
        AndroidPlatformTextInputSession androidPlatformTextInputSession = (AndroidPlatformTextInputSession) SessionMutex.d(this.f27707o0);
        return androidPlatformTextInputSession == null ? this.f27703m0.r() : androidPlatformTextInputSession.f();
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        setDensity(AndroidDensity_androidKt.a(getContext()));
        e1();
        if (x0(configuration) != this.f27715s0) {
            this.f27715s0 = x0(configuration);
            setFontFamilyResolver(FontFamilyResolver_androidKt.a(getContext()));
        }
        this.H.invoke(configuration);
    }

    @Override // android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        AndroidPlatformTextInputSession androidPlatformTextInputSession = (AndroidPlatformTextInputSession) SessionMutex.d(this.f27707o0);
        return androidPlatformTextInputSession == null ? this.f27703m0.o(editorInfo) : androidPlatformTextInputSession.e(editorInfo);
    }

    @Override // android.view.View
    public void onCreateVirtualViewTranslationRequests(long[] jArr, int[] iArr, Consumer consumer) {
        this.f27724x.t(jArr, iArr, consumer);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        AndroidAutofill androidAutofill;
        LifecycleOwner lifecycleOwnerA;
        super.onDetachedFromWindow();
        getSnapshotObserver().l();
        Lifecycle lifecycle = null;
        this.f27700l.e(null);
        ViewTreeOwners viewTreeOwners = getViewTreeOwners();
        if (viewTreeOwners != null && (lifecycleOwnerA = viewTreeOwners.a()) != null) {
            lifecycle = lifecycleOwnerA.getLifecycle();
        }
        if (lifecycle == null) {
            InlineClassHelperKt.d("No lifecycle owner exists");
            throw new KotlinNothingValueException();
        }
        lifecycle.removeObserver(this.f27724x);
        lifecycle.removeObserver(this);
        if (m0() && (androidAutofill = this.I) != null) {
            AutofillCallback.f25216a.b(androidAutofill);
        }
        getViewTreeObserver().removeOnGlobalLayoutListener(this.f27697j0);
        getViewTreeObserver().removeOnScrollChangedListener(this.f27699k0);
        getViewTreeObserver().removeOnTouchModeChangeListener(this.f27701l0);
        if (Build.VERSION.SDK_INT >= 31) {
            AndroidComposeViewTranslationCallbackS.f27827a.a(this);
        }
        AndroidAutofillManager androidAutofillManager = this.J;
        if (androidAutofillManager != null) {
            getSemanticsOwner().b().y(androidAutofillManager);
            getFocusOwner().b().y(androidAutofillManager);
        }
    }

    @Override // android.view.View
    protected void onFocusChanged(boolean z2, int i3, android.graphics.Rect rect) {
        super.onFocusChanged(z2, i3, rect);
        if (z2 || hasFocus()) {
            return;
        }
        getFocusOwner().t();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i3, int i4, int i5, int i6) throws Throwable {
        this.f27684c0 = 0L;
        this.T.t(this.F0);
        this.R = null;
        d1();
        if (this.P != null) {
            getAndroidViewsHandler$ui_release().layout(0, 0, i5 - i3, i6 - i4);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i4) {
        Trace.beginSection("AndroidOwner:onMeasure");
        try {
            if (!isAttachedToWindow()) {
                D0(getRoot());
            }
            long jR0 = r0(i3);
            int iB = (int) ULong.b(jR0 >>> 32);
            int iB2 = (int) ULong.b(jR0 & 4294967295L);
            long jR02 = r0(i4);
            long jA = Constraints.f29963b.a(iB, iB2, (int) ULong.b(jR02 >>> 32), (int) ULong.b(4294967295L & jR02));
            Constraints constraints = this.R;
            boolean zF = false;
            if (constraints == null) {
                this.R = Constraints.a(jA);
                this.S = false;
            } else {
                if (constraints != null) {
                    zF = Constraints.f(constraints.r(), jA);
                }
                if (!zF) {
                    this.S = true;
                }
            }
            this.T.K(jA);
            this.T.v();
            setMeasuredDimension(getRoot().getWidth(), getRoot().getHeight());
            if (this.P != null) {
                getAndroidViewsHandler$ui_release().measure(View.MeasureSpec.makeMeasureSpec(getRoot().getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getRoot().getHeight(), 1073741824));
            }
            Unit unit = Unit.f139807a;
            Trace.endSection();
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    @Override // android.view.View
    public void onProvideAutofillVirtualStructure(ViewStructure viewStructure, int i3) {
        AndroidAutofillManager androidAutofillManager;
        if (!m0() || viewStructure == null) {
            return;
        }
        if (ComposeUiFlags.f25104d && (androidAutofillManager = this.J) != null) {
            androidAutofillManager.l(viewStructure);
        }
        AndroidAutofill androidAutofill = this.I;
        if (androidAutofill != null) {
            AndroidAutofill_androidKt.b(androidAutofill, viewStructure);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public android.view.PointerIcon onResolvePointerIcon(MotionEvent motionEvent, int i3) {
        PointerIcon pointerIconB;
        int toolType = motionEvent.getToolType(i3);
        return (motionEvent.isFromSource(8194) || !motionEvent.isFromSource(16386) || !(toolType == 2 || toolType == 4) || (pointerIconB = getPointerIconService().b()) == null) ? super.onResolvePointerIcon(motionEvent, i3) : AndroidComposeViewVerificationHelperMethodsN.f27828a.b(getContext(), pointerIconB);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onResume(LifecycleOwner lifecycleOwner) {
        setShowLayoutBounds(L0.b());
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i3) {
        if (this.f27681b) {
            LayoutDirection layoutDirectionE = FocusInteropUtils_androidKt.e(i3);
            if (layoutDirectionE == null) {
                layoutDirectionE = LayoutDirection.f30001a;
            }
            setLayoutDirection(layoutDirectionE);
        }
    }

    @Override // android.view.View
    public void onScrollCaptureSearch(android.graphics.Rect rect, Point point, Consumer consumer) {
        ScrollCapture scrollCapture;
        if (Build.VERSION.SDK_INT < 31 || (scrollCapture = this.I0) == null) {
            return;
        }
        scrollCapture.d(this, getSemanticsOwner(), getCoroutineContext(), consumer);
    }

    @Override // android.view.View
    public void onVirtualViewTranslationResponses(LongSparseArray longSparseArray) {
        AndroidContentCaptureManager androidContentCaptureManager = this.f27724x;
        androidContentCaptureManager.y(androidContentCaptureManager, longSparseArray);
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z2) {
        boolean zB;
        this.f27700l.f(z2);
        this.H0 = true;
        super.onWindowFocusChanged(z2);
        if (!z2 || getShowLayoutBounds() == (zB = L0.b())) {
            return;
        }
        setShowLayoutBounds(zB);
        C();
    }

    @Override // androidx.compose.ui.node.Owner
    public void p(LayoutNode layoutNode) {
        AndroidAutofillManager androidAutofillManager;
        if (m0() && ComposeUiFlags.f25104d && (androidAutofillManager = this.J) != null) {
            androidAutofillManager.i(layoutNode);
        }
    }

    @Override // androidx.compose.ui.input.pointer.MatrixPositionCalculator
    public void q(float[] fArr) {
        O0();
        Matrix.l(fArr, this.f27680a0);
        AndroidComposeView_androidKt.j(fArr, Float.intBitsToFloat((int) (this.f27687e0 >> 32)), Float.intBitsToFloat((int) (this.f27687e0 & 4294967295L)), this.W);
    }

    @Override // androidx.compose.ui.node.Owner
    public void r(LayoutNode layoutNode) {
        AndroidAutofillManager androidAutofillManager;
        if (m0() && ComposeUiFlags.f25104d && (androidAutofillManager = this.J) != null) {
            androidAutofillManager.m(layoutNode);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean requestFocus(int i3, android.graphics.Rect rect) {
        View viewU0;
        if (!ComposeUiFlags.f25105e) {
            if (isFocused()) {
                return true;
            }
            if (getFocusOwner().p().b()) {
                return super.requestFocus(i3, rect);
            }
            FocusDirection focusDirectionD = FocusInteropUtils_androidKt.d(i3);
            final int iO = focusDirectionD != null ? focusDirectionD.o() : FocusDirection.f25444b.b();
            return Intrinsics.areEqual(getFocusOwner().w(iO, rect != null ? RectHelper_androidKt.e(rect) : null, new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView.requestFocus.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public final Boolean invoke(FocusTargetNode focusTargetNode) {
                    return Boolean.valueOf(focusTargetNode.R(iO));
                }
            }), Boolean.TRUE);
        }
        if (isFocused()) {
            return true;
        }
        if (this.f27702m || getFocusOwner().d().i()) {
            return false;
        }
        FocusDirection focusDirectionD2 = FocusInteropUtils_androidKt.d(i3);
        final int iO2 = focusDirectionD2 != null ? focusDirectionD2.o() : FocusDirection.f25444b.b();
        if (hasFocus() && L0(iO2)) {
            return true;
        }
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        Boolean boolW = getFocusOwner().w(iO2, rect != null ? RectHelper_androidKt.e(rect) : null, new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView$requestFocus$focusSearchResult$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(FocusTargetNode focusTargetNode) {
                booleanRef.f140137a = true;
                return Boolean.valueOf(focusTargetNode.R(iO2));
            }
        });
        if (boolW == null) {
            return false;
        }
        if (boolW.booleanValue()) {
            return true;
        }
        if (booleanRef.f140137a) {
            return false;
        }
        if ((rect != null && !hasFocus() && Intrinsics.areEqual(getFocusOwner().w(iO2, null, new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView$requestFocus$altFocus$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(FocusTargetNode focusTargetNode) {
                return Boolean.valueOf(focusTargetNode.R(iO2));
            }
        }), Boolean.TRUE)) || (viewU0 = u0(i3)) == null || viewU0 == this) {
            return true;
        }
        this.f27702m = true;
        boolean zRequestFocus = viewU0.requestFocus(i3);
        this.f27702m = false;
        return zRequestFocus;
    }

    @Override // androidx.compose.ui.node.Owner
    public void s(Owner.OnLayoutCompletedListener onLayoutCompletedListener) {
        this.T.z(onLayoutCompletedListener);
        V0(this, null, 1, null);
    }

    public void setAccessibilityEventBatchIntervalMillis(long j3) {
        this.f27722w.N0(j3);
    }

    public final void setConfigurationChangeObserver(Function1<? super Configuration, Unit> function1) {
        this.H = function1;
    }

    public final void setContentCaptureManager$ui_release(AndroidContentCaptureManager androidContentCaptureManager) {
        this.f27724x = androidContentCaptureManager;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r7v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9 */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v3, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    /* JADX WARN: Type inference failed for: r9v5 */
    public void setCoroutineContext(CoroutineContext coroutineContext) {
        this.f27696j = coroutineContext;
        DelegatableNode delegatableNodeK = getRoot().u0().k();
        if (delegatableNodeK instanceof SuspendingPointerInputModifierNode) {
            ((SuspendingPointerInputModifierNode) delegatableNodeK).O0();
        }
        int iA = NodeKind.a(16);
        if (!delegatableNodeK.getNode().isAttached()) {
            InlineClassHelperKt.c("visitSubtreeIf called on an unattached node");
        }
        MutableVector mutableVector = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child$ui_release = delegatableNodeK.getNode().getChild$ui_release();
        if (child$ui_release == null) {
            DelegatableNodeKt.c(mutableVector, delegatableNodeK.getNode(), false);
        } else {
            mutableVector.b(child$ui_release);
        }
        while (mutableVector.o() != 0) {
            Modifier.Node node = (Modifier.Node) mutableVector.u(mutableVector.o() - 1);
            if ((node.getAggregateChildKindSet$ui_release() & iA) != 0) {
                for (Modifier.Node child$ui_release2 = node; child$ui_release2 != null; child$ui_release2 = child$ui_release2.getChild$ui_release()) {
                    if ((child$ui_release2.getKindSet$ui_release() & iA) != 0) {
                        ?? H = child$ui_release2;
                        ?? mutableVector2 = 0;
                        while (H != 0) {
                            if (H instanceof PointerInputModifierNode) {
                                PointerInputModifierNode pointerInputModifierNode = (PointerInputModifierNode) H;
                                if (pointerInputModifierNode instanceof SuspendingPointerInputModifierNode) {
                                    ((SuspendingPointerInputModifierNode) pointerInputModifierNode).O0();
                                }
                            } else if ((H.getKindSet$ui_release() & iA) != 0 && (H instanceof DelegatingNode)) {
                                Modifier.Node nodeN2 = ((DelegatingNode) H).n2();
                                int i3 = 0;
                                H = H;
                                mutableVector2 = mutableVector2;
                                while (nodeN2 != null) {
                                    if ((nodeN2.getKindSet$ui_release() & iA) != 0) {
                                        i3++;
                                        mutableVector2 = mutableVector2;
                                        if (i3 == 1) {
                                            H = nodeN2;
                                        } else {
                                            if (mutableVector2 == 0) {
                                                mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (H != 0) {
                                                mutableVector2.b(H);
                                                H = 0;
                                            }
                                            mutableVector2.b(nodeN2);
                                        }
                                    }
                                    nodeN2 = nodeN2.getChild$ui_release();
                                    H = H;
                                    mutableVector2 = mutableVector2;
                                }
                                if (i3 == 1) {
                                }
                            }
                            H = DelegatableNodeKt.h(mutableVector2);
                        }
                    }
                }
            }
            DelegatableNodeKt.c(mutableVector, node, false);
        }
    }

    public final void setLastMatrixRecalculationAnimationTime$ui_release(long j3) {
        this.f27684c0 = j3;
    }

    public final void setOnViewTreeOwnersAvailable(Function1<? super ViewTreeOwners, Unit> function1) {
        ViewTreeOwners viewTreeOwners = getViewTreeOwners();
        if (viewTreeOwners != null) {
            function1.invoke(viewTreeOwners);
        }
        if (isAttachedToWindow()) {
            return;
        }
        this.f27695i0 = function1;
    }

    @Override // androidx.compose.ui.node.Owner
    public void setShowLayoutBounds(boolean z2) {
        this.O = z2;
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // androidx.compose.ui.node.Owner
    public OwnedLayer t(Function2 function2, Function0 function0, GraphicsLayer graphicsLayer, boolean z2) {
        if (graphicsLayer != null) {
            return new GraphicsLayerOwnerLayer(graphicsLayer, null, this, function2, function0);
        }
        if (!z2) {
            OwnedLayer ownedLayer = (OwnedLayer) this.A0.b();
            if (ownedLayer == null) {
                return new GraphicsLayerOwnerLayer(getGraphicsContext().a(), getGraphicsContext(), this, function2, function0);
            }
            ownedLayer.c(function2, function0);
            return ownedLayer;
        }
        if (isHardwareAccelerated() && this.f27689f0) {
            try {
                return new RenderNodeLayer(this, function2, function0);
            } catch (Throwable unused) {
                this.f27689f0 = false;
            }
        }
        if (this.Q == null) {
            ViewLayer.Companion companion = ViewLayer.f28240q;
            if (!companion.a()) {
                companion.d(new View(getContext()));
            }
            DrawChildContainer drawChildContainer = companion.b() ? new DrawChildContainer(getContext()) : new ViewLayerContainer(getContext());
            this.Q = drawChildContainer;
            addView(drawChildContainer);
        }
        DrawChildContainer drawChildContainer2 = this.Q;
        Intrinsics.checkNotNull(drawChildContainer2);
        return new ViewLayer(this, drawChildContainer2, function2, function0);
    }

    public final void t0(AndroidViewHolder androidViewHolder, Canvas canvas) {
        getAndroidViewsHandler$ui_release().a(androidViewHolder, canvas);
    }

    @Override // androidx.compose.ui.node.Owner
    public void u(LayoutNode layoutNode) {
        getLayoutNodes().r(layoutNode.v(), layoutNode);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // androidx.compose.ui.node.Owner
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object v(kotlin.jvm.functions.Function2 r5, kotlin.coroutines.Continuation r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof androidx.compose.ui.platform.AndroidComposeView$textInputSession$1
            if (r0 == 0) goto L13
            r0 = r6
            androidx.compose.ui.platform.AndroidComposeView$textInputSession$1 r0 = (androidx.compose.ui.platform.AndroidComposeView$textInputSession$1) r0
            int r1 = r0.f27763c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f27763c = r1
            goto L18
        L13:
            androidx.compose.ui.platform.AndroidComposeView$textInputSession$1 r0 = new androidx.compose.ui.platform.AndroidComposeView$textInputSession$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.f27761a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f27763c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 == r3) goto L2d
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L2d:
            kotlin.ResultKt.b(r6)
            goto L44
        L31:
            kotlin.ResultKt.b(r6)
            java.util.concurrent.atomic.AtomicReference r6 = r4.f27707o0
            androidx.compose.ui.platform.AndroidComposeView$textInputSession$2 r2 = new androidx.compose.ui.platform.AndroidComposeView$textInputSession$2
            r2.<init>()
            r0.f27763c = r3
            java.lang.Object r5 = androidx.compose.ui.SessionMutex.h(r6, r2, r5, r0)
            if (r5 != r1) goto L44
            return r1
        L44:
            kotlin.KotlinNothingValueException r5 = new kotlin.KotlinNothingValueException
            r5.<init>()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeView.v(kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // androidx.compose.ui.node.Owner
    public void w(LayoutNode layoutNode, long j3) {
        Trace.beginSection("AndroidOwner:measureAndLayout");
        try {
            this.T.u(layoutNode, j3);
            if (!this.T.n()) {
                MeasureAndLayoutDelegate.d(this.T, false, 1, null);
                s0();
            }
            if (ComposeUiFlags.f25102b) {
                getRectManager().d();
            }
            Unit unit = Unit.f139807a;
            Trace.endSection();
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    public FocusDirection w0(android.view.KeyEvent keyEvent) {
        long jA = KeyEvent_androidKt.a(keyEvent);
        Key.Companion companion = Key.f26638b;
        if (Key.p(jA, companion.m())) {
            return FocusDirection.i(KeyEvent_androidKt.f(keyEvent) ? FocusDirection.f25444b.f() : FocusDirection.f25444b.e());
        }
        if (Key.p(jA, companion.e())) {
            return FocusDirection.i(FocusDirection.f25444b.g());
        }
        if (Key.p(jA, companion.d())) {
            return FocusDirection.i(FocusDirection.f25444b.d());
        }
        if (Key.p(jA, companion.f()) ? true : Key.p(jA, companion.k())) {
            return FocusDirection.i(FocusDirection.f25444b.h());
        }
        if (Key.p(jA, companion.c()) ? true : Key.p(jA, companion.j())) {
            return FocusDirection.i(FocusDirection.f25444b.a());
        }
        if (Key.p(jA, companion.b()) ? true : Key.p(jA, companion.g()) ? true : Key.p(jA, companion.i())) {
            return FocusDirection.i(FocusDirection.f25444b.b());
        }
        if (Key.p(jA, companion.a()) ? true : Key.p(jA, companion.h())) {
            return FocusDirection.i(FocusDirection.f25444b.c());
        }
        return null;
    }

    @Override // androidx.compose.ui.input.pointer.PositionCalculator
    public long x(long j3) {
        O0();
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j3 >> 32)) - Float.intBitsToFloat((int) (this.f27687e0 >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j3 & 4294967295L)) - Float.intBitsToFloat((int) (this.f27687e0 & 4294967295L));
        return Matrix.f(this.f27682b0, Offset.e((((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32) | (4294967295L & ((long) Float.floatToRawIntBits(fIntBitsToFloat2)))));
    }

    @Override // androidx.compose.ui.node.Owner
    public long y(long j3) {
        O0();
        return Matrix.f(this.f27682b0, j3);
    }

    @Override // androidx.compose.ui.node.Owner
    public void z(LayoutNode layoutNode, boolean z2, boolean z3, boolean z4) {
        if (z2) {
            if (this.T.F(layoutNode, z3) && z4) {
                U0(layoutNode);
                return;
            }
            return;
        }
        if (this.T.I(layoutNode, z3) && z4) {
            U0(layoutNode);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i3) {
        Intrinsics.checkNotNull(view);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = generateDefaultLayoutParams();
        }
        addView(view, i3, layoutParams);
    }

    @Override // androidx.compose.ui.node.Owner
    public AndroidAccessibilityManager getAccessibilityManager() {
        return this.f27726y;
    }

    @Override // androidx.compose.ui.node.Owner
    public AndroidClipboard getClipboard() {
        return this.M;
    }

    @Override // androidx.compose.ui.node.Owner
    public AndroidClipboardManager getClipboardManager() {
        return this.L;
    }

    @Override // androidx.compose.ui.node.Owner
    public AndroidDragAndDropManager getDragAndDropManager() {
        return this.f27698k;
    }

    public MutableIntObjectMap<LayoutNode> getLayoutNodes() {
        return this.f27714s;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i3, int i4) {
        ViewGroup.LayoutParams layoutParamsGenerateDefaultLayoutParams = generateDefaultLayoutParams();
        layoutParamsGenerateDefaultLayoutParams.width = i3;
        layoutParamsGenerateDefaultLayoutParams.height = i4;
        Unit unit = Unit.f139807a;
        addView(view, -1, layoutParamsGenerateDefaultLayoutParams);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        addView(view, -1, layoutParams);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i3, ViewGroup.LayoutParams layoutParams) {
        addViewInLayout(view, i3, layoutParams, true);
    }

    @Deprecated
    public static /* synthetic */ void getFontLoader$annotations() {
    }

    public static /* synthetic */ void getLastMatrixRecalculationAnimationTime$ui_release$annotations() {
    }

    public static /* synthetic */ void getShowLayoutBounds$annotations() {
    }

    @Deprecated
    public static /* synthetic */ void getTextInputService$annotations() {
    }

    public View getView() {
        return this;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
    }
}
