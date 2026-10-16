package com.google.common.primitives;

import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public final class Bytes {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class ByteArrayAsList extends AbstractList<Byte> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final byte[] f85445a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f85446b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int f85447c;

        ByteArrayAsList(byte[] bArr, int i3, int i4) {
            this.f85445a = bArr;
            this.f85446b = i3;
            this.f85447c = i4;
        }

        @Override // java.util.AbstractList, java.util.List
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Byte get(int i3) {
            Preconditions.r(i3, size());
            return Byte.valueOf(this.f85445a[this.f85446b + i3]);
        }

        @Override // java.util.AbstractList, java.util.List
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Byte set(int i3, Byte b3) {
            Preconditions.r(i3, size());
            byte[] bArr = this.f85445a;
            int i4 = this.f85446b;
            byte b4 = bArr[i4 + i3];
            bArr[i4 + i3] = ((Byte) Preconditions.t(b3)).byteValue();
            return Byte.valueOf(b4);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(Object obj) {
            return (obj instanceof Byte) && Bytes.d(this.f85445a, ((Byte) obj).byteValue(), this.f85446b, this.f85447c) != -1;
        }

        byte[] d() {
            return Arrays.copyOfRange(this.f85445a, this.f85446b, this.f85447c);
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ByteArrayAsList)) {
                return super.equals(obj);
            }
            ByteArrayAsList byteArrayAsList = (ByteArrayAsList) obj;
            int size = size();
            if (byteArrayAsList.size() != size) {
                return false;
            }
            for (int i3 = 0; i3 < size; i3++) {
                if (this.f85445a[this.f85446b + i3] != byteArrayAsList.f85445a[byteArrayAsList.f85446b + i3]) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            int iC = 1;
            for (int i3 = this.f85446b; i3 < this.f85447c; i3++) {
                iC = (iC * 31) + Bytes.c(this.f85445a[i3]);
            }
            return iC;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object obj) {
            int iD;
            if (!(obj instanceof Byte) || (iD = Bytes.d(this.f85445a, ((Byte) obj).byteValue(), this.f85446b, this.f85447c)) < 0) {
                return -1;
            }
            return iD - this.f85446b;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object obj) {
            int iE;
            if (!(obj instanceof Byte) || (iE = Bytes.e(this.f85445a, ((Byte) obj).byteValue(), this.f85446b, this.f85447c)) < 0) {
                return -1;
            }
            return iE - this.f85446b;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f85447c - this.f85446b;
        }

        @Override // java.util.AbstractList, java.util.List
        public List subList(int i3, int i4) {
            Preconditions.y(i3, i4, size());
            if (i3 == i4) {
                return Collections.EMPTY_LIST;
            }
            byte[] bArr = this.f85445a;
            int i5 = this.f85446b;
            return new ByteArrayAsList(bArr, i3 + i5, i5 + i4);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            StringBuilder sb = new StringBuilder(size() * 5);
            sb.append('[');
            sb.append((int) this.f85445a[this.f85446b]);
            int i3 = this.f85446b;
            while (true) {
                i3++;
                if (i3 >= this.f85447c) {
                    sb.append(']');
                    return sb.toString();
                }
                sb.append(", ");
                sb.append((int) this.f85445a[i3]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int d(byte[] bArr, byte b3, int i3, int i4) {
        while (i3 < i4) {
            if (bArr[i3] == b3) {
                return i3;
            }
            i3++;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int e(byte[] bArr, byte b3, int i3, int i4) {
        for (int i5 = i4 - 1; i5 >= i3; i5--) {
            if (bArr[i5] == b3) {
                return i5;
            }
        }
        return -1;
    }

    public static byte[] f(Collection collection) {
        if (collection instanceof ByteArrayAsList) {
            return ((ByteArrayAsList) collection).d();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        byte[] bArr = new byte[length];
        for (int i3 = 0; i3 < length; i3++) {
            bArr[i3] = ((Number) Preconditions.t(array[i3])).byteValue();
        }
        return bArr;
    }

    public static int c(byte b3) {
        return b3;
    }
}
