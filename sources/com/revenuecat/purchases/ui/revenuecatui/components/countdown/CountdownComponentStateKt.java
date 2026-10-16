package com.revenuecat.purchases.ui.revenuecatui.components.countdown;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.LocalLifecycleOwnerKt;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

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
public final /* synthetic */ class CountdownComponentStateKt {
    private static final int MILLIS_IN_SECOND = 1000;
    private static final int SECONDS_IN_DAY = 86400;
    private static final int SECONDS_IN_HOUR = 3600;
    private static final int SECONDS_IN_MINUTE = 60;

    public static final CountdownState rememberCountdownState(Date targetDate, Composer composer, int i3) {
        Date date;
        Intrinsics.checkNotNullParameter(targetDate, "targetDate");
        composer.a0(280932820);
        if (ComposerKt.M()) {
            ComposerKt.U(280932820, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.countdown.rememberCountdownState (CountdownComponentState.kt:57)");
        }
        composer.a0(-392681169);
        boolean Z = composer.Z(targetDate);
        Object objG = composer.G();
        if (Z || objG == Composer.f23746a.a()) {
            objG = Long.valueOf(targetDate.getTime() - new Date().getTime());
            composer.w(objG);
        }
        long jLongValue = ((Number) objG).longValue();
        composer.U();
        composer.a0(-392678500);
        boolean Z2 = composer.Z(targetDate);
        Object objG2 = composer.G();
        if (Z2 || objG2 == Composer.f23746a.a()) {
            objG2 = SnapshotStateKt__SnapshotStateKt.e(jLongValue <= 0 ? CountdownTime.Companion.getZERO() : CountdownTime.Companion.fromInterval(jLongValue), null, 2, null);
            composer.w(objG2);
        }
        MutableState mutableState = (MutableState) objG2;
        composer.U();
        composer.a0(-392672454);
        Object objG3 = composer.G();
        Composer.Companion companion = Composer.f23746a;
        if (objG3 == companion.a()) {
            objG3 = SnapshotStateKt__SnapshotStateKt.e(Boolean.TRUE, null, 2, null);
            composer.w(objG3);
        }
        MutableState mutableState2 = (MutableState) objG3;
        composer.U();
        LifecycleOwner lifecycleOwner = (LifecycleOwner) composer.q(LocalLifecycleOwnerKt.c());
        composer.a0(-392667923);
        boolean zI = composer.I(lifecycleOwner) | composer.I(targetDate) | composer.Z(mutableState);
        Object objG4 = composer.G();
        if (zI || objG4 == companion.a()) {
            date = targetDate;
            Object countdownComponentStateKt$rememberCountdownState$1$1 = new CountdownComponentStateKt$rememberCountdownState$1$1(date, lifecycleOwner, mutableState2, mutableState, null);
            composer.w(countdownComponentStateKt$rememberCountdownState$1$1);
            objG4 = countdownComponentStateKt$rememberCountdownState$1$1;
        } else {
            date = targetDate;
        }
        composer.U();
        EffectsKt.g(date, (Function2) objG4, composer, i3 & 14);
        CountdownState countdownState = new CountdownState(rememberCountdownState$lambda$2(mutableState), Intrinsics.areEqual(rememberCountdownState$lambda$2(mutableState), CountdownTime.Companion.getZERO()));
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return countdownState;
    }

    private static final CountdownTime rememberCountdownState$lambda$2(MutableState<CountdownTime> mutableState) {
        return (CountdownTime) mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean rememberCountdownState$lambda$5(MutableState<Boolean> mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void rememberCountdownState$lambda$6(MutableState<Boolean> mutableState, boolean z2) {
        mutableState.setValue(Boolean.valueOf(z2));
    }
}
