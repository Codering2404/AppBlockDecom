package com.revenuecat.purchases;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class DangerousSettings implements Parcelable {
    private final boolean autoSyncPurchases;
    private final boolean customEntitlementComputation;
    private final boolean uiPreviewMode;
    public static final Companion Companion = new Companion(null);
    public static final Parcelable.Creator<DangerousSettings> CREATOR = new Creator();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final DangerousSettings forPreviewMode() {
            return new DangerousSettings(false, false, true);
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Creator implements Parcelable.Creator<DangerousSettings> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DangerousSettings createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new DangerousSettings(parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() != 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DangerousSettings[] newArray(int i3) {
            return new DangerousSettings[i3];
        }
    }

    public DangerousSettings() {
        this(false, false, false, 7, null);
    }

    @JvmStatic
    public static final DangerousSettings forPreviewMode() {
        return Companion.forPreviewMode();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DangerousSettings)) {
            return false;
        }
        DangerousSettings dangerousSettings = (DangerousSettings) obj;
        return this.autoSyncPurchases == dangerousSettings.autoSyncPurchases && this.customEntitlementComputation == dangerousSettings.customEntitlementComputation && this.uiPreviewMode == dangerousSettings.uiPreviewMode;
    }

    public final boolean getAutoSyncPurchases() {
        return this.autoSyncPurchases;
    }

    public final boolean getCustomEntitlementComputation$purchases_defaultsBc8Release() {
        return this.customEntitlementComputation;
    }

    public final boolean getUiPreviewMode$purchases_defaultsBc8Release() {
        return this.uiPreviewMode;
    }

    public int hashCode() {
        return (((Boolean.hashCode(this.autoSyncPurchases) * 31) + Boolean.hashCode(this.customEntitlementComputation)) * 31) + Boolean.hashCode(this.uiPreviewMode);
    }

    public String toString() {
        return "DangerousSettings(autoSyncPurchases=" + this.autoSyncPurchases + ", customEntitlementComputation=" + this.customEntitlementComputation + ", uiPreviewMode=" + this.uiPreviewMode + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i3) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeInt(this.autoSyncPurchases ? 1 : 0);
        out.writeInt(this.customEntitlementComputation ? 1 : 0);
        out.writeInt(this.uiPreviewMode ? 1 : 0);
    }

    public DangerousSettings(boolean z2, boolean z3, boolean z4) {
        this.autoSyncPurchases = z2;
        this.customEntitlementComputation = z3;
        this.uiPreviewMode = z4;
    }

    public /* synthetic */ DangerousSettings(boolean z2, boolean z3, boolean z4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? true : z2, (i3 & 2) != 0 ? false : z3, (i3 & 4) != 0 ? false : z4);
    }

    public DangerousSettings(boolean z2) {
        this(z2, false, false);
    }

    public /* synthetic */ DangerousSettings(boolean z2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? true : z2);
    }
}
