package com.facebook;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Charsets;
import org.json.JSONArray;
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
public final class AuthenticationTokenClaims implements Parcelable {
    public static final String JSON_KEY_AUD = "aud";
    public static final String JSON_KEY_EMAIL = "email";
    public static final String JSON_KEY_EXP = "exp";
    public static final String JSON_KEY_FAMILY_NAME = "family_name";
    public static final String JSON_KEY_GIVEN_NAME = "given_name";
    public static final String JSON_KEY_IAT = "iat";
    public static final String JSON_KEY_ISS = "iss";
    public static final String JSON_KEY_JIT = "jti";
    public static final String JSON_KEY_MIDDLE_NAME = "middle_name";
    public static final String JSON_KEY_NAME = "name";
    public static final String JSON_KEY_NONCE = "nonce";
    public static final String JSON_KEY_PICTURE = "picture";
    public static final String JSON_KEY_SUB = "sub";
    public static final String JSON_KEY_USER_AGE_RANGE = "user_age_range";
    public static final String JSON_KEY_USER_BIRTHDAY = "user_birthday";
    public static final String JSON_KEY_USER_FRIENDS = "user_friends";
    public static final String JSON_KEY_USER_GENDER = "user_gender";
    public static final String JSON_KEY_USER_HOMETOWN = "user_hometown";
    public static final String JSON_KEY_USER_LINK = "user_link";
    public static final String JSON_KEY_USER_LOCATION = "user_location";
    public static final long MAX_TIME_SINCE_TOKEN_ISSUED = 600000;
    public final String aud;
    public final String email;
    public final long exp;
    public final String familyName;
    public final String givenName;
    public final long iat;
    public final String iss;
    public final String jti;
    public final String middleName;
    public final String name;
    public final String nonce;
    public final String picture;
    public final String sub;
    public final Map<String, Integer> userAgeRange;
    public final String userBirthday;
    public final Set<String> userFriends;
    public final String userGender;
    public final Map<String, String> userHometown;
    public final String userLink;
    public final Map<String, String> userLocation;
    public static final Companion Companion = new Companion(null);
    public static final Parcelable.Creator<AuthenticationTokenClaims> CREATOR = new Parcelable.Creator<AuthenticationTokenClaims>() { // from class: com.facebook.AuthenticationTokenClaims$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AuthenticationTokenClaims createFromParcel(Parcel source) {
            Intrinsics.checkNotNullParameter(source, "source");
            return new AuthenticationTokenClaims(source);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AuthenticationTokenClaims[] newArray(int i3) {
            return new AuthenticationTokenClaims[i3];
        }
    };

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final AuthenticationTokenClaims createFromJSONObject$facebook_core_release(JSONObject jsonObject) throws JSONException {
            Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
            String jti = jsonObject.getString(AuthenticationTokenClaims.JSON_KEY_JIT);
            String iss = jsonObject.getString(AuthenticationTokenClaims.JSON_KEY_ISS);
            String aud = jsonObject.getString(AuthenticationTokenClaims.JSON_KEY_AUD);
            String nonce = jsonObject.getString("nonce");
            long j3 = jsonObject.getLong(AuthenticationTokenClaims.JSON_KEY_EXP);
            long j4 = jsonObject.getLong(AuthenticationTokenClaims.JSON_KEY_IAT);
            String sub = jsonObject.getString(AuthenticationTokenClaims.JSON_KEY_SUB);
            String nullableString$facebook_core_release = getNullableString$facebook_core_release(jsonObject, "name");
            String nullableString$facebook_core_release2 = getNullableString$facebook_core_release(jsonObject, AuthenticationTokenClaims.JSON_KEY_GIVEN_NAME);
            String nullableString$facebook_core_release3 = getNullableString$facebook_core_release(jsonObject, "middle_name");
            String nullableString$facebook_core_release4 = getNullableString$facebook_core_release(jsonObject, AuthenticationTokenClaims.JSON_KEY_FAMILY_NAME);
            String nullableString$facebook_core_release5 = getNullableString$facebook_core_release(jsonObject, AuthenticationTokenClaims.JSON_KEY_EMAIL);
            String nullableString$facebook_core_release6 = getNullableString$facebook_core_release(jsonObject, "picture");
            JSONArray jSONArrayOptJSONArray = jsonObject.optJSONArray(AuthenticationTokenClaims.JSON_KEY_USER_FRIENDS);
            String nullableString$facebook_core_release7 = getNullableString$facebook_core_release(jsonObject, AuthenticationTokenClaims.JSON_KEY_USER_BIRTHDAY);
            JSONObject jSONObjectOptJSONObject = jsonObject.optJSONObject(AuthenticationTokenClaims.JSON_KEY_USER_AGE_RANGE);
            JSONObject jSONObjectOptJSONObject2 = jsonObject.optJSONObject(AuthenticationTokenClaims.JSON_KEY_USER_HOMETOWN);
            JSONObject jSONObjectOptJSONObject3 = jsonObject.optJSONObject(AuthenticationTokenClaims.JSON_KEY_USER_LOCATION);
            String nullableString$facebook_core_release8 = getNullableString$facebook_core_release(jsonObject, AuthenticationTokenClaims.JSON_KEY_USER_GENDER);
            String nullableString$facebook_core_release9 = getNullableString$facebook_core_release(jsonObject, AuthenticationTokenClaims.JSON_KEY_USER_LINK);
            Intrinsics.checkNotNullExpressionValue(jti, "jti");
            Intrinsics.checkNotNullExpressionValue(iss, "iss");
            Intrinsics.checkNotNullExpressionValue(aud, "aud");
            Intrinsics.checkNotNullExpressionValue(nonce, "nonce");
            Intrinsics.checkNotNullExpressionValue(sub, "sub");
            return new AuthenticationTokenClaims(jti, iss, aud, nonce, j3, j4, sub, nullableString$facebook_core_release, nullableString$facebook_core_release2, nullableString$facebook_core_release3, nullableString$facebook_core_release4, nullableString$facebook_core_release5, nullableString$facebook_core_release6, jSONArrayOptJSONArray == null ? null : Utility.jsonArrayToStringList(jSONArrayOptJSONArray), nullableString$facebook_core_release7, jSONObjectOptJSONObject == null ? null : Utility.convertJSONObjectToHashMap(jSONObjectOptJSONObject), jSONObjectOptJSONObject2 == null ? null : Utility.convertJSONObjectToStringMap(jSONObjectOptJSONObject2), jSONObjectOptJSONObject3 != null ? Utility.convertJSONObjectToStringMap(jSONObjectOptJSONObject3) : null, nullableString$facebook_core_release8, nullableString$facebook_core_release9);
        }

        public final String getNullableString$facebook_core_release(JSONObject jSONObject, String name) {
            Intrinsics.checkNotNullParameter(jSONObject, "<this>");
            Intrinsics.checkNotNullParameter(name, "name");
            if (jSONObject.has(name)) {
                return jSONObject.getString(name);
            }
            return null;
        }

        public Companion() {
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AuthenticationTokenClaims(String jti, String iss, String aud, String nonce, long j3, long j4, String sub) {
        this(jti, iss, aud, nonce, j3, j4, sub, null, null, null, null, null, null, null, null, null, null, null, null, null, 1048448, null);
        Intrinsics.checkNotNullParameter(jti, "jti");
        Intrinsics.checkNotNullParameter(iss, "iss");
        Intrinsics.checkNotNullParameter(aud, "aud");
        Intrinsics.checkNotNullParameter(nonce, "nonce");
        Intrinsics.checkNotNullParameter(sub, "sub");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0044, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(new java.net.URL(r2).getHost(), "www.facebook.com") == false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean isValidClaims(org.json.JSONObject r7, java.lang.String r8) {
        /*
            r6 = this;
            java.lang.String r0 = "iss"
            r1 = 0
            if (r7 != 0) goto L6
            return r1
        L6:
            java.lang.String r2 = "jti"
            java.lang.String r3 = r7.optString(r2)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r2)
            int r2 = r3.length()
            if (r2 != 0) goto L16
            return r1
        L16:
            java.lang.String r2 = r7.optString(r0)     // Catch: java.net.MalformedURLException -> Lc2
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r0)     // Catch: java.net.MalformedURLException -> Lc2
            int r0 = r2.length()     // Catch: java.net.MalformedURLException -> Lc2
            if (r0 != 0) goto L24
            goto L46
        L24:
            java.net.URL r0 = new java.net.URL     // Catch: java.net.MalformedURLException -> Lc2
            r0.<init>(r2)     // Catch: java.net.MalformedURLException -> Lc2
            java.lang.String r0 = r0.getHost()     // Catch: java.net.MalformedURLException -> Lc2
            java.lang.String r3 = "facebook.com"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r3)     // Catch: java.net.MalformedURLException -> Lc2
            if (r0 != 0) goto L47
            java.net.URL r0 = new java.net.URL     // Catch: java.net.MalformedURLException -> Lc2
            r0.<init>(r2)     // Catch: java.net.MalformedURLException -> Lc2
            java.lang.String r0 = r0.getHost()     // Catch: java.net.MalformedURLException -> Lc2
            java.lang.String r2 = "www.facebook.com"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r2)     // Catch: java.net.MalformedURLException -> Lc2
            if (r0 != 0) goto L47
        L46:
            return r1
        L47:
            java.lang.String r0 = "aud"
            java.lang.String r2 = r7.optString(r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r0)
            int r0 = r2.length()
            if (r0 != 0) goto L57
            goto L61
        L57:
            java.lang.String r0 = com.facebook.FacebookSdk.getApplicationId()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r0)
            if (r0 != 0) goto L62
        L61:
            return r1
        L62:
            java.util.Date r0 = new java.util.Date
            java.lang.String r2 = "exp"
            long r2 = r7.optLong(r2)
            r4 = 1000(0x3e8, float:1.401E-42)
            long r4 = (long) r4
            long r2 = r2 * r4
            r0.<init>(r2)
            java.util.Date r2 = new java.util.Date
            r2.<init>()
            boolean r0 = r2.after(r0)
            if (r0 == 0) goto L7d
            return r1
        L7d:
            java.lang.String r0 = "iat"
            long r2 = r7.optLong(r0)
            java.util.Date r0 = new java.util.Date
            long r2 = r2 * r4
            r4 = 600000(0x927c0, double:2.964394E-318)
            long r2 = r2 + r4
            r0.<init>(r2)
            java.util.Date r2 = new java.util.Date
            r2.<init>()
            boolean r0 = r2.after(r0)
            if (r0 == 0) goto L99
            return r1
        L99:
            java.lang.String r0 = "sub"
            java.lang.String r2 = r7.optString(r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r0)
            int r0 = r2.length()
            if (r0 != 0) goto La9
            return r1
        La9:
            java.lang.String r0 = "nonce"
            java.lang.String r7 = r7.optString(r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r0)
            int r0 = r7.length()
            if (r0 != 0) goto Lb9
            goto Lbf
        Lb9:
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual(r7, r8)
            if (r7 != 0) goto Lc0
        Lbf:
            return r1
        Lc0:
            r7 = 1
            return r7
        Lc2:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.AuthenticationTokenClaims.isValidClaims(org.json.JSONObject, java.lang.String):boolean");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AuthenticationTokenClaims)) {
            return false;
        }
        AuthenticationTokenClaims authenticationTokenClaims = (AuthenticationTokenClaims) obj;
        return Intrinsics.areEqual(this.jti, authenticationTokenClaims.jti) && Intrinsics.areEqual(this.iss, authenticationTokenClaims.iss) && Intrinsics.areEqual(this.aud, authenticationTokenClaims.aud) && Intrinsics.areEqual(this.nonce, authenticationTokenClaims.nonce) && this.exp == authenticationTokenClaims.exp && this.iat == authenticationTokenClaims.iat && Intrinsics.areEqual(this.sub, authenticationTokenClaims.sub) && Intrinsics.areEqual(this.name, authenticationTokenClaims.name) && Intrinsics.areEqual(this.givenName, authenticationTokenClaims.givenName) && Intrinsics.areEqual(this.middleName, authenticationTokenClaims.middleName) && Intrinsics.areEqual(this.familyName, authenticationTokenClaims.familyName) && Intrinsics.areEqual(this.email, authenticationTokenClaims.email) && Intrinsics.areEqual(this.picture, authenticationTokenClaims.picture) && Intrinsics.areEqual(this.userFriends, authenticationTokenClaims.userFriends) && Intrinsics.areEqual(this.userBirthday, authenticationTokenClaims.userBirthday) && Intrinsics.areEqual(this.userAgeRange, authenticationTokenClaims.userAgeRange) && Intrinsics.areEqual(this.userHometown, authenticationTokenClaims.userHometown) && Intrinsics.areEqual(this.userLocation, authenticationTokenClaims.userLocation) && Intrinsics.areEqual(this.userGender, authenticationTokenClaims.userGender) && Intrinsics.areEqual(this.userLink, authenticationTokenClaims.userLink);
    }

    public final String getAud() {
        return this.aud;
    }

    public final String getEmail() {
        return this.email;
    }

    public final long getExp() {
        return this.exp;
    }

    public final String getFamilyName() {
        return this.familyName;
    }

    public final String getGivenName() {
        return this.givenName;
    }

    public final long getIat() {
        return this.iat;
    }

    public final String getIss() {
        return this.iss;
    }

    public final String getJti() {
        return this.jti;
    }

    public final String getMiddleName() {
        return this.middleName;
    }

    public final String getName() {
        return this.name;
    }

    public final String getNonce() {
        return this.nonce;
    }

    public final String getPicture() {
        return this.picture;
    }

    public final String getSub() {
        return this.sub;
    }

    public final Map<String, Integer> getUserAgeRange() {
        return this.userAgeRange;
    }

    public final String getUserBirthday() {
        return this.userBirthday;
    }

    public final Set<String> getUserFriends() {
        return this.userFriends;
    }

    public final String getUserGender() {
        return this.userGender;
    }

    public final Map<String, String> getUserHometown() {
        return this.userHometown;
    }

    public final String getUserLink() {
        return this.userLink;
    }

    public final Map<String, String> getUserLocation() {
        return this.userLocation;
    }

    public int hashCode() {
        int iHashCode = (((((((((((((527 + this.jti.hashCode()) * 31) + this.iss.hashCode()) * 31) + this.aud.hashCode()) * 31) + this.nonce.hashCode()) * 31) + Long.hashCode(this.exp)) * 31) + Long.hashCode(this.iat)) * 31) + this.sub.hashCode()) * 31;
        String str = this.name;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.givenName;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.middleName;
        int iHashCode4 = (iHashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.familyName;
        int iHashCode5 = (iHashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.email;
        int iHashCode6 = (iHashCode5 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.picture;
        int iHashCode7 = (iHashCode6 + (str6 != null ? str6.hashCode() : 0)) * 31;
        Set<String> set = this.userFriends;
        int iHashCode8 = (iHashCode7 + (set != null ? set.hashCode() : 0)) * 31;
        String str7 = this.userBirthday;
        int iHashCode9 = (iHashCode8 + (str7 != null ? str7.hashCode() : 0)) * 31;
        Map<String, Integer> map = this.userAgeRange;
        int iHashCode10 = (iHashCode9 + (map != null ? map.hashCode() : 0)) * 31;
        Map<String, String> map2 = this.userHometown;
        int iHashCode11 = (iHashCode10 + (map2 != null ? map2.hashCode() : 0)) * 31;
        Map<String, String> map3 = this.userLocation;
        int iHashCode12 = (iHashCode11 + (map3 != null ? map3.hashCode() : 0)) * 31;
        String str8 = this.userGender;
        int iHashCode13 = (iHashCode12 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.userLink;
        return iHashCode13 + (str9 != null ? str9.hashCode() : 0);
    }

    public final String toEnCodedString() {
        byte[] bytes = toString().getBytes(Charsets.f140510b);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        String strEncodeToString = Base64.encodeToString(bytes, 8);
        Intrinsics.checkNotNullExpressionValue(strEncodeToString, "encodeToString(claimsJso…Array(), Base64.URL_SAFE)");
        return strEncodeToString;
    }

    public final JSONObject toJSONObject$facebook_core_release() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(JSON_KEY_JIT, this.jti);
        jSONObject.put(JSON_KEY_ISS, this.iss);
        jSONObject.put(JSON_KEY_AUD, this.aud);
        jSONObject.put("nonce", this.nonce);
        jSONObject.put(JSON_KEY_EXP, this.exp);
        jSONObject.put(JSON_KEY_IAT, this.iat);
        String str = this.sub;
        if (str != null) {
            jSONObject.put(JSON_KEY_SUB, str);
        }
        String str2 = this.name;
        if (str2 != null) {
            jSONObject.put("name", str2);
        }
        String str3 = this.givenName;
        if (str3 != null) {
            jSONObject.put(JSON_KEY_GIVEN_NAME, str3);
        }
        String str4 = this.middleName;
        if (str4 != null) {
            jSONObject.put("middle_name", str4);
        }
        String str5 = this.familyName;
        if (str5 != null) {
            jSONObject.put(JSON_KEY_FAMILY_NAME, str5);
        }
        String str6 = this.email;
        if (str6 != null) {
            jSONObject.put(JSON_KEY_EMAIL, str6);
        }
        String str7 = this.picture;
        if (str7 != null) {
            jSONObject.put("picture", str7);
        }
        if (this.userFriends != null) {
            jSONObject.put(JSON_KEY_USER_FRIENDS, new JSONArray((Collection) this.userFriends));
        }
        String str8 = this.userBirthday;
        if (str8 != null) {
            jSONObject.put(JSON_KEY_USER_BIRTHDAY, str8);
        }
        if (this.userAgeRange != null) {
            jSONObject.put(JSON_KEY_USER_AGE_RANGE, new JSONObject(this.userAgeRange));
        }
        if (this.userHometown != null) {
            jSONObject.put(JSON_KEY_USER_HOMETOWN, new JSONObject(this.userHometown));
        }
        if (this.userLocation != null) {
            jSONObject.put(JSON_KEY_USER_LOCATION, new JSONObject(this.userLocation));
        }
        String str9 = this.userGender;
        if (str9 != null) {
            jSONObject.put(JSON_KEY_USER_GENDER, str9);
        }
        String str10 = this.userLink;
        if (str10 != null) {
            jSONObject.put(JSON_KEY_USER_LINK, str10);
        }
        return jSONObject;
    }

    public String toString() {
        String string = toJSONObject$facebook_core_release().toString();
        Intrinsics.checkNotNullExpressionValue(string, "claimsJsonObject.toString()");
        return string;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int i3) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.jti);
        dest.writeString(this.iss);
        dest.writeString(this.aud);
        dest.writeString(this.nonce);
        dest.writeLong(this.exp);
        dest.writeLong(this.iat);
        dest.writeString(this.sub);
        dest.writeString(this.name);
        dest.writeString(this.givenName);
        dest.writeString(this.middleName);
        dest.writeString(this.familyName);
        dest.writeString(this.email);
        dest.writeString(this.picture);
        if (this.userFriends == null) {
            dest.writeStringList(null);
        } else {
            dest.writeStringList(new ArrayList(this.userFriends));
        }
        dest.writeString(this.userBirthday);
        dest.writeMap(this.userAgeRange);
        dest.writeMap(this.userHometown);
        dest.writeMap(this.userLocation);
        dest.writeString(this.userGender);
        dest.writeString(this.userLink);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AuthenticationTokenClaims(String jti, String iss, String aud, String nonce, long j3, long j4, String sub, String str) {
        this(jti, iss, aud, nonce, j3, j4, sub, str, null, null, null, null, null, null, null, null, null, null, null, null, 1048320, null);
        Intrinsics.checkNotNullParameter(jti, "jti");
        Intrinsics.checkNotNullParameter(iss, "iss");
        Intrinsics.checkNotNullParameter(aud, "aud");
        Intrinsics.checkNotNullParameter(nonce, "nonce");
        Intrinsics.checkNotNullParameter(sub, "sub");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AuthenticationTokenClaims(String jti, String iss, String aud, String nonce, long j3, long j4, String sub, String str, String str2) {
        this(jti, iss, aud, nonce, j3, j4, sub, str, str2, null, null, null, null, null, null, null, null, null, null, null, 1048064, null);
        Intrinsics.checkNotNullParameter(jti, "jti");
        Intrinsics.checkNotNullParameter(iss, "iss");
        Intrinsics.checkNotNullParameter(aud, "aud");
        Intrinsics.checkNotNullParameter(nonce, "nonce");
        Intrinsics.checkNotNullParameter(sub, "sub");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AuthenticationTokenClaims(String jti, String iss, String aud, String nonce, long j3, long j4, String sub, String str, String str2, String str3) {
        this(jti, iss, aud, nonce, j3, j4, sub, str, str2, str3, null, null, null, null, null, null, null, null, null, null, 1047552, null);
        Intrinsics.checkNotNullParameter(jti, "jti");
        Intrinsics.checkNotNullParameter(iss, "iss");
        Intrinsics.checkNotNullParameter(aud, "aud");
        Intrinsics.checkNotNullParameter(nonce, "nonce");
        Intrinsics.checkNotNullParameter(sub, "sub");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AuthenticationTokenClaims(String jti, String iss, String aud, String nonce, long j3, long j4, String sub, String str, String str2, String str3, String str4) {
        this(jti, iss, aud, nonce, j3, j4, sub, str, str2, str3, str4, null, null, null, null, null, null, null, null, null, 1046528, null);
        Intrinsics.checkNotNullParameter(jti, "jti");
        Intrinsics.checkNotNullParameter(iss, "iss");
        Intrinsics.checkNotNullParameter(aud, "aud");
        Intrinsics.checkNotNullParameter(nonce, "nonce");
        Intrinsics.checkNotNullParameter(sub, "sub");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AuthenticationTokenClaims(String jti, String iss, String aud, String nonce, long j3, long j4, String sub, String str, String str2, String str3, String str4, String str5) {
        this(jti, iss, aud, nonce, j3, j4, sub, str, str2, str3, str4, str5, null, null, null, null, null, null, null, null, 1044480, null);
        Intrinsics.checkNotNullParameter(jti, "jti");
        Intrinsics.checkNotNullParameter(iss, "iss");
        Intrinsics.checkNotNullParameter(aud, "aud");
        Intrinsics.checkNotNullParameter(nonce, "nonce");
        Intrinsics.checkNotNullParameter(sub, "sub");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AuthenticationTokenClaims(String jti, String iss, String aud, String nonce, long j3, long j4, String sub, String str, String str2, String str3, String str4, String str5, String str6) {
        this(jti, iss, aud, nonce, j3, j4, sub, str, str2, str3, str4, str5, str6, null, null, null, null, null, null, null, 1040384, null);
        Intrinsics.checkNotNullParameter(jti, "jti");
        Intrinsics.checkNotNullParameter(iss, "iss");
        Intrinsics.checkNotNullParameter(aud, "aud");
        Intrinsics.checkNotNullParameter(nonce, "nonce");
        Intrinsics.checkNotNullParameter(sub, "sub");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AuthenticationTokenClaims(String jti, String iss, String aud, String nonce, long j3, long j4, String sub, String str, String str2, String str3, String str4, String str5, String str6, Collection<String> collection) {
        this(jti, iss, aud, nonce, j3, j4, sub, str, str2, str3, str4, str5, str6, collection, null, null, null, null, null, null, 1032192, null);
        Intrinsics.checkNotNullParameter(jti, "jti");
        Intrinsics.checkNotNullParameter(iss, "iss");
        Intrinsics.checkNotNullParameter(aud, "aud");
        Intrinsics.checkNotNullParameter(nonce, "nonce");
        Intrinsics.checkNotNullParameter(sub, "sub");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AuthenticationTokenClaims(String jti, String iss, String aud, String nonce, long j3, long j4, String sub, String str, String str2, String str3, String str4, String str5, String str6, Collection<String> collection, String str7) {
        this(jti, iss, aud, nonce, j3, j4, sub, str, str2, str3, str4, str5, str6, collection, str7, null, null, null, null, null, 1015808, null);
        Intrinsics.checkNotNullParameter(jti, "jti");
        Intrinsics.checkNotNullParameter(iss, "iss");
        Intrinsics.checkNotNullParameter(aud, "aud");
        Intrinsics.checkNotNullParameter(nonce, "nonce");
        Intrinsics.checkNotNullParameter(sub, "sub");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AuthenticationTokenClaims(String jti, String iss, String aud, String nonce, long j3, long j4, String sub, String str, String str2, String str3, String str4, String str5, String str6, Collection<String> collection, String str7, Map<String, Integer> map) {
        this(jti, iss, aud, nonce, j3, j4, sub, str, str2, str3, str4, str5, str6, collection, str7, map, null, null, null, null, 983040, null);
        Intrinsics.checkNotNullParameter(jti, "jti");
        Intrinsics.checkNotNullParameter(iss, "iss");
        Intrinsics.checkNotNullParameter(aud, "aud");
        Intrinsics.checkNotNullParameter(nonce, "nonce");
        Intrinsics.checkNotNullParameter(sub, "sub");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AuthenticationTokenClaims(String jti, String iss, String aud, String nonce, long j3, long j4, String sub, String str, String str2, String str3, String str4, String str5, String str6, Collection<String> collection, String str7, Map<String, Integer> map, Map<String, String> map2) {
        this(jti, iss, aud, nonce, j3, j4, sub, str, str2, str3, str4, str5, str6, collection, str7, map, map2, null, null, null, 917504, null);
        Intrinsics.checkNotNullParameter(jti, "jti");
        Intrinsics.checkNotNullParameter(iss, "iss");
        Intrinsics.checkNotNullParameter(aud, "aud");
        Intrinsics.checkNotNullParameter(nonce, "nonce");
        Intrinsics.checkNotNullParameter(sub, "sub");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AuthenticationTokenClaims(String jti, String iss, String aud, String nonce, long j3, long j4, String sub, String str, String str2, String str3, String str4, String str5, String str6, Collection<String> collection, String str7, Map<String, Integer> map, Map<String, String> map2, Map<String, String> map3) {
        this(jti, iss, aud, nonce, j3, j4, sub, str, str2, str3, str4, str5, str6, collection, str7, map, map2, map3, null, null, 786432, null);
        Intrinsics.checkNotNullParameter(jti, "jti");
        Intrinsics.checkNotNullParameter(iss, "iss");
        Intrinsics.checkNotNullParameter(aud, "aud");
        Intrinsics.checkNotNullParameter(nonce, "nonce");
        Intrinsics.checkNotNullParameter(sub, "sub");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AuthenticationTokenClaims(String jti, String iss, String aud, String nonce, long j3, long j4, String sub, String str, String str2, String str3, String str4, String str5, String str6, Collection<String> collection, String str7, Map<String, Integer> map, Map<String, String> map2, Map<String, String> map3, String str8) {
        this(jti, iss, aud, nonce, j3, j4, sub, str, str2, str3, str4, str5, str6, collection, str7, map, map2, map3, str8, null, 524288, null);
        Intrinsics.checkNotNullParameter(jti, "jti");
        Intrinsics.checkNotNullParameter(iss, "iss");
        Intrinsics.checkNotNullParameter(aud, "aud");
        Intrinsics.checkNotNullParameter(nonce, "nonce");
        Intrinsics.checkNotNullParameter(sub, "sub");
    }

    public AuthenticationTokenClaims(String encodedClaims, String expectedNonce) throws JSONException {
        Intrinsics.checkNotNullParameter(encodedClaims, "encodedClaims");
        Intrinsics.checkNotNullParameter(expectedNonce, "expectedNonce");
        Validate.notEmpty(encodedClaims, "encodedClaims");
        byte[] decodedBytes = Base64.decode(encodedClaims, 8);
        Intrinsics.checkNotNullExpressionValue(decodedBytes, "decodedBytes");
        JSONObject jSONObject = new JSONObject(new String(decodedBytes, Charsets.f140510b));
        if (isValidClaims(jSONObject, expectedNonce)) {
            String string = jSONObject.getString(JSON_KEY_JIT);
            Intrinsics.checkNotNullExpressionValue(string, "jsonObj.getString(JSON_KEY_JIT)");
            this.jti = string;
            String string2 = jSONObject.getString(JSON_KEY_ISS);
            Intrinsics.checkNotNullExpressionValue(string2, "jsonObj.getString(JSON_KEY_ISS)");
            this.iss = string2;
            String string3 = jSONObject.getString(JSON_KEY_AUD);
            Intrinsics.checkNotNullExpressionValue(string3, "jsonObj.getString(JSON_KEY_AUD)");
            this.aud = string3;
            String string4 = jSONObject.getString("nonce");
            Intrinsics.checkNotNullExpressionValue(string4, "jsonObj.getString(JSON_KEY_NONCE)");
            this.nonce = string4;
            this.exp = jSONObject.getLong(JSON_KEY_EXP);
            this.iat = jSONObject.getLong(JSON_KEY_IAT);
            String string5 = jSONObject.getString(JSON_KEY_SUB);
            Intrinsics.checkNotNullExpressionValue(string5, "jsonObj.getString(JSON_KEY_SUB)");
            this.sub = string5;
            Companion companion = Companion;
            this.name = companion.getNullableString$facebook_core_release(jSONObject, "name");
            this.givenName = companion.getNullableString$facebook_core_release(jSONObject, JSON_KEY_GIVEN_NAME);
            this.middleName = companion.getNullableString$facebook_core_release(jSONObject, "middle_name");
            this.familyName = companion.getNullableString$facebook_core_release(jSONObject, JSON_KEY_FAMILY_NAME);
            this.email = companion.getNullableString$facebook_core_release(jSONObject, JSON_KEY_EMAIL);
            this.picture = companion.getNullableString$facebook_core_release(jSONObject, "picture");
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(JSON_KEY_USER_FRIENDS);
            this.userFriends = jSONArrayOptJSONArray == null ? null : Collections.unmodifiableSet(Utility.jsonArrayToSet(jSONArrayOptJSONArray));
            this.userBirthday = companion.getNullableString$facebook_core_release(jSONObject, JSON_KEY_USER_BIRTHDAY);
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(JSON_KEY_USER_AGE_RANGE);
            this.userAgeRange = jSONObjectOptJSONObject == null ? null : Collections.unmodifiableMap(Utility.convertJSONObjectToHashMap(jSONObjectOptJSONObject));
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject(JSON_KEY_USER_HOMETOWN);
            this.userHometown = jSONObjectOptJSONObject2 == null ? null : Collections.unmodifiableMap(Utility.convertJSONObjectToStringMap(jSONObjectOptJSONObject2));
            JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject(JSON_KEY_USER_LOCATION);
            this.userLocation = jSONObjectOptJSONObject3 != null ? Collections.unmodifiableMap(Utility.convertJSONObjectToStringMap(jSONObjectOptJSONObject3)) : null;
            this.userGender = companion.getNullableString$facebook_core_release(jSONObject, JSON_KEY_USER_GENDER);
            this.userLink = companion.getNullableString$facebook_core_release(jSONObject, JSON_KEY_USER_LINK);
            return;
        }
        throw new IllegalArgumentException("Invalid claims");
    }

    public /* synthetic */ AuthenticationTokenClaims(String str, String str2, String str3, String str4, long j3, long j4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, Collection collection, String str12, Map map, Map map2, Map map3, String str13, String str14, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, j3, j4, str5, (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? null : str6, (i3 & Function.MAX_NARGS) != 0 ? null : str7, (i3 & 512) != 0 ? null : str8, (i3 & 1024) != 0 ? null : str9, (i3 & 2048) != 0 ? null : str10, (i3 & 4096) != 0 ? null : str11, (i3 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? null : collection, (i3 & 16384) != 0 ? null : str12, (32768 & i3) != 0 ? null : map, (65536 & i3) != 0 ? null : map2, (131072 & i3) != 0 ? null : map3, (262144 & i3) != 0 ? null : str13, (i3 & 524288) != 0 ? null : str14);
    }

    public AuthenticationTokenClaims(String jti, String iss, String aud, String nonce, long j3, long j4, String sub, String str, String str2, String str3, String str4, String str5, String str6, Collection<String> collection, String str7, Map<String, Integer> map, Map<String, String> map2, Map<String, String> map3, String str8, String str9) {
        Intrinsics.checkNotNullParameter(jti, "jti");
        Intrinsics.checkNotNullParameter(iss, "iss");
        Intrinsics.checkNotNullParameter(aud, "aud");
        Intrinsics.checkNotNullParameter(nonce, "nonce");
        Intrinsics.checkNotNullParameter(sub, "sub");
        Validate.notEmpty(jti, JSON_KEY_JIT);
        Validate.notEmpty(iss, JSON_KEY_ISS);
        Validate.notEmpty(aud, JSON_KEY_AUD);
        Validate.notEmpty(nonce, "nonce");
        Validate.notEmpty(sub, JSON_KEY_SUB);
        this.jti = jti;
        this.iss = iss;
        this.aud = aud;
        this.nonce = nonce;
        this.exp = j3;
        this.iat = j4;
        this.sub = sub;
        this.name = str;
        this.givenName = str2;
        this.middleName = str3;
        this.familyName = str4;
        this.email = str5;
        this.picture = str6;
        this.userFriends = collection != null ? Collections.unmodifiableSet(new HashSet(collection)) : null;
        this.userBirthday = str7;
        this.userAgeRange = map != null ? Collections.unmodifiableMap(new HashMap(map)) : null;
        this.userHometown = map2 != null ? Collections.unmodifiableMap(new HashMap(map2)) : null;
        this.userLocation = map3 != null ? Collections.unmodifiableMap(new HashMap(map3)) : null;
        this.userGender = str8;
        this.userLink = str9;
    }

    public AuthenticationTokenClaims(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.jti = Validate.notNullOrEmpty(parcel.readString(), JSON_KEY_JIT);
        this.iss = Validate.notNullOrEmpty(parcel.readString(), JSON_KEY_ISS);
        this.aud = Validate.notNullOrEmpty(parcel.readString(), JSON_KEY_AUD);
        this.nonce = Validate.notNullOrEmpty(parcel.readString(), "nonce");
        this.exp = parcel.readLong();
        this.iat = parcel.readLong();
        this.sub = Validate.notNullOrEmpty(parcel.readString(), JSON_KEY_SUB);
        this.name = parcel.readString();
        this.givenName = parcel.readString();
        this.middleName = parcel.readString();
        this.familyName = parcel.readString();
        this.email = parcel.readString();
        this.picture = parcel.readString();
        ArrayList<String> arrayListCreateStringArrayList = parcel.createStringArrayList();
        this.userFriends = arrayListCreateStringArrayList != null ? Collections.unmodifiableSet(new HashSet(arrayListCreateStringArrayList)) : null;
        this.userBirthday = parcel.readString();
        HashMap hashMap = parcel.readHashMap(IntCompanionObject.f140132a.getClass().getClassLoader());
        hashMap = hashMap == null ? null : hashMap;
        this.userAgeRange = hashMap != null ? Collections.unmodifiableMap(hashMap) : null;
        StringCompanionObject stringCompanionObject = StringCompanionObject.f140150a;
        HashMap hashMap2 = parcel.readHashMap(stringCompanionObject.getClass().getClassLoader());
        hashMap2 = hashMap2 == null ? null : hashMap2;
        this.userHometown = hashMap2 != null ? Collections.unmodifiableMap(hashMap2) : null;
        HashMap hashMap3 = parcel.readHashMap(stringCompanionObject.getClass().getClassLoader());
        hashMap3 = hashMap3 == null ? null : hashMap3;
        this.userLocation = hashMap3 != null ? Collections.unmodifiableMap(hashMap3) : null;
        this.userGender = parcel.readString();
        this.userLink = parcel.readString();
    }
}
