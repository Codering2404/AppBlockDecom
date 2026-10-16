package androidx.media3.container;

import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class ReorderingSeiMessageQueue {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SeiConsumer f41767a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ArrayDeque f41768b = new ArrayDeque();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ArrayDeque f41769c = new ArrayDeque();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final PriorityQueue f41770d = new PriorityQueue();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f41771e = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private SampleSeiMessages f41772f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class SampleSeiMessages implements Comparable<SampleSeiMessages> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f41774b = -9223372036854775807L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List f41773a = new ArrayList();

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(SampleSeiMessages sampleSeiMessages) {
            return Long.compare(this.f41774b, sampleSeiMessages.f41774b);
        }

        public void b(long j3, ParsableByteArray parsableByteArray) {
            Assertions.a(j3 != -9223372036854775807L);
            Assertions.g(this.f41773a.isEmpty());
            this.f41774b = j3;
            this.f41773a.add(parsableByteArray);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface SeiConsumer {
        void a(long j3, ParsableByteArray parsableByteArray);
    }

    public ReorderingSeiMessageQueue(SeiConsumer seiConsumer) {
        this.f41767a = seiConsumer;
    }

    private ParsableByteArray c(ParsableByteArray parsableByteArray) {
        ParsableByteArray parsableByteArray2 = this.f41768b.isEmpty() ? new ParsableByteArray() : (ParsableByteArray) this.f41768b.pop();
        parsableByteArray2.S(parsableByteArray.a());
        System.arraycopy(parsableByteArray.e(), parsableByteArray.f(), parsableByteArray2.e(), 0, parsableByteArray2.a());
        return parsableByteArray2;
    }

    private void e(int i3) {
        while (this.f41770d.size() > i3) {
            SampleSeiMessages sampleSeiMessages = (SampleSeiMessages) Util.k((SampleSeiMessages) this.f41770d.poll());
            for (int i4 = 0; i4 < sampleSeiMessages.f41773a.size(); i4++) {
                this.f41767a.a(sampleSeiMessages.f41774b, (ParsableByteArray) sampleSeiMessages.f41773a.get(i4));
                this.f41768b.push((ParsableByteArray) sampleSeiMessages.f41773a.get(i4));
            }
            sampleSeiMessages.f41773a.clear();
            SampleSeiMessages sampleSeiMessages2 = this.f41772f;
            if (sampleSeiMessages2 != null && sampleSeiMessages2.f41774b == sampleSeiMessages.f41774b) {
                this.f41772f = null;
            }
            this.f41769c.push(sampleSeiMessages);
        }
    }

    public void a(long j3, ParsableByteArray parsableByteArray) {
        int i3 = this.f41771e;
        if (i3 == 0 || (i3 != -1 && this.f41770d.size() >= this.f41771e && j3 < ((SampleSeiMessages) Util.k((SampleSeiMessages) this.f41770d.peek())).f41774b)) {
            this.f41767a.a(j3, parsableByteArray);
            return;
        }
        ParsableByteArray parsableByteArrayC = c(parsableByteArray);
        SampleSeiMessages sampleSeiMessages = this.f41772f;
        if (sampleSeiMessages != null && j3 == sampleSeiMessages.f41774b) {
            sampleSeiMessages.f41773a.add(parsableByteArrayC);
            return;
        }
        SampleSeiMessages sampleSeiMessages2 = this.f41769c.isEmpty() ? new SampleSeiMessages() : (SampleSeiMessages) this.f41769c.pop();
        sampleSeiMessages2.b(j3, parsableByteArrayC);
        this.f41770d.add(sampleSeiMessages2);
        this.f41772f = sampleSeiMessages2;
        int i4 = this.f41771e;
        if (i4 != -1) {
            e(i4);
        }
    }

    public void b() {
        this.f41770d.clear();
    }

    public void d() {
        e(0);
    }

    public int f() {
        return this.f41771e;
    }

    public void g(int i3) {
        Assertions.g(i3 >= 0);
        this.f41771e = i3;
        e(i3);
    }
}
