package androidx.compose.runtime;

import com.google.android.gms.ads_identifier.mrU.pMpIcGE;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;

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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class SlotReader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SlotTable f24167a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int[] f24168b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f24169c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Object[] f24170d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f24171e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private HashMap f24172f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f24173g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f24174h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f24175i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f24176j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final IntStack f24177k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f24178l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f24179m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f24180n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f24181o;

    public SlotReader(SlotTable slotTable) {
        this.f24167a = slotTable;
        this.f24168b = slotTable.s();
        int iT = slotTable.t();
        this.f24169c = iT;
        this.f24170d = slotTable.u();
        this.f24171e = slotTable.v();
        this.f24175i = iT;
        this.f24176j = -1;
        this.f24177k = new IntStack();
    }

    private final Object M(int[] iArr, int i3) {
        int i4 = i3 * 5;
        return (iArr[i4 + 1] & 1073741824) != 0 ? this.f24170d[iArr[i4 + 4]] : Composer.f23746a.a();
    }

    private final Object O(int[] iArr, int i3) {
        if ((iArr[(i3 * 5) + 1] & 536870912) != 0) {
            return this.f24170d[SlotTableKt.s(iArr, i3)];
        }
        return null;
    }

    private final Object b(int[] iArr, int i3) {
        return (iArr[(i3 * 5) + 1] & 268435456) != 0 ? this.f24170d[SlotTableKt.n(iArr, i3)] : Composer.f23746a.a();
    }

    public final Object A(int i3) {
        return B(this.f24174h, i3);
    }

    public final Object B(int i3, int i4) {
        int iU = SlotTableKt.u(this.f24168b, i3);
        int i5 = i3 + 1;
        int i6 = iU + i4;
        return i6 < (i5 < this.f24169c ? this.f24168b[(i5 * 5) + 4] : this.f24171e) ? this.f24170d[i6] : Composer.f23746a.a();
    }

    public final int C(int i3) {
        return this.f24168b[i3 * 5];
    }

    public final Object D(int i3) {
        return O(this.f24168b, i3);
    }

    public final int E(int i3) {
        return SlotTableKt.p(this.f24168b, i3);
    }

    public final boolean F(int i3) {
        return (this.f24168b[(i3 * 5) + 1] & 134217728) != 0;
    }

    public final boolean G(int i3) {
        return (this.f24168b[(i3 * 5) + 1] & 536870912) != 0;
    }

    public final boolean H() {
        return t() || this.f24174h == this.f24175i;
    }

    public final boolean I() {
        return (this.f24168b[(this.f24174h * 5) + 1] & 1073741824) != 0;
    }

    public final boolean J(int i3) {
        return (this.f24168b[(i3 * 5) + 1] & 1073741824) != 0;
    }

    public final Object K() {
        int i3;
        if (this.f24178l > 0 || (i3 = this.f24179m) >= this.f24180n) {
            this.f24181o = false;
            return Composer.f23746a.a();
        }
        this.f24181o = true;
        Object[] objArr = this.f24170d;
        this.f24179m = i3 + 1;
        return objArr[i3];
    }

    public final Object L(int i3) {
        int[] iArr = this.f24168b;
        if ((iArr[(i3 * 5) + 1] & 1073741824) != 0) {
            return M(iArr, i3);
        }
        return null;
    }

    public final int N(int i3) {
        return this.f24168b[(i3 * 5) + 1] & 67108863;
    }

    public final int P(int i3) {
        return this.f24168b[(i3 * 5) + 2];
    }

    public final void Q(int i3) {
        if (!(this.f24178l == 0)) {
            ComposerKt.t("Cannot reposition while in an empty region");
        }
        this.f24174h = i3;
        int i4 = this.f24169c;
        int i5 = i3 < i4 ? this.f24168b[(i3 * 5) + 2] : -1;
        this.f24176j = i5;
        if (i5 < 0) {
            this.f24175i = i4;
        } else {
            this.f24175i = i5 + SlotTableKt.p(this.f24168b, i5);
        }
        this.f24179m = 0;
        this.f24180n = 0;
    }

    public final void R(int i3) {
        int iP = SlotTableKt.p(this.f24168b, i3) + i3;
        int i4 = this.f24174h;
        if (!(i4 >= i3 && i4 <= iP)) {
            ComposerKt.t("Index " + i3 + " is not a parent of " + i4);
        }
        this.f24176j = i3;
        this.f24175i = iP;
        this.f24179m = 0;
        this.f24180n = 0;
    }

    public final int S() {
        if (!(this.f24178l == 0)) {
            ComposerKt.t("Cannot skip while in an empty region");
        }
        int[] iArr = this.f24168b;
        int i3 = this.f24174h;
        int i4 = (iArr[(i3 * 5) + 1] & 1073741824) == 0 ? iArr[(i3 * 5) + 1] & 67108863 : 1;
        this.f24174h = i3 + SlotTableKt.p(iArr, i3);
        return i4;
    }

    public final void T() {
        if (!(this.f24178l == 0)) {
            ComposerKt.t("Cannot skip the enclosing group while in an empty region");
        }
        this.f24174h = this.f24175i;
        this.f24179m = 0;
        this.f24180n = 0;
    }

    public final void U() {
        GroupSourceInformation groupSourceInformation;
        if (this.f24178l <= 0) {
            int i3 = this.f24176j;
            int i4 = this.f24174h;
            if (!(this.f24168b[(i4 * 5) + 2] == i3)) {
                PreconditionsKt.a("Invalid slot table detected");
            }
            HashMap map = this.f24172f;
            if (map != null && (groupSourceInformation = (GroupSourceInformation) map.get(a(i3))) != null) {
                groupSourceInformation.k(this.f24167a, i4);
            }
            IntStack intStack = this.f24177k;
            int i5 = this.f24179m;
            int i6 = this.f24180n;
            if (i5 == 0 && i6 == 0) {
                intStack.h(-1);
            } else {
                intStack.h(i5);
            }
            this.f24176j = i4;
            this.f24175i = SlotTableKt.p(this.f24168b, i4) + i4;
            int i7 = i4 + 1;
            this.f24174h = i7;
            this.f24179m = SlotTableKt.u(this.f24168b, i4);
            this.f24180n = i4 >= this.f24169c - 1 ? this.f24171e : this.f24168b[(i7 * 5) + 4];
        }
    }

    public final void V() {
        if (this.f24178l <= 0) {
            if (!((this.f24168b[(this.f24174h * 5) + 1] & 1073741824) != 0)) {
                PreconditionsKt.a("Expected a node group");
            }
            U();
        }
    }

    public final Anchor a(int i3) {
        ArrayList arrayListP = this.f24167a.p();
        int iT = SlotTableKt.t(arrayListP, i3, this.f24169c);
        if (iT >= 0) {
            return (Anchor) arrayListP.get(iT);
        }
        Anchor anchor = new Anchor(i3);
        arrayListP.add(-(iT + 1), anchor);
        return anchor;
    }

    public final void c() {
        this.f24178l++;
    }

    public final void d() {
        this.f24173g = true;
        this.f24167a.g(this, this.f24172f);
    }

    public final boolean e(int i3) {
        return (this.f24168b[(i3 * 5) + 1] & 67108864) != 0;
    }

    public final void f() {
        if (!(this.f24178l > 0)) {
            PreconditionsKt.a("Unbalanced begin/end empty");
        }
        this.f24178l--;
    }

    public final void g() {
        if (this.f24178l == 0) {
            if (!(this.f24174h == this.f24175i)) {
                ComposerKt.t("endGroup() not called at the end of a group");
            }
            int[] iArr = this.f24168b;
            int i3 = iArr[(this.f24176j * 5) + 2];
            this.f24176j = i3;
            this.f24175i = i3 < 0 ? this.f24169c : SlotTableKt.p(iArr, i3) + i3;
            int iG = this.f24177k.g();
            if (iG < 0) {
                this.f24179m = 0;
                this.f24180n = 0;
            } else {
                this.f24179m = iG;
                this.f24180n = i3 >= this.f24169c - 1 ? this.f24171e : this.f24168b[((i3 + 1) * 5) + 4];
            }
        }
    }

    public final List h() {
        ArrayList arrayList = new ArrayList();
        if (this.f24178l <= 0) {
            int i3 = 0;
            int iP = this.f24174h;
            while (true) {
                int i4 = i3;
                if (iP >= this.f24175i) {
                    break;
                }
                int[] iArr = this.f24168b;
                int i5 = iP * 5;
                int i6 = iArr[i5];
                Object objO = O(iArr, iP);
                int i7 = 1;
                int i8 = this.f24168b[i5 + 1];
                if ((1073741824 & i8) == 0) {
                    i7 = i8 & 67108863;
                }
                i3 = i4 + 1;
                arrayList.add(new KeyInfo(i6, objO, iP, i7, i4));
                iP += SlotTableKt.p(this.f24168b, iP);
            }
        }
        return arrayList;
    }

    public final boolean i() {
        return this.f24173g;
    }

    public final int j() {
        return this.f24175i;
    }

    public final int k() {
        return this.f24174h;
    }

    public final Object l() {
        int i3 = this.f24174h;
        if (i3 < this.f24175i) {
            return b(this.f24168b, i3);
        }
        return 0;
    }

    public final int m() {
        return this.f24175i;
    }

    public final int n() {
        int i3 = this.f24174h;
        if (i3 < this.f24175i) {
            return this.f24168b[i3 * 5];
        }
        return 0;
    }

    public final Object o() {
        int i3 = this.f24174h;
        if (i3 < this.f24175i) {
            return O(this.f24168b, i3);
        }
        return null;
    }

    public final int p() {
        return SlotTableKt.p(this.f24168b, this.f24174h);
    }

    public final int q() {
        return this.f24179m - SlotTableKt.u(this.f24168b, this.f24176j);
    }

    public final boolean r() {
        return this.f24181o;
    }

    public final boolean s() {
        int i3 = this.f24174h;
        return i3 < this.f24175i && (this.f24168b[(i3 * 5) + 1] & 536870912) != 0;
    }

    public final boolean t() {
        return this.f24178l > 0;
    }

    public final int u() {
        return this.f24176j;
    }

    public final int v() {
        int i3 = this.f24176j;
        if (i3 >= 0) {
            return this.f24168b[(i3 * 5) + 1] & 67108863;
        }
        return 0;
    }

    public final int w() {
        return this.f24180n - this.f24179m;
    }

    public final int x() {
        return this.f24169c;
    }

    public final SlotTable y() {
        return this.f24167a;
    }

    public final Object z(int i3) {
        return b(this.f24168b, i3);
    }

    public String toString() {
        return "SlotReader(current=" + this.f24174h + ", key=" + n() + ", parent=" + this.f24176j + pMpIcGE.dOavoz + this.f24175i + ')';
    }
}
