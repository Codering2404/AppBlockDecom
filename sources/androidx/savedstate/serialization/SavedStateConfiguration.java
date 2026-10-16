package androidx.savedstate.serialization;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.modules.SerializersModule;

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
public final class SavedStateConfiguration {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Companion f53050d = new Companion(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final SavedStateConfiguration f53051e = new SavedStateConfiguration(null, 0, false, 7, null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SerializersModule f53052a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f53053b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f53054c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Builder {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private SavedStateConfiguration(SerializersModule serializersModule, int i3, boolean z2) {
        this.f53052a = serializersModule;
        this.f53053b = i3;
        this.f53054c = z2;
    }

    public final int a() {
        return this.f53053b;
    }

    public final boolean b() {
        return this.f53054c;
    }

    public final SerializersModule c() {
        return this.f53052a;
    }

    /* synthetic */ SavedStateConfiguration(SerializersModule serializersModule, int i3, boolean z2, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? SavedStateConfigurationKt.f53055a : serializersModule, (i4 & 2) != 0 ? 2 : i3, (i4 & 4) != 0 ? false : z2);
    }
}
