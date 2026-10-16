package androidx.compose.ui.graphics;

import android.graphics.PorterDuff;
import androidx.compose.ui.graphics.BlendMode;
import kotlin.Metadata;

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
public final class AndroidBlendMode_androidKt {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f25621a;

        static {
            int[] iArr = new int[android.graphics.BlendMode.values().length];
            try {
                iArr[android.graphics.BlendMode.CLEAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[android.graphics.BlendMode.SRC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[android.graphics.BlendMode.DST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[android.graphics.BlendMode.SRC_OVER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[android.graphics.BlendMode.DST_OVER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[android.graphics.BlendMode.SRC_IN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[android.graphics.BlendMode.DST_IN.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[android.graphics.BlendMode.SRC_OUT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[android.graphics.BlendMode.DST_OUT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[android.graphics.BlendMode.SRC_ATOP.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[android.graphics.BlendMode.DST_ATOP.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[android.graphics.BlendMode.XOR.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[android.graphics.BlendMode.PLUS.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[android.graphics.BlendMode.MODULATE.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[android.graphics.BlendMode.SCREEN.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr[android.graphics.BlendMode.OVERLAY.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr[android.graphics.BlendMode.DARKEN.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr[android.graphics.BlendMode.LIGHTEN.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr[android.graphics.BlendMode.COLOR_DODGE.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr[android.graphics.BlendMode.COLOR_BURN.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr[android.graphics.BlendMode.HARD_LIGHT.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                iArr[android.graphics.BlendMode.SOFT_LIGHT.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                iArr[android.graphics.BlendMode.DIFFERENCE.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                iArr[android.graphics.BlendMode.EXCLUSION.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                iArr[android.graphics.BlendMode.MULTIPLY.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                iArr[android.graphics.BlendMode.HUE.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                iArr[android.graphics.BlendMode.SATURATION.ordinal()] = 27;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                iArr[android.graphics.BlendMode.COLOR.ordinal()] = 28;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                iArr[android.graphics.BlendMode.LUMINOSITY.ordinal()] = 29;
            } catch (NoSuchFieldError unused29) {
            }
            f25621a = iArr;
        }
    }

    public static final android.graphics.BlendMode a(int i3) {
        BlendMode.Companion companion = BlendMode.f25667b;
        return BlendMode.F(i3, companion.a()) ? android.graphics.BlendMode.CLEAR : BlendMode.F(i3, companion.x()) ? android.graphics.BlendMode.SRC : BlendMode.F(i3, companion.g()) ? android.graphics.BlendMode.DST : BlendMode.F(i3, companion.B()) ? android.graphics.BlendMode.SRC_OVER : BlendMode.F(i3, companion.k()) ? android.graphics.BlendMode.DST_OVER : BlendMode.F(i3, companion.z()) ? android.graphics.BlendMode.SRC_IN : BlendMode.F(i3, companion.i()) ? android.graphics.BlendMode.DST_IN : BlendMode.F(i3, companion.A()) ? android.graphics.BlendMode.SRC_OUT : BlendMode.F(i3, companion.j()) ? android.graphics.BlendMode.DST_OUT : BlendMode.F(i3, companion.y()) ? android.graphics.BlendMode.SRC_ATOP : BlendMode.F(i3, companion.h()) ? android.graphics.BlendMode.DST_ATOP : BlendMode.F(i3, companion.C()) ? android.graphics.BlendMode.XOR : BlendMode.F(i3, companion.t()) ? android.graphics.BlendMode.PLUS : BlendMode.F(i3, companion.q()) ? android.graphics.BlendMode.MODULATE : BlendMode.F(i3, companion.v()) ? android.graphics.BlendMode.SCREEN : BlendMode.F(i3, companion.s()) ? android.graphics.BlendMode.OVERLAY : BlendMode.F(i3, companion.e()) ? android.graphics.BlendMode.DARKEN : BlendMode.F(i3, companion.o()) ? android.graphics.BlendMode.LIGHTEN : BlendMode.F(i3, companion.d()) ? android.graphics.BlendMode.COLOR_DODGE : BlendMode.F(i3, companion.c()) ? android.graphics.BlendMode.COLOR_BURN : BlendMode.F(i3, companion.m()) ? android.graphics.BlendMode.HARD_LIGHT : BlendMode.F(i3, companion.w()) ? android.graphics.BlendMode.SOFT_LIGHT : BlendMode.F(i3, companion.f()) ? android.graphics.BlendMode.DIFFERENCE : BlendMode.F(i3, companion.l()) ? android.graphics.BlendMode.EXCLUSION : BlendMode.F(i3, companion.r()) ? android.graphics.BlendMode.MULTIPLY : BlendMode.F(i3, companion.n()) ? android.graphics.BlendMode.HUE : BlendMode.F(i3, companion.u()) ? android.graphics.BlendMode.SATURATION : BlendMode.F(i3, companion.b()) ? android.graphics.BlendMode.COLOR : BlendMode.F(i3, companion.p()) ? android.graphics.BlendMode.LUMINOSITY : android.graphics.BlendMode.SRC_OVER;
    }

    public static final PorterDuff.Mode b(int i3) {
        BlendMode.Companion companion = BlendMode.f25667b;
        return BlendMode.F(i3, companion.a()) ? PorterDuff.Mode.CLEAR : BlendMode.F(i3, companion.x()) ? PorterDuff.Mode.SRC : BlendMode.F(i3, companion.g()) ? PorterDuff.Mode.DST : BlendMode.F(i3, companion.B()) ? PorterDuff.Mode.SRC_OVER : BlendMode.F(i3, companion.k()) ? PorterDuff.Mode.DST_OVER : BlendMode.F(i3, companion.z()) ? PorterDuff.Mode.SRC_IN : BlendMode.F(i3, companion.i()) ? PorterDuff.Mode.DST_IN : BlendMode.F(i3, companion.A()) ? PorterDuff.Mode.SRC_OUT : BlendMode.F(i3, companion.j()) ? PorterDuff.Mode.DST_OUT : BlendMode.F(i3, companion.y()) ? PorterDuff.Mode.SRC_ATOP : BlendMode.F(i3, companion.h()) ? PorterDuff.Mode.DST_ATOP : BlendMode.F(i3, companion.C()) ? PorterDuff.Mode.XOR : BlendMode.F(i3, companion.t()) ? PorterDuff.Mode.ADD : BlendMode.F(i3, companion.v()) ? PorterDuff.Mode.SCREEN : BlendMode.F(i3, companion.s()) ? PorterDuff.Mode.OVERLAY : BlendMode.F(i3, companion.e()) ? PorterDuff.Mode.DARKEN : BlendMode.F(i3, companion.o()) ? PorterDuff.Mode.LIGHTEN : BlendMode.F(i3, companion.q()) ? PorterDuff.Mode.MULTIPLY : PorterDuff.Mode.SRC_OVER;
    }
}
