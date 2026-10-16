package com.revenuecat.purchases.ui.revenuecatui.fonts;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
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
public abstract class PaywallFont implements Parcelable {
    public static final int $stable = 0;

    public /* synthetic */ PaywallFont(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private PaywallFont() {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class AssetFont extends PaywallFont {
        public static final int $stable = 0;
        public static final Parcelable.Creator<AssetFont> CREATOR = new Creator();
        private final int fontStyle;
        private final FontWeight fontWeight;
        private final String path;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Creator implements Parcelable.Creator<AssetFont> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final AssetFont createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new AssetFont(parcel.readString(), FontWeightParceler.INSTANCE.m1162create(parcel), parcel.readInt());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final AssetFont[] newArray(int i3) {
                return new AssetFont[i3];
            }
        }

        public /* synthetic */ AssetFont(String str, FontWeight fontWeight, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i4 & 2) != 0 ? FontWeight.f29233b.g() : fontWeight, (i4 & 4) != 0 ? FontStyle.f29211b.b() : i3);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AssetFont)) {
                return false;
            }
            AssetFont assetFont = (AssetFont) obj;
            return Intrinsics.areEqual(this.path, assetFont.path) && Intrinsics.areEqual(this.fontWeight, assetFont.fontWeight) && this.fontStyle == assetFont.fontStyle;
        }

        public final int getFontStyle() {
            return this.fontStyle;
        }

        public final FontWeight getFontWeight() {
            return this.fontWeight;
        }

        public final String getPath() {
            return this.path;
        }

        public int hashCode() {
            return (((this.path.hashCode() * 31) + this.fontWeight.hashCode()) * 31) + this.fontStyle;
        }

        public String toString() {
            return "AssetFont(path=" + this.path + ", fontWeight=" + this.fontWeight + ", fontStyle=" + this.fontStyle + ')';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int i3) {
            Intrinsics.checkNotNullParameter(out, "out");
            out.writeString(this.path);
            FontWeightParceler.INSTANCE.write(this.fontWeight, out, i3);
            out.writeInt(this.fontStyle);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AssetFont(String path, FontWeight fontWeight, int i3) {
            super(null);
            Intrinsics.checkNotNullParameter(path, "path");
            Intrinsics.checkNotNullParameter(fontWeight, "fontWeight");
            this.path = path;
            this.fontWeight = fontWeight;
            this.fontStyle = i3;
        }

        public static /* synthetic */ void getFontWeight$annotations() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class GoogleFont extends PaywallFont {
        public static final int $stable = 0;
        public static final Parcelable.Creator<GoogleFont> CREATOR = new Creator();
        private final String fontName;
        private final GoogleFontProvider fontProvider;
        private final int fontStyle;
        private final FontWeight fontWeight;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Creator implements Parcelable.Creator<GoogleFont> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final GoogleFont createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new GoogleFont(parcel.readString(), GoogleFontProvider.CREATOR.createFromParcel(parcel), FontWeightParceler.INSTANCE.m1162create(parcel), parcel.readInt());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final GoogleFont[] newArray(int i3) {
                return new GoogleFont[i3];
            }
        }

        public /* synthetic */ GoogleFont(String str, GoogleFontProvider googleFontProvider, FontWeight fontWeight, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, googleFontProvider, (i4 & 4) != 0 ? FontWeight.f29233b.g() : fontWeight, (i4 & 8) != 0 ? FontStyle.f29211b.b() : i3);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof GoogleFont)) {
                return false;
            }
            GoogleFont googleFont = (GoogleFont) obj;
            return Intrinsics.areEqual(this.fontName, googleFont.fontName) && Intrinsics.areEqual(this.fontProvider, googleFont.fontProvider) && Intrinsics.areEqual(this.fontWeight, googleFont.fontWeight) && this.fontStyle == googleFont.fontStyle;
        }

        public final String getFontName() {
            return this.fontName;
        }

        public final GoogleFontProvider getFontProvider() {
            return this.fontProvider;
        }

        public final int getFontStyle() {
            return this.fontStyle;
        }

        public final FontWeight getFontWeight() {
            return this.fontWeight;
        }

        public int hashCode() {
            return (((((this.fontName.hashCode() * 31) + this.fontProvider.hashCode()) * 31) + this.fontWeight.hashCode()) * 31) + this.fontStyle;
        }

        public String toString() {
            return "GoogleFont(fontName=" + this.fontName + ", fontProvider=" + this.fontProvider + ", fontWeight=" + this.fontWeight + ", fontStyle=" + this.fontStyle + ')';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int i3) {
            Intrinsics.checkNotNullParameter(out, "out");
            out.writeString(this.fontName);
            this.fontProvider.writeToParcel(out, i3);
            FontWeightParceler.INSTANCE.write(this.fontWeight, out, i3);
            out.writeInt(this.fontStyle);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GoogleFont(String fontName, GoogleFontProvider fontProvider, FontWeight fontWeight, int i3) {
            super(null);
            Intrinsics.checkNotNullParameter(fontName, "fontName");
            Intrinsics.checkNotNullParameter(fontProvider, "fontProvider");
            Intrinsics.checkNotNullParameter(fontWeight, "fontWeight");
            this.fontName = fontName;
            this.fontProvider = fontProvider;
            this.fontWeight = fontWeight;
            this.fontStyle = i3;
        }

        public static /* synthetic */ void getFontWeight$annotations() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ResourceFont extends PaywallFont {
        public static final int $stable = 0;
        public static final Parcelable.Creator<ResourceFont> CREATOR = new Creator();
        private final int fontStyle;
        private final FontWeight fontWeight;
        private final int resourceId;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Creator implements Parcelable.Creator<ResourceFont> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final ResourceFont createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new ResourceFont(parcel.readInt(), FontWeightParceler.INSTANCE.m1162create(parcel), parcel.readInt());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final ResourceFont[] newArray(int i3) {
                return new ResourceFont[i3];
            }
        }

        public /* synthetic */ ResourceFont(int i3, FontWeight fontWeight, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this(i3, (i5 & 2) != 0 ? FontWeight.f29233b.g() : fontWeight, (i5 & 4) != 0 ? FontStyle.f29211b.b() : i4);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ResourceFont)) {
                return false;
            }
            ResourceFont resourceFont = (ResourceFont) obj;
            return this.resourceId == resourceFont.resourceId && Intrinsics.areEqual(this.fontWeight, resourceFont.fontWeight) && this.fontStyle == resourceFont.fontStyle;
        }

        public final int getFontStyle() {
            return this.fontStyle;
        }

        public final FontWeight getFontWeight() {
            return this.fontWeight;
        }

        public final int getResourceId() {
            return this.resourceId;
        }

        public int hashCode() {
            return (((this.resourceId * 31) + this.fontWeight.hashCode()) * 31) + this.fontStyle;
        }

        public String toString() {
            return "ResourceFont(resourceId=" + this.resourceId + ", fontWeight=" + this.fontWeight + ", fontStyle=" + this.fontStyle + ')';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int i3) {
            Intrinsics.checkNotNullParameter(out, "out");
            out.writeInt(this.resourceId);
            FontWeightParceler.INSTANCE.write(this.fontWeight, out, i3);
            out.writeInt(this.fontStyle);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ResourceFont(int i3, FontWeight fontWeight, int i4) {
            super(null);
            Intrinsics.checkNotNullParameter(fontWeight, "fontWeight");
            this.resourceId = i3;
            this.fontWeight = fontWeight;
            this.fontStyle = i4;
        }

        public static /* synthetic */ void getFontWeight$annotations() {
        }
    }
}
