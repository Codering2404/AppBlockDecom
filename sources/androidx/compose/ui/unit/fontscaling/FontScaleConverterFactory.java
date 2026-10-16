package androidx.compose.ui.unit.fontscaling;

import androidx.collection.SparseArrayCompat;
import androidx.compose.ui.unit.InlineClassHelperKt;
import kotlin.Metadata;
import kotlin.Unit;

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
public final class FontScaleConverterFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final FontScaleConverterFactory f30018a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final float[] f30019b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile SparseArrayCompat f30020c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Object[] f30021d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f30022e;

    static {
        FontScaleConverterFactory fontScaleConverterFactory = new FontScaleConverterFactory();
        f30018a = fontScaleConverterFactory;
        f30019b = new float[]{8.0f, 10.0f, 12.0f, 14.0f, 18.0f, 20.0f, 24.0f, 30.0f, 100.0f};
        f30020c = new SparseArrayCompat(0, 1, null);
        Object[] objArr = new Object[0];
        f30021d = objArr;
        synchronized (objArr) {
            fontScaleConverterFactory.h(f30020c, 1.15f, new FontScaleConverterTable(new float[]{8.0f, 10.0f, 12.0f, 14.0f, 18.0f, 20.0f, 24.0f, 30.0f, 100.0f}, new float[]{9.2f, 11.5f, 13.8f, 16.4f, 19.8f, 21.8f, 25.2f, 30.0f, 100.0f}));
            fontScaleConverterFactory.h(f30020c, 1.3f, new FontScaleConverterTable(new float[]{8.0f, 10.0f, 12.0f, 14.0f, 18.0f, 20.0f, 24.0f, 30.0f, 100.0f}, new float[]{10.4f, 13.0f, 15.6f, 18.8f, 21.6f, 23.6f, 26.4f, 30.0f, 100.0f}));
            fontScaleConverterFactory.h(f30020c, 1.5f, new FontScaleConverterTable(new float[]{8.0f, 10.0f, 12.0f, 14.0f, 18.0f, 20.0f, 24.0f, 30.0f, 100.0f}, new float[]{12.0f, 15.0f, 18.0f, 22.0f, 24.0f, 26.0f, 28.0f, 30.0f, 100.0f}));
            fontScaleConverterFactory.h(f30020c, 1.8f, new FontScaleConverterTable(new float[]{8.0f, 10.0f, 12.0f, 14.0f, 18.0f, 20.0f, 24.0f, 30.0f, 100.0f}, new float[]{14.4f, 18.0f, 21.6f, 24.4f, 27.6f, 30.8f, 32.8f, 34.8f, 100.0f}));
            fontScaleConverterFactory.h(f30020c, 2.0f, new FontScaleConverterTable(new float[]{8.0f, 10.0f, 12.0f, 14.0f, 18.0f, 20.0f, 24.0f, 30.0f, 100.0f}, new float[]{16.0f, 20.0f, 24.0f, 26.0f, 30.0f, 34.0f, 36.0f, 38.0f, 100.0f}));
            Unit unit = Unit.f139807a;
        }
        if (!(fontScaleConverterFactory.e(f30020c.k(0)) - 0.01f > 1.03f)) {
            InlineClassHelperKt.b("You should only apply non-linear scaling to font scales > 1");
        }
        f30022e = 8;
    }

    private FontScaleConverterFactory() {
    }

    private final FontScaleConverter a(FontScaleConverter fontScaleConverter, FontScaleConverter fontScaleConverter2, float f3) {
        float[] fArr = f30019b;
        float[] fArr2 = new float[fArr.length];
        int length = fArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            float f4 = f30019b[i3];
            fArr2[i3] = MathUtils.f30027a.b(fontScaleConverter.b(f4), fontScaleConverter2.b(f4), f3);
        }
        return new FontScaleConverterTable(f30019b, fArr2);
    }

    private final FontScaleConverter c(float f3) {
        return (FontScaleConverter) f30020c.g(d(f3));
    }

    private final int d(float f3) {
        return (int) (f3 * 100.0f);
    }

    private final float e(int i3) {
        return i3 / 100.0f;
    }

    private final void g(float f3, FontScaleConverter fontScaleConverter) {
        synchronized (f30021d) {
            SparseArrayCompat sparseArrayCompatClone = f30020c.clone();
            f30018a.h(sparseArrayCompatClone, f3, fontScaleConverter);
            f30020c = sparseArrayCompatClone;
            Unit unit = Unit.f139807a;
        }
    }

    private final void h(SparseArrayCompat sparseArrayCompat, float f3, FontScaleConverter fontScaleConverter) {
        sparseArrayCompat.m(d(f3), fontScaleConverter);
    }

    public final FontScaleConverter b(float f3) {
        FontScaleConverter fontScaleConverterTable;
        if (!f(f3)) {
            return null;
        }
        FontScaleConverter fontScaleConverterC = f30018a.c(f3);
        if (fontScaleConverterC != null) {
            return fontScaleConverterC;
        }
        int i3 = f30020c.i(d(f3));
        if (i3 >= 0) {
            return (FontScaleConverter) f30020c.r(i3);
        }
        int i4 = -(i3 + 1);
        int i5 = i4 - 1;
        float fE = 1.0f;
        if (i4 >= f30020c.q()) {
            FontScaleConverterTable fontScaleConverterTable2 = new FontScaleConverterTable(new float[]{1.0f}, new float[]{f3});
            g(f3, fontScaleConverterTable2);
            return fontScaleConverterTable2;
        }
        if (i5 < 0) {
            float[] fArr = f30019b;
            fontScaleConverterTable = new FontScaleConverterTable(fArr, fArr);
        } else {
            fE = e(f30020c.k(i5));
            fontScaleConverterTable = (FontScaleConverter) f30020c.r(i5);
        }
        FontScaleConverter fontScaleConverterA = a(fontScaleConverterTable, (FontScaleConverter) f30020c.r(i4), MathUtils.f30027a.a(0.0f, 1.0f, fE, e(f30020c.k(i4)), f3));
        g(f3, fontScaleConverterA);
        return fontScaleConverterA;
    }

    public final boolean f(float f3) {
        return f3 >= 1.03f;
    }
}
