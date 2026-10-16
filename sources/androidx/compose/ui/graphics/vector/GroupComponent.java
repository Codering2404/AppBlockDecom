package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawTransform;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

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
public final class GroupComponent extends VNode {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float[] f26304b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f26305c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f26306d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f26307e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private List f26308f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f26309g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Path f26310h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Function1 f26311i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Function1 f26312j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f26313k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private float f26314l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private float f26315m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private float f26316n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private float f26317o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private float f26318p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private float f26319q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private float f26320r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f26321s;

    public GroupComponent() {
        super(null);
        this.f26305c = new ArrayList();
        this.f26306d = true;
        this.f26307e = Color.f25715b.k();
        this.f26308f = VectorKt.e();
        this.f26309g = true;
        this.f26312j = new Function1<VNode, Unit>() { // from class: androidx.compose.ui.graphics.vector.GroupComponent$wrappedListener$1
            {
                super(1);
            }

            public final void c(VNode vNode) {
                this.f26322a.n(vNode);
                Function1 function1B = this.f26322a.b();
                if (function1B != null) {
                    function1B.invoke(vNode);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c((VNode) obj);
                return Unit.f139807a;
            }
        };
        this.f26313k = "";
        this.f26317o = 1.0f;
        this.f26318p = 1.0f;
        this.f26321s = true;
    }

    private final void A() {
        float[] fArrC = this.f26304b;
        if (fArrC == null) {
            fArrC = Matrix.c(null, 1, null);
            this.f26304b = fArrC;
        } else {
            Matrix.h(fArrC);
        }
        float[] fArr = fArrC;
        Matrix.o(fArr, this.f26315m + this.f26319q, this.f26316n + this.f26320r, 0.0f, 4, null);
        Matrix.j(fArr, this.f26314l);
        Matrix.k(fArr, this.f26317o, this.f26318p, 1.0f);
        Matrix.o(fArr, -this.f26315m, -this.f26316n, 0.0f, 4, null);
    }

    private final boolean h() {
        return !this.f26308f.isEmpty();
    }

    private final void k() {
        this.f26306d = false;
        this.f26307e = Color.f25715b.k();
    }

    private final void l(Brush brush) {
        if (this.f26306d && brush != null) {
            if (brush instanceof SolidColor) {
                m(((SolidColor) brush).a());
            } else {
                k();
            }
        }
    }

    private final void m(long j3) {
        if (this.f26306d && j3 != 16) {
            long j4 = this.f26307e;
            if (j4 == 16) {
                this.f26307e = j3;
            } else {
                if (VectorKt.f(j4, j3)) {
                    return;
                }
                k();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(VNode vNode) {
        if (vNode instanceof PathComponent) {
            PathComponent pathComponent = (PathComponent) vNode;
            l(pathComponent.e());
            l(pathComponent.g());
        } else if (vNode instanceof GroupComponent) {
            GroupComponent groupComponent = (GroupComponent) vNode;
            if (groupComponent.f26306d && this.f26306d) {
                m(groupComponent.f26307e);
            } else {
                k();
            }
        }
    }

    private final void z() {
        if (h()) {
            Path pathA = this.f26310h;
            if (pathA == null) {
                pathA = AndroidPath_androidKt.a();
                this.f26310h = pathA;
            }
            PathParserKt.c(this.f26308f, pathA);
        }
    }

    @Override // androidx.compose.ui.graphics.vector.VNode
    public void a(DrawScope drawScope) {
        if (this.f26321s) {
            A();
            this.f26321s = false;
        }
        if (this.f26309g) {
            z();
            this.f26309g = false;
        }
        DrawContext drawContextQ1 = drawScope.Q1();
        long jB = drawContextQ1.b();
        drawContextQ1.g().t();
        try {
            DrawTransform drawTransformE = drawContextQ1.e();
            float[] fArr = this.f26304b;
            if (fArr != null) {
                drawTransformE.a(Matrix.a(fArr).p());
            }
            Path path = this.f26310h;
            if (h() && path != null) {
                DrawTransform.g(drawTransformE, path, 0, 2, null);
            }
            List list = this.f26305c;
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                ((VNode) list.get(i3)).a(drawScope);
            }
            drawContextQ1.g().k();
            drawContextQ1.h(jB);
        } catch (Throwable th) {
            drawContextQ1.g().k();
            drawContextQ1.h(jB);
            throw th;
        }
    }

    @Override // androidx.compose.ui.graphics.vector.VNode
    public Function1 b() {
        return this.f26311i;
    }

    @Override // androidx.compose.ui.graphics.vector.VNode
    public void d(Function1 function1) {
        this.f26311i = function1;
    }

    public final int f() {
        return this.f26305c.size();
    }

    public final long g() {
        return this.f26307e;
    }

    public final void i(int i3, VNode vNode) {
        if (i3 < f()) {
            this.f26305c.set(i3, vNode);
        } else {
            this.f26305c.add(vNode);
        }
        n(vNode);
        vNode.d(this.f26312j);
        c();
    }

    public final boolean j() {
        return this.f26306d;
    }

    public final void o(int i3, int i4, int i5) {
        int i6 = 0;
        if (i3 > i4) {
            while (i6 < i5) {
                VNode vNode = (VNode) this.f26305c.get(i3);
                this.f26305c.remove(i3);
                this.f26305c.add(i4, vNode);
                i4++;
                i6++;
            }
        } else {
            while (i6 < i5) {
                VNode vNode2 = (VNode) this.f26305c.get(i3);
                this.f26305c.remove(i3);
                this.f26305c.add(i4 - 1, vNode2);
                i6++;
            }
        }
        c();
    }

    public final void p(int i3, int i4) {
        for (int i5 = 0; i5 < i4; i5++) {
            if (i3 < this.f26305c.size()) {
                ((VNode) this.f26305c.get(i3)).d(null);
                this.f26305c.remove(i3);
            }
        }
        c();
    }

    public final void q(List list) {
        this.f26308f = list;
        this.f26309g = true;
        c();
    }

    public final void r(String str) {
        this.f26313k = str;
        c();
    }

    public final void s(float f3) {
        this.f26315m = f3;
        this.f26321s = true;
        c();
    }

    public final void t(float f3) {
        this.f26316n = f3;
        this.f26321s = true;
        c();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("VGroup: ");
        sb.append(this.f26313k);
        List list = this.f26305c;
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            VNode vNode = (VNode) list.get(i3);
            sb.append("\t");
            sb.append(vNode.toString());
            sb.append("\n");
        }
        return sb.toString();
    }

    public final void u(float f3) {
        this.f26314l = f3;
        this.f26321s = true;
        c();
    }

    public final void v(float f3) {
        this.f26317o = f3;
        this.f26321s = true;
        c();
    }

    public final void w(float f3) {
        this.f26318p = f3;
        this.f26321s = true;
        c();
    }

    public final void x(float f3) {
        this.f26319q = f3;
        this.f26321s = true;
        c();
    }

    public final void y(float f3) {
        this.f26320r = f3;
        this.f26321s = true;
        c();
    }
}
