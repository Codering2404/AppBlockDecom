package cz.mobilesoft.coreblock.dto.events;

import android.os.Parcel;
import android.os.Parcelable;
import cz.mobilesoft.coreblock.dto.UrlDto;
import cz.mobilesoft.coreblock.repository.SubApp;
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
public final class PackageAdditionalBlockingDTO implements Parcelable {
    private final String packageName;
    private final SubApp subApp;
    private final UrlDto urlDto;
    public static final Parcelable.Creator<PackageAdditionalBlockingDTO> CREATOR = new Creator();
    public static final int $stable = 8;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Creator implements Parcelable.Creator<PackageAdditionalBlockingDTO> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final PackageAdditionalBlockingDTO createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new PackageAdditionalBlockingDTO(parcel.readString(), parcel.readInt() == 0 ? null : UrlDto.CREATOR.createFromParcel(parcel), parcel.readInt() != 0 ? SubApp.CREATOR.createFromParcel(parcel) : null);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final PackageAdditionalBlockingDTO[] newArray(int i3) {
            return new PackageAdditionalBlockingDTO[i3];
        }
    }

    public PackageAdditionalBlockingDTO() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ PackageAdditionalBlockingDTO copy$default(PackageAdditionalBlockingDTO packageAdditionalBlockingDTO, String str, UrlDto urlDto, SubApp subApp, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = packageAdditionalBlockingDTO.packageName;
        }
        if ((i3 & 2) != 0) {
            urlDto = packageAdditionalBlockingDTO.urlDto;
        }
        if ((i3 & 4) != 0) {
            subApp = packageAdditionalBlockingDTO.subApp;
        }
        return packageAdditionalBlockingDTO.copy(str, urlDto, subApp);
    }

    public final String component1() {
        return this.packageName;
    }

    public final UrlDto component2() {
        return this.urlDto;
    }

    public final SubApp component3() {
        return this.subApp;
    }

    public final PackageAdditionalBlockingDTO copy(String str, UrlDto urlDto, SubApp subApp) {
        return new PackageAdditionalBlockingDTO(str, urlDto, subApp);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PackageAdditionalBlockingDTO)) {
            return false;
        }
        PackageAdditionalBlockingDTO packageAdditionalBlockingDTO = (PackageAdditionalBlockingDTO) obj;
        return Intrinsics.areEqual(this.packageName, packageAdditionalBlockingDTO.packageName) && Intrinsics.areEqual(this.urlDto, packageAdditionalBlockingDTO.urlDto) && Intrinsics.areEqual(this.subApp, packageAdditionalBlockingDTO.subApp);
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final SubApp getSubApp() {
        return this.subApp;
    }

    public final UrlDto getUrlDto() {
        return this.urlDto;
    }

    public int hashCode() {
        String str = this.packageName;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        UrlDto urlDto = this.urlDto;
        int iHashCode2 = (iHashCode + (urlDto == null ? 0 : urlDto.hashCode())) * 31;
        SubApp subApp = this.subApp;
        return iHashCode2 + (subApp != null ? subApp.hashCode() : 0);
    }

    public String toString() {
        return "PackageAdditionalBlockingDTO(packageName=" + this.packageName + ", urlDto=" + this.urlDto + ", subApp=" + this.subApp + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int i3) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.packageName);
        UrlDto urlDto = this.urlDto;
        if (urlDto == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            urlDto.writeToParcel(dest, i3);
        }
        SubApp subApp = this.subApp;
        if (subApp == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            subApp.writeToParcel(dest, i3);
        }
    }

    public PackageAdditionalBlockingDTO(String str, UrlDto urlDto, SubApp subApp) {
        this.packageName = str;
        this.urlDto = urlDto;
        this.subApp = subApp;
    }

    public /* synthetic */ PackageAdditionalBlockingDTO(String str, UrlDto urlDto, SubApp subApp, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? null : urlDto, (i3 & 4) != 0 ? null : subApp);
    }
}
