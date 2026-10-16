package androidx.compose.foundation.text.input;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.text.input.internal.ChangeTracker;
import androidx.compose.foundation.text.input.internal.OffsetMappingCalculator;
import androidx.compose.foundation.text.input.internal.PartialGapBuffer;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class TextFieldBuffer implements Appendable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TextFieldCharSequence f10129a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final OffsetMappingCalculator f10130b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final PartialGapBuffer f10131c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ChangeTracker f10132d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f10133f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private TextRange f10134g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private MutableVector f10135h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Pair f10136i;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface ChangeList {
        long a(int i3);

        int b();

        long c(int i3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TextFieldBuffer(final TextFieldCharSequence textFieldCharSequence, ChangeTracker changeTracker, TextFieldCharSequence textFieldCharSequence2, OffsetMappingCalculator offsetMappingCalculator) {
        this.f10129a = textFieldCharSequence2;
        this.f10130b = offsetMappingCalculator;
        this.f10131c = new PartialGapBuffer(textFieldCharSequence);
        MutableVector mutableVector = null;
        this.f10132d = changeTracker != null ? new ChangeTracker(changeTracker) : null;
        this.f10133f = textFieldCharSequence.g();
        this.f10134g = textFieldCharSequence.d();
        List listC = textFieldCharSequence.c();
        if (listC != null && !listC.isEmpty()) {
            int size = textFieldCharSequence.c().size();
            Function1<Integer, AnnotatedString.Range<AnnotatedString.Annotation>> function1 = new Function1<Integer, AnnotatedString.Range<AnnotatedString.Annotation>>() { // from class: androidx.compose.foundation.text.input.TextFieldBuffer$composingAnnotations$1
                {
                    super(1);
                }

                public final AnnotatedString.Range c(int i3) {
                    return (AnnotatedString.Range) textFieldCharSequence.c().get(i3);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return c(((Number) obj).intValue());
                }
            };
            AnnotatedString.Range[] rangeArr = new AnnotatedString.Range[size];
            for (int i3 = 0; i3 < size; i3++) {
                rangeArr[i3] = function1.invoke(Integer.valueOf(i3));
            }
            mutableVector = new MutableVector(rangeArr, size);
        }
        this.f10135h = mutableVector;
    }

    public static /* synthetic */ TextFieldCharSequence A(TextFieldBuffer textFieldBuffer, long j3, TextRange textRange, List list, int i3, Object obj) {
        MutableVector mutableVector;
        if ((i3 & 1) != 0) {
            j3 = textFieldBuffer.l();
        }
        if ((i3 & 2) != 0) {
            textRange = textFieldBuffer.f10134g;
        }
        if ((i3 & 4) != 0 && ((mutableVector = textFieldBuffer.f10135h) == null || (list = mutableVector.h()) == null || list.isEmpty())) {
            list = null;
        }
        return textFieldBuffer.z(j3, textRange, list);
    }

    private final void b() {
        e().e();
    }

    private final void o(int i3, int i4, int i5) {
        e().f(i3, i4, i5);
        OffsetMappingCalculator offsetMappingCalculator = this.f10130b;
        if (offsetMappingCalculator != null) {
            offsetMappingCalculator.e(i3, i4, i5);
        }
        this.f10133f = TextFieldBufferKt.a(l(), i3, i4, i5);
    }

    private final void r(long j3) {
        long jB = TextRangeKt.b(0, j());
        if (TextRange.d(jB, j3)) {
            return;
        }
        InlineClassHelperKt.a("Expected " + ((Object) TextRange.q(j3)) + " to be in " + ((Object) TextRange.q(jB)));
    }

    public static /* synthetic */ void u(TextFieldBuffer textFieldBuffer, int i3, int i4, List list, int i5, Object obj) {
        if ((i5 & 4) != 0) {
            list = null;
        }
        textFieldBuffer.t(i3, i4, list);
    }

    private final void v(TextRange textRange) {
        if (textRange != null && !TextRange.h(textRange.r())) {
            this.f10134g = textRange;
            return;
        }
        this.f10134g = null;
        MutableVector mutableVector = this.f10135h;
        if (mutableVector != null) {
            mutableVector.i();
        }
    }

    public final CharSequence a() {
        return this.f10131c;
    }

    @Override // java.lang.Appendable
    public Appendable append(CharSequence charSequence) {
        if (charSequence != null) {
            o(j(), j(), charSequence.length());
            PartialGapBuffer partialGapBuffer = this.f10131c;
            PartialGapBuffer.d(partialGapBuffer, partialGapBuffer.length(), this.f10131c.length(), charSequence, 0, 0, 24, null);
        }
        return this;
    }

    public final void c() {
        this.f10136i = null;
    }

    public final void d() {
        v(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final ChangeTracker e() {
        ChangeTracker changeTracker = this.f10132d;
        if (changeTracker != null) {
            return changeTracker;
        }
        ChangeTracker changeTracker2 = new ChangeTracker(null, 1, 0 == true ? 1 : 0);
        this.f10132d = changeTracker2;
        return changeTracker2;
    }

    public final ChangeList f() {
        return e();
    }

    public final MutableVector g() {
        return this.f10135h;
    }

    public final TextRange h() {
        return this.f10134g;
    }

    public final Pair i() {
        return this.f10136i;
    }

    public final int j() {
        return this.f10131c.length();
    }

    public final TextFieldCharSequence k() {
        return this.f10129a;
    }

    public final long l() {
        return this.f10133f;
    }

    public final boolean m() {
        return this.f10134g != null;
    }

    public final boolean n() {
        return !TextRange.h(l());
    }

    public final void p(int i3, int i4, CharSequence charSequence) {
        q(i3, i4, charSequence, 0, charSequence.length());
    }

    public final void q(int i3, int i4, CharSequence charSequence, int i5, int i6) {
        if (!(i3 <= i4)) {
            InlineClassHelperKt.a("Expected start=" + i3 + " <= end=" + i4);
        }
        if (!(i5 <= i6)) {
            InlineClassHelperKt.a("Expected textStart=" + i5 + " <= textEnd=" + i6);
        }
        o(i3, i4, i6 - i5);
        this.f10131c.c(i3, i4, charSequence, i5, i6);
        d();
        c();
    }

    public final void s() {
        p(0, j(), this.f10129a.toString());
        x(this.f10129a.g());
        b();
    }

    public final void t(int i3, int i4, List list) {
        if (i3 < 0 || i3 > this.f10131c.length()) {
            throw new IndexOutOfBoundsException("start (" + i3 + ") offset is outside of text region " + this.f10131c.length());
        }
        if (i4 < 0 || i4 > this.f10131c.length()) {
            throw new IndexOutOfBoundsException("end (" + i4 + ") offset is outside of text region " + this.f10131c.length());
        }
        if (i3 >= i4) {
            throw new IllegalArgumentException("Do not set reversed or empty range: " + i3 + " > " + i4);
        }
        v(TextRange.b(TextRangeKt.b(i3, i4)));
        MutableVector mutableVector = this.f10135h;
        if (mutableVector != null) {
            mutableVector.i();
        }
        List list2 = list;
        if (list2 == null || list2.isEmpty()) {
            return;
        }
        if (this.f10135h == null) {
            this.f10135h = new MutableVector(new AnnotatedString.Range[16], 0);
        }
        int size = list2.size();
        for (int i5 = 0; i5 < size; i5++) {
            AnnotatedString.Range range = (AnnotatedString.Range) list.get(i5);
            MutableVector mutableVector2 = this.f10135h;
            if (mutableVector2 != null) {
                mutableVector2.b(AnnotatedString.Range.e(range, null, range.h() + i3, range.f() + i3, null, 9, null));
            }
        }
    }

    public String toString() {
        return this.f10131c.toString();
    }

    public final void w(int i3, int i4, int i5) {
        if (i4 < i5) {
            this.f10136i = new Pair(TextHighlightType.c(i3), TextRange.b(TextRangeKt.b(RangesKt.p(i4, 0, j()), RangesKt.p(i5, 0, j()))));
        } else {
            throw new IllegalArgumentException("Do not set reversed or empty range: " + i4 + " > " + i5);
        }
    }

    public final void x(long j3) {
        r(j3);
        this.f10133f = j3;
        this.f10136i = null;
    }

    public final void y(CharSequence charSequence) {
        int i3;
        int i4;
        PartialGapBuffer partialGapBuffer = this.f10131c;
        int length = partialGapBuffer.length();
        int length2 = charSequence.length();
        boolean z2 = false;
        if (partialGapBuffer.length() <= 0 || charSequence.length() <= 0) {
            i3 = 0;
            i4 = 0;
        } else {
            int i5 = 0;
            int i6 = 0;
            boolean z3 = false;
            while (true) {
                if (!z2) {
                    if (partialGapBuffer.charAt(i5) == charSequence.charAt(i6)) {
                        i5++;
                        i6++;
                    } else {
                        z2 = true;
                    }
                }
                if (!z3) {
                    if (partialGapBuffer.charAt(length - 1) == charSequence.charAt(length2 - 1)) {
                        length--;
                        length2--;
                    } else {
                        z3 = true;
                    }
                }
                if (i5 >= length || i6 >= length2 || (z2 && z3)) {
                    break;
                }
            }
            i3 = i5;
            i4 = i6;
        }
        int i7 = length;
        int i8 = length2;
        if (i3 < i7 || i4 < i8) {
            q(i3, i7, charSequence, i4, i8);
        }
    }

    public final TextFieldCharSequence z(long j3, TextRange textRange, List list) {
        return new TextFieldCharSequence(this.f10131c.toString(), j3, textRange, null, list, 8, null);
    }

    @Override // java.lang.Appendable
    public Appendable append(CharSequence charSequence, int i3, int i4) {
        if (charSequence != null) {
            o(j(), j(), i4 - i3);
            PartialGapBuffer partialGapBuffer = this.f10131c;
            PartialGapBuffer.d(partialGapBuffer, partialGapBuffer.length(), this.f10131c.length(), charSequence.subSequence(i3, i4), 0, 0, 24, null);
        }
        return this;
    }

    @Override // java.lang.Appendable
    public Appendable append(char c3) {
        o(j(), j(), 1);
        PartialGapBuffer partialGapBuffer = this.f10131c;
        PartialGapBuffer.d(partialGapBuffer, partialGapBuffer.length(), this.f10131c.length(), String.valueOf(c3), 0, 0, 24, null);
        return this;
    }

    public /* synthetic */ TextFieldBuffer(TextFieldCharSequence textFieldCharSequence, ChangeTracker changeTracker, TextFieldCharSequence textFieldCharSequence2, OffsetMappingCalculator offsetMappingCalculator, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(textFieldCharSequence, (i3 & 2) != 0 ? null : changeTracker, (i3 & 4) != 0 ? textFieldCharSequence : textFieldCharSequence2, (i3 & 8) != 0 ? null : offsetMappingCalculator);
    }
}
