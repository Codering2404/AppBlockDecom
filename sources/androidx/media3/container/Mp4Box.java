package androidx.media3.container;

import androidx.media3.common.util.ParsableByteArray;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class Mp4Box {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f41663a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class ContainerBox extends Mp4Box {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f41664b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List f41665c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List f41666d;

        public ContainerBox(int i3, long j3) {
            super(i3);
            this.f41664b = j3;
            this.f41665c = new ArrayList();
            this.f41666d = new ArrayList();
        }

        public void b(ContainerBox containerBox) {
            this.f41666d.add(containerBox);
        }

        public void c(LeafBox leafBox) {
            this.f41665c.add(leafBox);
        }

        public ContainerBox d(int i3) {
            int size = this.f41666d.size();
            for (int i4 = 0; i4 < size; i4++) {
                ContainerBox containerBox = (ContainerBox) this.f41666d.get(i4);
                if (containerBox.f41663a == i3) {
                    return containerBox;
                }
            }
            return null;
        }

        public LeafBox e(int i3) {
            int size = this.f41665c.size();
            for (int i4 = 0; i4 < size; i4++) {
                LeafBox leafBox = (LeafBox) this.f41665c.get(i4);
                if (leafBox.f41663a == i3) {
                    return leafBox;
                }
            }
            return null;
        }

        @Override // androidx.media3.container.Mp4Box
        public String toString() {
            return Mp4Box.a(this.f41663a) + " leaves: " + Arrays.toString(this.f41665c.toArray()) + " containers: " + Arrays.toString(this.f41666d.toArray());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class LeafBox extends Mp4Box {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ParsableByteArray f41667b;

        public LeafBox(int i3, ParsableByteArray parsableByteArray) {
            super(i3);
            this.f41667b = parsableByteArray;
        }
    }

    public static String a(int i3) {
        return "" + ((char) ((i3 >> 24) & 255)) + ((char) ((i3 >> 16) & 255)) + ((char) ((i3 >> 8) & 255)) + ((char) (i3 & 255));
    }

    public String toString() {
        return a(this.f41663a);
    }

    private Mp4Box(int i3) {
        this.f41663a = i3;
    }
}
