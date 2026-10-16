package com.facebook.ads.redexgen.core;

import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.qk, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0000¢\u0006\u0002\b\tJ\u001d\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0000¢\u0006\u0002\b\u000bJ%\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0000¢\u0006\u0002\b\u000fJ%\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0000¢\u0006\u0002\b\u0013J\u001d\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0007H\u0000¢\u0006\u0002\b\u0018J\u0019\u0010\u0019\u001a\u00020\u00072\n\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u001bH\u0000¢\u0006\u0002\b\u001cJ%\u0010\u001d\u001a\u00020\u001e2\n\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u001b2\n\u0010\u001f\u001a\u0006\u0012\u0002\b\u00030\u001bH\u0000¢\u0006\u0002\b R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lkotlin/collections/AbstractList$Companion;", "", "<init>", "()V", "checkElementIndex", "", "index", "", "size", "checkElementIndex$kotlin_stdlib", "checkPositionIndex", "checkPositionIndex$kotlin_stdlib", "checkRangeIndexes", "fromIndex", "toIndex", "checkRangeIndexes$kotlin_stdlib", "checkBoundsIndexes", "startIndex", "endIndex", "checkBoundsIndexes$kotlin_stdlib", "maxArraySize", "newCapacity", "oldCapacity", "minCapacity", "newCapacity$kotlin_stdlib", "orderedHashCode", "c", "", "orderedHashCode$kotlin_stdlib", "orderedEquals", "", "other", "orderedEquals$kotlin_stdlib", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class C2232qk {
    public static byte[] A00;

    static {
        A01();
    }

    public /* synthetic */ C2232qk(AbstractC2223qZ abstractC2223qZ) {
        this();
    }

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 99);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{-104, -74, -104, -20, -25, -63, -26, -36, -35, -16, -78, -104, -105, -117, -34, -44, -27, -48, -91, -117, -64, -76, 8, 3, -35, 2, -8, -7, Ascii.FF, -50, -76, -19, Ascii.DLE, Ascii.FS, Ascii.EM, Ascii.ETB, -13, Ascii.CAN, Ascii.SO, Ascii.SI, 34, -28, -54, 43, 48, 38, 39, 58, -4, -30, Framer.STDOUT_FRAME_PREFIX, 54, 42, 39, 52};
    }

    public C2232qk() {
    }

    public final int A02(Collection<?> collection) {
        C2222qY.A09(collection, A00(31, 1, 39));
        int i3 = 1;
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            int i4 = i3 * 31;
            int hashCode = next != null ? next.hashCode() : 0;
            i3 = i4 + hashCode;
        }
        return i3;
    }

    public final void A03(int i3, int i4) {
        if (i3 >= 0 && i3 < i4) {
        } else {
            throw new IndexOutOfBoundsException(A00(43, 7, 95) + i3 + A00(12, 8, 8) + i4);
        }
    }

    public final void A04(int i3, int i4) {
        if (i3 >= 0 && i3 <= i4) {
        } else {
            throw new IndexOutOfBoundsException(A00(43, 7, 95) + i3 + A00(12, 8, 8) + i4);
        }
    }

    public final void A05(int i3, int i4, int i5) {
        String strA00 = A00(32, 11, 71);
        if (i3 >= 0 && i4 <= i5) {
            if (i3 <= i4) {
                return;
            } else {
                throw new IllegalArgumentException(strA00 + i3 + A00(0, 12, 21) + i4);
            }
        }
        throw new IndexOutOfBoundsException(strA00 + i3 + A00(20, 11, 49) + i4 + A00(12, 8, 8) + i5);
    }

    public final boolean A06(Collection<?> collection, Collection<?> collection2) {
        C2222qY.A09(collection, A00(31, 1, 39));
        C2222qY.A09(collection2, A00(50, 5, 95));
        if (collection.size() != collection2.size()) {
            return false;
        }
        Iterator<?> it = collection2.iterator();
        Iterator<?> it2 = collection.iterator();
        while (it2.hasNext()) {
            if (!C2222qY.A0C(it2.next(), it.next())) {
                return false;
            }
        }
        return true;
    }
}
