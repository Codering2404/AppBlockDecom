package cz.mobilesoft.coreblock.scene.more.signin;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.enums.SignInEntryPoint;
import java.io.Serializable;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class SignInConfig implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SignInEntryPoint f110370a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Long f110371b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f110372c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f110373d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f110374f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f110375g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f110376h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f110377i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final boolean f110378j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final boolean f110379k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final String f110380l;

    public SignInConfig(SignInEntryPoint entryPoint, Long l3, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, String str) {
        Intrinsics.checkNotNullParameter(entryPoint, "entryPoint");
        this.f110370a = entryPoint;
        this.f110371b = l3;
        this.f110372c = z2;
        this.f110373d = z3;
        this.f110374f = z4;
        this.f110375g = z5;
        this.f110376h = z6;
        this.f110377i = z7;
        this.f110378j = z8;
        this.f110379k = z9;
        this.f110380l = str;
    }

    public final boolean a() {
        return this.f110373d;
    }

    public final SignInEntryPoint b() {
        return this.f110370a;
    }

    public final String c() {
        return this.f110380l;
    }

    public final Long d() {
        return this.f110371b;
    }

    public final boolean e() {
        return this.f110376h;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SignInConfig)) {
            return false;
        }
        SignInConfig signInConfig = (SignInConfig) obj;
        return this.f110370a == signInConfig.f110370a && Intrinsics.areEqual(this.f110371b, signInConfig.f110371b) && this.f110372c == signInConfig.f110372c && this.f110373d == signInConfig.f110373d && this.f110374f == signInConfig.f110374f && this.f110375g == signInConfig.f110375g && this.f110376h == signInConfig.f110376h && this.f110377i == signInConfig.f110377i && this.f110378j == signInConfig.f110378j && this.f110379k == signInConfig.f110379k && Intrinsics.areEqual(this.f110380l, signInConfig.f110380l);
    }

    public final boolean f() {
        return this.f110375g;
    }

    public final boolean g() {
        return this.f110374f;
    }

    public final boolean h() {
        return this.f110378j;
    }

    public int hashCode() {
        int iHashCode = this.f110370a.hashCode() * 31;
        Long l3 = this.f110371b;
        int iHashCode2 = (((((((((((((((((iHashCode + (l3 == null ? 0 : l3.hashCode())) * 31) + Boolean.hashCode(this.f110372c)) * 31) + Boolean.hashCode(this.f110373d)) * 31) + Boolean.hashCode(this.f110374f)) * 31) + Boolean.hashCode(this.f110375g)) * 31) + Boolean.hashCode(this.f110376h)) * 31) + Boolean.hashCode(this.f110377i)) * 31) + Boolean.hashCode(this.f110378j)) * 31) + Boolean.hashCode(this.f110379k)) * 31;
        String str = this.f110380l;
        return iHashCode2 + (str != null ? str.hashCode() : 0);
    }

    public final boolean i() {
        return this.f110377i;
    }

    public final boolean j() {
        return this.f110372c;
    }

    public final boolean k() {
        return this.f110379k;
    }

    public String toString() {
        return "SignInConfig(entryPoint=" + this.f110370a + ", lessonId=" + this.f110371b + ", isAlreadyAMember=" + this.f110372c + ", continueWithoutAccount=" + this.f110373d + ", showCloseButton=" + this.f110374f + ", shouldRestorePurchase=" + this.f110375g + ", requiredSignIn=" + this.f110376h + ", signUpAfterPurchase=" + this.f110377i + ", showScreenProgressBar=" + this.f110378j + ", isOnboarding=" + this.f110379k + ", finishRegistrationEmail=" + this.f110380l + ")";
    }

    public /* synthetic */ SignInConfig(SignInEntryPoint signInEntryPoint, Long l3, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(signInEntryPoint, (i3 & 2) != 0 ? null : l3, (i3 & 4) != 0 ? false : z2, (i3 & 8) != 0 ? false : z3, (i3 & 16) != 0 ? false : z4, (i3 & 32) != 0 ? false : z5, (i3 & 64) != 0 ? false : z6, (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? false : z7, (i3 & Function.MAX_NARGS) != 0 ? false : z8, (i3 & 512) != 0 ? false : z9, (i3 & 1024) != 0 ? null : str);
    }
}
