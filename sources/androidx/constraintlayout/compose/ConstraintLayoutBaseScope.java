package androidx.constraintlayout.compose;

import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.core.parser.CLArray;
import androidx.constraintlayout.core.parser.CLObject;
import androidx.constraintlayout.core.parser.CLString;
import androidx.constraintlayout.core.state.ConstraintSetParser;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

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
public abstract class ConstraintLayoutBaseScope {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f30422a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CLObject f30423b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f30424c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f30425d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f30426e;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class BaselineAnchor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object f30427a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final LayoutReference f30428b;

        public BaselineAnchor(Object obj, LayoutReference layoutReference) {
            this.f30427a = obj;
            this.f30428b = layoutReference;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof BaselineAnchor)) {
                return false;
            }
            BaselineAnchor baselineAnchor = (BaselineAnchor) obj;
            return Intrinsics.areEqual(this.f30427a, baselineAnchor.f30427a) && Intrinsics.areEqual(this.f30428b, baselineAnchor.f30428b);
        }

        public int hashCode() {
            return (this.f30427a.hashCode() * 31) + this.f30428b.hashCode();
        }

        public String toString() {
            return "BaselineAnchor(id=" + this.f30427a + ", reference=" + this.f30428b + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class HorizontalAnchor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object f30429a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f30430b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final LayoutReference f30431c;

        public HorizontalAnchor(Object obj, int i3, LayoutReference layoutReference) {
            this.f30429a = obj;
            this.f30430b = i3;
            this.f30431c = layoutReference;
        }

        public final Object a() {
            return this.f30429a;
        }

        public final int b() {
            return this.f30430b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof HorizontalAnchor)) {
                return false;
            }
            HorizontalAnchor horizontalAnchor = (HorizontalAnchor) obj;
            return Intrinsics.areEqual(this.f30429a, horizontalAnchor.f30429a) && this.f30430b == horizontalAnchor.f30430b && Intrinsics.areEqual(this.f30431c, horizontalAnchor.f30431c);
        }

        public int hashCode() {
            return (((this.f30429a.hashCode() * 31) + Integer.hashCode(this.f30430b)) * 31) + this.f30431c.hashCode();
        }

        public String toString() {
            return "HorizontalAnchor(id=" + this.f30429a + ", index=" + this.f30430b + ", reference=" + this.f30431c + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class VerticalAnchor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object f30432a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f30433b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final LayoutReference f30434c;

        public VerticalAnchor(Object obj, int i3, LayoutReference layoutReference) {
            this.f30432a = obj;
            this.f30433b = i3;
            this.f30434c = layoutReference;
        }

        public final Object a() {
            return this.f30432a;
        }

        public final int b() {
            return this.f30433b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof VerticalAnchor)) {
                return false;
            }
            VerticalAnchor verticalAnchor = (VerticalAnchor) obj;
            return Intrinsics.areEqual(this.f30432a, verticalAnchor.f30432a) && this.f30433b == verticalAnchor.f30433b && Intrinsics.areEqual(this.f30434c, verticalAnchor.f30434c);
        }

        public int hashCode() {
            return (((this.f30432a.hashCode() * 31) + Integer.hashCode(this.f30433b)) * 31) + this.f30434c.hashCode();
        }

        public String toString() {
            return "VerticalAnchor(id=" + this.f30432a + ", index=" + this.f30433b + ", reference=" + this.f30434c + ')';
        }
    }

    public ConstraintLayoutBaseScope(CLObject cLObject) {
        CLObject cLObjectA;
        this.f30423b = (cLObject == null || (cLObjectA = cLObject.a()) == null) ? new CLObject(new char[0]) : cLObjectA;
        this.f30425d = 1000;
        this.f30426e = 1000;
    }

    public static /* synthetic */ HorizontalAnchor d(ConstraintLayoutBaseScope constraintLayoutBaseScope, LayoutReference[] layoutReferenceArr, float f3, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createBottomBarrier-3ABfNKs");
        }
        if ((i3 & 2) != 0) {
            f3 = Dp.g(0);
        }
        return constraintLayoutBaseScope.c(layoutReferenceArr, f3);
    }

    private final int g() {
        int i3 = this.f30426e;
        this.f30426e = i3 + 1;
        return i3;
    }

    private final void k(int i3) {
        this.f30424c = ((this.f30424c * 1009) + i3) % 1000000007;
    }

    public final void a(State state) {
        ConstraintSetParser.C(this.f30423b, state, new ConstraintSetParser.LayoutVariables());
    }

    public final CLObject b(LayoutReference layoutReference) {
        String string = layoutReference.a().toString();
        if (this.f30423b.M(string) == null) {
            this.f30423b.W(string, new CLObject(new char[0]));
        }
        return this.f30423b.L(string);
    }

    public final HorizontalAnchor c(LayoutReference[] layoutReferenceArr, float f3) {
        LayoutReferenceImpl layoutReferenceImpl = new LayoutReferenceImpl(Integer.valueOf(g()));
        CLArray cLArray = new CLArray(new char[0]);
        for (LayoutReference layoutReference : layoutReferenceArr) {
            cLArray.z(CLString.A(layoutReference.a().toString()));
        }
        CLObject cLObjectB = b(layoutReferenceImpl);
        cLObjectB.Y("type", "barrier");
        cLObjectB.Y("direction", "bottom");
        cLObjectB.X("margin", f3);
        cLObjectB.W("contains", cLArray);
        k(15);
        for (LayoutReference layoutReference2 : layoutReferenceArr) {
            k(layoutReference2.hashCode());
        }
        k(Dp.j(f3));
        return new HorizontalAnchor(layoutReferenceImpl.a(), 0, layoutReferenceImpl);
    }

    public final VerticalAnchor e(LayoutReference[] layoutReferenceArr, float f3) {
        LayoutReferenceImpl layoutReferenceImpl = new LayoutReferenceImpl(Integer.valueOf(g()));
        CLArray cLArray = new CLArray(new char[0]);
        for (LayoutReference layoutReference : layoutReferenceArr) {
            cLArray.z(CLString.A(layoutReference.a().toString()));
        }
        CLObject cLObjectB = b(layoutReferenceImpl);
        cLObjectB.Y("type", "barrier");
        cLObjectB.Y("direction", "end");
        cLObjectB.X("margin", f3);
        cLObjectB.W("contains", cLArray);
        k(13);
        for (LayoutReference layoutReference2 : layoutReferenceArr) {
            k(layoutReference2.hashCode());
        }
        k(Dp.j(f3));
        return new VerticalAnchor(layoutReferenceImpl.a(), 0, layoutReferenceImpl);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ConstraintLayoutBaseScope) {
            return Intrinsics.areEqual(this.f30423b, ((ConstraintLayoutBaseScope) obj).f30423b);
        }
        return false;
    }

    public final HorizontalAnchor f(float f3) {
        LayoutReferenceImpl layoutReferenceImpl = new LayoutReferenceImpl(Integer.valueOf(g()));
        CLObject cLObjectB = b(layoutReferenceImpl);
        cLObjectB.Y("type", "hGuideline");
        cLObjectB.X("start", f3);
        k(7);
        k(Dp.j(f3));
        return new HorizontalAnchor(layoutReferenceImpl.a(), 0, layoutReferenceImpl);
    }

    public final CLObject h() {
        return this.f30423b;
    }

    public int hashCode() {
        return this.f30423b.hashCode();
    }

    public final int i() {
        return this.f30424c;
    }

    public void j() {
        this.f30423b.clear();
        this.f30426e = this.f30425d;
        this.f30424c = 0;
    }
}
