package com.facebook.login;

import com.facebook.AccessToken;
import com.facebook.AuthenticationToken;
import java.util.Set;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class LoginResult {
    private final AccessToken accessToken;
    private final AuthenticationToken authenticationToken;
    private final Set<String> recentlyDeniedPermissions;
    private final Set<String> recentlyGrantedPermissions;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LoginResult(AccessToken accessToken, Set<String> recentlyGrantedPermissions, Set<String> recentlyDeniedPermissions) {
        this(accessToken, null, recentlyGrantedPermissions, recentlyDeniedPermissions, 2, null);
        Intrinsics.checkNotNullParameter(accessToken, "accessToken");
        Intrinsics.checkNotNullParameter(recentlyGrantedPermissions, "recentlyGrantedPermissions");
        Intrinsics.checkNotNullParameter(recentlyDeniedPermissions, "recentlyDeniedPermissions");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LoginResult copy$default(LoginResult loginResult, AccessToken accessToken, AuthenticationToken authenticationToken, Set set, Set set2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            accessToken = loginResult.accessToken;
        }
        if ((i3 & 2) != 0) {
            authenticationToken = loginResult.authenticationToken;
        }
        if ((i3 & 4) != 0) {
            set = loginResult.recentlyGrantedPermissions;
        }
        if ((i3 & 8) != 0) {
            set2 = loginResult.recentlyDeniedPermissions;
        }
        return loginResult.copy(accessToken, authenticationToken, set, set2);
    }

    public final AccessToken component1() {
        return this.accessToken;
    }

    public final AuthenticationToken component2() {
        return this.authenticationToken;
    }

    public final Set<String> component3() {
        return this.recentlyGrantedPermissions;
    }

    public final Set<String> component4() {
        return this.recentlyDeniedPermissions;
    }

    public final LoginResult copy(AccessToken accessToken, AuthenticationToken authenticationToken, Set<String> recentlyGrantedPermissions, Set<String> recentlyDeniedPermissions) {
        Intrinsics.checkNotNullParameter(accessToken, "accessToken");
        Intrinsics.checkNotNullParameter(recentlyGrantedPermissions, "recentlyGrantedPermissions");
        Intrinsics.checkNotNullParameter(recentlyDeniedPermissions, "recentlyDeniedPermissions");
        return new LoginResult(accessToken, authenticationToken, recentlyGrantedPermissions, recentlyDeniedPermissions);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LoginResult)) {
            return false;
        }
        LoginResult loginResult = (LoginResult) obj;
        return Intrinsics.areEqual(this.accessToken, loginResult.accessToken) && Intrinsics.areEqual(this.authenticationToken, loginResult.authenticationToken) && Intrinsics.areEqual(this.recentlyGrantedPermissions, loginResult.recentlyGrantedPermissions) && Intrinsics.areEqual(this.recentlyDeniedPermissions, loginResult.recentlyDeniedPermissions);
    }

    public final AccessToken getAccessToken() {
        return this.accessToken;
    }

    public final AuthenticationToken getAuthenticationToken() {
        return this.authenticationToken;
    }

    public final Set<String> getRecentlyDeniedPermissions() {
        return this.recentlyDeniedPermissions;
    }

    public final Set<String> getRecentlyGrantedPermissions() {
        return this.recentlyGrantedPermissions;
    }

    public int hashCode() {
        int iHashCode = this.accessToken.hashCode() * 31;
        AuthenticationToken authenticationToken = this.authenticationToken;
        return ((((iHashCode + (authenticationToken == null ? 0 : authenticationToken.hashCode())) * 31) + this.recentlyGrantedPermissions.hashCode()) * 31) + this.recentlyDeniedPermissions.hashCode();
    }

    public String toString() {
        return "LoginResult(accessToken=" + this.accessToken + ", authenticationToken=" + this.authenticationToken + ", recentlyGrantedPermissions=" + this.recentlyGrantedPermissions + ", recentlyDeniedPermissions=" + this.recentlyDeniedPermissions + ')';
    }

    public LoginResult(AccessToken accessToken, AuthenticationToken authenticationToken, Set<String> recentlyGrantedPermissions, Set<String> recentlyDeniedPermissions) {
        Intrinsics.checkNotNullParameter(accessToken, "accessToken");
        Intrinsics.checkNotNullParameter(recentlyGrantedPermissions, "recentlyGrantedPermissions");
        Intrinsics.checkNotNullParameter(recentlyDeniedPermissions, "recentlyDeniedPermissions");
        this.accessToken = accessToken;
        this.authenticationToken = authenticationToken;
        this.recentlyGrantedPermissions = recentlyGrantedPermissions;
        this.recentlyDeniedPermissions = recentlyDeniedPermissions;
    }

    public /* synthetic */ LoginResult(AccessToken accessToken, AuthenticationToken authenticationToken, Set set, Set set2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(accessToken, (i3 & 2) != 0 ? null : authenticationToken, set, set2);
    }
}
