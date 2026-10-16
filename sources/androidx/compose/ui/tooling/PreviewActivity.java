package androidx.compose.ui.tooling;

import android.os.Bundle;
import android.util.Log;
import androidx.activity.ComponentActivity;
import androidx.activity.compose.ComponentActivityKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material.FloatingActionButtonKt;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import c1.ub.AsHNMpHTEsKfE;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class PreviewActivity extends ComponentActivity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f29745a = "PreviewActivity";

    /* JADX INFO: Access modifiers changed from: private */
    public final void I(String str) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Log.d(this.f29745a, "PreviewActivity has composable " + str);
        final String strQ1 = StringsKt.q1(str, '.', null, 2, null);
        final String strI1 = StringsKt.i1(str, '.', null, 2, null);
        String stringExtra = getIntent().getStringExtra("parameterProviderClassName");
        if (stringExtra != null) {
            J(strQ1, strI1, stringExtra);
            return;
        }
        Log.d(this.f29745a, "Previewing '" + strI1 + "' without a parameter provider.");
        ComponentActivityKt.b(this, null, ComposableLambdaKt.c(-840626948, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.tooling.PreviewActivity$setComposableContent$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) throws Exception {
                invoke((Composer) obj, ((Number) obj2).intValue());
                return Unit.f139807a;
            }

            public final void invoke(Composer composer, int i3) throws Exception {
                if (!composer.r((i3 & 3) != 2, i3 & 1)) {
                    composer.Q();
                    return;
                }
                if (ComposerKt.M()) {
                    ComposerKt.U(-840626948, i3, -1, "androidx.compose.ui.tooling.PreviewActivity.setComposableContent.<anonymous> (PreviewActivity.android.kt:74)");
                }
                ComposableInvoker.f29668a.g(strQ1, strI1, composer, new Object[0]);
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
            }
        }), 1, null);
    }

    private final void J(final String str, final String str2, String str3) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Log.d(this.f29745a, "Previewing '" + str2 + "' with parameter provider: '" + str3 + '\'');
        final Object[] objArrF = PreviewUtils_androidKt.f(PreviewUtils_androidKt.a(str3), getIntent().getIntExtra("parameterProviderIndex", -1));
        if (objArrF.length > 1) {
            ComponentActivityKt.b(this, null, ComposableLambdaKt.c(-861939235, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.tooling.PreviewActivity$setParameterizedContent$1
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
                    if (!composer.r((i3 & 3) != 2, i3 & 1)) {
                        composer.Q();
                        return;
                    }
                    if (ComposerKt.M()) {
                        ComposerKt.U(-861939235, i3, -1, "androidx.compose.ui.tooling.PreviewActivity.setParameterizedContent.<anonymous> (PreviewActivity.android.kt:103)");
                    }
                    Object objG = composer.G();
                    if (objG == Composer.f23746a.a()) {
                        objG = SnapshotIntStateKt.a(0);
                        composer.w(objG);
                    }
                    final MutableIntState mutableIntState = (MutableIntState) objG;
                    final Object[] objArr = objArrF;
                    ComposableLambda composableLambdaE = ComposableLambdaKt.e(958604965, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.tooling.PreviewActivity$setParameterizedContent$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.f139807a;
                        }

                        public final void invoke(Composer composer2, int i4) {
                            if (!composer2.r((i4 & 3) != 2, i4 & 1)) {
                                composer2.Q();
                                return;
                            }
                            if (ComposerKt.M()) {
                                ComposerKt.U(958604965, i4, -1, "androidx.compose.ui.tooling.PreviewActivity.setParameterizedContent.<anonymous>.<anonymous> (PreviewActivity.android.kt:117)");
                            }
                            Function2 function2A = ComposableSingletons$PreviewActivity_androidKt.f29676a.a();
                            boolean zI = composer2.I(objArr);
                            final MutableIntState mutableIntState2 = mutableIntState;
                            final Object[] objArr2 = objArr;
                            Object objG2 = composer2.G();
                            if (zI || objG2 == Composer.f23746a.a()) {
                                objG2 = new Function0<Unit>() { // from class: androidx.compose.ui.tooling.PreviewActivity$setParameterizedContent$1$1$1$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public /* bridge */ /* synthetic */ Object invoke() {
                                        m267invoke();
                                        return Unit.f139807a;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                                    public final void m267invoke() {
                                        MutableIntState mutableIntState3 = mutableIntState2;
                                        mutableIntState3.a((mutableIntState3.g() + 1) % objArr2.length);
                                    }
                                };
                                composer2.w(objG2);
                            }
                            FloatingActionButtonKt.a(function2A, (Function0) objG2, null, null, null, null, 0L, 0L, null, composer2, 6, 508);
                            if (ComposerKt.M()) {
                                ComposerKt.T();
                            }
                        }
                    }, composer, 54);
                    final String str4 = str;
                    final String str5 = str2;
                    final Object[] objArr2 = objArrF;
                    ScaffoldKt.a(null, null, null, null, null, composableLambdaE, 0, false, null, false, null, 0.0f, 0L, 0L, 0L, 0L, 0L, ComposableLambdaKt.e(57310875, true, new Function3<PaddingValues, Composer, Integer, Unit>() { // from class: androidx.compose.ui.tooling.PreviewActivity$setParameterizedContent$1.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) throws Exception {
                            invoke((PaddingValues) obj, (Composer) obj2, ((Number) obj3).intValue());
                            return Unit.f139807a;
                        }

                        public final void invoke(PaddingValues paddingValues, Composer composer2, int i4) throws Exception {
                            if ((i4 & 6) == 0) {
                                i4 |= composer2.Z(paddingValues) ? 4 : 2;
                            }
                            if (!composer2.r((i4 & 19) != 18, i4 & 1)) {
                                composer2.Q();
                                return;
                            }
                            if (ComposerKt.M()) {
                                ComposerKt.U(57310875, i4, -1, "androidx.compose.ui.tooling.PreviewActivity.setParameterizedContent.<anonymous>.<anonymous> (PreviewActivity.android.kt:107)");
                            }
                            Modifier modifierH = PaddingKt.h(Modifier.b8, paddingValues);
                            String str6 = str4;
                            String str7 = str5;
                            Object[] objArr3 = objArr2;
                            MutableIntState mutableIntState2 = mutableIntState;
                            MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.o(), false);
                            int iA = ComposablesKt.a(composer2, 0);
                            CompositionLocalMap compositionLocalMapU = composer2.u();
                            Modifier modifierF = ComposedModifierKt.f(composer2, modifierH);
                            ComposeUiNode.Companion companion = ComposeUiNode.f8;
                            Function0 function0A = companion.a();
                            if (composer2.m() == null) {
                                ComposablesKt.c();
                            }
                            composer2.L();
                            if (composer2.i()) {
                                composer2.P(function0A);
                            } else {
                                composer2.v();
                            }
                            Composer composerA = Updater.a(composer2);
                            Updater.e(composerA, measurePolicyG, companion.e());
                            Updater.e(composerA, compositionLocalMapU, companion.g());
                            Function2 function2B = companion.b();
                            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                                composerA.w(Integer.valueOf(iA));
                                composerA.p(Integer.valueOf(iA), function2B);
                            }
                            Updater.e(composerA, modifierF, companion.f());
                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
                            ComposableInvoker.f29668a.g(str6, str7, composer2, objArr3[mutableIntState2.g()]);
                            composer2.y();
                            if (ComposerKt.M()) {
                                ComposerKt.T();
                            }
                        }
                    }, composer, 54), composer, 196608, 12582912, 131039);
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                }
            }), 1, null);
        } else {
            ComponentActivityKt.b(this, null, ComposableLambdaKt.c(-1901447514, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.tooling.PreviewActivity$setParameterizedContent$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) throws Exception {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer, int i3) throws Exception {
                    if (!composer.r((i3 & 3) != 2, i3 & 1)) {
                        composer.Q();
                        return;
                    }
                    if (ComposerKt.M()) {
                        ComposerKt.U(-1901447514, i3, -1, "androidx.compose.ui.tooling.PreviewActivity.setParameterizedContent.<anonymous> (PreviewActivity.android.kt:128)");
                    }
                    ComposableInvoker composableInvoker = ComposableInvoker.f29668a;
                    String str4 = str;
                    String str5 = str2;
                    Object[] objArr = objArrF;
                    composableInvoker.g(str4, str5, composer, Arrays.copyOf(objArr, objArr.length));
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                }
            }), 1, null);
        }
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) throws IllegalAccessException, InvocationTargetException {
        AsHNMpHTEsKfE.IwwXwlR.invoke(null, this, bundle);
    }
}
