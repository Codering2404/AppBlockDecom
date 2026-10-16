package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.revenuecat.purchases.common.Constants;
import java.io.Serializable;
import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
final class GeneralRange<T> implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Comparator f83959a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f83960b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f83961c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final BoundType f83962d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f83963f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Object f83964g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final BoundType f83965h;

    /* JADX WARN: Multi-variable type inference failed */
    private GeneralRange(Comparator comparator, boolean z2, Object obj, BoundType boundType, boolean z3, Object obj2, BoundType boundType2) {
        this.f83959a = (Comparator) Preconditions.t(comparator);
        this.f83960b = z2;
        this.f83963f = z3;
        this.f83961c = obj;
        this.f83962d = (BoundType) Preconditions.t(boundType);
        this.f83964g = obj2;
        this.f83965h = (BoundType) Preconditions.t(boundType2);
        if (z2) {
            comparator.compare(NullnessCasts.a(obj), NullnessCasts.a(obj));
        }
        if (z3) {
            comparator.compare(NullnessCasts.a(obj2), NullnessCasts.a(obj2));
        }
        if (z2 && z3) {
            int iCompare = comparator.compare(NullnessCasts.a(obj), NullnessCasts.a(obj2));
            Preconditions.o(iCompare <= 0, "lowerEndpoint (%s) > upperEndpoint (%s)", obj, obj2);
            if (iCompare == 0) {
                BoundType boundType3 = BoundType.OPEN;
                Preconditions.d((boundType == boundType3 && boundType2 == boundType3) ? false : true);
            }
        }
    }

    static GeneralRange a(Comparator comparator) {
        BoundType boundType = BoundType.OPEN;
        return new GeneralRange(comparator, false, null, boundType, false, null, boundType);
    }

    static GeneralRange d(Comparator comparator, Object obj, BoundType boundType) {
        return new GeneralRange(comparator, true, obj, boundType, false, null, BoundType.OPEN);
    }

    static GeneralRange n(Comparator comparator, Object obj, BoundType boundType) {
        return new GeneralRange(comparator, false, null, BoundType.OPEN, true, obj, boundType);
    }

    Comparator b() {
        return this.f83959a;
    }

    boolean c(Object obj) {
        return (m(obj) || l(obj)) ? false : true;
    }

    BoundType e() {
        return this.f83962d;
    }

    public boolean equals(Object obj) {
        if (obj instanceof GeneralRange) {
            GeneralRange generalRange = (GeneralRange) obj;
            if (this.f83959a.equals(generalRange.f83959a) && this.f83960b == generalRange.f83960b && this.f83963f == generalRange.f83963f && e().equals(generalRange.e()) && g().equals(generalRange.g()) && Objects.a(f(), generalRange.f()) && Objects.a(h(), generalRange.h())) {
                return true;
            }
        }
        return false;
    }

    Object f() {
        return this.f83961c;
    }

    BoundType g() {
        return this.f83965h;
    }

    Object h() {
        return this.f83964g;
    }

    public int hashCode() {
        return Objects.b(this.f83959a, f(), e(), h(), g());
    }

    boolean i() {
        return this.f83960b;
    }

    boolean j() {
        return this.f83963f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    GeneralRange k(GeneralRange generalRange) {
        int iCompare;
        int iCompare2;
        Object obj;
        int iCompare3;
        BoundType boundType;
        Preconditions.t(generalRange);
        Preconditions.d(this.f83959a.equals(generalRange.f83959a));
        boolean z2 = this.f83960b;
        Object objF = f();
        BoundType boundTypeE = e();
        if (!i()) {
            z2 = generalRange.f83960b;
            objF = generalRange.f();
            boundTypeE = generalRange.e();
        } else if (generalRange.i() && ((iCompare = this.f83959a.compare(f(), generalRange.f())) < 0 || (iCompare == 0 && generalRange.e() == BoundType.OPEN))) {
            objF = generalRange.f();
            boundTypeE = generalRange.e();
        }
        boolean z3 = z2;
        boolean z4 = this.f83963f;
        Object objH = h();
        BoundType boundTypeG = g();
        if (!j()) {
            z4 = generalRange.f83963f;
            objH = generalRange.h();
            boundTypeG = generalRange.g();
        } else if (generalRange.j() && ((iCompare2 = this.f83959a.compare(h(), generalRange.h())) > 0 || (iCompare2 == 0 && generalRange.g() == BoundType.OPEN))) {
            objH = generalRange.h();
            boundTypeG = generalRange.g();
        }
        boolean z5 = z4;
        Object obj2 = objH;
        if (z3 && z5 && ((iCompare3 = this.f83959a.compare(objF, obj2)) > 0 || (iCompare3 == 0 && boundTypeE == (boundType = BoundType.OPEN) && boundTypeG == boundType))) {
            boundTypeE = BoundType.OPEN;
            boundTypeG = BoundType.CLOSED;
            obj = obj2;
        } else {
            obj = objF;
        }
        return new GeneralRange(this.f83959a, z3, obj, boundTypeE, z5, obj2, boundTypeG);
    }

    /* JADX WARN: Multi-variable type inference failed */
    boolean l(Object obj) {
        if (!j()) {
            return false;
        }
        int iCompare = this.f83959a.compare(obj, NullnessCasts.a(h()));
        return ((iCompare == 0) & (g() == BoundType.OPEN)) | (iCompare > 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    boolean m(Object obj) {
        if (!i()) {
            return false;
        }
        int iCompare = this.f83959a.compare(obj, NullnessCasts.a(f()));
        return ((iCompare == 0) & (e() == BoundType.OPEN)) | (iCompare < 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f83959a);
        sb.append(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
        BoundType boundType = this.f83962d;
        BoundType boundType2 = BoundType.CLOSED;
        sb.append(boundType == boundType2 ? '[' : '(');
        sb.append(this.f83960b ? this.f83961c : "-∞");
        sb.append(',');
        sb.append(this.f83963f ? this.f83964g : "∞");
        sb.append(this.f83965h == boundType2 ? ']' : ')');
        return sb.toString();
    }
}
