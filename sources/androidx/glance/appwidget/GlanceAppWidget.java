package androidx.glance.appwidget;

import android.content.Context;
import android.os.Bundle;
import androidx.glance.GlanceId;
import androidx.glance.appwidget.SizeMode;
import androidx.glance.session.SessionManager;
import androidx.glance.session.SessionManagerKt;
import androidx.glance.state.GlanceStateDefinition;
import androidx.glance.state.PreferencesGlanceStateDefinition;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public abstract class GlanceAppWidget {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f37928e = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f37929a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SessionManager f37930b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final SizeMode f37931c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final GlanceStateDefinition f37932d;

    public GlanceAppWidget(int i3) {
        this.f37929a = i3;
        this.f37930b = SessionManagerKt.a();
        this.f37931c = SizeMode.Single.f38453a;
        this.f37932d = PreferencesGlanceStateDefinition.f39725a;
    }

    static /* synthetic */ Object f(GlanceAppWidget glanceAppWidget, Context context, GlanceId glanceId, Continuation continuation) {
        return Unit.f139807a;
    }

    public static /* synthetic */ Object j(GlanceAppWidget glanceAppWidget, Context context, int i3, String str, Bundle bundle, Continuation continuation, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: triggerAction");
        }
        if ((i4 & 8) != 0) {
            bundle = null;
        }
        return glanceAppWidget.i(context, i3, str, bundle, continuation);
    }

    public static /* synthetic */ Object m(GlanceAppWidget glanceAppWidget, Context context, int i3, Bundle bundle, Continuation continuation, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: update");
        }
        if ((i4 & 4) != 0) {
            bundle = null;
        }
        return glanceAppWidget.l(context, i3, bundle, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00af, code lost:
    
        if (r2.c(r9, r10, r8, r0) == r1) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00dc, code lost:
    
        if (r2.c(r9, r10, r8, r0) == r1) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0118, code lost:
    
        if (r2.c(r9, r10, r8, r0) == r1) goto L55;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(android.content.Context r8, int r9, kotlin.coroutines.Continuation r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 304
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.glance.appwidget.GlanceAppWidget.a(android.content.Context, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final int b() {
        return this.f37929a;
    }

    public SizeMode c() {
        return this.f37931c;
    }

    public GlanceStateDefinition d() {
        return this.f37932d;
    }

    public Object e(Context context, GlanceId glanceId, Continuation continuation) {
        return f(this, context, glanceId, continuation);
    }

    public abstract Object g(Context context, GlanceId glanceId, Continuation continuation);

    /* JADX WARN: Code restructure failed: missing block: B:32:0x00b5, code lost:
    
        if (r0.c(r14, r6, r1) == r2) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00da, code lost:
    
        if (((androidx.glance.appwidget.AppWidgetSession) r14).q(r9, r1) == r2) goto L38;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object h(android.content.Context r14, int r15, android.os.Bundle r16, kotlin.coroutines.Continuation r17) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 227
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.glance.appwidget.GlanceAppWidget.h(android.content.Context, int, android.os.Bundle, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00e1, code lost:
    
        if (r1.p(r11, r3) == r4) goto L32;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object i(android.content.Context r20, int r21, java.lang.String r22, android.os.Bundle r23, kotlin.coroutines.Continuation r24) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 231
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.glance.appwidget.GlanceAppWidget.i(android.content.Context, int, java.lang.String, android.os.Bundle, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object k(Context context, GlanceId glanceId, Continuation continuation) {
        if (!(glanceId instanceof AppWidgetId)) {
            throw new IllegalArgumentException("Invalid Glance ID");
        }
        Object objM = m(this, context, ((AppWidgetId) glanceId).a(), null, continuation, 4, null);
        return objM == IntrinsicsKt.f() ? objM : Unit.f139807a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x00a2, code lost:
    
        if (r0.c(r14, r6, r1) == r2) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00c7, code lost:
    
        if (((androidx.glance.appwidget.AppWidgetSession) r14).r(r1) == r2) goto L31;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object l(android.content.Context r14, int r15, android.os.Bundle r16, kotlin.coroutines.Continuation r17) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 205
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.glance.appwidget.GlanceAppWidget.l(android.content.Context, int, android.os.Bundle, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public /* synthetic */ GlanceAppWidget(int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? R.layout.l3 : i3);
    }
}
