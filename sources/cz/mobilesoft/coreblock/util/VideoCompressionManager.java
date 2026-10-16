package cz.mobilesoft.coreblock.util;

import android.content.Context;
import android.database.Cursor;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import androidx.media3.common.MediaItem;
import androidx.media3.effect.FrameDropEffect;
import androidx.media3.effect.Presentation;
import androidx.media3.transformer.AudioEncoderSettings;
import androidx.media3.transformer.DefaultEncoderFactory;
import androidx.media3.transformer.EditedMediaItem;
import androidx.media3.transformer.Effects;
import androidx.media3.transformer.VideoEncoderSettings;
import com.facebook.internal.AnalyticsEvents;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class VideoCompressionManager {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f128087b = new Companion(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f128088c = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f128089a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public VideoCompressionManager(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f128089a = context;
    }

    private final int h(long j3, long j4, VideoProperties videoProperties) {
        double d3 = j3 / 1000.0d;
        int i3 = videoProperties.c() ? (int) ((((double) 128000) * d3) / ((double) 8)) : 0;
        if (d3 <= 0.0d) {
            return 1000000;
        }
        return (int) (((double) ((int) (((j4 - ((long) i3)) * ((long) 8)) / d3))) * 0.75d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final File i(Uri uri) {
        try {
            String strP = p(uri);
            String strM = m();
            return new File(this.f128089a.getCacheDir(), strP + "_" + strM + ".mp4");
        } catch (Exception unused) {
            return new File(this.f128089a.getCacheDir(), "compressed_video_" + UUID.randomUUID() + ".mp4");
        }
    }

    private final OutputResolution j(int i3, boolean z2) {
        if (i3 >= 2000000) {
            return z2 ? new OutputResolution(1280, 720) : new OutputResolution(720, 1280);
        }
        if (i3 >= 1000000) {
            return z2 ? new OutputResolution(854, 480) : new OutputResolution(480, 854);
        }
        if (i3 >= 400000) {
            return z2 ? new OutputResolution(640, 360) : new OutputResolution(360, 640);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final EditedMediaItem k(Uri uri, VideoProperties videoProperties, OutputVideoProperties outputVideoProperties) {
        Presentation presentationM = Presentation.m(outputVideoProperties.c().b(), outputVideoProperties.c().a(), 0);
        Intrinsics.checkNotNullExpressionValue(presentationM, "createForWidthAndHeight(...)");
        FrameDropEffect frameDropEffectK = videoProperties.b() > 30.0f ? FrameDropEffect.k(30.0f) : null;
        List listMutableListOf = CollectionsKt.mutableListOf(presentationM);
        if (frameDropEffectK != null) {
            listMutableListOf.add(frameDropEffectK);
        }
        EditedMediaItem editedMediaItemA = new EditedMediaItem.Builder(MediaItem.b(uri)).c(new Effects(CollectionsKt.emptyList(), listMutableListOf)).a();
        Intrinsics.checkNotNullExpressionValue(editedMediaItemA, "build(...)");
        return editedMediaItemA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DefaultEncoderFactory l(OutputVideoProperties outputVideoProperties) {
        DefaultEncoderFactory defaultEncoderFactoryG = new DefaultEncoderFactory.Builder(this.f128089a).i(new VideoEncoderSettings.Builder().c(outputVideoProperties.a()).a()).h(new AudioEncoderSettings.Builder().b(128000).a()).g();
        Intrinsics.checkNotNullExpressionValue(defaultEncoderFactoryG, "build(...)");
        return defaultEncoderFactoryG;
    }

    private final String m() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return simpleDateFormat.format(new Date()) + "_UTC";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float n(MediaMetadataRetriever mediaMetadataRetriever, long j3) {
        Integer numU;
        Float fS;
        String strExtractMetadata = mediaMetadataRetriever.extractMetadata(25);
        float fFloatValue = (strExtractMetadata == null || (fS = StringsKt.s(strExtractMetadata)) == null) ? 0.0f : fS.floatValue();
        if (fFloatValue == 0.0f) {
            String strExtractMetadata2 = mediaMetadataRetriever.extractMetadata(32);
            int iIntValue = (strExtractMetadata2 == null || (numU = StringsKt.u(strExtractMetadata2)) == null) ? 0 : numU.intValue();
            if (j3 > 0 && iIntValue > 0) {
                fFloatValue = (iIntValue * 1000.0f) / j3;
            }
        }
        if (fFloatValue == 0.0f) {
            return 30.0f;
        }
        return fFloatValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object o(Uri uri, Continuation continuation) {
        return BuildersKt.g(Dispatchers.b(), new VideoCompressionManager$getInputVideoProperties$2(this, uri, null), continuation);
    }

    private final String p(Uri uri) {
        int columnIndex;
        Cursor cursorQuery = this.f128089a.getContentResolver().query(uri, null, null, null, null);
        if (cursorQuery == null) {
            return AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_VIDEO;
        }
        try {
            if (!cursorQuery.moveToFirst() || (columnIndex = cursorQuery.getColumnIndex("_display_name")) == -1) {
                Unit unit = Unit.f139807a;
                CloseableKt.a(cursorQuery, null);
                return AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_VIDEO;
            }
            String string = cursorQuery.getString(columnIndex);
            Intrinsics.checkNotNull(string);
            String strReplace = new Regex("[^a-zA-Z0-9._-]").replace(string, "_");
            if (strReplace.length() > 100) {
                strReplace = strReplace.substring(0, 100);
                Intrinsics.checkNotNullExpressionValue(strReplace, "substring(...)");
            }
            String strR = FilesKt.r(new File(strReplace));
            CloseableKt.a(cursorQuery, null);
            return strR;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.a(cursorQuery, th);
                throw th2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final OutputVideoProperties q(VideoProperties videoProperties, long j3) {
        int iH = h(videoProperties.a(), j3, videoProperties);
        OutputResolution outputResolutionJ = j(iH, videoProperties.d());
        String str = r() ? "video/hevc" : "video/avc";
        if (outputResolutionJ == null) {
            return null;
        }
        return new OutputVideoProperties(iH, outputResolutionJ, str);
    }

    private final boolean r() {
        MediaCodecInfo[] codecInfos = new MediaCodecList(0).getCodecInfos();
        Intrinsics.checkNotNull(codecInfos);
        for (MediaCodecInfo mediaCodecInfo : codecInfos) {
            if (mediaCodecInfo.isEncoder()) {
                String[] supportedTypes = mediaCodecInfo.getSupportedTypes();
                Intrinsics.checkNotNull(supportedTypes);
                for (String str : supportedTypes) {
                    if (StringsKt.F(str, "video/hevc", true)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final Flow s(Uri inputVideoUri, long j3) {
        Intrinsics.checkNotNullParameter(inputVideoUri, "inputVideoUri");
        return FlowKt.f(new VideoCompressionManager$reduceVideoSize$1(this, inputVideoUri, j3, null));
    }
}
