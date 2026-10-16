package androidx.media3.common;

import android.util.SparseBooleanArray;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class FlagSet {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SparseBooleanArray f40590a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final SparseBooleanArray f40591a = new SparseBooleanArray();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f40592b;

        public Builder a(int i3) {
            Assertions.g(!this.f40592b);
            this.f40591a.append(i3, true);
            return this;
        }

        public Builder b(FlagSet flagSet) {
            for (int i3 = 0; i3 < flagSet.d(); i3++) {
                a(flagSet.c(i3));
            }
            return this;
        }

        public Builder c(int... iArr) {
            for (int i3 : iArr) {
                a(i3);
            }
            return this;
        }

        public Builder d(int i3, boolean z2) {
            return z2 ? a(i3) : this;
        }

        public FlagSet e() {
            Assertions.g(!this.f40592b);
            this.f40592b = true;
            return new FlagSet(this.f40591a);
        }
    }

    public boolean a(int i3) {
        return this.f40590a.get(i3);
    }

    public boolean b(int... iArr) {
        for (int i3 : iArr) {
            if (a(i3)) {
                return true;
            }
        }
        return false;
    }

    public int c(int i3) {
        Assertions.c(i3, 0, d());
        return this.f40590a.keyAt(i3);
    }

    public int d() {
        return this.f40590a.size();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FlagSet)) {
            return false;
        }
        FlagSet flagSet = (FlagSet) obj;
        if (Util.f41609a >= 24) {
            return this.f40590a.equals(flagSet.f40590a);
        }
        if (d() != flagSet.d()) {
            return false;
        }
        for (int i3 = 0; i3 < d(); i3++) {
            if (c(i3) != flagSet.c(i3)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        if (Util.f41609a >= 24) {
            return this.f40590a.hashCode();
        }
        int iD = d();
        for (int i3 = 0; i3 < d(); i3++) {
            iD = (iD * 31) + c(i3);
        }
        return iD;
    }

    private FlagSet(SparseBooleanArray sparseBooleanArray) {
        this.f40590a = sparseBooleanArray;
    }
}
