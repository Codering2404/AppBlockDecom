package androidx.media3.effect;

import android.util.JsonWriter;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.Util;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.UnmodifiableIterator;
import java.io.IOException;
import java.io.StringWriter;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import kotlinx.serialization.json.internal.OBeo.vgWWUoTKYyuC;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes2.dex */
public final class DebugTraceUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f42243a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ImmutableMap f42244b = ImmutableMap.a().g("TransformerInternal", ImmutableList.z("Start")).g("AssetLoader", ImmutableList.A("InputFormat", "OutputFormat")).g(vgWWUoTKYyuC.fWTvsubxZPysy, ImmutableList.E("InputFormat", "OutputFormat", "AcceptedInput", "ProducedOutput", "InputEnded", "OutputEnded")).g("AudioGraph", ImmutableList.A("RegisterNewInputStream", "OutputEnded")).g("AudioMixer", ImmutableList.B("RegisterNewInputStream", "OutputFormat", "ProducedOutput")).g("AudioEncoder", ImmutableList.E("InputFormat", "OutputFormat", "AcceptedInput", "ProducedOutput", "InputEnded", "OutputEnded")).g("VideoDecoder", ImmutableList.E("InputFormat", "OutputFormat", "AcceptedInput", "ProducedOutput", "InputEnded", "OutputEnded")).g("VideoFrameProcessor", ImmutableList.H("RegisterNewInputStream", "SurfaceTextureInput", "QueueFrame", "QueueBitmap", "QueueTexture", "RenderedToOutputSurface", "OutputTextureRendered", "ReceiveEndOfAllInput", "SignalEnded")).g("ExternalTextureManager", ImmutableList.A("SignalEOS", "SurfaceTextureTransformFix")).g("BitmapTextureManager", ImmutableList.z("SignalEOS")).g("TexIdTextureManager", ImmutableList.z("SignalEOS")).g("Compositor", ImmutableList.z("OutputTextureRendered")).g("VideoEncoder", ImmutableList.E("InputFormat", "OutputFormat", "AcceptedInput", "ProducedOutput", "InputEnded", "OutputEnded")).g("Muxer", ImmutableList.D("InputFormat", "CanWriteSample", "AcceptedInput", "InputEnded", "OutputEnded")).d();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Map f42245c = new LinkedHashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static long f42246d = Clock.f41485a.a();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Component {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Event {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    private static final class EventLog {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f42247a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f42248b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f42249c;

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(Util.J("%s@%dms", DebugTraceUtil.g(this.f42247a), Long.valueOf(this.f42248b)));
            sb.append(this.f42249c.isEmpty() ? "" : Util.J("(%s)", this.f42249c));
            return sb.toString();
        }

        private EventLog(long j3, long j4, String str) {
            this.f42247a = j3;
            this.f42248b = j4;
            this.f42249c = str;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    private static final class EventLogger {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List f42250a = new ArrayList(10);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Queue f42251b = new ArrayDeque(10);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f42252c = 0;

        public void a(EventLog eventLog) {
            if (this.f42250a.size() < 10) {
                this.f42250a.add(eventLog);
            } else {
                this.f42251b.add(eventLog);
                if (this.f42251b.size() > 10) {
                    this.f42251b.remove();
                }
            }
            this.f42252c++;
        }

        public void b(JsonWriter jsonWriter) throws IOException {
            jsonWriter.beginObject().name("count").value(this.f42252c).name("first").beginArray();
            Iterator it = this.f42250a.iterator();
            while (it.hasNext()) {
                jsonWriter.value(((EventLog) it.next()).toString());
            }
            jsonWriter.endArray();
            if (!this.f42251b.isEmpty()) {
                jsonWriter.name("last").beginArray();
                Iterator it2 = this.f42251b.iterator();
                while (it2.hasNext()) {
                    jsonWriter.value(((EventLog) it2.next()).toString());
                }
                jsonWriter.endArray();
            }
            jsonWriter.endObject();
        }
    }

    public static synchronized String b() {
        if (!f42243a) {
            return "\"Tracing disabled\"";
        }
        StringWriter stringWriter = new StringWriter();
        JsonWriter jsonWriter = new JsonWriter(stringWriter);
        try {
            jsonWriter.beginObject();
            UnmodifiableIterator it = f42244b.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                String str = (String) entry.getKey();
                List<String> list = (List) entry.getValue();
                jsonWriter.name(str);
                Map map = (Map) f42245c.get(str);
                jsonWriter.beginObject();
                for (String str2 : list) {
                    jsonWriter.name(str2);
                    if (map == null || !map.containsKey(str2)) {
                        jsonWriter.value("No events");
                    } else {
                        ((EventLogger) Assertions.e((EventLogger) map.get(str2))).b(jsonWriter);
                    }
                }
                jsonWriter.endObject();
            }
            jsonWriter.endObject();
            String string = stringWriter.toString();
            Util.o(jsonWriter);
            return string;
        } catch (IOException unused) {
            Util.o(jsonWriter);
            return "\"Error generating trace summary\"";
        } catch (Throwable th) {
            Util.o(jsonWriter);
            throw th;
        }
    }

    private static String c(boolean z2, boolean z3) {
        return z2 ? z3 ? "VideoDecoder" : "AudioDecoder" : z3 ? "VideoEncoder" : "AudioEncoder";
    }

    public static synchronized void d(boolean z2, boolean z3, String str, long j3, String str2, Object... objArr) {
        f(c(z2, z3), str, j3, str2, objArr);
    }

    public static synchronized void e(String str, String str2, long j3) {
        f(str, str2, j3, "", new Object[0]);
    }

    public static synchronized void f(String str, String str2, long j3, String str3, Object... objArr) {
        try {
            if (f42243a) {
                long jA = Clock.f41485a.a() - f42246d;
                Map map = f42245c;
                if (!map.containsKey(str)) {
                    map.put(str, new LinkedHashMap());
                }
                Map map2 = (Map) map.get(str);
                if (!map2.containsKey(str2)) {
                    map2.put(str2, new EventLogger());
                }
                ((EventLogger) map2.get(str2)).a(new EventLog(j3, jA, Util.J(str3, objArr)));
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String g(long j3) {
        if (j3 == -9223372036854775807L) {
            return "UNSET";
        }
        if (j3 == Long.MIN_VALUE) {
            return "EOS";
        }
        return j3 + "us";
    }

    public static synchronized void h() {
        f42245c.clear();
        f42246d = Clock.f41485a.a();
    }
}
