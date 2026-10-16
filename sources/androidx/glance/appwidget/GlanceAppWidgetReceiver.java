package androidx.glance.appwidget;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.os.Bundle;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

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
public abstract class GlanceAppWidgetReceiver extends AppWidgetProvider {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f38010b = new Companion(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f38011c = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CoroutineContext f38012a = Dispatchers.a();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: androidx.glance.appwidget.GlanceAppWidgetReceiver$onAppWidgetOptionsChanged$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "androidx.glance.appwidget.GlanceAppWidgetReceiver$onAppWidgetOptionsChanged$1", f = "GlanceAppWidgetReceiver.kt", l = {121}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f38013a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private /* synthetic */ Object f38014b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f38016d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f38017f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ Bundle f38018g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Context context, int i3, Bundle bundle, Continuation continuation) {
            super(2, continuation);
            this.f38016d = context;
            this.f38017f = i3;
            this.f38018g = bundle;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass1 anonymousClass1 = GlanceAppWidgetReceiver.this.new AnonymousClass1(this.f38016d, this.f38017f, this.f38018g, continuation);
            anonymousClass1.f38014b = obj;
            return anonymousClass1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f38013a;
            if (i3 == 0) {
                ResultKt.b(obj);
                GlanceAppWidgetReceiver.this.d((CoroutineScope) this.f38014b, this.f38016d);
                GlanceAppWidget glanceAppWidgetC = GlanceAppWidgetReceiver.this.c();
                Context context = this.f38016d;
                int i4 = this.f38017f;
                Bundle bundle = this.f38018g;
                this.f38013a = 1;
                if (glanceAppWidgetC.h(context, i4, bundle, this) == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: androidx.glance.appwidget.GlanceAppWidgetReceiver$onDeleted$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "androidx.glance.appwidget.GlanceAppWidgetReceiver$onDeleted$1", f = "GlanceAppWidgetReceiver.kt", l = {129}, m = "invokeSuspend")
    static final class C03521 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f38019a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f38020b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f38021c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f38022d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f38023f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private /* synthetic */ Object f38024g;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ Context f38026i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ int[] f38027j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03521(Context context, int[] iArr, Continuation continuation) {
            super(2, continuation);
            this.f38026i = context;
            this.f38027j = iArr;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            C03521 c03521 = GlanceAppWidgetReceiver.this.new C03521(this.f38026i, this.f38027j, continuation);
            c03521.f38024g = obj;
            return c03521;
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0045  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0060  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x005b -> B:13:0x005e). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) throws java.lang.Throwable {
            /*
                r8 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r1 = r8.f38023f
                r2 = 1
                if (r1 == 0) goto L27
                if (r1 != r2) goto L1f
                int r1 = r8.f38022d
                int r3 = r8.f38021c
                java.lang.Object r4 = r8.f38020b
                android.content.Context r4 = (android.content.Context) r4
                java.lang.Object r5 = r8.f38019a
                androidx.glance.appwidget.GlanceAppWidgetReceiver r5 = (androidx.glance.appwidget.GlanceAppWidgetReceiver) r5
                java.lang.Object r6 = r8.f38024g
                int[] r6 = (int[]) r6
                kotlin.ResultKt.b(r9)
                goto L5e
            L1f:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r0)
                throw r9
            L27:
                kotlin.ResultKt.b(r9)
                java.lang.Object r9 = r8.f38024g
                kotlinx.coroutines.CoroutineScope r9 = (kotlinx.coroutines.CoroutineScope) r9
                androidx.glance.appwidget.GlanceAppWidgetReceiver r1 = androidx.glance.appwidget.GlanceAppWidgetReceiver.this
                android.content.Context r3 = r8.f38026i
                androidx.glance.appwidget.GlanceAppWidgetReceiver.a(r1, r9, r3)
                int[] r9 = r8.f38027j
                androidx.glance.appwidget.GlanceAppWidgetReceiver r1 = androidx.glance.appwidget.GlanceAppWidgetReceiver.this
                android.content.Context r3 = r8.f38026i
                int r4 = r9.length
                r5 = 0
                r6 = r5
                r5 = r1
                r1 = r4
                r4 = r3
                r3 = r6
                r6 = r9
            L43:
                if (r3 >= r1) goto L60
                r9 = r6[r3]
                androidx.glance.appwidget.GlanceAppWidget r7 = r5.c()
                r8.f38024g = r6
                r8.f38019a = r5
                r8.f38020b = r4
                r8.f38021c = r3
                r8.f38022d = r1
                r8.f38023f = r2
                java.lang.Object r9 = r7.a(r4, r9, r8)
                if (r9 != r0) goto L5e
                return r0
            L5e:
                int r3 = r3 + r2
                goto L43
            L60:
                kotlin.Unit r9 = kotlin.Unit.f139807a
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.glance.appwidget.GlanceAppWidgetReceiver.C03521.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C03521) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: androidx.glance.appwidget.GlanceAppWidgetReceiver$onUpdate$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "androidx.glance.appwidget.GlanceAppWidgetReceiver$onUpdate$1", f = "GlanceAppWidgetReceiver.kt", l = {108}, m = "invokeSuspend")
    static final class C03531 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f38034a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private /* synthetic */ Object f38035b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f38037d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ int[] f38038f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03531(Context context, int[] iArr, Continuation continuation) {
            super(2, continuation);
            this.f38037d = context;
            this.f38038f = iArr;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            C03531 c03531 = GlanceAppWidgetReceiver.this.new C03531(this.f38037d, this.f38038f, continuation);
            c03531.f38035b = obj;
            return c03531;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f38034a;
            if (i3 == 0) {
                ResultKt.b(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.f38035b;
                GlanceAppWidgetReceiver.this.d(coroutineScope, this.f38037d);
                int[] iArr = this.f38038f;
                GlanceAppWidgetReceiver glanceAppWidgetReceiver = GlanceAppWidgetReceiver.this;
                Context context = this.f38037d;
                ArrayList arrayList = new ArrayList(iArr.length);
                for (int i4 : iArr) {
                    arrayList.add(BuildersKt__Builders_commonKt.b(coroutineScope, null, null, new GlanceAppWidgetReceiver$onUpdate$1$1$1(glanceAppWidgetReceiver, context, i4, null), 3, null));
                }
                this.f38034a = 1;
                if (AwaitKt.a(arrayList, this) == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C03531) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d(CoroutineScope coroutineScope, Context context) {
        BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new GlanceAppWidgetReceiver$updateManager$1(context, this, null), 3, null);
    }

    public CoroutineContext b() {
        return this.f38012a;
    }

    public abstract GlanceAppWidget c();

    @Override // android.appwidget.AppWidgetProvider
    public void onAppWidgetOptionsChanged(Context context, AppWidgetManager appWidgetManager, int i3, Bundle bundle) {
        CoroutineBroadcastReceiverKt.a(this, b(), new AnonymousClass1(context, i3, bundle, null));
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onDeleted(Context context, int[] iArr) {
        CoroutineBroadcastReceiverKt.a(this, b(), new C03521(context, iArr, null));
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x008c A[Catch: all -> 0x0049, CancellationException -> 0x00b6, TryCatch #3 {CancellationException -> 0x00b6, all -> 0x0049, blocks: (B:21:0x0042, B:28:0x0052, B:29:0x005a, B:30:0x005b, B:31:0x0063, B:32:0x0064, B:48:0x00af, B:38:0x007a, B:40:0x008c, B:42:0x0097, B:44:0x00a3, B:43:0x009f, B:46:0x00a7, B:47:0x00ae, B:35:0x006f), top: B:55:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00a7 A[Catch: all -> 0x0049, CancellationException -> 0x00b6, TryCatch #3 {CancellationException -> 0x00b6, all -> 0x0049, blocks: (B:21:0x0042, B:28:0x0052, B:29:0x005a, B:30:0x005b, B:31:0x0063, B:32:0x0064, B:48:0x00af, B:38:0x007a, B:40:0x008c, B:42:0x0097, B:44:0x00a3, B:43:0x009f, B:46:0x00a7, B:47:0x00ae, B:35:0x006f), top: B:55:0x0006 }] */
    @Override // android.appwidget.AppWidgetProvider, android.content.BroadcastReceiver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onReceive(android.content.Context r8, android.content.Intent r9) {
        /*
            r7 = this;
            java.lang.String r0 = "appWidgetIds"
            java.lang.String r1 = r9.getAction()     // Catch: java.lang.Throwable -> L4d java.util.concurrent.CancellationException -> L50
            if (r1 == 0) goto L1b
            int r2 = r1.hashCode()     // Catch: java.lang.Throwable -> L4d java.util.concurrent.CancellationException -> L50
            r3 = -19011148(0xfffffffffedde9b4, float:-1.4748642E38)
            if (r2 == r3) goto L6f
            r3 = 649033583(0x26af776f, float:1.2175437E-15)
            if (r2 == r3) goto L64
            r0 = 1989767543(0x76997177, float:1.5560991E33)
            if (r2 == r0) goto L1f
        L1b:
            r2 = r7
            r3 = r8
            goto Laf
        L1f:
            java.lang.String r0 = "ACTION_TRIGGER_LAMBDA"
            boolean r0 = r1.equals(r0)     // Catch: java.lang.Throwable -> L4d java.util.concurrent.CancellationException -> L50
            if (r0 != 0) goto L28
            goto L1b
        L28:
            java.lang.String r0 = "EXTRA_ACTION_KEY"
            java.lang.String r5 = r9.getStringExtra(r0)     // Catch: java.lang.Throwable -> L4d java.util.concurrent.CancellationException -> L50
            if (r5 == 0) goto L5b
            java.lang.String r0 = "EXTRA_APPWIDGET_ID"
            r1 = -1
            int r4 = r9.getIntExtra(r0, r1)     // Catch: java.lang.Throwable -> L4d java.util.concurrent.CancellationException -> L50
            if (r4 == r1) goto L52
            kotlin.coroutines.CoroutineContext r9 = r7.b()     // Catch: java.lang.Throwable -> L4d java.util.concurrent.CancellationException -> L50
            androidx.glance.appwidget.GlanceAppWidgetReceiver$onReceive$1$1 r1 = new androidx.glance.appwidget.GlanceAppWidgetReceiver$onReceive$1$1     // Catch: java.lang.Throwable -> L4d java.util.concurrent.CancellationException -> L50
            r6 = 0
            r2 = r7
            r3 = r8
            r1.<init>(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L49 java.util.concurrent.CancellationException -> Lb6
            androidx.glance.appwidget.CoroutineBroadcastReceiverKt.a(r7, r9, r1)     // Catch: java.lang.Throwable -> L49 java.util.concurrent.CancellationException -> Lb6
            return
        L49:
            r0 = move-exception
        L4a:
            r8 = r0
            goto Lb3
        L4d:
            r0 = move-exception
            r2 = r7
            goto L4a
        L50:
            r2 = r7
            goto Lb6
        L52:
            r2 = r7
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L49 java.util.concurrent.CancellationException -> Lb6
            java.lang.String r9 = "Intent is missing AppWidgetId extra"
            r8.<init>(r9)     // Catch: java.lang.Throwable -> L49 java.util.concurrent.CancellationException -> Lb6
            throw r8     // Catch: java.lang.Throwable -> L49 java.util.concurrent.CancellationException -> Lb6
        L5b:
            r2 = r7
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L49 java.util.concurrent.CancellationException -> Lb6
            java.lang.String r9 = "Intent is missing ActionKey extra"
            r8.<init>(r9)     // Catch: java.lang.Throwable -> L49 java.util.concurrent.CancellationException -> Lb6
            throw r8     // Catch: java.lang.Throwable -> L49 java.util.concurrent.CancellationException -> Lb6
        L64:
            r2 = r7
            r3 = r8
            java.lang.String r8 = "androidx.glance.appwidget.action.DEBUG_UPDATE"
            boolean r8 = r1.equals(r8)     // Catch: java.lang.Throwable -> L49 java.util.concurrent.CancellationException -> Lb6
            if (r8 != 0) goto L7a
            goto Laf
        L6f:
            r2 = r7
            r3 = r8
            java.lang.String r8 = "android.intent.action.LOCALE_CHANGED"
            boolean r8 = r1.equals(r8)     // Catch: java.lang.Throwable -> L49 java.util.concurrent.CancellationException -> Lb6
            if (r8 != 0) goto L7a
            goto Laf
        L7a:
            android.appwidget.AppWidgetManager r8 = android.appwidget.AppWidgetManager.getInstance(r3)     // Catch: java.lang.Throwable -> L49 java.util.concurrent.CancellationException -> Lb6
            java.lang.String r1 = r3.getPackageName()     // Catch: java.lang.Throwable -> L49 java.util.concurrent.CancellationException -> Lb6
            java.lang.Class r4 = r7.getClass()     // Catch: java.lang.Throwable -> L49 java.util.concurrent.CancellationException -> Lb6
            java.lang.String r4 = r4.getCanonicalName()     // Catch: java.lang.Throwable -> L49 java.util.concurrent.CancellationException -> Lb6
            if (r4 == 0) goto La7
            android.content.ComponentName r5 = new android.content.ComponentName     // Catch: java.lang.Throwable -> L49 java.util.concurrent.CancellationException -> Lb6
            r5.<init>(r1, r4)     // Catch: java.lang.Throwable -> L49 java.util.concurrent.CancellationException -> Lb6
            boolean r1 = r9.hasExtra(r0)     // Catch: java.lang.Throwable -> L49 java.util.concurrent.CancellationException -> Lb6
            if (r1 == 0) goto L9f
            int[] r9 = r9.getIntArrayExtra(r0)     // Catch: java.lang.Throwable -> L49 java.util.concurrent.CancellationException -> Lb6
            kotlin.jvm.internal.Intrinsics.checkNotNull(r9)     // Catch: java.lang.Throwable -> L49 java.util.concurrent.CancellationException -> Lb6
            goto La3
        L9f:
            int[] r9 = r8.getAppWidgetIds(r5)     // Catch: java.lang.Throwable -> L49 java.util.concurrent.CancellationException -> Lb6
        La3:
            r7.onUpdate(r3, r8, r9)     // Catch: java.lang.Throwable -> L49 java.util.concurrent.CancellationException -> Lb6
            return
        La7:
            java.lang.String r8 = "no canonical name"
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L49 java.util.concurrent.CancellationException -> Lb6
            r9.<init>(r8)     // Catch: java.lang.Throwable -> L49 java.util.concurrent.CancellationException -> Lb6
            throw r9     // Catch: java.lang.Throwable -> L49 java.util.concurrent.CancellationException -> Lb6
        Laf:
            super.onReceive(r3, r9)     // Catch: java.lang.Throwable -> L49 java.util.concurrent.CancellationException -> Lb6
            return
        Lb3:
            androidx.glance.appwidget.AppWidgetUtilsKt.l(r8)
        Lb6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.glance.appwidget.GlanceAppWidgetReceiver.onReceive(android.content.Context, android.content.Intent):void");
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] iArr) {
        CoroutineBroadcastReceiverKt.a(this, b(), new C03531(context, iArr, null));
    }
}
