package cz.mobilesoft.coreblock.util.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.lifecycle.LifecycleOwner;
import cz.mobilesoft.coreblock.base.ViewEvent;
import cz.mobilesoft.coreblock.base.ViewState;
import cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel;
import cz.mobilesoft.coreblock.util.helperextension.CoroutinesHelperExtKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class FlowExtKt {
    /* JADX WARN: Removed duplicated region for block: B:45:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00bf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void e(final kotlinx.coroutines.flow.Flow r7, androidx.lifecycle.LifecycleOwner r8, final kotlin.jvm.functions.Function2 r9, androidx.compose.runtime.Composer r10, final int r11, final int r12) {
        /*
            Method dump skipped, instruction units count: 219
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.compose.FlowExtKt.e(kotlinx.coroutines.flow.Flow, androidx.lifecycle.LifecycleOwner, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f(Flow flow, LifecycleOwner lifecycleOwner, Function2 function2, int i3, int i4, Composer composer, int i5) {
        e(flow, lifecycleOwner, function2, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x009f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void g(final cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel r7, androidx.lifecycle.LifecycleOwner r8, kotlin.jvm.functions.Function2 r9, androidx.compose.runtime.Composer r10, final int r11, final int r12) {
        /*
            java.lang.String r0 = "viewModel"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "block"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            r0 = -1386530212(0xffffffffad5b3a5c, float:-1.2461667E-11)
            androidx.compose.runtime.Composer r4 = r10.k(r0)
            r10 = r11 & 6
            if (r10 != 0) goto L20
            boolean r10 = r4.I(r7)
            if (r10 == 0) goto L1d
            r10 = 4
            goto L1e
        L1d:
            r10 = 2
        L1e:
            r10 = r10 | r11
            goto L21
        L20:
            r10 = r11
        L21:
            r1 = r11 & 48
            if (r1 != 0) goto L35
            r1 = r12 & 2
            if (r1 != 0) goto L32
            boolean r1 = r4.I(r8)
            if (r1 == 0) goto L32
            r1 = 32
            goto L34
        L32:
            r1 = 16
        L34:
            r10 = r10 | r1
        L35:
            r1 = r11 & 384(0x180, float:5.38E-43)
            if (r1 != 0) goto L45
            boolean r1 = r4.I(r9)
            if (r1 == 0) goto L42
            r1 = 256(0x100, float:3.59E-43)
            goto L44
        L42:
            r1 = 128(0x80, float:1.8E-43)
        L44:
            r10 = r10 | r1
        L45:
            r1 = r10 & 147(0x93, float:2.06E-43)
            r2 = 146(0x92, float:2.05E-43)
            if (r1 == r2) goto L4d
            r1 = 1
            goto L4e
        L4d:
            r1 = 0
        L4e:
            r2 = r10 & 1
            boolean r1 = r4.r(r1, r2)
            if (r1 == 0) goto La4
            r4.J()
            r1 = r11 & 1
            if (r1 == 0) goto L6f
            boolean r1 = r4.S()
            if (r1 == 0) goto L64
            goto L6f
        L64:
            r4.Q()
            r1 = r12 & 2
            if (r1 == 0) goto L6d
        L6b:
            r10 = r10 & (-113(0xffffffffffffff8f, float:NaN))
        L6d:
            r2 = r8
            goto L7e
        L6f:
            r1 = r12 & 2
            if (r1 == 0) goto L6d
            androidx.compose.runtime.ProvidableCompositionLocal r8 = androidx.lifecycle.compose.LocalLifecycleOwnerKt.c()
            java.lang.Object r8 = r4.q(r8)
            androidx.lifecycle.LifecycleOwner r8 = (androidx.lifecycle.LifecycleOwner) r8
            goto L6b
        L7e:
            r4.z()
            boolean r8 = androidx.compose.runtime.ComposerKt.M()
            if (r8 == 0) goto L8d
            r8 = -1
            java.lang.String r1 = "cz.mobilesoft.coreblock.util.compose.CollectCommand (FlowExt.kt:56)"
            androidx.compose.runtime.ComposerKt.U(r0, r10, r8, r1)
        L8d:
            kotlinx.coroutines.flow.Flow r1 = r7.J0()
            r5 = r10 & 1008(0x3f0, float:1.413E-42)
            r6 = 0
            r3 = r9
            e(r1, r2, r3, r4, r5, r6)
            r10 = r3
            boolean r8 = androidx.compose.runtime.ComposerKt.M()
            if (r8 == 0) goto La2
            androidx.compose.runtime.ComposerKt.T()
        La2:
            r9 = r2
            goto La9
        La4:
            r10 = r9
            r4.Q()
            r9 = r8
        La9:
            androidx.compose.runtime.ScopeUpdateScope r0 = r4.n()
            if (r0 == 0) goto Lb8
            r8 = r7
            cz.mobilesoft.coreblock.util.compose.l r7 = new cz.mobilesoft.coreblock.util.compose.l
            r7.<init>()
            r0.a(r7)
        Lb8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.compose.FlowExtKt.g(cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel, androidx.lifecycle.LifecycleOwner, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(BaseStatefulViewModel baseStatefulViewModel, LifecycleOwner lifecycleOwner, Function2 function2, int i3, int i4, Composer composer, int i5) {
        g(baseStatefulViewModel, lifecycleOwner, function2, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    public static final void i(Flow flow, CoroutineScope scope, FlowCollector collector) {
        Intrinsics.checkNotNullParameter(flow, "<this>");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(collector, "collector");
        BuildersKt__Builders_commonKt.d(scope, null, null, new FlowExtKt$collectAsStateFlow$1(flow, scope, collector, null), 3, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x009f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void j(final cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel r7, androidx.lifecycle.LifecycleOwner r8, kotlin.jvm.functions.Function2 r9, androidx.compose.runtime.Composer r10, final int r11, final int r12) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "block"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            r0 = 1335410472(0x4f98bf28, float:5.125329E9)
            androidx.compose.runtime.Composer r4 = r10.k(r0)
            r10 = r11 & 6
            if (r10 != 0) goto L20
            boolean r10 = r4.I(r7)
            if (r10 == 0) goto L1d
            r10 = 4
            goto L1e
        L1d:
            r10 = 2
        L1e:
            r10 = r10 | r11
            goto L21
        L20:
            r10 = r11
        L21:
            r1 = r11 & 48
            if (r1 != 0) goto L35
            r1 = r12 & 1
            if (r1 != 0) goto L32
            boolean r1 = r4.I(r8)
            if (r1 == 0) goto L32
            r1 = 32
            goto L34
        L32:
            r1 = 16
        L34:
            r10 = r10 | r1
        L35:
            r1 = r11 & 384(0x180, float:5.38E-43)
            if (r1 != 0) goto L45
            boolean r1 = r4.I(r9)
            if (r1 == 0) goto L42
            r1 = 256(0x100, float:3.59E-43)
            goto L44
        L42:
            r1 = 128(0x80, float:1.8E-43)
        L44:
            r10 = r10 | r1
        L45:
            r1 = r10 & 147(0x93, float:2.06E-43)
            r2 = 146(0x92, float:2.05E-43)
            if (r1 == r2) goto L4d
            r1 = 1
            goto L4e
        L4d:
            r1 = 0
        L4e:
            r2 = r10 & 1
            boolean r1 = r4.r(r1, r2)
            if (r1 == 0) goto La4
            r4.J()
            r1 = r11 & 1
            if (r1 == 0) goto L6f
            boolean r1 = r4.S()
            if (r1 == 0) goto L64
            goto L6f
        L64:
            r4.Q()
            r1 = r12 & 1
            if (r1 == 0) goto L6d
        L6b:
            r10 = r10 & (-113(0xffffffffffffff8f, float:NaN))
        L6d:
            r2 = r8
            goto L7e
        L6f:
            r1 = r12 & 1
            if (r1 == 0) goto L6d
            androidx.compose.runtime.ProvidableCompositionLocal r8 = androidx.lifecycle.compose.LocalLifecycleOwnerKt.c()
            java.lang.Object r8 = r4.q(r8)
            androidx.lifecycle.LifecycleOwner r8 = (androidx.lifecycle.LifecycleOwner) r8
            goto L6b
        L7e:
            r4.z()
            boolean r8 = androidx.compose.runtime.ComposerKt.M()
            if (r8 == 0) goto L8d
            r8 = -1
            java.lang.String r1 = "cz.mobilesoft.coreblock.util.compose.collectCommand (FlowExt.kt:64)"
            androidx.compose.runtime.ComposerKt.U(r0, r10, r8, r1)
        L8d:
            kotlinx.coroutines.flow.Flow r1 = r7.J0()
            r5 = r10 & 1008(0x3f0, float:1.413E-42)
            r6 = 0
            r3 = r9
            e(r1, r2, r3, r4, r5, r6)
            r10 = r3
            boolean r8 = androidx.compose.runtime.ComposerKt.M()
            if (r8 == 0) goto La2
            androidx.compose.runtime.ComposerKt.T()
        La2:
            r9 = r2
            goto La9
        La4:
            r10 = r9
            r4.Q()
            r9 = r8
        La9:
            androidx.compose.runtime.ScopeUpdateScope r0 = r4.n()
            if (r0 == 0) goto Lb8
            r8 = r7
            cz.mobilesoft.coreblock.util.compose.m r7 = new cz.mobilesoft.coreblock.util.compose.m
            r7.<init>()
            r0.a(r7)
        Lb8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.compose.FlowExtKt.j(cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel, androidx.lifecycle.LifecycleOwner, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(BaseStatefulViewModel baseStatefulViewModel, LifecycleOwner lifecycleOwner, Function2 function2, int i3, int i4, Composer composer, int i5) {
        j(baseStatefulViewModel, lifecycleOwner, function2, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    public static final void l(Flow flow, CoroutineScope scope, FlowCollector collector) {
        Intrinsics.checkNotNullParameter(flow, "<this>");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(collector, "collector");
        BuildersKt__Builders_commonKt.d(scope, null, null, new FlowExtKt$collectDistinctWithDrop$1(flow, collector, null), 3, null);
    }

    public static final ViewState m(BaseStatefulViewModel baseStatefulViewModel, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(baseStatefulViewModel, "<this>");
        if (ComposerKt.M()) {
            ComposerKt.U(-611001581, i3, -1, "cz.mobilesoft.coreblock.util.compose.collectState (FlowExt.kt:29)");
        }
        ViewState viewState = (ViewState) androidx.lifecycle.compose.FlowExtKt.b(baseStatefulViewModel.M0(), baseStatefulViewModel.L0(), null, null, null, composer, 0, 14).getValue();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return viewState;
    }

    public static final Function1 n(final BaseStatefulViewModel baseStatefulViewModel, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(baseStatefulViewModel, "<this>");
        if (ComposerKt.M()) {
            ComposerKt.U(794880841, i3, -1, "cz.mobilesoft.coreblock.util.compose.getOnEvent (FlowExt.kt:37)");
        }
        Object objG = composer.G();
        Composer.Companion companion = Composer.f23746a;
        if (objG == companion.a()) {
            objG = EffectsKt.l(EmptyCoroutineContext.f139889a, composer);
            composer.w(objG);
        }
        final CoroutineScope coroutineScopeI = CoroutineScopeKt.i((CoroutineScope) objG, CoroutinesHelperExtKt.b());
        Object objG2 = composer.G();
        if (objG2 == companion.a()) {
            objG2 = new Function1() { // from class: cz.mobilesoft.coreblock.util.compose.k
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return FlowExtKt.o(coroutineScopeI, baseStatefulViewModel, (ViewEvent) obj);
                }
            };
            composer.w(objG2);
        }
        Function1 function1 = (Function1) objG2;
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return function1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(CoroutineScope coroutineScope, BaseStatefulViewModel baseStatefulViewModel, ViewEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new FlowExtKt$getOnEvent$1$1$1(baseStatefulViewModel, event, null), 3, null);
        return Unit.f139807a;
    }
}
