package com.facebook.ads.redexgen.core;

import java.util.Arrays;
import java.util.RandomAccess;
import kotlin.Metadata;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.16, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0002\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u0004B%\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010\f\u001a\u00028\u00012\u0006\u0010\r\u001a\u00020\u0007H\u0096\u0002¢\u0006\u0002\u0010\u000eR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lkotlin/collections/AbstractList$SubList;", "E", "Lkotlin/collections/AbstractList;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "list", "fromIndex", "", "toIndex", "<init>", "(Lkotlin/collections/AbstractList;II)V", "_size", "get", "index", "(I)Ljava/lang/Object;", "size", "getSize", "()I", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AnonymousClass16<E> extends AbstractC03771r<E> implements RandomAccess {
    public static byte[] A03;
    public int A00;
    public final int A01;
    public final AbstractC03771r<E> A02;

    static {
        A01();
    }

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 12);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A03 = new byte[]{-96, -99, -89, -88};
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AnonymousClass16(AbstractC03771r<? extends E> abstractC03771r, int i3, int i4) {
        C2222qY.A09(abstractC03771r, A00(0, 4, 40));
        this.A02 = abstractC03771r;
        this.A01 = i3;
        AbstractC03771r.A02.A05(this.A01, i4, this.A02.size());
        this.A00 = i4 - this.A01;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC0584Ai
    /* JADX INFO: renamed from: A0C, reason: from getter */
    public final int getA00() {
        return this.A00;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC03771r, java.util.List
    public final E get(int index) {
        AbstractC03771r.A02.A03(index, this.A00);
        return this.A02.get(this.A01 + index);
    }
}
