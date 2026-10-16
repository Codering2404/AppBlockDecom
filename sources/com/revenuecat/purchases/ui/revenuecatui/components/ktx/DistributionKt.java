package com.revenuecat.purchases.ui.revenuecatui.components.ktx;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.ui.Alignment;
import com.revenuecat.purchases.paywalls.components.properties.FlexDistribution;
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
public final /* synthetic */ class DistributionKt {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FlexDistribution.values().length];
            try {
                iArr[FlexDistribution.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FlexDistribution.END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FlexDistribution.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[FlexDistribution.SPACE_BETWEEN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[FlexDistribution.SPACE_AROUND.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[FlexDistribution.SPACE_EVENLY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: toHorizontalArrangement-3ABfNKs, reason: not valid java name */
    public static final /* synthetic */ Arrangement.Horizontal m724toHorizontalArrangement3ABfNKs(FlexDistribution toHorizontalArrangement, float f3) {
        Intrinsics.checkNotNullParameter(toHorizontalArrangement, "$this$toHorizontalArrangement");
        switch (WhenMappings.$EnumSwitchMapping$0[toHorizontalArrangement.ordinal()]) {
            case 1:
                return Arrangement.f6574a.p(f3, Alignment.f25072a.k());
            case 2:
                return Arrangement.f6574a.p(f3, Alignment.f25072a.j());
            case 3:
                return Arrangement.f6574a.p(f3, Alignment.f25072a.g());
            case 4:
            case 5:
            case 6:
                return Arrangement.f6574a.g();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: renamed from: toVerticalArrangement-3ABfNKs, reason: not valid java name */
    public static final /* synthetic */ Arrangement.Vertical m725toVerticalArrangement3ABfNKs(FlexDistribution toVerticalArrangement, float f3) {
        Intrinsics.checkNotNullParameter(toVerticalArrangement, "$this$toVerticalArrangement");
        switch (WhenMappings.$EnumSwitchMapping$0[toVerticalArrangement.ordinal()]) {
            case 1:
                return Arrangement.f6574a.q(f3, Alignment.f25072a.l());
            case 2:
                return Arrangement.f6574a.q(f3, Alignment.f25072a.a());
            case 3:
                return Arrangement.f6574a.q(f3, Alignment.f25072a.i());
            case 4:
            case 5:
            case 6:
                return Arrangement.f6574a.h();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
