package com.facebook.ads.redexgen.core;

import com.google.common.collect.ElementTypesAreNonnullByDefault;
import com.google.common.collect.ParametricNullness;
import java.util.Comparator;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.ns, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
@ElementTypesAreNonnullByDefault
public abstract class AbstractC2060ns {
    public static final AbstractC2060ns A00 = new C0604Be();
    public static final AbstractC2060ns A02 = new C0602Bc(-1);
    public static final AbstractC2060ns A01 = new C0602Bc(1);

    public abstract int A05();

    public abstract AbstractC2060ns A06(int left, int right);

    public abstract AbstractC2060ns A07(long left, long right);

    public abstract <T> AbstractC2060ns A08(@ParametricNullness T left, @ParametricNullness T right, Comparator<T> comparator);

    public abstract AbstractC2060ns A09(boolean left, boolean right);

    public abstract AbstractC2060ns A0A(boolean left, boolean right);

    public AbstractC2060ns() {
    }

    public /* synthetic */ AbstractC2060ns(C0604Be c0604Be) {
        this();
    }

    public static AbstractC2060ns A01() {
        return A00;
    }
}
