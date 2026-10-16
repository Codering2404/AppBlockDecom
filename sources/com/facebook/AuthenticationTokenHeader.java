package com.facebook;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import com.facebook.internal.Validate;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
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
public final class AuthenticationTokenHeader implements Parcelable {
    public final String alg;
    public final String kid;
    public final String typ;
    public static final Companion Companion = new Companion(null);
    public static final Parcelable.Creator<AuthenticationTokenHeader> CREATOR = new Parcelable.Creator<AuthenticationTokenHeader>() { // from class: com.facebook.AuthenticationTokenHeader$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AuthenticationTokenHeader createFromParcel(Parcel source) {
            Intrinsics.checkNotNullParameter(source, "source");
            return new AuthenticationTokenHeader(source);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AuthenticationTokenHeader[] newArray(int i3) {
            return new AuthenticationTokenHeader[i3];
        }
    };

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public AuthenticationTokenHeader(String encodedHeaderString) throws JSONException {
        Intrinsics.checkNotNullParameter(encodedHeaderString, "encodedHeaderString");
        if (!isValidHeader(encodedHeaderString)) {
            throw new IllegalArgumentException("Invalid Header");
        }
        byte[] decodedBytes = Base64.decode(encodedHeaderString, 0);
        Intrinsics.checkNotNullExpressionValue(decodedBytes, "decodedBytes");
        JSONObject jSONObject = new JSONObject(new String(decodedBytes, Charsets.f140510b));
        String string = jSONObject.getString("alg");
        Intrinsics.checkNotNullExpressionValue(string, "jsonObj.getString(\"alg\")");
        this.alg = string;
        String string2 = jSONObject.getString("typ");
        Intrinsics.checkNotNullExpressionValue(string2, "jsonObj.getString(\"typ\")");
        this.typ = string2;
        String string3 = jSONObject.getString("kid");
        Intrinsics.checkNotNullExpressionValue(string3, "jsonObj.getString(\"kid\")");
        this.kid = string3;
    }

    private final boolean isValidHeader(String str) {
        boolean z2;
        boolean z3;
        String strOptString;
        Validate.notEmpty(str, "encodedHeaderString");
        byte[] decodedBytes = Base64.decode(str, 0);
        Intrinsics.checkNotNullExpressionValue(decodedBytes, "decodedBytes");
        try {
            JSONObject jSONObject = new JSONObject(new String(decodedBytes, Charsets.f140510b));
            String alg = jSONObject.optString("alg");
            Intrinsics.checkNotNullExpressionValue(alg, "alg");
            z2 = alg.length() > 0 && Intrinsics.areEqual(alg, "RS256");
            String strOptString2 = jSONObject.optString("kid");
            Intrinsics.checkNotNullExpressionValue(strOptString2, "jsonObj.optString(\"kid\")");
            z3 = strOptString2.length() > 0;
            strOptString = jSONObject.optString("typ");
            Intrinsics.checkNotNullExpressionValue(strOptString, "jsonObj.optString(\"typ\")");
        } catch (JSONException unused) {
        }
        return z2 && z3 && (strOptString.length() > 0);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AuthenticationTokenHeader)) {
            return false;
        }
        AuthenticationTokenHeader authenticationTokenHeader = (AuthenticationTokenHeader) obj;
        return Intrinsics.areEqual(this.alg, authenticationTokenHeader.alg) && Intrinsics.areEqual(this.typ, authenticationTokenHeader.typ) && Intrinsics.areEqual(this.kid, authenticationTokenHeader.kid);
    }

    public final String getAlg() {
        return this.alg;
    }

    public final String getKid() {
        return this.kid;
    }

    public final String getTyp() {
        return this.typ;
    }

    public int hashCode() {
        return ((((527 + this.alg.hashCode()) * 31) + this.typ.hashCode()) * 31) + this.kid.hashCode();
    }

    public final String toEnCodedString() {
        byte[] bytes = toString().getBytes(Charsets.f140510b);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        String strEncodeToString = Base64.encodeToString(bytes, 0);
        Intrinsics.checkNotNullExpressionValue(strEncodeToString, "encodeToString(claimsJso…eArray(), Base64.DEFAULT)");
        return strEncodeToString;
    }

    public final JSONObject toJSONObject$facebook_core_release() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("alg", this.alg);
        jSONObject.put("typ", this.typ);
        jSONObject.put("kid", this.kid);
        return jSONObject;
    }

    public String toString() {
        String string = toJSONObject$facebook_core_release().toString();
        Intrinsics.checkNotNullExpressionValue(string, "headerJsonObject.toString()");
        return string;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int i3) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.alg);
        dest.writeString(this.typ);
        dest.writeString(this.kid);
    }

    public AuthenticationTokenHeader(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.alg = Validate.notNullOrEmpty(parcel.readString(), "alg");
        this.typ = Validate.notNullOrEmpty(parcel.readString(), "typ");
        this.kid = Validate.notNullOrEmpty(parcel.readString(), "kid");
    }

    public AuthenticationTokenHeader(JSONObject jsonObject) throws JSONException {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        String string = jsonObject.getString("alg");
        Intrinsics.checkNotNullExpressionValue(string, "jsonObject.getString(\"alg\")");
        this.alg = string;
        String string2 = jsonObject.getString("typ");
        Intrinsics.checkNotNullExpressionValue(string2, "jsonObject.getString(\"typ\")");
        this.typ = string2;
        String string3 = jsonObject.getString("kid");
        Intrinsics.checkNotNullExpressionValue(string3, "jsonObject.getString(\"kid\")");
        this.kid = string3;
    }

    public AuthenticationTokenHeader(String alg, String typ, String kid) {
        Intrinsics.checkNotNullParameter(alg, "alg");
        Intrinsics.checkNotNullParameter(typ, "typ");
        Intrinsics.checkNotNullParameter(kid, "kid");
        this.alg = alg;
        this.typ = typ;
        this.kid = kid;
    }
}
