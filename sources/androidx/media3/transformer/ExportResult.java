package androidx.media3.transformer;

import androidx.media3.common.ColorInfo;
import androidx.media3.common.Format;
import androidx.media3.common.MediaItem;
import androidx.media3.common.util.Assertions;
import com.google.common.collect.ImmutableList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class ExportResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f48200a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f48201b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f48202c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f48203d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f48204e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f48205f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f48206g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f48207h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ColorInfo f48208i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f48209j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f48210k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f48211l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f48212m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f48213n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f48214o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final ExportException f48215p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f48216q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f48217r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    final ImmutableList f48218s;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private ImmutableList.Builder f48219a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f48220b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f48221c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f48222d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f48223e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f48224f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private String f48225g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private String f48226h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f48227i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private ColorInfo f48228j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private int f48229k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private int f48230l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private int f48231m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private String f48232n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private String f48233o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private int f48234p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private ExportException f48235q;

        public Builder() {
            c();
        }

        public Builder a(List list) {
            this.f48219a.k(list);
            return this;
        }

        public ExportResult b() {
            return new ExportResult(this.f48219a.m(), this.f48220b, this.f48221c, this.f48222d, this.f48223e, this.f48224f, this.f48225g, this.f48226h, this.f48227i, this.f48228j, this.f48229k, this.f48230l, this.f48231m, this.f48232n, this.f48233o, this.f48234p, this.f48235q);
        }

        public void c() {
            this.f48219a = new ImmutableList.Builder();
            this.f48220b = -9223372036854775807L;
            this.f48221c = -1L;
            this.f48222d = -2147483647;
            this.f48223e = -1;
            this.f48224f = -2147483647;
            this.f48225g = null;
            this.f48227i = -2147483647;
            this.f48228j = null;
            this.f48229k = -1;
            this.f48230l = -1;
            this.f48231m = 0;
            this.f48232n = null;
            this.f48234p = 0;
            this.f48235q = null;
        }

        public Builder d(String str) {
            this.f48225g = str;
            return this;
        }

        public Builder e(String str) {
            this.f48226h = str;
            return this;
        }

        public Builder f(int i3) {
            Assertions.a(i3 > 0 || i3 == -2147483647);
            this.f48222d = i3;
            return this;
        }

        public Builder g(int i3) {
            Assertions.a(i3 > 0 || i3 == -2147483647);
            this.f48227i = i3;
            return this;
        }

        public Builder h(int i3) {
            Assertions.a(i3 > 0 || i3 == -1);
            this.f48223e = i3;
            return this;
        }

        public Builder i(ColorInfo colorInfo) {
            this.f48228j = colorInfo;
            return this;
        }

        public Builder j(long j3) {
            Assertions.a(j3 >= 0 || j3 == -9223372036854775807L);
            this.f48220b = j3;
            return this;
        }

        public Builder k(ExportException exportException) {
            this.f48235q = exportException;
            return this;
        }

        public Builder l(long j3) {
            Assertions.b(j3 > 0 || j3 == -1, "Invalid file size = " + j3);
            this.f48221c = j3;
            return this;
        }

        public Builder m(int i3) {
            Assertions.a(i3 > 0 || i3 == -1);
            this.f48229k = i3;
            return this;
        }

        public Builder n(int i3) {
            this.f48234p = i3;
            return this;
        }

        public Builder o(int i3) {
            Assertions.a(i3 > 0 || i3 == -2147483647);
            this.f48224f = i3;
            return this;
        }

        public Builder p(String str) {
            this.f48232n = str;
            return this;
        }

        public Builder q(int i3) {
            Assertions.a(i3 >= 0);
            this.f48231m = i3;
            return this;
        }

        public Builder r(String str) {
            this.f48233o = str;
            return this;
        }

        public Builder s(int i3) {
            Assertions.a(i3 > 0 || i3 == -1);
            this.f48230l = i3;
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class ProcessedInput {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MediaItem f48236a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f48237b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Format f48238c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Format f48239d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f48240e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f48241f;

        public ProcessedInput(MediaItem mediaItem, long j3, Format format, Format format2, String str, String str2) {
            this.f48236a = mediaItem;
            this.f48237b = j3;
            this.f48238c = format;
            this.f48239d = format2;
            this.f48240e = str;
            this.f48241f = str2;
        }
    }

    private static int a(String str, int i3, List list, int i4) {
        int i5 = 0;
        if (str == null) {
            return 0;
        }
        if (i3 == 1) {
            return i4 == 1 ? 2 : 3;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ProcessedInput processedInput = (ProcessedInput) it.next();
            if ((i4 == 1 ? processedInput.f48240e : processedInput.f48241f) == null) {
                if (i5 == 1) {
                    return 3;
                }
                i5 = 2;
            } else {
                if (i5 == 2) {
                    return 3;
                }
                i5 = 1;
            }
        }
        return i5;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ExportResult)) {
            return false;
        }
        ExportResult exportResult = (ExportResult) obj;
        return Objects.equals(this.f48218s, exportResult.f48218s) && this.f48200a == exportResult.f48200a && this.f48201b == exportResult.f48201b && this.f48202c == exportResult.f48202c && this.f48203d == exportResult.f48203d && this.f48204e == exportResult.f48204e && Objects.equals(this.f48205f, exportResult.f48205f) && Objects.equals(this.f48206g, exportResult.f48206g) && this.f48207h == exportResult.f48207h && Objects.equals(this.f48208i, exportResult.f48208i) && this.f48209j == exportResult.f48209j && this.f48210k == exportResult.f48210k && this.f48211l == exportResult.f48211l && Objects.equals(this.f48212m, exportResult.f48212m) && Objects.equals(this.f48213n, exportResult.f48213n) && this.f48214o == exportResult.f48214o && Objects.equals(this.f48215p, exportResult.f48215p);
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((Objects.hashCode(this.f48218s) * 31) + ((int) this.f48200a)) * 31) + ((int) this.f48201b)) * 31) + this.f48202c) * 31) + this.f48203d) * 31) + this.f48204e) * 31) + Objects.hashCode(this.f48205f)) * 31) + Objects.hashCode(this.f48206g)) * 31) + this.f48207h) * 31) + Objects.hashCode(this.f48208i)) * 31) + this.f48209j) * 31) + this.f48210k) * 31) + this.f48211l) * 31) + Objects.hashCode(this.f48212m)) * 31) + Objects.hashCode(this.f48213n)) * 31) + this.f48214o) * 31) + Objects.hashCode(this.f48215p);
    }

    private ExportResult(ImmutableList immutableList, long j3, long j4, int i3, int i4, int i5, String str, String str2, int i6, ColorInfo colorInfo, int i7, int i8, int i9, String str3, String str4, int i10, ExportException exportException) {
        this.f48218s = immutableList;
        this.f48200a = j3;
        this.f48201b = j4;
        this.f48202c = i3;
        this.f48203d = i4;
        this.f48204e = i5;
        this.f48205f = str;
        this.f48206g = str2;
        this.f48207h = i6;
        this.f48208i = colorInfo;
        this.f48209j = i7;
        this.f48210k = i8;
        this.f48211l = i9;
        this.f48212m = str3;
        this.f48213n = str4;
        this.f48214o = i10;
        this.f48215p = exportException;
        this.f48217r = a(str2, i10, immutableList, 1);
        this.f48216q = a(str4, i10, immutableList, 2);
    }
}
