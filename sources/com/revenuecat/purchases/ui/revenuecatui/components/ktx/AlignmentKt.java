package com.revenuecat.purchases.ui.revenuecatui.components.ktx;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.text.style.TextAlign;
import com.revenuecat.purchases.paywalls.components.properties.HorizontalAlignment;
import com.revenuecat.purchases.paywalls.components.properties.TwoDimensionalAlignment;
import com.revenuecat.purchases.paywalls.components.properties.VerticalAlignment;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final /* synthetic */ class AlignmentKt {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[HorizontalAlignment.values().length];
            try {
                iArr[HorizontalAlignment.LEADING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[HorizontalAlignment.CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[HorizontalAlignment.TRAILING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[VerticalAlignment.values().length];
            try {
                iArr2[VerticalAlignment.TOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[VerticalAlignment.CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[VerticalAlignment.BOTTOM.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[TwoDimensionalAlignment.values().length];
            try {
                iArr3[TwoDimensionalAlignment.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr3[TwoDimensionalAlignment.LEADING.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr3[TwoDimensionalAlignment.TRAILING.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr3[TwoDimensionalAlignment.TOP.ordinal()] = 4;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr3[TwoDimensionalAlignment.BOTTOM.ordinal()] = 5;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr3[TwoDimensionalAlignment.TOP_LEADING.ordinal()] = 6;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr3[TwoDimensionalAlignment.TOP_TRAILING.ordinal()] = 7;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr3[TwoDimensionalAlignment.BOTTOM_LEADING.ordinal()] = 8;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr3[TwoDimensionalAlignment.BOTTOM_TRAILING.ordinal()] = 9;
            } catch (NoSuchFieldError unused15) {
            }
            $EnumSwitchMapping$2 = iArr3;
        }
    }

    public static final /* synthetic */ Alignment.Horizontal toAlignment(HorizontalAlignment horizontalAlignment) {
        Intrinsics.checkNotNullParameter(horizontalAlignment, "<this>");
        int i3 = WhenMappings.$EnumSwitchMapping$0[horizontalAlignment.ordinal()];
        if (i3 == 1) {
            return Alignment.f25072a.k();
        }
        if (i3 == 2) {
            return Alignment.f25072a.g();
        }
        if (i3 == 3) {
            return Alignment.f25072a.j();
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final /* synthetic */ Alignment.Horizontal toHorizontalAlignmentOrNull(TwoDimensionalAlignment twoDimensionalAlignment) {
        Intrinsics.checkNotNullParameter(twoDimensionalAlignment, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$2[twoDimensionalAlignment.ordinal()]) {
            case 1:
                return Alignment.f25072a.g();
            case 2:
                return Alignment.f25072a.k();
            case 3:
                return Alignment.f25072a.j();
            case 4:
            case 5:
                return null;
            case 6:
                return Alignment.f25072a.k();
            case 7:
                return Alignment.f25072a.j();
            case 8:
                return Alignment.f25072a.k();
            case 9:
                return Alignment.f25072a.j();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final /* synthetic */ int toTextAlign(HorizontalAlignment horizontalAlignment) {
        Intrinsics.checkNotNullParameter(horizontalAlignment, "<this>");
        int i3 = WhenMappings.$EnumSwitchMapping$0[horizontalAlignment.ordinal()];
        if (i3 == 1) {
            return TextAlign.f29616b.f();
        }
        if (i3 == 2) {
            return TextAlign.f29616b.a();
        }
        if (i3 == 3) {
            return TextAlign.f29616b.b();
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final /* synthetic */ Alignment.Vertical toVerticalAlignmentOrNull(TwoDimensionalAlignment twoDimensionalAlignment) {
        Intrinsics.checkNotNullParameter(twoDimensionalAlignment, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$2[twoDimensionalAlignment.ordinal()]) {
            case 1:
                return Alignment.f25072a.i();
            case 2:
            case 3:
                return null;
            case 4:
                return Alignment.f25072a.l();
            case 5:
                return Alignment.f25072a.a();
            case 6:
                return Alignment.f25072a.l();
            case 7:
                return Alignment.f25072a.l();
            case 8:
                return Alignment.f25072a.a();
            case 9:
                return Alignment.f25072a.a();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final /* synthetic */ Alignment.Vertical toAlignment(VerticalAlignment verticalAlignment) {
        Intrinsics.checkNotNullParameter(verticalAlignment, "<this>");
        int i3 = WhenMappings.$EnumSwitchMapping$1[verticalAlignment.ordinal()];
        if (i3 == 1) {
            return Alignment.f25072a.l();
        }
        if (i3 == 2) {
            return Alignment.f25072a.i();
        }
        if (i3 == 3) {
            return Alignment.f25072a.a();
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final /* synthetic */ Alignment toAlignment(TwoDimensionalAlignment twoDimensionalAlignment) {
        Intrinsics.checkNotNullParameter(twoDimensionalAlignment, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$2[twoDimensionalAlignment.ordinal()]) {
            case 1:
                return Alignment.f25072a.e();
            case 2:
                return Alignment.f25072a.h();
            case 3:
                return Alignment.f25072a.f();
            case 4:
                return Alignment.f25072a.m();
            case 5:
                return Alignment.f25072a.b();
            case 6:
                return Alignment.f25072a.o();
            case 7:
                return Alignment.f25072a.n();
            case 8:
                return Alignment.f25072a.d();
            case 9:
                return Alignment.f25072a.c();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
