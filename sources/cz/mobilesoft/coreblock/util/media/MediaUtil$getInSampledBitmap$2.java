package cz.mobilesoft.coreblock.util.media;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal.Util;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.util.media.MediaUtil$getInSampledBitmap$2", f = "MediaUtil.kt", l = {}, m = "invokeSuspend", v = 1)
final class MediaUtil$getInSampledBitmap$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Bitmap>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f128858a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Context f128859b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Uri f128860c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ int f128861d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ int f128862f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ boolean f128863g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MediaUtil$getInSampledBitmap$2(Context context, Uri uri, int i3, int i4, boolean z2, Continuation continuation) {
        super(2, continuation);
        this.f128859b = context;
        this.f128860c = uri;
        this.f128861d = i3;
        this.f128862f = i4;
        this.f128863g = z2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new MediaUtil$getInSampledBitmap$2(this.f128859b, this.f128860c, this.f128861d, this.f128862f, this.f128863g, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.f();
        if (this.f128858a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        InputStream inputStreamOpenInputStream = this.f128859b.getContentResolver().openInputStream(this.f128860c);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        Bitmap.Config config = Bitmap.Config.RGB_565;
        options.inPreferredConfig = config;
        BitmapFactory.decodeStream(inputStreamOpenInputStream, null, options);
        if (inputStreamOpenInputStream != null) {
            Util.m(inputStreamOpenInputStream);
        }
        int i3 = options.outWidth;
        int i4 = options.outHeight;
        MediaUtil mediaUtil = MediaUtil.f128857a;
        int iD = mediaUtil.d(options, this.f128861d, this.f128862f);
        if (i3 <= 0 || i4 <= 0) {
            return null;
        }
        options.inJustDecodeBounds = false;
        options.inPreferredConfig = config;
        options.inSampleSize = iD;
        InputStream inputStreamOpenInputStream2 = this.f128859b.getContentResolver().openInputStream(this.f128860c);
        Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpenInputStream2, null, options);
        if (inputStreamOpenInputStream2 != null) {
            Util.m(inputStreamOpenInputStream2);
        }
        if (this.f128863g) {
            float fE = mediaUtil.e(this.f128859b, this.f128860c);
            if (fE > 0.0f) {
                return mediaUtil.i(bitmapDecodeStream, fE);
            }
        }
        return bitmapDecodeStream;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((MediaUtil$getInSampledBitmap$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
