package androidx.compose.ui.platform;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRect;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathOperation;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class ShapeContainingUtilKt {
    private static final boolean a(RoundRect roundRect) {
        return Float.intBitsToFloat((int) (roundRect.h() >> 32)) + Float.intBitsToFloat((int) (roundRect.i() >> 32)) <= roundRect.j() && Float.intBitsToFloat((int) (roundRect.b() >> 32)) + Float.intBitsToFloat((int) (roundRect.c() >> 32)) <= roundRect.j() && Float.intBitsToFloat((int) (roundRect.h() & 4294967295L)) + Float.intBitsToFloat((int) (roundRect.b() & 4294967295L)) <= roundRect.d() && Float.intBitsToFloat((int) (roundRect.i() & 4294967295L)) + Float.intBitsToFloat((int) (roundRect.c() & 4294967295L)) <= roundRect.d();
    }

    public static final boolean b(Outline outline, float f3, float f4, Path path, Path path2) {
        if (outline instanceof Outline.Rectangle) {
            return e(((Outline.Rectangle) outline).b(), f3, f4);
        }
        if (outline instanceof Outline.Rounded) {
            return f((Outline.Rounded) outline, f3, f4, path, path2);
        }
        if (outline instanceof Outline.Generic) {
            return d(((Outline.Generic) outline).b(), f3, f4, path, path2);
        }
        throw new NoWhenBranchMatchedException();
    }

    public static /* synthetic */ boolean c(Outline outline, float f3, float f4, Path path, Path path2, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            path = null;
        }
        if ((i3 & 16) != 0) {
            path2 = null;
        }
        return b(outline, f3, f4, path, path2);
    }

    private static final boolean d(Path path, float f3, float f4, Path path2, Path path3) {
        Rect rect = new Rect(f3 - 0.005f, f4 - 0.005f, f3 + 0.005f, f4 + 0.005f);
        if (path2 == null) {
            path2 = AndroidPath_androidKt.a();
        }
        Path.d(path2, rect, null, 2, null);
        if (path3 == null) {
            path3 = AndroidPath_androidKt.a();
        }
        path3.v(path, path2, PathOperation.f25845b.b());
        boolean zIsEmpty = path3.isEmpty();
        path3.reset();
        path2.reset();
        return !zIsEmpty;
    }

    private static final boolean e(Rect rect, float f3, float f4) {
        return rect.o() <= f3 && f3 < rect.p() && rect.r() <= f4 && f4 < rect.i();
    }

    private static final boolean f(Outline.Rounded rounded, float f3, float f4, Path path, Path path2) {
        RoundRect roundRectB = rounded.b();
        if (f3 < roundRectB.e() || f3 >= roundRectB.f() || f4 < roundRectB.g() || f4 >= roundRectB.a()) {
            return false;
        }
        if (!a(roundRectB)) {
            Path pathA = path2 == null ? AndroidPath_androidKt.a() : path2;
            Path.s(pathA, roundRectB, null, 2, null);
            return d(pathA, f3, f4, path, path2);
        }
        float fE = roundRectB.e() + Float.intBitsToFloat((int) (roundRectB.h() >> 32));
        float fG = roundRectB.g() + Float.intBitsToFloat((int) (roundRectB.h() & 4294967295L));
        float f5 = roundRectB.f() - Float.intBitsToFloat((int) (roundRectB.i() >> 32));
        float fG2 = roundRectB.g() + Float.intBitsToFloat((int) (roundRectB.i() & 4294967295L));
        float f6 = roundRectB.f() - Float.intBitsToFloat((int) (roundRectB.c() >> 32));
        float fA = roundRectB.a() - Float.intBitsToFloat((int) (roundRectB.c() & 4294967295L));
        float fA2 = roundRectB.a() - Float.intBitsToFloat((int) (4294967295L & roundRectB.b()));
        float fE2 = roundRectB.e() + Float.intBitsToFloat((int) (roundRectB.b() >> 32));
        if (f3 < fE && f4 < fG) {
            return g(f3, f4, roundRectB.h(), fE, fG);
        }
        if (f3 < fE2 && f4 > fA2) {
            return g(f3, f4, roundRectB.b(), fE2, fA2);
        }
        if (f3 > f5 && f4 < fG2) {
            return g(f3, f4, roundRectB.i(), f5, fG2);
        }
        if (f3 <= f6 || f4 <= fA) {
            return true;
        }
        return g(f3, f4, roundRectB.c(), f6, fA);
    }

    private static final boolean g(float f3, float f4, long j3, float f5, float f6) {
        float f7 = f3 - f5;
        float f8 = f4 - f6;
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j3 >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j3 & 4294967295L));
        return ((f7 * f7) / (fIntBitsToFloat * fIntBitsToFloat)) + ((f8 * f8) / (fIntBitsToFloat2 * fIntBitsToFloat2)) <= 1.0f;
    }
}
