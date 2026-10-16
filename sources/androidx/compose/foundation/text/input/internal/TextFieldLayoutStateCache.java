package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text.input.TextFieldCharSequence;
import androidx.compose.foundation.text.input.internal.TextFieldLayoutStateCache;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.runtime.snapshots.StateObject;
import androidx.compose.runtime.snapshots.StateRecord;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextLayoutInput;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextMeasurer;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.intl.Locale;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import com.google.android.gms.common.api.Api;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

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
public final class TextFieldLayoutStateCache implements State<TextLayoutResult>, StateObject {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TextMeasurer f10615c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MutableState f10613a = SnapshotStateKt.i(null, NonMeasureInputs.f10637f.a());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MutableState f10614b = SnapshotStateKt.i(null, MeasureInputs.f10629g.a());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private CacheRecord f10616d = new CacheRecord();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class CacheRecord extends StateRecord {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private CharSequence f10617c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private List f10618d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private TextRange f10619e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private TextStyle f10620f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f10621g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f10622h;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private LayoutDirection f10625k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private FontFamily.Resolver f10626l;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private TextLayoutResult f10628n;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private float f10623i = Float.NaN;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private float f10624j = Float.NaN;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private long f10627m = ConstraintsKt.b(0, 0, 0, 0, 15, null);

        public final void A(float f3) {
            this.f10624j = f3;
        }

        public final void B(LayoutDirection layoutDirection) {
            this.f10625k = layoutDirection;
        }

        public final void C(TextLayoutResult textLayoutResult) {
            this.f10628n = textLayoutResult;
        }

        public final void D(boolean z2) {
            this.f10621g = z2;
        }

        public final void E(boolean z2) {
            this.f10622h = z2;
        }

        public final void F(TextStyle textStyle) {
            this.f10620f = textStyle;
        }

        public final void G(CharSequence charSequence) {
            this.f10617c = charSequence;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public void c(StateRecord stateRecord) {
            Intrinsics.checkNotNull(stateRecord, "null cannot be cast to non-null type androidx.compose.foundation.text.input.internal.TextFieldLayoutStateCache.CacheRecord");
            CacheRecord cacheRecord = (CacheRecord) stateRecord;
            this.f10617c = cacheRecord.f10617c;
            this.f10618d = cacheRecord.f10618d;
            this.f10619e = cacheRecord.f10619e;
            this.f10620f = cacheRecord.f10620f;
            this.f10621g = cacheRecord.f10621g;
            this.f10622h = cacheRecord.f10622h;
            this.f10623i = cacheRecord.f10623i;
            this.f10624j = cacheRecord.f10624j;
            this.f10625k = cacheRecord.f10625k;
            this.f10626l = cacheRecord.f10626l;
            this.f10627m = cacheRecord.f10627m;
            this.f10628n = cacheRecord.f10628n;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public StateRecord d() {
            return new CacheRecord();
        }

        public final List j() {
            return this.f10618d;
        }

        public final TextRange k() {
            return this.f10619e;
        }

        public final long l() {
            return this.f10627m;
        }

        public final float m() {
            return this.f10623i;
        }

        public final FontFamily.Resolver n() {
            return this.f10626l;
        }

        public final float o() {
            return this.f10624j;
        }

        public final LayoutDirection p() {
            return this.f10625k;
        }

        public final TextLayoutResult q() {
            return this.f10628n;
        }

        public final boolean r() {
            return this.f10621g;
        }

        public final boolean s() {
            return this.f10622h;
        }

        public final TextStyle t() {
            return this.f10620f;
        }

        public String toString() {
            return "CacheRecord(visualText=" + ((Object) this.f10617c) + ", composingAnnotations=" + this.f10618d + ", composition=" + this.f10619e + ", textStyle=" + this.f10620f + ", singleLine=" + this.f10621g + ", softWrap=" + this.f10622h + ", densityValue=" + this.f10623i + ", fontScale=" + this.f10624j + ", layoutDirection=" + this.f10625k + ", fontFamilyResolver=" + this.f10626l + ", constraints=" + ((Object) Constraints.q(this.f10627m)) + ", layoutResult=" + this.f10628n + ')';
        }

        public final CharSequence u() {
            return this.f10617c;
        }

        public final void v(List list) {
            this.f10618d = list;
        }

        public final void w(TextRange textRange) {
            this.f10619e = textRange;
        }

        public final void x(long j3) {
            this.f10627m = j3;
        }

        public final void y(float f3) {
            this.f10623i = f3;
        }

        public final void z(FontFamily.Resolver resolver) {
            this.f10626l = resolver;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class MeasureInputs {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final Companion f10629g = new Companion(null);

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final SnapshotMutationPolicy f10630h = new SnapshotMutationPolicy<MeasureInputs>() { // from class: androidx.compose.foundation.text.input.internal.TextFieldLayoutStateCache$MeasureInputs$Companion$mutationPolicy$1
            @Override // androidx.compose.runtime.SnapshotMutationPolicy
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public boolean b(TextFieldLayoutStateCache.MeasureInputs measureInputs, TextFieldLayoutStateCache.MeasureInputs measureInputs2) {
                if (measureInputs == null || measureInputs2 == null) {
                    return !((measureInputs == null) ^ (measureInputs2 == null));
                }
                return measureInputs.d() == measureInputs2.d() && measureInputs.f() == measureInputs2.f() && measureInputs.g() == measureInputs2.g() && Intrinsics.areEqual(measureInputs.e(), measureInputs2.e()) && Constraints.f(measureInputs.b(), measureInputs2.b());
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Density f10631a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final LayoutDirection f10632b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final FontFamily.Resolver f10633c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final long f10634d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final float f10635e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final float f10636f;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final SnapshotMutationPolicy a() {
                return MeasureInputs.f10630h;
            }

            private Companion() {
            }
        }

        public /* synthetic */ MeasureInputs(Density density, LayoutDirection layoutDirection, FontFamily.Resolver resolver, long j3, DefaultConstructorMarker defaultConstructorMarker) {
            this(density, layoutDirection, resolver, j3);
        }

        public final long b() {
            return this.f10634d;
        }

        public final Density c() {
            return this.f10631a;
        }

        public final float d() {
            return this.f10635e;
        }

        public final FontFamily.Resolver e() {
            return this.f10633c;
        }

        public final float f() {
            return this.f10636f;
        }

        public final LayoutDirection g() {
            return this.f10632b;
        }

        public String toString() {
            return "MeasureInputs(density=" + this.f10631a + ", densityValue=" + this.f10635e + ", fontScale=" + this.f10636f + ", layoutDirection=" + this.f10632b + ", fontFamilyResolver=" + this.f10633c + ", constraints=" + ((Object) Constraints.q(this.f10634d)) + ')';
        }

        private MeasureInputs(Density density, LayoutDirection layoutDirection, FontFamily.Resolver resolver, long j3) {
            this.f10631a = density;
            this.f10632b = layoutDirection;
            this.f10633c = resolver;
            this.f10634d = j3;
            this.f10635e = density.getDensity();
            this.f10636f = density.K1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class NonMeasureInputs {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final Companion f10637f = new Companion(null);

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final SnapshotMutationPolicy f10638g = new SnapshotMutationPolicy<NonMeasureInputs>() { // from class: androidx.compose.foundation.text.input.internal.TextFieldLayoutStateCache$NonMeasureInputs$Companion$mutationPolicy$1
            @Override // androidx.compose.runtime.SnapshotMutationPolicy
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public boolean b(TextFieldLayoutStateCache.NonMeasureInputs nonMeasureInputs, TextFieldLayoutStateCache.NonMeasureInputs nonMeasureInputs2) {
                if (nonMeasureInputs == null || nonMeasureInputs2 == null) {
                    return !((nonMeasureInputs == null) ^ (nonMeasureInputs2 == null));
                }
                return nonMeasureInputs.d() == nonMeasureInputs2.d() && Intrinsics.areEqual(nonMeasureInputs.e(), nonMeasureInputs2.e()) && nonMeasureInputs.b() == nonMeasureInputs2.b() && nonMeasureInputs.c() == nonMeasureInputs2.c() && nonMeasureInputs.f() == nonMeasureInputs2.f();
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final TransformedTextFieldState f10639a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final TextStyle f10640b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f10641c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f10642d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final boolean f10643e;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final SnapshotMutationPolicy a() {
                return NonMeasureInputs.f10638g;
            }

            private Companion() {
            }
        }

        public NonMeasureInputs(TransformedTextFieldState transformedTextFieldState, TextStyle textStyle, boolean z2, boolean z3, boolean z4) {
            this.f10639a = transformedTextFieldState;
            this.f10640b = textStyle;
            this.f10641c = z2;
            this.f10642d = z3;
            this.f10643e = z4;
        }

        public final boolean b() {
            return this.f10641c;
        }

        public final boolean c() {
            return this.f10642d;
        }

        public final TransformedTextFieldState d() {
            return this.f10639a;
        }

        public final TextStyle e() {
            return this.f10640b;
        }

        public final boolean f() {
            return this.f10643e;
        }

        public String toString() {
            return "NonMeasureInputs(textFieldState=" + this.f10639a + ", textStyle=" + this.f10640b + ", singleLine=" + this.f10641c + ", softWrap=" + this.f10642d + ", isKeyboardTypePhone=" + this.f10643e + ')';
        }
    }

    private final void A(NonMeasureInputs nonMeasureInputs) {
        this.f10613a.setValue(nonMeasureInputs);
    }

    private final TextLayoutResult b(TextFieldCharSequence textFieldCharSequence, NonMeasureInputs nonMeasureInputs, MeasureInputs measureInputs) {
        TextStyle textStyleE;
        Locale localeA;
        TextMeasurer textMeasurerY = y(measureInputs);
        if (nonMeasureInputs.f()) {
            LocaleList localeListW = nonMeasureInputs.e().w();
            if (localeListW == null || (localeA = localeListW.d(0)) == null) {
                localeA = Locale.f29469b.a();
            }
            textStyleE = nonMeasureInputs.e().L(new TextStyle(0L, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, TextFieldLayoutStateCache_androidKt.a(localeA.b()), 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16711679, (DefaultConstructorMarker) null));
        } else {
            textStyleE = nonMeasureInputs.e();
        }
        String string = textFieldCharSequence.toString();
        List listC = textFieldCharSequence.c();
        if (listC == null) {
            listC = CollectionsKt.emptyList();
        }
        return TextMeasurer.d(textMeasurerY, new AnnotatedString(string, listC), textStyleE, 0, nonMeasureInputs.c(), nonMeasureInputs.b() ? 1 : Api.BaseClientBuilder.API_PRIORITY_OTHER, null, measureInputs.b(), measureInputs.g(), measureInputs.c(), measureInputs.e(), false, 1060, null);
    }

    private final MeasureInputs i() {
        return (MeasureInputs) this.f10614b.getValue();
    }

    private final NonMeasureInputs r() {
        return (NonMeasureInputs) this.f10613a.getValue();
    }

    private final TextLayoutResult v(NonMeasureInputs nonMeasureInputs, MeasureInputs measureInputs) {
        CharSequence charSequenceU;
        TextFieldCharSequence textFieldCharSequenceO = nonMeasureInputs.d().o();
        CacheRecord cacheRecord = (CacheRecord) SnapshotKt.G(this.f10616d);
        TextLayoutResult textLayoutResultQ = cacheRecord.q();
        if (textLayoutResultQ != null && (charSequenceU = cacheRecord.u()) != null && StringsKt.A(charSequenceU, textFieldCharSequenceO) && Intrinsics.areEqual(cacheRecord.j(), textFieldCharSequenceO.c()) && Intrinsics.areEqual(cacheRecord.k(), textFieldCharSequenceO.d()) && cacheRecord.r() == nonMeasureInputs.b() && cacheRecord.s() == nonMeasureInputs.c() && cacheRecord.p() == measureInputs.g() && cacheRecord.m() == measureInputs.c().getDensity() && cacheRecord.o() == measureInputs.c().K1() && Constraints.f(cacheRecord.l(), measureInputs.b()) && Intrinsics.areEqual(cacheRecord.n(), measureInputs.e()) && !textLayoutResultQ.w().j().a()) {
            TextStyle textStyleT = cacheRecord.t();
            boolean zI = textStyleT != null ? textStyleT.I(nonMeasureInputs.e()) : false;
            TextStyle textStyleT2 = cacheRecord.t();
            boolean zH = textStyleT2 != null ? textStyleT2.H(nonMeasureInputs.e()) : false;
            if (zI && zH) {
                return textLayoutResultQ;
            }
            if (zI) {
                return TextLayoutResult.b(textLayoutResultQ, new TextLayoutInput(textLayoutResultQ.l().j(), nonMeasureInputs.e(), textLayoutResultQ.l().g(), textLayoutResultQ.l().e(), textLayoutResultQ.l().h(), textLayoutResultQ.l().f(), textLayoutResultQ.l().b(), textLayoutResultQ.l().d(), textLayoutResultQ.l().c(), textLayoutResultQ.l().a(), (DefaultConstructorMarker) null), 0L, 2, null);
            }
        }
        TextLayoutResult textLayoutResultB = b(textFieldCharSequenceO, nonMeasureInputs, measureInputs);
        if (!Intrinsics.areEqual(textLayoutResultB, textLayoutResultQ)) {
            Snapshot snapshotC = Snapshot.f24914e.c();
            if (!snapshotC.h()) {
                CacheRecord cacheRecord2 = this.f10616d;
                synchronized (SnapshotKt.J()) {
                    CacheRecord cacheRecord3 = (CacheRecord) SnapshotKt.h0(cacheRecord2, this, snapshotC);
                    cacheRecord3.G(textFieldCharSequenceO);
                    cacheRecord3.v(textFieldCharSequenceO.c());
                    cacheRecord3.w(textFieldCharSequenceO.d());
                    cacheRecord3.D(nonMeasureInputs.b());
                    cacheRecord3.E(nonMeasureInputs.c());
                    cacheRecord3.F(nonMeasureInputs.e());
                    cacheRecord3.B(measureInputs.g());
                    cacheRecord3.y(measureInputs.d());
                    cacheRecord3.A(measureInputs.f());
                    cacheRecord3.x(measureInputs.b());
                    cacheRecord3.z(measureInputs.e());
                    cacheRecord3.C(textLayoutResultB);
                    Unit unit = Unit.f139807a;
                }
                SnapshotKt.Q(snapshotC, this);
                return textLayoutResultB;
            }
        }
        return textLayoutResultB;
    }

    private final TextMeasurer y(MeasureInputs measureInputs) {
        TextMeasurer textMeasurer = this.f10615c;
        if (textMeasurer != null) {
            return textMeasurer;
        }
        TextMeasurer textMeasurer2 = new TextMeasurer(measureInputs.e(), measureInputs.c(), measureInputs.g(), 1);
        this.f10615c = textMeasurer2;
        return textMeasurer2;
    }

    private final void z(MeasureInputs measureInputs) {
        this.f10614b.setValue(measureInputs);
    }

    public final void B(TransformedTextFieldState transformedTextFieldState, TextStyle textStyle, boolean z2, boolean z3, KeyboardOptions keyboardOptions) {
        A(new NonMeasureInputs(transformedTextFieldState, textStyle, z2, z3, KeyboardType.n(keyboardOptions.j(), KeyboardType.f29379b.g())));
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public void n(StateRecord stateRecord) {
        Intrinsics.checkNotNull(stateRecord, "null cannot be cast to non-null type androidx.compose.foundation.text.input.internal.TextFieldLayoutStateCache.CacheRecord");
        this.f10616d = (CacheRecord) stateRecord;
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public StateRecord p() {
        return this.f10616d;
    }

    @Override // androidx.compose.runtime.State
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public TextLayoutResult getValue() {
        MeasureInputs measureInputsI;
        NonMeasureInputs nonMeasureInputsR = r();
        if (nonMeasureInputsR == null || (measureInputsI = i()) == null) {
            return null;
        }
        return v(nonMeasureInputsR, measureInputsI);
    }

    public final TextLayoutResult x(Density density, LayoutDirection layoutDirection, FontFamily.Resolver resolver, long j3) {
        MeasureInputs measureInputs = new MeasureInputs(density, layoutDirection, resolver, j3, null);
        z(measureInputs);
        NonMeasureInputs nonMeasureInputsR = r();
        if (nonMeasureInputsR != null) {
            return v(nonMeasureInputsR, measureInputs);
        }
        InlineClassHelperKt.d("Called layoutWithNewMeasureInputs before updateNonMeasureInputs");
        throw new KotlinNothingValueException();
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public StateRecord q(StateRecord stateRecord, StateRecord stateRecord2, StateRecord stateRecord3) {
        return stateRecord3;
    }
}
