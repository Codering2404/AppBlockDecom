package androidx.emoji2.text.flatbuffer;

import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class FlexBuffersBuilder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ReadWriteBuf f36977a;

    /* JADX INFO: renamed from: androidx.emoji2.text.flatbuffer.FlexBuffersBuilder$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 implements Comparator<Value> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ FlexBuffersBuilder f36978a;

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Value value, Value value2) {
            byte b3;
            byte b4;
            int i3 = value.f36979a;
            int i4 = value2.f36979a;
            do {
                b3 = this.f36978a.f36977a.get(i3);
                b4 = this.f36978a.f36977a.get(i4);
                if (b3 == 0) {
                    return b3 - b4;
                }
                i3++;
                i4++;
            } while (b3 == b4);
            return b3 - b4;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Value {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f36979a;
    }
}
