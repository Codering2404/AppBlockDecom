package androidx.compose.material;

import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

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
public final class ScaffoldKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ProvidableCompositionLocal f13632a = CompositionLocalKt.g(new Function0<FabPlacement>() { // from class: androidx.compose.material.ScaffoldKt$LocalFabPlacement$1
        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final FabPlacement invoke() {
            return null;
        }
    });

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final float f13633b = Dp.g(16);

    /* JADX WARN: Removed duplicated region for block: B:100:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x020f  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0262  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x02c4  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x02c6  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x02cd  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x02da  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x02e3  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x02ee  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x02f7  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x0300  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x0309  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x030d  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x030f  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x0313  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x0315  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x031c  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x032b  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x0330  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x0337  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x033d  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x0350  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x035b  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x0366  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x036c  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x037b  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x038b  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x039b  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x03a3  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x03ce  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x03ee  */
    /* JADX WARN: Removed duplicated region for block: B:284:0x0451  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x0471  */
    /* JADX WARN: Removed duplicated region for block: B:290:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x010f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void a(androidx.compose.ui.Modifier r39, androidx.compose.material.ScaffoldState r40, kotlin.jvm.functions.Function2 r41, kotlin.jvm.functions.Function2 r42, kotlin.jvm.functions.Function3 r43, kotlin.jvm.functions.Function2 r44, int r45, boolean r46, kotlin.jvm.functions.Function3 r47, boolean r48, androidx.compose.ui.graphics.Shape r49, float r50, long r51, long r53, long r55, long r57, long r59, final kotlin.jvm.functions.Function3 r61, androidx.compose.runtime.Composer r62, final int r63, final int r64, final int r65) {
        /*
            Method dump skipped, instruction units count: 1161
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ScaffoldKt.a(androidx.compose.ui.Modifier, androidx.compose.material.ScaffoldState, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function2, int, boolean, kotlin.jvm.functions.Function3, boolean, androidx.compose.ui.graphics.Shape, float, long, long, long, long, long, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0239  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0256  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x028a  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x02ed  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x02ef  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x02f6  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x0303  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x030a  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x030e  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x0317  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x0320  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x0329  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x0330  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x0334  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x0336  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x033a  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x033c  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x0340  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x0342  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x034f  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x035e  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x0363  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x036a  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x0370  */
    /* JADX WARN: Removed duplicated region for block: B:275:0x0388  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x0394  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x03a2  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x03aa  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x03b7  */
    /* JADX WARN: Removed duplicated region for block: B:286:0x03be  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x03d0  */
    /* JADX WARN: Removed duplicated region for block: B:290:0x03d8  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x03f2  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x040a  */
    /* JADX WARN: Removed duplicated region for block: B:295:0x0416  */
    /* JADX WARN: Removed duplicated region for block: B:298:0x041d  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x041f  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x042e  */
    /* JADX WARN: Removed duplicated region for block: B:307:0x046b  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x04cd  */
    /* JADX WARN: Removed duplicated region for block: B:311:0x04ec  */
    /* JADX WARN: Removed duplicated region for block: B:315:0x0516  */
    /* JADX WARN: Removed duplicated region for block: B:317:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0109  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void b(final androidx.compose.foundation.layout.WindowInsets r44, androidx.compose.ui.Modifier r45, androidx.compose.material.ScaffoldState r46, kotlin.jvm.functions.Function2 r47, kotlin.jvm.functions.Function2 r48, kotlin.jvm.functions.Function3 r49, kotlin.jvm.functions.Function2 r50, int r51, boolean r52, kotlin.jvm.functions.Function3 r53, boolean r54, androidx.compose.ui.graphics.Shape r55, float r56, long r57, long r59, long r61, long r63, long r65, final kotlin.jvm.functions.Function3 r67, androidx.compose.runtime.Composer r68, final int r69, final int r70, final int r71) {
        /*
            Method dump skipped, instruction units count: 1326
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ScaffoldKt.b(androidx.compose.foundation.layout.WindowInsets, androidx.compose.ui.Modifier, androidx.compose.material.ScaffoldState, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function2, int, boolean, kotlin.jvm.functions.Function3, boolean, androidx.compose.ui.graphics.Shape, float, long, long, long, long, long, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(final boolean z2, final int i3, final Function2 function2, final Function3 function3, final Function2 function22, final Function2 function23, final WindowInsets windowInsets, final Function2 function24, Composer composer, final int i4) {
        int i5;
        Function3 function32;
        Function2 function25;
        int i6;
        Composer composerK = composer.k(-468424875);
        if ((i4 & 6) == 0) {
            i5 = (composerK.b(z2) ? 4 : 2) | i4;
        } else {
            i5 = i4;
        }
        if ((i4 & 48) == 0) {
            i5 |= composerK.e(i3) ? 32 : 16;
        }
        if ((i4 & 384) == 0) {
            i5 |= composerK.I(function2) ? 256 : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i4 & 3072) == 0) {
            function32 = function3;
            i5 |= composerK.I(function32) ? 2048 : 1024;
        } else {
            function32 = function3;
        }
        if ((i4 & 24576) == 0) {
            i5 |= composerK.I(function22) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((196608 & i4) == 0) {
            function25 = function23;
            i5 |= composerK.I(function25) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        } else {
            function25 = function23;
        }
        if ((i4 & 1572864) == 0) {
            i5 |= composerK.Z(windowInsets) ? 1048576 : 524288;
        }
        if ((i4 & 12582912) == 0) {
            i5 |= composerK.I(function24) ? 8388608 : 4194304;
        }
        if ((i5 & 4793491) == 4793490 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-468424875, i5, -1, "androidx.compose.material.ScaffoldLayout (Scaffold.kt:390)");
            }
            boolean z3 = ((i5 & 896) == 256) | ((57344 & i5) == 16384) | ((3670016 & i5) == 1048576) | ((458752 & i5) == 131072) | ((i5 & 112) == 32) | ((i5 & 14) == 4) | ((29360128 & i5) == 8388608) | ((i5 & 7168) == 2048);
            Object objG = composerK.G();
            if (z3 || objG == Composer.f23746a.a()) {
                final Function3 function33 = function32;
                i6 = 1;
                final Function2 function26 = function25;
                Function2<SubcomposeMeasureScope, Constraints, MeasureResult> function27 = new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.material.ScaffoldKt$ScaffoldLayout$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        return m132invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).r());
                    }

                    /* JADX WARN: Removed duplicated region for block: B:93:0x0237  */
                    /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public final androidx.compose.ui.layout.MeasureResult m132invoke0kLqBqw(final androidx.compose.ui.layout.SubcomposeMeasureScope r34, long r35) {
                        /*
                            Method dump skipped, instruction units count: 895
                            To view this dump change 'Code comments level' option to 'DEBUG'
                        */
                        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ScaffoldKt$ScaffoldLayout$1$1.m132invoke0kLqBqw(androidx.compose.ui.layout.SubcomposeMeasureScope, long):androidx.compose.ui.layout.MeasureResult");
                    }
                };
                composerK.w(function27);
                objG = function27;
            } else {
                i6 = 1;
            }
            SubcomposeLayoutKt.a(null, (Function2) objG, composerK, 0, i6);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$ScaffoldLayout$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i7) {
                    ScaffoldKt.c(z2, i3, function2, function3, function22, function23, windowInsets, function24, composer2, RecomposeScopeImplKt.a(i4 | 1));
                }
            });
        }
    }

    public static final ProvidableCompositionLocal f() {
        return f13632a;
    }

    public static final ScaffoldState g(DrawerState drawerState, SnackbarHostState snackbarHostState, Composer composer, int i3, int i4) {
        if ((i4 & 1) != 0) {
            drawerState = DrawerKt.r(DrawerValue.Closed, null, composer, 6, 2);
        }
        if ((i4 & 2) != 0) {
            Object objG = composer.G();
            if (objG == Composer.f23746a.a()) {
                objG = new SnackbarHostState();
                composer.w(objG);
            }
            snackbarHostState = (SnackbarHostState) objG;
        }
        if (ComposerKt.M()) {
            ComposerKt.U(1569641925, i3, -1, "androidx.compose.material.rememberScaffoldState (Scaffold.kt:74)");
        }
        Object objG2 = composer.G();
        if (objG2 == Composer.f23746a.a()) {
            objG2 = new ScaffoldState(drawerState, snackbarHostState);
            composer.w(objG2);
        }
        ScaffoldState scaffoldState = (ScaffoldState) objG2;
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return scaffoldState;
    }
}
