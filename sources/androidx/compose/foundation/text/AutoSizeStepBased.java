package androidx.compose.foundation.text;

import androidx.compose.foundation.text.modifiers.TextAutoSizeLayoutScope;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.TextUnit;
import kotlin.Metadata;

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
final class AutoSizeStepBased implements TextAutoSize {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f9054a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f9055b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f9056c;

    private final boolean b(TextLayoutResult textLayoutResult) {
        int iF = textLayoutResult.l().f();
        TextOverflow.Companion companion = TextOverflow.f29661b;
        if (TextOverflow.h(iF, companion.a()) ? true : TextOverflow.h(iF, companion.e())) {
            return c(textLayoutResult);
        }
        if (TextOverflow.h(iF, companion.d()) ? true : TextOverflow.h(iF, companion.c()) ? true : TextOverflow.h(iF, companion.b())) {
            return d(textLayoutResult);
        }
        throw new IllegalArgumentException("TextOverflow type " + ((Object) TextOverflow.j(textLayoutResult.l().f())) + " is not supported.");
    }

    private final boolean c(TextLayoutResult textLayoutResult) {
        return textLayoutResult.g() || textLayoutResult.f();
    }

    private final boolean d(TextLayoutResult textLayoutResult) {
        int iN = textLayoutResult.n();
        if (iN == 0) {
            return false;
        }
        if (iN == 1) {
            return textLayoutResult.D(0);
        }
        int iF = textLayoutResult.l().f();
        TextOverflow.Companion companion = TextOverflow.f29661b;
        if (TextOverflow.h(iF, companion.d()) ? true : TextOverflow.h(iF, companion.c())) {
            return c(textLayoutResult);
        }
        if (TextOverflow.h(iF, companion.b())) {
            return textLayoutResult.D(textLayoutResult.n() - 1);
        }
        return false;
    }

    @Override // androidx.compose.foundation.text.TextAutoSize
    public long a(TextAutoSizeLayoutScope textAutoSizeLayoutScope, long j3, AnnotatedString annotatedString) {
        float fJ0 = textAutoSizeLayoutScope.J0(this.f9056c);
        float fJ02 = textAutoSizeLayoutScope.J0(this.f9054a);
        float fJ03 = textAutoSizeLayoutScope.J0(this.f9055b);
        float f3 = 2;
        float f4 = (fJ02 + fJ03) / f3;
        float f5 = fJ02;
        float f6 = fJ03;
        while (f6 - f5 >= fJ0) {
            if (b(textAutoSizeLayoutScope.t0(j3, annotatedString, textAutoSizeLayoutScope.v(f4)))) {
                f6 = f4;
            } else {
                f5 = f4;
            }
            f4 = (f5 + f6) / f3;
        }
        float fFloor = fJ02 + (((float) Math.floor((f5 - fJ02) / fJ0)) * fJ0);
        float f7 = fJ0 + fFloor;
        if (f7 <= fJ03 && !b(textAutoSizeLayoutScope.t0(j3, annotatedString, textAutoSizeLayoutScope.v(f7)))) {
            fFloor = f7;
        }
        return textAutoSizeLayoutScope.v(fFloor);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof AutoSizeStepBased)) {
            return false;
        }
        AutoSizeStepBased autoSizeStepBased = (AutoSizeStepBased) obj;
        return TextUnit.e(autoSizeStepBased.f9054a, this.f9054a) && TextUnit.e(autoSizeStepBased.f9055b, this.f9055b) && TextUnit.e(autoSizeStepBased.f9056c, this.f9056c);
    }

    @Override // androidx.compose.foundation.text.TextAutoSize
    public int hashCode() {
        return (((TextUnit.i(this.f9054a) * 31) + TextUnit.i(this.f9055b)) * 31) + TextUnit.i(this.f9056c);
    }
}
