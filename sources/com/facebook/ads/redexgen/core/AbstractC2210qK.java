package com.facebook.ads.redexgen.core;

import com.google.common.collect.ElementTypesAreNonnullByDefault;
import com.google.common.collect.ParametricNullness;
import java.util.Comparator;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.qK, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
@ElementTypesAreNonnullByDefault
public abstract class AbstractC2210qK<T> implements Comparator<T> {
    @Override // java.util.Comparator
    public abstract int compare(@ParametricNullness T left, @ParametricNullness T right);

    public static <C extends Comparable> AbstractC2210qK<C> A03() {
        return BB.A02;
    }

    public static <T> AbstractC2210qK<T> A04(Comparator<T> comparator) {
        if (comparator instanceof AbstractC2210qK) {
            return (AbstractC2210qK) comparator;
        }
        return new C0607Bh(comparator);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.kO != com.google.common.base.Function<F, ? extends T> */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.qK != com.google.common.collect.Ordering<T> */
    public final <F> AbstractC2210qK<F> A05(InterfaceC1859kO<F, ? extends T> function) {
        return new C0615Bp(function, this);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.qK != com.google.common.collect.Ordering<T> */
    public <S extends T> AbstractC2210qK<S> A06() {
        return new B2(this);
    }
}
