package androidx.media3.exoplayer.upstream;

import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.upstream.Allocator;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class DefaultAllocator implements Allocator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f45493a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f45494b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final byte[] f45495c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f45496d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f45497e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f45498f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Allocation[] f45499g;

    public DefaultAllocator(boolean z2, int i3) {
        this(z2, i3, 0);
    }

    @Override // androidx.media3.exoplayer.upstream.Allocator
    public synchronized void a(Allocator.AllocationNode allocationNode) {
        while (allocationNode != null) {
            try {
                Allocation[] allocationArr = this.f45499g;
                int i3 = this.f45498f;
                this.f45498f = i3 + 1;
                allocationArr[i3] = allocationNode.a();
                this.f45497e--;
                allocationNode = allocationNode.next();
            } catch (Throwable th) {
                throw th;
            }
        }
        notifyAll();
    }

    @Override // androidx.media3.exoplayer.upstream.Allocator
    public synchronized Allocation b() {
        Allocation allocation;
        try {
            this.f45497e++;
            int i3 = this.f45498f;
            if (i3 > 0) {
                Allocation[] allocationArr = this.f45499g;
                int i4 = i3 - 1;
                this.f45498f = i4;
                allocation = (Allocation) Assertions.e(allocationArr[i4]);
                this.f45499g[this.f45498f] = null;
            } else {
                allocation = new Allocation(new byte[this.f45494b], 0);
                int i5 = this.f45497e;
                Allocation[] allocationArr2 = this.f45499g;
                if (i5 > allocationArr2.length) {
                    this.f45499g = (Allocation[]) Arrays.copyOf(allocationArr2, allocationArr2.length * 2);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return allocation;
    }

    @Override // androidx.media3.exoplayer.upstream.Allocator
    public synchronized void c(Allocation allocation) {
        Allocation[] allocationArr = this.f45499g;
        int i3 = this.f45498f;
        this.f45498f = i3 + 1;
        allocationArr[i3] = allocation;
        this.f45497e--;
        notifyAll();
    }

    @Override // androidx.media3.exoplayer.upstream.Allocator
    public synchronized void d() {
        try {
            int i3 = 0;
            int iMax = Math.max(0, Util.m(this.f45496d, this.f45494b) - this.f45497e);
            int i4 = this.f45498f;
            if (iMax >= i4) {
                return;
            }
            if (this.f45495c != null) {
                int i5 = i4 - 1;
                while (i3 <= i5) {
                    Allocation allocation = (Allocation) Assertions.e(this.f45499g[i3]);
                    if (allocation.f45480a == this.f45495c) {
                        i3++;
                    } else {
                        Allocation allocation2 = (Allocation) Assertions.e(this.f45499g[i5]);
                        if (allocation2.f45480a != this.f45495c) {
                            i5--;
                        } else {
                            Allocation[] allocationArr = this.f45499g;
                            allocationArr[i3] = allocation2;
                            allocationArr[i5] = allocation;
                            i5--;
                            i3++;
                        }
                    }
                }
                iMax = Math.max(iMax, i3);
                if (iMax >= this.f45498f) {
                    return;
                }
            }
            Arrays.fill(this.f45499g, iMax, this.f45498f, (Object) null);
            this.f45498f = iMax;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // androidx.media3.exoplayer.upstream.Allocator
    public int e() {
        return this.f45494b;
    }

    public synchronized int f() {
        return this.f45497e * this.f45494b;
    }

    public synchronized void g() {
        if (this.f45493a) {
            h(0);
        }
    }

    public synchronized void h(int i3) {
        boolean z2 = i3 < this.f45496d;
        this.f45496d = i3;
        if (z2) {
            d();
        }
    }

    public DefaultAllocator(boolean z2, int i3, int i4) {
        Assertions.a(i3 > 0);
        Assertions.a(i4 >= 0);
        this.f45493a = z2;
        this.f45494b = i3;
        this.f45498f = i4;
        this.f45499g = new Allocation[i4 + 100];
        if (i4 <= 0) {
            this.f45495c = null;
            return;
        }
        this.f45495c = new byte[i4 * i3];
        for (int i5 = 0; i5 < i4; i5++) {
            this.f45499g[i5] = new Allocation(this.f45495c, i5 * i3);
        }
    }
}
