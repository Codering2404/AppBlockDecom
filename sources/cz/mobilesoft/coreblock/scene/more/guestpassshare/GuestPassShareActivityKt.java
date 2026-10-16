package cz.mobilesoft.coreblock.scene.more.guestpassshare;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

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
public final class GuestPassShareActivityKt {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void g(cz.mobilesoft.coreblock.scene.more.guestpassshare.GuestPassShareBottomButtonState r17, java.lang.String r18, final kotlin.jvm.functions.Function2 r19, androidx.compose.runtime.Composer r20, final int r21, final int r22) {
        /*
            r3 = r19
            r4 = r21
            r0 = -309592171(0xffffffffed8bff95, float:-5.4159245E27)
            r1 = r20
            androidx.compose.runtime.Composer r14 = r1.k(r0)
            r1 = r4 & 6
            if (r1 != 0) goto L20
            int r1 = r17.ordinal()
            boolean r1 = r14.e(r1)
            if (r1 == 0) goto L1d
            r1 = 4
            goto L1e
        L1d:
            r1 = 2
        L1e:
            r1 = r1 | r4
            goto L21
        L20:
            r1 = r4
        L21:
            r2 = r22 & 2
            if (r2 == 0) goto L2a
            r1 = r1 | 48
        L27:
            r5 = r18
            goto L3c
        L2a:
            r5 = r4 & 48
            if (r5 != 0) goto L27
            r5 = r18
            boolean r6 = r14.Z(r5)
            if (r6 == 0) goto L39
            r6 = 32
            goto L3b
        L39:
            r6 = 16
        L3b:
            r1 = r1 | r6
        L3c:
            r6 = r4 & 384(0x180, float:5.38E-43)
            if (r6 != 0) goto L4c
            boolean r6 = r14.I(r3)
            if (r6 == 0) goto L49
            r6 = 256(0x100, float:3.59E-43)
            goto L4b
        L49:
            r6 = 128(0x80, float:1.8E-43)
        L4b:
            r1 = r1 | r6
        L4c:
            r6 = r1 & 147(0x93, float:2.06E-43)
            r7 = 146(0x92, float:2.05E-43)
            r8 = 1
            if (r6 == r7) goto L55
            r6 = r8
            goto L56
        L55:
            r6 = 0
        L56:
            r7 = r1 & 1
            boolean r6 = r14.r(r6, r7)
            if (r6 == 0) goto L98
            if (r2 == 0) goto L62
            r2 = 0
            goto L63
        L62:
            r2 = r5
        L63:
            boolean r5 = androidx.compose.runtime.ComposerKt.M()
            if (r5 == 0) goto L6f
            r5 = -1
            java.lang.String r6 = "cz.mobilesoft.coreblock.scene.more.guestpassshare.GuestPassShareScreenScaffoldPreview (GuestPassShareActivity.kt:451)"
            androidx.compose.runtime.ComposerKt.U(r0, r1, r5, r6)
        L6f:
            cz.mobilesoft.coreblock.scene.more.guestpassshare.g0 r0 = new cz.mobilesoft.coreblock.scene.more.guestpassshare.g0
            r1 = r17
            r0.<init>()
            r5 = 54
            r6 = 1689080611(0x64ad5323, float:2.5578219E22)
            androidx.compose.runtime.internal.ComposableLambda r13 = androidx.compose.runtime.internal.ComposableLambdaKt.e(r6, r8, r0, r14, r5)
            r15 = 12582912(0xc00000, float:1.7632415E-38)
            r16 = 127(0x7f, float:1.78E-43)
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r12 = 0
            cz.mobilesoft.coreblock.view.compose.ComposeBackgroundKt.m(r5, r6, r7, r8, r9, r10, r12, r13, r14, r15, r16)
            boolean r0 = androidx.compose.runtime.ComposerKt.M()
            if (r0 == 0) goto L9e
            androidx.compose.runtime.ComposerKt.T()
            goto L9e
        L98:
            r1 = r17
            r14.Q()
            r2 = r5
        L9e:
            androidx.compose.runtime.ScopeUpdateScope r6 = r14.n()
            if (r6 == 0) goto Lae
            cz.mobilesoft.coreblock.scene.more.guestpassshare.h0 r0 = new cz.mobilesoft.coreblock.scene.more.guestpassshare.h0
            r5 = r22
            r0.<init>()
            r6.a(r0)
        Lae:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.guestpassshare.GuestPassShareActivityKt.g(cz.mobilesoft.coreblock.scene.more.guestpassshare.GuestPassShareBottomButtonState, java.lang.String, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(final GuestPassShareBottomButtonState guestPassShareBottomButtonState, final String str, final Function2 function2, BoxScope GradientBox, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(GradientBox, "$this$GradientBox");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1689080611, i3, -1, "cz.mobilesoft.coreblock.scene.more.guestpassshare.GuestPassShareScreenScaffoldPreview.<anonymous> (GuestPassShareActivity.kt:453)");
            }
            ScaffoldKt.a(null, ComposableSingletons$GuestPassShareActivityKt.f107414a.o(), ComposableLambdaKt.e(782954238, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.guestpassshare.i0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return GuestPassShareActivityKt.i(guestPassShareBottomButtonState, str, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), null, null, 0, Color.f25715b.j(), 0L, null, ComposableLambdaKt.e(-448183436, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.more.guestpassshare.j0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return GuestPassShareActivityKt.l(function2, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 806879664, 441);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0237  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final kotlin.Unit i(cz.mobilesoft.coreblock.scene.more.guestpassshare.GuestPassShareBottomButtonState r31, java.lang.String r32, androidx.compose.runtime.Composer r33, int r34) {
        /*
            Method dump skipped, instruction units count: 577
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.guestpassshare.GuestPassShareActivityKt.i(cz.mobilesoft.coreblock.scene.more.guestpassshare.GuestPassShareBottomButtonState, java.lang.String, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(Function2 function2, PaddingValues it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(it, "it");
        if ((i3 & 6) == 0) {
            i3 |= composer.Z(it) ? 4 : 2;
        }
        if (composer.r((i3 & 19) != 18, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-448183436, i3, -1, "cz.mobilesoft.coreblock.scene.more.guestpassshare.GuestPassShareScreenScaffoldPreview.<anonymous>.<anonymous> (GuestPassShareActivity.kt:497)");
            }
            Modifier modifierH = PaddingKt.h(Modifier.b8, it);
            MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.o(), false);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierH);
            ComposeUiNode.Companion companion = ComposeUiNode.f8;
            Function0 function0A = companion.a();
            if (composer.m() == null) {
                ComposablesKt.c();
            }
            composer.L();
            if (composer.i()) {
                composer.P(function0A);
            } else {
                composer.v();
            }
            Composer composerA = Updater.a(composer);
            Updater.e(composerA, measurePolicyG, companion.e());
            Updater.e(composerA, compositionLocalMapU, companion.g());
            Function2 function2B = companion.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            function2.invoke(composer, 0);
            composer.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(GuestPassShareBottomButtonState guestPassShareBottomButtonState, String str, Function2 function2, int i3, int i4, Composer composer, int i5) {
        g(guestPassShareBottomButtonState, str, function2, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }
}
