package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class Table {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected int f36980a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected ByteBuffer f36981b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f36982c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f36983d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    Utf8 f36984e = Utf8.a();

    /* JADX INFO: renamed from: androidx.emoji2.text.flatbuffer.Table$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 implements Comparator<Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ByteBuffer f36985a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Table f36986b;

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Integer num, Integer num2) {
            return this.f36986b.f(num, num2, this.f36985a);
        }
    }

    protected int a(int i3) {
        return i3 + this.f36981b.getInt(i3);
    }

    protected int b(int i3) {
        if (i3 < this.f36983d) {
            return this.f36981b.getShort(this.f36982c + i3);
        }
        return 0;
    }

    protected void c(int i3, ByteBuffer byteBuffer) {
        this.f36981b = byteBuffer;
        if (byteBuffer == null) {
            this.f36980a = 0;
            this.f36982c = 0;
            this.f36983d = 0;
        } else {
            this.f36980a = i3;
            int i4 = i3 - byteBuffer.getInt(i3);
            this.f36982c = i4;
            this.f36983d = this.f36981b.getShort(i4);
        }
    }

    protected int d(int i3) {
        int i4 = i3 + this.f36980a;
        return i4 + this.f36981b.getInt(i4) + 4;
    }

    protected int e(int i3) {
        int i4 = i3 + this.f36980a;
        return this.f36981b.getInt(i4 + this.f36981b.getInt(i4));
    }

    protected int f(Integer num, Integer num2, ByteBuffer byteBuffer) {
        return 0;
    }
}
