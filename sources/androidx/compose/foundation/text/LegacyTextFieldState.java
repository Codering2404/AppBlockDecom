package androidx.compose.foundation.text;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.input.EditProcessor;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TextInputSession;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class LegacyTextFieldState {
    private final MutableState A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private TextDelegate f9774a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final RecomposeScope f9775b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final SoftwareKeyboardController f9776c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final EditProcessor f9777d = new EditProcessor();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private TextInputSession f9778e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final MutableState f9779f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final MutableState f9780g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private LayoutCoordinates f9781h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final MutableState f9782i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private AnnotatedString f9783j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final MutableState f9784k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final MutableState f9785l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final MutableState f9786m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final MutableState f9787n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final MutableState f9788o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f9789p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final MutableState f9790q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final KeyboardActionRunner f9791r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final MutableState f9792s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final MutableState f9793t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private Function1 f9794u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final Function1 f9795v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final Function1 f9796w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final Paint f9797x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private long f9798y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final MutableState f9799z;

    public LegacyTextFieldState(TextDelegate textDelegate, RecomposeScope recomposeScope, SoftwareKeyboardController softwareKeyboardController) {
        this.f9774a = textDelegate;
        this.f9775b = recomposeScope;
        this.f9776c = softwareKeyboardController;
        Boolean bool = Boolean.FALSE;
        this.f9779f = SnapshotStateKt__SnapshotStateKt.e(bool, null, 2, null);
        this.f9780g = SnapshotStateKt__SnapshotStateKt.e(Dp.d(Dp.g(0)), null, 2, null);
        this.f9782i = SnapshotStateKt__SnapshotStateKt.e(null, null, 2, null);
        this.f9784k = SnapshotStateKt__SnapshotStateKt.e(HandleState.f9702a, null, 2, null);
        this.f9785l = SnapshotStateKt__SnapshotStateKt.e(bool, null, 2, null);
        this.f9786m = SnapshotStateKt__SnapshotStateKt.e(bool, null, 2, null);
        this.f9787n = SnapshotStateKt__SnapshotStateKt.e(bool, null, 2, null);
        this.f9788o = SnapshotStateKt__SnapshotStateKt.e(bool, null, 2, null);
        this.f9789p = true;
        this.f9790q = SnapshotStateKt__SnapshotStateKt.e(Boolean.TRUE, null, 2, null);
        this.f9791r = new KeyboardActionRunner(softwareKeyboardController);
        this.f9792s = SnapshotStateKt__SnapshotStateKt.e(bool, null, 2, null);
        this.f9793t = SnapshotStateKt__SnapshotStateKt.e(bool, null, 2, null);
        this.f9794u = new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text.LegacyTextFieldState$onValueChangeOriginal$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c((TextFieldValue) obj);
                return Unit.f139807a;
            }

            public final void c(TextFieldValue textFieldValue) {
            }
        };
        this.f9795v = new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text.LegacyTextFieldState$onValueChange$1
            {
                super(1);
            }

            public final void c(TextFieldValue textFieldValue) {
                String strI = textFieldValue.i();
                AnnotatedString annotatedStringY = this.f9801a.y();
                if (!Intrinsics.areEqual(strI, annotatedStringY != null ? annotatedStringY.k() : null)) {
                    this.f9801a.E(HandleState.f9702a);
                    if (this.f9801a.i()) {
                        this.f9801a.I(false);
                    } else {
                        this.f9801a.C(false);
                    }
                }
                LegacyTextFieldState legacyTextFieldState = this.f9801a;
                TextRange.Companion companion = TextRange.f28921b;
                legacyTextFieldState.M(companion.a());
                this.f9801a.D(companion.a());
                this.f9801a.f9794u.invoke(textFieldValue);
                this.f9801a.q().invalidate();
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c((TextFieldValue) obj);
                return Unit.f139807a;
            }
        };
        this.f9796w = new Function1<ImeAction, Unit>() { // from class: androidx.compose.foundation.text.LegacyTextFieldState$onImeActionPerformed$1
            {
                super(1);
            }

            public final void c(int i3) {
                this.f9800a.f9791r.d(i3);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c(((ImeAction) obj).p());
                return Unit.f139807a;
            }
        };
        this.f9797x = AndroidPaint_androidKt.a();
        this.f9798y = Color.f25715b.k();
        TextRange.Companion companion = TextRange.f28921b;
        this.f9799z = SnapshotStateKt__SnapshotStateKt.e(TextRange.b(companion.a()), null, 2, null);
        this.A = SnapshotStateKt__SnapshotStateKt.e(TextRange.b(companion.a()), null, 2, null);
    }

    public final boolean A() {
        return ((Boolean) this.f9790q.getValue()).booleanValue();
    }

    public final boolean B() {
        return this.f9789p;
    }

    public final void C(boolean z2) {
        this.f9792s.setValue(Boolean.valueOf(z2));
    }

    public final void D(long j3) {
        this.A.setValue(TextRange.b(j3));
    }

    public final void E(HandleState handleState) {
        this.f9784k.setValue(handleState);
    }

    public final void F(boolean z2) {
        this.f9779f.setValue(Boolean.valueOf(z2));
    }

    public final void G(boolean z2) {
        this.f9790q.setValue(Boolean.valueOf(z2));
    }

    public final void H(TextInputSession textInputSession) {
        this.f9778e = textInputSession;
    }

    public final void I(boolean z2) {
        this.f9793t.setValue(Boolean.valueOf(z2));
    }

    public final void J(LayoutCoordinates layoutCoordinates) {
        this.f9781h = layoutCoordinates;
    }

    public final void K(TextLayoutResultProxy textLayoutResultProxy) {
        this.f9782i.setValue(textLayoutResultProxy);
        this.f9789p = false;
    }

    public final void L(float f3) {
        this.f9780g.setValue(Dp.d(f3));
    }

    public final void M(long j3) {
        this.f9799z.setValue(TextRange.b(j3));
    }

    public final void N(boolean z2) {
        this.f9788o.setValue(Boolean.valueOf(z2));
    }

    public final void O(boolean z2) {
        this.f9785l.setValue(Boolean.valueOf(z2));
    }

    public final void P(boolean z2) {
        this.f9787n.setValue(Boolean.valueOf(z2));
    }

    public final void Q(boolean z2) {
        this.f9786m.setValue(Boolean.valueOf(z2));
    }

    public final void R(AnnotatedString annotatedString, AnnotatedString annotatedString2, TextStyle textStyle, boolean z2, Density density, FontFamily.Resolver resolver, Function1 function1, KeyboardActions keyboardActions, FocusManager focusManager, long j3) {
        this.f9794u = function1;
        this.f9798y = j3;
        KeyboardActionRunner keyboardActionRunner = this.f9791r;
        keyboardActionRunner.f(keyboardActions);
        keyboardActionRunner.e(focusManager);
        this.f9783j = annotatedString;
        TextDelegate textDelegateC = TextDelegateKt.c(this.f9774a, annotatedString2, textStyle, density, resolver, z2, 0, 0, 0, CollectionsKt.emptyList(), 448, null);
        if (this.f9774a != textDelegateC) {
            this.f9789p = true;
        }
        this.f9774a = textDelegateC;
    }

    public final boolean c() {
        return ((Boolean) this.f9792s.getValue()).booleanValue();
    }

    public final long d() {
        return ((TextRange) this.A.getValue()).r();
    }

    public final HandleState e() {
        return (HandleState) this.f9784k.getValue();
    }

    public final boolean f() {
        return ((Boolean) this.f9779f.getValue()).booleanValue();
    }

    public final Paint g() {
        return this.f9797x;
    }

    public final TextInputSession h() {
        return this.f9778e;
    }

    public final boolean i() {
        return ((Boolean) this.f9793t.getValue()).booleanValue();
    }

    public final SoftwareKeyboardController j() {
        return this.f9776c;
    }

    public final LayoutCoordinates k() {
        LayoutCoordinates layoutCoordinates = this.f9781h;
        if (layoutCoordinates == null || !layoutCoordinates.m()) {
            return null;
        }
        return layoutCoordinates;
    }

    public final TextLayoutResultProxy l() {
        return (TextLayoutResultProxy) this.f9782i.getValue();
    }

    public final float m() {
        return ((Dp) this.f9780g.getValue()).l();
    }

    public final Function1 n() {
        return this.f9796w;
    }

    public final Function1 o() {
        return this.f9795v;
    }

    public final EditProcessor p() {
        return this.f9777d;
    }

    public final RecomposeScope q() {
        return this.f9775b;
    }

    public final long r() {
        return this.f9798y;
    }

    public final long s() {
        return ((TextRange) this.f9799z.getValue()).r();
    }

    public final boolean t() {
        return ((Boolean) this.f9788o.getValue()).booleanValue();
    }

    public final boolean u() {
        return ((Boolean) this.f9785l.getValue()).booleanValue();
    }

    public final boolean v() {
        return ((Boolean) this.f9787n.getValue()).booleanValue();
    }

    public final boolean w() {
        return ((Boolean) this.f9786m.getValue()).booleanValue();
    }

    public final TextDelegate x() {
        return this.f9774a;
    }

    public final AnnotatedString y() {
        return this.f9783j;
    }

    public final boolean z() {
        return (TextRange.h(s()) && TextRange.h(d())) ? false : true;
    }
}
