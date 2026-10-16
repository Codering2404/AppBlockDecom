package com.superwall.sdk.web;

import com.superwall.sdk.models.internal.RedemptionResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.Duration;
import org.threeten.bp.Instant;
import org.threeten.bp.OffsetDateTime;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class WebTrialReminderKt {
    public static final Long webTrialReminderDelay(RedemptionResult.PaywallInfo.PaywallProduct product, long j3, long j4) {
        Intrinsics.checkNotNullParameter(product, "product");
        if (product.getTrialPeriodDays() > 0 && j3 > 0) {
            try {
                Instant instantD = OffsetDateTime.y(product.getTrialPeriodEndDate()).D();
                Instant instantH = instantD.w(Duration.m(product.getTrialPeriodDays())).H(j3);
                Instant instantA = Instant.A(j4);
                if (instantH.compareTo(instantA) > 0 && instantH.compareTo(instantD) < 0) {
                    return Long.valueOf(Duration.c(instantA, instantH).y());
                }
            } catch (ArithmeticException | DateTimeException unused) {
            }
        }
        return null;
    }
}
