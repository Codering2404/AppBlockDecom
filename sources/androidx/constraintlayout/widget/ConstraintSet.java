package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.HelperWidget;
import androidx.constraintlayout.motion.widget.Debug;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Constraints;
import androidx.constraintlayout.widget.R;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.ads_identifier.mrU.pMpIcGE;
import com.revenuecat.purchases.ui.revenuecatui.templates.VWmQ.cJfnYMIyomoWf;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes2.dex */
public class ConstraintSet {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int[] f33181h = {0, 4, 8};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static SparseIntArray f33182i = new SparseIntArray();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static SparseIntArray f33183j = new SparseIntArray();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f33184a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f33185b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f33186c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f33187d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private HashMap f33188e = new HashMap();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f33189f = true;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private HashMap f33190g = new HashMap();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    public static class Constraint {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f33191a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f33192b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final PropertySet f33193c = new PropertySet();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Motion f33194d = new Motion();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Layout f33195e = new Layout();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Transform f33196f = new Transform();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public HashMap f33197g = new HashMap();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        Delta f33198h;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        static class Delta {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int[] f33199a = new int[10];

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            int[] f33200b = new int[10];

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            int f33201c = 0;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            int[] f33202d = new int[10];

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            float[] f33203e = new float[10];

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            int f33204f = 0;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            int[] f33205g = new int[5];

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            String[] f33206h = new String[5];

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            int f33207i = 0;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            int[] f33208j = new int[4];

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            boolean[] f33209k = new boolean[4];

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            int f33210l = 0;

            Delta() {
            }

            void a(int i3, float f3) {
                int i4 = this.f33204f;
                int[] iArr = this.f33202d;
                if (i4 >= iArr.length) {
                    this.f33202d = Arrays.copyOf(iArr, iArr.length * 2);
                    float[] fArr = this.f33203e;
                    this.f33203e = Arrays.copyOf(fArr, fArr.length * 2);
                }
                int[] iArr2 = this.f33202d;
                int i5 = this.f33204f;
                iArr2[i5] = i3;
                float[] fArr2 = this.f33203e;
                this.f33204f = i5 + 1;
                fArr2[i5] = f3;
            }

            void b(int i3, int i4) {
                int i5 = this.f33201c;
                int[] iArr = this.f33199a;
                if (i5 >= iArr.length) {
                    this.f33199a = Arrays.copyOf(iArr, iArr.length * 2);
                    int[] iArr2 = this.f33200b;
                    this.f33200b = Arrays.copyOf(iArr2, iArr2.length * 2);
                }
                int[] iArr3 = this.f33199a;
                int i6 = this.f33201c;
                iArr3[i6] = i3;
                int[] iArr4 = this.f33200b;
                this.f33201c = i6 + 1;
                iArr4[i6] = i4;
            }

            void c(int i3, String str) {
                int i4 = this.f33207i;
                int[] iArr = this.f33205g;
                if (i4 >= iArr.length) {
                    this.f33205g = Arrays.copyOf(iArr, iArr.length * 2);
                    String[] strArr = this.f33206h;
                    this.f33206h = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
                }
                int[] iArr2 = this.f33205g;
                int i5 = this.f33207i;
                iArr2[i5] = i3;
                String[] strArr2 = this.f33206h;
                this.f33207i = i5 + 1;
                strArr2[i5] = str;
            }

            void d(int i3, boolean z2) {
                int i4 = this.f33210l;
                int[] iArr = this.f33208j;
                if (i4 >= iArr.length) {
                    this.f33208j = Arrays.copyOf(iArr, iArr.length * 2);
                    boolean[] zArr = this.f33209k;
                    this.f33209k = Arrays.copyOf(zArr, zArr.length * 2);
                }
                int[] iArr2 = this.f33208j;
                int i5 = this.f33210l;
                iArr2[i5] = i3;
                boolean[] zArr2 = this.f33209k;
                this.f33210l = i5 + 1;
                zArr2[i5] = z2;
            }

            void e(Constraint constraint) {
                for (int i3 = 0; i3 < this.f33201c; i3++) {
                    ConstraintSet.Q(constraint, this.f33199a[i3], this.f33200b[i3]);
                }
                for (int i4 = 0; i4 < this.f33204f; i4++) {
                    ConstraintSet.P(constraint, this.f33202d[i4], this.f33203e[i4]);
                }
                for (int i5 = 0; i5 < this.f33207i; i5++) {
                    ConstraintSet.R(constraint, this.f33205g[i5], this.f33206h[i5]);
                }
                for (int i6 = 0; i6 < this.f33210l; i6++) {
                    ConstraintSet.S(constraint, this.f33208j[i6], this.f33209k[i6]);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void g(int i3, ConstraintLayout.LayoutParams layoutParams) {
            this.f33191a = i3;
            Layout layout = this.f33195e;
            layout.f33230j = layoutParams.f33114e;
            layout.f33232k = layoutParams.f33116f;
            layout.f33234l = layoutParams.f33118g;
            layout.f33236m = layoutParams.f33120h;
            layout.f33238n = layoutParams.f33122i;
            layout.f33240o = layoutParams.f33124j;
            layout.f33242p = layoutParams.f33126k;
            layout.f33244q = layoutParams.f33128l;
            layout.f33246r = layoutParams.f33130m;
            layout.f33247s = layoutParams.f33132n;
            layout.f33248t = layoutParams.f33134o;
            layout.f33249u = layoutParams.f33142s;
            layout.f33250v = layoutParams.f33144t;
            layout.f33251w = layoutParams.f33146u;
            layout.f33252x = layoutParams.f33148v;
            layout.f33253y = layoutParams.G;
            layout.f33254z = layoutParams.H;
            layout.A = layoutParams.I;
            layout.B = layoutParams.f33136p;
            layout.C = layoutParams.f33138q;
            layout.D = layoutParams.f33140r;
            layout.E = layoutParams.X;
            layout.F = layoutParams.Y;
            layout.G = layoutParams.Z;
            layout.f33226h = layoutParams.f33110c;
            layout.f33222f = layoutParams.f33106a;
            layout.f33224g = layoutParams.f33108b;
            layout.f33218d = ((ViewGroup.MarginLayoutParams) layoutParams).width;
            layout.f33220e = ((ViewGroup.MarginLayoutParams) layoutParams).height;
            layout.H = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
            layout.I = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
            layout.J = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
            layout.K = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
            layout.N = layoutParams.D;
            layout.V = layoutParams.M;
            layout.W = layoutParams.L;
            layout.Y = layoutParams.O;
            layout.X = layoutParams.N;
            layout.f33239n0 = layoutParams.f33107a0;
            layout.f33241o0 = layoutParams.f33109b0;
            layout.Z = layoutParams.P;
            layout.f33213a0 = layoutParams.Q;
            layout.f33215b0 = layoutParams.T;
            layout.f33217c0 = layoutParams.U;
            layout.f33219d0 = layoutParams.R;
            layout.f33221e0 = layoutParams.S;
            layout.f33223f0 = layoutParams.V;
            layout.f33225g0 = layoutParams.W;
            layout.f33237m0 = layoutParams.f33111c0;
            layout.P = layoutParams.f33152x;
            layout.R = layoutParams.f33154z;
            layout.O = layoutParams.f33150w;
            layout.Q = layoutParams.f33153y;
            layout.T = layoutParams.A;
            layout.S = layoutParams.B;
            layout.U = layoutParams.C;
            layout.f33245q0 = layoutParams.f33113d0;
            layout.L = layoutParams.getMarginEnd();
            this.f33195e.M = layoutParams.getMarginStart();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void h(int i3, Constraints.LayoutParams layoutParams) {
            g(i3, layoutParams);
            this.f33193c.f33273d = layoutParams.f33291x0;
            Transform transform = this.f33196f;
            transform.f33277b = layoutParams.A0;
            transform.f33278c = layoutParams.B0;
            transform.f33279d = layoutParams.C0;
            transform.f33280e = layoutParams.D0;
            transform.f33281f = layoutParams.E0;
            transform.f33282g = layoutParams.F0;
            transform.f33283h = layoutParams.G0;
            transform.f33285j = layoutParams.H0;
            transform.f33286k = layoutParams.I0;
            transform.f33287l = layoutParams.J0;
            transform.f33289n = layoutParams.f33293z0;
            transform.f33288m = layoutParams.f33292y0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void i(ConstraintHelper constraintHelper, int i3, Constraints.LayoutParams layoutParams) {
            h(i3, layoutParams);
            if (constraintHelper instanceof Barrier) {
                Layout layout = this.f33195e;
                layout.f33231j0 = 1;
                Barrier barrier = (Barrier) constraintHelper;
                layout.f33227h0 = barrier.getType();
                this.f33195e.f33233k0 = barrier.getReferencedIds();
                this.f33195e.f33229i0 = barrier.getMargin();
            }
        }

        public void d(Constraint constraint) {
            Delta delta = this.f33198h;
            if (delta != null) {
                delta.e(constraint);
            }
        }

        public void e(ConstraintLayout.LayoutParams layoutParams) {
            Layout layout = this.f33195e;
            layoutParams.f33114e = layout.f33230j;
            layoutParams.f33116f = layout.f33232k;
            layoutParams.f33118g = layout.f33234l;
            layoutParams.f33120h = layout.f33236m;
            layoutParams.f33122i = layout.f33238n;
            layoutParams.f33124j = layout.f33240o;
            layoutParams.f33126k = layout.f33242p;
            layoutParams.f33128l = layout.f33244q;
            layoutParams.f33130m = layout.f33246r;
            layoutParams.f33132n = layout.f33247s;
            layoutParams.f33134o = layout.f33248t;
            layoutParams.f33142s = layout.f33249u;
            layoutParams.f33144t = layout.f33250v;
            layoutParams.f33146u = layout.f33251w;
            layoutParams.f33148v = layout.f33252x;
            ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = layout.H;
            ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = layout.I;
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = layout.J;
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = layout.K;
            layoutParams.A = layout.T;
            layoutParams.B = layout.S;
            layoutParams.f33152x = layout.P;
            layoutParams.f33154z = layout.R;
            layoutParams.G = layout.f33253y;
            layoutParams.H = layout.f33254z;
            layoutParams.f33136p = layout.B;
            layoutParams.f33138q = layout.C;
            layoutParams.f33140r = layout.D;
            layoutParams.I = layout.A;
            layoutParams.X = layout.E;
            layoutParams.Y = layout.F;
            layoutParams.M = layout.V;
            layoutParams.L = layout.W;
            layoutParams.O = layout.Y;
            layoutParams.N = layout.X;
            layoutParams.f33107a0 = layout.f33239n0;
            layoutParams.f33109b0 = layout.f33241o0;
            layoutParams.P = layout.Z;
            layoutParams.Q = layout.f33213a0;
            layoutParams.T = layout.f33215b0;
            layoutParams.U = layout.f33217c0;
            layoutParams.R = layout.f33219d0;
            layoutParams.S = layout.f33221e0;
            layoutParams.V = layout.f33223f0;
            layoutParams.W = layout.f33225g0;
            layoutParams.Z = layout.G;
            layoutParams.f33110c = layout.f33226h;
            layoutParams.f33106a = layout.f33222f;
            layoutParams.f33108b = layout.f33224g;
            ((ViewGroup.MarginLayoutParams) layoutParams).width = layout.f33218d;
            ((ViewGroup.MarginLayoutParams) layoutParams).height = layout.f33220e;
            String str = layout.f33237m0;
            if (str != null) {
                layoutParams.f33111c0 = str;
            }
            layoutParams.f33113d0 = layout.f33245q0;
            layoutParams.setMarginStart(layout.M);
            layoutParams.setMarginEnd(this.f33195e.L);
            layoutParams.c();
        }

        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Constraint clone() {
            Constraint constraint = new Constraint();
            constraint.f33195e.a(this.f33195e);
            constraint.f33194d.a(this.f33194d);
            constraint.f33193c.a(this.f33193c);
            constraint.f33196f.a(this.f33196f);
            constraint.f33191a = this.f33191a;
            constraint.f33198h = this.f33198h;
            return constraint;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    public static class Layout {

        /* JADX INFO: renamed from: r0, reason: collision with root package name */
        private static SparseIntArray f33211r0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f33218d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f33220e;

        /* JADX INFO: renamed from: k0, reason: collision with root package name */
        public int[] f33233k0;

        /* JADX INFO: renamed from: l0, reason: collision with root package name */
        public String f33235l0;

        /* JADX INFO: renamed from: m0, reason: collision with root package name */
        public String f33237m0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f33212a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f33214b = false;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f33216c = false;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f33222f = -1;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f33224g = -1;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public float f33226h = -1.0f;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f33228i = true;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f33230j = -1;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f33232k = -1;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f33234l = -1;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f33236m = -1;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f33238n = -1;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f33240o = -1;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f33242p = -1;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f33244q = -1;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public int f33246r = -1;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public int f33247s = -1;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public int f33248t = -1;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public int f33249u = -1;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public int f33250v = -1;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public int f33251w = -1;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public int f33252x = -1;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public float f33253y = 0.5f;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public float f33254z = 0.5f;
        public String A = null;
        public int B = -1;
        public int C = 0;
        public float D = 0.0f;
        public int E = -1;
        public int F = -1;
        public int G = -1;
        public int H = 0;
        public int I = 0;
        public int J = 0;
        public int K = 0;
        public int L = 0;
        public int M = 0;
        public int N = 0;
        public int O = Integer.MIN_VALUE;
        public int P = Integer.MIN_VALUE;
        public int Q = Integer.MIN_VALUE;
        public int R = Integer.MIN_VALUE;
        public int S = Integer.MIN_VALUE;
        public int T = Integer.MIN_VALUE;
        public int U = Integer.MIN_VALUE;
        public float V = -1.0f;
        public float W = -1.0f;
        public int X = 0;
        public int Y = 0;
        public int Z = 0;

        /* JADX INFO: renamed from: a0, reason: collision with root package name */
        public int f33213a0 = 0;

        /* JADX INFO: renamed from: b0, reason: collision with root package name */
        public int f33215b0 = 0;

        /* JADX INFO: renamed from: c0, reason: collision with root package name */
        public int f33217c0 = 0;

        /* JADX INFO: renamed from: d0, reason: collision with root package name */
        public int f33219d0 = 0;

        /* JADX INFO: renamed from: e0, reason: collision with root package name */
        public int f33221e0 = 0;

        /* JADX INFO: renamed from: f0, reason: collision with root package name */
        public float f33223f0 = 1.0f;

        /* JADX INFO: renamed from: g0, reason: collision with root package name */
        public float f33225g0 = 1.0f;

        /* JADX INFO: renamed from: h0, reason: collision with root package name */
        public int f33227h0 = -1;

        /* JADX INFO: renamed from: i0, reason: collision with root package name */
        public int f33229i0 = 0;

        /* JADX INFO: renamed from: j0, reason: collision with root package name */
        public int f33231j0 = -1;

        /* JADX INFO: renamed from: n0, reason: collision with root package name */
        public boolean f33239n0 = false;

        /* JADX INFO: renamed from: o0, reason: collision with root package name */
        public boolean f33241o0 = false;

        /* JADX INFO: renamed from: p0, reason: collision with root package name */
        public boolean f33243p0 = true;

        /* JADX INFO: renamed from: q0, reason: collision with root package name */
        public int f33245q0 = 0;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f33211r0 = sparseIntArray;
            sparseIntArray.append(R.styleable.T7, 24);
            f33211r0.append(R.styleable.U7, 25);
            f33211r0.append(R.styleable.W7, 28);
            f33211r0.append(R.styleable.X7, 29);
            f33211r0.append(R.styleable.c8, 35);
            f33211r0.append(R.styleable.b8, 34);
            f33211r0.append(R.styleable.D7, 4);
            f33211r0.append(R.styleable.C7, 3);
            f33211r0.append(R.styleable.A7, 1);
            f33211r0.append(R.styleable.i8, 6);
            f33211r0.append(R.styleable.j8, 7);
            f33211r0.append(R.styleable.K7, 17);
            f33211r0.append(R.styleable.L7, 18);
            f33211r0.append(R.styleable.M7, 19);
            f33211r0.append(R.styleable.w7, 90);
            f33211r0.append(R.styleable.i7, 26);
            f33211r0.append(R.styleable.Y7, 31);
            f33211r0.append(R.styleable.Z7, 32);
            f33211r0.append(R.styleable.J7, 10);
            f33211r0.append(R.styleable.I7, 9);
            f33211r0.append(R.styleable.m8, 13);
            f33211r0.append(R.styleable.p8, 16);
            f33211r0.append(R.styleable.n8, 14);
            f33211r0.append(R.styleable.k8, 11);
            f33211r0.append(R.styleable.o8, 15);
            f33211r0.append(R.styleable.l8, 12);
            f33211r0.append(R.styleable.f8, 38);
            f33211r0.append(R.styleable.R7, 37);
            f33211r0.append(R.styleable.Q7, 39);
            f33211r0.append(R.styleable.e8, 40);
            f33211r0.append(R.styleable.P7, 20);
            f33211r0.append(R.styleable.d8, 36);
            f33211r0.append(R.styleable.H7, 5);
            f33211r0.append(R.styleable.S7, 91);
            f33211r0.append(R.styleable.a8, 91);
            f33211r0.append(R.styleable.V7, 91);
            f33211r0.append(R.styleable.B7, 91);
            f33211r0.append(R.styleable.z7, 91);
            f33211r0.append(R.styleable.l7, 23);
            f33211r0.append(R.styleable.n7, 27);
            f33211r0.append(R.styleable.p7, 30);
            f33211r0.append(R.styleable.q7, 8);
            f33211r0.append(R.styleable.m7, 33);
            f33211r0.append(R.styleable.o7, 2);
            f33211r0.append(R.styleable.j7, 22);
            f33211r0.append(R.styleable.k7, 21);
            f33211r0.append(R.styleable.g8, 41);
            f33211r0.append(R.styleable.N7, 42);
            f33211r0.append(R.styleable.y7, 41);
            f33211r0.append(R.styleable.x7, 42);
            f33211r0.append(R.styleable.q8, 76);
            f33211r0.append(R.styleable.E7, 61);
            f33211r0.append(R.styleable.G7, 62);
            f33211r0.append(R.styleable.F7, 63);
            f33211r0.append(R.styleable.h8, 69);
            f33211r0.append(R.styleable.O7, 70);
            f33211r0.append(R.styleable.u7, 71);
            f33211r0.append(R.styleable.s7, 72);
            f33211r0.append(R.styleable.t7, 73);
            f33211r0.append(R.styleable.v7, 74);
            f33211r0.append(R.styleable.r7, 75);
        }

        public void a(Layout layout) {
            this.f33212a = layout.f33212a;
            this.f33218d = layout.f33218d;
            this.f33214b = layout.f33214b;
            this.f33220e = layout.f33220e;
            this.f33222f = layout.f33222f;
            this.f33224g = layout.f33224g;
            this.f33226h = layout.f33226h;
            this.f33228i = layout.f33228i;
            this.f33230j = layout.f33230j;
            this.f33232k = layout.f33232k;
            this.f33234l = layout.f33234l;
            this.f33236m = layout.f33236m;
            this.f33238n = layout.f33238n;
            this.f33240o = layout.f33240o;
            this.f33242p = layout.f33242p;
            this.f33244q = layout.f33244q;
            this.f33246r = layout.f33246r;
            this.f33247s = layout.f33247s;
            this.f33248t = layout.f33248t;
            this.f33249u = layout.f33249u;
            this.f33250v = layout.f33250v;
            this.f33251w = layout.f33251w;
            this.f33252x = layout.f33252x;
            this.f33253y = layout.f33253y;
            this.f33254z = layout.f33254z;
            this.A = layout.A;
            this.B = layout.B;
            this.C = layout.C;
            this.D = layout.D;
            this.E = layout.E;
            this.F = layout.F;
            this.G = layout.G;
            this.H = layout.H;
            this.I = layout.I;
            this.J = layout.J;
            this.K = layout.K;
            this.L = layout.L;
            this.M = layout.M;
            this.N = layout.N;
            this.O = layout.O;
            this.P = layout.P;
            this.Q = layout.Q;
            this.R = layout.R;
            this.S = layout.S;
            this.T = layout.T;
            this.U = layout.U;
            this.V = layout.V;
            this.W = layout.W;
            this.X = layout.X;
            this.Y = layout.Y;
            this.Z = layout.Z;
            this.f33213a0 = layout.f33213a0;
            this.f33215b0 = layout.f33215b0;
            this.f33217c0 = layout.f33217c0;
            this.f33219d0 = layout.f33219d0;
            this.f33221e0 = layout.f33221e0;
            this.f33223f0 = layout.f33223f0;
            this.f33225g0 = layout.f33225g0;
            this.f33227h0 = layout.f33227h0;
            this.f33229i0 = layout.f33229i0;
            this.f33231j0 = layout.f33231j0;
            this.f33237m0 = layout.f33237m0;
            int[] iArr = layout.f33233k0;
            if (iArr == null || layout.f33235l0 != null) {
                this.f33233k0 = null;
            } else {
                this.f33233k0 = Arrays.copyOf(iArr, iArr.length);
            }
            this.f33235l0 = layout.f33235l0;
            this.f33239n0 = layout.f33239n0;
            this.f33241o0 = layout.f33241o0;
            this.f33243p0 = layout.f33243p0;
            this.f33245q0 = layout.f33245q0;
        }

        void b(Context context, AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.h7);
            this.f33214b = true;
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i3);
                int i4 = f33211r0.get(index);
                switch (i4) {
                    case 1:
                        this.f33246r = ConstraintSet.H(typedArrayObtainStyledAttributes, index, this.f33246r);
                        break;
                    case 2:
                        this.K = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.K);
                        break;
                    case 3:
                        this.f33244q = ConstraintSet.H(typedArrayObtainStyledAttributes, index, this.f33244q);
                        break;
                    case 4:
                        this.f33242p = ConstraintSet.H(typedArrayObtainStyledAttributes, index, this.f33242p);
                        break;
                    case 5:
                        this.A = typedArrayObtainStyledAttributes.getString(index);
                        break;
                    case 6:
                        this.E = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.E);
                        break;
                    case 7:
                        this.F = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.F);
                        break;
                    case 8:
                        this.L = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.L);
                        break;
                    case 9:
                        this.f33252x = ConstraintSet.H(typedArrayObtainStyledAttributes, index, this.f33252x);
                        break;
                    case 10:
                        this.f33251w = ConstraintSet.H(typedArrayObtainStyledAttributes, index, this.f33251w);
                        break;
                    case 11:
                        this.R = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.R);
                        break;
                    case 12:
                        this.S = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.S);
                        break;
                    case 13:
                        this.O = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.O);
                        break;
                    case 14:
                        this.Q = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.Q);
                        break;
                    case 15:
                        this.T = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.T);
                        break;
                    case 16:
                        this.P = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.P);
                        break;
                    case 17:
                        this.f33222f = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f33222f);
                        break;
                    case 18:
                        this.f33224g = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f33224g);
                        break;
                    case 19:
                        this.f33226h = typedArrayObtainStyledAttributes.getFloat(index, this.f33226h);
                        break;
                    case 20:
                        this.f33253y = typedArrayObtainStyledAttributes.getFloat(index, this.f33253y);
                        break;
                    case 21:
                        this.f33220e = typedArrayObtainStyledAttributes.getLayoutDimension(index, this.f33220e);
                        break;
                    case 22:
                        this.f33218d = typedArrayObtainStyledAttributes.getLayoutDimension(index, this.f33218d);
                        break;
                    case 23:
                        this.H = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.H);
                        break;
                    case 24:
                        this.f33230j = ConstraintSet.H(typedArrayObtainStyledAttributes, index, this.f33230j);
                        break;
                    case 25:
                        this.f33232k = ConstraintSet.H(typedArrayObtainStyledAttributes, index, this.f33232k);
                        break;
                    case 26:
                        this.G = typedArrayObtainStyledAttributes.getInt(index, this.G);
                        break;
                    case 27:
                        this.I = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.I);
                        break;
                    case 28:
                        this.f33234l = ConstraintSet.H(typedArrayObtainStyledAttributes, index, this.f33234l);
                        break;
                    case 29:
                        this.f33236m = ConstraintSet.H(typedArrayObtainStyledAttributes, index, this.f33236m);
                        break;
                    case 30:
                        this.M = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.M);
                        break;
                    case 31:
                        this.f33249u = ConstraintSet.H(typedArrayObtainStyledAttributes, index, this.f33249u);
                        break;
                    case 32:
                        this.f33250v = ConstraintSet.H(typedArrayObtainStyledAttributes, index, this.f33250v);
                        break;
                    case 33:
                        this.J = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.J);
                        break;
                    case 34:
                        this.f33240o = ConstraintSet.H(typedArrayObtainStyledAttributes, index, this.f33240o);
                        break;
                    case 35:
                        this.f33238n = ConstraintSet.H(typedArrayObtainStyledAttributes, index, this.f33238n);
                        break;
                    case 36:
                        this.f33254z = typedArrayObtainStyledAttributes.getFloat(index, this.f33254z);
                        break;
                    case 37:
                        this.W = typedArrayObtainStyledAttributes.getFloat(index, this.W);
                        break;
                    case 38:
                        this.V = typedArrayObtainStyledAttributes.getFloat(index, this.V);
                        break;
                    case 39:
                        this.X = typedArrayObtainStyledAttributes.getInt(index, this.X);
                        break;
                    case 40:
                        this.Y = typedArrayObtainStyledAttributes.getInt(index, this.Y);
                        break;
                    case 41:
                        ConstraintSet.I(this, typedArrayObtainStyledAttributes, index, 0);
                        break;
                    case 42:
                        ConstraintSet.I(this, typedArrayObtainStyledAttributes, index, 1);
                        break;
                    default:
                        switch (i4) {
                            case 61:
                                this.B = ConstraintSet.H(typedArrayObtainStyledAttributes, index, this.B);
                                break;
                            case 62:
                                this.C = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.C);
                                break;
                            case 63:
                                this.D = typedArrayObtainStyledAttributes.getFloat(index, this.D);
                                break;
                            default:
                                switch (i4) {
                                    case 69:
                                        this.f33223f0 = typedArrayObtainStyledAttributes.getFloat(index, 1.0f);
                                        break;
                                    case 70:
                                        this.f33225g0 = typedArrayObtainStyledAttributes.getFloat(index, 1.0f);
                                        break;
                                    case 71:
                                        Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                                        break;
                                    case 72:
                                        this.f33227h0 = typedArrayObtainStyledAttributes.getInt(index, this.f33227h0);
                                        break;
                                    case 73:
                                        this.f33229i0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f33229i0);
                                        break;
                                    case 74:
                                        this.f33235l0 = typedArrayObtainStyledAttributes.getString(index);
                                        break;
                                    case 75:
                                        this.f33243p0 = typedArrayObtainStyledAttributes.getBoolean(index, this.f33243p0);
                                        break;
                                    case 76:
                                        this.f33245q0 = typedArrayObtainStyledAttributes.getInt(index, this.f33245q0);
                                        break;
                                    case 77:
                                        this.f33247s = ConstraintSet.H(typedArrayObtainStyledAttributes, index, this.f33247s);
                                        break;
                                    case 78:
                                        this.f33248t = ConstraintSet.H(typedArrayObtainStyledAttributes, index, this.f33248t);
                                        break;
                                    case 79:
                                        this.U = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.U);
                                        break;
                                    case 80:
                                        this.N = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.N);
                                        break;
                                    case 81:
                                        this.Z = typedArrayObtainStyledAttributes.getInt(index, this.Z);
                                        break;
                                    case 82:
                                        this.f33213a0 = typedArrayObtainStyledAttributes.getInt(index, this.f33213a0);
                                        break;
                                    case 83:
                                        this.f33217c0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f33217c0);
                                        break;
                                    case 84:
                                        this.f33215b0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f33215b0);
                                        break;
                                    case 85:
                                        this.f33221e0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f33221e0);
                                        break;
                                    case 86:
                                        this.f33219d0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f33219d0);
                                        break;
                                    case 87:
                                        this.f33239n0 = typedArrayObtainStyledAttributes.getBoolean(index, this.f33239n0);
                                        break;
                                    case 88:
                                        this.f33241o0 = typedArrayObtainStyledAttributes.getBoolean(index, this.f33241o0);
                                        break;
                                    case 89:
                                        this.f33237m0 = typedArrayObtainStyledAttributes.getString(index);
                                        break;
                                    case 90:
                                        this.f33228i = typedArrayObtainStyledAttributes.getBoolean(index, this.f33228i);
                                        break;
                                    case 91:
                                        Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + f33211r0.get(index));
                                        break;
                                    default:
                                        Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + f33211r0.get(index));
                                        break;
                                }
                                break;
                        }
                        break;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    public static class Motion {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private static SparseIntArray f33255o;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f33256a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f33257b = -1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f33258c = 0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f33259d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f33260e = -1;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f33261f = 0;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public float f33262g = Float.NaN;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f33263h = -1;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public float f33264i = Float.NaN;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public float f33265j = Float.NaN;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f33266k = -1;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public String f33267l = null;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f33268m = -3;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f33269n = -1;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f33255o = sparseIntArray;
            sparseIntArray.append(R.styleable.C8, 1);
            f33255o.append(R.styleable.E8, 2);
            f33255o.append(R.styleable.I8, 3);
            f33255o.append(R.styleable.B8, 4);
            f33255o.append(R.styleable.A8, 5);
            f33255o.append(R.styleable.z8, 6);
            f33255o.append(R.styleable.D8, 7);
            f33255o.append(R.styleable.H8, 8);
            f33255o.append(R.styleable.G8, 9);
            f33255o.append(R.styleable.F8, 10);
        }

        public void a(Motion motion) {
            this.f33256a = motion.f33256a;
            this.f33257b = motion.f33257b;
            this.f33259d = motion.f33259d;
            this.f33260e = motion.f33260e;
            this.f33261f = motion.f33261f;
            this.f33264i = motion.f33264i;
            this.f33262g = motion.f33262g;
            this.f33263h = motion.f33263h;
        }

        void b(Context context, AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.y8);
            this.f33256a = true;
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i3);
                switch (f33255o.get(index)) {
                    case 1:
                        this.f33264i = typedArrayObtainStyledAttributes.getFloat(index, this.f33264i);
                        break;
                    case 2:
                        this.f33260e = typedArrayObtainStyledAttributes.getInt(index, this.f33260e);
                        break;
                    case 3:
                        if (typedArrayObtainStyledAttributes.peekValue(index).type == 3) {
                            this.f33259d = typedArrayObtainStyledAttributes.getString(index);
                        } else {
                            this.f33259d = Easing.f31744c[typedArrayObtainStyledAttributes.getInteger(index, 0)];
                        }
                        break;
                    case 4:
                        this.f33261f = typedArrayObtainStyledAttributes.getInt(index, 0);
                        break;
                    case 5:
                        this.f33257b = ConstraintSet.H(typedArrayObtainStyledAttributes, index, this.f33257b);
                        break;
                    case 6:
                        this.f33258c = typedArrayObtainStyledAttributes.getInteger(index, this.f33258c);
                        break;
                    case 7:
                        this.f33262g = typedArrayObtainStyledAttributes.getFloat(index, this.f33262g);
                        break;
                    case 8:
                        this.f33266k = typedArrayObtainStyledAttributes.getInteger(index, this.f33266k);
                        break;
                    case 9:
                        this.f33265j = typedArrayObtainStyledAttributes.getFloat(index, this.f33265j);
                        break;
                    case 10:
                        int i4 = typedArrayObtainStyledAttributes.peekValue(index).type;
                        if (i4 == 1) {
                            int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                            this.f33269n = resourceId;
                            if (resourceId != -1) {
                                this.f33268m = -2;
                            }
                        } else if (i4 == 3) {
                            String string = typedArrayObtainStyledAttributes.getString(index);
                            this.f33267l = string;
                            if (string.indexOf("/") > 0) {
                                this.f33269n = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                                this.f33268m = -2;
                            } else {
                                this.f33268m = -1;
                            }
                        } else {
                            this.f33268m = typedArrayObtainStyledAttributes.getInteger(index, this.f33269n);
                        }
                        break;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    public static class PropertySet {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f33270a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f33271b = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f33272c = 0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f33273d = 1.0f;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f33274e = Float.NaN;

        public void a(PropertySet propertySet) {
            this.f33270a = propertySet.f33270a;
            this.f33271b = propertySet.f33271b;
            this.f33273d = propertySet.f33273d;
            this.f33274e = propertySet.f33274e;
            this.f33272c = propertySet.f33272c;
        }

        void b(Context context, AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.s9);
            this.f33270a = true;
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i3);
                if (index == R.styleable.u9) {
                    this.f33273d = typedArrayObtainStyledAttributes.getFloat(index, this.f33273d);
                } else if (index == R.styleable.t9) {
                    this.f33271b = typedArrayObtainStyledAttributes.getInt(index, this.f33271b);
                    this.f33271b = ConstraintSet.f33181h[this.f33271b];
                } else if (index == R.styleable.w9) {
                    this.f33272c = typedArrayObtainStyledAttributes.getInt(index, this.f33272c);
                } else if (index == R.styleable.v9) {
                    this.f33274e = typedArrayObtainStyledAttributes.getFloat(index, this.f33274e);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    public static class Transform {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private static SparseIntArray f33275o;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f33276a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f33277b = 0.0f;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f33278c = 0.0f;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f33279d = 0.0f;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f33280e = 1.0f;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public float f33281f = 1.0f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public float f33282g = Float.NaN;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public float f33283h = Float.NaN;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f33284i = -1;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public float f33285j = 0.0f;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public float f33286k = 0.0f;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public float f33287l = 0.0f;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f33288m = false;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public float f33289n = 0.0f;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f33275o = sparseIntArray;
            sparseIntArray.append(R.styleable.S9, 1);
            f33275o.append(R.styleable.T9, 2);
            f33275o.append(R.styleable.U9, 3);
            f33275o.append(R.styleable.Q9, 4);
            f33275o.append(R.styleable.R9, 5);
            f33275o.append(R.styleable.M9, 6);
            f33275o.append(R.styleable.N9, 7);
            f33275o.append(R.styleable.O9, 8);
            f33275o.append(R.styleable.P9, 9);
            f33275o.append(R.styleable.V9, 10);
            f33275o.append(R.styleable.W9, 11);
            f33275o.append(R.styleable.X9, 12);
        }

        public void a(Transform transform) {
            this.f33276a = transform.f33276a;
            this.f33277b = transform.f33277b;
            this.f33278c = transform.f33278c;
            this.f33279d = transform.f33279d;
            this.f33280e = transform.f33280e;
            this.f33281f = transform.f33281f;
            this.f33282g = transform.f33282g;
            this.f33283h = transform.f33283h;
            this.f33284i = transform.f33284i;
            this.f33285j = transform.f33285j;
            this.f33286k = transform.f33286k;
            this.f33287l = transform.f33287l;
            this.f33288m = transform.f33288m;
            this.f33289n = transform.f33289n;
        }

        void b(Context context, AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.L9);
            this.f33276a = true;
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i3);
                switch (f33275o.get(index)) {
                    case 1:
                        this.f33277b = typedArrayObtainStyledAttributes.getFloat(index, this.f33277b);
                        break;
                    case 2:
                        this.f33278c = typedArrayObtainStyledAttributes.getFloat(index, this.f33278c);
                        break;
                    case 3:
                        this.f33279d = typedArrayObtainStyledAttributes.getFloat(index, this.f33279d);
                        break;
                    case 4:
                        this.f33280e = typedArrayObtainStyledAttributes.getFloat(index, this.f33280e);
                        break;
                    case 5:
                        this.f33281f = typedArrayObtainStyledAttributes.getFloat(index, this.f33281f);
                        break;
                    case 6:
                        this.f33282g = typedArrayObtainStyledAttributes.getDimension(index, this.f33282g);
                        break;
                    case 7:
                        this.f33283h = typedArrayObtainStyledAttributes.getDimension(index, this.f33283h);
                        break;
                    case 8:
                        this.f33285j = typedArrayObtainStyledAttributes.getDimension(index, this.f33285j);
                        break;
                    case 9:
                        this.f33286k = typedArrayObtainStyledAttributes.getDimension(index, this.f33286k);
                        break;
                    case 10:
                        this.f33287l = typedArrayObtainStyledAttributes.getDimension(index, this.f33287l);
                        break;
                    case 11:
                        this.f33288m = true;
                        this.f33289n = typedArrayObtainStyledAttributes.getDimension(index, this.f33289n);
                        break;
                    case 12:
                        this.f33284i = ConstraintSet.H(typedArrayObtainStyledAttributes, index, this.f33284i);
                        break;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    class WriteJsonEngine {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    class WriteXmlEngine {
    }

    static {
        f33182i.append(R.styleable.A0, 25);
        f33182i.append(R.styleable.B0, 26);
        f33182i.append(R.styleable.D0, 29);
        f33182i.append(R.styleable.E0, 30);
        f33182i.append(R.styleable.K0, 36);
        f33182i.append(R.styleable.J0, 35);
        f33182i.append(R.styleable.f33329h0, 4);
        f33182i.append(R.styleable.f33325g0, 3);
        f33182i.append(R.styleable.f33309c0, 1);
        f33182i.append(R.styleable.f33317e0, 91);
        f33182i.append(R.styleable.f33313d0, 92);
        f33182i.append(R.styleable.T0, 6);
        f33182i.append(R.styleable.U0, 7);
        f33182i.append(R.styleable.f33357o0, 17);
        f33182i.append(R.styleable.f33361p0, 18);
        f33182i.append(R.styleable.f33365q0, 19);
        f33182i.append(R.styleable.Y, 99);
        f33182i.append(R.styleable.f33377u, 27);
        f33182i.append(R.styleable.F0, 32);
        f33182i.append(R.styleable.G0, 33);
        f33182i.append(R.styleable.f33353n0, 10);
        f33182i.append(R.styleable.f33349m0, 9);
        f33182i.append(R.styleable.X0, 13);
        f33182i.append(R.styleable.f33302a1, 16);
        f33182i.append(R.styleable.Y0, 14);
        f33182i.append(R.styleable.V0, 11);
        f33182i.append(R.styleable.Z0, 15);
        f33182i.append(R.styleable.W0, 12);
        f33182i.append(R.styleable.N0, 40);
        f33182i.append(R.styleable.f33390y0, 39);
        f33182i.append(R.styleable.f33387x0, 41);
        f33182i.append(R.styleable.M0, 42);
        f33182i.append(R.styleable.f33384w0, 20);
        f33182i.append(R.styleable.L0, 37);
        f33182i.append(R.styleable.f33345l0, 5);
        f33182i.append(R.styleable.f33393z0, 87);
        f33182i.append(R.styleable.I0, 87);
        f33182i.append(R.styleable.C0, 87);
        f33182i.append(R.styleable.f33321f0, 87);
        f33182i.append(R.styleable.f33305b0, 87);
        f33182i.append(R.styleable.f33392z, 24);
        f33182i.append(R.styleable.B, 28);
        f33182i.append(R.styleable.N, 31);
        f33182i.append(R.styleable.O, 8);
        f33182i.append(R.styleable.A, 34);
        f33182i.append(R.styleable.C, 2);
        f33182i.append(R.styleable.f33386x, 23);
        f33182i.append(R.styleable.f33389y, 21);
        f33182i.append(R.styleable.O0, 95);
        f33182i.append(R.styleable.f33369r0, 96);
        f33182i.append(R.styleable.f33383w, 22);
        f33182i.append(R.styleable.D, 43);
        f33182i.append(R.styleable.Q, 44);
        f33182i.append(R.styleable.L, 45);
        f33182i.append(R.styleable.M, 46);
        f33182i.append(R.styleable.K, 60);
        f33182i.append(R.styleable.I, 47);
        f33182i.append(R.styleable.J, 48);
        f33182i.append(R.styleable.E, 49);
        f33182i.append(R.styleable.F, 50);
        f33182i.append(R.styleable.G, 51);
        f33182i.append(R.styleable.H, 52);
        f33182i.append(R.styleable.P, 53);
        f33182i.append(R.styleable.P0, 54);
        f33182i.append(R.styleable.f33372s0, 55);
        f33182i.append(R.styleable.Q0, 56);
        f33182i.append(R.styleable.f33375t0, 57);
        f33182i.append(R.styleable.R0, 58);
        f33182i.append(R.styleable.f33378u0, 59);
        f33182i.append(R.styleable.f33333i0, 61);
        f33182i.append(R.styleable.f33341k0, 62);
        f33182i.append(R.styleable.f33337j0, 63);
        f33182i.append(R.styleable.R, 64);
        f33182i.append(R.styleable.f33342k1, 65);
        f33182i.append(R.styleable.X, 66);
        f33182i.append(R.styleable.f33346l1, 67);
        f33182i.append(R.styleable.f33314d1, 79);
        f33182i.append(R.styleable.f33380v, 38);
        f33182i.append(R.styleable.f33310c1, 68);
        f33182i.append(R.styleable.S0, 69);
        f33182i.append(R.styleable.f33381v0, 70);
        f33182i.append(R.styleable.f33306b1, 97);
        f33182i.append(R.styleable.V, 71);
        f33182i.append(R.styleable.T, 72);
        f33182i.append(R.styleable.U, 73);
        f33182i.append(R.styleable.W, 74);
        f33182i.append(R.styleable.S, 75);
        f33182i.append(R.styleable.f33318e1, 76);
        f33182i.append(R.styleable.H0, 77);
        f33182i.append(R.styleable.f33350m1, 78);
        f33182i.append(R.styleable.f33301a0, 80);
        f33182i.append(R.styleable.Z, 81);
        f33182i.append(R.styleable.f33322f1, 82);
        f33182i.append(R.styleable.f33338j1, 83);
        f33182i.append(R.styleable.f33334i1, 84);
        f33182i.append(R.styleable.f33330h1, 85);
        f33182i.append(R.styleable.f33326g1, 86);
        SparseIntArray sparseIntArray = f33183j;
        int i3 = R.styleable.v4;
        sparseIntArray.append(i3, 6);
        f33183j.append(i3, 7);
        f33183j.append(R.styleable.q3, 27);
        f33183j.append(R.styleable.y4, 13);
        f33183j.append(R.styleable.B4, 16);
        f33183j.append(R.styleable.z4, 14);
        f33183j.append(R.styleable.w4, 11);
        f33183j.append(R.styleable.A4, 15);
        f33183j.append(R.styleable.x4, 12);
        f33183j.append(R.styleable.p4, 40);
        f33183j.append(R.styleable.i4, 39);
        f33183j.append(R.styleable.h4, 41);
        f33183j.append(R.styleable.o4, 42);
        f33183j.append(R.styleable.g4, 20);
        f33183j.append(R.styleable.n4, 37);
        f33183j.append(R.styleable.a4, 5);
        f33183j.append(R.styleable.j4, 87);
        f33183j.append(R.styleable.m4, 87);
        f33183j.append(R.styleable.k4, 87);
        f33183j.append(R.styleable.X3, 87);
        f33183j.append(R.styleable.W3, 87);
        f33183j.append(R.styleable.v3, 24);
        f33183j.append(R.styleable.x3, 28);
        f33183j.append(R.styleable.J3, 31);
        f33183j.append(R.styleable.K3, 8);
        f33183j.append(R.styleable.w3, 34);
        f33183j.append(R.styleable.y3, 2);
        f33183j.append(R.styleable.t3, 23);
        f33183j.append(R.styleable.u3, 21);
        f33183j.append(R.styleable.q4, 95);
        f33183j.append(R.styleable.b4, 96);
        f33183j.append(R.styleable.s3, 22);
        f33183j.append(R.styleable.z3, 43);
        f33183j.append(R.styleable.M3, 44);
        f33183j.append(R.styleable.H3, 45);
        f33183j.append(R.styleable.I3, 46);
        f33183j.append(R.styleable.G3, 60);
        f33183j.append(R.styleable.E3, 47);
        f33183j.append(R.styleable.F3, 48);
        f33183j.append(R.styleable.A3, 49);
        f33183j.append(R.styleable.B3, 50);
        f33183j.append(R.styleable.C3, 51);
        f33183j.append(R.styleable.D3, 52);
        f33183j.append(R.styleable.L3, 53);
        f33183j.append(R.styleable.r4, 54);
        f33183j.append(R.styleable.c4, 55);
        f33183j.append(R.styleable.s4, 56);
        f33183j.append(R.styleable.d4, 57);
        f33183j.append(R.styleable.t4, 58);
        f33183j.append(R.styleable.e4, 59);
        f33183j.append(R.styleable.Z3, 62);
        f33183j.append(R.styleable.Y3, 63);
        f33183j.append(R.styleable.N3, 64);
        f33183j.append(R.styleable.M4, 65);
        f33183j.append(R.styleable.T3, 66);
        f33183j.append(R.styleable.N4, 67);
        f33183j.append(R.styleable.E4, 79);
        f33183j.append(R.styleable.r3, 38);
        f33183j.append(R.styleable.F4, 98);
        f33183j.append(R.styleable.D4, 68);
        f33183j.append(R.styleable.u4, 69);
        f33183j.append(R.styleable.f4, 70);
        f33183j.append(R.styleable.R3, 71);
        f33183j.append(R.styleable.P3, 72);
        f33183j.append(R.styleable.Q3, 73);
        f33183j.append(R.styleable.S3, 74);
        f33183j.append(R.styleable.O3, 75);
        f33183j.append(R.styleable.G4, 76);
        f33183j.append(R.styleable.l4, 77);
        f33183j.append(R.styleable.O4, 78);
        f33183j.append(R.styleable.V3, 80);
        f33183j.append(R.styleable.U3, 81);
        f33183j.append(R.styleable.H4, 82);
        f33183j.append(R.styleable.L4, 83);
        f33183j.append(R.styleable.K4, 84);
        f33183j.append(R.styleable.J4, 85);
        f33183j.append(R.styleable.I4, 86);
        f33183j.append(R.styleable.C4, 97);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int H(TypedArray typedArray, int i3, int i4) {
        int resourceId = typedArray.getResourceId(i3, i4);
        return resourceId == -1 ? typedArray.getInt(i3, -1) : resourceId;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static void I(java.lang.Object r4, android.content.res.TypedArray r5, int r6, int r7) {
        /*
            if (r4 != 0) goto L4
            goto L71
        L4:
            android.util.TypedValue r0 = r5.peekValue(r6)
            int r0 = r0.type
            r1 = 3
            if (r0 == r1) goto L72
            r1 = 5
            r2 = 0
            if (r0 == r1) goto L2b
            int r5 = r5.getInt(r6, r2)
            r6 = -4
            r0 = -2
            if (r5 == r6) goto L27
            r6 = -3
            if (r5 == r6) goto L21
            if (r5 == r0) goto L23
            r6 = -1
            if (r5 == r6) goto L23
        L21:
            r5 = r2
            goto L30
        L23:
            r3 = r2
            r2 = r5
            r5 = r3
            goto L30
        L27:
            r2 = 1
            r5 = r2
            r2 = r0
            goto L30
        L2b:
            int r5 = r5.getDimensionPixelSize(r6, r2)
            goto L23
        L30:
            boolean r6 = r4 instanceof androidx.constraintlayout.widget.ConstraintLayout.LayoutParams
            if (r6 == 0) goto L42
            androidx.constraintlayout.widget.ConstraintLayout$LayoutParams r4 = (androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) r4
            if (r7 != 0) goto L3d
            r4.width = r2
            r4.f33107a0 = r5
            return
        L3d:
            r4.height = r2
            r4.f33109b0 = r5
            return
        L42:
            boolean r6 = r4 instanceof androidx.constraintlayout.widget.ConstraintSet.Layout
            if (r6 == 0) goto L54
            androidx.constraintlayout.widget.ConstraintSet$Layout r4 = (androidx.constraintlayout.widget.ConstraintSet.Layout) r4
            if (r7 != 0) goto L4f
            r4.f33218d = r2
            r4.f33239n0 = r5
            return
        L4f:
            r4.f33220e = r2
            r4.f33241o0 = r5
            return
        L54:
            boolean r6 = r4 instanceof androidx.constraintlayout.widget.ConstraintSet.Constraint.Delta
            if (r6 == 0) goto L71
            androidx.constraintlayout.widget.ConstraintSet$Constraint$Delta r4 = (androidx.constraintlayout.widget.ConstraintSet.Constraint.Delta) r4
            if (r7 != 0) goto L67
            r6 = 23
            r4.b(r6, r2)
            r6 = 80
            r4.d(r6, r5)
            return
        L67:
            r6 = 21
            r4.b(r6, r2)
            r6 = 81
            r4.d(r6, r5)
        L71:
            return
        L72:
            java.lang.String r5 = r5.getString(r6)
            J(r4, r5, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintSet.I(java.lang.Object, android.content.res.TypedArray, int, int):void");
    }

    static void K(ConstraintLayout.LayoutParams layoutParams, String str) {
        float fAbs = Float.NaN;
        int i3 = -1;
        if (str != null) {
            int length = str.length();
            int iIndexOf = str.indexOf(44);
            int i4 = 0;
            if (iIndexOf > 0 && iIndexOf < length - 1) {
                String strSubstring = str.substring(0, iIndexOf);
                if (strSubstring.equalsIgnoreCase("W")) {
                    i3 = 0;
                } else if (strSubstring.equalsIgnoreCase("H")) {
                    i3 = 1;
                }
                i4 = iIndexOf + 1;
            }
            int iIndexOf2 = str.indexOf(58);
            try {
                if (iIndexOf2 < 0 || iIndexOf2 >= length - 1) {
                    String strSubstring2 = str.substring(i4);
                    if (strSubstring2.length() > 0) {
                        fAbs = Float.parseFloat(strSubstring2);
                    }
                } else {
                    String strSubstring3 = str.substring(i4, iIndexOf2);
                    String strSubstring4 = str.substring(iIndexOf2 + 1);
                    if (strSubstring3.length() > 0 && strSubstring4.length() > 0) {
                        float f3 = Float.parseFloat(strSubstring3);
                        float f4 = Float.parseFloat(strSubstring4);
                        if (f3 > 0.0f && f4 > 0.0f) {
                            fAbs = i3 == 1 ? Math.abs(f4 / f3) : Math.abs(f3 / f4);
                        }
                    }
                }
            } catch (NumberFormatException unused) {
            }
        }
        layoutParams.I = str;
        layoutParams.J = fAbs;
        layoutParams.K = i3;
    }

    private void L(Context context, Constraint constraint, TypedArray typedArray, boolean z2) {
        if (z2) {
            M(context, constraint, typedArray);
            return;
        }
        int indexCount = typedArray.getIndexCount();
        for (int i3 = 0; i3 < indexCount; i3++) {
            int index = typedArray.getIndex(i3);
            if (index != R.styleable.f33380v && R.styleable.N != index && R.styleable.O != index) {
                constraint.f33194d.f33256a = true;
                constraint.f33195e.f33214b = true;
                constraint.f33193c.f33270a = true;
                constraint.f33196f.f33276a = true;
            }
            switch (f33182i.get(index)) {
                case 1:
                    Layout layout = constraint.f33195e;
                    layout.f33246r = H(typedArray, index, layout.f33246r);
                    break;
                case 2:
                    Layout layout2 = constraint.f33195e;
                    layout2.K = typedArray.getDimensionPixelSize(index, layout2.K);
                    break;
                case 3:
                    Layout layout3 = constraint.f33195e;
                    layout3.f33244q = H(typedArray, index, layout3.f33244q);
                    break;
                case 4:
                    Layout layout4 = constraint.f33195e;
                    layout4.f33242p = H(typedArray, index, layout4.f33242p);
                    break;
                case 5:
                    constraint.f33195e.A = typedArray.getString(index);
                    break;
                case 6:
                    Layout layout5 = constraint.f33195e;
                    layout5.E = typedArray.getDimensionPixelOffset(index, layout5.E);
                    break;
                case 7:
                    Layout layout6 = constraint.f33195e;
                    layout6.F = typedArray.getDimensionPixelOffset(index, layout6.F);
                    break;
                case 8:
                    Layout layout7 = constraint.f33195e;
                    layout7.L = typedArray.getDimensionPixelSize(index, layout7.L);
                    break;
                case 9:
                    Layout layout8 = constraint.f33195e;
                    layout8.f33252x = H(typedArray, index, layout8.f33252x);
                    break;
                case 10:
                    Layout layout9 = constraint.f33195e;
                    layout9.f33251w = H(typedArray, index, layout9.f33251w);
                    break;
                case 11:
                    Layout layout10 = constraint.f33195e;
                    layout10.R = typedArray.getDimensionPixelSize(index, layout10.R);
                    break;
                case 12:
                    Layout layout11 = constraint.f33195e;
                    layout11.S = typedArray.getDimensionPixelSize(index, layout11.S);
                    break;
                case 13:
                    Layout layout12 = constraint.f33195e;
                    layout12.O = typedArray.getDimensionPixelSize(index, layout12.O);
                    break;
                case 14:
                    Layout layout13 = constraint.f33195e;
                    layout13.Q = typedArray.getDimensionPixelSize(index, layout13.Q);
                    break;
                case 15:
                    Layout layout14 = constraint.f33195e;
                    layout14.T = typedArray.getDimensionPixelSize(index, layout14.T);
                    break;
                case 16:
                    Layout layout15 = constraint.f33195e;
                    layout15.P = typedArray.getDimensionPixelSize(index, layout15.P);
                    break;
                case 17:
                    Layout layout16 = constraint.f33195e;
                    layout16.f33222f = typedArray.getDimensionPixelOffset(index, layout16.f33222f);
                    break;
                case 18:
                    Layout layout17 = constraint.f33195e;
                    layout17.f33224g = typedArray.getDimensionPixelOffset(index, layout17.f33224g);
                    break;
                case 19:
                    Layout layout18 = constraint.f33195e;
                    layout18.f33226h = typedArray.getFloat(index, layout18.f33226h);
                    break;
                case 20:
                    Layout layout19 = constraint.f33195e;
                    layout19.f33253y = typedArray.getFloat(index, layout19.f33253y);
                    break;
                case 21:
                    Layout layout20 = constraint.f33195e;
                    layout20.f33220e = typedArray.getLayoutDimension(index, layout20.f33220e);
                    break;
                case 22:
                    PropertySet propertySet = constraint.f33193c;
                    propertySet.f33271b = typedArray.getInt(index, propertySet.f33271b);
                    PropertySet propertySet2 = constraint.f33193c;
                    propertySet2.f33271b = f33181h[propertySet2.f33271b];
                    break;
                case 23:
                    Layout layout21 = constraint.f33195e;
                    layout21.f33218d = typedArray.getLayoutDimension(index, layout21.f33218d);
                    break;
                case 24:
                    Layout layout22 = constraint.f33195e;
                    layout22.H = typedArray.getDimensionPixelSize(index, layout22.H);
                    break;
                case 25:
                    Layout layout23 = constraint.f33195e;
                    layout23.f33230j = H(typedArray, index, layout23.f33230j);
                    break;
                case 26:
                    Layout layout24 = constraint.f33195e;
                    layout24.f33232k = H(typedArray, index, layout24.f33232k);
                    break;
                case 27:
                    Layout layout25 = constraint.f33195e;
                    layout25.G = typedArray.getInt(index, layout25.G);
                    break;
                case 28:
                    Layout layout26 = constraint.f33195e;
                    layout26.I = typedArray.getDimensionPixelSize(index, layout26.I);
                    break;
                case 29:
                    Layout layout27 = constraint.f33195e;
                    layout27.f33234l = H(typedArray, index, layout27.f33234l);
                    break;
                case 30:
                    Layout layout28 = constraint.f33195e;
                    layout28.f33236m = H(typedArray, index, layout28.f33236m);
                    break;
                case 31:
                    Layout layout29 = constraint.f33195e;
                    layout29.M = typedArray.getDimensionPixelSize(index, layout29.M);
                    break;
                case 32:
                    Layout layout30 = constraint.f33195e;
                    layout30.f33249u = H(typedArray, index, layout30.f33249u);
                    break;
                case 33:
                    Layout layout31 = constraint.f33195e;
                    layout31.f33250v = H(typedArray, index, layout31.f33250v);
                    break;
                case 34:
                    Layout layout32 = constraint.f33195e;
                    layout32.J = typedArray.getDimensionPixelSize(index, layout32.J);
                    break;
                case 35:
                    Layout layout33 = constraint.f33195e;
                    layout33.f33240o = H(typedArray, index, layout33.f33240o);
                    break;
                case 36:
                    Layout layout34 = constraint.f33195e;
                    layout34.f33238n = H(typedArray, index, layout34.f33238n);
                    break;
                case 37:
                    Layout layout35 = constraint.f33195e;
                    layout35.f33254z = typedArray.getFloat(index, layout35.f33254z);
                    break;
                case 38:
                    constraint.f33191a = typedArray.getResourceId(index, constraint.f33191a);
                    break;
                case 39:
                    Layout layout36 = constraint.f33195e;
                    layout36.W = typedArray.getFloat(index, layout36.W);
                    break;
                case 40:
                    Layout layout37 = constraint.f33195e;
                    layout37.V = typedArray.getFloat(index, layout37.V);
                    break;
                case 41:
                    Layout layout38 = constraint.f33195e;
                    layout38.X = typedArray.getInt(index, layout38.X);
                    break;
                case 42:
                    Layout layout39 = constraint.f33195e;
                    layout39.Y = typedArray.getInt(index, layout39.Y);
                    break;
                case 43:
                    PropertySet propertySet3 = constraint.f33193c;
                    propertySet3.f33273d = typedArray.getFloat(index, propertySet3.f33273d);
                    break;
                case 44:
                    Transform transform = constraint.f33196f;
                    transform.f33288m = true;
                    transform.f33289n = typedArray.getDimension(index, transform.f33289n);
                    break;
                case 45:
                    Transform transform2 = constraint.f33196f;
                    transform2.f33278c = typedArray.getFloat(index, transform2.f33278c);
                    break;
                case 46:
                    Transform transform3 = constraint.f33196f;
                    transform3.f33279d = typedArray.getFloat(index, transform3.f33279d);
                    break;
                case 47:
                    Transform transform4 = constraint.f33196f;
                    transform4.f33280e = typedArray.getFloat(index, transform4.f33280e);
                    break;
                case 48:
                    Transform transform5 = constraint.f33196f;
                    transform5.f33281f = typedArray.getFloat(index, transform5.f33281f);
                    break;
                case 49:
                    Transform transform6 = constraint.f33196f;
                    transform6.f33282g = typedArray.getDimension(index, transform6.f33282g);
                    break;
                case 50:
                    Transform transform7 = constraint.f33196f;
                    transform7.f33283h = typedArray.getDimension(index, transform7.f33283h);
                    break;
                case 51:
                    Transform transform8 = constraint.f33196f;
                    transform8.f33285j = typedArray.getDimension(index, transform8.f33285j);
                    break;
                case 52:
                    Transform transform9 = constraint.f33196f;
                    transform9.f33286k = typedArray.getDimension(index, transform9.f33286k);
                    break;
                case 53:
                    Transform transform10 = constraint.f33196f;
                    transform10.f33287l = typedArray.getDimension(index, transform10.f33287l);
                    break;
                case 54:
                    Layout layout40 = constraint.f33195e;
                    layout40.Z = typedArray.getInt(index, layout40.Z);
                    break;
                case 55:
                    Layout layout41 = constraint.f33195e;
                    layout41.f33213a0 = typedArray.getInt(index, layout41.f33213a0);
                    break;
                case 56:
                    Layout layout42 = constraint.f33195e;
                    layout42.f33215b0 = typedArray.getDimensionPixelSize(index, layout42.f33215b0);
                    break;
                case 57:
                    Layout layout43 = constraint.f33195e;
                    layout43.f33217c0 = typedArray.getDimensionPixelSize(index, layout43.f33217c0);
                    break;
                case 58:
                    Layout layout44 = constraint.f33195e;
                    layout44.f33219d0 = typedArray.getDimensionPixelSize(index, layout44.f33219d0);
                    break;
                case 59:
                    Layout layout45 = constraint.f33195e;
                    layout45.f33221e0 = typedArray.getDimensionPixelSize(index, layout45.f33221e0);
                    break;
                case 60:
                    Transform transform11 = constraint.f33196f;
                    transform11.f33277b = typedArray.getFloat(index, transform11.f33277b);
                    break;
                case 61:
                    Layout layout46 = constraint.f33195e;
                    layout46.B = H(typedArray, index, layout46.B);
                    break;
                case 62:
                    Layout layout47 = constraint.f33195e;
                    layout47.C = typedArray.getDimensionPixelSize(index, layout47.C);
                    break;
                case 63:
                    Layout layout48 = constraint.f33195e;
                    layout48.D = typedArray.getFloat(index, layout48.D);
                    break;
                case 64:
                    Motion motion = constraint.f33194d;
                    motion.f33257b = H(typedArray, index, motion.f33257b);
                    break;
                case 65:
                    if (typedArray.peekValue(index).type == 3) {
                        constraint.f33194d.f33259d = typedArray.getString(index);
                    } else {
                        constraint.f33194d.f33259d = Easing.f31744c[typedArray.getInteger(index, 0)];
                    }
                    break;
                case 66:
                    constraint.f33194d.f33261f = typedArray.getInt(index, 0);
                    break;
                case 67:
                    Motion motion2 = constraint.f33194d;
                    motion2.f33264i = typedArray.getFloat(index, motion2.f33264i);
                    break;
                case 68:
                    PropertySet propertySet4 = constraint.f33193c;
                    propertySet4.f33274e = typedArray.getFloat(index, propertySet4.f33274e);
                    break;
                case 69:
                    constraint.f33195e.f33223f0 = typedArray.getFloat(index, 1.0f);
                    break;
                case 70:
                    constraint.f33195e.f33225g0 = typedArray.getFloat(index, 1.0f);
                    break;
                case 71:
                    Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                    break;
                case 72:
                    Layout layout49 = constraint.f33195e;
                    layout49.f33227h0 = typedArray.getInt(index, layout49.f33227h0);
                    break;
                case 73:
                    Layout layout50 = constraint.f33195e;
                    layout50.f33229i0 = typedArray.getDimensionPixelSize(index, layout50.f33229i0);
                    break;
                case 74:
                    constraint.f33195e.f33235l0 = typedArray.getString(index);
                    break;
                case 75:
                    Layout layout51 = constraint.f33195e;
                    layout51.f33243p0 = typedArray.getBoolean(index, layout51.f33243p0);
                    break;
                case 76:
                    Motion motion3 = constraint.f33194d;
                    motion3.f33260e = typedArray.getInt(index, motion3.f33260e);
                    break;
                case 77:
                    constraint.f33195e.f33237m0 = typedArray.getString(index);
                    break;
                case 78:
                    PropertySet propertySet5 = constraint.f33193c;
                    propertySet5.f33272c = typedArray.getInt(index, propertySet5.f33272c);
                    break;
                case 79:
                    Motion motion4 = constraint.f33194d;
                    motion4.f33262g = typedArray.getFloat(index, motion4.f33262g);
                    break;
                case 80:
                    Layout layout52 = constraint.f33195e;
                    layout52.f33239n0 = typedArray.getBoolean(index, layout52.f33239n0);
                    break;
                case 81:
                    Layout layout53 = constraint.f33195e;
                    layout53.f33241o0 = typedArray.getBoolean(index, layout53.f33241o0);
                    break;
                case 82:
                    Motion motion5 = constraint.f33194d;
                    motion5.f33258c = typedArray.getInteger(index, motion5.f33258c);
                    break;
                case 83:
                    Transform transform12 = constraint.f33196f;
                    transform12.f33284i = H(typedArray, index, transform12.f33284i);
                    break;
                case 84:
                    Motion motion6 = constraint.f33194d;
                    motion6.f33266k = typedArray.getInteger(index, motion6.f33266k);
                    break;
                case 85:
                    Motion motion7 = constraint.f33194d;
                    motion7.f33265j = typedArray.getFloat(index, motion7.f33265j);
                    break;
                case 86:
                    int i4 = typedArray.peekValue(index).type;
                    if (i4 == 1) {
                        constraint.f33194d.f33269n = typedArray.getResourceId(index, -1);
                        Motion motion8 = constraint.f33194d;
                        if (motion8.f33269n != -1) {
                            motion8.f33268m = -2;
                        }
                    } else if (i4 == 3) {
                        constraint.f33194d.f33267l = typedArray.getString(index);
                        if (constraint.f33194d.f33267l.indexOf("/") > 0) {
                            constraint.f33194d.f33269n = typedArray.getResourceId(index, -1);
                            constraint.f33194d.f33268m = -2;
                        } else {
                            constraint.f33194d.f33268m = -1;
                        }
                    } else {
                        Motion motion9 = constraint.f33194d;
                        motion9.f33268m = typedArray.getInteger(index, motion9.f33269n);
                    }
                    break;
                case 87:
                    Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + f33182i.get(index));
                    break;
                case 88:
                case 89:
                case 90:
                default:
                    Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + f33182i.get(index));
                    break;
                case 91:
                    Layout layout54 = constraint.f33195e;
                    layout54.f33247s = H(typedArray, index, layout54.f33247s);
                    break;
                case 92:
                    Layout layout55 = constraint.f33195e;
                    layout55.f33248t = H(typedArray, index, layout55.f33248t);
                    break;
                case 93:
                    Layout layout56 = constraint.f33195e;
                    layout56.N = typedArray.getDimensionPixelSize(index, layout56.N);
                    break;
                case 94:
                    Layout layout57 = constraint.f33195e;
                    layout57.U = typedArray.getDimensionPixelSize(index, layout57.U);
                    break;
                case 95:
                    I(constraint.f33195e, typedArray, index, 0);
                    break;
                case 96:
                    I(constraint.f33195e, typedArray, index, 1);
                    break;
                case 97:
                    Layout layout58 = constraint.f33195e;
                    layout58.f33245q0 = typedArray.getInt(index, layout58.f33245q0);
                    break;
            }
        }
        Layout layout59 = constraint.f33195e;
        if (layout59.f33235l0 != null) {
            layout59.f33233k0 = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void P(Constraint constraint, int i3, float f3) {
        if (i3 == 19) {
            constraint.f33195e.f33226h = f3;
            return;
        }
        if (i3 == 20) {
            constraint.f33195e.f33253y = f3;
            return;
        }
        if (i3 == 37) {
            constraint.f33195e.f33254z = f3;
            return;
        }
        if (i3 == 60) {
            constraint.f33196f.f33277b = f3;
            return;
        }
        if (i3 == 63) {
            constraint.f33195e.D = f3;
            return;
        }
        if (i3 == 79) {
            constraint.f33194d.f33262g = f3;
            return;
        }
        if (i3 == 85) {
            constraint.f33194d.f33265j = f3;
            return;
        }
        if (i3 != 87) {
            if (i3 == 39) {
                constraint.f33195e.W = f3;
                return;
            }
            if (i3 == 40) {
                constraint.f33195e.V = f3;
                return;
            }
            switch (i3) {
                case 43:
                    constraint.f33193c.f33273d = f3;
                    break;
                case 44:
                    Transform transform = constraint.f33196f;
                    transform.f33289n = f3;
                    transform.f33288m = true;
                    break;
                case 45:
                    constraint.f33196f.f33278c = f3;
                    break;
                case 46:
                    constraint.f33196f.f33279d = f3;
                    break;
                case 47:
                    constraint.f33196f.f33280e = f3;
                    break;
                case 48:
                    constraint.f33196f.f33281f = f3;
                    break;
                case 49:
                    constraint.f33196f.f33282g = f3;
                    break;
                case 50:
                    constraint.f33196f.f33283h = f3;
                    break;
                case 51:
                    constraint.f33196f.f33285j = f3;
                    break;
                case 52:
                    constraint.f33196f.f33286k = f3;
                    break;
                case 53:
                    constraint.f33196f.f33287l = f3;
                    break;
                default:
                    switch (i3) {
                        case 67:
                            constraint.f33194d.f33264i = f3;
                            break;
                        case 68:
                            constraint.f33193c.f33274e = f3;
                            break;
                        case 69:
                            constraint.f33195e.f33223f0 = f3;
                            break;
                        case 70:
                            constraint.f33195e.f33225g0 = f3;
                            break;
                        default:
                            Log.w("ConstraintSet", "Unknown attribute 0x");
                            break;
                    }
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Q(Constraint constraint, int i3, int i4) {
        if (i3 == 6) {
            constraint.f33195e.E = i4;
            return;
        }
        if (i3 == 7) {
            constraint.f33195e.F = i4;
            return;
        }
        if (i3 == 8) {
            constraint.f33195e.L = i4;
            return;
        }
        if (i3 == 27) {
            constraint.f33195e.G = i4;
            return;
        }
        if (i3 == 28) {
            constraint.f33195e.I = i4;
            return;
        }
        if (i3 == 41) {
            constraint.f33195e.X = i4;
            return;
        }
        if (i3 == 42) {
            constraint.f33195e.Y = i4;
            return;
        }
        if (i3 == 61) {
            constraint.f33195e.B = i4;
            return;
        }
        if (i3 == 62) {
            constraint.f33195e.C = i4;
            return;
        }
        if (i3 == 72) {
            constraint.f33195e.f33227h0 = i4;
            return;
        }
        if (i3 == 73) {
            constraint.f33195e.f33229i0 = i4;
            return;
        }
        switch (i3) {
            case 2:
                constraint.f33195e.K = i4;
                break;
            case 11:
                constraint.f33195e.R = i4;
                break;
            case 12:
                constraint.f33195e.S = i4;
                break;
            case 13:
                constraint.f33195e.O = i4;
                break;
            case 14:
                constraint.f33195e.Q = i4;
                break;
            case 15:
                constraint.f33195e.T = i4;
                break;
            case 16:
                constraint.f33195e.P = i4;
                break;
            case 17:
                constraint.f33195e.f33222f = i4;
                break;
            case 18:
                constraint.f33195e.f33224g = i4;
                break;
            case 31:
                constraint.f33195e.M = i4;
                break;
            case 34:
                constraint.f33195e.J = i4;
                break;
            case 38:
                constraint.f33191a = i4;
                break;
            case 64:
                constraint.f33194d.f33257b = i4;
                break;
            case 66:
                constraint.f33194d.f33261f = i4;
                break;
            case 76:
                constraint.f33194d.f33260e = i4;
                break;
            case 78:
                constraint.f33193c.f33272c = i4;
                break;
            case 93:
                constraint.f33195e.N = i4;
                break;
            case 94:
                constraint.f33195e.U = i4;
                break;
            case 97:
                constraint.f33195e.f33245q0 = i4;
                break;
            default:
                switch (i3) {
                    case 21:
                        constraint.f33195e.f33220e = i4;
                        break;
                    case 22:
                        constraint.f33193c.f33271b = i4;
                        break;
                    case 23:
                        constraint.f33195e.f33218d = i4;
                        break;
                    case 24:
                        constraint.f33195e.H = i4;
                        break;
                    default:
                        switch (i3) {
                            case 54:
                                constraint.f33195e.Z = i4;
                                break;
                            case 55:
                                constraint.f33195e.f33213a0 = i4;
                                break;
                            case 56:
                                constraint.f33195e.f33215b0 = i4;
                                break;
                            case 57:
                                constraint.f33195e.f33217c0 = i4;
                                break;
                            case 58:
                                constraint.f33195e.f33219d0 = i4;
                                break;
                            case 59:
                                constraint.f33195e.f33221e0 = i4;
                                break;
                            default:
                                switch (i3) {
                                    case 82:
                                        constraint.f33194d.f33258c = i4;
                                        break;
                                    case 83:
                                        constraint.f33196f.f33284i = i4;
                                        break;
                                    case 84:
                                        constraint.f33194d.f33266k = i4;
                                        break;
                                    default:
                                        switch (i3) {
                                            case 87:
                                                break;
                                            case 88:
                                                constraint.f33194d.f33268m = i4;
                                                break;
                                            case 89:
                                                constraint.f33194d.f33269n = i4;
                                                break;
                                            default:
                                                Log.w("ConstraintSet", "Unknown attribute 0x");
                                                break;
                                        }
                                        break;
                                }
                                break;
                        }
                        break;
                }
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void R(Constraint constraint, int i3, String str) {
        if (i3 == 5) {
            constraint.f33195e.A = str;
            return;
        }
        if (i3 == 65) {
            constraint.f33194d.f33259d = str;
            return;
        }
        if (i3 == 74) {
            Layout layout = constraint.f33195e;
            layout.f33235l0 = str;
            layout.f33233k0 = null;
        } else if (i3 == 77) {
            constraint.f33195e.f33237m0 = str;
        } else if (i3 != 87) {
            if (i3 != 90) {
                Log.w("ConstraintSet", "Unknown attribute 0x");
            } else {
                constraint.f33194d.f33267l = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void S(Constraint constraint, int i3, boolean z2) {
        if (i3 == 44) {
            constraint.f33196f.f33288m = z2;
            return;
        }
        if (i3 == 75) {
            constraint.f33195e.f33243p0 = z2;
            return;
        }
        if (i3 != 87) {
            if (i3 == 80) {
                constraint.f33195e.f33239n0 = z2;
            } else if (i3 != 81) {
                Log.w("ConstraintSet", "Unknown attribute 0x");
            } else {
                constraint.f33195e.f33241o0 = z2;
            }
        }
    }

    private String V(int i3) {
        switch (i3) {
            case 1:
                return ViewHierarchyConstants.DIMENSION_LEFT_KEY;
            case 2:
                return "right";
            case 3:
                return ViewHierarchyConstants.DIMENSION_TOP_KEY;
            case 4:
                return "bottom";
            case 5:
                return "baseline";
            case 6:
                return "start";
            case 7:
                return "end";
            default:
                return "undefined";
        }
    }

    public static Constraint m(Context context, XmlPullParser xmlPullParser) {
        AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xmlPullParser);
        Constraint constraint = new Constraint();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSetAsAttributeSet, R.styleable.p3);
        M(context, constraint, typedArrayObtainStyledAttributes);
        typedArrayObtainStyledAttributes.recycle();
        return constraint;
    }

    private int[] w(View view, String str) {
        int iIntValue;
        Object designInformation;
        String[] strArrSplit = str.split(",");
        Context context = view.getContext();
        int[] iArr = new int[strArrSplit.length];
        int i3 = 0;
        int i4 = 0;
        while (i3 < strArrSplit.length) {
            String strTrim = strArrSplit[i3].trim();
            try {
                iIntValue = R.id.class.getField(strTrim).getInt(null);
            } catch (Exception unused) {
                iIntValue = 0;
            }
            if (iIntValue == 0) {
                iIntValue = context.getResources().getIdentifier(strTrim, "id", context.getPackageName());
            }
            if (iIntValue == 0 && view.isInEditMode() && (view.getParent() instanceof ConstraintLayout) && (designInformation = ((ConstraintLayout) view.getParent()).getDesignInformation(0, strTrim)) != null && (designInformation instanceof Integer)) {
                iIntValue = ((Integer) designInformation).intValue();
            }
            iArr[i4] = iIntValue;
            i3++;
            i4++;
        }
        return i4 != strArrSplit.length ? Arrays.copyOf(iArr, i4) : iArr;
    }

    private Constraint x(Context context, AttributeSet attributeSet, boolean z2) {
        Constraint constraint = new Constraint();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, z2 ? R.styleable.p3 : R.styleable.f33374t);
        L(context, constraint, typedArrayObtainStyledAttributes, z2);
        typedArrayObtainStyledAttributes.recycle();
        return constraint;
    }

    private Constraint y(int i3) {
        if (!this.f33190g.containsKey(Integer.valueOf(i3))) {
            this.f33190g.put(Integer.valueOf(i3), new Constraint());
        }
        return (Constraint) this.f33190g.get(Integer.valueOf(i3));
    }

    public int A(int i3) {
        return y(i3).f33195e.f33220e;
    }

    public Constraint B(int i3) {
        return y(i3);
    }

    public int C(int i3) {
        return y(i3).f33193c.f33271b;
    }

    public int D(int i3) {
        return y(i3).f33193c.f33272c;
    }

    public int E(int i3) {
        return y(i3).f33195e.f33218d;
    }

    public void F(Context context, int i3) {
        XmlResourceParser xml = context.getResources().getXml(i3);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    Constraint constraintX = x(context, Xml.asAttributeSet(xml), false);
                    if (name.equalsIgnoreCase("Guideline")) {
                        constraintX.f33195e.f33212a = true;
                    }
                    this.f33190g.put(Integer.valueOf(constraintX.f33191a), constraintX);
                }
            }
        } catch (IOException e3) {
            e3.printStackTrace();
        } catch (XmlPullParserException e4) {
            e4.printStackTrace();
        }
    }

    public void N(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = constraintLayout.getChildAt(i3);
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) childAt.getLayoutParams();
            int id = childAt.getId();
            if (this.f33189f && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!this.f33190g.containsKey(Integer.valueOf(id))) {
                this.f33190g.put(Integer.valueOf(id), new Constraint());
            }
            Constraint constraint = (Constraint) this.f33190g.get(Integer.valueOf(id));
            if (constraint != null) {
                if (!constraint.f33195e.f33214b) {
                    constraint.g(id, layoutParams);
                    if (childAt instanceof ConstraintHelper) {
                        constraint.f33195e.f33233k0 = ((ConstraintHelper) childAt).getReferencedIds();
                        if (childAt instanceof Barrier) {
                            Barrier barrier = (Barrier) childAt;
                            constraint.f33195e.f33243p0 = barrier.getAllowsGoneWidget();
                            constraint.f33195e.f33227h0 = barrier.getType();
                            constraint.f33195e.f33229i0 = barrier.getMargin();
                        }
                    }
                    constraint.f33195e.f33214b = true;
                }
                PropertySet propertySet = constraint.f33193c;
                if (!propertySet.f33270a) {
                    propertySet.f33271b = childAt.getVisibility();
                    constraint.f33193c.f33273d = childAt.getAlpha();
                    constraint.f33193c.f33270a = true;
                }
                Transform transform = constraint.f33196f;
                if (!transform.f33276a) {
                    transform.f33276a = true;
                    transform.f33277b = childAt.getRotation();
                    constraint.f33196f.f33278c = childAt.getRotationX();
                    constraint.f33196f.f33279d = childAt.getRotationY();
                    constraint.f33196f.f33280e = childAt.getScaleX();
                    constraint.f33196f.f33281f = childAt.getScaleY();
                    float pivotX = childAt.getPivotX();
                    float pivotY = childAt.getPivotY();
                    if (pivotX != 0.0d || pivotY != 0.0d) {
                        Transform transform2 = constraint.f33196f;
                        transform2.f33282g = pivotX;
                        transform2.f33283h = pivotY;
                    }
                    constraint.f33196f.f33285j = childAt.getTranslationX();
                    constraint.f33196f.f33286k = childAt.getTranslationY();
                    constraint.f33196f.f33287l = childAt.getTranslationZ();
                    Transform transform3 = constraint.f33196f;
                    if (transform3.f33288m) {
                        transform3.f33289n = childAt.getElevation();
                    }
                }
            }
        }
    }

    public void O(ConstraintSet constraintSet) {
        for (Integer num : constraintSet.f33190g.keySet()) {
            num.intValue();
            Constraint constraint = (Constraint) constraintSet.f33190g.get(num);
            if (!this.f33190g.containsKey(num)) {
                this.f33190g.put(num, new Constraint());
            }
            Constraint constraint2 = (Constraint) this.f33190g.get(num);
            if (constraint2 != null) {
                Layout layout = constraint2.f33195e;
                if (!layout.f33214b) {
                    layout.a(constraint.f33195e);
                }
                PropertySet propertySet = constraint2.f33193c;
                if (!propertySet.f33270a) {
                    propertySet.a(constraint.f33193c);
                }
                Transform transform = constraint2.f33196f;
                if (!transform.f33276a) {
                    transform.a(constraint.f33196f);
                }
                Motion motion = constraint2.f33194d;
                if (!motion.f33256a) {
                    motion.a(constraint.f33194d);
                }
                for (String str : constraint.f33197g.keySet()) {
                    if (!constraint2.f33197g.containsKey(str)) {
                        constraint2.f33197g.put(str, (ConstraintAttribute) constraint.f33197g.get(str));
                    }
                }
            }
        }
    }

    public void T(boolean z2) {
        this.f33189f = z2;
    }

    public void U(boolean z2) {
        this.f33184a = z2;
    }

    public void g(ConstraintLayout constraintLayout) {
        Constraint constraint;
        int childCount = constraintLayout.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = constraintLayout.getChildAt(i3);
            int id = childAt.getId();
            if (!this.f33190g.containsKey(Integer.valueOf(id))) {
                Log.w("ConstraintSet", "id unknown " + Debug.d(childAt));
            } else {
                if (this.f33189f && id == -1) {
                    throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                }
                if (this.f33190g.containsKey(Integer.valueOf(id)) && (constraint = (Constraint) this.f33190g.get(Integer.valueOf(id))) != null) {
                    ConstraintAttribute.j(childAt, constraint.f33197g);
                }
            }
        }
    }

    public void h(ConstraintSet constraintSet) {
        for (Constraint constraint : constraintSet.f33190g.values()) {
            if (constraint.f33198h != null) {
                if (constraint.f33192b != null) {
                    Iterator it = this.f33190g.keySet().iterator();
                    while (it.hasNext()) {
                        Constraint constraintZ = z(((Integer) it.next()).intValue());
                        String str = constraintZ.f33195e.f33237m0;
                        if (str != null && constraint.f33192b.matches(str)) {
                            constraint.f33198h.e(constraintZ);
                            constraintZ.f33197g.putAll((HashMap) constraint.f33197g.clone());
                        }
                    }
                } else {
                    constraint.f33198h.e(z(constraint.f33191a));
                }
            }
        }
    }

    public void i(ConstraintLayout constraintLayout) {
        k(constraintLayout, true);
        constraintLayout.setConstraintSet(null);
        constraintLayout.requestLayout();
    }

    public void j(ConstraintHelper constraintHelper, ConstraintWidget constraintWidget, ConstraintLayout.LayoutParams layoutParams, SparseArray sparseArray) {
        Constraint constraint;
        int id = constraintHelper.getId();
        if (this.f33190g.containsKey(Integer.valueOf(id)) && (constraint = (Constraint) this.f33190g.get(Integer.valueOf(id))) != null && (constraintWidget instanceof HelperWidget)) {
            constraintHelper.p(constraint, (HelperWidget) constraintWidget, layoutParams, sparseArray);
        }
    }

    void k(ConstraintLayout constraintLayout, boolean z2) {
        int childCount = constraintLayout.getChildCount();
        HashSet<Integer> hashSet = new HashSet(this.f33190g.keySet());
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = constraintLayout.getChildAt(i3);
            int id = childAt.getId();
            if (!this.f33190g.containsKey(Integer.valueOf(id))) {
                Log.w("ConstraintSet", "id unknown " + Debug.d(childAt));
            } else {
                if (this.f33189f && id == -1) {
                    throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                }
                if (id != -1) {
                    if (this.f33190g.containsKey(Integer.valueOf(id))) {
                        hashSet.remove(Integer.valueOf(id));
                        Constraint constraint = (Constraint) this.f33190g.get(Integer.valueOf(id));
                        if (constraint != null) {
                            if (childAt instanceof Barrier) {
                                constraint.f33195e.f33231j0 = 1;
                                Barrier barrier = (Barrier) childAt;
                                barrier.setId(id);
                                barrier.setType(constraint.f33195e.f33227h0);
                                barrier.setMargin(constraint.f33195e.f33229i0);
                                barrier.setAllowsGoneWidget(constraint.f33195e.f33243p0);
                                Layout layout = constraint.f33195e;
                                int[] iArr = layout.f33233k0;
                                if (iArr != null) {
                                    barrier.setReferencedIds(iArr);
                                } else {
                                    String str = layout.f33235l0;
                                    if (str != null) {
                                        layout.f33233k0 = w(barrier, str);
                                        barrier.setReferencedIds(constraint.f33195e.f33233k0);
                                    }
                                }
                            }
                            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) childAt.getLayoutParams();
                            layoutParams.c();
                            constraint.e(layoutParams);
                            if (z2) {
                                ConstraintAttribute.j(childAt, constraint.f33197g);
                            }
                            childAt.setLayoutParams(layoutParams);
                            PropertySet propertySet = constraint.f33193c;
                            if (propertySet.f33272c == 0) {
                                childAt.setVisibility(propertySet.f33271b);
                            }
                            childAt.setAlpha(constraint.f33193c.f33273d);
                            childAt.setRotation(constraint.f33196f.f33277b);
                            childAt.setRotationX(constraint.f33196f.f33278c);
                            childAt.setRotationY(constraint.f33196f.f33279d);
                            childAt.setScaleX(constraint.f33196f.f33280e);
                            childAt.setScaleY(constraint.f33196f.f33281f);
                            Transform transform = constraint.f33196f;
                            if (transform.f33284i != -1) {
                                if (((View) childAt.getParent()).findViewById(constraint.f33196f.f33284i) != null) {
                                    float top = (r4.getTop() + r4.getBottom()) / 2.0f;
                                    float left = (r4.getLeft() + r4.getRight()) / 2.0f;
                                    if (childAt.getRight() - childAt.getLeft() > 0 && childAt.getBottom() - childAt.getTop() > 0) {
                                        childAt.setPivotX(left - childAt.getLeft());
                                        childAt.setPivotY(top - childAt.getTop());
                                    }
                                }
                            } else {
                                if (!Float.isNaN(transform.f33282g)) {
                                    childAt.setPivotX(constraint.f33196f.f33282g);
                                }
                                if (!Float.isNaN(constraint.f33196f.f33283h)) {
                                    childAt.setPivotY(constraint.f33196f.f33283h);
                                }
                            }
                            childAt.setTranslationX(constraint.f33196f.f33285j);
                            childAt.setTranslationY(constraint.f33196f.f33286k);
                            childAt.setTranslationZ(constraint.f33196f.f33287l);
                            Transform transform2 = constraint.f33196f;
                            if (transform2.f33288m) {
                                childAt.setElevation(transform2.f33289n);
                            }
                        }
                    } else {
                        Log.v("ConstraintSet", "WARNING NO CONSTRAINTS for view " + id);
                    }
                }
            }
        }
        for (Integer num : hashSet) {
            Constraint constraint2 = (Constraint) this.f33190g.get(num);
            if (constraint2 != null) {
                if (constraint2.f33195e.f33231j0 == 1) {
                    Barrier barrier2 = new Barrier(constraintLayout.getContext());
                    barrier2.setId(num.intValue());
                    Layout layout2 = constraint2.f33195e;
                    int[] iArr2 = layout2.f33233k0;
                    if (iArr2 != null) {
                        barrier2.setReferencedIds(iArr2);
                    } else {
                        String str2 = layout2.f33235l0;
                        if (str2 != null) {
                            layout2.f33233k0 = w(barrier2, str2);
                            barrier2.setReferencedIds(constraint2.f33195e.f33233k0);
                        }
                    }
                    barrier2.setType(constraint2.f33195e.f33227h0);
                    barrier2.setMargin(constraint2.f33195e.f33229i0);
                    ConstraintLayout.LayoutParams layoutParamsGenerateDefaultLayoutParams = constraintLayout.generateDefaultLayoutParams();
                    barrier2.w();
                    constraint2.e(layoutParamsGenerateDefaultLayoutParams);
                    constraintLayout.addView(barrier2, layoutParamsGenerateDefaultLayoutParams);
                }
                if (constraint2.f33195e.f33212a) {
                    View guideline = new Guideline(constraintLayout.getContext());
                    guideline.setId(num.intValue());
                    ConstraintLayout.LayoutParams layoutParamsGenerateDefaultLayoutParams2 = constraintLayout.generateDefaultLayoutParams();
                    constraint2.e(layoutParamsGenerateDefaultLayoutParams2);
                    constraintLayout.addView(guideline, layoutParamsGenerateDefaultLayoutParams2);
                }
            }
        }
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt2 = constraintLayout.getChildAt(i4);
            if (childAt2 instanceof ConstraintHelper) {
                ((ConstraintHelper) childAt2).j(constraintLayout);
            }
        }
    }

    public void l(int i3, ConstraintLayout.LayoutParams layoutParams) {
        Constraint constraint;
        if (!this.f33190g.containsKey(Integer.valueOf(i3)) || (constraint = (Constraint) this.f33190g.get(Integer.valueOf(i3))) == null) {
            return;
        }
        constraint.e(layoutParams);
    }

    public void n(Context context, int i3) {
        o((ConstraintLayout) LayoutInflater.from(context).inflate(i3, (ViewGroup) null));
    }

    public void o(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        this.f33190g.clear();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = constraintLayout.getChildAt(i3);
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) childAt.getLayoutParams();
            int id = childAt.getId();
            if (this.f33189f && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!this.f33190g.containsKey(Integer.valueOf(id))) {
                this.f33190g.put(Integer.valueOf(id), new Constraint());
            }
            Constraint constraint = (Constraint) this.f33190g.get(Integer.valueOf(id));
            if (constraint != null) {
                constraint.f33197g = ConstraintAttribute.b(this.f33188e, childAt);
                constraint.g(id, layoutParams);
                constraint.f33193c.f33271b = childAt.getVisibility();
                constraint.f33193c.f33273d = childAt.getAlpha();
                constraint.f33196f.f33277b = childAt.getRotation();
                constraint.f33196f.f33278c = childAt.getRotationX();
                constraint.f33196f.f33279d = childAt.getRotationY();
                constraint.f33196f.f33280e = childAt.getScaleX();
                constraint.f33196f.f33281f = childAt.getScaleY();
                float pivotX = childAt.getPivotX();
                float pivotY = childAt.getPivotY();
                if (pivotX != 0.0d || pivotY != 0.0d) {
                    Transform transform = constraint.f33196f;
                    transform.f33282g = pivotX;
                    transform.f33283h = pivotY;
                }
                constraint.f33196f.f33285j = childAt.getTranslationX();
                constraint.f33196f.f33286k = childAt.getTranslationY();
                constraint.f33196f.f33287l = childAt.getTranslationZ();
                Transform transform2 = constraint.f33196f;
                if (transform2.f33288m) {
                    transform2.f33289n = childAt.getElevation();
                }
                if (childAt instanceof Barrier) {
                    Barrier barrier = (Barrier) childAt;
                    constraint.f33195e.f33243p0 = barrier.getAllowsGoneWidget();
                    constraint.f33195e.f33233k0 = barrier.getReferencedIds();
                    constraint.f33195e.f33227h0 = barrier.getType();
                    constraint.f33195e.f33229i0 = barrier.getMargin();
                }
            }
        }
    }

    public void p(ConstraintSet constraintSet) {
        this.f33190g.clear();
        for (Integer num : constraintSet.f33190g.keySet()) {
            Constraint constraint = (Constraint) constraintSet.f33190g.get(num);
            if (constraint != null) {
                this.f33190g.put(num, constraint.clone());
            }
        }
    }

    public void q(Constraints constraints) {
        int childCount = constraints.getChildCount();
        this.f33190g.clear();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = constraints.getChildAt(i3);
            Constraints.LayoutParams layoutParams = (Constraints.LayoutParams) childAt.getLayoutParams();
            int id = childAt.getId();
            if (this.f33189f && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!this.f33190g.containsKey(Integer.valueOf(id))) {
                this.f33190g.put(Integer.valueOf(id), new Constraint());
            }
            Constraint constraint = (Constraint) this.f33190g.get(Integer.valueOf(id));
            if (constraint != null) {
                if (childAt instanceof ConstraintHelper) {
                    constraint.i((ConstraintHelper) childAt, id, layoutParams);
                }
                constraint.h(id, layoutParams);
            }
        }
    }

    public void r(int i3, int i4, int i5, int i6) {
        if (!this.f33190g.containsKey(Integer.valueOf(i3))) {
            this.f33190g.put(Integer.valueOf(i3), new Constraint());
        }
        Constraint constraint = (Constraint) this.f33190g.get(Integer.valueOf(i3));
        if (constraint == null) {
            return;
        }
        switch (i4) {
            case 1:
                if (i6 == 1) {
                    Layout layout = constraint.f33195e;
                    layout.f33230j = i5;
                    layout.f33232k = -1;
                    return;
                } else if (i6 == 2) {
                    Layout layout2 = constraint.f33195e;
                    layout2.f33232k = i5;
                    layout2.f33230j = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("left to " + V(i6) + " undefined");
                }
            case 2:
                if (i6 == 1) {
                    Layout layout3 = constraint.f33195e;
                    layout3.f33234l = i5;
                    layout3.f33236m = -1;
                    return;
                } else if (i6 == 2) {
                    Layout layout4 = constraint.f33195e;
                    layout4.f33236m = i5;
                    layout4.f33234l = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("right to " + V(i6) + " undefined");
                }
            case 3:
                if (i6 == 3) {
                    Layout layout5 = constraint.f33195e;
                    layout5.f33238n = i5;
                    layout5.f33240o = -1;
                    layout5.f33246r = -1;
                    layout5.f33247s = -1;
                    layout5.f33248t = -1;
                    return;
                }
                if (i6 != 4) {
                    throw new IllegalArgumentException("right to " + V(i6) + " undefined");
                }
                Layout layout6 = constraint.f33195e;
                layout6.f33240o = i5;
                layout6.f33238n = -1;
                layout6.f33246r = -1;
                layout6.f33247s = -1;
                layout6.f33248t = -1;
                return;
            case 4:
                if (i6 == 4) {
                    Layout layout7 = constraint.f33195e;
                    layout7.f33244q = i5;
                    layout7.f33242p = -1;
                    layout7.f33246r = -1;
                    layout7.f33247s = -1;
                    layout7.f33248t = -1;
                    return;
                }
                if (i6 != 3) {
                    throw new IllegalArgumentException("right to " + V(i6) + " undefined");
                }
                Layout layout8 = constraint.f33195e;
                layout8.f33242p = i5;
                layout8.f33244q = -1;
                layout8.f33246r = -1;
                layout8.f33247s = -1;
                layout8.f33248t = -1;
                return;
            case 5:
                if (i6 == 5) {
                    Layout layout9 = constraint.f33195e;
                    layout9.f33246r = i5;
                    layout9.f33244q = -1;
                    layout9.f33242p = -1;
                    layout9.f33238n = -1;
                    layout9.f33240o = -1;
                    return;
                }
                if (i6 == 3) {
                    Layout layout10 = constraint.f33195e;
                    layout10.f33247s = i5;
                    layout10.f33244q = -1;
                    layout10.f33242p = -1;
                    layout10.f33238n = -1;
                    layout10.f33240o = -1;
                    return;
                }
                if (i6 != 4) {
                    throw new IllegalArgumentException("right to " + V(i6) + " undefined");
                }
                Layout layout11 = constraint.f33195e;
                layout11.f33248t = i5;
                layout11.f33244q = -1;
                layout11.f33242p = -1;
                layout11.f33238n = -1;
                layout11.f33240o = -1;
                return;
            case 6:
                if (i6 == 6) {
                    Layout layout12 = constraint.f33195e;
                    layout12.f33250v = i5;
                    layout12.f33249u = -1;
                    return;
                } else if (i6 == 7) {
                    Layout layout13 = constraint.f33195e;
                    layout13.f33249u = i5;
                    layout13.f33250v = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("right to " + V(i6) + " undefined");
                }
            case 7:
                if (i6 == 7) {
                    Layout layout14 = constraint.f33195e;
                    layout14.f33252x = i5;
                    layout14.f33251w = -1;
                    return;
                } else if (i6 == 6) {
                    Layout layout15 = constraint.f33195e;
                    layout15.f33251w = i5;
                    layout15.f33252x = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("right to " + V(i6) + " undefined");
                }
            default:
                throw new IllegalArgumentException(V(i4) + " to " + V(i6) + " unknown");
        }
    }

    public void s(int i3, int i4, int i5, int i6, int i7) {
        if (!this.f33190g.containsKey(Integer.valueOf(i3))) {
            this.f33190g.put(Integer.valueOf(i3), new Constraint());
        }
        Constraint constraint = (Constraint) this.f33190g.get(Integer.valueOf(i3));
        if (constraint == null) {
            return;
        }
        switch (i4) {
            case 1:
                if (i6 == 1) {
                    Layout layout = constraint.f33195e;
                    layout.f33230j = i5;
                    layout.f33232k = -1;
                } else {
                    if (i6 != 2) {
                        throw new IllegalArgumentException("Left to " + V(i6) + " undefined");
                    }
                    Layout layout2 = constraint.f33195e;
                    layout2.f33232k = i5;
                    layout2.f33230j = -1;
                }
                constraint.f33195e.H = i7;
                return;
            case 2:
                if (i6 == 1) {
                    Layout layout3 = constraint.f33195e;
                    layout3.f33234l = i5;
                    layout3.f33236m = -1;
                } else {
                    if (i6 != 2) {
                        throw new IllegalArgumentException("right to " + V(i6) + " undefined");
                    }
                    Layout layout4 = constraint.f33195e;
                    layout4.f33236m = i5;
                    layout4.f33234l = -1;
                }
                constraint.f33195e.I = i7;
                return;
            case 3:
                if (i6 == 3) {
                    Layout layout5 = constraint.f33195e;
                    layout5.f33238n = i5;
                    layout5.f33240o = -1;
                    layout5.f33246r = -1;
                    layout5.f33247s = -1;
                    layout5.f33248t = -1;
                } else {
                    if (i6 != 4) {
                        throw new IllegalArgumentException("right to " + V(i6) + " undefined");
                    }
                    Layout layout6 = constraint.f33195e;
                    layout6.f33240o = i5;
                    layout6.f33238n = -1;
                    layout6.f33246r = -1;
                    layout6.f33247s = -1;
                    layout6.f33248t = -1;
                }
                constraint.f33195e.J = i7;
                return;
            case 4:
                if (i6 == 4) {
                    Layout layout7 = constraint.f33195e;
                    layout7.f33244q = i5;
                    layout7.f33242p = -1;
                    layout7.f33246r = -1;
                    layout7.f33247s = -1;
                    layout7.f33248t = -1;
                } else {
                    if (i6 != 3) {
                        throw new IllegalArgumentException("right to " + V(i6) + " undefined");
                    }
                    Layout layout8 = constraint.f33195e;
                    layout8.f33242p = i5;
                    layout8.f33244q = -1;
                    layout8.f33246r = -1;
                    layout8.f33247s = -1;
                    layout8.f33248t = -1;
                }
                constraint.f33195e.K = i7;
                return;
            case 5:
                if (i6 == 5) {
                    Layout layout9 = constraint.f33195e;
                    layout9.f33246r = i5;
                    layout9.f33244q = -1;
                    layout9.f33242p = -1;
                    layout9.f33238n = -1;
                    layout9.f33240o = -1;
                    return;
                }
                if (i6 == 3) {
                    Layout layout10 = constraint.f33195e;
                    layout10.f33247s = i5;
                    layout10.f33244q = -1;
                    layout10.f33242p = -1;
                    layout10.f33238n = -1;
                    layout10.f33240o = -1;
                    return;
                }
                if (i6 != 4) {
                    throw new IllegalArgumentException("right to " + V(i6) + " undefined");
                }
                Layout layout11 = constraint.f33195e;
                layout11.f33248t = i5;
                layout11.f33244q = -1;
                layout11.f33242p = -1;
                layout11.f33238n = -1;
                layout11.f33240o = -1;
                return;
            case 6:
                if (i6 == 6) {
                    Layout layout12 = constraint.f33195e;
                    layout12.f33250v = i5;
                    layout12.f33249u = -1;
                } else {
                    if (i6 != 7) {
                        throw new IllegalArgumentException("right to " + V(i6) + " undefined");
                    }
                    Layout layout13 = constraint.f33195e;
                    layout13.f33249u = i5;
                    layout13.f33250v = -1;
                }
                constraint.f33195e.M = i7;
                return;
            case 7:
                if (i6 == 7) {
                    Layout layout14 = constraint.f33195e;
                    layout14.f33252x = i5;
                    layout14.f33251w = -1;
                } else {
                    if (i6 != 6) {
                        throw new IllegalArgumentException("right to " + V(i6) + " undefined");
                    }
                    Layout layout15 = constraint.f33195e;
                    layout15.f33251w = i5;
                    layout15.f33252x = -1;
                }
                constraint.f33195e.L = i7;
                return;
            default:
                throw new IllegalArgumentException(V(i4) + " to " + V(i6) + " unknown");
        }
    }

    public void t(int i3, int i4, int i5, float f3) {
        Layout layout = y(i3).f33195e;
        layout.B = i4;
        layout.C = i5;
        layout.D = f3;
    }

    public void u(int i3, int i4) {
        y(i3).f33195e.f33220e = i4;
    }

    public void v(int i3, int i4) {
        y(i3).f33195e.f33218d = i4;
    }

    public Constraint z(int i3) {
        if (this.f33190g.containsKey(Integer.valueOf(i3))) {
            return (Constraint) this.f33190g.get(Integer.valueOf(i3));
        }
        return null;
    }

    static void J(Object obj, String str, int i3) {
        if (str == null) {
            return;
        }
        int iIndexOf = str.indexOf(61);
        int length = str.length();
        if (iIndexOf <= 0 || iIndexOf >= length - 1) {
            return;
        }
        String strSubstring = str.substring(0, iIndexOf);
        String strSubstring2 = str.substring(iIndexOf + 1);
        if (strSubstring2.length() > 0) {
            String strTrim = strSubstring.trim();
            String strTrim2 = strSubstring2.trim();
            if (pMpIcGE.SMMfj.equalsIgnoreCase(strTrim)) {
                if (obj instanceof ConstraintLayout.LayoutParams) {
                    ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) obj;
                    if (i3 == 0) {
                        ((ViewGroup.MarginLayoutParams) layoutParams).width = 0;
                    } else {
                        ((ViewGroup.MarginLayoutParams) layoutParams).height = 0;
                    }
                    K(layoutParams, strTrim2);
                    return;
                }
                if (obj instanceof Layout) {
                    ((Layout) obj).A = strTrim2;
                    return;
                } else {
                    if (obj instanceof Constraint.Delta) {
                        ((Constraint.Delta) obj).c(5, strTrim2);
                        return;
                    }
                    return;
                }
            }
            try {
                if ("weight".equalsIgnoreCase(strTrim)) {
                    float f3 = Float.parseFloat(strTrim2);
                    if (obj instanceof ConstraintLayout.LayoutParams) {
                        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) obj;
                        if (i3 == 0) {
                            ((ViewGroup.MarginLayoutParams) layoutParams2).width = 0;
                            layoutParams2.L = f3;
                            return;
                        } else {
                            ((ViewGroup.MarginLayoutParams) layoutParams2).height = 0;
                            layoutParams2.M = f3;
                            return;
                        }
                    }
                    if (obj instanceof Layout) {
                        Layout layout = (Layout) obj;
                        if (i3 == 0) {
                            layout.f33218d = 0;
                            layout.W = f3;
                            return;
                        } else {
                            layout.f33220e = 0;
                            layout.V = f3;
                            return;
                        }
                    }
                    if (obj instanceof Constraint.Delta) {
                        Constraint.Delta delta = (Constraint.Delta) obj;
                        if (i3 == 0) {
                            delta.b(23, 0);
                            delta.a(39, f3);
                            return;
                        } else {
                            delta.b(21, 0);
                            delta.a(40, f3);
                            return;
                        }
                    }
                    return;
                }
                if ("parent".equalsIgnoreCase(strTrim)) {
                    float fMax = Math.max(0.0f, Math.min(1.0f, Float.parseFloat(strTrim2)));
                    if (obj instanceof ConstraintLayout.LayoutParams) {
                        ConstraintLayout.LayoutParams layoutParams3 = (ConstraintLayout.LayoutParams) obj;
                        if (i3 == 0) {
                            ((ViewGroup.MarginLayoutParams) layoutParams3).width = 0;
                            layoutParams3.V = fMax;
                            layoutParams3.P = 2;
                            return;
                        } else {
                            ((ViewGroup.MarginLayoutParams) layoutParams3).height = 0;
                            layoutParams3.W = fMax;
                            layoutParams3.Q = 2;
                            return;
                        }
                    }
                    if (obj instanceof Layout) {
                        Layout layout2 = (Layout) obj;
                        if (i3 == 0) {
                            layout2.f33218d = 0;
                            layout2.f33223f0 = fMax;
                            layout2.Z = 2;
                            return;
                        } else {
                            layout2.f33220e = 0;
                            layout2.f33225g0 = fMax;
                            layout2.f33213a0 = 2;
                            return;
                        }
                    }
                    if (obj instanceof Constraint.Delta) {
                        Constraint.Delta delta2 = (Constraint.Delta) obj;
                        if (i3 == 0) {
                            delta2.b(23, 0);
                            delta2.b(54, 2);
                        } else {
                            delta2.b(21, 0);
                            delta2.b(55, 2);
                        }
                    }
                }
            } catch (NumberFormatException unused) {
            }
        }
    }

    private static void M(Context context, Constraint constraint, TypedArray typedArray) {
        int indexCount = typedArray.getIndexCount();
        Constraint.Delta delta = new Constraint.Delta();
        constraint.f33198h = delta;
        constraint.f33194d.f33256a = false;
        constraint.f33195e.f33214b = false;
        constraint.f33193c.f33270a = false;
        constraint.f33196f.f33276a = false;
        for (int i3 = 0; i3 < indexCount; i3++) {
            int index = typedArray.getIndex(i3);
            int i4 = f33183j.get(index);
            String str = cJfnYMIyomoWf.RTO;
            switch (i4) {
                case 2:
                    delta.b(2, typedArray.getDimensionPixelSize(index, constraint.f33195e.K));
                    break;
                case 3:
                case 4:
                case 9:
                case 10:
                case 25:
                case 26:
                case 29:
                case 30:
                case 32:
                case 33:
                case 35:
                case 36:
                case 61:
                case 88:
                case 89:
                case 90:
                case 91:
                case 92:
                default:
                    Log.w(str, "Unknown attribute 0x" + Integer.toHexString(index) + "   " + f33182i.get(index));
                    break;
                case 5:
                    delta.c(5, typedArray.getString(index));
                    break;
                case 6:
                    delta.b(6, typedArray.getDimensionPixelOffset(index, constraint.f33195e.E));
                    break;
                case 7:
                    delta.b(7, typedArray.getDimensionPixelOffset(index, constraint.f33195e.F));
                    break;
                case 8:
                    delta.b(8, typedArray.getDimensionPixelSize(index, constraint.f33195e.L));
                    break;
                case 11:
                    delta.b(11, typedArray.getDimensionPixelSize(index, constraint.f33195e.R));
                    break;
                case 12:
                    delta.b(12, typedArray.getDimensionPixelSize(index, constraint.f33195e.S));
                    break;
                case 13:
                    delta.b(13, typedArray.getDimensionPixelSize(index, constraint.f33195e.O));
                    break;
                case 14:
                    delta.b(14, typedArray.getDimensionPixelSize(index, constraint.f33195e.Q));
                    break;
                case 15:
                    delta.b(15, typedArray.getDimensionPixelSize(index, constraint.f33195e.T));
                    break;
                case 16:
                    delta.b(16, typedArray.getDimensionPixelSize(index, constraint.f33195e.P));
                    break;
                case 17:
                    delta.b(17, typedArray.getDimensionPixelOffset(index, constraint.f33195e.f33222f));
                    break;
                case 18:
                    delta.b(18, typedArray.getDimensionPixelOffset(index, constraint.f33195e.f33224g));
                    break;
                case 19:
                    delta.a(19, typedArray.getFloat(index, constraint.f33195e.f33226h));
                    break;
                case 20:
                    delta.a(20, typedArray.getFloat(index, constraint.f33195e.f33253y));
                    break;
                case 21:
                    delta.b(21, typedArray.getLayoutDimension(index, constraint.f33195e.f33220e));
                    break;
                case 22:
                    delta.b(22, f33181h[typedArray.getInt(index, constraint.f33193c.f33271b)]);
                    break;
                case 23:
                    delta.b(23, typedArray.getLayoutDimension(index, constraint.f33195e.f33218d));
                    break;
                case 24:
                    delta.b(24, typedArray.getDimensionPixelSize(index, constraint.f33195e.H));
                    break;
                case 27:
                    delta.b(27, typedArray.getInt(index, constraint.f33195e.G));
                    break;
                case 28:
                    delta.b(28, typedArray.getDimensionPixelSize(index, constraint.f33195e.I));
                    break;
                case 31:
                    delta.b(31, typedArray.getDimensionPixelSize(index, constraint.f33195e.M));
                    break;
                case 34:
                    delta.b(34, typedArray.getDimensionPixelSize(index, constraint.f33195e.J));
                    break;
                case 37:
                    delta.a(37, typedArray.getFloat(index, constraint.f33195e.f33254z));
                    break;
                case 38:
                    int resourceId = typedArray.getResourceId(index, constraint.f33191a);
                    constraint.f33191a = resourceId;
                    delta.b(38, resourceId);
                    break;
                case 39:
                    delta.a(39, typedArray.getFloat(index, constraint.f33195e.W));
                    break;
                case 40:
                    delta.a(40, typedArray.getFloat(index, constraint.f33195e.V));
                    break;
                case 41:
                    delta.b(41, typedArray.getInt(index, constraint.f33195e.X));
                    break;
                case 42:
                    delta.b(42, typedArray.getInt(index, constraint.f33195e.Y));
                    break;
                case 43:
                    delta.a(43, typedArray.getFloat(index, constraint.f33193c.f33273d));
                    break;
                case 44:
                    delta.d(44, true);
                    delta.a(44, typedArray.getDimension(index, constraint.f33196f.f33289n));
                    break;
                case 45:
                    delta.a(45, typedArray.getFloat(index, constraint.f33196f.f33278c));
                    break;
                case 46:
                    delta.a(46, typedArray.getFloat(index, constraint.f33196f.f33279d));
                    break;
                case 47:
                    delta.a(47, typedArray.getFloat(index, constraint.f33196f.f33280e));
                    break;
                case 48:
                    delta.a(48, typedArray.getFloat(index, constraint.f33196f.f33281f));
                    break;
                case 49:
                    delta.a(49, typedArray.getDimension(index, constraint.f33196f.f33282g));
                    break;
                case 50:
                    delta.a(50, typedArray.getDimension(index, constraint.f33196f.f33283h));
                    break;
                case 51:
                    delta.a(51, typedArray.getDimension(index, constraint.f33196f.f33285j));
                    break;
                case 52:
                    delta.a(52, typedArray.getDimension(index, constraint.f33196f.f33286k));
                    break;
                case 53:
                    delta.a(53, typedArray.getDimension(index, constraint.f33196f.f33287l));
                    break;
                case 54:
                    delta.b(54, typedArray.getInt(index, constraint.f33195e.Z));
                    break;
                case 55:
                    delta.b(55, typedArray.getInt(index, constraint.f33195e.f33213a0));
                    break;
                case 56:
                    delta.b(56, typedArray.getDimensionPixelSize(index, constraint.f33195e.f33215b0));
                    break;
                case 57:
                    delta.b(57, typedArray.getDimensionPixelSize(index, constraint.f33195e.f33217c0));
                    break;
                case 58:
                    delta.b(58, typedArray.getDimensionPixelSize(index, constraint.f33195e.f33219d0));
                    break;
                case 59:
                    delta.b(59, typedArray.getDimensionPixelSize(index, constraint.f33195e.f33221e0));
                    break;
                case 60:
                    delta.a(60, typedArray.getFloat(index, constraint.f33196f.f33277b));
                    break;
                case 62:
                    delta.b(62, typedArray.getDimensionPixelSize(index, constraint.f33195e.C));
                    break;
                case 63:
                    delta.a(63, typedArray.getFloat(index, constraint.f33195e.D));
                    break;
                case 64:
                    delta.b(64, H(typedArray, index, constraint.f33194d.f33257b));
                    break;
                case 65:
                    if (typedArray.peekValue(index).type == 3) {
                        delta.c(65, typedArray.getString(index));
                    } else {
                        delta.c(65, Easing.f31744c[typedArray.getInteger(index, 0)]);
                    }
                    break;
                case 66:
                    delta.b(66, typedArray.getInt(index, 0));
                    break;
                case 67:
                    delta.a(67, typedArray.getFloat(index, constraint.f33194d.f33264i));
                    break;
                case 68:
                    delta.a(68, typedArray.getFloat(index, constraint.f33193c.f33274e));
                    break;
                case 69:
                    delta.a(69, typedArray.getFloat(index, 1.0f));
                    break;
                case 70:
                    delta.a(70, typedArray.getFloat(index, 1.0f));
                    break;
                case 71:
                    Log.e(str, "CURRENTLY UNSUPPORTED");
                    break;
                case 72:
                    delta.b(72, typedArray.getInt(index, constraint.f33195e.f33227h0));
                    break;
                case 73:
                    delta.b(73, typedArray.getDimensionPixelSize(index, constraint.f33195e.f33229i0));
                    break;
                case 74:
                    delta.c(74, typedArray.getString(index));
                    break;
                case 75:
                    delta.d(75, typedArray.getBoolean(index, constraint.f33195e.f33243p0));
                    break;
                case 76:
                    delta.b(76, typedArray.getInt(index, constraint.f33194d.f33260e));
                    break;
                case 77:
                    delta.c(77, typedArray.getString(index));
                    break;
                case 78:
                    delta.b(78, typedArray.getInt(index, constraint.f33193c.f33272c));
                    break;
                case 79:
                    delta.a(79, typedArray.getFloat(index, constraint.f33194d.f33262g));
                    break;
                case 80:
                    delta.d(80, typedArray.getBoolean(index, constraint.f33195e.f33239n0));
                    break;
                case 81:
                    delta.d(81, typedArray.getBoolean(index, constraint.f33195e.f33241o0));
                    break;
                case 82:
                    delta.b(82, typedArray.getInteger(index, constraint.f33194d.f33258c));
                    break;
                case 83:
                    delta.b(83, H(typedArray, index, constraint.f33196f.f33284i));
                    break;
                case 84:
                    delta.b(84, typedArray.getInteger(index, constraint.f33194d.f33266k));
                    break;
                case 85:
                    delta.a(85, typedArray.getFloat(index, constraint.f33194d.f33265j));
                    break;
                case 86:
                    int i5 = typedArray.peekValue(index).type;
                    if (i5 == 1) {
                        constraint.f33194d.f33269n = typedArray.getResourceId(index, -1);
                        delta.b(89, constraint.f33194d.f33269n);
                        Motion motion = constraint.f33194d;
                        if (motion.f33269n != -1) {
                            motion.f33268m = -2;
                            delta.b(88, -2);
                        }
                    } else if (i5 == 3) {
                        constraint.f33194d.f33267l = typedArray.getString(index);
                        delta.c(90, constraint.f33194d.f33267l);
                        if (constraint.f33194d.f33267l.indexOf("/") > 0) {
                            constraint.f33194d.f33269n = typedArray.getResourceId(index, -1);
                            delta.b(89, constraint.f33194d.f33269n);
                            constraint.f33194d.f33268m = -2;
                            delta.b(88, -2);
                        } else {
                            constraint.f33194d.f33268m = -1;
                            delta.b(88, -1);
                        }
                    } else {
                        Motion motion2 = constraint.f33194d;
                        motion2.f33268m = typedArray.getInteger(index, motion2.f33269n);
                        delta.b(88, constraint.f33194d.f33268m);
                    }
                    break;
                case 87:
                    Log.w(str, "unused attribute 0x" + Integer.toHexString(index) + "   " + f33182i.get(index));
                    break;
                case 93:
                    delta.b(93, typedArray.getDimensionPixelSize(index, constraint.f33195e.N));
                    break;
                case 94:
                    delta.b(94, typedArray.getDimensionPixelSize(index, constraint.f33195e.U));
                    break;
                case 95:
                    I(delta, typedArray, index, 0);
                    break;
                case 96:
                    I(delta, typedArray, index, 1);
                    break;
                case 97:
                    delta.b(97, typedArray.getInt(index, constraint.f33195e.f33245q0));
                    break;
                case 98:
                    if (MotionLayout.D0) {
                        int resourceId2 = typedArray.getResourceId(index, constraint.f33191a);
                        constraint.f33191a = resourceId2;
                        if (resourceId2 == -1) {
                            constraint.f33192b = typedArray.getString(index);
                        }
                    } else if (typedArray.peekValue(index).type == 3) {
                        constraint.f33192b = typedArray.getString(index);
                    } else {
                        constraint.f33191a = typedArray.getResourceId(index, constraint.f33191a);
                    }
                    break;
                case 99:
                    delta.d(99, typedArray.getBoolean(index, constraint.f33195e.f33228i));
                    break;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:120:0x01ab, code lost:
    
        continue;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void G(android.content.Context r8, org.xmlpull.v1.XmlPullParser r9) {
        /*
            Method dump skipped, instruction units count: 502
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintSet.G(android.content.Context, org.xmlpull.v1.XmlPullParser):void");
    }
}
