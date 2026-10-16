package coil;

import android.graphics.Bitmap;
import coil.EventListener;
import coil.decode.DecodeResult;
import coil.decode.Decoder;
import coil.fetch.FetchResult;
import coil.fetch.Fetcher;
import coil.request.ErrorResult;
import coil.request.ImageRequest;
import coil.request.Options;
import coil.request.SuccessResult;
import coil.size.Size;
import coil.transition.Transition;
import kotlin.Metadata;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public interface EventListener extends ImageRequest.Listener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f55420a = Companion.f55422a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final EventListener f55421b = new EventListener() { // from class: coil.EventListener$Companion$NONE$1
    };

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f55422a = new Companion();

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DefaultImpls {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface Factory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Companion f55423a = Companion.f55425a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Factory f55424b = new Factory() { // from class: coil.a
            @Override // coil.EventListener.Factory
            public final EventListener a(ImageRequest imageRequest) {
                return EventListener.Factory.c(imageRequest);
            }
        };

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            static final /* synthetic */ Companion f55425a = new Companion();

            private Companion() {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        static EventListener c(ImageRequest imageRequest) {
            return EventListener.f55421b;
        }

        EventListener a(ImageRequest imageRequest);
    }

    @Override // coil.request.ImageRequest.Listener
    default void a(ImageRequest imageRequest) {
    }

    @Override // coil.request.ImageRequest.Listener
    default void b(ImageRequest imageRequest) {
    }

    default void r(ImageRequest imageRequest) {
    }

    @Override // coil.request.ImageRequest.Listener
    default void c(ImageRequest imageRequest, ErrorResult errorResult) {
    }

    @Override // coil.request.ImageRequest.Listener
    default void d(ImageRequest imageRequest, SuccessResult successResult) {
    }

    default void e(ImageRequest imageRequest, String str) {
    }

    default void g(ImageRequest imageRequest, Object obj) {
    }

    default void i(ImageRequest imageRequest, Object obj) {
    }

    default void k(ImageRequest imageRequest, Bitmap bitmap) {
    }

    default void l(ImageRequest imageRequest, Size size) {
    }

    default void m(ImageRequest imageRequest, Object obj) {
    }

    default void n(ImageRequest imageRequest, Transition transition) {
    }

    default void o(ImageRequest imageRequest, Bitmap bitmap) {
    }

    default void q(ImageRequest imageRequest, Transition transition) {
    }

    default void h(ImageRequest imageRequest, Fetcher fetcher, Options options) {
    }

    default void p(ImageRequest imageRequest, Decoder decoder, Options options) {
    }

    default void f(ImageRequest imageRequest, Fetcher fetcher, Options options, FetchResult fetchResult) {
    }

    default void j(ImageRequest imageRequest, Decoder decoder, Options options, DecodeResult decodeResult) {
    }
}
