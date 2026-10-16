package androidx.glance.appwidget;

import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.BuildersKt__BuildersKt;

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
public final class GlanceRemoteViewsService extends RemoteViewsService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f38071a = new Companion(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final RemoteCollectionItemsInMemoryStore f38072b = new RemoteCollectionItemsInMemoryStore();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final RemoteCollectionItems c(int i3, int i4, String str) {
            RemoteCollectionItems remoteCollectionItemsA;
            synchronized (GlanceRemoteViewsService.f38072b) {
                remoteCollectionItemsA = GlanceRemoteViewsService.f38072b.a(i3, i4, str);
            }
            return remoteCollectionItemsA;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void d(int i3, int i4, String str) {
            synchronized (GlanceRemoteViewsService.f38072b) {
                GlanceRemoteViewsService.f38072b.c(i3, i4, str);
                Unit unit = Unit.f139807a;
            }
        }

        public final void e(int i3, int i4, String str, RemoteCollectionItems remoteCollectionItems) {
            synchronized (GlanceRemoteViewsService.f38072b) {
                GlanceRemoteViewsService.f38072b.d(i3, i4, str, remoteCollectionItems);
                Unit unit = Unit.f139807a;
            }
        }

        private Companion() {
        }
    }

    @Override // android.widget.RemoteViewsService
    public RemoteViewsService.RemoteViewsFactory onGetViewFactory(Intent intent) {
        int intExtra = intent.getIntExtra("appWidgetId", -1);
        if (intExtra == -1) {
            throw new IllegalStateException("No app widget id was present in the intent");
        }
        int intExtra2 = intent.getIntExtra("androidx.glance.widget.extra.view_id", -1);
        if (intExtra2 == -1) {
            throw new IllegalStateException("No view id was present in the intent");
        }
        String stringExtra = intent.getStringExtra("androidx.glance.widget.extra.size_info");
        if (stringExtra == null || stringExtra.length() == 0) {
            throw new IllegalStateException("No size info was present in the intent");
        }
        return new GlanceRemoteViewsFactory(this, intExtra, intExtra2, stringExtra);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class GlanceRemoteViewsFactory implements RemoteViewsService.RemoteViewsFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f38073a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f38074b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f38075c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f38076d;

        public GlanceRemoteViewsFactory(Context context, int i3, int i4, String str) {
            this.f38073a = context;
            this.f38074b = i3;
            this.f38075c = i4;
            this.f38076d = str;
        }

        private final RemoteCollectionItems e() {
            return GlanceRemoteViewsService.f38071a.c(this.f38074b, this.f38075c, this.f38076d);
        }

        private final void f() {
            BuildersKt__BuildersKt.b(null, new GlanceRemoteViewsService$GlanceRemoteViewsFactory$loadData$1(this, null), 1, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x0096, code lost:
        
            if (r14.s(r0) == r1) goto L27;
         */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object g(androidx.glance.appwidget.AppWidgetId r14, kotlin.coroutines.Continuation r15) throws java.lang.Throwable {
            /*
                r13 = this;
                boolean r0 = r15 instanceof androidx.glance.appwidget.GlanceRemoteViewsService$GlanceRemoteViewsFactory$startSessionAndWaitUntilReady$1
                if (r0 == 0) goto L13
                r0 = r15
                androidx.glance.appwidget.GlanceRemoteViewsService$GlanceRemoteViewsFactory$startSessionAndWaitUntilReady$1 r0 = (androidx.glance.appwidget.GlanceRemoteViewsService$GlanceRemoteViewsFactory$startSessionAndWaitUntilReady$1) r0
                int r1 = r0.f38083d
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f38083d = r1
                goto L18
            L13:
                androidx.glance.appwidget.GlanceRemoteViewsService$GlanceRemoteViewsFactory$startSessionAndWaitUntilReady$1 r0 = new androidx.glance.appwidget.GlanceRemoteViewsService$GlanceRemoteViewsFactory$startSessionAndWaitUntilReady$1
                r0.<init>(r13, r15)
            L18:
                java.lang.Object r15 = r0.f38081b
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r2 = r0.f38083d
                r3 = 2
                r4 = 1
                r5 = 0
                if (r2 == 0) goto L3d
                if (r2 == r4) goto L35
                if (r2 != r3) goto L2d
                kotlin.ResultKt.b(r15)
                goto L99
            L2d:
                java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
                java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
                r14.<init>(r15)
                throw r14
            L35:
                java.lang.Object r14 = r0.f38080a
                androidx.glance.appwidget.AppWidgetSession r14 = (androidx.glance.appwidget.AppWidgetSession) r14
                kotlin.ResultKt.b(r15)
                goto L8e
            L3d:
                kotlin.ResultKt.b(r15)
                android.content.Context r15 = r13.f38073a
                android.appwidget.AppWidgetManager r15 = android.appwidget.AppWidgetManager.getInstance(r15)
                int r2 = r13.f38074b
                android.appwidget.AppWidgetProviderInfo r15 = r15.getAppWidgetInfo(r2)
                if (r15 == 0) goto L51
                android.content.ComponentName r2 = r15.provider
                goto L52
            L51:
                r2 = r5
            L52:
                if (r2 == 0) goto L9c
                android.content.ComponentName r15 = r15.provider
                java.lang.String r15 = r15.getClassName()
                java.lang.Class r15 = java.lang.Class.forName(r15)
                java.lang.reflect.Constructor r15 = r15.getDeclaredConstructor(r5)
                java.lang.Object r15 = r15.newInstance(r5)
                java.lang.String r2 = "null cannot be cast to non-null type androidx.glance.appwidget.GlanceAppWidgetReceiver"
                kotlin.jvm.internal.Intrinsics.checkNotNull(r15, r2)
                androidx.glance.appwidget.GlanceAppWidgetReceiver r15 = (androidx.glance.appwidget.GlanceAppWidgetReceiver) r15
                androidx.glance.appwidget.GlanceAppWidget r7 = r15.c()
                androidx.glance.appwidget.AppWidgetSession r6 = new androidx.glance.appwidget.AppWidgetSession
                r11 = 12
                r12 = 0
                r9 = 0
                r10 = 0
                r8 = r14
                r6.<init>(r7, r8, r9, r10, r11, r12)
                androidx.glance.session.SessionManager r14 = androidx.glance.session.SessionManagerKt.a()
                android.content.Context r15 = r13.f38073a
                r0.f38080a = r6
                r0.f38083d = r4
                java.lang.Object r14 = r14.c(r15, r6, r0)
                if (r14 != r1) goto L8d
                goto L98
            L8d:
                r14 = r6
            L8e:
                r0.f38080a = r5
                r0.f38083d = r3
                java.lang.Object r14 = r14.s(r0)
                if (r14 != r1) goto L99
            L98:
                return r1
            L99:
                kotlin.Unit r14 = kotlin.Unit.f139807a
                return r14
            L9c:
                kotlin.Unit r14 = kotlin.Unit.f139807a
                return r14
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.glance.appwidget.GlanceRemoteViewsService.GlanceRemoteViewsFactory.g(androidx.glance.appwidget.AppWidgetId, kotlin.coroutines.Continuation):java.lang.Object");
        }

        public Void d() {
            return null;
        }

        @Override // android.widget.RemoteViewsService.RemoteViewsFactory
        public int getCount() {
            return e().b();
        }

        @Override // android.widget.RemoteViewsService.RemoteViewsFactory
        public long getItemId(int i3) {
            try {
                return e().c(i3);
            } catch (ArrayIndexOutOfBoundsException unused) {
                return -1L;
            }
        }

        @Override // android.widget.RemoteViewsService.RemoteViewsFactory
        public /* bridge */ /* synthetic */ RemoteViews getLoadingView() {
            return (RemoteViews) d();
        }

        @Override // android.widget.RemoteViewsService.RemoteViewsFactory
        public RemoteViews getViewAt(int i3) {
            try {
                return e().d(i3);
            } catch (ArrayIndexOutOfBoundsException unused) {
                return new RemoteViews(this.f38073a.getPackageName(), R.layout.S4);
            }
        }

        @Override // android.widget.RemoteViewsService.RemoteViewsFactory
        public int getViewTypeCount() {
            return e().e();
        }

        @Override // android.widget.RemoteViewsService.RemoteViewsFactory
        public boolean hasStableIds() {
            return e().f();
        }

        @Override // android.widget.RemoteViewsService.RemoteViewsFactory
        public void onDataSetChanged() {
            f();
        }

        @Override // android.widget.RemoteViewsService.RemoteViewsFactory
        public void onDestroy() {
            GlanceRemoteViewsService.f38071a.d(this.f38074b, this.f38075c, this.f38076d);
        }

        @Override // android.widget.RemoteViewsService.RemoteViewsFactory
        public void onCreate() {
        }
    }
}
