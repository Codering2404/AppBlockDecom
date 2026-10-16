package cz.mobilesoft.widgets.schedules;

import androidx.glance.appwidget.GlanceAppWidget;
import androidx.glance.appwidget.GlanceAppWidgetReceiver;
import cz.mobilesoft.widgets.AppBlockWidgetReceiver;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
public final class SchedulesWidgetReceiver extends AppBlockWidgetReceiver<SchedulesWidget> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Companion f134136h = new Companion(null);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f134137i = GlanceAppWidgetReceiver.f38011c | GlanceAppWidget.f37928e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final GlanceAppWidget f134138g = new SchedulesWidget();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x00a1, code lost:
        
            if (r1.a(r8, r3, r4, r5, r6) == r0) goto L23;
         */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object a(android.content.Context r8, kotlin.jvm.functions.Function1 r9, kotlin.coroutines.Continuation r10) throws java.lang.Throwable {
            /*
                r7 = this;
                boolean r0 = r10 instanceof cz.mobilesoft.widgets.schedules.SchedulesWidgetReceiver$Companion$updateWidget$1
                if (r0 == 0) goto L14
                r0 = r10
                cz.mobilesoft.widgets.schedules.SchedulesWidgetReceiver$Companion$updateWidget$1 r0 = (cz.mobilesoft.widgets.schedules.SchedulesWidgetReceiver$Companion$updateWidget$1) r0
                int r1 = r0.f134145h
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L14
                int r1 = r1 - r2
                r0.f134145h = r1
            L12:
                r6 = r0
                goto L1a
            L14:
                cz.mobilesoft.widgets.schedules.SchedulesWidgetReceiver$Companion$updateWidget$1 r0 = new cz.mobilesoft.widgets.schedules.SchedulesWidgetReceiver$Companion$updateWidget$1
                r0.<init>(r7, r10)
                goto L12
            L1a:
                java.lang.Object r10 = r6.f134143f
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r1 = r6.f134145h
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L5b
                if (r1 == r3) goto L46
                if (r1 != r2) goto L3e
                java.lang.Object r8 = r6.f134142d
                java.util.List r8 = (java.util.List) r8
                java.lang.Object r8 = r6.f134141c
                androidx.glance.appwidget.GlanceAppWidgetManager r8 = (androidx.glance.appwidget.GlanceAppWidgetManager) r8
                java.lang.Object r8 = r6.f134140b
                kotlin.jvm.functions.Function1 r8 = (kotlin.jvm.functions.Function1) r8
                java.lang.Object r8 = r6.f134139a
                android.content.Context r8 = (android.content.Context) r8
                kotlin.ResultKt.b(r10)
                goto La4
            L3e:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r9)
                throw r8
            L46:
                java.lang.Object r8 = r6.f134141c
                androidx.glance.appwidget.GlanceAppWidgetManager r8 = (androidx.glance.appwidget.GlanceAppWidgetManager) r8
                java.lang.Object r9 = r6.f134140b
                kotlin.jvm.functions.Function1 r9 = (kotlin.jvm.functions.Function1) r9
                java.lang.Object r1 = r6.f134139a
                android.content.Context r1 = (android.content.Context) r1
                kotlin.ResultKt.b(r10)
                r3 = r10
                r10 = r8
                r8 = r1
                r1 = r3
            L59:
                r3 = r9
                goto L78
            L5b:
                kotlin.ResultKt.b(r10)
                androidx.glance.appwidget.GlanceAppWidgetManager r10 = new androidx.glance.appwidget.GlanceAppWidgetManager
                r10.<init>(r8)
                r6.f134139a = r8
                r6.f134140b = r9
                java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.a(r10)
                r6.f134141c = r1
                r6.f134145h = r3
                java.lang.Class<cz.mobilesoft.widgets.schedules.SchedulesWidget> r1 = cz.mobilesoft.widgets.schedules.SchedulesWidget.class
                java.lang.Object r1 = r10.i(r1, r6)
                if (r1 != r0) goto L59
                goto La3
            L78:
                r4 = r1
                java.util.List r4 = (java.util.List) r4
                cz.mobilesoft.widgets.AppBlockWidgetReceiver$Companion r1 = cz.mobilesoft.widgets.AppBlockWidgetReceiver.f133865d
                cz.mobilesoft.widgets.schedules.SchedulesWidget r5 = new cz.mobilesoft.widgets.schedules.SchedulesWidget
                r5.<init>()
                java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.a(r8)
                r6.f134139a = r9
                java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.a(r3)
                r6.f134140b = r9
                java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.a(r10)
                r6.f134141c = r9
                java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.a(r4)
                r6.f134142d = r9
                r6.f134145h = r2
                r2 = r8
                java.lang.Object r8 = r1.a(r2, r3, r4, r5, r6)
                if (r8 != r0) goto La4
            La3:
                return r0
            La4:
                kotlin.Unit r8 = kotlin.Unit.f139807a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.widgets.schedules.SchedulesWidgetReceiver.Companion.a(android.content.Context, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
        }

        private Companion() {
        }
    }

    @Override // androidx.glance.appwidget.GlanceAppWidgetReceiver
    public GlanceAppWidget c() {
        return this.f134138g;
    }
}
