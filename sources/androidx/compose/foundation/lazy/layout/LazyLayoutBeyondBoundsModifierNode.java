package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsInfo;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.BeyondBoundsLayout;
import androidx.compose.ui.layout.BeyondBoundsLayoutKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.modifier.ModifierLocalMap;
import androidx.compose.ui.modifier.ModifierLocalModifierNode;
import androidx.compose.ui.modifier.ModifierLocalModifierNodeKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.LayoutModifierNodeKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;

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
public final class LazyLayoutBeyondBoundsModifierNode extends Modifier.Node implements ModifierLocalModifierNode, BeyondBoundsLayout, LayoutModifierNode {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Companion f8008f = new Companion(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f8009g = 8;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final LazyLayoutBeyondBoundsModifierNode$Companion$emptyBeyondBoundsScope$1 f8010h = new BeyondBoundsLayout.BeyondBoundsScope() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsModifierNode$Companion$emptyBeyondBoundsScope$1

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f8015a;

        @Override // androidx.compose.ui.layout.BeyondBoundsLayout.BeyondBoundsScope
        public boolean a() {
            return this.f8015a;
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LazyLayoutBeyondBoundsState f8011a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private LazyLayoutBeyondBoundsInfo f8012b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f8013c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Orientation f8014d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f8016a;

        static {
            int[] iArr = new int[LayoutDirection.values().length];
            try {
                iArr[LayoutDirection.f30001a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LayoutDirection.f30002b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f8016a = iArr;
        }
    }

    public LazyLayoutBeyondBoundsModifierNode(LazyLayoutBeyondBoundsState lazyLayoutBeyondBoundsState, LazyLayoutBeyondBoundsInfo lazyLayoutBeyondBoundsInfo, boolean z2, Orientation orientation) {
        this.f8011a = lazyLayoutBeyondBoundsState;
        this.f8012b = lazyLayoutBeyondBoundsInfo;
        this.f8013c = z2;
        this.f8014d = orientation;
    }

    private final LazyLayoutBeyondBoundsInfo.Interval n2(LazyLayoutBeyondBoundsInfo.Interval interval, int i3) {
        int iB = interval.b();
        int iA = interval.a();
        if (p2(i3)) {
            iA++;
        } else {
            iB--;
        }
        return this.f8012b.a(iB, iA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean o2(LazyLayoutBeyondBoundsInfo.Interval interval, int i3) {
        if (q2(i3)) {
            return false;
        }
        return p2(i3) ? interval.a() < this.f8011a.a() - 1 : interval.b() > 0;
    }

    private final boolean p2(int i3) {
        BeyondBoundsLayout.LayoutDirection.Companion companion = BeyondBoundsLayout.LayoutDirection.f27041b;
        if (BeyondBoundsLayout.LayoutDirection.i(i3, companion.c())) {
            return false;
        }
        if (BeyondBoundsLayout.LayoutDirection.i(i3, companion.b())) {
            return true;
        }
        if (BeyondBoundsLayout.LayoutDirection.i(i3, companion.a())) {
            return this.f8013c;
        }
        if (BeyondBoundsLayout.LayoutDirection.i(i3, companion.d())) {
            return !this.f8013c;
        }
        if (BeyondBoundsLayout.LayoutDirection.i(i3, companion.e())) {
            int i4 = WhenMappings.f8016a[DelegatableNodeKt.n(this).ordinal()];
            if (i4 == 1) {
                return this.f8013c;
            }
            if (i4 == 2) {
                return !this.f8013c;
            }
            throw new NoWhenBranchMatchedException();
        }
        if (!BeyondBoundsLayout.LayoutDirection.i(i3, companion.f())) {
            LazyLayoutBeyondBoundsModifierLocalKt.c();
            throw new KotlinNothingValueException();
        }
        int i5 = WhenMappings.f8016a[DelegatableNodeKt.n(this).ordinal()];
        if (i5 == 1) {
            return !this.f8013c;
        }
        if (i5 == 2) {
            return this.f8013c;
        }
        throw new NoWhenBranchMatchedException();
    }

    private final boolean q2(int i3) {
        BeyondBoundsLayout.LayoutDirection.Companion companion = BeyondBoundsLayout.LayoutDirection.f27041b;
        if (BeyondBoundsLayout.LayoutDirection.i(i3, companion.a()) ? true : BeyondBoundsLayout.LayoutDirection.i(i3, companion.d())) {
            return this.f8014d == Orientation.f6032b;
        }
        if (BeyondBoundsLayout.LayoutDirection.i(i3, companion.e()) ? true : BeyondBoundsLayout.LayoutDirection.i(i3, companion.f())) {
            return this.f8014d == Orientation.f6031a;
        }
        if (BeyondBoundsLayout.LayoutDirection.i(i3, companion.c()) ? true : BeyondBoundsLayout.LayoutDirection.i(i3, companion.b())) {
            return false;
        }
        LazyLayoutBeyondBoundsModifierLocalKt.c();
        throw new KotlinNothingValueException();
    }

    @Override // androidx.compose.ui.layout.BeyondBoundsLayout
    public Object i0(final int i3, Function1 function1) {
        if (this.f8011a.a() <= 0 || !this.f8011a.c() || !isAttached()) {
            return function1.invoke(f8010h);
        }
        int iE = p2(i3) ? this.f8011a.e() : this.f8011a.d();
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.f140144a = this.f8012b.a(iE, iE);
        int iK = RangesKt.k(this.f8011a.b() * 2, this.f8011a.a());
        Object objInvoke = null;
        int i4 = 0;
        while (objInvoke == null && o2((LazyLayoutBeyondBoundsInfo.Interval) objectRef.f140144a, i3) && i4 < iK) {
            LazyLayoutBeyondBoundsInfo.Interval intervalN2 = n2((LazyLayoutBeyondBoundsInfo.Interval) objectRef.f140144a, i3);
            this.f8012b.e((LazyLayoutBeyondBoundsInfo.Interval) objectRef.f140144a);
            objectRef.f140144a = intervalN2;
            i4++;
            LayoutModifierNodeKt.d(this);
            objInvoke = function1.invoke(new BeyondBoundsLayout.BeyondBoundsScope() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsModifierNode$layout$2
                @Override // androidx.compose.ui.layout.BeyondBoundsLayout.BeyondBoundsScope
                public boolean a() {
                    return this.f8017a.o2((LazyLayoutBeyondBoundsInfo.Interval) objectRef.f140144a, i3);
                }
            });
        }
        this.f8012b.e((LazyLayoutBeyondBoundsInfo.Interval) objectRef.f140144a);
        LayoutModifierNodeKt.d(this);
        return objInvoke;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo11measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j3) {
        final Placeable placeableN0 = measurable.n0(j3);
        return MeasureScope.B0(measureScope, placeableN0.X0(), placeableN0.O0(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsModifierNode$measure$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Placeable.PlacementScope) obj);
                return Unit.f139807a;
            }

            public final void invoke(Placeable.PlacementScope placementScope) {
                Placeable.PlacementScope.i(placementScope, placeableN0, 0, 0, 0.0f, 4, null);
            }
        }, 4, null);
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalModifierNode
    public ModifierLocalMap n0() {
        return ModifierLocalModifierNodeKt.b(TuplesKt.a(BeyondBoundsLayoutKt.a(), this));
    }

    public final void r2(LazyLayoutBeyondBoundsState lazyLayoutBeyondBoundsState, LazyLayoutBeyondBoundsInfo lazyLayoutBeyondBoundsInfo, boolean z2, Orientation orientation) {
        this.f8011a = lazyLayoutBeyondBoundsState;
        this.f8012b = lazyLayoutBeyondBoundsInfo;
        this.f8013c = z2;
        this.f8014d = orientation;
    }
}
