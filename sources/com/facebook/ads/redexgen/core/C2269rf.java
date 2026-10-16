package com.facebook.ads.redexgen.core;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;
import java.util.Spliterator;
import java.util.Spliterators;
import javax.annotation.CheckForNull;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.rf, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C2269rf extends AbstractList<Integer> implements RandomAccess, Serializable {
    public static byte[] A03;
    public static String[] A04 = {"YU1VDkaJfx0npt5ZCy0wfRWqTvB0gzrf", "HnEPzK", "p4nBQ52ikpMWjKifemE03jhF", "yEe4449S5FSBazETcjdBTZewZPLdBAWq", "Xlyhv", "2ScPcgGnYkk5iwJP9xeXeJNhXWw9hNmB", "BfGEj8ajDZOUDr9MhSeGOx8aXIdVpKot", "7ounehwY5pAPt7bmg9fcb1FAHFBm19vl"};
    public static final long serialVersionUID = 0;
    public final int A00;
    public final int A01;
    public final int[] A02;

    public static String A02(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 102);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A04() {
        A03 = new byte[]{-87, -99};
    }

    static {
        A04();
    }

    public C2269rf(int[] array) {
        this(array, 0, array.length);
    }

    public C2269rf(int[] array, int start, int end) {
        this.A02 = array;
        this.A01 = start;
        this.A00 = end;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final Integer get(int index) {
        AbstractC1878ki.A00(index, size());
        return Integer.valueOf(this.A02[this.A01 + index]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: A01, reason: merged with bridge method [inline-methods] */
    public final Integer set(int index, Integer element) {
        AbstractC1878ki.A00(index, size());
        int i3 = this.A02[this.A01 + index];
        int[] iArr = this.A02;
        int i4 = this.A01 + index;
        int oldValue = ((Integer) AbstractC1878ki.A04(element)).intValue();
        iArr[i4] = oldValue;
        return Integer.valueOf(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.util.Collection, java.lang.Iterable, java.util.List
    /* JADX INFO: renamed from: A03, reason: merged with bridge method [inline-methods] */
    public final Spliterator.OfInt spliterator() {
        return Spliterators.spliterator(this.A02, this.A01, this.A00, 0);
    }

    public final int[] A05() {
        return Arrays.copyOfRange(this.A02, this.A01, this.A00);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(@CheckForNull Object target) {
        return (target instanceof Integer) && AbstractC0592As.A04(this.A02, ((Integer) target).intValue(), this.A01, this.A00) != -1;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(@CheckForNull Object object) {
        if (object == this) {
            return true;
        }
        boolean z2 = object instanceof C2269rf;
        if (A04[2].length() != 24) {
            throw new RuntimeException();
        }
        A04[2] = "hkNtVJfoNZugUfjtOIkeX8Ri";
        if (z2) {
            C2269rf c2269rf = (C2269rf) object;
            int size = size();
            if (c2269rf.size() != size) {
                return false;
            }
            for (int i3 = 0; i3 < size; i3++) {
                int size2 = this.A02[this.A01 + i3];
                if (size2 != c2269rf.A02[c2269rf.A01 + i3]) {
                    return false;
                }
            }
            return true;
        }
        return super.equals(object);
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x0005 */
    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int hashCode() {
        /*
            r3 = this;
            r1 = 1
            int r2 = r3.A01
        L3:
            int r0 = r3.A00
            if (r2 >= r0) goto L15
            int r1 = r1 * 31
            int[] r0 = r3.A02
            r0 = r0[r2]
            int r0 = com.facebook.ads.redexgen.core.AbstractC0592As.A00(r0)
            int r1 = r1 + r0
            int r2 = r2 + 1
            goto L3
        L15:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C2269rf.hashCode():int");
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(@CheckForNull Object target) {
        if (target instanceof Integer) {
            int[] iArr = this.A02;
            String[] strArr = A04;
            if (strArr[6].charAt(15) == strArr[5].charAt(15)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A04;
            strArr2[6] = "lB9Ee3UdEb1Lo8jQSlnhxnRY63rogU68";
            strArr2[5] = "23HXI0mrZUyV0MEjy70kUSUiY9qLKHl0";
            int i3 = AbstractC0592As.A04(iArr, ((Integer) target).intValue(), this.A01, this.A00);
            if (i3 >= 0) {
                return i3 - this.A01;
            }
            return -1;
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return false;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(@CheckForNull Object target) {
        int iA05;
        if ((target instanceof Integer) && (iA05 = AbstractC0592As.A05(this.A02, ((Integer) target).intValue(), this.A01, this.A00)) >= 0) {
            int i3 = this.A01;
            return iA05 - i3;
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.A00 - this.A01;
    }

    @Override // java.util.AbstractList, java.util.List
    public final List<Integer> subList(int fromIndex, int toIndex) {
        int size = size();
        AbstractC1878ki.A0B(fromIndex, toIndex, size);
        if (fromIndex == toIndex) {
            return Collections.emptyList();
        }
        return new C2269rf(this.A02, this.A01 + fromIndex, this.A01 + toIndex);
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        StringBuilder sb = new StringBuilder(size() * 5);
        sb.append('[').append(this.A02[this.A01]);
        for (int i3 = this.A01 + 1; i3 < this.A00; i3++) {
            sb.append(A02(0, 2, 23)).append(this.A02[i3]);
        }
        StringBuilder builder = sb.append(']');
        return builder.toString();
    }
}
