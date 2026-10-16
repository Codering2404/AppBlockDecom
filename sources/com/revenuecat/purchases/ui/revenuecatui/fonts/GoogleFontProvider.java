package com.revenuecat.purchases.ui.revenuecatui.fonts;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.compose.ui.text.googlefonts.GoogleFont;
import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class GoogleFontProvider implements Parcelable {
    public static final int $stable = 0;
    public static final Parcelable.Creator<GoogleFontProvider> CREATOR = new Creator();
    private final int certificates;
    private final String providerAuthority;
    private final String providerPackage;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Creator implements Parcelable.Creator<GoogleFontProvider> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final GoogleFontProvider createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new GoogleFontProvider(parcel.readInt(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final GoogleFontProvider[] newArray(int i3) {
            return new GoogleFontProvider[i3];
        }
    }

    public GoogleFontProvider(int i3, String providerAuthority, String providerPackage) {
        Intrinsics.checkNotNullParameter(providerAuthority, "providerAuthority");
        Intrinsics.checkNotNullParameter(providerPackage, "providerPackage");
        this.certificates = i3;
        this.providerAuthority = providerAuthority;
        this.providerPackage = providerPackage;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GoogleFontProvider)) {
            return false;
        }
        GoogleFontProvider googleFontProvider = (GoogleFontProvider) obj;
        return this.certificates == googleFontProvider.certificates && Intrinsics.areEqual(this.providerAuthority, googleFontProvider.providerAuthority) && Intrinsics.areEqual(this.providerPackage, googleFontProvider.providerPackage);
    }

    public final int getCertificates() {
        return this.certificates;
    }

    public final String getProviderAuthority() {
        return this.providerAuthority;
    }

    public final String getProviderPackage() {
        return this.providerPackage;
    }

    public int hashCode() {
        return (((this.certificates * 31) + this.providerAuthority.hashCode()) * 31) + this.providerPackage.hashCode();
    }

    public final GoogleFont.Provider toGoogleProvider() {
        return new GoogleFont.Provider(this.providerAuthority, this.providerPackage, this.certificates);
    }

    public String toString() {
        return "GoogleFontProvider(certificates=" + this.certificates + ", providerAuthority=" + this.providerAuthority + ", providerPackage=" + this.providerPackage + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i3) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeInt(this.certificates);
        out.writeString(this.providerAuthority);
        out.writeString(this.providerPackage);
    }

    public /* synthetic */ GoogleFontProvider(int i3, String str, String str2, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, (i4 & 2) != 0 ? "com.google.android.gms.fonts" : str, (i4 & 4) != 0 ? "com.google.android.gms" : str2);
    }
}
