package cz.mobilesoft.coreblock.storage.room.entity.core;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class TokenFCMEntity {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Companion f126616c = new Companion(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f126617d = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f126618a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f126619b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public TokenFCMEntity(String token, boolean z2) {
        Intrinsics.checkNotNullParameter(token, "token");
        this.f126618a = token;
        this.f126619b = z2;
    }

    public final String a() {
        return this.f126618a;
    }

    public final boolean b() {
        return this.f126619b;
    }

    public final void c(boolean z2) {
        this.f126619b = z2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TokenFCMEntity)) {
            return false;
        }
        TokenFCMEntity tokenFCMEntity = (TokenFCMEntity) obj;
        return Intrinsics.areEqual(this.f126618a, tokenFCMEntity.f126618a) && this.f126619b == tokenFCMEntity.f126619b;
    }

    public int hashCode() {
        return (this.f126618a.hashCode() * 31) + Boolean.hashCode(this.f126619b);
    }

    public String toString() {
        return "TokenFCMEntity(token=" + this.f126618a + ", isSyncedWithServer=" + this.f126619b + ")";
    }

    public /* synthetic */ TokenFCMEntity(String str, boolean z2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? false : z2);
    }
}
