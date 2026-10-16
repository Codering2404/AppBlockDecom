package com.facebook.internal;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.facebook.FacebookSdk;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

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
public final class ImageRequest {
    private static final String ACCESS_TOKEN_PARAM = "access_token";
    public static final Companion Companion = new Companion(null);
    private static final String HEIGHT_PARAM = "height";
    private static final String MIGRATION_PARAM = "migration_overrides";
    private static final String MIGRATION_VALUE = "{october_2012:true}";
    private static final String PATH = "%s/%s/picture";
    public static final int UNSPECIFIED_DIMENSION = 0;
    private static final String WIDTH_PARAM = "width";
    private final boolean allowCachedRedirects;
    private final Callback callback;
    private final Object callerTag;
    private final Context context;
    private final Uri imageUri;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Builder {
        private boolean allowCachedRedirects;
        private Callback callback;
        private Object callerTag;
        private final Context context;
        private final Uri imageUri;

        public Builder(Context context, Uri imageUri) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(imageUri, "imageUri");
            this.context = context;
            this.imageUri = imageUri;
        }

        private final Context component1() {
            return this.context;
        }

        private final Uri component2() {
            return this.imageUri;
        }

        public static /* synthetic */ Builder copy$default(Builder builder, Context context, Uri uri, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                context = builder.context;
            }
            if ((i3 & 2) != 0) {
                uri = builder.imageUri;
            }
            return builder.copy(context, uri);
        }

        public final ImageRequest build() {
            Context context = this.context;
            Uri uri = this.imageUri;
            Callback callback = this.callback;
            boolean z2 = this.allowCachedRedirects;
            Object obj = this.callerTag;
            if (obj == null) {
                obj = new Object();
            } else if (obj == null) {
                throw new IllegalStateException("Required value was null.");
            }
            return new ImageRequest(context, uri, callback, z2, obj, null);
        }

        public final Builder copy(Context context, Uri imageUri) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(imageUri, "imageUri");
            return new Builder(context, imageUri);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Builder)) {
                return false;
            }
            Builder builder = (Builder) obj;
            return Intrinsics.areEqual(this.context, builder.context) && Intrinsics.areEqual(this.imageUri, builder.imageUri);
        }

        public int hashCode() {
            return (this.context.hashCode() * 31) + this.imageUri.hashCode();
        }

        public final Builder setAllowCachedRedirects(boolean z2) {
            this.allowCachedRedirects = z2;
            return this;
        }

        public final Builder setCallback(Callback callback) {
            this.callback = callback;
            return this;
        }

        public final Builder setCallerTag(Object obj) {
            this.callerTag = obj;
            return this;
        }

        public String toString() {
            return "Builder(context=" + this.context + ", imageUri=" + this.imageUri + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface Callback {
        void onCompleted(ImageResponse imageResponse);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final Uri getProfilePictureUri(String str, int i3, int i4) {
            return getProfilePictureUri(str, i3, i4, "");
        }

        private Companion() {
        }

        @JvmStatic
        public final Uri getProfilePictureUri(String str, int i3, int i4, String str2) {
            Validate.notNullOrEmpty(str, "userId");
            int iMax = Math.max(i3, 0);
            int iMax2 = Math.max(i4, 0);
            if (iMax == 0 && iMax2 == 0) {
                throw new IllegalArgumentException("Either width or height must be greater than 0");
            }
            Uri.Builder builderBuildUpon = Uri.parse(ServerProtocol.getGraphUrlBase()).buildUpon();
            StringCompanionObject stringCompanionObject = StringCompanionObject.f140150a;
            String str3 = String.format(Locale.US, ImageRequest.PATH, Arrays.copyOf(new Object[]{FacebookSdk.getGraphApiVersion(), str}, 2));
            Intrinsics.checkNotNullExpressionValue(str3, "format(locale, format, *args)");
            Uri.Builder builderPath = builderBuildUpon.path(str3);
            if (iMax2 != 0) {
                builderPath.appendQueryParameter("height", String.valueOf(iMax2));
            }
            if (iMax != 0) {
                builderPath.appendQueryParameter("width", String.valueOf(iMax));
            }
            builderPath.appendQueryParameter(ImageRequest.MIGRATION_PARAM, ImageRequest.MIGRATION_VALUE);
            if (!Utility.isNullOrEmpty(str2)) {
                builderPath.appendQueryParameter("access_token", str2);
            } else if (Utility.isNullOrEmpty(FacebookSdk.getClientToken()) || Utility.isNullOrEmpty(FacebookSdk.getApplicationId())) {
                Log.d("ImageRequest", "Needs access token to fetch profile picture. Without an access token a default silhoutte picture is returned");
            } else {
                builderPath.appendQueryParameter("access_token", FacebookSdk.getApplicationId() + '|' + FacebookSdk.getClientToken());
            }
            Uri uriBuild = builderPath.build();
            Intrinsics.checkNotNullExpressionValue(uriBuild, "builder.build()");
            return uriBuild;
        }
    }

    public /* synthetic */ ImageRequest(Context context, Uri uri, Callback callback, boolean z2, Object obj, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, uri, callback, z2, obj);
    }

    @JvmStatic
    public static final Uri getProfilePictureUri(String str, int i3, int i4) {
        return Companion.getProfilePictureUri(str, i3, i4);
    }

    public final boolean getAllowCachedRedirects() {
        return this.allowCachedRedirects;
    }

    public final Callback getCallback() {
        return this.callback;
    }

    public final Object getCallerTag() {
        return this.callerTag;
    }

    public final Context getContext() {
        return this.context;
    }

    public final Uri getImageUri() {
        return this.imageUri;
    }

    public final boolean isCachedRedirectAllowed() {
        return this.allowCachedRedirects;
    }

    private ImageRequest(Context context, Uri uri, Callback callback, boolean z2, Object obj) {
        this.context = context;
        this.imageUri = uri;
        this.callback = callback;
        this.allowCachedRedirects = z2;
        this.callerTag = obj;
    }

    @JvmStatic
    public static final Uri getProfilePictureUri(String str, int i3, int i4, String str2) {
        return Companion.getProfilePictureUri(str, i3, i4, str2);
    }
}
