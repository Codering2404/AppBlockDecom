package cz.mobilesoft.coreblock.view.compose;

import androidx.activity.compose.ActivityResultRegistryKt;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParserException;

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
public final class ComposeCommonsKt {
    /* JADX WARN: Removed duplicated region for block: B:46:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00f1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void g(java.lang.String r16, float r17, androidx.compose.runtime.Composer r18, final int r19, final int r20) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            Method dump skipped, instruction units count: 265
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.view.compose.ComposeCommonsKt.g(java.lang.String, float, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final boolean h(MutableState mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    private static final void i(MutableState mutableState, boolean z2) {
        mutableState.setValue(Boolean.valueOf(z2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult j(MutableState mutableState, DisposableEffectScope DisposableEffect) {
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        i(mutableState, !h(mutableState));
        return new DisposableEffectResult() { // from class: cz.mobilesoft.coreblock.view.compose.ComposeCommonsKt$AnimatedCheckmark_rAjV9yQ$lambda$3$0$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(String str, float f3, int i3, int i4, Composer composer, int i5) throws XmlPullParserException, IOException {
        g(str, f3, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0092  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void l(long r17, androidx.compose.runtime.Composer r19, final int r20, final int r21) {
        /*
            r0 = r20
            r1 = r21
            r2 = 1954228558(0x747b294e, float:7.959621E31)
            r3 = r19
            androidx.compose.runtime.Composer r3 = r3.k(r2)
            r4 = r0 & 6
            r5 = 2
            if (r4 != 0) goto L23
            r4 = r1 & 1
            r6 = r17
            if (r4 != 0) goto L20
            boolean r4 = r3.f(r6)
            if (r4 == 0) goto L20
            r4 = 4
            goto L21
        L20:
            r4 = r5
        L21:
            r4 = r4 | r0
            goto L26
        L23:
            r6 = r17
            r4 = r0
        L26:
            r8 = r4 & 3
            r9 = 0
            r10 = 1
            if (r8 == r5) goto L2e
            r5 = r10
            goto L2f
        L2e:
            r5 = r9
        L2f:
            r8 = r4 & 1
            boolean r5 = r3.r(r5, r8)
            if (r5 == 0) goto L96
            r3.J()
            r5 = r0 & 1
            if (r5 == 0) goto L50
            boolean r5 = r3.S()
            if (r5 == 0) goto L45
            goto L50
        L45:
            r3.Q()
            r5 = r1 & 1
            if (r5 == 0) goto L4e
            r4 = r4 & (-15)
        L4e:
            r12 = r6
            goto L5f
        L50:
            r5 = r1 & 1
            if (r5 == 0) goto L4e
            cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette r5 = cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt.j(r3, r9)
            long r5 = r5.e()
            r4 = r4 & (-15)
            r12 = r5
        L5f:
            r3.z()
            boolean r5 = androidx.compose.runtime.ComposerKt.M()
            if (r5 == 0) goto L6e
            r5 = -1
            java.lang.String r6 = "cz.mobilesoft.coreblock.view.compose.StatusBarSpacer (ComposeCommons.kt:104)"
            androidx.compose.runtime.ComposerKt.U(r2, r4, r5, r6)
        L6e:
            androidx.compose.ui.Modifier$Companion r11 = androidx.compose.ui.Modifier.b8
            r15 = 2
            r16 = 0
            r14 = 0
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.BackgroundKt.d(r11, r12, r14, r15, r16)
            r4 = 0
            r5 = 0
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.SizeKt.h(r2, r4, r10, r5)
            androidx.compose.foundation.layout.WindowInsets$Companion r4 = androidx.compose.foundation.layout.WindowInsets.f7172a
            r5 = 6
            androidx.compose.foundation.layout.WindowInsets r4 = androidx.compose.foundation.layout.WindowInsets_androidKt.e(r4, r3, r5)
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.WindowInsetsSizeKt.b(r2, r4)
            androidx.compose.foundation.layout.SpacerKt.a(r2, r3, r9)
            boolean r2 = androidx.compose.runtime.ComposerKt.M()
            if (r2 == 0) goto L9a
            androidx.compose.runtime.ComposerKt.T()
            goto L9a
        L96:
            r3.Q()
            r12 = r6
        L9a:
            androidx.compose.runtime.ScopeUpdateScope r2 = r3.n()
            if (r2 == 0) goto La8
            cz.mobilesoft.coreblock.view.compose.t4 r3 = new cz.mobilesoft.coreblock.view.compose.t4
            r3.<init>()
            r2.a(r3)
        La8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.view.compose.ComposeCommonsKt.l(long, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(long j3, int i3, int i4, Composer composer, int i5) {
        l(j3, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x028d  */
    /* JADX WARN: Removed duplicated region for block: B:90:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void n(final java.lang.String r27, kotlin.jvm.functions.Function0 r28, kotlin.jvm.functions.Function3 r29, androidx.compose.runtime.Composer r30, final int r31, final int r32) {
        /*
            Method dump skipped, instruction units count: 668
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.view.compose.ComposeCommonsKt.n(java.lang.String, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(String str, Function0 function0, Function3 function3, int i3, int i4, Composer composer, int i5) {
        n(str, function0, function3, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    public static final ActivityLauncher p(final Object obj, final Function2 onResult, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(onResult, "onResult");
        if (ComposerKt.M()) {
            ComposerKt.U(-1082284133, i3, -1, "cz.mobilesoft.coreblock.view.compose.getActivityLauncherWithCondition (ComposeCommons.kt:120)");
        }
        Object[] objArr = new Object[0];
        boolean z2 = true;
        boolean z3 = (((i3 & 14) ^ 6) > 4 && composer.I(obj)) || (i3 & 6) == 4;
        Object objG = composer.G();
        if (z3 || objG == Composer.f23746a.a()) {
            objG = new Function0() { // from class: cz.mobilesoft.coreblock.view.compose.u4
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ComposeCommonsKt.q(obj);
                }
            };
            composer.w(objG);
        }
        final MutableState mutableState = (MutableState) RememberSaveableKt.e(objArr, null, null, (Function0) objG, composer, 0, 6);
        ActivityResultContracts.StartActivityForResult startActivityForResult = new ActivityResultContracts.StartActivityForResult();
        if ((((i3 & 112) ^ 48) <= 32 || !composer.Z(onResult)) && (i3 & 48) != 32) {
            z2 = false;
        }
        boolean Z = composer.Z(mutableState) | z2;
        Object objG2 = composer.G();
        if (Z || objG2 == Composer.f23746a.a()) {
            objG2 = new Function1() { // from class: cz.mobilesoft.coreblock.view.compose.v4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return ComposeCommonsKt.r(onResult, mutableState, (ActivityResult) obj2);
                }
            };
            composer.w(objG2);
        }
        ActivityLauncher activityLauncher = new ActivityLauncher(ActivityResultRegistryKt.a(startActivityForResult, (Function1) objG2, composer, 0), mutableState);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return activityLauncher;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableState q(Object obj) {
        return SnapshotStateKt__SnapshotStateKt.e(obj, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r(Function2 function2, MutableState mutableState, ActivityResult it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function2.invoke(it, mutableState.getValue());
        return Unit.f139807a;
    }
}
