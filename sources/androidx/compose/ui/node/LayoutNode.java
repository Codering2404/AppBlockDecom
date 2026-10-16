package androidx.compose.ui.node;

import android.view.View;
import androidx.compose.runtime.ComposeNodeLifecycleCallback;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.ComposeUiFlags;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.input.pointer.PointerType;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutInfo;
import androidx.compose.ui.layout.LayoutNodeSubcompositionsState;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.Remeasurement;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.JvmActuals_jvmKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsInfo;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpSize;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.viewinterop.AndroidViewHolder;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import java.util.Comparator;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class LayoutNode implements ComposeNodeLifecycleCallback, Remeasurement, OwnerScope, LayoutInfo, SemanticsInfo, ComposeUiNode, InteroperableComposeUiNode, Owner.OnLayoutCompletedListener {
    public static final Companion T = new Companion(null);
    public static final int U = 8;
    private static final NoIntrinsicsMeasurePolicy V = new NoIntrinsicsMeasurePolicy() { // from class: androidx.compose.ui.node.LayoutNode$Companion$ErrorMeasurePolicy$1
        public Void e(MeasureScope measureScope, List list, long j3) {
            throw new IllegalStateException("Undefined measure and it is required");
        }

        @Override // androidx.compose.ui.layout.MeasurePolicy
        /* JADX INFO: renamed from: measure-3p2s80s */
        public /* bridge */ /* synthetic */ MeasureResult mo10measure3p2s80s(MeasureScope measureScope, List list, long j3) {
            return (MeasureResult) e(measureScope, list, j3);
        }
    };
    private static final Function0 W = new Function0<LayoutNode>() { // from class: androidx.compose.ui.node.LayoutNode$Companion$Constructor$1
        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final LayoutNode invoke() {
            return new LayoutNode(false, 0 == true ? 1 : 0, 3, null);
        }
    };
    private static final ViewConfiguration X = new ViewConfiguration() { // from class: androidx.compose.ui.node.LayoutNode$Companion$DummyViewConfiguration$1
        @Override // androidx.compose.ui.platform.ViewConfiguration
        public long a() {
            return 300L;
        }

        @Override // androidx.compose.ui.platform.ViewConfiguration
        public long b() {
            return 40L;
        }

        @Override // androidx.compose.ui.platform.ViewConfiguration
        public long c() {
            return 400L;
        }

        @Override // androidx.compose.ui.platform.ViewConfiguration
        public long e() {
            return DpSize.f29984b.b();
        }

        @Override // androidx.compose.ui.platform.ViewConfiguration
        public float g() {
            return 16.0f;
        }
    };
    private static final Comparator Y = new Comparator() { // from class: androidx.compose.ui.node.a
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return LayoutNode.p((LayoutNode) obj, (LayoutNode) obj2);
        }
    };
    private IntrinsicsPolicy A;
    private Density B;
    private LayoutDirection C;
    private ViewConfiguration D;
    private CompositionLocalMap E;
    private UsageByParent F;
    private UsageByParent G;
    private boolean H;
    private final NodeChain I;
    private final LayoutNodeLayoutDelegate J;
    private LayoutNodeSubcompositionsState K;
    private NodeCoordinator L;
    private boolean M;
    private Modifier N;
    private Modifier O;
    private Function1 P;
    private Function1 Q;
    private boolean R;
    private boolean S;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f27358a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f27359b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f27360c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f27361d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f27362f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f27363g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f27364h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f27365i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f27366j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private LayoutNode f27367k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f27368l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final MutableVectorWithMutationTracking f27369m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private MutableVector f27370n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f27371o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private LayoutNode f27372p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private Owner f27373q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private AndroidViewHolder f27374r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f27375s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f27376t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f27377u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private SemanticsConfiguration f27378v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f27379w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final MutableVector f27380x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f27381y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private MeasurePolicy f27382z;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Function0 a() {
            return LayoutNode.W;
        }

        public final Comparator b() {
            return LayoutNode.Y;
        }

        private Companion() {
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class LayoutState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final LayoutState f27384a = new LayoutState("Measuring", 0);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final LayoutState f27385b = new LayoutState("LookaheadMeasuring", 1);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final LayoutState f27386c = new LayoutState("LayingOut", 2);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final LayoutState f27387d = new LayoutState("LookaheadLayingOut", 3);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final LayoutState f27388f = new LayoutState("Idle", 4);

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final /* synthetic */ LayoutState[] f27389g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final /* synthetic */ EnumEntries f27390h;

        static {
            LayoutState[] layoutStateArrA = a();
            f27389g = layoutStateArrA;
            f27390h = EnumEntriesKt.a(layoutStateArrA);
        }

        private LayoutState(String str, int i3) {
        }

        private static final /* synthetic */ LayoutState[] a() {
            return new LayoutState[]{f27384a, f27385b, f27386c, f27387d, f27388f};
        }

        public static LayoutState valueOf(String str) {
            return (LayoutState) Enum.valueOf(LayoutState.class, str);
        }

        public static LayoutState[] values() {
            return (LayoutState[]) f27389g.clone();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static abstract class NoIntrinsicsMeasurePolicy implements MeasurePolicy {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f27391a;

        public NoIntrinsicsMeasurePolicy(String str) {
            this.f27391a = str;
        }

        public Void a(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i3) {
            throw new IllegalStateException(this.f27391a.toString());
        }

        public Void b(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i3) {
            throw new IllegalStateException(this.f27391a.toString());
        }

        public Void c(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i3) {
            throw new IllegalStateException(this.f27391a.toString());
        }

        public Void d(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i3) {
            throw new IllegalStateException(this.f27391a.toString());
        }

        @Override // androidx.compose.ui.layout.MeasurePolicy
        public /* bridge */ /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i3) {
            return ((Number) a(intrinsicMeasureScope, list, i3)).intValue();
        }

        @Override // androidx.compose.ui.layout.MeasurePolicy
        public /* bridge */ /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i3) {
            return ((Number) b(intrinsicMeasureScope, list, i3)).intValue();
        }

        @Override // androidx.compose.ui.layout.MeasurePolicy
        public /* bridge */ /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i3) {
            return ((Number) c(intrinsicMeasureScope, list, i3)).intValue();
        }

        @Override // androidx.compose.ui.layout.MeasurePolicy
        public /* bridge */ /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i3) {
            return ((Number) d(intrinsicMeasureScope, list, i3)).intValue();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class UsageByParent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final UsageByParent f27392a = new UsageByParent("InMeasureBlock", 0);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final UsageByParent f27393b = new UsageByParent("InLayoutBlock", 1);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final UsageByParent f27394c = new UsageByParent("NotUsed", 2);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ UsageByParent[] f27395d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final /* synthetic */ EnumEntries f27396f;

        static {
            UsageByParent[] usageByParentArrA = a();
            f27395d = usageByParentArrA;
            f27396f = EnumEntriesKt.a(usageByParentArrA);
        }

        private UsageByParent(String str, int i3) {
        }

        private static final /* synthetic */ UsageByParent[] a() {
            return new UsageByParent[]{f27392a, f27393b, f27394c};
        }

        public static UsageByParent valueOf(String str) {
            return (UsageByParent) Enum.valueOf(UsageByParent.class, str);
        }

        public static UsageByParent[] values() {
            return (UsageByParent[]) f27395d.clone();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f27397a;

        static {
            int[] iArr = new int[LayoutState.values().length];
            try {
                iArr[LayoutState.f27388f.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f27397a = iArr;
        }
    }

    public LayoutNode(boolean z2, int i3) {
        this.f27358a = z2;
        this.f27359b = i3;
        IntOffset.Companion companion = IntOffset.f29988b;
        this.f27360c = companion.a();
        this.f27361d = IntSize.f29998b.a();
        this.f27362f = companion.a();
        this.f27363g = true;
        this.f27369m = new MutableVectorWithMutationTracking(new MutableVector(new LayoutNode[16], 0), new Function0<Unit>() { // from class: androidx.compose.ui.node.LayoutNode$_foldedChildren$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m230invoke();
                return Unit.f139807a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m230invoke() {
                this.f27398a.f0().D();
            }
        });
        this.f27380x = new MutableVector(new LayoutNode[16], 0);
        this.f27381y = true;
        this.f27382z = V;
        this.B = LayoutNodeKt.f27406a;
        this.C = LayoutDirection.f30001a;
        this.D = X;
        this.E = CompositionLocalMap.Y7.a();
        UsageByParent usageByParent = UsageByParent.f27394c;
        this.F = usageByParent;
        this.G = usageByParent;
        this.I = new NodeChain(this);
        this.J = new LayoutNodeLayoutDelegate(this);
        this.M = true;
        this.N = Modifier.b8;
    }

    private final SemanticsConfiguration A() {
        this.f27379w = true;
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.f140144a = new SemanticsConfiguration();
        LayoutNodeKt.b(this).getSnapshotObserver().j(this, new Function0<Unit>() { // from class: androidx.compose.ui.node.LayoutNode$calculateSemanticsConfiguration$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m231invoke();
                return Unit.f139807a;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r4v0 */
            /* JADX WARN: Type inference failed for: r4v1, types: [androidx.compose.ui.Modifier$Node] */
            /* JADX WARN: Type inference failed for: r4v10 */
            /* JADX WARN: Type inference failed for: r4v11 */
            /* JADX WARN: Type inference failed for: r4v3 */
            /* JADX WARN: Type inference failed for: r4v4, types: [androidx.compose.ui.Modifier$Node] */
            /* JADX WARN: Type inference failed for: r4v5, types: [java.lang.Object] */
            /* JADX WARN: Type inference failed for: r4v6 */
            /* JADX WARN: Type inference failed for: r4v7 */
            /* JADX WARN: Type inference failed for: r4v8 */
            /* JADX WARN: Type inference failed for: r4v9 */
            /* JADX WARN: Type inference failed for: r5v0 */
            /* JADX WARN: Type inference failed for: r5v1 */
            /* JADX WARN: Type inference failed for: r5v10 */
            /* JADX WARN: Type inference failed for: r5v11 */
            /* JADX WARN: Type inference failed for: r5v2 */
            /* JADX WARN: Type inference failed for: r5v3, types: [androidx.compose.runtime.collection.MutableVector] */
            /* JADX WARN: Type inference failed for: r5v4 */
            /* JADX WARN: Type inference failed for: r5v5 */
            /* JADX WARN: Type inference failed for: r5v6, types: [androidx.compose.runtime.collection.MutableVector] */
            /* JADX WARN: Type inference failed for: r5v8 */
            /* JADX WARN: Type inference failed for: r5v9 */
            /* JADX WARN: Type inference failed for: r6v11 */
            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m231invoke() {
                NodeChain nodeChainU0 = this.f27399a.u0();
                int iA = NodeKind.a(8);
                Ref.ObjectRef objectRef2 = objectRef;
                if ((nodeChainU0.i() & iA) != 0) {
                    for (Modifier.Node nodeP = nodeChainU0.p(); nodeP != null; nodeP = nodeP.getParent$ui_release()) {
                        if ((nodeP.getKindSet$ui_release() & iA) != 0) {
                            ?? H = nodeP;
                            ?? mutableVector = 0;
                            while (H != 0) {
                                if (H instanceof SemanticsModifierNode) {
                                    SemanticsModifierNode semanticsModifierNode = (SemanticsModifierNode) H;
                                    if (semanticsModifierNode.j0()) {
                                        SemanticsConfiguration semanticsConfiguration = new SemanticsConfiguration();
                                        objectRef2.f140144a = semanticsConfiguration;
                                        semanticsConfiguration.s(true);
                                    }
                                    if (semanticsModifierNode.d2()) {
                                        ((SemanticsConfiguration) objectRef2.f140144a).t(true);
                                    }
                                    semanticsModifierNode.N((SemanticsPropertyReceiver) objectRef2.f140144a);
                                } else if ((H.getKindSet$ui_release() & iA) != 0 && (H instanceof DelegatingNode)) {
                                    Modifier.Node nodeN2 = ((DelegatingNode) H).n2();
                                    int i3 = 0;
                                    H = H;
                                    mutableVector = mutableVector;
                                    while (nodeN2 != null) {
                                        if ((nodeN2.getKindSet$ui_release() & iA) != 0) {
                                            i3++;
                                            mutableVector = mutableVector;
                                            if (i3 == 1) {
                                                H = nodeN2;
                                            } else {
                                                if (mutableVector == 0) {
                                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                if (H != 0) {
                                                    mutableVector.b(H);
                                                    H = 0;
                                                }
                                                mutableVector.b(nodeN2);
                                            }
                                        }
                                        nodeN2 = nodeN2.getChild$ui_release();
                                        H = H;
                                        mutableVector = mutableVector;
                                    }
                                    if (i3 == 1) {
                                    }
                                }
                                H = DelegatableNodeKt.h(mutableVector);
                            }
                        }
                    }
                }
            }
        });
        this.f27379w = false;
        return (SemanticsConfiguration) objectRef.f140144a;
    }

    public static /* synthetic */ void A1(LayoutNode layoutNode, boolean z2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z2 = false;
        }
        layoutNode.z1(z2);
    }

    private final void C() {
        this.G = this.F;
        this.F = UsageByParent.f27394c;
        MutableVector mutableVectorH0 = H0();
        Object[] objArr = mutableVectorH0.f24389a;
        int iO = mutableVectorH0.o();
        for (int i3 = 0; i3 < iO; i3++) {
            LayoutNode layoutNode = (LayoutNode) objArr[i3];
            if (layoutNode.F == UsageByParent.f27393b) {
                layoutNode.C();
            }
        }
    }

    public static /* synthetic */ void C1(LayoutNode layoutNode, boolean z2, boolean z3, boolean z4, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z2 = false;
        }
        if ((i3 & 2) != 0) {
            z3 = true;
        }
        if ((i3 & 4) != 0) {
            z4 = true;
        }
        layoutNode.B1(z2, z3, z4);
    }

    private final String D(int i3) {
        StringBuilder sb = new StringBuilder();
        for (int i4 = 0; i4 < i3; i4++) {
            sb.append("  ");
        }
        sb.append("|-");
        sb.append(toString());
        sb.append('\n');
        MutableVector mutableVectorH0 = H0();
        Object[] objArr = mutableVectorH0.f24389a;
        int iO = mutableVectorH0.o();
        for (int i5 = 0; i5 < iO; i5++) {
            sb.append(((LayoutNode) objArr[i5]).D(i3 + 1));
        }
        String string = sb.toString();
        if (i3 != 0) {
            return string;
        }
        String strSubstring = string.substring(0, string.length() - 1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    static /* synthetic */ String E(LayoutNode layoutNode, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i3 = 0;
        }
        return layoutNode.D(i3);
    }

    public static /* synthetic */ void E1(LayoutNode layoutNode, boolean z2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z2 = false;
        }
        layoutNode.D1(z2);
    }

    private final float F0() {
        return n0().j2();
    }

    public static /* synthetic */ void G1(LayoutNode layoutNode, boolean z2, boolean z3, boolean z4, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z2 = false;
        }
        if ((i3 & 2) != 0) {
            z3 = true;
        }
        if ((i3 & 4) != 0) {
            z4 = true;
        }
        layoutNode.F1(z2, z3, z4);
    }

    private final String I(LayoutNode layoutNode) {
        StringBuilder sb = new StringBuilder();
        sb.append("Cannot insert ");
        sb.append(layoutNode);
        sb.append(" because it already has a parent or an owner. This tree: ");
        sb.append(E(this, 0, 1, null));
        sb.append(" Other tree: ");
        LayoutNode layoutNode2 = layoutNode.f27372p;
        sb.append(layoutNode2 != null ? E(layoutNode2, 0, 1, null) : null);
        return sb.toString();
    }

    private final void I1() {
        this.I.y();
    }

    public static /* synthetic */ void J0(LayoutNode layoutNode, long j3, HitTestResult hitTestResult, int i3, boolean z2, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i3 = PointerType.f26922b.e();
        }
        int i5 = i3;
        if ((i4 & 8) != 0) {
            z2 = true;
        }
        layoutNode.I0(j3, hitTestResult, i5, z2);
    }

    public static /* synthetic */ void L0(LayoutNode layoutNode, long j3, HitTestResult hitTestResult, int i3, boolean z2, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i3 = PointerType.f26922b.d();
        }
        int i5 = i3;
        if ((i4 & 8) != 0) {
            z2 = true;
        }
        layoutNode.K0(j3, hitTestResult, i5, z2);
    }

    private final void Q1(LayoutNode layoutNode) {
        if (Intrinsics.areEqual(layoutNode, this.f27367k)) {
            return;
        }
        this.f27367k = layoutNode;
        if (layoutNode != null) {
            this.J.b();
            NodeCoordinator nodeCoordinatorX2 = Z().X2();
            for (NodeCoordinator nodeCoordinatorX0 = x0(); !Intrinsics.areEqual(nodeCoordinatorX0, nodeCoordinatorX2) && nodeCoordinatorX0 != null; nodeCoordinatorX0 = nodeCoordinatorX0.X2()) {
                nodeCoordinatorX0.H2();
            }
        } else {
            this.J.a();
        }
        P0();
    }

    private final void T0() {
        LayoutNode layoutNode;
        if (this.f27368l > 0) {
            this.f27371o = true;
        }
        if (!this.f27358a || (layoutNode = this.f27372p) == null) {
            return;
        }
        layoutNode.T0();
    }

    public static /* synthetic */ boolean Y0(LayoutNode layoutNode, Constraints constraints, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            constraints = layoutNode.J.l();
        }
        return layoutNode.X0(constraints);
    }

    private final void o1(LayoutNode layoutNode) {
        if (layoutNode.J.d() > 0) {
            this.J.L(r0.d() - 1);
        }
        if (this.f27373q != null) {
            layoutNode.F();
        }
        layoutNode.f27372p = null;
        layoutNode.x0().I3(null);
        if (layoutNode.f27358a) {
            this.f27368l--;
            MutableVector mutableVectorC = layoutNode.f27369m.c();
            Object[] objArr = mutableVectorC.f24389a;
            int iO = mutableVectorC.o();
            for (int i3 = 0; i3 < iO; i3++) {
                ((LayoutNode) objArr[i3]).x0().I3(null);
            }
        }
        T0();
        q1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int p(LayoutNode layoutNode, LayoutNode layoutNode2) {
        return layoutNode.F0() == layoutNode2.F0() ? Intrinsics.compare(layoutNode.C0(), layoutNode2.C0()) : Float.compare(layoutNode.F0(), layoutNode2.F0());
    }

    private final void p1() {
        P0();
        LayoutNode layoutNodeB0 = B0();
        if (layoutNodeB0 != null) {
            layoutNodeB0.N0();
        }
        O0();
    }

    private final void s1() {
        if (this.f27371o) {
            this.f27371o = false;
            MutableVector mutableVector = this.f27370n;
            if (mutableVector == null) {
                mutableVector = new MutableVector(new LayoutNode[16], 0);
                this.f27370n = mutableVector;
            }
            mutableVector.i();
            MutableVector mutableVectorC = this.f27369m.c();
            Object[] objArr = mutableVectorC.f24389a;
            int iO = mutableVectorC.o();
            for (int i3 = 0; i3 < iO; i3++) {
                LayoutNode layoutNode = (LayoutNode) objArr[i3];
                if (layoutNode.f27358a) {
                    mutableVector.d(mutableVector.o(), layoutNode.H0());
                } else {
                    mutableVector.b(layoutNode);
                }
            }
            this.J.D();
        }
    }

    private final void t(Modifier modifier) {
        this.N = modifier;
        this.I.F(modifier);
        this.J.Z();
        if (this.f27367k == null && this.I.q(NodeKind.a(512))) {
            Q1(this);
        }
    }

    public static /* synthetic */ boolean u1(LayoutNode layoutNode, Constraints constraints, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            constraints = layoutNode.J.k();
        }
        return layoutNode.t1(constraints);
    }

    private final IntrinsicsPolicy w0() {
        IntrinsicsPolicy intrinsicsPolicy = this.A;
        if (intrinsicsPolicy != null) {
            return intrinsicsPolicy;
        }
        IntrinsicsPolicy intrinsicsPolicy2 = new IntrinsicsPolicy(this, p0());
        this.A = intrinsicsPolicy2;
        return intrinsicsPolicy2;
    }

    public final Owner A0() {
        return this.f27373q;
    }

    public final void B() {
        this.G = this.F;
        this.F = UsageByParent.f27394c;
        MutableVector mutableVectorH0 = H0();
        Object[] objArr = mutableVectorH0.f24389a;
        int iO = mutableVectorH0.o();
        for (int i3 = 0; i3 < iO; i3++) {
            LayoutNode layoutNode = (LayoutNode) objArr[i3];
            if (layoutNode.F != UsageByParent.f27394c) {
                layoutNode.B();
            }
        }
    }

    public final LayoutNode B0() {
        LayoutNode layoutNode = this.f27372p;
        while (layoutNode != null && layoutNode.f27358a) {
            layoutNode = layoutNode.f27372p;
        }
        return layoutNode;
    }

    public final void B1(boolean z2, boolean z3, boolean z4) {
        if (!(this.f27367k != null)) {
            InlineClassHelperKt.c("Lookahead measure cannot be requested on a node that is not a part of theLookaheadScope");
        }
        Owner owner = this.f27373q;
        if (owner == null || this.f27376t || this.f27358a) {
            return;
        }
        owner.z(this, true, z2, z3);
        if (z4) {
            LookaheadPassDelegate lookaheadPassDelegateK0 = k0();
            Intrinsics.checkNotNull(lookaheadPassDelegateK0);
            lookaheadPassDelegateK0.d2(z2);
        }
    }

    public final int C0() {
        return n0().d2();
    }

    public final LayoutNodeSubcompositionsState D0() {
        return this.K;
    }

    public final void D1(boolean z2) {
        Owner owner;
        this.f27363g = true;
        if (this.f27358a || (owner = this.f27373q) == null) {
            return;
        }
        Owner.e(owner, this, false, z2, 2, null);
    }

    public ViewConfiguration E0() {
        return this.D;
    }

    public final void F() {
        Owner owner = this.f27373q;
        if (owner == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Cannot detach node that is already detached!  Tree: ");
            LayoutNode layoutNodeB0 = B0();
            sb.append(layoutNodeB0 != null ? E(layoutNodeB0, 0, 1, null) : null);
            InlineClassHelperKt.d(sb.toString());
            throw new KotlinNothingValueException();
        }
        LayoutNode layoutNodeB02 = B0();
        if (layoutNodeB02 != null) {
            layoutNodeB02.N0();
            layoutNodeB02.P0();
            MeasurePassDelegate measurePassDelegateN0 = n0();
            UsageByParent usageByParent = UsageByParent.f27394c;
            measurePassDelegateN0.E2(usageByParent);
            LookaheadPassDelegate lookaheadPassDelegateK0 = k0();
            if (lookaheadPassDelegateK0 != null) {
                lookaheadPassDelegateK0.C2(usageByParent);
            }
        }
        this.J.K();
        Function1 function1 = this.Q;
        if (function1 != null) {
            function1.invoke(owner);
        }
        if (!ComposeUiFlags.f25104d && this.I.q(NodeKind.a(8))) {
            S0();
        }
        this.I.A();
        this.f27376t = true;
        MutableVector mutableVectorC = this.f27369m.c();
        Object[] objArr = mutableVectorC.f24389a;
        int iO = mutableVectorC.o();
        for (int i3 = 0; i3 < iO; i3++) {
            ((LayoutNode) objArr[i3]).F();
        }
        this.f27376t = false;
        this.I.u();
        owner.B(this);
        this.f27373q = null;
        Q1(null);
        this.f27375s = 0;
        n0().v2();
        LookaheadPassDelegate lookaheadPassDelegateK02 = k0();
        if (lookaheadPassDelegateK02 != null) {
            lookaheadPassDelegateK02.r2();
        }
        if (ComposeUiFlags.f25104d && this.I.q(NodeKind.a(8))) {
            SemanticsConfiguration semanticsConfiguration = this.f27378v;
            this.f27378v = null;
            this.f27377u = false;
            owner.getSemanticsOwner().e(this, semanticsConfiguration);
            owner.F();
        }
    }

    public final void F1(boolean z2, boolean z3, boolean z4) {
        Owner owner;
        if (this.f27376t || this.f27358a || (owner = this.f27373q) == null) {
            return;
        }
        Owner.J(owner, this, false, z2, z3, 2, null);
        if (z4) {
            n0().k2(z2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Type inference failed for: r6v6 */
    public final void G() {
        if (h0() != LayoutState.f27388f || g0() || o0() || y() || !u()) {
            return;
        }
        NodeChain nodeChain = this.I;
        int iA = NodeKind.a(Function.MAX_NARGS);
        if ((nodeChain.i() & iA) != 0) {
            for (Modifier.Node nodeK = nodeChain.k(); nodeK != null; nodeK = nodeK.getChild$ui_release()) {
                if ((nodeK.getKindSet$ui_release() & iA) != 0) {
                    ?? H = nodeK;
                    ?? mutableVector = 0;
                    while (H != 0) {
                        if (H instanceof GlobalPositionAwareModifierNode) {
                            GlobalPositionAwareModifierNode globalPositionAwareModifierNode = (GlobalPositionAwareModifierNode) H;
                            globalPositionAwareModifierNode.I(DelegatableNodeKt.j(globalPositionAwareModifierNode, NodeKind.a(Function.MAX_NARGS)));
                        } else if ((H.getKindSet$ui_release() & iA) != 0 && (H instanceof DelegatingNode)) {
                            Modifier.Node nodeN2 = ((DelegatingNode) H).n2();
                            int i3 = 0;
                            H = H;
                            mutableVector = mutableVector;
                            while (nodeN2 != null) {
                                if ((nodeN2.getKindSet$ui_release() & iA) != 0) {
                                    i3++;
                                    mutableVector = mutableVector;
                                    if (i3 == 1) {
                                        H = nodeN2;
                                    } else {
                                        if (mutableVector == 0) {
                                            mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                        }
                                        if (H != 0) {
                                            mutableVector.b(H);
                                            H = 0;
                                        }
                                        mutableVector.b(nodeN2);
                                    }
                                }
                                nodeN2 = nodeN2.getChild$ui_release();
                                H = H;
                                mutableVector = mutableVector;
                            }
                            if (i3 == 1) {
                            }
                        }
                        H = DelegatableNodeKt.h(mutableVector);
                    }
                }
                if ((nodeK.getAggregateChildKindSet$ui_release() & iA) == 0) {
                    return;
                }
            }
        }
    }

    public final MutableVector G0() {
        if (this.f27381y) {
            this.f27380x.i();
            MutableVector mutableVector = this.f27380x;
            mutableVector.d(mutableVector.o(), H0());
            this.f27380x.A(Y);
            this.f27381y = false;
        }
        return this.f27380x;
    }

    public final void H(Canvas canvas, GraphicsLayer graphicsLayer) {
        x0().E2(canvas, graphicsLayer);
    }

    public final MutableVector H0() {
        b2();
        if (this.f27368l == 0) {
            return this.f27369m.c();
        }
        MutableVector mutableVector = this.f27370n;
        Intrinsics.checkNotNull(mutableVector);
        return mutableVector;
    }

    public final void H1(LayoutNode layoutNode) {
        if (WhenMappings.f27397a[layoutNode.h0().ordinal()] != 1) {
            throw new IllegalStateException("Unexpected state " + layoutNode.h0());
        }
        if (layoutNode.j0()) {
            C1(layoutNode, true, false, false, 6, null);
            return;
        }
        if (layoutNode.i0()) {
            layoutNode.z1(true);
        }
        if (layoutNode.o0()) {
            G1(layoutNode, true, false, false, 6, null);
        } else if (layoutNode.g0()) {
            layoutNode.D1(true);
        }
    }

    public final void I0(long j3, HitTestResult hitTestResult, int i3, boolean z2) {
        x0().f3(NodeCoordinator.O.a(), NodeCoordinator.K2(x0(), j3, false, 2, null), hitTestResult, i3, z2);
    }

    public final boolean J() {
        AlignmentLinesOwner alignmentLinesOwnerP;
        AlignmentLines alignmentLinesZ;
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.J;
        return layoutNodeLayoutDelegate.c().z().k() || !((alignmentLinesOwnerP = layoutNodeLayoutDelegate.p()) == null || (alignmentLinesZ = alignmentLinesOwnerP.z()) == null || !alignmentLinesZ.k());
    }

    public final void J1() {
        MutableVector mutableVectorH0 = H0();
        Object[] objArr = mutableVectorH0.f24389a;
        int iO = mutableVectorH0.o();
        for (int i3 = 0; i3 < iO; i3++) {
            LayoutNode layoutNode = (LayoutNode) objArr[i3];
            UsageByParent usageByParent = layoutNode.G;
            layoutNode.F = usageByParent;
            if (usageByParent != UsageByParent.f27394c) {
                layoutNode.J1();
            }
        }
    }

    public final boolean K() {
        return this.O != null;
    }

    public final void K0(long j3, HitTestResult hitTestResult, int i3, boolean z2) {
        x0().f3(NodeCoordinator.O.b(), NodeCoordinator.K2(x0(), j3, false, 2, null), hitTestResult, PointerType.f26922b.d(), z2);
    }

    public final void K1(boolean z2) {
        this.H = z2;
    }

    public final boolean L() {
        return this.H;
    }

    public final void L1(boolean z2) {
        this.f27364h = z2;
    }

    public final List M() {
        LookaheadPassDelegate lookaheadPassDelegateK0 = k0();
        Intrinsics.checkNotNull(lookaheadPassDelegateK0);
        return lookaheadPassDelegateK0.w1();
    }

    public final void M0(int i3, LayoutNode layoutNode) {
        if (!(layoutNode.f27372p == null || layoutNode.f27373q == null)) {
            InlineClassHelperKt.c(I(layoutNode));
        }
        layoutNode.f27372p = this;
        this.f27369m.a(i3, layoutNode);
        q1();
        if (layoutNode.f27358a) {
            this.f27368l++;
        }
        T0();
        Owner owner = this.f27373q;
        if (owner != null) {
            layoutNode.z(owner);
        }
        if (layoutNode.J.d() > 0) {
            LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.J;
            layoutNodeLayoutDelegate.L(layoutNodeLayoutDelegate.d() + 1);
        }
    }

    public final void M1(boolean z2) {
        this.M = z2;
    }

    public final List N() {
        return n0().A1();
    }

    public final void N0() {
        NodeCoordinator nodeCoordinatorA0 = a0();
        if (nodeCoordinatorA0 != null) {
            nodeCoordinatorA0.h3();
            return;
        }
        LayoutNode layoutNodeB0 = B0();
        if (layoutNodeB0 != null) {
            layoutNodeB0.N0();
        }
    }

    public final void N1(AndroidViewHolder androidViewHolder) {
        this.f27374r = androidViewHolder;
    }

    public final List O() {
        return H0().h();
    }

    public final void O0() {
        NodeCoordinator nodeCoordinatorZ = Z();
        for (NodeCoordinator nodeCoordinatorX0 = x0(); nodeCoordinatorX0 != nodeCoordinatorZ; nodeCoordinatorX0 = nodeCoordinatorX0.X2()) {
            Intrinsics.checkNotNull(nodeCoordinatorX0, "null cannot be cast to non-null type androidx.compose.ui.node.LayoutModifierNodeCoordinator");
            OwnedLayer ownedLayerR2 = ((LayoutModifierNodeCoordinator) nodeCoordinatorX0).R2();
            if (ownedLayerR2 != null) {
                ownedLayerR2.invalidate();
            }
        }
        OwnedLayer ownedLayerR22 = Z().R2();
        if (ownedLayerR22 != null) {
            ownedLayerR22.invalidate();
        }
    }

    public final void O1(UsageByParent usageByParent) {
        this.F = usageByParent;
    }

    public int P() {
        return this.f27365i;
    }

    public final void P0() {
        this.f27363g = true;
        if (this.f27367k != null) {
            C1(this, false, false, false, 7, null);
        } else {
            G1(this, false, false, false, 7, null);
        }
    }

    public final void P1(long j3) {
        this.f27361d = j3;
    }

    @Override // androidx.compose.ui.semantics.SemanticsInfo
    public SemanticsConfiguration Q() {
        if (!m() || y() || !this.I.q(NodeKind.a(8))) {
            return null;
        }
        if (!ComposeUiFlags.f25104d && this.f27378v == null) {
            this.f27378v = A();
        }
        return this.f27378v;
    }

    public final void Q0() {
        if (g0() || o0() || this.R) {
            return;
        }
        LayoutNodeKt.b(this).g(this);
    }

    @Override // androidx.compose.ui.semantics.SemanticsInfo
    public List R() {
        return O();
    }

    public final void R0() {
        this.J.C();
    }

    public final void R1(boolean z2) {
        this.R = z2;
    }

    @Override // androidx.compose.ui.semantics.SemanticsInfo
    public boolean S() {
        return x0().k3();
    }

    public final void S0() {
        if (this.f27379w) {
            return;
        }
        if (!ComposeUiFlags.f25104d) {
            this.f27378v = null;
            LayoutNodeKt.b(this).F();
        } else {
            if (this.I.s() || K()) {
                this.f27377u = true;
                return;
            }
            SemanticsConfiguration semanticsConfiguration = this.f27378v;
            this.f27378v = A();
            this.f27377u = false;
            Owner ownerB = LayoutNodeKt.b(this);
            ownerB.getSemanticsOwner().e(this, semanticsConfiguration);
            ownerB.F();
        }
    }

    public final void S1(long j3) {
        this.f27360c = j3;
    }

    public CompositionLocalMap T() {
        return this.E;
    }

    public final void T1(Function1 function1) {
        this.P = function1;
    }

    public Density U() {
        return this.B;
    }

    public final boolean U0() {
        return n0().m2();
    }

    public final void U1(Function1 function1) {
        this.Q = function1;
    }

    public final int V() {
        return this.f27375s;
    }

    public final Boolean V0() {
        LookaheadPassDelegate lookaheadPassDelegateK0 = k0();
        if (lookaheadPassDelegateK0 != null) {
            return Boolean.valueOf(lookaheadPassDelegateK0.u());
        }
        return null;
    }

    public final void V1(long j3) {
        this.f27362f = j3;
    }

    public final List W() {
        return this.f27369m.c().h();
    }

    public final boolean W0() {
        return this.f27366j;
    }

    public final void W1(boolean z2) {
        this.f27363g = z2;
    }

    public final boolean X() {
        return this.f27364h;
    }

    public final boolean X0(Constraints constraints) {
        if (constraints == null || this.f27367k == null) {
            return false;
        }
        LookaheadPassDelegate lookaheadPassDelegateK0 = k0();
        Intrinsics.checkNotNull(lookaheadPassDelegateK0);
        return lookaheadPassDelegateK0.v2(constraints.r());
    }

    public void X1(int i3) {
        this.f27359b = i3;
    }

    public final boolean Y() {
        long jQ2 = Z().Q2();
        return Constraints.j(jQ2) && Constraints.i(jQ2);
    }

    public final void Y1(boolean z2) {
        this.f27377u = z2;
    }

    public final NodeCoordinator Z() {
        return this.I.l();
    }

    public final void Z0() {
        if (this.F == UsageByParent.f27394c) {
            C();
        }
        LookaheadPassDelegate lookaheadPassDelegateK0 = k0();
        Intrinsics.checkNotNull(lookaheadPassDelegateK0);
        lookaheadPassDelegateK0.w2();
    }

    public final void Z1(LayoutNodeSubcompositionsState layoutNodeSubcompositionsState) {
        this.K = layoutNodeSubcompositionsState;
    }

    public final NodeCoordinator a0() {
        if (this.M) {
            NodeCoordinator nodeCoordinatorZ = Z();
            NodeCoordinator nodeCoordinatorY2 = x0().Y2();
            this.L = null;
            while (true) {
                if (Intrinsics.areEqual(nodeCoordinatorZ, nodeCoordinatorY2)) {
                    break;
                }
                if ((nodeCoordinatorZ != null ? nodeCoordinatorZ.R2() : null) != null) {
                    this.L = nodeCoordinatorZ;
                    break;
                }
                nodeCoordinatorZ = nodeCoordinatorZ != null ? nodeCoordinatorZ.Y2() : null;
            }
        }
        NodeCoordinator nodeCoordinator = this.L;
        if (nodeCoordinator == null || nodeCoordinator.R2() != null) {
            return nodeCoordinator;
        }
        InlineClassHelperKt.d("layer was not set");
        throw new KotlinNothingValueException();
    }

    @Override // androidx.compose.ui.node.OwnerScope
    public boolean a1() {
        return m();
    }

    public final void a2(boolean z2) {
        this.f27366j = z2;
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public void b() {
        if (!ComposeUiFlags.f25106f) {
            AndroidViewHolder androidViewHolder = this.f27374r;
            if (androidViewHolder != null) {
                androidViewHolder.b();
            }
            LayoutNodeSubcompositionsState layoutNodeSubcompositionsState = this.K;
            if (layoutNodeSubcompositionsState != null) {
                layoutNodeSubcompositionsState.b();
            }
        }
        NodeCoordinator nodeCoordinatorX2 = Z().X2();
        for (NodeCoordinator nodeCoordinatorX0 = x0(); !Intrinsics.areEqual(nodeCoordinatorX0, nodeCoordinatorX2) && nodeCoordinatorX0 != null; nodeCoordinatorX0 = nodeCoordinatorX0.X2()) {
            nodeCoordinatorX0.u3();
        }
        if (ComposeUiFlags.f25106f) {
            AndroidViewHolder androidViewHolder2 = this.f27374r;
            if (androidViewHolder2 != null) {
                androidViewHolder2.b();
            }
            LayoutNodeSubcompositionsState layoutNodeSubcompositionsState2 = this.K;
            if (layoutNodeSubcompositionsState2 != null) {
                layoutNodeSubcompositionsState2.b();
            }
        }
    }

    public View b0() {
        AndroidViewHolder androidViewHolder = this.f27374r;
        if (androidViewHolder != null) {
            return androidViewHolder.getInteropView();
        }
        return null;
    }

    public final void b1() {
        this.J.E();
    }

    public final void b2() {
        if (this.f27368l > 0) {
            s1();
        }
    }

    @Override // androidx.compose.ui.node.ComposeUiNode
    public void c(LayoutDirection layoutDirection) {
        if (this.C != layoutDirection) {
            this.C = layoutDirection;
            p1();
            for (Modifier.Node nodeK = this.I.k(); nodeK != null; nodeK = nodeK.getChild$ui_release()) {
                nodeK.onLayoutDirectionChange();
            }
        }
    }

    public final AndroidViewHolder c0() {
        return this.f27374r;
    }

    public final void c1() {
        this.J.F();
    }

    @Override // androidx.compose.ui.node.ComposeUiNode
    public void d(Density density) {
        if (Intrinsics.areEqual(this.B, density)) {
            return;
        }
        this.B = density;
        p1();
        for (Modifier.Node nodeK = this.I.k(); nodeK != null; nodeK = nodeK.getChild$ui_release()) {
            nodeK.onDensityChange();
        }
    }

    public final UsageByParent d0() {
        return this.F;
    }

    public final void d1() {
        this.J.G();
    }

    @Override // androidx.compose.ui.node.ComposeUiNode
    public void e(int i3) {
        this.f27365i = i3;
    }

    public final long e0() {
        return this.f27361d;
    }

    public final void e1() {
        this.J.H();
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public void f() {
        if (!ComposeUiFlags.f25106f) {
            AndroidViewHolder androidViewHolder = this.f27374r;
            if (androidViewHolder != null) {
                androidViewHolder.f();
            }
            LayoutNodeSubcompositionsState layoutNodeSubcompositionsState = this.K;
            if (layoutNodeSubcompositionsState != null) {
                layoutNodeSubcompositionsState.f();
            }
        }
        this.S = true;
        I1();
        if (m()) {
            if (ComposeUiFlags.f25104d) {
                this.f27378v = null;
                this.f27377u = false;
            } else {
                S0();
            }
        }
        Owner owner = this.f27373q;
        if (owner != null) {
            owner.G(this);
        }
        if (ComposeUiFlags.f25106f) {
            AndroidViewHolder androidViewHolder2 = this.f27374r;
            if (androidViewHolder2 != null) {
                androidViewHolder2.f();
            }
            LayoutNodeSubcompositionsState layoutNodeSubcompositionsState2 = this.K;
            if (layoutNodeSubcompositionsState2 != null) {
                layoutNodeSubcompositionsState2.f();
            }
        }
    }

    public final LayoutNodeLayoutDelegate f0() {
        return this.J;
    }

    public final int f1(int i3) {
        return w0().b(i3);
    }

    @Override // androidx.compose.ui.layout.Remeasurement
    public void g() {
        LayoutNode layoutNode;
        if (this.f27367k != null) {
            layoutNode = this;
            C1(layoutNode, false, false, false, 5, null);
        } else {
            G1(this, false, false, false, 5, null);
            layoutNode = this;
        }
        Constraints constraintsK = layoutNode.J.k();
        if (constraintsK != null) {
            Owner owner = layoutNode.f27373q;
            if (owner != null) {
                owner.w(this, constraintsK.r());
                return;
            }
            return;
        }
        Owner owner2 = layoutNode.f27373q;
        if (owner2 != null) {
            Owner.c(owner2, false, 1, null);
        }
    }

    public final boolean g0() {
        return this.J.n();
    }

    public final int g1(int i3) {
        return w0().c(i3);
    }

    @Override // androidx.compose.ui.layout.LayoutInfo
    public int getHeight() {
        return this.J.j();
    }

    @Override // androidx.compose.ui.layout.LayoutInfo
    public LayoutDirection getLayoutDirection() {
        return this.C;
    }

    @Override // androidx.compose.ui.layout.LayoutInfo
    public int getWidth() {
        return this.J.B();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r5v4 */
    @Override // androidx.compose.ui.node.ComposeUiNode
    public void h(ViewConfiguration viewConfiguration) {
        if (Intrinsics.areEqual(this.D, viewConfiguration)) {
            return;
        }
        this.D = viewConfiguration;
        NodeChain nodeChain = this.I;
        int iA = NodeKind.a(16);
        if ((nodeChain.i() & iA) != 0) {
            for (Modifier.Node nodeK = nodeChain.k(); nodeK != null; nodeK = nodeK.getChild$ui_release()) {
                if ((nodeK.getKindSet$ui_release() & iA) != 0) {
                    ?? H = nodeK;
                    ?? mutableVector = 0;
                    while (H != 0) {
                        if (H instanceof PointerInputModifierNode) {
                            ((PointerInputModifierNode) H).b2();
                        } else if ((H.getKindSet$ui_release() & iA) != 0 && (H instanceof DelegatingNode)) {
                            Modifier.Node nodeN2 = ((DelegatingNode) H).n2();
                            int i3 = 0;
                            H = H;
                            mutableVector = mutableVector;
                            while (nodeN2 != null) {
                                if ((nodeN2.getKindSet$ui_release() & iA) != 0) {
                                    i3++;
                                    mutableVector = mutableVector;
                                    if (i3 == 1) {
                                        H = nodeN2;
                                    } else {
                                        if (mutableVector == 0) {
                                            mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                        }
                                        if (H != 0) {
                                            mutableVector.b(H);
                                            H = 0;
                                        }
                                        mutableVector.b(nodeN2);
                                    }
                                }
                                nodeN2 = nodeN2.getChild$ui_release();
                                H = H;
                                mutableVector = mutableVector;
                            }
                            if (i3 == 1) {
                            }
                        }
                        H = DelegatableNodeKt.h(mutableVector);
                    }
                }
                if ((nodeK.getAggregateChildKindSet$ui_release() & iA) == 0) {
                    return;
                }
            }
        }
    }

    public final LayoutState h0() {
        return this.J.o();
    }

    public final int h1(int i3) {
        return w0().d(i3);
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public void i() {
        if (!m()) {
            InlineClassHelperKt.a("onReuse is only expected on attached node");
        }
        if (!ComposeUiFlags.f25106f) {
            AndroidViewHolder androidViewHolder = this.f27374r;
            if (androidViewHolder != null) {
                androidViewHolder.i();
            }
            LayoutNodeSubcompositionsState layoutNodeSubcompositionsState = this.K;
            if (layoutNodeSubcompositionsState != null) {
                layoutNodeSubcompositionsState.i();
            }
        }
        this.f27379w = false;
        if (y()) {
            this.S = false;
            if (!ComposeUiFlags.f25104d) {
                S0();
            }
        } else {
            I1();
        }
        int iV = v();
        X1(SemanticsModifierKt.d());
        Owner owner = this.f27373q;
        if (owner != null) {
            owner.i(this, iV);
        }
        if (ComposeUiFlags.f25106f) {
            AndroidViewHolder androidViewHolder2 = this.f27374r;
            if (androidViewHolder2 != null) {
                androidViewHolder2.i();
            }
            LayoutNodeSubcompositionsState layoutNodeSubcompositionsState2 = this.K;
            if (layoutNodeSubcompositionsState2 != null) {
                layoutNodeSubcompositionsState2.i();
            }
        }
        this.I.t();
        this.I.z();
        if (ComposeUiFlags.f25104d && this.I.q(NodeKind.a(8))) {
            S0();
        }
        H1(this);
        Owner owner2 = this.f27373q;
        if (owner2 != null) {
            owner2.h(this, iV);
        }
    }

    public final boolean i0() {
        return this.J.s();
    }

    public final int i1(int i3) {
        return w0().e(i3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Type inference failed for: r6v5 */
    @Override // androidx.compose.ui.node.Owner.OnLayoutCompletedListener
    public void j() {
        NodeCoordinator nodeCoordinatorZ = Z();
        int iA = NodeKind.a(ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
        boolean zI = NodeKindKt.i(iA);
        Modifier.Node nodeW2 = nodeCoordinatorZ.W2();
        if (!zI && (nodeW2 = nodeW2.getParent$ui_release()) == null) {
            return;
        }
        for (Modifier.Node nodeC3 = nodeCoordinatorZ.c3(zI); nodeC3 != null && (nodeC3.getAggregateChildKindSet$ui_release() & iA) != 0; nodeC3 = nodeC3.getChild$ui_release()) {
            if ((nodeC3.getKindSet$ui_release() & iA) != 0) {
                ?? H = nodeC3;
                ?? mutableVector = 0;
                while (H != 0) {
                    if (H instanceof LayoutAwareModifierNode) {
                        ((LayoutAwareModifierNode) H).p(Z());
                    } else if ((H.getKindSet$ui_release() & iA) != 0 && (H instanceof DelegatingNode)) {
                        Modifier.Node nodeN2 = ((DelegatingNode) H).n2();
                        int i3 = 0;
                        H = H;
                        mutableVector = mutableVector;
                        while (nodeN2 != null) {
                            if ((nodeN2.getKindSet$ui_release() & iA) != 0) {
                                i3++;
                                mutableVector = mutableVector;
                                if (i3 == 1) {
                                    H = nodeN2;
                                } else {
                                    if (mutableVector == 0) {
                                        mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                    }
                                    if (H != 0) {
                                        mutableVector.b(H);
                                        H = 0;
                                    }
                                    mutableVector.b(nodeN2);
                                }
                            }
                            nodeN2 = nodeN2.getChild$ui_release();
                            H = H;
                            mutableVector = mutableVector;
                        }
                        if (i3 == 1) {
                        }
                    }
                    H = DelegatableNodeKt.h(mutableVector);
                }
            }
            if (nodeC3 == nodeW2) {
                return;
            }
        }
    }

    public final boolean j0() {
        return this.J.u();
    }

    public final int j1(int i3) {
        return w0().f(i3);
    }

    @Override // androidx.compose.ui.node.ComposeUiNode
    public void k(MeasurePolicy measurePolicy) {
        if (Intrinsics.areEqual(this.f27382z, measurePolicy)) {
            return;
        }
        this.f27382z = measurePolicy;
        IntrinsicsPolicy intrinsicsPolicy = this.A;
        if (intrinsicsPolicy != null) {
            intrinsicsPolicy.k(p0());
        }
        P0();
    }

    public final LookaheadPassDelegate k0() {
        return this.J.v();
    }

    public final int k1(int i3) {
        return w0().g(i3);
    }

    @Override // androidx.compose.ui.node.ComposeUiNode
    public void l(Modifier modifier) {
        if (!(!this.f27358a || s0() == Modifier.b8)) {
            InlineClassHelperKt.a("Modifiers are not supported on virtual LayoutNodes");
        }
        if (y()) {
            InlineClassHelperKt.a("modifier is updated when deactivated");
        }
        if (!m()) {
            this.O = modifier;
            return;
        }
        t(modifier);
        if (this.f27377u) {
            S0();
        }
    }

    public final LayoutNode l0() {
        return this.f27367k;
    }

    public final int l1(int i3) {
        return w0().h(i3);
    }

    @Override // androidx.compose.ui.layout.LayoutInfo
    public boolean m() {
        return this.f27373q != null;
    }

    public final LayoutNodeDrawScope m0() {
        return LayoutNodeKt.b(this).getSharedDrawScope();
    }

    public final int m1(int i3) {
        return w0().i(i3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r4v5 */
    @Override // androidx.compose.ui.node.ComposeUiNode
    public void n(CompositionLocalMap compositionLocalMap) {
        this.E = compositionLocalMap;
        d((Density) compositionLocalMap.a(CompositionLocalsKt.f()));
        c((LayoutDirection) compositionLocalMap.a(CompositionLocalsKt.m()));
        h((ViewConfiguration) compositionLocalMap.a(CompositionLocalsKt.t()));
        NodeChain nodeChain = this.I;
        int iA = NodeKind.a(32768);
        if ((nodeChain.i() & iA) != 0) {
            for (Modifier.Node nodeK = nodeChain.k(); nodeK != null; nodeK = nodeK.getChild$ui_release()) {
                if ((nodeK.getKindSet$ui_release() & iA) != 0) {
                    ?? H = nodeK;
                    ?? mutableVector = 0;
                    while (H != 0) {
                        if (H instanceof CompositionLocalConsumerModifierNode) {
                            Modifier.Node node = ((CompositionLocalConsumerModifierNode) H).getNode();
                            if (node.isAttached()) {
                                NodeKindKt.e(node);
                            } else {
                                node.setUpdatedNodeAwaitingAttachForInvalidation$ui_release(true);
                            }
                        } else if ((H.getKindSet$ui_release() & iA) != 0 && (H instanceof DelegatingNode)) {
                            Modifier.Node nodeN2 = ((DelegatingNode) H).n2();
                            int i3 = 0;
                            H = H;
                            mutableVector = mutableVector;
                            while (nodeN2 != null) {
                                if ((nodeN2.getKindSet$ui_release() & iA) != 0) {
                                    i3++;
                                    mutableVector = mutableVector;
                                    if (i3 == 1) {
                                        H = nodeN2;
                                    } else {
                                        if (mutableVector == 0) {
                                            mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                        }
                                        if (H != 0) {
                                            mutableVector.b(H);
                                            H = 0;
                                        }
                                        mutableVector.b(nodeN2);
                                    }
                                }
                                nodeN2 = nodeN2.getChild$ui_release();
                                H = H;
                                mutableVector = mutableVector;
                            }
                            if (i3 == 1) {
                            }
                        }
                        H = DelegatableNodeKt.h(mutableVector);
                    }
                }
                if ((nodeK.getAggregateChildKindSet$ui_release() & iA) == 0) {
                    return;
                }
            }
        }
    }

    public final MeasurePassDelegate n0() {
        return this.J.w();
    }

    public final void n1(int i3, int i4, int i5) {
        if (i3 == i4) {
            return;
        }
        for (int i6 = 0; i6 < i5; i6++) {
            this.f27369m.a(i3 > i4 ? i4 + i6 : (i4 + i5) - 2, (LayoutNode) this.f27369m.d(i3 > i4 ? i3 + i6 : i3));
        }
        q1();
        T0();
        P0();
    }

    public final boolean o0() {
        return this.J.x();
    }

    public MeasurePolicy p0() {
        return this.f27382z;
    }

    public final UsageByParent q0() {
        return n0().b2();
    }

    public final void q1() {
        if (!this.f27358a) {
            this.f27381y = true;
            return;
        }
        LayoutNode layoutNodeB0 = B0();
        if (layoutNodeB0 != null) {
            layoutNodeB0.q1();
        }
    }

    public final UsageByParent r0() {
        UsageByParent usageByParentR1;
        LookaheadPassDelegate lookaheadPassDelegateK0 = k0();
        return (lookaheadPassDelegateK0 == null || (usageByParentR1 = lookaheadPassDelegateK0.R1()) == null) ? UsageByParent.f27394c : usageByParentR1;
    }

    public final void r1(int i3, int i4) {
        Placeable.PlacementScope placementScope;
        NodeCoordinator nodeCoordinatorZ;
        if (this.F == UsageByParent.f27394c) {
            C();
        }
        LayoutNode layoutNodeB0 = B0();
        if (layoutNodeB0 == null || (nodeCoordinatorZ = layoutNodeB0.Z()) == null || (placementScope = nodeCoordinatorZ.B1()) == null) {
            placementScope = LayoutNodeKt.b(this).getPlacementScope();
        }
        Placeable.PlacementScope.m(placementScope, n0(), i3, i4, 0.0f, 4, null);
    }

    public Modifier s0() {
        return this.N;
    }

    public final boolean t0() {
        return this.R;
    }

    public final boolean t1(Constraints constraints) {
        if (constraints == null) {
            return false;
        }
        if (this.F == UsageByParent.f27394c) {
            B();
        }
        return n0().A2(constraints.r());
    }

    public String toString() {
        return JvmActuals_jvmKt.a(this, null) + " children: " + O().size() + " measurePolicy: " + p0();
    }

    @Override // androidx.compose.ui.layout.LayoutInfo
    public boolean u() {
        return n0().u();
    }

    public final NodeChain u0() {
        return this.I;
    }

    @Override // androidx.compose.ui.layout.LayoutInfo
    public int v() {
        return this.f27359b;
    }

    public final long v0() {
        return this.f27360c;
    }

    public final void v1() {
        int iO = this.f27369m.c().o();
        while (true) {
            iO--;
            if (-1 >= iO) {
                this.f27369m.b();
                return;
            }
            o1((LayoutNode) this.f27369m.c().f24389a[iO]);
        }
    }

    @Override // androidx.compose.ui.layout.LayoutInfo
    public List w() {
        return this.I.n();
    }

    public final void w1(int i3, int i4) {
        if (!(i4 >= 0)) {
            InlineClassHelperKt.a("count (" + i4 + ") must be greater than 0");
        }
        int i5 = (i4 + i3) - 1;
        if (i3 > i5) {
            return;
        }
        while (true) {
            o1((LayoutNode) this.f27369m.c().f24389a[i5]);
            if (i5 == i3) {
                return;
            } else {
                i5--;
            }
        }
    }

    @Override // androidx.compose.ui.layout.LayoutInfo
    public LayoutCoordinates x() {
        return Z();
    }

    public final NodeCoordinator x0() {
        return this.I.o();
    }

    public final void x1() {
        if (this.F == UsageByParent.f27394c) {
            C();
        }
        n0().B2();
    }

    @Override // androidx.compose.ui.layout.LayoutInfo
    public boolean y() {
        return this.S;
    }

    public final long y0() {
        return this.f27362f;
    }

    public final void y1() {
        if (this.f27379w) {
            return;
        }
        LayoutNodeKt.b(this).r(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void z(androidx.compose.ui.node.Owner r7) {
        /*
            Method dump skipped, instruction units count: 380
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.LayoutNode.z(androidx.compose.ui.node.Owner):void");
    }

    public final boolean z0() {
        return this.f27363g;
    }

    public final void z1(boolean z2) {
        Owner owner;
        if (this.f27358a || (owner = this.f27373q) == null) {
            return;
        }
        owner.d(this, true, z2);
    }

    @Override // androidx.compose.ui.layout.LayoutInfo
    public SemanticsInfo a() {
        return B0();
    }

    public /* synthetic */ LayoutNode(boolean z2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? false : z2, (i4 & 2) != 0 ? SemanticsModifierKt.d() : i3);
    }
}
