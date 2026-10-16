package androidx.compose.ui.text.input;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.internal.InlineClassHelperKt;
import androidx.media3.common.JBEE.bfIdKSjLOVjG;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class EditingBuffer {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Companion f29337f = new Companion(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f29338g = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PartialGapBuffer f29339a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f29340b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f29341c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f29342d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f29343e;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public /* synthetic */ EditingBuffer(AnnotatedString annotatedString, long j3, DefaultConstructorMarker defaultConstructorMarker) {
        this(annotatedString, j3);
    }

    private final void q(int i3) {
        if (!(i3 >= 0)) {
            InlineClassHelperKt.a("Cannot set selectionEnd to a negative value: " + i3);
        }
        this.f29341c = i3;
    }

    private final void r(int i3) {
        if (!(i3 >= 0)) {
            InlineClassHelperKt.a("Cannot set selectionStart to a negative value: " + i3);
        }
        this.f29340b = i3;
    }

    public final void a() {
        this.f29342d = -1;
        this.f29343e = -1;
    }

    public final void b(int i3, int i4) {
        long jB = TextRangeKt.b(i3, i4);
        this.f29339a.c(i3, i4, "");
        long jA = EditingBufferKt.a(TextRangeKt.b(this.f29340b, this.f29341c), jB);
        r(TextRange.l(jA));
        q(TextRange.k(jA));
        if (l()) {
            long jA2 = EditingBufferKt.a(TextRangeKt.b(this.f29342d, this.f29343e), jB);
            if (TextRange.h(jA2)) {
                a();
            } else {
                this.f29342d = TextRange.l(jA2);
                this.f29343e = TextRange.k(jA2);
            }
        }
    }

    public final char c(int i3) {
        return this.f29339a.a(i3);
    }

    public final TextRange d() {
        if (l()) {
            return TextRange.b(TextRangeKt.b(this.f29342d, this.f29343e));
        }
        return null;
    }

    public final int e() {
        return this.f29343e;
    }

    public final int f() {
        return this.f29342d;
    }

    public final int g() {
        int i3 = this.f29340b;
        int i4 = this.f29341c;
        if (i3 == i4) {
            return i4;
        }
        return -1;
    }

    public final int h() {
        return this.f29339a.b();
    }

    public final long i() {
        return TextRangeKt.b(this.f29340b, this.f29341c);
    }

    public final int j() {
        return this.f29341c;
    }

    public final int k() {
        return this.f29340b;
    }

    public final boolean l() {
        return this.f29342d != -1;
    }

    public final void n(int i3, int i4) {
        if (i3 < 0 || i3 > this.f29339a.b()) {
            throw new IndexOutOfBoundsException("start (" + i3 + ") offset is outside of text region " + this.f29339a.b());
        }
        if (i4 < 0 || i4 > this.f29339a.b()) {
            throw new IndexOutOfBoundsException("end (" + i4 + ") offset is outside of text region " + this.f29339a.b());
        }
        if (i3 < i4) {
            this.f29342d = i3;
            this.f29343e = i4;
            return;
        }
        throw new IllegalArgumentException("Do not set reversed or empty range: " + i3 + " > " + i4);
    }

    public final void o(int i3) {
        p(i3, i3);
    }

    public final void p(int i3, int i4) {
        if (i3 < 0 || i3 > this.f29339a.b()) {
            throw new IndexOutOfBoundsException("start (" + i3 + ") offset is outside of text region " + this.f29339a.b());
        }
        if (i4 < 0 || i4 > this.f29339a.b()) {
            throw new IndexOutOfBoundsException("end (" + i4 + ") offset is outside of text region " + this.f29339a.b());
        }
        if (i3 <= i4) {
            r(i3);
            q(i4);
            return;
        }
        throw new IllegalArgumentException("Do not set reversed range: " + i3 + " > " + i4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final AnnotatedString s() {
        return new AnnotatedString(toString(), null, 2, 0 == true ? 1 : 0);
    }

    public String toString() {
        return this.f29339a.toString();
    }

    private EditingBuffer(AnnotatedString annotatedString, long j3) {
        this.f29339a = new PartialGapBuffer(annotatedString.k());
        this.f29340b = TextRange.l(j3);
        this.f29341c = TextRange.k(j3);
        this.f29342d = -1;
        this.f29343e = -1;
        int iL = TextRange.l(j3);
        int iK = TextRange.k(j3);
        if (iL < 0 || iL > annotatedString.length()) {
            throw new IndexOutOfBoundsException("start (" + iL + ") offset is outside of text region " + annotatedString.length());
        }
        if (iK < 0 || iK > annotatedString.length()) {
            throw new IndexOutOfBoundsException("end (" + iK + ") offset is outside of text region " + annotatedString.length());
        }
        if (iL <= iK) {
            return;
        }
        throw new IllegalArgumentException("Do not set reversed range: " + iL + " > " + iK);
    }

    public final void m(int i3, int i4, String str) {
        if (i3 < 0 || i3 > this.f29339a.b()) {
            throw new IndexOutOfBoundsException("start (" + i3 + ") offset is outside of text region " + this.f29339a.b());
        }
        if (i4 < 0 || i4 > this.f29339a.b()) {
            throw new IndexOutOfBoundsException("end (" + i4 + ") offset is outside of text region " + this.f29339a.b());
        }
        if (i3 <= i4) {
            this.f29339a.c(i3, i4, str);
            r(str.length() + i3);
            q(i3 + str.length());
            this.f29342d = -1;
            this.f29343e = -1;
            return;
        }
        throw new IllegalArgumentException("Do not set reversed range: " + i3 + bfIdKSjLOVjG.ypRDlKasb + i4);
    }
}
