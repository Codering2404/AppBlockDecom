package cz.mobilesoft.coreblock.util;

import android.net.Uri;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.util.VideoCompressionManager$reduceVideoSize$1$outputFile$1", f = "VideoCompressionManager.kt", l = {}, m = "invokeSuspend", v = 1)
final class VideoCompressionManager$reduceVideoSize$1$outputFile$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super File>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f128108a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ VideoCompressionManager f128109b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Uri f128110c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    VideoCompressionManager$reduceVideoSize$1$outputFile$1(VideoCompressionManager videoCompressionManager, Uri uri, Continuation continuation) {
        super(2, continuation);
        this.f128109b = videoCompressionManager;
        this.f128110c = uri;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new VideoCompressionManager$reduceVideoSize$1$outputFile$1(this.f128109b, this.f128110c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.f();
        if (this.f128108a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        return this.f128109b.i(this.f128110c);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((VideoCompressionManager$reduceVideoSize$1$outputFile$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
