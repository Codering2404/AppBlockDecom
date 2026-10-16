package androidx.media3.transformer;

import android.content.Context;
import android.hardware.DataSpace;
import android.media.metrics.EditingEndedEvent;
import android.media.metrics.EditingSession;
import android.media.metrics.MediaItemInfo;
import android.media.metrics.MediaMetricsManager;
import android.util.Size;
import android.util.SparseIntArray;
import androidx.media3.common.ColorInfo;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.analytics.u2;
import androidx.media3.transformer.ExportResult;
import com.facebook.ads.AdError;
import com.facebook.internal.NativeProtocol;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class EditingMetricsCollector {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final SparseIntArray f48114e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final SparseIntArray f48115f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final SparseIntArray f48116g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final SparseIntArray f48117h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f48118a = Clock.f41485a.a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f48119b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f48120c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final MetricsReporter f48121d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class DefaultMetricsReporter implements MetricsReporter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private EditingSession f48122a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f48123b;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static final class Factory implements MetricsReporter.Factory {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final Context f48124a;

            public Factory(Context context) {
                this.f48124a = context;
            }

            @Override // androidx.media3.transformer.EditingMetricsCollector.MetricsReporter.Factory
            public MetricsReporter create() {
                return new DefaultMetricsReporter(this.f48124a);
            }
        }

        @Override // java.lang.AutoCloseable
        public void close() {
            EditingSession editingSession = this.f48122a;
            if (editingSession != null) {
                editingSession.close();
                this.f48122a = null;
            }
        }

        @Override // androidx.media3.transformer.EditingMetricsCollector.MetricsReporter
        public void s2(EditingEndedEvent editingEndedEvent) {
            EditingSession editingSession;
            if (this.f48123b || (editingSession = this.f48122a) == null) {
                return;
            }
            editingSession.reportEditingEndedEvent(editingEndedEvent);
            this.f48123b = true;
        }

        private DefaultMetricsReporter(Context context) {
            MediaMetricsManager mediaMetricsManagerA = u2.a(context.getSystemService("media_metrics"));
            if (mediaMetricsManagerA != null) {
                this.f48122a = mediaMetricsManagerA.createEditingSession();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface MetricsReporter extends AutoCloseable {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public interface Factory {
            MetricsReporter create();
        }

        void s2(EditingEndedEvent editingEndedEvent);
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f48114e = sparseIntArray;
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        f48115f = sparseIntArray2;
        SparseIntArray sparseIntArray3 = new SparseIntArray();
        f48116g = sparseIntArray3;
        SparseIntArray sparseIntArray4 = new SparseIntArray();
        f48117h = sparseIntArray4;
        sparseIntArray.put(1000, 1);
        sparseIntArray.put(AdError.NO_FILL_ERROR_CODE, 2);
        sparseIntArray.put(AdError.SERVER_ERROR_CODE, 3);
        sparseIntArray.put(AdError.INTERNAL_ERROR_CODE, 4);
        sparseIntArray.put(AdError.CACHE_ERROR_CODE, 5);
        sparseIntArray.put(AdError.INTERNAL_ERROR_2003, 3);
        sparseIntArray.put(AdError.INTERNAL_ERROR_2004, 6);
        sparseIntArray.put(2005, 7);
        sparseIntArray.put(AdError.INTERNAL_ERROR_2006, 8);
        sparseIntArray.put(2007, 9);
        sparseIntArray.put(AdError.REMOTE_ADS_SERVICE_ERROR, 10);
        sparseIntArray.put(AdError.MEDIATION_ERROR_CODE, 11);
        sparseIntArray.put(3002, 12);
        sparseIntArray.put(3003, 13);
        sparseIntArray.put(4001, 14);
        sparseIntArray.put(4002, 15);
        sparseIntArray.put(4003, 16);
        sparseIntArray.put(5001, 17);
        sparseIntArray.put(AdError.MEDIAVIEW_MISSING_ERROR_CODE, 18);
        sparseIntArray.put(AdError.SHOW_CALLED_BEFORE_LOAD_ERROR_CODE, 19);
        sparseIntArray.put(AdError.LOAD_CALLED_WHILE_SHOWING_AD, 2);
        sparseIntArray2.put(-1, 0);
        sparseIntArray2.put(2, 131072);
        sparseIntArray2.put(1, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
        sparseIntArray2.put(6, 393216);
        sparseIntArray3.put(-1, 0);
        sparseIntArray3.put(2, 268435456);
        sparseIntArray3.put(1, 134217728);
        sparseIntArray4.put(-1, 0);
        sparseIntArray4.put(1, 4194304);
        sparseIntArray4.put(3, 12582912);
        sparseIntArray4.put(2, 8388608);
        sparseIntArray4.put(10, 16777216);
        sparseIntArray4.put(6, 29360128);
        sparseIntArray4.put(7, 33554432);
    }

    public EditingMetricsCollector(MetricsReporter metricsReporter, String str, String str2) {
        this.f48121d = metricsReporter;
        this.f48119b = str;
        this.f48120c = str2;
    }

    private EditingEndedEvent.Builder a(int i3) {
        EditingEndedEvent.Builder exporterName = f1.a(i3).setTimeSinceCreatedMillis(Clock.f41485a.a() - this.f48118a).setExporterName(this.f48119b);
        String str = this.f48120c;
        if (str != null) {
            exporterName.setMuxerName(str);
        }
        return exporterName;
    }

    private static long b(String str) {
        long j3 = MimeTypes.n(str) ? 4L : 0L;
        if (MimeTypes.q(str)) {
            j3 |= 2;
        }
        return MimeTypes.o(str) ? j3 | 1 : j3;
    }

    private static int c(int i3) {
        return f48114e.get(i3, 1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static List d(ImmutableList immutableList) {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < immutableList.size(); i3++) {
            ExportResult.ProcessedInput processedInput = (ExportResult.ProcessedInput) immutableList.get(i3);
            MediaItemInfo.Builder builderA = e1.a();
            builderA.setClipDurationMillis(Util.t1(processedInput.f48237b));
            String str = processedInput.f48241f;
            if (str != null) {
                builderA.addCodecName(str);
            }
            String str2 = processedInput.f48240e;
            if (str2 != null) {
                builderA.addCodecName(str2);
            }
            Format format = processedInput.f48239d;
            if (format != null) {
                String str3 = format.f40631n;
                if (str3 != null) {
                    builderA.setContainerMimeType(str3);
                }
                String str4 = format.f40632o;
                if (str4 != null) {
                    builderA.addSampleMimeType(str4);
                    builderA.addDataType(b(format.f40632o));
                }
                float f3 = format.f40641x;
                if (f3 != -1.0f) {
                    builderA.setVideoFrameRate(f3);
                }
                int i4 = format.f40639v;
                if (i4 == -1) {
                    i4 = -1;
                }
                int i5 = format.f40640w;
                if (i5 == -1) {
                    i5 = -1;
                }
                builderA.setVideoSize(new Size(i4, i5));
                ColorInfo colorInfo = format.C;
                if (colorInfo != null) {
                    builderA.setVideoDataSpace(f(colorInfo));
                }
            }
            Format format2 = processedInput.f48238c;
            if (format2 != null) {
                String str5 = format2.f40632o;
                if (str5 != null) {
                    builderA.addSampleMimeType(str5);
                    builderA.addDataType(b(format2.f40632o));
                }
                int i6 = format2.E;
                if (i6 != -1) {
                    builderA.setAudioChannelCount(i6);
                }
                int i7 = format2.F;
                if (i7 != -1) {
                    builderA.setAudioSampleRateHz(i7);
                }
            }
            arrayList.add(builderA.build());
        }
        return arrayList;
    }

    private static MediaItemInfo e(ExportResult exportResult) {
        MediaItemInfo.Builder builderA = e1.a();
        long j3 = exportResult.f48200a;
        if (j3 != -9223372036854775807L) {
            builderA.setDurationMillis(j3);
        }
        String str = exportResult.f48206g;
        if (str != null) {
            builderA.addSampleMimeType(str);
            builderA.addDataType(b(exportResult.f48206g));
        }
        String str2 = exportResult.f48213n;
        if (str2 != null) {
            builderA.addSampleMimeType(str2);
            builderA.addDataType(b(exportResult.f48213n));
        }
        int i3 = exportResult.f48203d;
        if (i3 != -1) {
            builderA.setAudioChannelCount(i3);
        }
        int i4 = exportResult.f48204e;
        if (i4 != -2147483647) {
            builderA.setAudioSampleRateHz(i4);
        }
        String str3 = exportResult.f48205f;
        if (str3 != null) {
            builderA.addCodecName(str3);
        }
        String str4 = exportResult.f48212m;
        if (str4 != null) {
            builderA.addCodecName(str4);
        }
        builderA.setVideoSampleCount(exportResult.f48211l);
        int i5 = exportResult.f48210k;
        if (i5 == -1) {
            i5 = -1;
        }
        int i6 = exportResult.f48209j;
        builderA.setVideoSize(new Size(i5, i6 != -1 ? i6 : -1));
        ColorInfo colorInfo = exportResult.f48208i;
        if (colorInfo != null) {
            builderA.setVideoDataSpace(f(colorInfo));
        }
        return builderA.build();
    }

    private static int f(ColorInfo colorInfo) {
        return DataSpace.pack(f48115f.get(colorInfo.f40554a, 0), f48117h.get(colorInfo.f40556c, 0), f48116g.get(colorInfo.f40555b, 0));
    }

    public void g(int i3) {
        EditingEndedEvent.Builder builderA = a(2);
        if (i3 != -1) {
            builderA.setFinalProgressPercent(i3);
        }
        this.f48121d.s2(builderA.build());
        try {
            f.a.a(this.f48121d);
        } catch (Exception e3) {
            Log.e("EditingMetricsCollector", "error while closing the metrics reporter", e3);
        }
    }

    public void h(int i3, ExportException exportException, ExportResult exportResult) {
        EditingEndedEvent.Builder errorCode = a(3).setErrorCode(c(exportException.f48193a));
        if (i3 != -1) {
            errorCode.setFinalProgressPercent(i3);
        }
        List listD = d(exportResult.f48218s);
        for (int i4 = 0; i4 < listD.size(); i4++) {
            errorCode.addInputMediaItemInfo(a1.a(listD.get(i4)));
        }
        errorCode.setOutputMediaItemInfo(e(exportResult));
        this.f48121d.s2(errorCode.build());
        try {
            f.a.a(this.f48121d);
        } catch (Exception e3) {
            Log.e("EditingMetricsCollector", "error while closing the metrics reporter", e3);
        }
    }

    public void i(ExportResult exportResult) {
        EditingEndedEvent.Builder finalProgressPercent = a(1).setFinalProgressPercent(100.0f);
        List listD = d(exportResult.f48218s);
        for (int i3 = 0; i3 < listD.size(); i3++) {
            finalProgressPercent.addInputMediaItemInfo(a1.a(listD.get(i3)));
        }
        finalProgressPercent.setOutputMediaItemInfo(e(exportResult));
        this.f48121d.s2(finalProgressPercent.build());
        try {
            f.a.a(this.f48121d);
        } catch (Exception e3) {
            Log.e("EditingMetricsCollector", "error while closing the metrics reporter", e3);
        }
    }
}
