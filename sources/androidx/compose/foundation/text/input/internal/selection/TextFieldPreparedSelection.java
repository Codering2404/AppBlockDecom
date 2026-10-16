package androidx.compose.foundation.text.input.internal.selection;

import androidx.compose.foundation.text.StringHelpersKt;
import androidx.compose.foundation.text.StringHelpers_androidKt;
import androidx.compose.foundation.text.input.TextFieldCharSequence;
import androidx.compose.foundation.text.input.internal.SelectionWedgeAffinity;
import androidx.compose.foundation.text.input.internal.TransformedTextFieldState;
import androidx.compose.foundation.text.input.internal.WedgeAffinity;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import kotlin.Metadata;
import kotlin.Unit;
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
public final class TextFieldPreparedSelection {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Companion f10741k = new Companion(null);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f10742l = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TransformedTextFieldState f10743a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TextLayoutResult f10744b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f10745c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f10746d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final TextFieldPreparedSelectionState f10747e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final TextFieldCharSequence f10748f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final SelectionWedgeAffinity f10749g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f10750h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private WedgeAffinity f10751i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final String f10752j;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public TextFieldPreparedSelection(TransformedTextFieldState transformedTextFieldState, TextLayoutResult textLayoutResult, boolean z2, float f3, TextFieldPreparedSelectionState textFieldPreparedSelectionState) {
        this.f10743a = transformedTextFieldState;
        this.f10744b = textLayoutResult;
        this.f10745c = z2;
        this.f10746d = f3;
        this.f10747e = textFieldPreparedSelectionState;
        Snapshot.Companion companion = Snapshot.f24914e;
        Snapshot snapshotD = companion.d();
        Function1 function1G = snapshotD != null ? snapshotD.g() : null;
        Snapshot snapshotE = companion.e(snapshotD);
        try {
            TextFieldCharSequence textFieldCharSequenceO = transformedTextFieldState.o();
            this.f10748f = textFieldCharSequenceO;
            this.f10749g = transformedTextFieldState.m();
            Unit unit = Unit.f139807a;
            companion.m(snapshotD, snapshotE, function1G);
            this.f10750h = textFieldCharSequenceO.g();
            this.f10752j = textFieldCharSequenceO.h().toString();
        } catch (Throwable th) {
            companion.m(snapshotD, snapshotE, function1G);
            throw th;
        }
    }

    private final int d(int i3) {
        return RangesKt.k(i3, this.f10752j.length() - 1);
    }

    private final int k(TextLayoutResult textLayoutResult, int i3) {
        return textLayoutResult.o(textLayoutResult.q(i3), true);
    }

    static /* synthetic */ int l(TextFieldPreparedSelection textFieldPreparedSelection, TextLayoutResult textLayoutResult, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i3 = TextRange.k(textFieldPreparedSelection.f10750h);
        }
        return textFieldPreparedSelection.k(textLayoutResult, i3);
    }

    private final int m(TextLayoutResult textLayoutResult, int i3) {
        return textLayoutResult.u(textLayoutResult.q(i3));
    }

    static /* synthetic */ int n(TextFieldPreparedSelection textFieldPreparedSelection, TextLayoutResult textLayoutResult, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i3 = TextRange.l(textFieldPreparedSelection.f10750h);
        }
        return textFieldPreparedSelection.m(textLayoutResult, i3);
    }

    private final int o(TextLayoutResult textLayoutResult, int i3) {
        while (i3 < this.f10748f.length()) {
            long jC = textLayoutResult.C(d(i3));
            if (TextRange.i(jC) > i3) {
                return TextRange.i(jC);
            }
            i3++;
        }
        return this.f10748f.length();
    }

    static /* synthetic */ int p(TextFieldPreparedSelection textFieldPreparedSelection, TextLayoutResult textLayoutResult, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i3 = TextRange.i(textFieldPreparedSelection.f10750h);
        }
        return textFieldPreparedSelection.o(textLayoutResult, i3);
    }

    private final int q(TextLayoutResult textLayoutResult, int i3) {
        while (i3 > 0) {
            long jC = textLayoutResult.C(d(i3));
            if (TextRange.n(jC) < i3) {
                return TextRange.n(jC);
            }
            i3--;
        }
        return 0;
    }

    static /* synthetic */ int r(TextFieldPreparedSelection textFieldPreparedSelection, TextLayoutResult textLayoutResult, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i3 = TextRange.i(textFieldPreparedSelection.f10750h);
        }
        return textFieldPreparedSelection.q(textLayoutResult, i3);
    }

    private final boolean u() {
        ResolvedTextDirection resolvedTextDirectionY;
        TextLayoutResult textLayoutResult = this.f10744b;
        return textLayoutResult == null || (resolvedTextDirectionY = textLayoutResult.y(TextRange.i(this.f10750h))) == null || resolvedTextDirectionY == ResolvedTextDirection.f29612a;
    }

    private final int v(TextLayoutResult textLayoutResult, int i3) {
        int i4 = TextRange.i(this.f10750h);
        if (Float.isNaN(this.f10747e.a())) {
            this.f10747e.c(textLayoutResult.e(i4).o());
        }
        int iQ = textLayoutResult.q(i4) + i3;
        if (iQ < 0) {
            return 0;
        }
        if (iQ >= textLayoutResult.n()) {
            return this.f10752j.length();
        }
        float fM = textLayoutResult.m(iQ) - 1;
        float fA = this.f10747e.a();
        if ((u() && fA >= textLayoutResult.t(iQ)) || (!u() && fA <= textLayoutResult.s(iQ))) {
            return textLayoutResult.o(iQ, true);
        }
        return textLayoutResult.x(Offset.e((((long) Float.floatToRawIntBits(fA)) << 32) | (((long) Float.floatToRawIntBits(fM)) & 4294967295L)));
    }

    private final int w(int i3) {
        int i4 = TextRange.i(this.f10748f.g());
        if (this.f10744b == null || Float.isNaN(this.f10746d)) {
            return i4;
        }
        Rect rectA = this.f10744b.e(i4).A(0.0f, this.f10746d * i3);
        float fM = this.f10744b.m(this.f10744b.r(rectA.r()));
        return Math.abs(rectA.r() - fM) > Math.abs(rectA.i() - fM) ? this.f10744b.x(rectA.t()) : this.f10744b.x(rectA.k());
    }

    public final TextFieldPreparedSelection A() {
        return u() ? G() : D();
    }

    public final TextFieldPreparedSelection B() {
        this.f10747e.b();
        if (this.f10752j.length() > 0) {
            int i3 = TextRange.i(s());
            long jA = TextPreparedSelectionKt.a(StringHelpers_androidKt.a(this.f10752j, TextRange.i(this.f10750h)), i3, this.f10743a);
            int iA = CursorAndWedgeAffinity.a(jA);
            WedgeAffinity wedgeAffinityB = CursorAndWedgeAffinity.b(jA);
            if (iA != i3 || !TextRange.h(s())) {
                T(TextRangeKt.a(iA));
            }
            if (wedgeAffinityB != null) {
                U(wedgeAffinityB);
            }
        }
        return this;
    }

    public final TextFieldPreparedSelection C() {
        this.f10747e.b();
        if (this.f10752j.length() > 0) {
            int i3 = TextRange.i(s());
            int iA = StringHelpersKt.a(this.f10752j, TextRange.k(this.f10750h));
            if (iA == TextRange.k(this.f10750h) && iA != this.f10752j.length()) {
                iA = StringHelpersKt.a(this.f10752j, iA + 1);
            }
            long jA = TextPreparedSelectionKt.a(iA, i3, this.f10743a);
            int iA2 = CursorAndWedgeAffinity.a(jA);
            WedgeAffinity wedgeAffinityB = CursorAndWedgeAffinity.b(jA);
            if (iA2 != i3 || !TextRange.h(s())) {
                T(TextRangeKt.a(iA2));
            }
            if (wedgeAffinityB != null) {
                U(wedgeAffinityB);
            }
        }
        return this;
    }

    public final TextFieldPreparedSelection D() {
        this.f10747e.b();
        if (this.f10752j.length() > 0) {
            int i3 = TextRange.i(s());
            TextLayoutResult textLayoutResult = this.f10744b;
            long jA = TextPreparedSelectionKt.a(textLayoutResult != null ? p(this, textLayoutResult, 0, 1, null) : this.f10752j.length(), i3, this.f10743a);
            int iA = CursorAndWedgeAffinity.a(jA);
            WedgeAffinity wedgeAffinityB = CursorAndWedgeAffinity.b(jA);
            if (iA != i3 || !TextRange.h(s())) {
                T(TextRangeKt.a(iA));
            }
            if (wedgeAffinityB != null) {
                U(wedgeAffinityB);
            }
        }
        return this;
    }

    public final TextFieldPreparedSelection E() {
        this.f10747e.b();
        if (this.f10752j.length() > 0) {
            int i3 = TextRange.i(s());
            long jA = TextPreparedSelectionKt.a(StringHelpers_androidKt.b(this.f10752j, TextRange.i(this.f10750h)), i3, this.f10743a);
            int iA = CursorAndWedgeAffinity.a(jA);
            WedgeAffinity wedgeAffinityB = CursorAndWedgeAffinity.b(jA);
            if (iA != i3 || !TextRange.h(s())) {
                T(TextRangeKt.a(iA));
            }
            if (wedgeAffinityB != null) {
                U(wedgeAffinityB);
            }
        }
        return this;
    }

    public final TextFieldPreparedSelection F() {
        this.f10747e.b();
        if (this.f10752j.length() > 0) {
            int i3 = TextRange.i(s());
            int iB = StringHelpersKt.b(this.f10752j, TextRange.l(this.f10750h));
            if (iB == TextRange.l(this.f10750h) && iB != 0) {
                iB = StringHelpersKt.b(this.f10752j, iB - 1);
            }
            long jA = TextPreparedSelectionKt.a(iB, i3, this.f10743a);
            int iA = CursorAndWedgeAffinity.a(jA);
            WedgeAffinity wedgeAffinityB = CursorAndWedgeAffinity.b(jA);
            if (iA != i3 || !TextRange.h(s())) {
                T(TextRangeKt.a(iA));
            }
            if (wedgeAffinityB != null) {
                U(wedgeAffinityB);
            }
        }
        return this;
    }

    public final TextFieldPreparedSelection G() {
        this.f10747e.b();
        if (this.f10752j.length() > 0) {
            int i3 = TextRange.i(s());
            TextLayoutResult textLayoutResult = this.f10744b;
            long jA = TextPreparedSelectionKt.a(textLayoutResult != null ? r(this, textLayoutResult, 0, 1, null) : 0, i3, this.f10743a);
            int iA = CursorAndWedgeAffinity.a(jA);
            WedgeAffinity wedgeAffinityB = CursorAndWedgeAffinity.b(jA);
            if (iA != i3 || !TextRange.h(s())) {
                T(TextRangeKt.a(iA));
            }
            if (wedgeAffinityB != null) {
                U(wedgeAffinityB);
            }
        }
        return this;
    }

    public final TextFieldPreparedSelection H() {
        return u() ? B() : E();
    }

    public final TextFieldPreparedSelection I() {
        return u() ? D() : G();
    }

    public final TextFieldPreparedSelection J() {
        this.f10747e.b();
        if (this.f10752j.length() > 0) {
            int i3 = TextRange.i(s());
            long jA = TextPreparedSelectionKt.a(this.f10752j.length(), i3, this.f10743a);
            int iA = CursorAndWedgeAffinity.a(jA);
            WedgeAffinity wedgeAffinityB = CursorAndWedgeAffinity.b(jA);
            if (iA != i3 || !TextRange.h(s())) {
                T(TextRangeKt.a(iA));
            }
            if (wedgeAffinityB != null) {
                U(wedgeAffinityB);
            }
        }
        return this;
    }

    public final TextFieldPreparedSelection K() {
        this.f10747e.b();
        if (this.f10752j.length() > 0) {
            int i3 = TextRange.i(s());
            long jA = TextPreparedSelectionKt.a(0, i3, this.f10743a);
            int iA = CursorAndWedgeAffinity.a(jA);
            WedgeAffinity wedgeAffinityB = CursorAndWedgeAffinity.b(jA);
            if (iA != i3 || !TextRange.h(s())) {
                T(TextRangeKt.a(iA));
            }
            if (wedgeAffinityB != null) {
                U(wedgeAffinityB);
            }
        }
        return this;
    }

    public final TextFieldPreparedSelection L() {
        this.f10747e.b();
        if (this.f10752j.length() > 0) {
            int i3 = TextRange.i(s());
            TextLayoutResult textLayoutResult = this.f10744b;
            long jA = TextPreparedSelectionKt.a(textLayoutResult != null ? l(this, textLayoutResult, 0, 1, null) : this.f10752j.length(), i3, this.f10743a);
            int iA = CursorAndWedgeAffinity.a(jA);
            WedgeAffinity wedgeAffinityB = CursorAndWedgeAffinity.b(jA);
            if (iA != i3 || !TextRange.h(s())) {
                T(TextRangeKt.a(iA));
            }
            if (wedgeAffinityB != null) {
                U(wedgeAffinityB);
            }
        }
        return this;
    }

    public final TextFieldPreparedSelection M() {
        return u() ? O() : L();
    }

    public final TextFieldPreparedSelection N() {
        return u() ? L() : O();
    }

    public final TextFieldPreparedSelection O() {
        this.f10747e.b();
        if (this.f10752j.length() > 0) {
            int i3 = TextRange.i(s());
            TextLayoutResult textLayoutResult = this.f10744b;
            long jA = TextPreparedSelectionKt.a(textLayoutResult != null ? n(this, textLayoutResult, 0, 1, null) : 0, i3, this.f10743a);
            int iA = CursorAndWedgeAffinity.a(jA);
            WedgeAffinity wedgeAffinityB = CursorAndWedgeAffinity.b(jA);
            if (iA != i3 || !TextRange.h(s())) {
                T(TextRangeKt.a(iA));
            }
            if (wedgeAffinityB != null) {
                U(wedgeAffinityB);
            }
        }
        return this;
    }

    public final TextFieldPreparedSelection P() {
        if (this.f10752j.length() > 0) {
            int i3 = TextRange.i(s());
            TextLayoutResult textLayoutResult = this.f10744b;
            long jA = TextPreparedSelectionKt.a(textLayoutResult != null ? v(textLayoutResult, -1) : 0, i3, this.f10743a);
            int iA = CursorAndWedgeAffinity.a(jA);
            WedgeAffinity wedgeAffinityB = CursorAndWedgeAffinity.b(jA);
            if (iA != i3 || !TextRange.h(s())) {
                T(TextRangeKt.a(iA));
            }
            if (wedgeAffinityB != null) {
                U(wedgeAffinityB);
            }
        }
        return this;
    }

    public final TextFieldPreparedSelection Q() {
        if (this.f10752j.length() > 0) {
            int i3 = TextRange.i(s());
            long jA = TextPreparedSelectionKt.a(w(-1), i3, this.f10743a);
            int iA = CursorAndWedgeAffinity.a(jA);
            WedgeAffinity wedgeAffinityB = CursorAndWedgeAffinity.b(jA);
            if (iA != i3 || !TextRange.h(s())) {
                T(TextRangeKt.a(iA));
            }
            if (wedgeAffinityB != null) {
                U(wedgeAffinityB);
            }
        }
        return this;
    }

    public final TextFieldPreparedSelection R() {
        this.f10747e.b();
        if (this.f10752j.length() > 0) {
            this.f10750h = TextRangeKt.b(0, this.f10752j.length());
        }
        return this;
    }

    public final TextFieldPreparedSelection S() {
        if (this.f10752j.length() > 0) {
            this.f10750h = TextRangeKt.b(TextRange.n(this.f10748f.g()), TextRange.i(this.f10750h));
        }
        return this;
    }

    public final void T(long j3) {
        this.f10750h = j3;
    }

    public final void U(WedgeAffinity wedgeAffinity) {
        this.f10751i = wedgeAffinity;
    }

    public final TextFieldPreparedSelection e(Function1 function1) {
        this.f10747e.b();
        if (this.f10752j.length() > 0) {
            if (TextRange.h(this.f10750h)) {
                function1.invoke(this);
                return this;
            }
            if (u()) {
                this.f10750h = TextRangeKt.a(TextRange.l(this.f10750h));
                return this;
            }
            this.f10750h = TextRangeKt.a(TextRange.k(this.f10750h));
        }
        return this;
    }

    public final TextFieldPreparedSelection f(Function1 function1) {
        this.f10747e.b();
        if (this.f10752j.length() > 0) {
            if (TextRange.h(this.f10750h)) {
                function1.invoke(this);
                return this;
            }
            if (u()) {
                this.f10750h = TextRangeKt.a(TextRange.k(this.f10750h));
                return this;
            }
            this.f10750h = TextRangeKt.a(TextRange.l(this.f10750h));
        }
        return this;
    }

    public final TextFieldPreparedSelection g() {
        if (this.f10752j.length() > 0) {
            if (TextRange.h(this.f10748f.g())) {
                TransformedTextFieldState.z(this.f10743a, "", TextRangeKt.b(TextRange.n(this.f10748f.g()), TextRange.i(this.f10750h)), null, !this.f10745c, 4, null);
            } else {
                this.f10743a.k();
            }
            this.f10750h = this.f10743a.o().g();
            this.f10751i = WedgeAffinity.f10685a;
        }
        return this;
    }

    public final TextFieldPreparedSelection h() {
        this.f10747e.b();
        if (this.f10752j.length() > 0) {
            this.f10750h = TextRangeKt.a(TextRange.i(this.f10750h));
        }
        return this;
    }

    public final TextFieldCharSequence i() {
        return this.f10748f;
    }

    public final SelectionWedgeAffinity j() {
        return this.f10749g;
    }

    public final long s() {
        return this.f10750h;
    }

    public final WedgeAffinity t() {
        return this.f10751i;
    }

    public final TextFieldPreparedSelection x() {
        if (this.f10752j.length() > 0) {
            int i3 = TextRange.i(s());
            TextLayoutResult textLayoutResult = this.f10744b;
            long jA = TextPreparedSelectionKt.a(textLayoutResult != null ? v(textLayoutResult, 1) : this.f10752j.length(), i3, this.f10743a);
            int iA = CursorAndWedgeAffinity.a(jA);
            WedgeAffinity wedgeAffinityB = CursorAndWedgeAffinity.b(jA);
            if (iA != i3 || !TextRange.h(s())) {
                T(TextRangeKt.a(iA));
            }
            if (wedgeAffinityB != null) {
                U(wedgeAffinityB);
            }
        }
        return this;
    }

    public final TextFieldPreparedSelection y() {
        if (this.f10752j.length() > 0) {
            int i3 = TextRange.i(s());
            long jA = TextPreparedSelectionKt.a(w(1), i3, this.f10743a);
            int iA = CursorAndWedgeAffinity.a(jA);
            WedgeAffinity wedgeAffinityB = CursorAndWedgeAffinity.b(jA);
            if (iA != i3 || !TextRange.h(s())) {
                T(TextRangeKt.a(iA));
            }
            if (wedgeAffinityB != null) {
                U(wedgeAffinityB);
            }
        }
        return this;
    }

    public final TextFieldPreparedSelection z() {
        return u() ? E() : B();
    }
}
