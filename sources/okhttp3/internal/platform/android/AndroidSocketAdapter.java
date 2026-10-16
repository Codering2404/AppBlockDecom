package okhttp3.internal.platform.android;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.net.ssl.SSLSocket;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import okhttp3.internal.platform.AndroidPlatform;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.platform.android.DeferredSocketAdapter;

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
public class AndroidSocketAdapter implements SocketAdapter {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Companion f144829f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final DeferredSocketAdapter.Factory f144830g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class f144831a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Method f144832b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Method f144833c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Method f144834d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Method f144835e;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final AndroidSocketAdapter b(Class cls) {
            Class superclass = cls;
            while (superclass != null && !Intrinsics.areEqual(superclass.getSimpleName(), "OpenSSLSocketImpl")) {
                superclass = superclass.getSuperclass();
                if (superclass == null) {
                    throw new AssertionError(Intrinsics.stringPlus("No OpenSSLSocketImpl superclass of socket of type ", cls));
                }
            }
            Intrinsics.checkNotNull(superclass);
            return new AndroidSocketAdapter(superclass);
        }

        public final DeferredSocketAdapter.Factory c(final String packageName) {
            Intrinsics.checkNotNullParameter(packageName, "packageName");
            return new DeferredSocketAdapter.Factory() { // from class: okhttp3.internal.platform.android.AndroidSocketAdapter$Companion$factory$1
                @Override // okhttp3.internal.platform.android.DeferredSocketAdapter.Factory
                public boolean b(SSLSocket sslSocket) {
                    Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
                    String name = sslSocket.getClass().getName();
                    Intrinsics.checkNotNullExpressionValue(name, "sslSocket.javaClass.name");
                    return StringsKt.U(name, Intrinsics.stringPlus(packageName, "."), false, 2, null);
                }

                @Override // okhttp3.internal.platform.android.DeferredSocketAdapter.Factory
                public SocketAdapter c(SSLSocket sslSocket) {
                    Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
                    return AndroidSocketAdapter.f144829f.b(sslSocket.getClass());
                }
            };
        }

        public final DeferredSocketAdapter.Factory d() {
            return AndroidSocketAdapter.f144830g;
        }

        private Companion() {
        }
    }

    static {
        Companion companion = new Companion(null);
        f144829f = companion;
        f144830g = companion.c("com.google.android.gms.org.conscrypt");
    }

    public AndroidSocketAdapter(Class sslSocketClass) throws NoSuchMethodException {
        Intrinsics.checkNotNullParameter(sslSocketClass, "sslSocketClass");
        this.f144831a = sslSocketClass;
        Method declaredMethod = sslSocketClass.getDeclaredMethod("setUseSessionTickets", Boolean.TYPE);
        Intrinsics.checkNotNullExpressionValue(declaredMethod, "sslSocketClass.getDeclar…:class.javaPrimitiveType)");
        this.f144832b = declaredMethod;
        this.f144833c = sslSocketClass.getMethod("setHostname", String.class);
        this.f144834d = sslSocketClass.getMethod("getAlpnSelectedProtocol", null);
        this.f144835e = sslSocketClass.getMethod("setAlpnProtocols", byte[].class);
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public boolean a() {
        return AndroidPlatform.f144791f.b();
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public boolean b(SSLSocket sslSocket) {
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        return this.f144831a.isInstance(sslSocket);
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public String c(SSLSocket sslSocket) {
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        if (!b(sslSocket)) {
            return null;
        }
        try {
            byte[] bArr = (byte[]) this.f144834d.invoke(sslSocket, null);
            if (bArr == null) {
                return null;
            }
            return new String(bArr, Charsets.f140510b);
        } catch (IllegalAccessException e3) {
            throw new AssertionError(e3);
        } catch (InvocationTargetException e4) {
            Throwable cause = e4.getCause();
            if ((cause instanceof NullPointerException) && Intrinsics.areEqual(((NullPointerException) cause).getMessage(), "ssl == null")) {
                return null;
            }
            throw new AssertionError(e4);
        }
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public void d(SSLSocket sslSocket, String str, List protocols) {
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        Intrinsics.checkNotNullParameter(protocols, "protocols");
        if (b(sslSocket)) {
            try {
                this.f144832b.invoke(sslSocket, Boolean.TRUE);
                if (str != null) {
                    this.f144833c.invoke(sslSocket, str);
                }
                this.f144835e.invoke(sslSocket, Platform.f144818a.c(protocols));
            } catch (IllegalAccessException e3) {
                throw new AssertionError(e3);
            } catch (InvocationTargetException e4) {
                throw new AssertionError(e4);
            }
        }
    }
}
