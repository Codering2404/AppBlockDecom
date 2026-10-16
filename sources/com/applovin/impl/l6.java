package com.applovin.impl;

import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.applovin.impl.ae;
import com.applovin.impl.g8;
import com.applovin.impl.i0;
import com.applovin.impl.l6;
import com.applovin.impl.o2;
import com.applovin.impl.sc;
import com.applovin.impl.uo;
import com.facebook.ads.AdError;
import com.facebook.stetho.websocket.CloseCodes;
import com.google.android.gms.common.api.Api;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class l6 extends sc {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int[] f61113f = new int[0];

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final vg f61114g = vg.a(new Comparator() { // from class: com.applovin.impl.uy
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return l6.a((Integer) obj, (Integer) obj2);
        }
    });

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final vg f61115h = vg.a(new Comparator() { // from class: com.applovin.impl.vy
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return l6.b((Integer) obj, (Integer) obj2);
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final g8.b f61116d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final AtomicReference f61117e;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    protected static final class b implements Comparable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f61118a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f61119b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final d f61120c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f61121d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final int f61122f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final int f61123g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final int f61124h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final int f61125i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final int f61126j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final boolean f61127k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private final int f61128l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private final int f61129m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private final int f61130n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private final int f61131o;

        public b(e9 e9Var, d dVar, int i3) {
            int i4;
            int iA;
            int iA2;
            this.f61120c = dVar;
            this.f61119b = l6.a(e9Var.f59385c);
            int i5 = 0;
            this.f61121d = l6.a(i3, false);
            int i6 = 0;
            while (true) {
                int size = dVar.f64305n.size();
                i4 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                if (i6 >= size) {
                    iA = 0;
                    i6 = Integer.MAX_VALUE;
                    break;
                } else {
                    iA = l6.a(e9Var, (String) dVar.f64305n.get(i6), false);
                    if (iA > 0) {
                        break;
                    } else {
                        i6++;
                    }
                }
            }
            this.f61123g = i6;
            this.f61122f = iA;
            this.f61124h = Integer.bitCount(e9Var.f59387f & dVar.f64306o);
            boolean z2 = true;
            this.f61127k = (e9Var.f59386d & 1) != 0;
            int i7 = e9Var.f59407z;
            this.f61128l = i7;
            this.f61129m = e9Var.A;
            int i8 = e9Var.f59390i;
            this.f61130n = i8;
            if ((i8 != -1 && i8 > dVar.f64308q) || (i7 != -1 && i7 > dVar.f64307p)) {
                z2 = false;
            }
            this.f61118a = z2;
            String[] strArrE = xp.e();
            int i9 = 0;
            while (true) {
                if (i9 >= strArrE.length) {
                    iA2 = 0;
                    i9 = Integer.MAX_VALUE;
                    break;
                } else {
                    iA2 = l6.a(e9Var, strArrE[i9], false);
                    if (iA2 > 0) {
                        break;
                    } else {
                        i9++;
                    }
                }
            }
            this.f61125i = i9;
            this.f61126j = iA2;
            while (true) {
                if (i5 < dVar.f64309r.size()) {
                    String str = e9Var.f59394m;
                    if (str != null && str.equals(dVar.f64309r.get(i5))) {
                        i4 = i5;
                        break;
                    }
                    i5++;
                } else {
                    break;
                }
            }
            this.f61131o = i4;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(b bVar) {
            vg vgVarC = (this.f61118a && this.f61121d) ? l6.f61114g : l6.f61114g.c();
            y3 y3VarA = y3.e().a(this.f61121d, bVar.f61121d).a(Integer.valueOf(this.f61123g), Integer.valueOf(bVar.f61123g), vg.a().c()).a(this.f61122f, bVar.f61122f).a(this.f61124h, bVar.f61124h).a(this.f61118a, bVar.f61118a).a(Integer.valueOf(this.f61131o), Integer.valueOf(bVar.f61131o), vg.a().c()).a(Integer.valueOf(this.f61130n), Integer.valueOf(bVar.f61130n), this.f61120c.f64313v ? l6.f61114g.c() : l6.f61115h).a(this.f61127k, bVar.f61127k).a(Integer.valueOf(this.f61125i), Integer.valueOf(bVar.f61125i), vg.a().c()).a(this.f61126j, bVar.f61126j).a(Integer.valueOf(this.f61128l), Integer.valueOf(bVar.f61128l), vgVarC).a(Integer.valueOf(this.f61129m), Integer.valueOf(bVar.f61129m), vgVarC);
            Integer numValueOf = Integer.valueOf(this.f61130n);
            Integer numValueOf2 = Integer.valueOf(bVar.f61130n);
            if (!xp.a((Object) this.f61119b, (Object) bVar.f61119b)) {
                vgVarC = l6.f61115h;
            }
            return y3VarA.a(numValueOf, numValueOf2, vgVarC).d();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    protected static final class c implements Comparable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f61132a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f61133b;

        public c(e9 e9Var, int i3) {
            this.f61132a = (e9Var.f59386d & 1) != 0;
            this.f61133b = l6.a(i3, false);
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(c cVar) {
            return y3.e().a(this.f61133b, cVar.f61133b).a(this.f61132a, cVar.f61132a).d();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class d extends uo implements o2 {
        public static final d O;
        public static final d P;
        public static final o2.a Q;
        public final int B;
        public final boolean C;
        public final boolean D;
        public final boolean E;
        public final boolean F;
        public final boolean G;
        public final boolean H;
        public final boolean I;
        public final boolean J;
        public final boolean K;
        public final boolean L;
        private final SparseArray M;
        private final SparseBooleanArray N;

        static {
            d dVarA = new e().a();
            O = dVarA;
            P = dVarA;
            Q = new o2.a() { // from class: com.applovin.impl.wy
                @Override // com.applovin.impl.o2.a
                public final o2 a(Bundle bundle) {
                    return l6.d.b(bundle);
                }
            };
        }

        private d(e eVar) {
            super(eVar);
            this.C = eVar.f61134x;
            this.D = eVar.f61135y;
            this.E = eVar.f61136z;
            this.F = eVar.A;
            this.G = eVar.B;
            this.H = eVar.C;
            this.I = eVar.D;
            this.B = eVar.E;
            this.J = eVar.F;
            this.K = eVar.G;
            this.L = eVar.H;
            this.M = eVar.I;
            this.N = eVar.J;
        }

        private static boolean a(SparseBooleanArray sparseBooleanArray, SparseBooleanArray sparseBooleanArray2) {
            int size = sparseBooleanArray.size();
            if (sparseBooleanArray2.size() != size) {
                return false;
            }
            for (int i3 = 0; i3 < size; i3++) {
                if (sparseBooleanArray2.indexOfKey(sparseBooleanArray.keyAt(i3)) < 0) {
                    return false;
                }
            }
            return true;
        }

        public final boolean b(int i3, po poVar) {
            Map map = (Map) this.M.get(i3);
            return map != null && map.containsKey(poVar);
        }

        @Override // com.applovin.impl.uo
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && d.class == obj.getClass()) {
                d dVar = (d) obj;
                if (super.equals(dVar) && this.C == dVar.C && this.D == dVar.D && this.E == dVar.E && this.F == dVar.F && this.G == dVar.G && this.H == dVar.H && this.I == dVar.I && this.B == dVar.B && this.J == dVar.J && this.K == dVar.K && this.L == dVar.L && a(this.N, dVar.N) && a(this.M, dVar.M)) {
                    return true;
                }
            }
            return false;
        }

        @Override // com.applovin.impl.uo
        public int hashCode() {
            return ((((((((((((((((((((((super.hashCode() + 31) * 31) + (this.C ? 1 : 0)) * 31) + (this.D ? 1 : 0)) * 31) + (this.E ? 1 : 0)) * 31) + (this.F ? 1 : 0)) * 31) + (this.G ? 1 : 0)) * 31) + (this.H ? 1 : 0)) * 31) + (this.I ? 1 : 0)) * 31) + this.B) * 31) + (this.J ? 1 : 0)) * 31) + (this.K ? 1 : 0)) * 31) + (this.L ? 1 : 0);
        }

        public final boolean d(int i3) {
            return this.N.get(i3);
        }

        private static boolean a(SparseArray sparseArray, SparseArray sparseArray2) {
            int size = sparseArray.size();
            if (sparseArray2.size() != size) {
                return false;
            }
            for (int i3 = 0; i3 < size; i3++) {
                int iIndexOfKey = sparseArray2.indexOfKey(sparseArray.keyAt(i3));
                if (iIndexOfKey < 0 || !a((Map) sparseArray.valueAt(i3), (Map) sparseArray2.valueAt(iIndexOfKey))) {
                    return false;
                }
            }
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static String b(int i3) {
            return Integer.toString(i3, 36);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ d b(Bundle bundle) {
            return new e(bundle).a();
        }

        private static boolean a(Map map, Map map2) {
            if (map2.size() != map.size()) {
                return false;
            }
            for (Map.Entry entry : map.entrySet()) {
                po poVar = (po) entry.getKey();
                if (!map2.containsKey(poVar) || !xp.a(entry.getValue(), map2.get(poVar))) {
                    return false;
                }
            }
            return true;
        }

        public final f a(int i3, po poVar) {
            Map map = (Map) this.M.get(i3);
            if (map != null) {
                return (f) map.get(poVar);
            }
            return null;
        }

        public static d a(Context context) {
            return new e(context).a();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class e extends uo.a {
        private boolean A;
        private boolean B;
        private boolean C;
        private boolean D;
        private int E;
        private boolean F;
        private boolean G;
        private boolean H;
        private final SparseArray I;
        private final SparseBooleanArray J;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        private boolean f61134x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        private boolean f61135y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        private boolean f61136z;

        public e() {
            this.I = new SparseArray();
            this.J = new SparseBooleanArray();
            c();
        }

        private void c() {
            this.f61134x = true;
            this.f61135y = false;
            this.f61136z = true;
            this.A = true;
            this.B = false;
            this.C = false;
            this.D = false;
            this.E = 0;
            this.F = true;
            this.G = false;
            this.H = true;
        }

        public e b(boolean z2) {
            this.B = z2;
            return this;
        }

        public e d(boolean z2) {
            this.H = z2;
            return this;
        }

        public e e(boolean z2) {
            this.f61135y = z2;
            return this;
        }

        public e f(boolean z2) {
            this.f61136z = z2;
            return this;
        }

        public e g(boolean z2) {
            this.A = z2;
            return this;
        }

        public e h(boolean z2) {
            this.F = z2;
            return this;
        }

        public e i(boolean z2) {
            this.f61134x = z2;
            return this;
        }

        public e j(boolean z2) {
            this.G = z2;
            return this;
        }

        private SparseBooleanArray a(int[] iArr) {
            if (iArr == null) {
                return new SparseBooleanArray();
            }
            SparseBooleanArray sparseBooleanArray = new SparseBooleanArray(iArr.length);
            for (int i3 : iArr) {
                sparseBooleanArray.append(i3, true);
            }
            return sparseBooleanArray;
        }

        @Override // com.applovin.impl.uo.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public e a(int i3, int i4, boolean z2) {
            super.a(i3, i4, z2);
            return this;
        }

        @Override // com.applovin.impl.uo.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public e a(Context context, boolean z2) {
            super.a(context, z2);
            return this;
        }

        public e(Context context) {
            super(context);
            this.I = new SparseArray();
            this.J = new SparseBooleanArray();
            c();
        }

        @Override // com.applovin.impl.uo.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public d a() {
            return new d(this);
        }

        public e a(boolean z2) {
            this.D = z2;
            return this;
        }

        public e a(int i3) {
            this.E = i3;
            return this;
        }

        private e(Bundle bundle) {
            super(bundle);
            d dVar = d.O;
            i(bundle.getBoolean(d.b(1000), dVar.C));
            e(bundle.getBoolean(d.b(AdError.NO_FILL_ERROR_CODE), dVar.D));
            f(bundle.getBoolean(d.b(1002), dVar.E));
            g(bundle.getBoolean(d.b(1003), dVar.F));
            b(bundle.getBoolean(d.b(1004), dVar.G));
            c(bundle.getBoolean(d.b(1005), dVar.H));
            a(bundle.getBoolean(d.b(CloseCodes.CLOSED_ABNORMALLY), dVar.I));
            a(bundle.getInt(d.b(1007), dVar.B));
            h(bundle.getBoolean(d.b(1008), dVar.J));
            j(bundle.getBoolean(d.b(1009), dVar.K));
            d(bundle.getBoolean(d.b(1010), dVar.L));
            this.I = new SparseArray();
            a(bundle);
            this.J = a(bundle.getIntArray(d.b(1014)));
        }

        public final e a(int i3, po poVar, f fVar) {
            Map map = (Map) this.I.get(i3);
            if (map == null) {
                map = new HashMap();
                this.I.put(i3, map);
            }
            if (map.containsKey(poVar) && xp.a(map.get(poVar), fVar)) {
                return this;
            }
            map.put(poVar, fVar);
            return this;
        }

        public e c(boolean z2) {
            this.C = z2;
            return this;
        }

        @Override // com.applovin.impl.uo.a
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public e a(Context context) {
            super.a(context);
            return this;
        }

        private void a(Bundle bundle) {
            int[] intArray = bundle.getIntArray(d.b(CloseCodes.UNEXPECTED_CONDITION));
            List listA = p2.a(po.f62472f, bundle.getParcelableArrayList(d.b(1012)), db.h());
            SparseArray sparseArrayA = p2.a(f.f61137f, bundle.getSparseParcelableArray(d.b(1013)), new SparseArray());
            if (intArray == null || intArray.length != listA.size()) {
                return;
            }
            for (int i3 = 0; i3 < intArray.length; i3++) {
                a(intArray[i3], (po) listA.get(i3), (f) sparseArrayA.get(i3));
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class f implements o2 {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final o2.a f61137f = new o2.a() { // from class: com.applovin.impl.xy
            @Override // com.applovin.impl.o2.a
            public final o2 a(Bundle bundle) {
                return l6.f.a(bundle);
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f61138a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int[] f61139b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f61140c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f61141d;

        public f(int i3, int[] iArr, int i4) {
            this.f61138a = i3;
            int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length);
            this.f61139b = iArrCopyOf;
            this.f61140c = iArr.length;
            this.f61141d = i4;
            Arrays.sort(iArrCopyOf);
        }

        private static String a(int i3) {
            return Integer.toString(i3, 36);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && f.class == obj.getClass()) {
                f fVar = (f) obj;
                if (this.f61138a == fVar.f61138a && Arrays.equals(this.f61139b, fVar.f61139b) && this.f61141d == fVar.f61141d) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return (((this.f61138a * 31) + Arrays.hashCode(this.f61139b)) * 31) + this.f61141d;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ f a(Bundle bundle) {
            boolean z2 = false;
            int i3 = bundle.getInt(a(0), -1);
            int[] intArray = bundle.getIntArray(a(1));
            int i4 = bundle.getInt(a(2), -1);
            if (i3 >= 0 && i4 >= 0) {
                z2 = true;
            }
            b1.a(z2);
            b1.a(intArray);
            return new f(i3, intArray, i4);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    protected static final class g implements Comparable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f61142a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f61143b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f61144c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f61145d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final int f61146f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final int f61147g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final int f61148h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final int f61149i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final boolean f61150j;

        public g(e9 e9Var, d dVar, int i3, String str) {
            int iA;
            boolean z2 = false;
            this.f61143b = l6.a(i3, false);
            int i4 = e9Var.f59386d & (~dVar.B);
            this.f61144c = (i4 & 1) != 0;
            this.f61145d = (i4 & 2) != 0;
            db dbVarA = dVar.f64310s.isEmpty() ? db.a("") : dVar.f64310s;
            int i5 = 0;
            while (true) {
                if (i5 >= dbVarA.size()) {
                    i5 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                    iA = 0;
                    break;
                } else {
                    iA = l6.a(e9Var, (String) dbVarA.get(i5), dVar.f64312u);
                    if (iA > 0) {
                        break;
                    } else {
                        i5++;
                    }
                }
            }
            this.f61146f = i5;
            this.f61147g = iA;
            int iBitCount = Integer.bitCount(e9Var.f59387f & dVar.f64311t);
            this.f61148h = iBitCount;
            this.f61150j = (e9Var.f59387f & 1088) != 0;
            int iA2 = l6.a(e9Var, str, l6.a(str) == null);
            this.f61149i = iA2;
            if (iA > 0 || ((dVar.f64310s.isEmpty() && iBitCount > 0) || this.f61144c || (this.f61145d && iA2 > 0))) {
                z2 = true;
            }
            this.f61142a = z2;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(g gVar) {
            y3 y3VarA = y3.e().a(this.f61143b, gVar.f61143b).a(Integer.valueOf(this.f61146f), Integer.valueOf(gVar.f61146f), vg.a().c()).a(this.f61147g, gVar.f61147g).a(this.f61148h, gVar.f61148h).a(this.f61144c, gVar.f61144c).a(Boolean.valueOf(this.f61145d), Boolean.valueOf(gVar.f61145d), this.f61147g == 0 ? vg.a() : vg.a().c()).a(this.f61149i, gVar.f61149i);
            if (this.f61148h == 0) {
                y3VarA = y3VarA.b(this.f61150j, gVar.f61150j);
            }
            return y3VarA.d();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    protected static final class h implements Comparable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f61151a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final d f61152b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f61153c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f61154d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final int f61155f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final int f61156g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final int f61157h;

        /* JADX WARN: Removed duplicated region for block: B:21:0x0033  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x005e  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public h(com.applovin.impl.e9 r7, com.applovin.impl.l6.d r8, int r9, boolean r10) {
            /*
                r6 = this;
                r6.<init>()
                r6.f61152b = r8
                r0 = -1082130432(0xffffffffbf800000, float:-1.0)
                r1 = 1
                r2 = 0
                r3 = -1
                if (r10 == 0) goto L33
                int r4 = r7.f59399r
                if (r4 == r3) goto L14
                int r5 = r8.f64293a
                if (r4 > r5) goto L33
            L14:
                int r4 = r7.f59400s
                if (r4 == r3) goto L1c
                int r5 = r8.f64294b
                if (r4 > r5) goto L33
            L1c:
                float r4 = r7.f59401t
                int r5 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
                if (r5 == 0) goto L29
                int r5 = r8.f64295c
                float r5 = (float) r5
                int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
                if (r4 > 0) goto L33
            L29:
                int r4 = r7.f59390i
                if (r4 == r3) goto L31
                int r5 = r8.f64296d
                if (r4 > r5) goto L33
            L31:
                r4 = r1
                goto L34
            L33:
                r4 = r2
            L34:
                r6.f61151a = r4
                if (r10 == 0) goto L5e
                int r10 = r7.f59399r
                if (r10 == r3) goto L40
                int r4 = r8.f64297f
                if (r10 < r4) goto L5e
            L40:
                int r10 = r7.f59400s
                if (r10 == r3) goto L48
                int r4 = r8.f64298g
                if (r10 < r4) goto L5e
            L48:
                float r10 = r7.f59401t
                int r0 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
                if (r0 == 0) goto L55
                int r0 = r8.f64299h
                float r0 = (float) r0
                int r10 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
                if (r10 < 0) goto L5e
            L55:
                int r10 = r7.f59390i
                if (r10 == r3) goto L5f
                int r0 = r8.f64300i
                if (r10 < r0) goto L5e
                goto L5f
            L5e:
                r1 = r2
            L5f:
                r6.f61153c = r1
                boolean r9 = com.applovin.impl.l6.a(r9, r2)
                r6.f61154d = r9
                int r9 = r7.f59390i
                r6.f61155f = r9
                int r9 = r7.b()
                r6.f61156g = r9
            L71:
                com.applovin.impl.db r9 = r8.f64304m
                int r9 = r9.size()
                if (r2 >= r9) goto L8d
                java.lang.String r9 = r7.f59394m
                if (r9 == 0) goto L8a
                com.applovin.impl.db r10 = r8.f64304m
                java.lang.Object r10 = r10.get(r2)
                boolean r9 = r9.equals(r10)
                if (r9 == 0) goto L8a
                goto L90
            L8a:
                int r2 = r2 + 1
                goto L71
            L8d:
                r2 = 2147483647(0x7fffffff, float:NaN)
            L90:
                r6.f61157h = r2
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.l6.h.<init>(com.applovin.impl.e9, com.applovin.impl.l6$d, int, boolean):void");
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(h hVar) {
            vg vgVarC = (this.f61151a && this.f61154d) ? l6.f61114g : l6.f61114g.c();
            return y3.e().a(this.f61154d, hVar.f61154d).a(this.f61151a, hVar.f61151a).a(this.f61153c, hVar.f61153c).a(Integer.valueOf(this.f61157h), Integer.valueOf(hVar.f61157h), vg.a().c()).a(Integer.valueOf(this.f61155f), Integer.valueOf(hVar.f61155f), this.f61152b.f64313v ? l6.f61114g.c() : l6.f61115h).a(Integer.valueOf(this.f61156g), Integer.valueOf(hVar.f61156g), vgVarC).a(Integer.valueOf(this.f61155f), Integer.valueOf(hVar.f61155f), vgVarC).d();
        }
    }

    public l6(Context context) {
        this(context, new i0.b());
    }

    private static void a(oo ooVar, int[] iArr, int i3, String str, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, List list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            int iIntValue = ((Integer) list.get(size)).intValue();
            if (!a(ooVar.a(iIntValue), str, iArr[iIntValue], i3, i4, i5, i6, i7, i8, i9, i10, i11)) {
                list.remove(size);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int b(Integer num, Integer num2) {
        return 0;
    }

    public l6(Context context, g8.b bVar) {
        this(d.a(context), bVar);
    }

    @Override // com.applovin.impl.vo
    public boolean b() {
        return true;
    }

    public l6(d dVar, g8.b bVar) {
        this.f61116d = bVar;
        this.f61117e = new AtomicReference(dVar);
    }

    private static int b(oo ooVar, int[] iArr, int i3, String str, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, List list) {
        int i12 = 0;
        for (int i13 = 0; i13 < list.size(); i13++) {
            int iIntValue = ((Integer) list.get(i13)).intValue();
            if (a(ooVar.a(iIntValue), str, iArr[iIntValue], i3, i4, i5, i6, i7, i8, i9, i10, i11)) {
                i12++;
            }
        }
        return i12;
    }

    private static int[] a(oo ooVar, int[] iArr, int i3, int i4, boolean z2, boolean z3, boolean z4) {
        e9 e9VarA = ooVar.a(i3);
        int[] iArr2 = new int[ooVar.f62350a];
        int i5 = 0;
        for (int i6 = 0; i6 < ooVar.f62350a; i6++) {
            if (i6 == i3 || a(ooVar.a(i6), iArr[i6], e9VarA, i4, z2, z3, z4)) {
                iArr2[i5] = i6;
                i5++;
            }
        }
        return Arrays.copyOf(iArr2, i5);
    }

    protected g8.a b(po poVar, int[][] iArr, int i3, d dVar, boolean z2) {
        g8.a aVarA = (dVar.f64314w || dVar.f64313v || !z2) ? null : a(poVar, iArr, i3, dVar);
        return aVarA == null ? a(poVar, iArr, dVar) : aVarA;
    }

    private static int[] a(oo ooVar, int[] iArr, boolean z2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, boolean z3) {
        String str;
        oo ooVar2;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int[] iArr2;
        int i23;
        int i24;
        HashSet hashSet;
        oo ooVar3 = ooVar;
        if (ooVar3.f62350a < 2) {
            return f61113f;
        }
        List listA = a(ooVar3, i12, i13, z3);
        if (listA.size() < 2) {
            return f61113f;
        }
        if (z2) {
            str = null;
            ooVar2 = ooVar;
            i14 = i3;
            i15 = i4;
            i16 = i5;
            i17 = i6;
            i18 = i7;
            i19 = i8;
            i20 = i9;
            i21 = i10;
            i22 = i11;
            iArr2 = iArr;
        } else {
            HashSet hashSet2 = new HashSet();
            int i25 = 0;
            String str2 = null;
            int i26 = 0;
            while (i26 < listA.size()) {
                String str3 = ooVar3.a(((Integer) listA.get(i26)).intValue()).f59394m;
                if (hashSet2.add(str3)) {
                    i23 = i26;
                    i24 = i25;
                    hashSet = hashSet2;
                    int iB = b(ooVar3, iArr, i3, str3, i4, i5, i6, i7, i8, i9, i10, i11, listA);
                    if (iB > i24) {
                        str2 = str3;
                        i25 = iB;
                    }
                    i26 = i23 + 1;
                    ooVar3 = ooVar;
                    hashSet2 = hashSet;
                } else {
                    i23 = i26;
                    i24 = i25;
                    hashSet = hashSet2;
                }
                i25 = i24;
                i26 = i23 + 1;
                ooVar3 = ooVar;
                hashSet2 = hashSet;
            }
            str = str2;
            ooVar2 = ooVar;
            iArr2 = iArr;
            i14 = i3;
            i15 = i4;
            i16 = i5;
            i17 = i6;
            i18 = i7;
            i19 = i8;
            i20 = i9;
            i21 = i10;
            i22 = i11;
        }
        a(ooVar2, iArr2, i14, str, i15, i16, i17, i18, i19, i20, i21, i22, listA);
        return listA.size() < 2 ? f61113f : tb.a(listA);
    }

    protected static int a(e9 e9Var, String str, boolean z2) {
        if (!TextUtils.isEmpty(str) && str.equals(e9Var.f59385c)) {
            return 4;
        }
        String strA = a(str);
        String strA2 = a(e9Var.f59385c);
        if (strA2 == null || strA == null) {
            return (z2 && strA2 == null) ? 1 : 0;
        }
        if (strA2.startsWith(strA) || strA.startsWith(strA2)) {
            return 3;
        }
        return xp.b(strA2, "-")[0].equals(xp.b(strA, "-")[0]) ? 2 : 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x000f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.graphics.Point a(boolean r3, int r4, int r5, int r6, int r7) {
        /*
            if (r3 == 0) goto Lf
            r3 = 0
            r0 = 1
            if (r6 <= r7) goto L8
            r1 = r0
            goto L9
        L8:
            r1 = r3
        L9:
            if (r4 <= r5) goto Lc
            r3 = r0
        Lc:
            if (r1 == r3) goto Lf
            goto L12
        Lf:
            r2 = r5
            r5 = r4
            r4 = r2
        L12:
            int r3 = r6 * r4
            int r0 = r7 * r5
            if (r3 < r0) goto L22
            android.graphics.Point r3 = new android.graphics.Point
            int r4 = com.applovin.impl.xp.a(r0, r6)
            r3.<init>(r5, r4)
            return r3
        L22:
            android.graphics.Point r5 = new android.graphics.Point
            int r3 = com.applovin.impl.xp.a(r3, r7)
            r5.<init>(r3, r4)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.l6.a(boolean, int, int, int, int):android.graphics.Point");
    }

    protected static boolean a(int i3, boolean z2) {
        int iD = ri.d(i3);
        if (iD != 4) {
            return z2 && iD == 3;
        }
        return true;
    }

    private static boolean a(e9 e9Var, int i3, e9 e9Var2, int i4, boolean z2, boolean z3, boolean z4) {
        int i5;
        String str;
        int i6;
        if (a(i3, false) && (i5 = e9Var.f59390i) != -1 && i5 <= i4 && ((z4 || ((i6 = e9Var.f59407z) != -1 && i6 == e9Var2.f59407z)) && (z2 || ((str = e9Var.f59394m) != null && TextUtils.equals(str, e9Var2.f59394m))))) {
            if (z3) {
                return true;
            }
            int i7 = e9Var.A;
            if (i7 != -1 && i7 == e9Var2.A) {
                return true;
            }
        }
        return false;
    }

    private static boolean a(e9 e9Var, String str, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
        int i13;
        int i14;
        int i15;
        if ((e9Var.f59387f & 16384) == 0 && a(i3, false) && (i3 & i4) != 0 && ((str == null || xp.a((Object) e9Var.f59394m, (Object) str)) && (((i13 = e9Var.f59399r) == -1 || (i9 <= i13 && i13 <= i5)) && ((i14 = e9Var.f59400s) == -1 || (i10 <= i14 && i14 <= i6))))) {
            float f3 = e9Var.f59401t;
            if ((f3 == -1.0f || (i11 <= f3 && f3 <= i7)) && (i15 = e9Var.f59390i) != -1 && i12 <= i15 && i15 <= i8) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int a(Integer num, Integer num2) {
        if (num.intValue() == -1) {
            return num2.intValue() == -1 ? 0 : -1;
        }
        if (num2.intValue() == -1) {
            return 1;
        }
        return num.intValue() - num2.intValue();
    }

    private static void a(sc.a aVar, int[][][] iArr, si[] siVarArr, g8[] g8VarArr) {
        boolean z2;
        boolean z3 = false;
        int i3 = -1;
        int i4 = -1;
        for (int i5 = 0; i5 < aVar.a(); i5++) {
            int iA = aVar.a(i5);
            g8 g8Var = g8VarArr[i5];
            if ((iA == 1 || iA == 2) && g8Var != null && a(iArr[i5], aVar.b(i5), g8Var)) {
                if (iA == 1) {
                    if (i4 != -1) {
                        z2 = false;
                        break;
                    }
                    i4 = i5;
                } else {
                    if (i3 != -1) {
                        z2 = false;
                        break;
                    }
                    i3 = i5;
                }
            }
        }
        z2 = true;
        if (i4 != -1 && i3 != -1) {
            z3 = true;
        }
        if (z2 && z3) {
            si siVar = new si(true);
            siVarArr[i4] = siVar;
            siVarArr[i3] = siVar;
        }
    }

    protected static String a(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, "und")) {
            return null;
        }
        return str;
    }

    private static boolean a(int[][] iArr, po poVar, g8 g8Var) {
        if (g8Var == null) {
            return false;
        }
        int iA = poVar.a(g8Var.a());
        for (int i3 = 0; i3 < g8Var.b(); i3++) {
            if (ri.c(iArr[iA][g8Var.b(i3)]) != 32) {
                return false;
            }
        }
        return true;
    }

    private static g8.a a(po poVar, int[][] iArr, int i3, d dVar) {
        po poVar2 = poVar;
        int i4 = dVar.E ? 24 : 16;
        boolean z2 = dVar.D && (i3 & i4) != 0;
        int i5 = 0;
        while (i5 < poVar2.f62473a) {
            oo ooVarA = poVar2.a(i5);
            int[] iArrA = a(ooVarA, iArr[i5], z2, i4, dVar.f64293a, dVar.f64294b, dVar.f64295c, dVar.f64296d, dVar.f64297f, dVar.f64298g, dVar.f64299h, dVar.f64300i, dVar.f64301j, dVar.f64302k, dVar.f64303l);
            if (iArrA.length > 0) {
                return new g8.a(ooVarA, iArrA);
            }
            i5++;
            poVar2 = poVar;
        }
        return null;
    }

    protected g8.a[] a(sc.a aVar, int[][][] iArr, int[] iArr2, d dVar) {
        b bVar;
        String str;
        int i3;
        b bVar2;
        int iA = aVar.a();
        g8.a[] aVarArr = new g8.a[iA];
        boolean z2 = false;
        int i4 = 0;
        boolean z3 = false;
        while (true) {
            if (i4 >= iA) {
                break;
            }
            if (2 == aVar.a(i4)) {
                if (!z2) {
                    g8.a aVarB = b(aVar.b(i4), iArr[i4], iArr2[i4], dVar, true);
                    aVarArr[i4] = aVarB;
                    z2 = aVarB != null;
                }
                z3 |= aVar.b(i4).f62473a > 0;
            }
            i4++;
        }
        int i5 = -1;
        b bVar3 = null;
        String str2 = null;
        int i6 = 0;
        while (i6 < iA) {
            if (1 == aVar.a(i6)) {
                bVar = bVar3;
                i3 = i5;
                str = str2;
                Pair pairA = a(aVar.b(i6), iArr[i6], iArr2[i6], dVar, dVar.L || !z3);
                if (pairA != null && (bVar == null || ((b) pairA.second).compareTo(bVar) > 0)) {
                    if (i3 != -1) {
                        aVarArr[i3] = null;
                    }
                    g8.a aVar2 = (g8.a) pairA.first;
                    aVarArr[i6] = aVar2;
                    String str3 = aVar2.f59888a.a(aVar2.f59889b[0]).f59385c;
                    bVar2 = (b) pairA.second;
                    str = str3;
                    i5 = i6;
                }
                i6++;
                bVar3 = bVar2;
                str2 = str;
            } else {
                bVar = bVar3;
                str = str2;
                i3 = i5;
            }
            bVar2 = bVar;
            i5 = i3;
            i6++;
            bVar3 = bVar2;
            str2 = str;
        }
        String str4 = str2;
        int i7 = -1;
        g gVar = null;
        for (int i8 = 0; i8 < iA; i8++) {
            int iA2 = aVar.a(i8);
            if (iA2 != 1 && iA2 != 2) {
                if (iA2 != 3) {
                    aVarArr[i8] = a(iA2, aVar.b(i8), iArr[i8], dVar);
                } else {
                    Pair pairA2 = a(aVar.b(i8), iArr[i8], dVar, str4);
                    if (pairA2 != null && (gVar == null || ((g) pairA2.second).compareTo(gVar) > 0)) {
                        if (i7 != -1) {
                            aVarArr[i7] = null;
                        }
                        aVarArr[i8] = (g8.a) pairA2.first;
                        gVar = (g) pairA2.second;
                        i7 = i8;
                    }
                }
            }
        }
        return aVarArr;
    }

    protected Pair a(po poVar, int[][] iArr, int i3, d dVar, boolean z2) {
        g8.a aVar = null;
        int i4 = -1;
        int i5 = -1;
        b bVar = null;
        for (int i6 = 0; i6 < poVar.f62473a; i6++) {
            oo ooVarA = poVar.a(i6);
            int[] iArr2 = iArr[i6];
            for (int i7 = 0; i7 < ooVarA.f62350a; i7++) {
                if (a(iArr2[i7], dVar.J)) {
                    b bVar2 = new b(ooVarA.a(i7), dVar, iArr2[i7]);
                    if ((bVar2.f61118a || dVar.F) && (bVar == null || bVar2.compareTo(bVar) > 0)) {
                        i4 = i6;
                        i5 = i7;
                        bVar = bVar2;
                    }
                }
            }
        }
        if (i4 == -1) {
            return null;
        }
        oo ooVarA2 = poVar.a(i4);
        if (!dVar.f64314w && !dVar.f64313v && z2) {
            int[] iArrA = a(ooVarA2, iArr[i4], i5, dVar.f64308q, dVar.G, dVar.H, dVar.I);
            if (iArrA.length > 1) {
                aVar = new g8.a(ooVarA2, iArrA);
            }
        }
        if (aVar == null) {
            aVar = new g8.a(ooVarA2, i5);
        }
        return Pair.create(aVar, (b) b1.a(bVar));
    }

    private static g8.a a(po poVar, int[][] iArr, d dVar) {
        int i3 = -1;
        oo ooVar = null;
        h hVar = null;
        for (int i4 = 0; i4 < poVar.f62473a; i4++) {
            oo ooVarA = poVar.a(i4);
            List listA = a(ooVarA, dVar.f64301j, dVar.f64302k, dVar.f64303l);
            int[] iArr2 = iArr[i4];
            for (int i5 = 0; i5 < ooVarA.f62350a; i5++) {
                e9 e9VarA = ooVarA.a(i5);
                if ((e9VarA.f59387f & 16384) == 0 && a(iArr2[i5], dVar.J)) {
                    h hVar2 = new h(e9VarA, dVar, iArr2[i5], listA.contains(Integer.valueOf(i5)));
                    if ((hVar2.f61151a || dVar.C) && (hVar == null || hVar2.compareTo(hVar) > 0)) {
                        ooVar = ooVarA;
                        i3 = i5;
                        hVar = hVar2;
                    }
                }
            }
        }
        if (ooVar == null) {
            return null;
        }
        return new g8.a(ooVar, i3);
    }

    protected g8.a a(int i3, po poVar, int[][] iArr, d dVar) {
        oo ooVar = null;
        c cVar = null;
        int i4 = 0;
        for (int i5 = 0; i5 < poVar.f62473a; i5++) {
            oo ooVarA = poVar.a(i5);
            int[] iArr2 = iArr[i5];
            for (int i6 = 0; i6 < ooVarA.f62350a; i6++) {
                if (a(iArr2[i6], dVar.J)) {
                    c cVar2 = new c(ooVarA.a(i6), iArr2[i6]);
                    if (cVar == null || cVar2.compareTo(cVar) > 0) {
                        ooVar = ooVarA;
                        i4 = i6;
                        cVar = cVar2;
                    }
                }
            }
        }
        if (ooVar == null) {
            return null;
        }
        return new g8.a(ooVar, i4);
    }

    protected Pair a(po poVar, int[][] iArr, d dVar, String str) {
        int i3 = -1;
        oo ooVar = null;
        g gVar = null;
        for (int i4 = 0; i4 < poVar.f62473a; i4++) {
            oo ooVarA = poVar.a(i4);
            int[] iArr2 = iArr[i4];
            for (int i5 = 0; i5 < ooVarA.f62350a; i5++) {
                if (a(iArr2[i5], dVar.J)) {
                    g gVar2 = new g(ooVarA.a(i5), dVar, iArr2[i5], str);
                    if (gVar2.f61142a && (gVar == null || gVar2.compareTo(gVar) > 0)) {
                        ooVar = ooVarA;
                        i3 = i5;
                        gVar = gVar2;
                    }
                }
            }
        }
        if (ooVar == null) {
            return null;
        }
        return Pair.create(new g8.a(ooVar, i3), (g) b1.a(gVar));
    }

    @Override // com.applovin.impl.sc
    protected final Pair a(sc.a aVar, int[][][] iArr, int[] iArr2, ae.a aVar2, fo foVar) {
        d dVar = (d) this.f61117e.get();
        int iA = aVar.a();
        g8.a[] aVarArrA = a(aVar, iArr, iArr2, dVar);
        int i3 = 0;
        while (true) {
            if (i3 >= iA) {
                break;
            }
            int iA2 = aVar.a(i3);
            if (!dVar.d(i3) && !dVar.f64315x.contains(Integer.valueOf(iA2))) {
                po poVarB = aVar.b(i3);
                if (dVar.b(i3, poVarB)) {
                    f fVarA = dVar.a(i3, poVarB);
                    aVarArrA[i3] = fVarA != null ? new g8.a(poVarB.a(fVarA.f61138a), fVarA.f61139b, fVarA.f61141d) : null;
                }
            } else {
                aVarArrA[i3] = null;
            }
            i3++;
        }
        g8[] g8VarArrA = this.f61116d.a(aVarArrA, a(), aVar2, foVar);
        si[] siVarArr = new si[iA];
        for (int i4 = 0; i4 < iA; i4++) {
            siVarArr[i4] = (dVar.d(i4) || dVar.f64315x.contains(Integer.valueOf(aVar.a(i4))) || (aVar.a(i4) != -2 && g8VarArrA[i4] == null)) ? null : si.f63718b;
        }
        if (dVar.K) {
            a(aVar, iArr, siVarArr, g8VarArrA);
        }
        return Pair.create(siVarArr, g8VarArrA);
    }

    private static List a(oo ooVar, int i3, int i4, boolean z2) {
        int i5;
        ArrayList arrayList = new ArrayList(ooVar.f62350a);
        for (int i6 = 0; i6 < ooVar.f62350a; i6++) {
            arrayList.add(Integer.valueOf(i6));
        }
        if (i3 != Integer.MAX_VALUE && i4 != Integer.MAX_VALUE) {
            int i7 = Integer.MAX_VALUE;
            for (int i8 = 0; i8 < ooVar.f62350a; i8++) {
                e9 e9VarA = ooVar.a(i8);
                int i9 = e9VarA.f59399r;
                if (i9 > 0 && (i5 = e9VarA.f59400s) > 0) {
                    Point pointA = a(z2, i3, i4, i9, i5);
                    int i10 = e9VarA.f59399r;
                    int i11 = e9VarA.f59400s;
                    int i12 = i10 * i11;
                    if (i10 >= ((int) (pointA.x * 0.98f)) && i11 >= ((int) (pointA.y * 0.98f)) && i12 < i7) {
                        i7 = i12;
                    }
                }
            }
            if (i7 != Integer.MAX_VALUE) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    int iB = ooVar.a(((Integer) arrayList.get(size)).intValue()).b();
                    if (iB == -1 || iB > i7) {
                        arrayList.remove(size);
                    }
                }
            }
        }
        return arrayList;
    }
}
