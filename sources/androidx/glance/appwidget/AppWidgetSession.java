package androidx.glance.appwidget;

import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.os.Bundle;
import android.widget.RemoteViews;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.unit.DpSize;
import androidx.glance.session.Session;
import androidx.glance.state.ConfigManager;
import androidx.glance.state.GlanceState;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.flow.Flow;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class AppWidgetSession extends Session {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final Companion f37733k = new Companion(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final GlanceAppWidget f37734c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AppWidgetId f37735d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Bundle f37736e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ConfigManager f37737f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final MutableState f37738g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final MutableState f37739h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Map f37740i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private RemoteViews f37741j;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class RunLambda {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f37742a;

        public RunLambda(String str) {
            this.f37742a = str;
        }

        public final String a() {
            return this.f37742a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class UpdateAppWidgetOptions {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Bundle f37743a;

        public UpdateAppWidgetOptions(Bundle bundle) {
            this.f37743a = bundle;
        }

        public final Bundle a() {
            return this.f37743a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class UpdateGlanceState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final UpdateGlanceState f37744a = new UpdateGlanceState();

        private UpdateGlanceState() {
        }
    }

    public /* synthetic */ AppWidgetSession(GlanceAppWidget glanceAppWidget, AppWidgetId appWidgetId, Bundle bundle, ConfigManager configManager, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(glanceAppWidget, appWidgetId, (i3 & 4) != 0 ? null : bundle, (i3 & 8) != 0 ? GlanceState.f39700a : configManager);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:0|2|(2:4|(1:6)(1:7))(0)|8|(1:(1:(4:18|35|57|58)(1:(2:15|16)(3:17|52|53)))(1:19))(2:20|(2:22|23)(3:24|(1:27)|56))|28|60|29|(2:31|32)(2:38|39)|(2:(0)|(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00e5, code lost:
    
        if (r15.d(r4) == r5) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00f0, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0119, code lost:
    
        if (r6.f37734c.b() != 0) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x011b, code lost:
    
        androidx.glance.appwidget.AppWidgetUtilsKt.l(r0);
        r0 = new android.widget.RemoteViews(r12.getPackageName(), r6.f37734c.b());
        r2.updateAppWidget(r6.f37735d.a(), r0);
        r6.f37741j = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0138, code lost:
    
        r4.f37746a = null;
        r4.f37747b = null;
        r4.f37748c = null;
        r4.f37751g = 4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0144, code lost:
    
        if (r15.d(r4) == r5) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0147, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0149, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x014a, code lost:
    
        r4.f37746a = r0;
        r4.f37747b = null;
        r4.f37748c = null;
        r4.f37751g = 5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0156, code lost:
    
        if (r15.d(r4) != r5) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x015f, code lost:
    
        r4.f37746a = null;
        r4.f37747b = null;
        r4.f37748c = null;
        r4.f37751g = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x016b, code lost:
    
        if (r15.d(r4) != r5) goto L35;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    @Override // androidx.glance.session.Session
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object d(android.content.Context r21, androidx.glance.EmittableWithChildren r22, kotlin.coroutines.Continuation r23) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 371
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.glance.appwidget.AppWidgetSession.d(android.content.Context, androidx.glance.EmittableWithChildren, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:79:0x0160, code lost:
    
        if (r8.y(r9, r0) == r1) goto L80;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // androidx.glance.session.Session
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object e(android.content.Context r8, java.lang.Object r9, kotlin.coroutines.Continuation r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 390
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.glance.appwidget.AppWidgetSession.e(android.content.Context, java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // androidx.glance.session.Session
    public Function2 f(final Context context) {
        return ComposableLambdaKt.c(-1784282257, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.appwidget.AppWidgetSession$provideGlance$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Composer) obj, ((Number) obj2).intValue());
                return Unit.f139807a;
            }

            public final void invoke(Composer composer, int i3) {
                if ((i3 & 11) == 2 && composer.l()) {
                    composer.Q();
                    return;
                }
                if (ComposerKt.M()) {
                    ComposerKt.U(-1784282257, i3, -1, "androidx.glance.appwidget.AppWidgetSession.provideGlance.<anonymous> (AppWidgetSession.kt:83)");
                }
                ProvidedValue[] providedValueArr = {androidx.glance.CompositionLocalsKt.b().d(context), androidx.glance.CompositionLocalsKt.c().d(this.f37735d), CompositionLocalsKt.a().d(this.f37739h.getValue()), androidx.glance.CompositionLocalsKt.e().d(this.f37738g.getValue())};
                final Context context2 = context;
                final AppWidgetSession appWidgetSession = this;
                CompositionLocalKt.c(providedValueArr, ComposableLambdaKt.b(composer, 1688971311, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.appwidget.AppWidgetSession$provideGlance$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    private static final boolean c(State state) {
                        return ((Boolean) state.getValue()).booleanValue();
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.f139807a;
                    }

                    public final void invoke(Composer composer2, int i4) {
                        if ((i4 & 11) == 2 && composer2.l()) {
                            composer2.Q();
                            return;
                        }
                        if (ComposerKt.M()) {
                            ComposerKt.U(1688971311, i4, -1, "androidx.glance.appwidget.AppWidgetSession.provideGlance.<anonymous>.<anonymous> (AppWidgetSession.kt:89)");
                        }
                        Context context3 = context2;
                        composer2.F(-492369756);
                        Object objG = composer2.G();
                        Composer.Companion companion = Composer.f23746a;
                        if (objG == companion.a()) {
                            objG = AppWidgetUtilsKt.j(context3);
                            composer2.w(objG);
                        }
                        composer2.Y();
                        AppWidgetManager appWidgetManager = (AppWidgetManager) objG;
                        Context context4 = context2;
                        AppWidgetSession appWidgetSession2 = appWidgetSession;
                        composer2.F(-492369756);
                        Object objG2 = composer2.G();
                        if (objG2 == companion.a()) {
                            objG2 = DpSize.c(AppWidgetUtilsKt.a(context4.getResources().getDisplayMetrics(), appWidgetManager, appWidgetSession2.f37735d.a()));
                            composer2.w(objG2);
                        }
                        composer2.Y();
                        long jM = ((DpSize) objG2).m();
                        Unit unit = null;
                        State stateM = SnapshotStateKt.m(Boolean.FALSE, new AppWidgetSession$provideGlance$1$1$configIsReady$2(appWidgetSession, appWidgetManager, context2, null), composer2, 70);
                        AppWidgetSession appWidgetSession3 = appWidgetSession;
                        Context context5 = context2;
                        composer2.F(-492369756);
                        Object objG3 = composer2.G();
                        if (objG3 == companion.a()) {
                            objG3 = AppWidgetUtilsKt.m(appWidgetSession3.f37734c, context5, appWidgetSession3.f37735d);
                            composer2.w(objG3);
                        }
                        composer2.Y();
                        State stateA = SnapshotStateKt.a((Flow) objG3, null, null, composer2, 56, 2);
                        if (!c(stateM)) {
                            stateA = null;
                        }
                        Function2 function2 = stateA != null ? (Function2) stateA.getValue() : null;
                        composer2.F(-1186217115);
                        if (function2 != null) {
                            SizeBoxKt.a(appWidgetSession.f37734c.c(), jM, function2, composer2, 48);
                            unit = Unit.f139807a;
                        }
                        composer2.Y();
                        composer2.F(-1186217263);
                        if (unit == null) {
                            IgnoreResultKt.a(composer2, 0);
                        }
                        composer2.Y();
                        final AppWidgetSession appWidgetSession4 = appWidgetSession;
                        EffectsKt.j(new Function0<Unit>() { // from class: androidx.glance.appwidget.AppWidgetSession.provideGlance.1.1.4
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Object invoke() {
                                m345invoke();
                                return Unit.f139807a;
                            }

                            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                            public final void m345invoke() {
                                appWidgetSession4.f37738g.getValue();
                            }
                        }, composer2, 0);
                        if (ComposerKt.M()) {
                            ComposerKt.T();
                        }
                    }
                }), composer, 56);
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
            }
        });
    }

    @Override // androidx.glance.session.Session
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public RemoteViewsRoot b() {
        return new RemoteViewsRoot(50);
    }

    public final Object p(String str, Continuation continuation) {
        Object objH = h(new RunLambda(str), continuation);
        return objH == IntrinsicsKt.f() ? objH : Unit.f139807a;
    }

    public final Object q(Bundle bundle, Continuation continuation) {
        Object objH = h(new UpdateAppWidgetOptions(bundle), continuation);
        return objH == IntrinsicsKt.f() ? objH : Unit.f139807a;
    }

    public final Object r(Continuation continuation) {
        Object objH = h(UpdateGlanceState.f37744a, continuation);
        return objH == IntrinsicsKt.f() ? objH : Unit.f139807a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x005c, code lost:
    
        if (r7.v(r0) == r1) goto L21;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object s(kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r7 instanceof androidx.glance.appwidget.AppWidgetSession$waitForReady$1
            if (r0 == 0) goto L13
            r0 = r7
            androidx.glance.appwidget.AppWidgetSession$waitForReady$1 r0 = (androidx.glance.appwidget.AppWidgetSession$waitForReady$1) r0
            int r1 = r0.f37770d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f37770d = r1
            goto L18
        L13:
            androidx.glance.appwidget.AppWidgetSession$waitForReady$1 r0 = new androidx.glance.appwidget.AppWidgetSession$waitForReady$1
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.f37768b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f37770d
            r3 = 2
            r4 = 0
            r5 = 1
            if (r2 == 0) goto L3d
            if (r2 == r5) goto L35
            if (r2 != r3) goto L2d
            kotlin.ResultKt.b(r7)
            goto L5f
        L2d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L35:
            java.lang.Object r2 = r0.f37767a
            androidx.glance.appwidget.AppWidgetSession$WaitForReady r2 = (androidx.glance.appwidget.AppWidgetSession.WaitForReady) r2
            kotlin.ResultKt.b(r7)
            goto L50
        L3d:
            kotlin.ResultKt.b(r7)
            androidx.glance.appwidget.AppWidgetSession$WaitForReady r2 = new androidx.glance.appwidget.AppWidgetSession$WaitForReady
            r2.<init>(r4, r5, r4)
            r0.f37767a = r2
            r0.f37770d = r5
            java.lang.Object r7 = r6.h(r2, r0)
            if (r7 != r1) goto L50
            goto L5e
        L50:
            kotlinx.coroutines.channels.Channel r7 = r2.a()
            r0.f37767a = r4
            r0.f37770d = r3
            java.lang.Object r7 = r7.v(r0)
            if (r7 != r1) goto L5f
        L5e:
            return r1
        L5f:
            kotlin.Unit r7 = kotlin.Unit.f139807a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.glance.appwidget.AppWidgetSession.s(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class WaitForReady {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Channel f37745a;

        public WaitForReady(Channel channel) {
            this.f37745a = channel;
        }

        public final Channel a() {
            return this.f37745a;
        }

        public /* synthetic */ WaitForReady(Channel channel, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? ChannelKt.b(-1, null, null, 6, null) : channel);
        }
    }

    public AppWidgetSession(GlanceAppWidget glanceAppWidget, AppWidgetId appWidgetId, Bundle bundle, ConfigManager configManager) {
        super(AppWidgetUtilsKt.p(appWidgetId));
        this.f37734c = glanceAppWidget;
        this.f37735d = appWidgetId;
        this.f37736e = bundle;
        this.f37737f = configManager;
        this.f37738g = SnapshotStateKt.i(null, SnapshotStateKt.k());
        this.f37739h = SnapshotStateKt.i(new Bundle(), SnapshotStateKt.k());
        this.f37740i = MapsKt.emptyMap();
    }
}
