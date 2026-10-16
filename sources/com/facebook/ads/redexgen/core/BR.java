package com.facebook.ads.redexgen.core;

import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class BR<E> extends AbstractC2090oN<E> {
    public static byte[] A03;
    public static String[] A04 = {"emqP2Ifv15ruA3vfOBddLKXSQAhVBBiZ", "hrMd7lJ1e8dj2uYkEp7ZkSLs2D8yKDzP", "R1glWPF1KbPaEDQGu2GwL6vWIpfQR0VI", "T12dHmfXBitdOytN2RtspbU6Ik8qeuAk", "0tCJd3vKXz4Euq7T8InIHSFr9bbtNXIu", "Q", "MwChlhzfsoxh", "7ToYkJZV1iSpkxWyqnmjBpfIK3KeTcwM"};
    public int A00;
    public boolean A01;
    public Object[] A02;

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i3, i3 + i4);
        int i6 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            if (A04[3].charAt(25) != 'k') {
                throw new RuntimeException();
            }
            A04[4] = "sNiI9gS6nHnAzu4lGjYMdK7Ee3tNN7Ch";
            if (i6 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 87);
            i6++;
        }
    }

    public static void A01() {
        A03 = new byte[]{-6, -1, -6, 5, -6, -14, -3, -44, -14, 1, -14, -12, -6, 5, 10};
    }

    static {
        A01();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.BR != com.google.common.collect.ImmutableCollection$ArrayBasedBuilder<E> */
    public BR(int initialCapacity) {
        AbstractC2025nJ.A00(initialCapacity, A00(0, 15, 58));
        this.A02 = new Object[initialCapacity];
        this.A00 = 0;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.BR != com.google.common.collect.ImmutableCollection$ArrayBasedBuilder<E> */
    private void A02(int newElements) {
        Object[] objArr = this.A02;
        int newCapacity = AbstractC2090oN.A03(objArr.length, this.A00 + newElements);
        if (newCapacity > objArr.length || this.A01) {
            Object[] contents = this.A02;
            this.A02 = Arrays.copyOf(contents, newCapacity);
            this.A01 = false;
        }
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.BR != com.google.common.collect.ImmutableCollection$ArrayBasedBuilder<E> */
    public BR<E> A03(E element) {
        AbstractC1878ki.A04(element);
        A02(1);
        Object[] objArr = this.A02;
        int i3 = this.A00;
        this.A00 = i3 + 1;
        objArr[i3] = element;
        return this;
    }
}
