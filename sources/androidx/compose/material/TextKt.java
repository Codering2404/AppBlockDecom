package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.text.TextStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

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
public final class TextKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ProvidableCompositionLocal f14984a = CompositionLocalKt.d(SnapshotStateKt.r(), new Function0<TextStyle>() { // from class: androidx.compose.material.TextKt$LocalTextStyle$1
        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final TextStyle invoke() {
            return TypographyKt.b();
        }
    });

    public static final void a(final TextStyle textStyle, final Function2 function2, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(1772272796);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(textStyle) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(function2) ? 32 : 16;
        }
        if ((i4 & 19) == 18 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(1772272796, i4, -1, "androidx.compose.material.ProvideTextStyle (Text.kt:396)");
            }
            ProvidableCompositionLocal providableCompositionLocal = f14984a;
            CompositionLocalKt.b(providableCompositionLocal.d(((TextStyle) composerK.q(providableCompositionLocal)).L(textStyle)), function2, composerK, (i4 & 112) | ProvidedValue.f24012i);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextKt$ProvideTextStyle$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i5) {
                    TextKt.a(textStyle, function2, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x029f  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x02a1  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x02a4  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x02a8  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x02b0  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x02b9  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x02bc  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x02bf  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x02c2  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x02c9  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x02cd  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x02cf  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x02d4  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x02d8  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x02df  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x02e3  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x02ee  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x02f1  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x02f5  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x02f9  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x02fe  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x0302  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x0305  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x030d  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x033b  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x0347  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x0382  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x03a3  */
    /* JADX WARN: Removed duplicated region for block: B:257:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0118  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ void b(final androidx.compose.ui.text.AnnotatedString r44, androidx.compose.ui.Modifier r45, long r46, long r48, androidx.compose.ui.text.font.FontStyle r50, androidx.compose.ui.text.font.FontWeight r51, androidx.compose.ui.text.font.FontFamily r52, long r53, androidx.compose.ui.text.style.TextDecoration r55, androidx.compose.ui.text.style.TextAlign r56, long r57, int r59, boolean r60, int r61, java.util.Map r62, kotlin.jvm.functions.Function1 r63, androidx.compose.ui.text.TextStyle r64, androidx.compose.runtime.Composer r65, final int r66, final int r67, final int r68) {
        /*
            Method dump skipped, instruction units count: 953
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextKt.b(androidx.compose.ui.text.AnnotatedString, androidx.compose.ui.Modifier, long, long, androidx.compose.ui.text.font.FontStyle, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontFamily, long, androidx.compose.ui.text.style.TextDecoration, androidx.compose.ui.text.style.TextAlign, long, int, boolean, int, java.util.Map, kotlin.jvm.functions.Function1, androidx.compose.ui.text.TextStyle, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x02a0  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x02a2  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x02a5  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x02a9  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x02b1  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x02ba  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x02bd  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x02c0  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x02c3  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x02ca  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x02ce  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x02d0  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x02d4  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x02d6  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x02da  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x02e1  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x02e5  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x02ec  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x02f2  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x02f6  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x02fa  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x02ff  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x0304  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x030a  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x0328  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x0334  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x035e  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x0360  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x038a  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x0391  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x03d3  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x041b  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x043e  */
    /* JADX WARN: Removed duplicated region for block: B:274:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0118  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void c(final java.lang.String r67, androidx.compose.ui.Modifier r68, long r69, long r71, androidx.compose.ui.text.font.FontStyle r73, androidx.compose.ui.text.font.FontWeight r74, androidx.compose.ui.text.font.FontFamily r75, long r76, androidx.compose.ui.text.style.TextDecoration r78, androidx.compose.ui.text.style.TextAlign r79, long r80, int r82, boolean r83, int r84, int r85, kotlin.jvm.functions.Function1 r86, androidx.compose.ui.text.TextStyle r87, androidx.compose.runtime.Composer r88, final int r89, final int r90, final int r91) {
        /*
            Method dump skipped, instruction units count: 1108
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextKt.c(java.lang.String, androidx.compose.ui.Modifier, long, long, androidx.compose.ui.text.font.FontStyle, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontFamily, long, androidx.compose.ui.text.style.TextDecoration, androidx.compose.ui.text.style.TextAlign, long, int, boolean, int, int, kotlin.jvm.functions.Function1, androidx.compose.ui.text.TextStyle, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0279  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x02b7  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x02b9  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x02bc  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x02c0  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x02c7  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x02cb  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x02d4  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x02d7  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x02da  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x02dd  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x02e4  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x02e8  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x02ef  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x02f3  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x02fa  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x02fe  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x0305  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x030a  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x030d  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0311  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x0316  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x031a  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x031f  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x0323  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x0326  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x032e  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x0350  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x036b  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x0395  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x0398  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x03c3  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x03ca  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x040c  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x045c  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x0482  */
    /* JADX WARN: Removed duplicated region for block: B:283:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x012c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void d(final androidx.compose.ui.text.AnnotatedString r60, androidx.compose.ui.Modifier r61, long r62, long r64, androidx.compose.ui.text.font.FontStyle r66, androidx.compose.ui.text.font.FontWeight r67, androidx.compose.ui.text.font.FontFamily r68, long r69, androidx.compose.ui.text.style.TextDecoration r71, androidx.compose.ui.text.style.TextAlign r72, long r73, int r75, boolean r76, int r77, int r78, java.util.Map r79, kotlin.jvm.functions.Function1 r80, androidx.compose.ui.text.TextStyle r81, androidx.compose.runtime.Composer r82, final int r83, final int r84, final int r85) {
        /*
            Method dump skipped, instruction units count: 1181
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextKt.d(androidx.compose.ui.text.AnnotatedString, androidx.compose.ui.Modifier, long, long, androidx.compose.ui.text.font.FontStyle, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontFamily, long, androidx.compose.ui.text.style.TextDecoration, androidx.compose.ui.text.style.TextAlign, long, int, boolean, int, int, java.util.Map, kotlin.jvm.functions.Function1, androidx.compose.ui.text.TextStyle, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x020f  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x027e  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x028f  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0298  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x029b  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x02a1  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x02a8  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x02ac  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x02ae  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x02b3  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x02b7  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x02be  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x02c2  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x02c9  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x02cd  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x02d0  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x02d4  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x02d8  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x02db  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x02e3  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x030d  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x0320  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x0356  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x0375  */
    /* JADX WARN: Removed duplicated region for block: B:243:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0118  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ void e(final java.lang.String r42, androidx.compose.ui.Modifier r43, long r44, long r46, androidx.compose.ui.text.font.FontStyle r48, androidx.compose.ui.text.font.FontWeight r49, androidx.compose.ui.text.font.FontFamily r50, long r51, androidx.compose.ui.text.style.TextDecoration r53, androidx.compose.ui.text.style.TextAlign r54, long r55, int r57, boolean r58, int r59, kotlin.jvm.functions.Function1 r60, androidx.compose.ui.text.TextStyle r61, androidx.compose.runtime.Composer r62, final int r63, final int r64, final int r65) {
        /*
            Method dump skipped, instruction units count: 907
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextKt.e(java.lang.String, androidx.compose.ui.Modifier, long, long, androidx.compose.ui.text.font.FontStyle, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontFamily, long, androidx.compose.ui.text.style.TextDecoration, androidx.compose.ui.text.style.TextAlign, long, int, boolean, int, kotlin.jvm.functions.Function1, androidx.compose.ui.text.TextStyle, androidx.compose.runtime.Composer, int, int, int):void");
    }

    public static final ProvidableCompositionLocal f() {
        return f14984a;
    }
}
