package com.google.android.libraries.places.internal;

import com.facebook.internal.Utility;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzcfr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final zzcfq f77764a = new zzcfq(new byte[0], 0, 0, false, false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f77765b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final AtomicReference[] f77766c;

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        int iHighestOneBit = Integer.highestOneBit((iAvailableProcessors + iAvailableProcessors) - 1);
        f77765b = iHighestOneBit;
        AtomicReference[] atomicReferenceArr = new AtomicReference[iHighestOneBit];
        for (int i3 = 0; i3 < iHighestOneBit; i3++) {
            atomicReferenceArr[i3] = new AtomicReference();
        }
        f77766c = atomicReferenceArr;
    }

    public static final zzcfq a() {
        AtomicReference atomicReferenceC = c();
        zzcfq zzcfqVar = f77764a;
        zzcfq zzcfqVar2 = (zzcfq) atomicReferenceC.getAndSet(zzcfqVar);
        if (zzcfqVar2 == zzcfqVar) {
            return new zzcfq();
        }
        if (zzcfqVar2 == null) {
            atomicReferenceC.set(null);
            return new zzcfq();
        }
        atomicReferenceC.set(zzcfqVar2.f77762f);
        zzcfqVar2.f77762f = null;
        zzcfqVar2.f77759c = 0;
        return zzcfqVar2;
    }

    public static final void b(zzcfq segment) {
        Intrinsics.checkNotNullParameter(segment, "segment");
        if (segment.f77762f != null || segment.f77763g != null) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (segment.f77760d) {
            return;
        }
        AtomicReference atomicReferenceC = c();
        zzcfq zzcfqVar = f77764a;
        zzcfq zzcfqVar2 = (zzcfq) atomicReferenceC.getAndSet(zzcfqVar);
        if (zzcfqVar2 != zzcfqVar) {
            int i3 = zzcfqVar2 != null ? zzcfqVar2.f77759c : 0;
            if (i3 >= 65536) {
                atomicReferenceC.set(zzcfqVar2);
                return;
            }
            segment.f77762f = zzcfqVar2;
            segment.f77758b = 0;
            segment.f77759c = i3 + Utility.DEFAULT_STREAM_BUFFER_SIZE;
            atomicReferenceC.set(segment);
        }
    }

    private static final AtomicReference c() {
        return f77766c[(int) (Thread.currentThread().getId() & (((long) f77765b) - 1))];
    }
}
