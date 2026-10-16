package androidx.compose.material3;

import androidx.compose.material3.tokens.SliderTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.geometry.CornerRadiusKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.RoundRect;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import kotlin.Metadata;

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
public final class SliderDefaults {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SliderDefaults f19885a = new SliderDefaults();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final float f19886b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final float f19887c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Path f19888d;

    static {
        SliderTokens sliderTokens = SliderTokens.f23396a;
        f19886b = sliderTokens.o();
        f19887c = sliderTokens.o();
        f19888d = AndroidPath_androidKt.a();
    }

    private SliderDefaults() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(DrawScope drawScope, long j3, float f3, long j4) {
        DrawScope.e2(drawScope, j4, drawScope.M1(f3) / 2.0f, j3, 0.0f, null, null, 0, 120, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:37:0x01c1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void l(androidx.compose.ui.graphics.drawscope.DrawScope r31, float[] r32, float r33, float r34, long r35, long r37, long r39, long r41, float r43, float r44, float r45, float r46, float r47, kotlin.jvm.functions.Function2 r48, kotlin.jvm.functions.Function3 r49, boolean r50) {
        /*
            Method dump skipped, instruction units count: 539
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SliderDefaults.l(androidx.compose.ui.graphics.drawscope.DrawScope, float[], float, float, long, long, long, long, float, float, float, float, float, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, boolean):void");
    }

    private final void m(DrawScope drawScope, long j3, long j4, long j5, float f3, float f4) {
        long jA = CornerRadiusKt.a(f3, f3);
        long jA2 = CornerRadiusKt.a(f4, f4);
        RoundRect roundRectC = RoundRectKt.c(RectKt.c(OffsetKt.a(Offset.m(j3), 0.0f), SizeKt.a(Size.i(j4), Size.g(j4))), jA, jA2, jA2, jA);
        Path path = f19888d;
        Path.s(path, roundRectC, null, 2, null);
        DrawScope.u0(drawScope, path, j5, 0.0f, null, null, 0, 60, null);
        path.r();
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:119:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x011b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(final androidx.compose.foundation.interaction.MutableInteractionSource r24, androidx.compose.ui.Modifier r25, androidx.compose.material3.SliderColors r26, boolean r27, long r28, androidx.compose.runtime.Composer r30, final int r31, final int r32) {
        /*
            Method dump skipped, instruction units count: 418
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SliderDefaults.a(androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.Modifier, androidx.compose.material3.SliderColors, boolean, long, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:92:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final /* synthetic */ void b(final androidx.compose.material3.RangeSliderState r15, androidx.compose.ui.Modifier r16, androidx.compose.material3.SliderColors r17, boolean r18, androidx.compose.runtime.Composer r19, final int r20, final int r21) {
        /*
            Method dump skipped, instruction units count: 306
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SliderDefaults.b(androidx.compose.material3.RangeSliderState, androidx.compose.ui.Modifier, androidx.compose.material3.SliderColors, boolean, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:103:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x015a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void c(final androidx.compose.material3.SliderPositions r18, androidx.compose.ui.Modifier r19, androidx.compose.material3.SliderColors r20, boolean r21, androidx.compose.runtime.Composer r22, final int r23, final int r24) {
        /*
            Method dump skipped, instruction units count: 376
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SliderDefaults.c(androidx.compose.material3.SliderPositions, androidx.compose.ui.Modifier, androidx.compose.material3.SliderColors, boolean, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:92:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final /* synthetic */ void d(final androidx.compose.material3.SliderState r15, androidx.compose.ui.Modifier r16, androidx.compose.material3.SliderColors r17, boolean r18, androidx.compose.runtime.Composer r19, final int r20, final int r21) {
        /*
            Method dump skipped, instruction units count: 306
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SliderDefaults.d(androidx.compose.material3.SliderState, androidx.compose.ui.Modifier, androidx.compose.material3.SliderColors, boolean, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0252  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0258 A[PHI: r2
      0x0258: PHI (r2v14 kotlin.jvm.functions.Function2) = (r2v11 kotlin.jvm.functions.Function2), (r2v15 kotlin.jvm.functions.Function2) binds: [B:171:0x0256, B:167:0x024f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:173:0x025a  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0263  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x026d  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x02aa  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x02bc  */
    /* JADX WARN: Removed duplicated region for block: B:193:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0112  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void e(final androidx.compose.material3.RangeSliderState r25, androidx.compose.ui.Modifier r26, boolean r27, androidx.compose.material3.SliderColors r28, kotlin.jvm.functions.Function2 r29, kotlin.jvm.functions.Function3 r30, float r31, float r32, androidx.compose.runtime.Composer r33, final int r34, final int r35) {
        /*
            Method dump skipped, instruction units count: 717
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SliderDefaults.e(androidx.compose.material3.RangeSliderState, androidx.compose.ui.Modifier, boolean, androidx.compose.material3.SliderColors, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, float, float, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0252  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0258 A[PHI: r2
      0x0258: PHI (r2v14 kotlin.jvm.functions.Function2) = (r2v11 kotlin.jvm.functions.Function2), (r2v15 kotlin.jvm.functions.Function2) binds: [B:171:0x0256, B:167:0x024f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:173:0x025a  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0263  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x026d  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x02aa  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x02bc  */
    /* JADX WARN: Removed duplicated region for block: B:193:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0112  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void f(final androidx.compose.material3.SliderState r25, androidx.compose.ui.Modifier r26, boolean r27, androidx.compose.material3.SliderColors r28, kotlin.jvm.functions.Function2 r29, kotlin.jvm.functions.Function3 r30, float r31, float r32, androidx.compose.runtime.Composer r33, final int r34, final int r35) {
        /*
            Method dump skipped, instruction units count: 717
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SliderDefaults.f(androidx.compose.material3.SliderState, androidx.compose.ui.Modifier, boolean, androidx.compose.material3.SliderColors, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, float, float, androidx.compose.runtime.Composer, int, int):void");
    }

    public final SliderColors i(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(1376295968, i3, -1, "androidx.compose.material3.SliderDefaults.colors (Slider.kt:845)");
        }
        SliderColors sliderColorsN = n(MaterialTheme.f18110a.a(composer, 6));
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return sliderColorsN;
    }

    public final SliderColors j(long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, Composer composer, int i3, int i4, int i5) {
        long j13;
        long j14;
        long jK = (i5 & 1) != 0 ? Color.f25715b.k() : j3;
        long jK2 = (i5 & 2) != 0 ? Color.f25715b.k() : j4;
        long jK3 = (i5 & 4) != 0 ? Color.f25715b.k() : j5;
        long jK4 = (i5 & 8) != 0 ? Color.f25715b.k() : j6;
        long jK5 = (i5 & 16) != 0 ? Color.f25715b.k() : j7;
        long jK6 = (i5 & 32) != 0 ? Color.f25715b.k() : j8;
        long jK7 = (i5 & 64) != 0 ? Color.f25715b.k() : j9;
        long jK8 = (i5 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? Color.f25715b.k() : j10;
        long j15 = jK;
        long jK9 = (i5 & Function.MAX_NARGS) != 0 ? Color.f25715b.k() : j11;
        long jK10 = (i5 & 512) != 0 ? Color.f25715b.k() : j12;
        if (ComposerKt.M()) {
            j13 = jK9;
            j14 = jK2;
            ComposerKt.U(885588574, i3, i4, "androidx.compose.material3.SliderDefaults.colors (Slider.kt:887)");
        } else {
            j13 = jK9;
            j14 = jK2;
        }
        SliderColors sliderColorsA = n(MaterialTheme.f18110a.a(composer, 6)).a(j15, j14, jK3, jK4, jK5, jK6, jK7, jK8, j13, jK10);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return sliderColorsA;
    }

    public final SliderColors n(ColorScheme colorScheme) {
        SliderColors sliderColorsK = colorScheme.K();
        if (sliderColorsK != null) {
            return sliderColorsK;
        }
        SliderTokens sliderTokens = SliderTokens.f23396a;
        SliderColors sliderColors = new SliderColors(ColorSchemeKt.g(colorScheme, sliderTokens.i()), ColorSchemeKt.g(colorScheme, sliderTokens.b()), ColorSchemeKt.g(colorScheme, sliderTokens.m()), ColorSchemeKt.g(colorScheme, sliderTokens.m()), ColorSchemeKt.g(colorScheme, sliderTokens.b()), ColorKt.h(Color.r(ColorSchemeKt.g(colorScheme, sliderTokens.e()), sliderTokens.f(), 0.0f, 0.0f, 0.0f, 14, null), colorScheme.o0()), Color.r(ColorSchemeKt.g(colorScheme, sliderTokens.c()), sliderTokens.d(), 0.0f, 0.0f, 0.0f, 14, null), Color.r(ColorSchemeKt.g(colorScheme, sliderTokens.g()), sliderTokens.h(), 0.0f, 0.0f, 0.0f, 14, null), Color.r(ColorSchemeKt.g(colorScheme, sliderTokens.g()), sliderTokens.h(), 0.0f, 0.0f, 0.0f, 14, null), Color.r(ColorSchemeKt.g(colorScheme, sliderTokens.c()), sliderTokens.d(), 0.0f, 0.0f, 0.0f, 14, null), null);
        colorScheme.i1(sliderColors);
        return sliderColors;
    }

    public final float o() {
        return f19887c;
    }

    public final float p() {
        return f19886b;
    }
}
