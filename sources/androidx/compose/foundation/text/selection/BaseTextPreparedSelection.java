package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.StringHelpersKt;
import androidx.compose.foundation.text.StringHelpers_androidKt;
import androidx.compose.foundation.text.selection.BaseTextPreparedSelection;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
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
public abstract class BaseTextPreparedSelection<T extends BaseTextPreparedSelection<T>> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Companion f11200h = new Companion(null);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f11201i = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AnnotatedString f11202a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f11203b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final TextLayoutResult f11204c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final OffsetMapping f11205d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final TextPreparedSelectionState f11206e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f11207f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private AnnotatedString f11208g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public /* synthetic */ BaseTextPreparedSelection(AnnotatedString annotatedString, long j3, TextLayoutResult textLayoutResult, OffsetMapping offsetMapping, TextPreparedSelectionState textPreparedSelectionState, DefaultConstructorMarker defaultConstructorMarker) {
        this(annotatedString, j3, textLayoutResult, offsetMapping, textPreparedSelectionState);
    }

    private final BaseTextPreparedSelection C() {
        int iL;
        v().b();
        if (w().length() > 0 && (iL = l()) != -1) {
            T(iL);
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    private final BaseTextPreparedSelection E() {
        Integer numM;
        v().b();
        if (w().length() > 0 && (numM = m()) != null) {
            T(numM.intValue());
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    private final BaseTextPreparedSelection F() {
        int iQ;
        v().b();
        if (w().length() > 0 && (iQ = q()) != -1) {
            T(iQ);
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    private final BaseTextPreparedSelection H() {
        Integer numT;
        v().b();
        if (w().length() > 0 && (numT = t()) != null) {
            T(numT.intValue());
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    private final int V() {
        return this.f11205d.b(TextRange.i(this.f11207f));
    }

    private final int W() {
        return this.f11205d.b(TextRange.k(this.f11207f));
    }

    private final int X() {
        return this.f11205d.b(TextRange.l(this.f11207f));
    }

    private final int a(int i3) {
        return RangesKt.k(i3, w().length() - 1);
    }

    private final int g(TextLayoutResult textLayoutResult, int i3) {
        return this.f11205d.a(textLayoutResult.o(textLayoutResult.q(i3), true));
    }

    static /* synthetic */ int h(BaseTextPreparedSelection baseTextPreparedSelection, TextLayoutResult textLayoutResult, int i3, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getLineEndByOffsetForLayout");
        }
        if ((i4 & 1) != 0) {
            i3 = baseTextPreparedSelection.W();
        }
        return baseTextPreparedSelection.g(textLayoutResult, i3);
    }

    private final int j(TextLayoutResult textLayoutResult, int i3) {
        return this.f11205d.a(textLayoutResult.u(textLayoutResult.q(i3)));
    }

    static /* synthetic */ int k(BaseTextPreparedSelection baseTextPreparedSelection, TextLayoutResult textLayoutResult, int i3, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getLineStartByOffsetForLayout");
        }
        if ((i4 & 1) != 0) {
            i3 = baseTextPreparedSelection.X();
        }
        return baseTextPreparedSelection.j(textLayoutResult, i3);
    }

    private final int n(TextLayoutResult textLayoutResult, int i3) {
        while (i3 < this.f11202a.length()) {
            long jC = textLayoutResult.C(a(i3));
            if (TextRange.i(jC) > i3) {
                return this.f11205d.a(TextRange.i(jC));
            }
            i3++;
        }
        return this.f11202a.length();
    }

    static /* synthetic */ int o(BaseTextPreparedSelection baseTextPreparedSelection, TextLayoutResult textLayoutResult, int i3, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getNextWordOffsetForLayout");
        }
        if ((i4 & 1) != 0) {
            i3 = baseTextPreparedSelection.V();
        }
        return baseTextPreparedSelection.n(textLayoutResult, i3);
    }

    private final int r(TextLayoutResult textLayoutResult, int i3) {
        while (i3 > 0) {
            long jC = textLayoutResult.C(a(i3));
            if (TextRange.n(jC) < i3) {
                return this.f11205d.a(TextRange.n(jC));
            }
            i3--;
        }
        return 0;
    }

    static /* synthetic */ int s(BaseTextPreparedSelection baseTextPreparedSelection, TextLayoutResult textLayoutResult, int i3, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getPrevWordOffset");
        }
        if ((i4 & 1) != 0) {
            i3 = baseTextPreparedSelection.V();
        }
        return baseTextPreparedSelection.r(textLayoutResult, i3);
    }

    private final boolean x() {
        TextLayoutResult textLayoutResult = this.f11204c;
        return (textLayoutResult != null ? textLayoutResult.y(V()) : null) != ResolvedTextDirection.f29613b;
    }

    private final int y(TextLayoutResult textLayoutResult, int i3) {
        int iV = V();
        if (this.f11206e.a() == null) {
            this.f11206e.c(Float.valueOf(textLayoutResult.e(iV).o()));
        }
        int iQ = textLayoutResult.q(iV) + i3;
        if (iQ < 0) {
            return 0;
        }
        if (iQ >= textLayoutResult.n()) {
            return w().length();
        }
        float fM = textLayoutResult.m(iQ) - 1;
        Float fA = this.f11206e.a();
        Intrinsics.checkNotNull(fA);
        float fFloatValue = fA.floatValue();
        if ((x() && fFloatValue >= textLayoutResult.t(iQ)) || (!x() && fFloatValue <= textLayoutResult.s(iQ))) {
            return textLayoutResult.o(iQ, true);
        }
        return this.f11205d.a(textLayoutResult.x(Offset.e((((long) Float.floatToRawIntBits(fA.floatValue())) << 32) | (((long) Float.floatToRawIntBits(fM)) & 4294967295L))));
    }

    public final BaseTextPreparedSelection A() {
        v().b();
        if (w().length() > 0) {
            if (x()) {
                F();
            } else {
                C();
            }
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    public final BaseTextPreparedSelection B() {
        v().b();
        if (w().length() > 0) {
            if (x()) {
                H();
            } else {
                E();
            }
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    public final BaseTextPreparedSelection D() {
        v().b();
        if (w().length() > 0) {
            int iA = StringHelpersKt.a(w(), TextRange.k(this.f11207f));
            if (iA == TextRange.k(this.f11207f) && iA != w().length()) {
                iA = StringHelpersKt.a(w(), iA + 1);
            }
            T(iA);
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    public final BaseTextPreparedSelection G() {
        v().b();
        if (w().length() > 0) {
            int iB = StringHelpersKt.b(w(), TextRange.l(this.f11207f));
            if (iB == TextRange.l(this.f11207f) && iB != 0) {
                iB = StringHelpersKt.b(w(), iB - 1);
            }
            T(iB);
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    public final BaseTextPreparedSelection I() {
        v().b();
        if (w().length() > 0) {
            if (x()) {
                C();
            } else {
                F();
            }
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    public final BaseTextPreparedSelection J() {
        v().b();
        if (w().length() > 0) {
            if (x()) {
                E();
            } else {
                H();
            }
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    public final BaseTextPreparedSelection K() {
        v().b();
        if (w().length() > 0) {
            T(w().length());
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    public final BaseTextPreparedSelection L() {
        v().b();
        if (w().length() > 0) {
            T(0);
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    public final BaseTextPreparedSelection M() {
        Integer numF;
        v().b();
        if (w().length() > 0 && (numF = f()) != null) {
            T(numF.intValue());
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    public final BaseTextPreparedSelection N() {
        v().b();
        if (w().length() > 0) {
            if (x()) {
                P();
            } else {
                M();
            }
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    public final BaseTextPreparedSelection O() {
        v().b();
        if (w().length() > 0) {
            if (x()) {
                M();
            } else {
                P();
            }
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    public final BaseTextPreparedSelection P() {
        Integer numI;
        v().b();
        if (w().length() > 0 && (numI = i()) != null) {
            T(numI.intValue());
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    public final BaseTextPreparedSelection Q() {
        TextLayoutResult textLayoutResult;
        if (w().length() > 0 && (textLayoutResult = this.f11204c) != null) {
            T(y(textLayoutResult, -1));
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    public final BaseTextPreparedSelection R() {
        v().b();
        if (w().length() > 0) {
            U(0, w().length());
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    public final BaseTextPreparedSelection S() {
        if (w().length() > 0) {
            this.f11207f = TextRangeKt.b(TextRange.n(this.f11203b), TextRange.i(this.f11207f));
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    protected final void T(int i3) {
        U(i3, i3);
    }

    protected final void U(int i3, int i4) {
        this.f11207f = TextRangeKt.b(i3, i4);
    }

    public final BaseTextPreparedSelection b(Function1 function1) {
        v().b();
        if (w().length() > 0) {
            if (TextRange.h(this.f11207f)) {
                Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
                function1.invoke(this);
            } else if (x()) {
                T(TextRange.l(this.f11207f));
            } else {
                T(TextRange.k(this.f11207f));
            }
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    public final BaseTextPreparedSelection c(Function1 function1) {
        v().b();
        if (w().length() > 0) {
            if (TextRange.h(this.f11207f)) {
                Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
                function1.invoke(this);
            } else if (x()) {
                T(TextRange.k(this.f11207f));
            } else {
                T(TextRange.l(this.f11207f));
            }
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    public final BaseTextPreparedSelection d() {
        v().b();
        if (w().length() > 0) {
            T(TextRange.i(this.f11207f));
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    public final AnnotatedString e() {
        return this.f11208g;
    }

    public final Integer f() {
        TextLayoutResult textLayoutResult = this.f11204c;
        if (textLayoutResult != null) {
            return Integer.valueOf(h(this, textLayoutResult, 0, 1, null));
        }
        return null;
    }

    public final Integer i() {
        TextLayoutResult textLayoutResult = this.f11204c;
        if (textLayoutResult != null) {
            return Integer.valueOf(k(this, textLayoutResult, 0, 1, null));
        }
        return null;
    }

    public final int l() {
        return StringHelpers_androidKt.a(this.f11208g.k(), TextRange.i(this.f11207f));
    }

    public final Integer m() {
        TextLayoutResult textLayoutResult = this.f11204c;
        if (textLayoutResult != null) {
            return Integer.valueOf(o(this, textLayoutResult, 0, 1, null));
        }
        return null;
    }

    public final OffsetMapping p() {
        return this.f11205d;
    }

    public final int q() {
        return StringHelpers_androidKt.b(this.f11208g.k(), TextRange.i(this.f11207f));
    }

    public final Integer t() {
        TextLayoutResult textLayoutResult = this.f11204c;
        if (textLayoutResult != null) {
            return Integer.valueOf(s(this, textLayoutResult, 0, 1, null));
        }
        return null;
    }

    public final long u() {
        return this.f11207f;
    }

    public final TextPreparedSelectionState v() {
        return this.f11206e;
    }

    public final String w() {
        return this.f11208g.k();
    }

    public final BaseTextPreparedSelection z() {
        TextLayoutResult textLayoutResult;
        if (w().length() > 0 && (textLayoutResult = this.f11204c) != null) {
            T(y(textLayoutResult, 1));
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    private BaseTextPreparedSelection(AnnotatedString annotatedString, long j3, TextLayoutResult textLayoutResult, OffsetMapping offsetMapping, TextPreparedSelectionState textPreparedSelectionState) {
        this.f11202a = annotatedString;
        this.f11203b = j3;
        this.f11204c = textLayoutResult;
        this.f11205d = offsetMapping;
        this.f11206e = textPreparedSelectionState;
        this.f11207f = j3;
        this.f11208g = annotatedString;
    }
}
