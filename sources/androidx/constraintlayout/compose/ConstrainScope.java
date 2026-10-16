package androidx.constraintlayout.compose;

import androidx.compose.foundation.layout.LayoutScopeMarker;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.compose.ConstraintLayoutBaseScope;
import androidx.constraintlayout.compose.Dimension;
import androidx.constraintlayout.core.parser.CLObject;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import io.reactivex.internal.operators.mixed.yrog.FptyjHFU;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ObservableProperty;
import kotlin.reflect.KProperty;

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
/* JADX INFO: loaded from: classes2.dex */
@LayoutScopeMarker
@Metadata
public final class ConstrainScope {
    static final /* synthetic */ KProperty[] C = {Reflection.e(new MutablePropertyReference1Impl(ConstrainScope.class, ViewHierarchyConstants.DIMENSION_WIDTH_KEY, "getWidth()Landroidx/constraintlayout/compose/Dimension;", 0)), Reflection.e(new MutablePropertyReference1Impl(ConstrainScope.class, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "getHeight()Landroidx/constraintlayout/compose/Dimension;", 0)), Reflection.e(new MutablePropertyReference1Impl(ConstrainScope.class, ViewHierarchyConstants.DIMENSION_VISIBILITY_KEY, "getVisibility()Landroidx/constraintlayout/compose/Visibility;", 0)), Reflection.e(new MutablePropertyReference1Impl(ConstrainScope.class, "scaleX", "getScaleX()F", 0)), Reflection.e(new MutablePropertyReference1Impl(ConstrainScope.class, "scaleY", FptyjHFU.boSPjC, 0)), Reflection.e(new MutablePropertyReference1Impl(ConstrainScope.class, "rotationX", "getRotationX()F", 0)), Reflection.e(new MutablePropertyReference1Impl(ConstrainScope.class, "rotationY", "getRotationY()F", 0)), Reflection.e(new MutablePropertyReference1Impl(ConstrainScope.class, "rotationZ", "getRotationZ()F", 0)), Reflection.e(new MutablePropertyReference1Impl(ConstrainScope.class, "translationX", "getTranslationX-D9Ej5fM()F", 0)), Reflection.e(new MutablePropertyReference1Impl(ConstrainScope.class, "translationY", "getTranslationY-D9Ej5fM()F", 0)), Reflection.e(new MutablePropertyReference1Impl(ConstrainScope.class, "translationZ", "getTranslationZ-D9Ej5fM()F", 0)), Reflection.e(new MutablePropertyReference1Impl(ConstrainScope.class, "pivotX", "getPivotX()F", 0)), Reflection.e(new MutablePropertyReference1Impl(ConstrainScope.class, "pivotY", "getPivotY()F", 0)), Reflection.e(new MutablePropertyReference1Impl(ConstrainScope.class, "horizontalChainWeight", "getHorizontalChainWeight()F", 0)), Reflection.e(new MutablePropertyReference1Impl(ConstrainScope.class, "verticalChainWeight", "getVerticalChainWeight()F", 0))};
    private float A;
    private float B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f30381a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CLObject f30382b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ConstrainedLayoutReference f30383c = new ConstrainedLayoutReference("parent");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final VerticalAnchorable f30384d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final VerticalAnchorable f30385e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final HorizontalAnchorable f30386f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final VerticalAnchorable f30387g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final VerticalAnchorable f30388h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final HorizontalAnchorable f30389i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final BaselineAnchorable f30390j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final DimensionProperty f30391k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final DimensionProperty f30392l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final ConstrainScope$visibility$2 f30393m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private float f30394n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final FloatProperty f30395o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final FloatProperty f30396p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final FloatProperty f30397q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final FloatProperty f30398r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final FloatProperty f30399s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final DpProperty f30400t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final DpProperty f30401u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final DpProperty f30402v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final FloatProperty f30403w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final FloatProperty f30404x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final FloatProperty f30405y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final FloatProperty f30406z;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    @Metadata
    private final class DimensionProperty extends ObservableProperty<Dimension> {
        public DimensionProperty(Dimension dimension) {
            super(dimension);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // kotlin.properties.ObservableProperty
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(KProperty kProperty, Dimension dimension, Dimension dimension2) {
            CLObject cLObjectD = ConstrainScope.this.d();
            String name = kProperty.getName();
            Intrinsics.checkNotNull(dimension2, "null cannot be cast to non-null type androidx.constraintlayout.compose.DimensionDescription");
            cLObjectD.W(name, ((DimensionDescription) dimension2).a());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    @Metadata
    private final class DpProperty extends ObservableProperty<Dp> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f30408b;

        public /* synthetic */ DpProperty(ConstrainScope constrainScope, float f3, String str, DefaultConstructorMarker defaultConstructorMarker) {
            this(f3, str);
        }

        @Override // kotlin.properties.ObservableProperty
        public /* bridge */ /* synthetic */ void c(KProperty kProperty, Object obj, Object obj2) {
            e(kProperty, ((Dp) obj).l(), ((Dp) obj2).l());
        }

        protected void e(KProperty kProperty, float f3, float f4) {
            if (Float.isNaN(f4)) {
                return;
            }
            CLObject cLObjectD = ConstrainScope.this.d();
            String name = this.f30408b;
            if (name == null) {
                name = kProperty.getName();
            }
            cLObjectD.X(name, f4);
        }

        private DpProperty(float f3, String str) {
            super(Dp.d(f3));
            this.f30408b = str;
        }

        public /* synthetic */ DpProperty(ConstrainScope constrainScope, float f3, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(constrainScope, f3, (i3 & 2) != 0 ? null : str, null);
        }
    }

    /* JADX WARN: Type inference failed for: r15v3, types: [androidx.constraintlayout.compose.ConstrainScope$visibility$2] */
    public ConstrainScope(Object obj, CLObject cLObject) {
        this.f30381a = obj;
        this.f30382b = cLObject;
        this.f30384d = new ConstraintVerticalAnchorable(-2, cLObject);
        this.f30385e = new ConstraintVerticalAnchorable(0, cLObject);
        this.f30386f = new ConstraintHorizontalAnchorable(0, cLObject);
        this.f30387g = new ConstraintVerticalAnchorable(-1, cLObject);
        this.f30388h = new ConstraintVerticalAnchorable(1, cLObject);
        this.f30389i = new ConstraintHorizontalAnchorable(1, cLObject);
        this.f30390j = new ConstraintBaselineAnchorable(cLObject);
        Dimension.Companion companion = Dimension.f30535a;
        this.f30391k = new DimensionProperty(companion.c());
        this.f30392l = new DimensionProperty(companion.c());
        final Visibility visibilityA = Visibility.f31002b.a();
        this.f30393m = new ObservableProperty<Visibility>(visibilityA) { // from class: androidx.constraintlayout.compose.ConstrainScope$visibility$2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // kotlin.properties.ObservableProperty
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void c(KProperty kProperty, Visibility visibility, Visibility visibility2) {
                this.f30412b.d().Y(kProperty.getName(), visibility2.b());
            }
        };
        this.f30394n = 1.0f;
        this.f30395o = new FloatProperty(this, 1.0f, null, 2, null);
        int i3 = 2;
        DefaultConstructorMarker defaultConstructorMarker = null;
        String str = null;
        this.f30396p = new FloatProperty(this, 1.0f, str, i3, defaultConstructorMarker);
        float f3 = 0.0f;
        this.f30397q = new FloatProperty(this, f3, str, i3, defaultConstructorMarker);
        this.f30398r = new FloatProperty(this, f3, str, i3, defaultConstructorMarker);
        this.f30399s = new FloatProperty(this, f3, str, i3, defaultConstructorMarker);
        float f4 = 0;
        this.f30400t = new DpProperty(this, Dp.g(f4), str, i3, defaultConstructorMarker);
        this.f30401u = new DpProperty(this, Dp.g(f4), str, i3, defaultConstructorMarker);
        this.f30402v = new DpProperty(this, Dp.g(f4), str, i3, defaultConstructorMarker);
        float f5 = 0.5f;
        this.f30403w = new FloatProperty(this, f5, str, i3, defaultConstructorMarker);
        this.f30404x = new FloatProperty(this, f5, str, i3, defaultConstructorMarker);
        this.f30405y = new FloatProperty(Float.NaN, "hWeight");
        this.f30406z = new FloatProperty(Float.NaN, "vWeight");
        this.A = 0.5f;
        this.B = 0.5f;
    }

    public static /* synthetic */ void b(ConstrainScope constrainScope, ConstrainedLayoutReference constrainedLayoutReference, float f3, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            f3 = 0.5f;
        }
        constrainScope.a(constrainedLayoutReference, f3);
    }

    public static /* synthetic */ void j(ConstrainScope constrainScope, ConstraintLayoutBaseScope.HorizontalAnchor horizontalAnchor, ConstraintLayoutBaseScope.HorizontalAnchor horizontalAnchor2, float f3, float f4, float f5, float f6, float f7, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            f3 = Dp.g(0);
        }
        float f8 = f3;
        if ((i3 & 8) != 0) {
            f4 = Dp.g(0);
        }
        float f9 = f4;
        if ((i3 & 16) != 0) {
            f5 = Dp.g(0);
        }
        constrainScope.i(horizontalAnchor, horizontalAnchor2, f8, f9, f5, (i3 & 32) != 0 ? Dp.g(0) : f6, (i3 & 64) != 0 ? 0.5f : f7);
    }

    public final void a(ConstrainedLayoutReference constrainedLayoutReference, float f3) {
        j(this, constrainedLayoutReference.e(), constrainedLayoutReference.b(), 0.0f, 0.0f, 0.0f, 0.0f, f3, 60, null);
    }

    public final HorizontalAnchorable c() {
        return this.f30389i;
    }

    public final CLObject d() {
        return this.f30382b;
    }

    public final VerticalAnchorable e() {
        return this.f30387g;
    }

    public final ConstrainedLayoutReference f() {
        return this.f30383c;
    }

    public final VerticalAnchorable g() {
        return this.f30384d;
    }

    public final HorizontalAnchorable h() {
        return this.f30386f;
    }

    public final void i(ConstraintLayoutBaseScope.HorizontalAnchor horizontalAnchor, ConstraintLayoutBaseScope.HorizontalAnchor horizontalAnchor2, float f3, float f4, float f5, float f6, float f7) {
        this.f30386f.b(horizontalAnchor, f3, f5);
        this.f30389i.b(horizontalAnchor2, f4, f6);
        this.f30382b.X("vBias", f7);
    }

    public final void k(Dimension dimension) {
        this.f30392l.b(this, C[1], dimension);
    }

    public final void l(float f3) {
        this.A = f3;
        if (Float.isNaN(f3)) {
            return;
        }
        this.f30382b.X("hBias", f3);
    }

    public final void m(Dimension dimension) {
        this.f30391k.b(this, C[0], dimension);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    @Metadata
    private final class FloatProperty extends ObservableProperty<Float> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f30410b;

        public FloatProperty(float f3, String str) {
            super(Float.valueOf(f3));
            this.f30410b = str;
        }

        @Override // kotlin.properties.ObservableProperty
        public /* bridge */ /* synthetic */ void c(KProperty kProperty, Object obj, Object obj2) {
            e(kProperty, ((Number) obj).floatValue(), ((Number) obj2).floatValue());
        }

        protected void e(KProperty kProperty, float f3, float f4) {
            if (Float.isNaN(f4)) {
                return;
            }
            CLObject cLObjectD = ConstrainScope.this.d();
            String name = this.f30410b;
            if (name == null) {
                name = kProperty.getName();
            }
            cLObjectD.X(name, f4);
        }

        public /* synthetic */ FloatProperty(ConstrainScope constrainScope, float f3, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(f3, (i3 & 2) != 0 ? null : str);
        }
    }
}
