package androidx.compose.ui.text.intl;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class Locale {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f29469b = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final java.util.Locale f29470a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Locale a() {
            return PlatformLocaleKt.a().b().d(0);
        }

        private Companion() {
        }
    }

    public Locale(java.util.Locale locale) {
        this.f29470a = locale;
    }

    public final String a() {
        return this.f29470a.getLanguage();
    }

    public final java.util.Locale b() {
        return this.f29470a;
    }

    public final String c() {
        return PlatformLocale_jvmKt.a(this.f29470a);
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Locale)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return Intrinsics.areEqual(c(), ((Locale) obj).c());
    }

    public int hashCode() {
        return c().hashCode();
    }

    public String toString() {
        return c();
    }

    public Locale(String str) {
        this(PlatformLocaleKt.a().a(str));
    }
}
