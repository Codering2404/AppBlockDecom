package cz.mobilesoft.coreblock.rest.interceptor;

import android.content.Context;
import cz.mobilesoft.coreblock.BuildConfig;
import cz.mobilesoft.coreblock.rest.exception.NoConnectionException;
import cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager;
import cz.mobilesoft.coreblock.storage.sharedprefs.flowproperty.BlockingFlowProperty;
import cz.mobilesoft.coreblock.util.NetworkHelperKt;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Response;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class ConnectivityInterceptor implements Interceptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f98507a;

    public ConnectivityInterceptor(Context mContext) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        this.f98507a = mContext;
    }

    @Override // okhttp3.Interceptor
    public Response a(Interceptor.Chain chain) throws IOException {
        Intrinsics.checkNotNullParameter(chain, "chain");
        if (!NetworkHelperKt.b(this.f98507a)) {
            throw new NoConnectionException();
        }
        if (!BuildConfig.f95357b.booleanValue() || ((Boolean) new BlockingFlowProperty(PrefManager.f126839a.B0().o1()).b()).booleanValue()) {
            return chain.a(chain.l().i().b());
        }
        try {
            Thread.sleep(2000L);
            throw new IOException("Connection to server disabled by developer preferences!");
        } catch (InterruptedException e3) {
            e3.printStackTrace();
            throw new IOException("Connection to server disabled by developer preferences!");
        }
    }
}
