package com.facebook.ads.redexgen.core;

import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import java.util.Arrays;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;

/* JADX INFO: Add missing generic type declarations: [E] */
/* JADX WARN: Unexpected interfaces in signature: [kotlin.jvm.internal.markers.KMappedMarker] */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.1s, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010*\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0092\u0004\u0018\u00002\f0\u0001R\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0005H\u0016J\r\u0010\u000b\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u00020\u0005H\u0016¨\u0006\u000e"}, d2 = {"Lkotlin/collections/AbstractList$ListIteratorImpl;", "Lkotlin/collections/AbstractList$IteratorImpl;", "Lkotlin/collections/AbstractList;", "", "index", "", "<init>", "(Lkotlin/collections/AbstractList;I)V", "hasPrevious", "", "nextIndex", "previous", "()Ljava/lang/Object;", "previousIndex", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class C03781s<E> extends AbstractC03771r<E>.IteratorImpl implements ListIterator<E> {
    public static byte[] A01;
    public final /* synthetic */ AbstractC03771r<E> A00;

    static {
        A01();
    }

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 88);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{Ascii.DC2, Framer.STDIN_FRAME_PREFIX, 56, 47, 60, 41, 52, Framer.STDERR_FRAME_PREFIX, 51, 125, 52, 46, 125, 51, Framer.STDERR_FRAME_PREFIX, 41, 125, 46, 40, Framer.STDIN_FRAME_PREFIX, Framer.STDIN_FRAME_PREFIX, Framer.STDERR_FRAME_PREFIX, 47, 41, 56, 57, 125, 59, Framer.STDERR_FRAME_PREFIX, 47, 125, 47, 56, 60, 57, 112, Framer.STDERR_FRAME_PREFIX, 51, Framer.STDOUT_FRAME_PREFIX, 36, 125, 62, Framer.STDERR_FRAME_PREFIX, Framer.STDOUT_FRAME_PREFIX, Framer.STDOUT_FRAME_PREFIX, 56, 62, 41, 52, Framer.STDERR_FRAME_PREFIX, 51};
    }

    @Override // java.util.ListIterator
    public final void add(E e3) {
        throw new UnsupportedOperationException(A00(0, 51, 5));
    }

    @Override // java.util.ListIterator
    public final void set(E e3) {
        throw new UnsupportedOperationException(A00(0, 51, 5));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C03781s(AbstractC03771r abstractC03771r, int i3) {
        super(abstractC03771r);
        this.A00 = abstractC03771r;
        AbstractC03771r.A02.A04(i3, this.A00.size());
        A05(i3);
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return getA00() > 0;
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return getA00();
    }

    @Override // java.util.ListIterator
    public final E previous() {
        if (hasPrevious()) {
            AbstractC03771r<E> abstractC03771r = this.A00;
            A05(getA00() - 1);
            return abstractC03771r.get(getA00());
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return getA00() - 1;
    }
}
