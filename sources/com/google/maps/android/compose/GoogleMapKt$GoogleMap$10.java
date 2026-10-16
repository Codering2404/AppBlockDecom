package com.google.maps.android.compose;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.Composition;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.CompositionKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.glance.color.Tq.KqqtdetwHMIO;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.LocationSource;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MapStyleOptions;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

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
/* JADX INFO: loaded from: classes6.dex */
@Metadata
@DebugMetadata(c = "com.google.maps.android.compose.GoogleMapKt$GoogleMap$10", f = "GoogleMap.kt", l = {230, 242}, m = "invokeSuspend")
final class GoogleMapKt$GoogleMap$10 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f90682a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f90683b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f90684c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f90685d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Object f90686f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f90687g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ MapView f90688h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ CompositionContext f90689i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final /* synthetic */ String f90690j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final /* synthetic */ MapClickListeners f90691k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    final /* synthetic */ int f90692l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    final /* synthetic */ CameraPositionState f90693m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    final /* synthetic */ State f90694n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    final /* synthetic */ State f90695o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    final /* synthetic */ State f90696p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    final /* synthetic */ State f90697q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    final /* synthetic */ State f90698r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    final /* synthetic */ State f90699s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    GoogleMapKt$GoogleMap$10(MapView mapView, CompositionContext compositionContext, String str, MapClickListeners mapClickListeners, int i3, CameraPositionState cameraPositionState, State state, State state2, State state3, State state4, State state5, State state6, Continuation continuation) {
        super(2, continuation);
        this.f90688h = mapView;
        this.f90689i = compositionContext;
        this.f90690j = str;
        this.f90691k = mapClickListeners;
        this.f90692l = i3;
        this.f90693m = cameraPositionState;
        this.f90694n = state;
        this.f90695o = state2;
        this.f90696p = state3;
        this.f90697q = state4;
        this.f90698r = state5;
        this.f90699s = state6;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new GoogleMapKt$GoogleMap$10(this.f90688h, this.f90689i, this.f90690j, this.f90691k, this.f90692l, this.f90693m, this.f90694n, this.f90695o, this.f90696p, this.f90697q, this.f90698r, this.f90699s, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objA;
        MapView mapView;
        Function2 function2;
        CompositionContext compositionContext;
        Composition compositionA;
        Composition composition;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f90687g;
        try {
            if (i3 == 0) {
                ResultKt.b(obj);
                MapView mapView2 = this.f90688h;
                CompositionContext compositionContext2 = this.f90689i;
                final String str = this.f90690j;
                final MapClickListeners mapClickListeners = this.f90691k;
                final int i4 = this.f90692l;
                final CameraPositionState cameraPositionState = this.f90693m;
                final State state = this.f90694n;
                final State state2 = this.f90695o;
                final State state3 = this.f90696p;
                final State state4 = this.f90697q;
                final State state5 = this.f90698r;
                final State state6 = this.f90699s;
                ComposableLambda composableLambdaC = ComposableLambdaKt.c(102586552, true, new Function2<Composer, Integer, Unit>() { // from class: com.google.maps.android.compose.GoogleMapKt$GoogleMap$10$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                        invoke((Composer) obj2, ((Number) obj3).intValue());
                        return Unit.f139807a;
                    }

                    public final void invoke(Composer composer, int i5) {
                        if ((i5 & 11) == 2 && composer.l()) {
                            composer.Q();
                            return;
                        }
                        if (ComposerKt.M()) {
                            ComposerKt.U(102586552, i5, -1, "com.google.maps.android.compose.GoogleMap.<anonymous>.<anonymous>.<anonymous> (GoogleMap.kt:125)");
                        }
                        final String str2 = str;
                        final CameraPositionState cameraPositionStateD = GoogleMapKt.d(state);
                        final MapClickListeners mapClickListeners2 = mapClickListeners;
                        PaddingValues paddingValuesE = GoogleMapKt.e(state2);
                        LocationSource locationSourceC = GoogleMapKt.c(state3);
                        MapProperties mapPropertiesG = GoogleMapKt.g(state4);
                        MapUiSettings mapUiSettingsF = GoogleMapKt.f(state5);
                        composer.F(2146556458);
                        Applier applierM = composer.m();
                        Intrinsics.checkNotNull(applierM, "null cannot be cast to non-null type com.google.maps.android.compose.MapApplier");
                        final GoogleMap googleMapI = ((MapApplier) applierM).I();
                        final Density density = (Density) composer.q(CompositionLocalsKt.f());
                        final LayoutDirection layoutDirection = (LayoutDirection) composer.q(CompositionLocalsKt.m());
                        final Function0<MapPropertiesNode> function0 = new Function0<MapPropertiesNode>() { // from class: com.google.maps.android.compose.MapUpdaterKt$MapUpdater$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                            public final MapPropertiesNode invoke() {
                                return new MapPropertiesNode(googleMapI, cameraPositionStateD, str2, mapClickListeners2, density, layoutDirection);
                            }
                        };
                        composer.F(1886828752);
                        if (!(composer.m() instanceof MapApplier)) {
                            ComposablesKt.c();
                        }
                        composer.o();
                        if (composer.i()) {
                            composer.P(new Function0<MapPropertiesNode>() { // from class: com.google.maps.android.compose.MapUpdaterKt$MapUpdater$$inlined$ComposeNode$1
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return function0.invoke();
                                }
                            });
                        } else {
                            composer.v();
                        }
                        Composer composerA = Updater.a(composer);
                        Updater.h(composerA, density, new Function2<MapPropertiesNode, Density, Unit>() { // from class: com.google.maps.android.compose.MapUpdaterKt$MapUpdater$2$1
                            public final void c(MapPropertiesNode update, Density it) {
                                Intrinsics.checkNotNullParameter(update, "$this$update");
                                Intrinsics.checkNotNullParameter(it, "it");
                                update.D(it);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                                c((MapPropertiesNode) obj2, (Density) obj3);
                                return Unit.f139807a;
                            }
                        });
                        Updater.h(composerA, layoutDirection, new Function2<MapPropertiesNode, LayoutDirection, Unit>() { // from class: com.google.maps.android.compose.MapUpdaterKt$MapUpdater$2$2
                            public final void c(MapPropertiesNode update, LayoutDirection it) {
                                Intrinsics.checkNotNullParameter(update, "$this$update");
                                Intrinsics.checkNotNullParameter(it, "it");
                                update.E(it);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                                c((MapPropertiesNode) obj2, (LayoutDirection) obj3);
                                return Unit.f139807a;
                            }
                        });
                        Updater.h(composerA, str2, new Function2<MapPropertiesNode, String, Unit>() { // from class: com.google.maps.android.compose.MapUpdaterKt$MapUpdater$2$3
                            public final void c(MapPropertiesNode update, String str3) {
                                Intrinsics.checkNotNullParameter(update, "$this$update");
                                update.C(str3);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                                c((MapPropertiesNode) obj2, (String) obj3);
                                return Unit.f139807a;
                            }
                        });
                        Updater.e(composerA, locationSourceC, new Function2<MapPropertiesNode, LocationSource, Unit>() { // from class: com.google.maps.android.compose.MapUpdaterKt$MapUpdater$2$4
                            {
                                super(2);
                            }

                            public final void c(MapPropertiesNode set, LocationSource locationSource) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                googleMapI.s(locationSource);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                                c((MapPropertiesNode) obj2, (LocationSource) obj3);
                                return Unit.f139807a;
                            }
                        });
                        Updater.e(composerA, Boolean.valueOf(mapPropertiesG.f()), new Function2<MapPropertiesNode, Boolean, Unit>() { // from class: com.google.maps.android.compose.MapUpdaterKt$MapUpdater$2$5
                            {
                                super(2);
                            }

                            public final void c(MapPropertiesNode set, boolean z2) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                googleMapI.n(z2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                                c((MapPropertiesNode) obj2, ((Boolean) obj3).booleanValue());
                                return Unit.f139807a;
                            }
                        });
                        Updater.e(composerA, Boolean.valueOf(mapPropertiesG.g()), new Function2<MapPropertiesNode, Boolean, Unit>() { // from class: com.google.maps.android.compose.MapUpdaterKt$MapUpdater$2$6
                            {
                                super(2);
                            }

                            public final void c(MapPropertiesNode set, boolean z2) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                googleMapI.p(z2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                                c((MapPropertiesNode) obj2, ((Boolean) obj3).booleanValue());
                                return Unit.f139807a;
                            }
                        });
                        Updater.e(composerA, Boolean.valueOf(mapPropertiesG.h()), new Function2<MapPropertiesNode, Boolean, Unit>() { // from class: com.google.maps.android.compose.MapUpdaterKt$MapUpdater$2$7
                            {
                                super(2);
                            }

                            public final void c(MapPropertiesNode set, boolean z2) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                googleMapI.x(z2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                                c((MapPropertiesNode) obj2, ((Boolean) obj3).booleanValue());
                                return Unit.f139807a;
                            }
                        });
                        Updater.e(composerA, Boolean.valueOf(mapPropertiesG.i()), new Function2<MapPropertiesNode, Boolean, Unit>() { // from class: com.google.maps.android.compose.MapUpdaterKt$MapUpdater$2$8
                            {
                                super(2);
                            }

                            public final void c(MapPropertiesNode set, boolean z2) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                googleMapI.T(z2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                                c((MapPropertiesNode) obj2, ((Boolean) obj3).booleanValue());
                                return Unit.f139807a;
                            }
                        });
                        Updater.e(composerA, mapPropertiesG.a(), new Function2<MapPropertiesNode, LatLngBounds, Unit>() { // from class: com.google.maps.android.compose.MapUpdaterKt$MapUpdater$2$9
                            {
                                super(2);
                            }

                            public final void c(MapPropertiesNode set, LatLngBounds latLngBounds) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                googleMapI.r(latLngBounds);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                                c((MapPropertiesNode) obj2, (LatLngBounds) obj3);
                                return Unit.f139807a;
                            }
                        });
                        Updater.e(composerA, mapPropertiesG.b(), new Function2<MapPropertiesNode, MapStyleOptions, Unit>() { // from class: com.google.maps.android.compose.MapUpdaterKt$MapUpdater$2$10
                            {
                                super(2);
                            }

                            public final void c(MapPropertiesNode set, MapStyleOptions mapStyleOptions) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                googleMapI.t(mapStyleOptions);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                                c((MapPropertiesNode) obj2, (MapStyleOptions) obj3);
                                return Unit.f139807a;
                            }
                        });
                        Updater.e(composerA, mapPropertiesG.c(), new Function2<MapPropertiesNode, MapType, Unit>() { // from class: com.google.maps.android.compose.MapUpdaterKt$MapUpdater$2$11
                            {
                                super(2);
                            }

                            public final void c(MapPropertiesNode set, MapType it) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                Intrinsics.checkNotNullParameter(it, "it");
                                googleMapI.u(it.b());
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                                c((MapPropertiesNode) obj2, (MapType) obj3);
                                return Unit.f139807a;
                            }
                        });
                        Updater.e(composerA, Float.valueOf(mapPropertiesG.d()), new Function2<MapPropertiesNode, Float, Unit>() { // from class: com.google.maps.android.compose.MapUpdaterKt$MapUpdater$2$12
                            {
                                super(2);
                            }

                            public final void c(MapPropertiesNode set, float f3) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                googleMapI.v(f3);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                                c((MapPropertiesNode) obj2, ((Number) obj3).floatValue());
                                return Unit.f139807a;
                            }
                        });
                        Updater.e(composerA, Float.valueOf(mapPropertiesG.e()), new Function2<MapPropertiesNode, Float, Unit>() { // from class: com.google.maps.android.compose.MapUpdaterKt$MapUpdater$2$13
                            {
                                super(2);
                            }

                            public final void c(MapPropertiesNode set, float f3) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                googleMapI.w(f3);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                                c((MapPropertiesNode) obj2, ((Number) obj3).floatValue());
                                return Unit.f139807a;
                            }
                        });
                        Updater.e(composerA, paddingValuesE, new Function2<MapPropertiesNode, PaddingValues, Unit>() { // from class: com.google.maps.android.compose.MapUpdaterKt$MapUpdater$2$14
                            {
                                super(2);
                            }

                            public final void c(MapPropertiesNode set, PaddingValues it) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                Intrinsics.checkNotNullParameter(it, "it");
                                Density densityO = set.o();
                                googleMapI.S(densityO.z0(it.b(set.p())), densityO.z0(it.d()), densityO.z0(it.c(set.p())), densityO.z0(it.a()));
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                                c((MapPropertiesNode) obj2, (PaddingValues) obj3);
                                return Unit.f139807a;
                            }
                        });
                        Updater.e(composerA, Boolean.valueOf(mapUiSettingsF.a()), new Function2<MapPropertiesNode, Boolean, Unit>() { // from class: com.google.maps.android.compose.MapUpdaterKt$MapUpdater$2$15
                            {
                                super(2);
                            }

                            public final void c(MapPropertiesNode set, boolean z2) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                googleMapI.l().a(z2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                                c((MapPropertiesNode) obj2, ((Boolean) obj3).booleanValue());
                                return Unit.f139807a;
                            }
                        });
                        Updater.e(composerA, Boolean.valueOf(mapUiSettingsF.b()), new Function2<MapPropertiesNode, Boolean, Unit>() { // from class: com.google.maps.android.compose.MapUpdaterKt$MapUpdater$2$16
                            {
                                super(2);
                            }

                            public final void c(MapPropertiesNode set, boolean z2) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                googleMapI.l().b(z2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                                c((MapPropertiesNode) obj2, ((Boolean) obj3).booleanValue());
                                return Unit.f139807a;
                            }
                        });
                        Updater.e(composerA, Boolean.valueOf(mapUiSettingsF.c()), new Function2<MapPropertiesNode, Boolean, Unit>() { // from class: com.google.maps.android.compose.MapUpdaterKt$MapUpdater$2$17
                            {
                                super(2);
                            }

                            public final void c(MapPropertiesNode set, boolean z2) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                googleMapI.l().c(z2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                                c((MapPropertiesNode) obj2, ((Boolean) obj3).booleanValue());
                                return Unit.f139807a;
                            }
                        });
                        Updater.e(composerA, Boolean.valueOf(mapUiSettingsF.d()), new Function2<MapPropertiesNode, Boolean, Unit>() { // from class: com.google.maps.android.compose.MapUpdaterKt$MapUpdater$2$18
                            {
                                super(2);
                            }

                            public final void c(MapPropertiesNode set, boolean z2) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                googleMapI.l().d(z2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                                c((MapPropertiesNode) obj2, ((Boolean) obj3).booleanValue());
                                return Unit.f139807a;
                            }
                        });
                        Updater.e(composerA, Boolean.valueOf(mapUiSettingsF.e()), new Function2<MapPropertiesNode, Boolean, Unit>() { // from class: com.google.maps.android.compose.MapUpdaterKt$MapUpdater$2$19
                            {
                                super(2);
                            }

                            public final void c(MapPropertiesNode set, boolean z2) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                googleMapI.l().e(z2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                                c((MapPropertiesNode) obj2, ((Boolean) obj3).booleanValue());
                                return Unit.f139807a;
                            }
                        });
                        Updater.e(composerA, Boolean.valueOf(mapUiSettingsF.f()), new Function2<MapPropertiesNode, Boolean, Unit>() { // from class: com.google.maps.android.compose.MapUpdaterKt$MapUpdater$2$20
                            {
                                super(2);
                            }

                            public final void c(MapPropertiesNode set, boolean z2) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                googleMapI.l().f(z2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                                c((MapPropertiesNode) obj2, ((Boolean) obj3).booleanValue());
                                return Unit.f139807a;
                            }
                        });
                        Updater.e(composerA, Boolean.valueOf(mapUiSettingsF.g()), new Function2<MapPropertiesNode, Boolean, Unit>() { // from class: com.google.maps.android.compose.MapUpdaterKt$MapUpdater$2$21
                            {
                                super(2);
                            }

                            public final void c(MapPropertiesNode set, boolean z2) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                googleMapI.l().g(z2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                                c((MapPropertiesNode) obj2, ((Boolean) obj3).booleanValue());
                                return Unit.f139807a;
                            }
                        });
                        Updater.e(composerA, Boolean.valueOf(mapUiSettingsF.h()), new Function2<MapPropertiesNode, Boolean, Unit>() { // from class: com.google.maps.android.compose.MapUpdaterKt$MapUpdater$2$22
                            {
                                super(2);
                            }

                            public final void c(MapPropertiesNode set, boolean z2) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                googleMapI.l().h(z2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                                c((MapPropertiesNode) obj2, ((Boolean) obj3).booleanValue());
                                return Unit.f139807a;
                            }
                        });
                        Updater.e(composerA, Boolean.valueOf(mapUiSettingsF.i()), new Function2<MapPropertiesNode, Boolean, Unit>() { // from class: com.google.maps.android.compose.MapUpdaterKt$MapUpdater$2$23
                            {
                                super(2);
                            }

                            public final void c(MapPropertiesNode set, boolean z2) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                googleMapI.l().i(z2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                                c((MapPropertiesNode) obj2, ((Boolean) obj3).booleanValue());
                                return Unit.f139807a;
                            }
                        });
                        Updater.e(composerA, Boolean.valueOf(mapUiSettingsF.j()), new Function2<MapPropertiesNode, Boolean, Unit>() { // from class: com.google.maps.android.compose.MapUpdaterKt$MapUpdater$2$24
                            {
                                super(2);
                            }

                            public final void c(MapPropertiesNode set, boolean z2) {
                                Intrinsics.checkNotNullParameter(set, "$this$set");
                                googleMapI.l().j(z2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                                c((MapPropertiesNode) obj2, ((Boolean) obj3).booleanValue());
                                return Unit.f139807a;
                            }
                        });
                        Updater.h(composerA, cameraPositionStateD, new Function2<MapPropertiesNode, CameraPositionState, Unit>() { // from class: com.google.maps.android.compose.MapUpdaterKt$MapUpdater$2$25
                            public final void c(MapPropertiesNode update, CameraPositionState it) {
                                Intrinsics.checkNotNullParameter(update, "$this$update");
                                Intrinsics.checkNotNullParameter(it, "it");
                                update.A(it);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                                c((MapPropertiesNode) obj2, (CameraPositionState) obj3);
                                return Unit.f139807a;
                            }
                        });
                        Updater.h(composerA, mapClickListeners2, new Function2<MapPropertiesNode, MapClickListeners, Unit>() { // from class: com.google.maps.android.compose.MapUpdaterKt$MapUpdater$2$26
                            public final void c(MapPropertiesNode update, MapClickListeners it) {
                                Intrinsics.checkNotNullParameter(update, "$this$update");
                                Intrinsics.checkNotNullParameter(it, "it");
                                update.B(it);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                                c((MapPropertiesNode) obj2, (MapClickListeners) obj3);
                                return Unit.f139807a;
                            }
                        });
                        composer.y();
                        composer.Y();
                        composer.Y();
                        ProvidedValue[] providedValueArr = {CameraPositionStateKt.a().d(cameraPositionState)};
                        final State state7 = state6;
                        CompositionLocalKt.c(providedValueArr, ComposableLambdaKt.b(composer, 273030520, true, new Function2<Composer, Integer, Unit>() { // from class: com.google.maps.android.compose.GoogleMapKt$GoogleMap$10$1$1.1
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                                invoke((Composer) obj2, ((Number) obj3).intValue());
                                return Unit.f139807a;
                            }

                            public final void invoke(Composer composer2, int i6) {
                                if ((i6 & 11) == 2 && composer2.l()) {
                                    composer2.Q();
                                    return;
                                }
                                if (ComposerKt.M()) {
                                    ComposerKt.U(273030520, i6, -1, "com.google.maps.android.compose.GoogleMap.<anonymous>.<anonymous>.<anonymous>.<anonymous> (GoogleMap.kt:137)");
                                }
                                Function2 function2H = GoogleMapKt.h(state7);
                                if (function2H != null) {
                                    function2H.invoke(composer2, 0);
                                }
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
                this.f90682a = compositionContext2;
                this.f90683b = mapView2;
                this.f90684c = composableLambdaC;
                this.f90685d = this;
                this.f90686f = mapView2;
                this.f90687g = 1;
                final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.c(this));
                mapView2.a(new OnMapReadyCallback() { // from class: com.google.maps.android.compose.GoogleMapKt$newComposition$$inlined$awaitMap$1
                    @Override // com.google.android.gms.maps.OnMapReadyCallback
                    public final void a(GoogleMap googleMap) {
                        Intrinsics.checkNotNullParameter(googleMap, KqqtdetwHMIO.rAae);
                        safeContinuation.resumeWith(Result.b(googleMap));
                    }
                });
                objA = safeContinuation.a();
                if (objA == IntrinsicsKt.f()) {
                    DebugProbesKt.c(this);
                }
                if (objA != objF) {
                    mapView = mapView2;
                    function2 = composableLambdaC;
                    compositionContext = compositionContext2;
                }
                return objF;
            }
            if (i3 != 1) {
                if (i3 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                composition = (Composition) this.f90682a;
                try {
                    ResultKt.b(obj);
                    throw new KotlinNothingValueException();
                } catch (Throwable th) {
                    th = th;
                    composition.dispose();
                    throw th;
                }
            }
            function2 = (Function2) this.f90684c;
            MapView mapView3 = (MapView) this.f90683b;
            CompositionContext compositionContext3 = (CompositionContext) this.f90682a;
            ResultKt.b(obj);
            compositionContext = compositionContext3;
            mapView = mapView3;
            objA = obj;
            this.f90682a = compositionA;
            this.f90683b = null;
            this.f90684c = null;
            this.f90685d = null;
            this.f90686f = null;
            this.f90687g = 2;
            if (DelayKt.a(this) != objF) {
                composition = compositionA;
                throw new KotlinNothingValueException();
            }
            return objF;
        } catch (Throwable th2) {
            th = th2;
            composition = compositionA;
            composition.dispose();
            throw th;
        }
        compositionA = CompositionKt.a(new MapApplier((GoogleMap) objA, mapView), compositionContext);
        compositionA.f(function2);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((GoogleMapKt$GoogleMap$10) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
