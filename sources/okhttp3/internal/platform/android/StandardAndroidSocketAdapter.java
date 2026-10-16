package okhttp3.internal.platform.android;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.platform.Platform;

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
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public final class StandardAndroidSocketAdapter extends AndroidSocketAdapter {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Companion f144847j = new Companion(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Class f144848h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Class f144849i;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ SocketAdapter b(Companion companion, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = "com.android.org.conscrypt";
            }
            return companion.a(str);
        }

        public final SocketAdapter a(String packageName) {
            Intrinsics.checkNotNullParameter(packageName, "packageName");
            try {
                Class<?> cls = Class.forName(Intrinsics.stringPlus(packageName, ".OpenSSLSocketImpl"));
                Class<?> cls2 = Class.forName(Intrinsics.stringPlus(packageName, ".OpenSSLSocketFactoryImpl"));
                Class<?> paramsClass = Class.forName(Intrinsics.stringPlus(packageName, ".SSLParametersImpl"));
                Intrinsics.checkNotNullExpressionValue(paramsClass, "paramsClass");
                return new StandardAndroidSocketAdapter(cls, cls2, paramsClass);
            } catch (Exception e3) {
                Platform.f144818a.g().k("unable to load android socket classes", 5, e3);
                return null;
            }
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StandardAndroidSocketAdapter(Class sslSocketClass, Class sslSocketFactoryClass, Class paramClass) {
        super(sslSocketClass);
        Intrinsics.checkNotNullParameter(sslSocketClass, "sslSocketClass");
        Intrinsics.checkNotNullParameter(sslSocketFactoryClass, "sslSocketFactoryClass");
        Intrinsics.checkNotNullParameter(paramClass, "paramClass");
        this.f144848h = sslSocketFactoryClass;
        this.f144849i = paramClass;
    }
}
