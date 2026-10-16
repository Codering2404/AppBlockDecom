package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.relocation.BringIntoViewRequester;
import androidx.compose.foundation.relocation.BringIntoViewRequesterKt;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

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
public final class TextLayoutState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private TextFieldLayoutStateCache f10654a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Function2 f10655b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final TextFieldLayoutStateCache f10656c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final MutableState f10657d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final MutableState f10658e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final MutableState f10659f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final MutableState f10660g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final BringIntoViewRequester f10661h;

    public TextLayoutState() {
        TextFieldLayoutStateCache textFieldLayoutStateCache = new TextFieldLayoutStateCache();
        this.f10654a = textFieldLayoutStateCache;
        this.f10656c = textFieldLayoutStateCache;
        this.f10657d = SnapshotStateKt.i(null, SnapshotStateKt.k());
        this.f10658e = SnapshotStateKt.i(null, SnapshotStateKt.k());
        this.f10659f = SnapshotStateKt.i(null, SnapshotStateKt.k());
        this.f10660g = SnapshotStateKt__SnapshotStateKt.e(Dp.d(Dp.g(0)), null, 2, null);
        this.f10661h = BringIntoViewRequesterKt.a();
    }

    public static /* synthetic */ int i(TextLayoutState textLayoutState, long j3, boolean z2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z2 = true;
        }
        return textLayoutState.h(j3, z2);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long b(long r6) {
        /*
            r5 = this;
            androidx.compose.ui.layout.LayoutCoordinates r0 = r5.j()
            if (r0 == 0) goto L22
            boolean r1 = r0.m()
            if (r1 == 0) goto L1a
            androidx.compose.ui.layout.LayoutCoordinates r1 = r5.e()
            r2 = 0
            if (r1 == 0) goto L20
            r3 = 0
            r4 = 2
            androidx.compose.ui.geometry.Rect r2 = androidx.compose.ui.layout.LayoutCoordinates.R(r1, r0, r3, r4, r2)
            goto L20
        L1a:
            androidx.compose.ui.geometry.Rect$Companion r0 = androidx.compose.ui.geometry.Rect.f25601e
            androidx.compose.ui.geometry.Rect r2 = r0.a()
        L20:
            if (r2 != 0) goto L28
        L22:
            androidx.compose.ui.geometry.Rect$Companion r0 = androidx.compose.ui.geometry.Rect.f25601e
            androidx.compose.ui.geometry.Rect r2 = r0.a()
        L28:
            long r6 = androidx.compose.foundation.text.input.internal.TextLayoutStateKt.a(r6, r2)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.TextLayoutState.b(long):long");
    }

    public final BringIntoViewRequester c() {
        return this.f10661h;
    }

    public final LayoutCoordinates d() {
        return (LayoutCoordinates) this.f10658e.getValue();
    }

    public final LayoutCoordinates e() {
        return (LayoutCoordinates) this.f10659f.getValue();
    }

    public final TextLayoutResult f() {
        return (TextLayoutResult) this.f10656c.getValue();
    }

    public final float g() {
        return ((Dp) this.f10660g.getValue()).l();
    }

    public final int h(long j3, boolean z2) {
        TextLayoutResult textLayoutResultF = f();
        if (textLayoutResultF == null) {
            return -1;
        }
        if (z2) {
            j3 = b(j3);
        }
        return textLayoutResultF.x(TextLayoutStateKt.b(this, j3));
    }

    public final LayoutCoordinates j() {
        return (LayoutCoordinates) this.f10657d.getValue();
    }

    public final boolean k(long j3) {
        TextLayoutResult textLayoutResultF = f();
        if (textLayoutResultF == null) {
            return false;
        }
        long jB = TextLayoutStateKt.b(this, b(j3));
        int iR = textLayoutResultF.r(Float.intBitsToFloat((int) (4294967295L & jB)));
        int i3 = (int) (jB >> 32);
        return Float.intBitsToFloat(i3) >= textLayoutResultF.s(iR) && Float.intBitsToFloat(i3) <= textLayoutResultF.t(iR);
    }

    public final TextLayoutResult l(Density density, LayoutDirection layoutDirection, FontFamily.Resolver resolver, long j3) {
        TextLayoutResult textLayoutResultX = this.f10654a.x(density, layoutDirection, resolver, j3);
        Function2 function2 = this.f10655b;
        if (function2 != null) {
            function2.invoke(density, new Function0<TextLayoutResult>() { // from class: androidx.compose.foundation.text.input.internal.TextLayoutState$layoutWithNewMeasureInputs$1$textLayoutProvider$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public final TextLayoutResult invoke() {
                    return this.f10662a.f10654a.getValue();
                }
            });
        }
        return textLayoutResultX;
    }

    public final void m(LayoutCoordinates layoutCoordinates) {
        this.f10658e.setValue(layoutCoordinates);
    }

    public final void n(LayoutCoordinates layoutCoordinates) {
        this.f10659f.setValue(layoutCoordinates);
    }

    public final void o(float f3) {
        this.f10660g.setValue(Dp.d(f3));
    }

    public final void p(Function2 function2) {
        this.f10655b = function2;
    }

    public final void q(LayoutCoordinates layoutCoordinates) {
        this.f10657d.setValue(layoutCoordinates);
    }

    public final void r(TransformedTextFieldState transformedTextFieldState, TextStyle textStyle, boolean z2, boolean z3, KeyboardOptions keyboardOptions) {
        this.f10654a.B(transformedTextFieldState, textStyle, z2, z3, keyboardOptions);
    }
}
