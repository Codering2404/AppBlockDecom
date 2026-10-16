package androidx.compose.material3.adaptive;

import android.content.Context;
import android.graphics.Rect;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.window.core.layout.WindowSizeClass;
import androidx.window.layout.FoldingFeature;
import androidx.window.layout.WindowInfoTracker;
import androidx.window.layout.WindowMetricsCalculator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class AndroidWindowAdaptiveInfo_androidKt {
    public static final State a(Composer composer, int i3) {
        composer.F(-883534959);
        if (ComposerKt.M()) {
            ComposerKt.U(-883534959, i3, -1, "androidx.compose.material3.adaptive.collectFoldingFeaturesAsState (AndroidWindowAdaptiveInfo.android.kt:68)");
        }
        Context context = (Context) composer.q(AndroidCompositionLocals_androidKt.g());
        composer.F(793549594);
        boolean Z = composer.Z(context);
        Object objG = composer.G();
        if (Z || objG == Composer.f23746a.a()) {
            final Flow flowC = WindowInfoTracker.f54344a.d(context).c(context);
            objG = new Flow<List<? extends FoldingFeature>>() { // from class: androidx.compose.material3.adaptive.AndroidWindowAdaptiveInfo_androidKt$collectFoldingFeaturesAsState$lambda$2$$inlined$map$1

                /* JADX INFO: renamed from: androidx.compose.material3.adaptive.AndroidWindowAdaptiveInfo_androidKt$collectFoldingFeaturesAsState$lambda$2$$inlined$map$1$2, reason: invalid class name */
                /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                @Metadata
                public static final class AnonymousClass2<T> implements FlowCollector {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    final /* synthetic */ FlowCollector f21589a;

                    /* JADX INFO: renamed from: androidx.compose.material3.adaptive.AndroidWindowAdaptiveInfo_androidKt$collectFoldingFeaturesAsState$lambda$2$$inlined$map$1$2$1, reason: invalid class name */
                    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                    @Metadata
                    @DebugMetadata(c = "androidx.compose.material3.adaptive.AndroidWindowAdaptiveInfo_androidKt$collectFoldingFeaturesAsState$lambda$2$$inlined$map$1$2", f = "AndroidWindowAdaptiveInfo.android.kt", l = {223}, m = "emit")
                    public static final class AnonymousClass1 extends ContinuationImpl {

                        /* JADX INFO: renamed from: a, reason: collision with root package name */
                        /* synthetic */ Object f21590a;

                        /* JADX INFO: renamed from: b, reason: collision with root package name */
                        int f21591b;

                        public AnonymousClass1(Continuation continuation) {
                            super(continuation);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            this.f21590a = obj;
                            this.f21591b |= Integer.MIN_VALUE;
                            return AnonymousClass2.this.emit(null, this);
                        }
                    }

                    public AnonymousClass2(FlowCollector flowCollector) {
                        this.f21589a = flowCollector;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public final java.lang.Object emit(java.lang.Object r7, kotlin.coroutines.Continuation r8) throws java.lang.Throwable {
                        /*
                            r6 = this;
                            boolean r0 = r8 instanceof androidx.compose.material3.adaptive.AndroidWindowAdaptiveInfo_androidKt$collectFoldingFeaturesAsState$lambda$2$$inlined$map$1.AnonymousClass2.AnonymousClass1
                            if (r0 == 0) goto L13
                            r0 = r8
                            androidx.compose.material3.adaptive.AndroidWindowAdaptiveInfo_androidKt$collectFoldingFeaturesAsState$lambda$2$$inlined$map$1$2$1 r0 = (androidx.compose.material3.adaptive.AndroidWindowAdaptiveInfo_androidKt$collectFoldingFeaturesAsState$lambda$2$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                            int r1 = r0.f21591b
                            r2 = -2147483648(0xffffffff80000000, float:-0.0)
                            r3 = r1 & r2
                            if (r3 == 0) goto L13
                            int r1 = r1 - r2
                            r0.f21591b = r1
                            goto L18
                        L13:
                            androidx.compose.material3.adaptive.AndroidWindowAdaptiveInfo_androidKt$collectFoldingFeaturesAsState$lambda$2$$inlined$map$1$2$1 r0 = new androidx.compose.material3.adaptive.AndroidWindowAdaptiveInfo_androidKt$collectFoldingFeaturesAsState$lambda$2$$inlined$map$1$2$1
                            r0.<init>(r8)
                        L18:
                            java.lang.Object r8 = r0.f21590a
                            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                            int r2 = r0.f21591b
                            r3 = 1
                            if (r2 == 0) goto L31
                            if (r2 != r3) goto L29
                            kotlin.ResultKt.b(r8)
                            goto L62
                        L29:
                            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                            r7.<init>(r8)
                            throw r7
                        L31:
                            kotlin.ResultKt.b(r8)
                            kotlinx.coroutines.flow.FlowCollector r8 = r6.f21589a
                            androidx.window.layout.WindowLayoutInfo r7 = (androidx.window.layout.WindowLayoutInfo) r7
                            java.util.List r7 = r7.a()
                            java.lang.Iterable r7 = (java.lang.Iterable) r7
                            java.util.ArrayList r2 = new java.util.ArrayList
                            r2.<init>()
                            java.util.Iterator r7 = r7.iterator()
                        L47:
                            boolean r4 = r7.hasNext()
                            if (r4 == 0) goto L59
                            java.lang.Object r4 = r7.next()
                            boolean r5 = r4 instanceof androidx.window.layout.FoldingFeature
                            if (r5 == 0) goto L47
                            r2.add(r4)
                            goto L47
                        L59:
                            r0.f21591b = r3
                            java.lang.Object r7 = r8.emit(r2, r0)
                            if (r7 != r1) goto L62
                            return r1
                        L62:
                            kotlin.Unit r7 = kotlin.Unit.f139807a
                            return r7
                        */
                        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.adaptive.AndroidWindowAdaptiveInfo_androidKt$collectFoldingFeaturesAsState$lambda$2$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                    }
                }

                @Override // kotlinx.coroutines.flow.Flow
                public Object collect(FlowCollector flowCollector, Continuation continuation) {
                    Object objCollect = flowC.collect(new AnonymousClass2(flowCollector), continuation);
                    return objCollect == IntrinsicsKt.f() ? objCollect : Unit.f139807a;
                }
            };
            composer.w(objG);
        }
        composer.Y();
        State stateA = SnapshotStateKt.a((Flow) objG, CollectionsKt.emptyList(), null, composer, 48, 2);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.Y();
        return stateA;
    }

    public static final WindowAdaptiveInfo b(Composer composer, int i3) {
        composer.F(-2003129230);
        if (ComposerKt.M()) {
            ComposerKt.U(-2003129230, i3, -1, "androidx.compose.material3.adaptive.currentWindowAdaptiveInfo (AndroidWindowAdaptiveInfo.android.kt:35)");
        }
        composer.F(-1765630114);
        long jO = ((Density) composer.q(CompositionLocalsKt.f())).o(IntSizeKt.e(c(composer, 0)));
        composer.Y();
        WindowAdaptiveInfo windowAdaptiveInfo = new WindowAdaptiveInfo(WindowSizeClass.f54166c.a(DpSize.j(jO), DpSize.i(jO)), AndroidPosture_androidKt.a((List) a(composer, 0).getValue()));
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.Y();
        return windowAdaptiveInfo;
    }

    public static final long c(Composer composer, int i3) {
        composer.F(-1153163183);
        if (ComposerKt.M()) {
            ComposerKt.U(-1153163183, i3, -1, "androidx.compose.material3.adaptive.currentWindowSize (AndroidWindowAdaptiveInfo.android.kt:49)");
        }
        composer.q(AndroidCompositionLocals_androidKt.f());
        Rect rectA = WindowMetricsCalculator.f54368a.b().a((Context) composer.q(AndroidCompositionLocals_androidKt.g())).a();
        long jA = IntSizeKt.a(rectA.width(), rectA.height());
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.Y();
        return jA;
    }
}
