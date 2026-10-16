package cz.mobilesoft.coreblock.util.profile;

import kotlin.Metadata;
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
public final class ProfileDescription {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f129247a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f129248b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f129249c;

    public ProfileDescription(String str, String str2, String str3) {
        this.f129247a = str;
        this.f129248b = str2;
        this.f129249c = str3;
    }

    public static /* synthetic */ ProfileDescription b(ProfileDescription profileDescription, String str, String str2, String str3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = profileDescription.f129247a;
        }
        if ((i3 & 2) != 0) {
            str2 = profileDescription.f129248b;
        }
        if ((i3 & 4) != 0) {
            str3 = profileDescription.f129249c;
        }
        return profileDescription.a(str, str2, str3);
    }

    public final ProfileDescription a(String str, String str2, String str3) {
        return new ProfileDescription(str, str2, str3);
    }

    public final String c() {
        return this.f129248b;
    }

    public final String d() {
        return this.f129249c;
    }

    public final String e() {
        return this.f129247a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProfileDescription)) {
            return false;
        }
        ProfileDescription profileDescription = (ProfileDescription) obj;
        return Intrinsics.areEqual(this.f129247a, profileDescription.f129247a) && Intrinsics.areEqual(this.f129248b, profileDescription.f129248b) && Intrinsics.areEqual(this.f129249c, profileDescription.f129249c);
    }

    public int hashCode() {
        String str = this.f129247a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f129248b;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f129249c;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "ProfileDescription(stateTitle=" + this.f129247a + ", stateFirstLine=" + this.f129248b + ", stateSecondLine=" + this.f129249c + ")";
    }
}
