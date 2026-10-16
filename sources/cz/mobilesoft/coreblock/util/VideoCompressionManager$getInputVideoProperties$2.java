package cz.mobilesoft.coreblock.util;

import android.media.MediaMetadataRetriever;
import android.net.Uri;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.util.VideoCompressionManager$getInputVideoProperties$2", f = "VideoCompressionManager.kt", l = {}, m = "invokeSuspend", v = 1)
final class VideoCompressionManager$getInputVideoProperties$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super VideoProperties>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f128090a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ VideoCompressionManager f128091b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Uri f128092c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    VideoCompressionManager$getInputVideoProperties$2(VideoCompressionManager videoCompressionManager, Uri uri, Continuation continuation) {
        super(2, continuation);
        this.f128091b = videoCompressionManager;
        this.f128092c = uri;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new VideoCompressionManager$getInputVideoProperties$2(this.f128091b, this.f128092c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Long lW;
        Integer numU;
        Integer numU2;
        IntrinsicsKt.f();
        if (this.f128090a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        VideoProperties videoProperties = null;
        try {
            try {
                mediaMetadataRetriever.setDataSource(this.f128091b.f128089a, this.f128092c);
                String strExtractMetadata = mediaMetadataRetriever.extractMetadata(18);
                int iIntValue = (strExtractMetadata == null || (numU2 = StringsKt.u(strExtractMetadata)) == null) ? 0 : numU2.intValue();
                String strExtractMetadata2 = mediaMetadataRetriever.extractMetadata(19);
                int iIntValue2 = (strExtractMetadata2 == null || (numU = StringsKt.u(strExtractMetadata2)) == null) ? 0 : numU.intValue();
                String strExtractMetadata3 = mediaMetadataRetriever.extractMetadata(9);
                long jLongValue = (strExtractMetadata3 == null || (lW = StringsKt.w(strExtractMetadata3)) == null) ? 0L : lW.longValue();
                boolean zAreEqual = Intrinsics.areEqual(mediaMetadataRetriever.extractMetadata(16), "yes");
                float fN = this.f128091b.n(mediaMetadataRetriever, jLongValue);
                boolean z2 = iIntValue > iIntValue2;
                if (iIntValue != 0 && iIntValue2 != 0 && jLongValue != 0) {
                    videoProperties = new VideoProperties(iIntValue, iIntValue2, jLongValue, fN, z2, zAreEqual);
                }
                return videoProperties;
            } catch (Exception e3) {
                CrashHelper.j(e3);
                mediaMetadataRetriever.release();
                return null;
            }
        } finally {
            mediaMetadataRetriever.release();
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((VideoCompressionManager$getInputVideoProperties$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
