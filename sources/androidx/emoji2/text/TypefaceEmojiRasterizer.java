package androidx.emoji2.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import androidx.emoji2.text.flatbuffer.MetadataItem;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class TypefaceEmojiRasterizer {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ThreadLocal f36940d = new ThreadLocal();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f36941a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MetadataRepo f36942b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile int f36943c = 0;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface HasGlyph {
    }

    TypefaceEmojiRasterizer(MetadataRepo metadataRepo, int i3) {
        this.f36942b = metadataRepo;
        this.f36941a = i3;
    }

    private MetadataItem g() {
        ThreadLocal threadLocal = f36940d;
        MetadataItem metadataItem = (MetadataItem) threadLocal.get();
        if (metadataItem == null) {
            metadataItem = new MetadataItem();
            threadLocal.set(metadataItem);
        }
        this.f36942b.d().k(metadataItem, this.f36941a);
        return metadataItem;
    }

    public void a(Canvas canvas, float f3, float f4, Paint paint) {
        Typeface typefaceG = this.f36942b.g();
        Typeface typeface = paint.getTypeface();
        paint.setTypeface(typefaceG);
        canvas.drawText(this.f36942b.c(), this.f36941a * 2, 2, f3, f4, paint);
        paint.setTypeface(typeface);
    }

    public int b(int i3) {
        return g().i(i3);
    }

    public int c() {
        return g().j();
    }

    public int d() {
        return this.f36943c & 3;
    }

    public int e() {
        return g().l();
    }

    public int f() {
        return g().m();
    }

    public short h() {
        return g().n();
    }

    public int i() {
        return g().o();
    }

    public boolean j() {
        return g().k();
    }

    public boolean k() {
        return (this.f36943c & 4) > 0;
    }

    public void l(boolean z2) {
        int iD = d();
        if (z2) {
            this.f36943c = iD | 4;
        } else {
            this.f36943c = iD;
        }
    }

    public void m(boolean z2) {
        int i3 = this.f36943c & 4;
        this.f36943c = z2 ? i3 | 2 : i3 | 1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(", id:");
        sb.append(Integer.toHexString(f()));
        sb.append(", codepoints:");
        int iC = c();
        for (int i3 = 0; i3 < iC; i3++) {
            sb.append(Integer.toHexString(b(i3)));
            sb.append(" ");
        }
        return sb.toString();
    }
}
