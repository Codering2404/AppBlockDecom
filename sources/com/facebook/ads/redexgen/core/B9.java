package com.facebook.ads.redexgen.core;

import com.google.common.collect.ElementTypesAreNonnullByDefault;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
@ElementTypesAreNonnullByDefault
public final class B9<K, V> extends AbstractC2100oX<K, V> {
    public static String[] A03 = {"BLd", "8EKeVjTJIU6MDNPM6ZTo", "HWbOsw9VtzWta1ewMSd8SFleZB3uycJV", "4g", "oHZcZe8PYtJP7zuLK1jInYJjmOVWCxEe", "hqSXyAZ2zuGNDHd4PkKakj6NBzhfvhom", "1gwnz8jAk7EqAxYvZHDnpar6edM6d04", "wfrdBhaNwCqY"};
    public static final AbstractC2100oX<Object, Object> A04 = new B9(null, new Object[0], 0);
    public static final long serialVersionUID = 0;
    public final transient Object[] A00;
    public final transient int A01;

    @CheckForNull
    public final transient Object A02;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static <K, V> B9<K, V> A00(int n3, Object[] alternatingKeysAndValues, C2098oV<K, V> builder) {
        Object obj;
        if (n3 == 0) {
            return (B9) A04;
        }
        if (n3 == 1) {
            AbstractC2025nJ.A03(Objects.requireNonNull(alternatingKeysAndValues[0]), Objects.requireNonNull(alternatingKeysAndValues[1]));
            return new B9<>(null, alternatingKeysAndValues, 1);
        }
        AbstractC1878ki.A01(n3, alternatingKeysAndValues.length >> 1);
        Object objA02 = A02(alternatingKeysAndValues, n3, BO.A03(n3), 0);
        if (objA02 instanceof Object[]) {
            Object[] objArr = (Object[]) objA02;
            C2097oU c2097oU = (C2097oU) objArr[2];
            if (builder == null) {
                throw c2097oU.A02();
            }
            builder.A01 = c2097oU;
            obj = objArr[0];
            n3 = ((Integer) objArr[1]).intValue();
            alternatingKeysAndValues = Arrays.copyOf(alternatingKeysAndValues, n3 * 2);
        } else {
            obj = objA02;
        }
        return new B9<>(obj, alternatingKeysAndValues, n3);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.B9 != com.google.common.collect.RegularImmutableMap<K, V> */
    public B9(@CheckForNull Object hashTable, Object[] alternatingKeysAndValues, int size) {
        this.A02 = hashTable;
        this.A00 = alternatingKeysAndValues;
        this.A01 = size;
    }

    @CheckForNull
    public static Object A01(@CheckForNull Object hashTableObject, @CheckForNull Object[] alternatingKeysAndValues, int size, int keyOffset, Object key) {
        int keyIndex;
        if (key == null) {
            return null;
        }
        if (size == 1) {
            if (!Objects.requireNonNull(alternatingKeysAndValues[keyOffset]).equals(key)) {
                return null;
            }
            Object obj = alternatingKeysAndValues[keyOffset ^ 1];
            if (A03[3].length() == 2) {
                String[] strArr = A03;
                strArr[4] = "QVSrtcZKARogVSSTsDMErisHHhx3s08I";
                strArr[2] = "AM5zanCyyloF9oZfJSoNtkvSUtakyhf1";
                return Objects.requireNonNull(obj);
            }
        } else {
            if (hashTableObject == null) {
                return null;
            }
            if (hashTableObject instanceof byte[]) {
                String[] strArr2 = A03;
                if (strArr2[4].charAt(30) != strArr2[2].charAt(30)) {
                    String[] strArr3 = A03;
                    strArr3[0] = "33E";
                    strArr3[7] = "0IVWz8DDpNA7";
                    byte[] bArr = (byte[]) hashTableObject;
                    int mask = bArr.length - 1;
                    int iA00 = AbstractC2085oI.A00(key.hashCode());
                    while (true) {
                        int i3 = iA00 & mask;
                        int i4 = bArr[i3];
                        String[] strArr4 = A03;
                        if (strArr4[0].length() == strArr4[7].length()) {
                            throw new RuntimeException();
                        }
                        String[] strArr5 = A03;
                        strArr5[4] = "Av4xGd01JYXCpVUXSFBX5Q3qG21nzo21";
                        strArr5[2] = "UuPO1t2w2j7pNt6wRWMrea5HC47YMJTH";
                        keyIndex = i4 & 255;
                        if (keyIndex == 255) {
                            return null;
                        }
                        boolean zEquals = key.equals(alternatingKeysAndValues[keyIndex]);
                        String[] strArr6 = A03;
                        if (strArr6[0].length() != strArr6[7].length()) {
                            A03[6] = "uEfKnUldtWRHisqrfIDf4ni9PGEoRP0";
                            if (zEquals) {
                                break;
                            }
                            iA00 = i3 + 1;
                        } else {
                            A03[1] = "rg32th7lbb1pJpYlIRnh";
                            if (zEquals) {
                                break;
                            }
                            iA00 = i3 + 1;
                        }
                    }
                    Object obj2 = alternatingKeysAndValues[keyIndex ^ 1];
                    if (A03[1].length() != 20) {
                        return obj2;
                    }
                    A03[1] = "OPXdJDLfRI5AGRwdD0N1";
                    return obj2;
                }
            } else if (hashTableObject instanceof short[]) {
                short[] sArr = (short[]) hashTableObject;
                int mask2 = sArr.length - 1;
                int iA002 = AbstractC2085oI.A00(key.hashCode());
                while (true) {
                    int i5 = iA002 & mask2;
                    int h3 = sArr[i5] & 65535;
                    if (h3 == 65535) {
                        return null;
                    }
                    if (key.equals(alternatingKeysAndValues[h3])) {
                        return alternatingKeysAndValues[h3 ^ 1];
                    }
                    iA002 = i5 + 1;
                }
            } else {
                int[] iArr = (int[]) hashTableObject;
                int mask3 = iArr.length - 1;
                int iA003 = AbstractC2085oI.A00(key.hashCode());
                while (true) {
                    int i6 = iA003 & mask3;
                    int h4 = iArr[i6];
                    if (h4 == -1) {
                        return null;
                    }
                    if (key.equals(alternatingKeysAndValues[h4])) {
                        return alternatingKeysAndValues[h4 ^ 1];
                    }
                    iA003 = i6 + 1;
                }
            }
        }
        throw new RuntimeException();
    }

    @CheckForNull
    public static Object A02(Object[] alternatingKeysAndValues, int n3, int tableSize, int keyOffset) {
        if (n3 == 1) {
            AbstractC2025nJ.A03(Objects.requireNonNull(alternatingKeysAndValues[keyOffset]), Objects.requireNonNull(alternatingKeysAndValues[keyOffset ^ 1]));
            return null;
        }
        int h3 = tableSize - 1;
        C2097oU c2097oU = null;
        int i3 = -1;
        if (tableSize > 128) {
            if (tableSize <= 32768) {
                short[] hashTable = new short[tableSize];
                Arrays.fill(hashTable, (short) -1);
                int keyIndex = 0;
                for (int i4 = 0; i4 < n3; i4++) {
                    int i5 = (i4 * 2) + keyOffset;
                    int h4 = (keyIndex * 2) + keyOffset;
                    Object value = Objects.requireNonNull(alternatingKeysAndValues[i5]);
                    Object objRequireNonNull = Objects.requireNonNull(alternatingKeysAndValues[i5 ^ 1]);
                    AbstractC2025nJ.A03(value, objRequireNonNull);
                    int iA00 = AbstractC2085oI.A00(value.hashCode());
                    while (true) {
                        int i6 = iA00 & h3;
                        int i7 = hashTable[i6] & 65535;
                        if (i7 == 65535) {
                            hashTable[i6] = (short) h4;
                            if (keyIndex < i4) {
                                alternatingKeysAndValues[h4] = value;
                                alternatingKeysAndValues[h4 ^ 1] = objRequireNonNull;
                            }
                            keyIndex++;
                        } else {
                            boolean zEquals = value.equals(alternatingKeysAndValues[i7]);
                            if (A03[5].charAt(16) != 'P') {
                                throw new RuntimeException();
                            }
                            A03[5] = "XeR3XdSVagosh0VhP9e0zQ2n8NaTx8OB";
                            if (zEquals) {
                                c2097oU = new C2097oU(value, objRequireNonNull, Objects.requireNonNull(alternatingKeysAndValues[i7 ^ 1]));
                                alternatingKeysAndValues[i7 ^ 1] = objRequireNonNull;
                                break;
                            }
                            iA00 = i6 + 1;
                        }
                    }
                }
                return keyIndex == n3 ? hashTable : new Object[]{hashTable, Integer.valueOf(keyIndex), c2097oU};
            }
            int[] hashTable2 = new int[tableSize];
            Arrays.fill(hashTable2, -1);
            int i8 = 0;
            int i9 = 0;
            while (i9 < n3) {
                int i10 = (i9 * 2) + keyOffset;
                int i11 = (i8 * 2) + keyOffset;
                Object objRequireNonNull2 = Objects.requireNonNull(alternatingKeysAndValues[i10]);
                Object objRequireNonNull3 = Objects.requireNonNull(alternatingKeysAndValues[i10 ^ 1]);
                AbstractC2025nJ.A03(objRequireNonNull2, objRequireNonNull3);
                int outKeyIndex = AbstractC2085oI.A00(objRequireNonNull2.hashCode());
                while (true) {
                    int outKeyIndex2 = outKeyIndex & h3;
                    int i12 = hashTable2[outKeyIndex2];
                    if (i12 == i3) {
                        hashTable2[outKeyIndex2] = i11;
                        if (i8 < i9) {
                            alternatingKeysAndValues[i11] = objRequireNonNull2;
                            alternatingKeysAndValues[i11 ^ 1] = objRequireNonNull3;
                        }
                        i8++;
                    } else {
                        if (objRequireNonNull2.equals(alternatingKeysAndValues[i12])) {
                            c2097oU = new C2097oU(objRequireNonNull2, objRequireNonNull3, Objects.requireNonNull(alternatingKeysAndValues[i12 ^ 1]));
                            alternatingKeysAndValues[i12 ^ 1] = objRequireNonNull3;
                            break;
                        }
                        outKeyIndex = outKeyIndex2 + 1;
                        i3 = -1;
                    }
                }
                i9++;
                i3 = -1;
            }
            return i8 == n3 ? hashTable2 : new Object[]{hashTable2, Integer.valueOf(i8), c2097oU};
        }
        byte[] bArr = new byte[tableSize];
        Arrays.fill(bArr, (byte) -1);
        int i13 = 0;
        for (int i14 = 0; i14 < n3; i14++) {
            int i15 = (i14 * 2) + keyOffset;
            int i16 = (i13 * 2) + keyOffset;
            Object objRequireNonNull4 = Objects.requireNonNull(alternatingKeysAndValues[i15]);
            Object objRequireNonNull5 = Objects.requireNonNull(alternatingKeysAndValues[i15 ^ 1]);
            AbstractC2025nJ.A03(objRequireNonNull4, objRequireNonNull5);
            int keyIndex2 = AbstractC2085oI.A00(objRequireNonNull4.hashCode());
            while (true) {
                int keyIndex3 = keyIndex2 & h3;
                int previousKeyIndex = bArr[keyIndex3] & 255;
                if (previousKeyIndex == 255) {
                    bArr[keyIndex3] = (byte) i16;
                    if (i13 < i14) {
                        alternatingKeysAndValues[i16] = objRequireNonNull4;
                        alternatingKeysAndValues[i16 ^ 1] = objRequireNonNull5;
                    }
                    i13++;
                } else {
                    if (objRequireNonNull4.equals(alternatingKeysAndValues[previousKeyIndex])) {
                        c2097oU = new C2097oU(objRequireNonNull4, objRequireNonNull5, Objects.requireNonNull(alternatingKeysAndValues[previousKeyIndex ^ 1]));
                        alternatingKeysAndValues[previousKeyIndex ^ 1] = objRequireNonNull5;
                        break;
                    }
                    keyIndex2 = keyIndex3 + 1;
                }
            }
        }
        return i13 == n3 ? bArr : new Object[]{bArr, Integer.valueOf(i13), c2097oU};
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.B9 != com.google.common.collect.RegularImmutableMap<K, V> */
    @Override // com.facebook.ads.redexgen.core.AbstractC2100oX
    public final AbstractC2091oO<V> A0A() {
        return new C2A(this.A00, 1, this.A01);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.B9 != com.google.common.collect.RegularImmutableMap<K, V> */
    @Override // com.facebook.ads.redexgen.core.AbstractC2100oX
    public final BO<Map.Entry<K, V>> A0D() {
        return new C2C(this, this.A00, 0, this.A01);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.B9 != com.google.common.collect.RegularImmutableMap<K, V> */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.BP != com.google.common.collect.ImmutableList<K> */
    @Override // com.facebook.ads.redexgen.core.AbstractC2100oX
    public final BO<K> A0E() {
        final C2A c2a = new C2A(this.A00, 0, this.A01);
        return new BO<K>(this, c2a) { // from class: com.facebook.ads.redexgen.X.2B
            public final transient BP<K> A00;
            public final transient AbstractC2100oX<K, ?> A01;

            /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2B != com.google.common.collect.RegularImmutableMap$KeySet<K> */
            /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.BP != com.google.common.collect.ImmutableList<K> */
            /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.oX != com.google.common.collect.ImmutableMap<K, ?> */
            {
                this.A01 = this;
                this.A00 = c2a;
            }

            /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2B != com.google.common.collect.RegularImmutableMap$KeySet<K> */
            @Override // com.facebook.ads.redexgen.core.AbstractC2091oO
            public final int A0I(Object[] dst, int offset) {
                return A0J().A0I(dst, offset);
            }

            /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2B != com.google.common.collect.RegularImmutableMap$KeySet<K> */
            @Override // com.facebook.ads.redexgen.core.BO, com.facebook.ads.redexgen.core.AbstractC2091oO
            public final BP<K> A0J() {
                return this.A00;
            }

            /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2B != com.google.common.collect.RegularImmutableMap$KeySet<K> */
            @Override // com.facebook.ads.redexgen.core.AbstractC2091oO
            public final boolean A0K() {
                return true;
            }

            /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2B != com.google.common.collect.RegularImmutableMap$KeySet<K> */
            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            /* JADX INFO: renamed from: A0N */
            public final C4C<K> iterator() {
                return A0J().iterator();
            }

            /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2B != com.google.common.collect.RegularImmutableMap$KeySet<K> */
            @Override // com.facebook.ads.redexgen.core.AbstractC2091oO, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public final boolean contains(@CheckForNull Object object) {
                return this.A01.get(object) != null;
            }

            /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2B != com.google.common.collect.RegularImmutableMap$KeySet<K> */
            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public final int size() {
                return this.A01.size();
            }
        };
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.B9 != com.google.common.collect.RegularImmutableMap<K, V> */
    @Override // com.facebook.ads.redexgen.core.AbstractC2100oX
    public final boolean A0F() {
        return false;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.B9 != com.google.common.collect.RegularImmutableMap<K, V> */
    @Override // com.facebook.ads.redexgen.core.AbstractC2100oX, java.util.Map
    @CheckForNull
    public final V get(@CheckForNull Object obj) {
        V v2 = (V) A01(this.A02, this.A00, this.A01, 0, obj);
        if (v2 == null) {
            return null;
        }
        return v2;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.B9 != com.google.common.collect.RegularImmutableMap<K, V> */
    @Override // java.util.Map
    public final int size() {
        return this.A01;
    }
}
