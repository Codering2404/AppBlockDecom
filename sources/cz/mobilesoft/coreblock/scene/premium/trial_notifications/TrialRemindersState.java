package cz.mobilesoft.coreblock.scene.premium.trial_notifications;

import cz.mobilesoft.coreblock.base.ViewState;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class TrialRemindersState implements ViewState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f113898a;

    public TrialRemindersState(boolean z2) {
        this.f113898a = z2;
    }

    public final TrialRemindersState a(boolean z2) {
        return new TrialRemindersState(z2);
    }

    public final boolean b() {
        return this.f113898a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof TrialRemindersState) && this.f113898a == ((TrialRemindersState) obj).f113898a;
    }

    public int hashCode() {
        return Boolean.hashCode(this.f113898a);
    }

    public String toString() {
        return "TrialRemindersState(isOfferTrialEndCalendarShown=" + this.f113898a + ")";
    }

    public /* synthetic */ TrialRemindersState(boolean z2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z2);
    }
}
