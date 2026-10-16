package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import java.util.AbstractQueue;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Queue;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public final class MinMaxPriorityQueue<E> extends AbstractQueue<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Heap f84432a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Heap f84433b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final int f84434c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Object[] f84435d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f84436f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f84437g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder<B> {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class Heap {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Ordering f84438a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Heap f84439b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ MinMaxPriorityQueue f84440c;

        private int j(int i3) {
            return l(l(i3));
        }

        private int k(int i3) {
            return (i3 * 2) + 1;
        }

        private int l(int i3) {
            return (i3 - 1) / 2;
        }

        private int m(int i3) {
            return (i3 * 2) + 2;
        }

        void a(int i3, Object obj) {
            Heap heap;
            int iE = e(i3, obj);
            if (iE == i3) {
                iE = i3;
                heap = this;
            } else {
                heap = this.f84439b;
            }
            heap.b(iE, obj);
        }

        int b(int i3, Object obj) {
            while (i3 > 2) {
                int iJ = j(i3);
                Object objG = this.f84440c.g(iJ);
                if (this.f84438a.compare(objG, obj) <= 0) {
                    break;
                }
                this.f84440c.f84435d[i3] = objG;
                i3 = iJ;
            }
            this.f84440c.f84435d[i3] = obj;
            return i3;
        }

        int c(int i3, int i4) {
            return this.f84438a.compare(this.f84440c.g(i3), this.f84440c.g(i4));
        }

        int d(int i3, Object obj) {
            int iH = h(i3);
            if (iH <= 0 || this.f84438a.compare(this.f84440c.g(iH), obj) >= 0) {
                return e(i3, obj);
            }
            this.f84440c.f84435d[i3] = this.f84440c.g(iH);
            this.f84440c.f84435d[iH] = obj;
            return iH;
        }

        int e(int i3, Object obj) {
            int iM;
            if (i3 == 0) {
                this.f84440c.f84435d[0] = obj;
                return 0;
            }
            int iL = l(i3);
            Object objG = this.f84440c.g(iL);
            if (iL != 0 && (iM = m(l(iL))) != iL && k(iM) >= this.f84440c.f84436f) {
                Object objG2 = this.f84440c.g(iM);
                if (this.f84438a.compare(objG2, objG) < 0) {
                    iL = iM;
                    objG = objG2;
                }
            }
            if (this.f84438a.compare(objG, obj) >= 0) {
                this.f84440c.f84435d[i3] = obj;
                return i3;
            }
            this.f84440c.f84435d[i3] = objG;
            this.f84440c.f84435d[iL] = obj;
            return iL;
        }

        int f(int i3) {
            while (true) {
                int i4 = i(i3);
                if (i4 <= 0) {
                    return i3;
                }
                this.f84440c.f84435d[i3] = this.f84440c.g(i4);
                i3 = i4;
            }
        }

        int g(int i3, int i4) {
            if (i3 >= this.f84440c.f84436f) {
                return -1;
            }
            Preconditions.z(i3 > 0);
            int iMin = Math.min(i3, this.f84440c.f84436f - i4) + i4;
            for (int i5 = i3 + 1; i5 < iMin; i5++) {
                if (c(i5, i3) < 0) {
                    i3 = i5;
                }
            }
            return i3;
        }

        int h(int i3) {
            return g(k(i3), 2);
        }

        int i(int i3) {
            int iK = k(i3);
            if (iK < 0) {
                return -1;
            }
            return g(k(iK), 4);
        }

        int n(Object obj) {
            int iM;
            int iL = l(this.f84440c.f84436f);
            if (iL != 0 && (iM = m(l(iL))) != iL && k(iM) >= this.f84440c.f84436f) {
                Object objG = this.f84440c.g(iM);
                if (this.f84438a.compare(objG, obj) < 0) {
                    this.f84440c.f84435d[iM] = obj;
                    this.f84440c.f84435d[this.f84440c.f84436f] = objG;
                    return iM;
                }
            }
            return this.f84440c.f84436f;
        }

        MoveDesc o(int i3, int i4, Object obj) {
            int iD = d(i4, obj);
            if (iD == i4) {
                return null;
            }
            Object objG = iD < i3 ? this.f84440c.g(i3) : this.f84440c.g(l(i3));
            if (this.f84439b.b(iD, obj) < i3) {
                return new MoveDesc(obj, objG);
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class MoveDesc<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Object f84441a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Object f84442b;

        MoveDesc(Object obj, Object obj2) {
            this.f84441a = obj;
            this.f84442b = obj2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class QueueIterator implements Iterator<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f84443a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f84444b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f84445c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Queue f84446d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private List f84447f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private Object f84448g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f84449h;

        private QueueIterator() {
            this.f84443a = -1;
            this.f84444b = -1;
            this.f84445c = MinMaxPriorityQueue.this.f84437g;
        }

        private void a() {
            if (MinMaxPriorityQueue.this.f84437g != this.f84445c) {
                throw new ConcurrentModificationException();
            }
        }

        private boolean b(Iterable iterable, Object obj) {
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                if (it.next() == obj) {
                    it.remove();
                    return true;
                }
            }
            return false;
        }

        private void c(int i3) {
            if (this.f84444b < i3) {
                if (this.f84447f != null) {
                    while (i3 < MinMaxPriorityQueue.this.size() && b(this.f84447f, MinMaxPriorityQueue.this.g(i3))) {
                        i3++;
                    }
                }
                this.f84444b = i3;
            }
        }

        private boolean d(Object obj) {
            for (int i3 = 0; i3 < MinMaxPriorityQueue.this.f84436f; i3++) {
                if (MinMaxPriorityQueue.this.f84435d[i3] == obj) {
                    MinMaxPriorityQueue.this.s(i3);
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            Queue queue;
            a();
            c(this.f84443a + 1);
            return this.f84444b < MinMaxPriorityQueue.this.size() || !((queue = this.f84446d) == null || queue.isEmpty());
        }

        @Override // java.util.Iterator
        public Object next() {
            a();
            c(this.f84443a + 1);
            if (this.f84444b < MinMaxPriorityQueue.this.size()) {
                int i3 = this.f84444b;
                this.f84443a = i3;
                this.f84449h = true;
                return MinMaxPriorityQueue.this.g(i3);
            }
            if (this.f84446d != null) {
                this.f84443a = MinMaxPriorityQueue.this.size();
                Object objPoll = this.f84446d.poll();
                this.f84448g = objPoll;
                if (objPoll != null) {
                    this.f84449h = true;
                    return objPoll;
                }
            }
            throw new NoSuchElementException("iterator moved past last element in queue.");
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Iterator
        public void remove() {
            CollectPreconditions.e(this.f84449h);
            a();
            this.f84449h = false;
            this.f84445c++;
            if (this.f84443a >= MinMaxPriorityQueue.this.size()) {
                Object obj = this.f84448g;
                Objects.requireNonNull(obj);
                Preconditions.z(d(obj));
                this.f84448g = null;
                return;
            }
            MoveDesc moveDescS = MinMaxPriorityQueue.this.s(this.f84443a);
            if (moveDescS != null) {
                if (this.f84446d == null || this.f84447f == null) {
                    this.f84446d = new ArrayDeque();
                    this.f84447f = new ArrayList(3);
                }
                if (!b(this.f84447f, moveDescS.f84441a)) {
                    this.f84446d.add(moveDescS.f84441a);
                }
                if (!b(this.f84446d, moveDescS.f84442b)) {
                    this.f84447f.add(moveDescS.f84442b);
                }
            }
            this.f84443a--;
            this.f84444b--;
        }
    }

    private int e() {
        int length = this.f84435d.length;
        return f(length < 64 ? (length + 1) * 2 : IntMath.c(length / 2, 3), this.f84434c);
    }

    private static int f(int i3, int i4) {
        return Math.min(i3 - 1, i4) + 1;
    }

    private MoveDesc h(int i3, Object obj) {
        Heap heapO = o(i3);
        int iF = heapO.f(i3);
        int iB = heapO.b(iF, obj);
        if (iB == iF) {
            return heapO.o(i3, iF, obj);
        }
        if (iB < i3) {
            return new MoveDesc(obj, g(i3));
        }
        return null;
    }

    private int l() {
        int i3 = this.f84436f;
        if (i3 != 1) {
            return (i3 == 2 || this.f84433b.c(1, 2) <= 0) ? 1 : 2;
        }
        return 0;
    }

    private void n() {
        if (this.f84436f > this.f84435d.length) {
            Object[] objArr = new Object[e()];
            Object[] objArr2 = this.f84435d;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.f84435d = objArr;
        }
    }

    private Heap o(int i3) {
        return p(i3) ? this.f84432a : this.f84433b;
    }

    static boolean p(int i3) {
        int i4 = ~(~(i3 + 1));
        Preconditions.A(i4 > 0, "negative index");
        return (1431655765 & i4) > (i4 & (-1431655766));
    }

    private Object q(int i3) {
        Object objG = g(i3);
        s(i3);
        return objG;
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Queue
    public boolean add(Object obj) {
        offer(obj);
        return true;
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public boolean addAll(Collection collection) {
        Iterator<E> it = collection.iterator();
        boolean z2 = false;
        while (it.hasNext()) {
            offer(it.next());
            z2 = true;
        }
        return z2;
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        for (int i3 = 0; i3 < this.f84436f; i3++) {
            this.f84435d[i3] = null;
        }
        this.f84436f = 0;
    }

    Object g(int i3) {
        Object obj = this.f84435d[i3];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return new QueueIterator();
    }

    @Override // java.util.Queue
    public boolean offer(Object obj) {
        Preconditions.t(obj);
        this.f84437g++;
        int i3 = this.f84436f;
        this.f84436f = i3 + 1;
        n();
        o(i3).a(i3, obj);
        return this.f84436f <= this.f84434c || pollLast() != obj;
    }

    @Override // java.util.Queue
    public Object peek() {
        if (isEmpty()) {
            return null;
        }
        return g(0);
    }

    @Override // java.util.Queue
    public Object poll() {
        if (isEmpty()) {
            return null;
        }
        return q(0);
    }

    public Object pollLast() {
        if (isEmpty()) {
            return null;
        }
        return q(l());
    }

    MoveDesc s(int i3) {
        Preconditions.w(i3, this.f84436f);
        this.f84437g++;
        int i4 = this.f84436f - 1;
        this.f84436f = i4;
        if (i4 == i3) {
            this.f84435d[i4] = null;
            return null;
        }
        Object objG = g(i4);
        int iN = o(this.f84436f).n(objG);
        if (iN == i3) {
            this.f84435d[this.f84436f] = null;
            return null;
        }
        Object objG2 = g(this.f84436f);
        this.f84435d[this.f84436f] = null;
        MoveDesc moveDescH = h(i3, objG2);
        return iN < i3 ? moveDescH == null ? new MoveDesc(objG, objG2) : new MoveDesc(objG, moveDescH.f84442b) : moveDescH;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        return this.f84436f;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public Object[] toArray() {
        int i3 = this.f84436f;
        Object[] objArr = new Object[i3];
        System.arraycopy(this.f84435d, 0, objArr, 0, i3);
        return objArr;
    }
}
