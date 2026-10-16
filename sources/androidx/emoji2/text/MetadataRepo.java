package androidx.emoji2.text;

import android.graphics.Typeface;
import android.util.SparseArray;
import androidx.core.os.TraceCompat;
import androidx.core.util.Preconditions;
import androidx.emoji2.text.flatbuffer.MetadataList;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class MetadataRepo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MetadataList f36930a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final char[] f36931b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Node f36932c = new Node(1024);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Typeface f36933d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Node {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final SparseArray f36934a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private TypefaceEmojiRasterizer f36935b;

        private Node() {
            this(1);
        }

        Node a(int i3) {
            SparseArray sparseArray = this.f36934a;
            if (sparseArray == null) {
                return null;
            }
            return (Node) sparseArray.get(i3);
        }

        final TypefaceEmojiRasterizer b() {
            return this.f36935b;
        }

        void c(TypefaceEmojiRasterizer typefaceEmojiRasterizer, int i3, int i4) {
            Node nodeA = a(typefaceEmojiRasterizer.b(i3));
            if (nodeA == null) {
                nodeA = new Node();
                this.f36934a.put(typefaceEmojiRasterizer.b(i3), nodeA);
            }
            if (i4 > i3) {
                nodeA.c(typefaceEmojiRasterizer, i3 + 1, i4);
            } else {
                nodeA.f36935b = typefaceEmojiRasterizer;
            }
        }

        Node(int i3) {
            this.f36934a = new SparseArray(i3);
        }
    }

    private MetadataRepo(Typeface typeface, MetadataList metadataList) {
        this.f36933d = typeface;
        this.f36930a = metadataList;
        this.f36931b = new char[metadataList.l() * 2];
        a(metadataList);
    }

    private void a(MetadataList metadataList) {
        int iL = metadataList.l();
        for (int i3 = 0; i3 < iL; i3++) {
            TypefaceEmojiRasterizer typefaceEmojiRasterizer = new TypefaceEmojiRasterizer(this, i3);
            Character.toChars(typefaceEmojiRasterizer.f(), this.f36931b, i3 * 2);
            h(typefaceEmojiRasterizer);
        }
    }

    public static MetadataRepo b(Typeface typeface, ByteBuffer byteBuffer) {
        try {
            TraceCompat.a("EmojiCompat.MetadataRepo.create");
            return new MetadataRepo(typeface, MetadataListReader.b(byteBuffer));
        } finally {
            TraceCompat.b();
        }
    }

    public char[] c() {
        return this.f36931b;
    }

    public MetadataList d() {
        return this.f36930a;
    }

    int e() {
        return this.f36930a.m();
    }

    Node f() {
        return this.f36932c;
    }

    Typeface g() {
        return this.f36933d;
    }

    void h(TypefaceEmojiRasterizer typefaceEmojiRasterizer) {
        Preconditions.i(typefaceEmojiRasterizer, "emoji metadata cannot be null");
        Preconditions.b(typefaceEmojiRasterizer.c() > 0, "invalid metadata codepoint length");
        this.f36932c.c(typefaceEmojiRasterizer, 0, typefaceEmojiRasterizer.c() - 1);
    }
}
