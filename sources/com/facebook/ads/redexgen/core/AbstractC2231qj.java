package com.facebook.ads.redexgen.core;

import com.applovin.exoplayer2.common.base.Ascii;
import com.google.common.collect.ElementTypesAreNonnullByDefault;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.qj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
@ElementTypesAreNonnullByDefault
public abstract class AbstractC2231qj {
    public static byte[] A00;
    public static String[] A01 = {"QMNv5OeLi", "JpCyGMjCH0qsxjrywkKfLwsh76HDYAsW", "KBfMQLxtUMBpcerO39v", "kcWpGIrroOmjfPs85a", "Ek92TFQTKr4621X3uMn", "aSOd7mkF1z21DVbAzu", "Gro5DGcboyXTTqFPFEdSQ7qnAhBJScvW", "47M7luGjiBOnZ0iOunZSyxDazaCqRcyy"};

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 4 out of bounds for length 4
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:135)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public static int A00(Set<?> s2) {
        int i3 = 0;
        Iterator<?> it = s2.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            i3 = ~(~(i3 + (next != null ? next.hashCode() : 0)));
        }
        return i3;
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 5
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:135)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    /* JADX WARN: Multi-variable type inference failed */
    public static <E> SortedSet<E> A03(SortedSet<E> unfiltered, InterfaceC1879kj<? super E> predicate) {
        if (!(unfiltered instanceof C0595Av)) {
            return new AnonymousClass26((SortedSet) AbstractC1878ki.A04(unfiltered), (InterfaceC1879kj) AbstractC1878ki.A04(predicate));
        }
        C0595Av c0595Av = (C0595Av) unfiltered;
        return new AnonymousClass26((SortedSet) c0595Av.A01, AbstractC1881kl.A00(c0595Av.A00, predicate));
    }

    public static String A04(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 125);
        }
        return new String(bArrCopyOfRange);
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 5
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:135)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public static <E> Set<E> A07(Set<E> unfiltered, InterfaceC1879kj<? super E> predicate) {
        if (unfiltered instanceof SortedSet) {
            return A03((SortedSet) unfiltered, predicate);
        }
        if (!(unfiltered instanceof C0595Av)) {
            return new C0595Av((Set) AbstractC1878ki.A04(unfiltered), (InterfaceC1879kj) AbstractC1878ki.A04(predicate));
        }
        C0595Av c0595Av = (C0595Av) unfiltered;
        return new C0595Av((Set) c0595Av.A01, AbstractC1881kl.A00(c0595Av.A00, predicate));
    }

    public static void A08() {
        A00 = new byte[]{Ascii.EM, Ascii.DLE, Ascii.EM, 17, Ascii.EM, Ascii.DC2, 8, 47, Ascii.EM, 8, 121, 111, 126, 59, 19, 5, Ascii.DC4, 82};
    }

    static {
        A08();
    }

    public static <E> AbstractC2229qh<E> A01(final Set<? extends E> set1, final Set<? extends E> set2) {
        AbstractC1878ki.A05(set1, A04(10, 4, 119));
        AbstractC1878ki.A05(set2, A04(14, 4, 29));
        return new C0597Ax(set1, set2);
    }

    public static <E> AbstractC2229qh<E> A02(final Set<E> set1, final Set<?> set2) {
        AbstractC1878ki.A05(set1, A04(10, 4, 119));
        AbstractC1878ki.A05(set2, A04(14, 4, 29));
        return new C0596Aw(set1, set2);
    }

    public static <E> HashSet<E> A05() {
        return new HashSet<>();
    }

    public static <E> HashSet<E> A06(int expectedSize) {
        return new HashSet<>(AbstractC2178po.A00(expectedSize));
    }

    public static boolean A09(@CheckForNull Set<?> s2, Object object) {
        if (s2 == object) {
            return true;
        }
        if (!(object instanceof Set)) {
            return false;
        }
        if (A01[0].length() != 9) {
            throw new RuntimeException();
        }
        String[] strArr = A01;
        strArr[2] = "mkkUVP7U2mO33UgVMEf";
        strArr[4] = "sZqEaXQqwVxNGw5Qr8W";
        Set set = (Set) object;
        try {
            if (s2.size() == set.size()) {
                if (s2.containsAll(set)) {
                    return true;
                }
            }
            return false;
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    public static boolean A0A(Set<?> set, Collection<?> collection) {
        AbstractC1878ki.A04(collection);
        if (0 != 0) {
            throw new NullPointerException(A04(0, 10, 1));
        }
        if (collection instanceof Set) {
            int size = collection.size();
            int size2 = set.size();
            if (A01[0].length() != 9) {
                throw new RuntimeException();
            }
            String[] strArr = A01;
            strArr[2] = "1Hjzr9oWssjCwBhAVsj";
            strArr[4] = "95dUReBvqcjLhc0vRoV";
            if (size > size2) {
                return AbstractC2138p9.A0E(set.iterator(), collection);
            }
        }
        Iterator<?> it = collection.iterator();
        String[] strArr2 = A01;
        if (strArr2[2].length() != strArr2[4].length()) {
            A01[1] = "sptQvlXJPhLrnOvdD6zGRYz2Tqrv0eAh";
            return A0B(set, it);
        }
        String[] strArr3 = A01;
        strArr3[2] = "FhrMChMKSM6HFLoTDqL";
        strArr3[4] = "aqz5QQGy23EnDjT9ypo";
        return A0B(set, it);
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x0005 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean A0B(java.util.Set<?> r2, java.util.Iterator<?> r3) {
        /*
            r1 = 0
        L1:
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L11
            java.lang.Object r0 = r3.next()
            boolean r0 = r2.remove(r0)
            r1 = r1 | r0
            goto L1
        L11:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.AbstractC2231qj.A0B(java.util.Set, java.util.Iterator):boolean");
    }
}
