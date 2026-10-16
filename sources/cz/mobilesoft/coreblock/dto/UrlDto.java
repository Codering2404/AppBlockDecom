package cz.mobilesoft.coreblock.dto;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.media3.exoplayer.audio.wRw.CbYNFSEGaQj;
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
public final class UrlDto implements Parcelable {
    private final String domain;
    private final boolean hasKeywordsBlocking;
    private final boolean isDomainReliable;
    private final String url;
    public static final Parcelable.Creator<UrlDto> CREATOR = new Creator();
    public static final int $stable = 8;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Creator implements Parcelable.Creator<UrlDto> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final UrlDto createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new UrlDto(parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readInt() != 0);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final UrlDto[] newArray(int i3) {
            return new UrlDto[i3];
        }
    }

    public UrlDto(String url, String domain, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(domain, "domain");
        this.url = url;
        this.domain = domain;
        this.hasKeywordsBlocking = z2;
        this.isDomainReliable = z3;
    }

    public static /* synthetic */ UrlDto copy$default(UrlDto urlDto, String str, String str2, boolean z2, boolean z3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = urlDto.url;
        }
        if ((i3 & 2) != 0) {
            str2 = urlDto.domain;
        }
        if ((i3 & 4) != 0) {
            z2 = urlDto.hasKeywordsBlocking;
        }
        if ((i3 & 8) != 0) {
            z3 = urlDto.isDomainReliable;
        }
        return urlDto.copy(str, str2, z2, z3);
    }

    public final String component1() {
        return this.url;
    }

    public final String component2() {
        return this.domain;
    }

    public final boolean component3() {
        return this.hasKeywordsBlocking;
    }

    public final boolean component4() {
        return this.isDomainReliable;
    }

    public final UrlDto copy(String url, String domain, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(domain, "domain");
        return new UrlDto(url, domain, z2, z3);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UrlDto)) {
            return false;
        }
        UrlDto urlDto = (UrlDto) obj;
        return Intrinsics.areEqual(this.url, urlDto.url) && Intrinsics.areEqual(this.domain, urlDto.domain) && this.hasKeywordsBlocking == urlDto.hasKeywordsBlocking && this.isDomainReliable == urlDto.isDomainReliable;
    }

    public final String getDomain() {
        return this.domain;
    }

    public final boolean getHasKeywordsBlocking() {
        return this.hasKeywordsBlocking;
    }

    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        return (((((this.url.hashCode() * 31) + this.domain.hashCode()) * 31) + Boolean.hashCode(this.hasKeywordsBlocking)) * 31) + Boolean.hashCode(this.isDomainReliable);
    }

    public final boolean isDomainReliable() {
        return this.isDomainReliable;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int i3) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.url);
        dest.writeString(this.domain);
        dest.writeInt(this.hasKeywordsBlocking ? 1 : 0);
        dest.writeInt(this.isDomainReliable ? 1 : 0);
    }

    public String toString() {
        return CbYNFSEGaQj.vKirkjpXVCd + this.url + "', domain='" + this.domain + "')";
    }

    public /* synthetic */ UrlDto(String str, String str2, boolean z2, boolean z3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i3 & 4) != 0 ? false : z2, (i3 & 8) != 0 ? true : z3);
    }
}
