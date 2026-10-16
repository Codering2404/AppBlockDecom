package com.revenuecat.purchases.paywalls.components.properties;

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
public final class ImageUrls {
    public static final Companion Companion = new Companion(null);
    private final int height;
    private final URL original;
    private final URL webp;
    private final URL webpLowRes;
    private final int width;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<ImageUrls> serializer() {
            return ImageUrls$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    @Deprecated
    public /* synthetic */ ImageUrls(int i3, @Serializable(with = URLSerializer.class) URL url, @Serializable(with = URLSerializer.class) URL url2, @SerialName @Serializable(with = URLSerializer.class) URL url3, UInt uInt, UInt uInt2, SerializationConstructorMarker serializationConstructorMarker, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, url, url2, url3, uInt, uInt2, serializationConstructorMarker);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(ImageUrls imageUrls, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        URLSerializer uRLSerializer = URLSerializer.INSTANCE;
        compositeEncoder.C(serialDescriptor, 0, uRLSerializer, imageUrls.original);
        compositeEncoder.C(serialDescriptor, 1, uRLSerializer, imageUrls.webp);
        compositeEncoder.C(serialDescriptor, 2, uRLSerializer, imageUrls.webpLowRes);
        UIntSerializer uIntSerializer = UIntSerializer.f142909a;
        compositeEncoder.C(serialDescriptor, 3, uIntSerializer, UInt.a(imageUrls.width));
        compositeEncoder.C(serialDescriptor, 4, uIntSerializer, UInt.a(imageUrls.height));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ImageUrls)) {
            return false;
        }
        ImageUrls imageUrls = (ImageUrls) obj;
        return Intrinsics.areEqual(this.original, imageUrls.original) && Intrinsics.areEqual(this.webp, imageUrls.webp) && Intrinsics.areEqual(this.webpLowRes, imageUrls.webpLowRes) && this.width == imageUrls.width && this.height == imageUrls.height;
    }

    /* JADX INFO: renamed from: getHeight-pVg5ArA, reason: not valid java name */
    public final /* synthetic */ int m660getHeightpVg5ArA() {
        return this.height;
    }

    public final /* synthetic */ URL getOriginal() {
        return this.original;
    }

    public final /* synthetic */ URL getWebp() {
        return this.webp;
    }

    public final /* synthetic */ URL getWebpLowRes() {
        return this.webpLowRes;
    }

    /* JADX INFO: renamed from: getWidth-pVg5ArA, reason: not valid java name */
    public final /* synthetic */ int m661getWidthpVg5ArA() {
        return this.width;
    }

    public int hashCode() {
        return (((((((this.original.hashCode() * 31) + this.webp.hashCode()) * 31) + this.webpLowRes.hashCode()) * 31) + this.width) * 31) + this.height;
    }

    public String toString() {
        return "ImageUrls(original=" + this.original + ", webp=" + this.webp + ", webpLowRes=" + this.webpLowRes + ", width=" + ((Object) UInt.e(this.width)) + ", height=" + ((Object) UInt.e(this.height)) + ')';
    }

    public /* synthetic */ ImageUrls(URL url, URL url2, URL url3, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(url, url2, url3, i3, i4);
    }

    private ImageUrls(int i3, URL url, URL url2, URL url3, UInt uInt, UInt uInt2, SerializationConstructorMarker serializationConstructorMarker) {
        if (31 != (i3 & 31)) {
            PluginExceptionsKt.b(i3, 31, ImageUrls$$serializer.INSTANCE.getDescriptor());
        }
        this.original = url;
        this.webp = url2;
        this.webpLowRes = url3;
        this.width = uInt.f();
        this.height = uInt2.f();
    }

    private ImageUrls(URL original, URL webp, URL webpLowRes, int i3, int i4) {
        Intrinsics.checkNotNullParameter(original, "original");
        Intrinsics.checkNotNullParameter(webp, "webp");
        Intrinsics.checkNotNullParameter(webpLowRes, "webpLowRes");
        this.original = original;
        this.webp = webp;
        this.webpLowRes = webpLowRes;
        this.width = i3;
        this.height = i4;
    }

    @Serializable(with = URLSerializer.class)
    public static /* synthetic */ void getOriginal$annotations() {
    }

    @Serializable(with = URLSerializer.class)
    public static /* synthetic */ void getWebp$annotations() {
    }

    @SerialName
    @Serializable(with = URLSerializer.class)
    public static /* synthetic */ void getWebpLowRes$annotations() {
    }
}
