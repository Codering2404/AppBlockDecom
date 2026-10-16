package com.revenuecat.purchases.ui.revenuecatui.components.countdown;

import kotlin.Metadata;
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
public final class CountdownState {
    public static final int $stable = 0;
    private final CountdownTime countdownTime;
    private final boolean hasEnded;

    public CountdownState(CountdownTime countdownTime, boolean z2) {
        Intrinsics.checkNotNullParameter(countdownTime, "countdownTime");
        this.countdownTime = countdownTime;
        this.hasEnded = z2;
    }

    public static /* synthetic */ CountdownState copy$default(CountdownState countdownState, CountdownTime countdownTime, boolean z2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            countdownTime = countdownState.countdownTime;
        }
        if ((i3 & 2) != 0) {
            z2 = countdownState.hasEnded;
        }
        return countdownState.copy(countdownTime, z2);
    }

    public final CountdownTime component1() {
        return this.countdownTime;
    }

    public final boolean component2() {
        return this.hasEnded;
    }

    public final CountdownState copy(CountdownTime countdownTime, boolean z2) {
        Intrinsics.checkNotNullParameter(countdownTime, "countdownTime");
        return new CountdownState(countdownTime, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CountdownState)) {
            return false;
        }
        CountdownState countdownState = (CountdownState) obj;
        return Intrinsics.areEqual(this.countdownTime, countdownState.countdownTime) && this.hasEnded == countdownState.hasEnded;
    }

    public final CountdownTime getCountdownTime() {
        return this.countdownTime;
    }

    public final boolean getHasEnded() {
        return this.hasEnded;
    }

    public int hashCode() {
        return (this.countdownTime.hashCode() * 31) + Boolean.hashCode(this.hasEnded);
    }

    public String toString() {
        return "CountdownState(countdownTime=" + this.countdownTime + ", hasEnded=" + this.hasEnded + ')';
    }
}
