package androidx.compose.ui.text.googlefonts;

import java.util.List;
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
public final class GoogleFont {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f29289a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f29290b;

    public GoogleFont(String str, boolean z2) {
        this.f29289a = str;
        this.f29290b = z2;
        if (str.length() <= 0) {
            throw new IllegalArgumentException("name cannot be empty");
        }
    }

    public final boolean a() {
        return this.f29290b;
    }

    public final String b() {
        return this.f29289a;
    }

    public /* synthetic */ GoogleFont(String str, boolean z2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? true : z2);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Provider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f29291a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f29292b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final List f29293c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f29294d;

        private Provider(String str, String str2, List list, int i3) {
            this.f29291a = str;
            this.f29292b = str2;
            this.f29293c = list;
            this.f29294d = i3;
        }

        public final List a() {
            return this.f29293c;
        }

        public final int b() {
            return this.f29294d;
        }

        public final String c() {
            return this.f29291a;
        }

        public final String d() {
            return this.f29292b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Provider)) {
                return false;
            }
            Provider provider = (Provider) obj;
            return Intrinsics.areEqual(this.f29291a, provider.f29291a) && Intrinsics.areEqual(this.f29292b, provider.f29292b) && Intrinsics.areEqual(this.f29293c, provider.f29293c) && this.f29294d == provider.f29294d;
        }

        public int hashCode() {
            int iHashCode = ((this.f29291a.hashCode() * 31) + this.f29292b.hashCode()) * 31;
            List list = this.f29293c;
            return ((iHashCode + (list != null ? list.hashCode() : 0)) * 31) + this.f29294d;
        }

        public Provider(String str, String str2, int i3) {
            this(str, str2, null, i3);
        }
    }
}
