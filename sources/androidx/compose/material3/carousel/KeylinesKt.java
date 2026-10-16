package androidx.compose.material3.carousel;

import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.RangesKt;

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
public final class KeylinesKt {
    private static final float a(float f3, float f4, float f5) {
        float fMax = Math.max(1.5f * f5, f3);
        float f6 = f4 * 0.85f;
        return fMax > f6 ? Math.max(f6, f5 * 1.2f) : fMax;
    }

    public static final KeylineList b(float f3, float f4, final float f5, final float f6, final Arrangement arrangement) {
        return KeylineListKt.c(f3, f4, CarouselAlignment.f21611b.c(), new Function1<KeylineListScope, Unit>() { // from class: androidx.compose.material3.carousel.KeylinesKt$createLeftAlignedKeylineList$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void c(KeylineListScope keylineListScope) {
                keylineListScope.b(f5, true);
                int iC = arrangement.c();
                Arrangement arrangement2 = arrangement;
                for (int i3 = 0; i3 < iC; i3++) {
                    KeylineListScope.a(keylineListScope, arrangement2.d(), false, 2, null);
                }
                int iE = arrangement.e();
                Arrangement arrangement3 = arrangement;
                for (int i4 = 0; i4 < iE; i4++) {
                    KeylineListScope.a(keylineListScope, arrangement3.f(), false, 2, null);
                }
                int iG = arrangement.g();
                Arrangement arrangement4 = arrangement;
                for (int i5 = 0; i5 < iG; i5++) {
                    KeylineListScope.a(keylineListScope, arrangement4.h(), false, 2, null);
                }
                keylineListScope.b(f6, true);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c((KeylineListScope) obj);
                return Unit.f139807a;
            }
        });
    }

    public static final KeylineList c(Density density, float f3, float f4, float f5, int i3, float f6, float f7) {
        float f8;
        if (f3 == 0.0f || f4 == 0.0f) {
            return KeylineListKt.a();
        }
        int[] iArr = {1};
        int[] iArr2 = {1, 0};
        float fMin = Math.min(f4, f3);
        float fO = RangesKt.o(fMin / 3.0f, f6, f7);
        float f9 = (fMin + fO) / 2.0f;
        if (f3 < 2 * f6) {
            iArr = new int[]{0};
        }
        int[] iArr3 = iArr;
        int iCeil = (int) Math.ceil(f3 / fMin);
        int iMax = (iCeil - Math.max(1, (int) Math.floor(((f3 - (ArraysKt.maxOrThrow(iArr2) * f9)) - (ArraysKt.maxOrThrow(iArr3) * f7)) / fMin))) + 1;
        int[] iArr4 = new int[iMax];
        for (int i4 = 0; i4 < iMax; i4++) {
            iArr4[i4] = iCeil - i4;
        }
        float fM1 = density.M1(CarouselDefaults.f21616a.a());
        Arrangement arrangementB = Arrangement.f21603h.b(f3, f5, fO, f6, f7, iArr3, f9, iArr2, fMin, iArr4);
        if (arrangementB == null || arrangementB.j() <= i3) {
            f8 = f3;
        } else {
            int iG = arrangementB.g();
            int iE = arrangementB.e();
            for (int iJ = arrangementB.j() - i3; iJ > 0; iJ--) {
                if (iG > 0) {
                    iG--;
                } else if (iE > 1) {
                    iE--;
                }
            }
            f8 = f3;
            arrangementB = Arrangement.f21603h.b(f8, f5, fO, f6, f7, new int[]{iG}, f9, new int[]{iE}, fMin, iArr4);
        }
        return arrangementB == null ? KeylineListKt.a() : b(f8, f5, fM1, fM1, arrangementB);
    }

    public static final KeylineList d(Density density, float f3, float f4, float f5) {
        if (f3 == 0.0f || f4 == 0.0f) {
            return KeylineListKt.a();
        }
        float fMin = Math.min(f4 + f5, f3);
        int iMax = Math.max(1, (int) Math.floor(f3 / fMin));
        float f6 = f3 - (iMax * fMin);
        int i3 = f6 <= 0.0f ? 0 : 1;
        float fM1 = density.M1(CarouselDefaults.f21616a.a());
        float fA = a(fM1, fMin, f6);
        return b(f3, f5, Math.max(Math.min(fM1, f4), fA * 0.5f), fM1, new Arrangement(0, 0.0f, 0, fA, i3, fMin, iMax));
    }
}
