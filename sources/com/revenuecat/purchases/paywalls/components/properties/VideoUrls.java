package com.revenuecat.purchases.paywalls.components.properties;

import com.revenuecat.purchases.models.Checksum;
import com.revenuecat.purchases.models.Checksum$$serializer;
import com.revenuecat.purchases.utils.serializers.URLSerializer;
import java.net.URL;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.UIntSerializer;

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
/* JADX INFO: loaded from: classes6.dex */
@Metadata
@Serializable
public final class VideoUrls {
    public static final Companion Companion = new Companion(null);
    private final Checksum checksum;
    private final Checksum checksumLowRes;
    private final int height;
    private final URL url;
    private final URL urlLowRes;
    private final int width;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<VideoUrls> serializer() {
            return VideoUrls$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ VideoUrls(int i3, int i4, URL url, Checksum checksum, URL url2, Checksum checksum2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, i4, url, checksum, url2, checksum2);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(VideoUrls videoUrls, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        UIntSerializer uIntSerializer = UIntSerializer.f142909a;
        compositeEncoder.C(serialDescriptor, 0, uIntSerializer, UInt.a(videoUrls.width));
        compositeEncoder.C(serialDescriptor, 1, uIntSerializer, UInt.a(videoUrls.height));
        URLSerializer uRLSerializer = URLSerializer.INSTANCE;
        compositeEncoder.C(serialDescriptor, 2, uRLSerializer, videoUrls.url);
        if (compositeEncoder.z(serialDescriptor, 3) || videoUrls.checksum != null) {
            compositeEncoder.i(serialDescriptor, 3, Checksum$$serializer.INSTANCE, videoUrls.checksum);
        }
        if (compositeEncoder.z(serialDescriptor, 4) || videoUrls.urlLowRes != null) {
            compositeEncoder.i(serialDescriptor, 4, uRLSerializer, videoUrls.urlLowRes);
        }
        if (!compositeEncoder.z(serialDescriptor, 5) && videoUrls.checksumLowRes == null) {
            return;
        }
        compositeEncoder.i(serialDescriptor, 5, Checksum$$serializer.INSTANCE, videoUrls.checksumLowRes);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VideoUrls)) {
            return false;
        }
        VideoUrls videoUrls = (VideoUrls) obj;
        return this.width == videoUrls.width && this.height == videoUrls.height && Intrinsics.areEqual(this.url, videoUrls.url) && Intrinsics.areEqual(this.checksum, videoUrls.checksum) && Intrinsics.areEqual(this.urlLowRes, videoUrls.urlLowRes) && Intrinsics.areEqual(this.checksumLowRes, videoUrls.checksumLowRes);
    }

    public final /* synthetic */ Checksum getChecksum() {
        return this.checksum;
    }

    public final /* synthetic */ Checksum getChecksumLowRes() {
        return this.checksumLowRes;
    }

    /* JADX INFO: renamed from: getHeight-pVg5ArA, reason: not valid java name */
    public final /* synthetic */ int m663getHeightpVg5ArA() {
        return this.height;
    }

    public final /* synthetic */ URL getUrl() {
        return this.url;
    }

    public final /* synthetic */ URL getUrlLowRes() {
        return this.urlLowRes;
    }

    /* JADX INFO: renamed from: getWidth-pVg5ArA, reason: not valid java name */
    public final /* synthetic */ int m664getWidthpVg5ArA() {
        return this.width;
    }

    public int hashCode() {
        int iHashCode = ((((this.width * 31) + this.height) * 31) + this.url.hashCode()) * 31;
        Checksum checksum = this.checksum;
        int iHashCode2 = (iHashCode + (checksum == null ? 0 : checksum.hashCode())) * 31;
        URL url = this.urlLowRes;
        int iHashCode3 = (iHashCode2 + (url == null ? 0 : url.hashCode())) * 31;
        Checksum checksum2 = this.checksumLowRes;
        return iHashCode3 + (checksum2 != null ? checksum2.hashCode() : 0);
    }

    public String toString() {
        return "VideoUrls(width=" + ((Object) UInt.e(this.width)) + ", height=" + ((Object) UInt.e(this.height)) + ", url=" + this.url + ", checksum=" + this.checksum + ", urlLowRes=" + this.urlLowRes + ", checksumLowRes=" + this.checksumLowRes + ')';
    }

    @Deprecated
    public /* synthetic */ VideoUrls(int i3, UInt uInt, UInt uInt2, @Serializable(with = URLSerializer.class) URL url, Checksum checksum, @SerialName @Serializable(with = URLSerializer.class) URL url2, @SerialName Checksum checksum2, SerializationConstructorMarker serializationConstructorMarker, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, uInt, uInt2, url, checksum, url2, checksum2, serializationConstructorMarker);
    }

    private VideoUrls(int i3, int i4, URL url, Checksum checksum, URL url2, Checksum checksum2) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.width = i3;
        this.height = i4;
        this.url = url;
        this.checksum = checksum;
        this.urlLowRes = url2;
        this.checksumLowRes = checksum2;
    }

    private VideoUrls(int i3, UInt uInt, UInt uInt2, URL url, Checksum checksum, URL url2, Checksum checksum2, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (i3 & 7)) {
            PluginExceptionsKt.b(i3, 7, VideoUrls$$serializer.INSTANCE.getDescriptor());
        }
        this.width = uInt.f();
        this.height = uInt2.f();
        this.url = url;
        if ((i3 & 8) == 0) {
            this.checksum = null;
        } else {
            this.checksum = checksum;
        }
        if ((i3 & 16) == 0) {
            this.urlLowRes = null;
        } else {
            this.urlLowRes = url2;
        }
        if ((i3 & 32) == 0) {
            this.checksumLowRes = null;
        } else {
            this.checksumLowRes = checksum2;
        }
    }

    public /* synthetic */ VideoUrls(int i3, int i4, URL url, Checksum checksum, URL url2, Checksum checksum2, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, i4, url, (i5 & 8) != 0 ? null : checksum, (i5 & 16) != 0 ? null : url2, (i5 & 32) != 0 ? null : checksum2, null);
    }

    @SerialName
    public static /* synthetic */ void getChecksumLowRes$annotations() {
    }

    @Serializable(with = URLSerializer.class)
    public static /* synthetic */ void getUrl$annotations() {
    }

    @SerialName
    @Serializable(with = URLSerializer.class)
    public static /* synthetic */ void getUrlLowRes$annotations() {
    }
}
