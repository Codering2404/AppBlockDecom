package androidx.compose.material3;

import androidx.compose.material3.tokens.TypographyKeyTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.text.TextStyle;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;

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
public final class TypographyKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ProvidableCompositionLocal f21581a = CompositionLocalKt.g(new Function0<Typography>() { // from class: androidx.compose.material3.TypographyKt$LocalTypography$1
        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Typography invoke() {
            return new Typography(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 32767, null);
        }
    });

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f21583a;

        static {
            int[] iArr = new int[TypographyKeyTokens.values().length];
            try {
                iArr[TypographyKeyTokens.DisplayLarge.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TypographyKeyTokens.DisplayMedium.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TypographyKeyTokens.DisplaySmall.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[TypographyKeyTokens.HeadlineLarge.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[TypographyKeyTokens.HeadlineMedium.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[TypographyKeyTokens.HeadlineSmall.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[TypographyKeyTokens.TitleLarge.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[TypographyKeyTokens.TitleMedium.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[TypographyKeyTokens.TitleSmall.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[TypographyKeyTokens.BodyLarge.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[TypographyKeyTokens.BodyMedium.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[TypographyKeyTokens.BodySmall.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[TypographyKeyTokens.LabelLarge.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[TypographyKeyTokens.LabelMedium.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[TypographyKeyTokens.LabelSmall.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            f21583a = iArr;
        }
    }

    private static final TextStyle a(Typography typography, TypographyKeyTokens typographyKeyTokens) {
        switch (WhenMappings.f21583a[typographyKeyTokens.ordinal()]) {
            case 1:
                return typography.e();
            case 2:
                return typography.f();
            case 3:
                return typography.g();
            case 4:
                return typography.h();
            case 5:
                return typography.i();
            case 6:
                return typography.j();
            case 7:
                return typography.n();
            case 8:
                return typography.o();
            case 9:
                return typography.p();
            case 10:
                return typography.b();
            case 11:
                return typography.c();
            case 12:
                return typography.d();
            case 13:
                return typography.k();
            case 14:
                return typography.l();
            case 15:
                return typography.m();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final ProvidableCompositionLocal b() {
        return f21581a;
    }

    public static final TextStyle c(TypographyKeyTokens typographyKeyTokens, Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-1049072145, i3, -1, "androidx.compose.material3.<get-value> (Typography.kt:209)");
        }
        TextStyle textStyleA = a(MaterialTheme.f18110a.c(composer, 6), typographyKeyTokens);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return textStyleA;
    }
}
