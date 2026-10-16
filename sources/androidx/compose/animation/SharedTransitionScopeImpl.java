package androidx.compose.animation;

import androidx.collection.MutableScatterMap;
import androidx.compose.animation.SharedTransitionScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.OutlineKt;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LookaheadScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.Comparator;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
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
public final class SharedTransitionScopeImpl implements SharedTransitionScope, LookaheadScope {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Companion f3650l = new Companion(null);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final Lazy f3651m = LazyKt.a(LazyThreadSafetyMode.f139763c, new Function0<SnapshotStateObserver>() { // from class: androidx.compose.animation.SharedTransitionScopeImpl$Companion$SharedTransitionObserver$2
        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final SnapshotStateObserver invoke() {
            SnapshotStateObserver snapshotStateObserver = new SnapshotStateObserver(new Function1<Function0<? extends Unit>, Unit>() { // from class: androidx.compose.animation.SharedTransitionScopeImpl$Companion$SharedTransitionObserver$2.1
                public final void c(Function0 function0) {
                    function0.invoke();
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    c((Function0) obj);
                    return Unit.f139807a;
                }
            });
            snapshotStateObserver.t();
            return snapshotStateObserver;
        }
    });

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CoroutineScope f3652a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ LookaheadScope f3653b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f3654c;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public LayoutCoordinates f3658h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private LayoutCoordinates f3659i;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final MutableState f3655d = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Function0 f3656f = new Function0<Unit>() { // from class: androidx.compose.animation.SharedTransitionScopeImpl$observeAnimatingBlock$1
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            m19invoke();
            return Unit.f139807a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m19invoke() {
            MutableScatterMap mutableScatterMap = this.f3666a.f3661k;
            Object[] objArr = mutableScatterMap.f3109b;
            Object[] objArr2 = mutableScatterMap.f3110c;
            long[] jArr = mutableScatterMap.f3108a;
            int length = jArr.length - 2;
            if (length < 0) {
                return;
            }
            int i3 = 0;
            while (true) {
                long j3 = jArr[i3];
                if ((((~j3) << 7) & j3 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i4 = 8 - ((~(i3 - length)) >>> 31);
                    for (int i5 = 0; i5 < i4; i5++) {
                        if ((255 & j3) < 128) {
                            int i6 = (i3 << 3) + i5;
                            Object obj = objArr[i6];
                            if (((SharedElement) objArr2[i6]).l()) {
                                return;
                            }
                        }
                        j3 >>= 8;
                    }
                    if (i4 != 8) {
                        return;
                    }
                }
                if (i3 == length) {
                    return;
                } else {
                    i3++;
                }
            }
        }
    };

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Function1 f3657g = new Function1<SharedTransitionScope, Unit>() { // from class: androidx.compose.animation.SharedTransitionScopeImpl$updateTransitionActiveness$1
        {
            super(1);
        }

        public final void c(SharedTransitionScope sharedTransitionScope) {
            this.f3690a.A();
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            c((SharedTransitionScope) obj);
            return Unit.f139807a;
        }
    };

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final SnapshotStateList f3660j = SnapshotStateKt.f();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final MutableScatterMap f3661k = new MutableScatterMap(0, 1, null);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final SnapshotStateObserver b() {
            return (SnapshotStateObserver) SharedTransitionScopeImpl.f3651m.getValue();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class ShapeBasedClip implements SharedTransitionScope.OverlayClip {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Shape f3664a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Path f3665b;

        @Override // androidx.compose.animation.SharedTransitionScope.OverlayClip
        public Path a(SharedTransitionScope.SharedContentState sharedContentState, Rect rect, LayoutDirection layoutDirection, Density density) {
            this.f3665b.reset();
            OutlineKt.a(this.f3665b, this.f3664a.mo29createOutlinePq9zytI(rect.q(), layoutDirection, density));
            this.f3665b.p(rect.t());
            return this.f3665b;
        }
    }

    public SharedTransitionScopeImpl(LookaheadScope lookaheadScope, CoroutineScope coroutineScope) {
        this.f3652a = coroutineScope;
        this.f3653b = lookaheadScope;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00e8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A() {
        /*
            Method dump skipped, instruction units count: 241
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.SharedTransitionScopeImpl.A():void");
    }

    private final void j() {
        if (this.f3654c) {
            return;
        }
        f3650l.b().p(this, this.f3657g, this.f3656f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SharedElementInternalState s(SharedElement sharedElement, BoundsAnimation boundsAnimation, SharedTransitionScope.PlaceHolderSize placeHolderSize, boolean z2, SharedTransitionScope.SharedContentState sharedContentState, SharedTransitionScope.OverlayClip overlayClip, float f3, boolean z3, Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(2066772852, i3, -1, "androidx.compose.animation.SharedTransitionScopeImpl.rememberSharedElementState (SharedTransitionScope.kt:991)");
        }
        Object objG = composer.G();
        if (objG == Composer.f23746a.a()) {
            objG = new SharedElementInternalState(sharedElement, boundsAnimation, placeHolderSize, z2, overlayClip, z3, sharedContentState, f3);
            composer.w(objG);
        }
        SharedElementInternalState sharedElementInternalState = (SharedElementInternalState) objG;
        sharedContentState.g(sharedElementInternalState);
        sharedElementInternalState.E(sharedElement);
        sharedElementInternalState.D(z2);
        sharedElementInternalState.u(boundsAnimation);
        sharedElementInternalState.B(placeHolderSize);
        sharedElementInternalState.z(overlayClip);
        sharedElementInternalState.G(f3);
        sharedElementInternalState.C(z3);
        sharedElementInternalState.F(sharedContentState);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return sharedElementInternalState;
    }

    private void w(boolean z2) {
        this.f3655d.setValue(Boolean.valueOf(z2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SharedElement y(Object obj) {
        SharedElement sharedElement = (SharedElement) this.f3661k.e(obj);
        if (sharedElement != null) {
            return sharedElement;
        }
        SharedElement sharedElement2 = new SharedElement(obj, this);
        this.f3661k.x(obj, sharedElement2);
        return sharedElement2;
    }

    public final void f(Object obj) {
        f3650l.b().l(obj);
    }

    public final void g(ContentDrawScope contentDrawScope) {
        SnapshotStateList snapshotStateList = this.f3660j;
        if (snapshotStateList.size() > 1) {
            CollectionsKt.sortWith(snapshotStateList, new Comparator() { // from class: androidx.compose.animation.SharedTransitionScopeImpl$drawInOverlay$$inlined$sortBy$1
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    LayerRenderer layerRenderer = (LayerRenderer) obj;
                    LayerRenderer layerRenderer2 = (LayerRenderer) obj2;
                    return ComparisonsKt.d(Float.valueOf((layerRenderer.a() == 0.0f && (layerRenderer instanceof SharedElementInternalState) && ((SharedElementInternalState) layerRenderer).l() == null) ? -1.0f : layerRenderer.a()), Float.valueOf((layerRenderer2.a() == 0.0f && (layerRenderer2 instanceof SharedElementInternalState) && ((SharedElementInternalState) layerRenderer2).l() == null) ? -1.0f : layerRenderer2.a()));
                }
            });
        }
        SnapshotStateList snapshotStateList2 = this.f3660j;
        int size = snapshotStateList2.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((LayerRenderer) snapshotStateList2.get(i3)).b(contentDrawScope);
        }
    }

    public final LayoutCoordinates h() {
        LayoutCoordinates layoutCoordinates = this.f3659i;
        if (layoutCoordinates != null) {
            return layoutCoordinates;
        }
        throw new IllegalArgumentException("Error: Uninitialized LayoutCoordinates. Please make sure when using the SharedTransitionScope composable function, the modifier passed to the child content is being used, or use SharedTransitionLayout instead.");
    }

    public final LayoutCoordinates i() {
        LayoutCoordinates layoutCoordinates = this.f3658h;
        if (layoutCoordinates != null) {
            return layoutCoordinates;
        }
        Intrinsics.throwUninitializedPropertyAccessException("root");
        return null;
    }

    public final void k(SharedElement sharedElement, Function1 function1, Function0 function0) {
        if (this.f3654c) {
            return;
        }
        f3650l.b().p(sharedElement, function1, function0);
    }

    public final void l() {
        f3650l.b().l(this);
        this.f3654c = true;
    }

    public final void n(LayerRenderer layerRenderer) {
        this.f3660j.add(layerRenderer);
    }

    public final void o(LayerRenderer layerRenderer) {
        this.f3660j.remove(layerRenderer);
    }

    @Override // androidx.compose.animation.SharedTransitionScope
    public boolean p() {
        return ((Boolean) this.f3655d.getValue()).booleanValue();
    }

    public final void q(SharedElementInternalState sharedElementInternalState) {
        SharedElement sharedElementP = sharedElementInternalState.p();
        sharedElementP.b(sharedElementInternalState);
        this.f3657g.invoke(this);
        sharedElementP.f().j();
        Iterator<T> it = this.f3660j.iterator();
        int i3 = 0;
        while (true) {
            if (!it.hasNext()) {
                i3 = -1;
                break;
            }
            LayerRenderer layerRenderer = (LayerRenderer) it.next();
            SharedElementInternalState sharedElementInternalState2 = layerRenderer instanceof SharedElementInternalState ? (SharedElementInternalState) layerRenderer : null;
            if (Intrinsics.areEqual(sharedElementInternalState2 != null ? sharedElementInternalState2.p() : null, sharedElementInternalState.p())) {
                break;
            } else {
                i3++;
            }
        }
        if (i3 == this.f3660j.size() - 1 || i3 == -1) {
            this.f3660j.add(sharedElementInternalState);
        } else {
            this.f3660j.add(i3 + 1, sharedElementInternalState);
        }
    }

    public final void r(SharedElementInternalState sharedElementInternalState) {
        SharedElement sharedElementP = sharedElementInternalState.p();
        sharedElementP.o(sharedElementInternalState);
        this.f3657g.invoke(this);
        sharedElementP.f().j();
        this.f3660j.remove(sharedElementInternalState);
        if (sharedElementP.g().isEmpty()) {
            BuildersKt__Builders_commonKt.d(sharedElementP.f().f3652a, null, null, new SharedTransitionScopeImpl$onStateRemoved$1$1(sharedElementP, null), 3, null);
        }
    }

    public final void t(LayoutCoordinates layoutCoordinates) {
        this.f3659i = layoutCoordinates;
    }

    @Override // androidx.compose.ui.layout.LookaheadScope
    public long u(LayoutCoordinates layoutCoordinates, LayoutCoordinates layoutCoordinates2, long j3, boolean z2) {
        return this.f3653b.u(layoutCoordinates, layoutCoordinates2, j3, z2);
    }

    public final void v(LayoutCoordinates layoutCoordinates) {
        this.f3658h = layoutCoordinates;
    }

    @Override // androidx.compose.ui.layout.LookaheadScope
    public LayoutCoordinates x(LayoutCoordinates layoutCoordinates) {
        return this.f3653b.x(layoutCoordinates);
    }

    @Override // androidx.compose.ui.layout.LookaheadScope
    public LayoutCoordinates z(Placeable.PlacementScope placementScope) {
        return this.f3653b.z(placementScope);
    }
}
