package com.facebook;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.facebook.AccessToken;
import com.facebook.internal.ImageRequest;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

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
public final class Profile implements Parcelable {
    public static final String FIRST_NAME_KEY = "first_name";
    public static final String ID_KEY = "id";
    public static final String LAST_NAME_KEY = "last_name";
    public static final String LINK_URI_KEY = "link_uri";
    public static final String MIDDLE_NAME_KEY = "middle_name";
    public static final String NAME_KEY = "name";
    public static final String PICTURE_URI_KEY = "picture_uri";
    public final String firstName;
    public final String id;
    public final String lastName;
    public final Uri linkUri;
    public final String middleName;
    public final String name;
    public final Uri pictureUri;
    public static final Companion Companion = new Companion(null);
    public static final String TAG = Profile.class.getSimpleName();
    public static final Parcelable.Creator<Profile> CREATOR = new Parcelable.Creator<Profile>() { // from class: com.facebook.Profile$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Profile createFromParcel(Parcel source) {
            Intrinsics.checkNotNullParameter(source, "source");
            return new Profile(source, null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Profile[] newArray(int i3) {
            return new Profile[i3];
        }
    };

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void fetchProfileForCurrentAccessToken() {
            AccessToken.Companion companion = AccessToken.Companion;
            AccessToken currentAccessToken = companion.getCurrentAccessToken();
            if (currentAccessToken == null) {
                return;
            }
            if (companion.isCurrentAccessTokenActive()) {
                Utility.getGraphMeRequestWithCacheAsync(currentAccessToken.getToken(), new Utility.GraphMeRequestWithCacheCallback() { // from class: com.facebook.Profile$Companion$fetchProfileForCurrentAccessToken$1
                    @Override // com.facebook.internal.Utility.GraphMeRequestWithCacheCallback
                    public void onFailure(FacebookException facebookException) {
                        Log.e(Profile.TAG, "Got unexpected exception: " + facebookException);
                    }

                    @Override // com.facebook.internal.Utility.GraphMeRequestWithCacheCallback
                    public void onSuccess(JSONObject jSONObject) {
                        String strOptString = jSONObject != null ? jSONObject.optString("id") : null;
                        if (strOptString == null) {
                            Log.w(Profile.TAG, "No user ID returned on Me request");
                            return;
                        }
                        String strOptString2 = jSONObject.optString("link");
                        String strOptString3 = jSONObject.optString("profile_picture", null);
                        Profile.Companion.setCurrentProfile(new Profile(strOptString, jSONObject.optString(Profile.FIRST_NAME_KEY), jSONObject.optString("middle_name"), jSONObject.optString(Profile.LAST_NAME_KEY), jSONObject.optString("name"), strOptString2 != null ? Uri.parse(strOptString2) : null, strOptString3 != null ? Uri.parse(strOptString3) : null));
                    }
                });
            } else {
                setCurrentProfile(null);
            }
        }

        @JvmStatic
        public final Profile getCurrentProfile() {
            return ProfileManager.Companion.getInstance().getCurrentProfile();
        }

        @JvmStatic
        public final void setCurrentProfile(Profile profile) {
            ProfileManager.Companion.getInstance().setCurrentProfile(profile);
        }

        public Companion() {
        }
    }

    public /* synthetic */ Profile(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    @JvmStatic
    public static final void fetchProfileForCurrentAccessToken() {
        Companion.fetchProfileForCurrentAccessToken();
    }

    @JvmStatic
    public static final Profile getCurrentProfile() {
        return Companion.getCurrentProfile();
    }

    @JvmStatic
    public static final void setCurrentProfile(Profile profile) {
        Companion.setCurrentProfile(profile);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        String str3;
        String str4;
        Uri uri;
        Uri uri2;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Profile)) {
            return false;
        }
        String str5 = this.id;
        return ((str5 == null && ((Profile) obj).id == null) || Intrinsics.areEqual(str5, ((Profile) obj).id)) && (((str = this.firstName) == null && ((Profile) obj).firstName == null) || Intrinsics.areEqual(str, ((Profile) obj).firstName)) && ((((str2 = this.middleName) == null && ((Profile) obj).middleName == null) || Intrinsics.areEqual(str2, ((Profile) obj).middleName)) && ((((str3 = this.lastName) == null && ((Profile) obj).lastName == null) || Intrinsics.areEqual(str3, ((Profile) obj).lastName)) && ((((str4 = this.name) == null && ((Profile) obj).name == null) || Intrinsics.areEqual(str4, ((Profile) obj).name)) && ((((uri = this.linkUri) == null && ((Profile) obj).linkUri == null) || Intrinsics.areEqual(uri, ((Profile) obj).linkUri)) && (((uri2 = this.pictureUri) == null && ((Profile) obj).pictureUri == null) || Intrinsics.areEqual(uri2, ((Profile) obj).pictureUri))))));
    }

    public final String getFirstName() {
        return this.firstName;
    }

    public final String getId() {
        return this.id;
    }

    public final String getLastName() {
        return this.lastName;
    }

    public final Uri getLinkUri() {
        return this.linkUri;
    }

    public final String getMiddleName() {
        return this.middleName;
    }

    public final String getName() {
        return this.name;
    }

    public final Uri getPictureUri() {
        return this.pictureUri;
    }

    public final Uri getProfilePictureUri(int i3, int i4) {
        String token;
        Uri uri = this.pictureUri;
        if (uri != null) {
            return uri;
        }
        AccessToken.Companion companion = AccessToken.Companion;
        if (companion.isCurrentAccessTokenActive()) {
            AccessToken currentAccessToken = companion.getCurrentAccessToken();
            token = currentAccessToken != null ? currentAccessToken.getToken() : null;
        } else {
            token = "";
        }
        return ImageRequest.Companion.getProfilePictureUri(this.id, i3, i4, token);
    }

    public int hashCode() {
        String str = this.id;
        int iHashCode = 527 + (str != null ? str.hashCode() : 0);
        String str2 = this.firstName;
        if (str2 != null) {
            iHashCode = (iHashCode * 31) + str2.hashCode();
        }
        String str3 = this.middleName;
        if (str3 != null) {
            iHashCode = (iHashCode * 31) + str3.hashCode();
        }
        String str4 = this.lastName;
        if (str4 != null) {
            iHashCode = (iHashCode * 31) + str4.hashCode();
        }
        String str5 = this.name;
        if (str5 != null) {
            iHashCode = (iHashCode * 31) + str5.hashCode();
        }
        Uri uri = this.linkUri;
        if (uri != null) {
            iHashCode = (iHashCode * 31) + uri.hashCode();
        }
        Uri uri2 = this.pictureUri;
        return uri2 != null ? (iHashCode * 31) + uri2.hashCode() : iHashCode;
    }

    public final JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.id);
            jSONObject.put(FIRST_NAME_KEY, this.firstName);
            jSONObject.put("middle_name", this.middleName);
            jSONObject.put(LAST_NAME_KEY, this.lastName);
            jSONObject.put("name", this.name);
            Uri uri = this.linkUri;
            if (uri != null) {
                jSONObject.put(LINK_URI_KEY, uri.toString());
            }
            Uri uri2 = this.pictureUri;
            if (uri2 != null) {
                jSONObject.put(PICTURE_URI_KEY, uri2.toString());
            }
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int i3) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.id);
        dest.writeString(this.firstName);
        dest.writeString(this.middleName);
        dest.writeString(this.lastName);
        dest.writeString(this.name);
        Uri uri = this.linkUri;
        dest.writeString(uri != null ? uri.toString() : null);
        Uri uri2 = this.pictureUri;
        dest.writeString(uri2 != null ? uri2.toString() : null);
    }

    public Profile(String str, String str2, String str3, String str4, String str5, Uri uri) {
        this(str, str2, str3, str4, str5, uri, null, 64, null);
    }

    public /* synthetic */ Profile(String str, String str2, String str3, String str4, String str5, Uri uri, Uri uri2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, str5, uri, (i3 & 64) != 0 ? null : uri2);
    }

    public Profile(String str, String str2, String str3, String str4, String str5, Uri uri, Uri uri2) {
        Validate.notNullOrEmpty(str, "id");
        this.id = str;
        this.firstName = str2;
        this.middleName = str3;
        this.lastName = str4;
        this.name = str5;
        this.linkUri = uri;
        this.pictureUri = uri2;
    }

    public Profile(JSONObject jsonObject) {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        this.id = jsonObject.optString("id", null);
        this.firstName = jsonObject.optString(FIRST_NAME_KEY, null);
        this.middleName = jsonObject.optString("middle_name", null);
        this.lastName = jsonObject.optString(LAST_NAME_KEY, null);
        this.name = jsonObject.optString("name", null);
        String strOptString = jsonObject.optString(LINK_URI_KEY, null);
        this.linkUri = strOptString == null ? null : Uri.parse(strOptString);
        String strOptString2 = jsonObject.optString(PICTURE_URI_KEY, null);
        this.pictureUri = strOptString2 != null ? Uri.parse(strOptString2) : null;
    }

    public Profile(Parcel parcel) {
        this.id = parcel.readString();
        this.firstName = parcel.readString();
        this.middleName = parcel.readString();
        this.lastName = parcel.readString();
        this.name = parcel.readString();
        String string = parcel.readString();
        this.linkUri = string == null ? null : Uri.parse(string);
        String string2 = parcel.readString();
        this.pictureUri = string2 != null ? Uri.parse(string2) : null;
    }
}
